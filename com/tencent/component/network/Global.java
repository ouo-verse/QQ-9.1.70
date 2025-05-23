package com.tencent.component.network;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.common.NetworkState;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class Global {
    private static final int GLOBAL_LISTENER_MAX_SIZE = 5;
    public static final String SDK_VERSION = "${env.NumberVersion}";
    private static Context sContext;
    private static List<Downloader.DownloadListener> sGlobalListeners = new ArrayList();
    private static ISharedPreferencesProvider sSharedPreferencesProvider;

    public static void addGlobalDownloadListener(Downloader.DownloadListener downloadListener) {
        List<Downloader.DownloadListener> list;
        if (Config.enbaleGlobalListener() && (list = sGlobalListeners) != null && list.size() < 5) {
            sGlobalListeners.add(downloadListener);
        }
    }

    public static void clearGlobalDownloadListener() {
        List<Downloader.DownloadListener> list;
        if (Config.enbaleGlobalListener() && (list = sGlobalListeners) != null) {
            list.clear();
        }
    }

    public static void dispatchOnDownloadCanceled(String str) {
        if (!Config.enbaleGlobalListener()) {
            return;
        }
        for (Downloader.DownloadListener downloadListener : getGlobalDownloadListeners()) {
            if (downloadListener != null) {
                downloadListener.onDownloadCanceled(str);
            }
        }
    }

    public static void dispatchOnDownloadFailed(String str, DownloadResult downloadResult) {
        if (!Config.enbaleGlobalListener()) {
            return;
        }
        for (Downloader.DownloadListener downloadListener : getGlobalDownloadListeners()) {
            if (downloadListener != null) {
                downloadListener.onDownloadFailed(str, downloadResult);
            }
        }
    }

    public static void dispatchOnDownloadSucceed(String str, DownloadResult downloadResult) {
        if (!Config.enbaleGlobalListener()) {
            return;
        }
        for (Downloader.DownloadListener downloadListener : getGlobalDownloadListeners()) {
            if (downloadListener != null) {
                downloadListener.onDownloadSucceed(str, downloadResult);
            }
        }
    }

    public static Context getContext() {
        return sContext;
    }

    public static List<Downloader.DownloadListener> getGlobalDownloadListeners() {
        List<Downloader.DownloadListener> list = sGlobalListeners;
        if (list == null) {
            return new ArrayList();
        }
        return list;
    }

    public static SharedPreferences getSharedPreferences(Context context, String str, int i3) {
        if (context == null) {
            return null;
        }
        ISharedPreferencesProvider iSharedPreferencesProvider = sSharedPreferencesProvider;
        if (iSharedPreferencesProvider != null) {
            return iSharedPreferencesProvider.getSharedPreferences(context, str, i3);
        }
        return context.getSharedPreferences(str, i3);
    }

    public static void init(Context context) {
        sContext = context;
        try {
            NetworkManager.init(getContext());
            NetworkState.g().setContext(getContext());
        } catch (Throwable th5) {
            QDLog.e(QDLog.TAG_DOWNLOAD, "", th5);
        }
    }

    public static void removeGlobalDownloadListener(Downloader.DownloadListener downloadListener) {
        List<Downloader.DownloadListener> list;
        if (Config.enbaleGlobalListener() && (list = sGlobalListeners) != null) {
            list.remove(downloadListener);
        }
    }

    public static void setSharedPreferencesProvider(ISharedPreferencesProvider iSharedPreferencesProvider) {
        sSharedPreferencesProvider = iSharedPreferencesProvider;
    }
}
