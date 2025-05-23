package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQCommonNApiModule;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class SearchNetApi {
    public static final SearchNetApi INSTANCE = new SearchNetApi();

    public final boolean isSendReqByOIDB() {
        String stringFromQQCommonConfig = ((QQCommonNApiModule) c.f117352a.k(BridgeManager.f117344a.u()).acquireModule("QQCommonNApiModule")).getStringFromQQCommonConfig("102505", "");
        if (stringFromQQCommonConfig.length() == 0) {
            DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("isSendReqByOIDBConfig: 102505: ", stringFromQQCommonConfig, KLog.INSTANCE, "SearchNetApi");
            return true;
        }
        boolean g16 = new e(stringFromQQCommonConfig).g("closeOIDBReq", false);
        KLog.INSTANCE.i("SearchNetApi", "isSendReqByOIDBConfig closeOIDBReq:" + g16 + "  102505: " + stringFromQQCommonConfig);
        return !g16;
    }
}
