package com.tencent.qqvideo.proxy.common;

import android.content.Context;
import android.util.Log;
import com.tencent.qqvideo.proxy.api.IPlayManager;
import com.tencent.qqvideo.proxy.api.IUtils;
import com.tencent.qqvideo.proxy.httpproxy.HttpproxyFacade;

/* loaded from: classes34.dex */
public class PlayManagerImp implements IPlayManager {
    private static String TAG = "TV_Httpproxy";
    private static boolean mbSoLoadSuccess = false;
    private ConfigStorage mConfigStorageInstance = new ConfigStorage();
    private HttpproxyFacade proxy;

    public PlayManagerImp() {
        this.proxy = null;
        this.proxy = HttpproxyFacade.instance();
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized void appToBack() {
        Log.d("@httpproxy_test", "appToBack");
        try {
            this.proxy.pushEvent(3);
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,appToBack synchronized not found");
        }
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized void appToFront() {
        Log.d("@httpproxy_test", "appToFront");
        try {
            this.proxy.pushEvent(4);
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,appToFront synchronized not found");
        }
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized String buildClipPlayURL(int i3, int i16) {
        try {
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,buildClipPlayURL synchronized not found");
            return "";
        }
        return this.proxy.buildClipPlayURL(i3, i16);
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized String buildPlayURLMp4(int i3) {
        Log.d("@httpproxy_test", "buildPlayURLMP4");
        try {
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,buildPlayURL synchronized not found");
            return "";
        }
        return this.proxy.buildPlayURL(i3);
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int cleanMemory() {
        try {
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,cleanMemory synchronized not found");
            return -1;
        }
        return this.proxy.cleanMemory();
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int cleanStorage() {
        try {
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error, cleanStorage synchronized not found");
            return -1;
        }
        return this.proxy.cleanStorage();
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized void deinit() {
        try {
            this.mConfigStorageInstance.stopGetServerConfig();
            this.proxy.deinit();
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,deinit synchronized not found");
        }
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int deleteClipFileOnDisk(String str, int i3) {
        try {
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,deleteClipFileOnDisk synchronized not found");
            return -1;
        }
        return this.proxy.deleteClipFileOnDisk(str, i3);
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int deleteFileOnDisk(String str) {
        try {
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,deleteFileOnDisk synchronized not found");
            return -1;
        }
        return this.proxy.deleteFileOnDisk(str);
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized long getClipFileSizeOnDisk(String str, int i3) {
        try {
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,getClipFileSizeOnDisk synchronized not found");
            return -1L;
        }
        return this.proxy.getClipFileSizeOnDisk(str, i3);
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized long getCurrentOffset(int i3) {
        try {
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,getCurrentOffset synchronized not found");
            return 0L;
        }
        return this.proxy.getCurrentOffset(i3);
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int getLocalServerPort() {
        try {
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,getLocalServerPort synchronized not found");
            return -1;
        }
        return this.proxy.getLocalServerPort();
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized String getProxyVersion() {
        Log.d("@httpproxy_test", "getProxyVersion");
        try {
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,getProxyVersion synchronized not found");
            return "TVHttpproxy.1.0.0.0000";
        }
        return this.proxy.getVersion();
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized long getTotalOffset(int i3) {
        try {
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,getTotalOffset synchronized not found");
            return 0L;
        }
        return this.proxy.getTotalOffset(i3);
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int init(Context context, String str) {
        if (context == null) {
            Log.e(TAG, "TVHttpProxy init context is null");
            return -1;
        }
        if (this.proxy != null) {
            HttpproxyFacade.setContext(context);
        }
        if (!mbSoLoadSuccess) {
            try {
                System.loadLibrary("tvideodownloadproxy");
                mbSoLoadSuccess = true;
            } catch (Throwable unused) {
                Log.e(TAG, "TVHttpProxyLoadLibrary load tvideodownloadproxy error ");
                mbSoLoadSuccess = false;
                return -1;
            }
        }
        Log.d("@httpproxy_test", "init");
        try {
            HttpproxyFacade.print(4, TAG, "TVDownloadProxy Version:" + ConfigStorage.getHttpProxyVersion());
            String downProxyConfig = ConfigStorage.getDownProxyConfig(context);
            this.mConfigStorageInstance.synGetServerConfig(context);
            return this.proxy.init(str, downProxyConfig);
        } catch (Throwable unused2) {
            Log.e(TAG, "error , init synchronized not found");
            return -1;
        }
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized boolean isClipCompleteOnDisk(String str, int i3) {
        try {
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,isClipCompleteOnDisk synchronized not found");
            return false;
        }
        return this.proxy.isClipCompleteOnDisk(str, i3);
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int pauseAllPreLoad() {
        try {
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,pauseAllPreLoad synchronized not found");
            return -1;
        }
        return this.proxy.pauseAllPreLoad();
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int pauseStorageIO() {
        try {
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,pauseStorageIO synchronized not found");
            return -1;
        }
        return this.proxy.pauseStorageIO();
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int preLoad(int i3, int i16) {
        Log.d("@httpproxy_test", "preLoad");
        try {
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,preLoad synchronized not found");
            return -1;
        }
        return this.proxy.preLoad(i3, i16);
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int preLoadClip(int i3, int i16, int i17, boolean z16, int i18) {
        try {
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,preLoadClip synchronized not found");
            return -1;
        }
        return this.proxy.preLoadClip(i3, i16, i17, z16, i18);
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int resumeAllPreLoad() {
        try {
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,resumeAllPreLoad synchronized not found");
            return -1;
        }
        return this.proxy.resumeAllPreLoad();
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int resumeStorageIO() {
        try {
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,resumeStorageIO synchronized not found");
            return -1;
        }
        return this.proxy.resumeStorageIO();
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int setClipInfo(int i3, int i16, String str, long j3, int i17) {
        try {
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,setClipInfo synchronized not found");
            return -1;
        }
        return this.proxy.setClipInfo(i3, i16, str, j3, i17);
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized void setCookie(String str) {
        try {
            this.proxy.setCookie(str);
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,setCookie synchronized not found");
        }
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public void setHttpLowSpeedParams(int i3, int i16) {
        try {
            this.proxy.setHttpLowSpeedParams(i3, i16);
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,setHttpLowSpeedParams synchronized not found");
        }
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int setMaxMemorySize(long j3) {
        try {
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,setMaxMemorySize synchronized not found");
            return -1;
        }
        return this.proxy.setMaxMemorySize(j3);
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int setMaxStorageSize(long j3) {
        try {
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,setMaxStorageSize synchronized not found");
            return -1;
        }
        return this.proxy.setMaxStorageSize(j3);
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized void setNetWorkState(int i3) {
        Log.d("@httpproxy_test", "setNetWorkState" + i3);
        try {
            this.proxy.setNetWorkState(i3);
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,setNetWorkStatus synchronized not found");
        }
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized void setPlayerState(int i3, int i16) {
        Log.d("@httpproxy_test", "setPlayerState:" + i3 + ":" + i16);
        try {
            this.proxy.setPlayerState(i3, i16);
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,setPlayState synchronized not found");
        }
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized void setRemainTime(int i3, int i16) {
        try {
            this.proxy.setRemainTime(i3, i16);
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,getTotalOffset synchronized not found");
        }
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized void setUtilsObject(IUtils iUtils) {
        Log.d("@httpproxy_test", "setUtilsObject");
        try {
            this.proxy.setUtils(iUtils);
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,setUtilsObject synchronized not found");
        }
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int startPlay(String str, int i3, String str2, long j3, int i16) {
        Log.d("@httpproxy_test", "startPlay");
        try {
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,startPlay synchronized not found");
            return -1;
        }
        return this.proxy.startPlay(str, i3, str2, j3, i16);
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int startPreLoad(int i3, String str, boolean z16, int i16) {
        try {
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,startPreLoad(int fileType, String fileID, boolean isSaveDisk, int playFlag) synchronized not found");
            return -1;
        }
        return this.proxy.startPreLoad(i3, str, z16, i16);
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int stopAllPreLoad() {
        try {
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,stopAllPreLoad synchronized not found");
            return -1;
        }
        return this.proxy.stopAllPreLoad();
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized void stopPlay(int i3) {
        try {
            this.proxy.stopPlay(i3);
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,stopPlay synchronized not found");
        }
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int stopPreLoad(int i3) {
        try {
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,stopPreLoad synchronized not found");
            return -1;
        }
        return this.proxy.stopPreLoad(i3);
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int startPlay(int i3, String str, boolean z16, int i16) {
        try {
        } catch (Throwable unused) {
            HttpproxyFacade.print(6, TAG, "error ,startPlayEx(int fileType, String fileID, boolean isSaveDisk, int playFlag) synchronized not found");
            return -1;
        }
        return this.proxy.startPlayEx(i3, str, z16, i16);
    }
}
