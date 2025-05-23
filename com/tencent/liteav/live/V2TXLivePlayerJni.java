package com.tencent.liteav.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.V2TXLivePlayer;
import com.tencent.live2.V2TXLivePlayerObserver;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.live2.impl.V2TXLivePlayerImpl;
import com.tencent.live2.impl.V2TXLiveProperty;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLContext;
import org.json.JSONArray;
import org.json.JSONObject;

@JNINamespace("liteav")
/* loaded from: classes7.dex */
public class V2TXLivePlayerJni extends V2TXLivePlayer {
    private static final String TAG = "V2TXLivePlayerJni";
    private boolean mClearLastImage = true;
    protected long mNativeV2TXLivePlayerJni;
    private V2TXLivePlayerObserver mObserver;
    private V2TXLivePlayerImpl mProxy;

    /* renamed from: com.tencent.liteav.live.V2TXLivePlayerJni$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f119060a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f119061b;

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f119062c;

        /* renamed from: d, reason: collision with root package name */
        static final /* synthetic */ int[] f119063d;

        /* renamed from: e, reason: collision with root package name */
        static final /* synthetic */ int[] f119064e;

        static {
            int[] iArr = new int[k.values().length];
            f119064e = iArr;
            try {
                iArr[k.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f119064e[k.ROTATION_90.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f119064e[k.ROTATION_180.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f119064e[k.ROTATION_270.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[GLConstants.a.values().length];
            f119063d = iArr2;
            try {
                iArr2[GLConstants.a.BYTE_BUFFER.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f119063d[GLConstants.a.BYTE_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f119063d[GLConstants.a.TEXTURE_2D.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[GLConstants.PixelFormatType.values().length];
            f119062c = iArr3;
            try {
                iArr3[GLConstants.PixelFormatType.I420.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f119062c[GLConstants.PixelFormatType.RGBA.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr4 = new int[V2TXLiveDef.V2TXLiveFillMode.values().length];
            f119061b = iArr4;
            try {
                iArr4[V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeFill.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f119061b[V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeScaleFill.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr5 = new int[V2TXLiveDef.V2TXLiveRotation.values().length];
            f119060a = iArr5;
            try {
                iArr5[V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation90.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f119060a[V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation180.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f119060a[V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation270.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public V2TXLivePlayerJni(Context context, V2TXLivePlayerImpl v2TXLivePlayerImpl) {
        this.mNativeV2TXLivePlayerJni = 0L;
        this.mProxy = v2TXLivePlayerImpl;
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
        this.mNativeV2TXLivePlayerJni = nativeCreate(new WeakReference(this));
    }

    private void enableExtensionCallback(boolean z16) {
        synchronized (this) {
            nativeEnableExtensionCallback(this.mNativeV2TXLivePlayerJni, z16);
        }
    }

    public static V2TXLiveDef.V2TXLivePlayerStatistics getJavaV2TXLivePlayerStatistics(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37, int i38, int i39, int i46, int i47, int i48) {
        V2TXLiveDef.V2TXLivePlayerStatistics v2TXLivePlayerStatistics = new V2TXLiveDef.V2TXLivePlayerStatistics();
        v2TXLivePlayerStatistics.appCpu = i3;
        v2TXLivePlayerStatistics.systemCpu = i16;
        v2TXLivePlayerStatistics.rtt = i17;
        v2TXLivePlayerStatistics.width = i18;
        v2TXLivePlayerStatistics.height = i19;
        v2TXLivePlayerStatistics.fps = i26;
        v2TXLivePlayerStatistics.videoBitrate = i27;
        v2TXLivePlayerStatistics.audioBitrate = i28;
        v2TXLivePlayerStatistics.audioPacketLoss = i29;
        v2TXLivePlayerStatistics.videoPacketLoss = i36;
        v2TXLivePlayerStatistics.jitterBufferDelay = i37;
        v2TXLivePlayerStatistics.audioTotalBlockTime = i38;
        v2TXLivePlayerStatistics.audioBlockRate = i39;
        v2TXLivePlayerStatistics.videoTotalBlockTime = i46;
        v2TXLivePlayerStatistics.videoBlockRate = i47;
        v2TXLivePlayerStatistics.netSpeed = i48;
        return v2TXLivePlayerStatistics;
    }

    private static ArrayList<V2TXLiveDef.V2TXLiveStreamInfo> getStreamListFormJsonString(String str) {
        ArrayList<V2TXLiveDef.V2TXLiveStreamInfo> arrayList = new ArrayList<>();
        if (str != null && !str.isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    arrayList.add(new V2TXLiveDef.V2TXLiveStreamInfo(jSONObject.getInt("width"), jSONObject.getInt("height"), jSONObject.getInt("bitrate"), (float) jSONObject.getDouble("framerate"), jSONObject.getString("url")));
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return arrayList;
    }

    private static native long nativeCreate(WeakReference<V2TXLivePlayerJni> weakReference);

    private static native void nativeDestroy(long j3);

    private static native int nativeEnableCustomRendering(long j3, boolean z16, int i3, int i16);

    private static native void nativeEnableExtensionCallback(long j3, boolean z16);

    private static native int nativeEnableObserveAudioFrame(long j3, boolean z16);

    private static native int nativeEnableReceiveSeiMessage(long j3, boolean z16, int i3);

    private static native int nativeEnableVolumeEvaluation(long j3, int i3);

    private static native String nativeGetStreamList(long j3);

    private static native int nativeIsPlaying(long j3);

    private static native int nativePauseAudio(long j3);

    private static native int nativePauseVideo(long j3);

    private static native int nativeResumeAudio(long j3);

    private static native int nativeResumeVideo(long j3);

    private static native int nativeSetCacheParams(long j3, float f16, float f17);

    private static native int nativeSetPlayoutVolume(long j3, int i3);

    private static native int nativeSetProperty(long j3, String str, Object obj);

    private static native int nativeSetRenderFillMode(long j3, int i3);

    private static native int nativeSetRenderRotation(long j3, int i3);

    private static native int nativeSetRenderView(long j3, DisplayTarget displayTarget);

    private static native void nativeSetSharedEGLContext(long j3, Object obj);

    private static native void nativeShowDebugView(long j3, boolean z16);

    private static native int nativeSnapshot(long j3);

    private static native int nativeStartPlay(long j3, String str);

    private static native int nativeStartRecord(long j3, String str, int i3, int i16);

    private static native int nativeStopPlay(long j3, boolean z16);

    private static native void nativeStopRecord(long j3);

    private static native int nativeSwitchStream(long j3, String str);

    public static V2TXLivePlayerJni weakToStrongReference(WeakReference<V2TXLivePlayerJni> weakReference) {
        return weakReference.get();
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int enableObserveAudioFrame(boolean z16) {
        return nativeEnableObserveAudioFrame(this.mNativeV2TXLivePlayerJni, z16);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int enableObserveVideoFrame(boolean z16, V2TXLiveDef.V2TXLivePixelFormat v2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType v2TXLiveBufferType) {
        GLConstants.PixelFormatType pixelFormatType;
        GLConstants.a aVar;
        V2TXLiveDef.V2TXLivePixelFormat v2TXLivePixelFormat2 = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420;
        if (v2TXLivePixelFormat == v2TXLivePixelFormat2 && v2TXLiveBufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteArray) {
            pixelFormatType = GLConstants.PixelFormatType.I420;
            aVar = GLConstants.a.BYTE_ARRAY;
        } else if (v2TXLivePixelFormat == V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D && v2TXLiveBufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture) {
            pixelFormatType = GLConstants.PixelFormatType.RGBA;
            aVar = GLConstants.a.TEXTURE_2D;
        } else if (v2TXLivePixelFormat == v2TXLivePixelFormat2 && v2TXLiveBufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteBuffer) {
            pixelFormatType = GLConstants.PixelFormatType.I420;
            aVar = GLConstants.a.BYTE_BUFFER;
        } else {
            LiteavLog.e(TAG, "Enable custom render failed, invalid params. format:" + v2TXLivePixelFormat + " type:" + v2TXLiveBufferType);
            return -4;
        }
        return nativeEnableCustomRendering(this.mNativeV2TXLivePlayerJni, z16, pixelFormatType.getValue(), aVar.ordinal());
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int enableReceiveSeiMessage(boolean z16, int i3) {
        return nativeEnableReceiveSeiMessage(this.mNativeV2TXLivePlayerJni, z16, i3);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int enableVolumeEvaluation(int i3) {
        return nativeEnableVolumeEvaluation(this.mNativeV2TXLivePlayerJni, i3);
    }

    protected void finalize() {
        nativeDestroy(this.mNativeV2TXLivePlayerJni);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public ArrayList<V2TXLiveDef.V2TXLiveStreamInfo> getStreamList() {
        return getStreamListFormJsonString(nativeGetStreamList(this.mNativeV2TXLivePlayerJni));
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int isPlaying() {
        return nativeIsPlaying(this.mNativeV2TXLivePlayerJni);
    }

    public void onAudioLoading(Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onAudioLoading(this.mProxy, bundle);
        }
    }

    public void onAudioPlaying(boolean z16, Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onAudioPlaying(this.mProxy, z16, bundle);
        }
    }

    public void onConnected(Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onConnected(this.mProxy, bundle);
        }
    }

    public void onError(int i3, String str, Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onError(this.mProxy, i3, str, bundle);
        }
    }

    public void onNetworkQuality(int i3) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null && (v2TXLivePlayerObserver instanceof com.tencent.live2.impl.a.a)) {
            ((com.tencent.live2.impl.a.a) v2TXLivePlayerObserver).onNetworkQuality(i3);
        }
    }

    public void onPlayEvent(int i3, Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null && (v2TXLivePlayerObserver instanceof com.tencent.live2.impl.a.a)) {
            ((com.tencent.live2.impl.a.a) v2TXLivePlayerObserver).onPlayEvent(i3, bundle);
        }
    }

    public void onPlayNetStatus(Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null && (v2TXLivePlayerObserver instanceof com.tencent.live2.impl.a.a)) {
            ((com.tencent.live2.impl.a.a) v2TXLivePlayerObserver).onPlayNetStatus(bundle);
        }
    }

    public void onPlayoutAudioFrame(byte[] bArr, int i3, int i16) {
        V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame = new V2TXLiveDef.V2TXLiveAudioFrame();
        v2TXLiveAudioFrame.data = bArr;
        v2TXLiveAudioFrame.sampleRate = i3;
        v2TXLiveAudioFrame.channel = i16;
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onPlayoutAudioFrame(this.mProxy, v2TXLiveAudioFrame);
        }
    }

    public void onPlayoutVolumeUpdate(int i3) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onPlayoutVolumeUpdate(this.mProxy, i3);
        }
    }

    public void onReceiveSeiMessage(int i3, byte[] bArr) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onReceiveSeiMessage(this.mProxy, i3, bArr);
        }
    }

    public void onRecordBegin(int i3, String str) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onLocalRecordBegin(this.mProxy, i3, str);
        }
    }

    public void onRecordComplete(int i3, String str) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onLocalRecordComplete(this.mProxy, i3, str);
        }
    }

    public void onRecordProgress(long j3, String str) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onLocalRecording(this.mProxy, j3, str);
        }
    }

    public void onRenderVideoFrame(int i3, int i16, Object obj, int i17, int i18, int i19, int i26, long j3, byte[] bArr, ByteBuffer byteBuffer) {
        V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame = new V2TXLiveDef.V2TXLiveVideoFrame();
        GLConstants.PixelFormatType a16 = GLConstants.PixelFormatType.a(i3);
        int i27 = AnonymousClass1.f119062c[a16.ordinal()];
        if (i27 != 1) {
            if (i27 != 2) {
                LiteavLog.e(TAG, "Invalid pixelFormat. pixelFormat:" + a16 + ".");
            } else {
                v2TXLiveVideoFrame.pixelFormat = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D;
            }
        } else {
            v2TXLiveVideoFrame.pixelFormat = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420;
        }
        GLConstants.a a17 = GLConstants.a.a(i16);
        int i28 = AnonymousClass1.f119063d[a17.ordinal()];
        if (i28 != 1) {
            if (i28 != 2) {
                if (i28 != 3) {
                    LiteavLog.e(TAG, "Invalid bufferType. bufferType:" + a17 + ".");
                } else {
                    v2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture;
                }
            } else {
                v2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteArray;
            }
        } else {
            v2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteBuffer;
        }
        V2TXLiveDef.V2TXLiveTexture v2TXLiveTexture = new V2TXLiveDef.V2TXLiveTexture();
        v2TXLiveTexture.textureId = i17;
        if (obj instanceof EGLContext) {
            v2TXLiveTexture.eglContext10 = (EGLContext) obj;
        } else if (obj instanceof android.opengl.EGLContext) {
            v2TXLiveTexture.eglContext14 = (android.opengl.EGLContext) obj;
        }
        v2TXLiveVideoFrame.texture = v2TXLiveTexture;
        v2TXLiveVideoFrame.data = bArr;
        v2TXLiveVideoFrame.buffer = byteBuffer;
        v2TXLiveVideoFrame.width = i18;
        v2TXLiveVideoFrame.height = i19;
        int i29 = AnonymousClass1.f119064e[k.a(i26).ordinal()];
        if (i29 != 1) {
            if (i29 != 2) {
                if (i29 != 3) {
                    if (i29 != 4) {
                        v2TXLiveVideoFrame.rotation = 0;
                    } else {
                        v2TXLiveVideoFrame.rotation = 270;
                    }
                } else {
                    v2TXLiveVideoFrame.rotation = 180;
                }
            } else {
                v2TXLiveVideoFrame.rotation = 90;
            }
        } else {
            v2TXLiveVideoFrame.rotation = 0;
        }
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onRenderVideoFrame(this.mProxy, v2TXLiveVideoFrame);
        }
    }

    public void onSnapshotComplete(Bitmap bitmap) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onSnapshotComplete(this.mProxy, bitmap);
        }
    }

    public void onStatisticsUpdate(V2TXLiveDef.V2TXLivePlayerStatistics v2TXLivePlayerStatistics) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onStatisticsUpdate(this.mProxy, v2TXLivePlayerStatistics);
        }
    }

    public void onStreamSwitched(int i3, String str) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onStreamSwitched(this.mProxy, str, i3);
        }
    }

    public void onVideoLoading(Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onVideoLoading(this.mProxy, bundle);
        }
    }

