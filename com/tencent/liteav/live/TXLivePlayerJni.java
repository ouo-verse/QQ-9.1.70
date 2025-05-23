package com.tencent.liteav.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.qqlive.tvkplayer.dex.sdkupdate.TVKUpdateInfo;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;
import java.io.File;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

@JNINamespace("liteav")
/* loaded from: classes7.dex */
public class TXLivePlayerJni implements com.tencent.rtmp.a, TXCloudVideoView.b {
    private static final String TAG = "TXLivePlayerJni";
    private TXLivePlayer.ITXAudioRawDataListener mAudioRawDataListener;
    private TXLivePlayer.ITXAudioVolumeEvaluationListener mAudioVolumeEvaluationListener;
    private Object mGLContext = null;
    private ITXLivePlayListener mListener;
    protected long mNativeTXLivePlayerJni;
    private TXLivePlayer.ITXSnapshotListener mSnapshotListener;
    private TXLivePlayer.ITXVideoRawDataListener mVideoRawDataListener;
    private TXRecordCommon.ITXVideoRecordListener mVideoRecordListener;
    private TXLivePlayer.ITXLivePlayVideoRenderListener mVideoRenderListener;

    public TXLivePlayerJni(Context context) {
        this.mNativeTXLivePlayerJni = 0L;
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
        this.mNativeTXLivePlayerJni = nativeCreate(new WeakReference(this));
    }

