package com.tencent.hippykotlin.demo.pages.qqfile.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionButton;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qqfile.model.DownloadStatus$EnumUnboxingLocalUtility;
import com.tencent.hippykotlin.demo.pages.qqfile.model.KTFileDownloadStatus;
import com.tencent.hippykotlin.demo.pages.qqfile.model.KTFileInfo;
import com.tencent.hippykotlin.demo.pages.qqfile.model.QQFileExpiringListViewModel;
import com.tencent.hippykotlin.demo.pages.qqfile.module.QQFileKuiklyModule;
import com.tencent.hippykotlin.demo.pages.qqfile.utils.QQFileReportKt;
import com.tencent.hippykotlin.demo.pages.qqfile.utils.QQFileTimeUtils;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import com.tencent.ntcompose.material.FooterRefreshKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.LazyColumnKt;
import com.tencent.ntcompose.material.ProgressIndicatorKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.an;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.p;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFileExpiringListItemKt {
    public static final e access$getDTItemParam(KTFileInfo kTFileInfo) {
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_expiring_file_list");
        e eVar = new e();
        eVar.t(IFileBrowserService.FILE_BROWSER_PAGE_FROM, c.f117352a.g().getPageData().n().k(IFileBrowserService.FILE_BROWSER_PAGE_FROM, 0));
        m3.v("cur_pg", eVar);
        m3.v("dt_eid", "em_bas_file_entry");
        m3.u("file_size", kTFileInfo.fileSize);
        m3.t("file_type", kTFileInfo.absFileType);
        return m3;
    }

    public static final void ItemList(final QQFileExpiringListViewModel qQFileExpiringListViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-940122546);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-940122546, i3, -1, "com.tencent.hippykotlin.demo.pages.qqfile.views.ItemList (QQFileExpiringListItem.kt:86)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(-1, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed = startRestartGroup.changed(mutableState);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (changed || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt$ItemList$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ScrollParams scrollParams) {
                    mutableState.setValue(-1);
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        LazyColumnKt.a(h16, null, null, null, null, null, null, null, null, null, null, 10, null, null, null, null, null, null, (Function1) rememberedValue2, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1351427085, true, new Function3<a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt$ItemList$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(a aVar, Composer composer2, Integer num) {
                a aVar2 = aVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1351427085, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqfile.views.ItemList.<anonymous> (QQFileExpiringListItem.kt:95)");
                }
                final QQFileExpiringListViewModel qQFileExpiringListViewModel2 = QQFileExpiringListViewModel.this;
                SnapshotStateList<KTFileInfo> snapshotStateList = qQFileExpiringListViewModel2.fileInfoList;
                final MutableState<Integer> mutableState2 = mutableState;
                LazyDslKt.b(aVar2, snapshotStateList, null, ComposableLambdaKt.composableLambda(composer3, -1426733511, true, new Function3<KTFileInfo, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt$ItemList$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(KTFileInfo kTFileInfo, Composer composer4, Integer num2) {
                        final KTFileInfo kTFileInfo2 = kTFileInfo;
                        Composer composer5 = composer4;
                        int intValue2 = num2.intValue();
                        if ((intValue2 & 14) == 0) {
                            intValue2 |= composer5.changed(kTFileInfo2) ? 4 : 2;
                        }
                        if ((intValue2 & 91) == 18 && composer5.getSkipping()) {
                            composer5.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1426733511, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqfile.views.ItemList.<anonymous>.<anonymous> (QQFileExpiringListItem.kt:96)");
                            }
                            final int indexOf = QQFileExpiringListViewModel.this.fileInfoList.indexOf(kTFileInfo2);
                            KTFileDownloadStatus kTFileDownloadStatus = QQFileExpiringListViewModel.this.fileDownloadStatusList.get(indexOf);
                            boolean z16 = mutableState2.getValue().intValue() == indexOf;
                            final QQFileExpiringListViewModel qQFileExpiringListViewModel3 = QQFileExpiringListViewModel.this;
                            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt.ItemList.2.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    int i16 = QQFileExpiringListViewModel.this.fileDownloadStatusList.get(indexOf).fileDownloadStatus;
                                    if (i16 == 1) {
                                        KLog kLog = KLog.INSTANCE;
                                        kLog.e("QQFileKuiklyExpiringList", kTFileInfo2.fileName + " \u5f00\u59cb\u4e0b\u8f7d [" + DownloadStatus$EnumUnboxingLocalUtility.stringValueOf(QQFileExpiringListViewModel.this.fileDownloadStatusList.get(indexOf).fileDownloadStatus) + ", " + QQFileExpiringListViewModel.this.fileDownloadStatusList.get(indexOf).process + ']');
                                        QQFileExpiringListViewModel.this.updateFileDownloadStatus$enumunboxing$(indexOf, 2, 0.0f);
                                        kLog.e("QQFileKuiklyExpiringList", kTFileInfo2.fileName + " \u5f00\u59cb\u4e0b\u8f7d\u540e [" + DownloadStatus$EnumUnboxingLocalUtility.stringValueOf(QQFileExpiringListViewModel.this.fileDownloadStatusList.get(indexOf).fileDownloadStatus) + ", " + QQFileExpiringListViewModel.this.fileDownloadStatusList.get(indexOf).process + ']');
                                    } else if (i16 == 2) {
                                        KLog.INSTANCE.e("QQFileKuiklyExpiringList", kTFileInfo2.fileName + " \u53d6\u6d88\u4e0b\u8f7d");
                                        QQFileExpiringListViewModel qQFileExpiringListViewModel4 = QQFileExpiringListViewModel.this;
                                        int i17 = indexOf;
                                        qQFileExpiringListViewModel4.updateFileDownloadStatus$enumunboxing$(i17, 3, qQFileExpiringListViewModel4.fileDownloadStatusList.get(i17).process);
                                    } else {
                                        KLog.INSTANCE.e("QQFileKuiklyExpiringList", kTFileInfo2.fileName + " \u6062\u590d\u4e0b\u8f7d");
                                        QQFileExpiringListViewModel qQFileExpiringListViewModel5 = QQFileExpiringListViewModel.this;
                                        int i18 = indexOf;
                                        qQFileExpiringListViewModel5.updateFileDownloadStatus$enumunboxing$(i18, 2, qQFileExpiringListViewModel5.fileDownloadStatusList.get(i18).process);
                                    }
                                    QQFileKuiklyModule companion2 = QQFileKuiklyModule.Companion.getInstance();
                                    final KTFileInfo kTFileInfo3 = kTFileInfo2;
                                    final QQFileExpiringListViewModel qQFileExpiringListViewModel6 = QQFileExpiringListViewModel.this;
                                    final int i19 = indexOf;
                                    Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt.ItemList.2.1.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(e eVar) {
                                            String str;
                                            String p16;
                                            e eVar2 = eVar;
                                            int i26 = 0;
                                            if (Intrinsics.areEqual(eVar2 != null ? Boolean.valueOf(eVar2.g("result", false)) : null, Boolean.TRUE)) {
                                                if (eVar2 == null || (str = eVar2.p("uuid")) == null) {
                                                    str = "";
                                                }
                                                if (Intrinsics.areEqual(KTFileInfo.this.uuid, str)) {
                                                    final float h17 = eVar2 != null ? (float) eVar2.h("process") : 0.0f;
                                                    int parseInt = (eVar2 == null || (p16 = eVar2.p(VirtualAppProxy.KEY_DOWNLOAD_STATUS)) == null) ? 0 : Integer.parseInt(p16);
                                                    int[] values = BoxType$EnumUnboxingSharedUtility.values(5);
                                                    int length = values.length;
                                                    int i27 = 0;
                                                    while (true) {
                                                        if (i27 >= length) {
                                                            break;
                                                        }
                                                        int i28 = values[i27];
                                                        if (BoxType$EnumUnboxingSharedUtility.ordinal(i28) == parseInt) {
                                                            i26 = i28;
                                                            break;
                                                        }
                                                        i27++;
                                                    }
                                                    int i29 = i26 != 0 ? i26 : 1;
                                                    KLog.INSTANCE.e("QQFileKuiklyExpiringList", KTFileInfo.this.uuid + " \u4e0b\u8f7d\u4e2d: " + h17 + ", \u72b6\u6001" + DownloadStatus$EnumUnboxingLocalUtility.stringValueOf(i29));
                                                    if (i29 == 4) {
                                                        final QQFileExpiringListViewModel qQFileExpiringListViewModel7 = qQFileExpiringListViewModel6;
                                                        final int i36 = i19;
                                                        TimerKt.d(1000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt.ItemList.2.1.1.1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Unit invoke() {
                                                                QQFileExpiringListViewModel.this.updateFileDownloadStatus$enumunboxing$(i36, 4, h17);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        i29 = 2;
                                                    }
                                                    qQFileExpiringListViewModel6.updateFileDownloadStatus$enumunboxing$(i19, i29, h17);
                                                }
                                            } else {
                                                KLog.INSTANCE.e("QQFileKuiklyExpiringList", "\u4e0b\u8f7d\u5931\u8d25\uff1aDownloadStatus_UNDOWNLOAD, 0");
                                                qQFileExpiringListViewModel6.updateFileDownloadStatus$enumunboxing$(i19, 1, 0.0f);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    e createParamsWithFileInfo = companion2.createParamsWithFileInfo(kTFileInfo3);
                                    createParamsWithFileInfo.t(VirtualAppProxy.KEY_DOWNLOAD_STATUS, BoxType$EnumUnboxingSharedUtility.ordinal(i16));
                                    companion2.toNative(true, "downloadFile", createParamsWithFileInfo.toString(), function1, false);
                                    KLog.INSTANCE.e("QQFileKuiklyModule", "downloadFile");
                                    e access$getDTItemParam = QQFileExpiringListItemKt.access$getDTItemParam(kTFileInfo2);
                                    access$getDTItemParam.v("dt_eid", WinkDaTongReportConstant.ElementId.EM_BAS_DOWNLOAD);
                                    QQFileReportKt.reportFileCustomDtEvent("dt_clck", access$getDTItemParam);
                                    return Unit.INSTANCE;
                                }
                            };
                            final MutableState<Integer> mutableState3 = mutableState2;
                            int i16 = intValue2 & 14;
                            composer5.startReplaceableGroup(511388516);
                            boolean changed2 = composer5.changed(kTFileInfo2) | composer5.changed(mutableState3);
                            Object rememberedValue3 = composer5.rememberedValue();
                            if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt$ItemList$2$1$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        QQFileKuiklyModule companion2 = QQFileKuiklyModule.Companion.getInstance();
                                        KTFileInfo kTFileInfo3 = KTFileInfo.this;
                                        final MutableState<Integer> mutableState4 = mutableState3;
                                        companion2.toNative(false, "shareFile", companion2.createParamsWithFileInfo(kTFileInfo3).toString(), new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt$ItemList$2$1$2$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(e eVar) {
                                                e eVar2 = eVar;
                                                if (Intrinsics.areEqual(eVar2 != null ? Boolean.valueOf(eVar2.g("result", false)) : null, Boolean.TRUE)) {
                                                    mutableState4.setValue(-1);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }, false);
                                        KLog.INSTANCE.e("QQFileKuiklyModule", "shareFile");
                                        e access$getDTItemParam = QQFileExpiringListItemKt.access$getDTItemParam(KTFileInfo.this);
                                        access$getDTItemParam.v("dt_eid", "em_bas_left_slide_menu");
                                        QQFileReportKt.reportFileCustomDtEvent("dt_clck", access$getDTItemParam);
                                        return Unit.INSTANCE;
                                    }
                                };
                                composer5.updateRememberedValue(rememberedValue3);
                            }
                            composer5.endReplaceableGroup();
                            Function0 function02 = (Function0) rememberedValue3;
                            final QQFileExpiringListViewModel qQFileExpiringListViewModel4 = QQFileExpiringListViewModel.this;
                            Function0<Unit> function03 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt.ItemList.2.1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    QQFileKuiklyModule companion2 = QQFileKuiklyModule.Companion.getInstance();
                                    final KTFileInfo kTFileInfo3 = KTFileInfo.this;
                                    final QQFileExpiringListViewModel qQFileExpiringListViewModel5 = qQFileExpiringListViewModel4;
                                    final int i17 = indexOf;
                                    companion2.toNative(true, "openFileBrowser", companion2.createParamsWithFileInfo(kTFileInfo3).toString(), new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt.ItemList.2.1.3.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(e eVar) {
                                            String str;
                                            e eVar2 = eVar;
                                            if (Intrinsics.areEqual(eVar2 != null ? Boolean.valueOf(eVar2.g("result", false)) : null, Boolean.TRUE)) {
                                                if (eVar2 == null || (str = eVar2.p("uuid")) == null) {
                                                    str = "";
                                                }
                                                Boolean valueOf = eVar2 != null ? Boolean.valueOf(eVar2.g("isDownloading", false)) : null;
                                                if (Intrinsics.areEqual(KTFileInfo.this.uuid, str) && Intrinsics.areEqual(valueOf, Boolean.FALSE)) {
                                                    qQFileExpiringListViewModel5.updateFileDownloadStatus$enumunboxing$(i17, 4, 1.0f);
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }, false);
                                    KLog.INSTANCE.e("QQFileKuiklyModule", "openFileBrowser");
                                    return Unit.INSTANCE;
                                }
                            };
                            final MutableState<Integer> mutableState4 = mutableState2;
                            composer5.startReplaceableGroup(1157296644);
                            boolean changed3 = composer5.changed(mutableState4);
                            Object rememberedValue4 = composer5.rememberedValue();
                            if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue4 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt$ItemList$2$1$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        mutableState4.setValue(-1);
                                        return Unit.INSTANCE;
                                    }
                                };
                                composer5.updateRememberedValue(rememberedValue4);
                            }
                            composer5.endReplaceableGroup();
                            final MutableState<Integer> mutableState5 = mutableState2;
                            final QQFileExpiringListViewModel qQFileExpiringListViewModel5 = QQFileExpiringListViewModel.this;
                            QQFileExpiringListItemKt.ListItem(kTFileInfo2, kTFileDownloadStatus, z16, function0, function02, function03, (Function0) rememberedValue4, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt.ItemList.2.1.5
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    mutableState5.setValue(Integer.valueOf(qQFileExpiringListViewModel5.fileInfoList.indexOf(kTFileInfo2)));
                                    return Unit.INSTANCE;
                                }
                            }, composer5, i16 | 64);
                            final p b16 = FooterRefreshKt.b(composer5, 0);
                            final QQFileExpiringListViewModel qQFileExpiringListViewModel6 = QQFileExpiringListViewModel.this;
                            FooterRefreshKt.a(b16, null, null, 300.0f, 0.0f, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt.ItemList.2.1.6
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    KLog.INSTANCE.e("QQFileKuiklyExpiringList", "isScrolledToTheEnd, loadMoreData");
                                    QQFileExpiringListViewModel.this.loadMoreData();
                                    b16.b(false);
                                    return Unit.INSTANCE;
                                }
                            }, ComposableSingletons$QQFileExpiringListItemKt.f116lambda1, composer5, 1575936, 22);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), composer3, 3080, 2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 8, 48, MsgConstant.KRMFILETHUMBSIZE384, 3930110);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt$ItemList$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFileExpiringListItemKt.ItemList(QQFileExpiringListViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.List, java.util.Collection] */
    public static final void ListItem(final KTFileInfo kTFileInfo, final KTFileDownloadStatus kTFileDownloadStatus, final boolean z16, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function0<Unit> function04, final Function0<Unit> function05, Composer composer, final int i3) {
        String a16;
        final String str;
        ?? emptyList;
        List listOf;
        Object first;
        Composer startRestartGroup = composer.startRestartGroup(-1413304080);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1413304080, i3, -1, "com.tencent.hippykotlin.demo.pages.qqfile.views.ListItem (QQFileExpiringListItem.kt:194)");
        }
        final int ceil = (int) Math.ceil(kTFileInfo.lifeTime / 86400.0d);
        QQFileTimeUtils qQFileTimeUtils = QQFileTimeUtils.INSTANCE;
        long j3 = kTFileInfo.uploadTime * 1000;
        final String str2 = "";
        if (j3 == 0) {
            str = "";
        } else {
            c cVar = c.f117352a;
            b bVar = (b) cVar.g().acquireModule("KRCalendarModule");
            bVar.b(j3);
            if (j3 >= QQFileTimeUtils.mYesterdayTime) {
                b.c((b) cVar.g().acquireModule("KRCalendarModule"), 0L, 1, null);
                a16 = bVar.a(j3, DateUtil.DATE_FORMAT_HOUR);
            } else if (j3 >= QQFileTimeUtils.mTwoDayAgoTime) {
                a16 = bVar.a(j3, "\u6628\u5929");
            } else if (j3 >= QQFileTimeUtils.mOneYearTime) {
                a16 = bVar.a(j3, "M-dd");
            } else {
                a16 = bVar.a(j3, "yy-MM-dd");
            }
            str = a16;
        }
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        String valueOf = String.valueOf(kTFileInfo.ownerUin);
        QQKuiklyPlatformApi qQKuiklyPlatformApi = (QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi");
        qQKuiklyPlatformApi.getClass();
        String[] strArr = {valueOf};
        Intrinsics.checkNotNull(strArr, "null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
        Object syncToNativeMethod = qQKuiklyPlatformApi.syncToNativeMethod(false, "getNickNamesByUins", strArr, null);
        if (!(syncToNativeMethod instanceof Object[])) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            emptyList = new ArrayList();
            Object[] objArr = (Object[]) syncToNativeMethod;
            int length = objArr.length;
            int i16 = 0;
            int i17 = 0;
            while (i16 < length) {
                Object obj = objArr[i16];
                int i18 = i17 + 1;
                if (i17 != 0) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    emptyList.add((String) obj);
                }
                i16++;
                i17 = i18;
            }
        }
        if (!emptyList.isEmpty()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) emptyList);
            str2 = (String) first;
        }
        if (str2.length() > 25) {
            StringBuilder sb5 = new StringBuilder();
            String substring = str2.substring(0, 22);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            sb5.append(substring);
            sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
            str2 = sb5.toString();
        }
        i.Companion companion2 = i.INSTANCE;
        i d16 = ModifiersKt.d(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null), QUIToken.color$default("bg_bottom_light"));
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed = startRestartGroup.changed(kTFileInfo);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt$ListItem$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Float f16) {
                    f16.floatValue();
                    QQFileReportKt.reportFileCustomDtEvent("dt_imp", QQFileExpiringListItemKt.access$getDTItemParam(KTFileInfo.this));
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        i b16 = ViewEventPropUpdaterKt.b(d16, (Function1) rememberedValue);
        boolean z17 = !z16;
        i z18 = ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.w(companion2, ((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).e()));
        i f16 = ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new QQMoreOptionButton(70.0f, new h(4294937920L), function02, "\u8f6c\u53d1", 16.0f, bp3.c.INSTANCE.f(), QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_BUTTON_TYPE));
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, 501361258, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt$ListItem$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 11) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(501361258, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqfile.views.ListItem.<anonymous> (QQFileExpiringListItem.kt:218)");
                    }
                    i d17 = ModifiersKt.d(i.INSTANCE, QUIToken.color$default("bg_bottom_light"));
                    final Function0<Unit> function06 = function03;
                    final KTFileInfo kTFileInfo2 = kTFileInfo;
                    composer3.startReplaceableGroup(511388516);
                    boolean changed2 = composer3.changed(function06) | composer3.changed(kTFileInfo2);
                    Object rememberedValue2 = composer3.rememberedValue();
                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt$ListItem$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                function06.invoke();
                                QQFileReportKt.reportFileCustomDtEvent("dt_clck", QQFileExpiringListItemKt.access$getDTItemParam(kTFileInfo2));
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    composer3.endReplaceableGroup();
                    i d18 = ViewEventPropUpdaterKt.d(d17, false, null, (Function1) rememberedValue2, 3, null);
                    final KTFileInfo kTFileInfo3 = kTFileInfo;
                    ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer3, -904851819, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt$ListItem$2.2
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(Composer composer4, Integer num2) {
                            final String str3;
                            boolean endsWith;
                            boolean endsWith2;
                            boolean endsWith3;
                            boolean endsWith4;
                            boolean endsWith5;
                            boolean endsWith6;
                            boolean endsWith7;
                            boolean endsWith8;
                            boolean endsWith9;
                            boolean endsWith10;
                            boolean endsWith11;
                            boolean endsWith12;
                            boolean endsWith13;
                            boolean endsWith14;
                            boolean endsWith15;
                            boolean endsWith16;
                            boolean endsWith17;
                            boolean endsWith18;
                            boolean endsWith19;
                            boolean endsWith20;
                            boolean endsWith21;
                            boolean endsWith22;
                            boolean endsWith23;
                            boolean endsWith24;
                            boolean endsWith25;
                            boolean endsWith26;
                            boolean endsWith27;
                            boolean endsWith28;
                            boolean endsWith29;
                            boolean endsWith30;
                            boolean endsWith31;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 11) == 2 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-904851819, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqfile.views.ListItem.<anonymous>.<anonymous> (QQFileExpiringListItem.kt:225)");
                                }
                                int i19 = KTFileInfo.this.absFileType;
                                int[] values = BoxType$EnumUnboxingSharedUtility.values(13);
                                int length2 = values.length;
                                int i26 = 0;
                                int i27 = 0;
                                while (true) {
                                    if (i27 >= length2) {
                                        break;
                                    }
                                    int i28 = values[i27];
                                    if (BoxType$EnumUnboxingSharedUtility.ordinal(i28) == i19) {
                                        i26 = i28;
                                        break;
                                    }
                                    i27++;
                                }
                                if (i26 == 0) {
                                    i26 = 1;
                                }
                                String str4 = KTFileInfo.this.fileName;
                                int ordinal = BoxType$EnumUnboxingSharedUtility.ordinal(i26);
                                String str5 = "filelook_pdf";
                                switch (ordinal) {
                                    case 1:
                                    case 2:
                                        str3 = "filelook_doc";
                                        break;
                                    case 3:
                                    case 4:
                                        str3 = "filelook_xls";
                                        break;
                                    case 5:
                                    case 6:
                                        str3 = "filelook_ppt";
                                        break;
                                    case 7:
                                        str3 = "filelook_txt";
                                        break;
                                    case 8:
                                        str3 = "filelook_pdf";
                                        break;
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                        str3 = "filelook_image";
                                        break;
                                    default:
                                        str3 = null;
                                        break;
                                }
                                if (str3 == null) {
                                    endsWith = StringsKt__StringsJVMKt.endsWith(str4, ".doc", true);
                                    if (!endsWith) {
                                        endsWith2 = StringsKt__StringsJVMKt.endsWith(str4, ".docx", true);
                                        if (!endsWith2) {
                                            endsWith3 = StringsKt__StringsJVMKt.endsWith(str4, ".xls", true);
                                            if (!endsWith3) {
                                                endsWith4 = StringsKt__StringsJVMKt.endsWith(str4, ".xlsx", true);
                                                if (!endsWith4) {
                                                    endsWith5 = StringsKt__StringsJVMKt.endsWith(str4, ".ppt", true);
                                                    if (!endsWith5) {
                                                        endsWith6 = StringsKt__StringsJVMKt.endsWith(str4, ".pptx", true);
                                                        if (!endsWith6) {
                                                            endsWith7 = StringsKt__StringsJVMKt.endsWith(str4, ".rtf", true);
                                                            if (!endsWith7) {
                                                                endsWith8 = StringsKt__StringsJVMKt.endsWith(str4, ".pdf", true);
                                                                if (!endsWith8) {
                                                                    endsWith9 = StringsKt__StringsJVMKt.endsWith(str4, ".bmp", true);
                                                                    if (!endsWith9) {
                                                                        endsWith10 = StringsKt__StringsJVMKt.endsWith(str4, ".png", true);
                                                                        if (!endsWith10) {
                                                                            endsWith11 = StringsKt__StringsJVMKt.endsWith(str4, ".jpg", true);
                                                                            if (!endsWith11) {
                                                                                endsWith12 = StringsKt__StringsJVMKt.endsWith(str4, ".jpeg", true);
                                                                                if (!endsWith12) {
                                                                                    endsWith13 = StringsKt__StringsJVMKt.endsWith(str4, QzoneEmotionUtils.SIGN_ICON_URL_END, true);
                                                                                    if (!endsWith13) {
                                                                                        endsWith14 = StringsKt__StringsJVMKt.endsWith(str4, ".heic", true);
                                                                                        if (!endsWith14) {
                                                                                            endsWith15 = StringsKt__StringsJVMKt.endsWith(str4, ".mp4", true);
                                                                                            if (!endsWith15) {
                                                                                                endsWith16 = StringsKt__StringsJVMKt.endsWith(str4, ".mkv", true);
                                                                                                if (!endsWith16) {
                                                                                                    endsWith17 = StringsKt__StringsJVMKt.endsWith(str4, ".avi", true);
                                                                                                    if (!endsWith17) {
                                                                                                        endsWith18 = StringsKt__StringsJVMKt.endsWith(str4, DefaultHlsExtractorFactory.MP3_FILE_EXTENSION, true);
                                                                                                        if (!endsWith18) {
                                                                                                            endsWith19 = StringsKt__StringsJVMKt.endsWith(str4, ".wav", true);
                                                                                                            if (!endsWith19) {
                                                                                                                endsWith20 = StringsKt__StringsJVMKt.endsWith(str4, DefaultHlsExtractorFactory.AAC_FILE_EXTENSION, true);
                                                                                                                if (!endsWith20) {
                                                                                                                    endsWith21 = StringsKt__StringsJVMKt.endsWith(str4, ".zip", true);
                                                                                                                    if (!endsWith21) {
                                                                                                                        endsWith22 = StringsKt__StringsJVMKt.endsWith(str4, ".rar", true);
                                                                                                                        if (!endsWith22) {
                                                                                                                            endsWith23 = StringsKt__StringsJVMKt.endsWith(str4, ".7z", true);
                                                                                                                            if (!endsWith23) {
                                                                                                                                endsWith24 = StringsKt__StringsJVMKt.endsWith(str4, ".html", true);
                                                                                                                                if (!endsWith24) {
                                                                                                                                    endsWith25 = StringsKt__StringsJVMKt.endsWith(str4, ".htm", true);
                                                                                                                                    if (!endsWith25) {
                                                                                                                                        endsWith26 = StringsKt__StringsJVMKt.endsWith(str4, ".psd", true);
                                                                                                                                        if (!endsWith26) {
                                                                                                                                            endsWith27 = StringsKt__StringsJVMKt.endsWith(str4, ".ipa", true);
                                                                                                                                            if (!endsWith27) {
                                                                                                                                                endsWith28 = StringsKt__StringsJVMKt.endsWith(str4, ".sketch", true);
                                                                                                                                                if (!endsWith28) {
                                                                                                                                                    endsWith29 = StringsKt__StringsJVMKt.endsWith(str4, ".ai", true);
                                                                                                                                                    if (!endsWith29) {
                                                                                                                                                        endsWith30 = StringsKt__StringsJVMKt.endsWith(str4, ".folder", true);
                                                                                                                                                        if (!endsWith30) {
                                                                                                                                                            endsWith31 = StringsKt__StringsJVMKt.endsWith(str4, ".floder", true);
                                                                                                                                                            if (!endsWith31) {
                                                                                                                                                                str5 = "filelook_unknown";
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                        str5 = "filelook_floder";
                                                                                                                                                    } else {
                                                                                                                                                        str5 = "filelook_ai";
                                                                                                                                                    }
                                                                                                                                                } else {
                                                                                                                                                    str5 = "filelook_sketch";
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                str5 = "filelook_ipa";
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            str5 = "filelook_ps";
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                str5 = "filelook_html";
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                    str5 = "filelook_zip";
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                        str5 = "filelook_audio";
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            str5 = "filelook_video";
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    str5 = "filelook_image";
                                                                }
                                                            } else {
                                                                str5 = "filelook_txt";
                                                            }
                                                            str3 = str5;
                                                        }
                                                    }
                                                    str5 = "filelook_ppt";
                                                    str3 = str5;
                                                }
                                            }
                                            str5 = "filelook_xls";
                                            str3 = str5;
                                        }
                                    }
                                    str5 = "filelook_doc";
                                    str3 = str5;
                                }
                                BoxKt.a(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null), 48.0f), null, null, ComposableLambdaKt.composableLambda(composer5, -1708249649, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt.ListItem.2.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer6, Integer num3) {
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1708249649, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqfile.views.ListItem.<anonymous>.<anonymous>.<anonymous> (QQFileExpiringListItem.kt:229)");
                                            }
                                            ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 48.0f), null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, QUIToken.INSTANCE.image(str3, null), null, null, null, null, null, null, null, null, null, null, composer7, 12845056, 0, 0, 2095967);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 3080, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    final KTFileInfo kTFileInfo4 = kTFileInfo;
                    ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer3, 753851153, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt$ListItem$2.3
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 11) == 2 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(753851153, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqfile.views.ListItem.<anonymous>.<anonymous> (QQFileExpiringListItem.kt:237)");
                                }
                                TextKt.a(KTFileInfo.this.fileName, null, null, QUIToken.color$default("text_primary"), Float.valueOf(17.0f), null, null, null, null, null, null, null, null, null, null, null, an.d(an.INSTANCE.c()), null, 2, null, null, null, null, null, null, null, false, composer5, 28672, 102236160, 0, 133890022);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    final String str3 = str;
                    final String str4 = str2;
                    final KTFileInfo kTFileInfo5 = kTFileInfo;
                    final int i19 = ceil;
                    QUIListDoubleLineCommonViewKt.QUIListDoubleLineCommonView(d18, null, composableLambda2, null, 0.0f, null, composableLambda3, null, null, ComposableLambdaKt.composableLambda(composer3, -1223347090, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt$ListItem$2.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 11) == 2 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1223347090, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqfile.views.ListItem.<anonymous>.<anonymous> (QQFileExpiringListItem.kt:246)");
                                }
                                TextKt.a(str3 + TokenParser.SP + str4 + TokenParser.SP + kTFileInfo5.fileSizeDes + TokenParser.SP + i19 + "\u5929\u5185\u8fc7\u671f", null, null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, null, null, null, null, null, null, null, null, null, null, an.d(an.INSTANCE.c()), null, 2, null, null, null, null, null, null, null, false, composer5, 28672, 102236160, 0, 133890022);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), 0.0f, null, null, null, ComposableLambdaKt.composableLambda(composer3, 1473188956, true, new Function2<Composer, Integer, Unit>(function0, i3) { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt$ListItem$2.5
                        public final /* synthetic */ Function0<Unit> $onDownload;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 11) == 2 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1473188956, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqfile.views.ListItem.<anonymous>.<anonymous> (QQFileExpiringListItem.kt:255)");
                                }
                                KLog kLog = KLog.INSTANCE;
                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("update listItem: ");
                                m3.append(DownloadStatus$EnumUnboxingLocalUtility.stringValueOf(KTFileDownloadStatus.this.fileDownloadStatus));
                                kLog.e("QQFileKuiklyExpiringList", m3.toString());
                                int i26 = KTFileDownloadStatus.this.fileDownloadStatus;
                                if (i26 == 4) {
                                    composer5.startReplaceableGroup(1914509683);
                                    BoxKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), QUIToken.color$default("bg_bottom_light")), null, null, ComposableSingletons$QQFileExpiringListItemKt.f117lambda2, composer5, 3080, 6);
                                    composer5.endReplaceableGroup();
                                } else if (BoxType$EnumUnboxingSharedUtility.compareTo(i26, 1) > 0 && KTFileDownloadStatus.this.fileDownloadStatus != 5) {
                                    composer5.startReplaceableGroup(1914511045);
                                    i a17 = ModifiersKt.a(ModifiersKt.c(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 12.0f), QUIToken.color$default("overlay_standard_primary")), "\u6682\u505c\u4e0b\u8f7d");
                                    final Function0<Unit> function07 = this.$onDownload;
                                    composer5.startReplaceableGroup(1157296644);
                                    boolean changed3 = composer5.changed(function07);
                                    Object rememberedValue3 = composer5.rememberedValue();
                                    if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt$ListItem$2$5$2$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                function07.invoke();
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer5.updateRememberedValue(rememberedValue3);
                                    }
                                    composer5.endReplaceableGroup();
                                    i d19 = ViewEventPropUpdaterKt.d(a17, false, null, (Function1) rememberedValue3, 3, null);
                                    Alignment alignment = Alignment.Center;
                                    final KTFileDownloadStatus kTFileDownloadStatus2 = KTFileDownloadStatus.this;
                                    BoxKt.a(d19, alignment, null, ComposableLambdaKt.composableLambda(composer5, -652276986, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt.ListItem.2.5.3
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer6, Integer num3) {
                                            String image;
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-652276986, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqfile.views.ListItem.<anonymous>.<anonymous>.<anonymous> (QQFileExpiringListItem.kt:297)");
                                                }
                                                i.Companion companion3 = i.INSTANCE;
                                                i u16 = ComposeLayoutPropUpdaterKt.u(companion3, 24.0f);
                                                QUIToken qUIToken = QUIToken.INSTANCE;
                                                ProgressIndicatorKt.a(KTFileDownloadStatus.this.process, u16, QUIToken.color$default("brand_standard"), QUIToken.color$default("bg_bottom_light"), 2.0f, 0.0f, composer7, 29248, 32);
                                                i u17 = ComposeLayoutPropUpdaterKt.u(companion3, 12.0f);
                                                if (KTFileDownloadStatus.this.fileDownloadStatus == 3) {
                                                    image = qUIToken.image("arrowhead_down", QUIToken.color$default("icon_secondary"));
                                                } else {
                                                    image = qUIToken.image("pause", QUIToken.color$default("icon_secondary"));
                                                }
                                                ImageKt.a(null, null, null, null, null, u17, null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, image, null, null, null, null, null, null, null, null, null, null, composer7, 12845056, 0, 0, 2095967);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 3128, 4);
                                    composer5.endReplaceableGroup();
                                } else {
                                    composer5.startReplaceableGroup(1914510076);
                                    i a18 = ModifiersKt.a(ModifiersKt.c(ModifiersKt.j(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), 0.0f, 0.0f, 2.0f, 0.0f, 11, null), 10.0f), QUIToken.color$default("overlay_standard_primary")), "\u5f00\u59cb\u4e0b\u8f7d");
                                    final Function0<Unit> function08 = this.$onDownload;
                                    composer5.startReplaceableGroup(1157296644);
                                    boolean changed4 = composer5.changed(function08);
                                    Object rememberedValue4 = composer5.rememberedValue();
                                    if (changed4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt$ListItem$2$5$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                function08.invoke();
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer5.updateRememberedValue(rememberedValue4);
                                    }
                                    composer5.endReplaceableGroup();
                                    BoxKt.a(ViewEventPropUpdaterKt.d(a18, false, null, (Function1) rememberedValue4, 3, null), Alignment.Center, null, ComposableSingletons$QQFileExpiringListItemKt.f118lambda3, composer5, 3128, 4);
                                    composer5.endReplaceableGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), 0.0f, composer3, 806879624, 24576, 48570);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        });
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed2 = startRestartGroup.changed(function04);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt$ListItem$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    function04.invoke();
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        Function0 function06 = (Function0) rememberedValue2;
        startRestartGroup.startReplaceableGroup(511388516);
        boolean changed3 = startRestartGroup.changed(function05) | startRestartGroup.changed(kTFileInfo);
        Object rememberedValue3 = startRestartGroup.rememberedValue();
        if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt$ListItem$4$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    function05.invoke();
                    e access$getDTItemParam = QQFileExpiringListItemKt.access$getDTItemParam(kTFileInfo);
                    access$getDTItemParam.v("dt_eid", "em_bas_left_slide_menu");
                    QQFileReportKt.reportFileCustomDtEvent("dt_imp", access$getDTItemParam);
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
        }
        startRestartGroup.endReplaceableGroup();
        QQMoreOptionContentViewKt.QQMoreOptionContentView(b16, z17, z18, composableLambda, 50.0f, function06, f16, listOf, (Function0) rememberedValue3, startRestartGroup, 18902536, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListItemKt$ListItem$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFileExpiringListItemKt.ListItem(KTFileInfo.this, kTFileDownloadStatus, z16, function0, function02, function03, function04, function05, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
