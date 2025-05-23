package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class MetadataRenderer extends BaseRenderer implements Handler.Callback {
    private static final int MAX_PENDING_METADATA_COUNT = 5;
    private static final int MSG_INVOKE_RENDERER = 0;
    private final MetadataInputBuffer buffer;
    private MetadataDecoder decoder;
    private final MetadataDecoderFactory decoderFactory;
    private final FormatHolder formatHolder;
    private boolean inputStreamEnded;
    private final MetadataOutput output;
    private final Handler outputHandler;
    private final Metadata[] pendingMetadata;
    private int pendingMetadataCount;
    private int pendingMetadataIndex;
    private final long[] pendingMetadataTimestamps;

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes2.dex */
    public interface Output extends MetadataOutput {
    }

    public MetadataRenderer(MetadataOutput metadataOutput, Looper looper) {
        this(metadataOutput, looper, MetadataDecoderFactory.DEFAULT);
    }

    private void flushPendingMetadata() {
        Arrays.fill(this.pendingMetadata, (Object) null);
        this.pendingMetadataIndex = 0;
        this.pendingMetadataCount = 0;
    }

    private void invokeRenderer(Metadata metadata) {
        Handler handler = this.outputHandler;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            invokeRendererInternal(metadata);
        }
    }

    private void invokeRendererInternal(Metadata metadata) {
        this.output.onMetadata(metadata);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            invokeRendererInternal((Metadata) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.inputStreamEnded;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onDisabled() {
        flushPendingMetadata();
        this.decoder = null;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onPositionReset(long j3, boolean z16) {
        flushPendingMetadata();
        this.inputStreamEnded = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] formatArr, long j3) throws ExoPlaybackException {
        this.decoder = this.decoderFactory.createDecoder(formatArr[0]);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j3, long j16) throws ExoPlaybackException {
        if (!this.inputStreamEnded && this.pendingMetadataCount < 5) {
            this.buffer.clear();
            if (readSource(this.formatHolder, this.buffer, false) == -4) {
                if (this.buffer.isEndOfStream()) {
                    this.inputStreamEnded = true;
                } else if (!this.buffer.isDecodeOnly()) {
                    MetadataInputBuffer metadataInputBuffer = this.buffer;
                    metadataInputBuffer.subsampleOffsetUs = this.formatHolder.format.subsampleOffsetUs;
                    metadataInputBuffer.flip();
                    try {
                        int i3 = (this.pendingMetadataIndex + this.pendingMetadataCount) % 5;
                        this.pendingMetadata[i3] = this.decoder.decode(this.buffer);
                        this.pendingMetadataTimestamps[i3] = this.buffer.timeUs;
                        this.pendingMetadataCount++;
                    } catch (MetadataDecoderException e16) {
                        throw ExoPlaybackException.createForRenderer(e16, getIndex());
                    }
                }
            }
        }
        if (this.pendingMetadataCount > 0) {
            long[] jArr = this.pendingMetadataTimestamps;
            int i16 = this.pendingMetadataIndex;
            if (jArr[i16] <= j3) {
                invokeRenderer(this.pendingMetadata[i16]);
                Metadata[] metadataArr = this.pendingMetadata;
                int i17 = this.pendingMetadataIndex;
                metadataArr[i17] = null;
                this.pendingMetadataIndex = (i17 + 1) % 5;
                this.pendingMetadataCount--;
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
        return 0;
    }

    public MetadataRenderer(MetadataOutput metadataOutput, Looper looper, MetadataDecoderFactory metadataDecoderFactory) {
        super(4);
        this.output = (MetadataOutput) Assertions.checkNotNull(metadataOutput);
        this.outputHandler = looper == null ? null : new Handler(looper, this);
        this.decoderFactory = (MetadataDecoderFactory) Assertions.checkNotNull(metadataDecoderFactory);
        this.formatHolder = new FormatHolder();
        this.buffer = new MetadataInputBuffer();
        this.pendingMetadata = new Metadata[5];
        this.pendingMetadataTimestamps = new long[5];
    }
}
