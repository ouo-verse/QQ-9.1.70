package com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyVasJSIModule;
import com.tencent.hippykotlin.demo.pages.qwallet.base.log.QWLog;
import com.tencent.hippykotlin.demo.pages.qwallet.base.module.QWalletGatewaySSOModule;
import com.tencent.hippykotlin.demo.pages.qwallet.base.module.QWalletHbModule;
import com.tencent.hippykotlin.demo.pages.qwallet.base.module.QWalletPageRouterModule;
import com.tencent.hippykotlin.demo.pages.qwallet.base.page_compose.QWalletComposePager;
import com.tencent.kuikly.core.module.Module;
import com.tencent.ntcompose.activity.a;
import com.tencent.ntcompose.activity.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;

/* loaded from: classes33.dex */
public final class HbDetailPager extends QWalletComposePager {
    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final Map<String, Module> createExternalModules() {
        Map<String, Module> mutableMap;
        mutableMap = MapsKt__MapsKt.toMutableMap(super.createExternalModules());
        if (mutableMap == null) {
            mutableMap = new LinkedHashMap<>();
        }
        mutableMap.put("QWalletGatewaySSOModule", new QWalletGatewaySSOModule());
        mutableMap.put("QWalletPageRouterModule", new QWalletPageRouterModule());
        mutableMap.put("QQKuiklyVasJSIModule", new QQKuiklyVasJSIModule());
        mutableMap.put("QWalletHbModule", new QWalletHbModule());
        return mutableMap;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qwallet.base.page_compose.QWalletComposePager, com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final void onCreate(a aVar) {
        super.onCreate(aVar);
        QWLog.INSTANCE.i("qwallet_hb_detail", "onCreate", false);
        b.c(this, null, ComposableSingletons$HbDetailPagerKt.f158lambda1, 1, null);
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void onDestroy() {
        super.onDestroy();
        QWLog.INSTANCE.i("qwallet_hb_detail", MosaicConstants$JsFunction.FUNC_ON_DESTROY, false);
    }
}
