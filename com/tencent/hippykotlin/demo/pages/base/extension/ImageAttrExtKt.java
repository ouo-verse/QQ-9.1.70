package com.tencent.hippykotlin.demo.pages.base.extension;

import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.views.af;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ImageAttrExtKt {
    public static final void srcUrl(af afVar, String str, String str2) {
        if (SkinColor.INSTANCE.isNightMode(afVar.getPagerId()) && str2 != null) {
            b.a.b(afVar, str2, false, 2, null);
        } else {
            b.a.b(afVar, str, false, 2, null);
        }
    }

    public static void urlToken$default(af afVar, String str) {
        boolean startsWith$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "qecommerce", false, 2, null);
        if (startsWith$default) {
            afVar.e(str + "?url_token_offline_bid=4737", false);
            return;
        }
        afVar.e(str, false);
    }
}
