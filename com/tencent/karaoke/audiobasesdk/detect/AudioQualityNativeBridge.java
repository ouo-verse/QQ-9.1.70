package com.tencent.karaoke.audiobasesdk.detect;

import com.tencent.karaoke.audiobasesdk.AudiobaseContext;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001b\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0086 J\t\u0010\u000b\u001a\u00020\u0006H\u0086 J\u0019\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0086 J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0086 J\t\u0010\u0012\u001a\u00020\u0010H\u0086 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/detect/AudioQualityNativeBridge;", "", "()V", "nativeHandle", "", "clippingDetect", "", "pBuf", "", "nFLenByte", "", "getEnabled", "initClipDetector", "nChannels", "nSampleRate", "setEnabled", "", NodeProps.ENABLED, "unInitClipDetector", "Companion", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class AudioQualityNativeBridge {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean loaded = AudiobaseContext.loadLibrary();
    private long nativeHandle;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/detect/AudioQualityNativeBridge$Companion;", "", "()V", "loaded", "", "isLoaded", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public final boolean isLoaded() {
            return AudioQualityNativeBridge.loaded;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final native boolean clippingDetect(@Nullable byte[] pBuf, int nFLenByte);

    public final native boolean getEnabled();

    public final native boolean initClipDetector(int nChannels, int nSampleRate);

    public final native void setEnabled(boolean enabled);

    public final native void unInitClipDetector();
}
