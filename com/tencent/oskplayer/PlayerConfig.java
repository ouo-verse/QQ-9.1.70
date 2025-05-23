package com.tencent.oskplayer;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.ext.mediaplayer.ExoMediaPlayer;
import com.tencent.oskplayer.datasource.HttpHeader;
import com.tencent.oskplayer.model.PlayerCallBack;
import com.tencent.oskplayer.proxy.DataSourceBuilder;
import com.tencent.oskplayer.proxy.VideoKeyGenerator;
import com.tencent.oskplayer.proxy.VideoProxy;
import com.tencent.oskplayer.report.IVideoReporter;
import com.tencent.oskplayer.service.DNSService;
import com.tencent.oskplayer.support.loader.DefaultNativeLibLoader;
import com.tencent.oskplayer.support.loader.NativeLibLoader;
import com.tencent.oskplayer.util.DefaultLogger;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.oskplayer.util.QLog;
import cooperation.qzone.cache.CacheManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes22.dex */
public class PlayerConfig {
    public static final boolean ASSERTIONS_ENABLED = true;
    public static final int CACHE_PROVIDER_LOCAL = 1;
    public static final int CACHE_PROVIDER_TC = 2;
    public static String CONTENT_TYPE_AUDIO_MP4 = "audio/mp4";
    public static String CONTENT_TYPE_HLS_PLAYLIST = "application/vnd.apple.mpegurl";
    public static String CONTENT_TYPE_HLS_PLAYLIST_COMPAT = "application/x-mpeg";
    public static String CONTENT_TYPE_HLS_PLAYLIST_COMPAT2 = "application/x-mpegURL";
    public static String CONTENT_TYPE_MPEG_TS = "video/MP2T";
    public static String CONTENT_TYPE_OCT_STREAM = "application/octet-stream";
    public static String CONTENT_TYPE_VIDEO_3GP = "video/3gp";
    public static String CONTENT_TYPE_VIDEO_MP4 = "video/mp4";
    public static String CONTENT_TYPE_VIDEO_MPEG = "video/mpeg";
    private static final long DEFUALT_CACHE_MAX_BYTES = 536870912;
    private static final long DEFUALT_CACHE_SINGLE_FILE_BYTES = 1048576;
    private static final int DEFUALT_CORE_CLIENT_COUNT = 10;
    private static final int DEFUALT_MAX_CLIENT_COUNT = 10;
    public static final String H265_DECODE_SCORE_REPORTED_MARK_PREFERENCE_KEY = "h265_decode_score_reported";
    public static final String LOCAL_CACHE_DIR_NAME = "local";
    public static final int MIN_FREE_SPACE = 1;
    public static final String SERVER = "videoproxy 1.4.1";
    private static final String TAG = "PlayerConfig";
    public static final String TC_CACHE_DIR_NAME = "tc";
    public static final boolean TRACE_ENABLED = true;
    public static final String USER_AGENT = "com.qzone.player-v20150909";
    public static final String VERSION = "1.4.1";
    private static final QLog defaultLogger = new DefaultLogger();
    private static volatile PlayerConfig instance;
    private Context appContext;
    private String cacheDir;
    private DataSourceBuilder dataSourceBuilder;
    private List<String> hostLastPathVideoList;
    private QLog logger;
    private List<String> mContentTypeList;
    private DNSService mDnsService;
    private boolean mEnableIResearchReport;
    private HttpHeader mExtraHeader;
    private NativeLibLoader mLibLoader;
    private List<String> mTcVideoPathList;
    private IVideoReporter mVideoReporter;
    private List<String> mWeiShiUgcVideoPathList;
    private List<String> mWeiShiVideoPathList;
    private List<String> normalVideoPathList;
    private VideoProxy.OnConnectionChangeListener onConnectionChangeListener;
    private Set<PlayerCallBack> playerCallBacks;
    private String tmpDir;
    private VideoKeyGenerator videoKeyGenerator;
    private boolean mIsDebug = false;
    private long cacheMaxBytes = 536870912;
    private long cacheSingleFileBytes = 1048576;
    private boolean enableProxy = true;
    private boolean enableCache = true;
    private boolean enableProxySecret = true;
    private int coreClientCount = 10;
    private int maxClientCount = 10;
    private int mVideoLowSpeedSeconds = 8;
    private int mVideoLowSpeedRates = 20;
    private int mSafeUrlTimeOut = 8;
    private int mVideoVkeyTimeOut = 10;
    private int mLogcatContextSeconds = 10;
    private int mCacheProvider = 1;
    private String mQLoadControlConfig = ExoMediaPlayer.DEFAULT_LC_SAMPLE_CONFIG;
    private String mHostEnableHttpDNSService = "";
    private String mHostEnableHttpDNSServicePrependIp = "";
    private List<String> mHeroInfoList = new ArrayList();
    public int mVideoFloatCompleteType = 1;
    public int mDataSourceMaxRetryCount = 5;
    private boolean mServerIPWithGetByName = false;
    private boolean mEnableWeishiDirectIp = false;
    private boolean mIsEnableHLSCache = true;
    private boolean mIsEnableHevcHwDecode = false;
    private volatile int mIPStackType = -1;
    private String mDefaultDataSourceType = "-1";

