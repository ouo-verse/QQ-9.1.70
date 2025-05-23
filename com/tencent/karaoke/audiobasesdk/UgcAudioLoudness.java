package com.tencent.karaoke.audiobasesdk;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0001)B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086 J\t\u0010\f\u001a\u00020\u0004H\u0086 J\u001e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fJ&\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fJ\t\u0010\u0014\u001a\u00020\u000bH\u0086 J\t\u0010\u0015\u001a\u00020\u000fH\u0086 J\t\u0010\u0016\u001a\u00020\u000fH\u0086 J\t\u0010\u0017\u001a\u00020\u000fH\u0086 J\u0006\u0010\u0018\u001a\u00020\u000fJ\u0016\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bJ\u0019\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0086 J\u0016\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000bJ\u0019\u0010\u001f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086 J\u0019\u0010#\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0086 J!\u0010$\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0086 J\u0011\u0010%\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000fH\u0086 J\t\u0010&\u001a\u00020'H\u0086 J\u0006\u0010(\u001a\u00020'R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/UgcAudioLoudness;", "", "()V", "hasInit", "", "nativeHandle", "", "calcLoudness", "byteArray", "", "bufferLength", "", "clearLoudness", "configure", "ugcLoudness", "", "targetLoudness", "threshold", "minTargetLoudness", "maxTargetLoudness", "getLastError", "getLoudness", "getVolume", "getVolumeThreshold", "getVolumeValue", "init", "sampleRate", "channels", "onInit", "sample", WadlProxyConsts.CHANNEL, "process", "buffer", "Ljava/nio/ByteBuffer;", "size", "setVolume", "setVolumeInterval", "setVolumeThreshold", "unInit", "", "uninit", "Companion", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class UgcAudioLoudness {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean loaded = AudiobaseContext.loadLibrary();
    private boolean hasInit;
    private long nativeHandle;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/UgcAudioLoudness$Companion;", "", "()V", "loaded", "", "isLoaded", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public final boolean isLoaded() {
            return UgcAudioLoudness.loaded;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final native boolean calcLoudness(@NotNull byte[] byteArray, int bufferLength);

    public final native boolean clearLoudness();

    public final synchronized boolean configure(float ugcLoudness, float targetLoudness, float threshold) {
        if (!this.hasInit) {
            return false;
        }
        setVolumeThreshold(threshold);
        return setVolume(ugcLoudness, targetLoudness);
    }

    public final native int getLastError();

    public final native float getLoudness();

    public final native float getVolume();

    public final native float getVolumeThreshold();

    public final synchronized float getVolumeValue() {
        if (!this.hasInit) {
            return 0.0f;
        }
        return getVolume();
    }

    public final synchronized boolean init(int sampleRate, int channels) {
        boolean z16;
        if (INSTANCE.isLoaded()) {
            uninit();
            z16 = onInit(sampleRate, channels);
            this.hasInit = z16;
        } else {
            z16 = false;
        }
        return z16;
    }

    public final native boolean onInit(int sample, int channel);

    public final synchronized boolean process(@NotNull ByteBuffer buffer, int size) {
        Intrinsics.checkParameterIsNotNull(buffer, "buffer");
        if (!this.hasInit) {
            return false;
        }
        byte[] array = buffer.array();
        Intrinsics.checkExpressionValueIsNotNull(array, "buffer.array()");
        return process(array, size);
    }

    public final native boolean process(@NotNull byte[] byteArray, int bufferLength);

    public final native boolean setVolume(float ugcLoudness, float targetLoudness);

    public final native boolean setVolumeInterval(float ugcLoudness, float minTargetLoudness, float maxTargetLoudness);

    public final native boolean setVolumeThreshold(float threshold);

    public final native void unInit();

    public final synchronized void uninit() {
        if (this.hasInit) {
            unInit();
            this.hasInit = false;
        }
    }

    public final synchronized boolean configure(float ugcLoudness, float minTargetLoudness, float maxTargetLoudness, float threshold) {
        if (!this.hasInit) {
            return false;
        }
        setVolumeThreshold(threshold);
        return setVolumeInterval(ugcLoudness, minTargetLoudness, maxTargetLoudness);
    }
}
