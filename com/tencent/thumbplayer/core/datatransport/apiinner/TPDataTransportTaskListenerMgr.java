package com.tencent.thumbplayer.core.datatransport.apiinner;

import android.net.Network;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportMessageInfo;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportCommonInfoListener;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportOfflineTaskMgr;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportPreloadTaskMgr;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr;
import com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDownloadProxyResourceLoaderListener;
import com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog;
import com.tencent.thumbplayer.core.datatransport.util.TPDataTransportLogFactory;
import com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPCGIRequester;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import com.tencent.thumbplayer.core.downloadproxy.utils.TVKThreadUtil;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.HashMap;

/* loaded from: classes26.dex */
public class TPDataTransportTaskListenerMgr {
    private static final int MSG_CONFIG_URL = 2011;
    private static final int MSG_CURRENT_CDN_URL = 5;
    private static final int MSG_CURRENT_CDN_URL_INFO = 6;
    private static final int MSG_DID_RELEASE_MEMORY = 2016;
    private static final int MSG_DOWNLOAD_PROTOCOL = 9;
    private static final int MSG_DOWNLOAD_STATUS = 8;
    private static final int MSG_ERROR = 4;
    private static final int MSG_FINISH = 3;
    private static final int MSG_LOW_DEFN_START_SWITCH_UP = 2026;
    private static final int MSG_M3U8_REFRESH = 2017;
    private static final int MSG_MULTI_NETWORK_CGI_FAIL = 2025;
    private static final int MSG_MULTI_NETWORK_CGI_SUCC = 2024;
    private static final int MSG_MULTI_NETWORK_LOW_SPEED = 2020;
    private static final int MSG_MULTI_NETWORK_STATUS = 2021;
    private static final int MSG_NATIVE_CONFIG_JSON_STR = 10;
    private static final int MSG_NOTIFY_FLV_PRELOAD_STATUS = 2009;
    private static final int MSG_NOTIFY_HTTP_HEADER = 2006;
    private static final int MSG_NOTIFY_LOSE_PACKAGE_CHECK = 2004;
    private static final int MSG_NOTIFY_M3U8_CONTENT = 2007;
    private static final int MSG_NOTIFY_PLAYER_SWITCH_DEFINITION = 2003;
    private static final int MSG_NOTIFY_SOCKET_FD = 2008;
    private static final int MSG_PLAY_VIDEO_NOT_FOUND = 101;
    private static final int MSG_PREPARE_FINISH = 50;
    private static final int MSG_PROGRESS = 2;
    private static final int MSG_PROXY_CANCEL_READ_DATA = 202;
    private static final int MSG_PROXY_GET_CONTENT_TYPE = 205;
    private static final int MSG_PROXY_GET_DATA_FILE_PATH = 204;
    private static final int MSG_PROXY_GET_DATA_TOTAL_SIZE = 203;
    private static final int MSG_PROXY_READ_DATA = 201;
    private static final int MSG_PROXY_START_READ_DATA = 200;
    private static final int MSG_QUIC_DOWNLOAD_STATUS = 3001;
    private static final int MSG_READ_INVALID = 2018;
    private static final int MSG_REPLAY_CDN = 2019;
    private static final int MSG_REPORT_QUIC_QUALITY = 3002;
    private static final int MSG_REPORT_URL = 2010;
    private static final int MSG_SIMULATE_LIVE_END_OF_CURRENT_CLIP = 2027;
    private static final int MSG_TAB_TEST_ID = 2014;
    private static final int MSG_UPDATE_NEXT_CLIP = 2023;
    private static final int MSG_URL_EXPIRED = 7;
    private static final int MSG_VERIFY_TOKEN_FAILED = 2022;
    private static final int MSG_WILL_RELEASE_MEMORY = 2015;
    private static final int MSG_WU_JI_CONFIG_URL = 2013;
    private static final long PLAYER_INFO_UPDATE_INTERVAL_MS = 500;
    private static final String THREAD_NAME = "TVKDL-Listener";
    private ITPDataTransportCommonInfoListener mCommonInfoListener;
    private Handler mHandler;
    private final ITPDataTransportLog mLogger;
    private HandlerThread mMsgHandlerThread;
    private String mNativeConfigStr;
    private Network mNetwork;
    private final TPListenerMgr<ITPDataTransportOfflineTaskMgr.OfflineTaskListener> mOfflineTaskListenerMgr;
    private final TPListenerMgr<ITPDataTransportPreloadTaskMgr.PreloadTaskListener> mPreloadTaskListenerMgr;
    private final TPListenerMgr<ITPDownloadProxyResourceLoaderListener> mResourceLoaderListenerMgr;
    private final TPListenerMgr<ITPDataTransportTaskMgr.TaskListener> mTaskListenerMgr;
    private long mUpdatePlayerInfoInterval;
    private final TPListenerMgr.INotifyCallback<ITPDataTransportTaskMgr.TaskListener> notifyCallback;
    private final Runnable updatePlayerInfo;