    PlayerConfig(Context context) {
        this.appContext = context;
    }

    public static PlayerConfig g() {
        if (instance != null) {
            return instance;
        }
        throw new RuntimeException("PlayerConfig not initialized!");
    }

    private String getCacheProvideFileDir(String str) {
        String str2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append(File.separator);
        if (isCacheProviderLocal()) {
            str2 = "local";
        } else {
            str2 = TC_CACHE_DIR_NAME;
        }
        sb5.append(str2);
        String sb6 = sb5.toString();
        File file = new File(sb6);
        if (file.isFile()) {
            PlayerUtils.log(4, TAG, "fileDir:" + sb6 + " is file, delete result:" + file.delete());
        }
        if (!file.exists()) {
            PlayerUtils.log(4, TAG, "fileDir:" + sb6 + " is not exist, make dir result:" + file.mkdirs());
        }
        return sb6;
    }

    public static boolean hasInit() {
        if (instance != null) {
            return true;
        }
        return false;
    }

    public static void init(Context context) {
        if (instance == null) {
            synchronized (PlayerConfig.class) {
                if (instance == null) {
                    instance = new PlayerConfig(context);
                }
            }
        }
    }

    public Context getAppContext() {
        return this.appContext;
    }

    public String getCacheDir() {
        File file;
        if (TextUtils.isEmpty(this.cacheDir)) {
            try {
                file = this.appContext.getExternalCacheDir();
            } catch (Exception unused) {
                file = null;
            }
            if (file == null) {
                return null;
            }
            return getCacheProvideFileDir(file + File.separator + CacheManager.VIDEO_PLAY_CACHE_DIR);
        }
        return this.cacheDir;
    }

    public long getCacheMaxBytes() {
        return this.cacheMaxBytes;
    }

    public long getCacheSingleFileBytes() {
        return this.cacheSingleFileBytes;
    }

    public synchronized Set<PlayerCallBack> getCallbacks() {
        return this.playerCallBacks;
    }

    public List<String> getContentTypeList() {
        List<String> list = this.mContentTypeList;
        if (list != null) {
            return list;
        }
        return new ArrayList(Arrays.asList(CONTENT_TYPE_VIDEO_MP4, CONTENT_TYPE_VIDEO_3GP, CONTENT_TYPE_AUDIO_MP4, CONTENT_TYPE_OCT_STREAM, CONTENT_TYPE_VIDEO_MPEG, CONTENT_TYPE_HLS_PLAYLIST, CONTENT_TYPE_HLS_PLAYLIST_COMPAT, CONTENT_TYPE_HLS_PLAYLIST_COMPAT2, CONTENT_TYPE_MPEG_TS));
    }

    public int getCoreClientCount() {
        return this.coreClientCount;
    }

    public DNSService getDNSService() {
        return this.mDnsService;
    }

    public DataSourceBuilder getDataSourceBuilder() {
        return this.dataSourceBuilder;
    }

    public int getDataSourceMaxRetryCount() {
        return this.mDataSourceMaxRetryCount;
    }

    public String getDefaultDataSourceType() {
        return this.mDefaultDataSourceType;
    }

    public int getFloafVideoCompleteType() {
        return this.mVideoFloatCompleteType;
    }

    public HttpHeader getGlobalExtraHeader() {
        return this.mExtraHeader;
    }

    public List<String> getHeroPlayerSetInfo() {
        return this.mHeroInfoList;
    }

    public List<String> getHostLastPathVideoList() {
        return this.hostLastPathVideoList;
    }

    public int getIPStackType() {
        return this.mIPStackType;
    }

