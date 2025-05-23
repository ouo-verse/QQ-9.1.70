package com.qzone.canvasui.gdtui.prenster;

import android.text.TextUtils;
import com.qzone.adapter.feedcomponent.h;
import com.qzone.canvasui.gdtui.prenster.DownloadImmediatelyContract;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;

/* loaded from: classes39.dex */
public class DownloadImmediatelyPresenter implements DownloadImmediatelyContract.Presenter {
    private static final String downloadingText = "\u4e0b\u8f7d\u4e2d ";
    private String installedText;
    private boolean isShowPercent = false;
    private String mAppDownloadUrl;
    private String mAppId;
    private String mAppName;
    private int mDownloadStatus;
    private int mProgress;
    private String unInstalledText;

    /* renamed from: v, reason: collision with root package name */
    DownloadImmediatelyContract.View f44896v;
    public static String downloadText = h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AdDownLoad", "\u7acb\u5373\u4e0b\u8f7d");
    private static String continueText = h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AdContinue", "\u7ee7\u7eed\u4e0b\u8f7d");
    public static String installText = h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AdInstall", "\u5b89\u88c5");
    public static String openText = h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AdOpen", "\u6253\u5f00");

    public DownloadImmediatelyPresenter(DownloadImmediatelyContract.View view) {
        this.f44896v = view;
        view.setPresenter(this);
    }

    @Override // com.qzone.canvasui.gdtui.prenster.DownloadImmediatelyContract.Presenter
    public String getAppDownloadUrl() {
        return this.mAppDownloadUrl;
    }

    @Override // com.qzone.canvasui.gdtui.prenster.DownloadImmediatelyContract.Presenter
    public String getAppId() {
        return this.mAppId;
    }

    public String getAppName() {
        return this.mAppName;
    }

    @Override // com.qzone.canvasui.gdtui.prenster.DownloadImmediatelyContract.Presenter
    public int getDownProgress() {
        return this.mProgress;
    }

    @Override // com.qzone.canvasui.gdtui.prenster.DownloadImmediatelyContract.Presenter
    public int getDownloadStatus() {
        return this.mDownloadStatus;
    }

    @Override // com.qzone.canvasui.gdtui.prenster.DownloadImmediatelyContract.Presenter
    public boolean needDrawProgress() {
        return this.isShowPercent;
    }

    @Override // com.qzone.canvasui.gdtui.prenster.DownloadImmediatelyContract.Presenter
    public void setAppDownloadUrl(String str) {
        this.mAppDownloadUrl = str;
    }

    @Override // com.qzone.canvasui.gdtui.prenster.DownloadImmediatelyContract.Presenter
    public void setAppId(String str) {
        this.mAppId = str;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public void setDownloadStatus(int i3) {
        this.mDownloadStatus = i3;
    }

    public void setProgress(int i3) {
        this.mProgress = i3;
    }

    @Override // com.qzone.canvasui.gdtui.prenster.DownloadImmediatelyContract.Presenter
    public void setupText(String str, String str2) {
        this.installedText = str;
        this.unInstalledText = str2;
    }

    @Override // com.qzone.canvasui.gdtui.prenster.DownloadImmediatelyContract.Presenter
    public void updateDownloadStatus(int i3, int i16) {
        this.mDownloadStatus = i3;
        this.mProgress = i16;
        if (i3 == 1) {
            this.f44896v.setViewText(downloadingText + this.mProgress + "%");
            showPercent();
            return;
        }
        if (i3 == 2) {
            if (!TextUtils.isEmpty(this.unInstalledText)) {
                this.f44896v.setViewText(this.unInstalledText);
            } else {
                this.f44896v.setViewText(downloadText);
            }
            hidePercent();
            return;
        }
        if (i3 == 3) {
            this.f44896v.setViewText(continueText);
            showPercent();
            return;
        }
        if (i3 == 4) {
            this.f44896v.setViewText(installText);
            hidePercent();
        } else {
            if (i3 != 5) {
                if (!TextUtils.isEmpty(this.unInstalledText)) {
                    this.f44896v.setViewText(this.unInstalledText);
                } else {
                    this.f44896v.setViewText(downloadText);
                }
                hidePercent();
                return;
            }
            if (!TextUtils.isEmpty(this.installedText)) {
                this.f44896v.setViewText(this.installedText);
            } else {
                this.f44896v.setViewText(openText);
            }
            hidePercent();
        }
    }

    @Override // com.qzone.canvasui.gdtui.prenster.DownloadImmediatelyContract.Presenter
    public void hidePercent() {
        this.isShowPercent = false;
        this.f44896v.refreshView();
    }

    @Override // com.qzone.canvasui.gdtui.prenster.DownloadImmediatelyContract.Presenter
    public void reset() {
        this.mProgress = 0;
        this.mDownloadStatus = 0;
        this.installedText = null;
        this.unInstalledText = null;
        this.isShowPercent = false;
    }

    @Override // com.qzone.canvasui.gdtui.prenster.DownloadImmediatelyContract.Presenter
    public void showPercent() {
        this.isShowPercent = true;
        this.f44896v.refreshView();
    }
}
