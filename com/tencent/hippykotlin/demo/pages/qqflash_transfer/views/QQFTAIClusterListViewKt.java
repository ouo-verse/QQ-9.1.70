package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.da_tong_report.DTReportConstKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt;
import com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.MqqUi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFTSecondLevelClusterInfo;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.LazyRowKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import defpackage.k;
import java.util.Iterator;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import ws3.bz;
import ws3.eg;
import ws3.j;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTAIClusterListViewKt {
    public static final void QQFTAIClusterListView(final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-735652261);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-735652261, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTAIClusterListView (QQFTAIClusterListView.kt:55)");
        }
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("firstClusteringList size=");
        m3.append(qQFlashTransferViewModel.firstClusteringList.size());
        kLog.d("QQFTCategoryListView", m3.toString());
        if (!qQFlashTransferViewModel.needShowAIClusterListView()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTAIClusterListViewKt$QQFTAIClusterListView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    QQFTAIClusterListViewKt.QQFTAIClusterListView(QQFlashTransferViewModel.this, composer2, i3 | 1);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        ColumnKt.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, c.f117352a.g().getPageData().m()), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1359621202, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTAIClusterListViewKt$QQFTAIClusterListView$2
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(d dVar, Composer composer2, Integer num) {
                SnapshotStateList<j> snapshotStateList;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1359621202, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTAIClusterListView.<anonymous> (QQFTAIClusterListView.kt:62)");
                    }
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 12.0f), composer3, 8, 0);
                    Iterator<bz> it = QQFlashTransferViewModel.this.firstClusteringList.iterator();
                    while (it.hasNext()) {
                        composer3.startReplaceableGroup(531794434);
                        bz next = it.next();
                        DatalineDetailViewModel$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("firstClusteringList type:"), next.f446226a, KLog.INSTANCE, "QQFTCategoryListView");
                        if (QQFlashTransferViewModel.this.firstClusteringList.size() > 1 && next.f446226a != 1) {
                            composer3.endReplaceableGroup();
                        } else {
                            QQFTSecondLevelClusterInfo qQFTSecondLevelClusterInfo = QQFlashTransferViewModel.this.secondLevelClusterList.get(Integer.valueOf(next.f446226a));
                            if ((qQFTSecondLevelClusterInfo == null || (snapshotStateList = qQFTSecondLevelClusterInfo.clusterList) == null || !(snapshotStateList.isEmpty() ^ true)) ? false : true) {
                                composer3.startReplaceableGroup(531794865);
                                QQFTAIClusterListViewKt.access$clusterArea(QQFlashTransferViewModel.this, next.f446226a, next.f446227b, composer3, 8);
                                composer3.endReplaceableGroup();
                            } else {
                                composer3.startReplaceableGroup(531794977);
                                QQFTAIClusterListViewKt.access$clusterEmptyArea(5, next.f446226a, next.f446227b, composer3, 6);
                                composer3.endReplaceableGroup();
                            }
                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 8.0f), composer3, 8, 0);
                            composer3.endReplaceableGroup();
                        }
                    }
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 4.0f), composer3, 8, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24584, 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 == null) {
            return;
        }
        endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTAIClusterListViewKt$QQFTAIClusterListView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTAIClusterListViewKt.QQFTAIClusterListView(QQFlashTransferViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$clusterArea(final QQFlashTransferViewModel qQFlashTransferViewModel, final int i3, final String str, Composer composer, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(-428131631);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-428131631, i16, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.clusterArea (QQFTAIClusterListView.kt:128)");
        }
        ColumnKt.a(ModifiersKt.b(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, c.f117352a.g().getPageData().m()), 16.0f, 0.0f, 0.0f, 0.0f, 14, null)), qQFlashTransferViewModel.isDisableClick() ? 0.3f : 1.0f), a.f339245a.b(), Alignment.INSTANCE.e(), null, ComposableLambdaKt.composableLambda(startRestartGroup, 100836282, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTAIClusterListViewKt$clusterArea$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(d dVar, Composer composer2, Integer num) {
                String str2;
                String str3;
                SnapshotStateList<j> snapshotStateList;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(100836282, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.clusterArea.<anonymous> (QQFTAIClusterListView.kt:132)");
                    }
                    TextKt.a("\u667a\u80fd\u5408\u96c6", null, null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, bp3.c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601542, 0, 0, 134216614);
                    i.Companion companion = i.INSTANCE;
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 12.0f), composer3, 8, 0);
                    if (QQFlashTransferViewModel.this.secondLevelClusterList.get(Integer.valueOf(i3)) != null) {
                        Integer num2 = null;
                        i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), i3 == 1 ? 100.0f : 124.0f);
                        if (k.a(c.f117352a)) {
                            str2 = "0S200MNJT807V3GE";
                        } else {
                            str2 = "0M2003OIIM08YV9M";
                        }
                        e dTBaseParams = DTReportConstKt.getDTBaseParams(str2);
                        int i17 = i3;
                        QQFlashTransferViewModel qQFlashTransferViewModel2 = QQFlashTransferViewModel.this;
                        if (i17 == 1) {
                            str3 = "1";
                        } else {
                            str3 = "2";
                        }
                        dTBaseParams.v("aggregation_type", str3);
                        QQFTSecondLevelClusterInfo qQFTSecondLevelClusterInfo = qQFlashTransferViewModel2.secondLevelClusterList.get(Integer.valueOf(i17));
                        if (qQFTSecondLevelClusterInfo != null && (snapshotStateList = qQFTSecondLevelClusterInfo.clusterList) != null) {
                            num2 = Integer.valueOf(snapshotStateList.size());
                        }
                        dTBaseParams.v("label_number", String.valueOf(num2));
                        Unit unit = Unit.INSTANCE;
                        i elementVR = ModifierExtKt.elementVR(k3, "em_bas_ai_aggregation_zone", dTBaseParams);
                        Boolean valueOf = Boolean.valueOf(!QQFlashTransferViewModel.this.isDisableClick());
                        Boolean bool = Boolean.FALSE;
                        final QQFlashTransferViewModel qQFlashTransferViewModel3 = QQFlashTransferViewModel.this;
                        final int i18 = i3;
                        LazyRowKt.a(elementVR, null, null, null, valueOf, null, null, bool, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, 1550732872, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTAIClusterListViewKt$clusterArea$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer4, Integer num3) {
                                com.tencent.ntcompose.foundation.lazy.layout.a aVar2 = aVar;
                                Composer composer5 = composer4;
                                int intValue2 = num3.intValue();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1550732872, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.clusterArea.<anonymous>.<anonymous> (QQFTAIClusterListView.kt:153)");
                                }
                                QQFTSecondLevelClusterInfo qQFTSecondLevelClusterInfo2 = QQFlashTransferViewModel.this.secondLevelClusterList.get(Integer.valueOf(i18));
                                Intrinsics.checkNotNull(qQFTSecondLevelClusterInfo2);
                                SnapshotStateList<j> snapshotStateList2 = qQFTSecondLevelClusterInfo2.clusterList;
                                final QQFlashTransferViewModel qQFlashTransferViewModel4 = QQFlashTransferViewModel.this;
                                final int i19 = i18;
                                LazyDslKt.b(aVar2, snapshotStateList2, null, ComposableLambdaKt.composableLambda(composer5, 1728433901, true, new Function3<j, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTAIClusterListViewKt.clusterArea.1.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(j jVar, Composer composer6, Integer num4) {
                                        final j jVar2 = jVar;
                                        Composer composer7 = composer6;
                                        int intValue3 = num4.intValue();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1728433901, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.clusterArea.<anonymous>.<anonymous>.<anonymous> (QQFTAIClusterListView.kt:154)");
                                        }
                                        i w3 = ModifiersKt.w(ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 0.0f, 0.0f, 12.0f, 0.0f, 11, null), QUIToken.color$default("overlay_standard_secondary"));
                                        final QQFlashTransferViewModel qQFlashTransferViewModel5 = QQFlashTransferViewModel.this;
                                        final int i26 = i19;
                                        BoxKt.a(w3, null, null, ComposableLambdaKt.composableLambda(composer7, 2042362483, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTAIClusterListViewKt.clusterArea.1.2.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(b bVar, Composer composer8, Integer num5) {
                                                Composer composer9 = composer8;
                                                int intValue4 = num5.intValue();
                                                if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                    composer9.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(2042362483, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.clusterArea.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTAIClusterListView.kt:155)");
                                                    }
                                                    i w16 = ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 80.0f);
                                                    final j jVar3 = j.this;
                                                    final QQFlashTransferViewModel qQFlashTransferViewModel6 = qQFlashTransferViewModel5;
                                                    final int i27 = i26;
                                                    ColumnKt.a(w16, null, null, null, ComposableLambdaKt.composableLambda(composer9, -548879062, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTAIClusterListViewKt.clusterArea.1.2.1.1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(d dVar2, Composer composer10, Integer num6) {
                                                            int i28;
                                                            String str4;
                                                            String str5;
                                                            i.Companion companion2;
                                                            d dVar3 = dVar2;
                                                            Composer composer11 = composer10;
                                                            int intValue5 = num6.intValue();
                                                            if ((intValue5 & 14) == 0) {
                                                                i28 = (composer11.changed(dVar3) ? 4 : 2) | intValue5;
                                                            } else {
                                                                i28 = intValue5;
                                                            }
                                                            if ((i28 & 91) == 18 && composer11.getSkipping()) {
                                                                composer11.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-548879062, intValue5, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.clusterArea.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTAIClusterListView.kt:156)");
                                                                }
                                                                i.Companion companion3 = i.INSTANCE;
                                                                i j3 = ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(companion3, 80.0f), 8.0f);
                                                                if (k.a(c.f117352a)) {
                                                                    str4 = "0S200MNJT807V3GE";
                                                                } else {
                                                                    str4 = "0M2003OIIM08YV9M";
                                                                }
                                                                i elementVR2 = ModifierExtKt.elementVR(j3, "em_bas_file", DTReportConstKt.getDTBaseParams(str4));
                                                                final QQFlashTransferViewModel qQFlashTransferViewModel7 = qQFlashTransferViewModel6;
                                                                final int i29 = i27;
                                                                final j jVar4 = j.this;
                                                                i d16 = ViewEventPropUpdaterKt.d(elementVR2, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTAIClusterListViewKt.clusterArea.1.2.1.1.1.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        KLog kLog = KLog.INSTANCE;
                                                                        StringBuilder sb5 = new StringBuilder();
                                                                        sb5.append("click index= ");
                                                                        sb5.append(clickParams);
                                                                        sb5.append(" selectFilesToDownload size=");
                                                                        sb5.append(QQFlashTransferViewModel.this.selectFilesToDownload.size());
                                                                        sb5.append(" type=");
                                                                        DatalineDetailViewModel$$ExternalSyntheticOutline0.m(sb5, i29, kLog, "categoryListView");
                                                                        if (!QQFlashTransferViewModel.this.isDisableClick()) {
                                                                            MqqUi ui5 = Mqq.INSTANCE.getUi();
                                                                            final QQFlashTransferViewModel qQFlashTransferViewModel8 = QQFlashTransferViewModel.this;
                                                                            final j jVar5 = jVar4;
                                                                            final int i36 = i29;
                                                                            ui5.openKuikly("QQTransferDownloadActivity", new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTAIClusterListViewKt.clusterArea.1.2.1.1.1.1.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(e eVar) {
                                                                                    String str6;
                                                                                    String str7;
                                                                                    e eVar2 = eVar;
                                                                                    eVar2.z(KuiklyLaunchParams.PARAM_LOCAL_BUNDLE_NAME, "nearbypro");
                                                                                    eVar2.z(KuiklyLaunchParams.PARAM_USE_HOST_DISPLAY_METRICS, "1");
                                                                                    eVar2.z(KuiklyLaunchParams.PARAM_BOTTOM_NAV_BAR_IMMERSIVE, "1");
                                                                                    eVar2.z(ISchemeApi.KEY_IOS_SRC_TYPE, "app");
                                                                                    eVar2.z("version", "1");
                                                                                    eVar2.z(KuiklyLaunchParams.PARAM_QUI_TOKEN_THEME_MODE, "0");
                                                                                    eVar2.z("index_path", QQFlashTransferViewModel.this.indexPath);
                                                                                    eVar2.z("parent_id", QQFlashTransferViewModel.this.parentId.getValue());
                                                                                    eVar2.z("file_set_id", jVar5.f446372a);
                                                                                    if (i36 == 1) {
                                                                                        str6 = "\u4eba\u7269\u7167\u7247";
                                                                                    } else {
                                                                                        str6 = jVar5.f446375d;
                                                                                    }
                                                                                    eVar2.z("parent_name", str6);
                                                                                    eVar2.z("cluster_type", Integer.valueOf(i36));
                                                                                    eVar2.z("cluster_id", jVar5.f446373b);
                                                                                    eVar2.z("cluster_num", UInt.m564boximpl(jVar5.f446376e));
                                                                                    eg egVar = jVar5.f446374c;
                                                                                    if (egVar != null && QQFTFileItemViewKt.getThumbnailValidIndex(egVar) >= 0) {
                                                                                        str7 = egVar.f446333b.get(QQFTFileItemViewKt.getThumbnailValidIndex(egVar)).f446358b;
                                                                                    } else {
                                                                                        str7 = "";
                                                                                    }
                                                                                    eVar2.z("face_url", str7);
                                                                                    eVar2.z(VRReportDefine$ReportParam.SCENE_TYPE, Integer.valueOf(QQFlashTransferViewModel.this.sceneType));
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            }));
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }, 3, null);
                                                                eg egVar = j.this.f446374c;
                                                                if (egVar != null && QQFTFileItemViewKt.getThumbnailValidIndex(egVar) >= 0) {
                                                                    str5 = egVar.f446333b.get(QQFTFileItemViewKt.getThumbnailValidIndex(egVar)).f446358b;
                                                                } else {
                                                                    str5 = "";
                                                                }
                                                                ImageKt.a(null, null, null, null, null, d16, null, 0, null, null, str5, null, null, null, null, null, null, null, null, null, null, composer11, 262144, 0, 0, 2096095);
                                                                composer11.startReplaceableGroup(612557806);
                                                                if (j.this.f446375d.length() > 0) {
                                                                    companion2 = companion3;
                                                                    i b16 = dVar3.b(companion2, Alignment.INSTANCE.b());
                                                                    final j jVar5 = j.this;
                                                                    BoxKt.a(b16, null, null, ComposableLambdaKt.composableLambda(composer11, 1067686155, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTAIClusterListViewKt.clusterArea.1.2.1.1.1.2
                                                                        {
                                                                            super(3);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function3
                                                                        public final Unit invoke(b bVar2, Composer composer12, Integer num7) {
                                                                            Composer composer13 = composer12;
                                                                            int intValue6 = num7.intValue();
                                                                            if ((intValue6 & 81) == 16 && composer13.getSkipping()) {
                                                                                composer13.skipToGroupEnd();
                                                                            } else {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(1067686155, intValue6, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.clusterArea.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTAIClusterListView.kt:196)");
                                                                                }
                                                                                i n3 = ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 0.0f, 4.0f, 0.0f, 0.0f, 13, null);
                                                                                String str6 = j.this.f446375d;
                                                                                h color$default = QUIToken.color$default("text_primary");
                                                                                int a16 = ai.INSTANCE.a();
                                                                                TextKt.a(str6, n3, null, color$default, Float.valueOf(14.0f), null, bp3.c.INSTANCE.f(), null, null, null, ai.f(a16), null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer13, 1601600, 100663296, 0, 133954468);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }), composer11, 3080, 6);
                                                                } else {
                                                                    companion2 = companion3;
                                                                }
                                                                composer11.endReplaceableGroup();
                                                                i b17 = dVar3.b(companion2, Alignment.INSTANCE.b());
                                                                final j jVar6 = j.this;
                                                                BoxKt.a(b17, null, null, ComposableLambdaKt.composableLambda(composer11, 1901420336, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTAIClusterListViewKt.clusterArea.1.2.1.1.1.3
                                                                    {
                                                                        super(3);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function3
                                                                    public final Unit invoke(b bVar2, Composer composer12, Integer num7) {
                                                                        Composer composer13 = composer12;
                                                                        int intValue6 = num7.intValue();
                                                                        if ((intValue6 & 81) == 16 && composer13.getSkipping()) {
                                                                            composer13.skipToGroupEnd();
                                                                        } else {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(1901420336, intValue6, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.clusterArea.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTAIClusterListView.kt:209)");
                                                                            }
                                                                            i n3 = ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 0.0f, 4.0f, 0.0f, 0.0f, 13, null);
                                                                            StringBuilder sb5 = new StringBuilder();
                                                                            sb5.append((Object) UInt.m615toStringimpl(j.this.f446376e));
                                                                            sb5.append('\u9879');
                                                                            String sb6 = sb5.toString();
                                                                            h color$default = QUIToken.color$default("text_secondary");
                                                                            int a16 = ai.INSTANCE.a();
                                                                            TextKt.a(sb6, n3, null, color$default, Float.valueOf(12.0f), null, bp3.c.INSTANCE.e(), null, null, null, ai.f(a16), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer13, 1601600, 0, 0, 134216612);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                            }
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }), composer11, 3080, 6);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer9, 24584, 14);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer7, 3080, 6);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 3080, 2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 12582920, 0, MsgConstant.KRMFILETHUMBSIZE384, 4194158);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24648, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTAIClusterListViewKt$clusterArea$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTAIClusterListViewKt.access$clusterArea(QQFlashTransferViewModel.this, i3, str, composer2, i16 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$clusterEmptyArea(final int i3, final int i16, final String str, Composer composer, final int i17) {
        final int i18;
        Composer startRestartGroup = composer.startRestartGroup(1272292398);
        if ((i17 & 14) == 0) {
            i18 = (startRestartGroup.changed(i3) ? 4 : 2) | i17;
        } else {
            i18 = i17;
        }
        if ((i17 & 112) == 0) {
            i18 |= startRestartGroup.changed(i16) ? 32 : 16;
        }
        if ((i18 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1272292398, i18, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.clusterEmptyArea (QQFTAIClusterListView.kt:82)");
            }
            ColumnKt.a(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, c.f117352a.g().getPageData().m()), 16.0f, 0.0f, 0.0f, 0.0f, 14, null)), a.f339245a.b(), Alignment.INSTANCE.e(), null, ComposableLambdaKt.composableLambda(startRestartGroup, 146145047, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTAIClusterListViewKt$clusterEmptyArea$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(d dVar, Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(146145047, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.clusterEmptyArea.<anonymous> (QQFTAIClusterListView.kt:85)");
                        }
                        TextKt.a("\u667a\u80fd\u5408\u96c6", null, null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, bp3.c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601542, 0, 0, 134216614);
                        i.Companion companion = i.INSTANCE;
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.k(companion, 12.0f), 0.0f, 1, null), composer3, 8, 0);
                        i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), i16 == 1 ? 100.0f : 124.0f);
                        Boolean bool = Boolean.FALSE;
                        final int i19 = i3;
                        final int i26 = i18;
                        LazyRowKt.a(k3, null, null, null, bool, null, null, bool, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, 803481376, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTAIClusterListViewKt$clusterEmptyArea$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer4, Integer num2) {
                                com.tencent.ntcompose.foundation.lazy.layout.a aVar2 = aVar;
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(803481376, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.clusterEmptyArea.<anonymous>.<anonymous> (QQFTAIClusterListView.kt:102)");
                                }
                                LazyDslKt.a(aVar2, i19, null, ComposableSingletons$QQFTAIClusterListViewKt.f124lambda6, composer5, ((i26 << 3) & 112) | 3080, 2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 12607496, 0, MsgConstant.KRMFILETHUMBSIZE384, 4194158);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 24648, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTAIClusterListViewKt$clusterEmptyArea$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTAIClusterListViewKt.access$clusterEmptyArea(i3, i16, str, composer2, i17 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
