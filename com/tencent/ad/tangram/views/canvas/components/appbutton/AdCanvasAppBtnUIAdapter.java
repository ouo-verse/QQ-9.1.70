package com.tencent.ad.tangram.views.canvas.components.appbutton;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.ad.tangram.downloader.AdDownloader;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdAppUtil;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdCanvasAppBtnUIAdapter extends AppDownloadManagerAdapter {
    public static final String TAG = "AdCanvasAppBtnUIAdapter";
    public boolean addToDownloadCallbacks;
    private String btnTitle;
    public AdCanvasAppBtnComponentData data;
    private boolean firstClick;
    private AdAppDownloadManager mAdAppDownloadManager;
    private AdCanvasAppBtnView mAdProgressButton;
    public boolean resumeDownload = false;

    public AdCanvasAppBtnUIAdapter(AdCanvasAppBtnComponentData adCanvasAppBtnComponentData, String str, AdCanvasAppBtnView adCanvasAppBtnView, AdAppDownloadManager adAppDownloadManager, boolean z16) {
        this.firstClick = true;
        this.mAdProgressButton = adCanvasAppBtnView;
        this.mAdAppDownloadManager = adAppDownloadManager;
        this.btnTitle = str;
        this.data = adCanvasAppBtnComponentData;
        this.addToDownloadCallbacks = z16;
        if (adCanvasAppBtnComponentData.canShowProgress) {
            this.firstClick = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealDownloadInstalled(@NonNull AdAppBtnData adAppBtnData, Context context) {
        installSucceedUpdateUI(adAppBtnData);
        launchApp(context, adAppBtnData.packageName);
    }

    private void firstClickInitDownloadApp() {
        AdAppDownloadManager adAppDownloadManager;
        AdCanvasAppBtnView adCanvasAppBtnView = this.mAdProgressButton;
        if (adCanvasAppBtnView != null && adCanvasAppBtnView.getContext() != null && (adAppDownloadManager = this.mAdAppDownloadManager) != null && adAppDownloadManager.getGdtAppBtnData() != null && this.mAdAppDownloadManager.getGdtAppBtnData().isValid()) {
            final AdAppBtnData gdtAppBtnData = this.mAdAppDownloadManager.getGdtAppBtnData();
            final Context context = this.mAdProgressButton.getContext();
            this.mAdAppDownloadManager.dealPkgExist(new AdAppDownloadManager.PkgExistCallback() { // from class: com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnUIAdapter.6
                @Override // com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager.PkgExistCallback
                public void onPkgExist(boolean z16) {
                    if (z16) {
                        if (AdAppUtil.isInstalled(context, gdtAppBtnData.packageName)) {
                            AdCanvasAppBtnUIAdapter.this.dealDownloadInstalled(gdtAppBtnData, context);
                            return;
                        } else {
                            AdCanvasAppBtnUIAdapter.this.finishDownloadUpdateUI(gdtAppBtnData);
                            AdCanvasAppBtnUIAdapter.this.mAdAppDownloadManager.installDownload(gdtAppBtnData.apkUrlhttp);
                            return;
                        }
                    }
                    if (AdAppUtil.isInstalled(context, gdtAppBtnData.packageName)) {
                        AdCanvasAppBtnUIAdapter.this.dealDownloadInstalled(gdtAppBtnData, context);
                        return;
                    }
                    AdAppDownloadManager adAppDownloadManager2 = AdCanvasAppBtnUIAdapter.this.mAdAppDownloadManager;
                    Context context2 = context;
                    AdAppBtnData adAppBtnData = gdtAppBtnData;
                    int currentPkgDownloadProgress = adAppDownloadManager2.getCurrentPkgDownloadProgress(context2, adAppBtnData.packageName, adAppBtnData.apkUrlhttp);
                    if (currentPkgDownloadProgress < 0) {
                        currentPkgDownloadProgress = 0;
                    }
                    AdCanvasAppBtnUIAdapter.this.mAdAppDownloadManager.startDownload();
                    AdCanvasAppBtnUIAdapter.this.startDownload(currentPkgDownloadProgress);
                    AdCanvasAppBtnComponentData adCanvasAppBtnComponentData = AdCanvasAppBtnUIAdapter.this.data;
                    if (adCanvasAppBtnComponentData != null) {
                        adCanvasAppBtnComponentData.canShowProgress = true;
                    }
                }
            });
        }
    }

    private void installDownload(@NonNull AdAppBtnData adAppBtnData) {
        AdAppDownloadManager adAppDownloadManager = this.mAdAppDownloadManager;
        if (adAppDownloadManager != null) {
            adAppDownloadManager.installDownload(adAppBtnData.apkUrlhttp);
        }
    }

    private void launchApp(Context context, @NonNull String str) {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.mAdAppDownloadManager.sourceId)) {
            bundle.putString(AdDownloadConstants.KEY_REF_ID, this.mAdAppDownloadManager.sourceId);
        }
        bundle.putString(AdDownloadConstants.KEY, AdDownloadConstants.SRC_AD);
    }

    private void pauseDownload(@NonNull AdAppBtnData adAppBtnData) {
        AdAppDownloadManager adAppDownloadManager = this.mAdAppDownloadManager;
        if (adAppDownloadManager == null) {
            return;
        }
        this.resumeDownload = false;
        adAppDownloadManager.pauseDownload(adAppBtnData.packageName, adAppBtnData.apkUrlhttp);
        pauseDownload();
        reportForPaused();
    }

    private void pauseDownloadUi(@Nullable final AdAppBtnData adAppBtnData, final int i3) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnUIAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                if (adAppBtnData != null && AdCanvasAppBtnUIAdapter.this.mAdProgressButton != null) {
                    if (adAppBtnData.cState == 8 || adAppBtnData.cState == 2) {
                        AdLog.i("AdCanvasAppBtnUIAdapter", "pauseDownloadUi " + adAppBtnData.packageName);
                        AdCanvasAppBtnUIAdapter.this.mAdProgressButton.setText("\u7ee7\u7eed");
                        adAppBtnData.cState = 2;
                        AdCanvasAppBtnUIAdapter.this.mAdProgressButton.setProgress(i3);
                    }
                }
            }
        }, 0);
    }

    private void restartDownload(AdAppBtnData adAppBtnData) {
        if (this.mAdProgressButton != null) {
            this.mAdAppDownloadManager.startDownload();
            startDownload(0);
        }
    }

    private void resumeDownload(@NonNull AdAppBtnData adAppBtnData) {
        this.resumeDownload = true;
        if (this.mAdProgressButton != null) {
            if (adAppBtnData.cState == 2 || adAppBtnData.cState == 1) {
                this.mAdAppDownloadManager.startDownload();
                startDownload(adAppBtnData.cProgerss);
            }
        }
    }

    private void startDownload() {
        AdAppDownloadManager adAppDownloadManager = this.mAdAppDownloadManager;
        if (adAppDownloadManager == null) {
            return;
        }
        adAppDownloadManager.startDownload();
        startDownload(0);
    }

    private void uninstallSucceedUpdateUI(AdAppBtnData adAppBtnData) {
        resetDownloadStateUi(adAppBtnData);
    }

    public void finishDownloadUpdateUI(@Nullable final AdAppBtnData adAppBtnData) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnUIAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                if (AdCanvasAppBtnUIAdapter.this.mAdProgressButton != null && adAppBtnData != null) {
                    AdCanvasAppBtnUIAdapter.this.mAdProgressButton.setProgress(100);
                    AdCanvasAppBtnUIAdapter.this.mAdProgressButton.setText("\u5b89\u88c5");
                    adAppBtnData.cState = 3;
                }
            }
        }, 0);
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.appbutton.AppDownloadManagerAdapter
    public void initDownloadApp(int i3) {
        try {
            AdAppDownloadManager adAppDownloadManager = this.mAdAppDownloadManager;
            if (adAppDownloadManager != null && adAppDownloadManager.getGdtAppBtnData() != null && this.mAdAppDownloadManager.getGdtAppBtnData().isValid()) {
                AdAppBtnData gdtAppBtnData = this.mAdAppDownloadManager.getGdtAppBtnData();
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 != 6) {
                                    if (i3 != 8) {
                                    }
                                } else {
                                    installSucceedUpdateUI(gdtAppBtnData);
                                }
                            } else {
                                finishDownloadUpdateUI(gdtAppBtnData);
                            }
                        } else {
                            pauseDownloadUi(gdtAppBtnData, 100);
                        }
                    }
                    startDownload(gdtAppBtnData.cProgerss);
                } else {
                    resetDownloadStateUi(gdtAppBtnData);
                }
            }
        } catch (Throwable th5) {
            AdLog.e("AdCanvasAppBtnUIAdapter", "initDownloadApp: ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void installSucceedUpdateUI(@Nullable final AdAppBtnData adAppBtnData) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnUIAdapter.4
            @Override // java.lang.Runnable
            public void run() {
                if (AdCanvasAppBtnUIAdapter.this.mAdProgressButton != null && adAppBtnData != null) {
                    AdCanvasAppBtnUIAdapter.this.mAdProgressButton.setProgress(100);
                    AdCanvasAppBtnUIAdapter.this.mAdProgressButton.setText("\u6253\u5f00");
                    adAppBtnData.cState = 6;
                }
            }
        }, 0);
    }

    @Override // com.tencent.ad.tangram.downloader.IAdDownloader.Callback
    public void onDownloadProgressUpdate(@Nullable List<Object> list, @Nullable List<Pair<String, String>> list2) {
        AdAppDownloadManager adAppDownloadManager;
        if (list != null && list2 != null && list.size() != 0 && list2.size() != 0) {
            for (int i3 = 0; i3 < list.size() && list.get(i3) != null && list2.get(i3) != null && (adAppDownloadManager = this.mAdAppDownloadManager) != null && adAppDownloadManager.getGdtAppBtnData() != null; i3++) {
                AdAppBtnData gdtAppBtnData = this.mAdAppDownloadManager.getGdtAppBtnData();
                if (AdDownloader.getInstance().isCurrentPkgTask(list2.get(i3), gdtAppBtnData) && (this.data.canShowProgress || this.addToDownloadCallbacks)) {
                    gdtAppBtnData.cState = 8;
                    updateBtnProgressUI(gdtAppBtnData, AdDownloader.getInstance().getProgress(list.get(i3)));
                }
            }
        }
    }

    @Override // com.tencent.ad.tangram.downloader.IAdDownloader.Callback
    public void onDownloadStatusChanged(int i3, int i16, @Nullable Pair<String, String> pair, @NonNull String str) {
        AdAppDownloadManager adAppDownloadManager;
        if (pair != null && !TextUtils.isEmpty((CharSequence) pair.first) && !TextUtils.isEmpty((CharSequence) pair.second) && !TextUtils.isEmpty(str) && (adAppDownloadManager = this.mAdAppDownloadManager) != null && adAppDownloadManager.getGdtAppBtnData() != null) {
            AdAppBtnData gdtAppBtnData = this.mAdAppDownloadManager.getGdtAppBtnData();
            switch (i3) {
                case 2:
                    if (AdDownloader.getInstance().isCurrentPkgTask(pair, gdtAppBtnData)) {
                        if (this.data.canShowProgress || this.addToDownloadCallbacks) {
                            pauseDownloadUi(gdtAppBtnData, i16);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (AdDownloader.getInstance().isCurrentPkgTask(pair, gdtAppBtnData)) {
                        finishDownloadUpdateUI(gdtAppBtnData);
                        return;
                    }
                    return;
                case 4:
                    if (AdDownloader.getInstance().isCurrentPkgTask(pair, gdtAppBtnData) && this.data.canShowProgress) {
                        resetDownloadStateUi(gdtAppBtnData);
                        return;
                    }
                    return;
                case 5:
                    if (AdDownloader.getInstance().isCurrentPkgTask(pair, gdtAppBtnData)) {
                        gdtAppBtnData.cState = 5;
                        return;
                    }
                    return;
                case 6:
                    if (str.equals(gdtAppBtnData.mGdtAdAppId) && ((String) pair.second).equals(gdtAppBtnData.packageName)) {
                        installSucceedUpdateUI(gdtAppBtnData);
                        return;
                    }
                    return;
                case 7:
                    if (str.equals(gdtAppBtnData.mGdtAdAppId) && ((String) pair.second).equals(gdtAppBtnData.packageName)) {
                        uninstallSucceedUpdateUI(gdtAppBtnData);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void reportForPaused() {
        Context context;
        AdAppDownloadManager adAppDownloadManager = this.mAdAppDownloadManager;
        if (adAppDownloadManager != null && adAppDownloadManager.f61340ad != null) {
            AdCanvasAppBtnView adCanvasAppBtnView = this.mAdProgressButton;
            Ad ad5 = null;
            if (adCanvasAppBtnView != null) {
                context = adCanvasAppBtnView.getContext();
            } else {
                context = null;
            }
            WeakReference weakReference = new WeakReference(context);
            AdAppDownloadManager adAppDownloadManager2 = this.mAdAppDownloadManager;
            if (adAppDownloadManager2 != null) {
                ad5 = adAppDownloadManager2.f61340ad;
            }
            AdReporterForEffect.reportAsync(weakReference, ad5, 238);
            return;
        }
        AdLog.e("AdCanvasAppBtnUIAdapter", "reportForPaused ad == null:");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetDownloadStateUi(@Nullable final AdAppBtnData adAppBtnData) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnUIAdapter.5
            @Override // java.lang.Runnable
            public void run() {
                if (AdCanvasAppBtnUIAdapter.this.mAdProgressButton != null && adAppBtnData != null) {
                    AdCanvasAppBtnUIAdapter.this.mAdProgressButton.setText(AdCanvasAppBtnUIAdapter.this.btnTitle);
                    AdCanvasAppBtnUIAdapter.this.mAdProgressButton.setProgress(100);
                    adAppBtnData.cState = 0;
                    adAppBtnData.cProgerss = 0;
                }
            }
        }, 0);
    }

    public void updateBtnProgressUI(@Nullable final AdAppBtnData adAppBtnData, final int i3) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnUIAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                AdAppBtnData adAppBtnData2 = adAppBtnData;
                if (adAppBtnData2 != null && adAppBtnData2.cState == 8) {
                    AdCanvasAppBtnUIAdapter adCanvasAppBtnUIAdapter = AdCanvasAppBtnUIAdapter.this;
                    if ((adCanvasAppBtnUIAdapter.addToDownloadCallbacks || adCanvasAppBtnUIAdapter.data.canShowProgress) && adCanvasAppBtnUIAdapter.mAdProgressButton != null && i3 >= 0) {
                        AdLog.i("AdCanvasAppBtnUIAdapter", "updateBtnProgressUI " + i3);
                        AdCanvasAppBtnUIAdapter.this.mAdProgressButton.setText("\u4e0b\u8f7d\u4e2d, " + i3 + "%");
                        AdCanvasAppBtnUIAdapter.this.mAdProgressButton.setProgress(i3);
                        adAppBtnData.cProgerss = i3;
                    }
                }
            }
        }, 0);
    }

    public void updateUIByClick(String str, @Nullable AdAppBtnData adAppBtnData, int i3) {
        AdAppDownloadManager adAppDownloadManager;
        if (this.mAdAppDownloadManager == null) {
            AdLog.e("AdCanvasAppBtnUIAdapter", "updateUIByClick mAdAppDownloadManager == null");
            return;
        }
        if (adAppBtnData == null) {
            AdLog.e("AdCanvasAppBtnUIAdapter", "updateUIByClick cgdtAppBtnData == null");
            if (this.resumeDownload) {
                this.mAdProgressButton.setText("\u7ee7\u7eed");
                this.mAdProgressButton.setProgress(0);
            } else {
                this.mAdProgressButton.setText("\u4e0b\u8f7d\u4e2d, 0%");
                this.mAdProgressButton.setProgress(0);
                this.mAdAppDownloadManager.fetchAppDataByOnClick(str);
            }
            this.resumeDownload = !this.resumeDownload;
            return;
        }
        AdLog.e("AdCanvasAppBtnUIAdapter", "updateUIByClick firstClick" + this.firstClick + str + " cState:" + i3 + " hasStartedDownload" + this.mAdAppDownloadManager.hasStartedDownload());
        if (this.firstClick && (adAppDownloadManager = this.mAdAppDownloadManager) != null && adAppDownloadManager.hasStartedDownload()) {
            firstClickInitDownloadApp();
            this.firstClick = false;
            return;
        }
        this.firstClick = false;
        AdCanvasAppBtnComponentData adCanvasAppBtnComponentData = this.data;
        if (adCanvasAppBtnComponentData != null) {
            adCanvasAppBtnComponentData.canShowProgress = true;
        }
        if (i3 != 0) {
            if (i3 != 1 && i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        if (i3 != 6) {
                            if (i3 == 8) {
                                pauseDownload(adAppBtnData);
                                return;
                            }
                            return;
                        }
                        launchApp(this.mAdProgressButton.getContext(), adAppBtnData.packageName);
                        return;
                    }
                    restartDownload(adAppBtnData);
                    return;
                }
                installDownload(adAppBtnData);
                return;
            }
            resumeDownload(adAppBtnData);
            return;
        }
        startDownload();
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.appbutton.AppDownloadManagerAdapter
    public void startDownload(int i3) {
        AdAppDownloadManager adAppDownloadManager = this.mAdAppDownloadManager;
        if (adAppDownloadManager == null || adAppDownloadManager.getGdtAppBtnData() == null || !this.mAdAppDownloadManager.getGdtAppBtnData().isValid() || this.mAdProgressButton.getContext() == null) {
            return;
        }
        AdAppBtnData gdtAppBtnData = this.mAdAppDownloadManager.getGdtAppBtnData();
        AdLog.i("AdCanvasAppBtnUIAdapter", "startDownload " + i3);
        updateBtnProgressUI(gdtAppBtnData, i3);
        this.resumeDownload = true;
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.appbutton.AppDownloadManagerAdapter
    public void pauseDownload() {
        super.pauseDownload();
        AdAppDownloadManager adAppDownloadManager = this.mAdAppDownloadManager;
        if (adAppDownloadManager == null || adAppDownloadManager.getGdtAppBtnData() == null || !this.mAdAppDownloadManager.getGdtAppBtnData().isValid() || this.mAdProgressButton.getContext() == null) {
            return;
        }
        AdAppBtnData gdtAppBtnData = this.mAdAppDownloadManager.getGdtAppBtnData();
        gdtAppBtnData.cState = 2;
        AdLog.i("AdCanvasAppBtnUIAdapter", "pauseDownload ");
        pauseDownloadUi(gdtAppBtnData, gdtAppBtnData.cProgerss);
    }
}