    public int getLogcatContextSecond() {
        return this.mLogcatContextSeconds;
    }

    public QLog getLogger() {
        QLog qLog = this.logger;
        if (qLog == null) {
            return defaultLogger;
        }
        return qLog;
    }

    public int getMaxClientCount() {
        return this.maxClientCount;
    }

    public NativeLibLoader getNativeLibLoader() {
        if (this.mLibLoader == null) {
            this.mLibLoader = new DefaultNativeLibLoader();
        }
        return this.mLibLoader;
    }

    public List<String> getNormalVideoPathList() {
        return this.normalVideoPathList;
    }

    public VideoProxy.OnConnectionChangeListener getOnConnectionChangeListener() {
        return this.onConnectionChangeListener;
    }

    public String getQLoadControlConfig() {
        return this.mQLoadControlConfig;
    }

    public int getSafeUrlTimeOut() {
        return this.mSafeUrlTimeOut;
    }

    public List<String> getTcVideoPathList() {
        return this.mTcVideoPathList;
    }

    public String getTempDir() {
        if (TextUtils.isEmpty(this.tmpDir)) {
            File filesDir = this.appContext.getFilesDir();
            if (filesDir == null) {
                return null;
            }
            return filesDir + File.separator + "video_tmp_files";
        }
        return this.tmpDir;
    }

    public int getVideoEnableLowSpeedRates() {
        return this.mVideoLowSpeedRates;
    }

    public int getVideoEnableLowSpeedSeconds() {
        return this.mVideoLowSpeedSeconds;
    }

    public VideoKeyGenerator getVideoKeyGenerator() {
        return this.videoKeyGenerator;
    }

    public IVideoReporter getVideoReporter() {
        return this.mVideoReporter;
    }

    public int getVideoVkeyTimeOut() {
        return this.mVideoVkeyTimeOut;
    }

    public List<String> getWeiShiUgcVideoPathList() {
        return this.mWeiShiUgcVideoPathList;
    }

    public List<String> getWeiShiVideoPathList() {
        return this.mWeiShiVideoPathList;
    }

    public boolean isCacheProviderLocal() {
        if (this.mCacheProvider == 1) {
            return true;
        }
        return false;
    }

    public boolean isDebugVersion() {
        return this.mIsDebug;
    }

    public boolean isEnableCache() {
        return this.enableCache;
    }

    public boolean isEnableHLSCache() {
        return this.mIsEnableHLSCache;
    }

    public boolean isEnableHevcHwDecode() {
        return this.mIsEnableHevcHwDecode;
    }

    public boolean isEnableProxy() {
        return this.enableProxy;
    }

    public boolean isEnableProxySecret() {
        return this.enableProxySecret;
    }

    public boolean isEnableWeishiDirectIp() {
        return this.mEnableWeishiDirectIp;
    }

    public boolean isHostEnableHttpDNSService(String str) {
        if (!TextUtils.isEmpty(this.mHostEnableHttpDNSService)) {
            return this.mHostEnableHttpDNSService.contains(str);
        }
        return false;
    }

    public boolean isHostEnableHttpDNSServicePrependIp(String str) {
        if (!TextUtils.isEmpty(this.mHostEnableHttpDNSServicePrependIp)) {
            return this.mHostEnableHttpDNSServicePrependIp.contains(str);
        }
        return false;
    }

    public boolean isIResearchEnabled() {
        return this.mEnableIResearchReport;
    }

    public boolean isServerIPWithGetByName() {
        return this.mServerIPWithGetByName;
    }

    public synchronized void registerCallback(PlayerCallBack playerCallBack) {
        if (playerCallBack != null) {
            if (this.playerCallBacks == null) {
                this.playerCallBacks = Collections.newSetFromMap(new ConcurrentHashMap(4, 0.75f));
            }
            this.playerCallBacks.add(playerCallBack);
        }
    }

    public void setCacheDir(String str) {
        this.cacheDir = getCacheProvideFileDir(str);
    }

    public void setCacheMaxBytes(long j3) {
        this.cacheMaxBytes = j3;
    }

    public void setCacheProvider(int i3) {
        this.mCacheProvider = i3;
    }

    public void setCacheSingleFileBytes(long j3) {
        this.cacheSingleFileBytes = j3;
    }

    public void setContentTypeList(List<String> list) {
        this.mContentTypeList = list;
    }

    public void setDNSService(DNSService dNSService) {
        this.mDnsService = dNSService;
    }

