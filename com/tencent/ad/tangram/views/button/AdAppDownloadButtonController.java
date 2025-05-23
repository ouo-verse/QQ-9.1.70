package com.tencent.ad.tangram.views.button;

import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.downloader.AdDownloadUrlManager;
import com.tencent.ad.tangram.downloader.AdDownloaderV2;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.AdReporterForClick;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdAppUtil;
import com.tencent.ad.tangram.util.AdClickUtil;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdAppDownloadButtonController {
    private static final String TAG = "AdAppDownloadButtonController";
    private boolean mIsValid;
    private Params mParams;
    private String mUrl;

    @NonNull
    private List<WeakReference<IAdAppDownloadButtonView>> mViewList = new CopyOnWriteArrayList();
    private AdDownloaderV2.OnQueryListener mOnQueryListener = createOnQueryListener(false);
    private AdDownloaderV2.OnQueryListener mOnQueryListenerAfterClick = createOnQueryListener(true);
    private int mStatus = 0;
    private int mProgress = 0;

    @NonNull
    private AdDownloaderV2.OnStatusChangedListener onStatusChangedListener = new AdDownloaderV2.OnStatusChangedListener() { // from class: com.tencent.ad.tangram.views.button.AdAppDownloadButtonController.6
        @Override // com.tencent.ad.tangram.downloader.AdDownloaderV2.OnStatusChangedListener
        public void onStatusChanged(String str, int i3) {
            if (AdAppDownloadButtonController.this.isCurrentTask(str)) {
                if (!AdAppDownloadButtonController.this.isValid()) {
                    AdLog.e(AdAppDownloadButtonController.TAG, "[OnStatusChangedListener][onStatusChanged] error, not valid");
                    return;
                }
                AdLog.i(AdAppDownloadButtonController.TAG, "[OnStatusChangedListener][onStatusChanged] aid:" + AdAppDownloadButtonController.this.mParams.clickParams.f61334ad.getAId() + " status:" + i3 + " url:" + str);
                AdAppDownloadButtonController adAppDownloadButtonController = AdAppDownloadButtonController.this;
                adAppDownloadButtonController.update(i3, adAppDownloadButtonController.mProgress);
            }
        }

        @Override // com.tencent.ad.tangram.downloader.AdDownloaderV2.OnStatusChangedListener
        public void onStatusChanged(String str, int i3, int i16) {
            if (AdAppDownloadButtonController.this.isCurrentTask(str)) {
                if (!AdAppDownloadButtonController.this.isValid()) {
                    AdLog.e(AdAppDownloadButtonController.TAG, "[OnStatusChangedListener][onStatusChanged] error, not valid");
                    return;
                }
                AdLog.i(AdAppDownloadButtonController.TAG, "[OnStatusChangedListener][onStatusChanged] aid:" + AdAppDownloadButtonController.this.mParams.clickParams.f61334ad.getAId() + " status:" + i3 + " progress:" + i16 + " url:" + str);
                AdAppDownloadButtonController.this.update(i3, i16);
            }
        }
    };

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public static final class Params {
        public AdClickUtil.Params clickParams;

        public boolean isValid() {
            AdClickUtil.Params params = this.clickParams;
            if (params != null && params.isValid()) {
                return true;
            }
            return false;
        }

        public boolean isValidForApp() {
            if (isValid() && this.clickParams.isValidForApp()) {
                return true;
            }
            return false;
        }
    }

    public AdAppDownloadButtonController(Params params) {
        this.mIsValid = false;
        this.mParams = params;
        this.mIsValid = isValidImpl();
    }

    private void afterClick(AdClickUtil.Result result) {
        if (!isValid()) {
            AdLog.e(TAG, "[afterClick] error, not valid");
            return;
        }
        if (this.mParams.clickParams.reportForClick && result != null && result.isSuccess()) {
            WeakReference weakReference = new WeakReference(this.mParams.clickParams.activity.get());
            AdClickUtil.Params params = this.mParams.clickParams;
            AdReporterForClick.reportAsync(weakReference, params.f61334ad, AdClickUtil.getUrlForClick(params, new AdClickUtil.URLParams()), this.mParams.clickParams.clickStartTimeMillis, 1);
        }
        AdClickUtil.afterClick(this.mParams.clickParams, result);
    }

    private void beforeClick() {
        if (!isValid()) {
            AdLog.e(TAG, "[beforeClick] error, not valid");
        } else {
            AdClickUtil.beforeClick(this.mParams.clickParams);
        }
    }

    private void cancelDownload() {
        if (!isValid()) {
            AdLog.e(TAG, "[cancelDownload] error, not valid");
            return;
        }
        if (TextUtils.isEmpty(this.mUrl)) {
            AdLog.e(TAG, "[cancelDownload] error, url is empty");
            return;
        }
        AdLog.i(TAG, "[cancelDownload] aid:" + this.mParams.clickParams.f61334ad.getAId() + " status:" + this.mStatus + " progress:" + this.mProgress + " url:" + this.mUrl);
        AdDownloaderV2.getInstance().cancelDownload(this.mUrl, this.mParams.clickParams.f61334ad, 2);
    }

    @NonNull
    private AdDownloaderV2.OnQueryListener createOnQueryListener(final boolean z16) {
        return new AdDownloaderV2.OnQueryListener() { // from class: com.tencent.ad.tangram.views.button.AdAppDownloadButtonController.5
            private void onClick() {
                AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.views.button.AdAppDownloadButtonController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        onClickOnMainThread();
                    }
                }, 0);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void onClickOnMainThread() {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    AdLog.e(AdAppDownloadButtonController.TAG, "[OnQueryListener][onClickOnMainThread] error, not on main thread");
                    return;
                }
                if (!AdAppDownloadButtonController.this.isValid()) {
                    AdLog.e(AdAppDownloadButtonController.TAG, "[OnQueryListener][onClickOnMainThread] error, not valid");
                    return;
                }
                if (!z16) {
                    AdLog.e(AdAppDownloadButtonController.TAG, "[OnQueryListener][onClickOnMainThread] error");
                    return;
                }
                AdLog.i(AdAppDownloadButtonController.TAG, "[OnQueryListener][onClickOnMainThread] aid:" + AdAppDownloadButtonController.this.mParams.clickParams.f61334ad.getAId() + " status:" + AdAppDownloadButtonController.this.mStatus + " progress:" + AdAppDownloadButtonController.this.mProgress + " url:" + AdAppDownloadButtonController.this.mUrl);
                if (AdAppDownloadButtonController.this.mStatus == 0 || AdAppDownloadButtonController.this.mStatus == 6 || AdAppDownloadButtonController.this.mStatus == 8) {
                    AdAppDownloadButtonController.this.startDownload();
                } else if (AdAppDownloadButtonController.this.mStatus == 7) {
                    AdAppDownloadButtonController.this.installDownload();
                } else {
                    AdLog.i(AdAppDownloadButtonController.TAG, "[OnQueryListener][onClick] do nothing");
                }
            }

            @Override // com.tencent.ad.tangram.downloader.AdDownloaderV2.OnQueryListener
            public void onQuery(String str, int i3) {
                if (AdAppDownloadButtonController.this.isCurrentTask(str)) {
                    if (!AdAppDownloadButtonController.this.isValid()) {
                        AdLog.e(AdAppDownloadButtonController.TAG, "[OnQueryListener][onQuery] error, not valid");
                        return;
                    }
                    AdLog.i(AdAppDownloadButtonController.TAG, "[OnQueryListener][onQuery] clicked:" + z16 + " aid:" + AdAppDownloadButtonController.this.mParams.clickParams.f61334ad.getAId() + " status:" + i3 + " progress:" + AdAppDownloadButtonController.this.mProgress + " url:" + str);
                    AdAppDownloadButtonController adAppDownloadButtonController = AdAppDownloadButtonController.this;
                    adAppDownloadButtonController.update(i3, adAppDownloadButtonController.mProgress);
                    if (z16) {
                        onClick();
                    }
                }
            }

            @Override // com.tencent.ad.tangram.downloader.AdDownloaderV2.OnQueryListener
            public void onQuery(String str, int i3, int i16) {
                if (AdAppDownloadButtonController.this.isCurrentTask(str)) {
                    if (!AdAppDownloadButtonController.this.isValid()) {
                        AdLog.e(AdAppDownloadButtonController.TAG, "[OnQueryListener][onQuery] error, not valid");
                        return;
                    }
                    AdLog.i(AdAppDownloadButtonController.TAG, "[OnQueryListener][onQuery] clicked:" + z16 + " aid:" + AdAppDownloadButtonController.this.mParams.clickParams.f61334ad.getAId() + " status:" + i3 + " progress:" + i16 + " url:" + str);
                    AdAppDownloadButtonController.this.update(i3, i16);
                    if (z16) {
                        onClick();
                    }
                }
            }
        };
    }

    private void fillParams(int i3) {
        if (!isValid()) {
            AdLog.e(TAG, "[fillParams] error, not valid");
            return;
        }
        AdClickUtil.Params params = this.mParams.clickParams;
        params.clickLocationParams = null;
        params.componentID = i3;
        AdClickUtil.fillParams(params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void installDownload() {
        if (!isValid()) {
            AdLog.e(TAG, "[installDownload] error, not valid");
            return;
        }
        if (TextUtils.isEmpty(this.mUrl)) {
            AdLog.e(TAG, "[installDownload] error, url is empty");
            return;
        }
        AdLog.i(TAG, "[installDownload] aid:" + this.mParams.clickParams.f61334ad.getAId() + " status:" + this.mStatus + " progress:" + this.mProgress + " url:" + this.mUrl);
        AdDownloaderV2.getInstance().installDownload(this.mUrl, this.mParams.clickParams.f61334ad, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCurrentTask(String str) {
        return TextUtils.equals(str, this.mUrl);
    }

    private boolean isValidImpl() {
        Params params = this.mParams;
        if (params != null && params.isValid() && !this.mParams.clickParams.f61334ad.isTripleLink() && !this.mParams.clickParams.f61334ad.isWXMINIProgram() && !this.mParams.clickParams.f61334ad.isWXCanvasAd() && !this.mParams.clickParams.f61334ad.isQQMINIProgram() && this.mParams.isValidForApp() && this.mParams.clickParams.f61334ad.isDownloadEnabled() && ((this.mParams.clickParams.f61334ad.isAppXiJingDefault() || this.mParams.clickParams.f61334ad.isAppXiJing() || this.mParams.clickParams.f61334ad.isAppXiJingFengling()) && TextUtils.isEmpty(this.mParams.clickParams.f61334ad.getAppMarketDeeplink()) && ((!this.mParams.clickParams.f61334ad.isAppXiJing() || !this.mParams.clickParams.f61334ad.disableLaunchApp()) && !TextUtils.isEmpty(this.mParams.clickParams.f61334ad.getAppDownloadUrlApi()) && !TextUtils.isEmpty(this.mParams.clickParams.f61334ad.getAppChannelAppName()) && !TextUtils.isEmpty(this.mParams.clickParams.f61334ad.getAppChannelPrivacyUrl()) && !TextUtils.isEmpty(this.mParams.clickParams.f61334ad.getAppChannelVersionName()) && !TextUtils.isEmpty(this.mParams.clickParams.f61334ad.getAppChannelPermissionUrl()) && !TextUtils.isEmpty(this.mParams.clickParams.f61334ad.getAppChannelAuthorName()) && !TextUtils.isEmpty(this.mParams.clickParams.f61334ad.getAppChannelFeatureListUrl())))) {
            return true;
        }
        return false;
    }

    private void loadInfo() {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.views.button.AdAppDownloadButtonController.3
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    AdLog.e(AdAppDownloadButtonController.TAG, "[loadInfo] error, can't load info on main thread");
                    return;
                }
                if (!AdAppDownloadButtonController.this.isValid()) {
                    AdLog.e(AdAppDownloadButtonController.TAG, "[loadInfo] error, not valid");
                    return;
                }
                AdLog.i(AdAppDownloadButtonController.TAG, "[loadInfo] aid:" + AdAppDownloadButtonController.this.mParams.clickParams.f61334ad.getAId() + " status:" + AdAppDownloadButtonController.this.mStatus + " progress:" + AdAppDownloadButtonController.this.mProgress + " url:" + AdAppDownloadButtonController.this.mUrl);
                AdAppDownloadButtonController.this.update(1, 0);
                AdAppDownloadButtonController.this.mUrl = AdDownloadUrlManager.getInstance().queryOnNetworkThread(AdAppDownloadButtonController.this.mParams.clickParams.f61334ad.getTraceId(), AdAppDownloadButtonController.this.mParams.clickParams.f61334ad.getAppDownloadUrlApi());
                AdAppDownloadButtonController adAppDownloadButtonController = AdAppDownloadButtonController.this;
                if (!TextUtils.isEmpty(adAppDownloadButtonController.mUrl)) {
                    i3 = 2;
                } else {
                    i3 = 3;
                }
                adAppDownloadButtonController.update(i3, 0);
                AdAppDownloadButtonController.this.queryDownload(true);
            }
        }, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickOnMainThread(int i3) {
        AdClickUtil.Result result;
        if (!isValid()) {
            AdLog.e(TAG, "[onClickOnMainThread] error");
            return;
        }
        boolean isInstalled = AdAppUtil.isInstalled(this.mParams.clickParams.activity.get(), this.mParams.clickParams.f61334ad.getAppPackageName());
        AdLog.i(TAG, "[onClickOnMainThread] componentID:" + i3 + " installed:" + isInstalled + " aid:" + this.mParams.clickParams.f61334ad.getAId() + " status:" + this.mStatus + " progress:" + this.mProgress + " url:" + this.mUrl);
        fillParams(i3);
        if (isInstalled) {
            update(9, 100);
            AdClickUtil.handle(this.mParams.clickParams);
            return;
        }
        beforeClick();
        int i16 = this.mStatus;
        if (i16 != 0 && i16 != 3) {
            if (i16 == 1) {
                result = new AdClickUtil.Result(0, 30);
            } else if (i16 != 2 && i16 != 6 && i16 != 8) {
                if (i16 != 4 && i16 != 5) {
                    if (i16 == 7) {
                        result = new AdClickUtil.Result(0, 34);
                        installDownload();
                    } else {
                        AdLog.e(TAG, "[onClickOnMainThread] error, status:" + this.mStatus);
                        return;
                    }
                } else {
                    result = new AdClickUtil.Result(0, 33);
                    pauseDownload();
                }
            } else {
                result = new AdClickUtil.Result(0, 32);
                startDownload();
            }
        } else {
            result = new AdClickUtil.Result(0, 31);
            loadInfo();
        }
        afterClick(result);
        AdClickUtil.handleAppAfterInstalled(this.mParams.clickParams, result);
    }

    private void pauseDownload() {
        if (!isValid()) {
            AdLog.e(TAG, "[pauseDownload] error, not valid");
            return;
        }
        if (TextUtils.isEmpty(this.mUrl)) {
            AdLog.e(TAG, "[pauseDownload] error, url is empty");
            return;
        }
        AdLog.i(TAG, "[pauseDownload] aid:" + this.mParams.clickParams.f61334ad.getAId() + " status:" + this.mStatus + " progress:" + this.mProgress + " url:" + this.mUrl);
        AdDownloaderV2.getInstance().pauseDownload(this.mUrl, this.mParams.clickParams.f61334ad, 2);
    }

    private void refresh() {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.views.button.AdAppDownloadButtonController.1
            @Override // java.lang.Runnable
            public void run() {
                if (!AdAppDownloadButtonController.this.isValid()) {
                    AdLog.e(AdAppDownloadButtonController.TAG, "refresh error, not valid");
                    return;
                }
                if (TextUtils.isEmpty(AdAppDownloadButtonController.this.mUrl)) {
                    AdAppDownloadButtonController.this.mUrl = AdDownloadUrlManager.getInstance().queryOnNetworkThread(AdAppDownloadButtonController.this.mParams.clickParams.f61334ad.getTraceId());
                }
                AdLog.i(AdAppDownloadButtonController.TAG, "[refresh] mUrl:" + AdAppDownloadButtonController.this.mUrl);
                if (AdAppUtil.isInstalled(AdAppDownloadButtonController.this.mParams.clickParams.activity.get(), AdAppDownloadButtonController.this.mParams.clickParams.f61334ad.getAppPackageName())) {
                    AdAppDownloadButtonController.this.update(9, 100);
                } else if (TextUtils.isEmpty(AdAppDownloadButtonController.this.mUrl)) {
                    AdAppDownloadButtonController.this.update(0, 0);
                } else {
                    AdAppDownloadButtonController.this.queryDownload(false);
                }
            }
        }, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDownload() {
        if (!isValid()) {
            AdLog.e(TAG, "[startDownload] error, not valid");
            return;
        }
        if (TextUtils.isEmpty(this.mUrl)) {
            AdLog.e(TAG, "[startDownload] error, url is empty");
            return;
        }
        AdLog.i(TAG, "[startDownload] aid:" + this.mParams.clickParams.f61334ad.getAId() + " status:" + this.mStatus + " progress:" + this.mProgress + " url:" + this.mUrl);
        update(4, this.mProgress);
        AdDownloaderV2.getInstance().startDownload(this.mUrl, this.mParams.clickParams.f61334ad, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update(final int i3, final int i16) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.views.button.AdAppDownloadButtonController.2
            @Override // java.lang.Runnable
            public void run() {
                IAdAppDownloadButtonView iAdAppDownloadButtonView;
                if (!AdAppDownloadButtonController.this.isValid()) {
                    AdLog.e(AdAppDownloadButtonController.TAG, "[update] error, not valid");
                    return;
                }
                AdLog.i(AdAppDownloadButtonController.TAG, "[update] aid:" + AdAppDownloadButtonController.this.mParams.clickParams.f61334ad.getAId() + " status_old:" + AdAppDownloadButtonController.this.mStatus + " status_new:" + i3 + " progress_old:" + AdAppDownloadButtonController.this.mProgress + " progress_new:" + i16 + " url:" + AdAppDownloadButtonController.this.mUrl);
                if (AdAppDownloadButtonController.this.mStatus == i3 && AdAppDownloadButtonController.this.mProgress == i16) {
                    AdLog.i(AdAppDownloadButtonController.TAG, "[update] do nothing");
                    return;
                }
                AdAppDownloadButtonController.this.mStatus = i3;
                AdAppDownloadButtonController.this.mProgress = i16;
                for (WeakReference weakReference : AdAppDownloadButtonController.this.mViewList) {
                    if (weakReference != null) {
                        iAdAppDownloadButtonView = (IAdAppDownloadButtonView) weakReference.get();
                    } else {
                        iAdAppDownloadButtonView = null;
                    }
                    if (iAdAppDownloadButtonView != null) {
                        iAdAppDownloadButtonView.update(i3, i16);
                    }
                }
            }
        }, 0);
    }

    public boolean isValid() {
        return this.mIsValid;
    }

    public void onCancelClick(int i3) {
        if (!isValid()) {
            AdLog.e(TAG, "[onCancelClick] error, not valid");
            return;
        }
        AdLog.i(TAG, "[onCancelClick] componentID:" + i3 + " aid:" + this.mParams.clickParams.f61334ad.getAId() + " status:" + this.mStatus + " progress:" + this.mProgress + " url:" + this.mUrl);
        fillParams(i3);
        beforeClick();
        cancelDownload();
        afterClick(new AdClickUtil.Result(0, 35));
    }

    public void onClick(final int i3) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.views.button.AdAppDownloadButtonController.4
            @Override // java.lang.Runnable
            public void run() {
                AdAppDownloadButtonController.this.onClickOnMainThread(i3);
            }
        }, 0);
    }

    public void onViewPause() {
        if (!isValid()) {
            AdLog.e(TAG, "[onViewPause] error, not valid");
        } else {
            AdLog.i(TAG, "[onViewPause]");
        }
    }

    public void onViewResume() {
        if (!isValid()) {
            AdLog.e(TAG, "[onViewResume] error, not valid");
        } else {
            AdLog.i(TAG, "[onViewResume]");
            refresh();
        }
    }

    public void queryDownload(boolean z16) {
        WeakReference<AdDownloaderV2.OnQueryListener> weakReference;
        if (!isValid()) {
            AdLog.e(TAG, "[queryDownload] error, not valid");
            return;
        }
        if (TextUtils.isEmpty(this.mUrl)) {
            AdLog.e(TAG, "[queryDownload] error, url is empty");
            return;
        }
        AdLog.i(TAG, "[queryDownload] clicked:" + z16 + " aid:" + this.mParams.clickParams.f61334ad.getAId() + " status:" + this.mStatus + " progress:" + this.mProgress + " url:" + this.mUrl);
        if (z16) {
            weakReference = new WeakReference<>(this.mOnQueryListenerAfterClick);
        } else {
            weakReference = new WeakReference<>(this.mOnQueryListener);
        }
        AdDownloaderV2.getInstance().queryDownload(this.mUrl, this.mParams.clickParams.f61334ad, 2, weakReference);
    }

    public boolean registerView(WeakReference<IAdAppDownloadButtonView> weakReference) {
        IAdAppDownloadButtonView iAdAppDownloadButtonView;
        if (!isValid()) {
            AdLog.e(TAG, "[registerView] error, not valid");
            return false;
        }
        if (weakReference != null) {
            iAdAppDownloadButtonView = weakReference.get();
        } else {
            iAdAppDownloadButtonView = null;
        }
        if (iAdAppDownloadButtonView == null) {
            AdLog.e(TAG, "[registerView] error, view is null");
            return false;
        }
        this.mViewList.add(weakReference);
        AdDownloaderV2.getInstance().registerListener(new WeakReference<>(this.onStatusChangedListener));
        refresh();
        return true;
    }

    public boolean unregisterView(WeakReference<IAdAppDownloadButtonView> weakReference) {
        IAdAppDownloadButtonView iAdAppDownloadButtonView;
        if (weakReference != null) {
            iAdAppDownloadButtonView = weakReference.get();
        } else {
            iAdAppDownloadButtonView = null;
        }
        if (iAdAppDownloadButtonView == null) {
            AdLog.e(TAG, "[unregisterView] error, view is null");
            return false;
        }
        for (WeakReference<IAdAppDownloadButtonView> weakReference2 : this.mViewList) {
            if (weakReference2 != null && weakReference2.get() == iAdAppDownloadButtonView) {
                this.mViewList.remove(weakReference2);
                if (this.mViewList.isEmpty()) {
                    AdDownloaderV2.getInstance().unregisterListener(new WeakReference<>(this.onStatusChangedListener));
                    return true;
                }
                return true;
            }
        }
        return false;
    }
}
