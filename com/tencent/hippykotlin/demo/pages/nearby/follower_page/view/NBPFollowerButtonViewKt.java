package com.tencent.hippykotlin.demo.pages.nearby.follower_page.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.follower_page.view_model.NBPFollowerViewModel;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.material.ButtonKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import s35.af;

/* loaded from: classes31.dex */
public final class NBPFollowerButtonViewKt {
    public static final void NBPFollowBackButton(final NBPFollowerViewModel nBPFollowerViewModel, final af afVar, final boolean z16, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1427174342);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1427174342, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowBackButton (NBPFollowerButtonView.kt:55)");
        }
        ButtonKt.a(null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerButtonViewKt$NBPFollowBackButton$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                NBPFollowerViewModel.this.setFollowState(1, String.valueOf(afVar.f433207e));
                NBPFollowerViewModel.this.fansFollowStatusList.set(NBPFollowerViewModel.this.fansList.indexOf(afVar), 4);
                NBPFollowerViewModel.this.followingList.add(0, afVar);
                NBPFollowerViewModel.this.followingStatusList.add(0, 3);
                NBPFollowerViewModel.this.dtReportElementClick("em_nearby_backfocus", !z16);
                return Unit.INSTANCE;
            }
        }, ViewEventPropUpdaterKt.g(ModifiersKt.j(ModifiersKt.d(ComposeLayoutPropUpdaterKt.v(i.INSTANCE, 72, 29), QUIToken.color$default("button_bg_primary_default")), 4), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerButtonViewKt$NBPFollowBackButton$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                NBPFollowerViewModel.this.dtReportElementImp("em_nearby_backfocus", !z16);
                return Unit.INSTANCE;
            }
        }), null, ComposableSingletons$NBPFollowerButtonViewKt.f34lambda1, startRestartGroup, 25088, 9);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerButtonViewKt$NBPFollowBackButton$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NBPFollowerButtonViewKt.NBPFollowBackButton(NBPFollowerViewModel.this, afVar, z16, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void NBPFollowedButton(final NBPFollowerViewModel nBPFollowerViewModel, final af afVar, final boolean z16, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-22328430);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-22328430, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowedButton (NBPFollowerButtonView.kt:129)");
        }
        ButtonKt.a(null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerButtonViewKt$NBPFollowedButton$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                NBPFollowerViewModel.this.unFollowAccount = String.valueOf(afVar.f433207e);
                NBPFollowerViewModel.this.setShowFollowingUnfollowActionSheet(true);
                NBPFollowerViewModel.this.dtReportElementClick("em_nearby_have_focus", true ^ z16);
                return Unit.INSTANCE;
            }
        }, ViewEventPropUpdaterKt.g(ModifiersKt.g(ModifiersKt.j(ModifiersKt.d(ComposeLayoutPropUpdaterKt.v(i.INSTANCE, 72, 29), QUIToken.color$default("button_bg_secondary_default")), 4), new e(1.0f, BorderStyle.SOLID, QUIToken.color$default("button_border_secondary_default"))), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerButtonViewKt$NBPFollowedButton$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                NBPFollowerViewModel.this.dtReportElementImp("em_nearby_have_focus", !z16);
                return Unit.INSTANCE;
            }
        }), null, ComposableSingletons$NBPFollowerButtonViewKt.f36lambda3, startRestartGroup, 25088, 9);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerButtonViewKt$NBPFollowedButton$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NBPFollowerButtonViewKt.NBPFollowedButton(NBPFollowerViewModel.this, afVar, z16, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void NBPFollowerButtonView(final NBPFollowerViewModel nBPFollowerViewModel, final int i3, final af afVar, final boolean z16, Composer composer, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(-1746885534);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1746885534, i16, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerButtonView (NBPFollowerButtonView.kt:31)");
        }
        if (i3 == 1) {
            startRestartGroup.startReplaceableGroup(1148229728);
            NBPFollowedButton(nBPFollowerViewModel, afVar, z16, startRestartGroup, ((i16 >> 3) & 896) | 72);
            startRestartGroup.endReplaceableGroup();
        } else if (i3 == 2) {
            startRestartGroup.startReplaceableGroup(1148229507);
            NBPFollowBackButton(nBPFollowerViewModel, afVar, z16, startRestartGroup, ((i16 >> 3) & 896) | 72);
            startRestartGroup.endReplaceableGroup();
        } else if (i3 == 3) {
            startRestartGroup.startReplaceableGroup(1148229619);
            NBPMutualFollowButton(nBPFollowerViewModel, afVar, z16, startRestartGroup, ((i16 >> 3) & 896) | 72);
            startRestartGroup.endReplaceableGroup();
        } else if (i3 != 4) {
            startRestartGroup.startReplaceableGroup(1148229903);
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(1148229821);
            NBPHiButton(nBPFollowerViewModel, afVar, z16, startRestartGroup, ((i16 >> 3) & 896) | 72);
            startRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerButtonViewKt$NBPFollowerButtonView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NBPFollowerButtonViewKt.NBPFollowerButtonView(NBPFollowerViewModel.this, i3, afVar, z16, composer2, i16 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void NBPHiButton(final NBPFollowerViewModel nBPFollowerViewModel, final af afVar, final boolean z16, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-470306557);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-470306557, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPHiButton (NBPFollowerButtonView.kt:156)");
        }
        ButtonKt.a(null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerButtonViewKt$NBPHiButton$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("tid: ");
                m3.append(af.this.f433207e);
                m3.append(" msg:");
                m3.append("hi\uff0c\u6211\u4e5f\u5f00\u59cb\u5173\u6ce8\u4f60\u5566");
                kLog.i("NBPFollowPageAIO", m3.toString());
                QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
                String valueOf = String.valueOf(af.this.f433207e);
                final NBPFollowerViewModel nBPFollowerViewModel2 = nBPFollowerViewModel;
                final af afVar2 = af.this;
                companion.sendAIOMessage(valueOf, "hi\uff0c\u6211\u4e5f\u5f00\u59cb\u5173\u6ce8\u4f60\u5566", new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerButtonViewKt$NBPHiButton$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                        ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u5df2\u548c\u5bf9\u65b9\u6253\u62db\u547c", QToastMode.Success);
                        NBPFollowerViewModel.this.fansFollowStatusList.set(NBPFollowerViewModel.this.fansList.indexOf(afVar2), 3);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        }, ModifiersKt.g(ModifiersKt.j(ModifiersKt.d(ComposeLayoutPropUpdaterKt.v(i.INSTANCE, 72, 29), QUIToken.color$default("button_bg_secondary_default")), 4), new e(1.0f, BorderStyle.SOLID, QUIToken.color$default("button_border_secondary_default"))), null, ComposableSingletons$NBPFollowerButtonViewKt.f37lambda4, startRestartGroup, 25088, 9);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerButtonViewKt$NBPHiButton$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NBPFollowerButtonViewKt.NBPHiButton(NBPFollowerViewModel.this, afVar, z16, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void NBPMutualFollowButton(final NBPFollowerViewModel nBPFollowerViewModel, final af afVar, final boolean z16, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-174642329);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-174642329, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPMutualFollowButton (NBPFollowerButtonView.kt:90)");
        }
        ButtonKt.a(null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerButtonViewKt$NBPMutualFollowButton$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u4e92\u76f8\u5173\u6ce8 showUnfollowActionSheet,  account: ");
                m3.append(af.this.f433207e);
                kLog.i("NBPFollowerPageViewModel", m3.toString());
                nBPFollowerViewModel.unFollowAccount = String.valueOf(af.this.f433207e);
                if (z16) {
                    nBPFollowerViewModel.setShowFansUnfollowActionSheet(true);
                } else {
                    nBPFollowerViewModel.setShowFollowingUnfollowActionSheet(true);
                }
                nBPFollowerViewModel.dtReportElementClick("em_nearby_focus_each", !z16);
                com.tencent.kuikly.core.nvi.serialization.json.e dTPageParam = nBPFollowerViewModel.getDTPageParam(!z16);
                NBPFollowerViewModel nBPFollowerViewModel2 = nBPFollowerViewModel;
                boolean z17 = z16;
                dTPageParam.v("dt_eid", "em_nearbby_focus_cancel_float");
                dTPageParam.t("nearby_btn_type", 1);
                dTPageParam.v("cur_pg", nBPFollowerViewModel2.getDTPageParam(true ^ z17));
                dTPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", dTPageParam);
                return Unit.INSTANCE;
            }
        }, ViewEventPropUpdaterKt.g(ModifiersKt.g(ModifiersKt.j(ModifiersKt.d(ComposeLayoutPropUpdaterKt.v(i.INSTANCE, 72, 29), QUIToken.color$default("button_bg_secondary_default")), 4), new e(1.0f, BorderStyle.SOLID, QUIToken.color$default("button_border_secondary_default"))), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerButtonViewKt$NBPMutualFollowButton$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                NBPFollowerViewModel.this.dtReportElementImp("em_nearby_focus_each", !z16);
                return Unit.INSTANCE;
            }
        }), null, ComposableSingletons$NBPFollowerButtonViewKt.f35lambda2, startRestartGroup, 25088, 9);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerButtonViewKt$NBPMutualFollowButton$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NBPFollowerButtonViewKt.NBPMutualFollowButton(NBPFollowerViewModel.this, afVar, z16, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
