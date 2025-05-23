package com.tencent.hippykotlin.demo.pages.nearby.base.utils;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.lib.Query;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class MiniAppUtils {
    public static final MiniAppUtils INSTANCE = new MiniAppUtils();

    public static void launch$default(String str) {
        Map mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("_mappid", "wx7643d5f831302ab0"), TuplesKt.to("_miniapptype", String.valueOf(MiniAppType$EnumUnboxingLocalUtility.getValue(2))), TuplesKt.to("_vt", String.valueOf(MiniAppVersionType$EnumUnboxingLocalUtility.getValue(3))), TuplesKt.to("via", "qq_txdt"), TuplesKt.to("_path", str));
        String m3 = AgreementConsentViewKt$$ExternalSyntheticOutline0.m("mqqapi://miniapp/open?", String.valueOf(new Query(mapOf)));
        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("launch: ", m3, KLog.INSTANCE, "MiniAppUtils");
        QQKuiklyPlatformApi.openPage$default((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi"), m3, false, 6);
    }
}