    private static String genFilePath(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(Long.valueOf(valueOf + TVKUpdateInfo.APP_ID).longValue()));
            String diskFileDir = getDiskFileDir(context);
            if (TextUtils.isEmpty(diskFileDir)) {
                return null;
            }
            return new File(diskFileDir, String.format("TXUGC_%s".concat(String.valueOf(str)), format)).getAbsolutePath();
        } catch (Exception e16) {
            LiteavLog.e(TAG, "create file path failed.", e16);
            return null;
        }
    }

    private static String getDiskFileDir(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        if (!"mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable()) {
            return context.getFilesDir().getPath();
        }
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
        if (externalFilesDir != null) {
            str = externalFilesDir.getPath();
        }
        return str;
    }

    public static String[] getMapKeys(Map<String, String> map) {
        String[] strArr = new String[map.size()];
        Iterator<String> it = map.keySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            strArr[i3] = it.next();
            i3++;
        }
        return strArr;
    }

    public static String[] getMapValues(Map<String, String> map, String[] strArr) {
        String[] strArr2 = new String[map.size()];
        int length = strArr.length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            strArr2[i16] = map.get(strArr[i3]);
            i3++;
            i16++;
        }
        return strArr2;
    }

    private static native void nativeCallExperimentalAPI(long j3, String str);

    private static native long nativeCreate(WeakReference<TXLivePlayerJni> weakReference);

    private static native void nativeDestroy(long j3);

    private static native void nativeEnableAudioVolumeEvaluation(long j3, int i3);

    private static native void nativeEnableCustomAudioProcess(long j3, boolean z16);

    private static native void nativeEnableCustomRenderI420(long j3, boolean z16);

    private static native void nativeEnableCustomRenderTexture(long j3, boolean z16, Object obj);

    private static native void nativeEnableHardwareDecode(long j3, boolean z16);

    private static native long nativeGetCurrentRenderPts(long j3);

    private static native boolean nativeIsPlaying(long j3);

    private static native void nativePause(long j3);

    private static native void nativeResume(long j3);

    private static native void nativeSetAudioRoute(long j3, int i3);

    private static native void nativeSetConfig(long j3, float f16, float f17, float f18, int i3, int i16, int i17, boolean z16, boolean z17, boolean z18, String str, Map map);

    private static native void nativeSetMute(long j3, boolean z16);

    private static native void nativeSetPlayerView(long j3, DisplayTarget displayTarget);

    private static native void nativeSetRenderMode(long j3, int i3);

    private static native void nativeSetRenderRotation(long j3, int i3);

    private static native void nativeSetVolume(long j3, int i3);

    private static native void nativeShowDebugView(long j3, boolean z16);

    private static native void nativeSnapshot(long j3);

    private static native int nativeStartPlay(long j3, String str, int i3);

    private static native void nativeStartRecord(long j3, int i3, String str);

    private static native void nativeStopPlay(long j3, boolean z16);

    private static native void nativeStopRecord(long j3);

    private static native int nativeSwitchStream(long j3, String str);

    public static TXLivePlayerJni weakToStrongReference(WeakReference<TXLivePlayerJni> weakReference) {
        return weakReference.get();
    }

    public boolean addVideoRawData(byte[] bArr) {
        return false;
    }

    @Override // com.tencent.rtmp.a
    public void callExperimentalAPI(String str) {
        nativeCallExperimentalAPI(this.mNativeTXLivePlayerJni, str);
    }

    @Override // com.tencent.rtmp.a
    public void enableAudioVolumeEvaluation(int i3) {
        nativeEnableAudioVolumeEvaluation(this.mNativeTXLivePlayerJni, i3);
    }

    @Override // com.tencent.rtmp.a
    public boolean enableHardwareDecode(boolean z16) {
        nativeEnableHardwareDecode(this.mNativeTXLivePlayerJni, z16);
        return true;
    }

    protected void finalize() {
        nativeDestroy(this.mNativeTXLivePlayerJni);
    }

    @Override // com.tencent.rtmp.a
    public long getCurrentRenderPts() {
        return nativeGetCurrentRenderPts(this.mNativeTXLivePlayerJni);
    }

    @Override // com.tencent.rtmp.a
    public boolean isPlaying() {
        return nativeIsPlaying(this.mNativeTXLivePlayerJni);
    }

    public void onAudioInfoChanged(int i3, int i16, int i17) {
        TXLivePlayer.ITXAudioRawDataListener iTXAudioRawDataListener = this.mAudioRawDataListener;
        if (iTXAudioRawDataListener != null) {
            iTXAudioRawDataListener.onAudioInfoChanged(i3, i16, i17);
        }
    }

    public void onAudioVolumeEvaluationNotify(int i3) {
        TXLivePlayer.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener = this.mAudioVolumeEvaluationListener;
        if (iTXAudioVolumeEvaluationListener != null) {
            iTXAudioVolumeEvaluationListener.onAudioVolumeEvaluationNotify(i3);
        }
    }

    public void onNetStatus(Bundle bundle) {
        ITXLivePlayListener iTXLivePlayListener = this.mListener;
        if (iTXLivePlayListener != null) {
            iTXLivePlayListener.onNetStatus(bundle);
        }
    }

    public void onPcmDataAvailable(byte[] bArr, long j3) {
        TXLivePlayer.ITXAudioRawDataListener iTXAudioRawDataListener = this.mAudioRawDataListener;
        if (iTXAudioRawDataListener != null) {
            iTXAudioRawDataListener.onPcmDataAvailable(bArr, j3);
        }
    }

    public void onPlayEvent(int i3, Bundle bundle) {
        ITXLivePlayListener iTXLivePlayListener = this.mListener;
        if (iTXLivePlayListener != null) {
            iTXLivePlayListener.onPlayEvent(i3, bundle);
        }
    }

    public void onRecordComplete(int i3, String str, String str2, String str3) {
        TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener = this.mVideoRecordListener;
        if (iTXVideoRecordListener != null) {
            TXRecordCommon.TXRecordResult tXRecordResult = new TXRecordCommon.TXRecordResult();
            if (i3 == 0) {
                tXRecordResult.retCode = 0;
            } else {
                tXRecordResult.retCode = -1;
            }
            tXRecordResult.descMsg = str;
            tXRecordResult.videoPath = str2;
            tXRecordResult.coverPath = str3;
            iTXVideoRecordListener.onRecordComplete(tXRecordResult);
        }
    }

    public void onRecordEvent(int i3, Bundle bundle) {
        TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener = this.mVideoRecordListener;
        if (iTXVideoRecordListener != null) {
            iTXVideoRecordListener.onRecordEvent(i3, bundle);
        }
    }

    public void onRecordProgress(long j3) {
        TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener = this.mVideoRecordListener;
        if (iTXVideoRecordListener != null) {
            iTXVideoRecordListener.onRecordProgress(j3);
        }
    }

    public void onRenderVideoFrame(int i3, int i16, Object obj, int i17, int i18, int i19, int i26, long j3, byte[] bArr, ByteBuffer byteBuffer) {
        TXLivePlayer.ITXLivePlayVideoRenderListener iTXLivePlayVideoRenderListener = this.mVideoRenderListener;
        if (iTXLivePlayVideoRenderListener != null) {
            TXLivePlayer.TXLiteAVTexture tXLiteAVTexture = new TXLivePlayer.TXLiteAVTexture();
            tXLiteAVTexture.textureId = i17;
            tXLiteAVTexture.width = i18;
            tXLiteAVTexture.height = i19;
            tXLiteAVTexture.eglContext = obj;
            iTXLivePlayVideoRenderListener.onRenderVideoFrame(tXLiteAVTexture);
        }
        TXLivePlayer.ITXVideoRawDataListener iTXVideoRawDataListener = this.mVideoRawDataListener;
        if (iTXVideoRawDataListener != null) {
            iTXVideoRawDataListener.onVideoRawDataAvailable(bArr, i18, i19, (int) j3);
        }
    }

    @Override // com.tencent.rtmp.ui.TXCloudVideoView.b
    public void onShowLog(boolean z16) {
        showDebugView(z16);
    }

    public void onSnapshot(Bitmap bitmap) {
        TXLivePlayer.ITXSnapshotListener iTXSnapshotListener = this.mSnapshotListener;
        if (iTXSnapshotListener != null) {
            iTXSnapshotListener.onSnapshot(bitmap);
        }
    }

    @Override // com.tencent.rtmp.a
    public void pause() {
        nativePause(this.mNativeTXLivePlayerJni);
    }

    @Override // com.tencent.rtmp.a
    public void resume() {
        nativeResume(this.mNativeTXLivePlayerJni);
    }

    @Override // com.tencent.rtmp.a
    public void setAudioRawDataListener(TXLivePlayer.ITXAudioRawDataListener iTXAudioRawDataListener) {
        boolean z16;
        this.mAudioRawDataListener = iTXAudioRawDataListener;
        long j3 = this.mNativeTXLivePlayerJni;
        if (iTXAudioRawDataListener != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        nativeEnableCustomAudioProcess(j3, z16);
    }

    @Override // com.tencent.rtmp.a
    public void setAudioRoute(int i3) {
        nativeSetAudioRoute(this.mNativeTXLivePlayerJni, i3);
    }

    @Override // com.tencent.rtmp.a
    public void setAudioVolumeEvaluationListener(TXLivePlayer.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        this.mAudioVolumeEvaluationListener = iTXAudioVolumeEvaluationListener;
    }

    @Override // com.tencent.rtmp.a
    public void setConfig(TXLivePlayConfig tXLivePlayConfig) {
        if (tXLivePlayConfig == null) {
            return;
        }
        nativeSetConfig(this.mNativeTXLivePlayerJni, tXLivePlayConfig.getCacheTime(), tXLivePlayConfig.getMaxAutoAdjustCacheTime(), tXLivePlayConfig.getMinAutoAdjustCacheTime(), tXLivePlayConfig.getVideoBlockThreshold(), tXLivePlayConfig.getConnectRetryCount(), tXLivePlayConfig.getConnectRetryInterval(), tXLivePlayConfig.isAutoAdjustCacheTime(), tXLivePlayConfig.isEnableMessage(), tXLivePlayConfig.isEnableMetaData(), tXLivePlayConfig.getFlvSessionKey(), tXLivePlayConfig.getHeaders());
    }

    @Override // com.tencent.rtmp.a
    public void setMute(boolean z16) {
        nativeSetMute(this.mNativeTXLivePlayerJni, z16);
    }

    @Override // com.tencent.rtmp.a
    public void setPlayListener(ITXLivePlayListener iTXLivePlayListener) {
        this.mListener = iTXLivePlayListener;
    }

    @Override // com.tencent.rtmp.a
    public void setPlayerView(TXCloudVideoView tXCloudVideoView) {
        DisplayTarget displayTarget;
        if (tXCloudVideoView != null) {
            a.a(tXCloudVideoView, new WeakReference(this));
            showDebugView(a.a(tXCloudVideoView));
        }
        long j3 = this.mNativeTXLivePlayerJni;
        if (tXCloudVideoView != null) {
            displayTarget = new DisplayTarget(tXCloudVideoView);
        } else {
            displayTarget = null;
        }
        nativeSetPlayerView(j3, displayTarget);
    }

    @Override // com.tencent.rtmp.a
    public void setRenderMode(int i3) {
        nativeSetRenderMode(this.mNativeTXLivePlayerJni, i3);
    }

    @Override // com.tencent.rtmp.a
    public void setRenderRotation(int i3) {
        nativeSetRenderRotation(this.mNativeTXLivePlayerJni, i3);
    }

    @Override // com.tencent.rtmp.a
    public void setSurface(Surface surface) {
        DisplayTarget displayTarget;
        long j3 = this.mNativeTXLivePlayerJni;
        if (surface != null) {
            displayTarget = new DisplayTarget(surface);
        } else {
            displayTarget = null;
        }
        nativeSetPlayerView(j3, displayTarget);
    }

    @Override // com.tencent.rtmp.a
    public void setVideoRawDataListener(TXLivePlayer.ITXVideoRawDataListener iTXVideoRawDataListener) {
        synchronized (this) {
            boolean z16 = false;
            if (this.mVideoRenderListener != null) {
                this.mVideoRenderListener = null;
                this.mGLContext = null;
                nativeEnableCustomRenderTexture(this.mNativeTXLivePlayerJni, false, null);
            }
            this.mVideoRawDataListener = iTXVideoRawDataListener;
            long j3 = this.mNativeTXLivePlayerJni;
            if (iTXVideoRawDataListener != null) {
                z16 = true;
            }
            nativeEnableCustomRenderI420(j3, z16);
        }
    }

    @Override // com.tencent.rtmp.a
    public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        this.mVideoRecordListener = iTXVideoRecordListener;
    }

    @Override // com.tencent.rtmp.a
    public int setVideoRenderListener(TXLivePlayer.ITXLivePlayVideoRenderListener iTXLivePlayVideoRenderListener, Object obj) {
        boolean z16;
        synchronized (this) {
            if (this.mVideoRawDataListener != null) {
                this.mVideoRawDataListener = null;
                nativeEnableCustomRenderI420(this.mNativeTXLivePlayerJni, false);
            }
            this.mVideoRenderListener = iTXLivePlayVideoRenderListener;
            if (iTXLivePlayVideoRenderListener == null) {
                obj = null;
            }
            this.mGLContext = obj;
            long j3 = this.mNativeTXLivePlayerJni;
            if (iTXLivePlayVideoRenderListener != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            nativeEnableCustomRenderTexture(j3, z16, obj);
        }
        return 0;
    }

    @Override // com.tencent.rtmp.a
    public void setVolume(int i3) {
        nativeSetVolume(this.mNativeTXLivePlayerJni, i3);
    }

    @Override // com.tencent.rtmp.a
    public void showDebugView(boolean z16) {
        nativeShowDebugView(this.mNativeTXLivePlayerJni, z16);
    }

    @Override // com.tencent.rtmp.a
    public void snapshot(TXLivePlayer.ITXSnapshotListener iTXSnapshotListener) {
        this.mSnapshotListener = iTXSnapshotListener;
        nativeSnapshot(this.mNativeTXLivePlayerJni);
    }

    @Override // com.tencent.rtmp.a
    public int startLivePlay(String str, int i3) {
        return nativeStartPlay(this.mNativeTXLivePlayerJni, str, i3);
    }

    @Override // com.tencent.rtmp.a
    public int startRecord(int i3) {
        String genFilePath = genFilePath(ContextUtils.getApplicationContext(), ".mp4");
        if (TextUtils.isEmpty(genFilePath)) {
            return -1;
        }
        nativeStartRecord(this.mNativeTXLivePlayerJni, i3, genFilePath);
        return 0;
    }

    @Override // com.tencent.rtmp.a
    public int stopPlay(boolean z16) {
        nativeStopPlay(this.mNativeTXLivePlayerJni, z16);
        return 0;
    }

    @Override // com.tencent.rtmp.a
    public int stopRecord() {
        nativeStopRecord(this.mNativeTXLivePlayerJni);
        return 0;
    }

    @Override // com.tencent.rtmp.a
    public int switchStream(String str) {
        if (TextUtils.isEmpty(str)) {
            LiteavLog.e(TAG, "Invalid params.");
            return -1;
        }
        return nativeSwitchStream(this.mNativeTXLivePlayerJni, str);
    }

    @Override // com.tencent.rtmp.a
    public void setSurfaceSize(int i3, int i16) {
    }
}
