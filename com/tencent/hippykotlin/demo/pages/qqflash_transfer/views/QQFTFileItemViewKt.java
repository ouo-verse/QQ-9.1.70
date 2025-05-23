package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogItem;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.da_tong_report.DTReportConstKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt;
import com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.FTFilterType;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.module.QQFlashTransferKuiklyModule;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.utils.QQFTReportUtil;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.msf.core.c0.g;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.FlowRowKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.foundation.scheduler.SchedulerKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.SurfaceKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.an;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService;
import defpackage.k;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import ws3.ab;
import ws3.bp;
import ws3.br;
import ws3.ct;
import ws3.cx;
import ws3.dr;
import ws3.eg;
import zz0.a;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTFileItemViewKt {
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0259, code lost:
    
        if ((r13 == null ? true : ((java.lang.Boolean) r13).booleanValue()) == false) goto L81;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v12, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.lang.Iterable, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [java.util.List<ws3.ab>] */
    /* JADX WARN: Type inference failed for: r15v3, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r15v8, types: [java.util.ArrayList] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void access$handleClickItem(QQFlashTransferViewModel qQFlashTransferViewModel, final QQFTFileDetailItemVM qQFTFileDetailItemVM, boolean z16, MutableState mutableState) {
        String str;
        ?? r152;
        int collectionSizeOrDefault;
        ab abVar;
        String sb5;
        final ab abVar2 = qQFTFileDetailItemVM.fileDetail;
        if (qQFTFileDetailItemVM.fileStatus.getValue().intValue() == 5) {
            QQKuiklyPlatformApi.Companion.qqToast("\u6587\u4ef6\u5df2\u5931\u6548", QToastMode.Warning);
            return;
        }
        if (qQFTFileDetailItemVM.fileStatus.getValue().intValue() == 4) {
            br value = qQFlashTransferViewModel.fileSet.getValue();
            if (!(value != null && value.f446199m == 1 && value.f446200n)) {
                QQKuiklyPlatformApi.Companion.qqToast("\u6587\u4ef6\u5ba1\u6838\u4e2d\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", QToastMode.Warning);
                return;
            }
        }
        if (qQFlashTransferViewModel.isSelectBarShow()) {
            handleCheckItem(qQFlashTransferViewModel, qQFTFileDetailItemVM);
            return;
        }
        if (abVar2 != null) {
            if (z16) {
                KLog.INSTANCE.d("QQFTFileItemView", "fileDetail clickable return");
                return;
            }
            a aVar = a.f453719a;
            if (aVar.a() - qQFlashTransferViewModel.fileItemClickTimestamp < 500) {
                KLog.INSTANCE.d("QQFTFileItemView", "\u70b9\u51fb\u64cd\u4f5c\u592a\u9891\u7e41");
                return;
            }
            qQFlashTransferViewModel.fileItemClickTimestamp = aVar.a();
            if (abVar2.C == 3) {
                IKernelFlashTransferService a16 = IKernelFlashTransferService.f344757i.a();
                String str2 = abVar2.f446150a;
                String str3 = abVar2.f446151b;
                final ct ctVar = new ct() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$handleClickItem$1$1
                    @Override // ws3.ct
                    public final void OnCheckDownloadStatus(final String str4, final int i3) {
                        final ab abVar3 = ab.this;
                        final QQFTFileDetailItemVM qQFTFileDetailItemVM2 = qQFTFileDetailItemVM;
                        SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$handleClickItem$1$1$OnCheckDownloadStatus$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                KLog kLog = KLog.INSTANCE;
                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("checkDownloadStatusBeforeLocalFileOper cliFileId=");
                                m3.append(str4);
                                m3.append(" fileDownloadStatus=");
                                DatalineDetailViewModel$$ExternalSyntheticOutline0.m(m3, i3, kLog, "QQFTFileItemView");
                                if (Intrinsics.areEqual(str4, abVar3.f446151b)) {
                                    qQFTFileDetailItemVM2.downloadStatus.setValue(Integer.valueOf(i3));
                                }
                                return Unit.INSTANCE;
                            }
                        });
                    }
                };
                a16.getClass();
                ArrayList arrayList = new ArrayList();
                arrayList.add(0);
                arrayList.add(str2);
                arrayList.add(str3);
                arrayList.add(String.valueOf(ctVar.hashCode()));
                Function1<Object, Unit> function1 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$checkDownloadStatusBeforeLocalFileOper$kernelCallback$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object obj) {
                        Object[] objArr = obj instanceof Object[] ? (Object[]) obj : null;
                        if (objArr != null) {
                            if (!(objArr.length == 0)) {
                                Iterator it = ArrayIteratorKt.iterator(objArr);
                                if (Intrinsics.areEqual((String) dr.a(it, "null cannot be cast to non-null type kotlin.String"), "OnCheckDownloadStatus")) {
                                    Object next = it.next();
                                    Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
                                    ((Integer) next).intValue();
                                    Object next2 = it.next();
                                    Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
                                    ((Integer) next2).intValue();
                                    Object next3 = it.next();
                                    Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
                                    Object next4 = it.next();
                                    Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.String");
                                    Object next5 = it.next();
                                    Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FileDownloadStatusKt.FileDownloadStatus }");
                                    ct.this.OnCheckDownloadStatus((String) next4, ((Integer) next5).intValue());
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    }
                };
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                a16.syncToNativeMethod(true, "checkDownloadStatusBeforeLocalFileOper", array, function1);
            }
            if (abVar2.f446154e.length() > 0) {
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("&index_path=");
                m3.append(abVar2.f446154e);
                str = m3.toString();
            } else {
                str = "";
            }
            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("mqqapi://kuikly/open?page_name=QQTransferDownloadActivity&local_bundle_name=nearbypro&use_host_display_metrics=1&bottom_nav_bar_immersive=1&src_type=app&version=1&qui_token_theme_mode=0&autorotate=1&file_set_id=");
            m16.append(abVar2.f446150a);
            m16.append("&parent_name=");
            m16.append(abVar2.f446160k);
            m16.append("&scene_type=");
            m16.append(qQFlashTransferViewModel.sceneType);
            m16.append(str);
            String sb6 = m16.toString();
            if (abVar2.f446155f) {
                StringBuilder m17 = HotViewKt$$ExternalSyntheticOutline0.m(sb6, "&parent_id=");
                m17.append(abVar2.f446151b);
                m17.append("&dir_file_count=");
                m17.append((Object) UInt.m615toStringimpl(abVar2.f446165p));
                m17.append("&dir_file_size=");
                m17.append((Object) ULong.m693toStringimpl(abVar2.f446164o));
                String sb7 = m17.toString();
                if (abVar2.f446152c.length() > 0) {
                    StringBuilder m18 = HotViewKt$$ExternalSyntheticOutline0.m(sb7, "&compressed_file_folder_id=");
                    m18.append(abVar2.f446152c);
                    sb5 = m18.toString();
                } else {
                    StringBuilder m19 = HotViewKt$$ExternalSyntheticOutline0.m(sb7, "&parent_filter_type=");
                    m19.append(qQFlashTransferViewModel.filterType.getValue().ordinal());
                    sb5 = m19.toString();
                }
                KLog.INSTANCE.d("QQFTFileItemView", "open url:" + sb5);
                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                QQKuiklyPlatformApi.Companion.openPage$default(sb5, false, 6);
                return;
            }
            if (abVar2.f446159j == 4) {
                if (abVar2.f446152c.length() == 0) {
                    StringBuilder m26 = HotViewKt$$ExternalSyntheticOutline0.m(sb6, "&compressed_file_folder_id=");
                    m26.append(abVar2.f446151b);
                    String sb8 = m26.toString();
                    if (!qQFlashTransferViewModel.isCompressPage()) {
                        sb8 = AgreementConsentViewKt$$ExternalSyntheticOutline0.m(sb8, "&bottom_nav_bar_immersive=1&modal_mode=1");
                    }
                    if (qQFlashTransferViewModel.filterType.getValue() != FTFilterType.ALL_FILE) {
                        StringBuilder m27 = HotViewKt$$ExternalSyntheticOutline0.m(sb8, "&parent_filter_type=");
                        m27.append(qQFlashTransferViewModel.filterType.getValue().ordinal());
                        sb8 = m27.toString();
                    }
                    if (qQFTFileDetailItemVM.compressStatus.getValue().intValue() == 4 || qQFTFileDetailItemVM.compressStatus.getValue().intValue() == 3) {
                        sb8 = AgreementConsentViewKt$$ExternalSyntheticOutline0.m(sb8, "&parent_zip_downloaded_file=1");
                    }
                    QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                    QQKuiklyPlatformApi.Companion.openPage$default(sb8, false, 6);
                    return;
                }
            }
            if (abVar2.f446152c.length() > 0) {
                if (!(abVar2.f446172w.length() == 0)) {
                    Object returnValue = QQFlashTransferKuiklyModule.Companion.getInstance().toNative(false, "fileExists", abVar2.f446172w, null, true).getReturnValue();
                }
                mutableState.setValue(Boolean.TRUE);
                return;
            }
            if (qQFlashTransferViewModel.isFileSetExpired.getValue().booleanValue()) {
                ?? r132 = qQFlashTransferViewModel.itemVMList;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(r132, 10);
                r152 = new ArrayList(collectionSizeOrDefault);
                Iterator it = r132.iterator();
                while (it.hasNext()) {
                    QQFTFileDetailItemVM qQFTFileDetailItemVM2 = (QQFTFileDetailItemVM) it.next();
                    ab abVar3 = qQFTFileDetailItemVM2.fileDetail;
                    if (!(abVar3 != null && abVar3.C == 3)) {
                        br value2 = qQFlashTransferViewModel.fileSet.getValue();
                        if (!(value2 != null && value2.f446200n)) {
                            abVar = new ab();
                            r152.add(abVar);
                        }
                    }
                    abVar = qQFTFileDetailItemVM2.fileDetail;
                    if (abVar == null) {
                        abVar = new ab();
                    }
                    r152.add(abVar);
                }
            } else {
                bp bpVar = qQFlashTransferViewModel.fileLists;
                r152 = bpVar != null ? bpVar.f446183a : 0;
            }
            QQFlashTransferKuiklyModule companion3 = QQFlashTransferKuiklyModule.Companion.getInstance();
            QQFTFileItemViewKt$handleClickItem$1$2 qQFTFileItemViewKt$handleClickItem$1$2 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$handleClickItem$1$2
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar) {
                    KLog.INSTANCE.d("QQFTFileItemView", "browseFile callback " + eVar);
                    return Unit.INSTANCE;
                }
            };
            e createParamsWithFileInfo = companion3.createParamsWithFileInfo(abVar2);
            if (r152 != 0) {
                Iterable iterable = r152.isEmpty() ^ true ? r152 : null;
                if (iterable != null) {
                    b bVar = new b();
                    Iterator it5 = iterable.iterator();
                    while (it5.hasNext()) {
                        bVar.t(companion3.createParamsWithFileInfo((ab) it5.next()));
                    }
                    Unit unit = Unit.INSTANCE;
                    createParamsWithFileInfo.v("fileList", bVar);
                }
            }
            companion3.toNative(true, "browseFile", createParamsWithFileInfo.toString(), qQFTFileItemViewKt$handleClickItem$1$2, false);
        }
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
    public static final void handleCheckItem(QQFlashTransferViewModel qQFlashTransferViewModel, QQFTFileDetailItemVM qQFTFileDetailItemVM) {
        StringBuilder m3;
        if (qQFTFileDetailItemVM.fileStatus.getValue().intValue() == 5) {
            KLog kLog = KLog.INSTANCE;
            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("handleCheckItem isInSecurityCheck ");
            m16.append(qQFTFileDetailItemVM.fileStatus.getValue().intValue());
            kLog.d("QQFTFileItemView", m16.toString());
            QQKuiklyPlatformApi.Companion.qqToast("\u6587\u4ef6\u5df2\u5931\u6548", QToastMode.Warning);
            return;
        }
        boolean z16 = false;
        if (qQFTFileDetailItemVM.fileStatus.getValue().intValue() == 4) {
            br value = qQFlashTransferViewModel.fileSet.getValue();
            if (!(value != null && value.f446199m == 1 && value.f446200n)) {
                KLog kLog2 = KLog.INSTANCE;
                StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("handleCheckItem isInSecurityCheck ");
                m17.append(qQFTFileDetailItemVM.fileStatus.getValue().intValue());
                kLog2.d("QQFTFileItemView", m17.toString());
                QQKuiklyPlatformApi.Companion.qqToast("\u6587\u4ef6\u5ba1\u6838\u4e2d\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", QToastMode.Warning);
                return;
            }
        }
        int size = qQFlashTransferViewModel.selectFilesToDownload.size();
        qQFlashTransferViewModel.beforeUpdateFileContentOffset();
        qQFTFileDetailItemVM.isSelected.setValue(Boolean.valueOf(!r1.getValue().booleanValue()));
        if (qQFlashTransferViewModel.itemVMList.isEmpty()) {
            qQFlashTransferViewModel.isAllSelectMode.setValue(Boolean.FALSE);
        } else {
            Iterator it = qQFlashTransferViewModel.itemVMList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z16 = true;
                    break;
                } else if (!((QQFTFileDetailItemVM) it.next()).isSelected.getValue().booleanValue()) {
                    break;
                }
            }
            qQFlashTransferViewModel.isAllSelectMode.setValue(Boolean.valueOf(z16));
        }
        ab abVar = qQFTFileDetailItemVM.fileDetail;
        if (abVar != null) {
            if (qQFTFileDetailItemVM.isSelected.getValue().booleanValue()) {
                qQFlashTransferViewModel.selectFilesToDownload.put(abVar.f446151b, abVar);
            } else {
                qQFlashTransferViewModel.selectFilesToDownload.remove(abVar.f446151b);
            }
            qQFlashTransferViewModel.updateAllSelectFileDownloadPause(abVar, qQFTFileDetailItemVM.isSelected.getValue().booleanValue());
            KLog kLog3 = KLog.INSTANCE;
            if (qQFTFileDetailItemVM.isSelected.getValue().booleanValue()) {
                m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("click add ");
            } else {
                m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("click remove ");
            }
            NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(m3, abVar.f446160k, kLog3, "QQFTFileItemView");
        }
        qQFlashTransferViewModel.updateFileContentOffset(size);
        KLog kLog4 = KLog.INSTANCE;
        StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("click check box...... enable.value=");
        m18.append(qQFTFileDetailItemVM.isSelected.getValue().booleanValue());
        m18.append(" topOffset=");
        m18.append(qQFlashTransferViewModel.fileContentTopOffset);
        kLog4.d("QQFTFileItemView", m18.toString());
    }

    public static final int getThumbnailValidIndex(eg egVar) {
        int size;
        if ((egVar != null ? egVar.f446333b : null) != null && !egVar.f446333b.isEmpty() && 1 <= (size = egVar.f446333b.size())) {
            int i3 = 1;
            while (true) {
                int i16 = i3 - 1;
                if (!(egVar.f446333b.get(i16).f446358b.length() > 0)) {
                    if (i3 == size) {
                        break;
                    }
                    i3++;
                } else {
                    return i16;
                }
            }
        }
        return -1;
    }

    public static final void QQFTFileItemView(final int i3, final QQFlashTransferViewModel qQFlashTransferViewModel, final QQFTFileDetailItemVM qQFTFileDetailItemVM, Composer composer, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(-1236457179);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1236457179, i16, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemView (QQFTFileItemView.kt:89)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        boolean z16 = qQFTFileDetailItemVM.fileStatus.getValue().intValue() == 3;
        if (qQFlashTransferViewModel.isGridMode.getValue().booleanValue()) {
            startRestartGroup.startReplaceableGroup(-915568636);
            if (qQFlashTransferViewModel.isImageGridMode()) {
                startRestartGroup.startReplaceableGroup(-915568593);
                imageGridMode(i3, z16, (int) (((GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(c.f117352a) - 5) + 1) / 5.0f), mutableState, qQFlashTransferViewModel, qQFTFileDetailItemVM, startRestartGroup, (i16 & 14) | 35840 | ((i16 << 9) & 458752));
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(-915568452);
                gridModeView(i3, z16, ((GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(c.f117352a) - 3) - 8.0f) / 3.0f, mutableState, qQFlashTransferViewModel, qQFTFileDetailItemVM, startRestartGroup, (i16 & 14) | 35840 | ((i16 << 9) & 458752));
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(-915568316);
            listViewMode(i3, z16, 71.0f, mutableState, qQFlashTransferViewModel, qQFTFileDetailItemVM, startRestartGroup, (i16 & 14) | 36224 | ((i16 << 9) & 458752));
            startRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$QQFTFileItemView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTFileItemViewKt.QQFTFileItemView(i3, qQFlashTransferViewModel, qQFTFileDetailItemVM, composer2, i16 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$fileStatusProcess(final Boolean bool, final Float f16, Composer composer, final int i3, final int i16) {
        int i17;
        Composer startRestartGroup = composer.startRestartGroup(-2067778539);
        int i18 = i16 & 1;
        if (i18 != 0) {
            i17 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i17 = (startRestartGroup.changed(bool) ? 4 : 2) | i3;
        } else {
            i17 = i3;
        }
        int i19 = i16 & 2;
        if (i19 != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            i17 |= startRestartGroup.changed(f16) ? 32 : 16;
        }
        if ((i17 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i18 != 0) {
                bool = Boolean.TRUE;
            }
            if (i19 != 0) {
                f16 = Float.valueOf(0.0f);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2067778539, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.fileStatusProcess (QQFTFileItemView.kt:315)");
            }
            BoxKt.a(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 20.0f), 14.0f), Alignment.CenterStart, null, ComposableLambdaKt.composableLambda(startRestartGroup, -815874917, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$fileStatusProcess$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num) {
                    int i26;
                    com.tencent.ntcompose.foundation.layout.b bVar2 = bVar;
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 14) == 0) {
                        i26 = (composer3.changed(bVar2) ? 4 : 2) | intValue;
                    } else {
                        i26 = intValue;
                    }
                    if ((i26 & 91) == 18 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-815874917, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.fileStatusProcess.<anonymous> (QQFTFileItemView.kt:317)");
                        }
                        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                            composer3.startReplaceableGroup(-1953683935);
                            ImageKt.a(QUIToken.INSTANCE.image("time", QUIToken.color$default("icon_tertiary")), null, null, null, null, bVar2.a(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 14.0f), Alignment.Center), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, 262144, 0, 0, 2097118);
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(-1953683742);
                            Float f17 = f16;
                            QQFTFileItemProcessViewKt.QQFTFileItemProcessView(f17 != null ? f17.floatValue() : 0.0f, 12.0f, QUIToken.color$default("icon_tertiary"), QUIToken.color$default("icon_tertiary"), 0.0f, composer3, 4656, 16);
                            composer3.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 3128, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$fileStatusProcess$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTFileItemViewKt.access$fileStatusProcess(bool, f16, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$undownloadedAlertDialog(final QQFlashTransferViewModel qQFlashTransferViewModel, final ab abVar, final MutableState mutableState, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(803733276);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(803733276, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.undownloadedAlertDialog (QQFTFileItemView.kt:583)");
        }
        boolean booleanValue = ((Boolean) mutableState.getValue()).booleanValue();
        QUIAlertDialogItem[] qUIAlertDialogItemArr = new QUIAlertDialogItem[2];
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed = startRestartGroup.changed(mutableState);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$undownloadedAlertDialog$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    mutableState.setValue(Boolean.FALSE);
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        qUIAlertDialogItemArr[0] = QUIAlertDialogKt.QUIAlertDialogNormalTextItem("\u53d6\u6d88", (Function0) rememberedValue);
        qUIAlertDialogItemArr[1] = QUIAlertDialogKt.QUIAlertDialogNormalTextItem("\u4e0b\u8f7d", new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$undownloadedAlertDialog$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                ArrayList arrayListOf;
                mutableState.setValue(Boolean.FALSE);
                ab abVar2 = abVar;
                if (abVar2 != null) {
                    QQFlashTransferViewModel qQFlashTransferViewModel2 = qQFlashTransferViewModel;
                    String str = abVar2.f446150a;
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(abVar2);
                    cx cxVar = new cx() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$undownloadedAlertDialog$2$1$1
                        @Override // ws3.cx
                        /* renamed from: onResult-jXDDuk8 */
                        public final void mo120onResultjXDDuk8(final int i16, final String str2, final int i17) {
                            SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$undownloadedAlertDialog$2$1$1$onResult$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    KLog kLog = KLog.INSTANCE;
                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("startFileListDownLoad result=");
                                    m3.append(i16);
                                    m3.append(" errMsg=");
                                    m3.append(str2);
                                    m3.append(" extraInfo=");
                                    m3.append((Object) UInt.m615toStringimpl(i17));
                                    kLog.d("QQFTFileItemView", m3.toString());
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                    };
                    QQFlashTransferViewModel.Companion companion = QQFlashTransferViewModel.Companion;
                    qQFlashTransferViewModel2.startFileListDownLoad(str, arrayListOf, cxVar, false);
                }
                return Unit.INSTANCE;
            }
        });
        QUIAlertDialogKt.QUIAlertDialog(booleanValue, "", "\u8be5\u6587\u4ef6\u4e3a\u538b\u7f29\u5305\u683c\u5f0f\uff0c\u65e0\u6cd5\u5728\u7ebf\u9884\u89c8\uff0c\u8bf7\u4e0b\u8f7d\u540e\u67e5\u770b", null, qUIAlertDialogItemArr, null, null, startRestartGroup, 33200, 104);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$undownloadedAlertDialog$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTFileItemViewKt.access$undownloadedAlertDialog(QQFlashTransferViewModel.this, abVar, mutableState, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$fileStatusAndFileSizeUI(final a.d dVar, final float f16, final i iVar, final QQFlashTransferViewModel qQFlashTransferViewModel, final QQFTFileDetailItemVM qQFTFileDetailItemVM, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(2002937217);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2002937217, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.fileStatusAndFileSizeUI (QQFTFileItemView.kt:494)");
        }
        FlowRowKt.a(null, ComposeLayoutPropUpdaterKt.w(iVar, f16), dVar, null, null, 0, ComposableLambdaKt.composableLambda(startRestartGroup, -933598298, true, new Function3<com.tencent.ntcompose.foundation.layout.i, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$fileStatusAndFileSizeUI$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.layout.i iVar2, Composer composer2, Integer num) {
                float f17;
                String str;
                ab abVar;
                Composer composer3;
                String str2;
                int i16;
                String str3;
                boolean z16;
                float floatValue;
                Composer composer4 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer4.getSkipping()) {
                    composer4.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-933598298, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.fileStatusAndFileSizeUI.<anonymous> (QQFTFileItemView.kt:495)");
                    }
                    ab abVar2 = QQFTFileDetailItemVM.this.fileDetail;
                    composer4.startReplaceableGroup(-573597654);
                    if (QQFTFileDetailItemVM.this.shouldShowFileStatus()) {
                        final Triple<String, String, Boolean> statusIconAndText = QQFTFileDetailItemVM.this.statusIconAndText(qQFlashTransferViewModel);
                        if (!statusIconAndText.getThird().booleanValue()) {
                            composer4.startReplaceableGroup(-573597488);
                            BoxKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 20.0f), 0.0f, 0.0f, 1.0f, 0.0f, 11, null), Alignment.CenterStart, null, ComposableLambdaKt.composableLambda(composer4, -85618782, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$fileStatusAndFileSizeUI$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer5, Integer num2) {
                                    int i17;
                                    com.tencent.ntcompose.foundation.layout.b bVar2 = bVar;
                                    Composer composer6 = composer5;
                                    int intValue2 = num2.intValue();
                                    if ((intValue2 & 14) == 0) {
                                        i17 = (composer6.changed(bVar2) ? 4 : 2) | intValue2;
                                    } else {
                                        i17 = intValue2;
                                    }
                                    if ((i17 & 91) == 18 && composer6.getSkipping()) {
                                        composer6.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-85618782, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.fileStatusAndFileSizeUI.<anonymous>.<anonymous> (QQFTFileItemView.kt:504)");
                                        }
                                        ImageKt.a(statusIconAndText.getFirst(), null, null, null, null, bVar2.a(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 12.0f), Alignment.Center), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer6, 262144, 0, 0, 2097118);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer4, 3128, 4);
                            composer4.endReplaceableGroup();
                        } else {
                            composer4.startReplaceableGroup(-573597097);
                            QQFTFileDetailItemVM qQFTFileDetailItemVM2 = QQFTFileDetailItemVM.this;
                            QQFlashTransferViewModel qQFlashTransferViewModel2 = qQFlashTransferViewModel;
                            if (qQFTFileDetailItemVM2.downloadStatus.getValue().intValue() != 1 && qQFTFileDetailItemVM2.downloadStatus.getValue().intValue() != 2 && qQFTFileDetailItemVM2.downloadStatus.getValue().intValue() != 4) {
                                if (qQFTFileDetailItemVM2.uploadStatus.getValue().intValue() == 1 || qQFTFileDetailItemVM2.uploadStatus.getValue().intValue() == 2 || qQFTFileDetailItemVM2.uploadStatus.getValue().intValue() == 4 || qQFTFileDetailItemVM2.fileStatus.getValue().intValue() == 4) {
                                    z16 = qQFTFileDetailItemVM2.uploadStatus.getValue().intValue() == 1 || qQFTFileDetailItemVM2.fileStatus.getValue().intValue() == 4;
                                    floatValue = qQFTFileDetailItemVM2.uploadProcess.getValue().floatValue();
                                    Pair pair = new Pair(Boolean.valueOf(z16), Float.valueOf(floatValue));
                                    QQFTFileItemViewKt.access$fileStatusProcess((Boolean) pair.getFirst(), (Float) pair.getSecond(), composer4, 0, 0);
                                    composer4.endReplaceableGroup();
                                } else {
                                    z16 = false;
                                    floatValue = 0.0f;
                                    Pair pair2 = new Pair(Boolean.valueOf(z16), Float.valueOf(floatValue));
                                    QQFTFileItemViewKt.access$fileStatusProcess((Boolean) pair2.getFirst(), (Float) pair2.getSecond(), composer4, 0, 0);
                                    composer4.endReplaceableGroup();
                                }
                            } else {
                                boolean z17 = qQFTFileDetailItemVM2.downloadStatus.getValue().intValue() == 1;
                                SnapshotStateMap<String, Float> snapshotStateMap = qQFlashTransferViewModel2.downloadProcessMap;
                                ab abVar3 = qQFTFileDetailItemVM2.fileDetail;
                                Float f18 = snapshotStateMap.get(abVar3 != null ? abVar3.f446151b : null);
                                if (f18 != null) {
                                    floatValue = f18.floatValue();
                                    z16 = z17;
                                    Pair pair22 = new Pair(Boolean.valueOf(z16), Float.valueOf(floatValue));
                                    QQFTFileItemViewKt.access$fileStatusProcess((Boolean) pair22.getFirst(), (Float) pair22.getSecond(), composer4, 0, 0);
                                    composer4.endReplaceableGroup();
                                } else {
                                    z16 = z17;
                                    floatValue = 0.0f;
                                    Pair pair222 = new Pair(Boolean.valueOf(z16), Float.valueOf(floatValue));
                                    QQFTFileItemViewKt.access$fileStatusProcess((Boolean) pair222.getFirst(), (Float) pair222.getSecond(), composer4, 0, 0);
                                    composer4.endReplaceableGroup();
                                }
                            }
                        }
                        f17 = 20.0f;
                        str = null;
                        abVar = abVar2;
                        composer3 = composer4;
                        TextKt.a(statusIconAndText.getSecond(), ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(12.0f), null, bp3.c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.e()), Float.valueOf(20.0f), null, null, null, null, an.d(an.INSTANCE.c()), null, 1, null, null, null, null, null, null, null, false, composer3, 1601600, 102236208, 0, 133886884);
                    } else {
                        f17 = 20.0f;
                        str = null;
                        abVar = abVar2;
                        composer3 = composer4;
                    }
                    composer3.endReplaceableGroup();
                    i B = ComposeLayoutPropUpdaterKt.B(i.INSTANCE);
                    StringBuilder sb5 = new StringBuilder();
                    if (QQFTFileDetailItemVM.this.shouldShowFileStatus()) {
                        str2 = "\u00b7";
                    } else {
                        str2 = "";
                    }
                    sb5.append(str2);
                    ab abVar4 = abVar;
                    if (abVar4 != null) {
                        long j3 = abVar4.f446164o;
                        if (j3 > 1073741824) {
                            StringBuilder sb6 = new StringBuilder();
                            float f19 = 1024;
                            i16 = 1;
                            double pow = Math.pow(10.0d, 1);
                            sb6.append(String.valueOf(Math.rint((((((float) j3) / f19) / f19) / f19) * pow) / pow));
                            sb6.append(" GB");
                            str3 = sb6.toString();
                        } else {
                            i16 = 1;
                            if (j3 > 1048576) {
                                StringBuilder sb7 = new StringBuilder();
                                float f26 = 1024;
                                double pow2 = Math.pow(10.0d, 1);
                                sb7.append(String.valueOf(Math.rint(((((float) j3) / f26) / f26) * pow2) / pow2));
                                sb7.append(" MB");
                                str3 = sb7.toString();
                            } else if (j3 > 1024) {
                                StringBuilder sb8 = new StringBuilder();
                                double pow3 = Math.pow(10.0d, 1);
                                sb8.append(String.valueOf(Math.rint((((float) j3) / 1024) * pow3) / pow3));
                                sb8.append(" KB");
                                str3 = sb8.toString();
                            } else {
                                str3 = j3 + " B";
                            }
                        }
                    } else {
                        i16 = 1;
                        str3 = str;
                    }
                    sb5.append(str3);
                    TextKt.a(sb5.toString(), B, null, QUIToken.color$default("text_secondary"), Float.valueOf(12.0f), null, bp3.c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.e()), Float.valueOf(f17), null, null, null, null, an.d(an.INSTANCE.c()), null, Integer.valueOf(i16), null, null, null, null, null, null, null, false, composer3, 1601600, 102236208, 0, 133886884);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 1573440, 57);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$fileStatusAndFileSizeUI$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTFileItemViewKt.access$fileStatusAndFileSizeUI(a.d.this, f16, iVar, qQFlashTransferViewModel, qQFTFileDetailItemVM, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void gridModeView(final int i3, final boolean z16, final float f16, final MutableState<Boolean> mutableState, final QQFlashTransferViewModel qQFlashTransferViewModel, final QQFTFileDetailItemVM qQFTFileDetailItemVM, Composer composer, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(914853430);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(914853430, i16, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.gridModeView (QQFTFileItemView.kt:105)");
        }
        final ab abVar = qQFTFileDetailItemVM.fileDetail;
        ColumnKt.a(ComposeLayoutPropUpdaterKt.w(ModifiersKt.b(i.INSTANCE, z16 ? 0.3f : 1.0f), f16), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 858895085, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$gridModeView$1
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
                        ComposerKt.traceEventStart(858895085, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.gridModeView.<anonymous> (QQFTFileItemView.kt:107)");
                    }
                    i.Companion companion = i.INSTANCE;
                    i w3 = ComposeLayoutPropUpdaterKt.w(companion, f16);
                    final float f17 = f16;
                    final QQFTFileDetailItemVM qQFTFileDetailItemVM2 = qQFTFileDetailItemVM;
                    final QQFlashTransferViewModel qQFlashTransferViewModel2 = qQFlashTransferViewModel;
                    final ab abVar2 = abVar;
                    final MutableState<Boolean> mutableState2 = mutableState;
                    final int i17 = i16;
                    final boolean z17 = z16;
                    BoxKt.a(w3, null, null, ComposableLambdaKt.composableLambda(composer3, 43978995, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$gridModeView$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer4, Integer num2) {
                            int i18;
                            h j3;
                            com.tencent.ntcompose.foundation.layout.b bVar2 = bVar;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i18 = (composer5.changed(bVar2) ? 4 : 2) | intValue2;
                            } else {
                                i18 = intValue2;
                            }
                            if ((i18 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(43978995, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.gridModeView.<anonymous>.<anonymous> (QQFTFileItemView.kt:108)");
                                }
                                i z18 = ComposeLayoutPropUpdaterKt.z(bVar2.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, f17 - 8.0f), Alignment.Center));
                                if (qQFTFileDetailItemVM2.isSelected.getValue().booleanValue()) {
                                    j3 = QUIToken.color$default("fill_standard_primary");
                                } else {
                                    j3 = h.INSTANCE.j();
                                }
                                uo3.b a16 = uo3.c.a(8.0f);
                                final QQFlashTransferViewModel qQFlashTransferViewModel3 = qQFlashTransferViewModel2;
                                final ab abVar3 = abVar2;
                                final MutableState<Boolean> mutableState3 = mutableState2;
                                final int i19 = i17;
                                final QQFTFileDetailItemVM qQFTFileDetailItemVM3 = qQFTFileDetailItemVM2;
                                final boolean z19 = z17;
                                final float f18 = f17;
                                SurfaceKt.a(z18, a16, null, j3, ComposableLambdaKt.composableLambda(composer5, -1627523087, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt.gridModeView.1.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                                ComposerKt.traceEventStart(-1627523087, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.gridModeView.<anonymous>.<anonymous>.<anonymous> (QQFTFileItemView.kt:116)");
                                            }
                                            QQFTFileItemViewKt.access$undownloadedAlertDialog(QQFlashTransferViewModel.this, abVar3, mutableState3, composer7, ((i19 >> 3) & 896) | 72);
                                            i elementVR = ModifierExtKt.elementVR(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.z(i.INSTANCE), 0.0f, 1, null), "em_bas_file_entry", QQFTReportUtil.INSTANCE.getDetailItemParams(QQFlashTransferViewModel.this, abVar3));
                                            final QQFlashTransferViewModel qQFlashTransferViewModel4 = QQFlashTransferViewModel.this;
                                            final QQFTFileDetailItemVM qQFTFileDetailItemVM4 = qQFTFileDetailItemVM3;
                                            final boolean z26 = z19;
                                            final MutableState<Boolean> mutableState4 = mutableState3;
                                            i w16 = ModifiersKt.w(ViewEventPropUpdaterKt.d(elementVR, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt.gridModeView.1.1.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    QQFTFileItemViewKt.access$handleClickItem(QQFlashTransferViewModel.this, qQFTFileDetailItemVM4, z26, mutableState4);
                                                    return Unit.INSTANCE;
                                                }
                                            }, 3, null), QUIToken.color$default("overlay_surface_bg"));
                                            Alignment alignment = Alignment.Center;
                                            final QQFTFileDetailItemVM qQFTFileDetailItemVM5 = qQFTFileDetailItemVM3;
                                            final boolean z27 = z19;
                                            final int i26 = i19;
                                            final float f19 = f18;
                                            final QQFlashTransferViewModel qQFlashTransferViewModel5 = QQFlashTransferViewModel.this;
                                            BoxKt.a(w16, alignment, null, ComposableLambdaKt.composableLambda(composer7, 1836671787, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt.gridModeView.1.1.1.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar3, Composer composer8, Integer num4) {
                                                    int i27;
                                                    String str;
                                                    com.tencent.ntcompose.foundation.layout.b bVar4 = bVar3;
                                                    Composer composer9 = composer8;
                                                    int intValue4 = num4.intValue();
                                                    if ((intValue4 & 14) == 0) {
                                                        i27 = (composer9.changed(bVar4) ? 4 : 2) | intValue4;
                                                    } else {
                                                        i27 = intValue4;
                                                    }
                                                    if ((i27 & 91) == 18 && composer9.getSkipping()) {
                                                        composer9.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1836671787, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.gridModeView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTFileItemView.kt:125)");
                                                        }
                                                        i.Companion companion2 = i.INSTANCE;
                                                        i a17 = bVar4.a(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null), Alignment.Center);
                                                        final float f26 = f19;
                                                        final QQFlashTransferViewModel qQFlashTransferViewModel6 = qQFlashTransferViewModel5;
                                                        final QQFTFileDetailItemVM qQFTFileDetailItemVM6 = QQFTFileDetailItemVM.this;
                                                        final int i28 = i26;
                                                        BoxKt.a(a17, null, null, ComposableLambdaKt.composableLambda(composer9, -933349147, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt.gridModeView.1.1.1.2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar5, Composer composer10, Integer num5) {
                                                                int i29;
                                                                com.tencent.ntcompose.foundation.layout.b bVar6 = bVar5;
                                                                Composer composer11 = composer10;
                                                                int intValue5 = num5.intValue();
                                                                if ((intValue5 & 14) == 0) {
                                                                    i29 = (composer11.changed(bVar6) ? 4 : 2) | intValue5;
                                                                } else {
                                                                    i29 = intValue5;
                                                                }
                                                                if ((i29 & 91) == 18 && composer11.getSkipping()) {
                                                                    composer11.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-933349147, intValue5, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.gridModeView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTFileItemView.kt:128)");
                                                                    }
                                                                    Alignment.Horizontal b16 = Alignment.INSTANCE.b();
                                                                    i a18 = bVar6.a(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), Alignment.Center);
                                                                    final float f27 = f26;
                                                                    final QQFlashTransferViewModel qQFlashTransferViewModel7 = qQFlashTransferViewModel6;
                                                                    final QQFTFileDetailItemVM qQFTFileDetailItemVM7 = qQFTFileDetailItemVM6;
                                                                    final int i36 = i28;
                                                                    ColumnKt.a(a18, null, b16, null, ComposableLambdaKt.composableLambda(composer11, -796169138, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt.gridModeView.1.1.1.2.1.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(3);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function3
                                                                        public final Unit invoke(d dVar2, Composer composer12, Integer num6) {
                                                                            int i37;
                                                                            d dVar3 = dVar2;
                                                                            Composer composer13 = composer12;
                                                                            int intValue6 = num6.intValue();
                                                                            if ((intValue6 & 14) == 0) {
                                                                                i37 = (composer13.changed(dVar3) ? 4 : 2) | intValue6;
                                                                            } else {
                                                                                i37 = intValue6;
                                                                            }
                                                                            if ((i37 & 91) == 18 && composer13.getSkipping()) {
                                                                                composer13.skipToGroupEnd();
                                                                            } else {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(-796169138, intValue6, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.gridModeView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTFileItemView.kt:132)");
                                                                                }
                                                                                i.Companion companion3 = i.INSTANCE;
                                                                                i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion3, f27 - 72), 0.0f, 8.0f, 0.0f, 0.0f, 13, null);
                                                                                final float f28 = f27;
                                                                                final QQFTFileDetailItemVM qQFTFileDetailItemVM8 = qQFTFileDetailItemVM7;
                                                                                final int i38 = i36;
                                                                                BoxKt.a(n3, null, null, ComposableLambdaKt.composableLambda(composer13, -1776319608, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt.gridModeView.1.1.1.2.1.1.1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(3);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function3
                                                                                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar7, Composer composer14, Integer num7) {
                                                                                        int i39;
                                                                                        com.tencent.ntcompose.foundation.layout.b bVar8 = bVar7;
                                                                                        Composer composer15 = composer14;
                                                                                        int intValue7 = num7.intValue();
                                                                                        if ((intValue7 & 14) == 0) {
                                                                                            i39 = (composer15.changed(bVar8) ? 4 : 2) | intValue7;
                                                                                        } else {
                                                                                            i39 = intValue7;
                                                                                        }
                                                                                        if ((i39 & 91) == 18 && composer15.getSkipping()) {
                                                                                            composer15.skipToGroupEnd();
                                                                                        } else {
                                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                                ComposerKt.traceEventStart(-1776319608, intValue7, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.gridModeView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTFileItemView.kt:135)");
                                                                                            }
                                                                                            i.Companion companion4 = i.INSTANCE;
                                                                                            QQFTFileThumbnailViewKt.m125QQFTFileThumbnailViewCvonfEE(ComposeLayoutPropUpdaterKt.u(companion4, f28 - 72), com.tencent.ntcompose.material.h.INSTANCE.c(), bVar8.a(ComposeLayoutPropUpdaterKt.u(companion4, 36.0f), Alignment.Center), qQFTFileDetailItemVM8, composer15, ((i38 >> 6) & 7168) | PlayerResources.ViewId.EXTENDED_VIEW_BTN_NORMAL_BUTTON);
                                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                                ComposerKt.traceEventEnd();
                                                                                            }
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                }), composer13, 3080, 6);
                                                                                i s16 = ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.j(companion3, 0.0f, 1, null), 8.0f, 0.0f, 8.0f, 0.0f, 10, null);
                                                                                Alignment alignment2 = Alignment.Center;
                                                                                final QQFTFileDetailItemVM qQFTFileDetailItemVM9 = qQFTFileDetailItemVM7;
                                                                                BoxKt.a(s16, alignment2, null, ComposableLambdaKt.composableLambda(composer13, -631011855, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt.gridModeView.1.1.1.2.1.1.2
                                                                                    {
                                                                                        super(3);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function3
                                                                                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar7, Composer composer14, Integer num7) {
                                                                                        Composer composer15 = composer14;
                                                                                        int intValue7 = num7.intValue();
                                                                                        if ((intValue7 & 81) == 16 && composer15.getSkipping()) {
                                                                                            composer15.skipToGroupEnd();
                                                                                        } else {
                                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                                ComposerKt.traceEventStart(-631011855, intValue7, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.gridModeView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTFileItemView.kt:143)");
                                                                                            }
                                                                                            i n16 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 11.5f, 0.0f, 0.0f, 13, null);
                                                                                            String fileName = QQFTFileDetailItemVM.this.getFileName();
                                                                                            h color$default = QUIToken.color$default("text_primary");
                                                                                            int a19 = ai.INSTANCE.a();
                                                                                            TextKt.a(fileName, n16, null, color$default, Float.valueOf(14.0f), null, bp3.c.INSTANCE.e(), null, null, null, ai.f(a19), null, null, null, null, null, an.d(an.INSTANCE.c()), null, 2, null, null, null, null, null, null, null, false, composer15, 1601600, 102236160, 0, 133888932);
                                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                                ComposerKt.traceEventEnd();
                                                                                            }
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                }), composer13, 3128, 4);
                                                                                QQFTFileItemViewKt.access$fileStatusAndFileSizeUI(com.tencent.ntcompose.foundation.layout.base.a.f339245a.b(), f27 - 12, dVar3.b(ComposeLayoutPropUpdaterKt.n(companion3, 0.0f, 2.0f, 0.0f, 3.5f, 5, null), Alignment.INSTANCE.b()), qQFlashTransferViewModel7, qQFTFileDetailItemVM7, composer13, ((i36 >> 3) & 57344) | g.f247768x1);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }), composer11, 24584, 10);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer9, 3080, 6);
                                                        i u16 = ComposeLayoutPropUpdaterKt.u(ComposeLayoutPropUpdaterKt.s(bVar4.a(companion2, Alignment.TopEnd), 4.0f, 0.0f, 0.0f, 4.0f, 6, null), 32.0f);
                                                        if (k.a(c.f117352a)) {
                                                            str = "0S200MNJT807V3GE";
                                                        } else {
                                                            str = "0M2003OIIM08YV9M";
                                                        }
                                                        i elementVR2 = ModifierExtKt.elementVR(u16, "em_bas_check", DTReportConstKt.getDTBaseParams(str));
                                                        final boolean z28 = z27;
                                                        final QQFlashTransferViewModel qQFlashTransferViewModel7 = qQFlashTransferViewModel5;
                                                        final QQFTFileDetailItemVM qQFTFileDetailItemVM7 = QQFTFileDetailItemVM.this;
                                                        QQFTCheckBoxViewKt.QQFTCheckBoxView(ViewEventPropUpdaterKt.d(elementVR2, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt.gridModeView.1.1.1.2.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                if (z28) {
                                                                    KLog.INSTANCE.d("QQFTFileItemView", "checkBox clickable return");
                                                                } else {
                                                                    QQFTFileItemViewKt.handleCheckItem(qQFlashTransferViewModel7, qQFTFileDetailItemVM7);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }, 3, null), 0.0f, QQFTFileDetailItemVM.this.isSelected.getValue().booleanValue(), null, null, z27, composer9, ((i26 << 12) & 458752) | 8, 26);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer7, 3128, 4);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 28680, 4);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3080, 6);
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.k(companion, 12.0f), f16), composer3, 8, 0);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$gridModeView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTFileItemViewKt.gridModeView(i3, z16, f16, mutableState, qQFlashTransferViewModel, qQFTFileDetailItemVM, composer2, i16 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void imageGridMode(final int i3, final boolean z16, final float f16, final MutableState<Boolean> mutableState, final QQFlashTransferViewModel qQFlashTransferViewModel, final QQFTFileDetailItemVM qQFTFileDetailItemVM, Composer composer, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(-602803044);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-602803044, i16, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.imageGridMode (QQFTFileItemView.kt:548)");
        }
        final ab abVar = qQFTFileDetailItemVM.fileDetail;
        BoxKt.a(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.u(ModifiersKt.b(i.INSTANCE, z16 ? 0.3f : 1.0f), f16), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$imageGridMode$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                QQFTFileItemViewKt.access$handleClickItem(QQFlashTransferViewModel.this, qQFTFileDetailItemVM, z16, mutableState);
                return Unit.INSTANCE;
            }
        }, 3, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 12247126, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$imageGridMode$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num) {
                int i17;
                com.tencent.ntcompose.foundation.layout.b bVar2 = bVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i17 = (composer3.changed(bVar2) ? 4 : 2) | intValue;
                } else {
                    i17 = intValue;
                }
                if ((i17 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(12247126, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.imageGridMode.<anonymous> (QQFTFileItemView.kt:558)");
                    }
                    i.Companion companion = i.INSTANCE;
                    i u16 = ComposeLayoutPropUpdaterKt.u(companion, f16 - 1);
                    final float f17 = f16;
                    final QQFTFileDetailItemVM qQFTFileDetailItemVM2 = qQFTFileDetailItemVM;
                    final int i18 = i16;
                    BoxKt.a(u16, null, null, ComposableLambdaKt.composableLambda(composer3, -1153411440, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$imageGridMode$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar3, Composer composer4, Integer num2) {
                            int i19;
                            com.tencent.ntcompose.foundation.layout.b bVar4 = bVar3;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i19 = (composer5.changed(bVar4) ? 4 : 2) | intValue2;
                            } else {
                                i19 = intValue2;
                            }
                            if ((i19 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1153411440, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.imageGridMode.<anonymous>.<anonymous> (QQFTFileItemView.kt:560)");
                                }
                                i.Companion companion2 = i.INSTANCE;
                                QQFTFileThumbnailViewKt.m125QQFTFileThumbnailViewCvonfEE(bVar4.a(ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null), Alignment.TopStart), com.tencent.ntcompose.material.h.INSTANCE.a(), bVar4.a(ComposeLayoutPropUpdaterKt.u(companion2, f17 / 3), Alignment.Center), qQFTFileDetailItemVM2, composer5, ((i18 >> 6) & 7168) | PlayerResources.ViewId.EXTENDED_VIEW_BTN_NORMAL_BUTTON);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3080, 6);
                    i a16 = bVar2.a(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.k(companion, 26.0f), 28.0f), Alignment.TopEnd);
                    final boolean z17 = z16;
                    final QQFlashTransferViewModel qQFlashTransferViewModel2 = qQFlashTransferViewModel;
                    final QQFTFileDetailItemVM qQFTFileDetailItemVM3 = qQFTFileDetailItemVM;
                    QQFTCheckBoxViewKt.QQFTCheckBoxView(ViewEventPropUpdaterKt.d(a16, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$imageGridMode$2.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            if (z17) {
                                KLog.INSTANCE.d("QQFTFileItemView", "checkBox clickable return");
                            } else {
                                QQFTFileItemViewKt.handleCheckItem(qQFlashTransferViewModel2, qQFTFileDetailItemVM3);
                            }
                            return Unit.INSTANCE;
                        }
                    }, 3, null), 0.0f, qQFTFileDetailItemVM.isSelected.getValue().booleanValue(), QUIToken.color$default("fill_allblack_medium"), QUIToken.color$default("border_superlight"), z16, composer3, ((i16 << 12) & 458752) | 36872, 2);
                    QQFTFileItemViewKt.access$undownloadedAlertDialog(qQFlashTransferViewModel, abVar, mutableState, composer3, ((i16 >> 3) & 896) | 72);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$imageGridMode$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTFileItemViewKt.imageGridMode(i3, z16, f16, mutableState, qQFlashTransferViewModel, qQFTFileDetailItemVM, composer2, i16 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void listViewMode(final int i3, final boolean z16, final float f16, final MutableState<Boolean> mutableState, final QQFlashTransferViewModel qQFlashTransferViewModel, final QQFTFileDetailItemVM qQFTFileDetailItemVM, Composer composer, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(897832158);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(897832158, i16, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.listViewMode (QQFTFileItemView.kt:191)");
        }
        final ab abVar = qQFTFileDetailItemVM.fileDetail;
        i.Companion companion = i.INSTANCE;
        i k3 = ComposeLayoutPropUpdaterKt.k(ModifiersKt.b(companion, z16 ? 0.3f : 1.0f), f16);
        c cVar = c.f117352a;
        RowKt.a(ModifiersKt.w(ViewEventPropUpdaterKt.d(ModifierExtKt.elementVR(ComposeLayoutPropUpdaterKt.w(k3, cVar.g().getPageData().m()), "em_bas_file_entry", QQFTReportUtil.INSTANCE.getDetailItemParams(qQFlashTransferViewModel, abVar)), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$listViewMode$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                QQFTFileItemViewKt.access$handleClickItem(QQFlashTransferViewModel.this, qQFTFileDetailItemVM, z16, mutableState);
                return Unit.INSTANCE;
            }
        }, 3, null), QUIToken.color$default("overlay_surface_bg")), null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -484424192, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$listViewMode$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                int i17;
                String str;
                n nVar2 = nVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i17 = (composer3.changed(nVar2) ? 4 : 2) | intValue;
                } else {
                    i17 = intValue;
                }
                if ((i17 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-484424192, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.listViewMode.<anonymous> (QQFTFileItemView.kt:198)");
                    }
                    i.Companion companion2 = i.INSTANCE;
                    i s16 = ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(companion2, f16), 16.0f, 0.0f, 14.0f, 0.0f, 10, null);
                    if (k.a(c.f117352a)) {
                        str = "0S200MNJT807V3GE";
                    } else {
                        str = "0M2003OIIM08YV9M";
                    }
                    i elementVR = ModifierExtKt.elementVR(s16, "em_bas_check", DTReportConstKt.getDTBaseParams(str));
                    final boolean z17 = z16;
                    final QQFlashTransferViewModel qQFlashTransferViewModel2 = qQFlashTransferViewModel;
                    final QQFTFileDetailItemVM qQFTFileDetailItemVM2 = qQFTFileDetailItemVM;
                    QQFTCheckBoxViewKt.QQFTCheckBoxView(ViewEventPropUpdaterKt.d(elementVR, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$listViewMode$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            if (z17) {
                                KLog.INSTANCE.d("QQFTFileItemView", "checkBox clickable return");
                            } else {
                                QQFTFileItemViewKt.handleCheckItem(qQFlashTransferViewModel2, qQFTFileDetailItemVM2);
                            }
                            return Unit.INSTANCE;
                        }
                    }, 3, null), 0.0f, qQFTFileDetailItemVM.isSelected.getValue().booleanValue(), null, null, z16, composer3, ((i16 << 12) & 458752) | 8, 26);
                    i a16 = nVar2.a(nVar2.b(ComposeLayoutPropUpdaterKt.k(companion2, f16), Alignment.INSTANCE.c()), 1.0f);
                    final float f17 = f16;
                    final QQFlashTransferViewModel qQFlashTransferViewModel3 = qQFlashTransferViewModel;
                    final boolean z18 = z16;
                    final QQFTFileDetailItemVM qQFTFileDetailItemVM3 = qQFTFileDetailItemVM;
                    final int i18 = i16;
                    RowKt.a(a16, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, -1529345118, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$listViewMode$2.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        /* JADX WARN: Removed duplicated region for block: B:32:0x0178  */
                        @Override // kotlin.jvm.functions.Function3
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Unit invoke(n nVar3, Composer composer4, Integer num2) {
                            int i19;
                            String str2;
                            n nVar4 = nVar3;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i19 = (composer5.changed(nVar4) ? 4 : 2) | intValue2;
                            } else {
                                i19 = intValue2;
                            }
                            if ((i19 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1529345118, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.listViewMode.<anonymous>.<anonymous> (QQFTFileItemView.kt:212)");
                                }
                                i.Companion companion3 = i.INSTANCE;
                                i u16 = ComposeLayoutPropUpdaterKt.u(companion3, f17 * 0.75f);
                                Alignment.Companion companion4 = Alignment.INSTANCE;
                                i q16 = ModifiersKt.q(nVar4.b(u16, companion4.c()), uo3.c.a(4.0f));
                                final float f18 = f17;
                                final QQFTFileDetailItemVM qQFTFileDetailItemVM4 = qQFTFileDetailItemVM3;
                                final int i26 = i18;
                                BoxKt.a(q16, null, null, ComposableLambdaKt.composableLambda(composer5, -556766296, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt.listViewMode.2.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer6, Integer num3) {
                                        int i27;
                                        com.tencent.ntcompose.foundation.layout.b bVar2 = bVar;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 14) == 0) {
                                            i27 = (composer7.changed(bVar2) ? 4 : 2) | intValue3;
                                        } else {
                                            i27 = intValue3;
                                        }
                                        if ((i27 & 91) == 18 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-556766296, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.listViewMode.<anonymous>.<anonymous>.<anonymous> (QQFTFileItemView.kt:217)");
                                            }
                                            i.Companion companion5 = i.INSTANCE;
                                            QQFTFileThumbnailViewKt.m125QQFTFileThumbnailViewCvonfEE(ComposeLayoutPropUpdaterKt.u(companion5, f18 * 0.75f), com.tencent.ntcompose.material.h.INSTANCE.a(), bVar2.a(ComposeLayoutPropUpdaterKt.u(companion5, (f18 * 0.75f) / 2), Alignment.Center), qQFTFileDetailItemVM4, composer7, ((i26 >> 6) & 7168) | PlayerResources.ViewId.EXTENDED_VIEW_BTN_NORMAL_BUTTON);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 3080, 6);
                                i n3 = ComposeLayoutPropUpdaterKt.n(nVar4.a(nVar4.b(companion3, companion4.c()), 1.0f), 12.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                final QQFTFileDetailItemVM qQFTFileDetailItemVM5 = qQFTFileDetailItemVM3;
                                final QQFlashTransferViewModel qQFlashTransferViewModel4 = qQFlashTransferViewModel3;
                                final int i27 = i18;
                                ColumnKt.a(n3, null, null, null, ComposableLambdaKt.composableLambda(composer5, 1426280409, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt.listViewMode.2.2.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(d dVar, Composer composer6, Integer num3) {
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1426280409, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.listViewMode.<anonymous>.<anonymous>.<anonymous> (QQFTFileItemView.kt:225)");
                                            }
                                            i.Companion companion5 = i.INSTANCE;
                                            i j3 = ComposeLayoutPropUpdaterKt.j(companion5, 0.0f, 1, null);
                                            String fileName = QQFTFileDetailItemVM.this.getFileName();
                                            h color$default = QUIToken.color$default("text_primary");
                                            int e16 = ai.INSTANCE.e();
                                            TextKt.a(fileName, j3, null, color$default, Float.valueOf(17.0f), null, bp3.c.INSTANCE.e(), null, null, null, ai.f(e16), Float.valueOf(24.0f), null, null, null, null, an.d(an.INSTANCE.c()), null, 1, null, null, null, null, null, null, null, false, composer7, 1601600, 102236208, 0, 133886884);
                                            QQFTFileItemViewKt.access$fileStatusAndFileSizeUI(com.tencent.ntcompose.foundation.layout.base.a.f339245a.g(), GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(c.f117352a), ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(companion5, 0.0f, 1, null), 0.0f, 2.0f, 0.0f, 0.0f, 13, null), qQFlashTransferViewModel4, QQFTFileDetailItemVM.this, composer7, ((i27 >> 3) & 57344) | g.f247768x1);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 24584, 14);
                                if (qQFlashTransferViewModel3.selectFilesToDownload.size() == 0) {
                                    c cVar2 = c.f117352a;
                                    if (!k.a(cVar2)) {
                                        composer5.startReplaceableGroup(600456068);
                                        i A = ModifiersKt.A(nVar4.b(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion3, 56.0f), f17), companion4.c()), 0.5f, 0.0f, 2, null);
                                        if (k.a(cVar2)) {
                                            str2 = "0S200MNJT807V3GE";
                                        } else {
                                            str2 = "0M2003OIIM08YV9M";
                                        }
                                        i elementVR2 = ModifierExtKt.elementVR(A, WinkDaTongReportConstant.ElementId.EM_BAS_MORE, DTReportConstKt.getDTBaseParams(str2));
                                        Boolean valueOf = Boolean.valueOf(z18);
                                        final QQFTFileDetailItemVM qQFTFileDetailItemVM6 = qQFTFileDetailItemVM3;
                                        final boolean z19 = z18;
                                        composer5.startReplaceableGroup(511388516);
                                        boolean changed = composer5.changed(valueOf) | composer5.changed(qQFTFileDetailItemVM6);
                                        Object rememberedValue = composer5.rememberedValue();
                                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$listViewMode$2$2$3$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    if (z19) {
                                                        KLog.INSTANCE.d("QQFTFileItemView", "checkBox clickable return");
                                                    } else {
                                                        QQFTFileDetailItemVM qQFTFileDetailItemVM7 = qQFTFileDetailItemVM6;
                                                        if (qQFTFileDetailItemVM7.fileStatus.getValue().intValue() == 4 || qQFTFileDetailItemVM7.fileStatus.getValue().intValue() == 5) {
                                                            KLog.INSTANCE.d("QQFTFileItemView", "checkBox cannot click because Security");
                                                        } else {
                                                            ab abVar2 = qQFTFileDetailItemVM6.fileDetail;
                                                            if (abVar2 != null) {
                                                                QQFlashTransferKuiklyModule companion5 = QQFlashTransferKuiklyModule.Companion.getInstance();
                                                                companion5.toNative(true, "shareFile", companion5.createParamsWithFileInfo(abVar2).toString(), null, false);
                                                            }
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer5.updateRememberedValue(rememberedValue);
                                        }
                                        composer5.endReplaceableGroup();
                                        BoxKt.a(ViewEventPropUpdaterKt.d(elementVR2, false, null, (Function1) rememberedValue, 3, null), null, null, ComposableSingletons$QQFTFileItemViewKt.f131lambda1, composer5, 3080, 6);
                                        composer5.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }
                                composer5.startReplaceableGroup(600457328);
                                BoxKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion3, 16.0f), f17), null, null, null, composer5, 8, 14);
                                composer5.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 196616, 30);
                    QQFTFileItemViewKt.access$undownloadedAlertDialog(qQFlashTransferViewModel, abVar, mutableState, composer3, ((i16 >> 3) & 896) | 72);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 196616, 30);
        if (i3 != qQFlashTransferViewModel.feedListViewModel.feedCardViewModelList.size() - 1) {
            RowKt.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.w(companion, cVar.g().getPageData().m()), 0.0f, 0.0f, 16.0f, 0.0f, 11, null), null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -401512869, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$listViewMode$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(n nVar, Composer composer2, Integer num) {
                    int i17;
                    n nVar2 = nVar;
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 14) == 0) {
                        i17 = (composer3.changed(nVar2) ? 4 : 2) | intValue;
                    } else {
                        i17 = intValue;
                    }
                    if ((i17 & 91) == 18 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-401512869, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.listViewMode.<anonymous> (QQFTFileItemView.kt:286)");
                        }
                        i.Companion companion2 = i.INSTANCE;
                        SurfaceKt.a(ModifiersKt.R(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, (f16 * 0.75f) + 62), 0.5f), false), null, null, null, ComposableSingletons$QQFTFileItemViewKt.f132lambda2, composer3, 24584, 14);
                        SurfaceKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(nVar2.a(companion2, 1.0f), 0.5f), QUIToken.color$default("border_standard")), null, null, null, ComposableSingletons$QQFTFileItemViewKt.f133lambda3, composer3, 24584, 14);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 196616, 30);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt$listViewMode$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTFileItemViewKt.listViewMode(i3, z16, f16, mutableState, qQFlashTransferViewModel, qQFTFileDetailItemVM, composer2, i16 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
