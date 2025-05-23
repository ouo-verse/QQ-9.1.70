package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Timer;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQAnimatedImageKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogItem;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIButtonKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIButtonType;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.da_tong_report.DTReportConstKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.MqqUi;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.mobileqq.activity.photo.MediaDBValues;
import com.tencent.mobileqq.flashtransfer.api.impl.FlashTransferHelperApiImpl;
import com.tencent.mobileqq.vaswebviewplugin.VasBusiness;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.foundation.scheduler.SchedulerKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService;
import defpackage.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.UnsignedKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import org.apache.httpcore.message.TokenParser;
import ws3.ab;
import ws3.br;
import ws3.ca;
import ws3.cx;
import ws3.dr;
import ws3.y;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTDownloadBarViewKt {
    public static final float access$getSaveTime(ca caVar) {
        int compare;
        compare = Integer.compare(caVar.f446236g ^ Integer.MIN_VALUE, UInt.m570constructorimpl(1000000) ^ Integer.MIN_VALUE);
        if (compare <= 0) {
            return 0.0f;
        }
        return ((((float) UnsignedKt.ulongToDouble(caVar.f446234e)) / 1000.0f) / 1000.0f) - (((float) UnsignedKt.ulongToDouble(caVar.f446234e)) / ((float) UnsignedKt.uintToDouble(caVar.f446236g)));
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.ArrayList] */
    public static final int handleDownloadFiles(final QQFlashTransferViewModel qQFlashTransferViewModel) {
        final int size = qQFlashTransferViewModel.selectFilesToDownload.size();
        final int downloadStatusFileCount = qQFlashTransferViewModel.getDownloadStatusFileCount(2);
        final int downloadStatusFileCount2 = qQFlashTransferViewModel.getDownloadStatusFileCount(3);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new ArrayList();
        Iterator<Map.Entry<String, ab>> it = qQFlashTransferViewModel.selectFilesToDownload.entrySet().iterator();
        while (true) {
            boolean z16 = false;
            if (!it.hasNext()) {
                break;
            }
            ab value = it.next().getValue();
            if (qQFlashTransferViewModel.downloadingFileList.containsKey(value.f446151b)) {
                ab abVar = qQFlashTransferViewModel.downloadingFileList.get(value.f446151b);
                if (abVar != null && abVar.C == 4) {
                    z16 = true;
                }
                if (z16) {
                }
            }
            if (!value.f446155f || value.f446164o > 0) {
                ((List) objectRef.element).add(value);
            }
        }
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("handleDownloadFiles selectFilesToDownload=");
        m3.append(qQFlashTransferViewModel.selectFilesToDownload.size());
        m3.append(" readyToDownloadList=");
        StringBuilder m16 = NearbyFDPageViewModel$$ExternalSyntheticOutline0.m((List) objectRef.element, m3, " downloadingFileList=");
        m16.append(qQFlashTransferViewModel.downloadingFileList.size());
        kLog.d("QQFTDownloadBarView", m16.toString());
        if (((List) objectRef.element).size() > 0) {
            qQFlashTransferViewModel.startFileListDownLoad(qQFlashTransferViewModel.fileSetId, (List) objectRef.element, new cx() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$handleDownloadFiles$1
                @Override // ws3.cx
                /* renamed from: onResult-jXDDuk8 */
                public final void mo120onResultjXDDuk8(final int i3, final String str, final int i16) {
                    final int i17 = size;
                    final int i18 = downloadStatusFileCount2;
                    final int i19 = downloadStatusFileCount;
                    final QQFlashTransferViewModel qQFlashTransferViewModel2 = qQFlashTransferViewModel;
                    final Ref.ObjectRef<List<ab>> objectRef2 = objectRef;
                    SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$handleDownloadFiles$1$onResult$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            KLog kLog2 = KLog.INSTANCE;
                            StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("handleDownloadFiles startFileListDownLoad result=");
                            m17.append(i3);
                            m17.append(" errMsg=");
                            m17.append(str);
                            m17.append(" extraInfo=");
                            m17.append((Object) UInt.m615toStringimpl(i16));
                            kLog2.d("QQFTDownloadBarView", m17.toString());
                            if (i3 != 0) {
                                StringsKt__StringsJVMKt.equals("CANCEL_DOWNLOAD_BY_CELLULAR_NETWORK", str, false);
                            } else {
                                int i26 = i17;
                                int i27 = i18;
                                if (i26 == i27) {
                                    kLog2.d("QQFTDownloadBarView", "IFlashTransferDownloadOperationCallback \u6587\u4ef6\u5df2\u4e0b\u8f7d");
                                } else if ((1 <= i27 && i27 < i26) && i19 == 0) {
                                    if (qQFlashTransferViewModel2.downloadingFileList.size() == 0) {
                                        QQKuiklyPlatformApi.Companion.qqToast("\u90e8\u5206\u6587\u4ef6\u5df2\u4e0b\u8f7d", QToastMode.Info);
                                    } else {
                                        QQKuiklyPlatformApi.Companion.qqToast("\u90e8\u5206\u6587\u4ef6\u5df2\u4e0b\u8f7d\u5b8c\u6210", QToastMode.Info);
                                    }
                                }
                                for (ab abVar2 : objectRef2.element) {
                                    if (qQFlashTransferViewModel2.downloadingFileList.containsKey(abVar2.f446151b)) {
                                        ab abVar3 = qQFlashTransferViewModel2.downloadingFileList.get(abVar2.f446151b);
                                        if (abVar3 != null && abVar3.C == 4) {
                                        }
                                    }
                                    if (!qQFlashTransferViewModel2.downloadingFileList.containsKey(abVar2.f446151b)) {
                                        qQFlashTransferViewModel2.downloadingFileList.put(abVar2.f446151b, abVar2);
                                    }
                                    MutableState<Long> mutableState = qQFlashTransferViewModel2.roundDownloadingSize;
                                    mutableState.setValue(Long.valueOf(mutableState.getValue().longValue() + abVar2.f446164o));
                                }
                                final QQFlashTransferViewModel qQFlashTransferViewModel3 = qQFlashTransferViewModel2;
                                TimerKt.c(50, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$handleDownloadFiles$1$onResult$1.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        Integer value2;
                                        Integer value3;
                                        if (!QQFlashTransferViewModel.this.isDownloadBarShow() && (((value2 = QQFlashTransferViewModel.this.fileSetDownLoadTaskStatus.getValue()) != null && value2.intValue() == 0) || ((value3 = QQFlashTransferViewModel.this.fileSetDownLoadTaskStatus.getValue()) != null && value3.intValue() == 1))) {
                                            QQFlashTransferViewModel.this.forceShowDownloadBar.setValue(Boolean.TRUE);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                e eVar = new e();
                                eVar.v(FlashTransferHelperApiImpl.kFileSetIdKey, qQFlashTransferViewModel2.fileSetId);
                                k.d((k) c.f117352a.g().acquireModule("KRNotifyModule"), "kQQFTCenterFileSetStatusDidChangeNotification", eVar, false, 4, null);
                                KLog.INSTANCE.d("QQFTDownloadBarView", "post notify: json:" + eVar);
                            }
                            return Unit.INSTANCE;
                        }
                    });
                }
            }, false);
            StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("startFileListDownLoad size=");
            m17.append(((List) objectRef.element).size());
            kLog.d("QQFTDownloadBarView", m17.toString());
        } else {
            qQFlashTransferViewModel.forceShowDownloadBar.setValue(Boolean.FALSE);
            QQKuiklyPlatformApi.Companion.qqToast("\u7a7a\u6587\u4ef6\u5939\u65e0\u6cd5\u4e0b\u8f7d", QToastMode.Warning);
        }
        qQFlashTransferViewModel.selectFilesToDownload.clear();
        return ((List) objectRef.element).size();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
    
        if (kotlin.UnsignedKt.ulongCompare(kotlin.ULong.m648constructorimpl(r9 & 4294967295L), kotlin.ULong.m648constructorimpl(5242880)) >= 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007a, code lost:
    
        if (r1.intValue() != 1) goto L24;
     */
    /* renamed from: updateSpeed-qim9Vi0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m124updateSpeedqim9Vi0(int i3, QQFlashTransferViewModel qQFlashTransferViewModel) {
        int compare;
        Integer value;
        boolean booleanValue = qQFlashTransferViewModel.isAutoSpeedUp.getValue().booleanValue();
        if (!qQFlashTransferViewModel.isAutoSpeedUp.getValue().booleanValue()) {
            compare = Integer.compare(i3 ^ Integer.MIN_VALUE, UInt.m570constructorimpl(10485760) ^ Integer.MIN_VALUE);
            if ((compare > 0) && (value = qQFlashTransferViewModel.fileSetDownLoadTaskStatus.getValue()) != null && value.intValue() == 1) {
                qQFlashTransferViewModel.isAutoSpeedUp.setValue(Boolean.TRUE);
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("speed=");
                m3.append((Object) UInt.m615toStringimpl(i3));
                m3.append(" getSpeedStr=");
                m3.append(l.f413536a.e(i3));
                m3.append(" oldAutoSpeedUp=");
                m3.append(booleanValue);
                m3.append(" isAutoSpeedUp=");
                m3.append(qQFlashTransferViewModel.isAutoSpeedUp.getValue().booleanValue());
                m3.append(" status=");
                m3.append(qQFlashTransferViewModel.fileSetDownLoadTaskStatus.getValue());
                kLog.d("updateSpeed", m3.toString());
            }
        }
        if (qQFlashTransferViewModel.isAutoSpeedUp.getValue().booleanValue()) {
        }
        Integer value2 = qQFlashTransferViewModel.fileSetDownLoadTaskStatus.getValue();
        if (value2 != null) {
        }
        qQFlashTransferViewModel.isAutoSpeedUp.setValue(Boolean.FALSE);
        KLog kLog2 = KLog.INSTANCE;
        StringBuilder m36 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("speed=");
        m36.append((Object) UInt.m615toStringimpl(i3));
        m36.append(" getSpeedStr=");
        m36.append(l.f413536a.e(i3));
        m36.append(" oldAutoSpeedUp=");
        m36.append(booleanValue);
        m36.append(" isAutoSpeedUp=");
        m36.append(qQFlashTransferViewModel.isAutoSpeedUp.getValue().booleanValue());
        m36.append(" status=");
        m36.append(qQFlashTransferViewModel.fileSetDownLoadTaskStatus.getValue());
        kLog2.d("updateSpeed", m36.toString());
    }

    /* JADX WARN: Type inference failed for: r2v16, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
    public static final void QQFTDownloadBarView(final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(568234683);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(568234683, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarView (QQFTDownloadBarView.kt:91)");
        }
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("showDownloadBarView inProgressAnim=");
        m3.append(qQFlashTransferViewModel.inProgressAnim.getValue().booleanValue());
        m3.append(" fileSetDownLoadTaskStatus=");
        m3.append(qQFlashTransferViewModel.fileSetDownLoadTaskStatus.getValue());
        m3.append(" forceShowDownloadBar=");
        m3.append(qQFlashTransferViewModel.forceShowDownloadBar.getValue().booleanValue());
        m3.append(" selectFilesToDownload=");
        m3.append(qQFlashTransferViewModel.selectFilesToDownload.size());
        m3.append(" itemVMListSize=");
        m3.append(qQFlashTransferViewModel.itemVMList.size());
        m3.append(" isFileSetInvalid=");
        m3.append(qQFlashTransferViewModel.isFileSetInvalid());
        kLog.d("QQFTDownloadBarView", m3.toString());
        if (qQFlashTransferViewModel.isSelectAndDownloadBarShow()) {
            startRestartGroup.startReplaceableGroup(878094271);
            if (qQFlashTransferViewModel.isSelectBarShow()) {
                startRestartGroup.startReplaceableGroup(878094314);
                if (qQFlashTransferViewModel.downloadingFileList.size() == 0 && !qQFlashTransferViewModel.isDownloadBarShow()) {
                    qQFlashTransferViewModel.resetDownloadProcess();
                }
                downloadSelectView(qQFlashTransferViewModel, startRestartGroup, 8);
                addRestartDownloadAlertDialog(qQFlashTransferViewModel, startRestartGroup, 8);
                startRestartGroup.endReplaceableGroup();
            } else if (qQFlashTransferViewModel.isDownloadBarShow()) {
                startRestartGroup.startReplaceableGroup(878094617);
                downloadProcessView(qQFlashTransferViewModel, startRestartGroup, 8);
                cancelDownloadAlertDialog(qQFlashTransferViewModel, startRestartGroup, 8);
                startRestartGroup.endReplaceableGroup();
            } else if (qQFlashTransferViewModel.isShowDownloadFinishBar()) {
                startRestartGroup.startReplaceableGroup(878094767);
                qQFlashTransferViewModel.resetDownloadProcess();
                downloadFinishView(qQFlashTransferViewModel, startRestartGroup, 8);
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(878094865);
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
        } else if (qQFlashTransferViewModel.canShowAllSelectCheckBox()) {
            startRestartGroup.startReplaceableGroup(878094919);
            downloadAllFileView(qQFlashTransferViewModel, startRestartGroup, 8);
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(878094965);
            startRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$QQFTDownloadBarView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTDownloadBarViewKt.QQFTDownloadBarView(QQFlashTransferViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void addRestartDownloadAlertDialog(final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1304958055);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1304958055, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.addRestartDownloadAlertDialog (QQFTDownloadBarView.kt:715)");
        }
        QUIAlertDialogKt.QUIAlertDialog(qQFlashTransferViewModel.showAddRestartDownloadAlertDialog.getValue().booleanValue(), "\u786e\u8ba4\u6dfb\u52a0\u4e0b\u8f7d\u4efb\u52a1", "\u5f53\u524d\u4e0b\u8f7d\u4efb\u52a1\u5df2\u6682\u505c\uff0c\u6dfb\u52a0\u65b0\u4efb\u52a1\u540e\u6240\u6709\u4efb\u52a1\u90fd\u5c06\u91cd\u65b0\u542f\u52a8", null, new QUIAlertDialogItem[]{QUIAlertDialogKt.QUIAlertDialogNormalTextItem("\u53d6\u6d88", new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$addRestartDownloadAlertDialog$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                QQFlashTransferViewModel.this.showAddRestartDownloadAlertDialog.setValue(Boolean.FALSE);
                return Unit.INSTANCE;
            }
        }), QUIAlertDialogKt.QUIAlertDialogNormalTextItem("\u6dfb\u52a0\u4e0b\u8f7d", new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$addRestartDownloadAlertDialog$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                String str;
                MutableState<Boolean> mutableState = QQFlashTransferViewModel.this.showAddRestartDownloadAlertDialog;
                Boolean bool = Boolean.FALSE;
                mutableState.setValue(bool);
                QQFlashTransferViewModel.this.isDownloadPause.setValue(bool);
                final int downloadStatusFileCount = QQFlashTransferViewModel.this.getDownloadStatusFileCount(4);
                IKernelFlashTransferService a16 = IKernelFlashTransferService.f344757i.a();
                br value = QQFlashTransferViewModel.this.fileSet.getValue();
                if (value == null || (str = value.f446187a) == null) {
                    str = "";
                }
                y yVar = new y();
                yVar.f446405a = Boolean.TRUE;
                Unit unit = Unit.INSTANCE;
                final QQFlashTransferViewModel qQFlashTransferViewModel2 = QQFlashTransferViewModel.this;
                a16.m(str, yVar, new cx() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$addRestartDownloadAlertDialog$2.2
                    @Override // ws3.cx
                    /* renamed from: onResult-jXDDuk8 */
                    public final void mo120onResultjXDDuk8(final int i16, final String str2, final int i17) {
                        final QQFlashTransferViewModel qQFlashTransferViewModel3 = QQFlashTransferViewModel.this;
                        final int i18 = downloadStatusFileCount;
                        SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$addRestartDownloadAlertDialog$2$2$onResult$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                KLog kLog = KLog.INSTANCE;
                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("reStartAndAddDownloadAlertDialog result=");
                                m3.append(i16);
                                m3.append(" errMsg=");
                                m3.append(str2);
                                m3.append(" extraInfo=");
                                m3.append((Object) UInt.m615toStringimpl(i17));
                                m3.append(" selectFilesToDownload=");
                                m3.append(qQFlashTransferViewModel3.selectFilesToDownload.size());
                                kLog.d("QQFTDownloadBarView", m3.toString());
                                int size = qQFlashTransferViewModel3.selectFilesToDownload.size();
                                if (i18 == size) {
                                    qQFlashTransferViewModel3.selectFilesToDownload.clear();
                                    QQKuiklyPlatformApi.Companion.qqToast("\u6587\u4ef6\u5df2\u5728\u4e0b\u8f7d\u4efb\u52a1\u4e2d", QToastMode.Info);
                                } else {
                                    QQFTDownloadBarViewKt.handleDownloadFiles(qQFlashTransferViewModel3);
                                }
                                qQFlashTransferViewModel3.updateAllItem(false);
                                qQFlashTransferViewModel3.updateFileContentOffset(size);
                                return Unit.INSTANCE;
                            }
                        });
                    }
                });
                return Unit.INSTANCE;
            }
        })}, null, null, startRestartGroup, 33200, 104);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$addRestartDownloadAlertDialog$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTDownloadBarViewKt.addRestartDownloadAlertDialog(QQFlashTransferViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void cancelDownloadAlertDialog(final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-313156197);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-313156197, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.cancelDownloadAlertDialog (QQFTDownloadBarView.kt:675)");
        }
        QUIAlertDialogKt.QUIAlertDialog(qQFlashTransferViewModel.showCancelDownloadAlertDialog.getValue().booleanValue(), null, "\u662f\u5426\u53d6\u6d88\u4e0b\u8f7d\uff1f", null, new QUIAlertDialogItem[]{QUIAlertDialogKt.QUIAlertDialogNormalTextItem("\u4e0d\uff0c\u7ee7\u7eed\u4e0b\u8f7d", new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$cancelDownloadAlertDialog$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                QQFlashTransferViewModel.this.showCancelDownloadAlertDialog.setValue(Boolean.FALSE);
                return Unit.INSTANCE;
            }
        }), QUIAlertDialogKt.QUIAlertDialogNormalTextItem("\u662f\uff0c\u6211\u8981\u53d6\u6d88", new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$cancelDownloadAlertDialog$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                String str;
                IKernelFlashTransferService a16 = IKernelFlashTransferService.f344757i.a();
                br value = QQFlashTransferViewModel.this.fileSet.getValue();
                if (value == null || (str = value.f446187a) == null) {
                    str = "";
                }
                y yVar = new y();
                yVar.f446405a = Boolean.TRUE;
                Unit unit = Unit.INSTANCE;
                final QQFlashTransferViewModel qQFlashTransferViewModel2 = QQFlashTransferViewModel.this;
                a16.o(str, yVar, new cx() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$cancelDownloadAlertDialog$2.2
                    @Override // ws3.cx
                    /* renamed from: onResult-jXDDuk8 */
                    public final void mo120onResultjXDDuk8(final int i16, final String str2, final int i17) {
                        final QQFlashTransferViewModel qQFlashTransferViewModel3 = QQFlashTransferViewModel.this;
                        SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$cancelDownloadAlertDialog$2$2$onResult$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                KLog kLog = KLog.INSTANCE;
                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("downloadProcessView stopFileListDownLoad result=");
                                m3.append(i16);
                                m3.append(" errMsg=");
                                m3.append(str2);
                                m3.append(" extraInfo=");
                                m3.append((Object) UInt.m615toStringimpl(i17));
                                kLog.d("QQFTDownloadBarView", m3.toString());
                                qQFlashTransferViewModel3.resetDownloadProcess();
                                return Unit.INSTANCE;
                            }
                        });
                    }
                });
                MutableState<Boolean> mutableState = QQFlashTransferViewModel.this.forceShowDownloadBar;
                Boolean bool = Boolean.FALSE;
                mutableState.setValue(bool);
                QQFlashTransferViewModel.this.inProgressAnim.setValue(bool);
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("delete pauseList fileListSize=");
                m3.append(QQFlashTransferViewModel.this.downloadingFileList.size());
                kLog.d("QQFTDownloadBarView", m3.toString());
                QQFlashTransferViewModel.this.downloadingFileList.clear();
                QQFlashTransferViewModel.this.showCancelDownloadAlertDialog.setValue(bool);
                return Unit.INSTANCE;
            }
        })}, null, null, startRestartGroup, 33152, 106);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$cancelDownloadAlertDialog$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTDownloadBarViewKt.cancelDownloadAlertDialog(QQFlashTransferViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void downloadAllFileView(final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-25381581);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-25381581, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadAllFileView (QQFTDownloadBarView.kt:893)");
        }
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("downloadAllFileView bottom");
        m3.append(QQFTUIConfigKt.getAndroidBottomNavBarHeight(startRestartGroup));
        kLog.d("QQFTDownloadBarView", m3.toString());
        BoxKt.a(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1007324743, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$downloadAllFileView$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                int i16;
                b bVar2 = bVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i16 = (composer3.changed(bVar2) ? 4 : 2) | intValue;
                } else {
                    i16 = intValue;
                }
                if ((i16 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1007324743, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadAllFileView.<anonymous> (QQFTDownloadBarView.kt:895)");
                    }
                    i d16 = ViewEventPropUpdaterKt.d(ModifiersKt.f(bVar2.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), QQFTUIConfigKt.getAndroidBottomNavBarHeight(composer3) + 80.0f), QUIToken.color$default("bg_bottom_light")), Alignment.BottomCenter), (float) 0.5d, QUIToken.color$default("overlay_light"), BorderStyle.SOLID), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$downloadAllFileView$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                            return Unit.INSTANCE;
                        }
                    }, 2, null);
                    final QQFlashTransferViewModel qQFlashTransferViewModel2 = QQFlashTransferViewModel.this;
                    BoxKt.a(d16, null, null, ComposableLambdaKt.composableLambda(composer3, -378195009, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$downloadAllFileView$1.2
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar3, Composer composer4, Integer num2) {
                            int i17;
                            b bVar4 = bVar3;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i17 = (composer5.changed(bVar4) ? 4 : 2) | intValue2;
                            } else {
                                i17 = intValue2;
                            }
                            if ((i17 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-378195009, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadAllFileView.<anonymous>.<anonymous> (QQFTDownloadBarView.kt:900)");
                                }
                                i a16 = bVar4.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 80.0f), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), Alignment.TopCenter);
                                Alignment.Vertical f16 = Alignment.INSTANCE.f();
                                final QQFlashTransferViewModel qQFlashTransferViewModel3 = QQFlashTransferViewModel.this;
                                RowKt.a(a16, null, f16, null, null, ComposableLambdaKt.composableLambda(composer5, -659728287, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadAllFileView.1.2.1
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(n nVar, Composer composer6, Integer num3) {
                                        int i18;
                                        n nVar2 = nVar;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 14) == 0) {
                                            i18 = (composer7.changed(nVar2) ? 4 : 2) | intValue3;
                                        } else {
                                            i18 = intValue3;
                                        }
                                        if ((i18 & 91) == 18 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-659728287, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadAllFileView.<anonymous>.<anonymous>.<anonymous> (QQFTDownloadBarView.kt:904)");
                                            }
                                            i r16 = ComposeLayoutPropUpdaterKt.r(ComposeLayoutPropUpdaterKt.f(nVar2.a(i.INSTANCE, 1.0f), 0.0f, 1, null), 16.0f, 8.0f, 16.0f, 8.0f);
                                            final QQFlashTransferViewModel qQFlashTransferViewModel4 = QQFlashTransferViewModel.this;
                                            BoxKt.a(r16, null, null, ComposableLambdaKt.composableLambda(composer7, -1614133913, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadAllFileView.1.2.1.1
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(b bVar5, Composer composer8, Integer num4) {
                                                    int i19;
                                                    String str;
                                                    b bVar6 = bVar5;
                                                    Composer composer9 = composer8;
                                                    int intValue4 = num4.intValue();
                                                    if ((intValue4 & 14) == 0) {
                                                        i19 = (composer9.changed(bVar6) ? 4 : 2) | intValue4;
                                                    } else {
                                                        i19 = intValue4;
                                                    }
                                                    if ((i19 & 91) == 18 && composer9.getSkipping()) {
                                                        composer9.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1614133913, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadAllFileView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTDownloadBarView.kt:905)");
                                                        }
                                                        if (QQFlashTransferViewModel.this.isCompressPage()) {
                                                            str = "\u4e0b\u8f7d\u538b\u7f29\u5305";
                                                        } else {
                                                            if (QQFlashTransferViewModel.this.parentId.getValue().length() > 0) {
                                                                str = "\u4e0b\u8f7d\u6587\u4ef6\u5939";
                                                            } else {
                                                                if (QQFlashTransferViewModel.this.clusterId.length() > 0) {
                                                                    str = "\u4e0b\u8f7d\u5408\u96c6";
                                                                } else {
                                                                    str = "\u4e0b\u8f7d\u6240\u6709\u6587\u4ef6";
                                                                }
                                                            }
                                                        }
                                                        String str2 = str;
                                                        QUIButtonType qUIButtonType = QUIButtonType.PRIMARY;
                                                        bp3.k kVar = new bp3.k(null, Float.valueOf(17.0f), bp3.c.INSTANCE.f(), null, null, null, null, null, null, null, null, null, null, null, 16377, null);
                                                        i a17 = bVar6.a(ModifiersKt.j(ModifiersKt.w(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 48.0f), QUIToken.color$default("button_bg_primary_pressed")), 14.0f), Alignment.TopCenter);
                                                        final QQFlashTransferViewModel qQFlashTransferViewModel5 = QQFlashTransferViewModel.this;
                                                        QUIButtonKt.QUIButton(a17, qUIButtonType, null, str2, kVar, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadAllFileView.1.2.1.1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                List<ab> emptyList;
                                                                KLog kLog2 = KLog.INSTANCE;
                                                                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("downloadAllFileView selectFilesToDownload=");
                                                                m16.append(QQFlashTransferViewModel.this.selectFilesToDownload.size());
                                                                m16.append(TokenParser.SP);
                                                                kLog2.d("QQFTDownloadBarView", m16.toString());
                                                                if (QQFlashTransferViewModel.this.hasShownFirstDownloadTip == null) {
                                                                    StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("downloadAllFileView hasShownFirstDownloadTip=");
                                                                    m17.append(QQFlashTransferViewModel.this.hasShownFirstDownloadTip);
                                                                    kLog2.d("QQFTDownloadBarView", m17.toString());
                                                                    QQFlashTransferViewModel qQFlashTransferViewModel6 = QQFlashTransferViewModel.this;
                                                                    Utils utils = Utils.INSTANCE;
                                                                    CacheModule cacheModule = utils.cacheModule("");
                                                                    QQFlashTransferViewModel.Companion companion = QQFlashTransferViewModel.Companion;
                                                                    int i26 = cacheModule.getInt(companion.getHAS_SHOWN_FIRST_DOWNLOAD_TIP_KEY());
                                                                    if (i26 == null) {
                                                                        i26 = 0;
                                                                    }
                                                                    qQFlashTransferViewModel6.hasShownFirstDownloadTip = i26;
                                                                    Integer num5 = QQFlashTransferViewModel.this.hasShownFirstDownloadTip;
                                                                    if (num5 == null || num5.intValue() != 1) {
                                                                        utils.cacheModule("").setInt(companion.getHAS_SHOWN_FIRST_DOWNLOAD_TIP_KEY(), 1);
                                                                        QQFlashTransferViewModel.this.hasShownFirstDownloadTip = 1;
                                                                        QQFlashTransferViewModel.this.showFirstDownloadTip.setValue(Boolean.TRUE);
                                                                    }
                                                                }
                                                                QQFlashTransferViewModel qQFlashTransferViewModel7 = QQFlashTransferViewModel.this;
                                                                qQFlashTransferViewModel7.roundDownloadingCount.setValue(Long.valueOf(qQFlashTransferViewModel7.m115getCurPageFileTotalCountsVKNKU()));
                                                                QQFlashTransferViewModel qQFlashTransferViewModel8 = QQFlashTransferViewModel.this;
                                                                MutableState<Long> mutableState = qQFlashTransferViewModel8.roundDownloadingSize;
                                                                Long curPageFileTotalSize = qQFlashTransferViewModel8.getCurPageFileTotalSize();
                                                                mutableState.setValue(Long.valueOf(curPageFileTotalSize != null ? curPageFileTotalSize.longValue() : 0L));
                                                                QQFlashTransferViewModel qQFlashTransferViewModel9 = QQFlashTransferViewModel.this;
                                                                String str3 = qQFlashTransferViewModel9.fileSetId;
                                                                emptyList = CollectionsKt__CollectionsKt.emptyList();
                                                                final QQFlashTransferViewModel qQFlashTransferViewModel10 = QQFlashTransferViewModel.this;
                                                                qQFlashTransferViewModel9.startFileListDownLoad(str3, emptyList, new cx() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadAllFileView.1.2.1.1.1.1
                                                                    @Override // ws3.cx
                                                                    /* renamed from: onResult-jXDDuk8 */
                                                                    public final void mo120onResultjXDDuk8(final int i27, final String str4, final int i28) {
                                                                        final QQFlashTransferViewModel qQFlashTransferViewModel11 = QQFlashTransferViewModel.this;
                                                                        SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$downloadAllFileView$1$2$1$1$1$1$onResult$1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(0);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function0
                                                                            public final Unit invoke() {
                                                                                KLog kLog3 = KLog.INSTANCE;
                                                                                StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("downloadAllFileView startFileListDownLoad result=");
                                                                                m18.append(i27);
                                                                                m18.append(" errMsg=");
                                                                                m18.append(str4);
                                                                                m18.append(" extraInfo=");
                                                                                m18.append((Object) UInt.m615toStringimpl(i28));
                                                                                kLog3.d("QQFTDownloadBarView", m18.toString());
                                                                                if (i27 == 0) {
                                                                                    final QQFlashTransferViewModel qQFlashTransferViewModel12 = qQFlashTransferViewModel11;
                                                                                    TimerKt.c(50, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$downloadAllFileView$1$2$1$1$1$1$onResult$1.1
                                                                                        {
                                                                                            super(0);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function0
                                                                                        public final Unit invoke() {
                                                                                            Integer value;
                                                                                            Integer value2;
                                                                                            if (!QQFlashTransferViewModel.this.isDownloadBarShow() && (((value = QQFlashTransferViewModel.this.fileSetDownLoadTaskStatus.getValue()) != null && value.intValue() == 0) || ((value2 = QQFlashTransferViewModel.this.fileSetDownLoadTaskStatus.getValue()) != null && value2.intValue() == 1))) {
                                                                                                QQFlashTransferViewModel.this.forceShowDownloadBar.setValue(Boolean.TRUE);
                                                                                            }
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    });
                                                                                    e eVar = new e();
                                                                                    eVar.v(FlashTransferHelperApiImpl.kFileSetIdKey, qQFlashTransferViewModel11.fileSetId);
                                                                                    k.d((k) c.f117352a.g().acquireModule("KRNotifyModule"), "kQQFTCenterFileSetStatusDidChangeNotification", eVar, false, 4, null);
                                                                                    kLog3.d("QQFTDownloadBarView", "post notify: json:" + eVar);
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                    }
                                                                }, true);
                                                                return Unit.INSTANCE;
                                                            }
                                                        }, null, null, composer9, (bp3.k.f28903n << 12) | 56, 196);
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
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 196616, 26);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3080, 6);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$downloadAllFileView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTDownloadBarViewKt.downloadAllFileView(QQFlashTransferViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void downloadFinishView(final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1740836171);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1740836171, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadFinishView (QQFTDownloadBarView.kt:758)");
        }
        BoxKt.a(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1911059089, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$downloadFinishView$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                int i16;
                b bVar2 = bVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i16 = (composer3.changed(bVar2) ? 4 : 2) | intValue;
                } else {
                    i16 = intValue;
                }
                if ((i16 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1911059089, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadFinishView.<anonymous> (QQFTDownloadBarView.kt:761)");
                    }
                    i d16 = ViewEventPropUpdaterKt.d(ModifiersKt.f(bVar2.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), QQFTUIConfigKt.getAndroidBottomNavBarHeight(composer3) + 110.0f), QUIToken.color$default("bg_middle_light")), Alignment.BottomCenter), (float) 0.5d, QUIToken.color$default("overlay_light"), BorderStyle.SOLID), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$downloadFinishView$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                            return Unit.INSTANCE;
                        }
                    }, 2, null);
                    final QQFlashTransferViewModel qQFlashTransferViewModel2 = QQFlashTransferViewModel.this;
                    BoxKt.a(d16, null, null, ComposableLambdaKt.composableLambda(composer3, 741634729, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$downloadFinishView$1.2
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar3, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(741634729, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadFinishView.<anonymous>.<anonymous> (QQFTDownloadBarView.kt:766)");
                                }
                                i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 90.0f);
                                final QQFlashTransferViewModel qQFlashTransferViewModel3 = QQFlashTransferViewModel.this;
                                final float f16 = 16.0f;
                                final float f17 = 24.0f;
                                BoxKt.a(k3, null, null, ComposableLambdaKt.composableLambda(composer5, 1530217059, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadFinishView.1.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(b bVar4, Composer composer6, Integer num3) {
                                        int i17;
                                        b bVar5 = bVar4;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 14) == 0) {
                                            i17 = (composer7.changed(bVar5) ? 4 : 2) | intValue3;
                                        } else {
                                            i17 = intValue3;
                                        }
                                        if ((i17 & 91) == 18 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1530217059, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadFinishView.<anonymous>.<anonymous>.<anonymous> (QQFTDownloadBarView.kt:767)");
                                            }
                                            a aVar = a.f339245a;
                                            a.k h16 = aVar.h();
                                            Alignment.Companion companion = Alignment.INSTANCE;
                                            Alignment.Horizontal e16 = companion.e();
                                            i.Companion companion2 = i.INSTANCE;
                                            i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.f(bVar5.a(companion2, Alignment.CenterStart), 0.0f, 1, null), f16, 17.0f, 0.0f, 0.0f, 12, null);
                                            final QQFlashTransferViewModel qQFlashTransferViewModel4 = qQFlashTransferViewModel3;
                                            ColumnKt.a(n3, h16, e16, null, ComposableLambdaKt.composableLambda(composer7, 1445756620, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadFinishView.1.2.1.1
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(d dVar, Composer composer8, Integer num4) {
                                                    Composer composer9 = composer8;
                                                    int intValue4 = num4.intValue();
                                                    if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                        composer9.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1445756620, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadFinishView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTDownloadBarView.kt:771)");
                                                        }
                                                        final QQFlashTransferViewModel qQFlashTransferViewModel5 = QQFlashTransferViewModel.this;
                                                        RowKt.a(null, null, null, null, null, ComposableLambdaKt.composableLambda(composer9, -1600715158, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadFinishView.1.2.1.1.1
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(n nVar, Composer composer10, Integer num5) {
                                                                String valueOf;
                                                                String str;
                                                                Composer composer11 = composer10;
                                                                int intValue5 = num5.intValue();
                                                                if ((intValue5 & 81) == 16 && composer11.getSkipping()) {
                                                                    composer11.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-1600715158, intValue5, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadFinishView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTDownloadBarView.kt:772)");
                                                                    }
                                                                    h color$default = QUIToken.color$default("text_primary");
                                                                    c.Companion companion3 = bp3.c.INSTANCE;
                                                                    TextKt.a("\u4e0b\u8f7d\u6210\u529f", null, null, color$default, Float.valueOf(16.0f), null, companion3.e(), null, null, null, null, Float.valueOf(22.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer11, 1601542, 48, 0, 134215590);
                                                                    ca value = QQFlashTransferViewModel.this.fileSetDownLoadInfo.getValue();
                                                                    if (value != null && QQFTDownloadBarViewKt.access$getSaveTime(value) > 1.0f) {
                                                                        TextKt.a(" \u00b7 \u8282\u7701 ", null, null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, companion3.e(), null, null, null, null, Float.valueOf(22.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer11, 1601542, 48, 0, 134215590);
                                                                        float access$getSaveTime = QQFTDownloadBarViewKt.access$getSaveTime(value);
                                                                        if (access$getSaveTime > 3600.0f) {
                                                                            double pow = Math.pow(10.0d, 1);
                                                                            valueOf = String.valueOf(String.valueOf(Math.rint((access$getSaveTime / 3600.0f) * pow) / pow));
                                                                        } else if (access$getSaveTime > 60.0f) {
                                                                            double pow2 = Math.pow(10.0d, 1);
                                                                            valueOf = String.valueOf(String.valueOf(Math.rint((access$getSaveTime / 60.0f) * pow2) / pow2));
                                                                        } else {
                                                                            double pow3 = Math.pow(10.0d, 1);
                                                                            valueOf = String.valueOf(String.valueOf(Math.rint(access$getSaveTime * pow3) / pow3));
                                                                        }
                                                                        TextKt.a(valueOf, null, null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, companion3.a(), null, null, null, null, Float.valueOf(22.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer11, 1601536, 48, 0, 134215590);
                                                                        StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m(TokenParser.SP);
                                                                        float access$getSaveTime2 = QQFTDownloadBarViewKt.access$getSaveTime(value);
                                                                        if (access$getSaveTime2 > 3600.0f) {
                                                                            str = "\u5c0f\u65f6";
                                                                        } else if (access$getSaveTime2 > 60.0f) {
                                                                            str = "\u5206\u949f";
                                                                        } else {
                                                                            str = "\u79d2";
                                                                        }
                                                                        m3.append(str);
                                                                        TextKt.a(m3.toString(), null, null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, companion3.e(), null, null, null, null, Float.valueOf(22.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer11, 1601536, 48, 0, 134215590);
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer9, 196608, 31);
                                                        Alignment.Vertical c16 = Alignment.INSTANCE.c();
                                                        i n16 = ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 0.0f, 6.0f, 0.0f, 0.0f, 13, null);
                                                        final QQFlashTransferViewModel qQFlashTransferViewModel6 = QQFlashTransferViewModel.this;
                                                        RowKt.a(n16, null, c16, null, null, ComposableLambdaKt.composableLambda(composer9, 1953499347, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadFinishView.1.2.1.1.2
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(n nVar, Composer composer10, Integer num5) {
                                                                int i18;
                                                                n nVar2 = nVar;
                                                                Composer composer11 = composer10;
                                                                int intValue5 = num5.intValue();
                                                                if ((intValue5 & 14) == 0) {
                                                                    i18 = (composer11.changed(nVar2) ? 4 : 2) | intValue5;
                                                                } else {
                                                                    i18 = intValue5;
                                                                }
                                                                if ((i18 & 91) == 18 && composer11.getSkipping()) {
                                                                    composer11.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(1953499347, intValue5, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadFinishView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTDownloadBarView.kt:817)");
                                                                    }
                                                                    i.Companion companion3 = i.INSTANCE;
                                                                    ImageKt.a(QUIToken.INSTANCE.image("tick", QUIToken.color$default("feedback_success")), null, null, null, null, ComposeLayoutPropUpdaterKt.n(nVar2.b(ComposeLayoutPropUpdaterKt.u(companion3, 14.0f), Alignment.INSTANCE.c()), 0.0f, 0.0f, 2.0f, 0.0f, 11, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer11, 262144, 0, 0, 2097118);
                                                                    ca value = QQFlashTransferViewModel.this.fileSetDownLoadInfo.getValue();
                                                                    String valueOf = String.valueOf(value != null ? UInt.m564boximpl(value.f446231b) : null);
                                                                    h color$default = QUIToken.color$default("text_primary");
                                                                    c.Companion companion4 = bp3.c.INSTANCE;
                                                                    TextKt.a(valueOf, null, null, color$default, Float.valueOf(12.0f), null, companion4.a(), null, null, null, null, Float.valueOf(17.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer11, 1601536, 48, 0, 134215590);
                                                                    TextKt.a(" \u4e2a\u5df2\u4fdd\u5b58\u81f3", null, null, QUIToken.color$default("text_primary"), Float.valueOf(12.0f), null, companion4.e(), null, null, null, null, Float.valueOf(17.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer11, 1601542, 48, 0, 134215590);
                                                                    TextKt.a(" \u6211\u7684\u6587\u4ef6 ", ViewEventPropUpdaterKt.d(companion3, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadFinishView.1.2.1.1.2.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            String str;
                                                                            KLog.INSTANCE.d("QQFTDownloadBarView", "jumpToNativeMyFile");
                                                                            if (defpackage.k.a(com.tencent.kuikly.core.manager.c.f117352a)) {
                                                                                str = "mqqapi://qqfile?page_from=3";
                                                                            } else {
                                                                                str = "mqqapi://qqfile/openmyfile?page_from=3";
                                                                            }
                                                                            MqqUi.openUrl$default(Mqq.INSTANCE.getUi(), str);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }, 3, null), null, QUIToken.color$default("text_link"), Float.valueOf(12.0f), null, companion4.f(), null, null, null, null, Float.valueOf(17.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer11, 1601606, 48, 0, 134215588);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer9, 196616, 26);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer7, 24648, 8);
                                            a.e b16 = aVar.b();
                                            Alignment.Horizontal d17 = companion.d();
                                            i u16 = ComposeLayoutPropUpdaterKt.u(bVar5.a(companion2, Alignment.CenterEnd), 56.0f);
                                            final QQFlashTransferViewModel qQFlashTransferViewModel5 = qQFlashTransferViewModel3;
                                            i d18 = ViewEventPropUpdaterKt.d(u16, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadFinishView.1.2.1.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    String str;
                                                    AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0.m((k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule"), "kQQFTDownloadFinishBarCloseNotify", false, 4, null);
                                                    QQFlashTransferViewModel.this.showFinishDownloadBar.setValue(Boolean.FALSE);
                                                    IKernelFlashTransferService a16 = IKernelFlashTransferService.f344757i.a();
                                                    br value = QQFlashTransferViewModel.this.fileSet.getValue();
                                                    if (value == null || (str = value.f446187a) == null) {
                                                        str = "";
                                                    }
                                                    y yVar = new y();
                                                    yVar.f446405a = Boolean.TRUE;
                                                    Unit unit = Unit.INSTANCE;
                                                    final QQFlashTransferViewModel qQFlashTransferViewModel6 = QQFlashTransferViewModel.this;
                                                    a16.o(str, yVar, new cx() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadFinishView.1.2.1.2.2
                                                        @Override // ws3.cx
                                                        /* renamed from: onResult-jXDDuk8 */
                                                        public final void mo120onResultjXDDuk8(final int i18, final String str2, final int i19) {
                                                            final QQFlashTransferViewModel qQFlashTransferViewModel7 = QQFlashTransferViewModel.this;
                                                            SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$downloadFinishView$1$2$1$2$2$onResult$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(0);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function0
                                                                public final Unit invoke() {
                                                                    KLog kLog = KLog.INSTANCE;
                                                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("downloadProcessView stopFileListDownLoad result=");
                                                                    m3.append(i18);
                                                                    m3.append(" errMsg=");
                                                                    m3.append(str2);
                                                                    m3.append(" extraInfo=");
                                                                    m3.append((Object) UInt.m615toStringimpl(i19));
                                                                    kLog.d("QQFTDownloadBarView", m3.toString());
                                                                    qQFlashTransferViewModel7.resetDownloadProcess();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            }, 3, null);
                                            final float f18 = f17;
                                            ColumnKt.a(d18, b16, d17, null, ComposableLambdaKt.composableLambda(composer7, 107130101, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadFinishView.1.2.1.3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(d dVar, Composer composer8, Integer num4) {
                                                    Composer composer9 = composer8;
                                                    int intValue4 = num4.intValue();
                                                    if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                        composer9.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(107130101, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadFinishView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTDownloadBarView.kt:879)");
                                                        }
                                                        i h17 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                                                        final float f19 = f18;
                                                        BoxKt.a(h17, null, null, ComposableLambdaKt.composableLambda(composer9, -1985685585, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadFinishView.1.2.1.3.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(b bVar6, Composer composer10, Integer num5) {
                                                                int i18;
                                                                b bVar7 = bVar6;
                                                                Composer composer11 = composer10;
                                                                int intValue5 = num5.intValue();
                                                                if ((intValue5 & 14) == 0) {
                                                                    i18 = (composer11.changed(bVar7) ? 4 : 2) | intValue5;
                                                                } else {
                                                                    i18 = intValue5;
                                                                }
                                                                if ((i18 & 91) == 18 && composer11.getSkipping()) {
                                                                    composer11.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-1985685585, intValue5, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadFinishView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTDownloadBarView.kt:880)");
                                                                    }
                                                                    ImageKt.a(QUIToken.INSTANCE.image("close", QUIToken.color$default("icon_nav_secondary")), null, null, null, null, ModifiersKt.A(bVar7.a(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, f19), Alignment.Center), 0.5f, 0.0f, 2, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer11, 262144, 0, 0, 2097118);
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
                                            }), composer7, 24648, 8);
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
                    }), composer3, 3080, 6);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$downloadFinishView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTDownloadBarViewKt.downloadFinishView(QQFlashTransferViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void downloadProcessView(final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-388812315);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-388812315, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadProcessView (QQFTDownloadBarView.kt:282)");
        }
        BoxKt.a(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1370755477, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$downloadProcessView$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                int i16;
                String str;
                b bVar2 = bVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i16 = (composer3.changed(bVar2) ? 4 : 2) | intValue;
                } else {
                    i16 = intValue;
                }
                if ((i16 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1370755477, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadProcessView.<anonymous> (QQFTDownloadBarView.kt:286)");
                    }
                    i f16 = ModifiersKt.f(bVar2.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), QQFTUIConfigKt.getAndroidBottomNavBarHeight(composer3) + 115.0f), QUIToken.color$default("bg_middle_light")), Alignment.BottomCenter), (float) 0.5d, QUIToken.color$default("overlay_light"), BorderStyle.SOLID);
                    if (defpackage.k.a(com.tencent.kuikly.core.manager.c.f117352a)) {
                        str = "0S200MNJT807V3GE";
                    } else {
                        str = "0M2003OIIM08YV9M";
                    }
                    e dTBaseParams = DTReportConstKt.getDTBaseParams(str);
                    dTBaseParams.v("current_state", String.valueOf(QQFlashTransferViewModel.this.fileSetDownLoadTaskStatus.getValue()));
                    Unit unit = Unit.INSTANCE;
                    i d16 = ViewEventPropUpdaterKt.d(ModifierExtKt.elementVR(f16, "em_bas_download_progress_ba", dTBaseParams), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$downloadProcessView$1.2
                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                            return Unit.INSTANCE;
                        }
                    }, 2, null);
                    final QQFlashTransferViewModel qQFlashTransferViewModel2 = QQFlashTransferViewModel.this;
                    ColumnKt.a(d16, null, null, null, ComposableLambdaKt.composableLambda(composer3, 1263984546, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$downloadProcessView$1.3
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1263984546, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadProcessView.<anonymous>.<anonymous> (QQFTDownloadBarView.kt:296)");
                                }
                                i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 60.0f), 0.0f, 12.0f, 0.0f, 0.0f, 13, null);
                                final QQFlashTransferViewModel qQFlashTransferViewModel3 = QQFlashTransferViewModel.this;
                                final float f17 = 16.0f;
                                final float f18 = 24.0f;
                                ColumnKt.a(n3, null, null, null, ComposableLambdaKt.composableLambda(composer5, -266898599, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadProcessView.1.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(d dVar2, Composer composer6, Integer num3) {
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-266898599, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadProcessView.<anonymous>.<anonymous>.<anonymous> (QQFTDownloadBarView.kt:297)");
                                            }
                                            i.Companion companion = i.INSTANCE;
                                            i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 50.0f);
                                            final float f19 = f17;
                                            final QQFlashTransferViewModel qQFlashTransferViewModel4 = qQFlashTransferViewModel3;
                                            final float f26 = f18;
                                            final float f27 = f18;
                                            BoxKt.a(k3, null, null, ComposableLambdaKt.composableLambda(composer7, -783612065, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadProcessView.1.3.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(b bVar3, Composer composer8, Integer num4) {
                                                    int i17;
                                                    b bVar4 = bVar3;
                                                    Composer composer9 = composer8;
                                                    int intValue4 = num4.intValue();
                                                    if ((intValue4 & 14) == 0) {
                                                        i17 = (composer9.changed(bVar4) ? 4 : 2) | intValue4;
                                                    } else {
                                                        i17 = intValue4;
                                                    }
                                                    if ((i17 & 91) == 18 && composer9.getSkipping()) {
                                                        composer9.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-783612065, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadProcessView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTDownloadBarView.kt:298)");
                                                        }
                                                        a aVar = a.f339245a;
                                                        a.e b16 = aVar.b();
                                                        Alignment.Companion companion2 = Alignment.INSTANCE;
                                                        Alignment.Horizontal e16 = companion2.e();
                                                        i.Companion companion3 = i.INSTANCE;
                                                        i f28 = ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.B(ComposeLayoutPropUpdaterKt.n(bVar4.a(companion3, Alignment.CenterStart), f19, 0.0f, 0.0f, 0.0f, 14, null)), 0.0f, 1, null);
                                                        final QQFlashTransferViewModel qQFlashTransferViewModel5 = qQFlashTransferViewModel4;
                                                        ColumnKt.a(f28, b16, e16, null, ComposableLambdaKt.composableLambda(composer9, 724350294, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadProcessView.1.3.1.1.1
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(d dVar3, Composer composer10, Integer num5) {
                                                                int i18;
                                                                d dVar4 = dVar3;
                                                                Composer composer11 = composer10;
                                                                int intValue5 = num5.intValue();
                                                                if ((intValue5 & 14) == 0) {
                                                                    i18 = (composer11.changed(dVar4) ? 4 : 2) | intValue5;
                                                                } else {
                                                                    i18 = intValue5;
                                                                }
                                                                if ((i18 & 91) == 18 && composer11.getSkipping()) {
                                                                    composer11.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(724350294, intValue5, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadProcessView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTDownloadBarView.kt:305)");
                                                                    }
                                                                    i.Companion companion4 = i.INSTANCE;
                                                                    i z16 = ComposeLayoutPropUpdaterKt.z(companion4);
                                                                    Alignment.Companion companion5 = Alignment.INSTANCE;
                                                                    i b17 = dVar4.b(z16, companion5.e());
                                                                    a aVar2 = a.f339245a;
                                                                    a.d g16 = aVar2.g();
                                                                    Alignment.Vertical f29 = companion5.f();
                                                                    final QQFlashTransferViewModel qQFlashTransferViewModel6 = QQFlashTransferViewModel.this;
                                                                    RowKt.a(b17, g16, f29, null, null, ComposableLambdaKt.composableLambda(composer11, -1927720200, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadProcessView.1.3.1.1.1.1
                                                                        {
                                                                            super(3);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function3
                                                                        public final Unit invoke(n nVar, Composer composer12, Integer num6) {
                                                                            String str2;
                                                                            String valueOf;
                                                                            Composer composer13 = composer12;
                                                                            int intValue6 = num6.intValue();
                                                                            if ((intValue6 & 81) == 16 && composer13.getSkipping()) {
                                                                                composer13.skipToGroupEnd();
                                                                            } else {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(-1927720200, intValue6, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadProcessView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTDownloadBarView.kt:312)");
                                                                                }
                                                                                if (QQFlashTransferViewModel.this.isPrepareDownload()) {
                                                                                    composer13.startReplaceableGroup(-915222513);
                                                                                    h color$default = QUIToken.color$default("text_primary");
                                                                                    c.Companion companion6 = bp3.c.INSTANCE;
                                                                                    TextKt.a("\u7b49\u5f85\u4e0b\u8f7d\u4e2d ", null, null, color$default, Float.valueOf(16.0f), null, companion6.e(), null, null, null, null, Float.valueOf(22.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer13, 1601542, 48, 0, 134215590);
                                                                                    TextKt.a(String.valueOf(Math.max(QQFlashTransferViewModel.this.fileSetDownLoadInfo.getValue() != null ? r1.f446232c & 4294967295L : 0L, QQFlashTransferViewModel.this.roundDownloadingCount.getValue().longValue())), null, null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, companion6.a(), null, null, null, null, Float.valueOf(22.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer13, 1601536, 48, 0, 134215590);
                                                                                    TextKt.a(" \u9879 \u00b7 ", null, null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, companion6.e(), null, null, null, null, Float.valueOf(22.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer13, 1601542, 48, 0, 134215590);
                                                                                    QQFTDownloadBarViewKt.access$totalDownloadFileSizeUI(QQFlashTransferViewModel.this, composer13, 8);
                                                                                    composer13.endReplaceableGroup();
                                                                                } else {
                                                                                    composer13.startReplaceableGroup(-915221155);
                                                                                    if (!QQFlashTransferViewModel.this.isDownloadPause.getValue().booleanValue() && !QQFlashTransferViewModel.this.deviceStateProcessInfo.isDownloadPause.getValue().booleanValue()) {
                                                                                        str2 = "\u4e0b\u8f7d\u4e2d ";
                                                                                    } else {
                                                                                        str2 = "\u5df2\u6682\u505c ";
                                                                                    }
                                                                                    h color$default2 = QUIToken.color$default("text_primary");
                                                                                    c.Companion companion7 = bp3.c.INSTANCE;
                                                                                    TextKt.a(str2, null, null, color$default2, Float.valueOf(16.0f), null, companion7.e(), null, null, null, null, Float.valueOf(22.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer13, 1601536, 48, 0, 134215590);
                                                                                    if (QQFlashTransferViewModel.this.isDownloadPause.getValue().booleanValue()) {
                                                                                        ca value = QQFlashTransferViewModel.this.fileSetDownLoadInfo.getValue();
                                                                                        valueOf = String.valueOf(value != null ? UInt.m564boximpl(value.f446232c) : null);
                                                                                    } else {
                                                                                        valueOf = String.valueOf(Math.max(QQFlashTransferViewModel.this.fileSetDownLoadInfo.getValue() != null ? r1.f446232c & 4294967295L : 0L, QQFlashTransferViewModel.this.roundDownloadingCount.getValue().longValue()));
                                                                                    }
                                                                                    TextKt.a(valueOf, null, null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, companion7.a(), null, null, null, null, Float.valueOf(22.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer13, 1601536, 48, 0, 134215590);
                                                                                    TextKt.a(" \u4e2a \u00b7 ", null, null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, companion7.e(), null, null, null, null, Float.valueOf(22.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer13, 1601542, 48, 0, 134215590);
                                                                                    QQFTDownloadBarViewKt.access$downloadedFileSizeUI(QQFlashTransferViewModel.this, composer13, 8);
                                                                                    QQFTDownloadBarViewKt.access$totalDownloadFileSizeUI(QQFlashTransferViewModel.this, composer13, 8);
                                                                                    composer13.endReplaceableGroup();
                                                                                }
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }), composer11, 196680, 24);
                                                                    if (QQFlashTransferViewModel.this.deviceStateProcessInfo.isDownloadPause.getValue().booleanValue() || ((!QQFlashTransferViewModel.this.isPrepareDownload() && !QQFlashTransferViewModel.this.isDownloadPause.getValue().booleanValue()) || QQFlashTransferViewModel.this.deviceStateProcessInfo.isSwitchToXgAndNoticeChanged.getValue().booleanValue())) {
                                                                        if (!QQFlashTransferViewModel.this.deviceStateProcessInfo.isDownloadPause.getValue().booleanValue() && !QQFlashTransferViewModel.this.deviceStateProcessInfo.isSwitchToXgAndNoticeChanged.getValue().booleanValue()) {
                                                                            composer11.startReplaceableGroup(-464471318);
                                                                            i n16 = ComposeLayoutPropUpdaterKt.n(dVar4.b(ComposeLayoutPropUpdaterKt.B(companion4), companion5.e()), 0.0f, 4.0f, 0.0f, 0.0f, 13, null);
                                                                            a.d g17 = aVar2.g();
                                                                            Alignment.Vertical a16 = companion5.a();
                                                                            final QQFlashTransferViewModel qQFlashTransferViewModel7 = QQFlashTransferViewModel.this;
                                                                            RowKt.a(n16, g17, a16, null, null, ComposableLambdaKt.composableLambda(composer11, 1855046839, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadProcessView.1.3.1.1.1.2
                                                                                {
                                                                                    super(3);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function3
                                                                                public final Unit invoke(n nVar, Composer composer12, Integer num6) {
                                                                                    Composer composer13;
                                                                                    String str2;
                                                                                    Integer value;
                                                                                    int compare;
                                                                                    String sb5;
                                                                                    Composer composer14 = composer12;
                                                                                    int intValue6 = num6.intValue();
                                                                                    if ((intValue6 & 81) == 16 && composer14.getSkipping()) {
                                                                                        composer14.skipToGroupEnd();
                                                                                    } else {
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventStart(1855046839, intValue6, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadProcessView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTDownloadBarView.kt:395)");
                                                                                        }
                                                                                        final QQFlashTransferViewModel qQFlashTransferViewModel8 = QQFlashTransferViewModel.this;
                                                                                        BoxKt.a(null, null, null, ComposableLambdaKt.composableLambda(composer14, 1841723197, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadProcessView.1.3.1.1.1.2.1
                                                                                            {
                                                                                                super(3);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function3
                                                                                            public final Unit invoke(b bVar5, Composer composer15, Integer num7) {
                                                                                                String str3;
                                                                                                Composer composer16 = composer15;
                                                                                                int intValue7 = num7.intValue();
                                                                                                if ((intValue7 & 81) == 16 && composer16.getSkipping()) {
                                                                                                    composer16.skipToGroupEnd();
                                                                                                } else {
                                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                                        ComposerKt.traceEventStart(1841723197, intValue7, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadProcessView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTDownloadBarView.kt:396)");
                                                                                                    }
                                                                                                    ca value2 = QQFlashTransferViewModel.this.fileSetDownLoadInfo.getValue();
                                                                                                    if (value2 != null) {
                                                                                                        StringBuilder sb6 = new StringBuilder();
                                                                                                        l lVar = l.f413536a;
                                                                                                        String str4 = "0.0";
                                                                                                        if (lVar.g(value2.f446235f).length() > 0) {
                                                                                                            if (Float.parseFloat(lVar.g(value2.f446235f)) >= 100.0f) {
                                                                                                                str4 = "000.0";
                                                                                                            } else if (Float.parseFloat(lVar.g(value2.f446235f)) >= 10.0f) {
                                                                                                                str4 = "00.0";
                                                                                                            }
                                                                                                        }
                                                                                                        sb6.append(str4);
                                                                                                        sb6.append(lVar.f(value2.f446235f));
                                                                                                        str3 = sb6.toString();
                                                                                                    } else {
                                                                                                        str3 = null;
                                                                                                    }
                                                                                                    h color$default = QUIToken.color$default("text_primary");
                                                                                                    c.Companion companion6 = bp3.c.INSTANCE;
                                                                                                    TextKt.a(str3, ModifiersKt.R(i.INSTANCE, false), null, color$default, Float.valueOf(12.0f), null, companion6.a(), null, null, null, null, Float.valueOf(17.0f), null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer16, 1601600, 100663344, 0, 133953444);
                                                                                                    ca value3 = QQFlashTransferViewModel.this.fileSetDownLoadInfo.getValue();
                                                                                                    TextKt.a(value3 != null ? l.f413536a.e(value3.f446235f) : null, null, null, QUIToken.color$default("text_primary"), Float.valueOf(12.0f), null, companion6.a(), null, null, null, null, Float.valueOf(17.0f), null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer16, 1601536, 100663344, 0, 133953446);
                                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                                        ComposerKt.traceEventEnd();
                                                                                                    }
                                                                                                }
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        }), composer14, 3072, 7);
                                                                                        composer14.startReplaceableGroup(-915215396);
                                                                                        if (QQFlashTransferViewModel.this.isAutoSpeedUp.getValue().booleanValue()) {
                                                                                            composer13 = composer14;
                                                                                            TextKt.a(" \u667a\u80fd\u63d0\u901f\u4e2d", null, null, QUIToken.color$default("text_link"), Float.valueOf(12.0f), null, bp3.c.INSTANCE.f(), null, null, null, null, Float.valueOf(17.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer13, 1601542, 48, 0, 134215590);
                                                                                        } else {
                                                                                            composer13 = composer14;
                                                                                        }
                                                                                        composer13.endReplaceableGroup();
                                                                                        Composer composer15 = composer13;
                                                                                        composer15.startReplaceableGroup(-915214856);
                                                                                        if (QQFlashTransferViewModel.this.isAutoSpeedUp.getValue().booleanValue()) {
                                                                                            QQAnimatedImageKt.QQAnimatedImage("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_dwVKbTulPBS.png", ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 16.0f), true, 0, composer15, 3526, 0);
                                                                                        }
                                                                                        composer15.endReplaceableGroup();
                                                                                        ca value2 = QQFlashTransferViewModel.this.fileSetDownLoadInfo.getValue();
                                                                                        if (value2 != null) {
                                                                                            QQFlashTransferViewModel qQFlashTransferViewModel9 = QQFlashTransferViewModel.this;
                                                                                            if (value2.f446235f > 0 && ((value = qQFlashTransferViewModel9.fileSetDownLoadTaskStatus.getValue()) == null || value.intValue() != 4)) {
                                                                                                compare = Integer.compare(value2.f446237h ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE);
                                                                                                if (compare > 0) {
                                                                                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m(" \u00b7 \u9884\u8ba1");
                                                                                                    long j3 = value2.f446237h & 4294967295L;
                                                                                                    if (j3 > 3600) {
                                                                                                        sb5 = ((j3 + 3559) / 3600) + "\u5c0f\u65f6";
                                                                                                    } else if (j3 > 60) {
                                                                                                        sb5 = ((j3 + 59) / 60) + "\u5206\u949f";
                                                                                                    } else {
                                                                                                        StringBuilder sb6 = new StringBuilder();
                                                                                                        sb6.append(j3);
                                                                                                        sb6.append('\u79d2');
                                                                                                        sb5 = sb6.toString();
                                                                                                    }
                                                                                                    m3.append(sb5);
                                                                                                    str2 = m3.toString();
                                                                                                }
                                                                                            }
                                                                                            str2 = " ";
                                                                                        } else {
                                                                                            str2 = null;
                                                                                        }
                                                                                        TextKt.a(str2, null, null, QUIToken.color$default("text_secondary"), Float.valueOf(12.0f), null, bp3.c.INSTANCE.e(), null, null, null, null, Float.valueOf(17.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer15, 1601536, 48, 0, 134215590);
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventEnd();
                                                                                        }
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            }), composer11, 196680, 24);
                                                                            composer11.endReplaceableGroup();
                                                                        } else {
                                                                            composer11.startReplaceableGroup(-464472011);
                                                                            TextKt.a(QQFlashTransferViewModel.this.deviceStateProcessInfo.notice, null, null, QUIToken.color$default("text_link"), Float.valueOf(12.0f), null, bp3.c.INSTANCE.f(), null, null, null, null, Float.valueOf(17.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer11, 1601536, 48, 0, 134215590);
                                                                            if (QQFlashTransferViewModel.this.deviceStateProcessInfo.isSwitchToXgAndNoticeChanged.getValue().booleanValue()) {
                                                                                QQFlashTransferViewModel.this.deviceStateProcessInfo.isSwitchToXgAndNoticeChanged.setValue(Boolean.FALSE);
                                                                            }
                                                                            composer11.endReplaceableGroup();
                                                                        }
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer9, 24648, 8);
                                                        a.d c16 = aVar.c();
                                                        Alignment.Vertical c17 = companion2.c();
                                                        i d17 = ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.f(bVar4.a(ComposeLayoutPropUpdaterKt.B(companion3), Alignment.CenterEnd), 0.0f, 1, null), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadProcessView.1.3.1.1.2
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                                                return Unit.INSTANCE;
                                                            }
                                                        }, 3, null);
                                                        final float f29 = f26;
                                                        final float f36 = f27;
                                                        final QQFlashTransferViewModel qQFlashTransferViewModel6 = qQFlashTransferViewModel4;
                                                        RowKt.a(d17, c16, c17, null, null, ComposableLambdaKt.composableLambda(composer9, -1220259327, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadProcessView.1.3.1.1.3
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(n nVar, Composer composer10, Integer num5) {
                                                                String str2;
                                                                String str3;
                                                                Composer composer11 = composer10;
                                                                int intValue5 = num5.intValue();
                                                                if ((intValue5 & 81) == 16 && composer11.getSkipping()) {
                                                                    composer11.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-1220259327, intValue5, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadProcessView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTDownloadBarView.kt:479)");
                                                                    }
                                                                    i.Companion companion4 = i.INSTANCE;
                                                                    i w3 = ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.f(companion4, 0.0f, 1, null), f29 + f36);
                                                                    com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                                                                    String str4 = "0S200MNJT807V3GE";
                                                                    if (defpackage.k.a(cVar)) {
                                                                        str2 = "0S200MNJT807V3GE";
                                                                    } else {
                                                                        str2 = "0M2003OIIM08YV9M";
                                                                    }
                                                                    e dTBaseParams2 = DTReportConstKt.getDTBaseParams(str2);
                                                                    if (qQFlashTransferViewModel6.isDownloadPause.getValue().booleanValue()) {
                                                                        str3 = "2";
                                                                    } else {
                                                                        str3 = "1";
                                                                    }
                                                                    dTBaseParams2.v("click_effect", str3);
                                                                    Unit unit2 = Unit.INSTANCE;
                                                                    i elementVR = ModifierExtKt.elementVR(w3, "em_bas_download_pause", dTBaseParams2);
                                                                    final QQFlashTransferViewModel qQFlashTransferViewModel7 = qQFlashTransferViewModel6;
                                                                    i A = ModifiersKt.A(ViewEventPropUpdaterKt.d(elementVR, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadProcessView.1.3.1.1.3.2
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            String str5;
                                                                            String str6;
                                                                            Integer value = QQFlashTransferViewModel.this.fileSetDownLoadTaskStatus.getValue();
                                                                            if (value != null && value.intValue() == 2) {
                                                                                KLog.INSTANCE.d("QQFTDownloadBarView", "task is finish.cannot pause.");
                                                                            } else {
                                                                                QQFlashTransferViewModel.this.isDownloadPause.setValue(Boolean.valueOf(!r9.getValue().booleanValue()));
                                                                                String str7 = "";
                                                                                if (QQFlashTransferViewModel.this.isDownloadPause.getValue().booleanValue()) {
                                                                                    IKernelFlashTransferService a16 = IKernelFlashTransferService.f344757i.a();
                                                                                    br value2 = QQFlashTransferViewModel.this.fileSet.getValue();
                                                                                    if (value2 != null && (str6 = value2.f446187a) != null) {
                                                                                        str7 = str6;
                                                                                    }
                                                                                    Boolean bool = Boolean.TRUE;
                                                                                    Unit unit3 = Unit.INSTANCE;
                                                                                    final QQFlashTransferViewModel qQFlashTransferViewModel8 = QQFlashTransferViewModel.this;
                                                                                    final cx cxVar = new cx() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadProcessView.1.3.1.1.3.2.2
                                                                                        @Override // ws3.cx
                                                                                        /* renamed from: onResult-jXDDuk8 */
                                                                                        public final void mo120onResultjXDDuk8(final int i18, final String str8, final int i19) {
                                                                                            final QQFlashTransferViewModel qQFlashTransferViewModel9 = QQFlashTransferViewModel.this;
                                                                                            SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$downloadProcessView$1$3$1$1$3$2$2$onResult$1
                                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                {
                                                                                                    super(0);
                                                                                                }

                                                                                                @Override // kotlin.jvm.functions.Function0
                                                                                                public final Unit invoke() {
                                                                                                    if (i18 == 0) {
                                                                                                        QQFTTransferSizeInterpolation qQFTTransferSizeInterpolation = qQFlashTransferViewModel9.curDownLoadedBytesInterpolation;
                                                                                                        Timer timer = qQFTTransferSizeInterpolation.downloadSpeedTimer;
                                                                                                        if (timer != null) {
                                                                                                            timer.stopTimer();
                                                                                                        }
                                                                                                        qQFTTransferSizeInterpolation.curValue.setValue(Long.valueOf(qQFTTransferSizeInterpolation.nextValue));
                                                                                                        qQFTTransferSizeInterpolation.expertCostTime = 500L;
                                                                                                        qQFTTransferSizeInterpolation.startTimerTimestamp = 0L;
                                                                                                        KLog.INSTANCE.d("QQFTTransferSizeInterpolation", "pause...");
                                                                                                    }
                                                                                                    KLog kLog = KLog.INSTANCE;
                                                                                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("downloadProcessView pauseFileSetDownload result=");
                                                                                                    m3.append(i18);
                                                                                                    m3.append(" errMsg=");
                                                                                                    m3.append(str8);
                                                                                                    m3.append(" extraInfo=");
                                                                                                    m3.append((Object) UInt.m615toStringimpl(i19));
                                                                                                    kLog.d("QQFTDownloadBarView", m3.toString());
                                                                                                    return Unit.INSTANCE;
                                                                                                }
                                                                                            });
                                                                                        }
                                                                                    };
                                                                                    a16.getClass();
                                                                                    ArrayList arrayList = new ArrayList();
                                                                                    arrayList.add(str7);
                                                                                    ArrayList m3 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m("isIncludeCompressInnerFiles");
                                                                                    if (bool != null) {
                                                                                        Intrinsics.checkNotNull(bool);
                                                                                        m3.add(1);
                                                                                    } else {
                                                                                        m3.add(new byte[0]);
                                                                                    }
                                                                                    m3.add("compressFolderOptionParamsFolderId");
                                                                                    m3.add(new byte[0]);
                                                                                    Object[] array = m3.toArray(new Object[0]);
                                                                                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                                                                    arrayList.add(Integer.valueOf(array.length));
                                                                                    CollectionsKt__MutableCollectionsKt.addAll(arrayList, array);
                                                                                    arrayList.add(String.valueOf(cxVar.hashCode()));
                                                                                    Function1<Object, Unit> function1 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$pauseFileSetDownload$kernelCallback$1
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
                                                                                                        int intValue6 = ((Integer) next).intValue();
                                                                                                        Object next2 = it.next();
                                                                                                        Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
                                                                                                        Object next3 = it.next();
                                                                                                        Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
                                                                                                        cx.this.mo120onResultjXDDuk8(intValue6, (String) next2, vs3.a.a((String) next3));
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    };
                                                                                    Object[] array2 = arrayList.toArray(new Object[0]);
                                                                                    Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                                                                    a16.syncToNativeMethod(true, "pauseFileSetDownload", array2, function1);
                                                                                } else {
                                                                                    IKernelFlashTransferService a17 = IKernelFlashTransferService.f344757i.a();
                                                                                    br value3 = QQFlashTransferViewModel.this.fileSet.getValue();
                                                                                    if (value3 != null && (str5 = value3.f446187a) != null) {
                                                                                        str7 = str5;
                                                                                    }
                                                                                    y yVar = new y();
                                                                                    yVar.f446405a = Boolean.TRUE;
                                                                                    Unit unit4 = Unit.INSTANCE;
                                                                                    a17.m(str7, yVar, new cx() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadProcessView.1.3.1.1.3.2.4
                                                                                        @Override // ws3.cx
                                                                                        /* renamed from: onResult-jXDDuk8 */
                                                                                        public final void mo120onResultjXDDuk8(final int i18, final String str8, final int i19) {
                                                                                            SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$downloadProcessView$1$3$1$1$3$2$4$onResult$1
                                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                {
                                                                                                    super(0);
                                                                                                }

                                                                                                @Override // kotlin.jvm.functions.Function0
                                                                                                public final Unit invoke() {
                                                                                                    KLog kLog = KLog.INSTANCE;
                                                                                                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("downloadProcessView resumeFileSetDownload result=");
                                                                                                    m16.append(i18);
                                                                                                    m16.append(" errMsg=");
                                                                                                    m16.append(str8);
                                                                                                    m16.append(" extraInfo=");
                                                                                                    m16.append((Object) UInt.m615toStringimpl(i19));
                                                                                                    kLog.d("QQFTDownloadBarView", m16.toString());
                                                                                                    return Unit.INSTANCE;
                                                                                                }
                                                                                            });
                                                                                        }
                                                                                    });
                                                                                }
                                                                                KLog kLog = KLog.INSTANCE;
                                                                                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("downloadProcessView isDownloadPause=");
                                                                                m16.append(QQFlashTransferViewModel.this.isDownloadPause.getValue().booleanValue());
                                                                                m16.append(" downloadingFileList.size=");
                                                                                m16.append(QQFlashTransferViewModel.this.downloadingFileList.size());
                                                                                kLog.d("QQFTDownloadBarView", m16.toString());
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }, 3, null), 0.5f, 0.0f, 2, null);
                                                                    final float f37 = f29;
                                                                    final QQFlashTransferViewModel qQFlashTransferViewModel8 = qQFlashTransferViewModel6;
                                                                    BoxKt.a(A, null, null, ComposableLambdaKt.composableLambda(composer11, -109702905, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadProcessView.1.3.1.1.3.3
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(3);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function3
                                                                        public final Unit invoke(b bVar5, Composer composer12, Integer num6) {
                                                                            int i18;
                                                                            String str5;
                                                                            b bVar6 = bVar5;
                                                                            Composer composer13 = composer12;
                                                                            int intValue6 = num6.intValue();
                                                                            if ((intValue6 & 14) == 0) {
                                                                                i18 = (composer13.changed(bVar6) ? 4 : 2) | intValue6;
                                                                            } else {
                                                                                i18 = intValue6;
                                                                            }
                                                                            if ((i18 & 91) == 18 && composer13.getSkipping()) {
                                                                                composer13.skipToGroupEnd();
                                                                            } else {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(-109702905, intValue6, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadProcessView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTDownloadBarView.kt:545)");
                                                                                }
                                                                                i a16 = bVar6.a(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, f37), Alignment.Center);
                                                                                QUIToken qUIToken = QUIToken.INSTANCE;
                                                                                if (qQFlashTransferViewModel8.isDownloadPause.getValue().booleanValue()) {
                                                                                    str5 = "play";
                                                                                } else {
                                                                                    str5 = "pause";
                                                                                }
                                                                                ImageKt.a(qUIToken.image(str5, QUIToken.color$default("icon_nav_secondary")), null, null, null, null, a16, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer13, 262144, 0, 0, 2097118);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }), composer11, 3080, 6);
                                                                    i w16 = ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.f(companion4, 0.0f, 1, null), f29 + f36);
                                                                    if (!defpackage.k.a(cVar)) {
                                                                        str4 = "0M2003OIIM08YV9M";
                                                                    }
                                                                    i elementVR2 = ModifierExtKt.elementVR(w16, "em_bas_download_delete", DTReportConstKt.getDTBaseParams(str4));
                                                                    final QQFlashTransferViewModel qQFlashTransferViewModel9 = qQFlashTransferViewModel6;
                                                                    i A2 = ModifiersKt.A(ViewEventPropUpdaterKt.d(elementVR2, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadProcessView.1.3.1.1.3.4
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            QQFlashTransferViewModel.this.showCancelDownloadAlertDialog.setValue(Boolean.TRUE);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }, 3, null), 0.5f, 0.0f, 2, null);
                                                                    final float f38 = f29;
                                                                    BoxKt.a(A2, null, null, ComposableLambdaKt.composableLambda(composer11, 1460720958, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadProcessView.1.3.1.1.3.5
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(3);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function3
                                                                        public final Unit invoke(b bVar5, Composer composer12, Integer num6) {
                                                                            int i18;
                                                                            b bVar6 = bVar5;
                                                                            Composer composer13 = composer12;
                                                                            int intValue6 = num6.intValue();
                                                                            if ((intValue6 & 14) == 0) {
                                                                                i18 = (composer13.changed(bVar6) ? 4 : 2) | intValue6;
                                                                            } else {
                                                                                i18 = intValue6;
                                                                            }
                                                                            if ((i18 & 91) == 18 && composer13.getSkipping()) {
                                                                                composer13.skipToGroupEnd();
                                                                            } else {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(1460720958, intValue6, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadProcessView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTDownloadBarView.kt:561)");
                                                                                }
                                                                                ImageKt.a(QUIToken.INSTANCE.image("close", QUIToken.color$default("icon_nav_secondary")), null, null, null, null, bVar6.a(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, f38), Alignment.Center), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer13, 262144, 0, 0, 2097118);
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
                                                        }), composer9, 196680, 24);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer7, 3080, 6);
                                            i q16 = ModifiersKt.q(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 6.0f), uo3.c.a(4.0f));
                                            float f28 = f17;
                                            i c16 = ModifiersKt.c(ComposeLayoutPropUpdaterKt.n(q16, f28, 6.0f, f28, 0.0f, 8, null), new h(VasBusiness.QWALLET));
                                            final QQFlashTransferViewModel qQFlashTransferViewModel5 = qQFlashTransferViewModel3;
                                            BoxKt.a(c16, null, null, ComposableLambdaKt.composableLambda(composer7, 296004630, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadProcessView.1.3.1.2
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(b bVar3, Composer composer8, Integer num4) {
                                                    int i17;
                                                    b bVar4 = bVar3;
                                                    Composer composer9 = composer8;
                                                    int intValue4 = num4.intValue();
                                                    if ((intValue4 & 14) == 0) {
                                                        i17 = (composer9.changed(bVar4) ? 4 : 2) | intValue4;
                                                    } else {
                                                        i17 = intValue4;
                                                    }
                                                    if ((i17 & 91) == 18 && composer9.getSkipping()) {
                                                        composer9.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(296004630, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadProcessView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTDownloadBarView.kt:571)");
                                                        }
                                                        i a16 = bVar4.a(i.INSTANCE, Alignment.BottomStart);
                                                        ca value = QQFlashTransferViewModel.this.fileSetDownLoadInfo.getValue();
                                                        BoxKt.a(ModifiersKt.c(ModifiersKt.q(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.i(a16, value != null ? ((float) QQFlashTransferViewModel.this.curDownLoadedBytes.getValue().longValue()) / ((float) UnsignedKt.ulongToDouble(value.f446234e)) : 0.0f), 6.0f), uo3.c.a(4.0f)), new h(4278226175L)), null, null, ComposableSingletons$QQFTDownloadBarViewKt.f126lambda1, composer9, 3080, 6);
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
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 24584, 14);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 24584, 14);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$downloadProcessView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTDownloadBarViewKt.downloadProcessView(QQFlashTransferViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void downloadSelectView(final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1247172706);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1247172706, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadSelectView (QQFTDownloadBarView.kt:116)");
        }
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("downloadSelectView bottom");
        m3.append(QQFTUIConfigKt.getAndroidBottomNavBarHeight(startRestartGroup));
        kLog.d("QQFTDownloadBarView", m3.toString());
        BoxKt.a(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1417395624, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$downloadSelectView$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                int i16;
                b bVar2 = bVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i16 = (composer3.changed(bVar2) ? 4 : 2) | intValue;
                } else {
                    i16 = intValue;
                }
                if ((i16 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1417395624, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadSelectView.<anonymous> (QQFTDownloadBarView.kt:118)");
                    }
                    i d16 = ViewEventPropUpdaterKt.d(ModifiersKt.f(bVar2.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), QQFTUIConfigKt.getAndroidBottomNavBarHeight(composer3) + 80.0f), QUIToken.color$default("bg_bottom_light")), Alignment.BottomCenter), (float) 0.5d, QUIToken.color$default("overlay_light"), BorderStyle.SOLID), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$downloadSelectView$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                            return Unit.INSTANCE;
                        }
                    }, 2, null);
                    final QQFlashTransferViewModel qQFlashTransferViewModel2 = QQFlashTransferViewModel.this;
                    BoxKt.a(d16, null, null, ComposableLambdaKt.composableLambda(composer3, 1235298194, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$downloadSelectView$1.2
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar3, Composer composer4, Integer num2) {
                            int i17;
                            b bVar4 = bVar3;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i17 = (composer5.changed(bVar4) ? 4 : 2) | intValue2;
                            } else {
                                i17 = intValue2;
                            }
                            if ((i17 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1235298194, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadSelectView.<anonymous>.<anonymous> (QQFTDownloadBarView.kt:123)");
                                }
                                i a16 = bVar4.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 80.0f), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), Alignment.TopCenter);
                                Alignment.Vertical f16 = Alignment.INSTANCE.f();
                                final QQFlashTransferViewModel qQFlashTransferViewModel3 = QQFlashTransferViewModel.this;
                                RowKt.a(a16, null, f16, null, null, ComposableLambdaKt.composableLambda(composer5, 1918953136, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadSelectView.1.2.1
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(n nVar, Composer composer6, Integer num3) {
                                        int i18;
                                        n nVar2 = nVar;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 14) == 0) {
                                            i18 = (composer7.changed(nVar2) ? 4 : 2) | intValue3;
                                        } else {
                                            i18 = intValue3;
                                        }
                                        if ((i18 & 91) == 18 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1918953136, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadSelectView.<anonymous>.<anonymous>.<anonymous> (QQFTDownloadBarView.kt:127)");
                                            }
                                            i r16 = ComposeLayoutPropUpdaterKt.r(ComposeLayoutPropUpdaterKt.f(nVar2.a(i.INSTANCE, 1.0f), 0.0f, 1, null), 16.0f, 8.0f, 16.0f, 8.0f);
                                            final QQFlashTransferViewModel qQFlashTransferViewModel4 = QQFlashTransferViewModel.this;
                                            BoxKt.a(r16, null, null, ComposableLambdaKt.composableLambda(composer7, -2129706774, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadSelectView.1.2.1.1
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(b bVar5, Composer composer8, Integer num4) {
                                                    int i19;
                                                    String str;
                                                    String str2;
                                                    b bVar6 = bVar5;
                                                    Composer composer9 = composer8;
                                                    int intValue4 = num4.intValue();
                                                    if ((intValue4 & 14) == 0) {
                                                        i19 = (composer9.changed(bVar6) ? 4 : 2) | intValue4;
                                                    } else {
                                                        i19 = intValue4;
                                                    }
                                                    if ((i19 & 91) == 18 && composer9.getSkipping()) {
                                                        composer9.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-2129706774, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadSelectView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTDownloadBarView.kt:150)");
                                                        }
                                                        if (ULong.m648constructorimpl(QQFlashTransferViewModel.this.selectFilesToDownload.size()) == QQFlashTransferViewModel.this.m116getCurPageFirstLevelItemCountsVKNKU()) {
                                                            str = "\u5168\u90e8\u4e0b\u8f7d";
                                                        } else {
                                                            str = "\u4e0b\u8f7d";
                                                        }
                                                        String str3 = str;
                                                        QUIButtonType qUIButtonType = QUIButtonType.PRIMARY;
                                                        bp3.k kVar = new bp3.k(null, Float.valueOf(17.0f), bp3.c.INSTANCE.f(), null, null, null, null, null, null, null, null, null, null, null, 16377, null);
                                                        i a17 = bVar6.a(ModifiersKt.j(ModifiersKt.w(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 48.0f), QUIToken.color$default("button_bg_primary_pressed")), 14.0f), Alignment.TopCenter);
                                                        if (defpackage.k.a(com.tencent.kuikly.core.manager.c.f117352a)) {
                                                            str2 = "0S200MNJT807V3GE";
                                                        } else {
                                                            str2 = "0M2003OIIM08YV9M";
                                                        }
                                                        e dTBaseParams = DTReportConstKt.getDTBaseParams(str2);
                                                        QQFlashTransferViewModel qQFlashTransferViewModel5 = QQFlashTransferViewModel.this;
                                                        dTBaseParams.v("files_number", String.valueOf(qQFlashTransferViewModel5.selectFilesToDownload.size()));
                                                        long j3 = 0;
                                                        for (Map.Entry<String, ab> entry : qQFlashTransferViewModel5.selectFilesToDownload.entrySet()) {
                                                            entry.getKey();
                                                            j3 = ULong.m648constructorimpl(j3 + entry.getValue().f446164o);
                                                        }
                                                        dTBaseParams.v(MediaDBValues.FILESIZE, ULong.m693toStringimpl(j3));
                                                        Unit unit = Unit.INSTANCE;
                                                        i elementVR = ModifierExtKt.elementVR(a17, "em_download_btn", dTBaseParams);
                                                        final QQFlashTransferViewModel qQFlashTransferViewModel6 = QQFlashTransferViewModel.this;
                                                        QUIButtonKt.QUIButton(elementVR, qUIButtonType, null, str3, kVar, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt.downloadSelectView.1.2.1.1.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                KLog kLog2 = KLog.INSTANCE;
                                                                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("downloadSelectView selectFilesToDownload=");
                                                                m16.append(QQFlashTransferViewModel.this.selectFilesToDownload.size());
                                                                m16.append(TokenParser.SP);
                                                                kLog2.d("QQFTDownloadBarView", m16.toString());
                                                                boolean z16 = true;
                                                                if (QQFlashTransferViewModel.this.hasShownFirstDownloadTip == null) {
                                                                    StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("hasShownFirstDownloadTip=");
                                                                    m17.append(QQFlashTransferViewModel.this.hasShownFirstDownloadTip);
                                                                    kLog2.d("QQFTDownloadBarView", m17.toString());
                                                                    QQFlashTransferViewModel qQFlashTransferViewModel7 = QQFlashTransferViewModel.this;
                                                                    Utils utils = Utils.INSTANCE;
                                                                    CacheModule cacheModule = utils.cacheModule("");
                                                                    QQFlashTransferViewModel.Companion companion = QQFlashTransferViewModel.Companion;
                                                                    int i26 = cacheModule.getInt(companion.getHAS_SHOWN_FIRST_DOWNLOAD_TIP_KEY());
                                                                    if (i26 == null) {
                                                                        i26 = 0;
                                                                    }
                                                                    qQFlashTransferViewModel7.hasShownFirstDownloadTip = i26;
                                                                    Integer num5 = QQFlashTransferViewModel.this.hasShownFirstDownloadTip;
                                                                    if (num5 == null || num5.intValue() != 1) {
                                                                        utils.cacheModule("").setInt(companion.getHAS_SHOWN_FIRST_DOWNLOAD_TIP_KEY(), 1);
                                                                        QQFlashTransferViewModel.this.hasShownFirstDownloadTip = 1;
                                                                        QQFlashTransferViewModel.this.showFirstDownloadTip.setValue(Boolean.TRUE);
                                                                    }
                                                                }
                                                                if (QQFlashTransferViewModel.this.isDownloadPause.getValue().booleanValue()) {
                                                                    QQFlashTransferViewModel.this.showAddRestartDownloadAlertDialog.setValue(Boolean.TRUE);
                                                                } else {
                                                                    QQFlashTransferViewModel qQFlashTransferViewModel8 = QQFlashTransferViewModel.this;
                                                                    int size = qQFlashTransferViewModel8.selectFilesToDownload.size();
                                                                    int downloadStatusFileCount = qQFlashTransferViewModel8.getDownloadStatusFileCount(2);
                                                                    int downloadStatusFileCount2 = qQFlashTransferViewModel8.getDownloadStatusFileCount(3);
                                                                    int size2 = qQFlashTransferViewModel8.downloadingFileList.size();
                                                                    kLog2.d("QQFTDownloadBarView", "handleDownloadSelectFiles beforeSelectFileCount=" + size + " downloadingFileCount=" + downloadStatusFileCount + " downloadedFileCount=" + downloadStatusFileCount2 + " curDownloadingCount=" + size2);
                                                                    if (downloadStatusFileCount > 0 && size2 > 0) {
                                                                        if (downloadStatusFileCount + downloadStatusFileCount2 == size) {
                                                                            QQKuiklyPlatformApi.Companion.qqToast("\u6587\u4ef6\u5df2\u5728\u4e0b\u8f7d\u4e2d", QToastMode.Info);
                                                                        } else {
                                                                            QQKuiklyPlatformApi.Companion.qqToast("\u90e8\u5206\u6587\u4ef6\u5df2\u5728\u4e0b\u8f7d\u4e2d", QToastMode.Info);
                                                                        }
                                                                        if (downloadStatusFileCount2 <= 0) {
                                                                            z16 = false;
                                                                        }
                                                                    }
                                                                    if (z16) {
                                                                        qQFlashTransferViewModel8.roundDownloadingSize.setValue(0L);
                                                                        qQFlashTransferViewModel8.roundDownloadingCount.setValue(Long.valueOf(size));
                                                                        QQFTDownloadBarViewKt.handleDownloadFiles(qQFlashTransferViewModel8);
                                                                    } else {
                                                                        qQFlashTransferViewModel8.selectFilesToDownload.clear();
                                                                    }
                                                                    qQFlashTransferViewModel8.updateAllItem(false);
                                                                    qQFlashTransferViewModel8.updateFileContentOffset(size);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }, null, null, composer9, (bp3.k.f28903n << 12) | 56, 196);
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
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 196616, 26);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3080, 6);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$downloadSelectView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTDownloadBarViewKt.downloadSelectView(QQFlashTransferViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void selectFileInfoStrView(final i iVar, final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-441347936);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-441347936, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.selectFileInfoStrView (QQFTDownloadBarView.kt:195)");
        }
        final int size = qQFlashTransferViewModel.selectFilesToDownload.size();
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = 0L;
        for (Map.Entry<String, ab> entry : qQFlashTransferViewModel.selectFilesToDownload.entrySet()) {
            entry.getKey();
            longRef.element = ULong.m648constructorimpl(longRef.element + entry.getValue().f446164o);
        }
        if (size > 0) {
            RowKt.a(iVar, a.f339245a.b(), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1837139261, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$selectFileInfoStrView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(n nVar, Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1837139261, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.selectFileInfoStrView.<anonymous> (QQFTDownloadBarView.kt:204)");
                        }
                        h color$default = QUIToken.color$default("text_primary");
                        ai.Companion companion = ai.INSTANCE;
                        int a16 = companion.a();
                        c.Companion companion2 = bp3.c.INSTANCE;
                        TextKt.a("\u5df2\u9009", null, null, color$default, Float.valueOf(17.0f), null, companion2.e(), null, null, null, ai.f(a16), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601542, 0, 0, 134216614);
                        String m3 = AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m(TokenParser.SP), size, TokenParser.SP);
                        h color$default2 = QUIToken.color$default("text_primary");
                        int a17 = companion.a();
                        TextKt.a(m3, null, null, color$default2, Float.valueOf(17.0f), null, companion2.a(), null, null, null, ai.f(a17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601536, 0, 0, 134216614);
                        h color$default3 = QUIToken.color$default("text_primary");
                        int a18 = companion.a();
                        TextKt.a("\u9879 \u00b7 ", null, null, color$default3, Float.valueOf(17.0f), null, companion2.e(), null, null, null, ai.f(a18), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601542, 0, 0, 134216614);
                        l lVar = l.f413536a;
                        String b16 = lVar.b(longRef.element);
                        h color$default4 = QUIToken.color$default("text_primary");
                        int a19 = companion.a();
                        TextKt.a(b16, null, null, color$default4, Float.valueOf(17.0f), null, companion2.a(), null, null, null, ai.f(a19), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601536, 0, 0, 134216614);
                        StringBuilder m16 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m(TokenParser.SP);
                        m16.append(lVar.c(longRef.element));
                        String sb5 = m16.toString();
                        h color$default5 = QUIToken.color$default("text_primary");
                        int a26 = companion.a();
                        TextKt.a(sb5, null, null, color$default5, Float.valueOf(17.0f), null, companion2.e(), null, null, null, ai.f(a26), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601536, 0, 0, 134216614);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 196680, 28);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$selectFileInfoStrView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTDownloadBarViewKt.selectFileInfoStrView(i.this, qQFlashTransferViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$downloadedFileSizeUI(final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        String str;
        Composer startRestartGroup = composer.startRestartGroup(1187149869);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1187149869, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadedFileSizeUI (QQFTDownloadBarView.kt:997)");
        }
        BoxKt.a(null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 811682919, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$downloadedFileSizeUI$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                String str2;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(811682919, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadedFileSizeUI.<anonymous> (QQFTDownloadBarView.kt:998)");
                    }
                    l lVar = l.f413536a;
                    if (Float.parseFloat(lVar.b(QQFlashTransferViewModel.this.curDownLoadedBytes.getValue().longValue())) >= 100.0f) {
                        str2 = "000.0";
                    } else if (Float.parseFloat(lVar.b(QQFlashTransferViewModel.this.curDownLoadedBytes.getValue().longValue())) >= 10.0f) {
                        str2 = "00.0";
                    } else {
                        str2 = "0.0";
                    }
                    String str3 = str2;
                    h color$default = QUIToken.color$default("text_primary");
                    c.Companion companion = bp3.c.INSTANCE;
                    TextKt.a(str3, ModifiersKt.R(i.INSTANCE, false), null, color$default, Float.valueOf(16.0f), null, companion.a(), null, null, null, null, Float.valueOf(22.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601600, 48, 0, 134215588);
                    TextKt.a(lVar.b(QQFlashTransferViewModel.this.curDownLoadedBytes.getValue().longValue()), null, null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, companion.a(), null, null, null, null, Float.valueOf(22.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601536, 48, 0, 134215590);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3072, 7);
        StringBuilder sb5 = new StringBuilder();
        long longValue = qQFlashTransferViewModel.curDownLoadedBytes.getValue().longValue();
        if (longValue > 1073741824) {
            str = "GB";
        } else if (longValue > 1048576) {
            str = "MB";
        } else if (longValue > 1024) {
            str = "KB";
        } else {
            str = "B";
        }
        TextKt.a(LoadFailParams$$ExternalSyntheticOutline0.m(sb5, str, '/'), null, null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, bp3.c.INSTANCE.e(), null, null, null, null, Float.valueOf(22.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, startRestartGroup, 1601536, 48, 0, 134215590);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$downloadedFileSizeUI$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTDownloadBarViewKt.access$downloadedFileSizeUI(QQFlashTransferViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$totalDownloadFileSizeUI(final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(569339350);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(569339350, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.totalDownloadFileSizeUI (QQFTDownloadBarView.kt:965)");
        }
        l lVar = l.f413536a;
        ca value = qQFlashTransferViewModel.fileSetDownLoadInfo.getValue();
        String b16 = lVar.b(Math.max(value != null ? value.f446234e : 0L, qQFlashTransferViewModel.roundDownloadingSize.getValue().longValue()));
        h color$default = QUIToken.color$default("text_primary");
        c.Companion companion = bp3.c.INSTANCE;
        TextKt.a(b16, null, null, color$default, Float.valueOf(16.0f), null, companion.a(), null, null, null, null, Float.valueOf(22.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, startRestartGroup, 1601536, 48, 0, 134215590);
        StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m(TokenParser.SP);
        ca value2 = qQFlashTransferViewModel.fileSetDownLoadInfo.getValue();
        m3.append(lVar.c(Math.max(value2 != null ? value2.f446234e : 0L, qQFlashTransferViewModel.roundDownloadingSize.getValue().longValue())));
        TextKt.a(m3.toString(), null, null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, companion.e(), null, null, null, null, Float.valueOf(22.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, startRestartGroup, 1601536, 48, 0, 134215590);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadBarViewKt$totalDownloadFileSizeUI$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTDownloadBarViewKt.access$totalDownloadFileSizeUI(QQFlashTransferViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
