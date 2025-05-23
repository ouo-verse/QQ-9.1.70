package com.tencent.hippykotlin.demo.pages.vas_pages.gxh.extensions;

import com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage;
import com.tencent.kuikly.core.views.ce;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class AttrKt {
    public static final void fontFamilyDinFont(ce ceVar) {
        String str;
        if (VasBasePage.Companion.getCtx().getPagerData().getIsIOS()) {
            str = "DIN Alternate";
        } else {
            str = "DIN";
        }
        ceVar.fontFamily(str);
    }
}
