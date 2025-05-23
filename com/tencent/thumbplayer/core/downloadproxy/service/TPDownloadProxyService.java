package com.tencent.thumbplayer.core.downloadproxy.service;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyInfoCallbackAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadParamAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxyInfoCallback;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyHelper;
import com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes26.dex */
public class TPDownloadProxyService extends Service {
    private static final String FILE_NAME = "TPDownloadProxyService";
    private int pid = -1;
    private TPDownloadProxyFactoryAidl.Stub downloadProxyFactory = null;

    /* loaded from: classes26.dex */
    private class DownloadProxy extends ITPDownloadProxyAidl.Stub {
        private ITPDownloadProxy downloadProxy;

        public DownloadProxy(int i3) {
            this.downloadProxy = null;
            this.downloadProxy = TPDownloadProxyFactory.getTPDownloadProxy(i3);
            TPDLProxyLog.i(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "Construct TPDownloadProxy sub prcess, serviceType:" + i3);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public long GetTotalMemorySizeKB() {
            return this.downloadProxy.GetTotalMemorySizeKB();
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public int checkResourceStatus(String str, String str2, int i3) {
            try {
                return this.downloadProxy.checkResourceStatus(str, str2, i3);
            } catch (Throwable th5) {
                TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "checkResourceStatus failed, error:" + th5);
                return -1;
            }
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public int clearCache(String str, String str2, int i3) {
            try {
                return this.downloadProxy.clearCache(str, str2, i3);
            } catch (Throwable th5) {
                TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "clearCache failed, error:" + th5);
                return -1;
            }
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public int clearRangeCache(String str, int i3, int i16) {
            try {
                return this.downloadProxy.clearRangeCache(str, i3, i16);
            } catch (Throwable th5) {
                TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "clearRangeCache failed, error:" + th5);
                return -1;
            }
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public String getClipPlayUrl(int i3, int i16, int i17) {
            return this.downloadProxy.getClipPlayUrl(i3, i16, i17);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public String getNativeInfo(int i3) {
            try {
                return this.downloadProxy.getNativeInfo(i3);
            } catch (Throwable th5) {
                TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getNativeInfo failed, error:" + th5);
                return null;
            }
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public String getPlayErrorCodeStr(int i3) {
            return this.downloadProxy.getPlayErrorCodeStr(i3);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public String getPlayUrl(int i3, int i16) {
            return this.downloadProxy.getPlayUrl(i3, i16);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public long getResourceSize(String str, String str2) {
            try {
                return this.downloadProxy.getResourceSize(str, str2);
            } catch (Throwable th5) {
                TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getResourceSize failed, error:" + th5);
                return -1L;
            }
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public int init(String str) {
            try {
                TPDLProxyInitParam tPDLProxyInitParam = (TPDLProxyInitParam) TPDLProxyUtils.serializeToObject(str);
                if (tPDLProxyInitParam == null) {
                    TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "param is null");
                    return -1;
                }
                int init = this.downloadProxy.init(TPDownloadProxyHelper.getContext(), tPDLProxyInitParam);
                pushEvent(101);
                return init;
            } catch (Throwable th5) {
                TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "init failed, error:" + th5);
                return -2;
            }
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public int pauseDownload(int i3) {
            return this.downloadProxy.pauseDownload(i3);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public void pushEvent(int i3) {
            this.downloadProxy.pushEvent(i3);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public int resumeDownload(int i3) {
            return this.downloadProxy.resumeDownload(i3);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public void setBusinessDownloadStrategy(int i3, int i16, int i17, int i18, int i19) {
            this.downloadProxy.setBusinessDownloadStrategy(i3, i16, i17, i18, i19);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public boolean setClipInfo(int i3, int i16, String str, TPDownloadParamAidl tPDownloadParamAidl) {
            return this.downloadProxy.setClipInfo(i3, i16, str, new TPDownloadParam(tPDownloadParamAidl.getUrlList(), tPDownloadParamAidl.getDlType(), tPDownloadParamAidl.getExtInfoMap()));
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public void setMaxStorageSizeMB(long j3) {
            this.downloadProxy.setMaxStorageSizeMB(j3);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public void setPlayState(int i3, int i16) {
            this.downloadProxy.setPlayState(i3, i16);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public void setUpdatePlayerInfoInterval(int i3) {
            this.downloadProxy.setUpdatePlayerInfoInterval(i3);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public void setUserData(Map map) {
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    if (entry != null) {
                        try {
                            if (entry.getValue() != null) {
                                this.downloadProxy.setUserData((String) entry.getKey(), entry.getValue());
                            }
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setUserData failed, error:" + th5);
                        }
                    }
                }
            }
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public int startClipPlay(String str, int i3, final ITPPlayListenerAidl iTPPlayListenerAidl) {
            return this.downloadProxy.startClipPlay(str, i3, new ITPPlayListener() { // from class: com.tencent.thumbplayer.core.downloadproxy.service.TPDownloadProxyService.DownloadProxy.2
                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public long getAdvRemainTime() {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl2 != null) {
                            return iTPPlayListenerAidl2.getAdvRemainTime();
                        }
                        return -1L;
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getAdvRemainTime failed, error:" + th5);
                        return -1L;
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public String getContentType(int i16, String str2) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl2 != null) {
                            return iTPPlayListenerAidl2.getContentType(i16, str2);
                        }
                        return "";
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getContentType key failed, error:" + th5);
                        return "";
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public int getCurrentPlayClipNo() {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl2 != null) {
                            return iTPPlayListenerAidl2.getCurrentPlayClipNo();
                        }
                        return -1;
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getCurrentPlayClipNo failed, error:" + th5);
                        return -1;
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public long getCurrentPlayOffset() {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl2 != null) {
                            return iTPPlayListenerAidl2.getCurrentPlayOffset();
                        }
                        return -1L;
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getCurrentPlayOffset failed, error:" + th5);
                        return -1L;
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public long getCurrentPosition() {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl2 != null) {
                            return iTPPlayListenerAidl2.getCurrentPosition();
                        }
                        return -1L;
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getCurrentPosition failed, error:" + th5);
                        return -1L;
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public String getDataFilePath(int i16, String str2) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl2 != null) {
                            return iTPPlayListenerAidl2.getDataFilePath(i16, str2);
                        }
                        return "";
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getDataFilePath key failed, error:" + th5);
                        return "";
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public long getDataTotalSize(int i16, String str2) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl2 != null) {
                            return iTPPlayListenerAidl2.getDataTotalSize(i16, str2);
                        }
                        return -1L;
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getDataTotalSize key failed, error:" + th5);
                        return -1L;
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public Object getPlayInfo(long j3) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl2 != null) {
                            return iTPPlayListenerAidl2.getPlayInfo(Long.toString(j3));
                        }
                        return null;
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayInfo type failed, error:" + th5);
                        return null;
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public long getPlayerBufferLength() {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl2 != null) {
                            return iTPPlayListenerAidl2.getPlayerBufferLength();
                        }
                        return -1L;
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayerBufferLength failed, error:" + th5);
                        return -1L;
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public void onDownloadCdnUrlExpired(Map<String, String> map) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl2 != null) {
                            iTPPlayListenerAidl2.onDownloadCdnUrlExpired(map);
                        }
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadCdnUrlExpired failed, error:" + th5);
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public void onDownloadCdnUrlInfoUpdate(String str2, String str3, String str4, String str5) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl2 != null) {
                            iTPPlayListenerAidl2.onDownloadCdnUrlInfoUpdate(str2, str3, str4, str5);
                        }
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadCdnUrlInfoUpdate failed, error:" + th5);
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public void onDownloadCdnUrlUpdate(String str2) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl2 != null) {
                            iTPPlayListenerAidl2.onDownloadCdnUrlUpdate(str2);
                        }
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadCdnUrlUpdate failed, error:" + th5);
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public void onDownloadError(int i16, int i17, String str2) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl2 != null) {
                            iTPPlayListenerAidl2.onDownloadError(i16, i17, str2);
                        }
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadError failed, error:" + th5);
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public void onDownloadFinish() {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl2 != null) {
                            iTPPlayListenerAidl2.onDownloadFinish();
                        }
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadFinish failed, error:" + th5);
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public void onDownloadProgressUpdate(int i16, int i17, long j3, long j16, String str2) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl2 != null) {
                            iTPPlayListenerAidl2.onDownloadProgressUpdate(i16, i17, j3, j16, str2);
                        }
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadProgressUpdate failed, error:" + th5);
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public void onDownloadProtocolUpdate(String str2, String str3) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl2 != null) {
                            iTPPlayListenerAidl2.onDownloadProtocolUpdate(str2, str3);
                        }
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadProtocolUpdate failed, error:" + th5);
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public void onDownloadStatusUpdate(int i16) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl2 != null) {
                            iTPPlayListenerAidl2.onDownloadStatusUpdate(i16);
                        }
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadStatusUpdate failed, error:" + th5);
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public void onPcdnDownloadFailed(String str2) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl2 != null) {
                            iTPPlayListenerAidl2.onPcdnDownloadFailed(str2);
                        }
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onPcdnDownloadFailed failed, error:" + th5.toString());
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public Object onPlayCallback(int i16, Object obj, Object obj2, Object obj3, Object obj4) {
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(obj);
                        arrayList.add(obj2);
                        arrayList.add(obj3);
                        arrayList.add(obj4);
                        ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl2 != null) {
                            iTPPlayListenerAidl2.onPlayCallback(i16, arrayList);
                            return null;
                        }
                        return null;
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onPlayCallback failed, error:" + th5);
                        return null;
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public void onQuicDownloadStatusUpdate(String str2) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl2 != null) {
                            iTPPlayListenerAidl2.onQuicDownloadStatusUpdate(str2);
                        }
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onQuicDownloadStatusUpdate failed, error:" + th5.toString());
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public int onReadData(int i16, String str2, long j3, long j16) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl2 != null) {
                            return iTPPlayListenerAidl2.onReadData(i16, str2, j3, j16);
                        }
                        return -1;
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onReadData key failed, error:" + th5);
                        return -1;
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public int onStartReadData(int i16, String str2, long j3, long j16) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl2 != null) {
                            return iTPPlayListenerAidl2.onStartReadData(i16, str2, j3, j16);
                        }
                        return -1;
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onStartReadData key failed, error:" + th5);
                        return -1;
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public int onStopReadData(int i16, String str2, int i17) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl2 != null) {
                            return iTPPlayListenerAidl2.onStopReadData(i16, str2, i17);
                        }
                        return -1;
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onStopReadData key failed, error:" + th5);
                        return -1;
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public Object getPlayInfo(String str2) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl2 != null) {
                            return iTPPlayListenerAidl2.getPlayInfo(str2);
                        }
                        return null;
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayInfo key failed, error:" + th5);
                        return null;
                    }
                }
            });
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public int startClipPreload(String str, int i3, final ITPPreLoadListenerAidl iTPPreLoadListenerAidl) {
            return this.downloadProxy.startClipPreload(str, i3, new ITPPreLoadListener() { // from class: com.tencent.thumbplayer.core.downloadproxy.service.TPDownloadProxyService.DownloadProxy.4
                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener
                public void onPcdnDownloadFailed(String str2) {
                    try {
                        ITPPreLoadListenerAidl iTPPreLoadListenerAidl2 = iTPPreLoadListenerAidl;
                        if (iTPPreLoadListenerAidl2 != null) {
                            iTPPreLoadListenerAidl2.onPcdnDownloadFailed(str2);
                        }
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onPcdnDownloadFailed failed, error:" + th5.toString());
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener
                public void onPrepareDownloadProgressUpdate(int i16, int i17, long j3, long j16, String str2) {
                    try {
                        ITPPreLoadListenerAidl iTPPreLoadListenerAidl2 = iTPPreLoadListenerAidl;
                        if (iTPPreLoadListenerAidl2 != null) {
                            iTPPreLoadListenerAidl2.onPrepareDownloadProgressUpdate(i16, i17, j3, j16, str2);
                        }
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onPrepareDownloadProgressUpdate failed, error:" + th5);
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener
                public void onPrepareError(int i16, int i17, String str2) {
                    try {
                        ITPPreLoadListenerAidl iTPPreLoadListenerAidl2 = iTPPreLoadListenerAidl;
                        if (iTPPreLoadListenerAidl2 != null) {
                            iTPPreLoadListenerAidl2.onPrepareError(i16, i17, str2);
                        }
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onPrepareError failed, error:" + th5);
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener
                public void onPrepareOK() {
                    try {
                        ITPPreLoadListenerAidl iTPPreLoadListenerAidl2 = iTPPreLoadListenerAidl;
                        if (iTPPreLoadListenerAidl2 != null) {
                            iTPPreLoadListenerAidl2.onPrepareOK();
                        }
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onPrepareOK failed, error:" + th5);
                    }
                }
            });
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public int startPlay(String str, TPDownloadParamAidl tPDownloadParamAidl, final ITPPlayListenerAidl iTPPlayListenerAidl) {
            try {
                return this.downloadProxy.startPlay(str, new TPDownloadParam(tPDownloadParamAidl.getUrlList(), tPDownloadParamAidl.getDlType(), tPDownloadParamAidl.getExtInfoMap()), new ITPPlayListener() { // from class: com.tencent.thumbplayer.core.downloadproxy.service.TPDownloadProxyService.DownloadProxy.1
                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public long getAdvRemainTime() {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl2 != null) {
                                return iTPPlayListenerAidl2.getAdvRemainTime();
                            }
                            return -1L;
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getAdvRemainTime failed, error:" + th5);
                            return -1L;
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public String getContentType(int i3, String str2) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl2 != null) {
                                return iTPPlayListenerAidl2.getContentType(i3, str2);
                            }
                            return "";
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getContentType key failed, error:" + th5);
                            return "";
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public int getCurrentPlayClipNo() {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl2 != null) {
                                return iTPPlayListenerAidl2.getCurrentPlayClipNo();
                            }
                            return -1;
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getCurrentPlayClipInfo failed, error:" + th5);
                            return -1;
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public long getCurrentPlayOffset() {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl2 != null) {
                                return iTPPlayListenerAidl2.getCurrentPlayOffset();
                            }
                            return -1L;
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getCurrentPlayOffset failed, error:" + th5);
                            return -1L;
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public long getCurrentPosition() {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl2 != null) {
                                return iTPPlayListenerAidl2.getCurrentPosition();
                            }
                            return -1L;
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getCurrentPosition failed, error:" + th5);
                            return -1L;
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public String getDataFilePath(int i3, String str2) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl2 != null) {
                                return iTPPlayListenerAidl2.getDataFilePath(i3, str2);
                            }
                            return "";
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getDataFilePath key failed, error:" + th5);
                            return "";
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public long getDataTotalSize(int i3, String str2) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl2 != null) {
                                return iTPPlayListenerAidl2.getDataTotalSize(i3, str2);
                            }
                            return -1L;
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getDataTotalSize key failed, error:" + th5);
                            return -1L;
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public Object getPlayInfo(long j3) {
                        try {
                            return iTPPlayListenerAidl.getPlayInfo(Long.toString(j3));
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayInfo type failed, error:" + th5);
                            return null;
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public long getPlayerBufferLength() {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl2 != null) {
                                return iTPPlayListenerAidl2.getPlayerBufferLength();
                            }
                            return -1L;
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayerBufferLength failed, error:" + th5);
                            return -1L;
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public void onDownloadCdnUrlExpired(Map<String, String> map) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl2 != null) {
                                iTPPlayListenerAidl2.onDownloadCdnUrlExpired(map);
                            }
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadCdnUrlExpired failed, error:" + th5);
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public void onDownloadCdnUrlInfoUpdate(String str2, String str3, String str4, String str5) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl2 != null) {
                                iTPPlayListenerAidl2.onDownloadCdnUrlInfoUpdate(str2, str3, str4, str5);
                            }
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadCdnUrlInfoUpdate failed, error:" + th5);
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public void onDownloadCdnUrlUpdate(String str2) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl2 != null) {
                                iTPPlayListenerAidl2.onDownloadCdnUrlUpdate(str2);
                            }
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadCdnUrlUpdate failed, error:" + th5);
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public void onDownloadError(int i3, int i16, String str2) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl2 != null) {
                                iTPPlayListenerAidl2.onDownloadError(i3, i16, str2);
                            }
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadError failed, error:" + th5);
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public void onDownloadFinish() {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl2 != null) {
                                iTPPlayListenerAidl2.onDownloadFinish();
                            }
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownlaodFinish failed, error:" + th5);
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public void onDownloadProgressUpdate(int i3, int i16, long j3, long j16, String str2) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl2 != null) {
                                iTPPlayListenerAidl2.onDownloadProgressUpdate(i3, i16, j3, j16, str2);
                            }
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownlaodProgressUpdate failed, error:" + th5);
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public void onDownloadProtocolUpdate(String str2, String str3) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl2 != null) {
                                iTPPlayListenerAidl2.onDownloadProtocolUpdate(str2, str3);
                            }
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadProtocolUpdate failed, error:" + th5);
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public void onDownloadStatusUpdate(int i3) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl2 != null) {
                                iTPPlayListenerAidl2.onDownloadStatusUpdate(i3);
                            }
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadStatusUpdate failed, error:" + th5);
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public void onPcdnDownloadFailed(String str2) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl2 != null) {
                                iTPPlayListenerAidl2.onPcdnDownloadFailed(str2);
                            }
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onPcdnDownloadFailed failed, error:" + th5.toString());
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public Object onPlayCallback(int i3, Object obj, Object obj2, Object obj3, Object obj4) {
                        try {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(obj);
                            arrayList.add(obj2);
                            arrayList.add(obj3);
                            arrayList.add(obj4);
                            ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl2 != null) {
                                iTPPlayListenerAidl2.onPlayCallback(i3, arrayList);
                                return null;
                            }
                            return null;
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onPlayCallback failed, error:" + th5);
                            return null;
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public void onQuicDownloadStatusUpdate(String str2) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl2 != null) {
                                iTPPlayListenerAidl2.onQuicDownloadStatusUpdate(str2);
                            }
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onQuicDownloadStatusUpdate failed, error:" + th5.toString());
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public int onReadData(int i3, String str2, long j3, long j16) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl2 != null) {
                                return iTPPlayListenerAidl2.onReadData(i3, str2, j3, j16);
                            }
                            return -1;
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onReadData key failed, error:" + th5);
                            return -1;
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public int onStartReadData(int i3, String str2, long j3, long j16) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl2 != null) {
                                return iTPPlayListenerAidl2.onStartReadData(i3, str2, j3, j16);
                            }
                            return -1;
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onStartReadData key failed, error:" + th5);
                            return -1;
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public int onStopReadData(int i3, String str2, int i16) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl2 = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl2 != null) {
                                return iTPPlayListenerAidl2.onStopReadData(i3, str2, i16);
                            }
                            return -1;
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onStopReadData key failed, error:" + th5);
                            return -1;
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public Object getPlayInfo(String str2) {
                        try {
                            return iTPPlayListenerAidl.getPlayInfo(str2);
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayInfo key failed, error:" + th5);
                            return null;
                        }
                    }
                });
            } catch (Throwable th5) {
                TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startPlay failed, error:" + th5);
                return -1;
            }
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public int startPreload(String str, TPDownloadParamAidl tPDownloadParamAidl, final ITPPreLoadListenerAidl iTPPreLoadListenerAidl) {
            return this.downloadProxy.startPreload(str, new TPDownloadParam(tPDownloadParamAidl.getUrlList(), tPDownloadParamAidl.getDlType(), tPDownloadParamAidl.getExtInfoMap()), new ITPPreLoadListener() { // from class: com.tencent.thumbplayer.core.downloadproxy.service.TPDownloadProxyService.DownloadProxy.3
                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener
                public void onPcdnDownloadFailed(String str2) {
                    try {
                        ITPPreLoadListenerAidl iTPPreLoadListenerAidl2 = iTPPreLoadListenerAidl;
                        if (iTPPreLoadListenerAidl2 != null) {
                            iTPPreLoadListenerAidl2.onPcdnDownloadFailed(str2);
                        }
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onPcdnDownloadFailed failed, error:" + th5.toString());
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener
                public void onPrepareDownloadProgressUpdate(int i3, int i16, long j3, long j16, String str2) {
                    try {
                        ITPPreLoadListenerAidl iTPPreLoadListenerAidl2 = iTPPreLoadListenerAidl;
                        if (iTPPreLoadListenerAidl2 != null) {
                            iTPPreLoadListenerAidl2.onPrepareDownloadProgressUpdate(i3, i16, j3, j16, str2);
                        }
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onPrepareDownloadProgressUpdate failed, error:" + th5);
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener
                public void onPrepareError(int i3, int i16, String str2) {
                    try {
                        ITPPreLoadListenerAidl iTPPreLoadListenerAidl2 = iTPPreLoadListenerAidl;
                        if (iTPPreLoadListenerAidl2 != null) {
                            iTPPreLoadListenerAidl2.onPrepareError(i3, i16, str2);
                        }
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onPrepareError failed, error:" + th5);
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener
                public void onPrepareOK() {
                    try {
                        ITPPreLoadListenerAidl iTPPreLoadListenerAidl2 = iTPPreLoadListenerAidl;
                        if (iTPPreLoadListenerAidl2 != null) {
                            iTPPreLoadListenerAidl2.onPrepareOK();
                        }
                    } catch (Throwable th5) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onPrepareOK failed, error:" + th5);
                    }
                }
            });
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public void startTask(int i3) {
            this.downloadProxy.startTask(i3);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public void stopPlay(int i3) {
            this.downloadProxy.stopPlay(i3);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public void stopPreload(int i3) {
            this.downloadProxy.stopPreload(i3);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public void updateTaskInfo(int i3, Map map) {
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    if (entry != null) {
                        try {
                            if (entry.getValue() != null) {
                                this.downloadProxy.updateTaskInfo(i3, (String) entry.getKey(), entry.getValue());
                            }
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "updateTaskInfo failed, error:" + th5);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes26.dex */
    private class DownloadProxyFactory extends TPDownloadProxyFactoryAidl.Stub {
        private final HashMap<Integer, ITPDownloadProxyAidl> mvTPDownloadProxyMap;

        DownloadProxyFactory() {
            this.mvTPDownloadProxyMap = new HashMap<>();
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
        public String getNativeVersion() {
            return TPDownloadProxyFactory.getNativeVersion();
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
        public synchronized ITPDownloadProxyAidl getTPDownloadProxy(int i3) {
            ITPDownloadProxyAidl iTPDownloadProxyAidl;
            iTPDownloadProxyAidl = this.mvTPDownloadProxyMap.get(Integer.valueOf(i3));
            if (iTPDownloadProxyAidl == null) {
                iTPDownloadProxyAidl = new DownloadProxy(i3);
                this.mvTPDownloadProxyMap.put(Integer.valueOf(i3), iTPDownloadProxyAidl);
            }
            return iTPDownloadProxyAidl;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
        public boolean isReadyForDownload() {
            return TPDownloadProxyFactory.isReadyForDownload();
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
        public boolean isReadyForPlay() {
            return TPDownloadProxyFactory.isReadyForPlay();
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
        public boolean pushEvent(int i3) {
            return TPDownloadProxyFactory.pushEvent(i3);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
        public void registerProxyInfoCallback(final ITPDownloadProxyInfoCallbackAidl iTPDownloadProxyInfoCallbackAidl) {
            TPDownloadProxyFactory.registerProxyInfoCallback(new ITPDownloadProxyInfoCallback() { // from class: com.tencent.thumbplayer.core.downloadproxy.service.TPDownloadProxyService.DownloadProxyFactory.1
                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxyInfoCallback
                public void OnNativeConfigUpdate(String str) {
                    try {
                        iTPDownloadProxyInfoCallbackAidl.OnNativeConfigUpdate(str);
                    } catch (Throwable th5) {
                        TPDLProxyLog.i(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "registerProxyInfoCallback aidl, error:" + th5);
                    }
                }
            });
        }
    }

    private boolean isExistMainProcess() {
        int i3;
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) {
                String str = runningAppProcessInfo.processName;
                if (!TextUtils.isEmpty(str) && str.equals(getPackageName())) {
                    int i16 = this.pid;
                    if (i16 != -1 && i16 != (i3 = runningAppProcessInfo.pid)) {
                        this.pid = i3;
                        return false;
                    }
                    this.pid = runningAppProcessInfo.pid;
                    TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "app main exist!");
                    return true;
                }
            }
        } catch (Throwable th5) {
            TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "isExistMainProcess failed, error:" + th5);
        }
        return false;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (this.downloadProxyFactory == null) {
            this.downloadProxyFactory = new DownloadProxyFactory();
        }
        TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "on bind!");
        isExistMainProcess();
        return this.downloadProxyFactory;
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "on rebind!");
        isExistMainProcess();
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        super.onStartCommand(intent, i3, i16);
        TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "on start command!");
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "on unbind!");
        super.onUnbind(intent);
        if (!isExistMainProcess()) {
            try {
                TPDownloadProxyNative.getInstance().stopAllDownload(3);
                TPListenerManager.getInstance().removeAllPlayListener();
                TPListenerManager.getInstance().removeAllPreLoadListener();
                return true;
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, th5.toString());
                return true;
            }
        }
        return true;
    }
}
