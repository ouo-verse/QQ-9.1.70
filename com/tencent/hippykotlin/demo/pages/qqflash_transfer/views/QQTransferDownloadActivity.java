package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import bp3.a;
import bp3.j;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModel;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogItem;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackViewKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.da_tong_report.DTReportConstKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt;
import com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQContext;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.MqqUi;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQCommonNApiModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.DeviceStateProcessInfo;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.FTFilterType;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFTFailedFileInfo;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFTFileListFilterInfo;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferCurFileSetInfo;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$addFileSetClusteringListListener$1;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$fetchCompressedFileFolder$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.module.QQFlashTransferKuiklyModule;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTAIClusterListCardVM;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTCompressTitleFilterCardVM;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFilterLayoutModeVM;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTPlaceHolderCardVM;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTTitleStatusCardVM;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.FooterRefreshState;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.mobileqq.activity.photo.MediaDBValues;
import com.tencent.mobileqq.flashtransfer.api.impl.FlashTransferHelperApiImpl;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.ntcompose.animation.m;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.k;
import com.tencent.ntcompose.foundation.layout.l;
import com.tencent.ntcompose.foundation.lazy.a;
import com.tencent.ntcompose.foundation.scheduler.SchedulerKt;
import com.tencent.ntcompose.material.AnimatedTransitionBoxKt;
import com.tencent.ntcompose.material.AnimatedTransitionType;
import com.tencent.ntcompose.material.GridLayoutMode;
import com.tencent.ntcompose.material.RichTextKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.r;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.tav.core.AssetExtension;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.UnsignedKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.apache.httpcore.message.TokenParser;
import ws3.Cdo;
import ws3.ab;
import ws3.ac;
import ws3.bo;
import ws3.bp;
import ws3.br;
import ws3.bs;
import ws3.bu;
import ws3.bv;
import ws3.bz;
import ws3.ca;
import ws3.cb;
import ws3.cc;
import ws3.ch;
import ws3.cr;
import ws3.cv;
import ws3.cw;
import ws3.cx;
import ws3.cy;
import ws3.da;
import ws3.dd;
import ws3.de;
import ws3.df;
import ws3.dh;
import ws3.di;
import ws3.dl;
import ws3.dp;
import ws3.dr;
import ws3.ds;
import ws3.ec;
import ws3.eg;
import ws3.eh;
import ws3.eu;
import ws3.v;
import ws3.w;
import ws3.x;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQTransferDownloadActivity extends QQFlashTransferBaseActivity {
    public static final /* synthetic */ int $r8$clinit = 0;
    public QQTransferDownloadActivity$addCompressedFileListener$1 compressedFileListener;
    public QQTransferDownloadActivity$addDeviceStatusListener$1 deviceStatusListener;
    public final MutableState<Boolean> didEntered;
    public QQTransferDownloadActivity$addFileSetDownloadListener$1 downloadListener;
    public String fileSetDeleteSuccessNotifyListener;
    public QQTransferDownloadActivity$addFolderListener$1 folderListener;
    public boolean isNetworkReachable;
    public int isOtherPageVisibleCnt;
    public MutableState<Boolean> isPageVisible;
    public int modalMode;
    public String otherPageAppearListener;
    public QQTransferDownloadActivity$addFileSetUploadListener$2 uploadInfoFileSetStatusListener;
    public QQTransferDownloadActivity$addFileSetUploadListener$1 uploadListener;
    public final QQFlashTransferViewModel viewModel = new QQFlashTransferViewModel();

    public QQTransferDownloadActivity() {
        MutableState<Boolean> mutableStateOf$default;
        MutableState<Boolean> mutableStateOf$default2;
        Boolean bool = Boolean.TRUE;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isPageVisible = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.didEntered = mutableStateOf$default2;
        this.isNetworkReachable = true;
    }

    public static final void access$QQFTContentView(final QQTransferDownloadActivity qQTransferDownloadActivity, final QQFlashTransferViewModel qQFlashTransferViewModel, final a aVar, Composer composer, final int i3) {
        qQTransferDownloadActivity.getClass();
        Composer startRestartGroup = composer.startRestartGroup(589176044);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(589176044, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.QQFTContentView (QQTransferDownloadActivity.kt:610)");
        }
        BoxKt.a(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 524381170, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$QQFTContentView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(524381170, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.QQFTContentView.<anonymous> (QQTransferDownloadActivity.kt:613)");
                    }
                    com.tencent.ntcompose.ui.platform.a aVar2 = (com.tencent.ntcompose.ui.platform.a) composer3.consume(CompositionLocalsKt.d());
                    ComposeFeedListViewModel composeFeedListViewModel = QQFlashTransferViewModel.this.feedListViewModel;
                    i f16 = ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, aVar2.e()), 0.0f, 1, null);
                    r.a aVar3 = new r.a(qQTransferDownloadActivity.viewModel.isImageGridMode() ? 5 : 3);
                    float e16 = aVar2.e();
                    float d16 = aVar2.d() * 2;
                    l c16 = k.c(qQTransferDownloadActivity.viewModel.isNormalGridMode() ? 4.0f : 0.0f, 0.0f, qQTransferDownloadActivity.viewModel.isNormalGridMode() ? 4.0f : 0.0f, QQFlashTransferViewModel.this.getLazyListBottomPadding(), 2, null);
                    GridLayoutMode gridLayoutMode = GridLayoutMode.PLAIN;
                    a aVar4 = aVar;
                    Boolean bool = Boolean.TRUE;
                    Float valueOf = Float.valueOf(d16);
                    final QQTransferDownloadActivity qQTransferDownloadActivity2 = qQTransferDownloadActivity;
                    final QQFlashTransferViewModel qQFlashTransferViewModel2 = QQFlashTransferViewModel.this;
                    Function1<ScrollParams, Unit> function1 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$QQFTContentView$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ScrollParams scrollParams) {
                            ScrollParams scrollParams2 = scrollParams;
                            QQTransferDownloadActivity.this.viewModel.isScrollOverTitle.setValue(Boolean.valueOf(scrollParams2.getOffsetY() > 55.0f));
                            QQTransferDownloadActivity.this.viewModel.isScrollOverFirstPage.setValue(Boolean.valueOf(scrollParams2.getOffsetY() > c.f117352a.g().getPageData().l() - qQFlashTransferViewModel2.getLazyListBottomPadding()));
                            return Unit.INSTANCE;
                        }
                    };
                    final QQTransferDownloadActivity qQTransferDownloadActivity3 = qQTransferDownloadActivity;
                    final a aVar5 = aVar;
                    Function1<ScrollParams, Unit> function12 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$QQFTContentView$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ScrollParams scrollParams) {
                            Object last;
                            if (QQTransferDownloadActivity.this.viewModel.isInSelectFileScrollAnim.getValue().booleanValue()) {
                                QQTransferDownloadActivity.this.viewModel.isInSelectFileScrollAnim.setValue(Boolean.FALSE);
                                if (QQTransferDownloadActivity.this.viewModel.selectFilesToDownload.size() <= 0) {
                                    last = CollectionsKt___CollectionsKt.last((List<? extends Object>) QQTransferDownloadActivity.this.viewModel.feedListViewModel.feedCardViewModelList);
                                    if (last instanceof QQFTPlaceHolderCardVM) {
                                        CollectionsKt__MutableCollectionsKt.removeLast(QQTransferDownloadActivity.this.viewModel.feedListViewModel.feedCardViewModelList);
                                    }
                                } else {
                                    aVar5.u(Float.valueOf(QQTransferDownloadActivity.this.viewModel.getSelectScrollOffset()));
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    final QQTransferDownloadActivity qQTransferDownloadActivity4 = qQTransferDownloadActivity;
                    Function2<Float, Float, Unit> function2 = new Function2<Float, Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$QQFTContentView$1.3
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(Float f17, Float f18) {
                            f17.floatValue();
                            QQTransferDownloadActivity.this.viewModel.pageListHeight = f18.floatValue();
                            return Unit.INSTANCE;
                        }
                    };
                    final QQTransferDownloadActivity qQTransferDownloadActivity5 = qQTransferDownloadActivity;
                    composeFeedListViewModel.buildLazyVerticalGrid(aVar3, f16, e16, aVar4, c16, 1.0f, 1.0f, null, null, null, bool, null, gridLayoutMode, 10, valueOf, function1, function12, null, null, function2, ComposableLambdaKt.composableLambda(composer3, 1127318398, true, new Function3<FooterRefreshState, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$QQFTContentView$1.4
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(FooterRefreshState footerRefreshState, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1127318398, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.QQFTContentView.<anonymous>.<anonymous> (QQTransferDownloadActivity.kt:646)");
                                }
                                if (QQTransferDownloadActivity.this.viewModel.footerRefreshState.getValue() != FooterRefreshState.IDLE) {
                                    QQFTFooterRefreshViewKt.QQFTFooterRefreshView(QQTransferDownloadActivity.this.viewModel, composer5, 8);
                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 50.0f), composer5, 8, 0);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, ((i3 << 6) & 7168) | 1769536, 3462, 70, 396160);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$QQFTContentView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQTransferDownloadActivity.access$QQFTContentView(QQTransferDownloadActivity.this, qQFlashTransferViewModel, aVar, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$alertDialogForDeviceStatus(final QQTransferDownloadActivity qQTransferDownloadActivity, final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        qQTransferDownloadActivity.getClass();
        Composer startRestartGroup = composer.startRestartGroup(854954352);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(854954352, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.alertDialogForDeviceStatus (QQTransferDownloadActivity.kt:1413)");
        }
        QUIAlertDialogKt.QUIAlertDialog(qQFlashTransferViewModel.deviceStateProcessInfo.showAlertDialog.getValue().booleanValue(), null, qQFlashTransferViewModel.deviceStateProcessInfo.notice, null, new QUIAlertDialogItem[]{QUIAlertDialogKt.QUIAlertDialogNormalTextItem("\u6211\u77e5\u9053\u4e86", new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$alertDialogForDeviceStatus$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                QQFlashTransferViewModel.this.deviceStateProcessInfo.showAlertDialog.setValue(Boolean.FALSE);
                cx cxVar = QQFlashTransferViewModel.this.deviceStateProcessInfo.callback;
                if (cxVar != null) {
                    cxVar.mo120onResultjXDDuk8(-1, "CANCEL_DOWNLOAD_BY_IN_SUFFICIENT_STORAGE", 0);
                }
                DeviceStateProcessInfo deviceStateProcessInfo = QQFlashTransferViewModel.this.deviceStateProcessInfo;
                deviceStateProcessInfo.fileSetId = "";
                deviceStateProcessInfo.files = null;
                deviceStateProcessInfo.callback = null;
                deviceStateProcessInfo.notice = "";
                return Unit.INSTANCE;
            }
        })}, null, null, startRestartGroup, 32768, 106);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$alertDialogForDeviceStatus$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQTransferDownloadActivity.access$alertDialogForDeviceStatus(QQTransferDownloadActivity.this, qQFlashTransferViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$askDialogForDeviceStatus(final QQTransferDownloadActivity qQTransferDownloadActivity, final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        qQTransferDownloadActivity.getClass();
        Composer startRestartGroup = composer.startRestartGroup(-1458940941);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1458940941, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.askDialogForDeviceStatus (QQTransferDownloadActivity.kt:1386)");
        }
        QUIAlertDialogKt.QUIAlertDialog(qQFlashTransferViewModel.deviceStateProcessInfo.showAskDialog.getValue().booleanValue(), null, qQFlashTransferViewModel.deviceStateProcessInfo.notice, null, new QUIAlertDialogItem[]{QUIAlertDialogKt.QUIAlertDialogNormalTextItem("\u5426", new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$askDialogForDeviceStatus$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                QQFlashTransferViewModel.this.deviceStateProcessInfo.showAskDialog.setValue(Boolean.FALSE);
                cx cxVar = QQFlashTransferViewModel.this.deviceStateProcessInfo.callback;
                if (cxVar != null) {
                    cxVar.mo120onResultjXDDuk8(-1, "CANCEL_DOWNLOAD_BY_CELLULAR_NETWORK", 0);
                }
                DeviceStateProcessInfo deviceStateProcessInfo = QQFlashTransferViewModel.this.deviceStateProcessInfo;
                deviceStateProcessInfo.fileSetId = "";
                deviceStateProcessInfo.files = null;
                deviceStateProcessInfo.callback = null;
                deviceStateProcessInfo.notice = "";
                return Unit.INSTANCE;
            }
        }), QUIAlertDialogKt.QUIAlertDialogNormalTextItem("\u662f", new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$askDialogForDeviceStatus$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                QQFlashTransferViewModel.this.deviceStateProcessInfo.showAskDialog.setValue(Boolean.FALSE);
                QQFlashTransferViewModel qQFlashTransferViewModel2 = QQFlashTransferViewModel.this;
                DeviceStateProcessInfo deviceStateProcessInfo = qQFlashTransferViewModel2.deviceStateProcessInfo;
                String str = deviceStateProcessInfo.fileSetId;
                boolean z16 = deviceStateProcessInfo.needDownloadAllFiles;
                List<ab> list = deviceStateProcessInfo.files;
                if (list == null) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                cx cxVar = qQFlashTransferViewModel2.deviceStateProcessInfo.callback;
                if (cxVar == null) {
                    cxVar = new cx() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$restartDownloadInXGNetwork$1
                        @Override // ws3.cx
                        /* renamed from: onResult-jXDDuk8 */
                        public final void mo120onResultjXDDuk8(int i16, String str2, int i17) {
                        }
                    };
                }
                qQFlashTransferViewModel2.internalStartDownloadFileList(str, z16, list, cxVar);
                DeviceStateProcessInfo deviceStateProcessInfo2 = QQFlashTransferViewModel.this.deviceStateProcessInfo;
                deviceStateProcessInfo2.fileSetId = "";
                deviceStateProcessInfo2.files = null;
                deviceStateProcessInfo2.callback = null;
                deviceStateProcessInfo2.notice = "";
                return Unit.INSTANCE;
            }
        })}, null, null, startRestartGroup, 32768, 106);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$askDialogForDeviceStatus$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQTransferDownloadActivity.access$askDialogForDeviceStatus(QQTransferDownloadActivity.this, qQFlashTransferViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$body(final QQTransferDownloadActivity qQTransferDownloadActivity, final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        qQTransferDownloadActivity.getClass();
        Composer startRestartGroup = composer.startRestartGroup(-258838875);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-258838875, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body (QQTransferDownloadActivity.kt:490)");
        }
        qQFlashTransferViewModel.listState = com.tencent.ntcompose.foundation.lazy.b.a(0, 0.0f, startRestartGroup, 0, 3);
        BoxKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, qQTransferDownloadActivity.isPageVisible.getValue().booleanValue() ? 0.0f : 1.0f, 7, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1390851295, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                Object obj;
                String str;
                e dTBaseParams;
                int i16;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1390851295, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.<anonymous> (QQTransferDownloadActivity.kt:494)");
                    }
                    i iVar = i.INSTANCE;
                    i d16 = ModifiersKt.d(ComposeLayoutPropUpdaterKt.h(iVar, 0.0f, 1, null), QUIToken.color$default("bg_bottom_light"));
                    if ((!QQFlashTransferViewModel.this.categoryInfos.isEmpty()) || QQFlashTransferViewModel.this.fileSet.getValue() != null) {
                        QQFlashTransferViewModel qQFlashTransferViewModel2 = QQFlashTransferViewModel.this;
                        br value = qQFlashTransferViewModel2.fileSet.getValue();
                        if (value == null) {
                            dTBaseParams = null;
                        } else {
                            String str2 = "3";
                            if (value.f446199m == 1 && value.f446200n) {
                                obj = "1";
                            } else {
                                if (!(!value.f446192f.isEmpty() && value.f446199m == 1)) {
                                    obj = "3";
                                } else {
                                    obj = "2";
                                }
                            }
                            if (qQFlashTransferViewModel2.isImageGridMode()) {
                                str2 = "2";
                            } else if (qQFlashTransferViewModel2.isGridMode.getValue().booleanValue()) {
                                str2 = "1";
                            }
                            e eVar = new e();
                            Iterator<QQFTFileListFilterInfo> it = qQFlashTransferViewModel2.categoryInfos.iterator();
                            while (it.hasNext()) {
                                ac acVar = it.next().categoryInfo;
                                eVar.v(acVar.f446178c, UInt.m615toStringimpl(acVar.f446177b));
                            }
                            String eVar2 = eVar.toString();
                            if (defpackage.k.a(c.f117352a)) {
                                str = "0S200MNJT807V3GE";
                            } else {
                                str = "0M2003OIIM08YV9M";
                            }
                            dTBaseParams = DTReportConstKt.getDTBaseParams(str);
                            if (qQFlashTransferViewModel2.compressedFileFolderId.length() > 0) {
                                i16 = 3;
                            } else {
                                if (qQFlashTransferViewModel2.parentId.getValue().length() > 0) {
                                    i16 = 2;
                                } else {
                                    i16 = qQFlashTransferViewModel2.clusterId.length() > 0 ? 4 : 1;
                                }
                            }
                            dTBaseParams.v("page_model", String.valueOf(i16));
                            dTBaseParams.v("entry_id", qQFlashTransferViewModel2.entryId);
                            dTBaseParams.v("user_identity", obj);
                            dTBaseParams.v(MediaDBValues.FILESIZE, ULong.m693toStringimpl(value.f446190d));
                            dTBaseParams.v("files_number", ULong.m693toStringimpl(value.f446189c));
                            dTBaseParams.v("entries_number", ULong.m693toStringimpl(qQFlashTransferViewModel2.m116getCurPageFirstLevelItemCountsVKNKU()));
                            dTBaseParams.v("Default_view", str2);
                            dTBaseParams.v("each_document_quantity", eVar2);
                            dTBaseParams.v("sceneType", String.valueOf(qQFlashTransferViewModel2.sceneType));
                        }
                        iVar = ModifierExtKt.pageVR(iVar, "pg_bas_flash_details", dTBaseParams);
                    }
                    i b16 = d16.b(iVar);
                    final QQFlashTransferViewModel qQFlashTransferViewModel3 = QQFlashTransferViewModel.this;
                    final QQTransferDownloadActivity qQTransferDownloadActivity2 = qQTransferDownloadActivity;
                    ColumnKt.a(b16, null, null, null, ComposableLambdaKt.composableLambda(composer3, -1844592760, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$body$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:59:0x01a2, code lost:
                        
                            if (r1.hasSendEntrance != false) goto L90;
                         */
                        /* JADX WARN: Removed duplicated region for block: B:27:0x00e9  */
                        /* JADX WARN: Removed duplicated region for block: B:29:0x00ee  */
                        /* JADX WARN: Removed duplicated region for block: B:32:0x0105  */
                        /* JADX WARN: Removed duplicated region for block: B:35:0x0116  */
                        /* JADX WARN: Removed duplicated region for block: B:38:0x0144  */
                        /* JADX WARN: Removed duplicated region for block: B:41:0x015a  */
                        /* JADX WARN: Removed duplicated region for block: B:50:0x0187  */
                        /* JADX WARN: Removed duplicated region for block: B:58:0x01a0  */
                        /* JADX WARN: Removed duplicated region for block: B:61:0x01a7  */
                        /* JADX WARN: Removed duplicated region for block: B:64:0x0230  */
                        /* JADX WARN: Removed duplicated region for block: B:65:0x01aa  */
                        /* JADX WARN: Removed duplicated region for block: B:69:0x014a  */
                        /* JADX WARN: Removed duplicated region for block: B:70:0x0124  */
                        /* JADX WARN: Removed duplicated region for block: B:71:0x010b  */
                        /* JADX WARN: Removed duplicated region for block: B:72:0x00fb  */
                        /* JADX WARN: Removed duplicated region for block: B:73:0x00eb  */
                        @Override // kotlin.jvm.functions.Function3
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                            h color$default;
                            String str3;
                            String image;
                            QQFlashTransferViewModel qQFlashTransferViewModel4;
                            br value2;
                            String str4;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1844592760, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.<anonymous>.<anonymous> (QQTransferDownloadActivity.kt:504)");
                                }
                                if (QQFlashTransferViewModel.this.isCompressFirstLevelPage()) {
                                    color$default = QUIToken.color$default("bg_bottom_standard");
                                } else {
                                    color$default = QUIToken.color$default("bg_nav_secondary");
                                }
                                h hVar = color$default;
                                boolean z16 = false;
                                if (!QQFlashTransferViewModel.this.isCompressFirstLevelPage() && !QQFlashTransferViewModel.this.isInSelectFileScrollAnim.getValue().booleanValue()) {
                                    if (!QQFlashTransferViewModel.this.isSecondaryPage() || !QQFlashTransferViewModel.this.isScrollOverTitle.getValue().booleanValue()) {
                                        if (!(QQFlashTransferViewModel.this.clusterId.length() > 0) && !QQFlashTransferViewModel.this.isCompressFolderPage()) {
                                            br value3 = QQFlashTransferViewModel.this.fileSet.getValue();
                                            if ((value3 != null ? value3.f446188b : null) != null && QQFlashTransferViewModel.this.isScrollOverTitle.getValue().booleanValue()) {
                                                br value4 = QQFlashTransferViewModel.this.fileSet.getValue();
                                                str4 = value4 != null ? value4.f446188b : null;
                                                Intrinsics.checkNotNull(str4);
                                                str3 = str4;
                                                String value5 = QQFlashTransferViewModel.this.clusterId.length() > 0 ? QQFlashTransferViewModel.this.curFaceUrl.getValue() : null;
                                                String str5 = QQFlashTransferViewModel.this.canShowAllSelectCheckBox() ? "\u5168\u9009" : null;
                                                if (qQTransferDownloadActivity2.modalMode == 1) {
                                                    image = QUIToken.INSTANCE.image("close", QUIToken.color$default("icon_primary"));
                                                } else {
                                                    image = QUIToken.INSTANCE.image("chevron_left", QUIToken.color$default("icon_nav_secondary"));
                                                }
                                                String str6 = image;
                                                int i17 = qQTransferDownloadActivity2.modalMode;
                                                String str7 = QQFlashTransferViewModel.this.selectFilesToDownload.size() > 0 ? "\u53d6\u6d88" : null;
                                                boolean canShowAllSelectCheckBox = QQFlashTransferViewModel.this.canShowAllSelectCheckBox();
                                                boolean z17 = QQFlashTransferViewModel.this.isCompressFirstLevelPage() && (QQFlashTransferViewModel.this.isScrollOverTitle.getValue().booleanValue() || QQFlashTransferViewModel.this.selectFilesToDownload.size() > 0 || QQFlashTransferViewModel.this.isCompressFolderPage());
                                                qQFlashTransferViewModel4 = QQFlashTransferViewModel.this;
                                                if (!qQFlashTransferViewModel4.isFileSetInvalid() && !qQFlashTransferViewModel4.isSecondaryPage()) {
                                                    value2 = qQFlashTransferViewModel4.fileSet.getValue();
                                                    if (value2 == null && value2.f446199m == 1) {
                                                    }
                                                }
                                                z16 = true;
                                                String image2 = z16 ? null : QUIToken.INSTANCE.image("more", QUIToken.color$default("icon_primary"));
                                                QQFlashTransferViewModel qQFlashTransferViewModel5 = QQFlashTransferViewModel.this;
                                                Integer valueOf = Integer.valueOf(i17);
                                                final QQFlashTransferViewModel qQFlashTransferViewModel6 = QQFlashTransferViewModel.this;
                                                Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.1.1.1
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        QQFlashTransferViewModel.this.beforeUpdateFileContentOffset();
                                                        int size = QQFlashTransferViewModel.this.selectFilesToDownload.size();
                                                        QQFlashTransferViewModel qQFlashTransferViewModel7 = QQFlashTransferViewModel.this;
                                                        qQFlashTransferViewModel7.getClass();
                                                        KLog kLog = KLog.INSTANCE;
                                                        kLog.d("QQFTFilterLayoutModeView", "checkbox selectAll");
                                                        if (!qQFlashTransferViewModel7.isAllSelectMode.getValue().booleanValue()) {
                                                            if (!qQFlashTransferViewModel7.hasLoadAll.getValue().booleanValue()) {
                                                                MutableState<Boolean> mutableState = qQFlashTransferViewModel7.hasTapSelectAll;
                                                                Boolean bool = Boolean.TRUE;
                                                                mutableState.setValue(bool);
                                                                qQFlashTransferViewModel7.showLoadingAllList.setValue(bool);
                                                                qQFlashTransferViewModel7.updateAllItem(true);
                                                                qQFlashTransferViewModel7.fetchPageFileList(true, null);
                                                                kLog.d("QQFTFilterLayoutModeView", "wait to load all");
                                                            } else {
                                                                kLog.d("QQFTFilterLayoutModeView", "selectAll");
                                                                qQFlashTransferViewModel7.updateAllItem(true);
                                                            }
                                                        } else {
                                                            kLog.d("QQFTFilterLayoutModeView", "checkbox deselect all");
                                                            qQFlashTransferViewModel7.updateAllItem(false);
                                                            qQFlashTransferViewModel7.hasTapSelectAll.setValue(Boolean.FALSE);
                                                        }
                                                        QQFlashTransferViewModel.this.updateFileContentOffset(size);
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                final QQTransferDownloadActivity qQTransferDownloadActivity3 = qQTransferDownloadActivity2;
                                                Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.1.1.2
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        QQTransferDownloadActivity qQTransferDownloadActivity4 = QQTransferDownloadActivity.this;
                                                        int i18 = QQTransferDownloadActivity.$r8$clinit;
                                                        qQTransferDownloadActivity4.closePage();
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                final QQFlashTransferViewModel qQFlashTransferViewModel7 = QQFlashTransferViewModel.this;
                                                Function0<Unit> function03 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.1.1.3
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        QQFlashTransferViewModel.this.hasTapSelectAll.setValue(Boolean.FALSE);
                                                        int size = QQFlashTransferViewModel.this.selectFilesToDownload.size();
                                                        QQFlashTransferViewModel.this.updateAllItem(false);
                                                        QQFlashTransferViewModel.this.updateFileContentOffset(size);
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                final QQFlashTransferViewModel qQFlashTransferViewModel8 = QQFlashTransferViewModel.this;
                                                QQFTNavBarKt.QQFTNavBar(qQFlashTransferViewModel5, hVar, str6, str7, valueOf, str3, value5, image2, str5, function0, function02, function03, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.1.1.4
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        br value6 = QQFlashTransferViewModel.this.fileSet.getValue();
                                                        if (value6 != null) {
                                                            QQFlashTransferKuiklyModule.Companion.getInstance().shareFileSet(value6, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$body$1$1$4$1$1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final /* bridge */ /* synthetic */ Unit invoke(e eVar3) {
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }, Boolean.valueOf(canShowAllSelectCheckBox), Boolean.valueOf(z17), 0.0f, composer5, 72, 196608, 0);
                                                QQFTDownloadFailBannerBarKt.QQFTDownloadFailBannerBar(QQFlashTransferViewModel.this, composer5, 8);
                                                i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                                                final QQTransferDownloadActivity qQTransferDownloadActivity4 = qQTransferDownloadActivity2;
                                                final QQFlashTransferViewModel qQFlashTransferViewModel9 = QQFlashTransferViewModel.this;
                                                BoxKt.a(h16, null, null, ComposableLambdaKt.composableLambda(composer5, -1596905662, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.1.1.5
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(b bVar2, Composer composer6, Integer num3) {
                                                        Composer composer7 = composer6;
                                                        int intValue3 = num3.intValue();
                                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                            composer7.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1596905662, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.<anonymous>.<anonymous>.<anonymous> (QQTransferDownloadActivity.kt:553)");
                                                            }
                                                            QQTransferDownloadActivity qQTransferDownloadActivity5 = QQTransferDownloadActivity.this;
                                                            QQFlashTransferViewModel qQFlashTransferViewModel10 = qQFlashTransferViewModel9;
                                                            QQTransferDownloadActivity.access$QQFTContentView(qQTransferDownloadActivity5, qQFlashTransferViewModel10, qQFlashTransferViewModel10.getListState(), composer7, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_REQUEST);
                                                            QQFTDownloadBarViewKt.QQFTDownloadBarView(qQFlashTransferViewModel9, composer7, 8);
                                                            if (qQFlashTransferViewModel9.isScrollOverFirstPage.getValue().booleanValue()) {
                                                                i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, qQFlashTransferViewModel9.isBottomBarShow() ? 100.0f : 0.0f, 7, null);
                                                                final QQFlashTransferViewModel qQFlashTransferViewModel11 = qQFlashTransferViewModel9;
                                                                BoxKt.a(n3, null, null, ComposableLambdaKt.composableLambda(composer7, -1078403391, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.1.1.5.1
                                                                    {
                                                                        super(3);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function3
                                                                    public final Unit invoke(b bVar3, Composer composer8, Integer num4) {
                                                                        int i18;
                                                                        b bVar4 = bVar3;
                                                                        Composer composer9 = composer8;
                                                                        int intValue4 = num4.intValue();
                                                                        if ((intValue4 & 14) == 0) {
                                                                            i18 = (composer9.changed(bVar4) ? 4 : 2) | intValue4;
                                                                        } else {
                                                                            i18 = intValue4;
                                                                        }
                                                                        if ((i18 & 91) == 18 && composer9.getSkipping()) {
                                                                            composer9.skipToGroupEnd();
                                                                        } else {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(-1078403391, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQTransferDownloadActivity.kt:559)");
                                                                            }
                                                                            i a16 = bVar4.a(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 72.0f), Alignment.BottomEnd);
                                                                            final QQFlashTransferViewModel qQFlashTransferViewModel12 = QQFlashTransferViewModel.this;
                                                                            BoxKt.a(a16, null, null, ComposableLambdaKt.composableLambda(composer9, 996924155, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.1.1.5.1.1
                                                                                {
                                                                                    super(3);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function3
                                                                                public final Unit invoke(b bVar5, Composer composer10, Integer num5) {
                                                                                    int i19;
                                                                                    b bVar6 = bVar5;
                                                                                    Composer composer11 = composer10;
                                                                                    int intValue5 = num5.intValue();
                                                                                    if ((intValue5 & 14) == 0) {
                                                                                        i19 = (composer11.changed(bVar6) ? 4 : 2) | intValue5;
                                                                                    } else {
                                                                                        i19 = intValue5;
                                                                                    }
                                                                                    if ((i19 & 91) == 18 && composer11.getSkipping()) {
                                                                                        composer11.skipToGroupEnd();
                                                                                    } else {
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventStart(996924155, intValue5, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQTransferDownloadActivity.kt:562)");
                                                                                        }
                                                                                        i L = ModifiersKt.L(bVar6.a(ModifiersKt.q(ModifiersKt.A(ModifiersKt.c(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 48.0f), QUIToken.color$default("bg_bottom_light")), 0.5f, 0.0f, 2, null), uo3.c.b()), Alignment.TopStart), 2.0f, 8.0f, 14.0f, QUIToken.color$default("fill_standard_quaternary"));
                                                                                        final QQFlashTransferViewModel qQFlashTransferViewModel13 = QQFlashTransferViewModel.this;
                                                                                        BoxKt.a(ViewEventPropUpdaterKt.d(L, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.1.1.5.1.1.1
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                                com.tencent.ntcompose.foundation.lazy.d.x(QQFlashTransferViewModel.this.getListState(), 0, 0.0f, true, null, 8, null);
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        }, 3, null), Alignment.Center, null, ComposableSingletons$QQTransferDownloadActivityKt.f148lambda2, composer11, 3128, 4);
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventEnd();
                                                                                        }
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            }), composer9, 3080, 6);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                            }
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }), composer7, 3080, 6);
                                                            }
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
                                        }
                                    }
                                    str4 = QQFlashTransferViewModel.this.pageTitle.getValue();
                                    str3 = str4;
                                    if (QQFlashTransferViewModel.this.clusterId.length() > 0) {
                                    }
                                    if (QQFlashTransferViewModel.this.canShowAllSelectCheckBox()) {
                                    }
                                    if (qQTransferDownloadActivity2.modalMode == 1) {
                                    }
                                    String str62 = image;
                                    int i172 = qQTransferDownloadActivity2.modalMode;
                                    if (QQFlashTransferViewModel.this.selectFilesToDownload.size() > 0) {
                                    }
                                    boolean canShowAllSelectCheckBox2 = QQFlashTransferViewModel.this.canShowAllSelectCheckBox();
                                    if (QQFlashTransferViewModel.this.isCompressFirstLevelPage()) {
                                    }
                                    qQFlashTransferViewModel4 = QQFlashTransferViewModel.this;
                                    if (!qQFlashTransferViewModel4.isFileSetInvalid()) {
                                        value2 = qQFlashTransferViewModel4.fileSet.getValue();
                                        if (value2 == null && value2.f446199m == 1) {
                                        }
                                    }
                                    z16 = true;
                                    if (z16) {
                                    }
                                    QQFlashTransferViewModel qQFlashTransferViewModel52 = QQFlashTransferViewModel.this;
                                    Integer valueOf2 = Integer.valueOf(i172);
                                    final QQFlashTransferViewModel qQFlashTransferViewModel62 = QQFlashTransferViewModel.this;
                                    Function0<Unit> function04 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.1.1.1
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            QQFlashTransferViewModel.this.beforeUpdateFileContentOffset();
                                            int size = QQFlashTransferViewModel.this.selectFilesToDownload.size();
                                            QQFlashTransferViewModel qQFlashTransferViewModel72 = QQFlashTransferViewModel.this;
                                            qQFlashTransferViewModel72.getClass();
                                            KLog kLog = KLog.INSTANCE;
                                            kLog.d("QQFTFilterLayoutModeView", "checkbox selectAll");
                                            if (!qQFlashTransferViewModel72.isAllSelectMode.getValue().booleanValue()) {
                                                if (!qQFlashTransferViewModel72.hasLoadAll.getValue().booleanValue()) {
                                                    MutableState<Boolean> mutableState = qQFlashTransferViewModel72.hasTapSelectAll;
                                                    Boolean bool = Boolean.TRUE;
                                                    mutableState.setValue(bool);
                                                    qQFlashTransferViewModel72.showLoadingAllList.setValue(bool);
                                                    qQFlashTransferViewModel72.updateAllItem(true);
                                                    qQFlashTransferViewModel72.fetchPageFileList(true, null);
                                                    kLog.d("QQFTFilterLayoutModeView", "wait to load all");
                                                } else {
                                                    kLog.d("QQFTFilterLayoutModeView", "selectAll");
                                                    qQFlashTransferViewModel72.updateAllItem(true);
                                                }
                                            } else {
                                                kLog.d("QQFTFilterLayoutModeView", "checkbox deselect all");
                                                qQFlashTransferViewModel72.updateAllItem(false);
                                                qQFlashTransferViewModel72.hasTapSelectAll.setValue(Boolean.FALSE);
                                            }
                                            QQFlashTransferViewModel.this.updateFileContentOffset(size);
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    final QQTransferDownloadActivity qQTransferDownloadActivity32 = qQTransferDownloadActivity2;
                                    Function0<Unit> function022 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.1.1.2
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            QQTransferDownloadActivity qQTransferDownloadActivity42 = QQTransferDownloadActivity.this;
                                            int i18 = QQTransferDownloadActivity.$r8$clinit;
                                            qQTransferDownloadActivity42.closePage();
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    final QQFlashTransferViewModel qQFlashTransferViewModel72 = QQFlashTransferViewModel.this;
                                    Function0<Unit> function032 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.1.1.3
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            QQFlashTransferViewModel.this.hasTapSelectAll.setValue(Boolean.FALSE);
                                            int size = QQFlashTransferViewModel.this.selectFilesToDownload.size();
                                            QQFlashTransferViewModel.this.updateAllItem(false);
                                            QQFlashTransferViewModel.this.updateFileContentOffset(size);
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    final QQFlashTransferViewModel qQFlashTransferViewModel82 = QQFlashTransferViewModel.this;
                                    QQFTNavBarKt.QQFTNavBar(qQFlashTransferViewModel52, hVar, str62, str7, valueOf2, str3, value5, image2, str5, function04, function022, function032, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.1.1.4
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            br value6 = QQFlashTransferViewModel.this.fileSet.getValue();
                                            if (value6 != null) {
                                                QQFlashTransferKuiklyModule.Companion.getInstance().shareFileSet(value6, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$body$1$1$4$1$1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final /* bridge */ /* synthetic */ Unit invoke(e eVar3) {
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }, Boolean.valueOf(canShowAllSelectCheckBox2), Boolean.valueOf(z17), 0.0f, composer5, 72, 196608, 0);
                                    QQFTDownloadFailBannerBarKt.QQFTDownloadFailBannerBar(QQFlashTransferViewModel.this, composer5, 8);
                                    i h162 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                                    final QQTransferDownloadActivity qQTransferDownloadActivity42 = qQTransferDownloadActivity2;
                                    final QQFlashTransferViewModel qQFlashTransferViewModel92 = QQFlashTransferViewModel.this;
                                    BoxKt.a(h162, null, null, ComposableLambdaKt.composableLambda(composer5, -1596905662, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.1.1.5
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(b bVar2, Composer composer6, Integer num3) {
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1596905662, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.<anonymous>.<anonymous>.<anonymous> (QQTransferDownloadActivity.kt:553)");
                                                }
                                                QQTransferDownloadActivity qQTransferDownloadActivity5 = QQTransferDownloadActivity.this;
                                                QQFlashTransferViewModel qQFlashTransferViewModel10 = qQFlashTransferViewModel92;
                                                QQTransferDownloadActivity.access$QQFTContentView(qQTransferDownloadActivity5, qQFlashTransferViewModel10, qQFlashTransferViewModel10.getListState(), composer7, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_REQUEST);
                                                QQFTDownloadBarViewKt.QQFTDownloadBarView(qQFlashTransferViewModel92, composer7, 8);
                                                if (qQFlashTransferViewModel92.isScrollOverFirstPage.getValue().booleanValue()) {
                                                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, qQFlashTransferViewModel92.isBottomBarShow() ? 100.0f : 0.0f, 7, null);
                                                    final QQFlashTransferViewModel qQFlashTransferViewModel11 = qQFlashTransferViewModel92;
                                                    BoxKt.a(n3, null, null, ComposableLambdaKt.composableLambda(composer7, -1078403391, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.1.1.5.1
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(b bVar3, Composer composer8, Integer num4) {
                                                            int i18;
                                                            b bVar4 = bVar3;
                                                            Composer composer9 = composer8;
                                                            int intValue4 = num4.intValue();
                                                            if ((intValue4 & 14) == 0) {
                                                                i18 = (composer9.changed(bVar4) ? 4 : 2) | intValue4;
                                                            } else {
                                                                i18 = intValue4;
                                                            }
                                                            if ((i18 & 91) == 18 && composer9.getSkipping()) {
                                                                composer9.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-1078403391, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQTransferDownloadActivity.kt:559)");
                                                                }
                                                                i a16 = bVar4.a(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 72.0f), Alignment.BottomEnd);
                                                                final QQFlashTransferViewModel qQFlashTransferViewModel12 = QQFlashTransferViewModel.this;
                                                                BoxKt.a(a16, null, null, ComposableLambdaKt.composableLambda(composer9, 996924155, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.1.1.5.1.1
                                                                    {
                                                                        super(3);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function3
                                                                    public final Unit invoke(b bVar5, Composer composer10, Integer num5) {
                                                                        int i19;
                                                                        b bVar6 = bVar5;
                                                                        Composer composer11 = composer10;
                                                                        int intValue5 = num5.intValue();
                                                                        if ((intValue5 & 14) == 0) {
                                                                            i19 = (composer11.changed(bVar6) ? 4 : 2) | intValue5;
                                                                        } else {
                                                                            i19 = intValue5;
                                                                        }
                                                                        if ((i19 & 91) == 18 && composer11.getSkipping()) {
                                                                            composer11.skipToGroupEnd();
                                                                        } else {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(996924155, intValue5, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQTransferDownloadActivity.kt:562)");
                                                                            }
                                                                            i L = ModifiersKt.L(bVar6.a(ModifiersKt.q(ModifiersKt.A(ModifiersKt.c(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 48.0f), QUIToken.color$default("bg_bottom_light")), 0.5f, 0.0f, 2, null), uo3.c.b()), Alignment.TopStart), 2.0f, 8.0f, 14.0f, QUIToken.color$default("fill_standard_quaternary"));
                                                                            final QQFlashTransferViewModel qQFlashTransferViewModel13 = QQFlashTransferViewModel.this;
                                                                            BoxKt.a(ViewEventPropUpdaterKt.d(L, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.1.1.5.1.1.1
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ClickParams clickParams) {
                                                                                    com.tencent.ntcompose.foundation.lazy.d.x(QQFlashTransferViewModel.this.getListState(), 0, 0.0f, true, null, 8, null);
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            }, 3, null), Alignment.Center, null, ComposableSingletons$QQTransferDownloadActivityKt.f148lambda2, composer11, 3128, 4);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                            }
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }), composer9, 3080, 6);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer7, 3080, 6);
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 3080, 6);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                }
                                str3 = "";
                                if (QQFlashTransferViewModel.this.clusterId.length() > 0) {
                                }
                                if (QQFlashTransferViewModel.this.canShowAllSelectCheckBox()) {
                                }
                                if (qQTransferDownloadActivity2.modalMode == 1) {
                                }
                                String str622 = image;
                                int i1722 = qQTransferDownloadActivity2.modalMode;
                                if (QQFlashTransferViewModel.this.selectFilesToDownload.size() > 0) {
                                }
                                boolean canShowAllSelectCheckBox22 = QQFlashTransferViewModel.this.canShowAllSelectCheckBox();
                                if (QQFlashTransferViewModel.this.isCompressFirstLevelPage()) {
                                }
                                qQFlashTransferViewModel4 = QQFlashTransferViewModel.this;
                                if (!qQFlashTransferViewModel4.isFileSetInvalid()) {
                                }
                                z16 = true;
                                if (z16) {
                                }
                                QQFlashTransferViewModel qQFlashTransferViewModel522 = QQFlashTransferViewModel.this;
                                Integer valueOf22 = Integer.valueOf(i1722);
                                final QQFlashTransferViewModel qQFlashTransferViewModel622 = QQFlashTransferViewModel.this;
                                Function0<Unit> function042 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.1.1.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        QQFlashTransferViewModel.this.beforeUpdateFileContentOffset();
                                        int size = QQFlashTransferViewModel.this.selectFilesToDownload.size();
                                        QQFlashTransferViewModel qQFlashTransferViewModel722 = QQFlashTransferViewModel.this;
                                        qQFlashTransferViewModel722.getClass();
                                        KLog kLog = KLog.INSTANCE;
                                        kLog.d("QQFTFilterLayoutModeView", "checkbox selectAll");
                                        if (!qQFlashTransferViewModel722.isAllSelectMode.getValue().booleanValue()) {
                                            if (!qQFlashTransferViewModel722.hasLoadAll.getValue().booleanValue()) {
                                                MutableState<Boolean> mutableState = qQFlashTransferViewModel722.hasTapSelectAll;
                                                Boolean bool = Boolean.TRUE;
                                                mutableState.setValue(bool);
                                                qQFlashTransferViewModel722.showLoadingAllList.setValue(bool);
                                                qQFlashTransferViewModel722.updateAllItem(true);
                                                qQFlashTransferViewModel722.fetchPageFileList(true, null);
                                                kLog.d("QQFTFilterLayoutModeView", "wait to load all");
                                            } else {
                                                kLog.d("QQFTFilterLayoutModeView", "selectAll");
                                                qQFlashTransferViewModel722.updateAllItem(true);
                                            }
                                        } else {
                                            kLog.d("QQFTFilterLayoutModeView", "checkbox deselect all");
                                            qQFlashTransferViewModel722.updateAllItem(false);
                                            qQFlashTransferViewModel722.hasTapSelectAll.setValue(Boolean.FALSE);
                                        }
                                        QQFlashTransferViewModel.this.updateFileContentOffset(size);
                                        return Unit.INSTANCE;
                                    }
                                };
                                final QQTransferDownloadActivity qQTransferDownloadActivity322 = qQTransferDownloadActivity2;
                                Function0<Unit> function0222 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.1.1.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        QQTransferDownloadActivity qQTransferDownloadActivity422 = QQTransferDownloadActivity.this;
                                        int i18 = QQTransferDownloadActivity.$r8$clinit;
                                        qQTransferDownloadActivity422.closePage();
                                        return Unit.INSTANCE;
                                    }
                                };
                                final QQFlashTransferViewModel qQFlashTransferViewModel722 = QQFlashTransferViewModel.this;
                                Function0<Unit> function0322 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.1.1.3
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        QQFlashTransferViewModel.this.hasTapSelectAll.setValue(Boolean.FALSE);
                                        int size = QQFlashTransferViewModel.this.selectFilesToDownload.size();
                                        QQFlashTransferViewModel.this.updateAllItem(false);
                                        QQFlashTransferViewModel.this.updateFileContentOffset(size);
                                        return Unit.INSTANCE;
                                    }
                                };
                                final QQFlashTransferViewModel qQFlashTransferViewModel822 = QQFlashTransferViewModel.this;
                                QQFTNavBarKt.QQFTNavBar(qQFlashTransferViewModel522, hVar, str622, str7, valueOf22, str3, value5, image2, str5, function042, function0222, function0322, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.1.1.4
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        br value6 = QQFlashTransferViewModel.this.fileSet.getValue();
                                        if (value6 != null) {
                                            QQFlashTransferKuiklyModule.Companion.getInstance().shareFileSet(value6, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$body$1$1$4$1$1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final /* bridge */ /* synthetic */ Unit invoke(e eVar3) {
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }, Boolean.valueOf(canShowAllSelectCheckBox22), Boolean.valueOf(z17), 0.0f, composer5, 72, 196608, 0);
                                QQFTDownloadFailBannerBarKt.QQFTDownloadFailBannerBar(QQFlashTransferViewModel.this, composer5, 8);
                                i h1622 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                                final QQTransferDownloadActivity qQTransferDownloadActivity422 = qQTransferDownloadActivity2;
                                final QQFlashTransferViewModel qQFlashTransferViewModel922 = QQFlashTransferViewModel.this;
                                BoxKt.a(h1622, null, null, ComposableLambdaKt.composableLambda(composer5, -1596905662, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.1.1.5
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(b bVar2, Composer composer6, Integer num3) {
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1596905662, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.<anonymous>.<anonymous>.<anonymous> (QQTransferDownloadActivity.kt:553)");
                                            }
                                            QQTransferDownloadActivity qQTransferDownloadActivity5 = QQTransferDownloadActivity.this;
                                            QQFlashTransferViewModel qQFlashTransferViewModel10 = qQFlashTransferViewModel922;
                                            QQTransferDownloadActivity.access$QQFTContentView(qQTransferDownloadActivity5, qQFlashTransferViewModel10, qQFlashTransferViewModel10.getListState(), composer7, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_REQUEST);
                                            QQFTDownloadBarViewKt.QQFTDownloadBarView(qQFlashTransferViewModel922, composer7, 8);
                                            if (qQFlashTransferViewModel922.isScrollOverFirstPage.getValue().booleanValue()) {
                                                i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, qQFlashTransferViewModel922.isBottomBarShow() ? 100.0f : 0.0f, 7, null);
                                                final QQFlashTransferViewModel qQFlashTransferViewModel11 = qQFlashTransferViewModel922;
                                                BoxKt.a(n3, null, null, ComposableLambdaKt.composableLambda(composer7, -1078403391, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.1.1.5.1
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(b bVar3, Composer composer8, Integer num4) {
                                                        int i18;
                                                        b bVar4 = bVar3;
                                                        Composer composer9 = composer8;
                                                        int intValue4 = num4.intValue();
                                                        if ((intValue4 & 14) == 0) {
                                                            i18 = (composer9.changed(bVar4) ? 4 : 2) | intValue4;
                                                        } else {
                                                            i18 = intValue4;
                                                        }
                                                        if ((i18 & 91) == 18 && composer9.getSkipping()) {
                                                            composer9.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1078403391, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQTransferDownloadActivity.kt:559)");
                                                            }
                                                            i a16 = bVar4.a(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 72.0f), Alignment.BottomEnd);
                                                            final QQFlashTransferViewModel qQFlashTransferViewModel12 = QQFlashTransferViewModel.this;
                                                            BoxKt.a(a16, null, null, ComposableLambdaKt.composableLambda(composer9, 996924155, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.1.1.5.1.1
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Unit invoke(b bVar5, Composer composer10, Integer num5) {
                                                                    int i19;
                                                                    b bVar6 = bVar5;
                                                                    Composer composer11 = composer10;
                                                                    int intValue5 = num5.intValue();
                                                                    if ((intValue5 & 14) == 0) {
                                                                        i19 = (composer11.changed(bVar6) ? 4 : 2) | intValue5;
                                                                    } else {
                                                                        i19 = intValue5;
                                                                    }
                                                                    if ((i19 & 91) == 18 && composer11.getSkipping()) {
                                                                        composer11.skipToGroupEnd();
                                                                    } else {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(996924155, intValue5, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQTransferDownloadActivity.kt:562)");
                                                                        }
                                                                        i L = ModifiersKt.L(bVar6.a(ModifiersKt.q(ModifiersKt.A(ModifiersKt.c(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 48.0f), QUIToken.color$default("bg_bottom_light")), 0.5f, 0.0f, 2, null), uo3.c.b()), Alignment.TopStart), 2.0f, 8.0f, 14.0f, QUIToken.color$default("fill_standard_quaternary"));
                                                                        final QQFlashTransferViewModel qQFlashTransferViewModel13 = QQFlashTransferViewModel.this;
                                                                        BoxKt.a(ViewEventPropUpdaterKt.d(L, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.body.1.1.5.1.1.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                com.tencent.ntcompose.foundation.lazy.d.x(QQFlashTransferViewModel.this.getListState(), 0, 0.0f, true, null, 8, null);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }, 3, null), Alignment.Center, null, ComposableSingletons$QQTransferDownloadActivityKt.f148lambda2, composer11, 3128, 4);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), composer9, 3080, 6);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer7, 3080, 6);
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 3080, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 24584, 14);
                    composer3.startReplaceableGroup(1597208969);
                    if (QQFlashTransferViewModel.this.showLoadingAllList.getValue().booleanValue()) {
                        BoxKt.a(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$body$1.2
                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                return Unit.INSTANCE;
                            }
                        }, 3, null), null, null, ComposableSingletons$QQTransferDownloadActivityKt.f149lambda3, composer3, 3080, 6);
                    }
                    composer3.endReplaceableGroup();
                    QQFTFilterLayoutModeViewKt.QQFTDetailFilterCategoryView(QQFlashTransferViewModel.this, composer3, 8);
                    QQFTFileSetStatusViewKt.QQFTDetailTitleBubbleView(QQFlashTransferViewModel.this, composer3, 8);
                    QQFTFileSetStatusViewKt.QQFTDetailExpireBubbleView(QQFlashTransferViewModel.this, composer3, 8);
                    QQTransferDownloadActivity.access$askDialogForDeviceStatus(qQTransferDownloadActivity, QQFlashTransferViewModel.this, composer3, 72);
                    QQTransferDownloadActivity.access$alertDialogForDeviceStatus(qQTransferDownloadActivity, QQFlashTransferViewModel.this, composer3, 72);
                    QQTransferDownloadActivity.access$showFisrtDownloadTipsAlertIfNeeded(qQTransferDownloadActivity, QQFlashTransferViewModel.this, composer3, 72);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$body$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQTransferDownloadActivity.access$body(QQTransferDownloadActivity.this, qQFlashTransferViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$showFisrtDownloadTipsAlertIfNeeded(final QQTransferDownloadActivity qQTransferDownloadActivity, final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        qQTransferDownloadActivity.getClass();
        Composer startRestartGroup = composer.startRestartGroup(104443228);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(104443228, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.showFisrtDownloadTipsAlertIfNeeded (QQTransferDownloadActivity.kt:1432)");
        }
        QUIAlertDialogKt.QUIAlertDialog(qQFlashTransferViewModel.showFirstDownloadTip.getValue().booleanValue(), "\u5df2\u53d1\u8d77\u95ea\u4f20\u4e0b\u8f7d", "\u5982\u79bb\u5f00\u5f53\u524d\u9875\u9762\uff0c\u5c06\u4e3a\u4f60\u5728\u540e\u53f0\u6301\u7eed\u4e0b\u8f7d\uff0c\u5e76\u5728\u5b8c\u6210\u540e\u4fdd\u5b58\u81f3 \u6211\u7684\u6587\u4ef6\u3002", ComposableLambdaKt.composableLambda(startRestartGroup, -1251983597, true, new Function3<Float, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$showFisrtDownloadTipsAlertIfNeeded$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(Float f16, Composer composer2, Integer num) {
                f16.floatValue();
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1251983597, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.showFisrtDownloadTipsAlertIfNeeded.<anonymous> (QQTransferDownloadActivity.kt:1437)");
                    }
                    final QQFlashTransferViewModel qQFlashTransferViewModel2 = QQFlashTransferViewModel.this;
                    a.C0144a c0144a = new a.C0144a(0, 1, null);
                    int e16 = c0144a.e(new j(QUIToken.color$default("text_primary"), Float.valueOf(14.0f), null, null, null, null, null, null, null, Float.valueOf(17.0f), null, null, null, null, null, 32252, null));
                    try {
                        c0144a.a("\u5982\u79bb\u5f00\u5f53\u524d\u9875\u9762\uff0c\u5c06\u4e3a\u4f60\u5728\u540e\u53f0\u6301\u7eed\u4e0b\u8f7d\uff0c\u5e76\u5728\u5b8c\u6210\u540e\u4fdd\u5b58\u81f3 ");
                        Unit unit = Unit.INSTANCE;
                        c0144a.c(e16);
                        e16 = c0144a.e(new j(QUIToken.color$default("text_link"), Float.valueOf(14.0f), null, null, null, null, null, null, null, Float.valueOf(17.0f), null, null, null, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$showFisrtDownloadTipsAlertIfNeeded$1$annotatedString$1$2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                String str;
                                if (defpackage.k.a(c.f117352a)) {
                                    str = "mqqapi://qqfile?page_from=3";
                                } else {
                                    str = "mqqapi://qqfile/openmyfile?page_from=3";
                                }
                                MqqUi.openUrl$default(Mqq.INSTANCE.getUi(), str);
                                QQFlashTransferViewModel.this.showFirstDownloadTip.setValue(Boolean.FALSE);
                                return Unit.INSTANCE;
                            }
                        }, 15868, null));
                        try {
                            c0144a.a("\u6211\u7684\u6587\u4ef6");
                            c0144a.c(e16);
                            RichTextKt.b(c0144a.f(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, 0, 0, 0, 268435454);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } finally {
                        }
                    } finally {
                    }
                }
                return Unit.INSTANCE;
            }
        }), new QUIAlertDialogItem[]{QUIAlertDialogKt.QUIAlertDialogNormalTextItem("\u6211\u77e5\u9053\u4e86", new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$showFisrtDownloadTipsAlertIfNeeded$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                QQFlashTransferViewModel.this.showFirstDownloadTip.setValue(Boolean.FALSE);
                return Unit.INSTANCE;
            }
        })}, null, null, startRestartGroup, 36272, 96);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$showFisrtDownloadTipsAlertIfNeeded$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQTransferDownloadActivity.access$showFisrtDownloadTipsAlertIfNeeded(QQTransferDownloadActivity.this, qQFlashTransferViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public final void closePage() {
        if (this.modalMode == 1) {
            this.didEntered.setValue(Boolean.FALSE);
        } else {
            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
            QQKuiklyPlatformApi.Companion.closePage$default();
        }
    }

    public final void notifyOtherPageIsAppear(boolean z16) {
        c cVar = c.f117352a;
        if (AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(cVar)) {
            e eVar = new e();
            eVar.v(FlashTransferHelperApiImpl.kFileSetIdKey, this.viewModel.fileSetId);
            eVar.w("kOtherDownloadPageIsAppearKey", z16);
            eVar.t("kOtherDownloadPageTokenKey", hashCode());
            com.tencent.kuikly.core.module.k.d((com.tencent.kuikly.core.module.k) cVar.g().acquireModule("KRNotifyModule"), "kOtherDownloadPageAppearNotify", eVar, false, 4, null);
            KLog.INSTANCE.d("QQTransferDownloadActivity", "pageDidAppear postNotify isAppear=" + z16 + " this=" + this + " fromPageToken=" + hashCode());
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFlashTransferBaseActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final void onDestroy() {
        List list;
        super.onDestroy();
        QQTransferDownloadActivity$addFileSetDownloadListener$1 qQTransferDownloadActivity$addFileSetDownloadListener$1 = this.downloadListener;
        if (qQTransferDownloadActivity$addFileSetDownloadListener$1 != null) {
            IKernelFlashTransferService.f344757i.a().i(qQTransferDownloadActivity$addFileSetDownloadListener$1);
        }
        if (this.uploadInfoFileSetStatusListener != null) {
            IKernelFlashTransferService.a aVar = IKernelFlashTransferService.f344757i;
            IKernelFlashTransferService a16 = aVar.a();
            QQTransferDownloadActivity$addFileSetUploadListener$2 qQTransferDownloadActivity$addFileSetUploadListener$2 = this.uploadInfoFileSetStatusListener;
            Intrinsics.checkNotNull(qQTransferDownloadActivity$addFileSetUploadListener$2);
            a16.j(qQTransferDownloadActivity$addFileSetUploadListener$2);
            IKernelFlashTransferService a17 = aVar.a();
            list = ArraysKt___ArraysKt.toList(new String[]{this.viewModel.fileSetId});
            a17.getClass();
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(list.size()));
            arrayList.addAll(list);
            Object[] array = arrayList.toArray(new Object[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            a17.syncToNativeMethod(true, "removeFileSetSimpleUploadInfoMonitoring", array, null);
        }
        QQTransferDownloadActivity$addFileSetUploadListener$1 qQTransferDownloadActivity$addFileSetUploadListener$1 = this.uploadListener;
        if (qQTransferDownloadActivity$addFileSetUploadListener$1 != null) {
            IKernelFlashTransferService.f344757i.a().k(qQTransferDownloadActivity$addFileSetUploadListener$1);
        }
        QQTransferDownloadActivity$addFolderListener$1 qQTransferDownloadActivity$addFolderListener$1 = this.folderListener;
        if (qQTransferDownloadActivity$addFolderListener$1 != null) {
            IKernelFlashTransferService.f344757i.a().l(qQTransferDownloadActivity$addFolderListener$1);
        }
        QQTransferDownloadActivity$addCompressedFileListener$1 qQTransferDownloadActivity$addCompressedFileListener$1 = this.compressedFileListener;
        if (qQTransferDownloadActivity$addCompressedFileListener$1 != null) {
            IKernelFlashTransferService.f344757i.a().f(qQTransferDownloadActivity$addCompressedFileListener$1);
        }
        QQTransferDownloadActivity$addDeviceStatusListener$1 qQTransferDownloadActivity$addDeviceStatusListener$1 = this.deviceStatusListener;
        if (qQTransferDownloadActivity$addDeviceStatusListener$1 != null) {
            IKernelFlashTransferService.f344757i.a().g(qQTransferDownloadActivity$addDeviceStatusListener$1);
        }
        String str = this.fileSetDeleteSuccessNotifyListener;
        if (str != null) {
            ((com.tencent.kuikly.core.module.k) c.f117352a.g().acquireModule("KRNotifyModule")).e(FlashTransferHelperApiImpl.kQQFTFileSetDidDeletedNotification, str);
        }
        String str2 = this.otherPageAppearListener;
        if (str2 != null) {
            ((com.tencent.kuikly.core.module.k) c.f117352a.g().acquireModule("KRNotifyModule")).e("kOtherDownloadPageAppearNotify", str2);
        }
        this.viewModel.onDestroy();
        ((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).clearImageMemoryCache();
        if (!this.viewModel.isSecondaryPage()) {
            QQFlashTransferCurFileSetInfo.fileSetInfo = null;
        }
        KLog.INSTANCE.d("QQTransferDownloadActivity", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void onPause() {
        super.onPause();
        KLog.INSTANCE.d("QQTransferDownloadActivity", "onPause " + this);
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity, com.tencent.kuikly.core.pager.b
    public final void onReceivePagerEvent(String str, e eVar) {
        super.onReceivePagerEvent(str, eVar);
        if (Intrinsics.areEqual(str, "onModalModeBackPressed")) {
            closePage();
        }
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void onResume() {
        super.onResume();
        updateListMode();
        if (!(this.modalMode == 1)) {
            ((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).setEdgePopWidth(getPageData().m());
        }
        KLog.INSTANCE.d("QQTransferDownloadActivity", "onResume " + this);
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void pageDidAppear() {
        super.pageDidAppear();
        this.isPageVisible.setValue(Boolean.TRUE);
        notifyOtherPageIsAppear(true);
        KLog.INSTANCE.d("QQTransferDownloadActivity", "pageDidAppear");
        TimerKt.c(200, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$pageDidAppear$1
            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                QQCommonNApiModule.Companion companion = QQCommonNApiModule.Companion;
                c cVar = c.f117352a;
                boolean isDarkTheme = ((QQCommonNApiModule) cVar.g().acquireModule("QQCommonNApiModule")).isDarkTheme();
                KLog.INSTANCE.d("QQTransferDownloadActivity", "pageDidAppear isDarkTheme=" + isDarkTheme);
                if (isDarkTheme) {
                    ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).setWhiteStatusBarStyle();
                } else {
                    ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).setBlackStatusBarStyle();
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void pageDidDisappear() {
        super.pageDidDisappear();
        this.isPageVisible.setValue(Boolean.FALSE);
        notifyOtherPageIsAppear(false);
        KLog.INSTANCE.d("QQTransferDownloadActivity", "pageDidDisappear " + this);
    }

    public final void requestFileSet() {
        QQFlashTransferViewModel qQFlashTransferViewModel = this.viewModel;
        String str = qQFlashTransferViewModel.fileSetId;
        int i3 = qQFlashTransferViewModel.sceneType;
        KLog.INSTANCE.d("QQTransferDownloadActivity", "requestFileSet");
        IKernelFlashTransferService a16 = IKernelFlashTransferService.f344757i.a();
        final dl dlVar = new dl() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$requestFileSet$1
            @Override // ws3.dl
            public final void onGetFileSet(final int i16, final int i17, final String str2, final br brVar, final boolean z16) {
                final QQTransferDownloadActivity qQTransferDownloadActivity = QQTransferDownloadActivity.this;
                SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$requestFileSet$1$onGetFileSet$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        if (QQTransferDownloadActivity.this.viewModel.fileSet.getValue() != null && z16) {
                            KLog.INSTANCE.d("QQTransferDownloadActivity", "getFileset has already server data.");
                        } else {
                            QQFlashTransferCurFileSetInfo.fileSetInfo = brVar;
                            KLog kLog = KLog.INSTANCE;
                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onGetFileSet set fileSetId=");
                            br brVar2 = QQFlashTransferCurFileSetInfo.fileSetInfo;
                            m3.append(brVar2 != null ? brVar2.f446187a : null);
                            m3.append(" isCache=");
                            NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0.m(m3, z16, kLog, "QQTransferDownloadActivity");
                            QQTransferDownloadActivity.this.updateFileSet(i17, str2, brVar, z16);
                        }
                        return Unit.INSTANCE;
                    }
                });
            }
        };
        a16.getClass();
        ArrayList arrayList = new ArrayList();
        ArrayList m3 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m("seq");
        m3.add(1);
        m3.add("fileSetId");
        m3.add(str);
        m3.add("sceneType");
        m3.add(Integer.valueOf(i3));
        m3.add("isUseCache");
        m3.add(1);
        m3.add("isNoReqSvr");
        m3.add(0);
        Object[] array = m3.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        arrayList.add(Integer.valueOf(array.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, array);
        arrayList.add(String.valueOf(dlVar.hashCode()));
        Function1<Object, Unit> function1 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$getFileSet$kernelCallback$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                Object[] objArr = obj instanceof Object[] ? (Object[]) obj : null;
                if (objArr != null) {
                    if (!(objArr.length == 0)) {
                        Iterator it = ArrayIteratorKt.iterator(objArr);
                        if (Intrinsics.areEqual((String) dr.a(it, "null cannot be cast to non-null type kotlin.String"), "onGetFileSet")) {
                            Object next = it.next();
                            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
                            int intValue = ((Integer) next).intValue();
                            Object next2 = it.next();
                            Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
                            int intValue2 = ((Integer) next2).intValue();
                            Object next3 = it.next();
                            Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) next3;
                            Object next4 = it.next();
                            Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.Int");
                            int intValue3 = ((Integer) next4).intValue();
                            Object[] objArr2 = new Object[intValue3];
                            for (int i16 = 0; i16 < intValue3; i16++) {
                                objArr2[i16] = it.next();
                            }
                            br a17 = bs.a(objArr2);
                            Object next5 = it.next();
                            Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.Int");
                            dl.this.onGetFileSet(intValue, intValue2, str2, a17, ((Integer) next5).intValue() == 1);
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        };
        Object[] array2 = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        a16.syncToNativeMethod(true, "getFileSet", array2, function1);
    }

    /* JADX WARN: Type inference failed for: r5v12, types: [com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$addFileSetClusteringListListener$1] */
    /* JADX WARN: Type inference failed for: r7v35, types: [com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetDownloadListener$1] */
    /* JADX WARN: Type inference failed for: r9v13, types: [com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFolderListener$1] */
    /* JADX WARN: Type inference failed for: r9v17, types: [com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addCompressedFileListener$1] */
    /* JADX WARN: Type inference failed for: r9v21, types: [com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addDeviceStatusListener$1] */
    /* JADX WARN: Type inference failed for: r9v36, types: [com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetUploadListener$1] */
    /* JADX WARN: Type inference failed for: r9v39, types: [com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetUploadListener$2] */
    public final void updateFileSet(int i3, String str, br brVar, boolean z16) {
        String str2;
        String str3;
        int i16;
        ws3.a aVar;
        ws3.a aVar2;
        List<bz> list;
        List list2;
        String str4;
        x xVar;
        x xVar2;
        x xVar3;
        x xVar4;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("updateFileSet result:", i3, ", errorMsg:", str, " totalFileCount=");
        br value = this.viewModel.fileSet.getValue();
        m3.append(value != null ? ULong.m642boximpl(value.f446189c) : null);
        m3.append(" isFileSetExpired=");
        m3.append(brVar != null && (brVar.f446201o == 5 || brVar.f446193g == 0));
        m3.append(" isCache=");
        m3.append(z16);
        m3.append(" isPageVisible=");
        m3.append(this.isPageVisible.getValue().booleanValue());
        m3.append(" isNetworkReachable=");
        AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(m3, this.isNetworkReachable, kLog, "QQTransferDownloadActivity");
        if (i3 != 0 && !z16) {
            br value2 = this.viewModel.fileSet.getValue();
            ULong m642boximpl = value2 != null ? ULong.m642boximpl(value2.f446189c) : null;
            if (m642boximpl != null && m642boximpl.getData() == 0) {
                this.viewModel.fileSet.setValue(null);
            }
            this.viewModel.isLoadingData.setValue(Boolean.FALSE);
            if (this.isPageVisible.getValue().booleanValue() && this.isNetworkReachable) {
                if (i3 == 100002) {
                    QQKuiklyPlatformApi.Companion.qqToast("\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", QToastMode.Warning);
                    this.viewModel.updateSafetyTipsView("\u52a0\u8f7d\u5931\u8d25");
                } else if (i3 != 130003) {
                    QQKuiklyPlatformApi.Companion.qqToast("\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", QToastMode.Warning);
                    this.viewModel.updateSafetyTipsView("\u52a0\u8f7d\u5931\u8d25");
                } else {
                    QQKuiklyPlatformApi.Companion.qqToast("\u5f53\u524d\u8bbf\u95ee\u4eba\u6570\u8fc7\u591a\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", QToastMode.Warning);
                    this.viewModel.updateSafetyTipsView("\u5f53\u524d\u8bbf\u95ee\u4eba\u6570\u8fc7\u591a\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                }
            }
            br value3 = this.viewModel.fileSet.getValue();
            if (value3 != null) {
                value3.f446201o = 3;
            }
            this.viewModel.footerRefreshState.setValue(FooterRefreshState.FAILURE);
            return;
        }
        boolean z17 = this.viewModel.fileSet.getValue() != null;
        this.viewModel.fileSet.setValue(brVar);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getFileset result:");
        sb5.append(i3);
        sb5.append(", errorMsg:");
        sb5.append(str);
        sb5.append(", total_file_count:");
        StringBuilder m16 = QQFlashTransferViewModel$fetchCompressedFileFolder$2$$ExternalSyntheticOutline0.m(brVar.f446190d, QQFlashTransferViewModel$fetchCompressedFileFolder$2$$ExternalSyntheticOutline0.m(brVar.f446189c, sb5, " total_file_size:"), " expire_time:");
        m16.append((Object) UInt.m615toStringimpl(brVar.f446193g));
        m16.append(" fileSetStatus=");
        br value4 = this.viewModel.fileSet.getValue();
        m16.append(value4 != null ? Integer.valueOf(value4.f446201o) : null);
        m16.append(" failedCount=");
        br value5 = this.viewModel.fileSet.getValue();
        m16.append((value5 == null || (xVar4 = value5.f446198l) == null) ? null : UInt.m564boximpl(xVar4.f446403c));
        m16.append(" pausedCount=");
        br value6 = this.viewModel.fileSet.getValue();
        m16.append((value6 == null || (xVar3 = value6.f446198l) == null) ? null : UInt.m564boximpl(xVar3.f446404d));
        m16.append("  successCount=");
        br value7 = this.viewModel.fileSet.getValue();
        m16.append((value7 == null || (xVar2 = value7.f446198l) == null) ? null : UInt.m564boximpl(xVar2.f446402b));
        m16.append(" totalDownloadFileCount=");
        br value8 = this.viewModel.fileSet.getValue();
        m16.append((value8 == null || (xVar = value8.f446198l) == null) ? null : ULong.m642boximpl(xVar.f446401a));
        m16.append(" firstLevelItemCount=");
        br value9 = this.viewModel.fileSet.getValue();
        m16.append(value9 != null ? UInt.m564boximpl(value9.f446196j) : null);
        m16.append(" shouldPull=");
        sb5.append(brVar.f446194h.f446147b);
        sb5.append(" firstClusteringListSize=");
        sb5.append(brVar.f446194h.f446146a.size());
        sb5.append(" isCache=");
        sb5.append(z16);
        sb5.append(" is_local_create=");
        br value10 = this.viewModel.fileSet.getValue();
        sb5.append(value10 != null ? Boolean.valueOf(value10.f446200n) : null);
        sb5.append(" transferType=");
        br value11 = this.viewModel.fileSet.getValue();
        sb5.append(value11 != null ? Integer.valueOf(value11.f446199m) : null);
        kLog.i("QQTransferDownloadActivity", sb5.toString());
        if (!brVar.f446192f.isEmpty()) {
            NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getFileset uploaders nickname="), brVar.f446192f.get(0).f446362b, kLog, "QQTransferDownloadActivity");
        }
        if (brVar.f446194h.f446147b && (!r1.f446146a.isEmpty())) {
            this.viewModel.firstClusteringList.clear();
            this.viewModel.firstClusteringList.addAll(brVar.f446194h.f446146a);
        }
        this.viewModel.uploadSucFileCount.setValue(Long.valueOf(brVar.f446197k.f446359a & 4294967295L));
        this.viewModel.creatorUploadStatus.setValue(Integer.valueOf(brVar.f446202p));
        for (bz bzVar : brVar.f446194h.f446146a) {
            KLog kLog2 = KLog.INSTANCE;
            StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getFileset firstClustering name=");
            m17.append(bzVar.f446227b);
            m17.append(" type=");
            ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(m17, bzVar.f446226a, kLog2, "QQTransferDownloadActivity");
        }
        if (this.viewModel.pageTitle.getValue().length() == 0) {
            this.viewModel.pageTitle.setValue(brVar.f446188b);
        }
        if (!z16) {
            br value12 = this.viewModel.fileSet.getValue();
            if (value12 != null && (value12.f446201o == 5 || value12.f446193g == 0)) {
                KLog kLog3 = KLog.INSTANCE;
                kLog3.i("QQTransferDownloadActivity", "getFileset FileSet is expired");
                final QQFlashTransferViewModel qQFlashTransferViewModel = this.viewModel;
                if (qQFlashTransferViewModel.fileSet.getValue() == null) {
                    kLog3.d("QQFlashTransferFileListViewModel", "getLocalFileListByStatuses fileSet null");
                    return;
                }
                String str5 = qQFlashTransferViewModel.fileSetId;
                String value13 = qQFlashTransferViewModel.parentId.getValue();
                String str6 = qQFlashTransferViewModel.indexPath;
                kLog3.d("QQFlashTransferFileListViewModel", "getLocalFileListByStatuses filesetId:" + str5);
                IKernelFlashTransferService a16 = IKernelFlashTransferService.f344757i.a();
                final df dfVar = new df() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$getLocalFileList$1
                    @Override // ws3.df
                    public final void onGetLocalFileListByStatuses(final cr crVar) {
                        final QQFlashTransferViewModel qQFlashTransferViewModel2 = QQFlashTransferViewModel.this;
                        SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$getLocalFileList$1$onGetLocalFileListByStatuses$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:30:0x00f7, code lost:
                            
                                if (r3 > 0) goto L34;
                             */
                            /* JADX WARN: Type inference failed for: r0v5, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
                            /* JADX WARN: Type inference failed for: r1v11, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
                            /* JADX WARN: Type inference failed for: r1v7, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
                            /* JADX WARN: Type inference failed for: r1v9, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
                            /* JADX WARN: Type inference failed for: r3v11, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
                            /* JADX WARN: Type inference failed for: r3v14, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
                            /* JADX WARN: Type inference failed for: r3v5, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
                            /* JADX WARN: Type inference failed for: r3v8, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
                            @Override // kotlin.jvm.functions.Function0
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Unit invoke() {
                                int compare;
                                int compare2;
                                KLog kLog4 = KLog.INSTANCE;
                                StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onGetLocalFileListByStatuses result:");
                                m18.append(cr.this.f446285a);
                                m18.append(" msg:");
                                m18.append(cr.this.f446286b);
                                m18.append(" listCount:");
                                m18.append(cr.this.f446287c.size());
                                kLog4.d("QQFlashTransferFileListViewModel", m18.toString());
                                if (cr.this.f446285a != 0) {
                                    ((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).qqToast(cr.this.f446286b, QToastMode.Warning);
                                } else {
                                    qQFlashTransferViewModel2.clearFileSkeletonView();
                                    qQFlashTransferViewModel2.itemVMList.clear();
                                    qQFlashTransferViewModel2.finishedVMList.clear();
                                    qQFlashTransferViewModel2.otherVMList.clear();
                                    if (cr.this.f446287c.isEmpty()) {
                                        kLog4.d("QQFlashTransferFileListViewModel", "onGetLocalFileListByStatuses insert empty");
                                        qQFlashTransferViewModel2.updateSafetyTipsView("\u8be5\u95ea\u4f20\u4efb\u52a1\u5df2\u8fc7\u671f");
                                        qQFlashTransferViewModel2.isFileSetExpired.setValue(Boolean.TRUE);
                                    } else {
                                        int size = cr.this.f446287c.size();
                                        for (int i17 = 0; i17 < size; i17++) {
                                            ab abVar = cr.this.f446287c.get(i17);
                                            QQFTFileDetailItemVM qQFTFileDetailItemVM = new QQFTFileDetailItemVM(qQFlashTransferViewModel2, abVar, false);
                                            qQFTFileDetailItemVM.isFromCache = true;
                                            qQFTFileDetailItemVM.updateThumbnailUrl(abVar.f446166q);
                                            if (!abVar.f446162m) {
                                                if (abVar.f446155f) {
                                                    if (abVar.C != 3) {
                                                        compare = Integer.compare(abVar.E.f446244d ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE);
                                                        if (compare <= 0) {
                                                            br value14 = qQFlashTransferViewModel2.fileSet.getValue();
                                                            if (value14 != null && value14.f446199m == 1 && value14.f446200n) {
                                                                if (abVar.B != 3) {
                                                                    compare2 = Integer.compare(abVar.D.f446250b ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE);
                                                                }
                                                            }
                                                            qQFTFileDetailItemVM.fileStatus.setValue(3);
                                                            qQFlashTransferViewModel2.otherVMList.add(qQFTFileDetailItemVM);
                                                        }
                                                    }
                                                    qQFlashTransferViewModel2.finishedVMList.add(qQFTFileDetailItemVM);
                                                } else {
                                                    if (abVar.C != 3) {
                                                        br value15 = qQFlashTransferViewModel2.fileSet.getValue();
                                                        if (!(value15 != null && value15.f446199m == 1 && value15.f446200n) || abVar.B != 3) {
                                                            qQFTFileDetailItemVM.fileStatus.setValue(3);
                                                            qQFlashTransferViewModel2.otherVMList.add(qQFTFileDetailItemVM);
                                                        }
                                                    }
                                                    qQFlashTransferViewModel2.finishedVMList.add(qQFTFileDetailItemVM);
                                                }
                                            }
                                        }
                                        QQFlashTransferViewModel qQFlashTransferViewModel3 = qQFlashTransferViewModel2;
                                        qQFlashTransferViewModel3.showExpiredList.setValue(Boolean.valueOf(qQFlashTransferViewModel3.finishedVMList.isEmpty()));
                                        qQFlashTransferViewModel2.handleExpiredList();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        });
                    }
                };
                a16.getClass();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add("fileSetId");
                arrayList2.add(str5);
                arrayList2.add("parentId");
                arrayList2.add(value13);
                arrayList2.add("indexPath");
                arrayList2.add(str6);
                arrayList2.add(VasWebReport.WEB_CORE_DATA_FLAGS);
                arrayList2.add(0);
                Object[] array = arrayList2.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                arrayList.add(Integer.valueOf(array.length));
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, array);
                arrayList.add(String.valueOf(dfVar.hashCode()));
                Function1<Object, Unit> function1 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$getLocalFileListByStatuses$kernelCallback$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object obj) {
                        List emptyList;
                        Object[] objArr = obj instanceof Object[] ? (Object[]) obj : null;
                        if (objArr != null) {
                            if (!(objArr.length == 0)) {
                                Iterator it = ArrayIteratorKt.iterator(objArr);
                                if (Intrinsics.areEqual((String) dr.a(it, "null cannot be cast to non-null type kotlin.String"), "onGetLocalFileListByStatuses")) {
                                    Object next = it.next();
                                    Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
                                    int intValue = ((Integer) next).intValue();
                                    Object[] objArr2 = new Object[intValue];
                                    for (int i17 = 0; i17 < intValue; i17++) {
                                        objArr2[i17] = it.next();
                                    }
                                    Iterator it5 = ArrayIteratorKt.iterator(objArr2);
                                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                                    cr crVar = new cr(0, "", emptyList);
                                    while (it5.hasNext()) {
                                        Object next2 = it5.next();
                                        if (Intrinsics.areEqual(next2, "seq")) {
                                            Object next3 = it5.next();
                                            Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int");
                                            ((Integer) next3).intValue();
                                        } else if (Intrinsics.areEqual(next2, "result")) {
                                            Object next4 = it5.next();
                                            Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.Int");
                                            crVar.f446285a = ((Integer) next4).intValue();
                                        } else if (Intrinsics.areEqual(next2, "errMs")) {
                                            Object next5 = it5.next();
                                            Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.String");
                                            crVar.f446286b = (String) next5;
                                        } else if (Intrinsics.areEqual(next2, "fileSetId")) {
                                            Object next6 = it5.next();
                                            Intrinsics.checkNotNull(next6, "null cannot be cast to non-null type kotlin.String");
                                        } else if (Intrinsics.areEqual(next2, "fileList")) {
                                            Object next7 = it5.next();
                                            Intrinsics.checkNotNull(next7, "null cannot be cast to non-null type kotlin.Int");
                                            int intValue2 = ((Integer) next7).intValue();
                                            ArrayList arrayList3 = new ArrayList();
                                            for (int i18 = 0; i18 < intValue2; i18++) {
                                                Object next8 = it5.next();
                                                Intrinsics.checkNotNull(next8, "null cannot be cast to non-null type kotlin.Int");
                                                int intValue3 = ((Integer) next8).intValue();
                                                Object[] objArr3 = new Object[intValue3];
                                                for (int i19 = 0; i19 < intValue3; i19++) {
                                                    objArr3[i19] = it5.next();
                                                }
                                                arrayList3.add(bo.b(objArr3));
                                            }
                                            crVar.f446287c = arrayList3;
                                        }
                                    }
                                    df.this.onGetLocalFileListByStatuses(crVar);
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    }
                };
                Object[] array2 = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                a16.syncToNativeMethod(true, "getLocalFileListByStatuses", array2, function1);
                return;
            }
        }
        if (!z16 && this.viewModel.isFileSetInvalid()) {
            KLog.INSTANCE.i("QQTransferDownloadActivity", "getFileset FileSet is Invalid");
            int i17 = brVar.f446201o;
            if (i17 == 6) {
                this.viewModel.updateSafetyTipsView("\u95ea\u4f20\u6587\u4ef6\u5df2\u5931\u6548");
                return;
            }
            if (i17 == 7) {
                this.viewModel.updateSafetyTipsView("\u8be5\u95ea\u4f20\u4efb\u52a1\u5df2\u5220\u9664");
                return;
            }
            if (this.isPageVisible.getValue().booleanValue()) {
                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                br value14 = this.viewModel.fileSet.getValue();
                Integer valueOf = value14 != null ? Integer.valueOf(value14.f446201o) : null;
                if (valueOf != null && valueOf.intValue() == 0) {
                    str4 = "\u6587\u4ef6\u96c6\u72b6\u6001\u672a\u77e5";
                } else if (valueOf != null && valueOf.intValue() == 3) {
                    str4 = "\u6587\u4ef6\u96c6\u521b\u5efa\u5931\u8d25";
                } else if (valueOf != null && valueOf.intValue() == 4) {
                    str4 = "\u6587\u4ef6\u96c6\u5df2\u88ab\u5220\u9664";
                } else if (valueOf != null && valueOf.intValue() == 5) {
                    str4 = "\u6587\u4ef6\u96c6\u5df2\u8fc7\u671f";
                } else {
                    str4 = (valueOf != null && valueOf.intValue() == 6) ? "\u6587\u4ef6\u96c6\u88ab\u5b89\u5168\u6253\u51fb" : "";
                }
                companion.qqToast(str4, QToastMode.Warning);
                return;
            }
            return;
        }
        if (!this.viewModel.isSecondaryPage()) {
            ComposeFeedListViewModel.resetFooterRefresh$default(this.viewModel.feedListViewModel);
        }
        if (!z17) {
            if (this.downloadListener != null) {
                IKernelFlashTransferService a17 = IKernelFlashTransferService.f344757i.a();
                QQTransferDownloadActivity$addFileSetDownloadListener$1 qQTransferDownloadActivity$addFileSetDownloadListener$1 = this.downloadListener;
                Intrinsics.checkNotNull(qQTransferDownloadActivity$addFileSetDownloadListener$1);
                a17.i(qQTransferDownloadActivity$addFileSetDownloadListener$1);
            }
            this.downloadListener = new di() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetDownloadListener$1
                @Override // ws3.di
                /* renamed from: onFileDownloadDidError-OsBMiQA, reason: not valid java name */
                public final void mo126onFileDownloadDidErrorOsBMiQA(final ab abVar) {
                    SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetDownloadListener$1$onFileDownloadDidError$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            KLog kLog4 = KLog.INSTANCE;
                            StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onFileDownloadDidError name=");
                            m18.append(ab.this.f446160k);
                            m18.append(" id=");
                            m18.append(ab.this.f446151b);
                            m18.append(" errorCode=");
                            m18.append((Object) UInt.m615toStringimpl(ab.this.f446171v.f446182d));
                            kLog4.d("QQTransferDownloadActivity", m18.toString());
                            return Unit.INSTANCE;
                        }
                    });
                }

                @Override // ws3.di
                /* renamed from: onFileDownloadSpeedChange-BltQuoY, reason: not valid java name */
                public final void mo128onFileDownloadSpeedChangeBltQuoY(final ab abVar, final int i18, final int i19) {
                    SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetDownloadListener$1$onFileDownloadSpeedChange$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            KLog kLog4 = KLog.INSTANCE;
                            StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onFileDownLoadSpeedChange name=");
                            m18.append(ab.this.f446160k);
                            m18.append(" id=");
                            m18.append(ab.this.f446151b);
                            m18.append(" curSpeedBps=");
                            m18.append((Object) UInt.m615toStringimpl(i18));
                            m18.append(" remainDownLoadSeconds=");
                            m18.append((Object) UInt.m615toStringimpl(i19));
                            kLog4.d("QQTransferDownloadActivity", m18.toString());
                            return Unit.INSTANCE;
                        }
                    });
                }

                @Override // ws3.di
                public final void onFileListDownloadDidCancel(final List<ab> list3) {
                    SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetDownloadListener$1$onFileListDownloadDidCancel$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            KLog kLog4 = KLog.INSTANCE;
                            StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onFileListDownloadDidCancel size=");
                            m18.append(list3.size());
                            kLog4.d("QQTransferDownloadActivity", m18.toString());
                            return Unit.INSTANCE;
                        }
                    });
                }

                @Override // ws3.di
                public final void onFileListDownloadDidError(final List<ab> list3) {
                    SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetDownloadListener$1$onFileListDownloadDidError$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            KLog kLog4 = KLog.INSTANCE;
                            StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onFileListDownloadDidError size=");
                            m18.append(list3.size());
                            kLog4.d("QQTransferDownloadActivity", m18.toString());
                            return Unit.INSTANCE;
                        }
                    });
                }

                @Override // ws3.di
                public final void onFileListDownloadDidPause(final List<ab> list3) {
                    SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetDownloadListener$1$onFileListDownloadDidPause$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            KLog kLog4 = KLog.INSTANCE;
                            StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onFileListDownloadDidPause size=");
                            m18.append(list3.size());
                            kLog4.d("QQTransferDownloadActivity", m18.toString());
                            return Unit.INSTANCE;
                        }
                    });
                }

                @Override // ws3.di
                public final void onFileSetDownloadTaskProgressChanged(final String str7, final ca caVar) {
                    final QQTransferDownloadActivity qQTransferDownloadActivity = QQTransferDownloadActivity.this;
                    SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetDownloadListener$1$onFileSetDownloadTaskProgressChanged$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            float f16;
                            String str8 = str7;
                            br value15 = qQTransferDownloadActivity.viewModel.fileSet.getValue();
                            if (Intrinsics.areEqual(str8, value15 != null ? value15.f446187a : null)) {
                                qQTransferDownloadActivity.viewModel.fileSetDownLoadInfo.setValue(caVar);
                                ca value16 = qQTransferDownloadActivity.viewModel.fileSetDownLoadInfo.getValue();
                                if (value16 != null) {
                                    QQFTDownloadBarViewKt.m124updateSpeedqim9Vi0(value16.f446235f, qQTransferDownloadActivity.viewModel);
                                }
                                qQTransferDownloadActivity.viewModel.curDownLoadedBytesInterpolation.updateValue(caVar.f446233d, true);
                                QQFlashTransferViewModel qQFlashTransferViewModel2 = qQTransferDownloadActivity.viewModel;
                                MutableState<Float> mutableState = qQFlashTransferViewModel2.progress;
                                if (qQFlashTransferViewModel2.fileSetDownLoadInfo.getValue() != null) {
                                    ca value17 = qQTransferDownloadActivity.viewModel.fileSetDownLoadInfo.getValue();
                                    Float valueOf2 = value17 != null ? Float.valueOf((float) UnsignedKt.ulongToDouble(value17.f446233d)) : null;
                                    Intrinsics.checkNotNull(valueOf2);
                                    float floatValue = valueOf2.floatValue();
                                    ca value18 = qQTransferDownloadActivity.viewModel.fileSetDownLoadInfo.getValue();
                                    Float valueOf3 = value18 != null ? Float.valueOf((float) UnsignedKt.ulongToDouble(value18.f446234e)) : null;
                                    Intrinsics.checkNotNull(valueOf3);
                                    f16 = floatValue / valueOf3.floatValue();
                                } else {
                                    f16 = 0.0f;
                                }
                                mutableState.setValue(Float.valueOf(f16));
                                if (qQTransferDownloadActivity.isPageVisible.getValue().booleanValue()) {
                                    qQTransferDownloadActivity.viewModel.inProgressAnim.setValue(Boolean.TRUE);
                                }
                                KLog kLog4 = KLog.INSTANCE;
                                StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onFileSetDownLoadProgressChanged curDownLoadFailFileNum=");
                                m18.append((Object) UInt.m615toStringimpl(caVar.f446230a));
                                m18.append(" curDownLoadedFileNum=");
                                m18.append((Object) UInt.m615toStringimpl(caVar.f446231b));
                                m18.append(" totalDownLoadedFileNum=");
                                m18.append((Object) UInt.m615toStringimpl(caVar.f446232c));
                                m18.append(" curDownLoadedBytes=");
                                StringBuilder m19 = QQFlashTransferViewModel$fetchCompressedFileFolder$2$$ExternalSyntheticOutline0.m(caVar.f446234e, QQFlashTransferViewModel$fetchCompressedFileFolder$2$$ExternalSyntheticOutline0.m(caVar.f446233d, m18, " totalDownLoadedBytes="), " curSpeedBps=");
                                m19.append((Object) UInt.m615toStringimpl(caVar.f446235f));
                                m19.append(" remainDownLoadSeconds=");
                                m19.append((Object) UInt.m615toStringimpl(caVar.f446237h));
                                m19.append(" progress=");
                                m19.append(qQTransferDownloadActivity.viewModel.progress.getValue().floatValue());
                                m19.append(" allWaitingStatusTask=");
                                NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0.m(m19, caVar.f446240k, kLog4, "QQTransferDownloadActivity");
                            }
                            return Unit.INSTANCE;
                        }
                    });
                }

                @Override // ws3.di
                public final void onFileSetDownloadTaskStatusChange(final int i18, final String str7, final ca caVar) {
                    final QQTransferDownloadActivity qQTransferDownloadActivity = QQTransferDownloadActivity.this;
                    SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetDownloadListener$1$onFileSetDownloadTaskStatusChange$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            float f16;
                            Integer value15;
                            Integer value16;
                            String str8 = str7;
                            br value17 = qQTransferDownloadActivity.viewModel.fileSet.getValue();
                            if (Intrinsics.areEqual(str8, value17 != null ? value17.f446187a : null)) {
                                qQTransferDownloadActivity.viewModel.fileSetDownLoadInfo.setValue(caVar);
                                ca value18 = qQTransferDownloadActivity.viewModel.fileSetDownLoadInfo.getValue();
                                if (value18 != null) {
                                    QQFTDownloadBarViewKt.m124updateSpeedqim9Vi0(value18.f446235f, qQTransferDownloadActivity.viewModel);
                                }
                                QQFlashTransferViewModel qQFlashTransferViewModel2 = qQTransferDownloadActivity.viewModel;
                                MutableState<Float> mutableState = qQFlashTransferViewModel2.progress;
                                if (qQFlashTransferViewModel2.fileSetDownLoadInfo.getValue() != null) {
                                    ca value19 = qQTransferDownloadActivity.viewModel.fileSetDownLoadInfo.getValue();
                                    Float valueOf2 = value19 != null ? Float.valueOf((float) UnsignedKt.ulongToDouble(value19.f446233d)) : null;
                                    Intrinsics.checkNotNull(valueOf2);
                                    float floatValue = valueOf2.floatValue();
                                    ca value20 = qQTransferDownloadActivity.viewModel.fileSetDownLoadInfo.getValue();
                                    Float valueOf3 = value20 != null ? Float.valueOf((float) UnsignedKt.ulongToDouble(value20.f446234e)) : null;
                                    Intrinsics.checkNotNull(valueOf3);
                                    f16 = floatValue / valueOf3.floatValue();
                                } else {
                                    f16 = 0.0f;
                                }
                                mutableState.setValue(Float.valueOf(f16));
                                int updateValue = qQTransferDownloadActivity.viewModel.curDownLoadedBytesInterpolation.updateValue(caVar.f446233d, true);
                                qQTransferDownloadActivity.viewModel.fileSetDownLoadTaskStatus.setValue(Integer.valueOf(i18));
                                Integer value21 = qQTransferDownloadActivity.viewModel.fileSetDownLoadTaskStatus.getValue();
                                if ((value21 != null && value21.intValue() == 0) || (((value15 = qQTransferDownloadActivity.viewModel.fileSetDownLoadTaskStatus.getValue()) != null && value15.intValue() == 5) || ((value16 = qQTransferDownloadActivity.viewModel.fileSetDownLoadTaskStatus.getValue()) != null && value16.intValue() == 3))) {
                                    qQTransferDownloadActivity.viewModel.resetDownloadProcess();
                                }
                                Integer value22 = qQTransferDownloadActivity.viewModel.fileSetDownLoadTaskStatus.getValue();
                                if (value22 == null || value22.intValue() != 1) {
                                    qQTransferDownloadActivity.viewModel.isAutoSpeedUp.setValue(Boolean.FALSE);
                                }
                                qQTransferDownloadActivity.viewModel.isDownloadPause.setValue(Boolean.valueOf(i18 == 4));
                                ca caVar2 = caVar;
                                if (caVar2.f446232c == caVar2.f446231b) {
                                    qQTransferDownloadActivity.viewModel.downloadingFileList.clear();
                                }
                                if (qQTransferDownloadActivity.isPageVisible.getValue().booleanValue() && i18 == 3 && caVar.f446232c == 0) {
                                    QQKuiklyPlatformApi.Companion.qqToast("\u6587\u4ef6\u6b63\u5728\u4e0a\u4f20\u4e2d\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", QToastMode.Warning);
                                }
                                int i19 = i18;
                                if (i19 == 2 || i19 == 3 || i19 == 4 || i19 == 5) {
                                    qQTransferDownloadActivity.viewModel.forceShowDownloadBar.setValue(Boolean.FALSE);
                                }
                                qQTransferDownloadActivity.viewModel.showFinishDownloadBar.setValue(Boolean.TRUE);
                                if (i18 == 2) {
                                    FTFilterType value23 = qQTransferDownloadActivity.viewModel.filterType.getValue();
                                    FTFilterType fTFilterType = FTFilterType.NOT_DOWNLOAD_FILE;
                                    if (value23 == fTFilterType) {
                                        qQTransferDownloadActivity.viewModel.filterFileType(fTFilterType);
                                    }
                                }
                                if (qQTransferDownloadActivity.isPageVisible.getValue().booleanValue()) {
                                    if (caVar.f446239j) {
                                        QQKuiklyPlatformApi.Companion.qqToast("\u6587\u4ef6\u5df2\u4e0b\u8f7d", QToastMode.Info);
                                        qQTransferDownloadActivity.viewModel.showFinishDownloadBar.setValue(Boolean.FALSE);
                                        KLog kLog4 = KLog.INSTANCE;
                                        StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("this=");
                                        m18.append(this);
                                        m18.append(" onFileSetDownloadTaskStatusChange \u6587\u4ef6\u5df2\u4e0b\u8f7d");
                                        kLog4.d("QQFTDownloadBarView", m18.toString());
                                    } else if (i18 == 2) {
                                        final QQTransferDownloadActivity qQTransferDownloadActivity2 = qQTransferDownloadActivity;
                                        TimerKt.c(updateValue, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetDownloadListener$1$onFileSetDownloadTaskStatusChange$1.2
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                if (QQTransferDownloadActivity.this.isPageVisible.getValue().booleanValue()) {
                                                    QQKuiklyPlatformApi.Companion.qqToast("\u4e0b\u8f7d\u6210\u529f", QToastMode.Success);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                    }
                                } else if (caVar.f446239j) {
                                    qQTransferDownloadActivity.viewModel.showFinishDownloadBar.setValue(Boolean.FALSE);
                                }
                                if (i18 == 2) {
                                    qQTransferDownloadActivity.viewModel.curDownLoadedBytesInterpolation.updateValue(caVar.f446233d, true);
                                }
                            }
                            KLog kLog5 = KLog.INSTANCE;
                            StringBuilder m19 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onFileSetDownLoadStatusChange fileSetDownLoadTaskStatus=");
                            m19.append(i18);
                            m19.append(" forceShowDownloadBar=");
                            m19.append(qQTransferDownloadActivity.viewModel.forceShowDownloadBar.getValue().booleanValue());
                            m19.append(" process=");
                            m19.append(qQTransferDownloadActivity.viewModel.progress.getValue().floatValue());
                            m19.append(" speed=");
                            ca value24 = qQTransferDownloadActivity.viewModel.fileSetDownLoadInfo.getValue();
                            m19.append(value24 != null ? UInt.m564boximpl(value24.f446235f) : null);
                            m19.append(" allWaitingStatusTask=");
                            m19.append(caVar.f446240k);
                            m19.append(" isAllFileAlreadyDownloaded=");
                            NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0.m(m19, caVar.f446239j, kLog5, "QQTransferDownloadActivity");
                            return Unit.INSTANCE;
                        }
                    });
                }

                @Override // ws3.di
                public final void onProfilerFileDidStartDownload(final String str7, final ws3.c cVar) {
                    final QQTransferDownloadActivity qQTransferDownloadActivity = QQTransferDownloadActivity.this;
                    SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetDownloadListener$1$onProfilerFileDidStartDownload$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            if (Intrinsics.areEqual(str7, qQTransferDownloadActivity.viewModel.fileSetId)) {
                                qQTransferDownloadActivity.viewModel.m119updateFileDownloadStatusjXDDuk8(cVar, 1, 0);
                                KLog kLog4 = KLog.INSTANCE;
                                StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onFileDidStartDownLoad filesetId=");
                                m18.append(str7);
                                m18.append(" id=");
                                NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(m18, cVar.f446228a, kLog4, "QQTransferDownloadActivity");
                            }
                            return Unit.INSTANCE;
                        }
                    });
                }

                @Override // ws3.di
                /* renamed from: onProfilerFileDownloadProgressChanged-RQJlUXk, reason: not valid java name */
                public final void mo129onProfilerFileDownloadProgressChangedRQJlUXk(final String str7, final ws3.c cVar, final long j3, final long j16) {
                    final QQTransferDownloadActivity qQTransferDownloadActivity = QQTransferDownloadActivity.this;
                    SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetDownloadListener$1$onProfilerFileDownloadProgressChanged$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            int compare;
                            int compare2;
                            if (Intrinsics.areEqual(str7, qQTransferDownloadActivity.viewModel.fileSetId)) {
                                qQTransferDownloadActivity.viewModel.downloadProcessMap.put(cVar.f446228a, Float.valueOf(((float) UnsignedKt.ulongToDouble(j3)) / ((float) UnsignedKt.ulongToDouble(j16))));
                                if (!qQTransferDownloadActivity.viewModel.downloadingFileList.containsKey(cVar.f446228a)) {
                                    ab abVar = new ab();
                                    ws3.c cVar2 = cVar;
                                    String str8 = cVar2.f446228a;
                                    abVar.f446151b = str8;
                                    abVar.f446152c = cVar2.f446229b;
                                    abVar.C = 2;
                                    abVar.f446150a = str7;
                                    qQTransferDownloadActivity.viewModel.downloadingFileList.put(str8, abVar);
                                }
                                bp bpVar = qQTransferDownloadActivity.viewModel.fileLists;
                                if (bpVar != null) {
                                    ws3.c cVar3 = cVar;
                                    long j17 = j3;
                                    long j18 = j16;
                                    for (ab abVar2 : bpVar.f446183a) {
                                        if (Intrinsics.areEqual(abVar2.f446151b, cVar3.f446228a)) {
                                            compare2 = Long.compare(j17 ^ Long.MIN_VALUE, j18 ^ Long.MIN_VALUE);
                                            if (compare2 < 0) {
                                                abVar2.C = 2;
                                            }
                                        }
                                    }
                                }
                                if (UnsignedKt.ulongCompare(j3, ULong.m648constructorimpl(0L)) > 0) {
                                    qQTransferDownloadActivity.viewModel.forceShowDownloadBar.setValue(Boolean.FALSE);
                                }
                                if (qQTransferDownloadActivity.viewModel.downloadFailedFileList.containsKey(cVar.f446228a)) {
                                    compare = Long.compare(j3 ^ Long.MIN_VALUE, j16 ^ Long.MIN_VALUE);
                                    if (compare < 0) {
                                        QQFTFailedFileInfo qQFTFailedFileInfo = qQTransferDownloadActivity.viewModel.downloadFailedFileList.get(cVar.f446228a);
                                        if (qQFTFailedFileInfo != null) {
                                            qQFTFailedFileInfo.process$delegate.setValue(Float.valueOf(((float) UnsignedKt.ulongToDouble(j3)) / ((float) UnsignedKt.ulongToDouble(j16))));
                                        }
                                        QQFTFailedFileInfo qQFTFailedFileInfo2 = qQTransferDownloadActivity.viewModel.downloadFailedFileList.get(cVar.f446228a);
                                        if (qQFTFailedFileInfo2 != null) {
                                            qQFTFailedFileInfo2.setDownloadStatus(2);
                                        }
                                    }
                                }
                                qQTransferDownloadActivity.viewModel.m119updateFileDownloadStatusjXDDuk8(cVar, 2, 0);
                            }
                            KLog kLog4 = KLog.INSTANCE;
                            StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onFileDownLoadProgressChanged id=");
                            m18.append(cVar.f446228a);
                            m18.append(" hasDownLoadedBytes=");
                            NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(QQFlashTransferViewModel$fetchCompressedFileFolder$2$$ExternalSyntheticOutline0.m(j16, QQFlashTransferViewModel$fetchCompressedFileFolder$2$$ExternalSyntheticOutline0.m(j3, m18, " totalBytes="), " file.fileSetId="), str7, kLog4, "QQTransferDownloadActivity");
                            return Unit.INSTANCE;
                        }
                    });
                }

                @Override // ws3.di
                public final void onProfilerFileListDidFinishDownload(final String str7, final List<w> list3) {
                    final QQTransferDownloadActivity qQTransferDownloadActivity = QQTransferDownloadActivity.this;
                    SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetDownloadListener$1$onProfilerFileListDidFinishDownload$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            x xVar5;
                            List<ab> list4;
                            String str8 = str7;
                            br value15 = qQTransferDownloadActivity.viewModel.fileSet.getValue();
                            if (Intrinsics.areEqual(str8, value15 != null ? value15.f446187a : null)) {
                                for (w wVar : list3) {
                                    qQTransferDownloadActivity.viewModel.downloadingFileList.remove(wVar.f446399a.f446228a);
                                    qQTransferDownloadActivity.viewModel.selectFilesToDownload.remove(wVar.f446399a.f446228a);
                                    qQTransferDownloadActivity.viewModel.m119updateFileDownloadStatusjXDDuk8(wVar.f446399a, 3, 0);
                                    bp bpVar = qQTransferDownloadActivity.viewModel.fileLists;
                                    if (bpVar != null && (list4 = bpVar.f446183a) != null) {
                                        Iterator<ab> it = list4.iterator();
                                        while (true) {
                                            if (it.hasNext()) {
                                                ab next = it.next();
                                                if (Intrinsics.areEqual(next.f446151b, wVar.f446399a.f446228a)) {
                                                    next.f446172w = wVar.f446400b;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                                br value16 = qQTransferDownloadActivity.viewModel.fileSet.getValue();
                                if (value16 != null && (xVar5 = value16.f446198l) != null) {
                                    xVar5.f446402b = UInt.m570constructorimpl(UInt.m570constructorimpl(list3.size()) + xVar5.f446402b);
                                }
                            }
                            KLog kLog4 = KLog.INSTANCE;
                            StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onProfilerFileListDidFinishDownload filesetId=");
                            m18.append(str7);
                            m18.append(" size=");
                            m18.append(list3.size());
                            kLog4.d("QQTransferDownloadActivity", m18.toString());
                            return Unit.INSTANCE;
                        }
                    });
                }

                @Override // ws3.di
                /* renamed from: onProfilerFileListDownloadDidCancel-jXDDuk8, reason: not valid java name */
                public final void mo130onProfilerFileListDownloadDidCanceljXDDuk8(final String str7, final List list3) {
                    final QQTransferDownloadActivity qQTransferDownloadActivity = QQTransferDownloadActivity.this;
                    SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetDownloadListener$1$onProfilerFileListDownloadDidCancel$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            String str8 = str7;
                            br value15 = qQTransferDownloadActivity.viewModel.fileSet.getValue();
                            if (Intrinsics.areEqual(str8, value15 != null ? value15.f446187a : null)) {
                                for (ws3.c cVar : list3) {
                                    qQTransferDownloadActivity.viewModel.m119updateFileDownloadStatusjXDDuk8(cVar, 6, 0);
                                    qQTransferDownloadActivity.viewModel.downloadingFileList.remove(cVar.f446228a);
                                    if (qQTransferDownloadActivity.viewModel.downloadingFileList.size() == 0) {
                                        qQTransferDownloadActivity.viewModel.inProgressAnim.setValue(Boolean.FALSE);
                                    }
                                }
                            }
                            KLog kLog4 = KLog.INSTANCE;
                            StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onProfilerFileListDownloadDidCancel filesetId=");
                            m18.append(str7);
                            m18.append(" size=");
                            m18.append(list3.size());
                            kLog4.d("QQTransferDownloadActivity", m18.toString());
                            return Unit.INSTANCE;
                        }
                    });
                }

                @Override // ws3.di
                public final void onProfilerFileListDownloadDidError(final String str7, final List<v> list3) {
                    final QQTransferDownloadActivity qQTransferDownloadActivity = QQTransferDownloadActivity.this;
                    SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetDownloadListener$1$onProfilerFileListDownloadDidError$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            String str8 = str7;
                            br value15 = qQTransferDownloadActivity.viewModel.fileSet.getValue();
                            if (Intrinsics.areEqual(str8, value15 != null ? value15.f446187a : null)) {
                                for (v vVar : list3) {
                                    qQTransferDownloadActivity.viewModel.downloadingFileList.remove(vVar.f446397a.f446228a);
                                    int size = qQTransferDownloadActivity.viewModel.downloadFailedFileList.size();
                                    qQTransferDownloadActivity.viewModel.m119updateFileDownloadStatusjXDDuk8(vVar.f446397a, 5, vVar.f446398b);
                                    if (qQTransferDownloadActivity.viewModel.downloadingFileList.size() == 0) {
                                        qQTransferDownloadActivity.viewModel.inProgressAnim.setValue(Boolean.FALSE);
                                    }
                                    if (size == 0) {
                                        qQTransferDownloadActivity.viewModel.updateDownloadFailedFileList();
                                    }
                                }
                            }
                            KLog kLog4 = KLog.INSTANCE;
                            StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onProfilerFileListDownloadDidError filesetId=");
                            m18.append(str7);
                            m18.append(" size=");
                            m18.append(list3.size());
                            kLog4.d("QQTransferDownloadActivity", m18.toString());
                            return Unit.INSTANCE;
                        }
                    });
                }

                @Override // ws3.di
                /* renamed from: onProfilerFileListDownloadDidPause-jXDDuk8, reason: not valid java name */
                public final void mo131onProfilerFileListDownloadDidPausejXDDuk8(final String str7, final List<ws3.c> list3, final int i18) {
                    final QQTransferDownloadActivity qQTransferDownloadActivity = QQTransferDownloadActivity.this;
                    SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetDownloadListener$1$onProfilerFileListDownloadDidPause$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            String str8 = str7;
                            br value15 = qQTransferDownloadActivity.viewModel.fileSet.getValue();
                            if (Intrinsics.areEqual(str8, value15 != null ? value15.f446187a : null)) {
                                Iterator<ws3.c> it = list3.iterator();
                                while (it.hasNext()) {
                                    qQTransferDownloadActivity.viewModel.m119updateFileDownloadStatusjXDDuk8(it.next(), 4, 0);
                                }
                            }
                            KLog kLog4 = KLog.INSTANCE;
                            StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onProfilerFileListDownloadDidPause filesetId=");
                            m18.append(str7);
                            m18.append(" size=");
                            StringBuilder m19 = NearbyFDPageViewModel$$ExternalSyntheticOutline0.m(list3, m18, " reason=");
                            m19.append((Object) UInt.m615toStringimpl(i18));
                            kLog4.d("QQTransferDownloadActivity", m19.toString());
                            return Unit.INSTANCE;
                        }
                    });
                }

                @Override // ws3.di
                public final void onProfilerFileListDownloadWaitDownloading(final String str7, final List<ws3.c> list3) {
                    final QQTransferDownloadActivity qQTransferDownloadActivity = QQTransferDownloadActivity.this;
                    SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetDownloadListener$1$onProfilerFileListDownloadWaitDownloading$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            if (Intrinsics.areEqual(str7, qQTransferDownloadActivity.viewModel.fileSetId)) {
                                Iterator<ws3.c> it = list3.iterator();
                                while (it.hasNext()) {
                                    qQTransferDownloadActivity.viewModel.m119updateFileDownloadStatusjXDDuk8(it.next(), 1, 0);
                                }
                            }
                            NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(NearbyFDPageViewModel$$ExternalSyntheticOutline0.m(list3, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onProfilerFileListDownloadWaitDownloading size="), " filesetId="), str7, KLog.INSTANCE, "QQTransferDownloadActivity");
                            return Unit.INSTANCE;
                        }
                    });
                }

                @Override // ws3.di
                public final void onThumbnailDownloadResult(final List<cc> list3) {
                    SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetDownloadListener$1$onThumbnailDownloadResult$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            KLog kLog4 = KLog.INSTANCE;
                            StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onFileCoverDownLoadFinished ");
                            m18.append(list3);
                            kLog4.d("QQTransferDownloadActivity", m18.toString());
                            return Unit.INSTANCE;
                        }
                    });
                }

                @Override // ws3.di
                public final void onUserDownloadOperationResultNotify(final eu euVar) {
                    final QQTransferDownloadActivity qQTransferDownloadActivity = QQTransferDownloadActivity.this;
                    SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetDownloadListener$1$onUserDownloadOperationResultNotify$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            String str7;
                            if (Intrinsics.areEqual(eu.this.f446365a, qQTransferDownloadActivity.viewModel.fileSetId) && !eu.this.f446366b.isEmpty()) {
                                int size = eu.this.f446368d.size();
                                int size2 = eu.this.f446369e.size();
                                if (eu.this.f446366b.size() == size) {
                                    str7 = "\u6587\u4ef6\u5ba1\u6838\u4e2d\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\u3002";
                                } else if (size > 0 && size2 > 0) {
                                    str7 = size2 + "\u4e2a\u6587\u4ef6\u4e0a\u4f20\u5931\u8d25\uff0c" + size + "\u4e2a\u6587\u4ef6\u5ba1\u6838\u4e2d\uff0c\u6682\u65f6\u65e0\u6cd5\u4e0b\u8f7d";
                                } else if (size > 0) {
                                    str7 = size + "\u4e2a\u6587\u4ef6\u5ba1\u6838\u4e2d\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                                } else if (size2 > 0) {
                                    str7 = size2 + "\u4e2a\u6587\u4ef6\u4e0a\u4f20\u5931\u8d25\uff0c\u65e0\u6cd5\u4e0b\u8f7d";
                                } else {
                                    str7 = null;
                                }
                                if (str7 != null) {
                                    QQKuiklyPlatformApi.Companion.qqToast(str7, QToastMode.Warning);
                                }
                                KLog kLog4 = KLog.INSTANCE;
                                StringBuilder m18 = NearbyFDPageViewModel$$ExternalSyntheticOutline0.m(eu.this.f446369e, NearbyFDPageViewModel$$ExternalSyntheticOutline0.m(eu.this.f446368d, NearbyFDPageViewModel$$ExternalSyntheticOutline0.m(eu.this.f446367c, NearbyFDPageViewModel$$ExternalSyntheticOutline0.m(eu.this.f446366b, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onUserDownloadOperationResultNotify allFileSize="), " safeBeatFileSize="), " pendingFileSize="), " uploadFailedFileList="), " downloadRunningFileList=");
                                m18.append(eu.this.f446370f.size());
                                m18.append(TokenParser.SP);
                                kLog4.d("QQTransferDownloadActivity", m18.toString());
                            }
                            return Unit.INSTANCE;
                        }
                    });
                }

                @Override // ws3.di
                public final void onFileDidStartDownload() {
                }

                @Override // ws3.di
                /* renamed from: onFileDownloadProgressChanged-ZFynlJw, reason: not valid java name */
                public final void mo127onFileDownloadProgressChangedZFynlJw() {
                }

                @Override // ws3.di
                public final void onFileListDidFinishDownload() {
                }

                @Override // ws3.di
                public final void onFileListDownloadWaitDownloading() {
                }
            };
            IKernelFlashTransferService.a aVar3 = IKernelFlashTransferService.f344757i;
            IKernelFlashTransferService a18 = aVar3.a();
            final QQTransferDownloadActivity$addFileSetDownloadListener$1 qQTransferDownloadActivity$addFileSetDownloadListener$12 = this.downloadListener;
            Intrinsics.checkNotNull(qQTransferDownloadActivity$addFileSetDownloadListener$12);
            a18.getClass();
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(String.valueOf(qQTransferDownloadActivity$addFileSetDownloadListener$12.hashCode()));
            Function1<Object, Unit> function12 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$addFileSetDownloadListener$fileSetDownloadListener$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    List emptyList;
                    List emptyList2;
                    List emptyList3;
                    List emptyList4;
                    List emptyList5;
                    Object[] objArr = obj instanceof Object[] ? (Object[]) obj : null;
                    if (objArr != null) {
                        int i18 = 0;
                        if (!(objArr.length == 0)) {
                            Iterator it = ArrayIteratorKt.iterator(objArr);
                            String str7 = (String) dr.a(it, "null cannot be cast to non-null type kotlin.String");
                            switch (str7.hashCode()) {
                                case -1914822280:
                                    if (str7.equals("onProfilerFileListDidFinishDownload")) {
                                        Object next = it.next();
                                        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
                                        String str8 = (String) next;
                                        Object next2 = it.next();
                                        Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue = ((Integer) next2).intValue();
                                        ArrayList arrayList4 = new ArrayList();
                                        for (int i19 = 0; i19 < intValue; i19++) {
                                            Object next3 = it.next();
                                            Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int");
                                            int intValue2 = ((Integer) next3).intValue();
                                            Object[] objArr2 = new Object[intValue2];
                                            for (int i26 = 0; i26 < intValue2; i26++) {
                                                objArr2[i26] = it.next();
                                            }
                                            Iterator it5 = ArrayIteratorKt.iterator(objArr2);
                                            w wVar = new w(null, null, 3, null);
                                            while (it5.hasNext()) {
                                                Object next4 = it5.next();
                                                if (Intrinsics.areEqual(next4, "fileInfo")) {
                                                    Object next5 = it5.next();
                                                    Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.Int");
                                                    int intValue3 = ((Integer) next5).intValue();
                                                    Object[] objArr3 = new Object[intValue3];
                                                    for (int i27 = 0; i27 < intValue3; i27++) {
                                                        objArr3[i27] = it5.next();
                                                    }
                                                    wVar.f446399a = ws3.d.a(objArr3);
                                                } else if (Intrinsics.areEqual(next4, "savePath")) {
                                                    Object next6 = it5.next();
                                                    Intrinsics.checkNotNull(next6, "null cannot be cast to non-null type kotlin.String");
                                                    wVar.f446400b = (String) next6;
                                                }
                                            }
                                            arrayList4.add(wVar);
                                        }
                                        di.this.onProfilerFileListDidFinishDownload(str8, arrayList4);
                                        break;
                                    }
                                    break;
                                case -1578573457:
                                    if (str7.equals("onProfilerFileDidStartDownload")) {
                                        Object next7 = it.next();
                                        Intrinsics.checkNotNull(next7, "null cannot be cast to non-null type kotlin.String");
                                        String str9 = (String) next7;
                                        Object next8 = it.next();
                                        Intrinsics.checkNotNull(next8, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue4 = ((Integer) next8).intValue();
                                        Object[] objArr4 = new Object[intValue4];
                                        for (int i28 = 0; i28 < intValue4; i28++) {
                                            objArr4[i28] = it.next();
                                        }
                                        di.this.onProfilerFileDidStartDownload(str9, ws3.d.a(objArr4));
                                        break;
                                    }
                                    break;
                                case -1255944712:
                                    if (str7.equals("onFileListDownloadDidCancel")) {
                                        Object next9 = it.next();
                                        Intrinsics.checkNotNull(next9, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue5 = ((Integer) next9).intValue();
                                        ArrayList arrayList5 = new ArrayList();
                                        for (int i29 = 0; i29 < intValue5; i29++) {
                                            Object next10 = it.next();
                                            Intrinsics.checkNotNull(next10, "null cannot be cast to non-null type kotlin.Int");
                                            int intValue6 = ((Integer) next10).intValue();
                                            Object[] objArr5 = new Object[intValue6];
                                            for (int i36 = 0; i36 < intValue6; i36++) {
                                                objArr5[i36] = it.next();
                                            }
                                            arrayList5.add(bo.b(objArr5));
                                        }
                                        di.this.onFileListDownloadDidCancel(arrayList5);
                                        break;
                                    }
                                    break;
                                case -1139409178:
                                    if (str7.equals("onFileDidStartDownload")) {
                                        Object next11 = it.next();
                                        Intrinsics.checkNotNull(next11, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue7 = ((Integer) next11).intValue();
                                        Object[] objArr6 = new Object[intValue7];
                                        for (int i37 = 0; i37 < intValue7; i37++) {
                                            objArr6[i37] = it.next();
                                        }
                                        bo.b(objArr6);
                                        di.this.onFileDidStartDownload();
                                        break;
                                    }
                                    break;
                                case -895465564:
                                    if (str7.equals("onFileDownloadProgressChanged")) {
                                        Object next12 = it.next();
                                        Intrinsics.checkNotNull(next12, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue8 = ((Integer) next12).intValue();
                                        Object[] objArr7 = new Object[intValue8];
                                        for (int i38 = 0; i38 < intValue8; i38++) {
                                            objArr7[i38] = it.next();
                                        }
                                        bo.b(objArr7);
                                        Object next13 = it.next();
                                        Intrinsics.checkNotNull(next13, "null cannot be cast to non-null type kotlin.String");
                                        vs3.a.b((String) next13);
                                        Object next14 = it.next();
                                        Intrinsics.checkNotNull(next14, "null cannot be cast to non-null type kotlin.String");
                                        vs3.a.b((String) next14);
                                        di.this.mo127onFileDownloadProgressChangedZFynlJw();
                                        break;
                                    }
                                    break;
                                case -868296820:
                                    if (str7.equals("onFileDownloadDidError")) {
                                        Object next15 = it.next();
                                        Intrinsics.checkNotNull(next15, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue9 = ((Integer) next15).intValue();
                                        Object[] objArr8 = new Object[intValue9];
                                        for (int i39 = 0; i39 < intValue9; i39++) {
                                            objArr8[i39] = it.next();
                                        }
                                        ab b16 = bo.b(objArr8);
                                        Object next16 = it.next();
                                        Intrinsics.checkNotNull(next16, "null cannot be cast to non-null type kotlin.String");
                                        vs3.a.a((String) next16);
                                        Object next17 = it.next();
                                        Intrinsics.checkNotNull(next17, "null cannot be cast to non-null type kotlin.String");
                                        di.this.mo126onFileDownloadDidErrorOsBMiQA(b16);
                                        break;
                                    }
                                    break;
                                case -454272261:
                                    if (str7.equals("onUserDownloadOperationResultNotify")) {
                                        Object next18 = it.next();
                                        Intrinsics.checkNotNull(next18, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue10 = ((Integer) next18).intValue();
                                        Object[] objArr9 = new Object[intValue10];
                                        for (int i46 = 0; i46 < intValue10; i46++) {
                                            objArr9[i46] = it.next();
                                        }
                                        Iterator it6 = ArrayIteratorKt.iterator(objArr9);
                                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                                        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                                        emptyList3 = CollectionsKt__CollectionsKt.emptyList();
                                        emptyList4 = CollectionsKt__CollectionsKt.emptyList();
                                        emptyList5 = CollectionsKt__CollectionsKt.emptyList();
                                        eu euVar = new eu("", emptyList, emptyList2, emptyList3, emptyList4, emptyList5);
                                        while (it6.hasNext()) {
                                            Object next19 = it6.next();
                                            if (Intrinsics.areEqual(next19, "fileSetId")) {
                                                Object next20 = it6.next();
                                                Intrinsics.checkNotNull(next20, "null cannot be cast to non-null type kotlin.String");
                                                euVar.f446365a = (String) next20;
                                            } else if (Intrinsics.areEqual(next19, "allFileList")) {
                                                Object next21 = it6.next();
                                                Intrinsics.checkNotNull(next21, "null cannot be cast to non-null type kotlin.Int");
                                                int intValue11 = ((Integer) next21).intValue();
                                                ArrayList arrayList6 = new ArrayList(intValue11);
                                                for (int i47 = 0; i47 < intValue11; i47++) {
                                                    Object next22 = it6.next();
                                                    Intrinsics.checkNotNull(next22, "null cannot be cast to non-null type kotlin.String");
                                                    arrayList6.add((String) next22);
                                                }
                                                euVar.f446366b = arrayList6;
                                            } else if (Intrinsics.areEqual(next19, "safeBeatFileList")) {
                                                Object next23 = it6.next();
                                                Intrinsics.checkNotNull(next23, "null cannot be cast to non-null type kotlin.Int");
                                                int intValue12 = ((Integer) next23).intValue();
                                                ArrayList arrayList7 = new ArrayList(intValue12);
                                                for (int i48 = 0; i48 < intValue12; i48++) {
                                                    Object next24 = it6.next();
                                                    Intrinsics.checkNotNull(next24, "null cannot be cast to non-null type kotlin.String");
                                                    arrayList7.add((String) next24);
                                                }
                                                euVar.f446367c = arrayList7;
                                            } else if (Intrinsics.areEqual(next19, "safePendingFileList")) {
                                                Object next25 = it6.next();
                                                Intrinsics.checkNotNull(next25, "null cannot be cast to non-null type kotlin.Int");
                                                int intValue13 = ((Integer) next25).intValue();
                                                ArrayList arrayList8 = new ArrayList(intValue13);
                                                for (int i49 = 0; i49 < intValue13; i49++) {
                                                    Object next26 = it6.next();
                                                    Intrinsics.checkNotNull(next26, "null cannot be cast to non-null type kotlin.String");
                                                    arrayList8.add((String) next26);
                                                }
                                                euVar.f446368d = arrayList8;
                                            } else if (Intrinsics.areEqual(next19, "uploadFailedFileList")) {
                                                Object next27 = it6.next();
                                                Intrinsics.checkNotNull(next27, "null cannot be cast to non-null type kotlin.Int");
                                                int intValue14 = ((Integer) next27).intValue();
                                                ArrayList arrayList9 = new ArrayList(intValue14);
                                                for (int i56 = 0; i56 < intValue14; i56++) {
                                                    Object next28 = it6.next();
                                                    Intrinsics.checkNotNull(next28, "null cannot be cast to non-null type kotlin.String");
                                                    arrayList9.add((String) next28);
                                                }
                                                euVar.f446369e = arrayList9;
                                            } else if (Intrinsics.areEqual(next19, "downloadRunningFileList")) {
                                                Object next29 = it6.next();
                                                Intrinsics.checkNotNull(next29, "null cannot be cast to non-null type kotlin.Int");
                                                int intValue15 = ((Integer) next29).intValue();
                                                ArrayList arrayList10 = new ArrayList(intValue15);
                                                for (int i57 = 0; i57 < intValue15; i57++) {
                                                    Object next30 = it6.next();
                                                    Intrinsics.checkNotNull(next30, "null cannot be cast to non-null type kotlin.String");
                                                    arrayList10.add((String) next30);
                                                }
                                                euVar.f446370f = arrayList10;
                                            }
                                        }
                                        di.this.onUserDownloadOperationResultNotify(euVar);
                                        break;
                                    }
                                    break;
                                case 127684916:
                                    if (str7.equals("onFileDownloadSpeedChange")) {
                                        Object next31 = it.next();
                                        Intrinsics.checkNotNull(next31, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue16 = ((Integer) next31).intValue();
                                        Object[] objArr10 = new Object[intValue16];
                                        for (int i58 = 0; i58 < intValue16; i58++) {
                                            objArr10[i58] = it.next();
                                        }
                                        ab b17 = bo.b(objArr10);
                                        Object next32 = it.next();
                                        Intrinsics.checkNotNull(next32, "null cannot be cast to non-null type kotlin.String");
                                        int a19 = vs3.a.a((String) next32);
                                        Object next33 = it.next();
                                        Intrinsics.checkNotNull(next33, "null cannot be cast to non-null type kotlin.String");
                                        di.this.mo128onFileDownloadSpeedChangeBltQuoY(b17, a19, vs3.a.a((String) next33));
                                        break;
                                    }
                                    break;
                                case 258725473:
                                    if (str7.equals("onFileListDidFinishDownload")) {
                                        Object next34 = it.next();
                                        Intrinsics.checkNotNull(next34, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue17 = ((Integer) next34).intValue();
                                        ArrayList arrayList11 = new ArrayList();
                                        for (int i59 = 0; i59 < intValue17; i59++) {
                                            Object next35 = it.next();
                                            Intrinsics.checkNotNull(next35, "null cannot be cast to non-null type kotlin.Int");
                                            int intValue18 = ((Integer) next35).intValue();
                                            Object[] objArr11 = new Object[intValue18];
                                            for (int i65 = 0; i65 < intValue18; i65++) {
                                                objArr11[i65] = it.next();
                                            }
                                            arrayList11.add(bo.b(objArr11));
                                        }
                                        di.this.onFileListDidFinishDownload();
                                        break;
                                    }
                                    break;
                                case 299869682:
                                    if (str7.equals("onThumbnailDownloadResult")) {
                                        Object next36 = it.next();
                                        Intrinsics.checkNotNull(next36, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue19 = ((Integer) next36).intValue();
                                        ArrayList arrayList12 = new ArrayList();
                                        for (int i66 = 0; i66 < intValue19; i66++) {
                                            Object next37 = it.next();
                                            Intrinsics.checkNotNull(next37, "null cannot be cast to non-null type kotlin.Int");
                                            int intValue20 = ((Integer) next37).intValue();
                                            Object[] objArr12 = new Object[intValue20];
                                            for (int i67 = 0; i67 < intValue20; i67++) {
                                                objArr12[i67] = it.next();
                                            }
                                            Iterator it7 = ArrayIteratorKt.iterator(objArr12);
                                            cc ccVar = new cc();
                                            while (it7.hasNext()) {
                                                Object next38 = it7.next();
                                                if (Intrinsics.areEqual(next38, "result")) {
                                                    Object next39 = it7.next();
                                                    Intrinsics.checkNotNull(next39, "null cannot be cast to non-null type kotlin.String");
                                                    vs3.a.a((String) next39);
                                                } else if (Intrinsics.areEqual(next38, "originInfo")) {
                                                    Object next40 = it7.next();
                                                    Intrinsics.checkNotNull(next40, "null cannot be cast to non-null type kotlin.Int");
                                                    int intValue21 = ((Integer) next40).intValue();
                                                    Object[] objArr13 = new Object[intValue21];
                                                    for (int i68 = 0; i68 < intValue21; i68++) {
                                                        objArr13[i68] = it7.next();
                                                    }
                                                    Iterator it8 = ArrayIteratorKt.iterator(objArr13);
                                                    while (it8.hasNext()) {
                                                        Object next41 = it8.next();
                                                        if (Intrinsics.areEqual(next41, "fileSetId")) {
                                                            Object next42 = it8.next();
                                                            Intrinsics.checkNotNull(next42, "null cannot be cast to non-null type kotlin.String");
                                                        } else if (Intrinsics.areEqual(next41, "fileId")) {
                                                            Object next43 = it8.next();
                                                            Intrinsics.checkNotNull(next43, "null cannot be cast to non-null type kotlin.String");
                                                        } else if (Intrinsics.areEqual(next41, "spec")) {
                                                            Object next44 = it8.next();
                                                            Intrinsics.checkNotNull(next44, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.SpecificationKt.Specification }");
                                                            ((Integer) next44).intValue();
                                                        } else if (Intrinsics.areEqual(next41, "url")) {
                                                            Object next45 = it8.next();
                                                            Intrinsics.checkNotNull(next45, "null cannot be cast to non-null type kotlin.String");
                                                        }
                                                    }
                                                } else if (Intrinsics.areEqual(next38, "thumbnailDiskPath")) {
                                                    Object next46 = it7.next();
                                                    Intrinsics.checkNotNull(next46, "null cannot be cast to non-null type kotlin.String");
                                                }
                                            }
                                            arrayList12.add(ccVar);
                                        }
                                        di.this.onThumbnailDownloadResult(arrayList12);
                                        break;
                                    }
                                    break;
                                case 321353459:
                                    if (str7.equals("onFileSetDownloadTaskProgressChanged")) {
                                        Object next47 = it.next();
                                        Intrinsics.checkNotNull(next47, "null cannot be cast to non-null type kotlin.String");
                                        String str10 = (String) next47;
                                        Object next48 = it.next();
                                        Intrinsics.checkNotNull(next48, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue22 = ((Integer) next48).intValue();
                                        Object[] objArr14 = new Object[intValue22];
                                        for (int i69 = 0; i69 < intValue22; i69++) {
                                            objArr14[i69] = it.next();
                                        }
                                        di.this.onFileSetDownloadTaskProgressChanged(str10, cb.a(objArr14));
                                        break;
                                    }
                                    break;
                                case 333152859:
                                    if (str7.equals("onProfilerFileListDownloadWaitDownloading")) {
                                        Object next49 = it.next();
                                        Intrinsics.checkNotNull(next49, "null cannot be cast to non-null type kotlin.String");
                                        String str11 = (String) next49;
                                        Object next50 = it.next();
                                        Intrinsics.checkNotNull(next50, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue23 = ((Integer) next50).intValue();
                                        ArrayList arrayList13 = new ArrayList();
                                        for (int i75 = 0; i75 < intValue23; i75++) {
                                            Object next51 = it.next();
                                            Intrinsics.checkNotNull(next51, "null cannot be cast to non-null type kotlin.Int");
                                            int intValue24 = ((Integer) next51).intValue();
                                            Object[] objArr15 = new Object[intValue24];
                                            for (int i76 = 0; i76 < intValue24; i76++) {
                                                objArr15[i76] = it.next();
                                            }
                                            arrayList13.add(ws3.d.a(objArr15));
                                        }
                                        di.this.onProfilerFileListDownloadWaitDownloading(str11, arrayList13);
                                        break;
                                    }
                                    break;
                                case 865474831:
                                    if (str7.equals("onProfilerFileListDownloadDidCancel")) {
                                        Object next52 = it.next();
                                        Intrinsics.checkNotNull(next52, "null cannot be cast to non-null type kotlin.String");
                                        String str12 = (String) next52;
                                        Object next53 = it.next();
                                        Intrinsics.checkNotNull(next53, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue25 = ((Integer) next53).intValue();
                                        ArrayList arrayList14 = new ArrayList();
                                        for (int i77 = 0; i77 < intValue25; i77++) {
                                            Object next54 = it.next();
                                            Intrinsics.checkNotNull(next54, "null cannot be cast to non-null type kotlin.Int");
                                            int intValue26 = ((Integer) next54).intValue();
                                            Object[] objArr16 = new Object[intValue26];
                                            for (int i78 = 0; i78 < intValue26; i78++) {
                                                objArr16[i78] = it.next();
                                            }
                                            arrayList14.add(ws3.d.a(objArr16));
                                        }
                                        Object next55 = it.next();
                                        Intrinsics.checkNotNull(next55, "null cannot be cast to non-null type kotlin.String");
                                        vs3.a.a((String) next55);
                                        di.this.mo130onProfilerFileListDownloadDidCanceljXDDuk8(str12, arrayList14);
                                        break;
                                    }
                                    break;
                                case 1070222026:
                                    if (str7.equals("onFileListDownloadDidError")) {
                                        Object next56 = it.next();
                                        Intrinsics.checkNotNull(next56, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue27 = ((Integer) next56).intValue();
                                        ArrayList arrayList15 = new ArrayList();
                                        for (int i79 = 0; i79 < intValue27; i79++) {
                                            Object next57 = it.next();
                                            Intrinsics.checkNotNull(next57, "null cannot be cast to non-null type kotlin.Int");
                                            int intValue28 = ((Integer) next57).intValue();
                                            Object[] objArr17 = new Object[intValue28];
                                            for (int i85 = 0; i85 < intValue28; i85++) {
                                                objArr17[i85] = it.next();
                                            }
                                            arrayList15.add(bo.b(objArr17));
                                        }
                                        di.this.onFileListDownloadDidError(arrayList15);
                                        break;
                                    }
                                    break;
                                case 1079877304:
                                    if (str7.equals("onFileListDownloadDidPause")) {
                                        Object next58 = it.next();
                                        Intrinsics.checkNotNull(next58, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue29 = ((Integer) next58).intValue();
                                        ArrayList arrayList16 = new ArrayList();
                                        for (int i86 = 0; i86 < intValue29; i86++) {
                                            Object next59 = it.next();
                                            Intrinsics.checkNotNull(next59, "null cannot be cast to non-null type kotlin.Int");
                                            int intValue30 = ((Integer) next59).intValue();
                                            Object[] objArr18 = new Object[intValue30];
                                            for (int i87 = 0; i87 < intValue30; i87++) {
                                                objArr18[i87] = it.next();
                                            }
                                            arrayList16.add(bo.b(objArr18));
                                        }
                                        di.this.onFileListDownloadDidPause(arrayList16);
                                        break;
                                    }
                                    break;
                                case 1282582166:
                                    if (str7.equals("onFileSetDownloadTaskStatusChange")) {
                                        Object next60 = it.next();
                                        Intrinsics.checkNotNull(next60, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FileSetDownloadTaskStatusKt.FileSetDownloadTaskStatus }");
                                        int intValue31 = ((Integer) next60).intValue();
                                        Object next61 = it.next();
                                        Intrinsics.checkNotNull(next61, "null cannot be cast to non-null type kotlin.String");
                                        String str13 = (String) next61;
                                        Object next62 = it.next();
                                        Intrinsics.checkNotNull(next62, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue32 = ((Integer) next62).intValue();
                                        Object[] objArr19 = new Object[intValue32];
                                        for (int i88 = 0; i88 < intValue32; i88++) {
                                            objArr19[i88] = it.next();
                                        }
                                        di.this.onFileSetDownloadTaskStatusChange(intValue31, str13, cb.a(objArr19));
                                        break;
                                    }
                                    break;
                                case 1692844243:
                                    if (str7.equals("onProfilerFileListDownloadDidError")) {
                                        Object next63 = it.next();
                                        Intrinsics.checkNotNull(next63, "null cannot be cast to non-null type kotlin.String");
                                        String str14 = (String) next63;
                                        Object next64 = it.next();
                                        Intrinsics.checkNotNull(next64, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue33 = ((Integer) next64).intValue();
                                        ArrayList arrayList17 = new ArrayList();
                                        int i89 = 0;
                                        while (i89 < intValue33) {
                                            Object next65 = it.next();
                                            Intrinsics.checkNotNull(next65, "null cannot be cast to non-null type kotlin.Int");
                                            int intValue34 = ((Integer) next65).intValue();
                                            Object[] objArr20 = new Object[intValue34];
                                            for (int i95 = i18; i95 < intValue34; i95++) {
                                                objArr20[i95] = it.next();
                                            }
                                            Iterator it9 = ArrayIteratorKt.iterator(objArr20);
                                            v vVar = new v(new ws3.c(null, null, 3, null), i18);
                                            while (it9.hasNext()) {
                                                Object next66 = it9.next();
                                                if (Intrinsics.areEqual(next66, "fileInfo")) {
                                                    Object next67 = it9.next();
                                                    Intrinsics.checkNotNull(next67, "null cannot be cast to non-null type kotlin.Int");
                                                    int intValue35 = ((Integer) next67).intValue();
                                                    Object[] objArr21 = new Object[intValue35];
                                                    while (i18 < intValue35) {
                                                        objArr21[i18] = it9.next();
                                                        i18++;
                                                    }
                                                    vVar.f446397a = ws3.d.a(objArr21);
                                                } else if (Intrinsics.areEqual(next66, "errorCode")) {
                                                    Object next68 = it9.next();
                                                    Intrinsics.checkNotNull(next68, "null cannot be cast to non-null type kotlin.String");
                                                    vVar.f446398b = vs3.a.a((String) next68);
                                                }
                                                i18 = 0;
                                            }
                                            arrayList17.add(vVar);
                                            i89++;
                                            i18 = 0;
                                        }
                                        di.this.onProfilerFileListDownloadDidError(str14, arrayList17);
                                        break;
                                    }
                                    break;
                                case 1702499521:
                                    if (str7.equals("onProfilerFileListDownloadDidPause")) {
                                        Object next69 = it.next();
                                        Intrinsics.checkNotNull(next69, "null cannot be cast to non-null type kotlin.String");
                                        String str15 = (String) next69;
                                        Object next70 = it.next();
                                        Intrinsics.checkNotNull(next70, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue36 = ((Integer) next70).intValue();
                                        ArrayList arrayList18 = new ArrayList();
                                        for (int i96 = 0; i96 < intValue36; i96++) {
                                            Object next71 = it.next();
                                            Intrinsics.checkNotNull(next71, "null cannot be cast to non-null type kotlin.Int");
                                            int intValue37 = ((Integer) next71).intValue();
                                            Object[] objArr22 = new Object[intValue37];
                                            for (int i97 = 0; i97 < intValue37; i97++) {
                                                objArr22[i97] = it.next();
                                            }
                                            arrayList18.add(ws3.d.a(objArr22));
                                        }
                                        Object next72 = it.next();
                                        Intrinsics.checkNotNull(next72, "null cannot be cast to non-null type kotlin.String");
                                        di.this.mo131onProfilerFileListDownloadDidPausejXDDuk8(str15, arrayList18, vs3.a.a((String) next72));
                                        break;
                                    }
                                    break;
                                case 1974216955:
                                    if (str7.equals("onProfilerFileDownloadProgressChanged")) {
                                        Object next73 = it.next();
                                        Intrinsics.checkNotNull(next73, "null cannot be cast to non-null type kotlin.String");
                                        String str16 = (String) next73;
                                        Object next74 = it.next();
                                        Intrinsics.checkNotNull(next74, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue38 = ((Integer) next74).intValue();
                                        Object[] objArr23 = new Object[intValue38];
                                        while (i18 < intValue38) {
                                            objArr23[i18] = it.next();
                                            i18++;
                                        }
                                        ws3.c a26 = ws3.d.a(objArr23);
                                        Object next75 = it.next();
                                        Intrinsics.checkNotNull(next75, "null cannot be cast to non-null type kotlin.String");
                                        long b18 = vs3.a.b((String) next75);
                                        Object next76 = it.next();
                                        Intrinsics.checkNotNull(next76, "null cannot be cast to non-null type kotlin.String");
                                        di.this.mo129onProfilerFileDownloadProgressChangedRQJlUXk(str16, a26, b18, vs3.a.b((String) next76));
                                        break;
                                    }
                                    break;
                                case 2128487556:
                                    if (str7.equals("onFileListDownloadWaitDownloading")) {
                                        Object next77 = it.next();
                                        Intrinsics.checkNotNull(next77, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue39 = ((Integer) next77).intValue();
                                        ArrayList arrayList19 = new ArrayList();
                                        for (int i98 = 0; i98 < intValue39; i98++) {
                                            Object next78 = it.next();
                                            Intrinsics.checkNotNull(next78, "null cannot be cast to non-null type kotlin.Int");
                                            int intValue40 = ((Integer) next78).intValue();
                                            Object[] objArr24 = new Object[intValue40];
                                            for (int i99 = 0; i99 < intValue40; i99++) {
                                                objArr24[i99] = it.next();
                                            }
                                            arrayList19.add(bo.b(objArr24));
                                        }
                                        di.this.onFileListDownloadWaitDownloading();
                                        break;
                                    }
                                    break;
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
            };
            Object[] array3 = arrayList3.toArray(new Object[0]);
            Intrinsics.checkNotNull(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            a18.syncToNativeMethod(true, "addFileSetDownloadListener", array3, function12);
            a18.f344759b.put(qQTransferDownloadActivity$addFileSetDownloadListener$12, function12);
            IKernelFlashTransferService a19 = aVar3.a();
            String str7 = this.viewModel.fileSetId;
            final de deVar = new de() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$asyncRequestDownLoadStatus$1
                @Override // ws3.de
                public final void onResult(final int i18, final String str8, final int i19, final ca caVar) {
                    final QQTransferDownloadActivity qQTransferDownloadActivity = QQTransferDownloadActivity.this;
                    SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$asyncRequestDownLoadStatus$1$onResult$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            float f16;
                            QQTransferDownloadActivity.this.viewModel.fileSetDownLoadTaskStatus.setValue(Integer.valueOf(i19));
                            QQTransferDownloadActivity.this.viewModel.isDownloadPause.setValue(Boolean.valueOf(i19 == 4));
                            QQTransferDownloadActivity.this.viewModel.fileSetDownLoadInfo.setValue(caVar);
                            ca value15 = QQTransferDownloadActivity.this.viewModel.fileSetDownLoadInfo.getValue();
                            if (value15 != null) {
                                QQFTDownloadBarViewKt.m124updateSpeedqim9Vi0(value15.f446235f, QQTransferDownloadActivity.this.viewModel);
                            }
                            QQFlashTransferViewModel qQFlashTransferViewModel2 = QQTransferDownloadActivity.this.viewModel;
                            QQFTTransferSizeInterpolation qQFTTransferSizeInterpolation = qQFlashTransferViewModel2.curDownLoadedBytesInterpolation;
                            ca value16 = qQFlashTransferViewModel2.fileSetDownLoadInfo.getValue();
                            qQFTTransferSizeInterpolation.updateValue(value16 != null ? value16.f446233d : 0L, false);
                            QQFlashTransferViewModel qQFlashTransferViewModel3 = QQTransferDownloadActivity.this.viewModel;
                            MutableState<Float> mutableState = qQFlashTransferViewModel3.progress;
                            if (qQFlashTransferViewModel3.fileSetDownLoadInfo.getValue() != null) {
                                ca value17 = QQTransferDownloadActivity.this.viewModel.fileSetDownLoadInfo.getValue();
                                Float valueOf2 = value17 != null ? Float.valueOf((float) UnsignedKt.ulongToDouble(value17.f446233d)) : null;
                                Intrinsics.checkNotNull(valueOf2);
                                float floatValue = valueOf2.floatValue();
                                ca value18 = QQTransferDownloadActivity.this.viewModel.fileSetDownLoadInfo.getValue();
                                Float valueOf3 = value18 != null ? Float.valueOf((float) UnsignedKt.ulongToDouble(value18.f446234e)) : null;
                                Intrinsics.checkNotNull(valueOf3);
                                f16 = floatValue / valueOf3.floatValue();
                            } else {
                                f16 = 0.0f;
                            }
                            mutableState.setValue(Float.valueOf(f16));
                            KLog kLog4 = KLog.INSTANCE;
                            StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("asyncRequestDownLoadStatus result=");
                            m18.append(i18);
                            m18.append(" fileSetId=");
                            m18.append(str8);
                            m18.append(" curDownLoadFailFileNum=");
                            m18.append((Object) UInt.m615toStringimpl(caVar.f446230a));
                            m18.append(" fileSetDownLoadTaskStatus=");
                            m18.append(i19);
                            m18.append(" info.failFileIdList=");
                            m18.append(caVar.f446238i.size());
                            kLog4.d("QQTransferDownloadActivity", m18.toString());
                            QQTransferDownloadActivity.this.viewModel.updateDownloadFailedFileList();
                            return Unit.INSTANCE;
                        }
                    });
                }
            };
            a19.getClass();
            ArrayList m18 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m(str7);
            m18.add(String.valueOf(deVar.hashCode()));
            Function1<Object, Unit> function13 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$asyncRequestDownLoadStatus$kernelCallback$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    Object[] objArr = obj instanceof Object[] ? (Object[]) obj : null;
                    if (objArr != null) {
                        if (!(objArr.length == 0)) {
                            Iterator it = ArrayIteratorKt.iterator(objArr);
                            if (Intrinsics.areEqual((String) dr.a(it, "null cannot be cast to non-null type kotlin.String"), "onResult")) {
                                Object next = it.next();
                                Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
                                int intValue = ((Integer) next).intValue();
                                Object next2 = it.next();
                                Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
                                String str8 = (String) next2;
                                Object next3 = it.next();
                                Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FileSetDownloadTaskStatusKt.FileSetDownloadTaskStatus }");
                                int intValue2 = ((Integer) next3).intValue();
                                Object next4 = it.next();
                                Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.Int");
                                int intValue3 = ((Integer) next4).intValue();
                                Object[] objArr2 = new Object[intValue3];
                                for (int i18 = 0; i18 < intValue3; i18++) {
                                    objArr2[i18] = it.next();
                                }
                                de.this.onResult(intValue, str8, intValue2, cb.a(objArr2));
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
            };
            Object[] array4 = m18.toArray(new Object[0]);
            Intrinsics.checkNotNull(array4, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            a19.syncToNativeMethod(true, "asyncRequestDownLoadStatus", array4, function13);
            if (this.viewModel.isInUploading()) {
                if (this.uploadListener != null) {
                    IKernelFlashTransferService a26 = aVar3.a();
                    QQTransferDownloadActivity$addFileSetUploadListener$1 qQTransferDownloadActivity$addFileSetUploadListener$1 = this.uploadListener;
                    Intrinsics.checkNotNull(qQTransferDownloadActivity$addFileSetUploadListener$1);
                    a26.k(qQTransferDownloadActivity$addFileSetUploadListener$1);
                }
                this.uploadListener = new dp() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetUploadListener$1
                    @Override // ws3.dp
                    public final void onFileDidFinishUpload(final ab abVar) {
                        final QQTransferDownloadActivity qQTransferDownloadActivity = QQTransferDownloadActivity.this;
                        SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetUploadListener$1$onFileDidFinishUpload$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                if (Intrinsics.areEqual(ab.this.f446150a, qQTransferDownloadActivity.viewModel.fileSetId)) {
                                    qQTransferDownloadActivity.viewModel.updateFileUploadStatus(ab.this, 3);
                                }
                                KLog kLog4 = KLog.INSTANCE;
                                StringBuilder m19 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onFileDidFinishUpload name=");
                                m19.append(ab.this.f446160k);
                                m19.append(" uploadStatus=");
                                DatalineDetailViewModel$$ExternalSyntheticOutline0.m(m19, ab.this.B, kLog4, "QQTransferDownloadActivity");
                                return Unit.INSTANCE;
                            }
                        });
                    }

                    @Override // ws3.dp
                    public final void onFileDidStartUpload(final ab abVar) {
                        final QQTransferDownloadActivity qQTransferDownloadActivity = QQTransferDownloadActivity.this;
                        SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetUploadListener$1$onFileDidStartUpload$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                if (Intrinsics.areEqual(ab.this.f446150a, qQTransferDownloadActivity.viewModel.fileSetId)) {
                                    qQTransferDownloadActivity.viewModel.updateFileUploadStatus(ab.this, 1);
                                }
                                KLog kLog4 = KLog.INSTANCE;
                                StringBuilder m19 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onFileDidStartUpload name=");
                                m19.append(ab.this.f446160k);
                                m19.append(" uploadStatus=");
                                DatalineDetailViewModel$$ExternalSyntheticOutline0.m(m19, ab.this.B, kLog4, "QQTransferDownloadActivity");
                                return Unit.INSTANCE;
                            }
                        });
                    }

                    @Override // ws3.dp
                    public final void onFileSetUploadProgressChanged(final bv bvVar) {
                        SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetUploadListener$1$onFileSetUploadProgressChanged$1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                KLog kLog4 = KLog.INSTANCE;
                                StringBuilder m19 = QQFlashTransferViewModel$fetchCompressedFileFolder$2$$ExternalSyntheticOutline0.m(bv.this.f446216d, QQFlashTransferViewModel$fetchCompressedFileFolder$2$$ExternalSyntheticOutline0.m(bv.this.f446215c, QQFlashTransferViewModel$fetchCompressedFileFolder$2$$ExternalSyntheticOutline0.m(bv.this.f446214b, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onFileSetUploadProgressChanged uploadedFileCount="), " totalFileCount="), " uploadedFileSize="), " uploadSpeed=");
                                m19.append((Object) ULong.m693toStringimpl(bv.this.f446217e));
                                kLog4.d("QQTransferDownloadActivity", m19.toString());
                                return Unit.INSTANCE;
                            }
                        });
                    }

                    @Override // ws3.dp
                    public final void onFileSetUploadStatusChanged(final br brVar2) {
                        SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetUploadListener$1$onFileSetUploadStatusChanged$1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                DatalineDetailViewModel$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onFileSetUploadStatusChanged uploadStatus="), br.this.f446202p, KLog.INSTANCE, "QQTransferDownloadActivity");
                                return Unit.INSTANCE;
                            }
                        });
                    }

                    @Override // ws3.dp
                    public final void onFileStaticStatusChanged(final ab abVar) {
                        final QQTransferDownloadActivity qQTransferDownloadActivity = QQTransferDownloadActivity.this;
                        SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetUploadListener$1$onFileStaticStatusChanged$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                KLog kLog4 = KLog.INSTANCE;
                                StringBuilder m19 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onFileStaticStatusChanged name=");
                                m19.append(ab.this.f446160k);
                                m19.append(" status=");
                                m19.append(ab.this.A);
                                m19.append(" urlSize=");
                                m19.append(ab.this.f446166q.f446333b.size());
                                kLog4.d("QQTransferDownloadActivity", m19.toString());
                                QQFlashTransferViewModel qQFlashTransferViewModel2 = qQTransferDownloadActivity.viewModel;
                                ab abVar2 = ab.this;
                                Iterator<BaseComposeCardViewModel> it = qQFlashTransferViewModel2.feedListViewModel.feedCardViewModelList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    BaseComposeCardViewModel next = it.next();
                                    if (next instanceof QQFTFileDetailItemVM) {
                                        QQFTFileDetailItemVM qQFTFileDetailItemVM = (QQFTFileDetailItemVM) next;
                                        ab abVar3 = qQFTFileDetailItemVM.fileDetail;
                                        if (Intrinsics.areEqual(abVar3 != null ? abVar3.f446151b : null, abVar2.f446151b)) {
                                            qQFTFileDetailItemVM.fileStatus.setValue(Integer.valueOf(abVar2.A));
                                            ab abVar4 = qQFTFileDetailItemVM.fileDetail;
                                            if (abVar4 != null) {
                                                abVar4.A = abVar2.A;
                                            }
                                            if (abVar4 != null) {
                                                abVar4.f446160k = abVar2.f446160k;
                                            }
                                            if (abVar4 != null) {
                                                abVar4.f446166q = abVar2.f446166q;
                                            }
                                            qQFTFileDetailItemVM.updateThumbnailUrl(abVar2.f446166q);
                                        }
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        });
                    }

                    @Override // ws3.dp
                    public final void onFileUploadDidCancel(final ab abVar) {
                        final QQTransferDownloadActivity qQTransferDownloadActivity = QQTransferDownloadActivity.this;
                        SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetUploadListener$1$onFileUploadDidCancel$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                if (Intrinsics.areEqual(ab.this.f446150a, qQTransferDownloadActivity.viewModel.fileSetId)) {
                                    qQTransferDownloadActivity.viewModel.updateFileUploadStatus(ab.this, 6);
                                }
                                KLog kLog4 = KLog.INSTANCE;
                                StringBuilder m19 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onFileUploadDidCancel name=");
                                m19.append(ab.this.f446160k);
                                m19.append(" uploadStatus=");
                                DatalineDetailViewModel$$ExternalSyntheticOutline0.m(m19, ab.this.B, kLog4, "QQTransferDownloadActivity");
                                return Unit.INSTANCE;
                            }
                        });
                    }

                    @Override // ws3.dp
                    public final void onFileUploadDidError(final ab abVar) {
                        final QQTransferDownloadActivity qQTransferDownloadActivity = QQTransferDownloadActivity.this;
                        SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetUploadListener$1$onFileUploadDidError$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                if (Intrinsics.areEqual(ab.this.f446150a, qQTransferDownloadActivity.viewModel.fileSetId)) {
                                    qQTransferDownloadActivity.viewModel.updateFileUploadStatus(ab.this, 5);
                                }
                                KLog kLog4 = KLog.INSTANCE;
                                StringBuilder m19 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onFileUploadDidError name=");
                                m19.append(ab.this.f446160k);
                                m19.append(" uploadStatus=");
                                DatalineDetailViewModel$$ExternalSyntheticOutline0.m(m19, ab.this.B, kLog4, "QQTransferDownloadActivity");
                                return Unit.INSTANCE;
                            }
                        });
                    }

                    @Override // ws3.dp
                    /* renamed from: onFileUploadProgressChanged-ZFynlJw */
                    public final void mo121onFileUploadProgressChangedZFynlJw(final ab abVar, final long j3, final long j16) {
                        final QQTransferDownloadActivity qQTransferDownloadActivity = QQTransferDownloadActivity.this;
                        SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetUploadListener$1$onFileUploadProgressChanged$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                if (Intrinsics.areEqual(ab.this.f446150a, qQTransferDownloadActivity.viewModel.fileSetId)) {
                                    QQFlashTransferViewModel qQFlashTransferViewModel2 = qQTransferDownloadActivity.viewModel;
                                    ab abVar2 = ab.this;
                                    UnsignedKt.ulongToDouble(j3);
                                    UnsignedKt.ulongToDouble(j16);
                                    qQFlashTransferViewModel2.updateFileUploadStatus(abVar2, 2);
                                }
                                KLog kLog4 = KLog.INSTANCE;
                                StringBuilder m19 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onFileUploadProgressChanged name=");
                                m19.append(ab.this.f446160k);
                                m19.append(" uploadStatus=");
                                m19.append(ab.this.B);
                                m19.append(" uploadedBytes=");
                                StringBuilder m26 = QQFlashTransferViewModel$fetchCompressedFileFolder$2$$ExternalSyntheticOutline0.m(j3, m19, " totalBytes=");
                                m26.append((Object) ULong.m693toStringimpl(j16));
                                kLog4.d("QQTransferDownloadActivity", m26.toString());
                                return Unit.INSTANCE;
                            }
                        });
                    }

                    @Override // ws3.dp
                    public final void onFileUploadStatusChanged(final ab abVar) {
                        final QQTransferDownloadActivity qQTransferDownloadActivity = QQTransferDownloadActivity.this;
                        SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetUploadListener$1$onFileUploadStatusChanged$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                if (Intrinsics.areEqual(ab.this.f446150a, qQTransferDownloadActivity.viewModel.fileSetId)) {
                                    QQFlashTransferViewModel qQFlashTransferViewModel2 = qQTransferDownloadActivity.viewModel;
                                    ab abVar2 = ab.this;
                                    qQFlashTransferViewModel2.updateFileUploadStatus(abVar2, abVar2.B);
                                }
                                KLog kLog4 = KLog.INSTANCE;
                                StringBuilder m19 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onFileUploadStatusChanged name=");
                                m19.append(ab.this.f446160k);
                                m19.append(" uploadStatus=");
                                DatalineDetailViewModel$$ExternalSyntheticOutline0.m(m19, ab.this.B, kLog4, "QQTransferDownloadActivity");
                                return Unit.INSTANCE;
                            }
                        });
                    }

                    @Override // ws3.dp
                    public final void onThumbnailGeneratePath() {
                        SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetUploadListener$1$onThumbnailGeneratePath$1
                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                KLog.INSTANCE.d("QQTransferDownloadActivity", "onThumbnailGeneratePath.");
                                return Unit.INSTANCE;
                            }
                        });
                    }
                };
                IKernelFlashTransferService a27 = aVar3.a();
                QQTransferDownloadActivity$addFileSetUploadListener$1 qQTransferDownloadActivity$addFileSetUploadListener$12 = this.uploadListener;
                Intrinsics.checkNotNull(qQTransferDownloadActivity$addFileSetUploadListener$12);
                a27.b(qQTransferDownloadActivity$addFileSetUploadListener$12);
                if (this.uploadInfoFileSetStatusListener != null) {
                    IKernelFlashTransferService a28 = aVar3.a();
                    QQTransferDownloadActivity$addFileSetUploadListener$2 qQTransferDownloadActivity$addFileSetUploadListener$2 = this.uploadInfoFileSetStatusListener;
                    Intrinsics.checkNotNull(qQTransferDownloadActivity$addFileSetUploadListener$2);
                    a28.j(qQTransferDownloadActivity$addFileSetUploadListener$2);
                }
                this.uploadInfoFileSetStatusListener = new cy() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetUploadListener$2
                    @Override // ws3.cy
                    public final void onFileSetSimpleUploadInfoChanged(final List<bu> list3) {
                        final QQTransferDownloadActivity qQTransferDownloadActivity = QQTransferDownloadActivity.this;
                        SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetUploadListener$2$onFileSetSimpleUploadInfoChanged$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                Iterator<bu> it = list3.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    bu next = it.next();
                                    if (qQTransferDownloadActivity.viewModel.fileSet.getValue() != null && Intrinsics.areEqual(next.f446205a, qQTransferDownloadActivity.viewModel.fileSetId)) {
                                        qQTransferDownloadActivity.viewModel.uploadSucFileCount.setValue(Long.valueOf(next.f446208d));
                                        qQTransferDownloadActivity.viewModel.uploadProcess.setValue(Float.valueOf(((float) UnsignedKt.ulongToDouble(next.f446210f)) / ((float) UnsignedKt.ulongToDouble(next.f446211g))));
                                        qQTransferDownloadActivity.viewModel.uploadSpeed.setValue(ULong.m642boximpl(next.f446212h));
                                        if (qQTransferDownloadActivity.viewModel.isUploadCreator()) {
                                            if (qQTransferDownloadActivity.viewModel.uploadedFileSize.getValue().longValue() == 0) {
                                                qQTransferDownloadActivity.viewModel.uploadedFileSize.setValue(Long.valueOf(next.f446210f));
                                                br value15 = qQTransferDownloadActivity.viewModel.fileSet.getValue();
                                                if (value15 != null) {
                                                    long j3 = value15.f446190d;
                                                    QQTransferDownloadActivity qQTransferDownloadActivity2 = qQTransferDownloadActivity;
                                                    if (qQTransferDownloadActivity2.viewModel.uploadedFileSize.getValue().longValue() >= j3) {
                                                        qQTransferDownloadActivity2.viewModel.needShowUploadFinishAnim.setValue(Boolean.TRUE);
                                                    }
                                                }
                                            } else {
                                                qQTransferDownloadActivity.viewModel.uploadFileSizeInterpolation.updateValue(next.f446210f, true);
                                            }
                                        } else if (qQTransferDownloadActivity.viewModel.isInUploading() && next.f446207c == 4) {
                                            qQTransferDownloadActivity.viewModel.needShowUploadFinishAnim.setValue(Boolean.TRUE);
                                        }
                                        if (next.f446206b == 7) {
                                            br value16 = qQTransferDownloadActivity.viewModel.fileSet.getValue();
                                            if (value16 != null) {
                                                value16.f446201o = next.f446206b;
                                            }
                                            br value17 = qQTransferDownloadActivity.viewModel.fileSet.getValue();
                                            if (value17 != null) {
                                                value17.f446202p = next.f446207c;
                                            }
                                            qQTransferDownloadActivity.viewModel.onFileSetStatusCanceled();
                                        }
                                        KLog kLog4 = KLog.INSTANCE;
                                        StringBuilder m19 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onFileSetSimpleUploadInfoChanged xx uploadStatus=");
                                        m19.append(next.f446207c);
                                        m19.append(" fileSetStatus=");
                                        m19.append(next.f446206b);
                                        m19.append(" uploadedFileSize=");
                                        StringBuilder m26 = QQFlashTransferViewModel$fetchCompressedFileFolder$2$$ExternalSyntheticOutline0.m(next.f446211g, QQFlashTransferViewModel$fetchCompressedFileFolder$2$$ExternalSyntheticOutline0.m(next.f446209e, QQFlashTransferViewModel$fetchCompressedFileFolder$2$$ExternalSyntheticOutline0.m(next.f446208d, QQFlashTransferViewModel$fetchCompressedFileFolder$2$$ExternalSyntheticOutline0.m(next.f446210f, m19, " uploadedFileCount="), " totalFileCount="), " totalFileSize="), " process=");
                                        m26.append(qQTransferDownloadActivity.viewModel.uploadProcess.getValue().floatValue());
                                        m26.append(" uploadSpeed=");
                                        StringBuilder m27 = QQFlashTransferViewModel$fetchCompressedFileFolder$2$$ExternalSyntheticOutline0.m(next.f446212h, m26, " getRmpByTransferSpeed=");
                                        m27.append(defpackage.l.f413536a.d(next.f446212h));
                                        kLog4.d("QQTransferDownloadActivity", m27.toString());
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        });
                    }
                };
                IKernelFlashTransferService a29 = aVar3.a();
                final QQTransferDownloadActivity$addFileSetUploadListener$2 qQTransferDownloadActivity$addFileSetUploadListener$22 = this.uploadInfoFileSetStatusListener;
                Intrinsics.checkNotNull(qQTransferDownloadActivity$addFileSetUploadListener$22);
                a29.getClass();
                ArrayList arrayList4 = new ArrayList();
                arrayList4.add(String.valueOf(qQTransferDownloadActivity$addFileSetUploadListener$22.hashCode()));
                Function1<Object, Unit> function14 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$addFileSetSimpleUploadInfoListener$fileSetSimpleUploadInfoListener$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object obj) {
                        Object[] objArr = obj instanceof Object[] ? (Object[]) obj : null;
                        if (objArr != null) {
                            if (!(objArr.length == 0)) {
                                Iterator it = ArrayIteratorKt.iterator(objArr);
                                if (Intrinsics.areEqual((String) dr.a(it, "null cannot be cast to non-null type kotlin.String"), "onFileSetSimpleUploadInfoChanged")) {
                                    Object next = it.next();
                                    Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
                                    int intValue = ((Integer) next).intValue();
                                    ArrayList arrayList5 = new ArrayList();
                                    for (int i18 = 0; i18 < intValue; i18++) {
                                        Object next2 = it.next();
                                        Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue2 = ((Integer) next2).intValue();
                                        Object[] objArr2 = new Object[intValue2];
                                        for (int i19 = 0; i19 < intValue2; i19++) {
                                            objArr2[i19] = it.next();
                                        }
                                        Iterator it5 = ArrayIteratorKt.iterator(objArr2);
                                        CollectionsKt__CollectionsKt.emptyList();
                                        bu buVar = new bu("", 0, 0, 0L, 0L, 0L, 0L, 0L);
                                        while (it5.hasNext()) {
                                            Object next3 = it5.next();
                                            if (Intrinsics.areEqual(next3, "fileSetId")) {
                                                Object next4 = it5.next();
                                                Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.String");
                                                buVar.f446205a = (String) next4;
                                            } else if (Intrinsics.areEqual(next3, "fileSetStatus")) {
                                                Object next5 = it5.next();
                                                Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FileSetStatusKt.FileSetStatus }");
                                                buVar.f446206b = ((Integer) next5).intValue();
                                            } else if (Intrinsics.areEqual(next3, "aiClusteringStatus")) {
                                                Object next6 = it5.next();
                                                Intrinsics.checkNotNull(next6, "null cannot be cast to non-null type kotlin.Int");
                                                int intValue3 = ((Integer) next6).intValue();
                                                Object[] objArr3 = new Object[intValue3];
                                                for (int i26 = 0; i26 < intValue3; i26++) {
                                                    objArr3[i26] = it5.next();
                                                }
                                                ws3.b.a(objArr3);
                                            } else if (Intrinsics.areEqual(next3, "firstLevelItemCount")) {
                                                Object next7 = it5.next();
                                                Intrinsics.checkNotNull(next7, "null cannot be cast to non-null type kotlin.String");
                                                vs3.a.a((String) next7);
                                            } else if (Intrinsics.areEqual(next3, "uploadStatus")) {
                                                Object next8 = it5.next();
                                                Intrinsics.checkNotNull(next8, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FileSetUploadStatusKt.FileSetUploadStatus }");
                                                buVar.f446207c = ((Integer) next8).intValue();
                                            } else if (Intrinsics.areEqual(next3, "uploadedFileCount")) {
                                                Object next9 = it5.next();
                                                Intrinsics.checkNotNull(next9, "null cannot be cast to non-null type kotlin.String");
                                                buVar.f446208d = vs3.a.b((String) next9);
                                            } else if (Intrinsics.areEqual(next3, "failedFileCount")) {
                                                Object next10 = it5.next();
                                                Intrinsics.checkNotNull(next10, "null cannot be cast to non-null type kotlin.String");
                                                vs3.a.b((String) next10);
                                            } else if (Intrinsics.areEqual(next3, "totalFileCount")) {
                                                Object next11 = it5.next();
                                                Intrinsics.checkNotNull(next11, "null cannot be cast to non-null type kotlin.String");
                                                buVar.f446209e = vs3.a.b((String) next11);
                                            } else if (Intrinsics.areEqual(next3, "uploadedFileSize")) {
                                                Object next12 = it5.next();
                                                Intrinsics.checkNotNull(next12, "null cannot be cast to non-null type kotlin.String");
                                                buVar.f446210f = vs3.a.b((String) next12);
                                            } else if (Intrinsics.areEqual(next3, "totalFileSize")) {
                                                Object next13 = it5.next();
                                                Intrinsics.checkNotNull(next13, "null cannot be cast to non-null type kotlin.String");
                                                buVar.f446211g = vs3.a.b((String) next13);
                                            } else if (Intrinsics.areEqual(next3, "uploadSpeed")) {
                                                Object next14 = it5.next();
                                                Intrinsics.checkNotNull(next14, "null cannot be cast to non-null type kotlin.String");
                                                buVar.f446212h = vs3.a.b((String) next14);
                                            } else if (Intrinsics.areEqual(next3, "timeRemain")) {
                                                Object next15 = it5.next();
                                                Intrinsics.checkNotNull(next15, "null cannot be cast to non-null type kotlin.String");
                                                vs3.a.b((String) next15);
                                            } else if (Intrinsics.areEqual(next3, "transferType")) {
                                                Object next16 = it5.next();
                                                Intrinsics.checkNotNull(next16, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FileSetListTypeKt.FileSetListType }");
                                                ((Integer) next16).intValue();
                                            } else if (Intrinsics.areEqual(next3, "isLocalCreate")) {
                                                Object next17 = it5.next();
                                                Intrinsics.checkNotNull(next17, "null cannot be cast to non-null type kotlin.Int");
                                                ((Integer) next17).intValue();
                                            }
                                        }
                                        arrayList5.add(buVar);
                                    }
                                    cy.this.onFileSetSimpleUploadInfoChanged(arrayList5);
                                    return Unit.INSTANCE;
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    }
                };
                Object[] array5 = arrayList4.toArray(new Object[0]);
                Intrinsics.checkNotNull(array5, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                a29.syncToNativeMethod(true, "addFileSetSimpleUploadInfoListener", array5, function14);
                a29.f344761d.put(qQTransferDownloadActivity$addFileSetUploadListener$22, function14);
                KLog kLog4 = KLog.INSTANCE;
                StringBuilder m19 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("addFileSetSimpleUploadInfoMonitoring ");
                m19.append(this.viewModel.fileSetId);
                kLog4.d("QQTransferDownloadActivity", m19.toString());
                IKernelFlashTransferService a36 = aVar3.a();
                list2 = ArraysKt___ArraysKt.toList(new String[]{this.viewModel.fileSetId});
                a36.getClass();
                ArrayList arrayList5 = new ArrayList();
                arrayList5.add(Integer.valueOf(list2.size()));
                arrayList5.addAll(list2);
                Object[] array6 = arrayList5.toArray(new Object[0]);
                Intrinsics.checkNotNull(array6, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                a36.syncToNativeMethod(true, "addFileSetSimpleUploadInfoMonitoring", array6, null);
            }
            if (this.folderListener != null) {
                IKernelFlashTransferService a37 = aVar3.a();
                QQTransferDownloadActivity$addFolderListener$1 qQTransferDownloadActivity$addFolderListener$1 = this.folderListener;
                Intrinsics.checkNotNull(qQTransferDownloadActivity$addFolderListener$1);
                a37.l(qQTransferDownloadActivity$addFolderListener$1);
            }
            this.folderListener = new da() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFolderListener$1
                @Override // ws3.da
                public final void onFolderProgressChanged(final List<ab> list3) {
                    final QQTransferDownloadActivity qQTransferDownloadActivity = QQTransferDownloadActivity.this;
                    SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFolderListener$1$onFolderProgressChanged$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            for (ab abVar : list3) {
                                if (abVar.B != 2) {
                                    qQTransferDownloadActivity.viewModel.downloadProcessMap.put(abVar.f446151b, Float.valueOf(((float) UnsignedKt.ulongToDouble(abVar.E.f446241a)) / ((float) UnsignedKt.ulongToDouble(abVar.E.f446242b))));
                                }
                                KLog kLog5 = KLog.INSTANCE;
                                StringBuilder m26 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onFolderProgressChanged name");
                                m26.append(abVar.f446160k);
                                m26.append(" process=");
                                m26.append(qQTransferDownloadActivity.viewModel.downloadProcessMap.get(abVar.f446151b));
                                m26.append(" downloadStatus=");
                                DatalineDetailViewModel$$ExternalSyntheticOutline0.m(m26, abVar.C, kLog5, "QQTransferDownloadActivity");
                            }
                            return Unit.INSTANCE;
                        }
                    });
                }

                @Override // ws3.da
                public final void onFolderStatusInfoUpdate(final List<ab> list3) {
                    final QQTransferDownloadActivity qQTransferDownloadActivity = QQTransferDownloadActivity.this;
                    SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFolderListener$1$onFolderStatusInfoUpdate$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:32:0x0097, code lost:
                        
                            if (r3.f446155f == true) goto L38;
                         */
                        @Override // kotlin.jvm.functions.Function0
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Unit invoke() {
                            ab abVar;
                            ab abVar2;
                            for (ab abVar3 : list3) {
                                QQFlashTransferViewModel qQFlashTransferViewModel2 = qQTransferDownloadActivity.viewModel;
                                int i18 = abVar3.C;
                                int i19 = abVar3.f446171v.f446182d;
                                Iterator<BaseComposeCardViewModel> it = qQFlashTransferViewModel2.feedListViewModel.feedCardViewModelList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    BaseComposeCardViewModel next = it.next();
                                    if (next instanceof QQFTFileDetailItemVM) {
                                        QQFTFileDetailItemVM qQFTFileDetailItemVM = (QQFTFileDetailItemVM) next;
                                        ab abVar4 = qQFTFileDetailItemVM.fileDetail;
                                        if (Intrinsics.areEqual(abVar4 != null ? abVar4.f446151b : null, abVar3.f446151b)) {
                                            ab abVar5 = qQFTFileDetailItemVM.fileDetail;
                                            if (abVar5 != null) {
                                                abVar5.C = i18;
                                            }
                                            qQFTFileDetailItemVM.downloadStatus.setValue(Integer.valueOf(i18));
                                            qQFlashTransferViewModel2.m118updateFailedFileListhJeF8fQ(qQFTFileDetailItemVM, abVar3.f446151b, i18, i19);
                                            if (qQFlashTransferViewModel2.downloadingFileList.containsKey(abVar3.f446151b) && (abVar2 = qQFlashTransferViewModel2.downloadingFileList.get(abVar3.f446151b)) != null) {
                                                abVar2.C = i18;
                                            }
                                            if (qQFlashTransferViewModel2.selectFilesToDownload.containsKey(abVar3.f446151b) && (abVar = qQFlashTransferViewModel2.selectFilesToDownload.get(abVar3.f446151b)) != null) {
                                                abVar.C = i18;
                                            }
                                            ab abVar6 = qQFTFileDetailItemVM.fileDetail;
                                            boolean z18 = abVar6 != null;
                                            if (z18 && abVar6 != null) {
                                                abVar6.E = abVar3.E;
                                            }
                                        }
                                    }
                                }
                                int i26 = abVar3.B;
                                if (i26 != 0) {
                                    qQTransferDownloadActivity.viewModel.updateFileUploadStatus(abVar3, i26);
                                }
                                KLog kLog5 = KLog.INSTANCE;
                                StringBuilder m26 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onFolderStatusInfoUpdate name=");
                                m26.append(abVar3.f446160k);
                                m26.append(" downloadStatus=");
                                m26.append(abVar3.C);
                                m26.append(" uploadStatus=");
                                m26.append(abVar3.B);
                                m26.append(" successCount=");
                                m26.append((Object) UInt.m615toStringimpl(abVar3.E.f446244d));
                                kLog5.d("QQTransferDownloadActivity", m26.toString());
                            }
                            KLog kLog6 = KLog.INSTANCE;
                            StringBuilder m27 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onFolderStatusInfoUpdate size=");
                            m27.append(list3.size());
                            kLog6.d("QQTransferDownloadActivity", m27.toString());
                            return Unit.INSTANCE;
                        }
                    });
                }
            };
            IKernelFlashTransferService a38 = aVar3.a();
            final QQTransferDownloadActivity$addFolderListener$1 qQTransferDownloadActivity$addFolderListener$12 = this.folderListener;
            Intrinsics.checkNotNull(qQTransferDownloadActivity$addFolderListener$12);
            a38.getClass();
            ArrayList arrayList6 = new ArrayList();
            arrayList6.add(String.valueOf(qQTransferDownloadActivity$addFolderListener$12.hashCode()));
            Function1<Object, Unit> function15 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$addFolderListener$folderListener$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    Object[] objArr = obj instanceof Object[] ? (Object[]) obj : null;
                    if (objArr != null) {
                        if (!(objArr.length == 0)) {
                            Iterator it = ArrayIteratorKt.iterator(objArr);
                            String str8 = (String) dr.a(it, "null cannot be cast to non-null type kotlin.String");
                            if (Intrinsics.areEqual(str8, "onFolderStatusInfoUpdate")) {
                                Object next = it.next();
                                Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
                                int intValue = ((Integer) next).intValue();
                                ArrayList arrayList7 = new ArrayList();
                                for (int i18 = 0; i18 < intValue; i18++) {
                                    Object next2 = it.next();
                                    Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
                                    int intValue2 = ((Integer) next2).intValue();
                                    Object[] objArr2 = new Object[intValue2];
                                    for (int i19 = 0; i19 < intValue2; i19++) {
                                        objArr2[i19] = it.next();
                                    }
                                    arrayList7.add(bo.b(objArr2));
                                }
                                da.this.onFolderStatusInfoUpdate(arrayList7);
                            } else if (Intrinsics.areEqual(str8, "onFolderProgressChanged")) {
                                Object next3 = it.next();
                                Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int");
                                int intValue3 = ((Integer) next3).intValue();
                                ArrayList arrayList8 = new ArrayList();
                                for (int i26 = 0; i26 < intValue3; i26++) {
                                    Object next4 = it.next();
                                    Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.Int");
                                    int intValue4 = ((Integer) next4).intValue();
                                    Object[] objArr3 = new Object[intValue4];
                                    for (int i27 = 0; i27 < intValue4; i27++) {
                                        objArr3[i27] = it.next();
                                    }
                                    arrayList8.add(bo.b(objArr3));
                                }
                                da.this.onFolderProgressChanged(arrayList8);
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
            };
            Object[] array7 = arrayList6.toArray(new Object[0]);
            Intrinsics.checkNotNull(array7, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            a38.syncToNativeMethod(true, "addFolderListener", array7, function15);
            a38.f344763f.put(qQTransferDownloadActivity$addFolderListener$12, function15);
            if (this.compressedFileListener != null) {
                IKernelFlashTransferService a39 = aVar3.a();
                QQTransferDownloadActivity$addCompressedFileListener$1 qQTransferDownloadActivity$addCompressedFileListener$1 = this.compressedFileListener;
                Intrinsics.checkNotNull(qQTransferDownloadActivity$addCompressedFileListener$1);
                a39.f(qQTransferDownloadActivity$addCompressedFileListener$1);
            }
            this.compressedFileListener = new cw() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addCompressedFileListener$1
                @Override // ws3.cw
                public final void onCompressedFileDownloadStatusChange(final ab abVar, final int i18) {
                    final QQTransferDownloadActivity qQTransferDownloadActivity = QQTransferDownloadActivity.this;
                    SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addCompressedFileListener$1$onCompressedFileDownloadStatusChange$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            QQFlashTransferViewModel qQFlashTransferViewModel2 = QQTransferDownloadActivity.this.viewModel;
                            ab abVar2 = abVar;
                            int i19 = i18;
                            Iterator<BaseComposeCardViewModel> it = qQFlashTransferViewModel2.feedListViewModel.feedCardViewModelList.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                BaseComposeCardViewModel next = it.next();
                                if (next instanceof QQFTFileDetailItemVM) {
                                    QQFTFileDetailItemVM qQFTFileDetailItemVM = (QQFTFileDetailItemVM) next;
                                    ab abVar3 = qQFTFileDetailItemVM.fileDetail;
                                    if (Intrinsics.areEqual(abVar3 != null ? abVar3.f446151b : null, abVar2.f446151b)) {
                                        qQFTFileDetailItemVM.compressStatus.setValue(Integer.valueOf(i19));
                                        ab abVar4 = qQFTFileDetailItemVM.fileDetail;
                                        ws3.k kVar = abVar4 != null ? abVar4.H : null;
                                        if (kVar != null) {
                                            kVar.f446377a = i19;
                                        }
                                        e eVar = new e();
                                        eVar.v("kCompressFolderId", abVar2.f446151b);
                                        com.tencent.kuikly.core.module.k.d((com.tencent.kuikly.core.module.k) c.f117352a.g().acquireModule("KRNotifyModule"), "kQQFTCompressFolderDownloadNotify", eVar, false, 4, null);
                                        KLog kLog5 = KLog.INSTANCE;
                                        StringBuilder m26 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("updateCompressedFileDownloadStatus id=");
                                        m26.append(abVar2.f446151b);
                                        m26.append(" status=");
                                        m26.append(i19);
                                        kLog5.d("QQFlashTransferFileListViewModel", m26.toString());
                                    }
                                }
                            }
                            KLog kLog6 = KLog.INSTANCE;
                            StringBuilder m27 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onCompressedFileDownloadStatusChange fileName=");
                            m27.append(abVar.f446160k);
                            m27.append(" id=");
                            m27.append(abVar.f446151b);
                            m27.append(" status=");
                            DatalineDetailViewModel$$ExternalSyntheticOutline0.m(m27, i18, kLog6, "QQTransferDownloadActivity");
                            return Unit.INSTANCE;
                        }
                    });
                }

                @Override // ws3.cw
                public final void onCompressedFileSaveDirPathChange(final ab abVar, final String str8) {
                    SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addCompressedFileListener$1$onCompressedFileSaveDirPathChange$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            KLog kLog5 = KLog.INSTANCE;
                            StringBuilder m26 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onCompressedFileSaveDirPathChange name=");
                            m26.append(ab.this.f446160k);
                            m26.append(" savePath=");
                            NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(m26, str8, kLog5, "QQTransferDownloadActivity");
                            return Unit.INSTANCE;
                        }
                    });
                }
            };
            IKernelFlashTransferService a46 = aVar3.a();
            final QQTransferDownloadActivity$addCompressedFileListener$1 qQTransferDownloadActivity$addCompressedFileListener$12 = this.compressedFileListener;
            Intrinsics.checkNotNull(qQTransferDownloadActivity$addCompressedFileListener$12);
            a46.getClass();
            ArrayList arrayList7 = new ArrayList();
            arrayList7.add(String.valueOf(qQTransferDownloadActivity$addCompressedFileListener$12.hashCode()));
            Function1<Object, Unit> function16 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$addCompressedFileListener$compressedFileListener$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    Object[] objArr = obj instanceof Object[] ? (Object[]) obj : null;
                    if (objArr != null) {
                        int i18 = 0;
                        if (!(objArr.length == 0)) {
                            Iterator it = ArrayIteratorKt.iterator(objArr);
                            String str8 = (String) dr.a(it, "null cannot be cast to non-null type kotlin.String");
                            if (Intrinsics.areEqual(str8, "onCompressedFileDownloadStatusChange")) {
                                Object next = it.next();
                                Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
                                int intValue = ((Integer) next).intValue();
                                Object[] objArr2 = new Object[intValue];
                                while (i18 < intValue) {
                                    objArr2[i18] = it.next();
                                    i18++;
                                }
                                ab b16 = bo.b(objArr2);
                                Object next2 = it.next();
                                Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FileSetDownloadStatusKt.FileSetDownloadStatus }");
                                cw.this.onCompressedFileDownloadStatusChange(b16, ((Integer) next2).intValue());
                            } else if (Intrinsics.areEqual(str8, "onCompressedFileSaveDirPathChange")) {
                                Object next3 = it.next();
                                Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int");
                                int intValue2 = ((Integer) next3).intValue();
                                Object[] objArr3 = new Object[intValue2];
                                while (i18 < intValue2) {
                                    objArr3[i18] = it.next();
                                    i18++;
                                }
                                ab b17 = bo.b(objArr3);
                                Object next4 = it.next();
                                Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.String");
                                cw.this.onCompressedFileSaveDirPathChange(b17, (String) next4);
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
            };
            Object[] array8 = arrayList7.toArray(new Object[0]);
            Intrinsics.checkNotNull(array8, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            a46.syncToNativeMethod(true, "addCompressedFileListener", array8, function16);
            a46.f344764g.put(qQTransferDownloadActivity$addCompressedFileListener$12, function16);
            if (this.deviceStatusListener != null) {
                IKernelFlashTransferService a47 = aVar3.a();
                QQTransferDownloadActivity$addDeviceStatusListener$1 qQTransferDownloadActivity$addDeviceStatusListener$1 = this.deviceStatusListener;
                Intrinsics.checkNotNull(qQTransferDownloadActivity$addDeviceStatusListener$1);
                a47.g(qQTransferDownloadActivity$addDeviceStatusListener$1);
            }
            this.deviceStatusListener = new dh() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addDeviceStatusListener$1
                @Override // ws3.dh
                public final void onAvailableStorageChange(final String str8, final boolean z18) {
                    final QQTransferDownloadActivity qQTransferDownloadActivity = QQTransferDownloadActivity.this;
                    SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addDeviceStatusListener$1$onAvailableStorageChange$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            KLog kLog5 = KLog.INSTANCE;
                            StringBuilder m26 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("addDeviceStatusListener. showInsufficientStorageAlert. msg: ");
                            m26.append(str8);
                            m26.append(" isEnough: ");
                            NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0.m(m26, z18, kLog5, "QQTransferDownloadActivity");
                            if (!z18) {
                                if (str8.length() > 0) {
                                    DeviceStateProcessInfo deviceStateProcessInfo = qQTransferDownloadActivity.viewModel.deviceStateProcessInfo;
                                    deviceStateProcessInfo.notice = str8;
                                    deviceStateProcessInfo.isDownloadPause.setValue(Boolean.TRUE);
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    });
                }

                @Override // ws3.dh
                public final void onNetStatusChanged(final String str8, final int i18) {
                    final QQTransferDownloadActivity qQTransferDownloadActivity = QQTransferDownloadActivity.this;
                    SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addDeviceStatusListener$1$onNetStatusChanged$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            KLog kLog5 = KLog.INSTANCE;
                            StringBuilder m26 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("addDeviceStatusListener. onNetStatusChanged. msg: ");
                            m26.append(str8);
                            m26.append(", networkStatus: ");
                            DatalineDetailViewModel$$ExternalSyntheticOutline0.m(m26, i18, kLog5, "QQTransferDownloadActivity");
                            int i19 = i18;
                            if (i19 == 0) {
                                if (str8.length() > 0) {
                                    DeviceStateProcessInfo deviceStateProcessInfo = qQTransferDownloadActivity.viewModel.deviceStateProcessInfo;
                                    deviceStateProcessInfo.notice = str8;
                                    deviceStateProcessInfo.isDownloadPause.setValue(Boolean.TRUE);
                                }
                            } else if (i19 >= 2 && i19 <= 5) {
                                if (!qQTransferDownloadActivity.viewModel.deviceStateProcessInfo.notice.equals(str8)) {
                                    DeviceStateProcessInfo deviceStateProcessInfo2 = qQTransferDownloadActivity.viewModel.deviceStateProcessInfo;
                                    deviceStateProcessInfo2.notice = str8;
                                    deviceStateProcessInfo2.isSwitchToXgAndNoticeChanged.setValue(Boolean.TRUE);
                                }
                            } else {
                                DeviceStateProcessInfo deviceStateProcessInfo3 = qQTransferDownloadActivity.viewModel.deviceStateProcessInfo;
                                deviceStateProcessInfo3.notice = "";
                                deviceStateProcessInfo3.isDownloadPause.setValue(Boolean.FALSE);
                            }
                            return Unit.INSTANCE;
                        }
                    });
                }

                @Override // ws3.dh
                public final void showBackToForegroundAlert() {
                }

                @Override // ws3.dh
                public final void showLowBatterylAlert() {
                }

                @Override // ws3.dh
                public final void showSleepAlert() {
                }
            };
            IKernelFlashTransferService a48 = aVar3.a();
            final QQTransferDownloadActivity$addDeviceStatusListener$1 qQTransferDownloadActivity$addDeviceStatusListener$12 = this.deviceStatusListener;
            Intrinsics.checkNotNull(qQTransferDownloadActivity$addDeviceStatusListener$12);
            a48.getClass();
            ArrayList arrayList8 = new ArrayList();
            arrayList8.add(String.valueOf(qQTransferDownloadActivity$addDeviceStatusListener$12.hashCode()));
            Function1<Object, Unit> function17 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$addDeviceStatusListener$deviceStatusListener$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    Object[] objArr = obj instanceof Object[] ? (Object[]) obj : null;
                    if (objArr != null) {
                        if (!(objArr.length == 0)) {
                            Iterator it = ArrayIteratorKt.iterator(objArr);
                            String str8 = (String) dr.a(it, "null cannot be cast to non-null type kotlin.String");
                            switch (str8.hashCode()) {
                                case -1847073151:
                                    if (str8.equals("onAvailableStorageChange")) {
                                        Object next = it.next();
                                        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
                                        ((Integer) next).intValue();
                                        Object next2 = it.next();
                                        Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
                                        String str9 = (String) next2;
                                        Object next3 = it.next();
                                        Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int");
                                        dh.this.onAvailableStorageChange(str9, ((Integer) next3).intValue() == 1);
                                        break;
                                    }
                                    break;
                                case 265941178:
                                    if (str8.equals("showBackToForegroundAlert")) {
                                        Object next4 = it.next();
                                        Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.Int");
                                        ((Integer) next4).intValue();
                                        Object next5 = it.next();
                                        Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.String");
                                        dh.this.showBackToForegroundAlert();
                                        break;
                                    }
                                    break;
                                case 1181874082:
                                    if (str8.equals("showSleepAlert")) {
                                        Object next6 = it.next();
                                        Intrinsics.checkNotNull(next6, "null cannot be cast to non-null type kotlin.Int");
                                        ((Integer) next6).intValue();
                                        Object next7 = it.next();
                                        Intrinsics.checkNotNull(next7, "null cannot be cast to non-null type kotlin.String");
                                        dh.this.showSleepAlert();
                                        break;
                                    }
                                    break;
                                case 1339377350:
                                    if (str8.equals("showLowBatterylAlert")) {
                                        Object next8 = it.next();
                                        Intrinsics.checkNotNull(next8, "null cannot be cast to non-null type kotlin.Int");
                                        ((Integer) next8).intValue();
                                        Object next9 = it.next();
                                        Intrinsics.checkNotNull(next9, "null cannot be cast to non-null type kotlin.String");
                                        dh.this.showLowBatterylAlert();
                                        break;
                                    }
                                    break;
                                case 1415264196:
                                    if (str8.equals("onNetStatusChanged")) {
                                        Object next10 = it.next();
                                        Intrinsics.checkNotNull(next10, "null cannot be cast to non-null type kotlin.Int");
                                        ((Integer) next10).intValue();
                                        Object next11 = it.next();
                                        Intrinsics.checkNotNull(next11, "null cannot be cast to non-null type kotlin.String");
                                        Object next12 = it.next();
                                        Intrinsics.checkNotNull(next12, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.common_record.NetStatusTypeKt.NetStatusType }");
                                        dh.this.onNetStatusChanged((String) next11, ((Integer) next12).intValue());
                                        break;
                                    }
                                    break;
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
            };
            Object[] array9 = arrayList8.toArray(new Object[0]);
            Intrinsics.checkNotNull(array9, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            a48.syncToNativeMethod(true, "addDeviceStatusListener", array9, function17);
            a48.f344765h.put(qQTransferDownloadActivity$addDeviceStatusListener$12, function17);
            c cVar = c.f117352a;
            this.fileSetDeleteSuccessNotifyListener = com.tencent.kuikly.core.module.k.b((com.tencent.kuikly.core.module.k) cVar.g().acquireModule("KRNotifyModule"), FlashTransferHelperApiImpl.kQQFTFileSetDidDeletedNotification, false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetNotifyListener$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar) {
                    e eVar2 = eVar;
                    if (Intrinsics.areEqual(eVar2 != null ? eVar2.p(FlashTransferHelperApiImpl.kFileSetIdKey) : null, QQTransferDownloadActivity.this.viewModel.fileSetId)) {
                        QQTransferDownloadActivity.this.viewModel.onFileSetStatusCanceled();
                    }
                    return Unit.INSTANCE;
                }
            }, 2, null);
            if (AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(cVar)) {
                this.otherPageAppearListener = com.tencent.kuikly.core.module.k.b((com.tencent.kuikly.core.module.k) cVar.g().acquireModule("KRNotifyModule"), "kOtherDownloadPageAppearNotify", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$addFileSetNotifyListener$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        e eVar2 = eVar;
                        String p16 = eVar2 != null ? eVar2.p(FlashTransferHelperApiImpl.kFileSetIdKey) : null;
                        Integer valueOf2 = eVar2 != null ? Integer.valueOf(eVar2.j("kOtherDownloadPageTokenKey")) : null;
                        if (Intrinsics.areEqual(p16, QQTransferDownloadActivity.this.viewModel.fileSetId)) {
                            int hashCode = QQTransferDownloadActivity.this.hashCode();
                            if (valueOf2 == null || valueOf2.intValue() != hashCode) {
                                if (eVar2.f("kOtherDownloadPageIsAppearKey")) {
                                    QQTransferDownloadActivity.this.isOtherPageVisibleCnt++;
                                } else {
                                    QQTransferDownloadActivity qQTransferDownloadActivity = QQTransferDownloadActivity.this;
                                    int i18 = qQTransferDownloadActivity.isOtherPageVisibleCnt - 1;
                                    qQTransferDownloadActivity.isOtherPageVisibleCnt = i18;
                                    if (i18 < 0) {
                                        qQTransferDownloadActivity.isOtherPageVisibleCnt = 0;
                                        KLog.INSTANCE.e("QQTransferDownloadActivity", "error: isOtherPageVisibleCnt is less than 0......");
                                    }
                                }
                                QQTransferDownloadActivity qQTransferDownloadActivity2 = QQTransferDownloadActivity.this;
                                int i19 = qQTransferDownloadActivity2.isOtherPageVisibleCnt;
                                if (i19 > 0) {
                                    qQTransferDownloadActivity2.isPageVisible.setValue(Boolean.FALSE);
                                } else if (i19 == 0) {
                                    qQTransferDownloadActivity2.isPageVisible.setValue(Boolean.TRUE);
                                }
                            }
                        }
                        KLog.INSTANCE.d("QQTransferDownloadActivity", "receive other page notify: " + p16 + TokenParser.SP + QQTransferDownloadActivity.this + " isOtherPageVisibleCnt=" + QQTransferDownloadActivity.this.isOtherPageVisibleCnt + " isPageVisible=" + QQTransferDownloadActivity.this.isPageVisible + " fromPageToken=" + valueOf2);
                        return Unit.INSTANCE;
                    }
                }, 2, null);
            }
            final QQFlashTransferViewModel qQFlashTransferViewModel2 = this.viewModel;
            qQFlashTransferViewModel2.categoryInfos.clear();
            QQFTFileListFilterInfo qQFTFileListFilterInfo = new QQFTFileListFilterInfo();
            ac acVar = new ac();
            acVar.f446178c = "\u6240\u6709\u7c7b\u578b";
            acVar.f446177b = UInt.m570constructorimpl((int) qQFlashTransferViewModel2.m116getCurPageFirstLevelItemCountsVKNKU());
            acVar.f446176a = UInt.m570constructorimpl(0);
            qQFTFileListFilterInfo.categoryInfo = acVar;
            qQFTFileListFilterInfo.isSelected.setValue(Boolean.TRUE);
            qQFlashTransferViewModel2.categoryInfos.add(qQFTFileListFilterInfo);
            if (!(qQFlashTransferViewModel2.clusterId.length() > 0) && !qQFlashTransferViewModel2.isCompressPage()) {
                String str8 = qQFlashTransferViewModel2.fileSetId;
                String value15 = qQFlashTransferViewModel2.parentId.getValue();
                int i18 = qQFlashTransferViewModel2.sceneType;
                KLog kLog5 = KLog.INSTANCE;
                StringBuilder m26 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getFileCategoryList fileSetId=");
                str3 = "QQTransferDownloadActivity";
                m26.append(qQFlashTransferViewModel2.fileSetId);
                m26.append(" parentId=");
                m26.append(value15);
                kLog5.d("QQFlashTransferFileListViewModel", m26.toString());
                IKernelFlashTransferService a49 = aVar3.a();
                final dd ddVar = new dd() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$getFileCategoryList$1
                    @Override // ws3.dd
                    public final void onGetFileCategory(final ch chVar) {
                        final QQFlashTransferViewModel qQFlashTransferViewModel3 = QQFlashTransferViewModel.this;
                        SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$getFileCategoryList$1$onGetFileCategory$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                KLog kLog6 = KLog.INSTANCE;
                                StringBuilder m27 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getFileCategoryList rsp result=");
                                m27.append(ch.this.f446263a);
                                m27.append(" errMsg=");
                                m27.append(ch.this.f446264b);
                                m27.append(" size=");
                                m27.append(ch.this.f446265c.size());
                                kLog6.d("QQFlashTransferFileListViewModel", m27.toString());
                                if (!ch.this.f446265c.isEmpty()) {
                                    for (ac acVar2 : ch.this.f446265c) {
                                        if (acVar2.f446176a != UInt.m570constructorimpl(0)) {
                                            QQFTFileListFilterInfo qQFTFileListFilterInfo2 = new QQFTFileListFilterInfo();
                                            qQFTFileListFilterInfo2.categoryInfo = acVar2;
                                            qQFlashTransferViewModel3.categoryInfos.add(qQFTFileListFilterInfo2);
                                        }
                                        KLog kLog7 = KLog.INSTANCE;
                                        StringBuilder m28 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("categoryInfo name=");
                                        m28.append(acVar2.f446178c);
                                        m28.append(" num=");
                                        m28.append((Object) UInt.m615toStringimpl(acVar2.f446177b));
                                        m28.append(" fileCategory=");
                                        m28.append((Object) UInt.m615toStringimpl(acVar2.f446176a));
                                        kLog7.d("QQFlashTransferFileListViewModel", m28.toString());
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        });
                    }
                };
                a49.getClass();
                ArrayList arrayList9 = new ArrayList();
                ArrayList m27 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m("seq");
                str2 = "QQFlashTransferFileListViewModel";
                m27.add(0);
                m27.add("fileSetId");
                m27.add(str8);
                m27.add("parentId");
                m27.add(value15);
                m27.add("sceneType");
                m27.add(Integer.valueOf(i18));
                Object[] array10 = m27.toArray(new Object[0]);
                Intrinsics.checkNotNull(array10, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                arrayList9.add(Integer.valueOf(array10.length));
                CollectionsKt__MutableCollectionsKt.addAll(arrayList9, array10);
                arrayList9.add(String.valueOf(ddVar.hashCode()));
                Function1<Object, Unit> function18 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$getFileCategoryList$kernelCallback$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object obj) {
                        List emptyList;
                        Object[] objArr = obj instanceof Object[] ? (Object[]) obj : null;
                        if (objArr != null) {
                            if (!(objArr.length == 0)) {
                                Iterator it = ArrayIteratorKt.iterator(objArr);
                                if (Intrinsics.areEqual((String) dr.a(it, "null cannot be cast to non-null type kotlin.String"), "onGetFileCategory")) {
                                    Object next = it.next();
                                    Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
                                    int intValue = ((Integer) next).intValue();
                                    Object[] objArr2 = new Object[intValue];
                                    for (int i19 = 0; i19 < intValue; i19++) {
                                        objArr2[i19] = it.next();
                                    }
                                    Iterator it5 = ArrayIteratorKt.iterator(objArr2);
                                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                                    ch chVar = new ch(0, "", emptyList);
                                    while (it5.hasNext()) {
                                        Object next2 = it5.next();
                                        if (Intrinsics.areEqual(next2, "seq")) {
                                            Object next3 = it5.next();
                                            Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int");
                                            ((Integer) next3).intValue();
                                        } else if (Intrinsics.areEqual(next2, "result")) {
                                            Object next4 = it5.next();
                                            Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.Int");
                                            chVar.f446263a = ((Integer) next4).intValue();
                                        } else if (Intrinsics.areEqual(next2, "errMs")) {
                                            Object next5 = it5.next();
                                            Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.String");
                                            chVar.f446264b = (String) next5;
                                        } else if (Intrinsics.areEqual(next2, "categoryInfos")) {
                                            Object next6 = it5.next();
                                            Intrinsics.checkNotNull(next6, "null cannot be cast to non-null type kotlin.Int");
                                            int intValue2 = ((Integer) next6).intValue();
                                            ArrayList arrayList10 = new ArrayList();
                                            for (int i26 = 0; i26 < intValue2; i26++) {
                                                Object next7 = it5.next();
                                                Intrinsics.checkNotNull(next7, "null cannot be cast to non-null type kotlin.Int");
                                                int intValue3 = ((Integer) next7).intValue();
                                                Object[] objArr3 = new Object[intValue3];
                                                for (int i27 = 0; i27 < intValue3; i27++) {
                                                    objArr3[i27] = it5.next();
                                                }
                                                Iterator it6 = ArrayIteratorKt.iterator(objArr3);
                                                ac acVar2 = new ac();
                                                while (it6.hasNext()) {
                                                    Object next8 = it6.next();
                                                    if (Intrinsics.areEqual(next8, "fileCategory")) {
                                                        Object next9 = it6.next();
                                                        Intrinsics.checkNotNull(next9, "null cannot be cast to non-null type kotlin.String");
                                                        acVar2.f446176a = vs3.a.a((String) next9);
                                                    } else if (Intrinsics.areEqual(next8, "count")) {
                                                        Object next10 = it6.next();
                                                        Intrinsics.checkNotNull(next10, "null cannot be cast to non-null type kotlin.String");
                                                        acVar2.f446177b = vs3.a.a((String) next10);
                                                    } else if (Intrinsics.areEqual(next8, "categoryName")) {
                                                        Object next11 = it6.next();
                                                        Intrinsics.checkNotNull(next11, "null cannot be cast to non-null type kotlin.String");
                                                        acVar2.f446178c = (String) next11;
                                                    }
                                                }
                                                arrayList10.add(acVar2);
                                            }
                                            chVar.f446265c = arrayList10;
                                        }
                                    }
                                    dd.this.onGetFileCategory(chVar);
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    }
                };
                Object[] array11 = arrayList9.toArray(new Object[0]);
                Intrinsics.checkNotNull(array11, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                a49.syncToNativeMethod(true, "getFileCategoryList", array11, function18);
                if (z16 && !this.viewModel.isSecondaryPage() && brVar.f446194h.f446147b) {
                    final QQFlashTransferViewModel qQFlashTransferViewModel3 = this.viewModel;
                    qQFlashTransferViewModel3.clusterInfo.getValue().f446291d = qQFlashTransferViewModel3.clusterId;
                    ds value16 = qQFlashTransferViewModel3.clusterInfo.getValue();
                    int i19 = qQFlashTransferViewModel3.clusterType;
                    int i26 = i19 < 0 ? 1 : i19;
                    value16.f446290c = i26 != 1 ? i26 != 2 ? 0 : 2 : 1;
                    qQFlashTransferViewModel3.clusterInfo.getValue().f446289b = qQFlashTransferViewModel3.fileSetId;
                    KLog kLog6 = KLog.INSTANCE;
                    StringBuilder m28 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchClusterList clusterType=");
                    m28.append(qQFlashTransferViewModel3.clusterType);
                    m28.append(" firstClusteringListCount=");
                    br value17 = qQFlashTransferViewModel3.fileSet.getValue();
                    m28.append((value17 == null || (aVar2 = value17.f446194h) == null || (list = aVar2.f446146a) == null) ? null : Integer.valueOf(list.size()));
                    m28.append(" parentId=");
                    m28.append(qQFlashTransferViewModel3.parentId.getValue());
                    m28.append(" shouldPoll=");
                    br value18 = qQFlashTransferViewModel3.fileSet.getValue();
                    m28.append((value18 == null || (aVar = value18.f446194h) == null) ? null : Boolean.valueOf(aVar.f446147b));
                    kLog6.d(str2, m28.toString());
                    if (qQFlashTransferViewModel3.clusterType < 0) {
                        if (qQFlashTransferViewModel3.parentId.getValue().length() == 0) {
                            if (qQFlashTransferViewModel3.clusterListener != null) {
                                IKernelFlashTransferService a56 = IKernelFlashTransferService.f344757i.a();
                                QQFlashTransferViewModel$addFileSetClusteringListListener$1 qQFlashTransferViewModel$addFileSetClusteringListListener$1 = qQFlashTransferViewModel3.clusterListener;
                                Intrinsics.checkNotNull(qQFlashTransferViewModel$addFileSetClusteringListListener$1);
                                a56.h(qQFlashTransferViewModel$addFileSetClusteringListListener$1);
                            }
                            if (qQFlashTransferViewModel3.clusterListener == null) {
                                qQFlashTransferViewModel3.clusterListener = new cv() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$addFileSetClusteringListListener$1
                                    @Override // ws3.cv
                                    public final void onClusteringListUpdate(final ec ecVar) {
                                        final QQFlashTransferViewModel qQFlashTransferViewModel4 = QQFlashTransferViewModel.this;
                                        SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$addFileSetClusteringListListener$1$onClusteringListUpdate$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Code restructure failed: missing block: B:19:0x00da, code lost:
                                            
                                                if (kotlin.UnsignedKt.uintCompare(r2.f446321h, r1.getData()) < 0) goto L40;
                                             */
                                            @Override // kotlin.jvm.functions.Function0
                                            /*
                                                Code decompiled incorrectly, please refer to instructions dump.
                                            */
                                            public final Unit invoke() {
                                                String str9;
                                                SnapshotStateList<ws3.j> snapshotStateList;
                                                QQFTSecondLevelClusterInfo qQFTSecondLevelClusterInfo = QQFlashTransferViewModel.this.secondLevelClusterList.get(Integer.valueOf(ecVar.f446316c));
                                                UInt m564boximpl = qQFTSecondLevelClusterInfo != null ? UInt.m564boximpl(qQFTSecondLevelClusterInfo.pollBatchSeq) : null;
                                                KLog kLog7 = KLog.INSTANCE;
                                                StringBuilder m29 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onClusteringListUpdate result=");
                                                m29.append(ecVar.f446314a);
                                                m29.append(" errMsg=");
                                                m29.append(ecVar.f446315b);
                                                m29.append(" type=");
                                                m29.append(ecVar.f446316c);
                                                m29.append(" size=");
                                                StringBuilder m36 = NearbyFDPageViewModel$$ExternalSyntheticOutline0.m(ecVar.f446319f, m29, " count=");
                                                m36.append((Object) UInt.m615toStringimpl(ecVar.f446320g));
                                                m36.append(" isEnd=");
                                                m36.append(ecVar.f446318e);
                                                m36.append(" pollBatchSeq=");
                                                m36.append((Object) UInt.m615toStringimpl(ecVar.f446321h));
                                                m36.append(" oldPollBatchSeq=");
                                                m36.append(m564boximpl);
                                                kLog7.d("QQFlashTransferFileListViewModel", m36.toString());
                                                if (Intrinsics.areEqual(ecVar.f446322i, QQFlashTransferViewModel.this.fileSetId) && ecVar.f446314a == 0) {
                                                    boolean z18 = false;
                                                    if (m564boximpl != null && UnsignedKt.uintCompare(m564boximpl.getData(), 0) >= 0) {
                                                        if (UnsignedKt.uintCompare(ecVar.f446321h, m564boximpl.getData()) > 0) {
                                                            if (qQFTSecondLevelClusterInfo != null && (snapshotStateList = qQFTSecondLevelClusterInfo.clusterList) != null) {
                                                                snapshotStateList.clear();
                                                            }
                                                        }
                                                    }
                                                    Iterator<bz> it = QQFlashTransferViewModel.this.firstClusteringList.iterator();
                                                    while (true) {
                                                        if (!it.hasNext()) {
                                                            break;
                                                        }
                                                        if (it.next().f446226a == ecVar.f446316c) {
                                                            z18 = true;
                                                            break;
                                                        }
                                                    }
                                                    if (!z18) {
                                                        bz bzVar2 = new bz(0, null, null, 7, null);
                                                        int i27 = ecVar.f446316c;
                                                        bzVar2.f446226a = i27;
                                                        if (i27 == 1) {
                                                            str9 = QzoneConfig.DefaultValue.DEFAULT_PORTRAIT_TEXT;
                                                        } else {
                                                            str9 = "\u5408\u96c6";
                                                        }
                                                        bzVar2.f446227b = str9;
                                                        QQFlashTransferViewModel.this.firstClusteringList.add(bzVar2);
                                                    }
                                                    if (qQFTSecondLevelClusterInfo != null) {
                                                        qQFTSecondLevelClusterInfo.clusterList.addAll(ecVar.f446319f);
                                                        ec ecVar2 = ecVar;
                                                        byte[] bArr = ecVar2.f446317d;
                                                        qQFTSecondLevelClusterInfo.totalCount.setValue(UInt.m564boximpl(ecVar2.f446320g));
                                                        qQFTSecondLevelClusterInfo.pollBatchSeq = ecVar.f446321h;
                                                    } else {
                                                        QQFTSecondLevelClusterInfo qQFTSecondLevelClusterInfo2 = new QQFTSecondLevelClusterInfo();
                                                        ec ecVar3 = ecVar;
                                                        int i28 = ecVar3.f446316c;
                                                        qQFTSecondLevelClusterInfo2.totalCount.setValue(UInt.m564boximpl(ecVar3.f446320g));
                                                        qQFTSecondLevelClusterInfo2.pollBatchSeq = ecVar.f446321h;
                                                        qQFTSecondLevelClusterInfo2.clusterList.clear();
                                                        qQFTSecondLevelClusterInfo2.clusterList.addAll(ecVar.f446319f);
                                                        QQFlashTransferViewModel.this.secondLevelClusterList.put(Integer.valueOf(ecVar.f446316c), qQFTSecondLevelClusterInfo2);
                                                    }
                                                } else {
                                                    kLog7.d("QQFlashTransferFileListViewModel", "onClusteringListUpdate different file set return...... ");
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                    }
                                };
                            }
                            final QQFlashTransferViewModel$addFileSetClusteringListListener$1 qQFlashTransferViewModel$addFileSetClusteringListListener$12 = qQFlashTransferViewModel3.clusterListener;
                            if (qQFlashTransferViewModel$addFileSetClusteringListListener$12 != null) {
                                IKernelFlashTransferService a57 = IKernelFlashTransferService.f344757i.a();
                                a57.getClass();
                                ArrayList arrayList10 = new ArrayList();
                                arrayList10.add(String.valueOf(qQFlashTransferViewModel$addFileSetClusteringListListener$12.hashCode()));
                                Function1<Object, Unit> function19 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$addFileSetClusteringListListener$fileSetClusteringListListener$1
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        List emptyList;
                                        Object[] objArr = obj instanceof Object[] ? (Object[]) obj : null;
                                        if (objArr != null) {
                                            int i27 = 0;
                                            if (!(objArr.length == 0)) {
                                                Iterator it = ArrayIteratorKt.iterator(objArr);
                                                if (Intrinsics.areEqual((String) dr.a(it, "null cannot be cast to non-null type kotlin.String"), "onClusteringListUpdate")) {
                                                    Object next = it.next();
                                                    Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
                                                    int intValue = ((Integer) next).intValue();
                                                    Object[] objArr2 = new Object[intValue];
                                                    for (int i28 = 0; i28 < intValue; i28++) {
                                                        objArr2[i28] = it.next();
                                                    }
                                                    Iterator it5 = ArrayIteratorKt.iterator(objArr2);
                                                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                                                    ec ecVar = new ec(0, "", 0, new byte[0], false, emptyList, 0, 0, "");
                                                    while (it5.hasNext()) {
                                                        Object next2 = it5.next();
                                                        if (Intrinsics.areEqual(next2, "seq")) {
                                                            Object next3 = it5.next();
                                                            Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int");
                                                            ((Integer) next3).intValue();
                                                        } else if (Intrinsics.areEqual(next2, "result")) {
                                                            Object next4 = it5.next();
                                                            Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.Int");
                                                            ecVar.f446314a = ((Integer) next4).intValue();
                                                        } else if (Intrinsics.areEqual(next2, "errMs")) {
                                                            Object next5 = it5.next();
                                                            Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.String");
                                                            ecVar.f446315b = (String) next5;
                                                        } else if (Intrinsics.areEqual(next2, "type")) {
                                                            Object next6 = it5.next();
                                                            Intrinsics.checkNotNull(next6, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.ClusteringTypeKt.ClusteringType }");
                                                            ecVar.f446316c = ((Integer) next6).intValue();
                                                        } else if (Intrinsics.areEqual(next2, "paginationInfo")) {
                                                            Object next7 = it5.next();
                                                            Intrinsics.checkNotNull(next7, "null cannot be cast to non-null type kotlin.ByteArray");
                                                            ecVar.f446317d = (byte[]) next7;
                                                        } else if (Intrinsics.areEqual(next2, "isEnd")) {
                                                            Object next8 = it5.next();
                                                            Intrinsics.checkNotNull(next8, "null cannot be cast to non-null type kotlin.Int");
                                                            ecVar.f446318e = ((Integer) next8).intValue() == 1 ? 1 : i27;
                                                        } else {
                                                            if (Intrinsics.areEqual(next2, "clusteringList")) {
                                                                Object next9 = it5.next();
                                                                Intrinsics.checkNotNull(next9, "null cannot be cast to non-null type kotlin.Int");
                                                                int intValue2 = ((Integer) next9).intValue();
                                                                ArrayList arrayList11 = new ArrayList();
                                                                int i29 = i27;
                                                                while (i29 < intValue2) {
                                                                    Object next10 = it5.next();
                                                                    Intrinsics.checkNotNull(next10, "null cannot be cast to non-null type kotlin.Int");
                                                                    int intValue3 = ((Integer) next10).intValue();
                                                                    Object[] objArr3 = new Object[intValue3];
                                                                    for (int i36 = i27; i36 < intValue3; i36++) {
                                                                        objArr3[i36] = it5.next();
                                                                    }
                                                                    Iterator it6 = ArrayIteratorKt.iterator(objArr3);
                                                                    ws3.j jVar = new ws3.j("", "", new eg(), "", 0);
                                                                    while (it6.hasNext()) {
                                                                        Object next11 = it6.next();
                                                                        if (Intrinsics.areEqual(next11, "fileSetId")) {
                                                                            Object next12 = it6.next();
                                                                            Intrinsics.checkNotNull(next12, "null cannot be cast to non-null type kotlin.String");
                                                                            jVar.f446372a = (String) next12;
                                                                        } else if (Intrinsics.areEqual(next11, "clusteringId")) {
                                                                            Object next13 = it6.next();
                                                                            Intrinsics.checkNotNull(next13, "null cannot be cast to non-null type kotlin.String");
                                                                            jVar.f446373b = (String) next13;
                                                                        } else if (Intrinsics.areEqual(next11, AssetExtension.SCENE_THUMBNAIL)) {
                                                                            Object next14 = it6.next();
                                                                            Intrinsics.checkNotNull(next14, "null cannot be cast to non-null type kotlin.Int");
                                                                            int intValue4 = ((Integer) next14).intValue();
                                                                            Object[] objArr4 = new Object[intValue4];
                                                                            for (int i37 = 0; i37 < intValue4; i37++) {
                                                                                objArr4[i37] = it6.next();
                                                                            }
                                                                            jVar.f446374c = eh.a(objArr4);
                                                                        } else if (Intrinsics.areEqual(next11, "name")) {
                                                                            Object next15 = it6.next();
                                                                            Intrinsics.checkNotNull(next15, "null cannot be cast to non-null type kotlin.String");
                                                                            jVar.f446375d = (String) next15;
                                                                        } else if (Intrinsics.areEqual(next11, "clusteringNum")) {
                                                                            Object next16 = it6.next();
                                                                            Intrinsics.checkNotNull(next16, "null cannot be cast to non-null type kotlin.String");
                                                                            jVar.f446376e = vs3.a.a((String) next16);
                                                                        }
                                                                    }
                                                                    arrayList11.add(jVar);
                                                                    i29++;
                                                                    i27 = 0;
                                                                }
                                                                ecVar.f446319f = arrayList11;
                                                            } else if (Intrinsics.areEqual(next2, "totalCount")) {
                                                                Object next17 = it5.next();
                                                                Intrinsics.checkNotNull(next17, "null cannot be cast to non-null type kotlin.String");
                                                                ecVar.f446320g = vs3.a.a((String) next17);
                                                            } else if (Intrinsics.areEqual(next2, "pollBatchSeq")) {
                                                                Object next18 = it5.next();
                                                                Intrinsics.checkNotNull(next18, "null cannot be cast to non-null type kotlin.String");
                                                                ecVar.f446321h = vs3.a.a((String) next18);
                                                            } else if (Intrinsics.areEqual(next2, "fileSetId")) {
                                                                Object next19 = it5.next();
                                                                Intrinsics.checkNotNull(next19, "null cannot be cast to non-null type kotlin.String");
                                                                ecVar.f446322i = (String) next19;
                                                            }
                                                            i27 = 0;
                                                        }
                                                    }
                                                    cv.this.onClusteringListUpdate(ecVar);
                                                    return Unit.INSTANCE;
                                                }
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                Object[] array12 = arrayList10.toArray(new Object[0]);
                                Intrinsics.checkNotNull(array12, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                i16 = 1;
                                a57.syncToNativeMethod(true, "addFileSetClusteringListListener", array12, function19);
                                a57.f344762e.put(qQFlashTransferViewModel$addFileSetClusteringListListener$12, function19);
                            } else {
                                i16 = 1;
                            }
                            qQFlashTransferViewModel3.getFileSetClusteringList(i16);
                            qQFlashTransferViewModel3.getFileSetClusteringList(2);
                            StringBuilder m29 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchClusterList clusterType=");
                            m29.append(qQFlashTransferViewModel3.clusterType);
                            m29.append(" parentId=");
                            m29.append(qQFlashTransferViewModel3.parentId);
                            kLog6.d(str3, m29.toString());
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
        }
        str2 = "QQFlashTransferFileListViewModel";
        str3 = "QQTransferDownloadActivity";
        if (z16) {
        }
    }

    public final void updateListMode() {
        c cVar = c.f117352a;
        CacheModule cacheModule = (CacheModule) cVar.g().acquireModule("HRCacheModule");
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("qq_flash_transfer_list_mode");
        m3.append(cVar.g().getPageData().n().q("uin", ""));
        Integer num = cacheModule.getInt(m3.toString());
        MutableState<Boolean> mutableState = this.viewModel.isGridMode;
        boolean z16 = false;
        if (num == null || num.intValue() == 0) {
            if (this.viewModel.compressedFileFolderId.length() == 0) {
                z16 = true;
            }
        }
        mutableState.setValue(Boolean.valueOf(z16));
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final void onCreate(com.tencent.ntcompose.activity.a aVar) {
        FTFilterType fTFilterType;
        List split$default;
        int collectionSizeOrDefault;
        List list;
        super.onCreate(aVar);
        final QQFlashTransferViewModel qQFlashTransferViewModel = this.viewModel;
        MutableState<String> mutableState = qQFlashTransferViewModel.pageTitle;
        QQContext qQContext = QQContext.INSTANCE;
        mutableState.setValue(qQContext.getPageData().n().p("parent_name"));
        qQFlashTransferViewModel.parentId.setValue(qQContext.getPageData().n().p("parent_id"));
        qQFlashTransferViewModel.fileSetId = qQContext.getPageData().n().p("file_set_id");
        qQFlashTransferViewModel.indexPath = qQContext.getPageData().n().p("index_path");
        qQFlashTransferViewModel.compressedFileFolderId = qQContext.getPageData().n().p("compressed_file_folder_id");
        qQFlashTransferViewModel.clusterType = qQContext.getPageData().n().k("cluster_type", -1);
        qQFlashTransferViewModel.clusterId = qQContext.getPageData().n().p("cluster_id");
        qQFlashTransferViewModel.clusteringNum.setValue(Integer.valueOf(qQContext.getPageData().n().k("cluster_num", 0)));
        qQFlashTransferViewModel.curFaceUrl.setValue(qQContext.getPageData().n().p("face_url"));
        qQFlashTransferViewModel.dirFileCount.setValue(Integer.valueOf(qQContext.getPageData().n().j("dir_file_count")));
        qQFlashTransferViewModel.dirFileSize.setValue(Long.valueOf(qQContext.getPageData().n().n("dir_file_size")));
        qQFlashTransferViewModel.sceneType = qQContext.getPageData().n().k(VRReportDefine$ReportParam.SCENE_TYPE, 0);
        qQFlashTransferViewModel.clusterInfo.getValue().f446295h = qQFlashTransferViewModel.sceneType;
        qQFlashTransferViewModel.fromH5AllCheck.setValue(qQContext.getPageData().n().p("all_checked"));
        qQFlashTransferViewModel.hasSendEntrance = qQContext.getPageData().n().j("has_send_entrance") == 1;
        qQFlashTransferViewModel.isParentCompressFolderDownloadFile.setValue(Boolean.valueOf(qQContext.getPageData().n().j("parent_zip_downloaded_file") == 1));
        qQFlashTransferViewModel.entryId = qQContext.getPageData().n().q("entry_id", "0");
        int j3 = qQContext.getPageData().n().j("parent_filter_type");
        MutableState<FTFilterType> mutableState2 = qQFlashTransferViewModel.filterType;
        FTFilterType[] values = FTFilterType.values();
        int length = values.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                fTFilterType = null;
                break;
            }
            fTFilterType = values[i3];
            if (fTFilterType.statusId == j3) {
                break;
            } else {
                i3++;
            }
        }
        if (fTFilterType == null) {
            fTFilterType = FTFilterType.ALL_FILE;
        }
        mutableState2.setValue(fTFilterType);
        String p16 = qQContext.getPageData().n().p("selected_items");
        if (p16.length() > 0) {
            try {
                split$default = StringsKt__StringsKt.split$default((CharSequence) p16, new String[]{"_"}, false, 0, 6, (Object) null);
                qQFlashTransferViewModel.entryId = "7";
                if (!split$default.isEmpty()) {
                    SnapshotStateList<Long> snapshotStateList = qQFlashTransferViewModel.fromH5SelectItems;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(split$default, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator it = split$default.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Long.valueOf(Long.parseLong((String) it.next())));
                    }
                    list = CollectionsKt___CollectionsKt.toList(arrayList);
                    snapshotStateList.addAll(list);
                }
            } catch (Exception e16) {
                KLog.INSTANCE.e("QQFlashTransferFileListViewModel", "parse fromH5SelectItemsStr error: " + e16);
            }
        }
        c cVar = c.f117352a;
        qQFlashTransferViewModel.downloadFinishBarCloseNotifyListener = com.tencent.kuikly.core.module.k.b((com.tencent.kuikly.core.module.k) cVar.g().acquireModule("KRNotifyModule"), "kQQFTDownloadFinishBarCloseNotify", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$initData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                QQFlashTransferViewModel.this.showFinishDownloadBar.setValue(Boolean.FALSE);
                return Unit.INSTANCE;
            }
        }, 2, null);
        qQFlashTransferViewModel.parentCompressDownloadNotifyListener = com.tencent.kuikly.core.module.k.b((com.tencent.kuikly.core.module.k) cVar.g().acquireModule("KRNotifyModule"), "kQQFTCompressFolderDownloadNotify", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$initData$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                if (Intrinsics.areEqual(eVar2 != null ? eVar2.p("kCompressFolderId") : null, QQFlashTransferViewModel.this.compressedFileFolderId)) {
                    QQFlashTransferViewModel.this.isParentCompressFolderDownloadFile.setValue(Boolean.TRUE);
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("init refreshData clusterType:");
        m3.append(qQFlashTransferViewModel.clusterType);
        m3.append(" indexPath: ");
        StringBuilder m16 = PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(m3, qQFlashTransferViewModel.indexPath, " parentFilterType:", j3, " sceneType:");
        m16.append(qQFlashTransferViewModel.sceneType);
        kLog.e("QQFlashTransferFileListViewModel", m16.toString());
        this.modalMode = cVar.g().getPageData().n().j(KuiklyLaunchParams.PARAM_MODAL_MODE);
        updateListMode();
        if (this.viewModel.isCompressFirstLevelPage()) {
            QQFlashTransferViewModel qQFlashTransferViewModel2 = this.viewModel;
            qQFlashTransferViewModel2.feedListViewModel.feedCardViewModelList.add(new QQFTCompressTitleFilterCardVM(qQFlashTransferViewModel2));
        } else if (this.viewModel.isCompressFolderPage()) {
            QQFlashTransferViewModel qQFlashTransferViewModel3 = this.viewModel;
            qQFlashTransferViewModel3.feedListViewModel.feedCardViewModelList.add(new QQFTFilterLayoutModeVM(qQFlashTransferViewModel3));
        } else {
            QQFlashTransferViewModel qQFlashTransferViewModel4 = this.viewModel;
            qQFlashTransferViewModel4.feedListViewModel.feedCardViewModelList.add((QQFTTitleStatusCardVM) qQFlashTransferViewModel4.titleStatusCardVM$delegate.getValue());
            QQFlashTransferViewModel qQFlashTransferViewModel5 = this.viewModel;
            qQFlashTransferViewModel5.feedListViewModel.feedCardViewModelList.add(new QQFTAIClusterListCardVM(qQFlashTransferViewModel5));
            QQFlashTransferViewModel qQFlashTransferViewModel6 = this.viewModel;
            qQFlashTransferViewModel6.feedListViewModel.feedCardViewModelList.add(new QQFTFilterLayoutModeVM(qQFlashTransferViewModel6));
        }
        QQFlashTransferViewModel qQFlashTransferViewModel7 = this.viewModel;
        qQFlashTransferViewModel7.firstFileContentIndex = qQFlashTransferViewModel7.feedListViewModel.feedCardViewModelList.size();
        com.tencent.ntcompose.activity.b.c(this, null, ComposableLambdaKt.composableLambdaInstance(-1823672832, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$onCreate$1
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
                        ComposerKt.traceEventStart(-1823672832, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.onCreate.<anonymous> (QQTransferDownloadActivity.kt:166)");
                    }
                    if (QQTransferDownloadActivity.this.modalMode == 1) {
                        composer2.startReplaceableGroup(1538875351);
                        AnonymousClass1 anonymousClass1 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$onCreate$1.1
                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                QQKuiklyPlatformApi qQKuiklyPlatformApi = (QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi");
                                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                qQKuiklyPlatformApi.closePage(false);
                                return Unit.INSTANCE;
                            }
                        };
                        final QQTransferDownloadActivity qQTransferDownloadActivity = QQTransferDownloadActivity.this;
                        QUIDragBackViewKt.QUIDragBackView(anonymousClass1, false, ComposableLambdaKt.composableLambda(composer2, -2101353715, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$onCreate$1.2
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Composer composer3, Integer num2) {
                                Composer composer4 = composer3;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2101353715, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.onCreate.<anonymous>.<anonymous> (QQTransferDownloadActivity.kt:171)");
                                    }
                                    i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                                    final QQTransferDownloadActivity qQTransferDownloadActivity2 = QQTransferDownloadActivity.this;
                                    BoxKt.a(h16, null, null, ComposableLambdaKt.composableLambda(composer4, -815267309, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.onCreate.1.2.1
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(b bVar, Composer composer5, Integer num3) {
                                            Composer composer6 = composer5;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer6.getSkipping()) {
                                                composer6.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-815267309, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (QQTransferDownloadActivity.kt:172)");
                                                }
                                                i.Companion companion = i.INSTANCE;
                                                AnimatedTransitionBoxKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null), h.INSTANCE.a(0.4f)), null, AnimatedTransitionType.FADE_IN_OUT, QQTransferDownloadActivity.this.didEntered.getValue().booleanValue(), new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.onCreate.1.2.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                                        bool.booleanValue();
                                                        return Unit.INSTANCE;
                                                    }
                                                }, null, null, ComposableSingletons$QQTransferDownloadActivityKt.f147lambda1, composer6, 12607880, 98);
                                                i h17 = ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null);
                                                AnimatedTransitionType animatedTransitionType = AnimatedTransitionType.DIRECTION_FROM_BOTTOM;
                                                boolean booleanValue = QQTransferDownloadActivity.this.didEntered.getValue().booleanValue();
                                                C46662 c46662 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.onCreate.1.2.1.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Boolean bool) {
                                                        boolean booleanValue2 = bool.booleanValue();
                                                        CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0.m("transitionAnimationFinish ", booleanValue2, KLog.INSTANCE, "QQTransferDownloadActivity");
                                                        if (!booleanValue2) {
                                                            QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                                            QQKuiklyPlatformApi.Companion.closePage$default();
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                m d16 = com.tencent.ntcompose.animation.b.d(250, 0, com.tencent.ntcompose.animation.i.b(), null, 10, null);
                                                m d17 = com.tencent.ntcompose.animation.b.d(250, 0, com.tencent.ntcompose.animation.i.a(), null, 10, null);
                                                final QQTransferDownloadActivity qQTransferDownloadActivity3 = QQTransferDownloadActivity.this;
                                                AnimatedTransitionBoxKt.a(h17, null, animatedTransitionType, booleanValue, c46662, d16, d17, ComposableLambdaKt.composableLambda(composer6, 510258708, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.onCreate.1.2.1.3
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(b bVar2, Composer composer7, Integer num4) {
                                                        Composer composer8 = composer7;
                                                        int intValue4 = num4.intValue();
                                                        if ((intValue4 & 81) == 16 && composer8.getSkipping()) {
                                                            composer8.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(510258708, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity.onCreate.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQTransferDownloadActivity.kt:193)");
                                                            }
                                                            QQTransferDownloadActivity qQTransferDownloadActivity4 = QQTransferDownloadActivity.this;
                                                            QQTransferDownloadActivity.access$body(qQTransferDownloadActivity4, qQTransferDownloadActivity4.viewModel, composer8, 72);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer6, 12607880, 2);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer4, 3080, 6);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer2, 390, 2);
                        composer2.endReplaceableGroup();
                    } else {
                        composer2.startReplaceableGroup(1538876962);
                        QQTransferDownloadActivity qQTransferDownloadActivity2 = QQTransferDownloadActivity.this;
                        QQTransferDownloadActivity.access$body(qQTransferDownloadActivity2, qQTransferDownloadActivity2.viewModel, composer2, 72);
                        composer2.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), 1, null);
        StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("QQTransferDownloadActivity start parentId=");
        m17.append(this.viewModel.parentId.getValue());
        m17.append(" fileSetId=");
        m17.append(this.viewModel.fileSetId);
        m17.append(" clusterType=");
        m17.append(this.viewModel.clusterType);
        m17.append(" clusterId=");
        m17.append(this.viewModel.clusterId);
        m17.append(" allChecked=");
        m17.append(this.viewModel.fromH5AllCheck.getValue());
        m17.append(" fromH5SelectItems=");
        m17.append(this.viewModel.fromH5SelectItems);
        m17.append(" selected_items=");
        m17.append(this.viewModel.fromH5SelectItems.size());
        m17.append(" modalMode=");
        m17.append(this.modalMode);
        m17.append(" hasSendEntrance=");
        m17.append(this.viewModel.hasSendEntrance);
        m17.append(" filterType=");
        m17.append(this.viewModel.filterType.getValue());
        m17.append(" sceneType=");
        ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(m17, this.viewModel.sceneType, kLog, "QQTransferDownloadActivity");
        QQFlashTransferKuiklyModule.Companion.getInstance().toNative(true, "getFileSaveRootDirectory", "", new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$onCreate$2
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                if (eVar2 != null) {
                    String p17 = eVar2.p("rootDirectory");
                    KLog.INSTANCE.d("QQTransferDownloadActivity", "getFileSaveRootDirectory rootPath=" + p17);
                    IKernelFlashTransferService a16 = IKernelFlashTransferService.f344757i.a();
                    final Cdo cdo = new Cdo() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$onCreate$2$1$1
                        @Override // ws3.Cdo
                        /* renamed from: onSetDownLoadFileDirResult-WZ4Q5Ns, reason: not valid java name */
                        public final void mo132onSetDownLoadFileDirResultWZ4Q5Ns(final int i16) {
                            SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity$onCreate$2$1$1$onSetDownLoadFileDirResult$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    KLog kLog2 = KLog.INSTANCE;
                                    StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onSetDownLoadFileDirResult resultCode=");
                                    m18.append((Object) UInt.m615toStringimpl(i16));
                                    kLog2.i("QQTransferDownloadActivity", m18.toString());
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                    };
                    a16.getClass();
                    ArrayList m18 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m(p17);
                    m18.add(String.valueOf(cdo.hashCode()));
                    Function1<Object, Unit> function1 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$setDownLoadDefaultFileDir$kernelCallback$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Object obj) {
                            Object[] objArr = obj instanceof Object[] ? (Object[]) obj : null;
                            if (objArr != null) {
                                if (!(objArr.length == 0)) {
                                    Iterator it5 = ArrayIteratorKt.iterator(objArr);
                                    if (Intrinsics.areEqual((String) dr.a(it5, "null cannot be cast to non-null type kotlin.String"), "onSetDownLoadFileDirResult")) {
                                        Object next = it5.next();
                                        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
                                        Cdo.this.mo132onSetDownLoadFileDirResultWZ4Q5Ns(vs3.a.a((String) next));
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    Object[] array = m18.toArray(new Object[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    a16.syncToNativeMethod(true, "setDownLoadDefaultFileDir", array, function1);
                }
                return Unit.INSTANCE;
            }
        }, false);
        Utils.INSTANCE.getClass();
        if (((QQKuiklyPlatformApi) cVar.g().acquireModule("QQKuiklyPlatformApi")).getNetworkType() == QQKuiklyPlatformApi.QQNetworkType.NOT_REACHABLE) {
            QQKuiklyPlatformApi.Companion.qqToast("\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8bbe\u7f6e", QToastMode.Warning);
            this.isNetworkReachable = false;
        }
        if (this.viewModel.isSecondaryPage()) {
            StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getFileSetInfo cache = ");
            m18.append(QQFlashTransferCurFileSetInfo.fileSetInfo);
            kLog.d("QQTransferDownloadActivity", m18.toString());
            if (QQFlashTransferCurFileSetInfo.fileSetInfo != null) {
                StringBuilder m19 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getFileSetInfo Cache ");
                br brVar = QQFlashTransferCurFileSetInfo.fileSetInfo;
                Intrinsics.checkNotNull(brVar);
                m19.append(brVar.f446187a);
                m19.append(" - ");
                NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(m19, this.viewModel.fileSetId, kLog, "QQTransferDownloadActivity");
                br brVar2 = QQFlashTransferCurFileSetInfo.fileSetInfo;
                if (brVar2 != null) {
                    updateFileSet(0, "", brVar2, false);
                }
                kLog.d("QQTransferDownloadActivity", "getFileSetInfo from cache.");
                return;
            }
            requestFileSet();
            kLog.d("QQTransferDownloadActivity", "re getFileSetInfo from requestFileSet.");
            return;
        }
        requestFileSet();
        kLog.d("QQTransferDownloadActivity", "getFileSetInfo from requestFileSet.");
    }
}
