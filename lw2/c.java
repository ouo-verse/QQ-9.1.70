package lw2;

import com.tencent.qqlive.ona.protocol.jce.AdH5UrlItem;
import com.tencent.tvideo.protocol.pb.AdWebAction;
import pw2.p;

/* compiled from: P */
/* loaded from: classes19.dex */
class c implements g<AdWebAction, AdH5UrlItem> {
    @Override // lw2.g
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AdH5UrlItem a(AdWebAction adWebAction) {
        if (adWebAction == null) {
            return null;
        }
        AdH5UrlItem adH5UrlItem = new AdH5UrlItem();
        adH5UrlItem.dstLinkUrlAppendParams = adWebAction.dst_link_url_append_params;
        adH5UrlItem.webviewType = adWebAction.webview_type;
        String str = adWebAction.url;
        adH5UrlItem.adxSplashH5Url = str;
        adH5UrlItem.url = str;
        adH5UrlItem.h5UrlValid = p.d(Boolean.valueOf(adWebAction.landing_url_valid)) ? 1 : 0;
        return adH5UrlItem;
    }
}
