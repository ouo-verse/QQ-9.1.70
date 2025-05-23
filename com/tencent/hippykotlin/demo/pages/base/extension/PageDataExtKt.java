package com.tencent.hippykotlin.demo.pages.base.extension;

import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.d;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.g;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* loaded from: classes31.dex */
public final class PageDataExtKt {
    public static final String getUin(g gVar) {
        return gVar.n().q("uin", "");
    }

    public static final e getUserData(g gVar) {
        if (gVar.n().a("ext_userdata")) {
            e m3 = gVar.n().m("ext_userdata");
            return m3 == null ? new e() : m3;
        }
        if (gVar.n().a("userData")) {
            e m16 = gVar.n().m("userData");
            return m16 == null ? new e() : m16;
        }
        if (gVar.n().a(QCircleScheme.AttrQQPublish.BUSINESS_USER_DATA)) {
            e eVar = new e(((d) c.f117352a.g().acquireModule("KRCodecModule")).a(gVar.n().q(QCircleScheme.AttrQQPublish.BUSINESS_USER_DATA, "{}")));
            gVar.n().v("userData", eVar);
            return eVar;
        }
        return new e();
    }

    public static final boolean isNightMode(g gVar) {
        return com.tencent.kuikly.core.base.d.a(gVar.n().k(MiniGamePAHippyBaseFragment.KEY_THEME, 0));
    }
}
