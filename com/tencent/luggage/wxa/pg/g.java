package com.tencent.luggage.wxa.pg;

import android.webkit.URLUtil;
import com.tencent.luggage.wxa.tn.y;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g implements e {
    @Override // com.tencent.luggage.wxa.pg.e
    public String a(String str) {
        URL url;
        if (!URLUtil.isNetworkUrl(str)) {
            return str;
        }
        if (str != null && str.startsWith("http://mpvideo.qpic.cn")) {
            str = str.substring(0, str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER));
        }
        try {
            url = new URL(str);
        } catch (MalformedURLException e16) {
            com.tencent.luggage.wxa.tg.h.a(6, "DefaultCacheKeyGenerator", com.tencent.luggage.wxa.tg.h.a((Throwable) e16));
            url = null;
        }
        if (url == null) {
            return null;
        }
        return y.a(str).substring(0, 20);
    }
}