    /* loaded from: classes26.dex */
    public static class SingleHolder {
        private static final TPDataTransportTaskListenerMgr INSTANCE = new TPDataTransportTaskListenerMgr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchCallbackMessage(int i3, int i16, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        if (i16 <= 0) {
            dispatchCommonInfoMessage(i3, obj, obj2, obj3, obj4, obj5);
            return;
        }
        if (this.mTaskListenerMgr.containsListener(i16)) {
            dispatchTaskMessage(i3, i16, obj, obj2, obj3, obj4, obj5);
        } else if (this.mPreloadTaskListenerMgr.containsListener(i16)) {
            dispatchPreLoadMessage(i3, i16, obj, obj2, obj3, obj4, obj5);
        } else if (this.mOfflineTaskListenerMgr.containsListener(i16)) {
            dispatchOfflineDownloadMessage(i3, i16, obj, obj2, obj3, obj4, obj5);
        }
    }

    private void dispatchCommonInfoMessage(int i3, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        TPDataTransportMessageInfo tPDataTransportMessageInfo;
        int i16;
        ITPDataTransportCommonInfoListener iTPDataTransportCommonInfoListener;
        TPDataTransportMessageInfo tPDataTransportMessageInfo2;
        int i17 = -1;
        if (i3 != 10) {
            if (i3 != 3002) {
                if (i3 != 2015) {
                    if (i3 != 2016) {
                        tPDataTransportMessageInfo = null;
                        if (i17 < 0 && (iTPDataTransportCommonInfoListener = this.mCommonInfoListener) != null) {
                            iTPDataTransportCommonInfoListener.onCommonInfoUpdate(i17, tPDataTransportMessageInfo);
                            return;
                        }
                    }
                    i16 = 3;
                    tPDataTransportMessageInfo2 = new TPDataTransportMessageInfo(-1, 3, TPDLProxyUtils.byteArrayToString((byte[]) obj));
                } else {
                    i16 = 2;
                    tPDataTransportMessageInfo2 = new TPDataTransportMessageInfo(-1, 2, TPDLProxyUtils.byteArrayToString((byte[]) obj));
                }
            } else {
                i16 = 1;
                tPDataTransportMessageInfo2 = new TPDataTransportMessageInfo(-1, 1, TPDLProxyUtils.byteArrayToString((byte[]) obj));
            }
            tPDataTransportMessageInfo = tPDataTransportMessageInfo2;
        } else {
            this.mNativeConfigStr = TPDLProxyUtils.byteArrayToString((byte[]) obj);
            i16 = 0;
            tPDataTransportMessageInfo = new TPDataTransportMessageInfo(-1, 0, this.mNativeConfigStr);
        }
        i17 = i16;
        if (i17 < 0) {
        }
    }

