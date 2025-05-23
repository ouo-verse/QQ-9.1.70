package com.tencent.hippykotlin.demo.pages.qqflash_transfer.model;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import bp3.a;
import bp3.b;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel;
import com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.center.QQFTCenterEmptyCardVM;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.center.QQFTCenterFileSetCardVM;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.center.QQFTCenterFilterCardVM;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.ntcompose.foundation.scheduler.SchedulerKt;
import com.tencent.ntcompose.lifecycle.viewmodel.g;
import com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService;
import defpackage.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import ws3.br;
import ws3.bs;
import ws3.bt;
import ws3.cj;
import ws3.cl;
import ws3.cm;
import ws3.cz;
import ws3.dm;
import ws3.dr;
import ws3.eo;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQTransferCenterViewModel extends g {
    public final Lazy bottomEmptyCardVM$delegate;
    public final Lazy emptyCardVM$delegate;
    public final ComposeFeedListViewModel feedListViewModel;
    public String fileSetDeleteSuccessNotifyListener;
    public final Map<String, QQFTCenterFileSetCardVM> fileSetMap;
    public final QQTransferCenterViewModel$fileSetSimpleStatusListener$1 fileSetSimpleStatusListener;
    public final MutableState<Float> fileSetUploadProgress;
    public final MutableState<Integer> fileSetUploadStatus;
    public final MutableState<String> fileSetUploadStatusContent;
    public final Lazy filterCardVM$delegate;
    public final MutableState<Boolean> forceShowEmpty;
    public final MutableState<Integer> hasShownGuide;
    public final MutableState<Boolean> hasTransferHistory;
    public boolean isLoadDataEnd;
    public boolean isLoadDataError;
    public final String kTag = "QQTransferCenterViewModel";
    public final List<String> monitoringArray;
    public String notifyListener;
    public byte[] paginationInfo;
    public final List<QQFTShareItem> shareItems;
    public MutableState<Boolean> shouldShowShareView;
    public boolean showTopEmptyCard;
    public long totalUploadSize;
    public final MutableState<a> uploadShareLinkContent;
    public QQTransferCenterViewModel$addFileSetUploadListener$uploadListener$1 uploadStatusListener;
    public long uploadTimeRemain;
    public long uploadedCount;
    public br uploadedFileSet;
    public String uploadedFileSetShareLink;
    public long uploadedSize;

    /* JADX WARN: Type inference failed for: r0v17, types: [com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel$fileSetSimpleStatusListener$1] */
    public QQTransferCenterViewModel() {
        MutableState<Integer> mutableStateOf$default;
        MutableState<Boolean> mutableStateOf$default2;
        MutableState<Boolean> mutableStateOf$default3;
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        MutableState<Boolean> mutableStateOf$default4;
        List<QQFTShareItem> listOf;
        MutableState<Integer> mutableStateOf$default5;
        MutableState<a> mutableStateOf$default6;
        MutableState<String> mutableStateOf$default7;
        MutableState<Float> mutableStateOf$default8;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(1, null, 2, null);
        this.hasShownGuide = mutableStateOf$default;
        Boolean bool = Boolean.FALSE;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.forceShowEmpty = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        this.hasTransferHistory = mutableStateOf$default3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQFTCenterEmptyCardVM>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel$emptyCardVM$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final QQFTCenterEmptyCardVM invoke() {
                return new QQFTCenterEmptyCardVM(QQTransferCenterViewModel.this, false);
            }
        });
        this.emptyCardVM$delegate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<QQFTCenterEmptyCardVM>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel$bottomEmptyCardVM$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final QQFTCenterEmptyCardVM invoke() {
                return new QQFTCenterEmptyCardVM(QQTransferCenterViewModel.this, true);
            }
        });
        this.bottomEmptyCardVM$delegate = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<QQFTCenterFilterCardVM>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel$filterCardVM$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final QQFTCenterFilterCardVM invoke() {
                return new QQFTCenterFilterCardVM(QQTransferCenterViewModel.this);
            }
        });
        this.filterCardVM$delegate = lazy3;
        this.feedListViewModel = new ComposeFeedListViewModel(new Function1<Function2<? super Boolean, ? super Boolean, ? extends Unit>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel$feedListViewModel$1
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Function2<? super Boolean, ? super Boolean, ? extends Unit> function2) {
                Function2<? super Boolean, ? super Boolean, ? extends Unit> function22 = function2;
                KLog.INSTANCE.d(QQTransferCenterViewModel.this.kTag, "OnLoadMoreCallback");
                QQTransferCenterViewModel qQTransferCenterViewModel = QQTransferCenterViewModel.this;
                boolean z16 = qQTransferCenterViewModel.isLoadDataEnd;
                if (z16) {
                    function22.invoke(Boolean.valueOf(z16), Boolean.valueOf(QQTransferCenterViewModel.this.isLoadDataError));
                } else {
                    qQTransferCenterViewModel.requestFileSetList(qQTransferCenterViewModel.paginationInfo, function22);
                }
                return Unit.INSTANCE;
            }
        });
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.shouldShowShareView = mutableStateOf$default4;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new QQFTShareItem[]{QQFLashTransferShareModelKt.ShareItemCopyLink, QQFLashTransferShareModelKt.ShareItemSendToQQ, QQFLashTransferShareModelKt.ShareItemSendToWechatFriend, QQFLashTransferShareModelKt.ShareItemQRCode});
        this.shareItems = listOf;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.fileSetUploadStatus = mutableStateOf$default5;
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(b.a(""), null, 2, null);
        this.uploadShareLinkContent = mutableStateOf$default6;
        mutableStateOf$default7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("\u4e0a\u4f20\u51c6\u5907\u4e2d", null, 2, null);
        this.fileSetUploadStatusContent = mutableStateOf$default7;
        mutableStateOf$default8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
        this.fileSetUploadProgress = mutableStateOf$default8;
        this.fileSetMap = new LinkedHashMap();
        this.monitoringArray = new ArrayList();
        this.fileSetSimpleStatusListener = new cz() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel$fileSetSimpleStatusListener$1
            @Override // ws3.cz
            public final void onFileSetStatusUpdate(final List<eo> list) {
                final QQTransferCenterViewModel qQTransferCenterViewModel = QQTransferCenterViewModel.this;
                SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel$fileSetSimpleStatusListener$1$onFileSetStatusUpdate$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Type inference failed for: r3v9, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.center.QQFTCenterFileSetCardVM>] */
                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        Object firstOrNull;
                        bt btVar;
                        KLog kLog = KLog.INSTANCE;
                        String str = QQTransferCenterViewModel.this.kTag;
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onFileSetStatusUpdate count:");
                        m3.append(list.size());
                        m3.append(" fileSetId:");
                        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                        eo eoVar = (eo) firstOrNull;
                        NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(m3, (eoVar == null || (btVar = eoVar.f446343a) == null) ? null : btVar.f446204a, kLog, str);
                        int size = list.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            eo eoVar2 = list.get(i3);
                            QQFTCenterFileSetCardVM qQFTCenterFileSetCardVM = (QQFTCenterFileSetCardVM) QQTransferCenterViewModel.this.fileSetMap.get(eoVar2.f446343a.f446204a);
                            if (qQFTCenterFileSetCardVM != null) {
                                KLog kLog2 = KLog.INSTANCE;
                                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("handleFileSetStatusUpdate fileSetId:");
                                m16.append(eoVar2.f446343a.f446204a);
                                m16.append(" completedFileCount:");
                                StringBuilder m17 = QQFlashTransferViewModel$fetchCompressedFileFolder$2$$ExternalSyntheticOutline0.m(eoVar2.f446345c, QQFlashTransferViewModel$fetchCompressedFileFolder$2$$ExternalSyntheticOutline0.m(eoVar2.f446344b, m16, " completedFileSize:"), "status:");
                                m17.append(eoVar2.f446348f);
                                m17.append(" speed:");
                                NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0.m(QQFlashTransferViewModel$fetchCompressedFileFolder$2$$ExternalSyntheticOutline0.m(eoVar2.f446353k, QQFlashTransferViewModel$fetchCompressedFileFolder$2$$ExternalSyntheticOutline0.m(eoVar2.f446352j, m17, " remain:"), " isLocal:"), eoVar2.f446354l, kLog2, "QQFTCenterFileSetCardVM");
                                qQFTCenterFileSetCardVM.simpleStatusInfo.setValue(eoVar2);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
            }
        };
    }

    public static final void access$updateFileSetUploadStatusContent(QQTransferCenterViewModel qQTransferCenterViewModel) {
        if (qQTransferCenterViewModel.fileSetUploadStatus.getValue().intValue() == 2) {
            if (qQTransferCenterViewModel.totalUploadSize == 0) {
                qQTransferCenterViewModel.fileSetUploadStatusContent.setValue("\u4e0a\u4f20\u51c6\u5907\u4e2d");
                return;
            }
            MutableState<String> mutableState = qQTransferCenterViewModel.fileSetUploadStatusContent;
            StringBuilder sb5 = new StringBuilder();
            l lVar = l.f413536a;
            sb5.append(lVar.b(qQTransferCenterViewModel.uploadedSize));
            sb5.append(lVar.c(qQTransferCenterViewModel.uploadedSize));
            sb5.append('/');
            sb5.append(lVar.b(qQTransferCenterViewModel.totalUploadSize));
            sb5.append(lVar.c(qQTransferCenterViewModel.totalUploadSize));
            sb5.append(" \u9884\u8ba1");
            sb5.append(lVar.a(qQTransferCenterViewModel.uploadTimeRemain));
            mutableState.setValue(sb5.toString());
            return;
        }
        if (qQTransferCenterViewModel.fileSetUploadStatus.getValue().intValue() == 6) {
            qQTransferCenterViewModel.fileSetUploadStatusContent.setValue("\u4e0a\u4f20\u5931\u8d25");
            return;
        }
        if (qQTransferCenterViewModel.fileSetUploadStatus.getValue().intValue() != 4 && qQTransferCenterViewModel.fileSetUploadStatus.getValue().intValue() != 3) {
            if (qQTransferCenterViewModel.fileSetUploadStatus.getValue().intValue() == 5) {
                qQTransferCenterViewModel.fileSetUploadStatusContent.setValue("\u4e0a\u4f20\u6682\u505c");
                return;
            }
            return;
        }
        MutableState<String> mutableState2 = qQTransferCenterViewModel.fileSetUploadStatusContent;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(qQTransferCenterViewModel.uploadedCount);
        sb6.append("\u4e2a\u6587\u4ef6 ");
        l lVar2 = l.f413536a;
        sb6.append(lVar2.b(qQTransferCenterViewModel.uploadedSize));
        sb6.append(lVar2.c(qQTransferCenterViewModel.uploadedSize));
        mutableState2.setValue(sb6.toString());
    }

    public final QQFTCenterFilterCardVM getFilterCardVM() {
        return (QQFTCenterFilterCardVM) this.filterCardVM$delegate.getValue();
    }

    public final void requestFileSetList(byte[] bArr, final Function2<? super Boolean, ? super Boolean, Unit> function2) {
        final cj cjVar = new cj(0, 0, new byte[0], 0, false, null);
        cjVar.f446269a = 1;
        cjVar.f446270b = getFilterCardVM().currentFilterType.getValue().intValue();
        cjVar.f446272d = 10;
        if (bArr == null && getFilterCardVM().currentFilterType.getValue().intValue() == 3) {
            cjVar.f446273e = true;
        } else {
            if (bArr != null) {
                cjVar.f446271c = bArr;
            }
            cjVar.f446273e = false;
        }
        KLog kLog = KLog.INSTANCE;
        String str = this.kTag;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("requestFileSetList type:");
        m3.append(cjVar.f446270b);
        m3.append(", isFirstPage:");
        NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0.m(m3, bArr == null, kLog, str);
        IKernelFlashTransferService a16 = IKernelFlashTransferService.f344757i.a();
        final dm dmVar = new dm() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel$requestFileSetList$2
            @Override // ws3.dm
            public final void onGetFileSetList(final cm cmVar) {
                final QQTransferCenterViewModel qQTransferCenterViewModel = QQTransferCenterViewModel.this;
                final cj cjVar2 = cjVar;
                final Function2<Boolean, Boolean, Unit> function22 = function2;
                SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel$requestFileSetList$2$onGetFileSetList$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    /* JADX WARN: Type inference failed for: r2v9, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.center.QQFTCenterFileSetCardVM>] */
                    /* JADX WARN: Type inference failed for: r4v11, types: [java.util.List<java.lang.String>, java.util.ArrayList] */
                    /* JADX WARN: Type inference failed for: r4v5, types: [java.util.List<java.lang.String>, java.util.ArrayList] */
                    /* JADX WARN: Type inference failed for: r5v23, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.center.QQFTCenterFileSetCardVM>] */
                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        KLog kLog2 = KLog.INSTANCE;
                        String str2 = QQTransferCenterViewModel.this.kTag;
                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onGetFileSetList result:");
                        m16.append(cmVar.f446274a);
                        m16.append(", errMsg:");
                        m16.append(cmVar.f446275b);
                        m16.append(", type:");
                        m16.append(cjVar2.f446270b);
                        m16.append(" listCount:");
                        m16.append(cmVar.f446276c.size());
                        m16.append(",totalCount:");
                        m16.append((Object) UInt.m615toStringimpl(cmVar.f446277d));
                        m16.append(", isEnd:");
                        m16.append(cmVar.f446278e);
                        m16.append(", isCache:");
                        NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0.m(m16, cmVar.f446280g, kLog2, str2);
                        QQTransferCenterViewModel qQTransferCenterViewModel2 = QQTransferCenterViewModel.this;
                        cm cmVar2 = cmVar;
                        qQTransferCenterViewModel2.getClass();
                        if (cmVar2.f446274a != 0) {
                            ((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).qqToast(cmVar2.f446275b, QToastMode.Warning);
                        } else if (cmVar2.f446276c.isEmpty() && qQTransferCenterViewModel2.paginationInfo == null && qQTransferCenterViewModel2.getFilterCardVM().currentFilterType.getValue().intValue() == 3) {
                            qQTransferCenterViewModel2.hasTransferHistory.setValue(Boolean.FALSE);
                        } else {
                            ArrayList arrayList = new ArrayList();
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            for (br brVar : cmVar2.f446276c) {
                                QQFTCenterFileSetCardVM qQFTCenterFileSetCardVM = new QQFTCenterFileSetCardVM(qQTransferCenterViewModel2, brVar);
                                arrayList.add(qQFTCenterFileSetCardVM);
                                linkedHashMap.put(brVar.f446187a, qQFTCenterFileSetCardVM);
                            }
                            if (qQTransferCenterViewModel2.paginationInfo == null) {
                                qQTransferCenterViewModel2.stopMonitoring();
                                qQTransferCenterViewModel2.fileSetMap.clear();
                                qQTransferCenterViewModel2.feedListViewModel.feedCardViewModelList.clear();
                            }
                            if (qQTransferCenterViewModel2.feedListViewModel.feedCardViewModelList.isEmpty()) {
                                if (qQTransferCenterViewModel2.showTopEmptyCard) {
                                    qQTransferCenterViewModel2.feedListViewModel.feedCardViewModelList.add((QQFTCenterEmptyCardVM) qQTransferCenterViewModel2.emptyCardVM$delegate.getValue());
                                }
                                qQTransferCenterViewModel2.feedListViewModel.feedCardViewModelList.add(qQTransferCenterViewModel2.getFilterCardVM());
                                if (arrayList.isEmpty() && qQTransferCenterViewModel2.getFilterCardVM().currentFilterType.getValue().intValue() != 3) {
                                    qQTransferCenterViewModel2.feedListViewModel.feedCardViewModelList.add((QQFTCenterEmptyCardVM) qQTransferCenterViewModel2.bottomEmptyCardVM$delegate.getValue());
                                }
                            }
                            qQTransferCenterViewModel2.feedListViewModel.feedCardViewModelList.addAll(arrayList);
                            qQTransferCenterViewModel2.fileSetMap.putAll(linkedHashMap);
                            qQTransferCenterViewModel2.hasTransferHistory.setValue(Boolean.TRUE);
                            if (!cmVar2.f446280g) {
                                qQTransferCenterViewModel2.paginationInfo = cmVar2.f446279f;
                            }
                            ArrayList arrayList2 = new ArrayList();
                            for (Map.Entry entry : qQTransferCenterViewModel2.fileSetMap.entrySet()) {
                                if (((QQFTCenterFileSetCardVM) entry.getValue()).fileSet.f446201o == 2 && !qQTransferCenterViewModel2.monitoringArray.contains(entry.getKey()) && (((QQFTCenterFileSetCardVM) entry.getValue()).fileSet.f446202p == 2 || ((QQFTCenterFileSetCardVM) entry.getValue()).fileSet.f446203q == 2)) {
                                    qQTransferCenterViewModel2.monitoringArray.add(entry.getKey());
                                    arrayList2.add(entry.getKey());
                                    KLog kLog3 = KLog.INSTANCE;
                                    String str3 = qQTransferCenterViewModel2.kTag;
                                    StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("startMonitoring fileSetId:");
                                    m17.append((String) entry.getKey());
                                    m17.append(", fileSetStatus:");
                                    m17.append(((QQFTCenterFileSetCardVM) entry.getValue()).fileSet.f446201o);
                                    m17.append(" uploadStatus:");
                                    m17.append(((QQFTCenterFileSetCardVM) entry.getValue()).fileSet.f446202p);
                                    m17.append(", downloadStatus:");
                                    DatalineDetailViewModel$$ExternalSyntheticOutline0.m(m17, ((QQFTCenterFileSetCardVM) entry.getValue()).fileSet.f446203q, kLog3, str3);
                                }
                            }
                            IKernelFlashTransferService.f344757i.a().a(qQTransferCenterViewModel2.kTag, arrayList2);
                            KLog kLog4 = KLog.INSTANCE;
                            String str4 = qQTransferCenterViewModel2.kTag;
                            StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("startMonitoring count:");
                            m18.append(arrayList2.size());
                            kLog4.d(str4, m18.toString());
                        }
                        cm cmVar3 = cmVar;
                        if (cmVar3.f446280g) {
                            QQTransferCenterViewModel qQTransferCenterViewModel3 = QQTransferCenterViewModel.this;
                            qQTransferCenterViewModel3.isLoadDataEnd = true;
                            qQTransferCenterViewModel3.isLoadDataError = false;
                            Function2<Boolean, Boolean, Unit> function23 = function22;
                            if (function23 != null) {
                                function23.invoke(Boolean.TRUE, Boolean.FALSE);
                            }
                        } else {
                            QQTransferCenterViewModel qQTransferCenterViewModel4 = QQTransferCenterViewModel.this;
                            boolean z16 = cmVar3.f446278e;
                            qQTransferCenterViewModel4.isLoadDataEnd = z16;
                            qQTransferCenterViewModel4.isLoadDataError = cmVar3.f446274a != 0;
                            Function2<Boolean, Boolean, Unit> function24 = function22;
                            if (function24 != null) {
                                function24.invoke(Boolean.valueOf(z16), Boolean.valueOf(QQTransferCenterViewModel.this.isLoadDataError));
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
            }
        };
        a16.getClass();
        ArrayList arrayList = new ArrayList();
        Object[] a17 = cl.a(cjVar);
        arrayList.add(Integer.valueOf(a17.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, a17);
        arrayList.add(String.valueOf(dmVar.hashCode()));
        Function1<Object, Unit> function1 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$getFileSetList$kernelCallback$1
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
                        if (Intrinsics.areEqual((String) dr.a(it, "null cannot be cast to non-null type kotlin.String"), "onGetFileSetList")) {
                            Object next = it.next();
                            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
                            int intValue = ((Integer) next).intValue();
                            Object[] objArr2 = new Object[intValue];
                            for (int i3 = 0; i3 < intValue; i3++) {
                                objArr2[i3] = it.next();
                            }
                            Iterator it5 = ArrayIteratorKt.iterator(objArr2);
                            emptyList = CollectionsKt__CollectionsKt.emptyList();
                            cm cmVar = new cm(0, 0, "", emptyList, 0, false, new byte[0], false, null);
                            while (it5.hasNext()) {
                                Object next2 = it5.next();
                                if (Intrinsics.areEqual(next2, "seq")) {
                                    Object next3 = it5.next();
                                    Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int");
                                    ((Integer) next3).intValue();
                                } else if (Intrinsics.areEqual(next2, "result")) {
                                    Object next4 = it5.next();
                                    Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.Int");
                                    cmVar.f446274a = ((Integer) next4).intValue();
                                } else if (Intrinsics.areEqual(next2, "errMs")) {
                                    Object next5 = it5.next();
                                    Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.String");
                                    cmVar.f446275b = (String) next5;
                                } else if (Intrinsics.areEqual(next2, "fileSetList")) {
                                    Object next6 = it5.next();
                                    Intrinsics.checkNotNull(next6, "null cannot be cast to non-null type kotlin.Int");
                                    int intValue2 = ((Integer) next6).intValue();
                                    ArrayList arrayList2 = new ArrayList();
                                    for (int i16 = 0; i16 < intValue2; i16++) {
                                        Object next7 = it5.next();
                                        Intrinsics.checkNotNull(next7, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue3 = ((Integer) next7).intValue();
                                        Object[] objArr3 = new Object[intValue3];
                                        for (int i17 = 0; i17 < intValue3; i17++) {
                                            objArr3[i17] = it5.next();
                                        }
                                        arrayList2.add(bs.a(objArr3));
                                    }
                                    cmVar.f446276c = arrayList2;
                                } else if (Intrinsics.areEqual(next2, "totalFileSetCount")) {
                                    Object next8 = it5.next();
                                    Intrinsics.checkNotNull(next8, "null cannot be cast to non-null type kotlin.String");
                                    cmVar.f446277d = vs3.a.a((String) next8);
                                } else if (Intrinsics.areEqual(next2, "isEnd")) {
                                    Object next9 = it5.next();
                                    Intrinsics.checkNotNull(next9, "null cannot be cast to non-null type kotlin.Int");
                                    cmVar.f446278e = ((Integer) next9).intValue() == 1;
                                } else if (Intrinsics.areEqual(next2, "paginationInfo")) {
                                    Object next10 = it5.next();
                                    Intrinsics.checkNotNull(next10, "null cannot be cast to non-null type kotlin.ByteArray");
                                    cmVar.f446279f = (byte[]) next10;
                                } else if (Intrinsics.areEqual(next2, QAdRewardDefine$VideoParams.ISCACHE)) {
                                    Object next11 = it5.next();
                                    Intrinsics.checkNotNull(next11, "null cannot be cast to non-null type kotlin.Int");
                                    cmVar.f446280g = ((Integer) next11).intValue() == 1;
                                }
                            }
                            dm.this.onGetFileSetList(cmVar);
                            return Unit.INSTANCE;
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        };
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        a16.syncToNativeMethod(true, "getFileSetList", array, function1);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List<java.lang.String>, java.util.ArrayList] */
    public final void stopMonitoring() {
        List list;
        IKernelFlashTransferService a16 = IKernelFlashTransferService.f344757i.a();
        String str = this.kTag;
        list = CollectionsKt___CollectionsKt.toList(this.monitoringArray);
        a16.getClass();
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(Integer.valueOf(list.size()));
        arrayList.addAll(list);
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        a16.syncToNativeMethod(true, "removeFileSetSimpleStatusMonitoring", array, null);
        this.monitoringArray.clear();
    }
}
