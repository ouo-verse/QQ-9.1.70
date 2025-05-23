package com.google.android.exoplayer2.text;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class TextRenderer extends BaseRenderer implements Handler.Callback {
    private static final int MSG_UPDATE_OUTPUT = 0;
    private static final int REPLACEMENT_STATE_NONE = 0;
    private static final int REPLACEMENT_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REPLACEMENT_STATE_WAIT_END_OF_STREAM = 2;
    private SubtitleDecoder decoder;
    private final SubtitleDecoderFactory decoderFactory;
    private int decoderReplacementState;
    private final FormatHolder formatHolder;
    private boolean inputStreamEnded;
    private SubtitleInputBuffer nextInputBuffer;
    private SubtitleOutputBuffer nextSubtitle;
    private int nextSubtitleEventIndex;
    private final TextOutput output;
    private final Handler outputHandler;
    private boolean outputStreamEnded;
    private Format streamFormat;
    private SubtitleOutputBuffer subtitle;

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes2.dex */
    public interface Output extends TextOutput {
    }

    public TextRenderer(TextOutput textOutput, Looper looper) {
        this(textOutput, looper, SubtitleDecoderFactory.DEFAULT);
    }

    private void clearOutput() {
        updateOutput(Collections.emptyList());
    }

    private long getNextEventTime() {
        int i3 = this.nextSubtitleEventIndex;
        if (i3 != -1 && i3 < this.subtitle.getEventTimeCount()) {
            return this.subtitle.getEventTime(this.nextSubtitleEventIndex);
        }
        return Long.MAX_VALUE;
    }

    private void invokeUpdateOutputInternal(List<Cue> list) {
        this.output.onCues(list);
    }

    private void releaseBuffers() {
        this.nextInputBuffer = null;
        this.nextSubtitleEventIndex = -1;
        SubtitleOutputBuffer subtitleOutputBuffer = this.subtitle;
        if (subtitleOutputBuffer != null) {
            subtitleOutputBuffer.release();
            this.subtitle = null;
        }
        SubtitleOutputBuffer subtitleOutputBuffer2 = this.nextSubtitle;
        if (subtitleOutputBuffer2 != null) {
            subtitleOutputBuffer2.release();
            this.nextSubtitle = null;
        }
    }

    private void releaseDecoder() {
        releaseBuffers();
        this.decoder.release();
        this.decoder = null;
        this.decoderReplacementState = 0;
    }

    private void replaceDecoder() {
        releaseDecoder();
        this.decoder = this.decoderFactory.createDecoder(this.streamFormat);
    }

    private void updateOutput(List<Cue> list) {
        Handler handler = this.outputHandler;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            invokeUpdateOutputInternal(list);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            invokeUpdateOutputInternal((List) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onDisabled() {
        this.streamFormat = null;
        clearOutput();
        releaseDecoder();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onPositionReset(long j3, boolean z16) {
        clearOutput();
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        if (this.decoderReplacementState != 0) {
            replaceDecoder();
        } else {
            releaseBuffers();
            this.decoder.flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] formatArr, long j3) throws ExoPlaybackException {
        Format format = formatArr[0];
        this.streamFormat = format;
        if (this.decoder != null) {
            this.decoderReplacementState = 1;
        } else {
            this.decoder = this.decoderFactory.createDecoder(format);
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j3, long j16) throws ExoPlaybackException {
        boolean z16;
        if (this.outputStreamEnded) {
            return;
        }
        if (this.nextSubtitle == null) {
            this.decoder.setPositionUs(j3);
            try {
                this.nextSubtitle = this.decoder.dequeueOutputBuffer();
            } catch (SubtitleDecoderException e16) {
                throw ExoPlaybackException.createForRenderer(e16, getIndex());
            }
        }
        if (getState() != 2) {
            return;
        }
        if (this.subtitle != null) {
            long nextEventTime = getNextEventTime();
            z16 = false;
            while (nextEventTime <= j3) {
                this.nextSubtitleEventIndex++;
                nextEventTime = getNextEventTime();
                z16 = true;
            }
        } else {
            z16 = false;
        }
        SubtitleOutputBuffer subtitleOutputBuffer = this.nextSubtitle;
        if (subtitleOutputBuffer != null) {
            if (subtitleOutputBuffer.isEndOfStream()) {
                if (!z16 && getNextEventTime() == Long.MAX_VALUE) {
                    if (this.decoderReplacementState == 2) {
                        replaceDecoder();
                    } else {
                        releaseBuffers();
                        this.outputStreamEnded = true;
                    }
                }
            } else if (this.nextSubtitle.timeUs <= j3) {
                SubtitleOutputBuffer subtitleOutputBuffer2 = this.subtitle;
                if (subtitleOutputBuffer2 != null) {
                    subtitleOutputBuffer2.release();
                }
                SubtitleOutputBuffer subtitleOutputBuffer3 = this.nextSubtitle;
                this.subtitle = subtitleOutputBuffer3;
                this.nextSubtitle = null;
                this.nextSubtitleEventIndex = subtitleOutputBuffer3.getNextEventTimeIndex(j3);
                z16 = true;
            }
        }
        if (z16) {
            updateOutput(this.subtitle.getCues(j3));
        }
        if (this.decoderReplacementState == 2) {
            return;
        }
        while (!this.inputStreamEnded) {
            try {
                if (this.nextInputBuffer == null) {
                    SubtitleInputBuffer dequeueInputBuffer = this.decoder.dequeueInputBuffer();
                    this.nextInputBuffer = dequeueInputBuffer;
                    if (dequeueInputBuffer == null) {
                        return;
                    }
                }
                if (this.decoderReplacementState == 1) {
                    this.nextInputBuffer.setFlags(4);
                    this.decoder.queueInputBuffer(this.nextInputBuffer);
                    this.nextInputBuffer = null;
                    this.decoderReplacementState = 2;
                    return;
                }
                int readSource = readSource(this.formatHolder, this.nextInputBuffer, false);
                if (readSource == -4) {
                    if (this.nextInputBuffer.isEndOfStream()) {
                        this.inputStreamEnded = true;
                    } else {
                        SubtitleInputBuffer subtitleInputBuffer = this.nextInputBuffer;
                        subtitleInputBuffer.subsampleOffsetUs = this.formatHolder.format.subsampleOffsetUs;
                        subtitleInputBuffer.flip();
                    }
                    this.decoder.queueInputBuffer(this.nextInputBuffer);
                    this.nextInputBuffer = null;
                } else if (readSource == -3) {
                    return;
                }
            } catch (SubtitleDecoderException e17) {
                throw ExoPlaybackException.createForRenderer(e17, getIndex());
            }
        }
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(Format format) {
        if (this.decoderFactory.supportsFormat(format)) {
            if (BaseRenderer.supportsFormatDrm(null, format.drmInitData)) {
                return 4;
            }
            return 2;
        }
        if (MimeTypes.isText(format.sampleMimeType)) {
            return 1;
        }
        return 0;
    }

    public TextRenderer(TextOutput textOutput, Looper looper, SubtitleDecoderFactory subtitleDecoderFactory) {
        super(3);
        this.output = (TextOutput) Assertions.checkNotNull(textOutput);
        this.outputHandler = looper == null ? null : new Handler(looper, this);
        this.decoderFactory = subtitleDecoderFactory;
        this.formatHolder = new FormatHolder();
    }
}