    public void setDataSourceBuilder(DataSourceBuilder dataSourceBuilder) {
        this.dataSourceBuilder = dataSourceBuilder;
    }

    public void setDataSourceMaxRetryCount(int i3) {
        this.mDataSourceMaxRetryCount = i3;
    }

    public void setDefaultDataSourceType(String str) {
        this.mDefaultDataSourceType = str;
    }

    public void setEnableCache(boolean z16) {
        this.enableCache = z16;
    }

    public void setEnableHLSCache(boolean z16) {
        this.mIsEnableHLSCache = z16;
    }

    public void setEnableHevcHwDecode(boolean z16) {
        this.mIsEnableHevcHwDecode = z16;
    }

    public void setEnableIResearchReport(boolean z16) {
        this.mEnableIResearchReport = z16;
    }

    public void setEnableProxy(boolean z16) {
        this.enableProxy = z16;
    }

    public void setEnableProxySecret(boolean z16) {
        this.enableProxySecret = z16;
    }

    public void setEnableWeishiDirectIp(boolean z16) {
        this.mEnableWeishiDirectIp = z16;
    }

    public void setFloatVideoCompleteType(int i3) {
        this.mVideoFloatCompleteType = i3;
    }

    public void setGlobalExtraHeader(HttpHeader httpHeader) {
        this.mExtraHeader = httpHeader;
    }

    public void setHeroPlayerSetInfo(List<String> list) {
        this.mHeroInfoList = list;
    }

    public void setHostEnableHttpDNSService(String str) {
        this.mHostEnableHttpDNSService = str;
    }

    public void setHostEnableHttpDNSServicePrependIp(String str) {
        this.mHostEnableHttpDNSServicePrependIp = str;
    }

    public void setHostLastPathVideoList(List<String> list) {
        this.hostLastPathVideoList = list;
    }

    public void setIPStackType(int i3) {
        PlayerUtils.log(4, TAG, "setIPStackType " + i3);
        this.mIPStackType = i3;
    }

    public void setIsDebugVersion(boolean z16) {
        this.mIsDebug = z16;
    }

    public void setLogcatContextSecond(int i3) {
        this.mLogcatContextSeconds = i3;
    }

    public void setLogger(QLog qLog) {
        this.logger = qLog;
    }

    public void setNativeLibLoader(NativeLibLoader nativeLibLoader) {
        this.mLibLoader = nativeLibLoader;
    }

    public void setNormalVideoPathList(List<String> list) {
        this.normalVideoPathList = list;
    }

    public void setOnConnectionChangeListener(VideoProxy.OnConnectionChangeListener onConnectionChangeListener) {
        this.onConnectionChangeListener = onConnectionChangeListener;
    }

    public void setQLoadControlConfig(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mQLoadControlConfig = str;
            return;
        }
        PlayerUtils.log(6, TAG, "setQLoadControlConfig ineffective " + str);
    }

    public void setSafeUrlTimeOut(int i3) {
        this.mSafeUrlTimeOut = i3;
    }

    public void setServerIpWithGetByName(boolean z16) {
        this.mServerIPWithGetByName = z16;
    }

    public void setTcVideoPathList(List<String> list) {
        this.mTcVideoPathList = list;
    }

    public void setVideoEnableLowSpeedRates(int i3) {
        this.mVideoLowSpeedRates = i3;
    }

    public void setVideoEnableLowSpeedSeconds(int i3) {
        this.mVideoLowSpeedSeconds = i3;
    }

    public void setVideoKeyGenerator(VideoKeyGenerator videoKeyGenerator) {
        this.videoKeyGenerator = videoKeyGenerator;
    }

    public void setVideoReporter(IVideoReporter iVideoReporter) {
        this.mVideoReporter = iVideoReporter;
    }

    public void setVideoVkeyTimeOut(int i3) {
        this.mVideoVkeyTimeOut = i3;
    }

    public void setWeiShiUgcVideoPathList(List<String> list) {
        this.mWeiShiUgcVideoPathList = list;
    }

    public void setWeiShiVideoPathList(List<String> list) {
        this.mWeiShiVideoPathList = list;
    }

    public synchronized void unregisterCallback(PlayerCallBack playerCallBack) {
        if (playerCallBack != null) {
            Set<PlayerCallBack> set = this.playerCallBacks;
            if (set != null) {
                set.remove(playerCallBack);
            }
        }
    }
}
