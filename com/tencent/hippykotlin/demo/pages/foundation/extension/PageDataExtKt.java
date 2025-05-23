package com.tencent.hippykotlin.demo.pages.foundation.extension;

import com.tencent.kuikly.core.pager.g;

/* loaded from: classes31.dex */
public final class PageDataExtKt {
    public static final float getDpScaleDensity(g gVar) {
        return (float) gVar.n().i("dpScaleDensity", 1.0d);
    }

    public static final long getResVersion(g gVar) {
        return gVar.n().o("resVersion", 0L);
    }

    public static final boolean isIpad(g gVar) {
        return gVar.n().g("isIpad", false);
    }

    public static final boolean isPublic(g gVar) {
        return gVar.n().g("isPublic", false);
    }

    public static final boolean isTabletDevice(g gVar) {
        if (gVar.n().g("isIpad", false)) {
            return true;
        }
        return gVar.n().g("isTabletDevice", false);
    }

    public static final boolean isTim(g gVar) {
        return gVar.n().g("isTim", false);
    }
}