    private void dispatchOfflineDownloadMessage(final int i3, int i16, final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5) {
        if (!this.mOfflineTaskListenerMgr.containsListener(i16)) {
            return;
        }
        this.mOfflineTaskListenerMgr.startNotify(i16, new TPListenerMgr.INotifyCallback<ITPDataTransportOfflineTaskMgr.OfflineTaskListener>() { // from class: com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportTaskListenerMgr.8
            @Override // com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr.INotifyCallback
            public void onNotify(int i17, ITPDataTransportOfflineTaskMgr.OfflineTaskListener offlineTaskListener) {
                if (offlineTaskListener == null) {
                    return;
                }
                int i18 = i3;
                if (i18 == 2) {
                    offlineTaskListener.onDownloadProgressUpdate(i17, TPDLProxyUtils.objectToInt(obj, 0), TPDLProxyUtils.objectToInt(obj2, 0), TPDLProxyUtils.objectToLong(obj3, 0L), TPDLProxyUtils.objectToLong(obj4, 0L), TPDLProxyUtils.byteArrayToString((byte[]) obj5));
                    return;
                }
                if (i18 == 3) {
                    offlineTaskListener.onDownloadFinished(i17);
                    return;
                }
                if (i18 == 4) {
                    offlineTaskListener.onDownloadError(i17, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), TPDLProxyUtils.byteArrayToString((byte[]) obj3));
                    return;
                }
                if (i18 != 7) {
                    return;
                }
                String byteArrayToString = TPDLProxyUtils.byteArrayToString((byte[]) obj);
                long objectToLong = TPDLProxyUtils.objectToLong(obj2, 0L);
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(byteArrayToString)) {
                    hashMap.put(TVKCommonParamEnum.REQ_PARAM_KEY_VKET_EXTTAG, byteArrayToString);
                    hashMap.put(TVKLiveRequestBuilder.RequestParamKey.RANDOM_NUMBER, String.valueOf(objectToLong));
                }
                offlineTaskListener.onCommonMessageCallback(i17, 1, new TPDataTransportMessageInfo(i17, 1, hashMap));
            }
        });
    }

    private void dispatchPreLoadMessage(final int i3, int i16, final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5) {
        if (!this.mPreloadTaskListenerMgr.containsListener(i16)) {
            return;
        }
        this.mPreloadTaskListenerMgr.startNotify(i16, new TPListenerMgr.INotifyCallback<ITPDataTransportPreloadTaskMgr.PreloadTaskListener>() { // from class: com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportTaskListenerMgr.7
            @Override // com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr.INotifyCallback
            public void onNotify(int i17, ITPDataTransportPreloadTaskMgr.PreloadTaskListener preloadTaskListener) {
                if (preloadTaskListener == null) {
                    return;
                }
                int i18 = i3;
                if (i18 == 2) {
                    preloadTaskListener.onDownloadProgressUpdate(i17, TPDLProxyUtils.objectToInt(obj, 0), TPDLProxyUtils.objectToInt(obj2, 0), TPDLProxyUtils.objectToLong(obj3, 0L), TPDLProxyUtils.objectToLong(obj4, 0L), TPDLProxyUtils.byteArrayToString((byte[]) obj5));
                } else if (i18 == 4) {
                    preloadTaskListener.onPrepareError(i17, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), TPDLProxyUtils.byteArrayToString((byte[]) obj3));
                } else {
                    if (i18 != 50) {
                        return;
                    }
                    preloadTaskListener.onPrepareFinished(i17);
                }
            }
        });
    }

    private void dispatchTaskMessage(final int i3, int i16, final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5) {
        if (!this.mTaskListenerMgr.containsListener(i16)) {
            return;
        }
        this.mTaskListenerMgr.startNotify(i16, new TPListenerMgr.INotifyCallback<ITPDataTransportTaskMgr.TaskListener>() { // from class: com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportTaskListenerMgr.4
            @Override // com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr.INotifyCallback
            public void onNotify(int i17, ITPDataTransportTaskMgr.TaskListener taskListener) {
                int i18 = i3;
                if (i18 != 101) {
                    if (i18 == 2009) {
                        int objectToInt = TPDLProxyUtils.objectToInt(obj, 0);
                        Object obj6 = obj2;
                        taskListener.onCommonMessageCallback(i17, 5, new TPDataTransportMessageInfo(i17, 5, Integer.valueOf(objectToInt), obj6 == null ? null : (byte[]) obj6, TPDLProxyUtils.byteArrayToString((byte[]) obj3), Integer.valueOf(TPDLProxyUtils.objectToInt(obj4, 0))));
                        return;
                    }
                    if (i18 == 2014) {
                        String byteArrayToString = TPDLProxyUtils.byteArrayToString((byte[]) obj);
                        String byteArrayToString2 = TPDLProxyUtils.byteArrayToString((byte[]) obj2);
                        taskListener.onCommonMessageCallback(i17, 8, new TPDataTransportMessageInfo(i17, 8, byteArrayToString, byteArrayToString2));
                        TPDataTransportTaskListenerMgr.this.mLogger.i("MSG_TAB_TESTID: " + byteArrayToString2);
                        return;
                    }
                    if (i18 == 3001) {
                        taskListener.onCommonMessageCallback(i17, 6, new TPDataTransportMessageInfo(i17, 6, TPDLProxyUtils.byteArrayToString((byte[]) obj)));
                        return;
                    }
                    if (i18 == 2003) {
                        taskListener.onCommonMessageCallback(i17, 2, new TPDataTransportMessageInfo(i17, 2, TPDLProxyUtils.byteArrayToString((byte[]) obj), TPDLProxyUtils.byteArrayToString((byte[]) obj2), Integer.valueOf(TPDLProxyUtils.objectToInt(obj3, 0))));
                        return;
                    }
                    if (i18 == 2004) {
                        final int objectToInt2 = TPDLProxyUtils.objectToInt(obj2, 0);
                        TVKThreadUtil.getScheduledExecutorServiceInstance().execute(new Runnable() { // from class: com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportTaskListenerMgr.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                TPDownloadProxyNative.getInstance().setGlobalOptionalConfigParam("lose_package_check_info", TPDLProxyUtils.losePackageCheck(objectToInt2));
                            }
                        });
                        return;
                    }
                    if (i18 == 2006) {
                        taskListener.onCommonMessageCallback(i17, 3, new TPDataTransportMessageInfo(i17, 3, TPDLProxyUtils.byteArrayToString((byte[]) obj)));
                        return;
                    }
                    if (i18 != 2007) {
                        switch (i18) {
                            case 2:
                                taskListener.onDownloadProgressUpdate(i17, TPDLProxyUtils.objectToInt(obj, 0), TPDLProxyUtils.objectToInt(obj2, 0), TPDLProxyUtils.objectToLong(obj3, 0L), TPDLProxyUtils.objectToLong(obj4, 0L), TPDLProxyUtils.byteArrayToString((byte[]) obj5));
                                return;
                            case 3:
                                taskListener.onDownloadFinished(i17);
                                return;
                            case 4:
                                taskListener.onDownloadError(i17, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), TPDLProxyUtils.byteArrayToString((byte[]) obj3));
                                return;
                            case 5:
                                taskListener.onCommonMessageCallback(i17, 13, new TPDataTransportMessageInfo(i17, 13, TPDLProxyUtils.byteArrayToString((byte[]) obj)));
                                return;
                            case 6:
                                taskListener.onCommonMessageCallback(i17, 14, new TPDataTransportMessageInfo(i17, 14, TPDLProxyUtils.byteArrayToString((byte[]) obj), TPDLProxyUtils.byteArrayToString((byte[]) obj2), TPDLProxyUtils.byteArrayToString((byte[]) obj3), TPDLProxyUtils.byteArrayToString((byte[]) obj4)));
                                return;
                            case 7:
                                break;
                            case 8:
                                taskListener.onCommonMessageCallback(i17, 15, new TPDataTransportMessageInfo(i17, 15, Integer.valueOf(TPDLProxyUtils.objectToInt(obj, 0))));
                                return;
                            case 9:
                                taskListener.onCommonMessageCallback(i17, 16, new TPDataTransportMessageInfo(i17, 16, TPDLProxyUtils.byteArrayToString((byte[]) obj), TPDLProxyUtils.byteArrayToString((byte[]) obj2)));
                                return;
                            default:
                                switch (i18) {
                                    case 2017:
                                        taskListener.onCommonMessageCallback(i17, 9, new TPDataTransportMessageInfo(i17, 9));
                                        return;
                                    case 2018:
                                        taskListener.onCommonMessageCallback(i17, 12, new TPDataTransportMessageInfo(i17, 12));
                                        return;
                                    case 2019:
                                        taskListener.onCommonMessageCallback(i17, 25, new TPDataTransportMessageInfo(i17, 25));
                                        return;
                                    case 2020:
                                        String byteArrayToString3 = TPDLProxyUtils.byteArrayToString((byte[]) obj);
                                        taskListener.onCommonMessageCallback(i17, 10, new TPDataTransportMessageInfo(i17, 10, byteArrayToString3));
                                        TPDataTransportTaskListenerMgr.this.mLogger.i("MULTI_NETWORK msg: " + i3 + ", info: " + byteArrayToString3);
                                        return;
                                    case 2021:
                                        String byteArrayToString4 = TPDLProxyUtils.byteArrayToString((byte[]) obj);
                                        taskListener.onCommonMessageCallback(i17, 11, new TPDataTransportMessageInfo(i17, 11, byteArrayToString4));
                                        TPDataTransportTaskListenerMgr.this.mLogger.i("MULTI_NETWORK msg: " + i3 + ", info: " + byteArrayToString4);
                                        return;
                                    case 2022:
                                        taskListener.onCommonMessageCallback(i17, 20, new TPDataTransportMessageInfo(i17, TPDLProxyUtils.objectToInt(obj, 0), 20));
                                        return;
                                    case 2023:
                                        taskListener.onCommonMessageCallback(i17, 21, new TPDataTransportMessageInfo(i17, 21));
                                        return;
                                    case 2024:
                                        taskListener.onCommonMessageCallback(i17, 22, new TPDataTransportMessageInfo(i17, 22, Integer.valueOf(TPDLProxyUtils.objectToInt(obj, 0)), TPDLProxyUtils.byteArrayToString((byte[]) obj2), (byte[]) obj3, TPDLProxyUtils.byteArrayToString((byte[]) obj5)));
                                        return;
                                    case TPDataTransportTaskListenerMgr.MSG_MULTI_NETWORK_CGI_FAIL /* 2025 */:
                                        taskListener.onCommonMessageCallback(i17, 23, new TPDataTransportMessageInfo(i17, 23, Integer.valueOf(TPDLProxyUtils.objectToInt(obj, 0)), TPDLProxyUtils.byteArrayToString((byte[]) obj2)));
                                        return;
                                    case 2026:
                                        taskListener.onCommonMessageCallback(i17, 24, new TPDataTransportMessageInfo(i17, 24));
                                        return;
                                    case TPDataTransportTaskListenerMgr.MSG_SIMULATE_LIVE_END_OF_CURRENT_CLIP /* 2027 */:
                                        taskListener.onCommonMessageCallback(i17, 26, new TPDataTransportMessageInfo(i17, 26));
                                        return;
                                    default:
                                        return;
                                }
                        }
                    } else {
                        taskListener.onCommonMessageCallback(i17, 4, new TPDataTransportMessageInfo(i17, 4, TPDLProxyUtils.byteArrayToString((byte[]) obj)));
                        return;
                    }
                }
                String byteArrayToString5 = TPDLProxyUtils.byteArrayToString((byte[]) obj);
                long objectToLong = TPDLProxyUtils.objectToLong(obj2, 0L);
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(byteArrayToString5)) {
                    hashMap.put(TVKCommonParamEnum.REQ_PARAM_KEY_VKET_EXTTAG, byteArrayToString5);
                    hashMap.put(TVKLiveRequestBuilder.RequestParamKey.RANDOM_NUMBER, String.valueOf(objectToLong));
                }
                taskListener.onCommonMessageCallback(i17, 1, new TPDataTransportMessageInfo(i17, 1, hashMap));
            }
        });
    }

    public static TPDataTransportTaskListenerMgr getInstance() {
        return SingleHolder.INSTANCE;
    }

    public void addOfflineTaskListener(int i3, ITPDataTransportOfflineTaskMgr.OfflineTaskListener offlineTaskListener) {
        this.mOfflineTaskListenerMgr.addTaskListener(i3, offlineTaskListener);
    }

    public void addPreloadTaskListener(int i3, ITPDataTransportPreloadTaskMgr.PreloadTaskListener preloadTaskListener) {
        this.mPreloadTaskListenerMgr.addTaskListener(i3, preloadTaskListener);
    }

    public void addResourceLoaderListener(int i3, ITPDownloadProxyResourceLoaderListener iTPDownloadProxyResourceLoaderListener) {
        this.mResourceLoaderListenerMgr.addTaskListener(i3, iTPDownloadProxyResourceLoaderListener);
    }

    public void addTaskListener(int i3, ITPDataTransportTaskMgr.TaskListener taskListener) {
        this.mTaskListenerMgr.addTaskListener(i3, taskListener);
    }

    public synchronized void handleCallbackMessage(final int i3, final int i16, final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5) {
        Handler handler = this.mHandler;
        if (handler == null) {
            return;
        }
        if (2008 == i3) {
            if (this.mNetwork == null) {
                this.mLogger.e("cellular_network, network is null");
                return;
            }
            String byteArrayToString = TPDLProxyUtils.byteArrayToString((byte[]) obj);
            int parseInt = Integer.parseInt(byteArrayToString);
            try {
                FileDescriptor fileDescriptor = new FileDescriptor();
                Field declaredField = FileDescriptor.class.getDeclaredField("descriptor");
                declaredField.setAccessible(true);
                declaredField.setInt(fileDescriptor, parseInt);
                this.mLogger.i("cellular_network, bind begin, sock fd: " + parseInt);
                this.mNetwork.bindSocket(fileDescriptor);
                this.mLogger.i("cellular_network, bind socket success, sock fd: " + parseInt);
            } catch (Throwable th5) {
                TPDownloadProxyNative.getInstance().setGlobalOptionalConfigParam("cellular_interface_id", String.valueOf(-1));
                this.mLogger.i("cellular_network, bind socket failed: " + th5);
            }
            this.mLogger.i("cellular_network, sock call back end, sock fd: " + parseInt + ", str_sock: " + byteArrayToString);
            return;
        }
        if (i3 != 2010 && i3 != 2011 && i3 != 2013) {
            handler.post(new Runnable() { // from class: com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportTaskListenerMgr.1
                @Override // java.lang.Runnable
                public void run() {
                    TPDataTransportTaskListenerMgr.this.dispatchCallbackMessage(i3, i16, obj, obj2, obj3, obj4, obj5);
                }
            });
        } else {
            TPCGIRequester.getInstance().addRequestItem(TPDLProxyUtils.byteArrayToString((byte[]) obj), i3);
        }
    }

    public int handleIntCallbackMessage(final int i3, int i16, final Object obj, final Object obj2, final Object obj3, Object obj4, Object obj5) {
        if (this.mHandler == null) {
            return -1;
        }
        final int[] iArr = {-1};
        this.mResourceLoaderListenerMgr.startNotify(i16, new TPListenerMgr.INotifyCallback<ITPDownloadProxyResourceLoaderListener>() { // from class: com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportTaskListenerMgr.2
            @Override // com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr.INotifyCallback
            public void onNotify(int i17, ITPDownloadProxyResourceLoaderListener iTPDownloadProxyResourceLoaderListener) {
                switch (i3) {
                    case 200:
                        iArr[0] = iTPDownloadProxyResourceLoaderListener.onStartReadData(i17, TPDLProxyUtils.byteArrayToString((byte[]) obj), TPDLProxyUtils.objectToLong(obj2, 0L), TPDLProxyUtils.objectToLong(obj3, -1L));
                        return;
                    case 201:
                        iArr[0] = iTPDownloadProxyResourceLoaderListener.onReadData(i17, TPDLProxyUtils.byteArrayToString((byte[]) obj), TPDLProxyUtils.objectToLong(obj2, 0L), TPDLProxyUtils.objectToInt(obj3, 0));
                        return;
                    case 202:
                        iArr[0] = iTPDownloadProxyResourceLoaderListener.onStopReadData(i17, TPDLProxyUtils.byteArrayToString((byte[]) obj), TPDLProxyUtils.objectToInt(obj2, 0));
                        return;
                    default:
                        return;
                }
            }
        });
        return iArr[0];
    }

    public String handleStringCallbackMessage(final int i3, int i16, final Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        if (this.mHandler == null) {
            return "";
        }
        final String[] strArr = {""};
        this.mResourceLoaderListenerMgr.startNotify(i16, new TPListenerMgr.INotifyCallback<ITPDownloadProxyResourceLoaderListener>() { // from class: com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportTaskListenerMgr.3
            @Override // com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr.INotifyCallback
            public void onNotify(int i17, ITPDownloadProxyResourceLoaderListener iTPDownloadProxyResourceLoaderListener) {
                switch (i3) {
                    case 203:
                        strArr[0] = String.valueOf(iTPDownloadProxyResourceLoaderListener.getDataTotalSize(i17, TPDLProxyUtils.byteArrayToString((byte[]) obj)));
                        return;
                    case 204:
                        strArr[0] = iTPDownloadProxyResourceLoaderListener.getDataFilePath(i17, TPDLProxyUtils.byteArrayToString((byte[]) obj));
                        return;
                    case 205:
                        strArr[0] = iTPDownloadProxyResourceLoaderListener.getContentType(i17, TPDLProxyUtils.byteArrayToString((byte[]) obj));
                        return;
                    default:
                        return;
                }
            }
        });
        return strArr[0];
    }

    public void initHandler() {
        if (this.mMsgHandlerThread == null) {
            synchronized (TPDataTransportTaskListenerMgr.class) {
                if (this.mMsgHandlerThread == null) {
                    this.mLogger.i("init new listener mgr");
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread(THREAD_NAME);
                    this.mMsgHandlerThread = baseHandlerThread;
                    baseHandlerThread.start();
                    Handler handler = new Handler(this.mMsgHandlerThread.getLooper());
                    this.mHandler = handler;
                    handler.postDelayed(this.updatePlayerInfo, this.mUpdatePlayerInfoInterval);
                }
            }
        }
    }

    public void removeAllTaskListener() {
        this.mTaskListenerMgr.clear();
        this.mPreloadTaskListenerMgr.clear();
    }

    public void removeResourceLoaderListener(int i3) {
        this.mResourceLoaderListenerMgr.removeTaskListener(i3);
    }

    public void removeTaskListener(int i3) {
        this.mTaskListenerMgr.removeTaskListener(i3);
        this.mPreloadTaskListenerMgr.removeTaskListener(i3);
        this.mOfflineTaskListenerMgr.removeTaskListener(i3);
    }

    public void setCommonInfoListener(ITPDataTransportCommonInfoListener iTPDataTransportCommonInfoListener) {
        if (iTPDataTransportCommonInfoListener == null) {
            return;
        }
        this.mCommonInfoListener = iTPDataTransportCommonInfoListener;
        if (!TextUtils.isEmpty(this.mNativeConfigStr)) {
            this.mLogger.i("setCommonInfoListener, native config update!");
            this.mCommonInfoListener.onCommonInfoUpdate(0, new TPDataTransportMessageInfo(-1, 0, this.mNativeConfigStr));
        }
    }

    public void setNetwork(Network network) {
        this.mLogger.i("cellular_network, set network");
        this.mNetwork = network;
    }

    public void setUpdatePlayerInfoInterval(int i3) {
        this.mUpdatePlayerInfoInterval = i3;
    }

    TPDataTransportTaskListenerMgr() {
        this.mUpdatePlayerInfoInterval = 500L;
        this.mLogger = TPDataTransportLogFactory.getInstance().getLogger("TPDataTransportTaskListenerMgr");
        this.mTaskListenerMgr = new TPListenerMgr<>("TaskListenerMgr");
        this.mPreloadTaskListenerMgr = new TPListenerMgr<>("PreloadTaskListenerMgr");
        this.mOfflineTaskListenerMgr = new TPListenerMgr<>("OfflineTaskListenerMgr");
        this.mResourceLoaderListenerMgr = new TPListenerMgr<>("ResourceLoaderListenerMgr");
        this.mNetwork = null;
        this.updatePlayerInfo = new Runnable() { // from class: com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportTaskListenerMgr.5
            @Override // java.lang.Runnable
            public void run() {
                TPDataTransportTaskListenerMgr.this.mTaskListenerMgr.startNotify(TPDataTransportTaskListenerMgr.this.notifyCallback);
                TPDataTransportTaskListenerMgr.this.mHandler.postDelayed(TPDataTransportTaskListenerMgr.this.updatePlayerInfo, TPDataTransportTaskListenerMgr.this.mUpdatePlayerInfoInterval);
            }
        };
        this.notifyCallback = new TPListenerMgr.INotifyCallback<ITPDataTransportTaskMgr.TaskListener>() { // from class: com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportTaskListenerMgr.6
            @Override // com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr.INotifyCallback
            public void onNotify(int i3, ITPDataTransportTaskMgr.TaskListener taskListener) {
                try {
                    int currentPosition = (int) (taskListener.getCurrentPosition(i3) / 1000);
                    int playerBufferLength = (int) taskListener.getPlayerBufferLength(i3);
                    int remainTimeBeforePlayMs = (int) (taskListener.getRemainTimeBeforePlayMs(i3) / 1000);
                    TPDownloadProxyNative.getInstance().updateTaskInfo(i3, "taskinfo_play_offset", String.valueOf(taskListener.getCurrentPlayOffset(i3)));
                    TPDownloadProxyNative.getInstance().updatePlayerPlayMsg(i3, currentPosition, playerBufferLength, remainTimeBeforePlayMs);
                } catch (Throwable th5) {
                    TPDataTransportTaskListenerMgr.this.mLogger.e("update error:" + th5);
                }
            }
        };
    }
}
