package com.qzone.app;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.collection.LruCache;
import com.qzone.common.account.LoginData;
import com.qzone.util.ToastUtil;
import com.qzone.util.ar;
import com.qzone.util.x;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.media.IDownloader;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.ImageDownloadInfo;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.handler.ReportHandler;
import com.tencent.component.network.module.report.ImageDownloadReporter;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.avatar.api.IQQAvatarBroadcastApi;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneMixApi;
import com.tencent.qzonehub.api.panorama.IPanoramaUtil;
import com.tencent.state.data.SquareJSConst;
import com.tenpay.sdk.util.QQFaceFileUtil;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.cache.QZoneFilePath;
import cooperation.qzone.networkedmodule.QzoneModuleConst;
import cooperation.qzone.report.lp.LpReportInfo_DC01796;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.statistic.StatisticCollector;
import cooperation.qzone.statistic.access.WnsKeys;
import cooperation.qzone.statistic.access.concept.Statistic;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.AnimatedWebpLoaderUtil;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.ProcessUtils;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ImageEnvImpl extends ImageManagerEnv {
    private static final String CAN_REPORT_HABO = "canReportHabo";
    private static final int CLOSE_565 = 0;
    private static final String DAY = "day";
    private static final int DEFAULT_RATIO = 100;
    public static final int MAX_RETRY_TIMES = 1;
    private static final String MODEL_ID_PREFIX = "super_resolution_model_";
    private static final String MONTH = "month";
    private static final int NEED_NOT_RECYCLE = 0;
    private static final int NEED_RECYCLE = 1;
    private static final int OPEN_565 = 1;
    private static final int PREFER_NEW_ANIMATION_IMP = 1;
    private static final int PREFER_NEW_DECODE_TASK = 1;
    private static final int PREFER_OLD_DECODE_TASK = 0;
    private static final String QZONE_IMAGE_MANAGER_GET_IMAGE_CACHE = "QzoneNewService.imagemanagergetimagecache_jiehe";
    private static final int SAMPLEHITNUMBER = 0;
    private static final String SECONDARY_KEY_DRAWABLE_CACHE_RATIO_PICTURE = "image_manager_drawable_cache_ratio_picture";
    private static final String SECONDARY_KEY_DRAWABLE_CACHE_RATIO_QZONE = "image_manager_drawable_cache_ratio_qzone";
    private static final String SECONDARY_KEY_QZONE_MAX_NUM_OF_DECODING_FAILURRES = "qzoneMaxNumOfDecodingFailures";
    private static final String SECONDARY_KEY_QZONE_NEW_ANIMATION_CACHE_SIZE = "qzoneNewAnimationCacheSize";
    private static final String SECONDARY_KEY_QZONE_PREFER_NEW_ANIMATION_IMP = "qzonePreferNewAnimationImp";
    private static final int SHARPP_PLAN_B_ENABLE = 0;
    private static final String TAG = "ImageManagerEnv";
    private static final String YEAR = "year";
    private static boolean canReportHabo = true;
    private static LruCache<String, String> faceFilePathLru = new LruCache<>(100);
    private static boolean hasInitHaboSample = false;
    private static volatile boolean listViewScrollIdle = true;
    private static boolean mCurrentLoadingImgStatus = true;
    private static SharedPreferences mPreference = null;
    private static volatile boolean mShouldPlayPhotoGif = true;
    private static int sampleRange = 5000;
    private static boolean shouldPlayAnimWebp;
    private boolean isSupportGifPlaying;
    private AvatarBroadcastRegisterTask mAvatarBroadcastRegisterTask;
    private ImageManagerEnv.ILruCacheProxy mQQImageLruCacheProxy;
    ImageManagerEnv.ImageDownloaderListener imageListener = null;
    ImageManagerEnv.StreamLoadListener mStreamLoadListener = null;
    IDownloader mDownloader = null;
    Downloader mImageDownloader = null;
    Downloader.DownloadListener mRealDownloadListener = null;
    Downloader.StreamDownloadListener mGifDownloadListener = null;
    private int hasGetConfigValueForisSupportGifPlaying = -1;
    private final AtomicBoolean isCheckAvatarBroadcastRegister = new AtomicBoolean(false);
    private boolean mIsSwitchIPCChannel = false;
    ConcurrentHashMap<String, f> map = new ConcurrentHashMap<>();
    private BroadcastReceiver avatarBroadcastReceiver = null;
    private int recycleGate = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class AvatarBroadcastRegisterTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<ImageEnvImpl> f44411d;

        /* renamed from: e, reason: collision with root package name */
        private ArrayList<String> f44412e;

        AvatarBroadcastRegisterTask(ImageEnvImpl imageEnvImpl, ArrayList<String> arrayList) {
            this.f44411d = new WeakReference<>(imageEnvImpl);
            this.f44412e = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<ImageEnvImpl> weakReference = this.f44411d;
            ImageEnvImpl imageEnvImpl = weakReference == null ? null : weakReference.get();
            if (imageEnvImpl == null) {
                return;
            }
            imageEnvImpl.tryCheckIsBroadcastRegister(this.f44412e);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements Downloader.StreamDownloadListener {
        a() {
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
            ImageManagerEnv.ImageDownloaderListener imageDownloaderListener = ImageEnvImpl.this.imageListener;
            if (imageDownloaderListener != null) {
                imageDownloaderListener.onDownloadCanceled(str);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
            ImageDownloadInfo imageDownloadInfo;
            if (ImageEnvImpl.this.imageListener != null) {
                if (downloadResult == null || downloadResult.getStatus() == null) {
                    imageDownloadInfo = null;
                } else {
                    DownloadReport report = downloadResult.getReport();
                    if (report != null) {
                        ReportHandler.DownloadReportObject obtainReportObj = new ImageDownloadReporter().obtainReportObj(downloadResult, report);
                        if (obtainReportObj != null) {
                            imageDownloadInfo = new ImageDownloadInfo.Builder(downloadResult.getStatus().getFailReason(), obtainReportObj.retCode).serverIp(obtainReportObj.serverIp).clientIp(obtainReportObj.clientip).contentType(obtainReportObj.content_type).build();
                            ImageEnvImpl.reportToBeacon(obtainReportObj, false);
                        } else {
                            imageDownloadInfo = new ImageDownloadInfo.Builder(downloadResult.getStatus().getFailReason(), downloadResult.getStatus().exception2Code).build();
                        }
                    } else {
                        imageDownloadInfo = new ImageDownloadInfo.Builder(downloadResult.getStatus().getFailReason(), downloadResult.getStatus().exception2Code).build();
                    }
                }
                ImageEnvImpl.this.imageListener.onDownloadFailed(str, imageDownloadInfo);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
            ImageManagerEnv.ImageDownloaderListener imageDownloaderListener = ImageEnvImpl.this.imageListener;
            if (imageDownloaderListener != null) {
                imageDownloaderListener.onDownloadProgress(str, j3, f16);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadSucceed(String str, DownloadResult downloadResult) {
            if (ImageEnvImpl.this.imageListener != null) {
                ImageDownloadInfo build = (!downloadResult.getContent().noCache || downloadResult.getStatus() == null) ? null : new ImageDownloadInfo.Builder(0, 0).nocacheCode(downloadResult.getContent().retCode).downloadDetailInfo(downloadResult.getStatus().detailDownloadInfo).build();
                DownloadReport report = downloadResult.getReport();
                if (report != null) {
                    ImageEnvImpl.reportToBeacon(new ImageDownloadReporter().obtainReportObj(downloadResult, report), true);
                }
                ImageEnvImpl.this.imageListener.onDownloadSucceed(str, downloadResult.getPath(), downloadResult.getContent().noCache, build);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.StreamDownloadListener
        public void onStreamDownloadProgress(String str, String str2) {
            ImageManagerEnv.ImageDownloaderListener imageDownloaderListener = ImageEnvImpl.this.imageListener;
            if (imageDownloaderListener != null) {
                imageDownloaderListener.onStreamProgress(str, str2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements ImageManagerEnv.ILruCacheProxy {
        c() {
        }

        @Override // com.tencent.component.media.ImageManagerEnv.ILruCacheProxy
        public Object get(String str) {
            Object g16 = ImageCacheHelper.f98636a.g(str);
            return g16 instanceof com.tencent.cache.api.g ? ((com.tencent.cache.api.g) g16).b() : g16;
        }

        @Override // com.tencent.component.media.ImageManagerEnv.ILruCacheProxy
        public void put(String str, Object obj) {
            if (obj instanceof Drawable) {
                obj = new com.tencent.cache.api.g(obj, ImageManager.getDrawableAllocSize((Drawable) obj));
            }
            ImageCacheHelper.f98636a.i(str, obj, Business.QZone);
        }

        @Override // com.tencent.component.media.ImageManagerEnv.ILruCacheProxy
        public void remove(String str) {
            ImageCacheHelper.f98636a.m(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    static class d {

        /* renamed from: a, reason: collision with root package name */
        static Executor f44416a;

        static {
            ThreadPoolParams threadPoolParams = new ThreadPoolParams();
            threadPoolParams.poolThreadName = "decodeImage_pool";
            threadPoolParams.corePoolsize = ImageManagerEnv.g().getDecodeThreadNum(true);
            threadPoolParams.maxPooolSize = ImageManagerEnv.g().getDecodeThreadNum(true);
            boolean z16 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.QUEUE_PAUSEABLE, 1) == 1;
            QZLog.i("PausablePriorityBlockingQueue", 1, "PausablePriorityBlockingQueue pausable:", Boolean.valueOf(z16));
            if (z16) {
                threadPoolParams.queue = new PausablePriorityBlockingQueue();
            } else {
                threadPoolParams.queue = new LinkedBlockingQueue();
            }
            threadPoolParams.keepAliveTime = 10;
            f44416a = ThreadManagerV2.newFreeThreadPool(threadPoolParams);
        }

        public static Executor a() {
            return f44416a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class e {

        /* renamed from: a, reason: collision with root package name */
        static Looper f44417a;

        static {
            HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread("qzone_image_dispatcher", 5);
            newFreeHandlerThread.start();
            f44417a = newFreeHandlerThread.getLooper();
        }

        static /* bridge */ /* synthetic */ Looper a() {
            return b();
        }

        private static Looper b() {
            return f44417a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public long f44418a;

        /* renamed from: b, reason: collision with root package name */
        public int f44419b;
    }

    private static String getModuleNameById(int i3) {
        return MODEL_ID_PREFIX + i3;
    }

    private static void initHaboSample() {
        if (!updateHaboSampleDate()) {
            if (isHitHaboSample()) {
                canReportHabo = true;
            } else {
                canReportHabo = false;
            }
            SharedPreferences sharedPreferences = mPreference;
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean(CAN_REPORT_HABO, canReportHabo);
                edit.commit();
                return;
            }
            return;
        }
        SharedPreferences sharedPreferences2 = mPreference;
        if (sharedPreferences2 != null) {
            canReportHabo = sharedPreferences2.getBoolean(CAN_REPORT_HABO, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAvatarUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("avatar://");
    }

    private static boolean isHitHaboSample() {
        return new Random().nextInt(sampleRange) == 0;
    }

    public static boolean isListViewScrollIdle() {
        return listViewScrollIdle;
    }

    public static boolean isSupportAnimWebp() {
        return AnimatedWebpLoaderUtil.isSupportAnimWebp();
    }

    private static void pauseImageDecode() {
        Executor executor;
        BlockingQueue<Runnable> queue;
        if (ImageManagerEnv.g() == null || (executor = ImageManagerEnv.g().getExecutor()) == null || !(executor instanceof ThreadPoolExecutor) || (queue = ((ThreadPoolExecutor) executor).getQueue()) == null || !(queue instanceof PausablePriorityBlockingQueue)) {
            return;
        }
        ((PausablePriorityBlockingQueue) queue).pause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerAvatarReceiver(Context context) {
        if (this.avatarBroadcastReceiver == null) {
            synchronized (this) {
                if (this.avatarBroadcastReceiver == null) {
                    this.avatarBroadcastReceiver = new b();
                    try {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("com.tencent.qqhead.getheadresp");
                        context.registerReceiver(this.avatarBroadcastReceiver, intentFilter, QQFaceFileUtil.QQFaceImageGetter.ReceiverQQFacePermission, null);
                    } catch (Exception e16) {
                        QZLog.w(e16);
                    }
                }
            }
        }
    }

    private void reportImageHitToHabo(String str, int i3, int i16) {
        if (QZLog.isDevelopLevel()) {
            QZLog.d(TAG, 4, "[QZ_Video]report video event to Habo. command id = " + str + ", result code = " + i3);
        }
        StatisticCollector statisticCollector = StatisticCollector.getInstance();
        Statistic statistic = statisticCollector.getStatistic();
        statistic.setValue(WnsKeys.CommandId, str);
        statistic.setValue(WnsKeys.ResultCode_i, Integer.valueOf(i3));
        statistic.setValue(WnsKeys.TimeCost, Integer.valueOf(i16));
        statistic.setValue(WnsKeys.AppId, Integer.valueOf(statisticCollector.getAppid()));
        statistic.setValue(WnsKeys.ReleaseVersion, statisticCollector.getReleaseVersion());
        statistic.setValue(WnsKeys.ToUIN, Long.valueOf(LoginData.getInstance().getUin()));
        statistic.setValue(WnsKeys.Qua, QZoneHelper.getQUA());
        statistic.setValue(WnsKeys.Build, AppSetting.f99542b);
        statisticCollector.put(statistic);
        statisticCollector.forceReport();
    }

    private static void resumeImageDecode() {
        Executor executor;
        BlockingQueue<Runnable> queue;
        if (ImageManagerEnv.g() == null || (executor = ImageManagerEnv.g().getExecutor()) == null || !(executor instanceof ThreadPoolExecutor) || (queue = ((ThreadPoolExecutor) executor).getQueue()) == null || !(queue instanceof PausablePriorityBlockingQueue)) {
            return;
        }
        ((PausablePriorityBlockingQueue) queue).resume();
    }

    private void sendAvatarBroadcastRegisterIPCMsg(ArrayList<String> arrayList) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.mAvatarBroadcastRegisterTask = new AvatarBroadcastRegisterTask(this, arrayList);
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(this.mAvatarBroadcastRegisterTask);
        } else {
            tryCheckIsBroadcastRegister(arrayList);
        }
    }

    public static void setListViewScrollIdle(boolean z16) {
        listViewScrollIdle = z16;
    }

    public static void setShouldPlayAnimWebp(boolean z16) {
        shouldPlayAnimWebp = z16;
    }

    public static void setShouldPlayPhotoGif(boolean z16) {
        mShouldPlayPhotoGif = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryCheckIsBroadcastRegister(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2;
        try {
            if (!this.isCheckAvatarBroadcastRegister.get()) {
                ((IQQAvatarBroadcastApi) QRoute.apiIPCSync(IQQAvatarBroadcastApi.class)).resetBroadcastRegisterState();
                QLog.d(TAG, 1, "[tryCheckIsBroadcastRegister] current register avatar broadcast, isBroadcastRegister: " + ((IQQAvatarBroadcastApi) QRoute.apiIPCSync(IQQAvatarBroadcastApi.class)).checkIsBroadcastRegister(true));
                this.isCheckAvatarBroadcastRegister.set(true);
                return;
            }
            boolean z16 = !((IQQAvatarBroadcastApi) QRoute.apiIPCSync(IQQAvatarBroadcastApi.class)).checkIsBroadcastRegister(false);
            this.mIsSwitchIPCChannel = z16;
            if (z16) {
                List<String> queryAvatarByUin = ((IQQAvatarBroadcastApi) QRoute.apiIPCSync(IQQAvatarBroadcastApi.class)).queryAvatarByUin(arrayList);
                if (queryAvatarByUin == null) {
                    arrayList2 = new ArrayList<>();
                } else {
                    arrayList2 = new ArrayList<>(queryAvatarByUin);
                }
                QZLog.d(TAG, 1, "[tryCheckIsBroadcastRegister] register broadcast fail, switch ipc fetch avatar url list. uinCount: " + (arrayList == null ? 0 : arrayList.size()) + " | avatarUrlCount: " + (queryAvatarByUin == null ? 0 : queryAvatarByUin.size()));
                Intent intent = new Intent();
                intent.putStringArrayListExtra(SquareJSConst.Params.PARAMS_UIN_LIST, arrayList);
                intent.putStringArrayListExtra("headPathList", arrayList2);
                processAvatarBroadcastReceiver(intent);
            }
        } catch (Throwable th5) {
            QZLog.e(TAG, 1, "[tryCheckIsBroadcastRegister] error: ", th5);
        }
    }

    private static boolean updateHaboSampleDate() {
        int i3;
        int i16;
        int i17;
        SharedPreferences sharedPreferences = mPreference;
        if (sharedPreferences != null) {
            i3 = sharedPreferences.getInt(YEAR, 0);
            i16 = mPreference.getInt(MONTH, 0);
            i17 = mPreference.getInt(DAY, 0);
        } else {
            i3 = 0;
            i16 = 0;
            i17 = 0;
        }
        Calendar calendar = Calendar.getInstance();
        int i18 = calendar.get(1);
        int i19 = calendar.get(2);
        int i26 = calendar.get(5);
        if (i18 == i3 && i19 == i16 && i26 == i17) {
            return true;
        }
        SharedPreferences sharedPreferences2 = mPreference;
        if (sharedPreferences2 != null) {
            SharedPreferences.Editor edit = sharedPreferences2.edit();
            edit.putInt(YEAR, i18);
            edit.putInt(MONTH, i19);
            edit.putInt(DAY, i26);
            edit.commit();
        }
        return false;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public boolean closeNativeAndinBitmap() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.QZONE_IMAGE_MANAGER_MAIN_KEY, QzoneConfig.SECONDARY_KEY_CLOSE_NATIVE_INBITMAP, 0) == 1;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public boolean copyFiles(File file, File file2) {
        return FileUtils.copyFiles(file, file2);
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public boolean enableBitmapNativeAlloc() {
        return true;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public boolean enableSocketMonitor() {
        return true;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public float getAnimationDrawableCacheRatio() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", SECONDARY_KEY_QZONE_NEW_ANIMATION_CACHE_SIZE, 70) / 100.0f;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public String getAvatarPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith("avatar://")) {
            str = str.substring(9);
        }
        String str2 = faceFilePathLru.get(str);
        if (TextUtils.isEmpty(str2)) {
            str2 = QQAppInterface.getBuddyFaceFilePath(str);
            faceFilePathLru.put(str, str2);
        }
        QZLog.d(TAG, 1, "getAvatarPath ", str, " path = ", str2);
        return str2;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public float getCacheMemRatio() {
        String processName = getProcessName(ImageManagerEnv.getAppContext());
        if (ProcessUtils.isQzone(processName)) {
            float config = QzoneConfig.getInstance().getConfig("QZoneSetting", SECONDARY_KEY_DRAWABLE_CACHE_RATIO_QZONE, 100) / 100.0f;
            QZLog.i("ImageEnvImpl", "--qzone--getDrawableCacheRatio:" + config);
            return config;
        }
        if (!ProcessUtils.isPicture(processName)) {
            return 1.0f;
        }
        float config2 = QzoneConfig.getInstance().getConfig("QZoneSetting", SECONDARY_KEY_DRAWABLE_CACHE_RATIO_PICTURE, 100) / 100.0f;
        QZLog.i("ImageEnvImpl", "--picture--getDrawableCacheRatio:" + config2);
        return config2;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public boolean getCurrentLoadingImgStatus() {
        return mCurrentLoadingImgStatus;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public int getDecodeThreadNum(boolean z16) {
        int b16 = x.b();
        if (b16 < 1) {
            b16 = 1;
        }
        return b16 > 1 ? b16 - 1 : b16;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public float getDesity() {
        return ar.i();
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public Looper getDispatcher() {
        return e.a();
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public IDownloader getDownloader(ImageManagerEnv.ImageDownloaderListener imageDownloaderListener) {
        Downloader downloader;
        Downloader downloader2;
        if (this.mDownloader == null) {
            synchronized (this) {
                if (this.mDownloader == null) {
                    try {
                        downloader = com.qzone.misc.network.downloader.b.e().f();
                    } catch (Throwable th5) {
                        QZLog.w(th5);
                        downloader = null;
                    }
                    this.mImageDownloader = downloader;
                    if (downloader == null) {
                        QZLog.e(QZLog.TO_DEVICE_TAG, "ImageEnvImpl no downloader available");
                    }
                    if (1 == QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_DOWNLOADER_USE_OKHTTP_MODE, 1) && (downloader2 = this.mImageDownloader) != null) {
                        downloader2.setDownloadMode(Downloader.DownloadMode.OkHttpMode);
                    }
                    this.imageListener = imageDownloaderListener;
                    this.mRealDownloadListener = new a();
                    this.mDownloader = new IDownloader() { // from class: com.qzone.app.ImageEnvImpl.2
                        private void a(String str, String str2, boolean z16) {
                            ImageEnvImpl imageEnvImpl = ImageEnvImpl.this;
                            Downloader downloader3 = imageEnvImpl.mImageDownloader;
                            if (downloader3 == null) {
                                return;
                            }
                            try {
                                downloader3.download(str, str2, z16, imageEnvImpl.mRealDownloadListener);
                            } catch (Throwable th6) {
                                QZLog.e(ImageEnvImpl.TAG, 1, "[downloadUrl] error: ", th6);
                            }
                        }

                        @Override // com.tencent.component.media.IDownloader
                        public void cancel(String str) {
                            Downloader downloader3 = ImageEnvImpl.this.mImageDownloader;
                            if (downloader3 != null) {
                                downloader3.cancel(str, null);
                            }
                        }

                        @Override // com.tencent.component.media.IDownloader
                        public void download(String str, String str2, boolean z16) {
                            if (ImageEnvImpl.isAvatarUrl(str)) {
                                QZLog.d(ImageEnvImpl.TAG, 1, "sendBroadcastLoadAvatarImage and url = ", str);
                                ImageEnvImpl.this.registerAvatarReceiver(ImageManagerEnv.getAppContext());
                                final ArrayList arrayList = new ArrayList();
                                String substring = str.substring(9);
                                arrayList.add(substring);
                                f fVar = new f();
                                fVar.f44418a = System.currentTimeMillis();
                                fVar.f44419b = 0;
                                ImageEnvImpl.this.map.put(substring, fVar);
                                ImageEnvImpl.this.sendLoadAvatarImageBroadcastLoadAvatar(arrayList);
                                int N = QZoneConfigHelper.N();
                                if (N > 0) {
                                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).postDelayed(new Runnable() { // from class: com.qzone.app.ImageEnvImpl.2.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            ImageEnvImpl.this.retry(arrayList);
                                        }
                                    }, N);
                                    return;
                                }
                                return;
                            }
                            a(str, str2, z16);
                        }
                    };
                }
            }
        }
        return this.mDownloader;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public Executor getExecutor() {
        return d.a();
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public Looper getFileThreadLooper() {
        return ThreadManagerV2.getFileThreadLooper();
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public int getHaboReportSampleRange() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.QZONE_IMAGE_MANAGER_MAIN_KEY, QzoneConfig.QZONE_IMAGE_MANAGER_HABO_REPORT_SAMPLE_RANGE, 5000);
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public String getImageBigUrlSegment() {
        return common.config.service.b.e().d("QZoneSetting", QzoneConfig.SECONDARY_IMAGE_BIG_URL_SEGMENT, QzoneConfig.DefaultValue.DEFAULT_IMAGE_BIG_URL_SEGMENT);
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public String getImageCurrentUrlSegment() {
        return common.config.service.b.e().d("QZoneSetting", QzoneConfig.SECONDARY_IMAGE_CURRENT_URL_SEGMENT, QzoneConfig.DefaultValue.DEFAULT_IMAGE_CURRENT_URL_SEGMENT);
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public int getMaxGifRenderThreadNum() {
        return x.b();
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public int getMaxNumOfDecodingFailures() {
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", SECONDARY_KEY_QZONE_MAX_NUM_OF_DECODING_FAILURRES, 3);
        QZLog.i(TAG, 1, "--getMaxNumOfDecodingFailures:" + config);
        return config;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public int getMinMemoryClassInArt() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.QZONE_IMAGE_MANAGER_MAIN_KEY, QzoneConfig.SECONDARY_KEY_MIN_MEMEORY_CLASS_IN_ART, 0);
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public int getModelIdFromUrl(String str) {
        return -1;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public int getNetWorkState() {
        return NetworkState.getNetworkType();
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public long getNoCacheImageExpiredTime() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.QZONE_IMAGE_MANAGER_MAIN_KEY, QzoneConfig.SECONDARY_KEY_NO_CACHE_IMAGE_EXPIRED_TIME, 2L);
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public Drawable getPhotoGifDefaultDrawable() {
        Context appContext = ImageManagerEnv.getAppContext();
        if (appContext == null) {
            return null;
        }
        if (!QZoneApiProxy.isInQZoneEnvironment()) {
            return new ColorDrawable(0);
        }
        return appContext.getResources().getDrawable(R.drawable.asd);
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public String getProcessName(Context context) {
        return MobileQQ.processName;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public String getQAParameterRex() {
        return common.config.service.b.e().d("QZoneSetting", QzoneConfig.SECONDARY_SUPER_RESOLUTION_QA_PARAMETER_REX, QzoneConfig.DefaultValue.DEFAULT_QA_PARAMETER_REX);
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public ImageManagerEnv.ILruCacheProxy getQQImagecache() {
        if (this.mQQImageLruCacheProxy == null) {
            this.mQQImageLruCacheProxy = new c();
        }
        return this.mQQImageLruCacheProxy;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public int getRotationDegree(String str) {
        return JpegExifReader.getRotationDegree(str);
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public String getSRParameterRex() {
        return common.config.service.b.e().d("QZoneSetting", QzoneConfig.SECONDARY_SUPER_RESOLUTION_SR_PARAMETER_REX, QzoneConfig.DefaultValue.DEFAULT_SR_PARAMETER_REX);
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public int getScreenHeight() {
        return u5.a.c();
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public int getScreenWidth() {
        return u5.a.d();
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public String getSocketMonitorUrl(String str, ImageLoader.Options options) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (options != null && !TextUtils.isEmpty(options.type)) {
            str2 = options.type;
        } else {
            str2 = AppConstants.HTTP_TYPE_QZONE_DOWNLOAD_PIC;
        }
        return MsfSdkUtils.insertMtype(str2, str);
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public Drawable getWatermarkLogoDrawable() {
        Context appContext = ImageManagerEnv.getAppContext();
        if (appContext == null) {
            return null;
        }
        return appContext.getResources().getDrawable(R.drawable.gj5);
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public boolean isAvifSoLoaded() {
        return j.b();
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public boolean isBigUrl(String str) {
        return URLUtil.isNetworkUrl(str) && str.indexOf(ImageManagerEnv.g().getImageBigUrlSegment()) != -1;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public boolean isForceShutdownGif() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_MAIN_FORCE_SHUTDOWN_GIF_DECODE, 0) == 1;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public boolean isGifSupport565() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.QZONE_IMAGE_MANAGER_MAIN_KEY, QzoneConfig.SECONDARY_KEY_QZONE_GIF_SUPPORT_565, 1) == 1;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public boolean isHighScaleUrl(String str) {
        return false;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public boolean isMainProcess(Context context) {
        return getProcessName(context).contains(":qzone");
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public boolean isNeedRecycle() {
        if (this.recycleGate == -1) {
            this.recycleGate = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_QZONE_GIF_NEED_RECYLE_BMP, 0);
        }
        QZLog.i(TAG, 1, "isNeedRecycle:" + this.recycleGate);
        return this.recycleGate == 1;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public boolean isOpenGetImageSuccessRecorder() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.QZONE_IMAGE_MANAGER_MAIN_KEY, QzoneConfig.QZONE_IMAGE_MANAGER_OPEN_GET_IMAGE_SUCCESS_RECORDER, 1) == 1;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public boolean isPreferNewAnimationImp() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", SECONDARY_KEY_QZONE_PREFER_NEW_ANIMATION_IMP, 0) == 1;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public boolean isPreferNewGifDecodeTask() {
        return !com.qzone.app.d.b() && QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_QZONE_GIF_PREFER_NEW_DECODE_TASK, 1) == 1;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public boolean isQQProcess(Context context) {
        return getProcessName(context).equals("com.tencent.mobileqq");
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public boolean isSuperResolutionUrl(String str) {
        return false;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public boolean isSupportGifPlaying() {
        if (this.hasGetConfigValueForisSupportGifPlaying > -1) {
            return this.isSupportGifPlaying;
        }
        boolean z16 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_GIF_SETTING, QzoneConfig.SECONDARY_KEY_GIF_DOWNLOAD_AND_PLAY, 1) == 1 && Build.VERSION.SDK_INT >= QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_GIF_SETTING, QzoneConfig.SECONDARY_KEY_GIF_DOWNLOAD_AND_PLAY_SDK_LEVEL, 21);
        this.isSupportGifPlaying = z16;
        this.hasGetConfigValueForisSupportGifPlaying++;
        return z16;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public boolean isSupportSharpp() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_SHARPP_PLAN_B_SWITCH, 0) != 0 || ((IQzoneMixApi) QRoute.api(IQzoneMixApi.class)).isSupportSharpP(BaseApplication.getContext()) == 1;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public boolean isWNSSupportPieceLoad() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_PICTURE_PIECE_LOAD, 1) == 1;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public boolean loadLibrary(String str) {
        if (QzoneModuleConst.QZONE_DECODE_ANIMATED_WEBP_KEY.equals(str)) {
            return AnimatedWebpLoaderUtil.loadSo();
        }
        ImageManagerEnv.getAppContext();
        if (TextUtils.isEmpty(str) || !str.equals(SoLoadConstants.SONAME_SHARPDEC)) {
            return false;
        }
        QZLog.i("ImageEnvImpl", 1, "-------load library for sharpp");
        return ((IQzoneMixApi) QRoute.api(IQzoneMixApi.class)).getVersion() >= 12;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public boolean needCheckAvatar() {
        return true;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public boolean openProgressTracer() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_IMAGE_JAR_PROGRESS_TRACER, 0) > 0;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public int panoramaComputeSampleSize(ImageLoader.Options options, int i3, int i16) {
        return ((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).computeSampleSize(options, i3, i16);
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public byte[] readFile(String str) {
        return com.tencent.mobileqq.utils.FileUtils.readFile(str);
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public String removeSocketMonitorParam(String str) {
        char charAt;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = HttpMsg.MTYPE + '=';
        int indexOf = str.indexOf(str2);
        if (indexOf <= -1) {
            return str;
        }
        int i3 = indexOf - 1;
        char charAt2 = str.charAt(i3);
        if (charAt2 != '?' && charAt2 != '#' && charAt2 != '&') {
            return str;
        }
        int length = indexOf + str2.length();
        while (length < str.length() && (charAt = str.charAt(length)) != '&' && charAt != '#') {
            length++;
        }
        return str.substring(0, i3) + str.substring(length);
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public void reportAnimationDrawableSize(int i3) {
        QZLog.d(TAG, 2, "reportAnimationDrawableSize(KB)--" + i3);
        com.qzone.app.d.e(i3);
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public void reportEventToMTA(final String str, final Properties properties) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.ReportThread).post(new Runnable() { // from class: com.qzone.app.ImageEnvImpl.6
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> hashMap = new HashMap<>();
                Properties properties2 = properties;
                if (properties2 != null && properties2.size() > 0) {
                    for (Map.Entry entry : properties.entrySet()) {
                        hashMap.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
                    }
                }
                com.tencent.mobileqq.statistics.StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(LoginData.getInstance().getUinString(), str, true, 0L, 0L, hashMap, null);
            }
        });
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public void reportGetImageCacheToMM(int i3) {
        if (!hasInitHaboSample) {
            sampleRange = ImageManagerEnv.g().getHaboReportSampleRange();
            mPreference = PreferenceManager.getCachePreference(BaseApplication.getContext(), LoginData.getInstance().getUin());
            initHaboSample();
            hasInitHaboSample = true;
        }
        if (canReportHabo) {
            reportImageHitToHabo(QZONE_IMAGE_MANAGER_GET_IMAGE_CACHE, i3, 0);
        }
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public void reportGifFrameRate(int i3, float f16, float f17) {
        com.qzone.app.d.f(i3, f16, f17);
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public void reportImageDecodingRes(String str, String str2, long j3, boolean z16, long j16, int i3) {
        com.qzone.app.d.g(str, str2, j3, z16, j16, i3);
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public void reportImageDecodingTask(String str, String str2, long j3, int i3, String str3, long j16) {
        ReportHandler.DownloadReportObject downloadReportObject = new ReportHandler.DownloadReportObject();
        downloadReportObject.endTime = j16;
        downloadReportObject.content_type = str;
        downloadReportObject.url = str2;
        downloadReportObject.fileSize = j3;
        downloadReportObject.retCode = i3;
        downloadReportObject.logInfo = str3;
        LpReportManager.getInstance().reportToDC01796(new LpReportInfo_DC01796(downloadReportObject));
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public boolean shouldPlayAnimWebp() {
        return shouldPlayAnimWebp;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public boolean shouldPlayPhotoGif() {
        return mShouldPlayPhotoGif;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public boolean shouldUseJpgWhenAvifDisable() {
        return true;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public void statisticCollectorReport(final String str, final HashMap<String, String> hashMap) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.ReportThread).post(new Runnable() { // from class: com.qzone.app.ImageEnvImpl.7
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.mobileqq.statistics.StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(LoginData.getInstance().getUinString(), str, true, 0L, 0L, hashMap, (String) null, true);
            }
        });
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public boolean useARGB8888Config() {
        boolean z16 = QzoneConfig.getInstance().getConfig(QzoneConfig.QZONE_IMAGE_MANAGER_MAIN_KEY, QzoneConfig.SECOND_KEY_IMAGE_MANAGER_USE_ARGB8888, 1) == 0;
        Context appContext = ImageManagerEnv.getAppContext();
        if (appContext == null) {
            w5.b.b(TAG, 1, "useARGB8888Config, context = " + appContext);
            return false;
        }
        if (((ActivityManager) appContext.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getMemoryClass() < QzoneConfig.getInstance().getConfig(QzoneConfig.QZONE_IMAGE_MANAGER_MAIN_KEY, QzoneConfig.SECOND_KEY_IMAGE_MANAGER_MEMORY_RESTRICTION, 128)) {
            return false;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !"com.tencent.qqhead.getheadresp".equals(intent.getAction())) {
                return;
            }
            ImageEnvImpl.this.processAvatarBroadcastReceiver(intent);
        }
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public void showToast(int i3, Context context, CharSequence charSequence, int i16) {
        ToastUtil.s(charSequence, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportToBeacon(ReportHandler.DownloadReportObject downloadReportObject, boolean z16) {
        String sb5;
        if (downloadReportObject == null || TextUtils.isEmpty(downloadReportObject.url)) {
            return;
        }
        if (downloadReportObject.url.contains("qzonestyle.gtimg.cn") || downloadReportObject.url.contains("r.photo.store.qq.com")) {
            HashMap hashMap = new HashMap();
            hashMap.put("retCode", String.valueOf(downloadReportObject.retCode));
            StringBuilder sb6 = downloadReportObject.errMsg;
            String str = "";
            if (sb6 == null) {
                sb5 = "";
            } else {
                sb5 = sb6.toString();
            }
            hashMap.put("errMsg", sb5);
            hashMap.put("logInfo", downloadReportObject.logInfo);
            Throwable th5 = downloadReportObject.f99898t;
            if (th5 != null) {
                str = th5.getMessage();
            }
            hashMap.put("exceptionMsg", str);
            hashMap.put("event_result", String.valueOf(z16));
            VasStatisticCollector.report("qzone_download_report", hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retry(ArrayList<String> arrayList) {
        f fVar;
        if (arrayList == null || arrayList.isEmpty() || this.map.isEmpty()) {
            return;
        }
        final ArrayList<String> arrayList2 = new ArrayList<>();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (this.map.containsKey(next) && (fVar = this.map.get(next)) != null) {
                int i3 = fVar.f44419b;
                if (i3 > 1) {
                    this.map.remove(next);
                } else {
                    fVar.f44419b = i3 + 1;
                    fVar.f44418a = System.currentTimeMillis();
                    this.map.put(next, fVar);
                }
                arrayList2.add(next);
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        sendLoadAvatarImageBroadcastLoadAvatar(arrayList2);
        int N = QZoneConfigHelper.N();
        if (N > 0) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).postDelayed(new Runnable() { // from class: com.qzone.app.ImageEnvImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    ImageEnvImpl.this.retry(arrayList2);
                }
            }, N);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendLoadAvatarImageBroadcastLoadAvatar(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            sendAvatarBroadcastRegisterIPCMsg(arrayList);
            so.b.d().j(arrayList);
        } else {
            QZLog.e(TAG, 1, "[sendLoadAvatarImageBroadcastLoadAvatar] current uin list is empty, load flow end.");
        }
    }

    public static void setCurrentLoadingImgStatus(boolean z16) {
        if (z16) {
            resumeImageDecode();
        } else {
            pauseImageDecode();
        }
        mCurrentLoadingImgStatus = z16;
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public String getImageCacheDir(boolean z16) {
        if (z16) {
            return QZoneFilePath.ROOT_QZONE_PATH;
        }
        return CacheManager.getInternalCacheDir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processAvatarBroadcastReceiver(final Intent intent) {
        if (intent == null) {
            QLog.d(TAG, 1, "[processAvatarBroadcastReceiver] intent should not be null.");
        } else {
            ThreadManagerV2.post(new Runnable() { // from class: com.qzone.app.ImageEnvImpl.5
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(SquareJSConst.Params.PARAMS_UIN_LIST);
                    ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("headPathList");
                    if (stringArrayListExtra != null && !stringArrayListExtra.isEmpty() && stringArrayListExtra2 != null && !stringArrayListExtra2.isEmpty() && stringArrayListExtra.size() == stringArrayListExtra2.size()) {
                        int size = stringArrayListExtra.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            String str = stringArrayListExtra.get(i3);
                            String str2 = stringArrayListExtra2.get(i3);
                            if (!TextUtils.isEmpty(str2)) {
                                File file = new File(str2);
                                if (file.isFile() && file.length() > 0) {
                                    ImageEnvImpl.this.map.remove(str);
                                    ImageManagerEnv.ImageDownloaderListener imageDownloaderListener = ImageEnvImpl.this.imageListener;
                                    if (imageDownloaderListener != null) {
                                        imageDownloaderListener.onDownloadSucceed("avatar://" + str, file.getAbsolutePath(), false, null);
                                    }
                                }
                                QZLog.d(ImageEnvImpl.TAG, 1, "[processAvatarBroadcastReceiver] and uin = ", str, " path = ", str2);
                            }
                        }
                        return;
                    }
                    QLog.d(ImageEnvImpl.TAG, 1, "[processAvatarBroadcastReceiver] current uin list is empty, load fail.");
                }
            }, 8, null, false);
        }
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public void reportException(Throwable th5) {
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public void reportImageDecodingResMTA(String str, String str2) {
    }

    @Override // com.tencent.component.media.ImageManagerEnv
    public void reportImageTimeCostMTA(String str, String str2, String str3, int i3) {
    }
}