    public void onVideoPlaying(boolean z16, Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onVideoPlaying(this.mProxy, z16, bundle);
        }
    }

    public void onVideoResolutionChanged(int i3, int i16) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onVideoResolutionChanged(this.mProxy, i3, i16);
        }
    }

    public void onWarning(int i3, String str, Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onWarning(this.mProxy, i3, str, bundle);
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int pauseAudio() {
        return nativePauseAudio(this.mNativeV2TXLivePlayerJni);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int pauseVideo() {
        return nativePauseVideo(this.mNativeV2TXLivePlayerJni);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int resumeAudio() {
        return nativeResumeAudio(this.mNativeV2TXLivePlayerJni);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int resumeVideo() {
        return nativeResumeVideo(this.mNativeV2TXLivePlayerJni);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setCacheParams(float f16, float f17) {
        if (f16 >= 0.0f && f17 >= 0.0f) {
            return nativeSetCacheParams(this.mNativeV2TXLivePlayerJni, f16, f17);
        }
        return -2;
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public void setObserver(V2TXLivePlayerObserver v2TXLivePlayerObserver) {
        this.mObserver = v2TXLivePlayerObserver;
        if (v2TXLivePlayerObserver != null && (v2TXLivePlayerObserver instanceof com.tencent.live2.impl.a.a)) {
            enableExtensionCallback(true);
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setPlayoutVolume(int i3) {
        return nativeSetPlayoutVolume(this.mNativeV2TXLivePlayerJni, i3);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setProperty(String str, Object obj) {
        char c16;
        synchronized (this) {
            switch (str.hashCode()) {
                case 480042124:
                    if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurfaceSize)) {
                        c16 = 2;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 582452376:
                    if (str.equals(V2TXLiveProperty.kV2ClearLastImage)) {
                        c16 = 0;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1120433643:
                    if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface)) {
                        c16 = 1;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1615550654:
                    if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetOpenGLContext)) {
                        c16 = 3;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                default:
                    c16 = '\uffff';
                    break;
            }
            if (c16 != 0) {
                if (c16 != 1) {
                    if (c16 != 2) {
                        if (c16 != 3) {
                            return nativeSetProperty(this.mNativeV2TXLivePlayerJni, str, obj);
                        }
                        if (!(obj instanceof EGLContext) && !(obj instanceof android.opengl.EGLContext)) {
                            LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                            return -2;
                        }
                        nativeSetSharedEGLContext(this.mNativeV2TXLivePlayerJni, obj);
                    } else {
                        LiteavLog.i(TAG, "set surface size is unnecessary");
                    }
                } else {
                    if (obj == null) {
                        return nativeSetRenderView(this.mNativeV2TXLivePlayerJni, null);
                    }
                    if (!(obj instanceof Surface)) {
                        LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                        return -2;
                    }
                    return nativeSetRenderView(this.mNativeV2TXLivePlayerJni, new DisplayTarget((Surface) obj));
                }
            } else {
                if (!(obj instanceof Boolean)) {
                    LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                    return -2;
                }
                this.mClearLastImage = ((Boolean) obj).booleanValue();
            }
            return 0;
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderFillMode(V2TXLiveDef.V2TXLiveFillMode v2TXLiveFillMode) {
        GLConstants.GLScaleType gLScaleType;
        int i3 = AnonymousClass1.f119061b[v2TXLiveFillMode.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                gLScaleType = GLConstants.GLScaleType.FIT_CENTER;
            } else {
                gLScaleType = GLConstants.GLScaleType.FILL;
            }
        } else {
            gLScaleType = GLConstants.GLScaleType.CENTER_CROP;
        }
        return nativeSetRenderFillMode(this.mNativeV2TXLivePlayerJni, gLScaleType.mValue);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderRotation(V2TXLiveDef.V2TXLiveRotation v2TXLiveRotation) {
        k kVar;
        int i3 = AnonymousClass1.f119060a[v2TXLiveRotation.ordinal()];
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
        return nativeSetRenderRotation(this.mNativeV2TXLivePlayerJni, kVar.mValue);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderView(TXCloudVideoView tXCloudVideoView) {
        return nativeSetRenderView(this.mNativeV2TXLivePlayerJni, tXCloudVideoView != null ? new DisplayTarget(tXCloudVideoView) : null);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public void showDebugView(boolean z16) {
        nativeShowDebugView(this.mNativeV2TXLivePlayerJni, z16);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int snapshot() {
        return nativeSnapshot(this.mNativeV2TXLivePlayerJni);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int startLivePlay(String str) {
        return nativeStartPlay(this.mNativeV2TXLivePlayerJni, str);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int startLocalRecording(V2TXLiveDef.V2TXLiveLocalRecordingParams v2TXLiveLocalRecordingParams) {
        if (v2TXLiveLocalRecordingParams != null && !TextUtils.isEmpty(v2TXLiveLocalRecordingParams.filePath)) {
            return nativeStartRecord(this.mNativeV2TXLivePlayerJni, v2TXLiveLocalRecordingParams.filePath, v2TXLiveLocalRecordingParams.recordMode.ordinal(), v2TXLiveLocalRecordingParams.interval);
        }
        return -2;
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public void stopLocalRecording() {
        nativeStopRecord(this.mNativeV2TXLivePlayerJni);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int stopPlay() {
        return nativeStopPlay(this.mNativeV2TXLivePlayerJni, this.mClearLastImage);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int switchStream(String str) {
        if (TextUtils.isEmpty(str)) {
            LiteavLog.e(TAG, "Invalid params.");
            return -2;
        }
        return nativeSwitchStream(this.mNativeV2TXLivePlayerJni, str);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderView(TextureView textureView) {
        return nativeSetRenderView(this.mNativeV2TXLivePlayerJni, textureView != null ? new DisplayTarget(textureView) : null);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderView(SurfaceView surfaceView) {
        return nativeSetRenderView(this.mNativeV2TXLivePlayerJni, surfaceView != null ? new DisplayTarget(surfaceView) : null);
    }
}
