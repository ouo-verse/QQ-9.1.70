package com.tencent.karaoke.audiobasesdk.mixer;

import com.tencent.karaoke.audiobasesdk.AudiobaseContext;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 F2\u00020\u0001:\u0001FB\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bJ\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bJ\u0011\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0082 J\u0013\u0010\u001a\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bH\u0082 J\t\u0010\u001b\u001a\u00020\bH\u0082 J\t\u0010\u001c\u001a\u00020\u0006H\u0082 J\t\u0010\u001d\u001a\u00020\bH\u0082 J\u0011\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\bH\u0082 J\u0011\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0082 J\u0013\u0010 \u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\bH\u0082 J\t\u0010!\u001a\u00020\bH\u0082 J\u0011\u0010\"\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0082 J\u0011\u0010#\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0082 J\u0011\u0010$\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0082 J\u0011\u0010%\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0082 J!\u0010&\u001a\u00020'2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u000b\u001a\u00020\bH\u0082 J2\u0010*\u001a\u00020'2\u0010\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010-\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010)2\u0006\u0010/\u001a\u00020-H\u0082 \u00a2\u0006\u0002\u00100J\t\u00101\u001a\u00020'H\u0082 J\u0019\u00102\u001a\u00020'2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00103\u001a\u00020\u0006H\u0082 J\u0019\u00104\u001a\u00020'2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u00105\u001a\u00020\u0006H\u0082 J)\u00106\u001a\u00020'2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\bH\u0082 J\u0019\u0010:\u001a\u00020'2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010;\u001a\u00020\bH\u0082 J\t\u0010<\u001a\u00020=H\u0082 J\u001e\u0010>\u001a\u00020'2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u000b\u001a\u00020\bJ/\u0010?\u001a\u00020'2\u0010\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010-\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010)2\u0006\u0010/\u001a\u00020-\u00a2\u0006\u0002\u00100J\u0006\u0010@\u001a\u00020'J\u0016\u0010A\u001a\u00020'2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00103\u001a\u00020\u0006J\u0016\u0010B\u001a\u00020'2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u00105\u001a\u00020\u0006J&\u0010C\u001a\u00020'2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\bJ\u0016\u0010D\u001a\u00020'2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010;\u001a\u00020\bJ\u0006\u0010E\u001a\u00020=R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006G"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/mixer/MultiChannelAudioMixer;", "", "()V", "nativeHandle", "", "getChannelFactor", "", "channelId", "", "getChannelFactors", "", "outputChannels", "getLastError", "getLatencyMs", "getOutputChannels", "getPreFactor", "trackId", "getTrackChannels", "getTrackFactors", "tracks", "getTracks", "getVolDef", "getVolMax", "getVolMin", "getVolume", "native_GetChannelFactor", "native_GetChannelFactors", "native_GetLastError", "native_GetLatencyMs", "native_GetOutputChannels", "native_GetPreFactor", "native_GetTrackChannels", "native_GetTrackFactors", "native_GetTracks", "native_GetVolDef", "native_GetVolMax", "native_GetVolMin", "native_GetVolume", "native_Init", "", "trackChannels", "", "native_Process", "trackBuffers", "", "", "trackBufLens", "outBuffer", "([[B[I[B)Z", "native_Reset", "native_SetChannelFactor", "channelFactor", "native_SetPreFactor", "perFactor", "native_SetVolMinMaxDef", "volMin", "volMax", "volDef", "native_SetVolume", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "native_Uninit", "", "onInit", "process", "reset", "setChannelFactor", "setPreFactor", "setVolMinMaxDef", "setVolume", "unInit", "Companion", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class MultiChannelAudioMixer {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean loaded = AudiobaseContext.loadLibrary();
    private long nativeHandle;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/mixer/MultiChannelAudioMixer$Companion;", "", "()V", "loaded", "", "isLoaded", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public final boolean isLoaded() {
            return MultiChannelAudioMixer.loaded;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final native float native_GetChannelFactor(int channelId);

    private final native float[] native_GetChannelFactors(int outputChannels);

    private final native int native_GetLastError();

    private final native float native_GetLatencyMs();

    private final native int native_GetOutputChannels();

    private final native float native_GetPreFactor(int trackId);

    private final native int native_GetTrackChannels(int trackId);

    private final native float[] native_GetTrackFactors(int tracks);

    private final native int native_GetTracks();

    private final native int native_GetVolDef(int trackId);

    private final native int native_GetVolMax(int trackId);

    private final native int native_GetVolMin(int trackId);

    private final native int native_GetVolume(int trackId);

    private final native boolean native_Init(int tracks, int[] trackChannels, int outputChannels);

    private final native boolean native_Process(byte[][] trackBuffers, int[] trackBufLens, byte[] outBuffer);

    private final native boolean native_Reset();

    private final native boolean native_SetChannelFactor(int channelId, float channelFactor);

    private final native boolean native_SetPreFactor(int trackId, float perFactor);

    private final native boolean native_SetVolMinMaxDef(int trackId, int volMin, int volMax, int volDef);

    private final native boolean native_SetVolume(int trackId, int volume);

    private final native void native_Uninit();

    public final synchronized float getChannelFactor(int channelId) {
        if (!INSTANCE.isLoaded()) {
            return -1.0f;
        }
        return native_GetChannelFactor(channelId);
    }

    @Nullable
    public final synchronized float[] getChannelFactors(int outputChannels) {
        if (!INSTANCE.isLoaded()) {
            return null;
        }
        return native_GetChannelFactors(outputChannels);
    }

    public final synchronized int getLastError() {
        if (!INSTANCE.isLoaded()) {
            return -1;
        }
        return native_GetLastError();
    }

    public final synchronized float getLatencyMs() {
        if (!INSTANCE.isLoaded()) {
            return -1.0f;
        }
        return native_GetLatencyMs();
    }

    public final synchronized int getOutputChannels() {
        if (!INSTANCE.isLoaded()) {
            return -1;
        }
        return native_GetOutputChannels();
    }

    public final synchronized float getPreFactor(int trackId) {
        if (!INSTANCE.isLoaded()) {
            return -1.0f;
        }
        return native_GetPreFactor(trackId);
    }

    public final synchronized int getTrackChannels(int trackId) {
        if (!INSTANCE.isLoaded()) {
            return -1;
        }
        return native_GetTrackChannels(trackId);
    }

    @Nullable
    public final synchronized float[] getTrackFactors(int tracks) {
        if (!INSTANCE.isLoaded()) {
            return null;
        }
        return native_GetTrackFactors(tracks);
    }

    public final synchronized int getTracks() {
        if (!INSTANCE.isLoaded()) {
            return -1;
        }
        return native_GetTracks();
    }

    public final synchronized int getVolDef(int trackId) {
        if (!INSTANCE.isLoaded()) {
            return -1;
        }
        return native_GetVolDef(trackId);
    }

    public final synchronized int getVolMax(int trackId) {
        if (!INSTANCE.isLoaded()) {
            return -1;
        }
        return native_GetVolMax(trackId);
    }

    public final synchronized int getVolMin(int trackId) {
        if (!INSTANCE.isLoaded()) {
            return -1;
        }
        return native_GetVolMin(trackId);
    }

    public final synchronized int getVolume(int trackId) {
        if (!INSTANCE.isLoaded()) {
            return -1;
        }
        return native_GetVolume(trackId);
    }

    public final synchronized boolean onInit(int tracks, @NotNull int[] trackChannels, int outputChannels) {
        Intrinsics.checkParameterIsNotNull(trackChannels, "trackChannels");
        if (!INSTANCE.isLoaded()) {
            return false;
        }
        return native_Init(tracks, trackChannels, outputChannels);
    }

    public final synchronized boolean process(@Nullable byte[][] trackBuffers, @Nullable int[] trackBufLens, @NotNull byte[] outBuffer) {
        Intrinsics.checkParameterIsNotNull(outBuffer, "outBuffer");
        if (!INSTANCE.isLoaded()) {
            return false;
        }
        return native_Process(trackBuffers, trackBufLens, outBuffer);
    }

    public final synchronized boolean reset() {
        if (!INSTANCE.isLoaded()) {
            return false;
        }
        return native_Reset();
    }

    public final synchronized boolean setChannelFactor(int channelId, float channelFactor) {
        if (!INSTANCE.isLoaded()) {
            return false;
        }
        return native_SetChannelFactor(channelId, channelFactor);
    }

    public final synchronized boolean setPreFactor(int trackId, float perFactor) {
        if (!INSTANCE.isLoaded()) {
            return false;
        }
        return native_SetPreFactor(trackId, perFactor);
    }

    public final synchronized boolean setVolMinMaxDef(int trackId, int volMin, int volMax, int volDef) {
        if (!INSTANCE.isLoaded()) {
            return false;
        }
        return native_SetVolMinMaxDef(trackId, volMin, volMax, volDef);
    }

    public final synchronized boolean setVolume(int trackId, int volume) {
        if (!INSTANCE.isLoaded()) {
            return false;
        }
        return native_SetVolume(trackId, volume);
    }

    public final synchronized void unInit() {
        if (!INSTANCE.isLoaded()) {
            return;
        }
        native_Uninit();
    }
}
