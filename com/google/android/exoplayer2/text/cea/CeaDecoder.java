package com.google.android.exoplayer2.text.cea;

import android.support.annotation.NonNull;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.util.LinkedList;
import java.util.PriorityQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class CeaDecoder implements SubtitleDecoder {
    private static final int NUM_INPUT_BUFFERS = 10;
    private static final int NUM_OUTPUT_BUFFERS = 2;
    private final LinkedList<CeaInputBuffer> availableInputBuffers = new LinkedList<>();
    private final LinkedList<SubtitleOutputBuffer> availableOutputBuffers;
    private CeaInputBuffer dequeuedInputBuffer;
    private long playbackPositionUs;
    private long queuedInputBufferCount;
    private final PriorityQueue<CeaInputBuffer> queuedInputBuffers;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class CeaInputBuffer extends SubtitleInputBuffer implements Comparable<CeaInputBuffer> {
        private long queuedInputBufferCount;

        CeaInputBuffer() {
        }

        @Override // java.lang.Comparable
        public int compareTo(@NonNull CeaInputBuffer ceaInputBuffer) {
            if (isEndOfStream() != ceaInputBuffer.isEndOfStream()) {
                return isEndOfStream() ? 1 : -1;
            }
            long j3 = this.timeUs - ceaInputBuffer.timeUs;
            if (j3 == 0) {
                j3 = this.queuedInputBufferCount - ceaInputBuffer.queuedInputBufferCount;
                if (j3 == 0) {
                    return 0;
                }
            }
            return j3 > 0 ? 1 : -1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private final class CeaOutputBuffer extends SubtitleOutputBuffer {
        CeaOutputBuffer() {
        }

        @Override // com.google.android.exoplayer2.text.SubtitleOutputBuffer, com.google.android.exoplayer2.decoder.OutputBuffer
        public final void release() {
            CeaDecoder.this.releaseOutputBuffer(this);
        }
    }

    public CeaDecoder() {
        int i3 = 0;
        while (true) {
            if (i3 >= 10) {
                break;
            }
            this.availableInputBuffers.add(new CeaInputBuffer());
            i3++;
        }
        this.availableOutputBuffers = new LinkedList<>();
        for (int i16 = 0; i16 < 2; i16++) {
            this.availableOutputBuffers.add(new CeaOutputBuffer());
        }
        this.queuedInputBuffers = new PriorityQueue<>();
    }

    private void releaseInputBuffer(CeaInputBuffer ceaInputBuffer) {
        ceaInputBuffer.clear();
        this.availableInputBuffers.add(ceaInputBuffer);
    }

    protected abstract Subtitle createSubtitle();

    protected abstract void decode(SubtitleInputBuffer subtitleInputBuffer);

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void flush() {
        this.queuedInputBufferCount = 0L;
        this.playbackPositionUs = 0L;
        while (!this.queuedInputBuffers.isEmpty()) {
            releaseInputBuffer(this.queuedInputBuffers.poll());
        }
        CeaInputBuffer ceaInputBuffer = this.dequeuedInputBuffer;
        if (ceaInputBuffer != null) {
            releaseInputBuffer(ceaInputBuffer);
            this.dequeuedInputBuffer = null;
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public abstract String getName();

    protected abstract boolean isNewSubtitleDataAvailable();

    protected void releaseOutputBuffer(SubtitleOutputBuffer subtitleOutputBuffer) {
        subtitleOutputBuffer.clear();
        this.availableOutputBuffers.add(subtitleOutputBuffer);
    }

    @Override // com.google.android.exoplayer2.text.SubtitleDecoder
    public void setPositionUs(long j3) {
        this.playbackPositionUs = j3;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    public SubtitleInputBuffer dequeueInputBuffer() throws SubtitleDecoderException {
        Assertions.checkState(this.dequeuedInputBuffer == null);
        if (this.availableInputBuffers.isEmpty()) {
            return null;
        }
        CeaInputBuffer pollFirst = this.availableInputBuffers.pollFirst();
        this.dequeuedInputBuffer = pollFirst;
        return pollFirst;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    public SubtitleOutputBuffer dequeueOutputBuffer() throws SubtitleDecoderException {
        if (this.availableOutputBuffers.isEmpty()) {
            return null;
        }
        while (!this.queuedInputBuffers.isEmpty() && this.queuedInputBuffers.peek().timeUs <= this.playbackPositionUs) {
            CeaInputBuffer poll = this.queuedInputBuffers.poll();
            if (poll.isEndOfStream()) {
                SubtitleOutputBuffer pollFirst = this.availableOutputBuffers.pollFirst();
                pollFirst.addFlag(4);
                releaseInputBuffer(poll);
                return pollFirst;
            }
            decode(poll);
            if (isNewSubtitleDataAvailable()) {
                Subtitle createSubtitle = createSubtitle();
                if (!poll.isDecodeOnly()) {
                    SubtitleOutputBuffer pollFirst2 = this.availableOutputBuffers.pollFirst();
                    pollFirst2.setContent(poll.timeUs, createSubtitle, Long.MAX_VALUE);
                    releaseInputBuffer(poll);
                    return pollFirst2;
                }
            }
            releaseInputBuffer(poll);
        }
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        Assertions.checkArgument(subtitleInputBuffer == this.dequeuedInputBuffer);
        if (subtitleInputBuffer.isDecodeOnly()) {
            releaseInputBuffer(this.dequeuedInputBuffer);
        } else {
            CeaInputBuffer ceaInputBuffer = this.dequeuedInputBuffer;
            long j3 = this.queuedInputBufferCount;
            this.queuedInputBufferCount = 1 + j3;
            ceaInputBuffer.queuedInputBufferCount = j3;
            this.queuedInputBuffers.add(this.dequeuedInputBuffer);
        }
        this.dequeuedInputBuffer = null;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void release() {
    }
}
