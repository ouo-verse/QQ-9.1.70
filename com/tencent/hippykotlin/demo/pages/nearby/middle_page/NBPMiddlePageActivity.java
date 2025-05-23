package com.tencent.hippykotlin.demo.pages.nearby.middle_page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUITokenThemeMode;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPOIRepo;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.NBPBaseActivity;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.LoadingViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.ntcompose.activity.a;
import com.tencent.ntcompose.activity.b;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import p35.ah;
import x25.h;
import x25.m;

/* loaded from: classes31.dex */
public final class NBPMiddlePageActivity extends NBPBaseActivity {
    public final MutableState poi$delegate;
    public m poiData;

    public NBPMiddlePageActivity() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.poi$delegate = mutableStateOf$default;
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final boolean isV2() {
        return true;
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity
    public final QUITokenThemeMode quiTokenThemeMode() {
        return QUITokenThemeMode.ONLY_DAY_AND_NIGHT;
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final void onCreate(a aVar) {
        ah ahVar;
        super.onCreate(aVar);
        final String p16 = getPageData().n().p("poi_key");
        KLog.INSTANCE.i("NBPMiddlePageActivity", "initPageData: poiKey=" + p16);
        try {
            try {
                QQNearbyModule.Companion companion = QQNearbyModule.Companion;
                Object[] sharePenetratePageData = companion.getInstance().getSharePenetratePageData();
                Object firstOrNull = sharePenetratePageData != null ? ArraysKt___ArraysKt.firstOrNull(sharePenetratePageData) : null;
                byte[] bArr = firstOrNull instanceof byte[] ? (byte[]) firstOrNull : null;
                ahVar = bArr != null ? (ah) i.b(new ah(null, null, 0, null, null, 0, null, 0, 0, null, null, null, null, 0, 0, null, null, null, null, null, null, 2097151), bArr) : null;
                companion.getInstance().setSharePenetratePageData(new byte[0]);
            } catch (Exception e16) {
                KLog.INSTANCE.e("NBPMiddlePageActivity", "\u89e3\u6790\u9875\u9762\u6570\u636e\u5931\u8d25 " + e16);
                QQNearbyModule.Companion.getInstance().setSharePenetratePageData(new byte[0]);
                ahVar = null;
            }
            if (ahVar == null) {
                if (p16.length() == 0) {
                    KLog.INSTANCE.e("NBPMiddlePageActivity", "initPageData: \u6570\u636e\u9519\u8bef\uff0c\u5173\u95ed\u9875\u9762\uff1apoi=" + ahVar + ", poiKey=" + p16);
                    QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                    QQKuiklyPlatformApi.Companion.closePage$default();
                    b.c(this, null, ComposableLambdaKt.composableLambdaInstance(-676086496, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.NBPMiddlePageActivity$onCreate$1
                        {
                            super(2);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(Composer composer, Integer num) {
                            Composer composer2 = composer;
                            int intValue = num.intValue();
                            if ((intValue & 11) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-676086496, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.NBPMiddlePageActivity.onCreate.<anonymous> (NBPMiddlePageActivity.kt:40)");
                                }
                                ah ahVar2 = (ah) NBPMiddlePageActivity.this.poi$delegate.getValue();
                                if (ahVar2 != null) {
                                    composer2.startReplaceableGroup(695950055);
                                    NBPMiddlePageKt.NBPMiddlePage(ahVar2, null, composer2, 8, 2);
                                    composer2.endReplaceableGroup();
                                } else {
                                    composer2.startReplaceableGroup(695950111);
                                    LoadingViewKt.LoadingView(false, composer2, 0, 1);
                                    composer2.endReplaceableGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), 1, null);
                }
            }
            if (ahVar != null) {
                if (p16.length() == 0) {
                    this.poi$delegate.setValue(ahVar);
                    b.c(this, null, ComposableLambdaKt.composableLambdaInstance(-676086496, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.NBPMiddlePageActivity$onCreate$1
                        {
                            super(2);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(Composer composer, Integer num) {
                            Composer composer2 = composer;
                            int intValue = num.intValue();
                            if ((intValue & 11) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-676086496, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.NBPMiddlePageActivity.onCreate.<anonymous> (NBPMiddlePageActivity.kt:40)");
                                }
                                ah ahVar2 = (ah) NBPMiddlePageActivity.this.poi$delegate.getValue();
                                if (ahVar2 != null) {
                                    composer2.startReplaceableGroup(695950055);
                                    NBPMiddlePageKt.NBPMiddlePage(ahVar2, null, composer2, 8, 2);
                                    composer2.endReplaceableGroup();
                                } else {
                                    composer2.startReplaceableGroup(695950111);
                                    LoadingViewKt.LoadingView(false, composer2, 0, 1);
                                    composer2.endReplaceableGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), 1, null);
                }
            }
            NBPPOIRepo nBPPOIRepo = new NBPPOIRepo();
            ah ahVar2 = new ah(null, null, 0, null, null, 0, null, 0, 0, null, null, null, null, 0, 0, null, null, null, null, null, p16, 1048575);
            UserDataManager.INSTANCE.getUserSelfInfo();
            nBPPOIRepo.getPOIDetail(ahVar2, NearbyProUtilsKt.getCoord(), new Function3<h, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.NBPMiddlePageActivity$initPageData$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(h hVar, Integer num, String str) {
                    h hVar2 = hVar;
                    int intValue = num.intValue();
                    String str2 = str;
                    if (intValue != 0) {
                        KLog kLog = KLog.INSTANCE;
                        StringBuilder m3 = PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("initPageData getPOIDetail failed: poiKey="), p16, " code=", intValue, ", msg=");
                        m3.append(str2);
                        kLog.e("NBPMiddlePageActivity", m3.toString());
                        NearbyProUtilsKt.toastAPIErrorMsg$default(intValue, str2);
                        QQKuiklyPlatformApi.Companion companion3 = QQKuiklyPlatformApi.Companion;
                        QQKuiklyPlatformApi.Companion.closePage$default();
                    } else {
                        NBPMiddlePageActivity nBPMiddlePageActivity = this;
                        m mVar = hVar2 != null ? hVar2.f447095e : null;
                        nBPMiddlePageActivity.poiData = mVar;
                        nBPMiddlePageActivity.poi$delegate.setValue(mVar != null ? mVar.f447113d : null);
                        if (((ah) this.poi$delegate.getValue()) == null) {
                            KLog kLog2 = KLog.INSTANCE;
                            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("initPageData getPOIDetail failed: poiData=");
                            m16.append(this.poiData);
                            kLog2.e("NBPMiddlePageActivity", m16.toString());
                            NearbyProUtilsKt.toastAPIErrorMsg$default(intValue, str2);
                            QQKuiklyPlatformApi.Companion companion4 = QQKuiklyPlatformApi.Companion;
                            QQKuiklyPlatformApi.Companion.closePage$default();
                        }
                    }
                    return Unit.INSTANCE;
                }
            });
            b.c(this, null, ComposableLambdaKt.composableLambdaInstance(-676086496, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.NBPMiddlePageActivity$onCreate$1
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer, Integer num) {
                    Composer composer2 = composer;
                    int intValue = num.intValue();
                    if ((intValue & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-676086496, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.NBPMiddlePageActivity.onCreate.<anonymous> (NBPMiddlePageActivity.kt:40)");
                        }
                        ah ahVar22 = (ah) NBPMiddlePageActivity.this.poi$delegate.getValue();
                        if (ahVar22 != null) {
                            composer2.startReplaceableGroup(695950055);
                            NBPMiddlePageKt.NBPMiddlePage(ahVar22, null, composer2, 8, 2);
                            composer2.endReplaceableGroup();
                        } else {
                            composer2.startReplaceableGroup(695950111);
                            LoadingViewKt.LoadingView(false, composer2, 0, 1);
                            composer2.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), 1, null);
        } catch (Throwable th5) {
            QQNearbyModule.Companion.getInstance().setSharePenetratePageData(new byte[0]);
            throw th5;
        }
    }
}
