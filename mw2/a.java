package mw2;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d;
import com.tencent.qqlive.ona.protocol.jce.AdActionItem;
import com.tencent.qqlive.ona.protocol.jce.AdAndroidMarketInfo;
import com.tencent.qqlive.ona.protocol.jce.AdDownloadItem;
import com.tencent.qqlive.ona.protocol.jce.AdH5UrlItem;
import com.tencent.qqlive.ona.protocol.jce.AdOpenAppItem;
import com.tencent.qqlive.ona.protocol.jce.PackageAction;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    public static boolean a(@Nullable wv2.a aVar) {
        AdActionItem adActionItem;
        AdDownloadItem adDownloadItem;
        AdAndroidMarketInfo adAndroidMarketInfo;
        if (aVar != null && (adActionItem = aVar.f446565a) != null && (adDownloadItem = adActionItem.adDownload) != null && (adAndroidMarketInfo = adDownloadItem.androidMarketInfo) != null && adAndroidMarketInfo.enableMarketDownload) {
            return true;
        }
        return false;
    }

    public static boolean b(@Nullable wv2.a aVar) {
        AdActionItem adActionItem;
        AdOpenAppItem adOpenAppItem;
        AdDownloadItem adDownloadItem;
        AdAndroidMarketInfo adAndroidMarketInfo;
        if (aVar != null && (adActionItem = aVar.f446565a) != null && (adOpenAppItem = adActionItem.adOpenApp) != null && (adDownloadItem = adOpenAppItem.downloadItem) != null && (adAndroidMarketInfo = adDownloadItem.androidMarketInfo) != null && adAndroidMarketInfo.enableMarketDownload) {
            return true;
        }
        return false;
    }

    public static boolean c(boolean z16, @Nullable wv2.a aVar) {
        if (a(aVar) && !z16) {
            AdDownloadItem adDownloadItem = aVar.f446565a.adDownload;
            if (h(adDownloadItem.downloadType, adDownloadItem.androidMarketInfo)) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(boolean z16, @Nullable wv2.a aVar) {
        if (b(aVar) && !z16) {
            AdDownloadItem adDownloadItem = aVar.f446565a.adOpenApp.downloadItem;
            if (j(adDownloadItem.downloadType, adDownloadItem.androidMarketInfo)) {
                return true;
            }
        }
        return false;
    }

    public static void e(@Nullable wv2.a aVar) {
        AdActionItem adActionItem;
        AdDownloadItem adDownloadItem;
        int i3;
        if (aVar != null && (adActionItem = aVar.f446565a) != null && (adDownloadItem = adActionItem.adDownload) != null && adDownloadItem.downloadType == 0) {
            if (aVar.f446568d && aVar.f446577m) {
                i3 = 3;
            } else {
                i3 = 4;
            }
            adDownloadItem.downloadType = i3;
        }
    }

    @Nullable
    public static AdDownloadItem f(@Nullable wv2.a aVar) {
        AdDownloadItem adDownloadItem;
        if (n(aVar)) {
            adDownloadItem = aVar.f446565a.adDownload;
        } else {
            adDownloadItem = null;
        }
        if (adDownloadItem == null && o(aVar)) {
            return aVar.f446565a.adOpenApp.downloadItem;
        }
        return adDownloadItem;
    }

    public static String g(wv2.a aVar) {
        AdActionItem adActionItem;
        AdH5UrlItem adH5UrlItem;
        if (aVar != null && (adActionItem = aVar.f446565a) != null && (adH5UrlItem = adActionItem.adH5UrlItem) != null) {
            return adH5UrlItem.url;
        }
        return null;
    }

    public static boolean h(int i3, @Nullable AdAndroidMarketInfo adAndroidMarketInfo) {
        if (adAndroidMarketInfo != null && ((i3 == 3 || i3 == 4) && i(adAndroidMarketInfo))) {
            return true;
        }
        return false;
    }

    public static boolean i(@NonNull AdAndroidMarketInfo adAndroidMarketInfo) {
        if (adAndroidMarketInfo.enableMarketDownload && !TextUtils.isEmpty(adAndroidMarketInfo.marketDeepLink) && !y.h(adAndroidMarketInfo.marketPackageName)) {
            return true;
        }
        return false;
    }

    public static boolean j(int i3, @Nullable AdAndroidMarketInfo adAndroidMarketInfo) {
        if (adAndroidMarketInfo != null && ((i3 == 3 || i3 == 4 || i3 == 0) && i(adAndroidMarketInfo))) {
            return true;
        }
        return false;
    }

    private static boolean k(@Nullable wv2.a aVar) {
        AdActionItem adActionItem;
        AdDownloadItem adDownloadItem;
        if (aVar != null && (adActionItem = aVar.f446565a) != null && (adDownloadItem = adActionItem.adDownload) != null && !TextUtils.isEmpty(adDownloadItem.packageName)) {
            return true;
        }
        return false;
    }

    private static boolean l(@Nullable wv2.a aVar) {
        AdActionItem adActionItem;
        AdOpenAppItem adOpenAppItem;
        AdDownloadItem adDownloadItem;
        if (aVar != null && (adActionItem = aVar.f446565a) != null && (adOpenAppItem = adActionItem.adOpenApp) != null && (adDownloadItem = adOpenAppItem.downloadItem) != null && !TextUtils.isEmpty(adDownloadItem.packageName)) {
            return true;
        }
        return false;
    }

    public static boolean m(d dVar, wv2.a aVar) {
        if (!k(aVar) && !l(aVar)) {
            return false;
        }
        return true;
    }

    private static boolean n(@Nullable wv2.a aVar) {
        AdActionItem adActionItem;
        AdDownloadItem adDownloadItem;
        AdAndroidMarketInfo adAndroidMarketInfo;
        if (aVar != null && (adActionItem = aVar.f446565a) != null && (adDownloadItem = adActionItem.adDownload) != null && (adAndroidMarketInfo = adDownloadItem.androidMarketInfo) != null && adAndroidMarketInfo.enableMarketDownload) {
            return true;
        }
        return false;
    }

    private static boolean o(@Nullable wv2.a aVar) {
        AdActionItem adActionItem;
        AdOpenAppItem adOpenAppItem;
        AdDownloadItem adDownloadItem;
        AdAndroidMarketInfo adAndroidMarketInfo;
        if (aVar != null && (adActionItem = aVar.f446565a) != null && (adOpenAppItem = adActionItem.adOpenApp) != null && (adDownloadItem = adOpenAppItem.downloadItem) != null && (adAndroidMarketInfo = adDownloadItem.androidMarketInfo) != null && adAndroidMarketInfo.enableMarketDownload) {
            return true;
        }
        return false;
    }

    public static boolean p(@NonNull wv2.a aVar) {
        AdActionItem adActionItem;
        AdOpenAppItem adOpenAppItem;
        PackageAction packageAction;
        if (aVar != null && (adActionItem = aVar.f446565a) != null && (adOpenAppItem = adActionItem.adOpenApp) != null && (packageAction = adOpenAppItem.packageAction) != null && !TextUtils.isEmpty(packageAction.url)) {
            return true;
        }
        return false;
    }
}
