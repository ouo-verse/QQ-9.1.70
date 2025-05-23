package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import kotlin.Deprecated;
import kotlin.ReplaceWith;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class EcommerceExtKt {
    public static final void elementVR(Attr attr, String str, e eVar) {
        vr$default(attr, null, str, eVar, null, null, false, 56);
    }

    public static final void pageVR(Attr attr, String str, e eVar) {
        vr$default(attr, str, null, null, eVar, null, false, 54);
    }

    @Deprecated(message = "this function is deprecated!", replaceWith = @ReplaceWith(expression = "elementVR(elementId: String, pageId: String? = null, elementParams: JSONObject? = null)", imports = {}))
    public static final void vr(Attr attr, String str, e eVar) {
        vr$default(attr, null, str, eVar, null, null, false, 56);
    }

    public static void vr$default(Attr attr, String str, String str2, e eVar, e eVar2, String str3, boolean z16, int i3) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        if ((i3 & 4) != 0) {
            eVar = null;
        }
        if ((i3 & 8) != 0) {
            eVar2 = null;
        }
        if ((i3 & 16) != 0) {
            str3 = null;
        }
        if ((i3 & 32) != 0) {
            z16 = false;
        }
        e eVar3 = new e();
        if (str != null) {
            eVar3.v("pageId", str);
        }
        if (str2 != null) {
            eVar3.v("elementId", str2);
        }
        if (eVar != null) {
            eVar3.v("params", eVar);
        }
        if (eVar2 != null) {
            eVar3.v(QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, eVar2);
        }
        if (str3 != null) {
            eVar3.v(IECDtReport.ACTION_IDENTIFIER, str3);
        }
        eVar3.w("needAsync", z16);
        attr.with("vr", eVar3.toString());
    }
}
