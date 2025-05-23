package com.tencent.hippykotlin.demo.pages.foundation.lib;

import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.pager.g;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQContext {
    public static final QQContext INSTANCE = new QQContext();

    public final boolean getIOS() {
        return getPageData().getIsIOS();
    }

    public final g getPageData() {
        return c.f117352a.g().getPageData();
    }

    public final String getUin() {
        return getPageData().n().q("uin", "");
    }

    public final boolean isAndroid() {
        return getPageData().getIsAndroid();
    }

    public final boolean isDebug() {
        return getPageData().u();
    }
}
