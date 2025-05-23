package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModel;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayerKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayerState;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUILoadingViewKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.LoadingIconType;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFTFailedFileInfo;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.resource.QQFTIconConstant;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import com.tencent.ntcompose.foundation.scheduler.SchedulerKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.LazyColumnKt;
import com.tencent.ntcompose.material.ModalKt;
import com.tencent.ntcompose.material.ProgressIndicatorKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.an;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.qqnt.kernel.nativeinterface.RichErrorCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import ws3.ab;
import ws3.cu;
import ws3.cx;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTDownloadFailedFileListFloatViewKt {
    public static final void QQFTDownloadFailedFileListFloatView(final QQFlashTransferViewModel qQFlashTransferViewModel, final Function1<? super Boolean, Unit> function1, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(841207054);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(841207054, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatView (QQFTDownloadFailedFileListFloatView.kt:69)");
        }
        ModalKt.a(null, false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 116992396, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatViewKt$QQFTDownloadFailedFileListFloatView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                        ComposerKt.traceEventStart(116992396, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatView.<anonymous> (QQFTDownloadFailedFileListFloatView.kt:73)");
                    }
                    i f16 = ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null);
                    Alignment alignment = Alignment.BottomEnd;
                    final Function1<Boolean, Unit> function12 = function1;
                    final int i16 = i3;
                    final QQFlashTransferViewModel qQFlashTransferViewModel2 = qQFlashTransferViewModel;
                    BoxKt.a(f16, alignment, null, ComposableLambdaKt.composableLambda(composer3, 1531804102, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatViewKt$QQFTDownloadFailedFileListFloatView$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1531804102, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatView.<anonymous>.<anonymous> (QQFTDownloadFailedFileListFloatView.kt:78)");
                                }
                                HalfFloatingLayerState rememberHalfFloatingLayerState = HalfFloatingLayerKt.rememberHalfFloatingLayerState(composer5);
                                KLog.INSTANCE.d("QQFTDownloadFailedFileListFloatView", "render modal...");
                                float androidBottomNavBarHeight = QQFTUIConfigKt.getAndroidBottomNavBarHeight(composer5) + 362.0f;
                                h color$default = QUIToken.color$default("bg_middle_light");
                                final Function1<Boolean, Unit> function13 = function12;
                                composer5.startReplaceableGroup(1157296644);
                                boolean changed = composer5.changed(function13);
                                Object rememberedValue = composer5.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatViewKt$QQFTDownloadFailedFileListFloatView$1$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(Object obj) {
                                            function13.invoke(Boolean.FALSE);
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer5.updateRememberedValue(rememberedValue);
                                }
                                composer5.endReplaceableGroup();
                                Function1 function14 = (Function1) rememberedValue;
                                Function2<Composer, Integer, Unit> function2 = ComposableSingletons$QQFTDownloadFailedFileListFloatViewKt.f127lambda1;
                                final QQFlashTransferViewModel qQFlashTransferViewModel3 = qQFlashTransferViewModel2;
                                final Function1<Boolean, Unit> function15 = function12;
                                final int i17 = i16;
                                HalfFloatingLayerKt.HalfFloatingLayer(androidBottomNavBarHeight, 0.3f, color$default, 0.0f, function14, rememberHalfFloatingLayerState, function2, ComposableLambdaKt.composableLambda(composer5, -1217151584, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatViewKt.QQFTDownloadFailedFileListFloatView.1.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(Composer composer6, Integer num3) {
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 11) == 2 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1217151584, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatView.<anonymous>.<anonymous>.<anonymous> (QQFTDownloadFailedFileListFloatView.kt:93)");
                                            }
                                            QQFTDownloadFailedFileListFloatViewKt.boardContent(QQFlashTransferViewModel.this, function15, composer7, (i17 & 112) | 8);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 14156336, 8);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3128, 4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24576, 15);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatViewKt$QQFTDownloadFailedFileListFloatView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTDownloadFailedFileListFloatViewKt.QQFTDownloadFailedFileListFloatView(QQFlashTransferViewModel.this, function1, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void boardContent(final QQFlashTransferViewModel qQFlashTransferViewModel, final Function1<? super Boolean, Unit> function1, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1517702391);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1517702391, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.boardContent (QQFTDownloadFailedFileListFloatView.kt:103)");
        }
        ColumnKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), 16.0f, 0.0f, 0.0f, 0.0f, 14, null), QUIToken.color$default("bg_middle_light")), null, Alignment.INSTANCE.b(), null, ComposableLambdaKt.composableLambda(startRestartGroup, 2024722482, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatViewKt$boardContent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                        ComposerKt.traceEventStart(2024722482, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.boardContent.<anonymous> (QQFTDownloadFailedFileListFloatView.kt:109)");
                    }
                    i.Companion companion = i.INSTANCE;
                    i j3 = ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 24.0f, 0.0f, 0.0f, 13, null), 0.0f, 1, null);
                    final QQFlashTransferViewModel qQFlashTransferViewModel2 = QQFlashTransferViewModel.this;
                    final Function1<Boolean, Unit> function12 = function1;
                    BoxKt.a(j3, null, null, ComposableLambdaKt.composableLambda(composer3, -333102868, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatViewKt$boardContent$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                            int i16;
                            b bVar2 = bVar;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i16 = (composer5.changed(bVar2) ? 4 : 2) | intValue2;
                            } else {
                                i16 = intValue2;
                            }
                            if ((i16 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-333102868, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.boardContent.<anonymous>.<anonymous> (QQFTDownloadFailedFileListFloatView.kt:111)");
                                }
                                i.Companion companion2 = i.INSTANCE;
                                i a16 = bVar2.a(companion2, Alignment.CenterStart);
                                String str = QQFlashTransferViewModel.this.downloadFailedFileList.size() + "\u4e2a\u6587\u4ef6\u4e0b\u8f7d\u5931\u8d25";
                                h color$default = QUIToken.color$default("text_primary");
                                ai.Companion companion3 = ai.INSTANCE;
                                int a17 = companion3.a();
                                c.Companion companion4 = c.INSTANCE;
                                TextKt.a(str, a16, null, color$default, Float.valueOf(17.0f), null, companion4.f(), null, null, null, ai.f(a17), null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer5, 1601600, 100663296, 0, 133954468);
                                i n3 = ComposeLayoutPropUpdaterKt.n(bVar2.a(companion2, Alignment.CenterEnd), 0.0f, 0.0f, 16.0f, 0.0f, 11, null);
                                final QQFlashTransferViewModel qQFlashTransferViewModel3 = QQFlashTransferViewModel.this;
                                final Function1<Boolean, Unit> function13 = function12;
                                TextKt.a("\u6e05\u7a7a\u4efb\u52a1", ViewEventPropUpdaterKt.d(n3, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatViewKt.boardContent.1.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Multi-variable type inference failed */
                                    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.util.ArrayList] */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        List list;
                                        KLog kLog = KLog.INSTANCE;
                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("failedFileIdList size=");
                                        m3.append(QQFlashTransferViewModel.this.downloadFailedFileList.size());
                                        kLog.d("QQFTDownloadFailedFileListFloatView", m3.toString());
                                        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                                        objectRef.element = new ArrayList();
                                        Iterator<Map.Entry<String, QQFTFailedFileInfo>> it = QQFlashTransferViewModel.this.downloadFailedFileList.entrySet().iterator();
                                        while (it.hasNext()) {
                                            ((ArrayList) objectRef.element).add(it.next().getValue().failedFile);
                                        }
                                        IKernelFlashTransferService a18 = IKernelFlashTransferService.f344757i.a();
                                        list = CollectionsKt___CollectionsKt.toList((Iterable) objectRef.element);
                                        final QQFlashTransferViewModel qQFlashTransferViewModel4 = QQFlashTransferViewModel.this;
                                        a18.c(list, new cu() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatViewKt.boardContent.1.1.1.1
                                            @Override // ws3.cu
                                            public final void onCleanFailedFilesResult(final int i17, final String str2) {
                                                final Ref.ObjectRef<ArrayList<ab>> objectRef2 = objectRef;
                                                final QQFlashTransferViewModel qQFlashTransferViewModel5 = qQFlashTransferViewModel4;
                                                SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatViewKt$boardContent$1$1$1$1$onCleanFailedFilesResult$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        KLog kLog2 = KLog.INSTANCE;
                                                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onCleanFailedFilesResult result=");
                                                        m16.append(i17);
                                                        m16.append(" errMsg=");
                                                        NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(m16, str2, kLog2, "QQFTDownloadFailedFileListFloatView");
                                                        if (i17 == 0) {
                                                            Iterator<ab> it5 = objectRef2.element.iterator();
                                                            while (it5.hasNext()) {
                                                                ab next = it5.next();
                                                                Iterator<BaseComposeCardViewModel> it6 = qQFlashTransferViewModel5.feedListViewModel.feedCardViewModelList.iterator();
                                                                while (true) {
                                                                    if (it6.hasNext()) {
                                                                        BaseComposeCardViewModel next2 = it6.next();
                                                                        if (next2 instanceof QQFTFileDetailItemVM) {
                                                                            QQFTFileDetailItemVM qQFTFileDetailItemVM = (QQFTFileDetailItemVM) next2;
                                                                            ab abVar = qQFTFileDetailItemVM.fileDetail;
                                                                            if (Intrinsics.areEqual(abVar != null ? abVar.f446151b : null, next.f446151b)) {
                                                                                ab abVar2 = qQFTFileDetailItemVM.fileDetail;
                                                                                if (abVar2 != null) {
                                                                                    abVar2.C = 6;
                                                                                }
                                                                                qQFTFileDetailItemVM.downloadStatus.setValue(6);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                            }
                                        });
                                        QQFlashTransferViewModel.this.downloadFailedFileList.clear();
                                        function13.invoke(Boolean.FALSE);
                                        return Unit.INSTANCE;
                                    }
                                }, 3, null), null, QUIToken.color$default("brand_standard"), Float.valueOf(17.0f), null, companion4.f(), null, null, null, ai.f(companion3.a()), null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer5, 1601606, 100663296, 0, 133954468);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3080, 6);
                    if (QQFlashTransferViewModel.this.downloadFailedFileList.size() > 0) {
                        i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), QQFTUIConfigKt.getAndroidBottomNavBarHeight(composer3) + 300.0f), 0.0f, 16.0f, 0.0f, 0.0f, 13, null);
                        Boolean bool = Boolean.FALSE;
                        final QQFlashTransferViewModel qQFlashTransferViewModel3 = QQFlashTransferViewModel.this;
                        LazyColumnKt.a(n3, null, null, null, null, null, null, bool, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, 495632604, true, new Function3<a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatViewKt$boardContent$1.2
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(a aVar, Composer composer4, Integer num2) {
                                List list;
                                a aVar2 = aVar;
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(495632604, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.boardContent.<anonymous>.<anonymous> (QQFTDownloadFailedFileListFloatView.kt:165)");
                                }
                                list = CollectionsKt___CollectionsKt.toList(QQFlashTransferViewModel.this.downloadFailedFileList.values());
                                final QQFlashTransferViewModel qQFlashTransferViewModel4 = QQFlashTransferViewModel.this;
                                LazyDslKt.b(aVar2, list, null, ComposableLambdaKt.composableLambda(composer5, 1795297540, true, new Function3<QQFTFailedFileInfo, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatViewKt.boardContent.1.2.1
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(QQFTFailedFileInfo qQFTFailedFileInfo, Composer composer6, Integer num3) {
                                        QQFTFailedFileInfo qQFTFailedFileInfo2 = qQFTFailedFileInfo;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1795297540, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.boardContent.<anonymous>.<anonymous>.<anonymous> (QQFTDownloadFailedFileListFloatView.kt:166)");
                                        }
                                        QQFTDownloadFailedFileListFloatViewKt.failedListItem(qQFTFailedFileInfo2, QQFlashTransferViewModel.this, composer7, 72);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 3144, 2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 12582920, 0, MsgConstant.KRMFILETHUMBSIZE384, 4194174);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24584, 10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatViewKt$boardContent$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTDownloadFailedFileListFloatViewKt.boardContent(QQFlashTransferViewModel.this, function1, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void failedListItem(final QQFTFailedFileInfo qQFTFailedFileInfo, final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1209429778);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1209429778, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.failedListItem (QQFTDownloadFailedFileListFloatView.kt:176)");
        }
        final int thumbnailValidIndex = QQFTFileItemViewKt.getThumbnailValidIndex(qQFTFailedFileInfo.failedFile.f446166q);
        ColumnKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null)), 0.0f, 0.0f, 0.0f, 8.0f, 7, null), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -687821239, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatViewKt$failedListItem$1
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
                        ComposerKt.traceEventStart(-687821239, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.failedListItem.<anonymous> (QQFTDownloadFailedFileListFloatView.kt:181)");
                    }
                    i.Companion companion = i.INSTANCE;
                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null)), 0.0f, 0.0f, 0.0f, 8.0f, 7, null);
                    final int i16 = thumbnailValidIndex;
                    final QQFTFailedFileInfo qQFTFailedFileInfo2 = qQFTFailedFileInfo;
                    final QQFlashTransferViewModel qQFlashTransferViewModel2 = qQFlashTransferViewModel;
                    BoxKt.a(n3, null, null, ComposableLambdaKt.composableLambda(composer3, 221668687, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatViewKt$failedListItem$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                            int i17;
                            b bVar2 = bVar;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i17 = (composer5.changed(bVar2) ? 4 : 2) | intValue2;
                            } else {
                                i17 = intValue2;
                            }
                            if ((i17 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(221668687, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.failedListItem.<anonymous>.<anonymous> (QQFTDownloadFailedFileListFloatView.kt:182)");
                                }
                                i.Companion companion2 = i.INSTANCE;
                                final float f16 = 20.0f;
                                i s16 = ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.w(bVar2.a(companion2, Alignment.CenterStart), (com.tencent.kuikly.core.manager.c.f117352a.g().getPageData().m() - 32.0f) - 20.0f), 0.0f, 0.0f, 16.0f, 0.0f, 11, null);
                                final int i18 = i16;
                                final QQFTFailedFileInfo qQFTFailedFileInfo3 = qQFTFailedFileInfo2;
                                RowKt.a(s16, null, null, null, null, ComposableLambdaKt.composableLambda(composer5, -899653391, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatViewKt.failedListItem.1.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(n nVar, Composer composer6, Integer num3) {
                                        int i19;
                                        int i26;
                                        String str;
                                        Map mutableMapOf;
                                        n nVar2 = nVar;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 14) == 0) {
                                            i19 = (composer7.changed(nVar2) ? 4 : 2) | intValue3;
                                        } else {
                                            i19 = intValue3;
                                        }
                                        if ((i19 & 91) == 18 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-899653391, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.failedListItem.<anonymous>.<anonymous>.<anonymous> (QQFTDownloadFailedFileListFloatView.kt:187)");
                                            }
                                            i.Companion companion3 = i.INSTANCE;
                                            i j3 = ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(companion3, 52.0f), 4.0f);
                                            int i27 = i18;
                                            int i28 = 11;
                                            boolean z16 = false;
                                            if (i27 >= 0) {
                                                str = qQFTFailedFileInfo3.failedFile.f446166q.f446333b.get(i27).f446358b;
                                            } else {
                                                ab abVar = qQFTFailedFileInfo3.failedFile;
                                                if (abVar != null && abVar.f446159j == 4) {
                                                    str = QQFTIconConstant.FILE_TYPE_ICONS[4];
                                                } else {
                                                    String[] strArr = QQFTIconConstant.FILE_TYPE_ICONS;
                                                    if (abVar != null && abVar.f446155f) {
                                                        i26 = 25;
                                                    } else {
                                                        i26 = (abVar != null ? Integer.valueOf(abVar.f446159j) : null) != null ? abVar.f446159j : 11;
                                                    }
                                                    str = strArr[i26];
                                                }
                                            }
                                            String str2 = str;
                                            mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("Referer", "https://qfile.qq.com"));
                                            ab abVar2 = qQFTFailedFileInfo3.failedFile;
                                            String[] strArr2 = QQFTIconConstant.FILE_TYPE_ICONS_URL;
                                            if (abVar2 != null && abVar2.f446155f) {
                                                z16 = true;
                                            }
                                            if (z16) {
                                                i28 = 25;
                                            } else {
                                                if ((abVar2 != null ? Integer.valueOf(abVar2.f446159j) : null) != null) {
                                                    i28 = abVar2.f446159j;
                                                }
                                            }
                                            ImageKt.a(null, null, qQFTFailedFileInfo3.failedFile.f446151b, null, null, j3, null, 0, null, null, str2, null, null, strArr2[i28], null, null, null, null, null, null, mutableMapOf, composer7, 262144, 0, 8, 1039323);
                                            i j16 = ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.n(nVar2.b(companion3, Alignment.INSTANCE.c()), 10.0f, 0.0f, 16.0f, 0.0f, 10, null), 0.0f, 1, null);
                                            final QQFTFailedFileInfo qQFTFailedFileInfo4 = qQFTFailedFileInfo3;
                                            ColumnKt.a(j16, null, null, null, ComposableLambdaKt.composableLambda(composer7, 1969283624, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatViewKt.failedListItem.1.1.1.1
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(d dVar2, Composer composer8, Integer num4) {
                                                    String str3;
                                                    Composer composer9 = composer8;
                                                    int intValue4 = num4.intValue();
                                                    if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                        composer9.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1969283624, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.failedListItem.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTDownloadFailedFileListFloatView.kt:199)");
                                                        }
                                                        i.Companion companion4 = i.INSTANCE;
                                                        i j17 = ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.n(companion4, 0.0f, 0.0f, 0.0f, 4.0f, 7, null), 0.0f, 1, null);
                                                        String str4 = QQFTFailedFileInfo.this.failedFile.f446160k;
                                                        h color$default = QUIToken.color$default("text_primary");
                                                        ai.Companion companion5 = ai.INSTANCE;
                                                        int a16 = companion5.a();
                                                        c.Companion companion6 = c.INSTANCE;
                                                        c e16 = companion6.e();
                                                        an.Companion companion7 = an.INSTANCE;
                                                        TextKt.a(str4, j17, null, color$default, Float.valueOf(17.0f), null, e16, null, null, null, ai.f(a16), null, null, null, null, null, an.d(companion7.c()), null, 1, null, null, null, null, null, null, null, false, composer9, 1601600, 102236160, 0, 133888932);
                                                        i l3 = ComposeLayoutPropUpdaterKt.l(companion4, 0.0f);
                                                        switch (QQFTFailedFileInfo.this.failedFile.f446171v.f446182d) {
                                                            case 1005016:
                                                            case 1006001:
                                                            case 1007401:
                                                            case 1007402:
                                                            case 1007404:
                                                            case 2006018:
                                                                str3 = "\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8bbe\u7f6e\u540e\u91cd\u65b0\u4e0b\u8f7d";
                                                                break;
                                                            case 1005023:
                                                            case 1005024:
                                                            case 1005025:
                                                            case 1005026:
                                                            case 1005027:
                                                                str3 = "\u4e0b\u8f7d\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5";
                                                                break;
                                                            case 1005029:
                                                            case RichErrorCode.KSRVFILENOTEXIT /* 2006021 */:
                                                                str3 = "\u6587\u4ef6\u5df2\u8fc7\u671f\uff0c\u65e0\u6cd5\u4e0b\u8f7d";
                                                                break;
                                                            case 1007002:
                                                            case 1007003:
                                                            case 1007004:
                                                            case 1007005:
                                                            case 1007006:
                                                            case 1007301:
                                                            case RichErrorCode.KSRVRSPERRCODE /* 2006020 */:
                                                            case RichErrorCode.KSRVREFUSEDDOWNLOADFILE /* 2006047 */:
                                                            case 170018100:
                                                            default:
                                                                str3 = "\u4e0b\u8f7d\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                                                                break;
                                                            case 1007101:
                                                                str3 = "\u83b7\u53d6\u6587\u4ef6\u5931\u8d25\uff0c\u8bf7\u91cd\u65b0\u4e0a\u4f20";
                                                                break;
                                                            case 1007201:
                                                            case 1007203:
                                                                str3 = "\u4e0a\u4f20\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                                                                break;
                                                            case 1007202:
                                                                str3 = "\u6587\u4ef6\u4e0a\u4f20\u8d85\u65f6\uff0c\u8bf7\u91cd\u65b0\u4e0a\u4f20";
                                                                break;
                                                            case 1008001:
                                                            case 2006028:
                                                                str3 = "\u6587\u4ef6\u4e0a\u4f20\u5931\u8d25\uff0c\u65e0\u6cd5\u4e0b\u8f7d";
                                                                break;
                                                            case RichErrorCode.KFILEIOFAILED /* 2006002 */:
                                                                str3 = "\u65e0\u6cd5\u6253\u5f00\u6587\u4ef6\uff0c\u8bf7\u68c0\u67e5\u6587\u4ef6\u72b6\u6001\u540e\u91cd\u65b0\u4e0a\u4f20";
                                                                break;
                                                            case RichErrorCode.KFILEINVALID /* 2006006 */:
                                                                str3 = "\u672c\u5730\u6587\u4ef6\u53d1\u751f\u6539\u53d8\uff0c\u8bf7\u91cd\u65b0\u4e0a\u4f20";
                                                                break;
                                                            case RichErrorCode.KSRVFILESECURITYSTRIKE /* 2006040 */:
                                                                str3 = "\u6587\u4ef6\u5df2\u5931\u6548\uff0c\u65e0\u6cd5\u4e0b\u8f7d";
                                                                break;
                                                            case RichErrorCode.KSRVREFUSEDDOWNLOADFILEBYPERSONLIMIT /* 2006048 */:
                                                            case 170018101:
                                                                str3 = "\u4e0b\u8f7d\u5931\u8d25\uff0c\u5f53\u524d\u4e0b\u8f7d\u4eba\u6570\u8fc7\u591a";
                                                                break;
                                                            case RichErrorCode.KSRVREFUSEDDOWNLOADFILEBYDOWNLOADLIMIT /* 2006049 */:
                                                            case 170018102:
                                                            case 170018103:
                                                            case 170018104:
                                                                str3 = "\u4e0b\u8f7d\u5931\u8d25\uff0c\u4f60\u7684\u4e0b\u8f7d\u6b21\u6570\u5df2\u8fbe\u4e0a\u9650";
                                                                break;
                                                        }
                                                        h color$default2 = QUIToken.color$default("text_secondary");
                                                        int a17 = companion5.a();
                                                        TextKt.a(str3, l3, null, color$default2, Float.valueOf(14.0f), null, companion6.e(), null, null, null, ai.f(a17), null, null, null, null, null, an.d(companion7.c()), null, 1, null, null, null, null, null, null, null, false, composer9, 1601600, 102236160, 0, 133888932);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer7, 24584, 14);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 196616, 30);
                                i s17 = ComposeLayoutPropUpdaterKt.s(bVar2.a(companion2, Alignment.CenterEnd), 0.0f, 0.0f, 16.0f, 0.0f, 11, null);
                                final QQFTFailedFileInfo qQFTFailedFileInfo4 = qQFTFailedFileInfo2;
                                final QQFlashTransferViewModel qQFlashTransferViewModel3 = qQFlashTransferViewModel2;
                                RowKt.a(s17, null, null, null, null, ComposableLambdaKt.composableLambda(composer5, 650318312, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatViewKt.failedListItem.1.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(n nVar, Composer composer6, Integer num3) {
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(650318312, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.failedListItem.<anonymous>.<anonymous>.<anonymous> (QQFTDownloadFailedFileListFloatView.kt:225)");
                                            }
                                            if (QQFTFailedFileInfo.this.getDownloadStatus() == 1) {
                                                composer7.startReplaceableGroup(-289733761);
                                                QUILoadingViewKt.QUILoadingView(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), false, null, LoadingIconType.GRAY, "", QUIToken.color$default("bg_middle_light"), null, composer7, 289800, 70);
                                                composer7.endReplaceableGroup();
                                            } else if (QQFTFailedFileInfo.this.getDownloadStatus() == 2) {
                                                composer7.startReplaceableGroup(-289733389);
                                                i c16 = ModifiersKt.c(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 12.0f), QUIToken.color$default("overlay_dark"));
                                                Alignment alignment = Alignment.Center;
                                                final QQFlashTransferViewModel qQFlashTransferViewModel4 = qQFlashTransferViewModel3;
                                                final QQFTFailedFileInfo qQFTFailedFileInfo5 = QQFTFailedFileInfo.this;
                                                BoxKt.a(c16, alignment, null, ComposableLambdaKt.composableLambda(composer7, -463473166, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatViewKt.failedListItem.1.1.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(b bVar3, Composer composer8, Integer num4) {
                                                        Composer composer9 = composer8;
                                                        int intValue4 = num4.intValue();
                                                        if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                            composer9.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-463473166, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.failedListItem.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTDownloadFailedFileListFloatView.kt:240)");
                                                            }
                                                            i u16 = ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f);
                                                            h color$default = QUIToken.color$default("icon_allwhite_primary");
                                                            h color$default2 = QUIToken.color$default("overlay_standard_primary");
                                                            Float f17 = QQFlashTransferViewModel.this.downloadProcessMap.get(qQFTFailedFileInfo5.failedFile.f446151b);
                                                            ProgressIndicatorKt.a(f17 != null ? f17.floatValue() : 0.0f, u16, color$default, color$default2, 2.0f, 0.0f, composer9, 29248, 32);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer7, 3128, 4);
                                                composer7.endReplaceableGroup();
                                            } else if (QQFTFailedFileInfo.this.getDownloadStatus() == 3) {
                                                composer7.startReplaceableGroup(-289732494);
                                                ImageKt.a(QUIToken.INSTANCE.image("tick", QUIToken.color$default("feedback_success")), null, null, null, null, ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, f16), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatViewKt.failedListItem.1.1.2.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                                        return Unit.INSTANCE;
                                                    }
                                                }, 3, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer7, 262144, 0, 0, 2097118);
                                                composer7.endReplaceableGroup();
                                            } else {
                                                composer7.startReplaceableGroup(-289732215);
                                                String image = QUIToken.INSTANCE.image("download", QUIToken.color$default("icon_primary"));
                                                i A = ModifiersKt.A(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, f16), 0.5f, 0.0f, 2, null);
                                                final QQFlashTransferViewModel qQFlashTransferViewModel5 = qQFlashTransferViewModel3;
                                                final QQFTFailedFileInfo qQFTFailedFileInfo6 = QQFTFailedFileInfo.this;
                                                ImageKt.a(image, null, null, null, null, ViewEventPropUpdaterKt.d(A, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatViewKt.failedListItem.1.1.2.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        ArrayList arrayListOf;
                                                        QQFlashTransferViewModel qQFlashTransferViewModel6 = QQFlashTransferViewModel.this;
                                                        ab abVar = qQFTFailedFileInfo6.failedFile;
                                                        String str = abVar.f446150a;
                                                        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(abVar);
                                                        cx cxVar = new cx() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatViewKt.failedListItem.1.1.2.3.1
                                                            @Override // ws3.cx
                                                            /* renamed from: onResult-jXDDuk8 */
                                                            public final void mo120onResultjXDDuk8(final int i19, final String str2, final int i26) {
                                                                SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatViewKt$failedListItem$1$1$2$3$1$onResult$1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Unit invoke() {
                                                                        KLog kLog = KLog.INSTANCE;
                                                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("startFileListDownLoad result=");
                                                                        m3.append(i19);
                                                                        m3.append(" errMsg=");
                                                                        m3.append(str2);
                                                                        m3.append(" extraInfo=");
                                                                        m3.append((Object) UInt.m615toStringimpl(i26));
                                                                        kLog.d("QQFTDownloadFailedFileListFloatView", m3.toString());
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                            }
                                                        };
                                                        QQFlashTransferViewModel.Companion companion3 = QQFlashTransferViewModel.Companion;
                                                        qQFlashTransferViewModel6.startFileListDownLoad(str, arrayListOf, cxVar, false);
                                                        return Unit.INSTANCE;
                                                    }
                                                }, 3, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer7, 262144, 0, 0, 2097118);
                                                composer7.endReplaceableGroup();
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 196616, 30);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3080, 6);
                    BoxKt.a(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), null, null, ComposableSingletons$QQFTDownloadFailedFileListFloatViewKt.f129lambda3, composer3, 3080, 6);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatViewKt$failedListItem$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTDownloadFailedFileListFloatViewKt.failedListItem(QQFTFailedFileInfo.this, qQFlashTransferViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void indicatorBar(Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-484007888);
        if (i3 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-484007888, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.indicatorBar (QQFTDownloadFailedFileListFloatView.kt:291)");
            }
            BoxKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 14.0f), QUIToken.color$default("bg_middle_light")), Alignment.Center, null, ComposableSingletons$QQFTDownloadFailedFileListFloatViewKt.f130lambda4, startRestartGroup, 3128, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailedFileListFloatViewKt$indicatorBar$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTDownloadFailedFileListFloatViewKt.indicatorBar(composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
