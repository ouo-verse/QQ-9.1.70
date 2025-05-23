package com.tencent.tavcut.core.render.audio.extractor;

import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.autotemplate.filter.TAVOneClickFilmStickerEffect;
import com.tencent.tavcut.core.render.log.TavLogger;
import com.tencent.videocut.utils.VideoUtils;
import com.tencent.videocut.utils.g;
import com.tencent.videocut.utils.thread.c;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bH\u0002J\u001e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0004J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0010H\u0002J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0010H\u0002J\b\u0010 \u001a\u00020\u0014H\u0002J\b\u0010!\u001a\u00020\u0014H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/tencent/tavcut/core/render/audio/extractor/AudioExtractor;", "Lcom/tencent/tavcut/core/render/audio/extractor/IAudioExtractor;", "()V", "audioExtractorListener", "Lcom/tencent/tavcut/core/render/audio/extractor/OnAudioExtractorListener;", "audioTotalDuration", "", "channelCount", "", "isRunning", "", "mediaExtractor", "Landroid/media/MediaExtractor;", "mediaMuxer", "Landroid/media/MediaMuxer;", "outputAudioPath", "", "sampleRate", TAVOneClickFilmStickerEffect.TRACK_INDEX, "cancelExtractAudio", "", "computeBufferSize", "createBufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "sampleSize", "extractAudioFromVideo", "inputVideoPath", "listener", "initMediaExtractor", "notifyExtractorError", "errCode", "errMsg", "release", "startExtractAudio", "Companion", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class AudioExtractor implements IAudioExtractor {
    private static final String AUDIO_MIME_PREFIX = "audio/";
    private static final int BIT_TO_BYTE = 8;
    private static final int BUFFER_SIZE = 8192;
    private static final float MAX_PROGRESS = 100.0f;
    private static final int SAMPLE_BIT = 16;
    private static final double SAMPLE_DURATION_S = 0.02d;
    private static final int STEREO_CHANNEL = 2;
    private static final String TAG = "AudioExtractor";
    private OnAudioExtractorListener audioExtractorListener;
    private long audioTotalDuration;
    private int channelCount;
    private boolean isRunning;
    private MediaExtractor mediaExtractor;
    private MediaMuxer mediaMuxer;
    private int sampleRate;
    private String outputAudioPath = "";
    private int trackIndex = -1;

    public static final /* synthetic */ MediaExtractor access$getMediaExtractor$p(AudioExtractor audioExtractor) {
        MediaExtractor mediaExtractor = audioExtractor.mediaExtractor;
        if (mediaExtractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
        }
        return mediaExtractor;
    }

    public static final /* synthetic */ MediaMuxer access$getMediaMuxer$p(AudioExtractor audioExtractor) {
        MediaMuxer mediaMuxer = audioExtractor.mediaMuxer;
        if (mediaMuxer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaMuxer");
        }
        return mediaMuxer;
    }

    private final int computeBufferSize() {
        int i3;
        if (this.channelCount == 2) {
            i3 = 12;
        } else {
            i3 = 16;
        }
        int i16 = (int) ((((this.sampleRate * 2) * 0.02d) * 16) / 8);
        if (AudioRecord.getMinBufferSize(this.sampleRate, i3, 2) >= i16) {
            return 8192;
        }
        return i16;
    }

    private final MediaCodec.BufferInfo createBufferInfo(int sampleSize) {
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        bufferInfo.offset = 0;
        bufferInfo.size = sampleSize;
        MediaExtractor mediaExtractor = this.mediaExtractor;
        if (mediaExtractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
        }
        bufferInfo.flags = mediaExtractor.getSampleFlags();
        MediaExtractor mediaExtractor2 = this.mediaExtractor;
        if (mediaExtractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
        }
        bufferInfo.presentationTimeUs = mediaExtractor2.getSampleTime();
        return bufferInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean initMediaExtractor(String inputVideoPath) {
        boolean startsWith$default;
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.mediaExtractor = mediaExtractor;
            mediaExtractor.setDataSource(inputVideoPath);
            this.mediaMuxer = new MediaMuxer(this.outputAudioPath, 0);
            MediaExtractor mediaExtractor2 = this.mediaExtractor;
            if (mediaExtractor2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
            }
            int trackCount = mediaExtractor2.getTrackCount();
            int i3 = 0;
            while (true) {
                boolean z16 = true;
                if (i3 < trackCount) {
                    MediaExtractor mediaExtractor3 = this.mediaExtractor;
                    if (mediaExtractor3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
                    }
                    MediaFormat trackFormat = mediaExtractor3.getTrackFormat(i3);
                    String mime = trackFormat.getString("mime");
                    Intrinsics.checkExpressionValueIsNotNull(mime, "mime");
                    if (mime.length() <= 0) {
                        z16 = false;
                    }
                    if (z16) {
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(mime, "audio/", false, 2, null);
                        if (startsWith$default) {
                            MediaMuxer mediaMuxer = this.mediaMuxer;
                            if (mediaMuxer == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mediaMuxer");
                            }
                            this.trackIndex = mediaMuxer.addTrack(trackFormat);
                            MediaExtractor mediaExtractor4 = this.mediaExtractor;
                            if (mediaExtractor4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
                            }
                            mediaExtractor4.selectTrack(i3);
                            this.sampleRate = trackFormat.getInteger("sample-rate");
                            this.channelCount = trackFormat.getInteger("channel-count");
                        }
                    }
                    i3++;
                } else {
                    this.audioTotalDuration = VideoUtils.f384231a.a(inputVideoPath);
                    return true;
                }
            }
        } catch (IOException e16) {
            TavLogger.e(TAG, "Fail to init MediaExtractor", e16);
            release();
            return false;
        } catch (IllegalArgumentException e17) {
            TavLogger.e(TAG, "Fail to init MediaExtractor", e17);
            release();
            return false;
        }
    }

    private final void notifyExtractorError(int errCode, String errMsg) {
        this.isRunning = false;
        OnAudioExtractorListener onAudioExtractorListener = this.audioExtractorListener;
        if (onAudioExtractorListener != null) {
            onAudioExtractorListener.onExtractError(errCode, errMsg);
        }
    }

    private final void release() {
        MediaMuxer mediaMuxer = this.mediaMuxer;
        if (mediaMuxer != null) {
            if (mediaMuxer == null) {
                try {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaMuxer");
                } catch (IllegalStateException e16) {
                    TavLogger.e(TAG, "MediaMuxer stop failed", e16);
                    String message = e16.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    notifyExtractorError(4, message);
                }
            }
            mediaMuxer.release();
        }
        MediaExtractor mediaExtractor = this.mediaExtractor;
        if (mediaExtractor != null) {
            if (mediaExtractor == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
            }
            mediaExtractor.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void startExtractAudio() {
        OnAudioExtractorListener onAudioExtractorListener;
        String str = "";
        OnAudioExtractorListener onAudioExtractorListener2 = this.audioExtractorListener;
        if (onAudioExtractorListener2 != null) {
            onAudioExtractorListener2.onExtractStart();
        }
        boolean z16 = false;
        try {
            try {
                ByteBuffer allocate = ByteBuffer.allocate(computeBufferSize());
                MediaMuxer mediaMuxer = this.mediaMuxer;
                if (mediaMuxer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaMuxer");
                }
                mediaMuxer.start();
                this.isRunning = true;
                while (this.isRunning) {
                    MediaExtractor mediaExtractor = this.mediaExtractor;
                    if (mediaExtractor == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
                    }
                    int readSampleData = mediaExtractor.readSampleData(allocate, 0);
                    float f16 = 100.0f;
                    if (readSampleData <= 0) {
                        MediaExtractor mediaExtractor2 = this.mediaExtractor;
                        if (mediaExtractor2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
                        }
                        mediaExtractor2.unselectTrack(this.trackIndex);
                        this.isRunning = false;
                    } else {
                        MediaCodec.BufferInfo createBufferInfo = createBufferInfo(readSampleData);
                        MediaMuxer mediaMuxer2 = this.mediaMuxer;
                        if (mediaMuxer2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mediaMuxer");
                        }
                        mediaMuxer2.writeSampleData(this.trackIndex, allocate, createBufferInfo);
                        MediaExtractor mediaExtractor3 = this.mediaExtractor;
                        if (mediaExtractor3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
                        }
                        mediaExtractor3.advance();
                        f16 = RangesKt___RangesKt.coerceAtMost(100.0f, (((float) createBufferInfo.presentationTimeUs) / ((float) this.audioTotalDuration)) * 100.0f);
                    }
                    OnAudioExtractorListener onAudioExtractorListener3 = this.audioExtractorListener;
                    if (onAudioExtractorListener3 != null) {
                        onAudioExtractorListener3.onExtracting((int) f16);
                    }
                }
                release();
                z16 = true;
            } catch (IllegalArgumentException e16) {
                TavLogger.e(TAG, "read sample data error", e16);
                String message = e16.getMessage();
                if (message != null) {
                    str = message;
                }
                notifyExtractorError(2, str);
                if (z16) {
                } else {
                    return;
                }
            } catch (IllegalStateException e17) {
                TavLogger.e(TAG, "read sample data error", e17);
                String message2 = e17.getMessage();
                if (message2 != null) {
                    str = message2;
                }
                notifyExtractorError(2, str);
                if (z16) {
                }
            }
            if (z16 && (onAudioExtractorListener = this.audioExtractorListener) != null) {
                onAudioExtractorListener.onExtractFinish(this.outputAudioPath);
            }
        } finally {
            release();
        }
    }

    @Override // com.tencent.tavcut.core.render.audio.extractor.IAudioExtractor
    public void cancelExtractAudio() {
        this.isRunning = false;
        this.audioExtractorListener = null;
    }

    public final void extractAudioFromVideo(@NotNull final String inputVideoPath, @NotNull String outputAudioPath, @NotNull OnAudioExtractorListener listener) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(inputVideoPath, "inputVideoPath");
        Intrinsics.checkParameterIsNotNull(outputAudioPath, "outputAudioPath");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.audioExtractorListener = listener;
        if (!g.f384239a.h(inputVideoPath)) {
            TavLogger.e(TAG, "Video don't exist");
            OnAudioExtractorListener onAudioExtractorListener = this.audioExtractorListener;
            if (onAudioExtractorListener != null) {
                onAudioExtractorListener.onExtractError(3, "Video don't exist");
                return;
            }
            return;
        }
        this.outputAudioPath = outputAudioPath;
        if (outputAudioPath.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            TavLogger.e(TAG, "Output audio path is invalid");
            OnAudioExtractorListener onAudioExtractorListener2 = this.audioExtractorListener;
            if (onAudioExtractorListener2 != null) {
                onAudioExtractorListener2.onExtractError(1, "Output audio path is invalid");
                return;
            }
            return;
        }
        c.f384289c.d(new Runnable() { // from class: com.tencent.tavcut.core.render.audio.extractor.AudioExtractor$extractAudioFromVideo$1
            @Override // java.lang.Runnable
            public final void run() {
                boolean initMediaExtractor;
                OnAudioExtractorListener onAudioExtractorListener3;
                initMediaExtractor = AudioExtractor.this.initMediaExtractor(inputVideoPath);
                if (initMediaExtractor) {
                    AudioExtractor.this.startExtractAudio();
                    return;
                }
                TavLogger.e("AudioExtractor", "Init mediaExtractor failed");
                onAudioExtractorListener3 = AudioExtractor.this.audioExtractorListener;
                if (onAudioExtractorListener3 != null) {
                    onAudioExtractorListener3.onExtractError(2, "Init mediaExtractor failed");
                }
            }
        });
    }
}
