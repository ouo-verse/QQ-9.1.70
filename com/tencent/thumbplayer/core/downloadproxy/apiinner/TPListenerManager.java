package com.tencent.thumbplayer.core.downloadproxy.apiinner;

import android.net.Network;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportTaskListenerMgr;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxyInfoCallback;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPOfflineDownloadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPCGIRequester;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import com.tencent.thumbplayer.core.downloadproxy.utils.TVKThreadUtil;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes26.dex */
public class TPListenerManager {
    private static final int DEFAULT_UPDATE_PLAYER_INFO_INTERVAL = 1000;
    private static final String FILE_NAME = "TPListenerManager";
    private static final int MSG_CALLBACK_MSG_REPORT = 3000;
    private static final int MSG_CONFIG_URL = 2011;
    private static final int MSG_CURRENT_CDN_URL = 5;
    private static final int MSG_CURRENT_CDN_URL_INFO = 6;
    private static final int MSG_DELETE_CACHE_FINISHED = 4001;
    private static final int MSG_DID_RELEASE_MEMORY = 2016;
    private static final int MSG_DOWNLOAD_PROTOCOL = 9;
    private static final int MSG_DOWNLOAD_STATUS = 8;
    private static final int MSG_ERROR = 4;
    private static final int MSG_FINISH = 3;
    private static final int MSG_M3U8_REFRESH = 2017;
    private static final int MSG_MULTI_NETWORK_LOW_SPEED = 2020;
    private static final int MSG_MULTI_NETWORK_STATUS = 2021;
    private static final int MSG_NATIVE_CONFIG_JSON_STR = 10;
    private static final int MSG_NOTIFY_FLV_PRELOAD_STATUS = 2009;
    private static final int MSG_NOTIFY_HTTP_HEADER = 2006;
    private static final int MSG_NOTIFY_LOSE_PACKAGE_CEHCK = 2004;
    private static final int MSG_NOTIFY_M3U8_CONTENT = 2007;
    private static final int MSG_NOTIFY_PLAYER_SWITCH_DEFINITION = 2003;
    private static final int MSG_NOTIFY_SOCKET_FD = 2008;
    private static final int MSG_PCDN_TS_FAILED = 3003;
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
    private static final int MSG_REPORT_QUIC_QUALITY = 3002;
    private static final int MSG_REPORT_URL = 2010;
    private static final int MSG_TAB_TESTID = 2014;
    private static final int MSG_URL_EXPIRED = 7;
    private static final int MSG_VERIFY_TOKEN_FAILED = 2022;
    private static final int MSG_WILL_RELEASE_MEMORY = 2015;
    private static final int MSG_WUJI_CONFIG_URL = 2013;
    private static final String THREAD_NAME = "TVKDL-Listener";
    private ITPDownloadListener mITPDownloadListener;
    private Handler mMsgHandler;
    private HandlerThread mMsgHandlerThread;
    private String mNativeConfigStr;
    private Network mNetwork;
    private final Map<Integer, ITPOfflineDownloadListener> mOfflineDownloadListenerMap;
    private final Map<Integer, ITPPlayListener> mPlayListenerMap;
    private final Map<Integer, ITPPreLoadListener> mPreLoadListenerMap;
    private final List<ITPDownloadProxyInfoCallback> mProxyInfoCallback;
    private final Runnable updatePlayerInfo;
    private int updatePlayerInfoINterval;
    private static final Object PLAY_LISTENER_MAP_MUTEX = new Object();
    private static final Object PRELOAD_LISTENER_MAP_MUTEX = new Object();
    private static final Object OFFLINE_LISTENER_MAP_MUTEX = new Object();
    private static final Object PROXY_INFO_CALLBACK_MAP_MUTEX = new Object();

    /* loaded from: classes26.dex */
    private static class SingletonHolder {
        private static final TPListenerManager INSTANCE = new TPListenerManager();

        SingletonHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchCallbackMessage(int i3, int i16, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        if (i3 == 10) {
            this.mNativeConfigStr = TPDLProxyUtils.byteArrayToString((byte[]) obj);
            synchronized (PROXY_INFO_CALLBACK_MAP_MUTEX) {
                for (ITPDownloadProxyInfoCallback iTPDownloadProxyInfoCallback : this.mProxyInfoCallback) {
                    TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "native config callback");
                    iTPDownloadProxyInfoCallback.OnNativeConfigUpdate(this.mNativeConfigStr);
                }
            }
            return;
        }
        ITPPlayListener playlistener = getPlaylistener(i16);
        if (playlistener != null) {
            dispatchPlayMessage(playlistener, i3, i16, obj, obj2, obj3, obj4, obj5);
            return;
        }
        ITPPreLoadListener preLoadListener = getPreLoadListener(i16);
        if (preLoadListener != null) {
            dispatchPreLoadMessage(preLoadListener, i3, i16, obj, obj2, obj3, obj4, obj5);
            return;
        }
        ITPOfflineDownloadListener offlineDownloadListener = getOfflineDownloadListener(i16);
        if (offlineDownloadListener != null) {
            dispatchOfflineDownloadMessage(offlineDownloadListener, i3, i16, obj, obj2, obj3, obj4, obj5);
            return;
        }
        if (this.mITPDownloadListener != null) {
            if (i3 != 2015) {
                if (i3 != 2016) {
                    if (i3 != 3000) {
                        if (i3 != 3002) {
                            if (i3 == 4001) {
                                this.mITPDownloadListener.deleteCacheFinished(TPDLProxyUtils.byteArrayToString((byte[]) obj));
                                return;
                            }
                            return;
                        }
                        this.mITPDownloadListener.onQuicQualityReportUpdate(TPDLProxyUtils.byteArrayToString((byte[]) obj));
                        return;
                    }
                    this.mITPDownloadListener.onDownloadInfoReportUpdate(TPDLProxyUtils.byteArrayToString((byte[]) obj));
                    return;
                }
                this.mITPDownloadListener.didReleaseMemory(TPDLProxyUtils.byteArrayToString((byte[]) obj));
                return;
            }
            this.mITPDownloadListener.willReleaseMemory(TPDLProxyUtils.byteArrayToString((byte[]) obj));
        }
    }

