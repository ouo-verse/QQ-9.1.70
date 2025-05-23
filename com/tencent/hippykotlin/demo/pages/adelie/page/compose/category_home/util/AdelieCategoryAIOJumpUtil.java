package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.util;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomeDataManager;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.app.AppConstants;
import g25.k;
import kotlin.Unit;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieCategoryAIOJumpUtil {
    public static final AdelieCategoryAIOJumpUtil INSTANCE = new AdelieCategoryAIOJumpUtil();

    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.List<java.lang.Long>, java.util.ArrayList] */
    public final void jumpToAIO$qecommerce_biz_release(k kVar, String str, String str2, boolean z16) {
        String replace$default;
        if (kVar.f401176f0.length() > 0) {
            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
            QQKuiklyPlatformApi.Companion.openPage$default(kVar.f401176f0, false, 6);
            return;
        }
        c cVar = c.f117352a;
        com.tencent.kuikly.core.module.k kVar2 = (com.tencent.kuikly.core.module.k) cVar.g().acquireModule("KRNotifyModule");
        e eVar = new e();
        eVar.w("show_next_time", false);
        Unit unit = Unit.INSTANCE;
        com.tencent.kuikly.core.module.k.d(kVar2, "adelie_interrupt_guide_animation", eVar, false, 4, null);
        if (!AdelieCategoryHomeDataManager.backFlowDoneRobotList.contains(Long.valueOf(kVar.f401171d)) && !z16) {
            KLog.INSTANCE.i("AdelieCategoryAIOJumpUtil", "jump to AIO by scheme");
            replace$default = StringsKt__StringsJVMKt.replace$default("mqqapi://qqrobotaio/open?uin={robot_uin}", "{robot_uin}", String.valueOf(kVar.f401171d), false, 4, (Object) null);
            QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
            QQKuiklyPlatformApi.Companion.openPage$default(replace$default, false, 6);
            return;
        }
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("jump to AIO by robotInfo uin:");
        m3.append(kVar.f401171d);
        kLog.i("AdelieCategoryAIOJumpUtil", m3.toString());
        AdelieKuiklyHomePageModule adelieKuiklyHomePageModule = (AdelieKuiklyHomePageModule) cVar.g().acquireModule("AdelieKuiklyHomePageModule");
        e createRobotInfoJson = adelieKuiklyHomePageModule.createRobotInfoJson(kVar);
        if (str != null) {
            createRobotInfoJson.v(AppConstants.Key.KEY_QZONE_VIDEO_URL, str);
        }
        if (str2 != null) {
            createRobotInfoJson.v("fullScreenBg", str2);
        }
        adelieKuiklyHomePageModule.toNative(false, "openAIOByRobotInfo", createRobotInfoJson.toString(), null, false);
    }
}
