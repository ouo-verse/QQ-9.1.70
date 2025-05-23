package com.tencent.hippykotlin.demo.pages.qqfile.utils;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import defpackage.k;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFileReportKt {
    public static final void reportFileCustomDtEvent(String str, e eVar) {
        String str2;
        if (k.a(c.f117352a)) {
            str2 = "0S200MNJT807V3GE";
        } else {
            str2 = "0M2003OIIM08YV9M";
        }
        eVar.v(DTParamKey.REPORT_KEY_APPKEY, str2);
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, eVar);
    }
}