    private void dispatchOfflineDownloadMessage(ITPOfflineDownloadListener iTPOfflineDownloadListener, int i3, int i16, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        if (iTPOfflineDownloadListener == null) {
            return;
        }
        switch (i3) {
            case 2:
                iTPOfflineDownloadListener.onDownloadProgressUpdate(TPDLProxyUtils.objectToInt(obj, 0), TPDLProxyUtils.objectToInt(obj2, 0), TPDLProxyUtils.objectToLong(obj3, 0L), TPDLProxyUtils.objectToLong(obj4, 0L), TPDLProxyUtils.byteArrayToString((byte[]) obj5));
                return;
            case 3:
                iTPOfflineDownloadListener.onDownloadFinish();
                return;
            case 4:
                iTPOfflineDownloadListener.onDownloadError(((Integer) obj).intValue(), ((Integer) obj2).intValue(), TPDLProxyUtils.byteArrayToString((byte[]) obj3));
                return;
            case 5:
                iTPOfflineDownloadListener.onDownloadCdnUrlUpdate(TPDLProxyUtils.byteArrayToString((byte[]) obj));
                return;
            case 6:
                iTPOfflineDownloadListener.onDownloadCdnUrlInfoUpdate(TPDLProxyUtils.byteArrayToString((byte[]) obj), TPDLProxyUtils.byteArrayToString((byte[]) obj2), TPDLProxyUtils.byteArrayToString((byte[]) obj3), TPDLProxyUtils.byteArrayToString((byte[]) obj4));
                return;
            case 7:
                String byteArrayToString = TPDLProxyUtils.byteArrayToString((byte[]) obj);
                long objectToLong = TPDLProxyUtils.objectToLong(obj2, 0L);
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(byteArrayToString)) {
                    hashMap.put(TVKCommonParamEnum.REQ_PARAM_KEY_VKET_EXTTAG, byteArrayToString);
                    hashMap.put(TVKLiveRequestBuilder.RequestParamKey.RANDOM_NUMBER, String.valueOf(objectToLong));
                }
                iTPOfflineDownloadListener.onDownloadCdnUrlExpired(hashMap);
                return;
            case 8:
                iTPOfflineDownloadListener.onDownloadStatusUpdate(TPDLProxyUtils.objectToInt(obj, 0));
                return;
            case 9:
                iTPOfflineDownloadListener.onDownloadProtocolUpdate(TPDLProxyUtils.byteArrayToString((byte[]) obj), TPDLProxyUtils.byteArrayToString((byte[]) obj2));
                return;
            default:
                return;
        }
    }

    private void dispatchPlayMessage(ITPPlayListener iTPPlayListener, int i3, int i16, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        Object obj6;
        if (iTPPlayListener == null) {
            return;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 101) {
                    if (i3 != 2009) {
                        if (i3 != 2014) {
                            if (i3 != 3001) {
                                if (i3 != 3003) {
                                    if (i3 != 2003) {
                                        if (i3 != 2004) {
                                            if (i3 != 2006) {
                                                if (i3 != 2007) {
                                                    if (i3 != 2017) {
                                                        if (i3 != 2018) {
                                                            switch (i3) {
                                                                case 5:
                                                                    iTPPlayListener.onDownloadCdnUrlUpdate(TPDLProxyUtils.byteArrayToString((byte[]) obj));
                                                                    break;
                                                                case 6:
                                                                    iTPPlayListener.onDownloadCdnUrlInfoUpdate(TPDLProxyUtils.byteArrayToString((byte[]) obj), TPDLProxyUtils.byteArrayToString((byte[]) obj2), TPDLProxyUtils.byteArrayToString((byte[]) obj3), TPDLProxyUtils.byteArrayToString((byte[]) obj4));
                                                                    break;
                                                                case 7:
                                                                    String byteArrayToString = TPDLProxyUtils.byteArrayToString((byte[]) obj);
                                                                    long objectToLong = TPDLProxyUtils.objectToLong(obj2, 0L);
                                                                    Map<String, String> hashMap = new HashMap<>();
                                                                    if (!TextUtils.isEmpty(byteArrayToString)) {
                                                                        hashMap.put(TVKCommonParamEnum.REQ_PARAM_KEY_VKET_EXTTAG, byteArrayToString);
                                                                        hashMap.put(TVKLiveRequestBuilder.RequestParamKey.RANDOM_NUMBER, String.valueOf(objectToLong));
                                                                    }
                                                                    iTPPlayListener.onDownloadCdnUrlExpired(hashMap);
                                                                    break;
                                                                case 8:
                                                                    iTPPlayListener.onDownloadStatusUpdate(TPDLProxyUtils.objectToInt(obj, 0));
                                                                    break;
                                                                case 9:
                                                                    iTPPlayListener.onDownloadProtocolUpdate(TPDLProxyUtils.byteArrayToString((byte[]) obj), TPDLProxyUtils.byteArrayToString((byte[]) obj2));
                                                                    break;
                                                                default:
                                                                    switch (i3) {
                                                                        case 2020:
                                                                            String byteArrayToString2 = TPDLProxyUtils.byteArrayToString((byte[]) obj);
                                                                            iTPPlayListener.onPlayCallback(10, byteArrayToString2, null, null, null);
                                                                            TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "MULTI_NETWORK msg: " + i3 + ", info: " + byteArrayToString2);
                                                                            break;
                                                                        case 2021:
                                                                            String byteArrayToString3 = TPDLProxyUtils.byteArrayToString((byte[]) obj);
                                                                            iTPPlayListener.onPlayCallback(11, byteArrayToString3, null, null, null);
                                                                            TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "MULTI_NETWORK msg: " + i3 + ", info: " + byteArrayToString3);
                                                                            break;
                                                                        case 2022:
                                                                            iTPPlayListener.onPlayCallback(13, Integer.valueOf(TPDLProxyUtils.objectToInt(obj, 0)), null, null, null);
                                                                            break;
                                                                    }
                                                            }
                                                        } else {
                                                            iTPPlayListener.onPlayCallback(12, "", null, null, null);
                                                        }
                                                    } else {
                                                        iTPPlayListener.onPlayCallback(9, "", null, null, null);
                                                    }
                                                } else {
                                                    iTPPlayListener.onPlayCallback(4, TPDLProxyUtils.byteArrayToString((byte[]) obj), null, null, null);
                                                }
                                            } else {
                                                iTPPlayListener.onPlayCallback(3, TPDLProxyUtils.byteArrayToString((byte[]) obj), null, null, null);
                                            }
                                            return;
                                        }
                                        final int objectToInt = TPDLProxyUtils.objectToInt(obj2, 0);
                                        TVKThreadUtil.getScheduledExecutorServiceInstance().execute(new Runnable() { // from class: com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager.3
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                TPDownloadProxyNative.getInstance().setUserData("lose_package_check_info", TPDLProxyUtils.losePackageCheck(objectToInt));
                                            }
                                        });
                                        return;
                                    }
                                    iTPPlayListener.onPlayCallback(2, TPDLProxyUtils.byteArrayToString((byte[]) obj), TPDLProxyUtils.byteArrayToString((byte[]) obj2), Integer.valueOf(TPDLProxyUtils.objectToInt(obj3, 0)), null);
                                    return;
                                }
                                String byteArrayToString4 = TPDLProxyUtils.byteArrayToString((byte[]) obj);
                                TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onPcdnDownloadFailed: " + byteArrayToString4);
                                iTPPlayListener.onPcdnDownloadFailed(byteArrayToString4);
                                return;
                            }
                            iTPPlayListener.onQuicDownloadStatusUpdate(TPDLProxyUtils.byteArrayToString((byte[]) obj));
                            return;
                        }
                        Object byteArrayToString5 = TPDLProxyUtils.byteArrayToString((byte[]) obj);
                        String byteArrayToString6 = TPDLProxyUtils.byteArrayToString((byte[]) obj2);
                        iTPPlayListener.onPlayCallback(8, byteArrayToString5, byteArrayToString6, null, null);
                        TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "MSG_TAB_TESTID: " + byteArrayToString6);
                        return;
                    }
                    int objectToInt2 = TPDLProxyUtils.objectToInt(obj, 0);
                    if (obj2 == null) {
                        obj6 = null;
                    } else {
                        obj6 = (byte[]) obj2;
                    }
                    iTPPlayListener.onPlayCallback(5, Integer.valueOf(objectToInt2), obj6, TPDLProxyUtils.byteArrayToString((byte[]) obj3), Integer.valueOf(TPDLProxyUtils.objectToInt(obj4, 0)));
                    return;
                }
                String byteArrayToString7 = TPDLProxyUtils.byteArrayToString((byte[]) obj);
                long objectToLong2 = TPDLProxyUtils.objectToLong(obj2, 0L);
                HashMap hashMap2 = new HashMap();
                if (!TextUtils.isEmpty(byteArrayToString7)) {
                    hashMap2.put(TVKCommonParamEnum.REQ_PARAM_KEY_VKET_EXTTAG, byteArrayToString7);
                    hashMap2.put(TVKLiveRequestBuilder.RequestParamKey.RANDOM_NUMBER, String.valueOf(objectToLong2));
                }
                iTPPlayListener.onPlayCallback(1, hashMap2, null, null, null);
                return;
            }
            iTPPlayListener.onDownloadFinish();
            return;
        }
        iTPPlayListener.onDownloadProgressUpdate(TPDLProxyUtils.objectToInt(obj, 0), TPDLProxyUtils.objectToInt(obj2, 0), TPDLProxyUtils.objectToLong(obj3, 0L), TPDLProxyUtils.objectToLong(obj4, 0L), TPDLProxyUtils.byteArrayToString((byte[]) obj5));
    }

    private void dispatchPreLoadMessage(ITPPreLoadListener iTPPreLoadListener, int i3, int i16, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        if (iTPPreLoadListener == null) {
            return;
        }
        if (i3 != 2) {
            if (i3 != 4) {
                if (i3 != 50) {
                    if (i3 == 3003) {
                        String byteArrayToString = TPDLProxyUtils.byteArrayToString((byte[]) obj);
                        TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onPcdnDownloadFailed: " + byteArrayToString);
                        iTPPreLoadListener.onPcdnDownloadFailed(byteArrayToString);
                        return;
                    }
                    return;
                }
                iTPPreLoadListener.onPrepareOK();
                return;
            }
            iTPPreLoadListener.onPrepareError(((Integer) obj).intValue(), ((Integer) obj2).intValue(), TPDLProxyUtils.byteArrayToString((byte[]) obj3));
            return;
        }
        iTPPreLoadListener.onPrepareDownloadProgressUpdate(TPDLProxyUtils.objectToInt(obj, 0), TPDLProxyUtils.objectToInt(obj2, 0), TPDLProxyUtils.objectToLong(obj3, 0L), TPDLProxyUtils.objectToLong(obj4, 0L), TPDLProxyUtils.byteArrayToString((byte[]) obj5));
    }

    public static TPListenerManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public ITPOfflineDownloadListener getOfflineDownloadListener(int i3) {
        ITPOfflineDownloadListener iTPOfflineDownloadListener;
        synchronized (OFFLINE_LISTENER_MAP_MUTEX) {
            iTPOfflineDownloadListener = this.mOfflineDownloadListenerMap.get(Integer.valueOf(i3));
        }
        return iTPOfflineDownloadListener;
    }

    public ITPPlayListener getPlaylistener(int i3) {
        ITPPlayListener iTPPlayListener;
        synchronized (PLAY_LISTENER_MAP_MUTEX) {
            iTPPlayListener = this.mPlayListenerMap.get(Integer.valueOf(i3));
        }
        return iTPPlayListener;
    }

    public ITPPreLoadListener getPreLoadListener(int i3) {
        ITPPreLoadListener iTPPreLoadListener;
        synchronized (PRELOAD_LISTENER_MAP_MUTEX) {
            iTPPreLoadListener = this.mPreLoadListenerMap.get(Integer.valueOf(i3));
        }
        return iTPPreLoadListener;
    }

    public synchronized void handleCallbackMessage(final int i3, final int i16, final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5) {
        Handler handler = this.mMsgHandler;
        if (handler == null) {
            return;
        }
        if (2008 == i3) {
            if (this.mNetwork == null) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "cellular_network, network is null");
                return;
            }
            String byteArrayToString = TPDLProxyUtils.byteArrayToString((byte[]) obj);
            int parseInt = Integer.parseInt(byteArrayToString);
            try {
                FileDescriptor fileDescriptor = new FileDescriptor();
                Field declaredField = FileDescriptor.class.getDeclaredField("descriptor");
                declaredField.setAccessible(true);
                declaredField.setInt(fileDescriptor, parseInt);
                TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "cellular_network, bind begin, sock fd: " + parseInt);
                this.mNetwork.bindSocket(fileDescriptor);
                TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "cellular_network, bind socket success, sock fd: " + parseInt);
            } catch (Throwable th5) {
                TPDownloadProxyNative.getInstance().setUserData("cellular_interface_id", "-1");
                TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "cellular_network, bind socket failed: " + th5);
            }
            TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "cellular_network, sock call back end, sock fd: " + parseInt + ", str_sock: " + byteArrayToString);
            return;
        }
        if (i3 != 2011 && i3 != 2013) {
            handler.post(new Runnable() { // from class: com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager.2
                @Override // java.lang.Runnable
                public void run() {
                    TPListenerManager.this.dispatchCallbackMessage(i3, i16, obj, obj2, obj3, obj4, obj5);
                }
            });
        } else {
            TPCGIRequester.getInstance().addRequestItem(TPDLProxyUtils.byteArrayToString((byte[]) obj), i3);
        }
    }

    public int handleIntCallbackMessage(int i3, int i16, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        ITPPlayListener playlistener = getPlaylistener(i16);
        if (playlistener != null) {
            if (i3 == 200) {
                return playlistener.onStartReadData(i16, TPDLProxyUtils.byteArrayToString((byte[]) obj), TPDLProxyUtils.objectToLong(obj2, 0L), TPDLProxyUtils.objectToLong(obj3, -1L));
            }
            if (i3 == 202) {
                return playlistener.onStopReadData(i16, TPDLProxyUtils.byteArrayToString((byte[]) obj), TPDLProxyUtils.objectToInt(obj2, 0));
            }
            if (i3 != 201) {
                return 0;
            }
            return playlistener.onReadData(i16, TPDLProxyUtils.byteArrayToString((byte[]) obj), TPDLProxyUtils.objectToLong(obj2, 0L), TPDLProxyUtils.objectToInt(obj3, 0));
        }
        return TPDataTransportTaskListenerMgr.getInstance().handleIntCallbackMessage(i3, i16, obj, obj2, obj3, obj4, obj5);
    }

    public String handleStringCallbackMessage(int i3, int i16, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        ITPPlayListener playlistener = getPlaylistener(i16);
        if (playlistener != null) {
            if (i3 == 205) {
                return playlistener.getContentType(i16, TPDLProxyUtils.byteArrayToString((byte[]) obj));
            }
            if (i3 == 203) {
                return String.valueOf(playlistener.getDataTotalSize(i16, TPDLProxyUtils.byteArrayToString((byte[]) obj)));
            }
            if (i3 == 204) {
                return playlistener.getDataFilePath(i16, TPDLProxyUtils.byteArrayToString((byte[]) obj));
            }
            return "";
        }
        return TPDataTransportTaskListenerMgr.getInstance().handleStringCallbackMessage(i3, i16, obj, obj2, obj3, obj4, obj5);
    }

    public void initHandler() {
        if (this.mMsgHandlerThread == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread(THREAD_NAME);
            this.mMsgHandlerThread = baseHandlerThread;
            baseHandlerThread.start();
            Handler handler = new Handler(this.mMsgHandlerThread.getLooper());
            this.mMsgHandler = handler;
            handler.postDelayed(this.updatePlayerInfo, this.updatePlayerInfoINterval);
        }
    }

    public void registerDownloadProxyCallback(ITPDownloadProxyInfoCallback iTPDownloadProxyInfoCallback) {
        synchronized (PROXY_INFO_CALLBACK_MAP_MUTEX) {
            if (!this.mProxyInfoCallback.contains(iTPDownloadProxyInfoCallback)) {
                this.mProxyInfoCallback.add(iTPDownloadProxyInfoCallback);
            }
        }
        if (!TextUtils.isEmpty(this.mNativeConfigStr)) {
            TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "cellular_network, set network");
            iTPDownloadProxyInfoCallback.OnNativeConfigUpdate(this.mNativeConfigStr);
        }
    }

    public void removeAllPlayListener() {
        synchronized (PLAY_LISTENER_MAP_MUTEX) {
            this.mPlayListenerMap.clear();
        }
    }

    public void removeAllPreLoadListener() {
        synchronized (PRELOAD_LISTENER_MAP_MUTEX) {
            this.mPreLoadListenerMap.clear();
        }
    }

    public void removeOfflineDownloadListener(int i3) {
        if (i3 > 0) {
            synchronized (OFFLINE_LISTENER_MAP_MUTEX) {
                this.mOfflineDownloadListenerMap.remove(Integer.valueOf(i3));
            }
        }
    }

    public void removePlayListener(int i3) {
        if (i3 > 0) {
            synchronized (PLAY_LISTENER_MAP_MUTEX) {
                this.mPlayListenerMap.remove(Integer.valueOf(i3));
            }
        }
    }

    public void removePreLoadListener(int i3) {
        if (i3 > 0) {
            synchronized (PRELOAD_LISTENER_MAP_MUTEX) {
                this.mPreLoadListenerMap.remove(Integer.valueOf(i3));
            }
        }
    }

    public void setDownloadListener(ITPDownloadListener iTPDownloadListener) {
        this.mITPDownloadListener = iTPDownloadListener;
    }

    public void setITPDownloadListener(ITPDownloadListener iTPDownloadListener) {
        this.mITPDownloadListener = iTPDownloadListener;
    }

    public void setNetwork(Network network) {
        TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "cellular_network, set network");
        this.mNetwork = network;
    }

    public void setOfflineDownloadListener(int i3, ITPOfflineDownloadListener iTPOfflineDownloadListener) {
        if (i3 > 0 && iTPOfflineDownloadListener != null) {
            synchronized (OFFLINE_LISTENER_MAP_MUTEX) {
                this.mOfflineDownloadListenerMap.put(Integer.valueOf(i3), iTPOfflineDownloadListener);
            }
        }
    }

    public void setPlayListener(int i3, ITPPlayListener iTPPlayListener) {
        if (i3 > 0 && iTPPlayListener != null) {
            synchronized (PLAY_LISTENER_MAP_MUTEX) {
                this.mPlayListenerMap.put(Integer.valueOf(i3), iTPPlayListener);
            }
        }
    }

    public void setPreLoadListener(int i3, ITPPreLoadListener iTPPreLoadListener) {
        if (i3 > 0 && iTPPreLoadListener != null) {
            synchronized (PRELOAD_LISTENER_MAP_MUTEX) {
                this.mPreLoadListenerMap.put(Integer.valueOf(i3), iTPPreLoadListener);
            }
        }
    }

    public void setUpdatePlayerInfoInterval(int i3) {
        this.updatePlayerInfoINterval = i3;
    }

    public void unregisterDownloadProxyCallback(ITPDownloadProxyInfoCallback iTPDownloadProxyInfoCallback) {
        synchronized (PROXY_INFO_CALLBACK_MAP_MUTEX) {
            this.mProxyInfoCallback.remove(iTPDownloadProxyInfoCallback);
        }
    }

    TPListenerManager() {
        this.updatePlayerInfoINterval = 1000;
        this.mNetwork = null;
        this.mITPDownloadListener = null;
        this.mPlayListenerMap = new HashMap();
        this.mPreLoadListenerMap = new HashMap();
        this.mOfflineDownloadListenerMap = new HashMap();
        this.mProxyInfoCallback = new ArrayList();
        this.updatePlayerInfo = new Runnable() { // from class: com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager.1
            @Override // java.lang.Runnable
            public void run() {
                Map map;
                synchronized (TPListenerManager.PLAY_LISTENER_MAP_MUTEX) {
                    map = TPListenerManager.this.mPlayListenerMap;
                }
                try {
                    for (Map.Entry entry : map.entrySet()) {
                        int intValue = ((Integer) entry.getKey()).intValue();
                        ITPPlayListener iTPPlayListener = (ITPPlayListener) entry.getValue();
                        int currentPosition = (int) (iTPPlayListener.getCurrentPosition() / 1000);
                        int playerBufferLength = (int) iTPPlayListener.getPlayerBufferLength();
                        int advRemainTime = (int) (iTPPlayListener.getAdvRemainTime() / 1000);
                        TPDownloadProxyNative.getInstance().updateTaskInfo(intValue, "taskinfo_play_offset", String.valueOf(iTPPlayListener.getCurrentPlayOffset()));
                        TPDownloadProxyNative.getInstance().updatePlayerPlayMsg(intValue, currentPosition, playerBufferLength, advRemainTime);
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        };
    }
}
