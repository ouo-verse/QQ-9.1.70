package com.tencent.ad.tangram.views.canvas.components.appbutton;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.downloader.AdDownloadTask;
import com.tencent.ad.tangram.downloader.AdDownloader;
import com.tencent.ad.tangram.downloader.IAdDownloader;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdNet;
import com.tencent.ad.tangram.protocol.landing_page_collect_data;
import com.tencent.ad.tangram.statistics.AdReportForAction;
import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.ad.tangram.statistics.canvas.AdRefreshCallback;
import com.tencent.ad.tangram.statistics.canvas.AdReport;
import com.tencent.ad.tangram.statistics.canvas.AdReporterForDMPWithCanvas;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdAppUtil;
import com.tencent.ad.tangram.views.canvas.AdCanvasDownloadListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdAppDownloadManager implements IAdDownloader.Callback {
    public static final int DOWNLOAD_CANCELED = 4;
    public static final int DOWNLOAD_ERROR = 5;
    public static final int DOWNLOAD_FINISHED = 3;
    public static final int DOWNLOAD_ING = 8;
    public static final int DOWNLOAD_INSTALL_SUCCESS = 6;
    public static final int DOWNLOAD_NONE = 0;
    public static final int DOWNLOAD_PAUSED = 2;
    public static final int DOWNLOAD_STARTED = 1;
    public static final int DOWNLOAD_UNINSTALL_SUCCESS = 7;
    private static final int MAX_TRY = 3;
    private static final String TAG = "AdAppDownloadManager";

    /* renamed from: ad, reason: collision with root package name */
    public Ad f61340ad;
    private volatile boolean initialized;
    private boolean isLoadingAppData;
    private volatile AdAppBtnData mCgdtAppBtnData;
    private WeakReference<Context> mContext;
    public String sourceId;
    private boolean mStartedDownload = false;
    private boolean autodownload = false;

    @Nullable
    private ClickLoadAppJob mClickLoadAppJob = null;

    @NonNull
    private CopyOnWriteArrayList<AppDownloadManagerAdapter> mBtnUIPresenterList = new CopyOnWriteArrayList<>();

    @NonNull
    private ArrayList<DownloadStatusCallback> downloadStatusCallbacks = new ArrayList<>();

    @NonNull
    private ArrayList<AdRefreshCallback> adRefreshCallbacks = new ArrayList<>();

    @Nullable
    private AppDataDownloadCallback appDataDownloadCallbacks = null;

    @Nullable
    private WeakReference<AppDataCallback> dataCallbackWeakReference = null;

    @Nullable
    private AdDownloaderWrapper downloaderWrapper = null;

    @NonNull
    private Runnable mWiFiDelayJob = new Runnable() { // from class: com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager.1
        @Override // java.lang.Runnable
        public void run() {
            AdAppDownloadManager.this.autodownload = false;
        }
    };

    @NonNull
    private Runnable mLoadAppJob = new Runnable() { // from class: com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager.2
        @Override // java.lang.Runnable
        public void run() {
            AppDataCallback appDataCallback;
            AdAppBtnData loadGdtAppBtnData;
            if (AdAppDownloadManager.this.f61340ad != null) {
                int i3 = 0;
                do {
                    long currentTimeMillis = System.currentTimeMillis();
                    i3++;
                    if (!TextUtils.isEmpty(AdAppDownloadManager.this.f61340ad.getAppId()) && (loadGdtAppBtnData = AdAppDataLoader.loadGdtAppBtnData(AdAppDownloadManager.this.f61340ad.getAppId(), null, i3)) != null && loadGdtAppBtnData.isValid()) {
                        loadGdtAppBtnData.mGdtAdAppId = AdAppDownloadManager.this.f61340ad.getAppId();
                        AdAppDownloadManager.this.setmCgdtAppBtnData(loadGdtAppBtnData);
                    }
                    if (AdAppDownloadManager.this.mCgdtAppBtnData != null) {
                        AdLog.w("AdCanvasAppBtnUIAdapter", "loader sucess!!!");
                        AdAppDownloadManager.this.reportAppDataLoad(true, System.currentTimeMillis() - currentTimeMillis);
                        AdAppDownloadManager.this.callAppDataDownloadCallback();
                        if (AdAppDownloadManager.this.dataCallbackWeakReference != null && (appDataCallback = (AppDataCallback) AdAppDownloadManager.this.dataCallbackWeakReference.get()) != null) {
                            appDataCallback.onFetchSuccess(AdAppDownloadManager.this.mCgdtAppBtnData);
                        }
                        AdAppDownloadManager.this.firstAutoDownloadReport();
                    } else {
                        AdLog.w("AdCanvasAppBtnUIAdapter", "loader failed!!!");
                        AdAppDownloadManager.this.reportAppDataLoad(false, System.currentTimeMillis() - currentTimeMillis);
                    }
                    if (AdAppDownloadManager.this.mCgdtAppBtnData != null) {
                        break;
                    }
                } while (i3 < 3);
            }
            AdAppDownloadManager.this.isLoadingAppData = false;
        }
    };

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface AppDataCallback {
        void onFetchSuccess(AdAppBtnData adAppBtnData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface AppDataDownloadCallback {
        void onLoadSuccess();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class ClickLoadAppJob implements Runnable {

        /* renamed from: id, reason: collision with root package name */
        String f61341id;

        ClickLoadAppJob(String str) {
            this.f61341id = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdAppBtnData loadGdtAppBtnData;
            AdAppDownloadManager adAppDownloadManager = AdAppDownloadManager.this;
            if (adAppDownloadManager.f61340ad != null && adAppDownloadManager.mCgdtAppBtnData == null) {
                new AdAppDataLoader();
                long currentTimeMillis = System.currentTimeMillis();
                if (!TextUtils.isEmpty(AdAppDownloadManager.this.f61340ad.getAppId()) && (loadGdtAppBtnData = AdAppDataLoader.loadGdtAppBtnData(AdAppDownloadManager.this.f61340ad.getAppId(), null, -1)) != null && loadGdtAppBtnData.isValid()) {
                    loadGdtAppBtnData.mGdtAdAppId = AdAppDownloadManager.this.f61340ad.getAppId();
                    AdAppDownloadManager.this.setmCgdtAppBtnData(loadGdtAppBtnData);
                }
                if (AdAppDownloadManager.this.mCgdtAppBtnData != null) {
                    AdLog.w("AdCanvasAppBtnUIAdapter", "Click loader sucess!!!");
                    AdAppDownloadManager.this.initDownloadAction(true);
                    AdAppDownloadManager.this.reportAppDataLoad(true, System.currentTimeMillis() - currentTimeMillis);
                } else {
                    AdLog.w("AdCanvasAppBtnUIAdapter", "Click loader failed!!!");
                    AdAppDownloadManager.this.reportAppDataLoad(false, System.currentTimeMillis() - currentTimeMillis);
                }
            }
            AdAppDownloadManager.this.isLoadingAppData = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface DownloadStatusCallback {
        void getDownloadStatus(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface PkgExistCallback {
        void onPkgExist(boolean z16);
    }

    private void callAdRefreshCallback() {
        this.adRefreshCallbacks.add(AdReport.getInstance().getAdReportAdapter());
        for (int i3 = 0; i3 < this.adRefreshCallbacks.size(); i3++) {
            if (this.adRefreshCallbacks.get(i3) != null) {
                this.adRefreshCallbacks.get(i3).onAdRefresh(this.f61340ad);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callAppDataDownloadCallback() {
        AppDataDownloadCallback appDataDownloadCallback = this.appDataDownloadCallbacks;
        if (appDataDownloadCallback != null) {
            appDataDownloadCallback.onLoadSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealDownloadInstalled(String str) {
        AdLog.w(TAG, "onActivityResume already installed. " + str);
        Iterator<AppDownloadManagerAdapter> it = this.mBtnUIPresenterList.iterator();
        while (it.hasNext()) {
            AppDownloadManagerAdapter next = it.next();
            if (next instanceof AdCanvasAppBtnUIAdapter) {
                ((AdCanvasAppBtnUIAdapter) next).installSucceedUpdateUI(this.mCgdtAppBtnData);
            } else {
                return;
            }
        }
    }

    private void fetchAppData() {
        WeakReference<Context> weakReference;
        AdLog.d(TAG, "going fetch AppData");
        if (!this.isLoadingAppData && this.mCgdtAppBtnData == null && (weakReference = this.mContext) != null && AdNet.isNetValid(weakReference.get())) {
            this.isLoadingAppData = true;
            AdThreadManager.getInstance().post(this.mLoadAppJob, 4);
        }
    }

    @Nullable
    private AppDownloadManagerAdapter findPresenter(String str) {
        AppDownloadManagerAdapter appDownloadManagerAdapter;
        CopyOnWriteArrayList<AppDownloadManagerAdapter> copyOnWriteArrayList = this.mBtnUIPresenterList;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() != 0) {
            for (int i3 = 0; i3 < this.mBtnUIPresenterList.size() && (appDownloadManagerAdapter = this.mBtnUIPresenterList.get(i3)) != null; i3++) {
                if (TextUtils.isEmpty(str) && (appDownloadManagerAdapter instanceof AdAppBtnUIPresenter)) {
                    return appDownloadManagerAdapter;
                }
                if (!TextUtils.isEmpty(str) && (appDownloadManagerAdapter instanceof AdCanvasAppBtnUIAdapter) && TextUtils.equals(str, ((AdCanvasAppBtnUIAdapter) this.mBtnUIPresenterList.get(i3)).data.f61339id)) {
                    return appDownloadManagerAdapter;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void firstAutoDownloadReport() {
        if (this.autodownload && this.mContext != null && this.mCgdtAppBtnData != null) {
            dealPkgExist(new PkgExistCallback() { // from class: com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager.7
                @Override // com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager.PkgExistCallback
                public void onPkgExist(boolean z16) {
                    if (z16) {
                        AdReporterForDMPWithCanvas.reportAppBtnClickAsync(AdAppDownloadManager.this.f61340ad);
                    }
                }
            });
        }
    }

    private void initAutoRefreshUICallback() {
        registerDownloadListener();
        this.appDataDownloadCallbacks = new AppDataDownloadCallback() { // from class: com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager.3
            @Override // com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager.AppDataDownloadCallback
            public void onLoadSuccess() {
                AdAppDownloadManager.this.initDownloadAction(false);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportAppDataLoad(boolean z16, long j3) {
        int i3;
        AdReportForAction.Params params = new AdReportForAction.Params();
        params.context = this.mContext;
        params.f61333ad = this.f61340ad;
        landing_page_collect_data.LandingPageCollectData landingPageCollectData = params.data;
        if (z16) {
            i3 = 36;
        } else {
            i3 = 37;
        }
        landingPageCollectData.landing_page_action_type = i3;
        landingPageCollectData.landing_error_code = 0;
        landingPageCollectData.latency_ms = j3;
        AdReportForAction.report(params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void setmCgdtAppBtnData(AdAppBtnData adAppBtnData) {
        if (this.mCgdtAppBtnData == null) {
            this.mCgdtAppBtnData = adAppBtnData;
            AdDownloadTask.getInstance().setDownloadUrl(this.mCgdtAppBtnData.apkUrlhttp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void syncDownloadBtnUI(int i3) {
        AdCanvasAppBtnComponentData adCanvasAppBtnComponentData;
        callDownloadStatusCallbacks();
        CopyOnWriteArrayList<AppDownloadManagerAdapter> copyOnWriteArrayList = this.mBtnUIPresenterList;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() != 0) {
            Iterator<AppDownloadManagerAdapter> it = this.mBtnUIPresenterList.iterator();
            while (it.hasNext()) {
                AppDownloadManagerAdapter next = it.next();
                if ((next instanceof AdCanvasAppBtnUIAdapter) && (adCanvasAppBtnComponentData = ((AdCanvasAppBtnUIAdapter) next).data) != null) {
                    if (findPresenter(adCanvasAppBtnComponentData.f61339id) instanceof AdCanvasAppBtnUIAdapter) {
                        AdLog.i("AdCanvasAppBtnUIAdapter", "syncDownloadBtnUI :" + i3);
                        next.initDownloadApp(i3);
                    } else {
                        return;
                    }
                } else {
                    AdLog.e("AdCanvasAppBtnUIAdapter", "syncDownloadBtnUI failed");
                    return;
                }
            }
        }
    }

    public void callDownloadStatusCallbacks() {
        Iterator<DownloadStatusCallback> it = this.downloadStatusCallbacks.iterator();
        while (it.hasNext()) {
            DownloadStatusCallback next = it.next();
            if (next != null && this.mContext != null && this.mCgdtAppBtnData != null) {
                AdLog.i(TAG, "getDownloadStatus" + this.mCgdtAppBtnData.cState);
                next.getDownloadStatus(this.mCgdtAppBtnData.cState);
            } else {
                AdLog.i(TAG, " no data");
            }
        }
    }

    public void dealPkgExist(@NonNull final PkgExistCallback pkgExistCallback) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager.5
            @Override // java.lang.Runnable
            public void run() {
                Context context;
                if (AdAppDownloadManager.this.mContext != null) {
                    context = (Context) AdAppDownloadManager.this.mContext.get();
                } else {
                    context = null;
                }
                if (context != null && AdAppDownloadManager.this.mCgdtAppBtnData != null) {
                    PkgExistCallback pkgExistCallback2 = pkgExistCallback;
                    AdAppDownloadManager adAppDownloadManager = AdAppDownloadManager.this;
                    pkgExistCallback2.onPkgExist(adAppDownloadManager.isPkgExist(context, adAppDownloadManager.mCgdtAppBtnData.packageName, AdAppDownloadManager.this.mCgdtAppBtnData.apkUrlhttp));
                }
            }
        }, 5);
    }

    public void fetchAppDataByOnClick(String str) {
        if (this.mClickLoadAppJob == null) {
            this.mClickLoadAppJob = new ClickLoadAppJob(str);
        }
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference != null && AdNet.isNetValid(weakReference.get()) && !this.isLoadingAppData) {
            this.isLoadingAppData = true;
            AdThreadManager.getInstance().post(this.mClickLoadAppJob, 4);
        }
    }

    public void fetchDownloadStatus(@Nullable DownloadStatusCallback downloadStatusCallback) {
        if (downloadStatusCallback != null) {
            this.downloadStatusCallbacks.add(downloadStatusCallback);
        }
    }

    public int getCurrentPkgDownloadProgress(@Nullable Context context, String str, String str2) {
        AdDownloaderWrapper adDownloaderWrapper;
        if (context == null || (adDownloaderWrapper = this.downloaderWrapper) == null) {
            return 0;
        }
        return adDownloaderWrapper.getCurrentPkgDownloadProgress(context, str, str2);
    }

    @Nullable
    public AdDownloaderWrapper getDownloader() {
        return this.downloaderWrapper;
    }

    public AdAppBtnData getGdtAppBtnData() {
        return this.mCgdtAppBtnData;
    }

    public boolean hasStartedDownload() {
        return this.mStartedDownload;
    }

    public void init(Context context, boolean z16, Ad ad5, String str) {
        if (this.initialized) {
            return;
        }
        synchronized (AdAppDownloadManager.class) {
            if (this.initialized) {
                return;
            }
            this.initialized = true;
            this.mContext = new WeakReference<>(context);
            this.autodownload = z16;
            this.f61340ad = ad5;
            this.sourceId = str;
            setDownloader();
            initAutoRefreshUICallback();
            fetchAppData();
            callAdRefreshCallback();
            if (AdNet.isWifiConnected(context)) {
                AdThreadManager.getInstance().postDelayed(this.mWiFiDelayJob, 3, 1000L);
            }
        }
    }

    public void initDownloadAction(final boolean z16) {
        Context context;
        try {
            WeakReference<Context> weakReference = this.mContext;
            if (weakReference != null) {
                context = weakReference.get();
            } else {
                context = null;
            }
            if (context != null && this.mCgdtAppBtnData != null) {
                String str = this.mCgdtAppBtnData.packageName;
                if (AdAppUtil.isInstalled(context, str)) {
                    AdLog.i(TAG, "App already installed " + str);
                    this.mCgdtAppBtnData.cState = 6;
                    syncDownloadBtnUI(6);
                    return;
                }
                dealPkgExist(new PkgExistCallback() { // from class: com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager.4
                    @Override // com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager.PkgExistCallback
                    public void onPkgExist(boolean z17) {
                        Context context2;
                        if (AdAppDownloadManager.this.mContext != null) {
                            context2 = (Context) AdAppDownloadManager.this.mContext.get();
                        } else {
                            context2 = null;
                        }
                        if (context2 == null) {
                            return;
                        }
                        String str2 = AdAppDownloadManager.this.mCgdtAppBtnData.packageName;
                        String str3 = AdAppDownloadManager.this.mCgdtAppBtnData.apkUrlhttp;
                        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                            if (z17) {
                                AdAppDownloadManager.this.mCgdtAppBtnData.cState = 3;
                                AdReporterForEffect.reportAsync(AdAppDownloadManager.this.mContext, AdAppDownloadManager.this.f61340ad, 270);
                                AdAppDownloadManager.this.installDownload(str3);
                            } else {
                                int currentPkgDownloadProgress = AdAppDownloadManager.this.getCurrentPkgDownloadProgress(context2, str2, str3);
                                if (currentPkgDownloadProgress < 0) {
                                    currentPkgDownloadProgress = 0;
                                }
                                AdAppDownloadManager.this.mCgdtAppBtnData.cProgerss = currentPkgDownloadProgress;
                                if (!z16 && !AdAppDownloadManager.this.autodownload) {
                                    if (AdAppDownloadManager.this.isPkgDownloading(context2, str2, str3) >= 0) {
                                        AdAppDownloadManager.this.mCgdtAppBtnData.cState = 8;
                                        AdAppDownloadManager.this.setStartedDownload(true);
                                    } else if (AdAppDownloadManager.this.isPkgDownloadPaused(context2, str2, str3) >= 0) {
                                        AdAppDownloadManager.this.mCgdtAppBtnData.cState = 2;
                                    }
                                } else {
                                    AdLog.i(AdAppDownloadManager.TAG, "isUserClick || autodownload && wifi " + z16 + " ," + str2);
                                    AdAppDownloadManager.this.mCgdtAppBtnData.cState = 1;
                                    AdAppDownloadManager.this.startDownload();
                                    if (AdAppDownloadManager.this.mBtnUIPresenterList != null && AdAppDownloadManager.this.mBtnUIPresenterList.size() > 0) {
                                        Iterator it = AdAppDownloadManager.this.mBtnUIPresenterList.iterator();
                                        while (it.hasNext()) {
                                            AppDownloadManagerAdapter appDownloadManagerAdapter = (AppDownloadManagerAdapter) it.next();
                                            if (appDownloadManagerAdapter instanceof AdCanvasAppBtnUIAdapter) {
                                                appDownloadManagerAdapter.startDownload(currentPkgDownloadProgress);
                                            }
                                        }
                                    }
                                }
                            }
                            AdAppDownloadManager adAppDownloadManager = AdAppDownloadManager.this;
                            adAppDownloadManager.syncDownloadBtnUI(adAppDownloadManager.mCgdtAppBtnData.cState);
                        }
                    }
                });
            }
        } catch (Throwable th5) {
            AdLog.e(TAG, "initDownloadAction: ", th5);
        }
    }

    public void installDownload(String str) {
        if (this.downloaderWrapper != null && !TextUtils.isEmpty(str)) {
            AdDownloaderWrapper adDownloaderWrapper = this.downloaderWrapper;
            adDownloaderWrapper.installDownload(adDownloaderWrapper.getDownloadInfoByUrl(str));
        }
    }

    public int isPkgDownloadPaused(@Nullable Context context, String str, String str2) {
        AdDownloaderWrapper adDownloaderWrapper;
        if (context == null || (adDownloaderWrapper = this.downloaderWrapper) == null) {
            return -1;
        }
        return adDownloaderWrapper.isPkgDownloadPaused(context, str, str2);
    }

    public int isPkgDownloading(@Nullable Context context, String str, String str2) {
        AdDownloaderWrapper adDownloaderWrapper;
        if (context == null || (adDownloaderWrapper = this.downloaderWrapper) == null) {
            return -1;
        }
        return adDownloaderWrapper.isPkgDownloading(context, str, str2);
    }

    public boolean isPkgExist(@Nullable Context context, String str, String str2) {
        AdDownloaderWrapper adDownloaderWrapper;
        if (context == null || (adDownloaderWrapper = this.downloaderWrapper) == null || !adDownloaderWrapper.isPkgExist(context, str, str2)) {
            return false;
        }
        return true;
    }

    public void onActivityResume() {
        dealPkgExist(new PkgExistCallback() { // from class: com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager.6
            @Override // com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager.PkgExistCallback
            public void onPkgExist(boolean z16) {
                Context context;
                if (AdAppDownloadManager.this.mContext != null) {
                    context = (Context) AdAppDownloadManager.this.mContext.get();
                } else {
                    context = null;
                }
                if (context != null && AdAppDownloadManager.this.mCgdtAppBtnData != null && AdAppDownloadManager.this.mBtnUIPresenterList != null && AdAppDownloadManager.this.mBtnUIPresenterList.size() != 0) {
                    String str = AdAppDownloadManager.this.mCgdtAppBtnData.packageName;
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (z16) {
                        if (AdAppUtil.isInstalled(context, str)) {
                            AdAppDownloadManager.this.dealDownloadInstalled(str);
                            return;
                        }
                        AdLog.w(AdAppDownloadManager.TAG, "onActivityResume already finishDownload. " + str);
                        Iterator it = AdAppDownloadManager.this.mBtnUIPresenterList.iterator();
                        while (it.hasNext()) {
                            AppDownloadManagerAdapter appDownloadManagerAdapter = (AppDownloadManagerAdapter) it.next();
                            if (appDownloadManagerAdapter instanceof AdCanvasAppBtnUIAdapter) {
                                ((AdCanvasAppBtnUIAdapter) appDownloadManagerAdapter).finishDownloadUpdateUI(AdAppDownloadManager.this.mCgdtAppBtnData);
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (AdAppUtil.isInstalled(context, str)) {
                        AdAppDownloadManager.this.dealDownloadInstalled(str);
                        return;
                    }
                    if (AdAppDownloadManager.this.mCgdtAppBtnData.cState == 6 || AdAppDownloadManager.this.mCgdtAppBtnData.cState == 0 || AdAppDownloadManager.this.mCgdtAppBtnData.cState == 3) {
                        AdLog.w(AdAppDownloadManager.TAG, "onActivityResume already installed or finishDownload but not exist." + str);
                        Iterator it5 = AdAppDownloadManager.this.mBtnUIPresenterList.iterator();
                        while (it5.hasNext()) {
                            AppDownloadManagerAdapter appDownloadManagerAdapter2 = (AppDownloadManagerAdapter) it5.next();
                            if (appDownloadManagerAdapter2 instanceof AdCanvasAppBtnUIAdapter) {
                                ((AdCanvasAppBtnUIAdapter) appDownloadManagerAdapter2).resetDownloadStateUi(AdAppDownloadManager.this.mCgdtAppBtnData);
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
        });
    }

    public void onDestroy() {
        AdLog.i("AdCanvasAppBtnUIAdapter", "onDestroy resetStaticVariables");
        unregisterDownloadListener();
        this.isLoadingAppData = false;
        this.mStartedDownload = false;
        CopyOnWriteArrayList<AppDownloadManagerAdapter> copyOnWriteArrayList = this.mBtnUIPresenterList;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        ArrayList<AdRefreshCallback> arrayList = this.adRefreshCallbacks;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.appDataDownloadCallbacks = null;
        this.dataCallbackWeakReference = null;
        this.downloadStatusCallbacks.clear();
        this.initialized = false;
    }

    @Override // com.tencent.ad.tangram.downloader.IAdDownloader.Callback
    public void onDownloadProgressUpdate(List<Object> list, List<Pair<String, String>> list2) {
        AppDownloadManagerAdapter next;
        CopyOnWriteArrayList<AppDownloadManagerAdapter> copyOnWriteArrayList = this.mBtnUIPresenterList;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<AppDownloadManagerAdapter> it = this.mBtnUIPresenterList.iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                next.onDownloadProgressUpdate(list, list2);
            }
        }
    }

    @Override // com.tencent.ad.tangram.downloader.IAdDownloader.Callback
    public void onDownloadStatusChanged(int i3, int i16, Pair<String, String> pair, String str) {
        AppDownloadManagerAdapter next;
        CopyOnWriteArrayList<AppDownloadManagerAdapter> copyOnWriteArrayList = this.mBtnUIPresenterList;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<AppDownloadManagerAdapter> it = this.mBtnUIPresenterList.iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                next.onDownloadStatusChanged(i3, i16, pair, str);
            }
        }
    }

    public void pauseDownload(String str, String str2) {
        AdDownloaderWrapper adDownloaderWrapper = this.downloaderWrapper;
        if (adDownloaderWrapper != null) {
            adDownloaderWrapper.pauseDownload(str, str2);
        }
    }

    public void registerDownloadListener() {
        AdLog.d(TAG, "registerDownloadListener: ");
        AdDownloaderWrapper adDownloaderWrapper = this.downloaderWrapper;
        if (adDownloaderWrapper != null) {
            adDownloaderWrapper.registerListener(AdCanvasDownloadListener.getInstance().getDownloadListener(this));
        }
    }

    public void removePresenter(AppDownloadManagerAdapter appDownloadManagerAdapter) {
        CopyOnWriteArrayList<AppDownloadManagerAdapter> copyOnWriteArrayList = this.mBtnUIPresenterList;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(appDownloadManagerAdapter);
        }
    }

    public void setAppBtnUIPresenter(AppDownloadManagerAdapter appDownloadManagerAdapter) {
        if (!this.mBtnUIPresenterList.contains(appDownloadManagerAdapter)) {
            this.mBtnUIPresenterList.add(appDownloadManagerAdapter);
            callAppDataDownloadCallback();
        }
    }

    public void setAppDataCallback(WeakReference<AppDataCallback> weakReference) {
        if (this.dataCallbackWeakReference == null) {
            this.dataCallbackWeakReference = weakReference;
        }
    }

    public void setDownloader() {
        if (this.downloaderWrapper == null) {
            this.downloaderWrapper = new AdDownloaderWrapper(AdDownloader.getInstance().getDownloader());
        }
    }

    public void setStartedDownload(boolean z16) {
        this.mStartedDownload = z16;
    }

    public void startDownload() {
        String str;
        WeakReference<Context> weakReference;
        if (this.mCgdtAppBtnData == null) {
            return;
        }
        this.mStartedDownload = true;
        AdAppBtnData adAppBtnData = this.mCgdtAppBtnData;
        Ad ad5 = this.f61340ad;
        if (ad5 != null) {
            str = ad5.getVia();
        } else {
            str = null;
        }
        adAppBtnData.via = str;
        if (this.downloaderWrapper != null && (weakReference = this.mContext) != null) {
            Context context = weakReference.get();
            if (context instanceof Activity) {
                this.downloaderWrapper.startRealDownload((Activity) context, this.mCgdtAppBtnData);
            }
        }
        AdReport.getInstance().downloadReport(this.f61340ad, this.mCgdtAppBtnData.mGdtAdAppId, this.mCgdtAppBtnData.cProgerss, this.autodownload, this.mCgdtAppBtnData);
    }

    public void unregisterDownloadListener() {
        AdLog.d(TAG, "unregisterDownloadListener");
        AdDownloaderWrapper adDownloaderWrapper = this.downloaderWrapper;
        if (adDownloaderWrapper != null) {
            adDownloaderWrapper.unregisterListener(AdCanvasDownloadListener.getInstance().getDownloadListener(this));
        }
    }
}
