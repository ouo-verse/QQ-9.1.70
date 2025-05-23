package com.tencent.liteav.live;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.i;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.beauty.TXBeautyManagerImpl;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.liteav.device.TXDeviceManagerImpl;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.V2TXLivePusher;
import com.tencent.live2.V2TXLivePusherObserver;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.live2.impl.a.b;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLContext;
import org.json.JSONArray;
import org.json.JSONObject;

@JNINamespace("liteav")
/* loaded from: classes7.dex */
public class V2TXLivePusherJni extends V2TXLivePusher {
    private static final String TAG = "V2TXLivePusherJni";
    private TXAudioEffectManager mAudioEffectManager;
    private TXBeautyManagerImpl mBeautyManager;
    private TXDeviceManager mDeviceManager;
    private long mNativeV2TXLivePusherJni;
    private V2TXLivePusherObserver mObserver;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.liteav.live.V2TXLivePusherJni$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f119065a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f119066b;

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f119067c;

        /* renamed from: d, reason: collision with root package name */
        static final /* synthetic */ int[] f119068d;

        /* renamed from: e, reason: collision with root package name */
        static final /* synthetic */ int[] f119069e;

        /* renamed from: f, reason: collision with root package name */
        static final /* synthetic */ int[] f119070f;

        static {
            int[] iArr = new int[GLConstants.a.values().length];
            f119070f = iArr;
            try {
                iArr[GLConstants.a.TEXTURE_2D.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f119070f[GLConstants.a.BYTE_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f119070f[GLConstants.a.BYTE_BUFFER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[GLConstants.PixelFormatType.values().length];
            f119069e = iArr2;
            try {
                iArr2[GLConstants.PixelFormatType.I420.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f119069e[GLConstants.PixelFormatType.RGBA.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[V2TXLiveDef.V2TXLiveBufferType.values().length];
            f119068d = iArr3;
            try {
                iArr3[V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f119068d[V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteArray.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f119068d[V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteBuffer.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr4 = new int[V2TXLiveDef.V2TXLivePixelFormat.values().length];
            f119067c = iArr4;
            try {
                iArr4[V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f119067c[V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr5 = new int[V2TXLiveDef.V2TXLiveFillMode.values().length];
            f119066b = iArr5;
            try {
                iArr5[V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeFill.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f119066b[V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeFit.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f119066b[V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeScaleFill.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            int[] iArr6 = new int[V2TXLiveDef.V2TXLiveRotation.values().length];
            f119065a = iArr6;
            try {
                iArr6[V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation90.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f119065a[V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation180.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f119065a[V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation270.ordinal()] = 3;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    public V2TXLivePusherJni(Context context, int i3) {
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
        long nativeCreate = nativeCreate(new WeakReference(this), i3);
        this.mNativeV2TXLivePusherJni = nativeCreate;
        this.mAudioEffectManager = new TXAudioEffectManagerImpl(nativeCreateAudioEffectManager(nativeCreate));
        this.mBeautyManager = new TXBeautyManagerImpl(nativeCreateBeautyManager(this.mNativeV2TXLivePusherJni));
        this.mDeviceManager = new TXDeviceManagerImpl(nativeCreateDeviceManager(this.mNativeV2TXLivePusherJni));
        if (context instanceof Activity) {
            i.a().a((Activity) context);
        }
    }

    private static Object getEglContextFromLiveVideoFrame(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        V2TXLiveDef.V2TXLiveTexture v2TXLiveTexture = v2TXLiveVideoFrame.texture;
        Object obj = v2TXLiveTexture.eglContext10;
        if (obj == null) {
            obj = null;
        }
        Object obj2 = v2TXLiveTexture.eglContext14;
        if (obj2 != null) {
            obj = obj2;
        }
        if (obj == null) {
            return EGL14.eglGetCurrentContext();
        }
        return obj;
    }

    private static native long nativeCreate(WeakReference<V2TXLivePusherJni> weakReference, int i3);

    private static native long nativeCreateAudioEffectManager(long j3);

    private static native long nativeCreateBeautyManager(long j3);

    private static native long nativeCreateDeviceManager(long j3);

    private static native void nativeDestroy(long j3);

    private static native int nativeEnableAudioProcessObserver(long j3, boolean z16, int i3, int i16, int i17, int i18);

    private static native int nativeEnableCustomAudioCapture(long j3, boolean z16);

    private static native int nativeEnableCustomVideoCapture(long j3, boolean z16);

    private static native int nativeEnableCustomVideoProcess(long j3, boolean z16, int i3, int i16);

    private static native void nativeEnableExtensionCallback(long j3, boolean z16);

    private static native void nativeEnableVoiceActivityDetection(long j3, boolean z16);

    private static native int nativeEnableVolumeEvaluation(long j3, int i3);

    private static native int nativeIsPushing(long j3);

    private static native int nativePauseAudio(long j3);

    private static native int nativePauseVideo(long j3);

    private static native int nativeResumeAudio(long j3);

    private static native int nativeResumeVideo(long j3);

    private static native int nativeSendCustomAudioFrame(long j3, byte[] bArr, int i3, int i16, long j16);

    private static native int nativeSendCustomVideoFrame(long j3, int i3, int i16, int i17, int i18, int i19, int i26, Object obj, byte[] bArr, ByteBuffer byteBuffer);

    private static native int nativeSendSeiMessage(long j3, int i3, byte[] bArr);

    private static native int nativeSetAudioQuality(long j3, int i3);

    private static native int nativeSetEncoderMirror(long j3, boolean z16);

    private static native int nativeSetMixTranscodingConfig(long j3, String str);

    private static native int nativeSetProperty(long j3, String str, Object obj);

    private static native int nativeSetRenderFillMode(long j3, int i3);

    private static native int nativeSetRenderMirror(long j3, int i3);

    private static native int nativeSetRenderRotation(long j3, int i3);

    private static native int nativeSetRenderView(long j3, DisplayTarget displayTarget);

    private static native int nativeSetVideoQuality(long j3, int i3, int i16, int i17, int i18, int i19);

    private static native int nativeSetWatermark(long j3, Bitmap bitmap, float f16, float f17, float f18);

    private static native void nativeShowDebugView(long j3, boolean z16);

    private static native int nativeSnapshot(long j3);

    private static native int nativeStartCamera(long j3, boolean z16);

    private static native int nativeStartMicrophone(long j3);

    private static native int nativeStartPush(long j3, String str);

    private static native int nativeStartRecord(long j3, String str, int i3, int i16);

    private static native int nativeStartScreenCapture(long j3);

    private static native int nativeStartSystemAudioLoopback(long j3);

    private static native int nativeStartVirtualCamera(long j3, Bitmap bitmap);

    private static native int nativeStopCamera(long j3);

    private static native int nativeStopMicrophone(long j3);

    private static native int nativeStopPush(long j3);

    private static native void nativeStopRecord(long j3);

    private static native int nativeStopScreenCapture(long j3);

    private static native int nativeStopSystemAudioLoopback(long j3);

    private static native int nativeStopVirtualCamera(long j3);

    public static V2TXLivePusherJni weakToStrongReference(WeakReference<V2TXLivePusherJni> weakReference) {
        return weakReference.get();
    }

    public V2TXLiveDef.V2TXLiveVideoFrame createV2TXLiveVideoFrame(int i3, int i16, int i17, int i18, int i19, int i26, Object obj, byte[] bArr, ByteBuffer byteBuffer) {
        V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame = new V2TXLiveDef.V2TXLiveVideoFrame();
        int i27 = AnonymousClass1.f119069e[GLConstants.PixelFormatType.a(i18).ordinal()];
        if (i27 != 1) {
            if (i27 != 2) {
                return null;
            }
            v2TXLiveVideoFrame.pixelFormat = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D;
        } else {
            v2TXLiveVideoFrame.pixelFormat = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420;
        }
        int i28 = AnonymousClass1.f119070f[GLConstants.a.a(i17).ordinal()];
        if (i28 != 1) {
            if (i28 != 2) {
                if (i28 != 3) {
                    return null;
                }
                v2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteBuffer;
                v2TXLiveVideoFrame.buffer = byteBuffer;
            } else {
                v2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteArray;
                v2TXLiveVideoFrame.data = bArr;
            }
        } else {
            v2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture;
            V2TXLiveDef.V2TXLiveTexture v2TXLiveTexture = new V2TXLiveDef.V2TXLiveTexture();
            v2TXLiveVideoFrame.texture = v2TXLiveTexture;
            v2TXLiveTexture.textureId = i26;
            if (obj instanceof EGLContext) {
                v2TXLiveTexture.eglContext10 = (EGLContext) obj;
            } else if (obj instanceof android.opengl.EGLContext) {
                v2TXLiveTexture.eglContext14 = (android.opengl.EGLContext) obj;
            }
        }
        v2TXLiveVideoFrame.width = i3;
        v2TXLiveVideoFrame.height = i16;
        v2TXLiveVideoFrame.rotation = i19;
        return v2TXLiveVideoFrame;
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int enableAudioProcessObserver(boolean z16, V2TXLiveDef.V2TXLiveAudioFrameObserverFormat v2TXLiveAudioFrameObserverFormat) {
        if (v2TXLiveAudioFrameObserverFormat == null) {
            return -2;
        }
        return nativeEnableAudioProcessObserver(this.mNativeV2TXLivePusherJni, z16, v2TXLiveAudioFrameObserverFormat.sampleRate, v2TXLiveAudioFrameObserverFormat.channel, v2TXLiveAudioFrameObserverFormat.samplesPerCall, v2TXLiveAudioFrameObserverFormat.mode.ordinal());
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int enableCustomAudioCapture(boolean z16) {
        return nativeEnableCustomAudioCapture(this.mNativeV2TXLivePusherJni, z16);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int enableCustomVideoCapture(boolean z16) {
        return nativeEnableCustomVideoCapture(this.mNativeV2TXLivePusherJni, z16);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int enableCustomVideoProcess(boolean z16, V2TXLiveDef.V2TXLivePixelFormat v2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType v2TXLiveBufferType) {
        if (z16) {
            boolean z17 = true;
            if ((v2TXLiveBufferType != V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteBuffer || v2TXLivePixelFormat != V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420) && (v2TXLiveBufferType != V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture || v2TXLivePixelFormat != V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D)) {
                z17 = false;
            }
            if (z17) {
                return nativeEnableCustomVideoProcess(this.mNativeV2TXLivePusherJni, z16, v2TXLivePixelFormat.ordinal(), v2TXLiveBufferType.ordinal());
            }
            return -4;
        }
        return nativeEnableCustomVideoProcess(this.mNativeV2TXLivePusherJni, z16, v2TXLivePixelFormat.ordinal(), v2TXLiveBufferType.ordinal());
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public void enableVoiceActivityDetection(boolean z16) {
        nativeEnableVoiceActivityDetection(this.mNativeV2TXLivePusherJni, z16);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int enableVolumeEvaluation(int i3) {
        return nativeEnableVolumeEvaluation(this.mNativeV2TXLivePusherJni, i3);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        release();
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public TXAudioEffectManager getAudioEffectManager() {
        return this.mAudioEffectManager;
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public TXBeautyManager getBeautyManager() {
        return this.mBeautyManager;
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public TXDeviceManager getDeviceManager() {
        return this.mDeviceManager;
    }

    public int getFrameBufferType(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        GLConstants.a aVar = GLConstants.a.BYTE_BUFFER;
        int i3 = AnonymousClass1.f119068d[v2TXLiveVideoFrame.bufferType.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                aVar = GLConstants.a.BYTE_ARRAY;
            }
        } else {
            aVar = GLConstants.a.TEXTURE_2D;
        }
        return aVar.mValue;
    }

    public byte[] getFrameByteArray(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        return v2TXLiveVideoFrame.data;
    }

    public ByteBuffer getFrameByteBuffer(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        return v2TXLiveVideoFrame.buffer;
    }

    public Object getFrameEglContext(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        V2TXLiveDef.V2TXLiveTexture v2TXLiveTexture;
        EGLContext eGLContext = null;
        if (v2TXLiveVideoFrame == null || (v2TXLiveTexture = v2TXLiveVideoFrame.texture) == null) {
            return null;
        }
        EGLContext eGLContext2 = v2TXLiveTexture.eglContext10;
        if (eGLContext2 != null) {
            eGLContext = eGLContext2;
        }
        android.opengl.EGLContext eGLContext3 = v2TXLiveTexture.eglContext14;
        if (eGLContext3 != null) {
            return eGLContext3;
        }
        return eGLContext;
    }

    public int getFrameHeight(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        return v2TXLiveVideoFrame.height;
    }

    public int getFramePixelFormat(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        GLConstants.PixelFormatType pixelFormatType = GLConstants.PixelFormatType.I420;
        int i3 = AnonymousClass1.f119067c[v2TXLiveVideoFrame.pixelFormat.ordinal()];
        if (i3 != 1 && i3 == 2) {
            pixelFormatType = GLConstants.PixelFormatType.RGBA;
        }
        return pixelFormatType.getValue();
    }

    public int getFrameRotation(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        return v2TXLiveVideoFrame.rotation;
    }

    public int getFrameTextureId(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        V2TXLiveDef.V2TXLiveTexture v2TXLiveTexture;
        if (v2TXLiveVideoFrame != null && (v2TXLiveTexture = v2TXLiveVideoFrame.texture) != null) {
            return v2TXLiveTexture.textureId;
        }
        return -1;
    }

    public int getFrameWidth(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        return v2TXLiveVideoFrame.width;
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int isPushing() {
        return nativeIsPushing(this.mNativeV2TXLivePusherJni);
    }

    public void onCaptureFirstAudioFrame() {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onCaptureFirstAudioFrame();
        }
    }

    public void onCaptureFirstVideoFrame() {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onCaptureFirstVideoFrame();
        }
    }

    public int onCustomPreprocessFrame(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame, V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame2) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            return v2TXLivePusherObserver.onProcessVideoFrame(v2TXLiveVideoFrame, v2TXLiveVideoFrame2);
        }
        return -1;
    }

    public void onEnterRoom(int i3, String str) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null && (v2TXLivePusherObserver instanceof b)) {
            ((b) v2TXLivePusherObserver).onEnterRoom(i3);
        }
    }

    public void onError(int i3, String str, Bundle bundle) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onError(i3, str, bundle);
        }
    }

    public void onExitRoom(int i3, String str) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null && (v2TXLivePusherObserver instanceof b)) {
            ((b) v2TXLivePusherObserver).onExitRoom(i3);
        }
    }

    public void onGLContextCreated() {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onGLContextCreated();
        }
    }

    public void onGLContextDestroyed() {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onGLContextDestroyed();
        }
    }

    public void onMicrophoneVolumeUpdate(int i3) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onMicrophoneVolumeUpdate(i3);
        }
    }

    public void onNetworkQuality(int i3) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null && (v2TXLivePusherObserver instanceof b)) {
            ((b) v2TXLivePusherObserver).onNetworkQuality(i3);
        }
    }

    public void onProcessAudioFrame(byte[] bArr, long j3, int i3, int i16) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver == null) {
            return;
        }
        V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame = new V2TXLiveDef.V2TXLiveAudioFrame();
        v2TXLiveAudioFrame.data = bArr;
        v2TXLiveAudioFrame.sampleRate = i3;
        v2TXLiveAudioFrame.channel = i16;
        v2TXLiveAudioFrame.timestamp = j3;
        v2TXLivePusherObserver.onProcessAudioFrame(v2TXLiveAudioFrame);
    }

    public void onPushEvent(int i3, Bundle bundle) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null && (v2TXLivePusherObserver instanceof b)) {
            ((b) v2TXLivePusherObserver).onPushEvent(i3, bundle);
        }
    }

    public void onPushNetStatus(Bundle bundle) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null && (v2TXLivePusherObserver instanceof b)) {
            ((b) v2TXLivePusherObserver).onPushNetStatus(bundle);
        }
    }

    public void onPushStatusUpdate(int i3, String str, Bundle bundle) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        V2TXLiveDef.V2TXLivePushStatus v2TXLivePushStatus = V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusDisconnected;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        str = "disconnected from the server.";
                    }
                } else {
                    v2TXLivePushStatus = V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusReconnecting;
                    str = "reconnecting to the server.";
                }
            } else {
                v2TXLivePushStatus = V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusConnectSuccess;
                str = "connected to the server successfully.";
            }
        } else {
            v2TXLivePushStatus = V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusConnecting;
            str = "connecting to the server.";
        }
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onPushStatusUpdate(v2TXLivePushStatus, str, bundle);
        }
    }

    public void onRecordBegin(int i3, String str) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onLocalRecordBegin(i3, str);
        }
    }

    public void onRecordComplete(int i3, String str) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onLocalRecordComplete(i3, str);
        }
    }

    public void onRecordProgress(long j3, String str) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onLocalRecording(j3, str);
        }
    }

    public void onScreenCaptureStarted() {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onScreenCaptureStarted();
        }
    }

    public void onScreenCaptureStoped(int i3) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onScreenCaptureStopped(i3);
        }
    }

    public void onSetMixTranscodingConfig(int i3, String str) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onSetMixTranscodingConfig(i3, str);
        }
    }

    public void onSnapshotComplete(Bitmap bitmap) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onSnapshotComplete(bitmap);
        }
    }

    public void onStatisticsUpdate(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            V2TXLiveDef.V2TXLivePusherStatistics v2TXLivePusherStatistics = new V2TXLiveDef.V2TXLivePusherStatistics();
            v2TXLivePusherStatistics.appCpu = i3;
            v2TXLivePusherStatistics.systemCpu = i16;
            v2TXLivePusherStatistics.width = i17;
            v2TXLivePusherStatistics.height = i18;
            v2TXLivePusherStatistics.fps = i19;
            v2TXLivePusherStatistics.videoBitrate = i26;
            v2TXLivePusherStatistics.audioBitrate = i27;
            v2TXLivePusherStatistics.rtt = i28;
            v2TXLivePusherStatistics.netSpeed = i29;
            v2TXLivePusherObserver.onStatisticsUpdate(v2TXLivePusherStatistics);
        }
    }

    public void onUserAudioAvailable(String str, boolean z16) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null && (v2TXLivePusherObserver instanceof b)) {
            ((b) v2TXLivePusherObserver).onUserAudioAvailable(str, z16);
        }
    }

    public void onUserOffline(String str) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null && (v2TXLivePusherObserver instanceof b)) {
            ((b) v2TXLivePusherObserver).onRemoteUserExit(str, 0);
        }
    }

    public void onUserOnline(String str) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null && (v2TXLivePusherObserver instanceof b)) {
            ((b) v2TXLivePusherObserver).onRemoteUserEnter(str);
        }
    }

    public void onUserVideoAvailable(String str, int i3, boolean z16) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null && (v2TXLivePusherObserver instanceof b)) {
            ((b) v2TXLivePusherObserver).onUserVideoAvailable(str, i3, z16);
        }
    }

    public void onVoiceActivityDetectionUpdate(boolean z16) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onVoiceActivityDetectionUpdate(z16);
        }
    }

    public void onWarning(int i3, String str, Bundle bundle) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onWarning(i3, str, bundle);
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int pauseAudio() {
        return nativePauseAudio(this.mNativeV2TXLivePusherJni);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int pauseVideo() {
        return nativePauseVideo(this.mNativeV2TXLivePusherJni);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public void release() {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManager;
        if (tXBeautyManagerImpl != null) {
            tXBeautyManagerImpl.clear();
        }
        long j3 = this.mNativeV2TXLivePusherJni;
        if (j3 != 0) {
            nativeDestroy(j3);
            this.mNativeV2TXLivePusherJni = 0L;
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int resumeAudio() {
        return nativeResumeAudio(this.mNativeV2TXLivePusherJni);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int resumeVideo() {
        return nativeResumeVideo(this.mNativeV2TXLivePusherJni);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int sendCustomAudioFrame(V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame) {
        if (v2TXLiveAudioFrame == null) {
            return -2;
        }
        return nativeSendCustomAudioFrame(this.mNativeV2TXLivePusherJni, v2TXLiveAudioFrame.data, v2TXLiveAudioFrame.sampleRate, v2TXLiveAudioFrame.channel, v2TXLiveAudioFrame.timestamp);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int sendCustomVideoFrame(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        GLConstants.PixelFormatType pixelFormatType;
        GLConstants.a aVar;
        Object eglContextFromLiveVideoFrame;
        if (v2TXLiveVideoFrame == null) {
            return -2;
        }
        int i3 = AnonymousClass1.f119067c[v2TXLiveVideoFrame.pixelFormat.ordinal()];
        int i16 = -1;
        if (i3 != 1) {
            if (i3 != 2) {
                return -1;
            }
            pixelFormatType = GLConstants.PixelFormatType.RGBA;
        } else {
            pixelFormatType = GLConstants.PixelFormatType.I420;
        }
        int i17 = AnonymousClass1.f119068d[v2TXLiveVideoFrame.bufferType.ordinal()];
        if (i17 != 1) {
            eglContextFromLiveVideoFrame = null;
            if (i17 != 2) {
                if (i17 != 3) {
                    return -1;
                }
                aVar = GLConstants.a.BYTE_BUFFER;
            } else {
                aVar = GLConstants.a.BYTE_ARRAY;
            }
        } else {
            aVar = GLConstants.a.TEXTURE_2D;
            V2TXLiveDef.V2TXLiveTexture v2TXLiveTexture = v2TXLiveVideoFrame.texture;
            if (v2TXLiveTexture == null) {
                return -1;
            }
            i16 = v2TXLiveTexture.textureId;
            eglContextFromLiveVideoFrame = getEglContextFromLiveVideoFrame(v2TXLiveVideoFrame);
        }
        return nativeSendCustomVideoFrame(this.mNativeV2TXLivePusherJni, v2TXLiveVideoFrame.width, v2TXLiveVideoFrame.height, aVar.mValue, pixelFormatType.getValue(), v2TXLiveVideoFrame.rotation, i16, eglContextFromLiveVideoFrame, v2TXLiveVideoFrame.data, v2TXLiveVideoFrame.buffer);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int sendSeiMessage(int i3, byte[] bArr) {
        return nativeSendSeiMessage(this.mNativeV2TXLivePusherJni, i3, bArr);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setAudioQuality(V2TXLiveDef.V2TXLiveAudioQuality v2TXLiveAudioQuality) {
        return nativeSetAudioQuality(this.mNativeV2TXLivePusherJni, v2TXLiveAudioQuality.ordinal());
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setEncoderMirror(boolean z16) {
        return nativeSetEncoderMirror(this.mNativeV2TXLivePusherJni, z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0101  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v2, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v3 */
    @Override // com.tencent.live2.V2TXLivePusher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int setMixTranscodingConfig(V2TXLiveDef.V2TXLiveTranscodingConfig v2TXLiveTranscodingConfig) {
        ?? r26;
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = "";
        if (v2TXLiveTranscodingConfig != null) {
            Object obj = null;
            try {
                ?? jSONObject = new JSONObject();
                try {
                    jSONObject.put("videoWidth", v2TXLiveTranscodingConfig.videoWidth);
                    jSONObject.put("videoHeight", v2TXLiveTranscodingConfig.videoHeight);
                    jSONObject.put("videoBitrate", v2TXLiveTranscodingConfig.videoBitrate);
                    jSONObject.put("videoFramerate", v2TXLiveTranscodingConfig.videoFramerate);
                    jSONObject.put("videoGOP", v2TXLiveTranscodingConfig.videoGOP);
                    jSONObject.put("backgroundColor", v2TXLiveTranscodingConfig.backgroundColor);
                    if (TextUtils.isEmpty(v2TXLiveTranscodingConfig.backgroundImage)) {
                        str = "";
                    } else {
                        str = v2TXLiveTranscodingConfig.backgroundImage;
                    }
                    jSONObject.put("backgroundImage", str);
                    jSONObject.put("audioSampleRate", v2TXLiveTranscodingConfig.audioSampleRate);
                    jSONObject.put("audioBitrate", v2TXLiveTranscodingConfig.audioBitrate);
                    jSONObject.put("audioChannels", v2TXLiveTranscodingConfig.audioChannels);
                    if (TextUtils.isEmpty(v2TXLiveTranscodingConfig.outputStreamId)) {
                        str2 = "";
                    } else {
                        str2 = v2TXLiveTranscodingConfig.outputStreamId;
                    }
                    jSONObject.put("outputStreamId", str2);
                    JSONArray jSONArray = new JSONArray();
                    ArrayList<V2TXLiveDef.V2TXLiveMixStream> arrayList = v2TXLiveTranscodingConfig.mixStreams;
                    if (arrayList != null) {
                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                            V2TXLiveDef.V2TXLiveMixStream v2TXLiveMixStream = arrayList.get(i3);
                            JSONObject jSONObject2 = new JSONObject();
                            if (TextUtils.isEmpty(v2TXLiveMixStream.userId)) {
                                str3 = "";
                            } else {
                                str3 = v2TXLiveMixStream.userId;
                            }
                            jSONObject2.put("userId", str3);
                            if (TextUtils.isEmpty(v2TXLiveMixStream.streamId)) {
                                str4 = "";
                            } else {
                                str4 = v2TXLiveMixStream.streamId;
                            }
                            jSONObject2.put("streamId", str4);
                            jSONObject2.put(HippyTKDListViewAdapter.X, v2TXLiveMixStream.f119782x);
                            jSONObject2.put("y", v2TXLiveMixStream.f119783y);
                            jSONObject2.put("width", v2TXLiveMixStream.width);
                            jSONObject2.put("height", v2TXLiveMixStream.height);
                            jSONObject2.put("zOrder", v2TXLiveMixStream.zOrder);
                            jSONObject2.put(RemoteMessageConst.INPUT_TYPE, v2TXLiveMixStream.inputType.ordinal());
                            jSONArray.mo162put(jSONObject2);
                        }
                    }
                    jSONObject.put("mixStreamList", jSONArray);
                    r26 = jSONObject;
                } catch (Exception e16) {
                    e = e16;
                    obj = jSONObject;
                    e.printStackTrace();
                    r26 = obj;
                    if (r26 != 0) {
                    }
                    return nativeSetMixTranscodingConfig(this.mNativeV2TXLivePusherJni, str5);
                }
            } catch (Exception e17) {
                e = e17;
            }
            if (r26 != 0) {
                str5 = r26.toString();
            }
        }
        return nativeSetMixTranscodingConfig(this.mNativeV2TXLivePusherJni, str5);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public void setObserver(V2TXLivePusherObserver v2TXLivePusherObserver) {
        this.mObserver = v2TXLivePusherObserver;
        if (v2TXLivePusherObserver != null && (v2TXLivePusherObserver instanceof b)) {
            nativeEnableExtensionCallback(this.mNativeV2TXLivePusherJni, true);
        }
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setProperty(String str, Object obj) {
        str.hashCode();
        if (!str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurfaceSize)) {
            if (!str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface)) {
                return nativeSetProperty(this.mNativeV2TXLivePusherJni, str, obj);
            }
            if (obj == null) {
                nativeSetRenderView(this.mNativeV2TXLivePusherJni, null);
                return 0;
            }
            if (obj instanceof Surface) {
                nativeSetRenderView(this.mNativeV2TXLivePusherJni, new DisplayTarget((Surface) obj));
                return 0;
            }
            LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
            return -2;
        }
        LiteavLog.i(TAG, "set surface size is unnecessary");
        return 0;
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setRenderFillMode(V2TXLiveDef.V2TXLiveFillMode v2TXLiveFillMode) {
        GLConstants.GLScaleType gLScaleType = GLConstants.GLScaleType.CENTER_CROP;
        int i3 = AnonymousClass1.f119066b[v2TXLiveFillMode.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    gLScaleType = GLConstants.GLScaleType.FILL;
                }
            } else {
                gLScaleType = GLConstants.GLScaleType.FIT_CENTER;
            }
        }
        return nativeSetRenderFillMode(this.mNativeV2TXLivePusherJni, gLScaleType.mValue);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setRenderMirror(V2TXLiveDef.V2TXLiveMirrorType v2TXLiveMirrorType) {
        return nativeSetRenderMirror(this.mNativeV2TXLivePusherJni, v2TXLiveMirrorType.ordinal());
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setRenderRotation(V2TXLiveDef.V2TXLiveRotation v2TXLiveRotation) {
        k kVar;
        int i3 = AnonymousClass1.f119065a[v2TXLiveRotation.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    kVar = k.NORMAL;
                } else {
                    kVar = k.ROTATION_270;
                }
            } else {
                kVar = k.ROTATION_180;
            }
        } else {
            kVar = k.ROTATION_90;
        }
        return nativeSetRenderRotation(this.mNativeV2TXLivePusherJni, kVar.mValue);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setRenderView(TXCloudVideoView tXCloudVideoView) {
        return nativeSetRenderView(this.mNativeV2TXLivePusherJni, new DisplayTarget(tXCloudVideoView));
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setVideoQuality(V2TXLiveDef.V2TXLiveVideoEncoderParam v2TXLiveVideoEncoderParam) {
        if (v2TXLiveVideoEncoderParam == null) {
            return -2;
        }
        return nativeSetVideoQuality(this.mNativeV2TXLivePusherJni, v2TXLiveVideoEncoderParam.videoResolution.ordinal(), v2TXLiveVideoEncoderParam.videoResolutionMode.ordinal(), v2TXLiveVideoEncoderParam.videoFps, v2TXLiveVideoEncoderParam.videoBitrate, v2TXLiveVideoEncoderParam.minVideoBitrate);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setWatermark(Bitmap bitmap, float f16, float f17, float f18) {
        return nativeSetWatermark(this.mNativeV2TXLivePusherJni, bitmap, f16, f17, f18);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public void showDebugView(boolean z16) {
        nativeShowDebugView(this.mNativeV2TXLivePusherJni, z16);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int snapshot() {
        return nativeSnapshot(this.mNativeV2TXLivePusherJni);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int startCamera(boolean z16) {
        return nativeStartCamera(this.mNativeV2TXLivePusherJni, z16);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int startLocalRecording(V2TXLiveDef.V2TXLiveLocalRecordingParams v2TXLiveLocalRecordingParams) {
        if (v2TXLiveLocalRecordingParams != null && !TextUtils.isEmpty(v2TXLiveLocalRecordingParams.filePath)) {
            return nativeStartRecord(this.mNativeV2TXLivePusherJni, v2TXLiveLocalRecordingParams.filePath, v2TXLiveLocalRecordingParams.recordMode.ordinal(), v2TXLiveLocalRecordingParams.interval);
        }
        return -2;
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int startMicrophone() {
        return nativeStartMicrophone(this.mNativeV2TXLivePusherJni);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int startPush(String str) {
        return nativeStartPush(this.mNativeV2TXLivePusherJni, str);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int startScreenCapture() {
        return nativeStartScreenCapture(this.mNativeV2TXLivePusherJni);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int startSystemAudioLoopback() {
        return nativeStartSystemAudioLoopback(this.mNativeV2TXLivePusherJni);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int startVirtualCamera(Bitmap bitmap) {
        return nativeStartVirtualCamera(this.mNativeV2TXLivePusherJni, bitmap);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int stopCamera() {
        return nativeStopCamera(this.mNativeV2TXLivePusherJni);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public void stopLocalRecording() {
        nativeStopRecord(this.mNativeV2TXLivePusherJni);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int stopMicrophone() {
        return nativeStopMicrophone(this.mNativeV2TXLivePusherJni);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int stopPush() {
        return nativeStopPush(this.mNativeV2TXLivePusherJni);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int stopScreenCapture() {
        return nativeStopScreenCapture(this.mNativeV2TXLivePusherJni);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int stopSystemAudioLoopback() {
        return nativeStopSystemAudioLoopback(this.mNativeV2TXLivePusherJni);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int stopVirtualCamera() {
        return nativeStopVirtualCamera(this.mNativeV2TXLivePusherJni);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setRenderView(TextureView textureView) {
        return nativeSetRenderView(this.mNativeV2TXLivePusherJni, new DisplayTarget(textureView));
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int setRenderView(SurfaceView surfaceView) {
        return nativeSetRenderView(this.mNativeV2TXLivePusherJni, new DisplayTarget(surfaceView));
    }
}
