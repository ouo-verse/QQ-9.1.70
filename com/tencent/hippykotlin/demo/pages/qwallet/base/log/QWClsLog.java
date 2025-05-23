package com.tencent.hippykotlin.demo.pages.qwallet.base.log;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class QWClsLog {
    public static final QWClsLog INSTANCE = new QWClsLog();

    public final String getPageData(String str) {
        return c.f117352a.g().getPageData().n().p(str);
    }

    public final void report$enumunboxing$(int i3, String str, String str2) {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("mqqapi://kuikly/open?page_name=");
        m3.append(getPageData("page_name"));
        m3.append("&act_id=");
        m3.append(getPageData("act_id"));
        m3.append("&msg_id=");
        m3.append(getPageData("msg_id"));
        m3.append("&pvsrc=");
        m3.append(getPageData("pvsrc"));
        String sb5 = m3.toString();
        e eVar = new e();
        eVar.v("level", QWClsLog$LEVEL$EnumUnboxingLocalUtility.name(i3));
        eVar.v("url", sb5);
        eVar.v("type", str);
        eVar.v("version", String.valueOf(PageDataExtKt.getResVersion(c.f117352a.g().getPageData())));
        eVar.v("message", str2);
        BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, null, null, new QWClsLog$report$1(eVar, null), 3, null);
    }
}
