package lw2;

import com.tencent.qqlive.ona.protocol.jce.AdAndroidMarketInfo;
import com.tencent.qqlive.ona.protocol.jce.AdDownloadItem;
import com.tencent.qqlive.ona.protocol.jce.AdUrlItem;
import com.tencent.tvideo.protocol.pb.AdDownloadAction;
import com.tencent.tvideo.protocol.pb.AdDownloadType;
import java.util.ArrayList;
import pw2.p;

/* compiled from: P */
/* loaded from: classes19.dex */
class b implements g<AdDownloadAction, AdDownloadItem> {
    public static AdAndroidMarketInfo c(com.tencent.tvideo.protocol.pb.AdAndroidMarketInfo adAndroidMarketInfo) {
        if (adAndroidMarketInfo == null) {
            return null;
        }
        AdAndroidMarketInfo adAndroidMarketInfo2 = new AdAndroidMarketInfo();
        adAndroidMarketInfo2.enableMarketDownload = p.d(Boolean.valueOf(adAndroidMarketInfo.enable_market_download));
        adAndroidMarketInfo2.marketDeepLink = adAndroidMarketInfo.market_deep_link;
        adAndroidMarketInfo2.marketPackageName = new ArrayList<>(adAndroidMarketInfo.market_package_name);
        return adAndroidMarketInfo2;
    }

    @Override // lw2.g
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AdDownloadItem a(AdDownloadAction adDownloadAction) {
        int i3;
        if (adDownloadAction == null) {
            return null;
        }
        AdDownloadItem adDownloadItem = new AdDownloadItem();
        AdUrlItem adUrlItem = new AdUrlItem();
        adUrlItem.url = adDownloadAction.download_url;
        adDownloadItem.urlItem = adUrlItem;
        adDownloadItem.packageName = adDownloadAction.package_name;
        AdDownloadType adDownloadType = adDownloadAction.download_type;
        if (adDownloadType != null) {
            i3 = adDownloadType.getValue();
        } else {
            i3 = 0;
        }
        adDownloadItem.downloadType = i3;
        adDownloadItem.androidMarketInfo = c(adDownloadAction.android_market_info);
        return adDownloadItem;
    }
}
