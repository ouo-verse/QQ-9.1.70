package com.etrump.mixlayout;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.font.api.IFontSoLoaderAdapter;

/* compiled from: P */
/* loaded from: classes2.dex */
public class o {
    public static synchronized boolean a() {
        boolean isVipFontSoDownloaded;
        synchronized (o.class) {
            isVipFontSoDownloaded = ((IFontSoLoaderAdapter) QRoute.api(IFontSoLoaderAdapter.class)).isVipFontSoDownloaded();
        }
        return isVipFontSoDownloaded;
    }

    public static synchronized boolean b() {
        boolean isVipFontSoLoaded;
        synchronized (o.class) {
            isVipFontSoLoaded = ((IFontSoLoaderAdapter) QRoute.api(IFontSoLoaderAdapter.class)).isVipFontSoLoaded();
        }
        return isVipFontSoLoaded;
    }

    public static synchronized boolean c() {
        boolean loadSo;
        synchronized (o.class) {
            loadSo = ((IFontSoLoaderAdapter) QRoute.api(IFontSoLoaderAdapter.class)).loadSo();
        }
        return loadSo;
    }
}
