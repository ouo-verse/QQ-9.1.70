package com.tencent.thumbplayer.core.downloadproxy.client;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadParamAidl;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPOfflineDownloadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes26.dex */
public class TPDownloadProxyClient implements ITPDownloadProxy {
    private static final String FILE_NAME = "TPDownloadProxyClient";
    private ITPDownloadProxyAidl downloadProxyAidl;
    private Context mContext;
    private int mServiceType;
    private TPDLProxyInitParam mSubProcessInitParam;

    public TPDownloadProxyClient(int i3, ITPDownloadProxyAidl iTPDownloadProxyAidl) {
        this.mServiceType = i3;
        this.downloadProxyAidl = iTPDownloadProxyAidl;
    }

    private String getSuggestBitrate(int i3) {
        if (i3 == TPDownloadProxyEnum.SuggestBitrateType.NOT_CHOOSE_CLARIFY.ordinal()) {
            return getNativeInfo(6);
        }
        if (i3 == TPDownloadProxyEnum.SuggestBitrateType.CHOOSE_CLARIFY.ordinal()) {
            return getNativeInfo(7);
        }
        return null;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public long GetTotalMemorySizeKB() {
        try {
            return this.downloadProxyAidl.GetTotalMemorySizeKB();
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "GetTotalMemorySizeMB failed, error:" + th5.toString());
            return 0L;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int checkResourceStatus(String str, String str2, int i3) {
        try {
            return this.downloadProxyAidl.checkResourceStatus(str, str2, i3);
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "checkResourceStatus failed, error:" + th5);
            return -1;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int clearCache(String str, String str2, int i3) {
        try {
            return this.downloadProxyAidl.clearCache(str, str2, i3);
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "clearCache failed, error:" + th5);
            return -1;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int clearRangeCache(String str, int i3, int i16) {
        try {
            return this.downloadProxyAidl.clearRangeCache(str, i3, i16);
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "clearRangeCache failed, error:" + th5);
            return -1;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int deinit() {
        return 0;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public String getClipPlayUrl(int i3, int i16, int i17) {
        ITPDownloadProxy processAdapterDownloadProxy;
        if (TPDownloadProxyFactory.isNeedSwitchToMainProcess() && (processAdapterDownloadProxy = TPDownloadProxyFactory.getProcessAdapterDownloadProxy(this.mServiceType)) != null) {
            return processAdapterDownloadProxy.getClipPlayUrl(i3, i16, i17);
        }
        try {
            return this.downloadProxyAidl.getClipPlayUrl(i3, i16, i17);
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getClipPlayUrl failed, error:" + th5);
            return null;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public String getDownloadProxyInfo(int i3, Object obj, Object obj2, Object obj3) {
        ITPDownloadProxy processAdapterDownloadProxy;
        if (TPDownloadProxyFactory.isNeedSwitchToMainProcess() && (processAdapterDownloadProxy = TPDownloadProxyFactory.getProcessAdapterDownloadProxy(this.mServiceType)) != null) {
            return processAdapterDownloadProxy.getDownloadProxyInfo(i3, obj, obj2, obj3);
        }
        if (i3 != 0) {
            return null;
        }
        int ordinal = TPDownloadProxyEnum.SuggestBitrateType.NOT_CHOOSE_CLARIFY.ordinal();
        if (obj != null) {
            ordinal = TPDLProxyUtils.stringToInt(obj.toString(), ordinal);
        }
        return getSuggestBitrate(ordinal);
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public String getNativeInfo(int i3) {
        ITPDownloadProxy processAdapterDownloadProxy;
        if (TPDownloadProxyFactory.isNeedSwitchToMainProcess() && (processAdapterDownloadProxy = TPDownloadProxyFactory.getProcessAdapterDownloadProxy(this.mServiceType)) != null) {
            return processAdapterDownloadProxy.getNativeInfo(i3);
        }
        try {
            return this.downloadProxyAidl.getNativeInfo(i3);
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getNativeInfo failed, error:" + th5);
            return null;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public String getPlayErrorCodeStr(int i3) {
        ITPDownloadProxy processAdapterDownloadProxy;
        if (TPDownloadProxyFactory.isNeedSwitchToMainProcess() && (processAdapterDownloadProxy = TPDownloadProxyFactory.getProcessAdapterDownloadProxy(this.mServiceType)) != null) {
            return processAdapterDownloadProxy.getPlayErrorCodeStr(i3);
        }
        try {
            return this.downloadProxyAidl.getPlayErrorCodeStr(i3);
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayErrorCodeStr failed, error:" + th5);
            return null;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public String getPlayUrl(int i3, int i16) {
        ITPDownloadProxy processAdapterDownloadProxy;
        if (TPDownloadProxyFactory.isNeedSwitchToMainProcess() && (processAdapterDownloadProxy = TPDownloadProxyFactory.getProcessAdapterDownloadProxy(this.mServiceType)) != null) {
            return processAdapterDownloadProxy.getPlayUrl(i3, i16);
        }
        try {
            return this.downloadProxyAidl.getPlayUrl(i3, i16);
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayUrl failed, error:" + th5);
            return null;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public long getResourceSize(String str, String str2) {
        try {
            return this.downloadProxyAidl.getResourceSize(str, str2);
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getResourceSize failed, error:" + th5);
            return -1L;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int init(Context context, TPDLProxyInitParam tPDLProxyInitParam) {
        this.mContext = context;
        this.mSubProcessInitParam = tPDLProxyInitParam;
        String serialize = TPDLProxyUtils.serialize(tPDLProxyInitParam);
        if (TextUtils.isEmpty(serialize)) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "param is null");
            return -1;
        }
        try {
            return this.downloadProxyAidl.init(serialize);
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "init failed, error:" + th5);
            return -2;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public boolean isInit() {
        return true;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int pauseDownload(int i3) {
        ITPDownloadProxy processAdapterDownloadProxy;
        if (TPDownloadProxyFactory.isNeedSwitchToMainProcess() && (processAdapterDownloadProxy = TPDownloadProxyFactory.getProcessAdapterDownloadProxy(this.mServiceType)) != null) {
            return processAdapterDownloadProxy.pauseDownload(i3);
        }
        try {
            return this.downloadProxyAidl.pauseDownload(i3);
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "pauseDownload failed, error:" + th5);
            return -1;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void pushEvent(int i3) {
        if (TPDownloadProxyFactory.isNeedSwitchToMainProcess()) {
            ITPDownloadProxy processAdapterDownloadProxy = TPDownloadProxyFactory.getProcessAdapterDownloadProxy(this.mServiceType);
            if (processAdapterDownloadProxy != null) {
                processAdapterDownloadProxy.pushEvent(i3);
                return;
            }
            return;
        }
        try {
            this.downloadProxyAidl.pushEvent(i3);
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "pushEvent failed, error:" + th5);
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int removeStorageCache(String str) {
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int resumeDownload(int i3) {
        ITPDownloadProxy processAdapterDownloadProxy;
        if (TPDownloadProxyFactory.isNeedSwitchToMainProcess() && (processAdapterDownloadProxy = TPDownloadProxyFactory.getProcessAdapterDownloadProxy(this.mServiceType)) != null) {
            return processAdapterDownloadProxy.resumeDownload(i3);
        }
        try {
            return this.downloadProxyAidl.resumeDownload(i3);
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "resumeDownload failed, error:" + th5);
            return -1;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void setBusinessDownloadStrategy(int i3, int i16, int i17, int i18, int i19) {
        try {
            this.downloadProxyAidl.setBusinessDownloadStrategy(i3, i16, i17, i18, i19);
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setBusinessDownloadStrategy failed, error:" + th5.toString());
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public boolean setClipInfo(int i3, int i16, String str, TPDownloadParam tPDownloadParam) {
        ITPDownloadProxy processAdapterDownloadProxy;
        if (TPDownloadProxyFactory.isNeedSwitchToMainProcess() && (processAdapterDownloadProxy = TPDownloadProxyFactory.getProcessAdapterDownloadProxy(this.mServiceType)) != null) {
            return processAdapterDownloadProxy.setClipInfo(i3, i16, str, tPDownloadParam);
        }
        try {
            return this.downloadProxyAidl.setClipInfo(i3, i16, str, new TPDownloadParamAidl(tPDownloadParam.getUrlList(), tPDownloadParam.getDlType(), tPDownloadParam.getExtInfoMap()));
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setClipInfo failed, error:" + th5);
            return false;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void setLogListener(ITPDLProxyLogListener iTPDLProxyLogListener) {
        TPDLProxyLog.setLogListener(TVKEventId.PLAYER_STATE_CLIP_START, iTPDLProxyLogListener);
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void setMaxStorageSizeMB(long j3) {
        try {
            this.downloadProxyAidl.setMaxStorageSizeMB(j3);
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setMaxStorageSizeMB failed, error:" + th5);
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void setPlayState(int i3, int i16) {
        if (TPDownloadProxyFactory.isNeedSwitchToMainProcess()) {
            ITPDownloadProxy processAdapterDownloadProxy = TPDownloadProxyFactory.getProcessAdapterDownloadProxy(this.mServiceType);
            if (processAdapterDownloadProxy != null) {
                processAdapterDownloadProxy.setPlayState(i3, i16);
                return;
            }
            return;
        }
        try {
            this.downloadProxyAidl.setPlayState(i3, i16);
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setPlayState failed, error:" + th5);
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void setUpdatePlayerInfoInterval(int i3) {
        try {
            this.downloadProxyAidl.setUpdatePlayerInfoInterval(i3);
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setUpdatePlayerInfoInterval failed, error:" + th5.toString());
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void setUserData(String str, Object obj) {
        if (TPDownloadProxyFactory.isNeedSwitchToMainProcess()) {
            ITPDownloadProxy processAdapterDownloadProxy = TPDownloadProxyFactory.getProcessAdapterDownloadProxy(this.mServiceType);
            if (processAdapterDownloadProxy != null) {
                processAdapterDownloadProxy.setUserData(str, obj);
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(str, obj);
        try {
            this.downloadProxyAidl.setUserData(hashMap);
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setUserData failed, error:" + th5);
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int startClipOfflineDownload(String str, int i3, ITPOfflineDownloadListener iTPOfflineDownloadListener) {
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int startClipPlay(String str, int i3, final ITPPlayListener iTPPlayListener) {
        ITPDownloadProxy processAdapterDownloadProxy;
        if (TPDownloadProxyFactory.isNeedSwitchToMainProcess() && (processAdapterDownloadProxy = TPDownloadProxyFactory.getProcessAdapterDownloadProxy(this.mServiceType)) != null) {
            return processAdapterDownloadProxy.startClipPlay(str, i3, iTPPlayListener);
        }
        try {
            if (iTPPlayListener == null) {
                return this.downloadProxyAidl.startClipPlay(str, i3, null);
            }
            return this.downloadProxyAidl.startClipPlay(str, i3, new ITPPlayListenerAidl.Stub() { // from class: com.tencent.thumbplayer.core.downloadproxy.client.TPDownloadProxyClient.2
                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public long getAdvRemainTime() {
                    return iTPPlayListener.getAdvRemainTime();
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public String getContentType(int i16, String str2) throws RemoteException {
                    return null;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public int getCurrentPlayClipNo() {
                    return iTPPlayListener.getCurrentPlayClipNo();
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public long getCurrentPlayOffset() {
                    return iTPPlayListener.getCurrentPlayOffset();
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public long getCurrentPosition() {
                    return iTPPlayListener.getCurrentPosition();
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public String getDataFilePath(int i16, String str2) throws RemoteException {
                    return null;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public long getDataTotalSize(int i16, String str2) throws RemoteException {
                    return 0L;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public String getPlayInfo(String str2) {
                    Object playInfo = iTPPlayListener.getPlayInfo(str2);
                    if (playInfo != null && playInfo.getClass() == String.class) {
                        if (playInfo.getClass() == String.class) {
                            return (String) playInfo;
                        }
                        if (playInfo.getClass() == Integer.class) {
                            return Integer.toString(((Integer) playInfo).intValue());
                        }
                        return null;
                    }
                    return null;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public long getPlayerBufferLength() {
                    return iTPPlayListener.getPlayerBufferLength();
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public void onDownloadCdnUrlExpired(Map map) {
                    iTPPlayListener.onDownloadCdnUrlExpired(map);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public void onDownloadCdnUrlInfoUpdate(String str2, String str3, String str4, String str5) {
                    iTPPlayListener.onDownloadCdnUrlInfoUpdate(str2, str3, str4, str5);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public void onDownloadCdnUrlUpdate(String str2) {
                    iTPPlayListener.onDownloadCdnUrlUpdate(str2);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public void onDownloadError(int i16, int i17, String str2) {
                    iTPPlayListener.onDownloadError(i16, i17, str2);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public void onDownloadFinish() {
                    iTPPlayListener.onDownloadFinish();
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public void onDownloadProgressUpdate(int i16, int i17, long j3, long j16, String str2) {
                    iTPPlayListener.onDownloadProgressUpdate(i16, i17, j3, j16, str2);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public void onDownloadProtocolUpdate(String str2, String str3) {
                    iTPPlayListener.onDownloadProtocolUpdate(str2, str3);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public void onDownloadStatusUpdate(int i16) {
                    iTPPlayListener.onDownloadStatusUpdate(i16);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public void onPcdnDownloadFailed(String str2) throws RemoteException {
                    iTPPlayListener.onPcdnDownloadFailed(str2);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public int onPlayCallback(int i16, List list) {
                    Object obj = 0;
                    if (list != null) {
                        if (list.size() == 1) {
                            obj = iTPPlayListener.onPlayCallback(i16, list.get(0), null, null, null);
                        } else if (list.size() == 2) {
                            obj = iTPPlayListener.onPlayCallback(i16, list.get(0), list.get(1), null, null);
                        } else if (list.size() == 3) {
                            obj = iTPPlayListener.onPlayCallback(i16, list.get(0), list.get(1), list.get(2), null);
                        } else if (list.size() == 4) {
                            obj = iTPPlayListener.onPlayCallback(i16, list.get(0), list.get(1), list.get(2), list.get(3));
                        } else {
                            TPDLProxyLog.e(TPDownloadProxyClient.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "playCallback failed, ext size error");
                        }
                    } else {
                        TPDLProxyLog.e(TPDownloadProxyClient.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "playCallback failed, ext is null");
                    }
                    if (obj != null && obj.getClass() == Integer.class) {
                        return ((Integer) obj).intValue();
                    }
                    return -1;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public void onQuicDownloadStatusUpdate(String str2) {
                    iTPPlayListener.onQuicDownloadStatusUpdate(str2);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public int onReadData(int i16, String str2, long j3, long j16) throws RemoteException {
                    return 0;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public int onStartReadData(int i16, String str2, long j3, long j16) throws RemoteException {
                    return 0;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public int onStopReadData(int i16, String str2, int i17) throws RemoteException {
                    return 0;
                }
            });
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startClipPlay failed, error:" + th5);
            return -1;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int startClipPreload(String str, int i3, final ITPPreLoadListener iTPPreLoadListener) {
        try {
            return this.downloadProxyAidl.startClipPreload(str, i3, new ITPPreLoadListenerAidl.Stub() { // from class: com.tencent.thumbplayer.core.downloadproxy.client.TPDownloadProxyClient.4
                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl
                public void onPcdnDownloadFailed(String str2) throws RemoteException {
                    iTPPreLoadListener.onPcdnDownloadFailed(str2);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl
                public void onPrepareDownloadProgressUpdate(int i16, int i17, long j3, long j16, String str2) {
                    iTPPreLoadListener.onPrepareDownloadProgressUpdate(i16, i17, j3, j16, str2);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl
                public void onPrepareError(int i16, int i17, String str2) {
                    iTPPreLoadListener.onPrepareError(i16, i17, str2);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl
                public void onPrepareOK() {
                    iTPPreLoadListener.onPrepareOK();
                }
            });
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startClipPreload failed, error:" + th5);
            return -1;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int startOfflineDownload(String str, TPDownloadParam tPDownloadParam, ITPOfflineDownloadListener iTPOfflineDownloadListener) {
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int startPlay(String str, TPDownloadParam tPDownloadParam, final ITPPlayListener iTPPlayListener) {
        ITPDownloadProxy processAdapterDownloadProxy;
        if (this.downloadProxyAidl != null && tPDownloadParam != null) {
            if (TPDownloadProxyFactory.isNeedSwitchToMainProcess() && (processAdapterDownloadProxy = TPDownloadProxyFactory.getProcessAdapterDownloadProxy(this.mServiceType)) != null) {
                if (!processAdapterDownloadProxy.isInit()) {
                    processAdapterDownloadProxy.init(this.mContext, this.mSubProcessInitParam);
                }
                return processAdapterDownloadProxy.startPlay(str, tPDownloadParam, iTPPlayListener);
            }
            TPDownloadParamAidl tPDownloadParamAidl = new TPDownloadParamAidl(tPDownloadParam.getUrlList(), tPDownloadParam.getDlType(), tPDownloadParam.getExtInfoMap());
            try {
                if (iTPPlayListener == null) {
                    return this.downloadProxyAidl.startPlay(str, tPDownloadParamAidl, null);
                }
                return this.downloadProxyAidl.startPlay(str, tPDownloadParamAidl, new ITPPlayListenerAidl.Stub() { // from class: com.tencent.thumbplayer.core.downloadproxy.client.TPDownloadProxyClient.1
                    @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                    public long getAdvRemainTime() {
                        return iTPPlayListener.getAdvRemainTime();
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                    public String getContentType(int i3, String str2) throws RemoteException {
                        return iTPPlayListener.getContentType(i3, str2);
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                    public int getCurrentPlayClipNo() {
                        return iTPPlayListener.getCurrentPlayClipNo();
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                    public long getCurrentPlayOffset() {
                        return iTPPlayListener.getCurrentPlayOffset();
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                    public long getCurrentPosition() {
                        return iTPPlayListener.getCurrentPosition();
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                    public String getDataFilePath(int i3, String str2) throws RemoteException {
                        return iTPPlayListener.getDataFilePath(i3, str2);
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                    public long getDataTotalSize(int i3, String str2) throws RemoteException {
                        return iTPPlayListener.getDataTotalSize(i3, str2);
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                    public String getPlayInfo(String str2) {
                        Object playInfo = iTPPlayListener.getPlayInfo(str2);
                        if (playInfo != null && playInfo.getClass() == String.class) {
                            if (playInfo.getClass() == String.class) {
                                return (String) playInfo;
                            }
                            if (playInfo.getClass() == Integer.class) {
                                return Integer.toString(((Integer) playInfo).intValue());
                            }
                            return null;
                        }
                        return null;
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                    public long getPlayerBufferLength() {
                        return iTPPlayListener.getPlayerBufferLength();
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                    public void onDownloadCdnUrlExpired(Map map) {
                        iTPPlayListener.onDownloadCdnUrlExpired(map);
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                    public void onDownloadCdnUrlInfoUpdate(String str2, String str3, String str4, String str5) {
                        iTPPlayListener.onDownloadCdnUrlInfoUpdate(str2, str3, str4, str5);
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                    public void onDownloadCdnUrlUpdate(String str2) {
                        iTPPlayListener.onDownloadCdnUrlUpdate(str2);
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                    public void onDownloadError(int i3, int i16, String str2) {
                        iTPPlayListener.onDownloadError(i3, i16, str2);
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                    public void onDownloadFinish() {
                        iTPPlayListener.onDownloadFinish();
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                    public void onDownloadProgressUpdate(int i3, int i16, long j3, long j16, String str2) {
                        iTPPlayListener.onDownloadProgressUpdate(i3, i16, j3, j16, str2);
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                    public void onDownloadProtocolUpdate(String str2, String str3) {
                        iTPPlayListener.onDownloadProtocolUpdate(str2, str3);
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                    public void onDownloadStatusUpdate(int i3) {
                        iTPPlayListener.onDownloadStatusUpdate(i3);
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                    public void onPcdnDownloadFailed(String str2) throws RemoteException {
                        iTPPlayListener.onPcdnDownloadFailed(str2);
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                    public int onPlayCallback(int i3, List list) {
                        Object obj = 0;
                        if (list != null) {
                            if (list.size() == 1) {
                                obj = iTPPlayListener.onPlayCallback(i3, list.get(0), null, null, null);
                            } else if (list.size() == 2) {
                                obj = iTPPlayListener.onPlayCallback(i3, list.get(0), list.get(1), null, null);
                            } else if (list.size() == 3) {
                                obj = iTPPlayListener.onPlayCallback(i3, list.get(0), list.get(1), list.get(2), null);
                            } else if (list.size() == 4) {
                                obj = iTPPlayListener.onPlayCallback(i3, list.get(0), list.get(1), list.get(2), list.get(3));
                            } else {
                                TPDLProxyLog.e(TPDownloadProxyClient.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "playCallback failed, ext size error");
                            }
                        } else {
                            TPDLProxyLog.e(TPDownloadProxyClient.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "playCallback failed, ext is null");
                        }
                        if (obj != null && obj.getClass() == Integer.class) {
                            return ((Integer) obj).intValue();
                        }
                        return -1;
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                    public void onQuicDownloadStatusUpdate(String str2) {
                        iTPPlayListener.onQuicDownloadStatusUpdate(str2);
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                    public int onReadData(int i3, String str2, long j3, long j16) throws RemoteException {
                        return iTPPlayListener.onReadData(i3, str2, j3, j16);
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                    public int onStartReadData(int i3, String str2, long j3, long j16) throws RemoteException {
                        return iTPPlayListener.onStartReadData(i3, str2, j3, j16);
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                    public int onStopReadData(int i3, String str2, int i16) throws RemoteException {
                        return iTPPlayListener.onStopReadData(i3, str2, i16);
                    }
                });
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startPlay failed, error:" + th5);
            }
        }
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int startPreload(String str, TPDownloadParam tPDownloadParam, final ITPPreLoadListener iTPPreLoadListener) {
        try {
            return this.downloadProxyAidl.startPreload(str, new TPDownloadParamAidl(tPDownloadParam.getUrlList(), tPDownloadParam.getDlType(), tPDownloadParam.getExtInfoMap()), new ITPPreLoadListenerAidl.Stub() { // from class: com.tencent.thumbplayer.core.downloadproxy.client.TPDownloadProxyClient.3
                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl
                public void onPcdnDownloadFailed(String str2) throws RemoteException {
                    iTPPreLoadListener.onPcdnDownloadFailed(str2);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl
                public void onPrepareDownloadProgressUpdate(int i3, int i16, long j3, long j16, String str2) {
                    iTPPreLoadListener.onPrepareDownloadProgressUpdate(i3, i16, j3, j16, str2);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl
                public void onPrepareError(int i3, int i16, String str2) {
                    iTPPreLoadListener.onPrepareError(i3, i16, str2);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl
                public void onPrepareOK() {
                    iTPPreLoadListener.onPrepareOK();
                }
            });
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startPreload failed, error:" + th5);
            return -1;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void startTask(int i3) {
        try {
            this.downloadProxyAidl.startTask(i3);
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startTask failed, error:" + th5);
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void stopPlay(int i3) {
        if (TPDownloadProxyFactory.isNeedSwitchToMainProcess()) {
            ITPDownloadProxy processAdapterDownloadProxy = TPDownloadProxyFactory.getProcessAdapterDownloadProxy(this.mServiceType);
            if (processAdapterDownloadProxy != null) {
                processAdapterDownloadProxy.stopPlay(i3);
                return;
            }
            return;
        }
        try {
            this.downloadProxyAidl.stopPlay(i3);
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "stopPlay failed, error:" + th5);
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void stopPreload(int i3) {
        try {
            this.downloadProxyAidl.stopPreload(i3);
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "stopPreload failed, error:" + th5);
        }
    }

    public void updateAidl(ITPDownloadProxyAidl iTPDownloadProxyAidl) {
        this.downloadProxyAidl = iTPDownloadProxyAidl;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void updateTaskInfo(int i3, String str, Object obj) {
        if (TPDownloadProxyFactory.isNeedSwitchToMainProcess()) {
            ITPDownloadProxy processAdapterDownloadProxy = TPDownloadProxyFactory.getProcessAdapterDownloadProxy(this.mServiceType);
            if (processAdapterDownloadProxy != null) {
                processAdapterDownloadProxy.updateTaskInfo(i3, str, obj);
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(str, obj);
        try {
            this.downloadProxyAidl.updateTaskInfo(i3, hashMap);
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "updateTaskInfo failed, error:" + th5);
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void stopOfflineDownload(int i3) {
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void updateStoragePath(String str) {
    }
}
