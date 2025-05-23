package com.tencent.hippykotlin.demo.pages.nearby.qq_stranger_nearby_entry_guide;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.NBPBaseActivity;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.g;
import com.tencent.ntcompose.activity.a;
import com.tencent.ntcompose.activity.b;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* loaded from: classes31.dex */
public final class QQStrangerNearbyEntryGuidePage extends NBPBaseActivity {
    public static final /* synthetic */ int $r8$clinit = 0;

    public final void closePage(boolean z16) {
        k kVar = (k) c.f117352a.g().acquireModule("KRNotifyModule");
        e eVar = new e();
        eVar.w("click_entry", z16);
        Unit unit = Unit.INSTANCE;
        k.d(kVar, "QQ_STRANGER_NEARBY_ENTRY_GUIDE_CLOSE_EVENT", eVar, false, 4, null);
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.closePage$default();
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity, com.tencent.kuikly.core.pager.b
    public final void onReceivePagerEvent(String str, e eVar) {
        super.onReceivePagerEvent(str, eVar);
        if (Intrinsics.areEqual(str, "onModalModeBackPressed")) {
            closePage(false);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final void onCreate(a aVar) {
        super.onCreate(aVar);
        g pageData = getPageData();
        float m3 = pageData.m();
        pageData.l();
        double h16 = pageData.n().h("screen_w");
        pageData.n().h("screen_h");
        double d16 = m3 / h16;
        final GuideParams guideParams = new GuideParams((float) (pageData.n().h(HippyTKDListViewAdapter.X) * d16), (float) (pageData.n().h("y") * d16), (float) (pageData.n().h("w") * d16), (float) (pageData.n().h(h.F) * d16), (float) (pageData.n().i("r", 8.0d / d16) * d16));
        KLog.INSTANCE.i("QQStrangerNearbyEntryGuidePage", "onCreate params=" + guideParams);
        b.c(this, null, ComposableLambdaKt.composableLambdaInstance(-1370858620, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.qq_stranger_nearby_entry_guide.QQStrangerNearbyEntryGuidePage$onCreate$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer, Integer num) {
                Composer composer2 = composer;
                int intValue = num.intValue();
                if ((intValue & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1370858620, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.qq_stranger_nearby_entry_guide.QQStrangerNearbyEntryGuidePage.onCreate.<anonymous> (QQStrangerNearbyEntryGuidePage.kt:44)");
                    }
                    i.Companion companion = i.INSTANCE;
                    final GuideParams guideParams2 = GuideParams.this;
                    final QQStrangerNearbyEntryGuidePage qQStrangerNearbyEntryGuidePage = this;
                    composer2.startReplaceableGroup(511388516);
                    boolean changed = composer2.changed(guideParams2) | composer2.changed(qQStrangerNearbyEntryGuidePage);
                    Object rememberedValue = composer2.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.qq_stranger_nearby_entry_guide.QQStrangerNearbyEntryGuidePage$onCreate$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                boolean z16;
                                ClickParams clickParams2 = clickParams;
                                GuideParams guideParams3 = GuideParams.this;
                                float x16 = clickParams2.getX();
                                float y16 = clickParams2.getY();
                                float f16 = guideParams3.targetX;
                                if (x16 >= f16 && x16 <= f16 + guideParams3.targetWidth) {
                                    float f17 = guideParams3.targetY;
                                    if (y16 >= f17 && y16 <= f17 + guideParams3.targetHeight) {
                                        z16 = true;
                                        CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0.m("handleClick ", z16, KLog.INSTANCE, "QQStrangerNearbyEntryGuidePage");
                                        QQStrangerNearbyEntryGuidePage qQStrangerNearbyEntryGuidePage2 = qQStrangerNearbyEntryGuidePage;
                                        int i3 = QQStrangerNearbyEntryGuidePage.$r8$clinit;
                                        qQStrangerNearbyEntryGuidePage2.closePage(z16);
                                        return Unit.INSTANCE;
                                    }
                                }
                                z16 = false;
                                CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0.m("handleClick ", z16, KLog.INSTANCE, "QQStrangerNearbyEntryGuidePage");
                                QQStrangerNearbyEntryGuidePage qQStrangerNearbyEntryGuidePage22 = qQStrangerNearbyEntryGuidePage;
                                int i36 = QQStrangerNearbyEntryGuidePage.$r8$clinit;
                                qQStrangerNearbyEntryGuidePage22.closePage(z16);
                                return Unit.INSTANCE;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    composer2.endReplaceableGroup();
                    QQStrangerNearbyEntryGuidePageKt.access$GuideView(ViewEventPropUpdaterKt.d(companion, false, null, (Function1) rememberedValue, 3, null), GuideParams.this, composer2, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), 1, null);
    }
}
