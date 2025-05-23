package com.tencent.karaoke.audiobasesdk.segment;

import com.tencent.component.utils.LogUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.karaoke.audiobasesdk.AudiobaseContext;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0002\u001f B#\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u0013\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u00a2\u0006\u0002\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\u0016\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003J\u0006\u0010\u001e\u001a\u00020\u0018R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\tR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/segment/MediaSingSegment;", "", "sampleRate", "", WadlProxyConsts.CHANNEL, "qrcData", "", "(IILjava/lang/String;)V", "getChannel", "()I", "inited", "", "isFinished", "getQrcData", "()Ljava/lang/String;", "released", "getSampleRate", "segmentNative", "Lcom/tencent/karaoke/audiobasesdk/segment/MediaSingSegmentNative;", "fetchSingSegment", "", "Lcom/tencent/karaoke/audiobasesdk/segment/SingSegmentData;", "()[Lcom/tencent/karaoke/audiobasesdk/segment/SingSegmentData;", "finish", "", "init", "process", "pcmDataBuffer", "", "readSize", "release", "Builder", "Companion", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class MediaSingSegment {
    private static volatile boolean isSoLoaded;
    private final int channel;
    private volatile boolean inited;
    private volatile boolean isFinished;

    @Nullable
    private final String qrcData;
    private volatile boolean released;
    private final int sampleRate;
    private final MediaSingSegmentNative segmentNative;
    private static final String TAG = TAG;
    private static final String TAG = TAG;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/segment/MediaSingSegment$Builder;", "", "()V", WadlProxyConsts.CHANNEL, "", "getChannel", "()I", "setChannel", "(I)V", "qrcData", "", "getQrcData", "()Ljava/lang/String;", "setQrcData", "(Ljava/lang/String;)V", "sampleRate", "getSampleRate", "setSampleRate", "build", "Lcom/tencent/karaoke/audiobasesdk/segment/MediaSingSegment;", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public static final class Builder {

        @Nullable
        private String qrcData;
        private int channel = -1;
        private int sampleRate = -1;

        @Nullable
        public final MediaSingSegment build() {
            LogUtil.i(MediaSingSegment.TAG, " build channel (" + this.channel + "), sampleRate(" + this.sampleRate + ')');
            if (this.channel == -1 || this.sampleRate == -1) {
                LogUtil.e(MediaSingSegment.TAG, "must set channel (" + this.channel + ") and sampleRate(" + this.sampleRate + ')');
                throw new Throwable("must set channel (" + this.channel + ") and sampleRate(" + this.sampleRate + ')');
            }
            try {
                if (!MediaSingSegment.isSoLoaded) {
                    MediaSingSegment.isSoLoaded = AudiobaseContext.loadLibrary();
                    LogUtil.i(MediaSingSegment.TAG, "Builder load result : " + MediaSingSegment.isSoLoaded + TokenParser.SP);
                }
                DefaultConstructorMarker defaultConstructorMarker = null;
                if (!MediaSingSegment.isSoLoaded) {
                    return null;
                }
                return new MediaSingSegment(this.sampleRate, this.channel, this.qrcData, defaultConstructorMarker);
            } catch (Exception e16) {
                LogUtil.e(MediaSingSegment.TAG, "loadlibrary error: " + e16.getMessage());
                throw new Throwable("loadlibrary error error(" + e16.getMessage());
            }
        }

        public final int getChannel() {
            return this.channel;
        }

        @Nullable
        public final String getQrcData() {
            return this.qrcData;
        }

        public final int getSampleRate() {
            return this.sampleRate;
        }

        public final void setChannel(int i3) {
            this.channel = i3;
        }

        public final void setQrcData(@Nullable String str) {
            this.qrcData = str;
        }

        public final void setSampleRate(int i3) {
            this.sampleRate = i3;
        }
    }

    MediaSingSegment(int i3, int i16, String str) {
        this.sampleRate = i3;
        this.channel = i16;
        this.qrcData = str;
        this.segmentNative = new MediaSingSegmentNative();
    }

    @Nullable
    public final synchronized SingSegmentData[] fetchSingSegment() {
        if (!this.inited) {
            LogUtil.e(TAG, "fetchSingSegment inited:" + this.inited);
        }
        if (!this.isFinished) {
            LogUtil.e(TAG, "fetchSingSegment isFinished:" + this.isFinished);
        }
        return this.segmentNative.fetchSingSegmentList();
    }

    public final synchronized void finish() {
        if (this.isFinished) {
            return;
        }
        this.isFinished = true;
        this.inited = false;
        this.segmentNative.finish();
    }

    public final int getChannel() {
        return this.channel;
    }

    @Nullable
    public final String getQrcData() {
        return this.qrcData;
    }

    public final int getSampleRate() {
        return this.sampleRate;
    }

    public final synchronized void init() {
        if (this.inited) {
            return;
        }
        this.inited = this.segmentNative.init(this.sampleRate, this.channel);
        LogUtil.i(TAG, "init : " + this.inited);
    }

    public final synchronized boolean process(@NotNull byte[] pcmDataBuffer, int readSize) {
        Intrinsics.checkParameterIsNotNull(pcmDataBuffer, "pcmDataBuffer");
        if (!this.inited) {
            LogUtil.w(TAG, "inited == false");
            return false;
        }
        return this.segmentNative.process(pcmDataBuffer, readSize);
    }

    public final synchronized void release() {
        if (this.released) {
            return;
        }
        this.released = true;
        finish();
        this.segmentNative.uninit();
    }

    public /* synthetic */ MediaSingSegment(int i3, int i16, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, str);
    }

    /* synthetic */ MediaSingSegment(int i3, int i16, String str, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, (i17 & 4) != 0 ? null : str);
    }
}
