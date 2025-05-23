package com.tencent.oskplayer.proxy;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.cache.Cache;
import com.tencent.oskplayer.cache.CacheDataSource;
import com.tencent.oskplayer.cache.CacheListener;
import com.tencent.oskplayer.cache.LeastRecentlyUsedCacheEvictor;
import com.tencent.oskplayer.cache.SimpleCache;
import com.tencent.oskplayer.datasource.DataSource;
import com.tencent.oskplayer.datasource.DataSpec;
import com.tencent.oskplayer.datasource.DefaultDataSourceBuilder;
import com.tencent.oskplayer.datasource.DefaultHttpDataSource;
import com.tencent.oskplayer.datasource.DownloadListener;
import com.tencent.oskplayer.datasource.FileDataSource;
import com.tencent.oskplayer.datasource.HttpDataSource;
import com.tencent.oskplayer.datasource.HttpHeader;
import com.tencent.oskplayer.datasource.IllegalDataSpecException;
import com.tencent.oskplayer.datasource.VideoDownloadListener;
import com.tencent.oskplayer.proxy.VideoRequestManager;
import com.tencent.oskplayer.report.VideoResultCode;
import com.tencent.oskplayer.support.util.OskFile;
import com.tencent.oskplayer.util.HttpParser;
import com.tencent.oskplayer.util.PassOnVideoType;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.oskplayer.util.Predicate;
import com.tencent.oskplayer.util.SecretUtils;
import com.tencent.oskplayer.util.StorageUtil;
import com.tencent.oskplayer.util.ThreadUtils;
import com.tencent.oskplayer.util.VideoSpeedReport;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.InetAddress;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes22.dex */
public class VideoProxy {
    public static final String LOG_TAG_PREFIX = "VideoProxy/";
    private static final String MTYPE = "qzone_video_player";
    public static final String PARAM_DATASOURCE_TYPE = "dataSourceType";
    public static final String PARAM_ENABLE_CACHE = "enableCache";
    private static final String PARAM_EXTRAHEADER = "eh";
    private static final String PARAM_MTYPE = "mType";
    public static final String PARAM_PREPERRED_CONTENT_TYPE = "preferredContentType";
    private static final String PARAM_PRIORITY = "p";
    private static final String PARAM_TOKEN = "t";
    public static final String PARAM_URL = "v";
    public static final String PARAM_UUID = "uuid";
    private static final String PROXY_HOST = "0.0.0.0";
    public static final String PROXY_SERVER = "http://127.0.0.1";
    private static final String TAG = "VideoProxy";
    private static final String TAG_SEP = "/";
    private static final String USER_AGENT = "com.qzone.player-v20150909";
    public static final String VALUE_CACHE_ENABLED = "1";
    public static final String VALUE_CACHE_NOT_ENABLED = "0";
    public static final String VALUE_CACHE_PLACEHOLDER = "[VALUE_CACHE_PLACEHOLDER]";
    public static final String VALUE_CACHE_PLACEHOLDER_REG = "\\[VALUE_CACHE_PLACEHOLDER\\]";
    public static final String VALUE_CONTENT_TYPE_VIDEO_M3U8 = "application/vnd.apple.mpegurl";
    public static final String VALUE_CONTENT_TYPE_VIDEO_MP4 = "video/mp4";
    public static final String VALUE_CONTENT_TYPE_VIDEO_MPEG_TS = "video/MP2T";
    public static final String VALUE_DATASOURCE_DEFAULT = "1";
    public static final String VALUE_DATASOURCE_TENCENT = "0";
    public static final String VALUE_DATASOURCE_UNKNOWN = "-1";
    public static final int VALUE_PRIORITY_NOT_SPECIFIED = -1;
    public static final int VALUE_PRIORITY_PLAY = 90;
    public static final int VALUE_PRIORITY_PRELOAD = 10;
    public static final int _UNKNOWN = -1;
    private static final int sExtraHeaderCollectionMax = 100;
    private Cache cache;
    private final ExecutorService executorService;
    private volatile boolean isShutdown;
    private int serverPort;
    private ServerSocket serverSocket;
    private ITcDataSourceUtils tcDataSourceUtils;
    private final VideoRequestManager videoRequestManager;
    private Thread waitConnectionThread;
    private static AtomicInteger VIDEO_UUID = new AtomicInteger(10000);
    private static AtomicInteger PLAY_LIST_ID = new AtomicInteger(10000);
    private boolean isPauseTcStorageIO = false;
    private boolean isSecretEnable = true;
    private Map<String, CacheListener> mCacheListenerMap = new ConcurrentHashMap();
    private Map<String, LivePlayListInfo> mLivePlayListInfo = new ConcurrentHashMap();
    private Map<String, PlayListInfo> mPlayListInfo = new ConcurrentHashMap();
    private Map<String, LivePlayListInfo> mErrorLivePlayListInfo = new ConcurrentHashMap();
    private boolean isCacheProviderLocal = PlayerConfig.g().isCacheProviderLocal();
    private int mRecvDataTreshold = 1000;
    private Set<HttpHeader> mExtraHeaderCollection = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap(5, 0.75f)));
    public int mProxyExceptionCount = 0;
    public final int PROXY_EXCEPTION_COUNT_MAX = 3;
    private Map<String, CacheReadListener> cacheReadListenerMap = new HashMap();
    private Map<String, HttpErrorListener> httpUrlErrorListenerMap = new HashMap();
    private Map<String, HttpErrorListener> uuidErrorListenerMap = new HashMap();
    private ConcurrentHashMap<String, HttpRetryLogic> httpRetryLogicMap = new ConcurrentHashMap<>(8, 0.75f, 2);
    private Set<String> videoDownloadHashSet = Collections.synchronizedSet(new HashSet());

    /* loaded from: classes22.dex */
    public interface CacheReadListener {
        void onCachedBytesRead(long j3, long j16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public final class DataSourceOpenResult {
        DataSource dataSource;
        boolean isHandled;
        File localPlayListFile;
        long retCode;

        DataSourceOpenResult() {
            this.isHandled = false;
            this.dataSource = null;
            this.retCode = -1L;
            this.localPlayListFile = null;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes22.dex */
    public @interface DataSourceType {
    }

    /* loaded from: classes22.dex */
    public interface HttpErrorListener {
        public static final String MSG_KEY_ERR_MSG = "error_msg";
        public static final String MSG_KEY_PRIORITY = "priority";

        void onHttpError(String str, String str2, int i3, Map<String, Object> map, Map<String, List<String>> map2, int i16, long j3, long j16);
    }

    /* loaded from: classes22.dex */
    public interface OnConnectionChangeListener {
        void onConnectionChange(boolean z16, InputStream inputStream, OutputStream outputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public static class PreloadInfo {
        String localUrl;
        String originalUrl;

        PreloadInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class ProbeContentRequestListener implements VideoRequestManager.RequestListener {
        CountDownLatch latch;
        public int mFlags = 0;
        String uuid;

        public ProbeContentRequestListener(String str, CountDownLatch countDownLatch) {
            this.uuid = str;
            this.latch = countDownLatch;
        }

        public int getFlag() {
            return this.mFlags;
        }

        @Override // com.tencent.oskplayer.proxy.VideoRequestManager.RequestListener
        public void onBeforeRequestRemove(VideoRequest videoRequest) {
            if (videoRequest.getUuid().equals(this.uuid)) {
                this.mFlags = videoRequest.getContentFormatFlag();
                this.latch.countDown();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public final class SocketHandler implements Runnable {
        CountDownLatch signal;
        Socket socket;
        Future<?> task;
        VideoRequest videoRequest;

        public SocketHandler(Socket socket, CountDownLatch countDownLatch) {
            this.socket = socket;
            this.signal = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.signal.await();
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
            VideoRequest videoRequest = new VideoRequest();
            this.videoRequest = videoRequest;
            videoRequest.setTask(this.task);
            VideoProxy.this.processSocket(this.socket, this.videoRequest);
        }

        public void setTask(Future<?> future) {
            this.task = future;
        }
    }

    /* loaded from: classes22.dex */
    private final class WaitRequestRunnable implements Runnable {
        private CountDownLatch startSignal;

        public WaitRequestRunnable(CountDownLatch countDownLatch) {
            this.startSignal = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.startSignal.countDown();
            VideoProxy.this.waitForRequest();
        }
    }

    public VideoProxy() {
        if (this.isCacheProviderLocal) {
            final String cacheDir = PlayerConfig.g().getCacheDir();
            if (TextUtils.isEmpty(cacheDir)) {
                this.cache = null;
            } else {
                final long min = Math.min(StorageUtil.getDirAvailableSpace(cacheDir), PlayerConfig.g().getCacheMaxBytes());
                PlayerUtils.log(4, TAG, "cache availableSpace=" + min);
                final LeastRecentlyUsedCacheEvictor leastRecentlyUsedCacheEvictor = new LeastRecentlyUsedCacheEvictor(min);
                ThreadUtils.submitTask(new Runnable() { // from class: com.tencent.oskplayer.proxy.VideoProxy.1
                    @Override // java.lang.Runnable
                    public void run() {
                        long j3;
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            j3 = StorageUtil.getDirUsedSpace(cacheDir);
                        } catch (OutOfMemoryError unused) {
                            PlayerUtils.log(5, VideoProxy.TAG, "calculate cacheSize OOM usedSpace set to 0");
                            j3 = 0;
                        }
                        long min2 = Math.min(min + j3, PlayerConfig.g().getCacheMaxBytes());
                        ((LeastRecentlyUsedCacheEvictor) leastRecentlyUsedCacheEvictor).setMaxBytes(min2);
                        PlayerUtils.log(4, VideoProxy.TAG, "update cacheSize " + min2 + ", timecost=" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                }, TAG);
                this.cache = new SimpleCache(new File(cacheDir), leastRecentlyUsedCacheEvictor);
            }
            PlayerUtils.log(4, TAG, "cache provider is local ");
        } else {
            PlayerUtils.log(4, TAG, "cache provider is tc");
        }
        PlayerUtils.log(4, TAG, "cache dir is:" + PlayerConfig.g().getCacheDir());
        this.videoRequestManager = new VideoRequestManager();
        this.executorService = new ThreadUtils.FlexibleSizeExecutor(PlayerConfig.g().getCoreClientCount(), PlayerConfig.g().getMaxClientCount(), 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        try {
            ServerSocket serverSocket = new ServerSocket(PlayerUtils.findFreePort(5), PlayerConfig.g().getMaxClientCount(), InetAddress.getByName(PROXY_HOST));
            this.serverSocket = serverSocket;
            this.serverPort = serverSocket.getLocalPort();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            BaseThread baseThread = new BaseThread(new WaitRequestRunnable(countDownLatch), "video_proxy_wait_for_connection_thread");
            this.waitConnectionThread = baseThread;
            baseThread.start();
            countDownLatch.await();
            PlayerUtils.log(4, TAG, "proxy start success");
        } catch (IOException e16) {
            this.executorService.shutdown();
            PlayerUtils.log(6, TAG, "proxy start failed " + PlayerUtils.getPrintableStackTrace(e16));
        } catch (IllegalStateException e17) {
            this.executorService.shutdown();
            PlayerUtils.log(6, TAG, "proxy start failed " + PlayerUtils.getPrintableStackTrace(e17));
        } catch (InterruptedException e18) {
            this.executorService.shutdown();
            PlayerUtils.log(6, TAG, "proxy start failed " + PlayerUtils.getPrintableStackTrace(e18));
        }
    }

    private void cancelPreloadRequestsSync(String str, VideoRequest videoRequest) {
        ArrayList<VideoRequest> idleVideoRequest = getIdleVideoRequest(getPreloadVideoRequestByVideoKey(str));
        String str2 = LOG_TAG_PREFIX + videoRequest.getSeqNum();
        if (idleVideoRequest.size() > 0) {
            final CountDownLatch countDownLatch = new CountDownLatch(idleVideoRequest.size());
            PlayerUtils.log(5, str2, "start auto cancel preload requests, request count " + countDownLatch.getCount());
            VideoCancelListener videoCancelListener = new VideoCancelListener() { // from class: com.tencent.oskplayer.proxy.VideoProxy.2
                @Override // com.tencent.oskplayer.proxy.VideoCancelListener
                public void onVideoCancelSuccess(VideoRequest videoRequest2) {
                    countDownLatch.countDown();
                }

                @Override // com.tencent.oskplayer.proxy.VideoCancelListener
                public void onVideoCancelStart(VideoRequest videoRequest2) {
                }

                @Override // com.tencent.oskplayer.proxy.VideoCancelListener
                public void onVideoCancelProceed(VideoRequest videoRequest2, int i3) {
                }
            };
            Iterator<VideoRequest> it = idleVideoRequest.iterator();
            while (it.hasNext()) {
                it.next().cancel(videoCancelListener);
            }
            try {
                countDownLatch.await(2000, TimeUnit.MILLISECONDS);
                if (getPreloadVideoRequestByVideoKey(str).size() == 0) {
                    PlayerUtils.log(5, str2, "auto cancel preload requests success");
                } else {
                    PlayerUtils.log(5, str2, "auto cancel preload requests timeout, max wait time is 2000 seconds");
                }
            } catch (InterruptedException e16) {
                PlayerUtils.log(5, str2, "auto cancel preload requests interrupted " + e16.toString());
            }
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* JADX WARN: Not initialized variable reg: 19, insn: 0x0933: MOVE (r21 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r19 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:380:0x092f */
    private java.io.File generateLocalPlaylistFile(com.tencent.oskplayer.datasource.DataSource r58, com.tencent.oskplayer.datasource.DataSpec r59, java.lang.String r60, com.tencent.oskplayer.proxy.VideoRequest r61) throws com.tencent.oskplayer.proxy.LivePlayListException {
        /*
            Method dump skipped, instructions count: 2464
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.oskplayer.proxy.VideoProxy.generateLocalPlaylistFile(com.tencent.oskplayer.datasource.DataSource, com.tencent.oskplayer.datasource.DataSpec, java.lang.String, com.tencent.oskplayer.proxy.VideoRequest):java.io.File");
    }

    private HttpHeader getExtraHeaderById(int i3) {
        for (HttpHeader httpHeader : this.mExtraHeaderCollection) {
            if (i3 == httpHeader.getId()) {
                return httpHeader;
            }
        }
        return null;
    }

    private int getFakeHttpStatus(Throwable th5) {
        if (th5.toString().toLowerCase().contains("unexpected end of stream")) {
            return 6;
        }
        if (th5.getCause() != null && (th5.getCause() instanceof SocketTimeoutException)) {
            return 14;
        }
        return 7;
    }

    private ArrayList<VideoRequest> getIdleVideoRequest(ArrayList<VideoRequest> arrayList) {
        ArrayList<VideoRequest> arrayList2 = new ArrayList<>();
        Iterator<VideoRequest> it = arrayList.iterator();
        while (it.hasNext()) {
            VideoRequest next = it.next();
            if (next.isIdle()) {
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    private ArrayList<VideoRequest> getPreloadVideoRequestByVideoKey(String str) {
        return this.videoRequestManager.getVideoRequestByVideoKey(str, 10);
    }

    public static String getSourceUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            PlayerUtils.log(6, TAG, "getSourceUrl: httpUrl is empty");
            return str;
        }
        if (!str.contains(PROXY_SERVER)) {
            return str;
        }
        try {
            return Uri.parse(str).getQueryParameter("v");
        } catch (Exception e16) {
            PlayerUtils.log(6, TAG, "getSourceUrl: Exception=" + e16);
            return str;
        }
    }

    private DataSourceOpenResult openDataSource(DataSource dataSource, DataSpec dataSpec, String str, String str2, VideoRequest videoRequest, Socket socket, String str3, long j3, long j16, long j17) throws Exception {
        int i3;
        String str4;
        int i16;
        String str5;
        DataSourceOpenResult dataSourceOpenResult;
        DataSourceOpenResult dataSourceOpenResult2 = new DataSourceOpenResult();
        dataSourceOpenResult2.retCode = j3;
        PlayerUtils.log(4, str2, "dataSpec=" + dataSpec.toString());
        if (!PlayerUtils.isHLSStream(str)) {
            dataSource.open(dataSpec);
        } else {
            try {
                File generateLocalPlaylistFile = generateLocalPlaylistFile(dataSource, dataSpec, str, videoRequest);
                dataSourceOpenResult2.localPlayListFile = generateLocalPlaylistFile;
                if (generateLocalPlaylistFile != null) {
                    PlayerUtils.log(4, str2, "localPlaylist generate success " + dataSourceOpenResult2.localPlayListFile.toString());
                    FileDataSource fileDataSource = new FileDataSource() { // from class: com.tencent.oskplayer.proxy.VideoProxy.3
                        @Override // com.tencent.oskplayer.datasource.FileDataSource, com.tencent.oskplayer.datasource.DataSource
                        public FileType getFileType() {
                            return FileType.getFileType(PlayerConfig.CONTENT_TYPE_HLS_PLAYLIST);
                        }
                    };
                    fileDataSource.open(new DataSpec(Uri.fromFile(dataSourceOpenResult2.localPlayListFile), dataSpec.absoluteStreamPosition, dataSpec.position, dataSpec.length, dataSpec.key, dataSpec.flags, dataSpec.uuid, dataSpec.priority));
                    dataSourceOpenResult2.dataSource = fileDataSource;
                } else {
                    if (videoRequest.getPrority() != 90) {
                        str5 = " is interrupted";
                        dataSourceOpenResult = dataSourceOpenResult2;
                    } else {
                        PlayerUtils.getDownloadRetCode(18, j16);
                        HttpErrorListener httpErrorListener = this.httpUrlErrorListenerMap.get(str3);
                        HttpErrorListener httpErrorListener2 = this.uuidErrorListenerMap.get(videoRequest.getUuid());
                        if (httpErrorListener != null) {
                            str5 = " is interrupted";
                            dataSourceOpenResult = dataSourceOpenResult2;
                            httpErrorListener.onHttpError(videoRequest.getUuid(), str, 18, null, new HashMap(), (int) (System.currentTimeMillis() - j17), dataSourceOpenResult2.retCode, j16);
                        } else {
                            str5 = " is interrupted";
                            dataSourceOpenResult = dataSourceOpenResult2;
                        }
                        if (httpErrorListener2 != null) {
                            httpErrorListener2.onHttpError(videoRequest.getUuid(), str, 18, null, new HashMap(), (int) (System.currentTimeMillis() - j17), dataSourceOpenResult.retCode, j16);
                        }
                    }
                    PlayerUtils.log(4, str2, "localPlaylist generate fail, see previous logs");
                    try {
                        socket.close();
                    } catch (IOException unused) {
                    }
                    this.videoRequestManager.removeRequest(videoRequest);
                    if (videoRequest.isCancelProcceed()) {
                        videoRequest.setStoppedReason(256);
                        PlayerUtils.log(4, str2, videoRequest + str5);
                        videoRequest.enterCancelSuccessState();
                    } else {
                        videoRequest.setStoppedReason(257);
                    }
                    videoRequest.setIsStopped(true);
                    dataSourceOpenResult.isHandled = true;
                    return dataSourceOpenResult;
                }
            } catch (LivePlayListException e16) {
                PlayerUtils.log(6, LOG_TAG_PREFIX + videoRequest.getSeqNum(), "livePlayListException " + e16);
                if (e16.getCause() != null) {
                    if (!(e16.getCause() instanceof HttpDataSource.InterruptConnectServerException) && !(e16.getCause() instanceof HttpDataSource.InterruptReadException)) {
                        i3 = 17;
                    } else {
                        i3 = 0;
                    }
                } else {
                    i3 = 16;
                }
                if (videoRequest.getPrority() != 90 || i3 == 0) {
                    str4 = " is interrupted";
                    i16 = 256;
                } else {
                    dataSourceOpenResult2.retCode = PlayerUtils.getDownloadRetCode(i3, j16);
                    HttpErrorListener httpErrorListener3 = this.httpUrlErrorListenerMap.get(str3);
                    HttpErrorListener httpErrorListener4 = this.uuidErrorListenerMap.get(videoRequest.getUuid());
                    if (httpErrorListener3 == null) {
                        str4 = " is interrupted";
                        i16 = 256;
                    } else {
                        str4 = " is interrupted";
                        i16 = 256;
                        httpErrorListener3.onHttpError(videoRequest.getUuid(), str, i3, null, new HashMap(), (int) (System.currentTimeMillis() - j17), dataSourceOpenResult2.retCode, j16);
                    }
                    if (httpErrorListener4 != null) {
                        httpErrorListener4.onHttpError(videoRequest.getUuid(), str, i3, null, new HashMap(), (int) (System.currentTimeMillis() - j17), dataSourceOpenResult2.retCode, j16);
                    }
                }
                try {
                    socket.close();
                } catch (IOException unused2) {
                }
                this.videoRequestManager.removeRequest(videoRequest);
                if (videoRequest.isCancelProcceed()) {
                    videoRequest.setStoppedReason(i16);
                    PlayerUtils.log(4, str2, videoRequest + str4);
                    videoRequest.enterCancelSuccessState();
                } else {
                    videoRequest.setStoppedReason(257);
                }
                videoRequest.setIsStopped(true);
                dataSourceOpenResult2.isHandled = true;
                return dataSourceOpenResult2;
            }
        }
        return dataSourceOpenResult2;
    }

    private void preloadMediasAsync(ArrayList<PreloadInfo> arrayList, String str) {
        preloadMediasAsync(arrayList, 2, -1L, null, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d2 A[Catch: Exception -> 0x023f, TryCatch #0 {Exception -> 0x023f, blocks: (B:3:0x0035, B:5:0x003b, B:8:0x0042, B:10:0x004d, B:11:0x0050, B:13:0x0093, B:15:0x009b, B:17:0x00a3, B:24:0x00d2, B:26:0x00d8, B:27:0x00f5, B:28:0x00f8, B:30:0x011d, B:33:0x0127, B:34:0x012c, B:36:0x014c, B:38:0x0155, B:39:0x015d, B:41:0x016c, B:43:0x0196, B:45:0x019c, B:46:0x01b8, B:48:0x01d9, B:51:0x01e5, B:62:0x0219, B:63:0x022a, B:64:0x022b, B:66:0x0172, B:68:0x017e, B:69:0x0182, B:71:0x018e, B:72:0x0192, B:73:0x015a, B:75:0x00b3, B:54:0x01ed, B:56:0x0200, B:59:0x0207, B:60:0x0218, B:21:0x00ab), top: B:2:0x0035, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x011d A[Catch: Exception -> 0x023f, TryCatch #0 {Exception -> 0x023f, blocks: (B:3:0x0035, B:5:0x003b, B:8:0x0042, B:10:0x004d, B:11:0x0050, B:13:0x0093, B:15:0x009b, B:17:0x00a3, B:24:0x00d2, B:26:0x00d8, B:27:0x00f5, B:28:0x00f8, B:30:0x011d, B:33:0x0127, B:34:0x012c, B:36:0x014c, B:38:0x0155, B:39:0x015d, B:41:0x016c, B:43:0x0196, B:45:0x019c, B:46:0x01b8, B:48:0x01d9, B:51:0x01e5, B:62:0x0219, B:63:0x022a, B:64:0x022b, B:66:0x0172, B:68:0x017e, B:69:0x0182, B:71:0x018e, B:72:0x0192, B:73:0x015a, B:75:0x00b3, B:54:0x01ed, B:56:0x0200, B:59:0x0207, B:60:0x0218, B:21:0x00ab), top: B:2:0x0035, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x019c A[Catch: Exception -> 0x023f, TryCatch #0 {Exception -> 0x023f, blocks: (B:3:0x0035, B:5:0x003b, B:8:0x0042, B:10:0x004d, B:11:0x0050, B:13:0x0093, B:15:0x009b, B:17:0x00a3, B:24:0x00d2, B:26:0x00d8, B:27:0x00f5, B:28:0x00f8, B:30:0x011d, B:33:0x0127, B:34:0x012c, B:36:0x014c, B:38:0x0155, B:39:0x015d, B:41:0x016c, B:43:0x0196, B:45:0x019c, B:46:0x01b8, B:48:0x01d9, B:51:0x01e5, B:62:0x0219, B:63:0x022a, B:64:0x022b, B:66:0x0172, B:68:0x017e, B:69:0x0182, B:71:0x018e, B:72:0x0192, B:73:0x015a, B:75:0x00b3, B:54:0x01ed, B:56:0x0200, B:59:0x0207, B:60:0x0218, B:21:0x00ab), top: B:2:0x0035, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01e5 A[Catch: Exception -> 0x023f, TRY_LEAVE, TryCatch #0 {Exception -> 0x023f, blocks: (B:3:0x0035, B:5:0x003b, B:8:0x0042, B:10:0x004d, B:11:0x0050, B:13:0x0093, B:15:0x009b, B:17:0x00a3, B:24:0x00d2, B:26:0x00d8, B:27:0x00f5, B:28:0x00f8, B:30:0x011d, B:33:0x0127, B:34:0x012c, B:36:0x014c, B:38:0x0155, B:39:0x015d, B:41:0x016c, B:43:0x0196, B:45:0x019c, B:46:0x01b8, B:48:0x01d9, B:51:0x01e5, B:62:0x0219, B:63:0x022a, B:64:0x022b, B:66:0x0172, B:68:0x017e, B:69:0x0182, B:71:0x018e, B:72:0x0192, B:73:0x015a, B:75:0x00b3, B:54:0x01ed, B:56:0x0200, B:59:0x0207, B:60:0x0218, B:21:0x00ab), top: B:2:0x0035, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void processSocket(Socket socket, VideoRequest videoRequest) {
        String str;
        int i3;
        int i16;
        OutputStream outputStream;
        int i17;
        String str2 = LOG_TAG_PREFIX + videoRequest.getSeqNum();
        String str3 = str2 + "/";
        PlayerUtils.log(3, str2, "process socket");
        try {
            InputStream inputStream = socket.getInputStream();
            if (inputStream == null) {
                PlayerUtils.log(6, str2, "socket inputstream is null");
                return;
            }
            OnConnectionChangeListener onConnectionChangeListener = PlayerConfig.g().getOnConnectionChangeListener();
            if (onConnectionChangeListener != null) {
                onConnectionChangeListener.onConnectionChange(true, inputStream, null);
            }
            HttpParser httpParser = new HttpParser(inputStream, str3);
            String requestMethod = httpParser.getRequestMethod();
            String param = httpParser.getParam("v");
            String param2 = httpParser.getParam("p");
            String param3 = httpParser.getParam("uuid");
            String param4 = httpParser.getParam(PARAM_ENABLE_CACHE);
            String param5 = httpParser.getParam(PARAM_DATASOURCE_TYPE);
            String param6 = httpParser.getParam(PARAM_PREPERRED_CONTENT_TYPE);
            String param7 = httpParser.getParam("t");
            String param8 = httpParser.getParam(PARAM_EXTRAHEADER);
            if (param == null) {
                PlayerUtils.log(6, str2, "invalid request detected, sourceUrl is null");
                return;
            }
            if (!TextUtils.isEmpty(param8) && TextUtils.isDigitsOnly(param8)) {
                try {
                    i16 = Integer.parseInt(param8, 10);
                    str = param7;
                    i3 = -1;
                } catch (Exception unused) {
                    StringBuilder sb5 = new StringBuilder();
                    str = param7;
                    sb5.append("invalid extraHeaderId ");
                    sb5.append(param8);
                    PlayerUtils.log(6, str2, sb5.toString());
                }
                if (i16 != i3) {
                    HttpHeader extraHeaderById = getExtraHeaderById(i16);
                    if (extraHeaderById == null) {
                        PlayerUtils.log(6, str2, "ehid=" + i16 + " is invalid");
                    } else {
                        videoRequest.setExtraHeader(extraHeaderById);
                    }
                }
                String rawHeaders = httpParser.getRawHeaders();
                PlayerUtils.log(4, str2, PlayerUtils.removeLineBreaks("mediaplayer request header:" + rawHeaders, null));
                outputStream = socket.getOutputStream();
                if (outputStream != null) {
                    PlayerUtils.log(6, str2, "socket outputstream is null");
                    return;
                }
                if (onConnectionChangeListener != null) {
                    onConnectionChangeListener.onConnectionChange(true, null, outputStream);
                }
                long[] rangeOffset = HttpParser.getRangeOffset(rawHeaders);
                videoRequest.setRequestMethod(requestMethod);
                videoRequest.setSourceUrl(param);
                videoRequest.setRangeStart(rangeOffset[0]);
                videoRequest.setRangeEnd(rangeOffset[1]);
                videoRequest.setUuid(param3);
                if (!TextUtils.isEmpty(param4) && param4.equals("1")) {
                    videoRequest.setCacheEnabled(true);
                } else {
                    videoRequest.setCacheEnabled(false);
                }
                videoRequest.setDataSourceType(param5);
                videoRequest.setPreferredContentType(param6);
                videoRequest.setLogTag(str3);
                if (TextUtils.isEmpty(param2)) {
                    videoRequest.setPrority(-1);
                } else if (param2.equals(String.valueOf(90))) {
                    videoRequest.setPrority(90);
                } else if (param2.equals(String.valueOf(10))) {
                    videoRequest.setPrority(10);
                } else {
                    i17 = -1;
                    videoRequest.setPrority(-1);
                    if (videoRequest.getPrority() == i17) {
                        PlayerUtils.log(5, str2, "videoRequest " + videoRequest + " priority is not specified");
                    }
                    PlayerUtils.log(4, str2, "dump videoRequest=" + videoRequest);
                    cancelPreloadRequestsSync(videoRequest.getVideoKey(), videoRequest);
                    if (this.isSecretEnable && PlayerConfig.g().isEnableProxySecret()) {
                        if (str != null) {
                            PlayerUtils.log(6, str2, "invalid request detected, token is null");
                            return;
                        }
                        String decode = SecretUtils.decode(SecretUtils.DES, SecretUtils.getRandomNum(), str);
                        String parseVideoKey = PlayerUtils.parseVideoKey(param);
                        if (decode == null || !decode.equals(parseVideoKey)) {
                            PlayerUtils.log(6, str2, "invalid request detected, key is illegal");
                            throw new ProxyException("token required", 100);
                        }
                    }
                    this.videoRequestManager.addRequest(param, videoRequest);
                    writeResponse(socket, param, outputStream, videoRequest, inputStream);
                    return;
                }
                i17 = -1;
                if (videoRequest.getPrority() == i17) {
                }
                PlayerUtils.log(4, str2, "dump videoRequest=" + videoRequest);
                cancelPreloadRequestsSync(videoRequest.getVideoKey(), videoRequest);
                if (this.isSecretEnable) {
                    if (str != null) {
                    }
                }
                this.videoRequestManager.addRequest(param, videoRequest);
                writeResponse(socket, param, outputStream, videoRequest, inputStream);
                return;
            }
            str = param7;
            i3 = -1;
            i16 = -1;
            if (i16 != i3) {
            }
            String rawHeaders2 = httpParser.getRawHeaders();
            PlayerUtils.log(4, str2, PlayerUtils.removeLineBreaks("mediaplayer request header:" + rawHeaders2, null));
            outputStream = socket.getOutputStream();
            if (outputStream != null) {
            }
        } catch (Exception e16) {
            this.mProxyExceptionCount++;
            PlayerUtils.log(5, str2, "mProxyExceptionCount " + this.mProxyExceptionCount);
            String printableStackTrace = PlayerUtils.getPrintableStackTrace(e16);
            if (PlayerConfig.g().getVideoReporter() != null) {
                boolean z16 = e16 instanceof ProxyException;
                long j3 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
                if (z16) {
                    j3 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE + ((ProxyException) e16).getErrCode();
                } else if (e16 instanceof IllegalDataSpecException) {
                    j3 = -99799;
                } else if (e16 instanceof ArrayIndexOutOfBoundsException) {
                    j3 = -99699;
                }
                long downloadRetCode = PlayerUtils.getDownloadRetCode(4L, j3);
                long downloadResponseCode = PlayerUtils.getDownloadResponseCode(downloadRetCode, j3);
                if (!UuidPlayIdMap.isUuidDeleted(videoRequest.getUuid())) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(AdMetricTag.RESPONSE_CODE, Long.valueOf(downloadResponseCode));
                    hashMap.put("subRetCode", Long.valueOf(j3));
                    hashMap.put("message", "(" + downloadResponseCode + "," + j3 + ")," + e16.toString());
                    PlayerConfig.g().getVideoReporter().downloadResult(videoRequest.getUuid(), downloadRetCode, hashMap);
                }
            }
            PlayerUtils.log(6, str2, "unexpected proxy err " + e16.getMessage() + printableStackTrace, e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void sendUrlRequestSync(String str, long j3, PreloadListener preloadListener, String str2) {
        long j16;
        long j17;
        DefaultHttpDataSource defaultHttpDataSource = new DefaultHttpDataSource("com.qzone.player-v20150909", null, null);
        String str3 = "VideoProxy/sendUrlRequest/" + str2;
        byte[] bArr = new byte[512];
        PlayerUtils.log(4, str3, "sendUrlRequest start url=" + str);
        long j18 = -1;
        long j19 = 0;
        if (preloadListener != null) {
            try {
                try {
                    preloadListener.onStart(str);
                } catch (Exception e16) {
                    e = e16;
                    PlayerUtils.log(4, str3, "sendUrlRequest exit with message" + e.getMessage());
                    try {
                        defaultHttpDataSource.close();
                    } catch (Exception e17) {
                        PlayerUtils.log(4, str3, "sendUrlRequest closeException" + e17);
                    }
                    if (preloadListener != null) {
                        preloadListener.onFinish(str);
                    }
                    j16 = j18;
                    j17 = j19;
                    PlayerUtils.log(4, str3, "sendUrlRequest totalLength=" + j16 + ", totalReadBytes=" + j17);
                }
            } finally {
            }
        }
        defaultHttpDataSource.open(new DataSpec(Uri.parse(str), 0L, 0L, -1L, null, 0, null));
        long totalLength = defaultHttpDataSource.getTotalLength();
        j17 = 0;
        while (true) {
            try {
                long read = defaultHttpDataSource.read(bArr, 0, 512);
                if (read == -1) {
                    break;
                }
                long j26 = j17 + read;
                if (preloadListener != null) {
                    try {
                        preloadListener.onUpdate(str, j26, j3, totalLength);
                    } catch (Exception e18) {
                        e = e18;
                        j18 = totalLength;
                        j19 = j26;
                        PlayerUtils.log(4, str3, "sendUrlRequest exit with message" + e.getMessage());
                        defaultHttpDataSource.close();
                        if (preloadListener != null) {
                        }
                        j16 = j18;
                        j17 = j19;
                        PlayerUtils.log(4, str3, "sendUrlRequest totalLength=" + j16 + ", totalReadBytes=" + j17);
                    }
                }
                if (j3 > 0 && j3 != -1 && j26 >= j3) {
                    j17 = j26;
                    break;
                }
                j17 = j26;
            } catch (Exception e19) {
                e = e19;
                j19 = j17;
                j18 = totalLength;
            }
        }
        PlayerUtils.log(4, str3, "sendUrlRequest finish, totalReadBytes=" + j17);
        try {
            defaultHttpDataSource.close();
        } catch (Exception e26) {
            PlayerUtils.log(4, str3, "sendUrlRequest closeException" + e26);
        }
        if (preloadListener != null) {
            preloadListener.onFinish(str);
        }
        j16 = totalLength;
        PlayerUtils.log(4, str3, "sendUrlRequest totalLength=" + j16 + ", totalReadBytes=" + j17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void waitForRequest() {
        PlayerUtils.log(3, TAG, "proxy started");
        while (!Thread.currentThread().isInterrupted()) {
            try {
                try {
                    Socket accept = this.serverSocket.accept();
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    SocketHandler socketHandler = new SocketHandler(accept, countDownLatch);
                    if (PlayerConfig.g().isDebugVersion()) {
                        PlayerUtils.log(3, TAG, this.videoRequestManager.toString());
                    }
                    PlayerUtils.log(4, TAG, this.executorService.toString());
                    Future<?> submit = this.executorService.submit(socketHandler);
                    ((ThreadPoolExecutor) this.executorService).setCorePoolSize(((ThreadUtils.FlexibleSizeExecutor) this.executorService).getPendingTaskCount() + 2);
                    socketHandler.setTask(submit);
                    countDownLatch.countDown();
                } catch (IOException e16) {
                    PlayerUtils.log(6, TAG, "proxy server is quit, reason " + PlayerUtils.getPrintableStackTrace(e16));
                } catch (OutOfMemoryError e17) {
                    PlayerUtils.log(6, TAG, "proxy server is quit, reason OOM" + PlayerUtils.getPrintableStackTrace(e17));
                } catch (SocketException e18) {
                    if (this.serverSocket.isClosed()) {
                        PlayerUtils.log(3, TAG, "closing proxy server");
                    } else {
                        PlayerUtils.log(6, TAG, "proxy server is quit, reason " + PlayerUtils.getPrintableStackTrace(e18));
                    }
                }
            } finally {
                PlayerUtils.log(3, TAG, "shutdown thread pool");
                this.executorService.shutdownNow();
                PlayerUtils.log(3, TAG, "proxy server stopped");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:626:0x0520, code lost:
    
        r51 = r5;
        r52 = r8;
        r19 = r9;
        r45 = r11;
        r12 = r67;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0bdc  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0e81 A[Catch: all -> 0x0e85, TRY_ENTER, TRY_LEAVE, TryCatch #64 {all -> 0x0e85, blocks: (B:379:0x0b66, B:113:0x0e81), top: B:378:0x0b66 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x129d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x12c6  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x12e7  */
    /* JADX WARN: Removed duplicated region for block: B:135:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x1298 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0ec8  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0ef3  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0f16  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0f2f  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0f4c  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0fbb  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x100a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0f33  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0ec3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0d52 A[Catch: all -> 0x0c2d, TryCatch #10 {all -> 0x0c2d, blocks: (B:369:0x0af5, B:371:0x0afd, B:372:0x0b04, B:374:0x0b28, B:384:0x0b3e, B:106:0x0bed, B:246:0x0bf8, B:250:0x0c4b, B:252:0x0c53, B:258:0x0c87, B:260:0x0c8f, B:264:0x0cba, B:269:0x0cde, B:272:0x0cfc, B:274:0x0d24, B:276:0x0d28, B:278:0x0d33, B:280:0x0d52, B:282:0x0d56, B:284:0x0d5c, B:289:0x0d7c, B:290:0x0d71, B:296:0x0d3b, B:298:0x0d43, B:300:0x0d47, B:303:0x0d87, B:305:0x0daf, B:308:0x0dbe, B:310:0x0dc2, B:312:0x0dca, B:315:0x0dd6, B:317:0x0dfe, B:320:0x0e09, B:323:0x0e28, B:326:0x0e3d, B:329:0x0e52), top: B:100:0x0a74, inners: #74 }] */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0d6e  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0d71 A[Catch: all -> 0x0c2d, TryCatch #10 {all -> 0x0c2d, blocks: (B:369:0x0af5, B:371:0x0afd, B:372:0x0b04, B:374:0x0b28, B:384:0x0b3e, B:106:0x0bed, B:246:0x0bf8, B:250:0x0c4b, B:252:0x0c53, B:258:0x0c87, B:260:0x0c8f, B:264:0x0cba, B:269:0x0cde, B:272:0x0cfc, B:274:0x0d24, B:276:0x0d28, B:278:0x0d33, B:280:0x0d52, B:282:0x0d56, B:284:0x0d5c, B:289:0x0d7c, B:290:0x0d71, B:296:0x0d3b, B:298:0x0d43, B:300:0x0d47, B:303:0x0d87, B:305:0x0daf, B:308:0x0dbe, B:310:0x0dc2, B:312:0x0dca, B:315:0x0dd6, B:317:0x0dfe, B:320:0x0e09, B:323:0x0e28, B:326:0x0e3d, B:329:0x0e52), top: B:100:0x0a74, inners: #74 }] */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0a76 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0b9d  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0b66 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:423:0x0992 A[Catch: all -> 0x0a1f, TRY_LEAVE, TryCatch #79 {all -> 0x0a1f, blocks: (B:421:0x0977, B:423:0x0992), top: B:420:0x0977 }] */
    /* JADX WARN: Removed duplicated region for block: B:429:0x09be  */
    /* JADX WARN: Removed duplicated region for block: B:435:0x09e7  */
    /* JADX WARN: Removed duplicated region for block: B:438:0x0a08  */
    /* JADX WARN: Removed duplicated region for block: B:733:0x00db  */
    /* JADX WARN: Type inference failed for: r28v0 */
    /* JADX WARN: Type inference failed for: r28v1 */
    /* JADX WARN: Type inference failed for: r28v8 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void writeResponse(Socket socket, String str, OutputStream outputStream, VideoRequest videoRequest, InputStream inputStream) {
        DataSourceBuilder dataSourceBuilder;
        DataSource defaultHttpDataSource;
        DataSource dataSource;
        OutputStream outputStream2;
        InputStream inputStream2;
        long j3;
        long j16;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        long j17;
        DataSource dataSource2;
        int i3;
        boolean z16;
        File file;
        Exception exc;
        InputStream inputStream3;
        Throwable th5;
        DataSource dataSource3;
        long j18;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        long j19;
        String str15;
        String str16;
        IOException iOException;
        long j26;
        FileType fileType;
        long j27;
        int i16;
        boolean z17;
        IOException iOException2;
        OnConnectionChangeListener onConnectionChangeListener;
        VideoProxy videoProxy;
        VideoRequest videoRequest2;
        Exception exc2;
        boolean z18;
        long j28;
        long j29;
        boolean delete;
        String str17;
        long j36;
        HashMap hashMap;
        OnConnectionChangeListener onConnectionChangeListener2;
        boolean delete2;
        int i17;
        String str18;
        String str19;
        int i18;
        int i19;
        IOException iOException3;
        int i26;
        long j37;
        FileType fileType2;
        long j38;
        int i27;
        long j39;
        OnConnectionChangeListener onConnectionChangeListener3;
        boolean delete3;
        int i28;
        DataSpec dataSpec;
        int i29;
        Uri uri;
        DataSourceOpenResult openDataSource;
        long j46;
        File file2;
        long j47;
        FileType fileType3;
        long totalLength;
        DataSource dataSource4;
        long j48;
        String newResponseHeader;
        int i36;
        int i37;
        DataSource dataSource5;
        int i38;
        boolean z19;
        String str20;
        VideoProxy videoProxy2;
        long j49;
        DataSpec dataSpec2;
        DataSource dataSource6;
        DataSource dataSource7;
        int i39;
        long rangeEnd = videoRequest.getRangeEnd();
        long rangeStart = videoRequest.getRangeStart();
        String videoKey = videoRequest.getVideoKey();
        ?? r28 = "total send ";
        String dataSourceType = videoRequest.getDataSourceType();
        DataSourceBuilder dataSourceBuilder2 = PlayerConfig.g().getDataSourceBuilder();
        HttpRetryLogic httpRetryLogic = this.httpRetryLogicMap.get(videoKey);
        String str21 = LOG_TAG_PREFIX + videoRequest.getSeqNum();
        String str22 = str21 + "/";
        if (dataSourceBuilder2 == null) {
            if (this.tcDataSourceUtils != null && ((TextUtils.equals(dataSourceType, "0") || TextUtils.equals(dataSourceType, "-1")) && this.tcDataSourceUtils.isEnabled() && !this.tcDataSourceUtils.isUseDefaultSourceBuilder(str))) {
                if (this.isCacheProviderLocal) {
                    DataSourceBuilder dataSourceBuilder3 = this.tcDataSourceUtils.getDataSourceBuilder(this.cache, httpRetryLogic, videoRequest);
                    if (!this.isPauseTcStorageIO) {
                        this.tcDataSourceUtils.pauseStorageIO();
                        this.isPauseTcStorageIO = true;
                    }
                    dataSourceBuilder = dataSourceBuilder3;
                } else {
                    dataSourceBuilder2 = this.tcDataSourceUtils.getDataSourceBuilder(null, httpRetryLogic, videoRequest);
                    if (this.isPauseTcStorageIO) {
                        this.tcDataSourceUtils.resumeStorageIO();
                        this.isPauseTcStorageIO = false;
                    }
                }
            } else {
                dataSourceBuilder = new DefaultDataSourceBuilder(this.cache, httpRetryLogic, videoRequest);
            }
            if (dataSourceBuilder == null) {
                defaultHttpDataSource = dataSourceBuilder.build(str, str22);
            } else {
                defaultHttpDataSource = new DefaultHttpDataSource("com.qzone.player-v20150909", new PassOnVideoType(), videoRequest.getContentTypeFixer());
                defaultHttpDataSource.setLogTag(str22);
            }
            dataSource = defaultHttpDataSource;
            if (dataSource != null) {
                PlayerUtils.log(6, str21, "DataSource is null!!!");
                return;
            }
            byte[] bArr = new byte[65536];
            FileType fileType4 = FileType.UNKNOWN;
            DataSpec dataSpec3 = new DataSpec(Uri.parse(str), rangeStart == -1 ? 0L : rangeStart, rangeStart == -1 ? 0L : rangeStart, (rangeEnd == -1 || rangeEnd == -2) ? -1L : (rangeEnd - rangeStart) + 1, videoKey, 0, videoRequest.getUuid(), videoRequest.getPrority());
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            long currentTimeMillis = System.currentTimeMillis();
            VideoSpeedReport.ReportPoint reportPoint = new VideoSpeedReport.ReportPoint(VideoSpeedReport.ReportPoint.HTTP_OPEN, false, "[" + rangeStart + "," + rangeEnd + "]");
            VideoSpeedReport.ReportType.addToVideoReportType(VideoSpeedReport.ReportType.TYPE_VIDEO_PLAY, reportPoint);
            VideoSpeedReport.g().start(reportPoint);
            long j56 = rangeEnd;
            String str23 = r28;
            byte[] bArr2 = bArr;
            String str24 = " bytes, rangeStart=";
            String str25 = "dataSource close failed";
            BufferedOutputStream bufferedOutputStream2 = bufferedOutputStream;
            String str26 = "DelPlayListFile failed";
            DataSource dataSource8 = dataSource;
            String str27 = videoKey;
            DataSpec dataSpec4 = dataSpec3;
            try {
                try {
                    try {
                        openDataSource = openDataSource(dataSource, dataSpec3, str, str21, videoRequest, socket, videoKey, 0L, VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE, currentTimeMillis);
                    } catch (Exception e16) {
                        outputStream2 = outputStream;
                        inputStream2 = inputStream;
                        j3 = rangeStart;
                        j16 = j56;
                        str2 = str23;
                        str3 = str24;
                        str4 = ", rangeEnd=";
                        str5 = str21;
                        str6 = str25;
                        str7 = "DelPlayListFile ";
                        str8 = str26;
                        j17 = 0;
                        dataSource2 = dataSource8;
                        i3 = 0;
                        z16 = true;
                        file = null;
                        exc = e16;
                    }
                } catch (IOException e17) {
                    e = e17;
                }
                try {
                    j46 = openDataSource.retCode;
                    try {
                        file2 = openDataSource.localPlayListFile;
                        try {
                        } catch (IOException e18) {
                            file = file2;
                            j3 = rangeStart;
                            j19 = j56;
                            str2 = str23;
                            str3 = str24;
                            str15 = ", rangeEnd=";
                            str5 = str21;
                            str16 = "DelPlayListFile ";
                            iOException = e18;
                            dataSource3 = dataSource8;
                            fileType = fileType4;
                            j26 = j46;
                            j27 = -1;
                        } catch (Exception e19) {
                            e = e19;
                            outputStream2 = outputStream;
                            inputStream2 = inputStream;
                            j17 = j46;
                            file = file2;
                            j3 = rangeStart;
                            j16 = j56;
                            str2 = str23;
                            str3 = str24;
                            str4 = ", rangeEnd=";
                            str5 = str21;
                            str6 = str25;
                            str7 = "DelPlayListFile ";
                            str8 = str26;
                        } catch (Throwable th6) {
                            file = file2;
                            j3 = rangeStart;
                            inputStream3 = inputStream;
                            th5 = th6;
                            dataSource3 = dataSource8;
                            j18 = j56;
                            str9 = str23;
                            str3 = str24;
                            str10 = ", rangeEnd=";
                            str11 = str21;
                            str12 = str25;
                            str13 = "DelPlayListFile ";
                            str14 = str26;
                            i3 = 0;
                        }
                    } catch (IOException e26) {
                        j3 = rangeStart;
                        j19 = j56;
                        str2 = str23;
                        str3 = str24;
                        str15 = ", rangeEnd=";
                        str5 = str21;
                        str16 = "DelPlayListFile ";
                        iOException = e26;
                        dataSource3 = dataSource8;
                        fileType = fileType4;
                        j26 = j46;
                        j27 = -1;
                        i16 = 0;
                        z17 = true;
                        file = null;
                        try {
                            str18 = str16;
                            str19 = str15;
                            try {
                                if (iOException instanceof HttpDataSource.InvalidResponseCodeException) {
                                }
                            } catch (Throwable th7) {
                                inputStream3 = inputStream;
                                th5 = th7;
                                iOException2 = iOException;
                                i18 = r28;
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            str13 = str16;
                            i17 = i16;
                            str10 = str15;
                            j18 = j19;
                            str12 = str25;
                            str14 = str26;
                            inputStream3 = inputStream;
                            str9 = str2;
                            str11 = str5;
                        }
                        try {
                            if (videoRequest.shouldCancel()) {
                            }
                            PlayerUtils.log(4, str5, str23 + (i26 == true ? 1 : 0) + str24 + j3 + str19 + j56);
                            try {
                                dataSource3.close();
                            } catch (IOException unused) {
                                PlayerUtils.log(5, str5, str25);
                            }
                            if (iOException3 == null) {
                            }
                            if (file != null) {
                            }
                            onConnectionChangeListener3 = PlayerConfig.g().getOnConnectionChangeListener();
                            if (onConnectionChangeListener3 != null) {
                            }
                            exc2 = iOException3;
                            j29 = j39;
                            z18 = z17;
                            j28 = j26;
                            videoProxy.videoRequestManager.removeRequest(videoRequest2);
                            if (!videoRequest.isCancelProcceed()) {
                            }
                            videoRequest2.setIsStopped(true);
                            String uuid = videoRequest.getUuid();
                            if (PlayerConfig.g().getVideoReporter() != null) {
                            }
                            String str28 = str27;
                            HttpErrorListener httpErrorListener = videoProxy.httpUrlErrorListenerMap.get(str28);
                            HttpErrorListener httpErrorListener2 = videoProxy.uuidErrorListenerMap.get(videoRequest.getUuid());
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("priority", Integer.valueOf(videoRequest.getPrority()));
                            if (!(exc2 instanceof HttpDataSource.InvalidResponseCodeException)) {
                            }
                            PlayerUtils.log(4, str17, "writeResponse finish");
                            return;
                        } catch (Throwable th9) {
                            inputStream3 = inputStream;
                            IOException iOException4 = iOException3;
                            str11 = str5;
                            str9 = str23;
                            str3 = str24;
                            str10 = str19;
                            str12 = str25;
                            str13 = str18;
                            j18 = j56;
                            th5 = th9;
                            iOException2 = iOException4;
                            i3 = i26 == true ? 1 : 0;
                            str14 = str26;
                            PlayerUtils.log(4, str11, str9 + i3 + str3 + j3 + str10 + j18);
                            try {
                                dataSource3.close();
                            } catch (IOException unused2) {
                                PlayerUtils.log(5, str11, str12);
                            }
                            if (iOException2 == null) {
                                try {
                                    socket.close();
                                } catch (IOException unused3) {
                                }
                            }
                            if (file != null && file.isFile() && file.exists()) {
                                delete2 = file.delete();
                                PlayerUtils.log(4, str11, str13 + file.toString());
                                if (!delete2) {
                                    PlayerUtils.log(5, str11, str14 + file.toString());
                                }
                            }
                            onConnectionChangeListener2 = PlayerConfig.g().getOnConnectionChangeListener();
                            if (onConnectionChangeListener2 != null) {
                                onConnectionChangeListener2.onConnectionChange(false, inputStream3, outputStream);
                                throw th5;
                            }
                            throw th5;
                        }
                    } catch (Exception e27) {
                        outputStream2 = outputStream;
                        inputStream2 = inputStream;
                        j17 = j46;
                        j3 = rangeStart;
                        j16 = j56;
                        str2 = str23;
                        str3 = str24;
                        str4 = ", rangeEnd=";
                        str5 = str21;
                        str6 = str25;
                        str7 = "DelPlayListFile ";
                        str8 = str26;
                        exc = e27;
                        dataSource2 = dataSource8;
                        i3 = 0;
                        z16 = true;
                        file = null;
                    }
                } catch (IOException e28) {
                    e = e28;
                    j3 = rangeStart;
                    j19 = j56;
                    str2 = str23;
                    str3 = str24;
                    str15 = ", rangeEnd=";
                    str5 = str21;
                    str16 = "DelPlayListFile ";
                    iOException = e;
                    j26 = 0;
                    dataSource3 = dataSource8;
                    fileType = fileType4;
                    j27 = -1;
                    i16 = 0;
                    z17 = true;
                    file = null;
                    str18 = str16;
                    str19 = str15;
                    if (iOException instanceof HttpDataSource.InvalidResponseCodeException) {
                    }
                    if (videoRequest.shouldCancel()) {
                    }
                    PlayerUtils.log(4, str5, str23 + (i26 == true ? 1 : 0) + str24 + j3 + str19 + j56);
                    dataSource3.close();
                    if (iOException3 == null) {
                    }
                    if (file != null) {
                    }
                    onConnectionChangeListener3 = PlayerConfig.g().getOnConnectionChangeListener();
                    if (onConnectionChangeListener3 != null) {
                    }
                    exc2 = iOException3;
                    j29 = j39;
                    z18 = z17;
                    j28 = j26;
                    videoProxy.videoRequestManager.removeRequest(videoRequest2);
                    if (!videoRequest.isCancelProcceed()) {
                    }
                    videoRequest2.setIsStopped(true);
                    String uuid2 = videoRequest.getUuid();
                    if (PlayerConfig.g().getVideoReporter() != null) {
                    }
                    String str282 = str27;
                    HttpErrorListener httpErrorListener3 = videoProxy.httpUrlErrorListenerMap.get(str282);
                    HttpErrorListener httpErrorListener22 = videoProxy.uuidErrorListenerMap.get(videoRequest.getUuid());
                    HashMap hashMap22 = new HashMap();
                    hashMap22.put("priority", Integer.valueOf(videoRequest.getPrority()));
                    if (!(exc2 instanceof HttpDataSource.InvalidResponseCodeException)) {
                    }
                    PlayerUtils.log(4, str17, "writeResponse finish");
                    return;
                }
                if (openDataSource.isHandled) {
                    PlayerUtils.log(4, str21, str23 + 0 + str24 + rangeStart + ", rangeEnd=" + j56);
                    try {
                        dataSource8.close();
                        i39 = 5;
                    } catch (IOException unused4) {
                        i39 = 5;
                        PlayerUtils.log(5, str21, str25);
                    }
                    try {
                        socket.close();
                    } catch (IOException unused5) {
                    }
                    if (file2 != null && file2.isFile() && file2.exists()) {
                        boolean delete4 = file2.delete();
                        PlayerUtils.log(4, str21, "DelPlayListFile " + file2.toString());
                        if (!delete4) {
                            PlayerUtils.log(i39, str21, str26 + file2.toString());
                        }
                    }
                    OnConnectionChangeListener onConnectionChangeListener4 = PlayerConfig.g().getOnConnectionChangeListener();
                    if (onConnectionChangeListener4 != null) {
                        onConnectionChangeListener4.onConnectionChange(false, inputStream, outputStream);
                        return;
                    }
                    return;
                }
                j3 = rangeStart;
                long j57 = j56;
                str2 = str23;
                String str29 = str24;
                String str30 = ", rangeEnd=";
                str5 = str21;
                try {
                    dataSource3 = openDataSource.dataSource;
                    if (dataSource3 == null) {
                        dataSource3 = dataSource8;
                        try {
                            if (dataSource3 instanceof CacheDataSource) {
                                try {
                                    DataSource upstreamDataSource = ((CacheDataSource) dataSource3).getUpstreamDataSource();
                                    try {
                                        if (upstreamDataSource instanceof HttpDataSource) {
                                            String uri2 = ((HttpDataSource) upstreamDataSource).getUri();
                                            if (uri2 != null) {
                                                StringBuilder sb5 = new StringBuilder();
                                                dataSource7 = dataSource3;
                                                sb5.append("firstTimeOpenFinish:");
                                                sb5.append(uri2);
                                                PlayerUtils.log(4, str5, sb5.toString());
                                                dataSource3 = dataSource7;
                                            }
                                        } else {
                                            dataSource7 = dataSource3;
                                            PlayerUtils.log(6, str5, "abnormal upstreamDataSource " + upstreamDataSource);
                                            dataSource3 = dataSource7;
                                        }
                                    } catch (IOException e29) {
                                        e = e29;
                                        j26 = j46;
                                        str25 = str25;
                                        file = file2;
                                        j19 = j57;
                                        dataSource3 = dataSource8;
                                        j27 = -1;
                                        fileType = fileType4;
                                        str16 = "DelPlayListFile ";
                                        str26 = str26;
                                        z17 = true;
                                        iOException = e;
                                        str15 = str30;
                                        str3 = str29;
                                        i16 = 0;
                                        str18 = str16;
                                        str19 = str15;
                                        if (iOException instanceof HttpDataSource.InvalidResponseCodeException) {
                                        }
                                        if (videoRequest.shouldCancel()) {
                                        }
                                        PlayerUtils.log(4, str5, str23 + (i26 == true ? 1 : 0) + str24 + j3 + str19 + j56);
                                        dataSource3.close();
                                        if (iOException3 == null) {
                                        }
                                        if (file != null) {
                                        }
                                        onConnectionChangeListener3 = PlayerConfig.g().getOnConnectionChangeListener();
                                        if (onConnectionChangeListener3 != null) {
                                        }
                                        exc2 = iOException3;
                                        j29 = j39;
                                        z18 = z17;
                                        j28 = j26;
                                        videoProxy.videoRequestManager.removeRequest(videoRequest2);
                                        if (!videoRequest.isCancelProcceed()) {
                                        }
                                        videoRequest2.setIsStopped(true);
                                        String uuid22 = videoRequest.getUuid();
                                        if (PlayerConfig.g().getVideoReporter() != null) {
                                        }
                                        String str2822 = str27;
                                        HttpErrorListener httpErrorListener32 = videoProxy.httpUrlErrorListenerMap.get(str2822);
                                        HttpErrorListener httpErrorListener222 = videoProxy.uuidErrorListenerMap.get(videoRequest.getUuid());
                                        HashMap hashMap222 = new HashMap();
                                        hashMap222.put("priority", Integer.valueOf(videoRequest.getPrority()));
                                        if (!(exc2 instanceof HttpDataSource.InvalidResponseCodeException)) {
                                        }
                                        PlayerUtils.log(4, str17, "writeResponse finish");
                                        return;
                                    } catch (Exception e36) {
                                        e = e36;
                                        inputStream2 = inputStream;
                                        exc = e;
                                        j17 = j46;
                                        file = file2;
                                        j16 = j57;
                                        dataSource2 = dataSource8;
                                        str7 = "DelPlayListFile ";
                                        i3 = 0;
                                        z16 = true;
                                        str4 = str30;
                                        str6 = str25;
                                        str8 = str26;
                                        str3 = str29;
                                        outputStream2 = outputStream;
                                        try {
                                            StringBuilder sb6 = new StringBuilder();
                                            try {
                                                sb6.append("other exception ");
                                                sb6.append(PlayerUtils.getPrintableStackTrace(exc));
                                                PlayerUtils.log(4, str5, sb6.toString());
                                                if (videoRequest.shouldCancel()) {
                                                }
                                                PlayerUtils.log(4, str5, str2 + i3 + str3 + j3 + str4 + j16);
                                                try {
                                                    dataSource2.close();
                                                } catch (IOException unused6) {
                                                    PlayerUtils.log(5, str5, str6);
                                                }
                                                if (file != null) {
                                                }
                                                onConnectionChangeListener = PlayerConfig.g().getOnConnectionChangeListener();
                                                if (onConnectionChangeListener != null) {
                                                }
                                                videoProxy = this;
                                                videoRequest2 = videoRequest;
                                                exc2 = exc;
                                                z18 = z16;
                                                dataSource3 = dataSource2;
                                                j28 = j17;
                                                j29 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
                                                videoProxy.videoRequestManager.removeRequest(videoRequest2);
                                                if (!videoRequest.isCancelProcceed()) {
                                                }
                                                videoRequest2.setIsStopped(true);
                                                String uuid222 = videoRequest.getUuid();
                                                if (PlayerConfig.g().getVideoReporter() != null) {
                                                }
                                                String str28222 = str27;
                                                HttpErrorListener httpErrorListener322 = videoProxy.httpUrlErrorListenerMap.get(str28222);
                                                HttpErrorListener httpErrorListener2222 = videoProxy.uuidErrorListenerMap.get(videoRequest.getUuid());
                                                HashMap hashMap2222 = new HashMap();
                                                hashMap2222.put("priority", Integer.valueOf(videoRequest.getPrority()));
                                                if (!(exc2 instanceof HttpDataSource.InvalidResponseCodeException)) {
                                                }
                                                PlayerUtils.log(4, str17, "writeResponse finish");
                                                return;
                                            } catch (Throwable th10) {
                                                th5 = th10;
                                                str13 = str7;
                                                str9 = str2;
                                                str12 = str6;
                                                str11 = str5;
                                                dataSource3 = dataSource2;
                                                iOException2 = null;
                                                long j58 = j16;
                                                inputStream3 = inputStream;
                                                str14 = str8;
                                                str10 = str4;
                                                j18 = j58;
                                                PlayerUtils.log(4, str11, str9 + i3 + str3 + j3 + str10 + j18);
                                                dataSource3.close();
                                                if (iOException2 == null) {
                                                }
                                                if (file != null) {
                                                }
                                                onConnectionChangeListener2 = PlayerConfig.g().getOnConnectionChangeListener();
                                                if (onConnectionChangeListener2 != null) {
                                                }
                                            }
                                        } catch (Throwable th11) {
                                            th5 = th11;
                                            str13 = str7;
                                            str9 = str2;
                                            str12 = str6;
                                            str11 = str5;
                                            iOException2 = null;
                                            long j59 = j16;
                                            inputStream3 = inputStream2;
                                            str14 = str8;
                                            str10 = str4;
                                            j18 = j59;
                                            dataSource3 = dataSource2;
                                        }
                                    } catch (Throwable th12) {
                                        inputStream3 = inputStream;
                                        th5 = th12;
                                        str12 = str25;
                                        file = file2;
                                        j18 = j57;
                                        dataSource3 = dataSource8;
                                        str13 = "DelPlayListFile ";
                                        str14 = str26;
                                        i3 = 0;
                                        iOException2 = null;
                                        str10 = str30;
                                        str3 = str29;
                                        str9 = str2;
                                        str11 = str5;
                                        PlayerUtils.log(4, str11, str9 + i3 + str3 + j3 + str10 + j18);
                                        dataSource3.close();
                                        if (iOException2 == null) {
                                        }
                                        if (file != null) {
                                        }
                                        onConnectionChangeListener2 = PlayerConfig.g().getOnConnectionChangeListener();
                                        if (onConnectionChangeListener2 != null) {
                                        }
                                    }
                                } catch (IOException e37) {
                                    e = e37;
                                    j26 = j46;
                                    str25 = str25;
                                    file = file2;
                                    j19 = j57;
                                } catch (Exception e38) {
                                    e = e38;
                                    dataSource8 = dataSource3;
                                } catch (Throwable th13) {
                                    inputStream3 = inputStream;
                                    th5 = th13;
                                    str12 = str25;
                                    file = file2;
                                    j18 = j57;
                                }
                            }
                            dataSource7 = dataSource3;
                            dataSource3 = dataSource7;
                        } catch (IOException e39) {
                            e = e39;
                            dataSource8 = dataSource3;
                            j47 = j46;
                            file = file2;
                            j19 = j57;
                            fileType3 = fileType4;
                            str16 = "DelPlayListFile ";
                            str15 = str30;
                            str3 = str29;
                            iOException = e;
                            str25 = str25;
                            dataSource3 = dataSource8;
                            fileType = fileType3;
                            j26 = j47;
                            j27 = -1;
                            str26 = str26;
                            i16 = 0;
                            z17 = true;
                            str18 = str16;
                            str19 = str15;
                            if (iOException instanceof HttpDataSource.InvalidResponseCodeException) {
                            }
                            if (videoRequest.shouldCancel()) {
                            }
                            PlayerUtils.log(4, str5, str23 + (i26 == true ? 1 : 0) + str24 + j3 + str19 + j56);
                            dataSource3.close();
                            if (iOException3 == null) {
                            }
                            if (file != null) {
                            }
                            onConnectionChangeListener3 = PlayerConfig.g().getOnConnectionChangeListener();
                            if (onConnectionChangeListener3 != null) {
                            }
                            exc2 = iOException3;
                            j29 = j39;
                            z18 = z17;
                            j28 = j26;
                            videoProxy.videoRequestManager.removeRequest(videoRequest2);
                            if (!videoRequest.isCancelProcceed()) {
                            }
                            videoRequest2.setIsStopped(true);
                            String uuid2222 = videoRequest.getUuid();
                            if (PlayerConfig.g().getVideoReporter() != null) {
                            }
                            String str282222 = str27;
                            HttpErrorListener httpErrorListener3222 = videoProxy.httpUrlErrorListenerMap.get(str282222);
                            HttpErrorListener httpErrorListener22222 = videoProxy.uuidErrorListenerMap.get(videoRequest.getUuid());
                            HashMap hashMap22222 = new HashMap();
                            hashMap22222.put("priority", Integer.valueOf(videoRequest.getPrority()));
                            if (!(exc2 instanceof HttpDataSource.InvalidResponseCodeException)) {
                            }
                            PlayerUtils.log(4, str17, "writeResponse finish");
                            return;
                        } catch (Exception e46) {
                            e = e46;
                            dataSource8 = dataSource3;
                            j17 = j46;
                            file = file2;
                            j16 = j57;
                            str7 = "DelPlayListFile ";
                            inputStream2 = inputStream;
                            str4 = str30;
                            str6 = str25;
                            str8 = str26;
                            str3 = str29;
                            outputStream2 = outputStream;
                            exc = e;
                            dataSource2 = dataSource8;
                            i3 = 0;
                            z16 = true;
                            StringBuilder sb62 = new StringBuilder();
                            sb62.append("other exception ");
                            sb62.append(PlayerUtils.getPrintableStackTrace(exc));
                            PlayerUtils.log(4, str5, sb62.toString());
                            if (videoRequest.shouldCancel()) {
                            }
                            PlayerUtils.log(4, str5, str2 + i3 + str3 + j3 + str4 + j16);
                            dataSource2.close();
                            if (file != null) {
                            }
                            onConnectionChangeListener = PlayerConfig.g().getOnConnectionChangeListener();
                            if (onConnectionChangeListener != null) {
                            }
                            videoProxy = this;
                            videoRequest2 = videoRequest;
                            exc2 = exc;
                            z18 = z16;
                            dataSource3 = dataSource2;
                            j28 = j17;
                            j29 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
                            videoProxy.videoRequestManager.removeRequest(videoRequest2);
                            if (!videoRequest.isCancelProcceed()) {
                            }
                            videoRequest2.setIsStopped(true);
                            String uuid22222 = videoRequest.getUuid();
                            if (PlayerConfig.g().getVideoReporter() != null) {
                            }
                            String str2822222 = str27;
                            HttpErrorListener httpErrorListener32222 = videoProxy.httpUrlErrorListenerMap.get(str2822222);
                            HttpErrorListener httpErrorListener222222 = videoProxy.uuidErrorListenerMap.get(videoRequest.getUuid());
                            HashMap hashMap222222 = new HashMap();
                            hashMap222222.put("priority", Integer.valueOf(videoRequest.getPrority()));
                            if (!(exc2 instanceof HttpDataSource.InvalidResponseCodeException)) {
                            }
                            PlayerUtils.log(4, str17, "writeResponse finish");
                            return;
                        } catch (Throwable th14) {
                            th = th14;
                            file = file2;
                            str3 = str29;
                            th5 = th;
                            str9 = str2;
                            str12 = str25;
                            str10 = str30;
                            str11 = str5;
                            j18 = j57;
                            str13 = "DelPlayListFile ";
                            str14 = str26;
                            i3 = 0;
                            iOException2 = null;
                            inputStream3 = inputStream;
                            PlayerUtils.log(4, str11, str9 + i3 + str3 + j3 + str10 + j18);
                            dataSource3.close();
                            if (iOException2 == null) {
                            }
                            if (file != null) {
                            }
                            onConnectionChangeListener2 = PlayerConfig.g().getOnConnectionChangeListener();
                            if (onConnectionChangeListener2 != null) {
                            }
                        }
                    }
                } catch (IOException e47) {
                    e = e47;
                    j47 = j46;
                    file = file2;
                    j19 = j57;
                    fileType3 = fileType4;
                    str16 = "DelPlayListFile ";
                } catch (Exception e48) {
                    e = e48;
                    inputStream2 = inputStream;
                    j17 = j46;
                    file = file2;
                    j16 = j57;
                    str7 = "DelPlayListFile ";
                } catch (Throwable th15) {
                    file = file2;
                    str3 = str29;
                    th5 = th15;
                    str9 = str2;
                    str12 = str25;
                    str10 = str30;
                    str11 = str5;
                    j18 = j57;
                    dataSource3 = dataSource8;
                }
                try {
                    try {
                        totalLength = dataSource3.getTotalLength();
                        j17 = j46;
                        try {
                            FileType fileType5 = dataSource3.getFileType();
                            try {
                                videoRequest.updateInfo(totalLength, fileType5);
                                file = file2;
                                try {
                                    newResponseHeader = HttpParser.newResponseHeader(j3, j57, totalLength, fileType5.toString(), !PlayerUtils.isHLSStream(str));
                                    str25 = str25;
                                    try {
                                        try {
                                            if (fileType5.equals(fileType4)) {
                                                fileType = fileType5;
                                                try {
                                                    PlayerUtils.log(6, str5, "file type should not unknown");
                                                } catch (IOException e49) {
                                                    iOException = e49;
                                                    j27 = totalLength;
                                                    j26 = j17;
                                                    str16 = "DelPlayListFile ";
                                                    str26 = str26;
                                                    z17 = true;
                                                    j19 = j57;
                                                    str15 = str30;
                                                    str3 = str29;
                                                    i16 = 0;
                                                    str18 = str16;
                                                    str19 = str15;
                                                    if (iOException instanceof HttpDataSource.InvalidResponseCodeException) {
                                                    }
                                                    if (videoRequest.shouldCancel()) {
                                                    }
                                                    PlayerUtils.log(4, str5, str23 + (i26 == true ? 1 : 0) + str24 + j3 + str19 + j56);
                                                    dataSource3.close();
                                                    if (iOException3 == null) {
                                                    }
                                                    if (file != null) {
                                                    }
                                                    onConnectionChangeListener3 = PlayerConfig.g().getOnConnectionChangeListener();
                                                    if (onConnectionChangeListener3 != null) {
                                                    }
                                                    exc2 = iOException3;
                                                    j29 = j39;
                                                    z18 = z17;
                                                    j28 = j26;
                                                    videoProxy.videoRequestManager.removeRequest(videoRequest2);
                                                    if (!videoRequest.isCancelProcceed()) {
                                                    }
                                                    videoRequest2.setIsStopped(true);
                                                    String uuid222222 = videoRequest.getUuid();
                                                    if (PlayerConfig.g().getVideoReporter() != null) {
                                                    }
                                                    String str28222222 = str27;
                                                    HttpErrorListener httpErrorListener322222 = videoProxy.httpUrlErrorListenerMap.get(str28222222);
                                                    HttpErrorListener httpErrorListener2222222 = videoProxy.uuidErrorListenerMap.get(videoRequest.getUuid());
                                                    HashMap hashMap2222222 = new HashMap();
                                                    hashMap2222222.put("priority", Integer.valueOf(videoRequest.getPrority()));
                                                    if (!(exc2 instanceof HttpDataSource.InvalidResponseCodeException)) {
                                                    }
                                                    PlayerUtils.log(4, str17, "writeResponse finish");
                                                    return;
                                                } catch (Exception e56) {
                                                    exc = e56;
                                                    dataSource2 = dataSource3;
                                                    j16 = j57;
                                                    str6 = str25;
                                                    str7 = "DelPlayListFile ";
                                                    str8 = str26;
                                                    i3 = 0;
                                                    z16 = true;
                                                    inputStream2 = inputStream;
                                                    str4 = str30;
                                                    str3 = str29;
                                                    outputStream2 = outputStream;
                                                    StringBuilder sb622 = new StringBuilder();
                                                    sb622.append("other exception ");
                                                    sb622.append(PlayerUtils.getPrintableStackTrace(exc));
                                                    PlayerUtils.log(4, str5, sb622.toString());
                                                    if (videoRequest.shouldCancel()) {
                                                    }
                                                    PlayerUtils.log(4, str5, str2 + i3 + str3 + j3 + str4 + j16);
                                                    dataSource2.close();
                                                    if (file != null) {
                                                    }
                                                    onConnectionChangeListener = PlayerConfig.g().getOnConnectionChangeListener();
                                                    if (onConnectionChangeListener != null) {
                                                    }
                                                    videoProxy = this;
                                                    videoRequest2 = videoRequest;
                                                    exc2 = exc;
                                                    z18 = z16;
                                                    dataSource3 = dataSource2;
                                                    j28 = j17;
                                                    j29 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
                                                    videoProxy.videoRequestManager.removeRequest(videoRequest2);
                                                    if (!videoRequest.isCancelProcceed()) {
                                                    }
                                                    videoRequest2.setIsStopped(true);
                                                    String uuid2222222 = videoRequest.getUuid();
                                                    if (PlayerConfig.g().getVideoReporter() != null) {
                                                    }
                                                    String str282222222 = str27;
                                                    HttpErrorListener httpErrorListener3222222 = videoProxy.httpUrlErrorListenerMap.get(str282222222);
                                                    HttpErrorListener httpErrorListener22222222 = videoProxy.uuidErrorListenerMap.get(videoRequest.getUuid());
                                                    HashMap hashMap22222222 = new HashMap();
                                                    hashMap22222222.put("priority", Integer.valueOf(videoRequest.getPrority()));
                                                    if (!(exc2 instanceof HttpDataSource.InvalidResponseCodeException)) {
                                                    }
                                                    PlayerUtils.log(4, str17, "writeResponse finish");
                                                    return;
                                                } catch (Throwable th16) {
                                                    inputStream3 = inputStream;
                                                    th5 = th16;
                                                    str10 = str30;
                                                    j18 = j57;
                                                    str12 = str25;
                                                    str13 = "DelPlayListFile ";
                                                    str14 = str26;
                                                    i3 = 0;
                                                    iOException2 = null;
                                                    str3 = str29;
                                                    str9 = str2;
                                                    str11 = str5;
                                                    PlayerUtils.log(4, str11, str9 + i3 + str3 + j3 + str10 + j18);
                                                    dataSource3.close();
                                                    if (iOException2 == null) {
                                                    }
                                                    if (file != null) {
                                                    }
                                                    onConnectionChangeListener2 = PlayerConfig.g().getOnConnectionChangeListener();
                                                    if (onConnectionChangeListener2 != null) {
                                                    }
                                                }
                                            } else {
                                                fileType = fileType5;
                                            }
                                        } catch (Exception e57) {
                                            e = e57;
                                            dataSource2 = dataSource3;
                                            j16 = j57;
                                            str6 = str25;
                                            str7 = "DelPlayListFile ";
                                            str8 = str26;
                                            inputStream2 = inputStream;
                                            str4 = str30;
                                            str3 = str29;
                                            outputStream2 = outputStream;
                                            exc = e;
                                            i3 = 0;
                                            z16 = true;
                                            StringBuilder sb6222 = new StringBuilder();
                                            sb6222.append("other exception ");
                                            sb6222.append(PlayerUtils.getPrintableStackTrace(exc));
                                            PlayerUtils.log(4, str5, sb6222.toString());
                                            if (videoRequest.shouldCancel()) {
                                            }
                                            PlayerUtils.log(4, str5, str2 + i3 + str3 + j3 + str4 + j16);
                                            dataSource2.close();
                                            if (file != null) {
                                            }
                                            onConnectionChangeListener = PlayerConfig.g().getOnConnectionChangeListener();
                                            if (onConnectionChangeListener != null) {
                                            }
                                            videoProxy = this;
                                            videoRequest2 = videoRequest;
                                            exc2 = exc;
                                            z18 = z16;
                                            dataSource3 = dataSource2;
                                            j28 = j17;
                                            j29 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
                                            videoProxy.videoRequestManager.removeRequest(videoRequest2);
                                            if (!videoRequest.isCancelProcceed()) {
                                            }
                                            videoRequest2.setIsStopped(true);
                                            String uuid22222222 = videoRequest.getUuid();
                                            if (PlayerConfig.g().getVideoReporter() != null) {
                                            }
                                            String str2822222222 = str27;
                                            HttpErrorListener httpErrorListener32222222 = videoProxy.httpUrlErrorListenerMap.get(str2822222222);
                                            HttpErrorListener httpErrorListener222222222 = videoProxy.uuidErrorListenerMap.get(videoRequest.getUuid());
                                            HashMap hashMap222222222 = new HashMap();
                                            hashMap222222222.put("priority", Integer.valueOf(videoRequest.getPrority()));
                                            if (!(exc2 instanceof HttpDataSource.InvalidResponseCodeException)) {
                                            }
                                            PlayerUtils.log(4, str17, "writeResponse finish");
                                            return;
                                        } catch (Throwable th17) {
                                            str3 = str29;
                                            th5 = th17;
                                            str9 = str2;
                                            str10 = str30;
                                            str11 = str5;
                                            j18 = j57;
                                            str12 = str25;
                                            str13 = "DelPlayListFile ";
                                            str14 = str26;
                                            i3 = 0;
                                            iOException2 = null;
                                            inputStream3 = inputStream;
                                            PlayerUtils.log(4, str11, str9 + i3 + str3 + j3 + str10 + j18);
                                            dataSource3.close();
                                            if (iOException2 == null) {
                                            }
                                            if (file != null) {
                                            }
                                            onConnectionChangeListener2 = PlayerConfig.g().getOnConnectionChangeListener();
                                            if (onConnectionChangeListener2 != null) {
                                            }
                                        }
                                    } catch (IOException e58) {
                                        e = e58;
                                        dataSource4 = dataSource3;
                                        fileType = fileType5;
                                    }
                                } catch (IOException e59) {
                                    e = e59;
                                    dataSource4 = dataSource3;
                                    fileType = fileType5;
                                    j48 = totalLength;
                                    str16 = "DelPlayListFile ";
                                    j19 = j57;
                                    str15 = str30;
                                    str3 = str29;
                                    iOException = e;
                                    str25 = str25;
                                    j27 = j48;
                                    dataSource3 = dataSource4;
                                    j26 = j17;
                                    str26 = str26;
                                    i16 = 0;
                                    z17 = true;
                                    str18 = str16;
                                    str19 = str15;
                                    if (iOException instanceof HttpDataSource.InvalidResponseCodeException) {
                                    }
                                    if (videoRequest.shouldCancel()) {
                                    }
                                    PlayerUtils.log(4, str5, str23 + (i26 == true ? 1 : 0) + str24 + j3 + str19 + j56);
                                    dataSource3.close();
                                    if (iOException3 == null) {
                                    }
                                    if (file != null) {
                                    }
                                    onConnectionChangeListener3 = PlayerConfig.g().getOnConnectionChangeListener();
                                    if (onConnectionChangeListener3 != null) {
                                    }
                                    exc2 = iOException3;
                                    j29 = j39;
                                    z18 = z17;
                                    j28 = j26;
                                    videoProxy.videoRequestManager.removeRequest(videoRequest2);
                                    if (!videoRequest.isCancelProcceed()) {
                                    }
                                    videoRequest2.setIsStopped(true);
                                    String uuid222222222 = videoRequest.getUuid();
                                    if (PlayerConfig.g().getVideoReporter() != null) {
                                    }
                                    String str28222222222 = str27;
                                    HttpErrorListener httpErrorListener322222222 = videoProxy.httpUrlErrorListenerMap.get(str28222222222);
                                    HttpErrorListener httpErrorListener2222222222 = videoProxy.uuidErrorListenerMap.get(videoRequest.getUuid());
                                    HashMap hashMap2222222222 = new HashMap();
                                    hashMap2222222222.put("priority", Integer.valueOf(videoRequest.getPrority()));
                                    if (!(exc2 instanceof HttpDataSource.InvalidResponseCodeException)) {
                                    }
                                    PlayerUtils.log(4, str17, "writeResponse finish");
                                    return;
                                } catch (Exception e65) {
                                    e = e65;
                                    dataSource2 = dataSource3;
                                    str6 = str25;
                                    j16 = j57;
                                } catch (Throwable th18) {
                                    th = th18;
                                    str3 = str29;
                                    th5 = th;
                                    str9 = str2;
                                    str12 = str25;
                                    str10 = str30;
                                    str11 = str5;
                                    j18 = j57;
                                    str13 = "DelPlayListFile ";
                                    str14 = str26;
                                    i3 = 0;
                                    iOException2 = null;
                                    inputStream3 = inputStream;
                                    PlayerUtils.log(4, str11, str9 + i3 + str3 + j3 + str10 + j18);
                                    dataSource3.close();
                                    if (iOException2 == null) {
                                    }
                                    if (file != null) {
                                    }
                                    onConnectionChangeListener2 = PlayerConfig.g().getOnConnectionChangeListener();
                                    if (onConnectionChangeListener2 != null) {
                                    }
                                }
                            } catch (IOException e66) {
                                e = e66;
                                dataSource4 = dataSource3;
                                fileType = fileType5;
                                file = file2;
                            } catch (Exception e67) {
                                e = e67;
                                dataSource2 = dataSource3;
                                file = file2;
                                j16 = j57;
                                str7 = "DelPlayListFile ";
                                inputStream2 = inputStream;
                                str4 = str30;
                                str6 = str25;
                                str8 = str26;
                                str3 = str29;
                                outputStream2 = outputStream;
                                exc = e;
                                i3 = 0;
                                z16 = true;
                                StringBuilder sb62222 = new StringBuilder();
                                sb62222.append("other exception ");
                                sb62222.append(PlayerUtils.getPrintableStackTrace(exc));
                                PlayerUtils.log(4, str5, sb62222.toString());
                                if (videoRequest.shouldCancel()) {
                                }
                                PlayerUtils.log(4, str5, str2 + i3 + str3 + j3 + str4 + j16);
                                dataSource2.close();
                                if (file != null) {
                                }
                                onConnectionChangeListener = PlayerConfig.g().getOnConnectionChangeListener();
                                if (onConnectionChangeListener != null) {
                                }
                                videoProxy = this;
                                videoRequest2 = videoRequest;
                                exc2 = exc;
                                z18 = z16;
                                dataSource3 = dataSource2;
                                j28 = j17;
                                j29 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
                                videoProxy.videoRequestManager.removeRequest(videoRequest2);
                                if (!videoRequest.isCancelProcceed()) {
                                }
                                videoRequest2.setIsStopped(true);
                                String uuid2222222222 = videoRequest.getUuid();
                                if (PlayerConfig.g().getVideoReporter() != null) {
                                }
                                String str282222222222 = str27;
                                HttpErrorListener httpErrorListener3222222222 = videoProxy.httpUrlErrorListenerMap.get(str282222222222);
                                HttpErrorListener httpErrorListener22222222222 = videoProxy.uuidErrorListenerMap.get(videoRequest.getUuid());
                                HashMap hashMap22222222222 = new HashMap();
                                hashMap22222222222.put("priority", Integer.valueOf(videoRequest.getPrority()));
                                if (!(exc2 instanceof HttpDataSource.InvalidResponseCodeException)) {
                                }
                                PlayerUtils.log(4, str17, "writeResponse finish");
                                return;
                            }
                        } catch (IOException e68) {
                            dataSource4 = dataSource3;
                            file = file2;
                            str16 = "DelPlayListFile ";
                            j19 = j57;
                            str15 = str30;
                            str3 = str29;
                            iOException = e68;
                            str25 = str25;
                            j27 = totalLength;
                            fileType = fileType4;
                        } catch (Exception e69) {
                            e = e69;
                        }
                    } catch (IOException e75) {
                        j47 = j46;
                        file = file2;
                        j19 = j57;
                        str16 = "DelPlayListFile ";
                        str15 = str30;
                        str3 = str29;
                        iOException = e75;
                        str25 = str25;
                        fileType = fileType4;
                        dataSource3 = dataSource3;
                        j26 = j47;
                        j27 = -1;
                        str26 = str26;
                        i16 = 0;
                        z17 = true;
                        str18 = str16;
                        str19 = str15;
                        if (iOException instanceof HttpDataSource.InvalidResponseCodeException) {
                        }
                        if (videoRequest.shouldCancel()) {
                        }
                        PlayerUtils.log(4, str5, str23 + (i26 == true ? 1 : 0) + str24 + j3 + str19 + j56);
                        dataSource3.close();
                        if (iOException3 == null) {
                        }
                        if (file != null) {
                        }
                        onConnectionChangeListener3 = PlayerConfig.g().getOnConnectionChangeListener();
                        if (onConnectionChangeListener3 != null) {
                        }
                        exc2 = iOException3;
                        j29 = j39;
                        z18 = z17;
                        j28 = j26;
                        videoProxy.videoRequestManager.removeRequest(videoRequest2);
                        if (!videoRequest.isCancelProcceed()) {
                        }
                        videoRequest2.setIsStopped(true);
                        String uuid22222222222 = videoRequest.getUuid();
                        if (PlayerConfig.g().getVideoReporter() != null) {
                        }
                        String str2822222222222 = str27;
                        HttpErrorListener httpErrorListener32222222222 = videoProxy.httpUrlErrorListenerMap.get(str2822222222222);
                        HttpErrorListener httpErrorListener222222222222 = videoProxy.uuidErrorListenerMap.get(videoRequest.getUuid());
                        HashMap hashMap222222222222 = new HashMap();
                        hashMap222222222222.put("priority", Integer.valueOf(videoRequest.getPrority()));
                        if (!(exc2 instanceof HttpDataSource.InvalidResponseCodeException)) {
                        }
                        PlayerUtils.log(4, str17, "writeResponse finish");
                        return;
                    } catch (Exception e76) {
                        e = e76;
                        dataSource2 = dataSource3;
                        j17 = j46;
                        file = file2;
                        j16 = j57;
                        str7 = "DelPlayListFile ";
                    }
                    try {
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append("totalLength=");
                        sb7.append(totalLength);
                        sb7.append(", send response headers: ");
                        j48 = totalLength;
                        try {
                            sb7.append(PlayerUtils.removeLineBreaks(newResponseHeader, null));
                            PlayerUtils.log(4, str5, sb7.toString());
                            try {
                                bufferedOutputStream2.write(newResponseHeader.getBytes("UTF-8"));
                                bufferedOutputStream2.flush();
                                VideoSpeedReport.g().end(reportPoint);
                                long currentTimeMillis2 = System.currentTimeMillis();
                                i36 = 0;
                                boolean z26 = true;
                                while (true) {
                                    try {
                                        z19 = !Thread.interrupted();
                                        if (!z19) {
                                            break;
                                        }
                                        try {
                                            if (videoRequest.shouldCancel()) {
                                                break;
                                            }
                                            str24 = str29;
                                            str20 = str30;
                                            j56 = j57;
                                            byte[] bArr3 = bArr2;
                                            try {
                                                int read = dataSource3.read(bArr3, 0, 65536);
                                                if (read == -1 || videoRequest.isHeadRequest()) {
                                                    break;
                                                }
                                                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                                                try {
                                                    try {
                                                        z16 = z19;
                                                        if (currentTimeMillis3 > this.mRecvDataTreshold) {
                                                            try {
                                                                PlayerUtils.log(5, str5, " not receive data over " + currentTimeMillis3 + "ms");
                                                            } catch (IOException e77) {
                                                                e = e77;
                                                                iOException = e;
                                                                i16 = i36;
                                                                bufferedOutputStream2 = bufferedOutputStream2;
                                                                j27 = j48;
                                                                j26 = j17;
                                                                j19 = j56;
                                                                str3 = str24;
                                                                str15 = str20;
                                                                str16 = "DelPlayListFile ";
                                                                str26 = str26;
                                                                z17 = z16;
                                                                str18 = str16;
                                                                str19 = str15;
                                                                if (iOException instanceof HttpDataSource.InvalidResponseCodeException) {
                                                                }
                                                                if (videoRequest.shouldCancel()) {
                                                                }
                                                                PlayerUtils.log(4, str5, str23 + (i26 == true ? 1 : 0) + str24 + j3 + str19 + j56);
                                                                dataSource3.close();
                                                                if (iOException3 == null) {
                                                                }
                                                                if (file != null) {
                                                                }
                                                                onConnectionChangeListener3 = PlayerConfig.g().getOnConnectionChangeListener();
                                                                if (onConnectionChangeListener3 != null) {
                                                                }
                                                                exc2 = iOException3;
                                                                j29 = j39;
                                                                z18 = z17;
                                                                j28 = j26;
                                                                videoProxy.videoRequestManager.removeRequest(videoRequest2);
                                                                if (!videoRequest.isCancelProcceed()) {
                                                                }
                                                                videoRequest2.setIsStopped(true);
                                                                String uuid222222222222 = videoRequest.getUuid();
                                                                if (PlayerConfig.g().getVideoReporter() != null) {
                                                                }
                                                                String str28222222222222 = str27;
                                                                HttpErrorListener httpErrorListener322222222222 = videoProxy.httpUrlErrorListenerMap.get(str28222222222222);
                                                                HttpErrorListener httpErrorListener2222222222222 = videoProxy.uuidErrorListenerMap.get(videoRequest.getUuid());
                                                                HashMap hashMap2222222222222 = new HashMap();
                                                                hashMap2222222222222.put("priority", Integer.valueOf(videoRequest.getPrority()));
                                                                if (!(exc2 instanceof HttpDataSource.InvalidResponseCodeException)) {
                                                                }
                                                                PlayerUtils.log(4, str17, "writeResponse finish");
                                                                return;
                                                            } catch (Exception e78) {
                                                                e = e78;
                                                                outputStream2 = outputStream;
                                                                exc = e;
                                                                dataSource2 = dataSource3;
                                                                i3 = i36;
                                                                j16 = j56;
                                                                str3 = str24;
                                                                str4 = str20;
                                                                str6 = str25;
                                                                str7 = "DelPlayListFile ";
                                                                str8 = str26;
                                                                inputStream2 = inputStream;
                                                                StringBuilder sb622222 = new StringBuilder();
                                                                sb622222.append("other exception ");
                                                                sb622222.append(PlayerUtils.getPrintableStackTrace(exc));
                                                                PlayerUtils.log(4, str5, sb622222.toString());
                                                                if (videoRequest.shouldCancel()) {
                                                                }
                                                                PlayerUtils.log(4, str5, str2 + i3 + str3 + j3 + str4 + j16);
                                                                dataSource2.close();
                                                                if (file != null) {
                                                                }
                                                                onConnectionChangeListener = PlayerConfig.g().getOnConnectionChangeListener();
                                                                if (onConnectionChangeListener != null) {
                                                                }
                                                                videoProxy = this;
                                                                videoRequest2 = videoRequest;
                                                                exc2 = exc;
                                                                z18 = z16;
                                                                dataSource3 = dataSource2;
                                                                j28 = j17;
                                                                j29 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
                                                                videoProxy.videoRequestManager.removeRequest(videoRequest2);
                                                                if (!videoRequest.isCancelProcceed()) {
                                                                }
                                                                videoRequest2.setIsStopped(true);
                                                                String uuid2222222222222 = videoRequest.getUuid();
                                                                if (PlayerConfig.g().getVideoReporter() != null) {
                                                                }
                                                                String str282222222222222 = str27;
                                                                HttpErrorListener httpErrorListener3222222222222 = videoProxy.httpUrlErrorListenerMap.get(str282222222222222);
                                                                HttpErrorListener httpErrorListener22222222222222 = videoProxy.uuidErrorListenerMap.get(videoRequest.getUuid());
                                                                HashMap hashMap22222222222222 = new HashMap();
                                                                hashMap22222222222222.put("priority", Integer.valueOf(videoRequest.getPrority()));
                                                                if (!(exc2 instanceof HttpDataSource.InvalidResponseCodeException)) {
                                                                }
                                                                PlayerUtils.log(4, str17, "writeResponse finish");
                                                                return;
                                                            }
                                                        }
                                                        long currentTimeMillis4 = System.currentTimeMillis();
                                                        if (i36 == 0 && j3 == 0) {
                                                            if (dataSource3 instanceof CacheDataSource) {
                                                                dataSource6 = ((CacheDataSource) dataSource3).getUpstreamDataSource();
                                                            } else {
                                                                dataSource6 = dataSource3 instanceof HttpDataSource ? dataSource3 : null;
                                                            }
                                                            if (dataSource6 != null && (dataSource6 instanceof HttpDataSource)) {
                                                                Predicate<String> contentPredicator = ((HttpDataSource) dataSource6).getContentPredicator();
                                                                if (contentPredicator != null) {
                                                                    if (!contentPredicator.evaluate(bArr3)) {
                                                                        throw new HttpDataSource.InvalidContentException("invalid content", dataSpec4);
                                                                    }
                                                                } else {
                                                                    dataSpec2 = dataSpec4;
                                                                    j49 = currentTimeMillis4;
                                                                    PlayerUtils.log(6, str5, "predicator is null");
                                                                    bufferedOutputStream2.write(bArr3, 0, read);
                                                                    i36 += read;
                                                                    videoRequest.updateSentBytes(read);
                                                                    videoRequest.setDownloadedBytes(i36);
                                                                    bArr2 = bArr3;
                                                                    dataSpec4 = dataSpec2;
                                                                    z26 = z16;
                                                                    currentTimeMillis2 = j49;
                                                                    j57 = j56;
                                                                    str29 = str24;
                                                                    str30 = str20;
                                                                }
                                                            }
                                                        }
                                                        j49 = currentTimeMillis4;
                                                        dataSpec2 = dataSpec4;
                                                        bufferedOutputStream2.write(bArr3, 0, read);
                                                        i36 += read;
                                                        videoRequest.updateSentBytes(read);
                                                        videoRequest.setDownloadedBytes(i36);
                                                        bArr2 = bArr3;
                                                        dataSpec4 = dataSpec2;
                                                        z26 = z16;
                                                        currentTimeMillis2 = j49;
                                                        j57 = j56;
                                                        str29 = str24;
                                                        str30 = str20;
                                                    } catch (IOException e79) {
                                                        e = e79;
                                                        z16 = z19;
                                                        iOException = e;
                                                        i16 = i36;
                                                        bufferedOutputStream2 = bufferedOutputStream2;
                                                        j27 = j48;
                                                        j26 = j17;
                                                        j19 = j56;
                                                        str3 = str24;
                                                        str15 = str20;
                                                        str16 = "DelPlayListFile ";
                                                        str26 = str26;
                                                        z17 = z16;
                                                        str18 = str16;
                                                        str19 = str15;
                                                        if (iOException instanceof HttpDataSource.InvalidResponseCodeException) {
                                                        }
                                                        if (videoRequest.shouldCancel()) {
                                                        }
                                                        PlayerUtils.log(4, str5, str23 + (i26 == true ? 1 : 0) + str24 + j3 + str19 + j56);
                                                        dataSource3.close();
                                                        if (iOException3 == null) {
                                                        }
                                                        if (file != null) {
                                                        }
                                                        onConnectionChangeListener3 = PlayerConfig.g().getOnConnectionChangeListener();
                                                        if (onConnectionChangeListener3 != null) {
                                                        }
                                                        exc2 = iOException3;
                                                        j29 = j39;
                                                        z18 = z17;
                                                        j28 = j26;
                                                        videoProxy.videoRequestManager.removeRequest(videoRequest2);
                                                        if (!videoRequest.isCancelProcceed()) {
                                                        }
                                                        videoRequest2.setIsStopped(true);
                                                        String uuid22222222222222 = videoRequest.getUuid();
                                                        if (PlayerConfig.g().getVideoReporter() != null) {
                                                        }
                                                        String str2822222222222222 = str27;
                                                        HttpErrorListener httpErrorListener32222222222222 = videoProxy.httpUrlErrorListenerMap.get(str2822222222222222);
                                                        HttpErrorListener httpErrorListener222222222222222 = videoProxy.uuidErrorListenerMap.get(videoRequest.getUuid());
                                                        HashMap hashMap222222222222222 = new HashMap();
                                                        hashMap222222222222222.put("priority", Integer.valueOf(videoRequest.getPrority()));
                                                        if (!(exc2 instanceof HttpDataSource.InvalidResponseCodeException)) {
                                                        }
                                                        PlayerUtils.log(4, str17, "writeResponse finish");
                                                        return;
                                                    } catch (Exception e85) {
                                                        e = e85;
                                                        z16 = z19;
                                                        outputStream2 = outputStream;
                                                        exc = e;
                                                        dataSource2 = dataSource3;
                                                        i3 = i36;
                                                        j16 = j56;
                                                        str3 = str24;
                                                        str4 = str20;
                                                        str6 = str25;
                                                        str7 = "DelPlayListFile ";
                                                        str8 = str26;
                                                        inputStream2 = inputStream;
                                                        StringBuilder sb6222222 = new StringBuilder();
                                                        sb6222222.append("other exception ");
                                                        sb6222222.append(PlayerUtils.getPrintableStackTrace(exc));
                                                        PlayerUtils.log(4, str5, sb6222222.toString());
                                                        if (videoRequest.shouldCancel()) {
                                                        }
                                                        PlayerUtils.log(4, str5, str2 + i3 + str3 + j3 + str4 + j16);
                                                        dataSource2.close();
                                                        if (file != null) {
                                                        }
                                                        onConnectionChangeListener = PlayerConfig.g().getOnConnectionChangeListener();
                                                        if (onConnectionChangeListener != null) {
                                                        }
                                                        videoProxy = this;
                                                        videoRequest2 = videoRequest;
                                                        exc2 = exc;
                                                        z18 = z16;
                                                        dataSource3 = dataSource2;
                                                        j28 = j17;
                                                        j29 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
                                                        videoProxy.videoRequestManager.removeRequest(videoRequest2);
                                                        if (!videoRequest.isCancelProcceed()) {
                                                        }
                                                        videoRequest2.setIsStopped(true);
                                                        String uuid222222222222222 = videoRequest.getUuid();
                                                        if (PlayerConfig.g().getVideoReporter() != null) {
                                                        }
                                                        String str28222222222222222 = str27;
                                                        HttpErrorListener httpErrorListener322222222222222 = videoProxy.httpUrlErrorListenerMap.get(str28222222222222222);
                                                        HttpErrorListener httpErrorListener2222222222222222 = videoProxy.uuidErrorListenerMap.get(videoRequest.getUuid());
                                                        HashMap hashMap2222222222222222 = new HashMap();
                                                        hashMap2222222222222222.put("priority", Integer.valueOf(videoRequest.getPrority()));
                                                        if (!(exc2 instanceof HttpDataSource.InvalidResponseCodeException)) {
                                                        }
                                                        PlayerUtils.log(4, str17, "writeResponse finish");
                                                        return;
                                                    }
                                                } catch (Throwable th19) {
                                                    th = th19;
                                                    inputStream3 = inputStream;
                                                    th5 = th;
                                                    i3 = i36;
                                                    str9 = str2;
                                                    str11 = str5;
                                                    j18 = j56;
                                                    str3 = str24;
                                                    str10 = str20;
                                                    str12 = str25;
                                                    str13 = "DelPlayListFile ";
                                                    str14 = str26;
                                                    iOException2 = null;
                                                    PlayerUtils.log(4, str11, str9 + i3 + str3 + j3 + str10 + j18);
                                                    dataSource3.close();
                                                    if (iOException2 == null) {
                                                    }
                                                    if (file != null) {
                                                    }
                                                    onConnectionChangeListener2 = PlayerConfig.g().getOnConnectionChangeListener();
                                                    if (onConnectionChangeListener2 != null) {
                                                    }
                                                }
                                            } catch (IOException e86) {
                                                e = e86;
                                            } catch (Exception e87) {
                                                e = e87;
                                            } catch (Throwable th20) {
                                                th = th20;
                                            }
                                        } catch (IOException e88) {
                                            j56 = j57;
                                            iOException = e88;
                                            str15 = str30;
                                            bufferedOutputStream2 = bufferedOutputStream2;
                                            j27 = j48;
                                            j26 = j17;
                                            j19 = j56;
                                            str26 = str26;
                                            str3 = str29;
                                            z17 = z19;
                                            i16 = i36;
                                            str16 = "DelPlayListFile ";
                                            str18 = str16;
                                            str19 = str15;
                                            if (iOException instanceof HttpDataSource.InvalidResponseCodeException) {
                                            }
                                            if (videoRequest.shouldCancel()) {
                                            }
                                            PlayerUtils.log(4, str5, str23 + (i26 == true ? 1 : 0) + str24 + j3 + str19 + j56);
                                            dataSource3.close();
                                            if (iOException3 == null) {
                                            }
                                            if (file != null) {
                                            }
                                            onConnectionChangeListener3 = PlayerConfig.g().getOnConnectionChangeListener();
                                            if (onConnectionChangeListener3 != null) {
                                            }
                                            exc2 = iOException3;
                                            j29 = j39;
                                            z18 = z17;
                                            j28 = j26;
                                            videoProxy.videoRequestManager.removeRequest(videoRequest2);
                                            if (!videoRequest.isCancelProcceed()) {
                                            }
                                            videoRequest2.setIsStopped(true);
                                            String uuid2222222222222222 = videoRequest.getUuid();
                                            if (PlayerConfig.g().getVideoReporter() != null) {
                                            }
                                            String str282222222222222222 = str27;
                                            HttpErrorListener httpErrorListener3222222222222222 = videoProxy.httpUrlErrorListenerMap.get(str282222222222222222);
                                            HttpErrorListener httpErrorListener22222222222222222 = videoProxy.uuidErrorListenerMap.get(videoRequest.getUuid());
                                            HashMap hashMap22222222222222222 = new HashMap();
                                            hashMap22222222222222222.put("priority", Integer.valueOf(videoRequest.getPrority()));
                                            if (!(exc2 instanceof HttpDataSource.InvalidResponseCodeException)) {
                                            }
                                            PlayerUtils.log(4, str17, "writeResponse finish");
                                            return;
                                        } catch (Exception e89) {
                                            z16 = z19;
                                            long j65 = j57;
                                            exc = e89;
                                            dataSource2 = dataSource3;
                                            i3 = i36;
                                            str4 = str30;
                                            j16 = j65;
                                            str6 = str25;
                                            str7 = "DelPlayListFile ";
                                            str8 = str26;
                                            inputStream2 = inputStream;
                                            str3 = str29;
                                            outputStream2 = outputStream;
                                            StringBuilder sb62222222 = new StringBuilder();
                                            sb62222222.append("other exception ");
                                            sb62222222.append(PlayerUtils.getPrintableStackTrace(exc));
                                            PlayerUtils.log(4, str5, sb62222222.toString());
                                            if (videoRequest.shouldCancel()) {
                                            }
                                            PlayerUtils.log(4, str5, str2 + i3 + str3 + j3 + str4 + j16);
                                            dataSource2.close();
                                            if (file != null) {
                                            }
                                            onConnectionChangeListener = PlayerConfig.g().getOnConnectionChangeListener();
                                            if (onConnectionChangeListener != null) {
                                            }
                                            videoProxy = this;
                                            videoRequest2 = videoRequest;
                                            exc2 = exc;
                                            z18 = z16;
                                            dataSource3 = dataSource2;
                                            j28 = j17;
                                            j29 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
                                            videoProxy.videoRequestManager.removeRequest(videoRequest2);
                                            if (!videoRequest.isCancelProcceed()) {
                                            }
                                            videoRequest2.setIsStopped(true);
                                            String uuid22222222222222222 = videoRequest.getUuid();
                                            if (PlayerConfig.g().getVideoReporter() != null) {
                                            }
                                            String str2822222222222222222 = str27;
                                            HttpErrorListener httpErrorListener32222222222222222 = videoProxy.httpUrlErrorListenerMap.get(str2822222222222222222);
                                            HttpErrorListener httpErrorListener222222222222222222 = videoProxy.uuidErrorListenerMap.get(videoRequest.getUuid());
                                            HashMap hashMap222222222222222222 = new HashMap();
                                            hashMap222222222222222222.put("priority", Integer.valueOf(videoRequest.getPrority()));
                                            if (!(exc2 instanceof HttpDataSource.InvalidResponseCodeException)) {
                                            }
                                            PlayerUtils.log(4, str17, "writeResponse finish");
                                            return;
                                        } catch (Throwable th21) {
                                            inputStream3 = inputStream;
                                            th5 = th21;
                                            i3 = i36;
                                            str10 = str30;
                                            j18 = j57;
                                            str12 = str25;
                                            str13 = "DelPlayListFile ";
                                            str14 = str26;
                                            iOException2 = null;
                                            str3 = str29;
                                            str9 = str2;
                                            str11 = str5;
                                            PlayerUtils.log(4, str11, str9 + i3 + str3 + j3 + str10 + j18);
                                            dataSource3.close();
                                            if (iOException2 == null) {
                                            }
                                            if (file != null) {
                                            }
                                            onConnectionChangeListener2 = PlayerConfig.g().getOnConnectionChangeListener();
                                            if (onConnectionChangeListener2 != null) {
                                            }
                                        }
                                    } catch (IOException e95) {
                                        dataSource5 = dataSource3;
                                        i38 = i36;
                                        z16 = z26;
                                        bufferedOutputStream2 = bufferedOutputStream2;
                                        j19 = j57;
                                        str16 = "DelPlayListFile ";
                                        str15 = str30;
                                        str3 = str29;
                                        iOException = e95;
                                    } catch (Exception e96) {
                                        e = e96;
                                        dataSource2 = dataSource3;
                                        i37 = i36;
                                        z16 = z26;
                                        j16 = j57;
                                        str7 = "DelPlayListFile ";
                                        str8 = str26;
                                        inputStream2 = inputStream;
                                        str4 = str30;
                                        str3 = str29;
                                        outputStream2 = outputStream;
                                    } catch (Throwable th22) {
                                        long j66 = j57;
                                        String str31 = str30;
                                        str3 = str29;
                                        th5 = th22;
                                        str9 = str2;
                                        str10 = str31;
                                        str11 = str5;
                                        j18 = j66;
                                        i3 = i36;
                                        str12 = str25;
                                        str13 = "DelPlayListFile ";
                                        str14 = str26;
                                        iOException2 = null;
                                        inputStream3 = inputStream;
                                        PlayerUtils.log(4, str11, str9 + i3 + str3 + j3 + str10 + j18);
                                        dataSource3.close();
                                        if (iOException2 == null) {
                                        }
                                        if (file != null) {
                                        }
                                        onConnectionChangeListener2 = PlayerConfig.g().getOnConnectionChangeListener();
                                        if (onConnectionChangeListener2 != null) {
                                        }
                                    }
                                }
                                videoProxy2 = this;
                                z16 = z19;
                                if (!z16) {
                                    videoRequest.setStoppedReason(256);
                                    PlayerUtils.log(4, str5, videoRequest + " is interrupted");
                                }
                            } catch (IOException e97) {
                                e = e97;
                                dataSource4 = dataSource3;
                                bufferedOutputStream2 = bufferedOutputStream2;
                                j19 = j57;
                                str16 = "DelPlayListFile ";
                                str15 = str30;
                                str3 = str29;
                                iOException = e;
                                j27 = j48;
                                dataSource3 = dataSource4;
                                j26 = j17;
                                str26 = str26;
                                i16 = 0;
                                z17 = true;
                                str18 = str16;
                                str19 = str15;
                                if (iOException instanceof HttpDataSource.InvalidResponseCodeException) {
                                }
                                if (videoRequest.shouldCancel()) {
                                }
                                PlayerUtils.log(4, str5, str23 + (i26 == true ? 1 : 0) + str24 + j3 + str19 + j56);
                                dataSource3.close();
                                if (iOException3 == null) {
                                }
                                if (file != null) {
                                }
                                onConnectionChangeListener3 = PlayerConfig.g().getOnConnectionChangeListener();
                                if (onConnectionChangeListener3 != null) {
                                }
                                exc2 = iOException3;
                                j29 = j39;
                                z18 = z17;
                                j28 = j26;
                                videoProxy.videoRequestManager.removeRequest(videoRequest2);
                                if (!videoRequest.isCancelProcceed()) {
                                }
                                videoRequest2.setIsStopped(true);
                                String uuid222222222222222222 = videoRequest.getUuid();
                                if (PlayerConfig.g().getVideoReporter() != null) {
                                }
                                String str28222222222222222222 = str27;
                                HttpErrorListener httpErrorListener322222222222222222 = videoProxy.httpUrlErrorListenerMap.get(str28222222222222222222);
                                HttpErrorListener httpErrorListener2222222222222222222 = videoProxy.uuidErrorListenerMap.get(videoRequest.getUuid());
                                HashMap hashMap2222222222222222222 = new HashMap();
                                hashMap2222222222222222222.put("priority", Integer.valueOf(videoRequest.getPrority()));
                                if (!(exc2 instanceof HttpDataSource.InvalidResponseCodeException)) {
                                }
                                PlayerUtils.log(4, str17, "writeResponse finish");
                                return;
                            }
                        } catch (IOException e98) {
                            e = e98;
                            dataSource4 = dataSource3;
                        }
                        try {
                            try {
                                if (videoRequest.shouldCancel()) {
                                    videoRequest.enterCancelProceedState();
                                }
                                bufferedOutputStream2.flush();
                            } catch (Exception e99) {
                                e = e99;
                                outputStream2 = outputStream;
                                dataSource2 = dataSource3;
                                i37 = i36;
                                j16 = j56;
                                str3 = str24;
                                str4 = str20;
                                str7 = "DelPlayListFile ";
                                str8 = str26;
                                inputStream2 = inputStream;
                                exc = e;
                                i3 = i37;
                                str6 = str25;
                                StringBuilder sb622222222 = new StringBuilder();
                                sb622222222.append("other exception ");
                                sb622222222.append(PlayerUtils.getPrintableStackTrace(exc));
                                PlayerUtils.log(4, str5, sb622222222.toString());
                                if (videoRequest.shouldCancel()) {
                                }
                                PlayerUtils.log(4, str5, str2 + i3 + str3 + j3 + str4 + j16);
                                dataSource2.close();
                                if (file != null) {
                                    delete = file.delete();
                                    PlayerUtils.log(4, str5, str7 + file.toString());
                                    if (!delete) {
                                    }
                                }
                                onConnectionChangeListener = PlayerConfig.g().getOnConnectionChangeListener();
                                if (onConnectionChangeListener != null) {
                                }
                                videoProxy = this;
                                videoRequest2 = videoRequest;
                                exc2 = exc;
                                z18 = z16;
                                dataSource3 = dataSource2;
                                j28 = j17;
                                j29 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
                                videoProxy.videoRequestManager.removeRequest(videoRequest2);
                                if (!videoRequest.isCancelProcceed()) {
                                }
                                videoRequest2.setIsStopped(true);
                                String uuid2222222222222222222 = videoRequest.getUuid();
                                if (PlayerConfig.g().getVideoReporter() != null) {
                                }
                                String str282222222222222222222 = str27;
                                HttpErrorListener httpErrorListener3222222222222222222 = videoProxy.httpUrlErrorListenerMap.get(str282222222222222222222);
                                HttpErrorListener httpErrorListener22222222222222222222 = videoProxy.uuidErrorListenerMap.get(videoRequest.getUuid());
                                HashMap hashMap22222222222222222222 = new HashMap();
                                hashMap22222222222222222222.put("priority", Integer.valueOf(videoRequest.getPrority()));
                                if (!(exc2 instanceof HttpDataSource.InvalidResponseCodeException)) {
                                }
                                PlayerUtils.log(4, str17, "writeResponse finish");
                                return;
                            } catch (Throwable th23) {
                                inputStream3 = inputStream;
                                th5 = th23;
                                str9 = str2;
                                str11 = str5;
                                i3 = i36;
                                j18 = j56;
                                str3 = str24;
                                str10 = str20;
                                str12 = str25;
                                str13 = "DelPlayListFile ";
                                str14 = str26;
                                iOException2 = null;
                                PlayerUtils.log(4, str11, str9 + i3 + str3 + j3 + str10 + j18);
                                dataSource3.close();
                                if (iOException2 == null) {
                                }
                                if (file != null) {
                                }
                                onConnectionChangeListener2 = PlayerConfig.g().getOnConnectionChangeListener();
                                if (onConnectionChangeListener2 != null) {
                                }
                            }
                            try {
                                bufferedOutputStream2.close();
                                PlayerUtils.log(4, str5, str2 + i36 + str24 + j3 + str20 + j56);
                                try {
                                    dataSource3.close();
                                } catch (IOException unused7) {
                                    PlayerUtils.log(5, str5, str25);
                                }
                                try {
                                    socket.close();
                                } catch (IOException unused8) {
                                }
                                if (file != null && file.isFile() && file.exists()) {
                                    boolean delete5 = file.delete();
                                    PlayerUtils.log(4, str5, "DelPlayListFile " + file.toString());
                                    if (!delete5) {
                                        PlayerUtils.log(5, str5, str26 + file.toString());
                                    }
                                }
                                OnConnectionChangeListener onConnectionChangeListener5 = PlayerConfig.g().getOnConnectionChangeListener();
                                if (onConnectionChangeListener5 != null) {
                                    onConnectionChangeListener5.onConnectionChange(false, inputStream, outputStream);
                                }
                                videoRequest2 = videoRequest;
                                videoProxy = videoProxy2;
                                z18 = z16;
                                j28 = j17;
                                j29 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
                                exc2 = null;
                            } catch (Exception e100) {
                                outputStream2 = outputStream;
                                dataSource2 = dataSource3;
                                j16 = j56;
                                str3 = str24;
                                str4 = str20;
                                inputStream2 = inputStream;
                                exc = e100;
                                i3 = i36;
                                str6 = str25;
                                str7 = "DelPlayListFile ";
                                str8 = str26;
                                StringBuilder sb6222222222 = new StringBuilder();
                                sb6222222222.append("other exception ");
                                sb6222222222.append(PlayerUtils.getPrintableStackTrace(exc));
                                PlayerUtils.log(4, str5, sb6222222222.toString());
                                if (videoRequest.shouldCancel()) {
                                    videoRequest.enterCancelProceedState();
                                }
                                PlayerUtils.log(4, str5, str2 + i3 + str3 + j3 + str4 + j16);
                                dataSource2.close();
                                if (file != null && file.isFile() && file.exists()) {
                                    delete = file.delete();
                                    PlayerUtils.log(4, str5, str7 + file.toString());
                                    if (!delete) {
                                        PlayerUtils.log(5, str5, str8 + file.toString());
                                    }
                                }
                                onConnectionChangeListener = PlayerConfig.g().getOnConnectionChangeListener();
                                if (onConnectionChangeListener != null) {
                                    onConnectionChangeListener.onConnectionChange(false, inputStream, outputStream2);
                                }
                                videoProxy = this;
                                videoRequest2 = videoRequest;
                                exc2 = exc;
                                z18 = z16;
                                dataSource3 = dataSource2;
                                j28 = j17;
                                j29 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
                                videoProxy.videoRequestManager.removeRequest(videoRequest2);
                                if (!videoRequest.isCancelProcceed()) {
                                }
                                videoRequest2.setIsStopped(true);
                                String uuid22222222222222222222 = videoRequest.getUuid();
                                if (PlayerConfig.g().getVideoReporter() != null) {
                                }
                                String str2822222222222222222222 = str27;
                                HttpErrorListener httpErrorListener32222222222222222222 = videoProxy.httpUrlErrorListenerMap.get(str2822222222222222222222);
                                HttpErrorListener httpErrorListener222222222222222222222 = videoProxy.uuidErrorListenerMap.get(videoRequest.getUuid());
                                HashMap hashMap222222222222222222222 = new HashMap();
                                hashMap222222222222222222222.put("priority", Integer.valueOf(videoRequest.getPrority()));
                                if (!(exc2 instanceof HttpDataSource.InvalidResponseCodeException)) {
                                }
                                PlayerUtils.log(4, str17, "writeResponse finish");
                                return;
                            } catch (Throwable th24) {
                                th = th24;
                                inputStream3 = inputStream;
                                th5 = th;
                                i3 = i36;
                                str9 = str2;
                                str11 = str5;
                                j18 = j56;
                                str3 = str24;
                                str10 = str20;
                                str12 = str25;
                                str13 = "DelPlayListFile ";
                                str14 = str26;
                                iOException2 = null;
                                PlayerUtils.log(4, str11, str9 + i3 + str3 + j3 + str10 + j18);
                                dataSource3.close();
                                if (iOException2 == null) {
                                }
                                if (file != null) {
                                }
                                onConnectionChangeListener2 = PlayerConfig.g().getOnConnectionChangeListener();
                                if (onConnectionChangeListener2 != null) {
                                }
                            }
                        } catch (IOException e101) {
                            dataSource5 = dataSource3;
                            i38 = i36;
                            j19 = j56;
                            str3 = str24;
                            str15 = str20;
                            str16 = "DelPlayListFile ";
                            iOException = e101;
                            bufferedOutputStream2 = bufferedOutputStream2;
                            j27 = j48;
                            dataSource3 = dataSource5;
                            i16 = i38;
                            j26 = j17;
                            str26 = str26;
                            z17 = z16;
                            str18 = str16;
                            str19 = str15;
                            if (iOException instanceof HttpDataSource.InvalidResponseCodeException) {
                            }
                            if (videoRequest.shouldCancel()) {
                            }
                            PlayerUtils.log(4, str5, str23 + (i26 == true ? 1 : 0) + str24 + j3 + str19 + j56);
                            dataSource3.close();
                            if (iOException3 == null) {
                            }
                            if (file != null) {
                                delete3 = file.delete();
                                PlayerUtils.log(4, str5, str18 + file.toString());
                                if (!delete3) {
                                }
                            }
                            onConnectionChangeListener3 = PlayerConfig.g().getOnConnectionChangeListener();
                            if (onConnectionChangeListener3 != null) {
                            }
                            exc2 = iOException3;
                            j29 = j39;
                            z18 = z17;
                            j28 = j26;
                            videoProxy.videoRequestManager.removeRequest(videoRequest2);
                            if (!videoRequest.isCancelProcceed()) {
                            }
                            videoRequest2.setIsStopped(true);
                            String uuid222222222222222222222 = videoRequest.getUuid();
                            if (PlayerConfig.g().getVideoReporter() != null) {
                            }
                            String str28222222222222222222222 = str27;
                            HttpErrorListener httpErrorListener322222222222222222222 = videoProxy.httpUrlErrorListenerMap.get(str28222222222222222222222);
                            HttpErrorListener httpErrorListener2222222222222222222222 = videoProxy.uuidErrorListenerMap.get(videoRequest.getUuid());
                            HashMap hashMap2222222222222222222222 = new HashMap();
                            hashMap2222222222222222222222.put("priority", Integer.valueOf(videoRequest.getPrority()));
                            if (!(exc2 instanceof HttpDataSource.InvalidResponseCodeException)) {
                            }
                            PlayerUtils.log(4, str17, "writeResponse finish");
                            return;
                        }
                    } catch (IOException e102) {
                        e = e102;
                        dataSource4 = dataSource3;
                        j48 = totalLength;
                        str16 = "DelPlayListFile ";
                        j19 = j57;
                        str15 = str30;
                        str3 = str29;
                        iOException = e;
                        j27 = j48;
                        dataSource3 = dataSource4;
                        j26 = j17;
                        str26 = str26;
                        i16 = 0;
                        z17 = true;
                        str18 = str16;
                        str19 = str15;
                        if (iOException instanceof HttpDataSource.InvalidResponseCodeException) {
                            try {
                                HttpDataSource.InvalidResponseCodeException invalidResponseCodeException = (HttpDataSource.InvalidResponseCodeException) iOException;
                                str24 = str3;
                                if (videoRequest.getPrority() == 90) {
                                    try {
                                        if (invalidResponseCodeException.responseCode == 416) {
                                            videoProxy = this;
                                            try {
                                                str23 = str2;
                                                r28 = i16;
                                            } catch (Throwable th25) {
                                                th = th25;
                                                int i46 = i16;
                                                th5 = th;
                                                iOException2 = iOException;
                                                str9 = str2;
                                                str11 = str5;
                                                j18 = j19;
                                                i3 = i46;
                                                str3 = str24;
                                                str10 = str19;
                                                str12 = str25;
                                                str13 = str18;
                                                str14 = str26;
                                                inputStream3 = inputStream;
                                                PlayerUtils.log(4, str11, str9 + i3 + str3 + j3 + str10 + j18);
                                                dataSource3.close();
                                                if (iOException2 == null) {
                                                }
                                                if (file != null) {
                                                }
                                                onConnectionChangeListener2 = PlayerConfig.g().getOnConnectionChangeListener();
                                                if (onConnectionChangeListener2 != null) {
                                                }
                                            }
                                            try {
                                                Iterator<VideoRequest> it = videoProxy.videoRequestManager.getVideoRequestByVideoKey(str27, -1).iterator();
                                                while (true) {
                                                    if (!it.hasNext()) {
                                                        videoRequest2 = videoRequest;
                                                        fileType2 = fileType;
                                                        j38 = -1;
                                                        break;
                                                    }
                                                    VideoRequest next = it.next();
                                                    Iterator<VideoRequest> it5 = it;
                                                    videoRequest2 = videoRequest;
                                                    if (!next.equals(videoRequest2) && next.getTotalLength() != -1) {
                                                        long totalLength2 = next.getTotalLength();
                                                        fileType2 = next.getFileType();
                                                        j38 = totalLength2;
                                                        break;
                                                    }
                                                    it = it5;
                                                }
                                                if (j38 != -1 && j38 == j3 && j19 == -2) {
                                                    str27 = str27;
                                                    String newResponseHeader2 = HttpParser.newResponseHeader(j3, j19, j38, fileType2.toString(), !PlayerUtils.isHLSStream(str));
                                                    j56 = j19;
                                                    if (fileType2.equals(FileType.UNKNOWN)) {
                                                        PlayerUtils.log(6, str5, "file type should not unknown");
                                                    }
                                                    PlayerUtils.log(4, str5, "totalLength=" + j27 + ", send response headers: " + PlayerUtils.removeLineBreaks(newResponseHeader2, null));
                                                    try {
                                                        BufferedOutputStream bufferedOutputStream3 = bufferedOutputStream2;
                                                        bufferedOutputStream3.write(newResponseHeader2.getBytes("UTF-8"));
                                                        bufferedOutputStream3.flush();
                                                        bufferedOutputStream3.close();
                                                        iOException3 = null;
                                                        i26 = r28;
                                                    } catch (Exception e103) {
                                                        PlayerUtils.log(4, str5, "workaround 416 error ", e103);
                                                        i19 = r28;
                                                        iOException3 = iOException;
                                                        i26 = i19;
                                                        if (iOException3 != null) {
                                                        }
                                                    }
                                                    if (iOException3 != null) {
                                                        try {
                                                            PlayerUtils.log(4, str5, "uri:" + videoRequest.getSourceUrl() + ", InvalidResponseCode: \r\n" + HttpParser.getHeaders(invalidResponseCodeException.headerFields));
                                                            long subErrorCode = PlayerUtils.getSubErrorCode(invalidResponseCodeException.headerFields);
                                                            j26 = PlayerUtils.getDownloadRetCode((long) invalidResponseCodeException.responseCode, subErrorCode);
                                                            j37 = subErrorCode;
                                                            iOException = iOException3;
                                                            i28 = i26;
                                                            iOException3 = iOException;
                                                            j39 = j37;
                                                            i26 = i28;
                                                        } catch (Throwable th26) {
                                                            inputStream3 = inputStream;
                                                            th5 = th26;
                                                            iOException2 = iOException3;
                                                            i18 = i26;
                                                            str11 = str5;
                                                            i3 = i18;
                                                            j18 = j56;
                                                            str9 = str23;
                                                            str3 = str24;
                                                            str10 = str19;
                                                            str12 = str25;
                                                            str13 = str18;
                                                            str14 = str26;
                                                            PlayerUtils.log(4, str11, str9 + i3 + str3 + j3 + str10 + j18);
                                                            dataSource3.close();
                                                            if (iOException2 == null) {
                                                            }
                                                            if (file != null) {
                                                            }
                                                            onConnectionChangeListener2 = PlayerConfig.g().getOnConnectionChangeListener();
                                                            if (onConnectionChangeListener2 != null) {
                                                            }
                                                        }
                                                    } else {
                                                        iOException = iOException3;
                                                        i27 = i26;
                                                    }
                                                } else {
                                                    str27 = str27;
                                                    j56 = j19;
                                                    i19 = r28;
                                                }
                                            } catch (Throwable th27) {
                                                th5 = th27;
                                                iOException2 = iOException;
                                                str11 = str5;
                                                j18 = j19;
                                                i3 = r28;
                                                str9 = str23;
                                                str3 = str24;
                                                str10 = str19;
                                                str12 = str25;
                                                str13 = str18;
                                                str14 = str26;
                                                inputStream3 = inputStream;
                                                PlayerUtils.log(4, str11, str9 + i3 + str3 + j3 + str10 + j18);
                                                dataSource3.close();
                                                if (iOException2 == null) {
                                                }
                                                if (file != null) {
                                                }
                                                onConnectionChangeListener2 = PlayerConfig.g().getOnConnectionChangeListener();
                                                if (onConnectionChangeListener2 != null) {
                                                }
                                            }
                                        } else {
                                            videoProxy = this;
                                            str23 = str2;
                                            i19 = i16;
                                            j56 = j19;
                                            videoRequest2 = videoRequest;
                                        }
                                        iOException3 = iOException;
                                        i26 = i19;
                                        if (iOException3 != null) {
                                        }
                                    } catch (Throwable th28) {
                                        th = th28;
                                    }
                                } else {
                                    videoProxy = this;
                                    str23 = str2;
                                    i27 = i16;
                                    j56 = j19;
                                    videoRequest2 = videoRequest;
                                }
                                j37 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
                                i28 = i27;
                                iOException3 = iOException;
                                j39 = j37;
                                i26 = i28;
                            } catch (Throwable th29) {
                                int i47 = i16;
                                th5 = th29;
                                iOException2 = iOException;
                                str9 = str2;
                                str11 = str5;
                                j18 = j19;
                                i3 = i47;
                            }
                        } else {
                            videoProxy = this;
                            str23 = str2;
                            int i48 = i16;
                            str24 = str3;
                            j56 = j19;
                            videoRequest2 = videoRequest;
                            try {
                                if (iOException instanceof HttpDataSource.InvalidContentTypeException) {
                                    HttpDataSource.InvalidContentTypeException invalidContentTypeException = (HttpDataSource.InvalidContentTypeException) iOException;
                                    i27 = i48;
                                    if (videoRequest.getPrority() == 90) {
                                        PlayerUtils.log(4, str5, "uri:" + videoRequest.getSourceUrl() + ", InvalidContentType: \r\n" + HttpParser.getHeaders(invalidContentTypeException.headerFields));
                                        long subErrorCode2 = PlayerUtils.getSubErrorCode(invalidContentTypeException.headerFields);
                                        j26 = PlayerUtils.getDownloadRetCode(3L, subErrorCode2);
                                        j37 = subErrorCode2;
                                        i28 = i48;
                                        iOException3 = iOException;
                                        j39 = j37;
                                        i26 = i28;
                                    }
                                    j37 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
                                    i28 = i27;
                                    iOException3 = iOException;
                                    j39 = j37;
                                    i26 = i28;
                                } else {
                                    if (iOException instanceof HttpDataSource.InvalidContentException) {
                                        if (videoRequest.getPrority() == 90) {
                                            PlayerUtils.log(4, str5, "uri:" + videoRequest.getSourceUrl() + ", InvalidContent");
                                            j39 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
                                            j26 = PlayerUtils.getDownloadRetCode(10L, VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE);
                                        } else {
                                            j39 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
                                        }
                                    } else {
                                        j39 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
                                        if (iOException instanceof HttpDataSource.MalformedResponseException) {
                                            if (videoRequest.getPrority() == 90) {
                                                PlayerUtils.log(4, str5, "uri:" + videoRequest.getSourceUrl() + ", MalformedResponse");
                                                j26 = PlayerUtils.getDownloadRetCode(12L, VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE);
                                            }
                                        } else {
                                            if (iOException instanceof HttpDataSource.InterruptConnectServerException) {
                                                videoRequest2.setStoppedReason(256);
                                                PlayerUtils.log(5, str5, videoRequest2 + " connect to server interrupted");
                                            } else if (iOException instanceof HttpDataSource.InterruptReadException) {
                                                videoRequest2.setStoppedReason(256);
                                                PlayerUtils.log(5, str5, videoRequest2 + " read interrupted");
                                            } else if (iOException instanceof HttpDataSource.UnableConnectServerException) {
                                                PlayerUtils.log(5, str5, "uri:" + videoRequest2 + ", unable to connect server: " + PlayerUtils.getPrintableStackTrace(iOException));
                                                if (videoRequest.getPrority() == 90) {
                                                    if (dataSource3 instanceof CacheDataSource) {
                                                        DataSource upstreamDataSource2 = ((CacheDataSource) dataSource3).getUpstreamDataSource();
                                                        if (upstreamDataSource2 instanceof DefaultHttpDataSource) {
                                                            dataSpec = ((DefaultHttpDataSource) upstreamDataSource2).getDataSpec();
                                                            if (dataSpec == null && (uri = dataSpec.uri) != null && uri.getHost() != null && uri.getHost().equals("127.0.0.1")) {
                                                                i29 = PlayerUtils.isNetworkAvailable() ? 5 : 9;
                                                            } else {
                                                                i29 = 13;
                                                            }
                                                            j26 = PlayerUtils.getDownloadRetCode(i29, VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE);
                                                        } else {
                                                            PlayerUtils.log(4, str5, "cacheDataSource dataSpec error");
                                                            dataSpec = null;
                                                            if (dataSpec == null && (uri = dataSpec.uri) != null && uri.getHost() != null && uri.getHost().equals("127.0.0.1")) {
                                                            }
                                                            j26 = PlayerUtils.getDownloadRetCode(i29, VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE);
                                                        }
                                                    } else {
                                                        if (dataSource3 instanceof DefaultHttpDataSource) {
                                                            dataSpec = ((DefaultHttpDataSource) dataSource3).getDataSpec();
                                                            if (dataSpec == null && (uri = dataSpec.uri) != null && uri.getHost() != null && uri.getHost().equals("127.0.0.1")) {
                                                            }
                                                            j26 = PlayerUtils.getDownloadRetCode(i29, VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE);
                                                        }
                                                        dataSpec = null;
                                                        if (dataSpec == null && (uri = dataSpec.uri) != null && uri.getHost() != null && uri.getHost().equals("127.0.0.1")) {
                                                        }
                                                        j26 = PlayerUtils.getDownloadRetCode(i29, VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE);
                                                    }
                                                }
                                            } else if (iOException instanceof HttpDataSource.HttpDataSourceException) {
                                                PlayerUtils.log(5, str5, "uri:" + videoRequest2 + ", read upstream error: " + PlayerUtils.getPrintableStackTrace(iOException));
                                                if (videoRequest.getPrority() == 90) {
                                                    j26 = PlayerUtils.getDownloadRetCode(videoProxy.getFakeHttpStatus(iOException), VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE);
                                                }
                                            } else if ((dataSource3 instanceof FileDataSource) && (iOException instanceof FileDataSource.FileDataSourceException)) {
                                                if (videoRequest.getPrority() == 90) {
                                                    j26 = PlayerUtils.getDownloadRetCode(1404L, VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE);
                                                }
                                            } else if (iOException instanceof NoRouteToHostException) {
                                                PlayerUtils.log(5, str5, "uri:" + videoRequest2 + ",read upstream error " + PlayerUtils.getPrintableStackTrace(iOException));
                                                if (videoRequest.getPrority() == 90) {
                                                    j26 = PlayerUtils.getDownloadRetCode(1L, VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE);
                                                }
                                            } else if (iOException instanceof InterruptedIOException) {
                                                videoRequest2.setStoppedReason(256);
                                                PlayerUtils.log(4, str5, videoRequest2 + " is interrupted");
                                            } else if (videoProxy.isShutdown) {
                                                PlayerUtils.log(5, str5, "response interrupted, proxy has shutdown");
                                            } else if (iOException.getMessage().matches("(?i)^.*((ECONNRESET)|(EPIPE)|(reset)).*$")) {
                                                PlayerUtils.log(5, str5, "response interrupted, client closed connection");
                                            } else if (iOException.toString().contains("write byteCount err")) {
                                                PlayerUtils.log(5, str5, "response interrupted, socket write byteCount err");
                                            } else {
                                                PlayerUtils.log(5, str5, videoRequest2 + "error occurred while sending data " + PlayerUtils.getPrintableStackTrace(iOException));
                                                videoRequest.getPrority();
                                            }
                                            iOException3 = iOException;
                                            z17 = false;
                                            i26 = i48;
                                        }
                                    }
                                    iOException3 = iOException;
                                    i26 = i48;
                                }
                            } catch (Throwable th30) {
                                th = th30;
                                inputStream3 = inputStream;
                                str11 = str5;
                                i17 = i48 == true ? 1 : 0;
                                str9 = str23;
                                str3 = str24;
                                str10 = str19;
                                str12 = str25;
                                str13 = str18;
                                str14 = str26;
                                j18 = j56;
                                th5 = th;
                                iOException2 = iOException;
                                i3 = i17;
                                PlayerUtils.log(4, str11, str9 + i3 + str3 + j3 + str10 + j18);
                                dataSource3.close();
                                if (iOException2 == null) {
                                }
                                if (file != null) {
                                    delete2 = file.delete();
                                    PlayerUtils.log(4, str11, str13 + file.toString());
                                    if (!delete2) {
                                    }
                                }
                                onConnectionChangeListener2 = PlayerConfig.g().getOnConnectionChangeListener();
                                if (onConnectionChangeListener2 != null) {
                                }
                            }
                        }
                        if (videoRequest.shouldCancel()) {
                            videoRequest.enterCancelProceedState();
                        }
                        PlayerUtils.log(4, str5, str23 + (i26 == true ? 1 : 0) + str24 + j3 + str19 + j56);
                        dataSource3.close();
                        if (iOException3 == null) {
                            try {
                                socket.close();
                            } catch (IOException unused9) {
                            }
                        }
                        if (file != null && file.isFile() && file.exists()) {
                            delete3 = file.delete();
                            PlayerUtils.log(4, str5, str18 + file.toString());
                            if (!delete3) {
                                PlayerUtils.log(5, str5, str26 + file.toString());
                            }
                        }
                        onConnectionChangeListener3 = PlayerConfig.g().getOnConnectionChangeListener();
                        if (onConnectionChangeListener3 != null) {
                            onConnectionChangeListener3.onConnectionChange(false, inputStream, outputStream);
                        }
                        exc2 = iOException3;
                        j29 = j39;
                        z18 = z17;
                        j28 = j26;
                        videoProxy.videoRequestManager.removeRequest(videoRequest2);
                        if (!videoRequest.isCancelProcceed()) {
                        }
                        videoRequest2.setIsStopped(true);
                        String uuid2222222222222222222222 = videoRequest.getUuid();
                        if (PlayerConfig.g().getVideoReporter() != null) {
                        }
                        String str282222222222222222222222 = str27;
                        HttpErrorListener httpErrorListener3222222222222222222222 = videoProxy.httpUrlErrorListenerMap.get(str282222222222222222222222);
                        HttpErrorListener httpErrorListener22222222222222222222222 = videoProxy.uuidErrorListenerMap.get(videoRequest.getUuid());
                        HashMap hashMap22222222222222222222222 = new HashMap();
                        hashMap22222222222222222222222.put("priority", Integer.valueOf(videoRequest.getPrority()));
                        if (!(exc2 instanceof HttpDataSource.InvalidResponseCodeException)) {
                        }
                        PlayerUtils.log(4, str17, "writeResponse finish");
                        return;
                    }
                    videoProxy.videoRequestManager.removeRequest(videoRequest2);
                    if (!videoRequest.isCancelProcceed()) {
                        videoRequest.enterCancelSuccessState();
                    } else if (z18) {
                        videoRequest2.setStoppedReason(16);
                    }
                    videoRequest2.setIsStopped(true);
                    String uuid22222222222222222222222 = videoRequest.getUuid();
                    if (PlayerConfig.g().getVideoReporter() != null) {
                        long downloadResponseCode = PlayerUtils.getDownloadResponseCode(j28, j29);
                        if (!UuidPlayIdMap.isUuidDeleted(uuid22222222222222222222222)) {
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put("message", "(" + downloadResponseCode + "," + j29 + ")");
                            PlayerConfig.g().getVideoReporter().downloadResult(uuid22222222222222222222222, j28, hashMap3);
                        }
                    }
                    String str2822222222222222222222222 = str27;
                    HttpErrorListener httpErrorListener32222222222222222222222 = videoProxy.httpUrlErrorListenerMap.get(str2822222222222222222222222);
                    HttpErrorListener httpErrorListener222222222222222222222222 = videoProxy.uuidErrorListenerMap.get(videoRequest.getUuid());
                    HashMap hashMap222222222222222222222222 = new HashMap();
                    hashMap222222222222222222222222.put("priority", Integer.valueOf(videoRequest.getPrority()));
                    if (!(exc2 instanceof HttpDataSource.InvalidResponseCodeException)) {
                        HttpDataSource.InvalidResponseCodeException invalidResponseCodeException2 = (HttpDataSource.InvalidResponseCodeException) exc2;
                        if (httpErrorListener32222222222222222222222 != null) {
                            j36 = j29;
                            hashMap = hashMap222222222222222222222222;
                            str17 = str5;
                            httpErrorListener32222222222222222222222.onHttpError(videoRequest.getUuid(), str, invalidResponseCodeException2.responseCode, hashMap222222222222222222222222, invalidResponseCodeException2.headerFields, (int) (System.currentTimeMillis() - currentTimeMillis), j28, j36);
                        } else {
                            j36 = j29;
                            hashMap = hashMap222222222222222222222222;
                            str17 = str5;
                        }
                        if (httpErrorListener222222222222222222222222 != null) {
                            httpErrorListener222222222222222222222222.onHttpError(videoRequest.getUuid(), str, invalidResponseCodeException2.responseCode, hashMap, invalidResponseCodeException2.headerFields, (int) (System.currentTimeMillis() - currentTimeMillis), j28, j36);
                        }
                    } else {
                        long j67 = j29;
                        str17 = str5;
                        VideoProxy videoProxy3 = videoProxy;
                        if (exc2 instanceof HttpDataSource.InvalidContentTypeException) {
                            HttpDataSource.InvalidContentTypeException invalidContentTypeException2 = (HttpDataSource.InvalidContentTypeException) exc2;
                            if (httpErrorListener32222222222222222222222 != null) {
                                httpErrorListener32222222222222222222222.onHttpError(videoRequest.getUuid(), str, 3, hashMap222222222222222222222222, invalidContentTypeException2.headerFields, (int) (System.currentTimeMillis() - currentTimeMillis), j28, j67);
                            }
                            if (httpErrorListener222222222222222222222222 != null) {
                                httpErrorListener222222222222222222222222.onHttpError(videoRequest.getUuid(), str, 3, hashMap222222222222222222222222, invalidContentTypeException2.headerFields, (int) (System.currentTimeMillis() - currentTimeMillis), j28, j67);
                            }
                        } else if (exc2 instanceof HttpDataSource.InvalidContentException) {
                            HttpErrorListener httpErrorListener4 = videoProxy3.httpUrlErrorListenerMap.get(str2822222222222222222222222);
                            if (httpErrorListener4 != null) {
                                httpErrorListener4.onHttpError(videoRequest.getUuid(), str, 10, hashMap222222222222222222222222, new HashMap(), (int) (System.currentTimeMillis() - currentTimeMillis), j28, j67);
                            }
                            if (httpErrorListener222222222222222222222222 != null) {
                                httpErrorListener222222222222222222222222.onHttpError(videoRequest.getUuid(), str, 10, hashMap222222222222222222222222, new HashMap(), (int) (System.currentTimeMillis() - currentTimeMillis), j28, j67);
                            }
                        } else if (exc2 instanceof HttpDataSource.MalformedResponseException) {
                            if (httpErrorListener32222222222222222222222 != null) {
                                httpErrorListener32222222222222222222222.onHttpError(videoRequest.getUuid(), str, 12, hashMap222222222222222222222222, new HashMap(), (int) (System.currentTimeMillis() - currentTimeMillis), j28, j67);
                            }
                            if (httpErrorListener222222222222222222222222 != null) {
                                httpErrorListener222222222222222222222222.onHttpError(videoRequest.getUuid(), str, 12, hashMap222222222222222222222222, new HashMap(), (int) (System.currentTimeMillis() - currentTimeMillis), j28, j67);
                            }
                        } else if (!(exc2 instanceof HttpDataSource.InterruptConnectServerException) && !(exc2 instanceof HttpDataSource.InterruptReadException)) {
                            if (exc2 instanceof HttpDataSource.UnableConnectServerException) {
                                if (httpErrorListener32222222222222222222222 != null) {
                                    httpErrorListener32222222222222222222222.onHttpError(videoRequest.getUuid(), str, PlayerUtils.isNetworkAvailable() ? 5 : 9, hashMap222222222222222222222222, new HashMap(), (int) (System.currentTimeMillis() - currentTimeMillis), j28, j67);
                                }
                                if (httpErrorListener222222222222222222222222 != null) {
                                    httpErrorListener222222222222222222222222.onHttpError(videoRequest.getUuid(), str, PlayerUtils.isNetworkAvailable() ? 5 : 9, hashMap222222222222222222222222, new HashMap(), (int) (System.currentTimeMillis() - currentTimeMillis), j28, j67);
                                }
                            } else if (exc2 instanceof HttpDataSource.HttpDataSourceException) {
                                if (httpErrorListener32222222222222222222222 != null) {
                                    httpErrorListener32222222222222222222222.onHttpError(videoRequest.getUuid(), str, videoProxy3.getFakeHttpStatus(exc2), hashMap222222222222222222222222, new HashMap(), (int) (System.currentTimeMillis() - currentTimeMillis), j28, j67);
                                }
                                if (httpErrorListener222222222222222222222222 != null) {
                                    httpErrorListener222222222222222222222222.onHttpError(videoRequest.getUuid(), str, videoProxy3.getFakeHttpStatus(exc2), hashMap222222222222222222222222, new HashMap(), (int) (System.currentTimeMillis() - currentTimeMillis), j28, j67);
                                }
                            } else if ((dataSource3 instanceof FileDataSource) && (exc2 instanceof FileDataSource.FileDataSourceException)) {
                                hashMap222222222222222222222222.put("error_msg", ImageTaskConst.ErrorDesciption.IMAGE_TASK_NO_SUCH_FILE_DESC);
                                if (httpErrorListener32222222222222222222222 != null) {
                                    httpErrorListener32222222222222222222222.onHttpError(videoRequest.getUuid(), str, VideoResultCode.DOWNLOAD_FAKE_HTTP_STATUS_LOCAL_FILE_NOTFOUND, hashMap222222222222222222222222, null, (int) (System.currentTimeMillis() - currentTimeMillis), j28, j67);
                                }
                                if (httpErrorListener222222222222222222222222 != null) {
                                    httpErrorListener222222222222222222222222.onHttpError(videoRequest.getUuid(), str, VideoResultCode.DOWNLOAD_FAKE_HTTP_STATUS_LOCAL_FILE_NOTFOUND, hashMap222222222222222222222222, null, (int) (System.currentTimeMillis() - currentTimeMillis), j28, j67);
                                }
                            } else if (exc2 instanceof NoRouteToHostException) {
                                if (httpErrorListener32222222222222222222222 != null) {
                                    httpErrorListener32222222222222222222222.onHttpError(videoRequest.getUuid(), str, 1, hashMap222222222222222222222222, new HashMap(), (int) (System.currentTimeMillis() - currentTimeMillis), j28, j67);
                                }
                                if (httpErrorListener222222222222222222222222 != null) {
                                    httpErrorListener222222222222222222222222.onHttpError(videoRequest.getUuid(), str, 1, hashMap222222222222222222222222, new HashMap(), (int) (System.currentTimeMillis() - currentTimeMillis), j28, j67);
                                }
                            }
                        }
                    }
                    PlayerUtils.log(4, str17, "writeResponse finish");
                    return;
                } catch (Throwable th31) {
                    th = th31;
                    file = file2;
                    str3 = str29;
                    th5 = th;
                    str9 = str2;
                    str12 = str25;
                    str10 = str30;
                    str11 = str5;
                    j18 = j57;
                    str13 = "DelPlayListFile ";
                    str14 = str26;
                    i3 = 0;
                    iOException2 = null;
                    inputStream3 = inputStream;
                    PlayerUtils.log(4, str11, str9 + i3 + str3 + j3 + str10 + j18);
                    dataSource3.close();
                    if (iOException2 == null) {
                    }
                    if (file != null) {
                    }
                    onConnectionChangeListener2 = PlayerConfig.g().getOnConnectionChangeListener();
                    if (onConnectionChangeListener2 != null) {
                    }
                }
            } catch (Throwable th32) {
                j3 = rangeStart;
                inputStream3 = inputStream;
                th5 = th32;
                dataSource3 = dataSource8;
                j18 = j56;
                str9 = str23;
                str3 = str24;
                str10 = ", rangeEnd=";
                str11 = str21;
                str12 = str25;
                str13 = "DelPlayListFile ";
                str14 = str26;
                i3 = 0;
                file = null;
            }
        }
        dataSourceBuilder = dataSourceBuilder2;
        if (dataSourceBuilder == null) {
        }
        dataSource = defaultHttpDataSource;
        if (dataSource != null) {
        }
    }

    public synchronized void addCacheReadListener(String str, CacheReadListener cacheReadListener) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.cacheReadListenerMap.put(PlayerUtils.parseVideoKey(str), cacheReadListener);
    }

    public synchronized void addHttpErrorListener(String str, HttpErrorListener httpErrorListener) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.httpUrlErrorListenerMap.put(PlayerUtils.parseVideoKey(str), httpErrorListener);
    }

    public void addHttpRetryLogic(String str, HttpRetryLogic httpRetryLogic) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String parseVideoKey = PlayerUtils.parseVideoKey(str);
        if (parseVideoKey != null && httpRetryLogic != null) {
            this.httpRetryLogicMap.put(parseVideoKey, httpRetryLogic);
        } else {
            PlayerUtils.log(3, TAG, "add http retry logic is null");
        }
    }

    public synchronized void addUuidErrorListener(String str, HttpErrorListener httpErrorListener) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.uuidErrorListenerMap.put(str, httpErrorListener);
    }

    @Deprecated
    public void cancelAllAsync() {
        PlayerUtils.log(4, TAG, "cancelAllAsync is not supported any more!");
    }

    public void cancelAllPreloadAsync(boolean z16) {
        ITcDataSourceUtils iTcDataSourceUtils = this.tcDataSourceUtils;
        if (iTcDataSourceUtils != null) {
            iTcDataSourceUtils.stopAllPreload();
        }
        VideoRequestManager videoRequestManager = this.videoRequestManager;
        if (videoRequestManager != null) {
            videoRequestManager.cancelAllPreloadRequestAsync(z16);
        }
    }

    @Deprecated
    public void cancelAsync(String str, boolean z16) {
        PlayerUtils.log(4, TAG, "cancelAsync is not supported any more!");
    }

    public void clearCache() {
        ITcDataSourceUtils iTcDataSourceUtils = this.tcDataSourceUtils;
        if (iTcDataSourceUtils != null) {
            iTcDataSourceUtils.cleanStorage();
        }
        Cache cache = this.cache;
        if (cache != null) {
            cache.removeAll();
        }
    }

    public void clearCacheByUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ITcDataSourceUtils iTcDataSourceUtils = this.tcDataSourceUtils;
        if (iTcDataSourceUtils != null) {
            iTcDataSourceUtils.deleteFileOnDisk(str);
        }
        if (this.cache != null) {
            this.cache.removeByKey(PlayerUtils.parseVideoKey(str));
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r6v1 ??, still in use, count: 18, list:
          (r6v1 ?? I:??[OBJECT, ARRAY]) from 0x016e: MOVE (r8v4 ?? I:??[OBJECT, ARRAY]) = (r6v1 ?? I:??[OBJECT, ARRAY]) (LINE:367)
          (r6v1 ?? I:??[OBJECT, ARRAY]) from 0x01a4: MOVE (r8v5 ?? I:??[OBJECT, ARRAY]) = (r6v1 ?? I:??[OBJECT, ARRAY]) (LINE:421)
          (r6v1 ?? I:??[OBJECT, ARRAY]) from 0x020e: MOVE (r8v6 ?? I:??[OBJECT, ARRAY]) = (r6v1 ?? I:??[OBJECT, ARRAY]) (LINE:527)
          (r6v1 ?? I:??[OBJECT, ARRAY]) from 0x01da: MOVE (r8v7 ?? I:??[OBJECT, ARRAY]) = (r6v1 ?? I:??[OBJECT, ARRAY]) (LINE:475)
          (r6v1 ?? I:??[OBJECT, ARRAY]) from 0x0169: MOVE (r8v8 ?? I:??[OBJECT, ARRAY]) = (r6v1 ?? I:??[OBJECT, ARRAY]) (LINE:362)
          (r6v1 ?? I:??[OBJECT, ARRAY]) from 0x0076: MOVE (r8v15 ?? I:??[OBJECT, ARRAY]) = (r6v1 ?? I:??[OBJECT, ARRAY]) (LINE:119)
          (r6v1 ?? I:com.tencent.oskplayer.datasource.DataSpec) from 0x008c: IGET (r1v21 ?? I:java.lang.String) = (r6v1 ?? I:com.tencent.oskplayer.datasource.DataSpec) A[Catch: all -> 0x0168, Exception -> 0x016d, IOException -> 0x01a3, CacheDataSinkException -> 0x01d9, HttpDataSourceException -> 0x020d] (LINE:141) com.tencent.oskplayer.datasource.DataSpec.key java.lang.String
          (r6v1 ?? I:com.tencent.oskplayer.datasource.DataSpec) from 0x00ac: IGET (r1v22 ?? I:java.lang.String) = (r6v1 ?? I:com.tencent.oskplayer.datasource.DataSpec) A[Catch: all -> 0x0168, Exception -> 0x016d, IOException -> 0x01a3, CacheDataSinkException -> 0x01d9, HttpDataSourceException -> 0x020d] (LINE:173) com.tencent.oskplayer.datasource.DataSpec.key java.lang.String
          (r6v1 ?? I:com.tencent.oskplayer.datasource.DataSpec) from 0x00b1: INVOKE (r0v36 ?? I:long) = (r7v1 ?? I:com.tencent.oskplayer.datasource.DataSource), (r6v1 ?? I:com.tencent.oskplayer.datasource.DataSpec) INTERFACE call: com.tencent.oskplayer.datasource.DataSource.open(com.tencent.oskplayer.datasource.DataSpec):long A[Catch: all -> 0x0168, Exception -> 0x016d, IOException -> 0x01a3, CacheDataSinkException -> 0x01d9, HttpDataSourceException -> 0x020d, MD:(com.tencent.oskplayer.datasource.DataSpec):long throws java.io.IOException (m)] (LINE:178)
          (r6v1 ??) from 0x0160: PHI (r6v6 ??) = (r6v1 ??), (r6v7 ??) binds: [B:44:0x00ba, B:155:?] A[DONT_GENERATE, DONT_INLINE]
          (r6v1 ??) from 0x0164: PHI (r6v5 ??) = (r6v1 ??), (r6v7 ??) binds: [B:44:0x00ba, B:155:?] A[DONT_GENERATE, DONT_INLINE]
          (r6v1 ??) from 0x015d: PHI (r6v4 ??) = (r6v1 ??), (r6v7 ??) binds: [B:44:0x00ba, B:155:?] A[DONT_GENERATE, DONT_INLINE]
          (r6v1 ??) from 0x015a: PHI (r6v3 ??) = (r6v1 ??), (r6v7 ??) binds: [B:44:0x00ba, B:155:?] A[DONT_GENERATE, DONT_INLINE]
          (r6v1 ??) from 0x0156: PHI (r6v2 ??) = (r6v1 ??), (r6v7 ??) binds: [B:44:0x00ba, B:155:?] A[DONT_GENERATE, DONT_INLINE]
          (r6v1 ?? I:com.tencent.oskplayer.datasource.DataSpec) from 0x00c4: INVOKE 
          (r14v10 ?? I:com.tencent.oskplayer.cache.FileDataSink)
          (r6v1 ?? I:com.tencent.oskplayer.datasource.DataSpec)
          (r0v36 ?? I:long)
          (r2v13 ?? I:com.tencent.oskplayer.proxy.FileType)
         VIRTUAL call: com.tencent.oskplayer.cache.FileDataSink.open(com.tencent.oskplayer.datasource.DataSpec, long, com.tencent.oskplayer.proxy.FileType):com.tencent.oskplayer.datasource.DataSink A[Catch: all -> 0x0156, Exception -> 0x015a, IOException -> 0x015d, CacheDataSinkException -> 0x0160, HttpDataSourceException -> 0x0164, MD:(com.tencent.oskplayer.datasource.DataSpec, long, com.tencent.oskplayer.proxy.FileType):com.tencent.oskplayer.datasource.DataSink throws com.tencent.oskplayer.cache.CacheDataSink$CacheDataSinkException (m)] (LINE:197)
          (r6v1 ??) from 0x00c8: PHI (r6v7 ??) = (r6v1 ??), (r6v8 ??) binds: [B:45:0x00ba, B:57:0x00c8] A[DONT_GENERATE, DONT_INLINE]
          (r6v1 ?? I:com.tencent.oskplayer.datasource.DataSpec) from 0x00a4: IGET (r1v29 ?? I:java.lang.String) = (r6v1 ?? I:com.tencent.oskplayer.datasource.DataSpec) (LINE:165) com.tencent.oskplayer.datasource.DataSpec.key java.lang.String
          (r6v1 ?? I:com.tencent.oskplayer.datasource.DataSpec) from 0x0084: IGET (r2v23 ?? I:java.lang.String) = (r6v1 ?? I:com.tencent.oskplayer.datasource.DataSpec) (LINE:133) com.tencent.oskplayer.datasource.DataSpec.key java.lang.String
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:34)
        */
    public java.lang.String downloadVideoSync(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r6v1 ??, still in use, count: 18, list:
          (r6v1 ?? I:??[OBJECT, ARRAY]) from 0x016e: MOVE (r8v4 ?? I:??[OBJECT, ARRAY]) = (r6v1 ?? I:??[OBJECT, ARRAY]) (LINE:367)
          (r6v1 ?? I:??[OBJECT, ARRAY]) from 0x01a4: MOVE (r8v5 ?? I:??[OBJECT, ARRAY]) = (r6v1 ?? I:??[OBJECT, ARRAY]) (LINE:421)
          (r6v1 ?? I:??[OBJECT, ARRAY]) from 0x020e: MOVE (r8v6 ?? I:??[OBJECT, ARRAY]) = (r6v1 ?? I:??[OBJECT, ARRAY]) (LINE:527)
          (r6v1 ?? I:??[OBJECT, ARRAY]) from 0x01da: MOVE (r8v7 ?? I:??[OBJECT, ARRAY]) = (r6v1 ?? I:??[OBJECT, ARRAY]) (LINE:475)
          (r6v1 ?? I:??[OBJECT, ARRAY]) from 0x0169: MOVE (r8v8 ?? I:??[OBJECT, ARRAY]) = (r6v1 ?? I:??[OBJECT, ARRAY]) (LINE:362)
          (r6v1 ?? I:??[OBJECT, ARRAY]) from 0x0076: MOVE (r8v15 ?? I:??[OBJECT, ARRAY]) = (r6v1 ?? I:??[OBJECT, ARRAY]) (LINE:119)
          (r6v1 ?? I:com.tencent.oskplayer.datasource.DataSpec) from 0x008c: IGET (r1v21 ?? I:java.lang.String) = (r6v1 ?? I:com.tencent.oskplayer.datasource.DataSpec) A[Catch: all -> 0x0168, Exception -> 0x016d, IOException -> 0x01a3, CacheDataSinkException -> 0x01d9, HttpDataSourceException -> 0x020d] (LINE:141) com.tencent.oskplayer.datasource.DataSpec.key java.lang.String
          (r6v1 ?? I:com.tencent.oskplayer.datasource.DataSpec) from 0x00ac: IGET (r1v22 ?? I:java.lang.String) = (r6v1 ?? I:com.tencent.oskplayer.datasource.DataSpec) A[Catch: all -> 0x0168, Exception -> 0x016d, IOException -> 0x01a3, CacheDataSinkException -> 0x01d9, HttpDataSourceException -> 0x020d] (LINE:173) com.tencent.oskplayer.datasource.DataSpec.key java.lang.String
          (r6v1 ?? I:com.tencent.oskplayer.datasource.DataSpec) from 0x00b1: INVOKE (r0v36 ?? I:long) = (r7v1 ?? I:com.tencent.oskplayer.datasource.DataSource), (r6v1 ?? I:com.tencent.oskplayer.datasource.DataSpec) INTERFACE call: com.tencent.oskplayer.datasource.DataSource.open(com.tencent.oskplayer.datasource.DataSpec):long A[Catch: all -> 0x0168, Exception -> 0x016d, IOException -> 0x01a3, CacheDataSinkException -> 0x01d9, HttpDataSourceException -> 0x020d, MD:(com.tencent.oskplayer.datasource.DataSpec):long throws java.io.IOException (m)] (LINE:178)
          (r6v1 ??) from 0x0160: PHI (r6v6 ??) = (r6v1 ??), (r6v7 ??) binds: [B:44:0x00ba, B:155:?] A[DONT_GENERATE, DONT_INLINE]
          (r6v1 ??) from 0x0164: PHI (r6v5 ??) = (r6v1 ??), (r6v7 ??) binds: [B:44:0x00ba, B:155:?] A[DONT_GENERATE, DONT_INLINE]
          (r6v1 ??) from 0x015d: PHI (r6v4 ??) = (r6v1 ??), (r6v7 ??) binds: [B:44:0x00ba, B:155:?] A[DONT_GENERATE, DONT_INLINE]
          (r6v1 ??) from 0x015a: PHI (r6v3 ??) = (r6v1 ??), (r6v7 ??) binds: [B:44:0x00ba, B:155:?] A[DONT_GENERATE, DONT_INLINE]
          (r6v1 ??) from 0x0156: PHI (r6v2 ??) = (r6v1 ??), (r6v7 ??) binds: [B:44:0x00ba, B:155:?] A[DONT_GENERATE, DONT_INLINE]
          (r6v1 ?? I:com.tencent.oskplayer.datasource.DataSpec) from 0x00c4: INVOKE 
          (r14v10 ?? I:com.tencent.oskplayer.cache.FileDataSink)
          (r6v1 ?? I:com.tencent.oskplayer.datasource.DataSpec)
          (r0v36 ?? I:long)
          (r2v13 ?? I:com.tencent.oskplayer.proxy.FileType)
         VIRTUAL call: com.tencent.oskplayer.cache.FileDataSink.open(com.tencent.oskplayer.datasource.DataSpec, long, com.tencent.oskplayer.proxy.FileType):com.tencent.oskplayer.datasource.DataSink A[Catch: all -> 0x0156, Exception -> 0x015a, IOException -> 0x015d, CacheDataSinkException -> 0x0160, HttpDataSourceException -> 0x0164, MD:(com.tencent.oskplayer.datasource.DataSpec, long, com.tencent.oskplayer.proxy.FileType):com.tencent.oskplayer.datasource.DataSink throws com.tencent.oskplayer.cache.CacheDataSink$CacheDataSinkException (m)] (LINE:197)
          (r6v1 ??) from 0x00c8: PHI (r6v7 ??) = (r6v1 ??), (r6v8 ??) binds: [B:45:0x00ba, B:57:0x00c8] A[DONT_GENERATE, DONT_INLINE]
          (r6v1 ?? I:com.tencent.oskplayer.datasource.DataSpec) from 0x00a4: IGET (r1v29 ?? I:java.lang.String) = (r6v1 ?? I:com.tencent.oskplayer.datasource.DataSpec) (LINE:165) com.tencent.oskplayer.datasource.DataSpec.key java.lang.String
          (r6v1 ?? I:com.tencent.oskplayer.datasource.DataSpec) from 0x0084: IGET (r2v23 ?? I:java.lang.String) = (r6v1 ?? I:com.tencent.oskplayer.datasource.DataSpec) (LINE:133) com.tencent.oskplayer.datasource.DataSpec.key java.lang.String
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r26v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:237)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */

    public void downloadVideosAsync(List<String> list, int i3, final boolean z16, final VideoDownloadListener videoDownloadListener, final HttpHeader httpHeader) {
        ArrayList arrayList = new ArrayList();
        for (final String str : list) {
            arrayList.add(new Runnable() { // from class: com.tencent.oskplayer.proxy.VideoProxy.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoProxy.this.downloadVideoSync(str, videoDownloadListener, z16, httpHeader);
                }
            });
        }
        if (arrayList.size() > 0) {
            ThreadUtils.executePriorityTask(arrayList, i3);
        }
    }

    public long getCachedBytesFromEnd(String str) {
        if (!TextUtils.isEmpty(str) && this.cache != null) {
            return this.cache.getCachedBytesFromEnd(PlayerUtils.parseVideoKey(str));
        }
        return 0L;
    }

    public long getCachedBytesFromStart(String str) {
        if (!TextUtils.isEmpty(str) && this.cache != null) {
            return this.cache.getCachedBytesFromStart(PlayerUtils.parseVideoKey(str));
        }
        return 0L;
    }

    public double getCachedSizeRate(String str) {
        if (TextUtils.isEmpty(str) || this.cache == null || !this.isCacheProviderLocal) {
            return 0.0d;
        }
        return this.cache.getCachedSizeRate(PlayerUtils.parseVideoKey(str));
    }

    public String getLocalServerPrefix() {
        return "http://127.0.0.1:" + this.serverPort;
    }

    public long getTotalLength(String str) {
        if (TextUtils.isEmpty(str) || this.cache == null || !this.isCacheProviderLocal) {
            return -1L;
        }
        return this.cache.getTotalLength(PlayerUtils.parseVideoKey(str));
    }

    public long getUnCachedSize(String str) {
        if (TextUtils.isEmpty(str) || this.cache == null || !this.isCacheProviderLocal) {
            return -1L;
        }
        return this.cache.getRemainUnCachedBytes(PlayerUtils.parseVideoKey(str));
    }

    public String getUrl(String str) {
        return getUrl(str, (HttpHeader) null);
    }

    public VideoRequestManager getVideoRequestManager() {
        return this.videoRequestManager;
    }

    public boolean isCached(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ITcDataSourceUtils iTcDataSourceUtils = this.tcDataSourceUtils;
        if (iTcDataSourceUtils != null && !this.isCacheProviderLocal) {
            return iTcDataSourceUtils.isClipCompleteOnDisk(str, 1);
        }
        if (this.cache == null || !this.isCacheProviderLocal) {
            return false;
        }
        return this.cache.isCached(PlayerUtils.parseVideoKey(str));
    }

    public Future<?> preloadAsync(final String str, final long j3, final long j16, final int i3, final boolean z16, final boolean z17, final HttpHeader httpHeader, final DownloadListener downloadListener) {
        return ThreadUtils.submitTask(new Runnable() { // from class: com.tencent.oskplayer.proxy.VideoProxy.5
            @Override // java.lang.Runnable
            public void run() {
                VideoProxy.this.preloadSync(str, j3, j16, i3, z16, z17, httpHeader, downloadListener);
            }
        }, "preloadAsync");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void preloadMedia(List<String> list, int i3, long j3, PreloadListener preloadListener) {
        preloadMedia(list, i3, j3, preloadListener, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x066b, code lost:
    
        if (r61 == null) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x066d, code lost:
    
        r61.onError(r52, -105);
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0807, code lost:
    
        if (r61 == null) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x073d, code lost:
    
        if (r61 == null) goto L281;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0757 A[Catch: all -> 0x080b, TryCatch #43 {all -> 0x080b, blocks: (B:115:0x074f, B:117:0x0757, B:119:0x075d, B:121:0x076e, B:123:0x0786, B:130:0x078c, B:132:0x07ab, B:133:0x07b1, B:135:0x07d0, B:141:0x06e2, B:143:0x0705), top: B:71:0x0548 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x07b1 A[Catch: all -> 0x080b, TryCatch #43 {all -> 0x080b, blocks: (B:115:0x074f, B:117:0x0757, B:119:0x075d, B:121:0x076e, B:123:0x0786, B:130:0x078c, B:132:0x07ab, B:133:0x07b1, B:135:0x07d0, B:141:0x06e2, B:143:0x0705), top: B:71:0x0548 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0705 A[Catch: all -> 0x080b, TRY_LEAVE, TryCatch #43 {all -> 0x080b, blocks: (B:115:0x074f, B:117:0x0757, B:119:0x075d, B:121:0x076e, B:123:0x0786, B:130:0x078c, B:132:0x07ab, B:133:0x07b1, B:135:0x07d0, B:141:0x06e2, B:143:0x0705), top: B:71:0x0548 }] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x03b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x031e A[Catch: all -> 0x037b, TRY_LEAVE, TryCatch #39 {all -> 0x037b, blocks: (B:250:0x02dd, B:252:0x031e), top: B:249:0x02dd }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0525  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x084e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0855  */
    /* JADX WARN: Type inference failed for: r0v71, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r27v10 */
    /* JADX WARN: Type inference failed for: r27v13 */
    /* JADX WARN: Type inference failed for: r27v14 */
    /* JADX WARN: Type inference failed for: r27v17 */
    /* JADX WARN: Type inference failed for: r27v18 */
    /* JADX WARN: Type inference failed for: r27v19 */
    /* JADX WARN: Type inference failed for: r27v4, types: [int] */
    /* JADX WARN: Type inference failed for: r27v5 */
    /* JADX WARN: Type inference failed for: r27v7 */
    /* JADX WARN: Type inference failed for: r28v10 */
    /* JADX WARN: Type inference failed for: r28v11 */
    /* JADX WARN: Type inference failed for: r28v12 */
    /* JADX WARN: Type inference failed for: r28v13 */
    /* JADX WARN: Type inference failed for: r28v2, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r28v3 */
    /* JADX WARN: Type inference failed for: r28v5 */
    /* JADX WARN: Type inference failed for: r28v8 */
    /* JADX WARN: Type inference failed for: r28v9 */
    /* JADX WARN: Type inference failed for: r29v11 */
    /* JADX WARN: Type inference failed for: r29v15 */
    /* JADX WARN: Type inference failed for: r29v16 */
    /* JADX WARN: Type inference failed for: r29v17 */
    /* JADX WARN: Type inference failed for: r29v18 */
    /* JADX WARN: Type inference failed for: r29v8 */
    /* JADX WARN: Type inference failed for: r29v9 */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.tencent.oskplayer.datasource.DefaultHttpDataSource, com.tencent.oskplayer.datasource.DataSource] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23, types: [long] */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v4, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v3, types: [int] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r7v18, types: [long] */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v25, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* JADX WARN: Type inference failed for: r7v35 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean preloadSync(String str, long j3, long j16, int i3, boolean z16, boolean z17, HttpHeader httpHeader, DownloadListener downloadListener) {
        String str2;
        String str3;
        String str4;
        String str5;
        long j17;
        VideoProxy videoProxy;
        ITcDataSourceUtils iTcDataSourceUtils;
        Throwable th5;
        String str6;
        String str7;
        long j18;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        long j19;
        long j26;
        String str18;
        String str19;
        long currentTimeMillis;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        long j27;
        String str29;
        String str30;
        String str31;
        String str32;
        String str33;
        String str34;
        String str35;
        long j28;
        Throwable th6;
        String str36;
        String str37;
        String str38;
        String str39;
        String str40;
        String str41;
        String str42;
        String str43;
        String str44;
        String str45;
        String str46;
        String str47;
        String str48;
        String str49;
        String str50;
        String str51;
        String str52;
        String str53;
        String str54;
        String str55;
        String str56;
        String str57;
        String str58;
        long j29 = j3;
        String str59 = " bytes for url ";
        if (!TextUtils.isEmpty(str) && URLUtil.isNetworkUrl(str)) {
            ITcDataSourceUtils iTcDataSourceUtils2 = this.tcDataSourceUtils;
            if (iTcDataSourceUtils2 != null && !this.isCacheProviderLocal) {
                return iTcDataSourceUtils2.preload(str, 0L, 0, 1, 15, "");
            }
            if (!PlayerConfig.g().isEnableProxy()) {
                PlayerUtils.log(4, TAG, "preloadSync video cache disabled ");
                return false;
            }
            String parseVideoKey = PlayerUtils.parseVideoKey(str);
            String url = getUrl(str, true, true, "-1", "video/mp4", 10, httpHeader);
            String videoUuidFromVideoUrl = PlayerUtils.getVideoUuidFromVideoUrl(url);
            if (downloadListener != null) {
                downloadListener.onStart(str);
            }
            if (!z16 || url == null) {
                str2 = url;
                str3 = " pos1 ";
                str4 = TAG;
                str5 = videoUuidFromVideoUrl;
                j17 = -1;
            } else {
                DefaultHttpDataSource defaultHttpDataSource = new DefaultHttpDataSource("com.qzone.player-v20150909", null, null);
                byte[] bArr = new byte[512];
                try {
                    try {
                        try {
                            ?? parse = Uri.parse(url);
                            ?? r29 = 0;
                            defaultHttpDataSource.open(new DataSpec(parse, 0L, 0L, -1L, null, 0, null));
                            ?? totalLength = defaultHttpDataSource.getTotalLength();
                            ?? r27 = (j16 > 5000L ? 1 : (j16 == 5000L ? 0 : -1));
                            try {
                                if (r27 > 0) {
                                    r29 = url;
                                    try {
                                        try {
                                            int i16 = ((int) ((8 * totalLength) / j16)) * 1000;
                                            int i17 = ((i3 / 1000) * i16) / 8;
                                            j17 = totalLength;
                                            long j36 = (j16 / 1000) * 800;
                                            r27 = " bytes for url ";
                                            parse = "preloadSync error preload ";
                                            try {
                                                j29 = Math.min(j29, i17 + j36);
                                                str58 = "preload_log start preloadSync head bitrate=" + i16 + JefsClass.INDEX_URL + str + ",headerBytesCount= " + j36 + ",durationBytesCount=" + i17 + ",maxPreloadBytes=" + j29;
                                                str57 = TAG;
                                            } catch (HttpDataSource.HttpDataSourceException e16) {
                                                e = e16;
                                                str57 = TAG;
                                            } catch (IOException e17) {
                                                e = e17;
                                                totalLength = TAG;
                                                str5 = videoUuidFromVideoUrl;
                                                str25 = " maxPreloadBytes ";
                                                str50 = totalLength;
                                                str49 = r27;
                                                str48 = parse;
                                                str47 = r29;
                                                str26 = "preloadSync head closeException ";
                                                str27 = "preloadSync head total preload ";
                                                str28 = "preloadSync head preload finish";
                                                j27 = 0;
                                                str24 = str50;
                                                str22 = str49;
                                                str23 = str48;
                                                str21 = str47;
                                                try {
                                                    StringBuilder sb5 = new StringBuilder();
                                                    str41 = str26;
                                                } catch (Throwable th7) {
                                                    str36 = "preload_log over preloadSync head url ";
                                                    long j37 = j27;
                                                    th6 = th7;
                                                    str39 = str26;
                                                    str37 = str25;
                                                    j28 = j37;
                                                    str42 = str24;
                                                    try {
                                                        PlayerUtils.log(3, str42, str27 + j28 + " bytes");
                                                        defaultHttpDataSource.close();
                                                        PlayerUtils.log(4, str42, str28);
                                                        PlayerUtils.log(4, str42, str36 + str + str37 + j29);
                                                        throw th6;
                                                    } catch (Exception e18) {
                                                        PlayerUtils.log(4, str42, str39 + e18);
                                                        if (downloadListener != null) {
                                                            downloadListener.onError(str, -105);
                                                            throw th6;
                                                        }
                                                        throw th6;
                                                    }
                                                }
                                                try {
                                                    sb5.append(str23);
                                                    sb5.append(j29);
                                                    sb5.append(str22);
                                                    sb5.append(str);
                                                    sb5.append(" pos3 ");
                                                    sb5.append(PlayerUtils.getPrintableStackTrace(e));
                                                    PlayerUtils.log(5, str24, sb5.toString());
                                                    PlayerUtils.log(4, str24, "preloadSync head url " + str + str25 + j29);
                                                    if (downloadListener != null) {
                                                        downloadListener.onError(str, -104);
                                                    }
                                                    try {
                                                        PlayerUtils.log(3, str24, str27 + j27 + " bytes");
                                                        defaultHttpDataSource.close();
                                                        PlayerUtils.log(4, str24, str28);
                                                        PlayerUtils.log(4, str24, "preload_log over preloadSync head url " + str + str25 + j29);
                                                    } catch (Exception e19) {
                                                        PlayerUtils.log(4, str24, str41 + e19);
                                                        if (downloadListener != null) {
                                                            downloadListener.onError(str, -105);
                                                        }
                                                    }
                                                    str3 = " pos1 ";
                                                    str4 = str24;
                                                    str2 = str21;
                                                    if (z17) {
                                                    }
                                                    videoProxy = this;
                                                    iTcDataSourceUtils = videoProxy.tcDataSourceUtils;
                                                    if (iTcDataSourceUtils != null) {
                                                    }
                                                    if (downloadListener == null) {
                                                    }
                                                } catch (Throwable th8) {
                                                    th = th8;
                                                    str37 = str25;
                                                    str36 = "preload_log over preloadSync head url ";
                                                    j28 = j27;
                                                    str39 = str41;
                                                    str43 = str24;
                                                    th6 = th;
                                                    str42 = str43;
                                                    PlayerUtils.log(3, str42, str27 + j28 + " bytes");
                                                    defaultHttpDataSource.close();
                                                    PlayerUtils.log(4, str42, str28);
                                                    PlayerUtils.log(4, str42, str36 + str + str37 + j29);
                                                    throw th6;
                                                }
                                            }
                                            try {
                                                PlayerUtils.log(4, str57, str58);
                                                str25 = " maxPreloadBytes ";
                                                totalLength = str57;
                                                r27 = r27;
                                                parse = parse;
                                                r29 = r29;
                                            } catch (HttpDataSource.HttpDataSourceException e26) {
                                                e = e26;
                                                str5 = videoUuidFromVideoUrl;
                                                str35 = "preload_log over preloadSync head url ";
                                                str27 = "preloadSync head total preload ";
                                                str28 = "preloadSync head preload finish";
                                                str56 = str57;
                                                str55 = r27;
                                                str54 = parse;
                                                str53 = r29;
                                                str59 = str55;
                                                str30 = str54;
                                                str52 = str56;
                                                str51 = str53;
                                                j28 = 0;
                                                str46 = str52;
                                                str45 = str51;
                                                str32 = " pos1 ";
                                                str33 = "preloadSync head closeException ";
                                                str34 = " maxPreloadBytes ";
                                                str31 = str46;
                                                str29 = str45;
                                                try {
                                                    try {
                                                        if (e.getCause() instanceof ProtocolException) {
                                                        }
                                                        try {
                                                            PlayerUtils.log(3, str31, str27 + j28 + " bytes");
                                                            defaultHttpDataSource.close();
                                                            PlayerUtils.log(4, str31, str28);
                                                            PlayerUtils.log(4, str31, str35 + str + str34 + j29);
                                                            str4 = str31;
                                                            str2 = str29;
                                                        } catch (Exception e27) {
                                                            PlayerUtils.log(4, str31, str44 + e27);
                                                            str4 = str31;
                                                            str2 = str29;
                                                            if (downloadListener != null) {
                                                                downloadListener.onError(str, -105);
                                                                str4 = str31;
                                                                str2 = str29;
                                                            }
                                                        }
                                                        if (z17) {
                                                        }
                                                        videoProxy = this;
                                                        iTcDataSourceUtils = videoProxy.tcDataSourceUtils;
                                                        if (iTcDataSourceUtils != null) {
                                                        }
                                                        if (downloadListener == null) {
                                                        }
                                                    } catch (Throwable th9) {
                                                        str36 = str35;
                                                        th6 = th9;
                                                        str37 = str34;
                                                        str39 = "preloadSync head total preload ";
                                                        str42 = str31;
                                                    }
                                                } catch (Throwable th10) {
                                                    th = th10;
                                                    str39 = str33;
                                                    str37 = str34;
                                                    str36 = str35;
                                                    str43 = str31;
                                                }
                                            } catch (Throwable th11) {
                                                th = th11;
                                                th6 = th;
                                                str36 = "preload_log over preloadSync head url ";
                                                str37 = " maxPreloadBytes ";
                                                str39 = "preloadSync head closeException ";
                                                str27 = "preloadSync head total preload ";
                                                str28 = "preloadSync head preload finish";
                                                str40 = str57;
                                                j28 = 0;
                                                str42 = str40;
                                                PlayerUtils.log(3, str42, str27 + j28 + " bytes");
                                                defaultHttpDataSource.close();
                                                PlayerUtils.log(4, str42, str28);
                                                PlayerUtils.log(4, str42, str36 + str + str37 + j29);
                                                throw th6;
                                            }
                                        } catch (HttpDataSource.HttpDataSourceException e28) {
                                            e = e28;
                                            j17 = totalLength;
                                            str52 = TAG;
                                            str5 = videoUuidFromVideoUrl;
                                            str35 = "preload_log over preloadSync head url ";
                                            str30 = "preloadSync error preload ";
                                            str27 = "preloadSync head total preload ";
                                            str28 = "preloadSync head preload finish";
                                            str51 = r29;
                                            j28 = 0;
                                            str46 = str52;
                                            str45 = str51;
                                            str32 = " pos1 ";
                                            str33 = "preloadSync head closeException ";
                                            str34 = " maxPreloadBytes ";
                                            str31 = str46;
                                            str29 = str45;
                                            if (e.getCause() instanceof ProtocolException) {
                                                try {
                                                    if (e.getMessage() != null) {
                                                        str44 = str33;
                                                        if (e.getMessage().toLowerCase().contains("unexpected end of stream")) {
                                                            PlayerUtils.log(4, str31, "preloadSync head preload interrupted totalPreloadedBytes=" + j28);
                                                            if (downloadListener != null) {
                                                                downloadListener.onError(str, -101);
                                                            }
                                                            str3 = str32;
                                                        }
                                                    } else {
                                                        str44 = str33;
                                                    }
                                                    StringBuilder sb6 = new StringBuilder();
                                                    sb6.append(str30);
                                                    sb6.append(j29);
                                                    sb6.append(str59);
                                                    sb6.append(str);
                                                    str3 = str32;
                                                    sb6.append(str3);
                                                    sb6.append(PlayerUtils.getPrintableStackTrace(e));
                                                    PlayerUtils.log(5, str31, sb6.toString());
                                                    if (downloadListener != null) {
                                                        downloadListener.onError(str, -102);
                                                    }
                                                } catch (Throwable th12) {
                                                    th6 = th12;
                                                    str39 = str33;
                                                    str37 = str34;
                                                    str36 = str35;
                                                    str42 = str31;
                                                    PlayerUtils.log(3, str42, str27 + j28 + " bytes");
                                                    defaultHttpDataSource.close();
                                                    PlayerUtils.log(4, str42, str28);
                                                    PlayerUtils.log(4, str42, str36 + str + str37 + j29);
                                                    throw th6;
                                                }
                                            } else {
                                                str44 = str33;
                                                str3 = str32;
                                                try {
                                                    PlayerUtils.log(5, str31, str30 + j29 + str59 + str + " pos2 " + PlayerUtils.getPrintableStackTrace(e));
                                                    if (downloadListener != null) {
                                                        downloadListener.onError(str, -103);
                                                    }
                                                } catch (Throwable th13) {
                                                    th = th13;
                                                    str36 = str35;
                                                    str37 = str34;
                                                    str39 = str44;
                                                    str43 = str31;
                                                    th6 = th;
                                                    str42 = str43;
                                                    PlayerUtils.log(3, str42, str27 + j28 + " bytes");
                                                    defaultHttpDataSource.close();
                                                    PlayerUtils.log(4, str42, str28);
                                                    PlayerUtils.log(4, str42, str36 + str + str37 + j29);
                                                    throw th6;
                                                }
                                            }
                                            PlayerUtils.log(3, str31, str27 + j28 + " bytes");
                                            defaultHttpDataSource.close();
                                            PlayerUtils.log(4, str31, str28);
                                            PlayerUtils.log(4, str31, str35 + str + str34 + j29);
                                            str4 = str31;
                                            str2 = str29;
                                            if (z17) {
                                            }
                                            videoProxy = this;
                                            iTcDataSourceUtils = videoProxy.tcDataSourceUtils;
                                            if (iTcDataSourceUtils != null) {
                                            }
                                            if (downloadListener == null) {
                                            }
                                        } catch (IOException e29) {
                                            e = e29;
                                            j17 = totalLength;
                                            r27 = " bytes for url ";
                                            parse = "preloadSync error preload ";
                                        }
                                    } catch (Throwable th14) {
                                        th = th14;
                                        str57 = TAG;
                                    }
                                } else {
                                    String str60 = url;
                                    j17 = totalLength;
                                    String str61 = " bytes for url ";
                                    String str62 = "preloadSync error preload ";
                                    str20 = TAG;
                                    try {
                                        StringBuilder sb7 = new StringBuilder();
                                        sb7.append("preloadSync head url ");
                                        sb7.append(str);
                                        str25 = " maxPreloadBytes ";
                                        try {
                                            sb7.append(str25);
                                            sb7.append(j29);
                                            PlayerUtils.log(4, str20, sb7.toString());
                                            totalLength = str20;
                                            r27 = str61;
                                            parse = str62;
                                            r29 = str60;
                                        } catch (HttpDataSource.HttpDataSourceException e36) {
                                            e = e36;
                                            str5 = videoUuidFromVideoUrl;
                                            str27 = "preloadSync head total preload ";
                                            str28 = "preloadSync head preload finish";
                                            str32 = " pos1 ";
                                            str35 = "preload_log over preloadSync head url ";
                                            str33 = "preloadSync head closeException ";
                                            str59 = str61;
                                            str30 = str62;
                                            str34 = str25;
                                            j28 = 0;
                                            str31 = str20;
                                            str29 = str60;
                                            if (e.getCause() instanceof ProtocolException) {
                                            }
                                            PlayerUtils.log(3, str31, str27 + j28 + " bytes");
                                            defaultHttpDataSource.close();
                                            PlayerUtils.log(4, str31, str28);
                                            PlayerUtils.log(4, str31, str35 + str + str34 + j29);
                                            str4 = str31;
                                            str2 = str29;
                                            if (z17) {
                                            }
                                            videoProxy = this;
                                            iTcDataSourceUtils = videoProxy.tcDataSourceUtils;
                                            if (iTcDataSourceUtils != null) {
                                            }
                                            if (downloadListener == null) {
                                            }
                                        } catch (IOException e37) {
                                            e = e37;
                                            str5 = videoUuidFromVideoUrl;
                                            str50 = str20;
                                            str49 = str61;
                                            str48 = str62;
                                            str47 = str60;
                                            str26 = "preloadSync head closeException ";
                                            str27 = "preloadSync head total preload ";
                                            str28 = "preloadSync head preload finish";
                                            j27 = 0;
                                            str24 = str50;
                                            str22 = str49;
                                            str23 = str48;
                                            str21 = str47;
                                            StringBuilder sb52 = new StringBuilder();
                                            str41 = str26;
                                            sb52.append(str23);
                                            sb52.append(j29);
                                            sb52.append(str22);
                                            sb52.append(str);
                                            sb52.append(" pos3 ");
                                            sb52.append(PlayerUtils.getPrintableStackTrace(e));
                                            PlayerUtils.log(5, str24, sb52.toString());
                                            PlayerUtils.log(4, str24, "preloadSync head url " + str + str25 + j29);
                                            if (downloadListener != null) {
                                            }
                                            PlayerUtils.log(3, str24, str27 + j27 + " bytes");
                                            defaultHttpDataSource.close();
                                            PlayerUtils.log(4, str24, str28);
                                            PlayerUtils.log(4, str24, "preload_log over preloadSync head url " + str + str25 + j29);
                                            str3 = " pos1 ";
                                            str4 = str24;
                                            str2 = str21;
                                            if (z17) {
                                            }
                                            videoProxy = this;
                                            iTcDataSourceUtils = videoProxy.tcDataSourceUtils;
                                            if (iTcDataSourceUtils != null) {
                                            }
                                            if (downloadListener == null) {
                                            }
                                        } catch (Throwable th15) {
                                            str27 = "preloadSync head total preload ";
                                            str28 = "preloadSync head preload finish";
                                            th6 = th15;
                                            str37 = str25;
                                            str36 = "preload_log over preloadSync head url ";
                                            str38 = str20;
                                            str39 = "preloadSync head closeException ";
                                            str40 = str38;
                                            j28 = 0;
                                            str42 = str40;
                                            PlayerUtils.log(3, str42, str27 + j28 + " bytes");
                                            defaultHttpDataSource.close();
                                            PlayerUtils.log(4, str42, str28);
                                            PlayerUtils.log(4, str42, str36 + str + str37 + j29);
                                            throw th6;
                                        }
                                    } catch (HttpDataSource.HttpDataSourceException e38) {
                                        e = e38;
                                        str5 = videoUuidFromVideoUrl;
                                        str27 = "preloadSync head total preload ";
                                        str28 = "preloadSync head preload finish";
                                        str35 = "preload_log over preloadSync head url ";
                                        str56 = str20;
                                        str55 = str61;
                                        str54 = str62;
                                        str53 = str60;
                                        str59 = str55;
                                        str30 = str54;
                                        str52 = str56;
                                        str51 = str53;
                                        j28 = 0;
                                        str46 = str52;
                                        str45 = str51;
                                        str32 = " pos1 ";
                                        str33 = "preloadSync head closeException ";
                                        str34 = " maxPreloadBytes ";
                                        str31 = str46;
                                        str29 = str45;
                                        if (e.getCause() instanceof ProtocolException) {
                                        }
                                        PlayerUtils.log(3, str31, str27 + j28 + " bytes");
                                        defaultHttpDataSource.close();
                                        PlayerUtils.log(4, str31, str28);
                                        PlayerUtils.log(4, str31, str35 + str + str34 + j29);
                                        str4 = str31;
                                        str2 = str29;
                                        if (z17) {
                                        }
                                        videoProxy = this;
                                        iTcDataSourceUtils = videoProxy.tcDataSourceUtils;
                                        if (iTcDataSourceUtils != null) {
                                        }
                                        if (downloadListener == null) {
                                        }
                                    } catch (Throwable th16) {
                                        th = th16;
                                        str27 = "preloadSync head total preload ";
                                        str28 = "preloadSync head preload finish";
                                        th6 = th;
                                        str36 = "preload_log over preloadSync head url ";
                                        str37 = " maxPreloadBytes ";
                                        str38 = str20;
                                        str39 = "preloadSync head closeException ";
                                        str40 = str38;
                                        j28 = 0;
                                        str42 = str40;
                                        PlayerUtils.log(3, str42, str27 + j28 + " bytes");
                                        defaultHttpDataSource.close();
                                        PlayerUtils.log(4, str42, str28);
                                        PlayerUtils.log(4, str42, str36 + str + str37 + j29);
                                        throw th6;
                                    }
                                }
                                j27 = 0;
                                while (true) {
                                    str5 = videoUuidFromVideoUrl;
                                    if (j27 < j29) {
                                        try {
                                            long read = defaultHttpDataSource.read(bArr, 0, 512);
                                            if (read != -1) {
                                                j27 += read;
                                                videoUuidFromVideoUrl = str5;
                                            }
                                        } catch (HttpDataSource.HttpDataSourceException e39) {
                                            e = e39;
                                            str32 = " pos1 ";
                                            str35 = "preload_log over preloadSync head url ";
                                            str33 = "preloadSync head closeException ";
                                            str27 = "preloadSync head total preload ";
                                            str28 = "preloadSync head preload finish";
                                            str30 = parse;
                                            str34 = str25;
                                            j28 = j27;
                                            str59 = r27;
                                            str31 = totalLength;
                                            str29 = r29;
                                            if (e.getCause() instanceof ProtocolException) {
                                            }
                                            PlayerUtils.log(3, str31, str27 + j28 + " bytes");
                                            defaultHttpDataSource.close();
                                            PlayerUtils.log(4, str31, str28);
                                            PlayerUtils.log(4, str31, str35 + str + str34 + j29);
                                            str4 = str31;
                                            str2 = str29;
                                            if (z17) {
                                            }
                                            videoProxy = this;
                                            iTcDataSourceUtils = videoProxy.tcDataSourceUtils;
                                            if (iTcDataSourceUtils != null) {
                                            }
                                            if (downloadListener == null) {
                                            }
                                        } catch (IOException e46) {
                                            e = e46;
                                            str26 = "preloadSync head closeException ";
                                            str27 = "preloadSync head total preload ";
                                            str28 = "preloadSync head preload finish";
                                            str24 = totalLength;
                                            str22 = r27;
                                            str23 = parse;
                                            str21 = r29;
                                            StringBuilder sb522 = new StringBuilder();
                                            str41 = str26;
                                            sb522.append(str23);
                                            sb522.append(j29);
                                            sb522.append(str22);
                                            sb522.append(str);
                                            sb522.append(" pos3 ");
                                            sb522.append(PlayerUtils.getPrintableStackTrace(e));
                                            PlayerUtils.log(5, str24, sb522.toString());
                                            PlayerUtils.log(4, str24, "preloadSync head url " + str + str25 + j29);
                                            if (downloadListener != null) {
                                            }
                                            PlayerUtils.log(3, str24, str27 + j27 + " bytes");
                                            defaultHttpDataSource.close();
                                            PlayerUtils.log(4, str24, str28);
                                            PlayerUtils.log(4, str24, "preload_log over preloadSync head url " + str + str25 + j29);
                                            str3 = " pos1 ";
                                            str4 = str24;
                                            str2 = str21;
                                            if (z17) {
                                            }
                                            videoProxy = this;
                                            iTcDataSourceUtils = videoProxy.tcDataSourceUtils;
                                            if (iTcDataSourceUtils != null) {
                                            }
                                            if (downloadListener == null) {
                                            }
                                        } catch (Throwable th17) {
                                            th = th17;
                                            str37 = str25;
                                            str36 = "preload_log over preloadSync head url ";
                                            j28 = j27;
                                            str39 = "preloadSync head closeException ";
                                            str27 = "preloadSync head total preload ";
                                            str28 = "preloadSync head preload finish";
                                            str43 = totalLength;
                                            th6 = th;
                                            str42 = str43;
                                            PlayerUtils.log(3, str42, str27 + j28 + " bytes");
                                            defaultHttpDataSource.close();
                                            PlayerUtils.log(4, str42, str28);
                                            PlayerUtils.log(4, str42, str36 + str + str37 + j29);
                                            throw th6;
                                        }
                                    }
                                    try {
                                        PlayerUtils.log(3, (String) totalLength, "preloadSync head total preload " + j27 + " bytes");
                                        defaultHttpDataSource.close();
                                        PlayerUtils.log(4, (String) totalLength, "preloadSync head preload finish");
                                        PlayerUtils.log(4, (String) totalLength, "preload_log over preloadSync head url " + str + str25 + j29);
                                    } catch (Exception e47) {
                                        PlayerUtils.log(4, (String) totalLength, "preloadSync head closeException " + e47);
                                        if (downloadListener != null) {
                                            downloadListener.onError(str, -105);
                                        }
                                    }
                                    str3 = " pos1 ";
                                    str4 = totalLength;
                                    str2 = r29;
                                    break;
                                }
                            } catch (IOException e48) {
                                e = e48;
                            }
                        } catch (HttpDataSource.HttpDataSourceException e49) {
                            e = e49;
                            str45 = url;
                            str46 = TAG;
                            str27 = "preloadSync head total preload ";
                            str5 = videoUuidFromVideoUrl;
                            str28 = "preloadSync head preload finish";
                            str35 = "preload_log over preloadSync head url ";
                            str30 = "preloadSync error preload ";
                            j28 = 0;
                            j17 = -1;
                        }
                    } catch (IOException e56) {
                        e = e56;
                        str21 = url;
                        str22 = " bytes for url ";
                        str23 = "preloadSync error preload ";
                        str24 = TAG;
                        str25 = " maxPreloadBytes ";
                        str26 = "preloadSync head closeException ";
                        str27 = "preloadSync head total preload ";
                        str5 = videoUuidFromVideoUrl;
                        str28 = "preloadSync head preload finish";
                        j27 = 0;
                        j17 = -1;
                    } catch (Throwable th18) {
                        th = th18;
                        str20 = TAG;
                    }
                } catch (HttpDataSource.HttpDataSourceException e57) {
                    e = e57;
                    str29 = url;
                    str30 = "preloadSync error preload ";
                    str31 = TAG;
                    str27 = "preloadSync head total preload ";
                    str5 = videoUuidFromVideoUrl;
                    str32 = " pos1 ";
                    str33 = "preloadSync head closeException ";
                    str28 = "preloadSync head preload finish";
                    str34 = " maxPreloadBytes ";
                    str35 = "preload_log over preloadSync head url ";
                    j28 = 0;
                    j17 = -1;
                }
            }
            if (z17) {
                long currentTimeMillis2 = System.currentTimeMillis();
                if (str2 != null) {
                    ?? defaultHttpDataSource2 = new DefaultHttpDataSource("com.qzone.player-v20150909", null, null);
                    ?? r56 = new byte[512];
                    ?? r65 = (j17 > (-1L) ? 1 : (j17 == (-1L) ? 0 : -1));
                    String str63 = "preloadSync tail error for url ";
                    ?? r36 = "preloadSync tail closeException ";
                    try {
                        if (r65 == 0) {
                            try {
                                defaultHttpDataSource2.open(new DataSpec(Uri.parse(str2), 0L, 0L, -1L, null, 0, null));
                                j17 = defaultHttpDataSource2.getTotalLength();
                                defaultHttpDataSource2.close();
                            } catch (HttpDataSource.HttpDataSourceException e58) {
                                e = e58;
                                videoProxy = this;
                                str13 = " bytes";
                                str14 = "preloadSync tail error for url ";
                                str15 = "preloadSync tail preload finish";
                                str16 = str3;
                                str17 = "preloadSync tail closeException ";
                                j26 = 0;
                                if (!(e.getCause() instanceof ProtocolException)) {
                                }
                                try {
                                    PlayerUtils.log(3, str4, "preloadSync tail total preload " + j26 + str13);
                                    defaultHttpDataSource2.close();
                                    PlayerUtils.log(4, str4, str15);
                                } catch (Exception e59) {
                                    PlayerUtils.log(4, str4, str17 + e59);
                                }
                                iTcDataSourceUtils = videoProxy.tcDataSourceUtils;
                                if (iTcDataSourceUtils != null) {
                                }
                                if (downloadListener == null) {
                                }
                            } catch (IOException e65) {
                                e = e65;
                                videoProxy = this;
                                str8 = " bytes";
                                str9 = "preloadSync tail error for url ";
                                str10 = "preloadSync tail preload finish";
                                str11 = str3;
                                str12 = "preloadSync tail closeException ";
                                j19 = 0;
                                PlayerUtils.log(5, str4, str9 + str + str11 + PlayerUtils.getPrintableStackTrace(e));
                                if (downloadListener != null) {
                                }
                                try {
                                    PlayerUtils.log(3, str4, "preloadSync tail total preload " + j19 + str8);
                                    defaultHttpDataSource2.close();
                                    PlayerUtils.log(4, str4, str10);
                                } catch (Exception e66) {
                                    PlayerUtils.log(4, str4, str12 + e66);
                                }
                                iTcDataSourceUtils = videoProxy.tcDataSourceUtils;
                                if (iTcDataSourceUtils != null) {
                                }
                                if (downloadListener == null) {
                                }
                            } catch (Throwable th19) {
                                th = th19;
                                str63 = "preloadSync tail closeException ";
                                r56 = " bytes";
                                r65 = "preloadSync tail preload finish";
                                r36 = 0;
                                th5 = th;
                                j18 = r36;
                                str7 = r56;
                                str6 = r65;
                                try {
                                    PlayerUtils.log(3, str4, "preloadSync tail total preload " + j18 + str7);
                                    defaultHttpDataSource2.close();
                                    PlayerUtils.log(4, str4, str6);
                                    throw th5;
                                } catch (Exception e67) {
                                    PlayerUtils.log(4, str4, str63 + e67);
                                    if (downloadListener != null) {
                                        downloadListener.onError(str, -105);
                                        throw th5;
                                    }
                                    throw th5;
                                }
                            }
                        }
                        str9 = "preloadSync tail error for url ";
                        long j38 = j17;
                        str11 = str3;
                        long j39 = ((float) j38) * 0.9f;
                        long j46 = j38 - j29;
                        try {
                            try {
                                long max = Math.max(j46, j39);
                                try {
                                    StringBuilder sb8 = new StringBuilder();
                                    try {
                                        sb8.append("preloadSync tail positionWanted=");
                                        sb8.append(j39);
                                        sb8.append(JefsClass.INDEX_URL);
                                        sb8.append(str);
                                        sb8.append(",positionMax= ");
                                        sb8.append(j46);
                                        sb8.append(",position=");
                                        sb8.append(max);
                                        PlayerUtils.log(4, str4, sb8.toString());
                                        defaultHttpDataSource2.open(new DataSpec(Uri.parse(str2), max, max, -1L, null, 0, null));
                                        r36 = 0;
                                        while (true) {
                                            try {
                                                long read2 = defaultHttpDataSource2.read(r56, 0, 512);
                                                if (read2 == -1) {
                                                    break;
                                                }
                                                r36 += read2;
                                            } catch (HttpDataSource.HttpDataSourceException e68) {
                                                e = e68;
                                                videoProxy = this;
                                            } catch (IOException e69) {
                                                e = e69;
                                                videoProxy = this;
                                            } catch (Throwable th20) {
                                                th = th20;
                                            }
                                        }
                                        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                                        videoProxy = this;
                                    } catch (HttpDataSource.HttpDataSourceException e75) {
                                        e = e75;
                                        videoProxy = this;
                                        str15 = "preloadSync tail preload finish";
                                        str17 = "preloadSync tail closeException ";
                                        str13 = " bytes";
                                        str14 = str9;
                                        str16 = str11;
                                        j26 = 0;
                                        if (!(e.getCause() instanceof ProtocolException)) {
                                        }
                                        PlayerUtils.log(3, str4, "preloadSync tail total preload " + j26 + str13);
                                        defaultHttpDataSource2.close();
                                        PlayerUtils.log(4, str4, str15);
                                        iTcDataSourceUtils = videoProxy.tcDataSourceUtils;
                                        if (iTcDataSourceUtils != null) {
                                        }
                                        if (downloadListener == null) {
                                        }
                                    } catch (IOException e76) {
                                        e = e76;
                                        videoProxy = this;
                                        str10 = "preloadSync tail preload finish";
                                        str12 = "preloadSync tail closeException ";
                                        str8 = " bytes";
                                        j19 = 0;
                                        PlayerUtils.log(5, str4, str9 + str + str11 + PlayerUtils.getPrintableStackTrace(e));
                                        if (downloadListener != null) {
                                        }
                                        PlayerUtils.log(3, str4, "preloadSync tail total preload " + j19 + str8);
                                        defaultHttpDataSource2.close();
                                        PlayerUtils.log(4, str4, str10);
                                        iTcDataSourceUtils = videoProxy.tcDataSourceUtils;
                                        if (iTcDataSourceUtils != null) {
                                        }
                                        if (downloadListener == null) {
                                        }
                                    } catch (Throwable th21) {
                                        th = th21;
                                        str19 = "preloadSync tail preload finish";
                                        str63 = "preloadSync tail closeException ";
                                        str18 = " bytes";
                                        th5 = th;
                                        j18 = 0;
                                        str7 = str18;
                                        str6 = str19;
                                        PlayerUtils.log(3, str4, "preloadSync tail total preload " + j18 + str7);
                                        defaultHttpDataSource2.close();
                                        PlayerUtils.log(4, str4, str6);
                                        throw th5;
                                    }
                                } catch (HttpDataSource.HttpDataSourceException e77) {
                                    e = e77;
                                    videoProxy = this;
                                    str17 = "preloadSync tail closeException ";
                                    str13 = " bytes";
                                    str15 = "preloadSync tail preload finish";
                                }
                            } catch (IOException e78) {
                                e = e78;
                                videoProxy = this;
                                str12 = "preloadSync tail closeException ";
                                str8 = " bytes";
                                str10 = "preloadSync tail preload finish";
                            } catch (Throwable th22) {
                                th = th22;
                                str63 = "preloadSync tail closeException ";
                                str18 = " bytes";
                                str19 = "preloadSync tail preload finish";
                            }
                        } catch (HttpDataSource.HttpDataSourceException e79) {
                            e = e79;
                            videoProxy = this;
                            str14 = str9;
                            str17 = "preloadSync tail closeException ";
                            str13 = " bytes";
                            str16 = str11;
                            str15 = "preloadSync tail preload finish";
                        }
                        try {
                            try {
                                if (videoProxy.mCacheListenerMap.containsKey(parseVideoKey)) {
                                    try {
                                        CacheListener cacheListener = videoProxy.mCacheListenerMap.get(parseVideoKey);
                                        if (cacheListener != null) {
                                            cacheListener.setFileLastModified((int) currentTimeMillis);
                                            videoProxy.mCacheListenerMap.remove(parseVideoKey);
                                        }
                                    } catch (HttpDataSource.HttpDataSourceException e85) {
                                        e = e85;
                                        str14 = str9;
                                        str15 = "preloadSync tail preload finish";
                                        str17 = "preloadSync tail closeException ";
                                        str13 = " bytes";
                                        str16 = str11;
                                        j26 = r36;
                                        if (!(e.getCause() instanceof ProtocolException)) {
                                        }
                                        PlayerUtils.log(3, str4, "preloadSync tail total preload " + j26 + str13);
                                        defaultHttpDataSource2.close();
                                        PlayerUtils.log(4, str4, str15);
                                        iTcDataSourceUtils = videoProxy.tcDataSourceUtils;
                                        if (iTcDataSourceUtils != null) {
                                        }
                                        if (downloadListener == null) {
                                        }
                                    }
                                }
                                try {
                                    PlayerUtils.log(3, str4, "preloadSync tail total preload " + r36 + " bytes");
                                    defaultHttpDataSource2.close();
                                    PlayerUtils.log(4, str4, "preloadSync tail preload finish");
                                } catch (Exception e86) {
                                    PlayerUtils.log(4, str4, "preloadSync tail closeException " + e86);
                                }
                            } catch (IOException e87) {
                                e = e87;
                                str10 = "preloadSync tail preload finish";
                                str12 = "preloadSync tail closeException ";
                                str8 = " bytes";
                                j19 = r36;
                                PlayerUtils.log(5, str4, str9 + str + str11 + PlayerUtils.getPrintableStackTrace(e));
                                if (downloadListener != null) {
                                    downloadListener.onError(str, -104);
                                }
                                PlayerUtils.log(3, str4, "preloadSync tail total preload " + j19 + str8);
                                defaultHttpDataSource2.close();
                                PlayerUtils.log(4, str4, str10);
                                iTcDataSourceUtils = videoProxy.tcDataSourceUtils;
                                if (iTcDataSourceUtils != null) {
                                }
                                if (downloadListener == null) {
                                }
                            } catch (Throwable th23) {
                                th = th23;
                                r65 = "preloadSync tail preload finish";
                                str63 = "preloadSync tail closeException ";
                                r56 = " bytes";
                                th5 = th;
                                j18 = r36;
                                str7 = r56;
                                str6 = r65;
                                PlayerUtils.log(3, str4, "preloadSync tail total preload " + j18 + str7);
                                defaultHttpDataSource2.close();
                                PlayerUtils.log(4, str4, str6);
                                throw th5;
                            }
                        } catch (HttpDataSource.HttpDataSourceException e88) {
                            e = e88;
                            str15 = "preloadSync tail preload finish";
                            str17 = "preloadSync tail closeException ";
                            str13 = " bytes";
                            str14 = str9;
                            str16 = str11;
                            j26 = r36;
                            if (!(e.getCause() instanceof ProtocolException)) {
                                if (e.getMessage() != null && e.getMessage().toLowerCase().contains("unexpected end of stream")) {
                                    PlayerUtils.log(4, str4, "preloadSync tail preload interrupted totalPreloadedBytes=" + j26);
                                    if (downloadListener != null) {
                                        downloadListener.onError(str, -101);
                                    }
                                } else {
                                    PlayerUtils.log(5, str4, str14 + str + str16 + PlayerUtils.getPrintableStackTrace(e));
                                    if (downloadListener != null) {
                                        downloadListener.onError(str, -102);
                                    }
                                }
                            } else {
                                PlayerUtils.log(5, str4, str14 + str + str16 + PlayerUtils.getPrintableStackTrace(e));
                                if (downloadListener != null) {
                                    downloadListener.onError(str, -103);
                                }
                            }
                            PlayerUtils.log(3, str4, "preloadSync tail total preload " + j26 + str13);
                            defaultHttpDataSource2.close();
                            PlayerUtils.log(4, str4, str15);
                            iTcDataSourceUtils = videoProxy.tcDataSourceUtils;
                            if (iTcDataSourceUtils != null) {
                            }
                            if (downloadListener == null) {
                            }
                        }
                        iTcDataSourceUtils = videoProxy.tcDataSourceUtils;
                        if (iTcDataSourceUtils != null) {
                            iTcDataSourceUtils.stopPlay(str5);
                        }
                        if (downloadListener == null) {
                            return true;
                        }
                        downloadListener.onEnd(str);
                        return true;
                    } catch (Throwable th24) {
                        th = th24;
                    }
                }
            }
            videoProxy = this;
            iTcDataSourceUtils = videoProxy.tcDataSourceUtils;
            if (iTcDataSourceUtils != null) {
            }
            if (downloadListener == null) {
            }
        }
        return false;
    }

    public int probeContentFlag(String str) {
        String url = getUrl(str, true, true, "-1", "video/mp4", 10, null);
        String videoUuidFromVideoUrl = PlayerUtils.getVideoUuidFromVideoUrl(url);
        DefaultHttpDataSource defaultHttpDataSource = new DefaultHttpDataSource("com.qzone.player-v20150909", null, null);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ProbeContentRequestListener probeContentRequestListener = new ProbeContentRequestListener(videoUuidFromVideoUrl, countDownLatch);
        this.videoRequestManager.addRequestListener(probeContentRequestListener);
        try {
            try {
                defaultHttpDataSource.open(new DataSpec(Uri.parse(url), 0L, 0L, -1L, null, 0, null), "HEAD");
                defaultHttpDataSource.close();
                countDownLatch.await(5L, TimeUnit.SECONDS);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            this.videoRequestManager.removeRequestListener(probeContentRequestListener);
            return probeContentRequestListener.mFlags;
        } catch (Throwable th5) {
            this.videoRequestManager.removeRequestListener(probeContentRequestListener);
            throw th5;
        }
    }

    public synchronized void removeCacheReadListener(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.cacheReadListenerMap.remove(PlayerUtils.parseVideoKey(str));
    }

    public synchronized void removeHttpErrorListener(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.httpUrlErrorListenerMap.remove(PlayerUtils.parseVideoKey(str));
    }

    public void removeHttpRetryLogic(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.httpRetryLogicMap.remove(PlayerUtils.parseVideoKey(str));
    }

    public synchronized void removeUuidErrorListener(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.uuidErrorListenerMap.remove(str);
    }

    public synchronized void setDataSourceBuilder(ITcDataSourceUtils iTcDataSourceUtils) {
        this.tcDataSourceUtils = iTcDataSourceUtils;
    }

    public void shutdown() {
        this.isShutdown = true;
        PlayerUtils.log(3, TAG, "shutting down proxy server");
        this.waitConnectionThread.interrupt();
        try {
            PlayerUtils.log(3, TAG, "close server socket");
            this.serverSocket.close();
        } catch (IOException e16) {
            PlayerUtils.log(6, TAG, "error when close proxy server " + e16.toString());
        }
        this.executorService.shutdownNow();
    }

    private void preloadMediasAsync(ArrayList<PreloadInfo> arrayList, int i3, final long j3, final PreloadListener preloadListener, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "preloadMediasAsync";
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<PreloadInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            final PreloadInfo next = it.next();
            boolean z16 = true;
            if (j3 == -1) {
                z16 = true ^ isCached(next.originalUrl);
            } else if (j3 > 0) {
                long cachedBytesFromStart = j3 - this.cache.getCachedBytesFromStart(PlayerUtils.parseVideoKey(next.originalUrl));
                PlayerUtils.log(3, str, "remainingBytes2Cache " + cachedBytesFromStart + JefsClass.INDEX_URL + next.originalUrl);
                if (cachedBytesFromStart <= 0) {
                    z16 = false;
                }
            }
            if (z16) {
                final String str2 = str;
                arrayList2.add(new Runnable() { // from class: com.tencent.oskplayer.proxy.VideoProxy.4
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoProxy.this.sendUrlRequestSync(next.localUrl, j3, preloadListener, str2);
                    }
                });
            } else {
                if (preloadListener != null) {
                    preloadListener.onFinish(next.originalUrl);
                }
                PlayerUtils.log(4, str, "url " + next.originalUrl + " already cached, cacheMaxBytes=" + j3);
            }
        }
        if (arrayList2.size() > 0) {
            ThreadUtils.executePriorityTask(arrayList2, i3);
        }
    }

    @Deprecated
    public void cancelAsync(String str) {
        PlayerUtils.log(4, TAG, "cancelAsync is not supported any more!");
    }

    public String getUrl(String str, HttpHeader httpHeader) {
        return getUrl(str, httpHeader, PlayerConfig.g().getDefaultDataSourceType());
    }

    void preloadMedia(List<String> list, int i3, long j3, PreloadListener preloadListener, HttpHeader httpHeader) {
        ArrayList<PreloadInfo> arrayList = new ArrayList<>();
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && URLUtil.isNetworkUrl(str)) {
                PreloadInfo preloadInfo = new PreloadInfo();
                preloadInfo.originalUrl = str;
                preloadInfo.localUrl = getUrl(str, true, true, "-1", "video/mp4", 10, httpHeader);
                arrayList.add(preloadInfo);
                PlayerUtils.log(4, "preloadMedia", "preload wz localUrl " + preloadInfo.localUrl);
            }
        }
        preloadMediasAsync(arrayList, i3, j3, preloadListener, "preloadMedia");
    }

    public String getUrl(String str, HttpHeader httpHeader, String str2) {
        return getUrl(str, true, true, str2, "video/mp4", 90, httpHeader);
    }

    public String getUrl(String str, boolean z16, boolean z17, String str2, String str3, int i3, HttpHeader httpHeader) {
        String str4;
        boolean z18;
        String str5;
        String str6;
        boolean z19;
        String str7;
        String str8;
        String str9;
        String str10 = "";
        if (PlayerConfig.g().isEnableProxy() && this.mProxyExceptionCount <= 3 && !this.executorService.isShutdown() && !this.executorService.isTerminated()) {
            if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
                str4 = str;
                z18 = z17;
            } else {
                String wrapFileScheme = PlayerUtils.wrapFileScheme(str);
                if (PlayerUtils.isAssetsUri(wrapFileScheme)) {
                    str4 = wrapFileScheme;
                } else {
                    if (!PlayerUtils.isRawResourceUri(wrapFileScheme)) {
                        return wrapFileScheme;
                    }
                    str4 = str;
                }
                z18 = false;
            }
            if (PlayerUtils.isHLSStream(str4)) {
                str6 = VALUE_CONTENT_TYPE_VIDEO_M3U8;
                str5 = "1";
                z19 = false;
            } else {
                str5 = str2;
                str6 = str3;
                z19 = z18;
            }
            try {
                str7 = URLEncoder.encode(str4, "UTF-8");
            } catch (UnsupportedEncodingException e16) {
                PlayerUtils.log(6, TAG, "invalid url " + PlayerUtils.getPrintableStackTrace(e16));
                str7 = "";
            }
            if (TextUtils.isEmpty(str7)) {
                PlayerUtils.log(6, TAG, "url is empty " + str7);
                return str4;
            }
            if (this.executorService.isShutdown()) {
                return str4;
            }
            if (z16) {
                str8 = "u" + String.valueOf(VIDEO_UUID.getAndIncrement());
            } else {
                str8 = null;
            }
            String fileExtension = OskFile.getFileExtension(PlayerUtils.getUrlFileName(str4));
            if (!TextUtils.isEmpty(fileExtension)) {
                str10 = "media." + fileExtension;
            }
            String str11 = getLocalServerPrefix() + "/" + str10 + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + "v" + ContainerUtils.KEY_VALUE_DELIMITER + str7 + ContainerUtils.FIELD_DELIMITER + "mType" + ContainerUtils.KEY_VALUE_DELIMITER + MTYPE;
            if (z19) {
                str11 = str11 + "&enableCache=1";
            }
            if (i3 == 90 || i3 == 10 || i3 == -1) {
                str11 = str11 + "&p=" + i3;
            }
            if (TextUtils.equals(str5, "1") || TextUtils.equals(str5, "0") || TextUtils.equals(str5, "-1")) {
                str11 = str11 + "&dataSourceType=" + str5;
            }
            if (!TextUtils.isEmpty(str6)) {
                try {
                    str9 = URLEncoder.encode(str6, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                    PlayerUtils.log(6, TAG, "unable to encode contentType " + str6);
                    str9 = null;
                }
                if (!TextUtils.isEmpty(str9)) {
                    str11 = str11 + "&preferredContentType=" + str9;
                }
            }
            if (str8 != null) {
                str11 = str11 + "&uuid=" + str8;
            }
            String str12 = str11;
            if (this.isSecretEnable && PlayerConfig.g().isEnableProxySecret()) {
                try {
                    str12 = str12 + "&t=" + SecretUtils.encode(SecretUtils.DES, SecretUtils.getRandomNum(), PlayerUtils.parseVideoKey(str4));
                } catch (Exception e17) {
                    PlayerUtils.log(6, TAG, "encode failed = " + PlayerUtils.getPrintableStackTrace(e17));
                    this.isSecretEnable = false;
                }
            }
            if (httpHeader == null) {
                return str12;
            }
            this.mExtraHeaderCollection.add(httpHeader);
            if (this.mExtraHeaderCollection.size() > 100) {
                Set<HttpHeader> set = this.mExtraHeaderCollection;
                set.remove(set.iterator().next());
            }
            return str12 + "&eh=" + httpHeader.getId();
        }
        return PlayerUtils.wrapFileScheme(str);
    }

    public List<String> getUrl(List<String> list) {
        return getUrl(list, (List<HttpHeader>) null);
    }

    public List<String> getUrl(List<String> list, List<HttpHeader> list2) {
        String str = "u" + String.valueOf(VIDEO_UUID.getAndIncrement());
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<String> it = list.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                String url = getUrl(it.next(), false, true, PlayerConfig.g().getDefaultDataSourceType(), "video/mp4", 90, list2 != null ? list2.get(i3) : null);
                if (URLUtil.isHttpUrl(url) && !TextUtils.isEmpty(url) && url.startsWith(PROXY_SERVER)) {
                    url = url + "&uuid=" + str;
                }
                arrayList.add(url);
                i3++;
            }
        }
        return arrayList;
    }
}
