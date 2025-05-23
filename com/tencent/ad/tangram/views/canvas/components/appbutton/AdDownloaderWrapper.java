package com.tencent.ad.tangram.views.canvas.components.appbutton;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.ad.tangram.downloader.IAdDownloader;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdDownloaderWrapper {
    private IAdDownloader mDownloader;

    public AdDownloaderWrapper(IAdDownloader iAdDownloader) {
        this.mDownloader = iAdDownloader;
    }

    public int getCurrentPkgDownloadProgress(Context context, String str, String str2) {
        IAdDownloader iAdDownloader = this.mDownloader;
        if (iAdDownloader != null) {
            return iAdDownloader.getCurrentPkgDownloadProgress(context, str, str2);
        }
        return 0;
    }

    @Nullable
    public Object getDownloadInfoByUrl(String str) {
        IAdDownloader iAdDownloader = this.mDownloader;
        if (iAdDownloader != null) {
            return iAdDownloader.getDownloadInfoByUrl(str);
        }
        return null;
    }

    public void installDownload(Object obj) {
        IAdDownloader iAdDownloader = this.mDownloader;
        if (iAdDownloader != null) {
            iAdDownloader.installDownload(obj);
        }
    }

    public int isPkgDownloadPaused(Context context, String str, String str2) {
        IAdDownloader iAdDownloader = this.mDownloader;
        if (iAdDownloader != null) {
            return iAdDownloader.isPkgDownloadPaused(context, str, str2);
        }
        return -1;
    }

    public int isPkgDownloading(Context context, String str, String str2) {
        IAdDownloader iAdDownloader = this.mDownloader;
        if (iAdDownloader != null) {
            return iAdDownloader.isPkgDownloading(context, str, str2);
        }
        return -1;
    }

    public boolean isPkgExist(Context context, String str, String str2) {
        IAdDownloader iAdDownloader = this.mDownloader;
        if (iAdDownloader != null) {
            return iAdDownloader.isPkgExist(context, str, str2);
        }
        return false;
    }

    public void pauseDownload(String str, String str2) {
        IAdDownloader iAdDownloader = this.mDownloader;
        if (iAdDownloader != null) {
            iAdDownloader.pauseDownload(str, str2);
        }
    }

    public void registerListener(IAdDownloader.Callback callback) {
        IAdDownloader iAdDownloader = this.mDownloader;
        if (iAdDownloader != null) {
            iAdDownloader.registerListener(callback);
        }
    }

    public void startRealDownload(@Nullable Activity activity, @Nullable AdAppBtnData adAppBtnData) {
        if (activity != null && adAppBtnData != null) {
            String str = adAppBtnData.packageName;
            String str2 = adAppBtnData.mGdtAdAppId;
            String str3 = adAppBtnData.apkUrlhttp;
            String str4 = adAppBtnData.name;
            String str5 = adAppBtnData.via;
            String stringExtra = activity.getIntent().getStringExtra(AdDownloadConstants.KEY_REF_ID);
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = activity.getIntent().getStringExtra(AdDownloadConstants.KEY);
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                Bundle bundle = new Bundle();
                bundle.putString(AdDownloadConstants.PARAM_TASK_PACKNAME, str);
                bundle.putString(AdDownloadConstants.PARAM_SNG_APPID, str2);
                bundle.putString(AdDownloadConstants.PARAM_URL, str3);
                bundle.putString(AdDownloadConstants.PARAM_APPNAME, str4);
                bundle.putInt(AdDownloadConstants.PARAM_ACTIONCODE, 2);
                bundle.putInt(AdDownloadConstants.PARAM_WOWNLOAD_TYPE, 0);
                bundle.putBoolean(AdDownloadConstants.PARAM_BLOCK_NOTIFY, false);
                bundle.putInt(AdDownloadConstants.PARAM_SHOW_NOTIFICATION, 0);
                bundle.putBoolean(AdDownloadConstants.PARAM_IS_APK, true);
                bundle.putBoolean(AdDownloadConstants.PARAM_AUTO_INSTALL, true);
                bundle.putBoolean(AdDownloadConstants.PARAM_SHOW_NETWORK_DIALOG, false);
                bundle.putBoolean(AdDownloadConstants.PARAM_IS_AUTOINSTALL_BY_SDK, false);
                bundle.putString(AdDownloadConstants.PARAM_VIA, str5);
                bundle.putString(AdDownloadConstants.KEY_REF_ID, stringExtra);
                bundle.putInt(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE, 1);
                IAdDownloader iAdDownloader = this.mDownloader;
                if (iAdDownloader != null) {
                    iAdDownloader.doDownloadAction(activity, bundle, AdDownloadConstants.DOWNLOAD_SOURCE_AD, 0);
                }
            }
        }
    }

    public void unregisterListener(IAdDownloader.Callback callback) {
        IAdDownloader iAdDownloader = this.mDownloader;
        if (iAdDownloader != null) {
            iAdDownloader.unregisterListener(callback);
        }
    }
}
