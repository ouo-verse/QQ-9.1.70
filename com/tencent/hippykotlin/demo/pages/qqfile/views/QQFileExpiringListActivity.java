package com.tencent.hippykotlin.demo.pages.qqfile.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qqfile.model.QQFileExpiringListViewModel;
import com.tencent.hippykotlin.demo.pages.qqfile.module.QQFileKuiklyModule;
import com.tencent.hippykotlin.demo.pages.qqfile.utils.QQFileReportKt;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.a;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.ntcompose.activity.b;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import defpackage.k;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFileExpiringListActivity extends BaseComponentActivity {
    public static final void access$body(final QQFileExpiringListActivity qQFileExpiringListActivity, final QQFileExpiringListViewModel qQFileExpiringListViewModel, Composer composer, final int i3) {
        qQFileExpiringListActivity.getClass();
        Composer startRestartGroup = composer.startRestartGroup(-1408574616);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1408574616, i3, -1, "com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListActivity.body (QQFileExpiringListActivity.kt:58)");
        }
        ColumnKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), QUIToken.color$default("bg_bottom_light")), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -324471521, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListActivity$body$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(d dVar, Composer composer2, Integer num) {
                String str;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-324471521, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListActivity.body.<anonymous> (QQFileExpiringListActivity.kt:59)");
                    }
                    QUINavBarKt.QUINavBar(QUIToken.color$default("bg_nav_secondary"), null, null, "\u5373\u5c06\u8fc7\u671f\u7684\u597d\u53cb\u6587\u4ef6", null, null, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListActivity$body$1.1
                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                            QQKuiklyPlatformApi.Companion.closePage$default();
                            return Unit.INSTANCE;
                        }
                    }, null, false, 0.0f, composer3, 806882312, 438);
                    if (QQFileExpiringListViewModel.this.isFilelistEmpty.getValue().booleanValue()) {
                        composer3.startReplaceableGroup(269396355);
                        if (k.a(c.f117352a)) {
                            str = "empty_state_file";
                        } else {
                            str = "blank_empty_bag";
                        }
                        QQFileBlankViewKt.blankView(str, "\u6ca1\u6709\u5373\u5c06\u8fc7\u671f\u7684\u6587\u4ef6", "\u91cd\u8981\u6587\u4ef6\u8bf7\u53ca\u65f6\u4fdd\u5b58\u6216\u8f6c\u5b58\u5230\u5fae\u4e91", composer3, 432);
                        composer3.endReplaceableGroup();
                    } else {
                        composer3.startReplaceableGroup(269396712);
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 12.0f), composer3, 8, 0);
                        QQFileExpiringListItemKt.ItemList(QQFileExpiringListViewModel.this, composer3, 8);
                        composer3.endReplaceableGroup();
                    }
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
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListActivity$body$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFileExpiringListActivity.access$body(QQFileExpiringListActivity.this, qQFileExpiringListViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final Map<String, Module> createExternalModules() {
        registerModule("QQFileKuiklyModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListActivity$createExternalModules$1
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new QQFileKuiklyModule();
            }
        });
        return super.createExternalModules();
    }

    public final e getDTPageParam() {
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_expiring_file_list");
        m3.t(IFileBrowserService.FILE_BROWSER_PAGE_FROM, c.f117352a.g().getPageData().n().k(IFileBrowserService.FILE_BROWSER_PAGE_FROM, 0));
        return m3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final void onCreate(com.tencent.ntcompose.activity.a aVar) {
        super.onCreate(aVar);
        final QQFileExpiringListViewModel qQFileExpiringListViewModel = new QQFileExpiringListViewModel();
        b.c(this, null, ComposableLambdaKt.composableLambdaInstance(765641944, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListActivity$onCreate$1
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
                        ComposerKt.traceEventStart(765641944, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListActivity.onCreate.<anonymous> (QQFileExpiringListActivity.kt:34)");
                    }
                    QQFileExpiringListActivity.access$body(QQFileExpiringListActivity.this, qQFileExpiringListViewModel, composer2, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), 1, null);
        QQFileKuiklyModule.Companion.getInstance().toNative(false, "onFileExpiringListPageLaunch", "", null, false);
        QQFileReportKt.reportFileCustomDtEvent("dt_pgin", getDTPageParam());
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void onDestroy() {
        super.onDestroy();
        QQFileReportKt.reportFileCustomDtEvent("dt_pgout", getDTPageParam());
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void onPause() {
        super.onPause();
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void onResume() {
        super.onResume();
    }
}
