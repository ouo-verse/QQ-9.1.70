package com.tencent.hippykotlin.demo.pages.qqflash_transfer.model;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import ap3.a;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Timer;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModel;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.repo.QQFTRepo;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTTransferSizeInterpolation;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTFilterSelectionViewModel;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTEmptyListCardVM;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTExpiredHeaderCardVM;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileSkeletonCardVM;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTPlaceHolderCardVM;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTTitleStatusCardVM;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.FooterRefreshState;
import com.tencent.mobileqq.qqguildsdk.data.type.IPermissionType;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.ntcompose.foundation.lazy.f;
import com.tencent.ntcompose.foundation.scheduler.SchedulerKt;
import com.tencent.ntcompose.lifecycle.viewmodel.g;
import com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService;
import defpackage.j;
import defpackage.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.UnsignedKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.apache.httpcore.message.TokenParser;
import ws3.aa;
import ws3.ab;
import ws3.ad;
import ws3.bo;
import ws3.bp;
import ws3.bq;
import ws3.br;
import ws3.bx;
import ws3.bz;
import ws3.ca;
import ws3.cf;
import ws3.cg;
import ws3.ci;
import ws3.cn;
import ws3.cq;
import ws3.cs;
import ws3.cx;
import ws3.db;
import ws3.dc;
import ws3.dj;
import ws3.dk;
import ws3.dr;
import ws3.ds;
import ws3.dv;
import ws3.dx;
import ws3.e;
import ws3.eb;
import ws3.eg;
import ws3.ei;
import ws3.em;
import ws3.ep;
import ws3.eq;
import ws3.h;
import ws3.i;
import ws3.l;
import ws3.p;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFlashTransferViewModel extends g {
    public static final Companion Companion = new Companion();
    public SnapshotStateList<QQFTFileListFilterInfo> categoryInfos;
    public MutableState<ULong> clusterFileSize;
    public String clusterId;
    public MutableState<ds> clusterInfo;
    public QQFlashTransferViewModel$addFileSetClusteringListListener$1 clusterListener;
    public int clusterType;
    public MutableState<Integer> clusteringNum;
    public String compressedFileFolderId;
    public MutableState<Integer> creatorUploadStatus;
    public MutableState<Long> curDownLoadedBytes;
    public QQFTTransferSizeInterpolation curDownLoadedBytesInterpolation;
    public MutableState<String> curFaceUrl;
    public DeviceStateProcessInfo deviceStateProcessInfo;
    public MutableState<Integer> dirFileCount;
    public MutableState<Long> dirFileSize;
    public SnapshotStateMap<String, QQFTFailedFileInfo> downloadFailedFileList;
    public String downloadFinishBarCloseNotifyListener;
    public SnapshotStateMap<String, Float> downloadProcessMap;
    public final Lazy downloadedHeaderCardVM$delegate;
    public SnapshotStateMap<String, ab> downloadingFileList;
    public final Lazy emptyListCardVM$delegate;
    public String entryId;
    public final MutableState<a> expireBubblePosition;
    public final Lazy expiredHeaderCardVM$delegate;
    public final ComposeFeedListViewModel feedListViewModel;
    public MutableState<Integer> fileCategory;
    public Float fileContentTopOffset;
    public long fileItemClickTimestamp;
    public bp fileLists;
    public MutableState<br> fileSet;
    public MutableState<ca> fileSetDownLoadInfo;
    public MutableState<Integer> fileSetDownLoadTaskStatus;
    public String fileSetId;
    public final MutableState<a> filterPopoverPosition;
    public final Lazy filterSelectionModel$delegate;
    public MutableState<FTFilterType> filterType;
    public long filterTypeClickTimestamp;
    public List<QQFTFileDetailItemVM> finishedVMList;
    public SnapshotStateList<bz> firstClusteringList;
    public int firstFileContentIndex;
    public MutableState<FooterRefreshState> footerRefreshState;
    public MutableState<Boolean> forceShowDownloadBar;
    public MutableState<String> fromH5AllCheck;
    public SnapshotStateList<Long> fromH5SelectItems;
    public MutableState<Boolean> hasLoadAll;
    public boolean hasSendEntrance;
    public boolean hasShowBarBeforeScroll;
    public Integer hasShownFirstDownloadTip;
    public MutableState<Boolean> hasTapSelectAll;
    public MutableState<Boolean> inProgressAnim;
    public String indexPath;
    public MutableState<Integer> isAllSelectFilePause;
    public MutableState<Boolean> isAllSelectMode;
    public MutableState<Boolean> isAutoSpeedUp;
    public final MutableState<Boolean> isDownloadPause;
    public final MutableState<Boolean> isFileSetExpired;
    public MutableState<Boolean> isGridMode;
    public MutableState<Boolean> isInSelectFileScrollAnim;
    public MutableState<Boolean> isLoadingData;
    public MutableState<Boolean> isParentCompressFolderDownloadFile;
    public MutableState<Boolean> isPullingCompressedFileFolderList;
    public MutableState<Boolean> isScrollOverFirstPage;
    public MutableState<Boolean> isScrollOverTitle;
    public List<QQFTFileDetailItemVM> itemVMList;
    public com.tencent.ntcompose.foundation.lazy.a listState;
    public MutableState<Boolean> needShowUploadFinishAnim;
    public List<QQFTFileDetailItemVM> otherVMList;
    public float pageListHeight;
    public MutableState<String> pageTitle;
    public byte[] paginationInfo;
    public String parentCompressDownloadNotifyListener;
    public MutableState<String> parentId;
    public MutableState<Float> progress;
    public final QQFTRepo repo;
    public MutableState<Long> roundDownloadingCount;
    public MutableState<Long> roundDownloadingSize;
    public int sceneType;
    public SnapshotStateMap<Integer, QQFTSecondLevelClusterInfo> secondLevelClusterList;
    public SnapshotStateMap<String, ab> selectFilesToDownload;
    public final MutableState<Boolean> showAddRestartDownloadAlertDialog;
    public final MutableState<Boolean> showCacheTips;
    public final MutableState<Boolean> showCancelDownloadAlertDialog;
    public MutableState<Boolean> showCreateFloatView;
    public final MutableState<Boolean> showExpireBubbleView;
    public final MutableState<Boolean> showExpiredList;
    public MutableState<Boolean> showFilterList;
    public MutableState<Boolean> showFinishDownloadBar;
    public final MutableState<Boolean> showFirstDownloadTip;
    public MutableState<Boolean> showLoadingAllList;
    public final MutableState<Boolean> showTitleBubbleView;
    public final MutableState<a> titleBubblePosition;
    public final Lazy titleStatusCardVM$delegate;
    public QQFTTransferSizeInterpolation uploadFileSizeInterpolation;
    public MutableState<Float> uploadProcess;
    public MutableState<ULong> uploadSpeed;
    public MutableState<Long> uploadSucFileCount;
    public MutableState<Long> uploadedFileSize;
    public ArrayList<String> uploadingFileIds;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public final String getHAS_SHOWN_FIRST_DOWNLOAD_TIP_KEY() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("SHOW_FIRST_DOWNLOAD_TIP_KEY");
            m3.append(c.f117352a.g().getPageData().n().q("uin", ""));
            return m3.toString();
        }
    }

    public QQFlashTransferViewModel() {
        MutableState<Boolean> mutableStateOf$default;
        MutableState<String> mutableStateOf$default2;
        MutableState<String> mutableStateOf$default3;
        MutableState<Integer> mutableStateOf$default4;
        MutableState<Long> mutableStateOf$default5;
        MutableState<ULong> mutableStateOf$default6;
        MutableState<Boolean> mutableStateOf$default7;
        MutableState<Boolean> mutableStateOf$default8;
        MutableState<Boolean> mutableStateOf$default9;
        MutableState<br> mutableStateOf$default10;
        MutableState<Long> mutableStateOf$default11;
        MutableState<Long> mutableStateOf$default12;
        MutableState<Float> mutableStateOf$default13;
        MutableState<ULong> mutableStateOf$default14;
        MutableState<Integer> mutableStateOf$default15;
        MutableState<Boolean> mutableStateOf$default16;
        Lazy lazy;
        Lazy lazy2;
        MutableState<Boolean> mutableStateOf$default17;
        MutableState<FooterRefreshState> mutableStateOf$default18;
        MutableState<Boolean> mutableStateOf$default19;
        MutableState<a> mutableStateOf$default20;
        MutableState<Boolean> mutableStateOf$default21;
        MutableState<Boolean> mutableStateOf$default22;
        MutableState<Integer> mutableStateOf$default23;
        MutableState<Boolean> mutableStateOf$default24;
        MutableState<Boolean> mutableStateOf$default25;
        MutableState<Boolean> mutableStateOf$default26;
        MutableState<Integer> mutableStateOf$default27;
        MutableState<Boolean> mutableStateOf$default28;
        MutableState<Boolean> mutableStateOf$default29;
        MutableState<Boolean> mutableStateOf$default30;
        MutableState<Boolean> mutableStateOf$default31;
        MutableState<ca> mutableStateOf$default32;
        MutableState<FTFilterType> mutableStateOf$default33;
        MutableState<Integer> mutableStateOf$default34;
        Lazy lazy3;
        MutableState<Boolean> mutableStateOf$default35;
        MutableState<ds> mutableStateOf$default36;
        MutableState<String> mutableStateOf$default37;
        MutableState<Integer> mutableStateOf$default38;
        MutableState<Float> mutableStateOf$default39;
        MutableState<Boolean> mutableStateOf$default40;
        MutableState<Long> mutableStateOf$default41;
        MutableState<Boolean> mutableStateOf$default42;
        MutableState<Long> mutableStateOf$default43;
        MutableState<Long> mutableStateOf$default44;
        MutableState<String> mutableStateOf$default45;
        MutableState<Boolean> mutableStateOf$default46;
        MutableState<Boolean> mutableStateOf$default47;
        MutableState<Boolean> mutableStateOf$default48;
        MutableState<Boolean> mutableStateOf$default49;
        MutableState<Boolean> mutableStateOf$default50;
        Lazy lazy4;
        Lazy lazy5;
        MutableState<Boolean> mutableStateOf$default51;
        MutableState<Boolean> mutableStateOf$default52;
        MutableState<a> mutableStateOf$default53;
        MutableState<Boolean> mutableStateOf$default54;
        MutableState<a> mutableStateOf$default55;
        Boolean bool = Boolean.TRUE;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isLoadingData = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
        this.pageTitle = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
        this.parentId = mutableStateOf$default3;
        this.fileSetId = "";
        this.clusterId = "";
        this.indexPath = "";
        this.compressedFileFolderId = "";
        this.clusterType = -1;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.dirFileCount = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0L, null, 2, null);
        this.dirFileSize = mutableStateOf$default5;
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ULong.m642boximpl(0L), null, 2, null);
        this.clusterFileSize = mutableStateOf$default6;
        Boolean bool2 = Boolean.FALSE;
        mutableStateOf$default7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.hasLoadAll = mutableStateOf$default7;
        mutableStateOf$default8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.hasTapSelectAll = mutableStateOf$default8;
        mutableStateOf$default9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.showLoadingAllList = mutableStateOf$default9;
        mutableStateOf$default10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.fileSet = mutableStateOf$default10;
        mutableStateOf$default11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0L, null, 2, null);
        this.uploadSucFileCount = mutableStateOf$default11;
        mutableStateOf$default12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0L, null, 2, null);
        this.uploadedFileSize = mutableStateOf$default12;
        Float valueOf = Float.valueOf(0.0f);
        mutableStateOf$default13 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(valueOf, null, 2, null);
        this.uploadProcess = mutableStateOf$default13;
        mutableStateOf$default14 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ULong.m642boximpl(0L), null, 2, null);
        this.uploadSpeed = mutableStateOf$default14;
        mutableStateOf$default15 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.creatorUploadStatus = mutableStateOf$default15;
        mutableStateOf$default16 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.needShowUploadFinishAnim = mutableStateOf$default16;
        this.uploadFileSizeInterpolation = new QQFTTransferSizeInterpolation(this.uploadedFileSize, new Function1<Long, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$uploadFileSizeInterpolation$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Long l3) {
                long longValue = l3.longValue();
                br value = QQFlashTransferViewModel.this.fileSet.getValue();
                if (value != null) {
                    long j3 = value.f446190d;
                    QQFlashTransferViewModel qQFlashTransferViewModel = QQFlashTransferViewModel.this;
                    if (longValue >= j3) {
                        qQFlashTransferViewModel.needShowUploadFinishAnim.setValue(Boolean.TRUE);
                    }
                }
                KLog.INSTANCE.d("QQFlashTransferFileListViewModel", "QQFTTransferSizeInterpolation finalValue=" + longValue);
                return Unit.INSTANCE;
            }
        });
        this.itemVMList = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQFTTitleStatusCardVM>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$titleStatusCardVM$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final QQFTTitleStatusCardVM invoke() {
                return new QQFTTitleStatusCardVM(QQFlashTransferViewModel.this);
            }
        });
        this.titleStatusCardVM$delegate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<QQFTEmptyListCardVM>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$emptyListCardVM$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final QQFTEmptyListCardVM invoke() {
                return new QQFTEmptyListCardVM(QQFlashTransferViewModel.this, null);
            }
        });
        this.emptyListCardVM$delegate = lazy2;
        this.feedListViewModel = new ComposeFeedListViewModel(new Function1<Function2<? super Boolean, ? super Boolean, ? extends Unit>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$feedListViewModel$1
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v17, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Function2<? super Boolean, ? super Boolean, ? extends Unit> function2) {
                final Function2<? super Boolean, ? super Boolean, ? extends Unit> function22 = function2;
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ComposeFeedListViewModel loadMore clusterId=");
                m3.append(QQFlashTransferViewModel.this.clusterId);
                m3.append(" clusterType=");
                m3.append(QQFlashTransferViewModel.this.clusterType);
                m3.append(" fileSetId=");
                m3.append(QQFlashTransferViewModel.this.fileSetId);
                m3.append(" / ");
                br value = QQFlashTransferViewModel.this.fileSet.getValue();
                m3.append(value != null ? value.f446187a : null);
                m3.append(" hasLoadAll=");
                m3.append(QQFlashTransferViewModel.this.hasLoadAll.getValue().booleanValue());
                m3.append(" fileSetIsNull");
                m3.append(QQFlashTransferViewModel.this.fileSet.getValue() == null);
                m3.append(" status=");
                br value2 = QQFlashTransferViewModel.this.fileSet.getValue();
                m3.append(value2 != null ? Integer.valueOf(value2.f446201o) : null);
                m3.append(" isDownloadedFilterHasMoreData=");
                m3.append(QQFlashTransferViewModel.access$isDownloadedFilterHasMoreData(QQFlashTransferViewModel.this));
                kLog.d("getFileList", m3.toString());
                if ((!QQFlashTransferViewModel.this.hasLoadAll.getValue().booleanValue() || QQFlashTransferViewModel.access$isDownloadedFilterHasMoreData(QQFlashTransferViewModel.this)) && !QQFlashTransferViewModel.this.isFileSetInvalid() && (!(!QQFlashTransferViewModel.this.isSecondaryPage()) || QQFlashTransferViewModel.this.fileSet.getValue() != null)) {
                    if (QQFlashTransferViewModel.access$isDownloadedFilterHasMoreData(QQFlashTransferViewModel.this)) {
                        final QQFlashTransferViewModel qQFlashTransferViewModel = QQFlashTransferViewModel.this;
                        SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$feedListViewModel$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
                            /* JADX WARN: Type inference failed for: r10v10, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
                            /* JADX WARN: Type inference failed for: r1v5, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
                            /* JADX WARN: Type inference failed for: r6v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
                            /* JADX WARN: Type inference failed for: r7v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
                            /* JADX WARN: Type inference failed for: r9v9, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                FooterRefreshState footerRefreshState;
                                List<ab> list;
                                List<ab> list2;
                                QQFlashTransferViewModel qQFlashTransferViewModel2 = QQFlashTransferViewModel.this;
                                boolean booleanValue = qQFlashTransferViewModel2.isAllSelectMode.getValue().booleanValue();
                                bp bpVar = qQFlashTransferViewModel2.fileLists;
                                if (bpVar != null && (list = bpVar.f446183a) != null) {
                                    ArrayList arrayList = new ArrayList();
                                    int size = list.size() - qQFlashTransferViewModel2.itemVMList.size();
                                    if (size > 0) {
                                        int fileListReqCount = qQFlashTransferViewModel2.getFileListReqCount(false);
                                        if (fileListReqCount <= size) {
                                            size = fileListReqCount;
                                        }
                                        bp bpVar2 = qQFlashTransferViewModel2.fileLists;
                                        Intrinsics.checkNotNull(bpVar2);
                                        boolean z16 = bpVar2.f446186d;
                                        int size2 = qQFlashTransferViewModel2.itemVMList.size();
                                        KLog kLog2 = KLog.INSTANCE;
                                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchFileListFromCache fileLists size=");
                                        bp bpVar3 = qQFlashTransferViewModel2.fileLists;
                                        m16.append((bpVar3 == null || (list2 = bpVar3.f446183a) == null) ? null : Integer.valueOf(list2.size()));
                                        m16.append(" isSelected=");
                                        m16.append(booleanValue);
                                        m16.append(" showFilterList=");
                                        m16.append(qQFlashTransferViewModel2.showFilterList.getValue().booleanValue());
                                        m16.append(" itemSize=");
                                        m16.append(qQFlashTransferViewModel2.itemVMList.size());
                                        m16.append(" renderCount=");
                                        m16.append(size);
                                        m16.append(" isFromCache=");
                                        m16.append(z16);
                                        kLog2.d("QQFlashTransferFileListViewModel", m16.toString());
                                        int i3 = size + size2;
                                        while (size2 < i3) {
                                            QQFTFileDetailItemVM qQFTFileDetailItemVM = new QQFTFileDetailItemVM(qQFlashTransferViewModel2, list.get(size2), false);
                                            qQFTFileDetailItemVM.updateThumbnailUrl(list.get(size2).f446166q);
                                            qQFTFileDetailItemVM.isSelected.setValue(Boolean.valueOf(booleanValue));
                                            qQFTFileDetailItemVM.isFromCache = z16;
                                            arrayList.add(qQFTFileDetailItemVM);
                                            qQFlashTransferViewModel2.itemVMList.add(qQFTFileDetailItemVM);
                                            size2++;
                                        }
                                        if (!arrayList.isEmpty()) {
                                            qQFlashTransferViewModel2.feedListViewModel.feedCardViewModelList.addAll(arrayList);
                                        }
                                    }
                                }
                                Function2<Boolean, Boolean, Unit> function23 = function22;
                                int size3 = QQFlashTransferViewModel.this.itemVMList.size();
                                bp bpVar4 = QQFlashTransferViewModel.this.fileLists;
                                Intrinsics.checkNotNull(bpVar4);
                                function23.invoke(Boolean.valueOf(size3 == bpVar4.f446183a.size()), Boolean.FALSE);
                                QQFlashTransferViewModel qQFlashTransferViewModel3 = QQFlashTransferViewModel.this;
                                MutableState<FooterRefreshState> mutableState = qQFlashTransferViewModel3.footerRefreshState;
                                int size4 = qQFlashTransferViewModel3.itemVMList.size();
                                bp bpVar5 = QQFlashTransferViewModel.this.fileLists;
                                Intrinsics.checkNotNull(bpVar5);
                                if (size4 == bpVar5.f446183a.size()) {
                                    footerRefreshState = FooterRefreshState.NONE_MORE_DATA;
                                } else {
                                    footerRefreshState = FooterRefreshState.IDLE;
                                }
                                mutableState.setValue(footerRefreshState);
                                return Unit.INSTANCE;
                            }
                        });
                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchFileListFromCache end  curSize=");
                        m16.append(QQFlashTransferViewModel.this.itemVMList.size());
                        m16.append(" cacheSize=");
                        bp bpVar = QQFlashTransferViewModel.this.fileLists;
                        Intrinsics.checkNotNull(bpVar);
                        m16.append(bpVar.f446183a.size());
                        kLog.d("getFileList", m16.toString());
                    } else {
                        QQFlashTransferViewModel.this.fetchPageFileList(false, function22);
                    }
                }
                return Unit.INSTANCE;
            }
        });
        mutableStateOf$default17 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.isAllSelectMode = mutableStateOf$default17;
        mutableStateOf$default18 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(FooterRefreshState.IDLE, null, 2, null);
        this.footerRefreshState = mutableStateOf$default18;
        mutableStateOf$default19 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.showFilterList = mutableStateOf$default19;
        mutableStateOf$default20 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.filterPopoverPosition = mutableStateOf$default20;
        mutableStateOf$default21 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.forceShowDownloadBar = mutableStateOf$default21;
        mutableStateOf$default22 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.showFinishDownloadBar = mutableStateOf$default22;
        this.selectFilesToDownload = SnapshotStateKt.mutableStateMapOf();
        this.downloadingFileList = SnapshotStateKt.mutableStateMapOf();
        mutableStateOf$default23 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.fileSetDownLoadTaskStatus = mutableStateOf$default23;
        mutableStateOf$default24 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.isDownloadPause = mutableStateOf$default24;
        mutableStateOf$default25 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.showCancelDownloadAlertDialog = mutableStateOf$default25;
        mutableStateOf$default26 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.showAddRestartDownloadAlertDialog = mutableStateOf$default26;
        mutableStateOf$default27 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.isAllSelectFilePause = mutableStateOf$default27;
        mutableStateOf$default28 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.isScrollOverTitle = mutableStateOf$default28;
        mutableStateOf$default29 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.isScrollOverFirstPage = mutableStateOf$default29;
        mutableStateOf$default30 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.isInSelectFileScrollAnim = mutableStateOf$default30;
        mutableStateOf$default31 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.showCreateFloatView = mutableStateOf$default31;
        mutableStateOf$default32 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.fileSetDownLoadInfo = mutableStateOf$default32;
        this.downloadProcessMap = SnapshotStateKt.mutableStateMapOf();
        mutableStateOf$default33 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(FTFilterType.ALL_FILE, null, 2, null);
        this.filterType = mutableStateOf$default33;
        mutableStateOf$default34 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.fileCategory = mutableStateOf$default34;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<QQFTFilterSelectionViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$filterSelectionModel$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final QQFTFilterSelectionViewModel invoke() {
                QQFTFilterSelectionViewModel qQFTFilterSelectionViewModel = new QQFTFilterSelectionViewModel(new String[]{"\u5168\u90e8", "\u5df2\u4e0b\u8f7d", "\u672a\u4e0b\u8f7d"});
                qQFTFilterSelectionViewModel.selectItem(QQFlashTransferViewModel.this.filterType.getValue().ordinal());
                return qQFTFilterSelectionViewModel;
            }
        });
        this.filterSelectionModel$delegate = lazy3;
        mutableStateOf$default35 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isGridMode = mutableStateOf$default35;
        this.firstClusteringList = SnapshotStateKt.mutableStateListOf();
        mutableStateOf$default36 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new ds(), null, 2, null);
        this.clusterInfo = mutableStateOf$default36;
        this.secondLevelClusterList = SnapshotStateKt.mutableStateMapOf();
        mutableStateOf$default37 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
        this.curFaceUrl = mutableStateOf$default37;
        mutableStateOf$default38 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.clusteringNum = mutableStateOf$default38;
        mutableStateOf$default39 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(valueOf, null, 2, null);
        this.progress = mutableStateOf$default39;
        mutableStateOf$default40 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.inProgressAnim = mutableStateOf$default40;
        mutableStateOf$default41 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0L, null, 2, null);
        this.curDownLoadedBytes = mutableStateOf$default41;
        this.curDownLoadedBytesInterpolation = new QQFTTransferSizeInterpolation(mutableStateOf$default41, new Function1<Long, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$curDownLoadedBytesInterpolation$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Long l3) {
                long longValue = l3.longValue();
                ca value = QQFlashTransferViewModel.this.fileSetDownLoadInfo.getValue();
                if (value != null) {
                    long j3 = value.f446234e;
                    QQFlashTransferViewModel qQFlashTransferViewModel = QQFlashTransferViewModel.this;
                    if (longValue >= j3) {
                        qQFlashTransferViewModel.resetDownloadProcess();
                    }
                }
                KLog.INSTANCE.d("QQFlashTransferFileListViewModel", "QQFTTransferSizeInterpolation finalValue=" + longValue);
                return Unit.INSTANCE;
            }
        });
        mutableStateOf$default42 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.isAutoSpeedUp = mutableStateOf$default42;
        mutableStateOf$default43 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0L, null, 2, null);
        this.roundDownloadingCount = mutableStateOf$default43;
        mutableStateOf$default44 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0L, null, 2, null);
        this.roundDownloadingSize = mutableStateOf$default44;
        mutableStateOf$default45 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
        this.fromH5AllCheck = mutableStateOf$default45;
        this.fromH5SelectItems = SnapshotStateKt.mutableStateListOf();
        this.repo = new QQFTRepo();
        this.categoryInfos = SnapshotStateKt.mutableStateListOf();
        this.downloadFailedFileList = SnapshotStateKt.mutableStateMapOf();
        mutableStateOf$default46 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.isPullingCompressedFileFolderList = mutableStateOf$default46;
        mutableStateOf$default47 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.isParentCompressFolderDownloadFile = mutableStateOf$default47;
        this.uploadingFileIds = new ArrayList<>();
        mutableStateOf$default48 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.isFileSetExpired = mutableStateOf$default48;
        mutableStateOf$default49 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.showCacheTips = mutableStateOf$default49;
        mutableStateOf$default50 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.showExpiredList = mutableStateOf$default50;
        this.finishedVMList = new ArrayList();
        this.otherVMList = new ArrayList();
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<QQFTExpiredHeaderCardVM>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$downloadedHeaderCardVM$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final QQFTExpiredHeaderCardVM invoke() {
                return new QQFTExpiredHeaderCardVM(QQFlashTransferViewModel.this, false);
            }
        });
        this.downloadedHeaderCardVM$delegate = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<QQFTExpiredHeaderCardVM>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$expiredHeaderCardVM$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final QQFTExpiredHeaderCardVM invoke() {
                return new QQFTExpiredHeaderCardVM(QQFlashTransferViewModel.this, true);
            }
        });
        this.expiredHeaderCardVM$delegate = lazy5;
        this.deviceStateProcessInfo = new DeviceStateProcessInfo();
        this.entryId = "0";
        mutableStateOf$default51 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.showFirstDownloadTip = mutableStateOf$default51;
        mutableStateOf$default52 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.showTitleBubbleView = mutableStateOf$default52;
        mutableStateOf$default53 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.titleBubblePosition = mutableStateOf$default53;
        mutableStateOf$default54 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.showExpireBubbleView = mutableStateOf$default54;
        mutableStateOf$default55 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.expireBubblePosition = mutableStateOf$default55;
        KLog.INSTANCE.e("QQFlashTransferFileListViewModel", "init refreshData");
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
    public static final void access$initLoadMoreFileListData(QQFlashTransferViewModel qQFlashTransferViewModel, boolean z16, List list) {
        qQFlashTransferViewModel.getClass();
        KLog.INSTANCE.d("QQFlashTransferFileListViewModel", "initLoadMoreFileListData isSelected=" + z16 + " size=" + list.size());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ab abVar = (ab) it.next();
            QQFTFileDetailItemVM qQFTFileDetailItemVM = new QQFTFileDetailItemVM(qQFlashTransferViewModel, abVar, false);
            bp bpVar = qQFlashTransferViewModel.fileLists;
            Intrinsics.checkNotNull(bpVar);
            qQFTFileDetailItemVM.isFromCache = bpVar.f446186d;
            qQFTFileDetailItemVM.updateThumbnailUrl(abVar.f446166q);
            arrayList2.add(qQFTFileDetailItemVM);
            qQFTFileDetailItemVM.isSelected.setValue(Boolean.valueOf(z16));
            qQFlashTransferViewModel.itemVMList.add(qQFTFileDetailItemVM);
            if (qQFlashTransferViewModel.m117isFromH5SelectHitWZ4Q5Ns(abVar.f446158i)) {
                qQFTFileDetailItemVM.isSelected.setValue(Boolean.TRUE);
                arrayList.add(abVar);
            }
            int i3 = abVar.B;
            if (i3 == 1 || i3 == 2 || i3 == 4 || abVar.A == 4) {
                arrayList3.add(abVar.f446168s);
            }
        }
        qQFlashTransferViewModel.uploadingFileIds.addAll(arrayList3);
        qQFlashTransferViewModel.pollFilesTransferProgress(arrayList3);
        if (!arrayList2.isEmpty()) {
            qQFlashTransferViewModel.feedListViewModel.feedCardViewModelList.addAll(arrayList2);
        }
        if (arrayList.size() > 0) {
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("initLoadMoreData startFileListDownLoad size=");
            m3.append(arrayList.size());
            kLog.d("QQFlashTransferFileListViewModel", m3.toString());
            qQFlashTransferViewModel.startFileListDownLoad(qQFlashTransferViewModel.fileSetId, arrayList, new cx() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$initLoadMoreFileListData$1$1
                @Override // ws3.cx
                /* renamed from: onResult-jXDDuk8 */
                public final void mo120onResultjXDDuk8(final int i16, final String str, final int i17) {
                    SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$initLoadMoreFileListData$1$1$onResult$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            KLog kLog2 = KLog.INSTANCE;
                            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("initLoadMoreData handleDownloadFiles startFileListDownLoad result=");
                            m16.append(i16);
                            m16.append(" errMsg=");
                            m16.append(str);
                            m16.append(" extraInfo=");
                            m16.append((Object) UInt.m615toStringimpl(i17));
                            kLog2.d("QQFlashTransferFileListViewModel", m16.toString());
                            return Unit.INSTANCE;
                        }
                    });
                }
            }, false);
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
    public static final boolean access$isDownloadedFilterHasMoreData(QQFlashTransferViewModel qQFlashTransferViewModel) {
        if (!qQFlashTransferViewModel.hasLoadAll.getValue().booleanValue() || qQFlashTransferViewModel.filterType.getValue() != FTFilterType.DOWNLOADED_FILE) {
            return false;
        }
        bp bpVar = qQFlashTransferViewModel.fileLists;
        if (!(bpVar != null && bpVar.f446186d) || bpVar == null) {
            return false;
        }
        int size = qQFlashTransferViewModel.itemVMList.size();
        bp bpVar2 = qQFlashTransferViewModel.fileLists;
        Intrinsics.checkNotNull(bpVar2);
        return size < bpVar2.f446183a.size();
    }

    /* JADX WARN: Type inference failed for: r1v14, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
    public static final boolean access$updateEmptyView(QQFlashTransferViewModel qQFlashTransferViewModel) {
        String str;
        List<ab> list;
        List<ab> list2;
        qQFlashTransferViewModel.getClass();
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("updateEmptyView size=");
        bp bpVar = qQFlashTransferViewModel.fileLists;
        m3.append((bpVar == null || (list2 = bpVar.f446183a) == null) ? null : Integer.valueOf(list2.size()));
        kLog.d("QQFlashTransferFileListViewModel", m3.toString());
        if (!qQFlashTransferViewModel.hasLoadAll.getValue().booleanValue()) {
            return false;
        }
        bp bpVar2 = qQFlashTransferViewModel.fileLists;
        if (!((bpVar2 == null || (list = bpVar2.f446183a) == null || list.size() != 0) ? false : true) || qQFlashTransferViewModel.isFileSetExpired.getValue().booleanValue() || !qQFlashTransferViewModel.itemVMList.isEmpty()) {
            return false;
        }
        MutableState<String> mutableState = qQFlashTransferViewModel.getEmptyListCardVM().displayText;
        if (qQFlashTransferViewModel.filterType.getValue() == FTFilterType.DOWNLOADED_FILE) {
            str = "\u5f53\u524d\u6ca1\u6709\u5df2\u4e0b\u8f7d\u7684\u6587\u4ef6";
        } else if (qQFlashTransferViewModel.filterType.getValue() == FTFilterType.NOT_DOWNLOAD_FILE) {
            str = "\u5f53\u524d\u6ca1\u6709\u672a\u4e0b\u8f7d\u7684\u6587\u4ef6";
        } else {
            str = "\u5f53\u524d\u6ca1\u6709\u6587\u4ef6";
        }
        mutableState.setValue(str);
        if (!qQFlashTransferViewModel.feedListViewModel.feedCardViewModelList.contains(qQFlashTransferViewModel.getEmptyListCardVM())) {
            qQFlashTransferViewModel.feedListViewModel.feedCardViewModelList.add(qQFlashTransferViewModel.getEmptyListCardVM());
        }
        kLog.d("QQFlashTransferFileListViewModel", "add EmptyView1");
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0040, code lost:
    
        if (r1 > r2) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void beforeUpdateFileContentOffset() {
        int i3;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("beforeUpdateFileContentOffset size=");
        m3.append(this.feedListViewModel.feedCardViewModelList.size());
        kLog.d("QQFlashTransferFileListViewModel", m3.toString());
        this.hasShowBarBeforeScroll = isBottomBarShow();
        com.tencent.ntcompose.foundation.lazy.a listState = getListState();
        if (needShowAIClusterListView() && isNormalGridMode()) {
            int size = this.feedListViewModel.feedCardViewModelList.size();
            i3 = this.firstFileContentIndex + 3;
        }
        if ((this.clusterId.length() > 0) && !this.isGridMode.getValue().booleanValue()) {
            i3 = this.firstFileContentIndex - 1;
        } else {
            i3 = this.firstFileContentIndex;
        }
        Float q16 = listState.q(i3);
        if (q16 == null) {
            q16 = Float.valueOf(0.0f);
        }
        this.fileContentTopOffset = q16;
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
    public final boolean canShowAllSelectCheckBox() {
        return (this.fileSet.getValue() == null || this.isFileSetExpired.getValue().booleanValue() || isFileSetInvalid() || (this.footerRefreshState.getValue() == FooterRefreshState.FAILURE && this.itemVMList.isEmpty())) ? false : true;
    }

    public final void cancelPollFilesTransferProgressListener() {
        CollectionsKt__CollectionsKt.emptyList();
        String str = this.fileSetId;
        ArrayList<String> arrayList = this.uploadingFileIds;
        IKernelFlashTransferService a16 = IKernelFlashTransferService.f344757i.a();
        a16.getClass();
        ArrayList arrayList2 = new ArrayList();
        ArrayList m3 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m("seq");
        m3.add(0);
        m3.add("fileSetId");
        m3.add(str);
        m3.add("svrFileIds");
        m3.add(Integer.valueOf(arrayList.size()));
        m3.addAll(arrayList);
        Object[] array = m3.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        arrayList2.add(Integer.valueOf(array.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList2, array);
        Object[] array2 = arrayList2.toArray(new Object[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        a16.syncToNativeMethod(true, "cancelPollFilesTransferProgress", array2, null);
        this.uploadingFileIds.clear();
    }

    public final void clearFileSkeletonView() {
        SnapshotStateList<BaseComposeCardViewModel> snapshotStateList = this.feedListViewModel.feedCardViewModelList;
        ArrayList arrayList = new ArrayList();
        for (BaseComposeCardViewModel baseComposeCardViewModel : snapshotStateList) {
            if (baseComposeCardViewModel instanceof QQFTFileSkeletonCardVM) {
                arrayList.add(baseComposeCardViewModel);
            }
        }
        snapshotStateList.removeAll(arrayList);
        KLog.INSTANCE.e("QQFlashTransferFileListViewModel", "clearFileSkeletonView.");
    }

    public final void fetchFileSetClusteringDetail(final boolean z16, byte[] bArr, final Function2<? super Boolean, ? super Boolean, Unit> function2) {
        int i3;
        this.clusterInfo.getValue().f446291d = this.clusterId;
        ds value = this.clusterInfo.getValue();
        int i16 = this.clusterType;
        if (i16 < 0) {
            i16 = 1;
        }
        if (i16 != 1) {
            i3 = 2;
            if (i16 != 2) {
                i3 = 0;
            }
        } else {
            i3 = 1;
        }
        value.f446290c = i3;
        this.clusterInfo.getValue().f446289b = this.fileSetId;
        this.clusterInfo.getValue().f446292e = getFilterType();
        this.clusterInfo.getValue().f446294g = UInt.m570constructorimpl(getFileListReqCount(z16));
        if (bArr != null) {
            this.clusterInfo.getValue().f446293f = bArr;
        } else {
            this.clusterInfo.getValue().f446293f = new byte[0];
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        TimerKt.c(1000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$fetchFileSetClusteringDetail$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                if (!Ref.BooleanRef.this.element) {
                    this.footerRefreshState.setValue(FooterRefreshState.REFRESHING);
                }
                NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchFileList isGotListRsp = "), Ref.BooleanRef.this.element, KLog.INSTANCE, "QQFlashTransferFileListViewModel");
                return Unit.INSTANCE;
            }
        });
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getFileSetClusteringDetail clusteringId=");
        m3.append(this.clusterId);
        m3.append(" type=");
        m3.append(this.clusterInfo.getValue().f446290c);
        m3.append(" filterType=");
        m3.append(this.clusterInfo.getValue().f446292e);
        m3.append(" paginationInfo=");
        m3.append(this.clusterInfo.getValue().f446293f.length);
        m3.append(" loadAllDownload=");
        m3.append(z16);
        m3.append(" reqCnt=");
        m3.append((Object) UInt.m615toStringimpl(this.clusterInfo.getValue().f446294g));
        kLog.d("QQFlashTransferFileListViewModel", m3.toString());
        final boolean z17 = this.paginationInfo == null;
        IKernelFlashTransferService.f344757i.a().d(this.clusterInfo.getValue(), new db() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$fetchFileSetClusteringDetail$2
            @Override // ws3.db
            public final void onGetClusteringDetail(final dv dvVar) {
                final QQFlashTransferViewModel qQFlashTransferViewModel = QQFlashTransferViewModel.this;
                final Ref.BooleanRef booleanRef2 = booleanRef;
                final Function2<Boolean, Boolean, Unit> function22 = function2;
                final boolean z18 = z16;
                final boolean z19 = z17;
                SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$fetchFileSetClusteringDetail$2$onGetClusteringDetail$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        Boolean bool;
                        List<ab> list;
                        Object first;
                        String str;
                        FooterRefreshState footerRefreshState;
                        List<ab> list2;
                        KLog kLog2 = KLog.INSTANCE;
                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onGetClusteringDetail fileSetId=");
                        m16.append(dv.this.f446297b);
                        m16.append(" clusteringId=");
                        m16.append(dv.this.f446298c);
                        m16.append(" paginationInfo=");
                        byte[] bArr2 = qQFlashTransferViewModel.paginationInfo;
                        Integer num = null;
                        if (bArr2 != null) {
                            bool = Boolean.valueOf(bArr2.length == 0);
                        } else {
                            bool = null;
                        }
                        m16.append(bool);
                        m16.append(" end=");
                        m16.append(dv.this.f446300e);
                        m16.append(" result=");
                        m16.append(dv.this.f446296a);
                        m16.append("totalInfo{count=");
                        m16.append((Object) UInt.m615toStringimpl(dv.this.f446302g.f446303a));
                        m16.append(" size=");
                        m16.append((Object) ULong.m693toStringimpl(dv.this.f446302g.f446304b));
                        m16.append('}');
                        kLog2.d("QQFlashTransferFileListViewModel", m16.toString());
                        booleanRef2.element = true;
                        MutableState<Boolean> mutableState = qQFlashTransferViewModel.isLoadingData;
                        Boolean bool2 = Boolean.FALSE;
                        mutableState.setValue(bool2);
                        qQFlashTransferViewModel.clearFileSkeletonView();
                        if (dv.this.f446296a != 0) {
                            qQFlashTransferViewModel.footerRefreshState.setValue(FooterRefreshState.FAILURE);
                            Function2<Boolean, Boolean, Unit> function23 = function22;
                            if (function23 != null) {
                                function23.invoke(Boolean.valueOf(dv.this.f446300e), Boolean.TRUE);
                            }
                        } else if (Intrinsics.areEqual(qQFlashTransferViewModel.clusterInfo.getValue().f446289b, dv.this.f446297b) && Intrinsics.areEqual(qQFlashTransferViewModel.clusterInfo.getValue().f446291d, dv.this.f446298c)) {
                            qQFlashTransferViewModel.clusterFileSize.setValue(ULong.m642boximpl(dv.this.f446302g.f446304b));
                            if (z18) {
                                for (ab abVar : dv.this.f446301f) {
                                    if (!qQFlashTransferViewModel.selectFilesToDownload.containsKey(abVar.f446151b)) {
                                        qQFlashTransferViewModel.selectFilesToDownload.put(abVar.f446151b, abVar);
                                    }
                                }
                                dv dvVar2 = dv.this;
                                if (!dvVar2.f446300e) {
                                    qQFlashTransferViewModel.fetchFileSetClusteringDetail(true, dvVar2.f446299d, function22);
                                } else {
                                    final QQFlashTransferViewModel qQFlashTransferViewModel2 = qQFlashTransferViewModel;
                                    TimerKt.c(500, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$fetchFileSetClusteringDetail$2$onGetClusteringDetail$1.1
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            QQFlashTransferViewModel.this.showLoadingAllList.setValue(Boolean.FALSE);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                            } else {
                                if (z19) {
                                    bp bpVar = new bp();
                                    bpVar.f446183a = dv.this.f446301f;
                                    qQFlashTransferViewModel.parentId.getValue();
                                    QQFlashTransferViewModel qQFlashTransferViewModel3 = qQFlashTransferViewModel;
                                    qQFlashTransferViewModel3.fileLists = bpVar;
                                    QQFlashTransferViewModel.access$initFileListData(qQFlashTransferViewModel3, qQFlashTransferViewModel3.hasTapSelectAll.getValue().booleanValue());
                                } else {
                                    bp bpVar2 = qQFlashTransferViewModel.fileLists;
                                    List<ab> mutableList = (bpVar2 == null || (list = bpVar2.f446183a) == null) ? null : CollectionsKt___CollectionsKt.toMutableList((Collection) list);
                                    if (mutableList != null) {
                                        dv dvVar3 = dv.this;
                                        QQFlashTransferViewModel qQFlashTransferViewModel4 = qQFlashTransferViewModel;
                                        mutableList.addAll(dvVar3.f446301f);
                                        if (qQFlashTransferViewModel4.fileLists != null) {
                                            qQFlashTransferViewModel4.parentId.getValue();
                                        }
                                        bp bpVar3 = qQFlashTransferViewModel4.fileLists;
                                        if (bpVar3 != null) {
                                            bpVar3.f446183a = mutableList;
                                        }
                                        QQFlashTransferViewModel.access$initLoadMoreFileListData(qQFlashTransferViewModel4, qQFlashTransferViewModel4.hasTapSelectAll.getValue().booleanValue(), dvVar3.f446301f);
                                    }
                                }
                                QQFlashTransferViewModel qQFlashTransferViewModel5 = qQFlashTransferViewModel;
                                bp bpVar4 = qQFlashTransferViewModel5.fileLists;
                                if (bpVar4 != null) {
                                    bpVar4.f446184b = dv.this.f446299d;
                                }
                                if (bpVar4 != null) {
                                    bpVar4.f446185c = dv.this.f446300e;
                                }
                                dv dvVar4 = dv.this;
                                boolean z26 = dvVar4.f446300e;
                                if (z26) {
                                    qQFlashTransferViewModel5.paginationInfo = null;
                                } else {
                                    qQFlashTransferViewModel5.paginationInfo = dvVar4.f446299d;
                                }
                                qQFlashTransferViewModel5.hasLoadAll.setValue(Boolean.valueOf(z26));
                                if (qQFlashTransferViewModel.hasLoadAll.getValue().booleanValue() && qQFlashTransferViewModel.hasTapSelectAll.getValue().booleanValue()) {
                                    qQFlashTransferViewModel.hasTapSelectAll.setValue(bool2);
                                }
                                if (!dv.this.f446301f.isEmpty()) {
                                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) dv.this.f446301f);
                                    str = ((ab) first).f446151b;
                                } else {
                                    str = "fileLists empty";
                                }
                                StringBuilder m17 = NearbyFDPageViewModel$$ExternalSyntheticOutline0.m(dv.this.f446301f, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onGetClusteringDetail size="), " / ");
                                bp bpVar5 = qQFlashTransferViewModel.fileLists;
                                if (bpVar5 != null && (list2 = bpVar5.f446183a) != null) {
                                    num = Integer.valueOf(list2.size());
                                }
                                m17.append(num);
                                m17.append(" isEnd=");
                                m17.append(dv.this.f446300e);
                                m17.append(" cliFileId=");
                                m17.append(str);
                                m17.append(" hasLoadAll=");
                                m17.append(qQFlashTransferViewModel.hasLoadAll.getValue().booleanValue());
                                kLog2.d("QQFlashTransferFileListViewModel", m17.toString());
                                Function2<Boolean, Boolean, Unit> function24 = function22;
                                if (function24 != null) {
                                    function24.invoke(Boolean.valueOf(dv.this.f446300e), bool2);
                                }
                                boolean access$updateEmptyView = QQFlashTransferViewModel.access$updateEmptyView(qQFlashTransferViewModel);
                                MutableState<FooterRefreshState> mutableState2 = qQFlashTransferViewModel.footerRefreshState;
                                if (dv.this.f446300e && !access$updateEmptyView) {
                                    footerRefreshState = FooterRefreshState.NONE_MORE_DATA;
                                } else {
                                    footerRefreshState = FooterRefreshState.IDLE;
                                }
                                mutableState2.setValue(footerRefreshState);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
            }
        });
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
    public final void filterFileType(FTFilterType fTFilterType) {
        List<ab> list;
        List<ab> emptyList;
        this.filterType.getValue();
        this.filterType.setValue(fTFilterType);
        int size = this.selectFilesToDownload.size();
        updateAllItem(false);
        updateFileContentOffset(size);
        removeEmptyView();
        cancelPollFilesTransferProgressListener();
        int size2 = this.feedListViewModel.feedCardViewModelList.size();
        SnapshotStateList<BaseComposeCardViewModel> snapshotStateList = this.feedListViewModel.feedCardViewModelList;
        ArrayList arrayList = new ArrayList();
        Iterator<BaseComposeCardViewModel> it = snapshotStateList.iterator();
        while (it.hasNext()) {
            BaseComposeCardViewModel next = it.next();
            if (next instanceof QQFTFileDetailItemVM) {
                arrayList.add(next);
            }
        }
        snapshotStateList.removeAll(arrayList);
        int size3 = this.feedListViewModel.feedCardViewModelList.size();
        bp bpVar = this.fileLists;
        if (bpVar != null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            bpVar.f446183a = emptyList;
        }
        Integer num = null;
        this.paginationInfo = null;
        this.hasLoadAll.setValue(Boolean.FALSE);
        this.itemVMList.clear();
        ComposeFeedListViewModel.resetFooterRefresh$default(this.feedListViewModel);
        KLog kLog = KLog.INSTANCE;
        kLog.d("QQFlashTransferFileListViewModel", "resetFooterRefresh");
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("filterFileType newSize=");
        bp bpVar2 = this.fileLists;
        if (bpVar2 != null && (list = bpVar2.f446183a) != null) {
            num = Integer.valueOf(list.size());
        }
        m3.append(num);
        m3.append(" forceUpdate=");
        m3.append(true);
        m3.append(" clusteringId=");
        m3.append(this.clusterInfo.getValue().f446291d);
        m3.append(" filterType=");
        m3.append(this.filterType.getValue());
        m3.append(" feedCardViewModelList [");
        m3.append(size2);
        m3.append(" -> ");
        m3.append(size3);
        m3.append(']');
        kLog.d("QQFlashTransferFileListViewModel", m3.toString());
    }

    /* renamed from: getCurPageFileTotalCount-s-VKNKU, reason: not valid java name */
    public final long m115getCurPageFileTotalCountsVKNKU() {
        if (!(this.parentId.getValue().length() > 0) && !isCompressPage()) {
            if (this.clusterId.length() == 0) {
                br value = this.fileSet.getValue();
                if (value != null) {
                    return value.f446189c;
                }
                return 0L;
            }
            return ULong.m648constructorimpl(this.clusteringNum.getValue().intValue());
        }
        return ULong.m648constructorimpl(this.dirFileCount.getValue().intValue());
    }

    public final Long getCurPageFileTotalSize() {
        if (!(this.parentId.getValue().length() > 0) && !isCompressPage()) {
            if (this.clusterId.length() > 0) {
                return Long.valueOf(this.clusterFileSize.getValue().getData());
            }
            if (this.fileSet.getValue() != null) {
                br value = this.fileSet.getValue();
                if ((value != null ? ULong.m642boximpl(value.f446190d) : null) != null) {
                    br value2 = this.fileSet.getValue();
                    Intrinsics.checkNotNull(value2);
                    return Long.valueOf(value2.f446190d);
                }
            }
            return null;
        }
        return this.dirFileSize.getValue();
    }

    /* renamed from: getCurPageFirstLevelItemCount-s-VKNKU, reason: not valid java name */
    public final long m116getCurPageFirstLevelItemCountsVKNKU() {
        int compare;
        if (!isSecondaryPage() && this.fileSet.getValue() != null) {
            br value = this.fileSet.getValue();
            Intrinsics.checkNotNull(value);
            compare = Integer.compare(value.f446196j ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE);
            if (compare > 0) {
                if (this.fileSet.getValue() != null) {
                    return ULong.m648constructorimpl(r0.f446196j & 4294967295L);
                }
                return 0L;
            }
        }
        return m115getCurPageFileTotalCountsVKNKU();
    }

    public final int getDownloadStatusFileCount(int i3) {
        Iterator<Map.Entry<String, ab>> it = this.selectFilesToDownload.entrySet().iterator();
        int i16 = 0;
        while (it.hasNext()) {
            if (it.next().getValue().C == i3) {
                i16++;
            }
        }
        return i16;
    }

    public final QQFTEmptyListCardVM getEmptyListCardVM() {
        return (QQFTEmptyListCardVM) this.emptyListCardVM$delegate.getValue();
    }

    public final void getFileSetClusteringList(int i3) {
        dx dxVar = new dx(0, "", 0, 0, new aa(), 0);
        dxVar.f446305a = 1;
        dxVar.f446306b = this.fileSetId;
        dxVar.f446307c = i3;
        dxVar.f446308d = 100;
        dxVar.f446310f = this.sceneType;
        KLog.INSTANCE.d("QQFlashTransferFileListViewModel", "getFileSetClusteringList type=" + i3);
        IKernelFlashTransferService a16 = IKernelFlashTransferService.f344757i.a();
        a16.getClass();
        ArrayList arrayList = new ArrayList();
        Object[] a17 = eb.a(dxVar);
        arrayList.add(Integer.valueOf(a17.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, a17);
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        a16.syncToNativeMethod(true, "getFileSetClusteringList", array, null);
    }

    public final QQFTFilterSelectionViewModel getFilterSelectionModel() {
        return (QQFTFilterSelectionViewModel) this.filterSelectionModel$delegate.getValue();
    }

    public final int getFilterType() {
        if (this.filterType.getValue() == FTFilterType.ALL_FILE) {
            return 0;
        }
        return this.filterType.getValue() == FTFilterType.DOWNLOADED_FILE ? 2 : 1;
    }

    public final float getLazyListBottomPadding() {
        return isBottomBarShow() ? 160.0f : 80.0f;
    }

    public final com.tencent.ntcompose.foundation.lazy.a getListState() {
        com.tencent.ntcompose.foundation.lazy.a aVar = this.listState;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("listState");
        return null;
    }

    public final float getSelectScrollOffset() {
        if (k.a(c.f117352a)) {
            Float f16 = this.fileContentTopOffset;
            if (f16 != null) {
                return f16.floatValue() - (isCompressPage() ? 6.0f : 12.0f);
            }
            return 0.0f;
        }
        Float f17 = this.fileContentTopOffset;
        if (f17 != null) {
            return f17.floatValue() - (isCompressPage() ? 10.0f : 16.0f);
        }
        return 0.0f;
    }

    public final QQFTFileListFilterInfo getSelectedCategoryInfo() {
        QQFTFileListFilterInfo qQFTFileListFilterInfo;
        Iterator<QQFTFileListFilterInfo> it = this.categoryInfos.iterator();
        while (true) {
            if (!it.hasNext()) {
                qQFTFileListFilterInfo = null;
                break;
            }
            qQFTFileListFilterInfo = it.next();
            if (qQFTFileListFilterInfo.isSelected.getValue().booleanValue()) {
                break;
            }
        }
        return qQFTFileListFilterInfo;
    }

    public final int getSkeletonSize() {
        if (this.fileCategory.getValue().intValue() != 0) {
            Iterator<QQFTFileListFilterInfo> it = this.categoryInfos.iterator();
            while (it.hasNext()) {
                QQFTFileListFilterInfo next = it.next();
                if (next.categoryInfo.f446176a == this.fileCategory.getValue().intValue()) {
                    return next.categoryInfo.f446177b;
                }
            }
        }
        return Math.min((int) m116getCurPageFirstLevelItemCountsVKNKU(), getFileListReqCount(false));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006f  */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void handleExpiredList() {
        int size = this.otherVMList.size() + this.finishedVMList.size();
        if (size > 0) {
            br value = this.fileSet.getValue();
            Intrinsics.checkNotNull(value);
            if (size < ((int) value.f446189c) && this.showExpiredList.getValue().booleanValue()) {
                this.showCacheTips.setValue(Boolean.TRUE);
                this.feedListViewModel.feedCardViewModelList.clear();
                this.feedListViewModel.feedCardViewModelList.add((QQFTTitleStatusCardVM) this.titleStatusCardVM$delegate.getValue());
                this.itemVMList.clear();
                if (!this.finishedVMList.isEmpty()) {
                    this.feedListViewModel.feedCardViewModelList.add((QQFTExpiredHeaderCardVM) this.expiredHeaderCardVM$delegate.getValue());
                } else {
                    this.feedListViewModel.feedCardViewModelList.add((QQFTExpiredHeaderCardVM) this.downloadedHeaderCardVM$delegate.getValue());
                    this.itemVMList.addAll(this.finishedVMList);
                    this.feedListViewModel.feedCardViewModelList.addAll(this.itemVMList);
                    if (!this.otherVMList.isEmpty()) {
                        this.feedListViewModel.feedCardViewModelList.add((QQFTExpiredHeaderCardVM) this.expiredHeaderCardVM$delegate.getValue());
                    }
                }
                if (this.showExpiredList.getValue().booleanValue()) {
                    this.itemVMList.addAll(this.otherVMList);
                    this.feedListViewModel.feedCardViewModelList.addAll(this.otherVMList);
                }
                this.footerRefreshState.setValue(FooterRefreshState.NONE_MORE_DATA);
                this.isFileSetExpired.setValue(Boolean.TRUE);
            }
        }
        this.showCacheTips.setValue(Boolean.FALSE);
        this.feedListViewModel.feedCardViewModelList.clear();
        this.feedListViewModel.feedCardViewModelList.add((QQFTTitleStatusCardVM) this.titleStatusCardVM$delegate.getValue());
        this.itemVMList.clear();
        if (!this.finishedVMList.isEmpty()) {
        }
        if (this.showExpiredList.getValue().booleanValue()) {
        }
        this.footerRefreshState.setValue(FooterRefreshState.NONE_MORE_DATA);
        this.isFileSetExpired.setValue(Boolean.TRUE);
    }

    public final boolean isBottomBarShow() {
        return isSelectAndDownloadBarShow() || canShowAllSelectCheckBox();
    }

    public final boolean isCompressFirstLevelPage() {
        if (this.parentId.getValue().length() == 0) {
            if (this.compressedFileFolderId.length() > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean isCompressFolderPage() {
        if (this.parentId.getValue().length() > 0) {
            if (this.compressedFileFolderId.length() > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean isCompressPage() {
        return this.compressedFileFolderId.length() > 0;
    }

    public final boolean isDisableClick() {
        return this.selectFilesToDownload.size() > 0;
    }

    public final boolean isDownloadBarShow() {
        if (this.inProgressAnim.getValue().booleanValue()) {
            return true;
        }
        Integer value = this.fileSetDownLoadTaskStatus.getValue();
        if (value != null && value.intValue() == 4) {
            return true;
        }
        Integer value2 = this.fileSetDownLoadTaskStatus.getValue();
        return (value2 != null && value2.intValue() == 1) || this.forceShowDownloadBar.getValue().booleanValue();
    }

    public final boolean isFileSetInvalid() {
        br value = this.fileSet.getValue();
        if (value != null && value.f446201o == 3) {
            return true;
        }
        br value2 = this.fileSet.getValue();
        if (value2 != null && value2.f446201o == 4) {
            return true;
        }
        br value3 = this.fileSet.getValue();
        if (value3 != null && value3.f446201o == 5) {
            return true;
        }
        br value4 = this.fileSet.getValue();
        if (value4 != null && value4.f446201o == 6) {
            return true;
        }
        br value5 = this.fileSet.getValue();
        return value5 != null && value5.f446201o == 7;
    }

    /* renamed from: isFromH5SelectHit-WZ4Q5Ns, reason: not valid java name */
    public final boolean m117isFromH5SelectHitWZ4Q5Ns(int i3) {
        return Intrinsics.areEqual(this.fromH5AllCheck.getValue(), "1") || this.fromH5SelectItems.contains(Long.valueOf(((long) i3) & 4294967295L));
    }

    public final boolean isImageGridMode() {
        if (this.isGridMode.getValue().booleanValue() && (this.fileCategory.getValue().intValue() == 2 || this.fileCategory.getValue().intValue() == 3)) {
            return true;
        }
        return this.clusterId.length() > 0;
    }

    public final boolean isInUploading() {
        return this.creatorUploadStatus.getValue().intValue() == 1 || this.creatorUploadStatus.getValue().intValue() == 2 || this.creatorUploadStatus.getValue().intValue() == 3 || this.creatorUploadStatus.getValue().intValue() == 5 || this.creatorUploadStatus.getValue().intValue() == 6 || this.creatorUploadStatus.getValue().intValue() == 7;
    }

    public final boolean isNormalGridMode() {
        return this.isGridMode.getValue().booleanValue() && !isImageGridMode();
    }

    public final boolean isPrepareDownload() {
        Integer value;
        Integer value2;
        Integer value3 = this.fileSetDownLoadTaskStatus.getValue();
        if ((value3 == null || value3.intValue() != 4) && (((value = this.fileSetDownLoadTaskStatus.getValue()) == null || value.intValue() != 1) && this.forceShowDownloadBar.getValue().booleanValue())) {
            return true;
        }
        ca value4 = this.fileSetDownLoadInfo.getValue();
        return (value4 != null && value4.f446240k) && (value2 = this.fileSetDownLoadTaskStatus.getValue()) != null && value2.intValue() == 1;
    }

    public final boolean isSecondaryPage() {
        if (this.parentId.getValue().length() > 0) {
            return true;
        }
        return (this.clusterId.length() > 0) || isCompressPage();
    }

    public final boolean isSelectAndDownloadBarShow() {
        return isSelectBarShow() || isDownloadBarShow() || isShowDownloadFinishBar();
    }

    public final boolean isSelectBarShow() {
        return this.selectFilesToDownload.size() > 0;
    }

    public final boolean isShowDownloadFinishBar() {
        Integer value;
        int compare;
        if (!this.showFinishDownloadBar.getValue().booleanValue()) {
            return false;
        }
        Integer value2 = this.fileSetDownLoadTaskStatus.getValue();
        if (((value2 == null || value2.intValue() != 2) && ((value = this.fileSetDownLoadTaskStatus.getValue()) == null || value.intValue() != 3)) || this.fileSetDownLoadInfo.getValue() == null) {
            return false;
        }
        ca value3 = this.fileSetDownLoadInfo.getValue();
        Intrinsics.checkNotNull(value3);
        compare = Integer.compare(value3.f446231b ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE);
        return compare > 0;
    }

    public final boolean isUploadCreator() {
        if (this.fileSet.getValue() != null) {
            br value = this.fileSet.getValue();
            Intrinsics.checkNotNull(value);
            if (value.f446200n) {
                return true;
            }
        }
        return false;
    }

    public final boolean needShowAIClusterListView() {
        return (isFileSetInvalid() || this.firstClusteringList.size() <= 0 || isSecondaryPage()) ? false : true;
    }

    public final void onDestroy() {
        QQFlashTransferViewModel$addFileSetClusteringListListener$1 qQFlashTransferViewModel$addFileSetClusteringListListener$1 = this.clusterListener;
        if (qQFlashTransferViewModel$addFileSetClusteringListListener$1 != null) {
            IKernelFlashTransferService.f344757i.a().h(qQFlashTransferViewModel$addFileSetClusteringListListener$1);
        }
        cancelPollFilesTransferProgressListener();
        String str = this.downloadFinishBarCloseNotifyListener;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadFinishBarCloseNotifyListener");
            str = null;
        }
        c cVar = c.f117352a;
        ((com.tencent.kuikly.core.module.k) cVar.g().acquireModule("KRNotifyModule")).e("kQQFTDownloadFinishBarCloseNotify", str);
        String str3 = this.parentCompressDownloadNotifyListener;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentCompressDownloadNotifyListener");
        } else {
            str2 = str3;
        }
        ((com.tencent.kuikly.core.module.k) cVar.g().acquireModule("KRNotifyModule")).e("kQQFTCompressFolderDownloadNotify", str2);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
    public final void onFileSetStatusCanceled() {
        String str;
        List<ab> emptyList;
        removeEmptyView();
        onDestroy();
        SnapshotStateList<BaseComposeCardViewModel> snapshotStateList = this.feedListViewModel.feedCardViewModelList;
        ArrayList arrayList = new ArrayList();
        Iterator<BaseComposeCardViewModel> it = snapshotStateList.iterator();
        while (it.hasNext()) {
            BaseComposeCardViewModel next = it.next();
            if (next instanceof QQFTFileDetailItemVM) {
                arrayList.add(next);
            }
        }
        snapshotStateList.removeAll(arrayList);
        this.itemVMList.clear();
        bp bpVar = this.fileLists;
        if (bpVar != null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            bpVar.f446183a = emptyList;
        }
        this.paginationInfo = null;
        MutableState<Boolean> mutableState = this.hasLoadAll;
        Boolean bool = Boolean.FALSE;
        mutableState.setValue(bool);
        this.showFinishDownloadBar.setValue(bool);
        updateSafetyTipsView("\u8be5\u95ea\u4f20\u4efb\u52a1\u5df2\u5220\u9664");
        br brVar = new br();
        brVar.f446187a = this.fileSetId;
        br value = this.fileSet.getValue();
        if (value == null || (str = value.f446188b) == null) {
            str = "";
        }
        brVar.f446188b = str;
        br value2 = this.fileSet.getValue();
        brVar.f446189c = value2 != null ? value2.f446189c : 0L;
        br value3 = this.fileSet.getValue();
        brVar.f446190d = value3 != null ? value3.f446190d : 0L;
        brVar.f446201o = 7;
        br value4 = this.fileSet.getValue();
        brVar.f446196j = value4 != null ? value4.f446196j : 0;
        br value5 = this.fileSet.getValue();
        if (value5 != null) {
            brVar.f446198l = value5.f446198l;
        }
        this.fileSet.setValue(brVar);
    }

    public final void pollFilesTransferProgress(List<String> list) {
        List emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        cn cnVar = new cn(0, "", emptyList, 0, 0L);
        cnVar.f446282b = this.fileSetId;
        cnVar.f446281a = 0;
        cnVar.f446283c = list;
        cnVar.f446284d = this.sceneType;
        IKernelFlashTransferService a16 = IKernelFlashTransferService.f344757i.a();
        a16.getClass();
        ArrayList arrayList = new ArrayList();
        Object[] a17 = cq.a(cnVar);
        arrayList.add(Integer.valueOf(a17.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, a17);
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        a16.syncToNativeMethod(true, "pollFilesTransferProgress", array, null);
    }

    public final void removeEmptyView() {
        if (this.feedListViewModel.feedCardViewModelList.size() > 0 && this.feedListViewModel.feedCardViewModelList.contains(getEmptyListCardVM())) {
            this.feedListViewModel.feedCardViewModelList.remove(getEmptyListCardVM());
        }
    }

    public final void resetDownloadProcess() {
        this.progress.setValue(Float.valueOf(0.0f));
        this.inProgressAnim.setValue(Boolean.FALSE);
        QQFTTransferSizeInterpolation qQFTTransferSizeInterpolation = this.curDownLoadedBytesInterpolation;
        Timer timer = qQFTTransferSizeInterpolation.downloadSpeedTimer;
        if (timer != null) {
            timer.stopTimer();
        }
        qQFTTransferSizeInterpolation.beforeValue = 0L;
        qQFTTransferSizeInterpolation.nextValue = 0L;
        qQFTTransferSizeInterpolation.curValue.setValue(0L);
        KLog.INSTANCE.d("QQFTTransferSizeInterpolation", "reset.");
        qQFTTransferSizeInterpolation.expertCostTime = 500L;
        qQFTTransferSizeInterpolation.startTimerTimestamp = 0L;
    }

    public final void startFileListDownLoad(String str, List<ab> list, cx cxVar, boolean z16) {
        e eVar = new e(0, false, 0L);
        eVar.f446311a = 0;
        eVar.f446312b = true;
        if (z16) {
            if (isCompressPage()) {
                Long curPageFileTotalSize = getCurPageFileTotalSize();
                r2 = curPageFileTotalSize != null ? ULong.m648constructorimpl(curPageFileTotalSize.longValue()) : 0L;
            } else {
                br value = this.fileSet.getValue();
                if (value != null) {
                    r2 = value.f446190d;
                }
            }
            eVar.f446313c = r2;
        } else {
            Iterator<ab> it = list.iterator();
            while (it.hasNext()) {
                eVar.f446313c = ULong.m648constructorimpl(ULong.m648constructorimpl(UInt.m570constructorimpl((int) it.next().f446164o) & 4294967295L) + eVar.f446313c);
            }
        }
        final QQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1 qQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1 = new QQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1(this, z16, str, list, cxVar);
        IKernelFlashTransferService a16 = IKernelFlashTransferService.f344757i.a();
        a16.getClass();
        ArrayList arrayList = new ArrayList();
        Object[] a17 = h.a(eVar);
        arrayList.add(Integer.valueOf(a17.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, a17);
        arrayList.add(String.valueOf(qQFlashTransferViewModel$startFileListDownLoad$checkDeviceStatusCallback$1.hashCode()));
        Function1<Object, Unit> function1 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$checkDeviceStatus$kernelCallback$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                Object[] objArr = obj instanceof Object[] ? (Object[]) obj : null;
                if (objArr != null) {
                    if (!(objArr.length == 0)) {
                        Iterator it5 = ArrayIteratorKt.iterator(objArr);
                        if (Intrinsics.areEqual((String) dr.a(it5, "null cannot be cast to non-null type kotlin.String"), "onCheckDeviceStatus")) {
                            Object next = it5.next();
                            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
                            int intValue = ((Integer) next).intValue();
                            Object[] objArr2 = new Object[intValue];
                            for (int i3 = 0; i3 < intValue; i3++) {
                                objArr2[i3] = it5.next();
                            }
                            Iterator it6 = ArrayIteratorKt.iterator(objArr2);
                            i iVar = new i(new LinkedHashMap());
                            while (it6.hasNext()) {
                                Object next2 = it6.next();
                                if (Intrinsics.areEqual(next2, "seq")) {
                                    Object next3 = it6.next();
                                    Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int");
                                    ((Integer) next3).intValue();
                                } else if (Intrinsics.areEqual(next2, "invalidStatus")) {
                                    Object next4 = it6.next();
                                    Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.Int");
                                    int intValue2 = ((Integer) next4).intValue();
                                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                                    for (int i16 = 0; i16 < intValue2; i16++) {
                                        Object next5 = it6.next();
                                        Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue3 = ((Integer) next5).intValue();
                                        Object next6 = it6.next();
                                        Intrinsics.checkNotNull(next6, "null cannot be cast to non-null type kotlin.String");
                                        linkedHashMap.put(Integer.valueOf(intValue3), (String) next6);
                                    }
                                    iVar.f446371a = linkedHashMap;
                                }
                            }
                            cs.this.onCheckDeviceStatus(iVar);
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        };
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        a16.syncToNativeMethod(true, "checkDeviceStatus", array, function1);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
    public final void updateAllItem(boolean z16) {
        KLog.INSTANCE.d("QQFlashTransferFileListViewModel", "updateAllItem " + z16);
        if (z16) {
            Iterator it = this.itemVMList.iterator();
            while (it.hasNext()) {
                QQFTFileDetailItemVM qQFTFileDetailItemVM = (QQFTFileDetailItemVM) it.next();
                qQFTFileDetailItemVM.isSelected.setValue(Boolean.valueOf(z16));
                ab abVar = qQFTFileDetailItemVM.fileDetail;
                if (abVar != null) {
                    if (!this.selectFilesToDownload.containsKey(abVar.f446151b)) {
                        this.selectFilesToDownload.put(abVar.f446151b, abVar);
                    }
                    updateAllSelectFileDownloadPause(abVar, true);
                }
            }
        } else {
            Iterator it5 = this.itemVMList.iterator();
            while (it5.hasNext()) {
                ((QQFTFileDetailItemVM) it5.next()).isSelected.setValue(Boolean.valueOf(z16));
            }
            this.selectFilesToDownload.clear();
            updateAllSelectFileDownloadPause(null, false);
        }
        this.isAllSelectMode.setValue(Boolean.valueOf(z16));
    }

    public final void updateAllSelectFileDownloadPause(ab abVar, boolean z16) {
        boolean z17 = false;
        if (this.selectFilesToDownload.size() == 0) {
            this.isAllSelectFilePause.setValue(0);
            return;
        }
        if (abVar != null && abVar.C == 4) {
            z17 = true;
        }
        if (z17) {
            if (z16) {
                MutableState<Integer> mutableState = this.isAllSelectFilePause;
                mutableState.setValue(Integer.valueOf(mutableState.getValue().intValue() + 1));
            } else {
                this.isAllSelectFilePause.setValue(Integer.valueOf(r4.getValue().intValue() - 1));
            }
        }
    }

    public final void updateDownloadFailedFileList() {
        String str = this.fileSetId;
        IKernelFlashTransferService a16 = IKernelFlashTransferService.f344757i.a();
        final dc dcVar = new dc() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$updateDownloadFailedFileList$1
            @Override // ws3.dc
            public final void onGetFailedFileList(final cg cgVar) {
                final QQFlashTransferViewModel qQFlashTransferViewModel = QQFlashTransferViewModel.this;
                SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$updateDownloadFailedFileList$1$onGetFailedFileList$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        if (Intrinsics.areEqual(cg.this.f446261c, qQFlashTransferViewModel.fileSetId)) {
                            qQFlashTransferViewModel.downloadFailedFileList.clear();
                            for (ab abVar : cg.this.f446262d) {
                                QQFTFailedFileInfo qQFTFailedFileInfo = new QQFTFailedFileInfo();
                                qQFTFailedFileInfo.setFailedFile(abVar);
                                if (!qQFlashTransferViewModel.downloadFailedFileList.containsKey(abVar.f446151b)) {
                                    qQFlashTransferViewModel.downloadFailedFileList.put(abVar.f446151b, qQFTFailedFileInfo);
                                }
                            }
                        }
                        KLog kLog = KLog.INSTANCE;
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getFailedFileList result=");
                        m3.append(cg.this.f446259a);
                        m3.append(" errMsg=");
                        m3.append(cg.this.f446260b);
                        m3.append(" size=");
                        StringBuilder m16 = NearbyFDPageViewModel$$ExternalSyntheticOutline0.m(cg.this.f446262d, m3, " / ");
                        ca value = qQFlashTransferViewModel.fileSetDownLoadInfo.getValue();
                        m16.append(value != null ? value.f446238i : null);
                        kLog.e("QQFlashTransferFileListViewModel", m16.toString());
                        return Unit.INSTANCE;
                    }
                });
            }
        };
        a16.getClass();
        ArrayList arrayList = new ArrayList();
        ArrayList m3 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m("seq");
        m3.add(0);
        m3.add("fileSetId");
        m3.add(str);
        m3.add("type");
        m3.add(1);
        Object[] array = m3.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        arrayList.add(Integer.valueOf(array.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, array);
        arrayList.add(String.valueOf(dcVar.hashCode()));
        Function1<Object, Unit> function1 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$getFailedFileList$kernelCallback$1
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
                        if (Intrinsics.areEqual((String) dr.a(it, "null cannot be cast to non-null type kotlin.String"), "onGetFailedFileList")) {
                            Object next = it.next();
                            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
                            int intValue = ((Integer) next).intValue();
                            Object[] objArr2 = new Object[intValue];
                            for (int i3 = 0; i3 < intValue; i3++) {
                                objArr2[i3] = it.next();
                            }
                            Iterator it5 = ArrayIteratorKt.iterator(objArr2);
                            emptyList = CollectionsKt__CollectionsKt.emptyList();
                            cg cgVar = new cg(0, "", "", emptyList);
                            while (it5.hasNext()) {
                                Object next2 = it5.next();
                                if (Intrinsics.areEqual(next2, "seq")) {
                                    Object next3 = it5.next();
                                    Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int");
                                    ((Integer) next3).intValue();
                                } else if (Intrinsics.areEqual(next2, "result")) {
                                    Object next4 = it5.next();
                                    Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.Int");
                                    cgVar.f446259a = ((Integer) next4).intValue();
                                } else if (Intrinsics.areEqual(next2, "errMs")) {
                                    Object next5 = it5.next();
                                    Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.String");
                                    cgVar.f446260b = (String) next5;
                                } else if (Intrinsics.areEqual(next2, "fileSetId")) {
                                    Object next6 = it5.next();
                                    Intrinsics.checkNotNull(next6, "null cannot be cast to non-null type kotlin.String");
                                    cgVar.f446261c = (String) next6;
                                } else if (Intrinsics.areEqual(next2, "fileList")) {
                                    Object next7 = it5.next();
                                    Intrinsics.checkNotNull(next7, "null cannot be cast to non-null type kotlin.Int");
                                    int intValue2 = ((Integer) next7).intValue();
                                    ArrayList arrayList2 = new ArrayList();
                                    for (int i16 = 0; i16 < intValue2; i16++) {
                                        Object next8 = it5.next();
                                        Intrinsics.checkNotNull(next8, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue3 = ((Integer) next8).intValue();
                                        Object[] objArr3 = new Object[intValue3];
                                        for (int i17 = 0; i17 < intValue3; i17++) {
                                            objArr3[i17] = it5.next();
                                        }
                                        arrayList2.add(bo.b(objArr3));
                                    }
                                    cgVar.f446262d = arrayList2;
                                }
                            }
                            dc.this.onGetFailedFileList(cgVar);
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        };
        Object[] array2 = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        a16.syncToNativeMethod(true, "getFailedFileList", array2, function1);
    }

    /* renamed from: updateFailedFileList-hJeF8fQ, reason: not valid java name */
    public final void m118updateFailedFileListhJeF8fQ(QQFTFileDetailItemVM qQFTFileDetailItemVM, String str, int i3, int i16) {
        ad adVar;
        eg egVar;
        List<eq> list;
        ad adVar2;
        boolean containsKey = this.downloadFailedFileList.containsKey(str);
        Object obj = null;
        if (containsKey || i3 != 5 || qQFTFileDetailItemVM.fileDetail == null) {
            if (containsKey) {
                if (i3 == 3) {
                    this.downloadFailedFileList.remove(str);
                } else {
                    QQFTFailedFileInfo qQFTFailedFileInfo = this.downloadFailedFileList.get(str);
                    if (qQFTFailedFileInfo != null) {
                        qQFTFailedFileInfo.setDownloadStatus(i3);
                    }
                }
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("updateFailedFileDownloadStatus remove name=");
                ab abVar = qQFTFileDetailItemVM.fileDetail;
                m3.append(abVar != null ? abVar.f446160k : null);
                m3.append(" id=");
                ab abVar2 = qQFTFileDetailItemVM.fileDetail;
                m3.append(abVar2 != null ? abVar2.f446151b : null);
                m3.append(" errorCode=");
                ab abVar3 = qQFTFileDetailItemVM.fileDetail;
                if (abVar3 != null && (adVar = abVar3.f446171v) != null) {
                    obj = UInt.m564boximpl(adVar.f446182d);
                }
                m3.append(obj);
                m3.append(" status=");
                m3.append(i3);
                kLog.d("QQFlashTransferFileListViewModel", m3.toString());
                return;
            }
            return;
        }
        QQFTFailedFileInfo qQFTFailedFileInfo2 = new QQFTFailedFileInfo();
        ab abVar4 = qQFTFileDetailItemVM.fileDetail;
        Intrinsics.checkNotNull(abVar4);
        qQFTFailedFileInfo2.setFailedFile(abVar4);
        qQFTFailedFileInfo2.failedFile.f446171v.f446182d = i16;
        qQFTFailedFileInfo2.setDownloadStatus(5);
        this.downloadFailedFileList.put(str, qQFTFailedFileInfo2);
        KLog kLog2 = KLog.INSTANCE;
        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("updateFileDownloadStatus onFileDownLoadDidError name=");
        ab abVar5 = qQFTFileDetailItemVM.fileDetail;
        m16.append(abVar5 != null ? abVar5.f446160k : null);
        m16.append(" id=");
        ab abVar6 = qQFTFileDetailItemVM.fileDetail;
        m16.append(abVar6 != null ? abVar6.f446151b : null);
        m16.append(" errorCode=");
        ab abVar7 = qQFTFileDetailItemVM.fileDetail;
        m16.append((abVar7 == null || (adVar2 = abVar7.f446171v) == null) ? null : UInt.m564boximpl(adVar2.f446182d));
        m16.append(" / ");
        m16.append((Object) UInt.m615toStringimpl(i16));
        m16.append(" urlsSize=");
        ab abVar8 = qQFTFileDetailItemVM.fileDetail;
        if (abVar8 != null && (egVar = abVar8.f446166q) != null && (list = egVar.f446333b) != null) {
            obj = Integer.valueOf(list.size());
        }
        m16.append(obj);
        kLog2.d("QQFlashTransferFileListViewModel", m16.toString());
    }

    public final boolean updateFeedCardItem(ab abVar, boolean z16) {
        Iterator<BaseComposeCardViewModel> it = this.feedListViewModel.feedCardViewModelList.iterator();
        while (it.hasNext()) {
            BaseComposeCardViewModel next = it.next();
            if (next instanceof QQFTFileDetailItemVM) {
                QQFTFileDetailItemVM qQFTFileDetailItemVM = (QQFTFileDetailItemVM) next;
                ab abVar2 = qQFTFileDetailItemVM.fileDetail;
                if (Intrinsics.areEqual(abVar2 != null ? abVar2.f446151b : null, abVar.f446151b)) {
                    if (!z16) {
                        qQFTFileDetailItemVM.updateFile(abVar);
                        qQFTFileDetailItemVM.isFromCache = false;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final void updateFileContentOffset(int i3) {
        if (this.fileContentTopOffset == null) {
            return;
        }
        int size = this.selectFilesToDownload.size();
        if (size > 0 && i3 == 0) {
            float f16 = this.pageListHeight;
            Float f17 = this.fileContentTopOffset;
            Intrinsics.checkNotNull(f17);
            float floatValue = f17.floatValue();
            c cVar = c.f117352a;
            if (f16 > cVar.g().getPageData().l() + floatValue) {
                float c16 = getListState().c();
                Float f18 = this.fileContentTopOffset;
                Intrinsics.checkNotNull(f18);
                if (c16 < f18.floatValue()) {
                    this.isInSelectFileScrollAnim.setValue(Boolean.TRUE);
                    f.l(getListState(), 0.0f, getSelectScrollOffset(), true, null, 8, null);
                } else {
                    getListState().u(Float.valueOf(getSelectScrollOffset()));
                }
            } else {
                float selectScrollOffset = ((getSelectScrollOffset() + cVar.g().getPageData().l()) - this.pageListHeight) - getLazyListBottomPadding();
                if (this.hasShowBarBeforeScroll) {
                    selectScrollOffset += 80.0f;
                }
                this.feedListViewModel.feedCardViewModelList.add(new QQFTPlaceHolderCardVM(selectScrollOffset, this));
                SchedulerKt.b(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$updateFileContentOffset$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        QQFlashTransferViewModel.this.isInSelectFileScrollAnim.setValue(Boolean.TRUE);
                        f.l(QQFlashTransferViewModel.this.getListState(), 0.0f, QQFlashTransferViewModel.this.getSelectScrollOffset(), true, null, 8, null);
                        return Unit.INSTANCE;
                    }
                });
            }
        } else if (size == 0 && i3 > 0) {
            getListState().u(null);
            float c17 = getListState().c() - 1;
            Float f19 = this.fileContentTopOffset;
            Intrinsics.checkNotNull(f19);
            if (c17 < f19.floatValue()) {
                this.isInSelectFileScrollAnim.setValue(Boolean.TRUE);
                f.l(getListState(), 0.0f, 0.0f, true, null, 8, null);
            }
        }
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("updateFileContentOffset fileContentTopOffset=");
        m3.append(this.fileContentTopOffset);
        m3.append(" contentOffset=");
        m3.append(getListState().c());
        m3.append(" pageListHeight=");
        m3.append(this.pageListHeight);
        kLog.d("QQFlashTransferFileListViewModel", m3.toString());
    }

    /* renamed from: updateFileDownloadStatus-jXDDuk8, reason: not valid java name */
    public final void m119updateFileDownloadStatusjXDDuk8(ws3.c cVar, int i3, int i16) {
        ab abVar;
        ab abVar2;
        Iterator<BaseComposeCardViewModel> it = this.feedListViewModel.feedCardViewModelList.iterator();
        while (it.hasNext()) {
            BaseComposeCardViewModel next = it.next();
            if (next instanceof QQFTFileDetailItemVM) {
                QQFTFileDetailItemVM qQFTFileDetailItemVM = (QQFTFileDetailItemVM) next;
                ab abVar3 = qQFTFileDetailItemVM.fileDetail;
                if (Intrinsics.areEqual(abVar3 != null ? abVar3.f446151b : null, cVar.f446228a)) {
                    ab abVar4 = qQFTFileDetailItemVM.fileDetail;
                    if (abVar4 != null) {
                        abVar4.C = i3;
                    }
                    qQFTFileDetailItemVM.downloadStatus.setValue(Integer.valueOf(i3));
                    m118updateFailedFileListhJeF8fQ(qQFTFileDetailItemVM, cVar.f446228a, i3, i16);
                    if (this.downloadingFileList.containsKey(cVar.f446228a) && (abVar2 = this.downloadingFileList.get(cVar.f446228a)) != null) {
                        abVar2.C = i3;
                    }
                    if (!this.selectFilesToDownload.containsKey(cVar.f446228a) || (abVar = this.selectFilesToDownload.get(cVar.f446228a)) == null) {
                        return;
                    }
                    abVar.C = i3;
                    return;
                }
            }
        }
    }

    public final void updateFileUploadStatus(ab abVar, int i3) {
        Iterator<BaseComposeCardViewModel> it = this.feedListViewModel.feedCardViewModelList.iterator();
        while (it.hasNext()) {
            BaseComposeCardViewModel next = it.next();
            if (next instanceof QQFTFileDetailItemVM) {
                QQFTFileDetailItemVM qQFTFileDetailItemVM = (QQFTFileDetailItemVM) next;
                ab abVar2 = qQFTFileDetailItemVM.fileDetail;
                if (Intrinsics.areEqual(abVar2 != null ? abVar2.f446151b : null, abVar.f446151b)) {
                    ab abVar3 = qQFTFileDetailItemVM.fileDetail;
                    if (abVar3 != null) {
                        abVar3.B = i3;
                    }
                    qQFTFileDetailItemVM.uploadStatus.setValue(Integer.valueOf(i3));
                    return;
                }
            }
        }
    }

    public final void updateSafetyTipsView(String str) {
        Object last;
        Object last2;
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.feedListViewModel.feedCardViewModelList);
        if (last instanceof QQFTEmptyListCardVM) {
            CollectionsKt__MutableCollectionsKt.removeLast(this.feedListViewModel.feedCardViewModelList);
            KLog.INSTANCE.e("QQFlashTransferFileListViewModel", "updateEmptyView error for duplicate. text:" + str);
        }
        last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.feedListViewModel.feedCardViewModelList);
        if (last2 instanceof QQFTFileDetailItemVM) {
            KLog.INSTANCE.d("QQFlashTransferFileListViewModel", "updateEmptyView failed for fileDetail");
        } else {
            clearFileSkeletonView();
            this.feedListViewModel.feedCardViewModelList.add(new QQFTEmptyListCardVM(this, str));
        }
    }

    /* JADX WARN: Type inference failed for: r10v16, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r13v6, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
    public static final void access$initFileListData(QQFlashTransferViewModel qQFlashTransferViewModel, boolean z16) {
        List<ab> list;
        int size;
        boolean z17;
        List<ab> list2;
        bp bpVar = qQFlashTransferViewModel.fileLists;
        if (bpVar == null || (list = bpVar.f446183a) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        bp bpVar2 = qQFlashTransferViewModel.fileLists;
        boolean z18 = true;
        if ((bpVar2 != null && bpVar2.f446186d) && qQFlashTransferViewModel.filterType.getValue() != FTFilterType.NOT_DOWNLOAD_FILE) {
            size = qQFlashTransferViewModel.getFileListReqCount(false);
        } else {
            size = list.size();
        }
        if (size > list.size()) {
            size = list.size();
        }
        bp bpVar3 = qQFlashTransferViewModel.fileLists;
        Intrinsics.checkNotNull(bpVar3);
        boolean z19 = bpVar3.f446186d;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("initFileListData fileLists size=");
        bp bpVar4 = qQFlashTransferViewModel.fileLists;
        m3.append((bpVar4 == null || (list2 = bpVar4.f446183a) == null) ? null : Integer.valueOf(list2.size()));
        m3.append(" isSelected=");
        m3.append(z16);
        m3.append(" showFilterList=");
        m3.append(qQFlashTransferViewModel.showFilterList.getValue().booleanValue());
        m3.append(" itemSize=");
        m3.append(qQFlashTransferViewModel.itemVMList.size());
        m3.append(" renderCount=");
        m3.append(size);
        m3.append(" isFromCache=");
        NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0.m(m3, z19, kLog, "QQFlashTransferFileListViewModel");
        int i3 = 0;
        while (i3 < size) {
            if (!qQFlashTransferViewModel.updateFeedCardItem(list.get(i3), z19)) {
                QQFTFileDetailItemVM qQFTFileDetailItemVM = new QQFTFileDetailItemVM(qQFlashTransferViewModel, list.get(i3), false);
                qQFTFileDetailItemVM.updateThumbnailUrl(list.get(i3).f446166q);
                qQFTFileDetailItemVM.isSelected.setValue(Boolean.valueOf(z16));
                qQFTFileDetailItemVM.isFromCache = z19;
                arrayList2.add(qQFTFileDetailItemVM);
                if (qQFlashTransferViewModel.m117isFromH5SelectHitWZ4Q5Ns(list.get(i3).f446158i)) {
                    qQFTFileDetailItemVM.isSelected.setValue(Boolean.TRUE);
                    arrayList.add(list.get(i3));
                }
                qQFlashTransferViewModel.itemVMList.add(qQFTFileDetailItemVM);
            } else if (!z19) {
                ab abVar = list.get(i3);
                Iterator it = qQFlashTransferViewModel.itemVMList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    QQFTFileDetailItemVM qQFTFileDetailItemVM2 = (QQFTFileDetailItemVM) it.next();
                    ab abVar2 = qQFTFileDetailItemVM2.fileDetail;
                    if (Intrinsics.areEqual(abVar2 != null ? abVar2.f446151b : null, abVar.f446151b)) {
                        qQFTFileDetailItemVM2.updateFile(abVar);
                        qQFTFileDetailItemVM2.isFromCache = false;
                        break;
                    }
                }
            }
            bp bpVar5 = qQFlashTransferViewModel.fileLists;
            if ((bpVar5 == null || bpVar5.f446186d) ? false : true) {
                z17 = true;
                if (list.get(i3).B == 1 || list.get(i3).B == 2 || list.get(i3).B == 4 || list.get(i3).A == 4) {
                    arrayList3.add(list.get(i3).f446168s);
                }
            } else {
                z17 = true;
            }
            i3++;
            z18 = z17;
        }
        boolean z26 = z18;
        if (!z19) {
            SnapshotStateList<BaseComposeCardViewModel> snapshotStateList = qQFlashTransferViewModel.feedListViewModel.feedCardViewModelList;
            ArrayList arrayList4 = new ArrayList();
            Iterator<BaseComposeCardViewModel> it5 = snapshotStateList.iterator();
            while (it5.hasNext()) {
                BaseComposeCardViewModel next = it5.next();
                BaseComposeCardViewModel baseComposeCardViewModel = next;
                if (((baseComposeCardViewModel instanceof QQFTFileDetailItemVM) && ((QQFTFileDetailItemVM) baseComposeCardViewModel).isFromCache) ? z26 : false) {
                    arrayList4.add(next);
                }
            }
            snapshotStateList.removeAll(arrayList4);
            ?? r16 = qQFlashTransferViewModel.itemVMList;
            ArrayList arrayList5 = new ArrayList();
            Iterator it6 = r16.iterator();
            while (it6.hasNext()) {
                Object next2 = it6.next();
                if (((QQFTFileDetailItemVM) next2).isFromCache) {
                    arrayList5.add(next2);
                }
            }
            r16.removeAll(arrayList5);
        }
        if (arrayList3.size() > 0) {
            qQFlashTransferViewModel.uploadingFileIds.addAll(arrayList3);
            qQFlashTransferViewModel.pollFilesTransferProgress(arrayList3);
        }
        if (!arrayList2.isEmpty()) {
            qQFlashTransferViewModel.feedListViewModel.feedCardViewModelList.addAll(arrayList2);
        }
        if (arrayList.size() > 0) {
            KLog kLog2 = KLog.INSTANCE;
            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("initFileListData startFileListDownLoad size=");
            m16.append(arrayList.size());
            kLog2.d("QQFlashTransferFileListViewModel", m16.toString());
            qQFlashTransferViewModel.startFileListDownLoad(qQFlashTransferViewModel.fileSetId, arrayList, new cx() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$initFileListData$1$1
                @Override // ws3.cx
                /* renamed from: onResult-jXDDuk8, reason: not valid java name */
                public final void mo120onResultjXDDuk8(final int i16, final String str, final int i17) {
                    SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$initFileListData$1$1$onResult$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            KLog kLog3 = KLog.INSTANCE;
                            StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("initFileListData handleDownloadFiles startFileListDownLoad result=");
                            m17.append(i16);
                            m17.append(" errMsg=");
                            m17.append(str);
                            m17.append(" extraInfo=");
                            m17.append((Object) UInt.m615toStringimpl(i17));
                            kLog3.d("QQFlashTransferFileListViewModel", m17.toString());
                            return Unit.INSTANCE;
                        }
                    });
                }
            }, false);
        }
    }

    public final void internalStartDownloadFileList(final String str, boolean z16, List<ab> list, final cx cxVar) {
        List<ab> listOf;
        if (z16) {
            if (this.compressedFileFolderId.length() == 0) {
                if (this.parentId.getValue().length() > 0) {
                    ab abVar = new ab();
                    abVar.f446150a = str;
                    abVar.f446151b = this.parentId.getValue();
                    abVar.f446155f = true;
                    abVar.f446160k = this.pageTitle.getValue();
                    abVar.f446168s = this.parentId.getValue();
                    abVar.f446158i = 1;
                    abVar.f446159j = 25;
                    abVar.f446165p = UInt.m570constructorimpl(this.dirFileCount.getValue().intValue());
                    abVar.f446164o = ULong.m648constructorimpl(this.dirFileSize.getValue().longValue());
                    IKernelFlashTransferService a16 = IKernelFlashTransferService.f344757i.a();
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(abVar);
                    a16.n(str, listOf, cxVar);
                    return;
                }
            }
            if ((this.clusterId.length() > 0) && this.clusterType >= 0) {
                this.repo.fetchAllClusteringDetailFiles(new ArrayList<>(), str, this.clusterId, this.clusterType, null, new Function1<List<? extends ab>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$internalStartDownloadFileList$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(List<? extends ab> list2) {
                        List<? extends ab> list3 = list2;
                        KLog kLog = KLog.INSTANCE;
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchAllClusteringDetailFiles size=");
                        m3.append(list3.size());
                        kLog.d("QQFlashTransferFileListViewModel", m3.toString());
                        IKernelFlashTransferService.f344757i.a().n(str, list3, cxVar);
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
            Boolean bool = Boolean.TRUE;
            String str2 = this.compressedFileFolderId;
            KLog.INSTANCE.d("QQFlashTransferFileListViewModel", "startFileSetDownload compressFolder id = " + str2);
            IKernelFlashTransferService a17 = IKernelFlashTransferService.f344757i.a();
            a17.getClass();
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            ArrayList m3 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m("isIncludeCompressInnerFiles");
            if (bool != null) {
                Intrinsics.checkNotNull(bool);
                m3.add(1);
            } else {
                m3.add(new byte[0]);
            }
            m3.add("compressFolderOptionParamsFolderId");
            if (str2 != null) {
                Intrinsics.checkNotNull(str2);
                m3.add(str2);
            } else {
                m3.add(new byte[0]);
            }
            Object[] array = m3.toArray(new Object[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            arrayList.add(Integer.valueOf(array.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, array);
            arrayList.add(String.valueOf(cxVar.hashCode()));
            Function1<Object, Unit> function1 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$startFileSetDownload$kernelCallback$1
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
                                Object next3 = it.next();
                                Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
                                cx.this.mo120onResultjXDDuk8(intValue, (String) next2, vs3.a.a((String) next3));
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
            };
            Object[] array2 = arrayList.toArray(new Object[0]);
            Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            a17.syncToNativeMethod(true, "startFileSetDownload", array2, function1);
            return;
        }
        IKernelFlashTransferService.f344757i.a().n(str, list, cxVar);
    }

    public final void fetchFileList(boolean z16, final boolean z17, final byte[] bArr, final Function2<? super Boolean, ? super Boolean, Unit> function2) {
        List emptyList;
        List<ep> listOf;
        List listOf2;
        KLog kLog = KLog.INSTANCE;
        kLog.d("QQFlashTransferFileListViewModel", "fetchFileList isUseCache=" + z16);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        TimerKt.c(1000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$fetchFileList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                if (!Ref.BooleanRef.this.element) {
                    this.footerRefreshState.setValue(FooterRefreshState.REFRESHING);
                }
                NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchFileList isGotListRsp = "), Ref.BooleanRef.this.element, KLog.INSTANCE, "QQFlashTransferFileListViewModel");
                return Unit.INSTANCE;
            }
        });
        final int fileListReqCount = getFileListReqCount(z17);
        final boolean z18 = this.paginationInfo == null;
        boolean z19 = (!(this.parentId.getValue().length() > 0) || this.filterType.getValue() == FTFilterType.ALL_FILE) ? z16 : false;
        QQFTRepo qQFTRepo = this.repo;
        int i3 = this.sceneType;
        String str = this.fileSetId;
        if (str == null) {
            str = "";
        }
        String str2 = str;
        String value = this.parentId.getValue();
        String str3 = this.indexPath;
        int filterType = getFilterType();
        int intValue = this.fileCategory.getValue().intValue();
        boolean z26 = z19;
        final Function1<ci, Unit> function1 = new Function1<ci, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$fetchFileList$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:103:0x0303, code lost:
            
                if ((r10.isEmpty()) != false) goto L100;
             */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke(ci ciVar) {
                Object firstOrNull;
                List<ab> list;
                FooterRefreshState footerRefreshState;
                List<ab> list2;
                List<ab> list3;
                ci ciVar2 = ciVar;
                Ref.BooleanRef.this.element = true;
                MutableState<Boolean> mutableState = this.isLoadingData;
                Boolean bool = Boolean.FALSE;
                mutableState.setValue(bool);
                this.clearFileSkeletonView();
                if (ciVar2.f446266a == 0 && !ciVar2.f446268c.isEmpty()) {
                    KLog kLog2 = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchFileList result=");
                    m3.append(ciVar2.f446266a);
                    m3.append(" fileListsSize=");
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) ciVar2.f446268c);
                    bp bpVar = (bp) firstOrNull;
                    List<ab> list4 = null;
                    m3.append((bpVar == null || (list3 = bpVar.f446183a) == null) ? null : Integer.valueOf(list3.size()));
                    m3.append(" paginationInfo_size=");
                    byte[] bArr2 = bArr;
                    m3.append(bArr2 != null ? Integer.valueOf(bArr2.length) : null);
                    m3.append(" / ");
                    m3.append(ciVar2.f446268c.get(0).f446184b.length);
                    m3.append(" size=");
                    bp bpVar2 = this.fileLists;
                    m3.append((bpVar2 == null || (list2 = bpVar2.f446183a) == null) ? null : Integer.valueOf(list2.size()));
                    m3.append(" isEnd=");
                    m3.append(ciVar2.f446268c.get(0).f446185c);
                    m3.append(" isCache=");
                    m3.append(ciVar2.f446268c.get(0).f446186d);
                    m3.append(" reqCount=");
                    m3.append(fileListReqCount);
                    m3.append(" filterType=");
                    m3.append(this.getFilterType());
                    kLog2.d("getFileList", m3.toString());
                    if (z17) {
                        for (ab abVar : ciVar2.f446268c.get(0).f446183a) {
                            if (!this.selectFilesToDownload.containsKey(abVar.f446151b)) {
                                this.selectFilesToDownload.put(abVar.f446151b, abVar);
                            }
                        }
                        if (!ciVar2.f446268c.get(0).f446185c) {
                            this.fetchFileList(false, true, ciVar2.f446268c.get(0).f446184b, function2);
                        } else {
                            final QQFlashTransferViewModel qQFlashTransferViewModel = this;
                            TimerKt.c(500, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$fetchFileList$2.2
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    QQFlashTransferViewModel.this.showLoadingAllList.setValue(Boolean.FALSE);
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                    } else {
                        if (z18) {
                            this.fileLists = ciVar2.f446268c.get(0);
                            QQFlashTransferViewModel qQFlashTransferViewModel2 = this;
                            QQFlashTransferViewModel.access$initFileListData(qQFlashTransferViewModel2, qQFlashTransferViewModel2.hasTapSelectAll.getValue().booleanValue());
                        } else {
                            bp bpVar3 = this.fileLists;
                            if (bpVar3 != null && (list = bpVar3.f446183a) != null) {
                                list4 = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
                            }
                            if (list4 != null) {
                                list4.addAll(ciVar2.f446268c.get(0).f446183a);
                                QQFlashTransferViewModel qQFlashTransferViewModel3 = this;
                                bp bpVar4 = qQFlashTransferViewModel3.fileLists;
                                if (bpVar4 != null) {
                                    bpVar4.f446183a = list4;
                                }
                                QQFlashTransferViewModel.access$initLoadMoreFileListData(qQFlashTransferViewModel3, qQFlashTransferViewModel3.hasTapSelectAll.getValue().booleanValue(), ciVar2.f446268c.get(0).f446183a);
                            }
                        }
                        this.paginationInfo = ciVar2.f446268c.get(0).f446184b;
                        if (ciVar2.f446268c.get(0).f446186d) {
                            this.hasLoadAll.setValue(Boolean.TRUE);
                        } else {
                            this.hasLoadAll.setValue(Boolean.valueOf(ciVar2.f446268c.get(0).f446185c));
                        }
                        if (this.hasTapSelectAll.getValue().booleanValue() && this.hasLoadAll.getValue().booleanValue()) {
                            this.hasTapSelectAll.setValue(bool);
                        }
                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("setNoneData isDownloadedFilterHasMoreData=");
                        m16.append(QQFlashTransferViewModel.access$isDownloadedFilterHasMoreData(this));
                        m16.append(" isEnd=");
                        NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0.m(m16, ciVar2.f446268c.get(0).f446185c, kLog2, "getFileList");
                        if (QQFlashTransferViewModel.access$isDownloadedFilterHasMoreData(this)) {
                            Function2<Boolean, Boolean, Unit> function22 = function2;
                            if (function22 != null) {
                                function22.invoke(bool, bool);
                            }
                        } else {
                            Function2<Boolean, Boolean, Unit> function23 = function2;
                            if (function23 != null) {
                                function23.invoke(Boolean.valueOf(ciVar2.f446268c.get(0).f446185c), bool);
                            }
                        }
                        if (z17 && !this.hasLoadAll.getValue().booleanValue()) {
                            QQFlashTransferViewModel qQFlashTransferViewModel4 = this;
                            qQFlashTransferViewModel4.fetchFileList(false, true, qQFlashTransferViewModel4.paginationInfo, function2);
                        }
                        boolean access$updateEmptyView = QQFlashTransferViewModel.access$updateEmptyView(this);
                        QQFlashTransferViewModel qQFlashTransferViewModel5 = this;
                        MutableState<FooterRefreshState> mutableState2 = qQFlashTransferViewModel5.footerRefreshState;
                        if (qQFlashTransferViewModel5.hasLoadAll.getValue().booleanValue() && !access$updateEmptyView && !QQFlashTransferViewModel.access$isDownloadedFilterHasMoreData(this)) {
                            footerRefreshState = FooterRefreshState.NONE_MORE_DATA;
                        } else {
                            footerRefreshState = FooterRefreshState.IDLE;
                        }
                        mutableState2.setValue(footerRefreshState);
                    }
                } else {
                    this.footerRefreshState.setValue(FooterRefreshState.FAILURE);
                    Function2<Boolean, Boolean, Unit> function24 = function2;
                    if (function24 != null) {
                        Boolean bool2 = Boolean.TRUE;
                        function24.invoke(bool2, bool2);
                    }
                    KLog kLog3 = KLog.INSTANCE;
                    StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchFileList error: result=");
                    m17.append(ciVar2.f446266a);
                    m17.append(" errMs=");
                    NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(m17, ciVar2.f446267b, kLog3, "getFileList");
                    Utils.INSTANCE.getClass();
                    if (((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).getNetworkType() != QQKuiklyPlatformApi.QQNetworkType.NOT_REACHABLE) {
                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                        String str4 = ciVar2.f446267b;
                        if (str4.length() == 0) {
                            str4 = "\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                        }
                        companion.qqToast(str4, QToastMode.Warning);
                    }
                    bp bpVar5 = this.fileLists;
                    if (bpVar5 != null && (r10 = bpVar5.f446183a) != null) {
                    }
                    this.updateSafetyTipsView("\u52a0\u8f7d\u5931\u8d25");
                }
                return Unit.INSTANCE;
            }
        };
        qQFTRepo.getClass();
        CollectionsKt__CollectionsKt.emptyList();
        bx bxVar = new bx();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        ei eiVar = new ei("", 0, "", 0, new byte[0], bxVar, emptyList, false);
        eiVar.f446336b = 1;
        eiVar.f446335a = value;
        eiVar.f446337c = str3;
        bxVar.f446224a = UInt.m570constructorimpl(intValue);
        eiVar.f446340f.f446225b = filterType;
        eiVar.f446338d = UInt.m570constructorimpl(fileListReqCount);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new ep(0, 0));
        eiVar.f446341g = listOf;
        if (bArr != null) {
            eiVar.f446339e = bArr;
        }
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(eiVar);
        StringBuilder m3 = PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(j.a("QQFTRepo fileSetId=", str2, " parentId=", value, " indexPath="), str3, " filterType=", filterType, " paginationInfoSize=");
        m3.append(bArr != null ? Integer.valueOf(bArr.length) : null);
        m3.append(" isUseCache=");
        m3.append(z26);
        kLog.d("getFileList", m3.toString());
        IKernelFlashTransferService a16 = IKernelFlashTransferService.f344757i.a();
        final dk dkVar = new dk() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.repo.QQFTRepo$getFileList$1
            @Override // ws3.dk
            public final void onGetFileList(final ci ciVar) {
                final Function1<ci, Unit> function12 = function1;
                SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.repo.QQFTRepo$getFileList$1$onGetFileList$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        function12.invoke(ciVar);
                        return Unit.INSTANCE;
                    }
                });
            }
        };
        a16.getClass();
        ArrayList arrayList = new ArrayList();
        ArrayList m16 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m("seq");
        m16.add(1);
        m16.add("fileSetId");
        m16.add(str2);
        m16.add("reqInfos");
        m16.add(Integer.valueOf(listOf2.size()));
        Iterator it = listOf2.iterator();
        while (it.hasNext()) {
            Object[] a17 = em.a((ei) it.next());
            m16.add(Integer.valueOf(a17.length));
            CollectionsKt__MutableCollectionsKt.addAll(m16, a17);
        }
        m16.add("sceneType");
        m16.add(Integer.valueOf(i3));
        m16.add("isUseCache");
        m16.add(Integer.valueOf(z26 ? 1 : 0));
        Object[] array = m16.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        arrayList.add(Integer.valueOf(array.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, array);
        arrayList.add(String.valueOf(dkVar.hashCode()));
        Function1<Object, Unit> function12 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$getFileList$kernelCallback$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                Object[] objArr = obj instanceof Object[] ? (Object[]) obj : null;
                if (objArr != null) {
                    if (!(objArr.length == 0)) {
                        Iterator it5 = ArrayIteratorKt.iterator(objArr);
                        if (Intrinsics.areEqual((String) dr.a(it5, "null cannot be cast to non-null type kotlin.String"), "onGetFileList")) {
                            Object next = it5.next();
                            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
                            int intValue2 = ((Integer) next).intValue();
                            Object[] objArr2 = new Object[intValue2];
                            for (int i16 = 0; i16 < intValue2; i16++) {
                                objArr2[i16] = it5.next();
                            }
                            Iterator it6 = ArrayIteratorKt.iterator(objArr2);
                            ci ciVar = new ci(0, 0, null, null, 15, null);
                            while (it6.hasNext()) {
                                Object next2 = it6.next();
                                if (Intrinsics.areEqual(next2, "seq")) {
                                    Object next3 = it6.next();
                                    Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int");
                                    ((Integer) next3).intValue();
                                } else if (Intrinsics.areEqual(next2, "result")) {
                                    Object next4 = it6.next();
                                    Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.Int");
                                    ciVar.f446266a = ((Integer) next4).intValue();
                                } else if (Intrinsics.areEqual(next2, "errMs")) {
                                    Object next5 = it6.next();
                                    Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.String");
                                    ciVar.f446267b = (String) next5;
                                } else if (Intrinsics.areEqual(next2, "fileLists")) {
                                    Object next6 = it6.next();
                                    Intrinsics.checkNotNull(next6, "null cannot be cast to non-null type kotlin.Int");
                                    int intValue3 = ((Integer) next6).intValue();
                                    ArrayList arrayList2 = new ArrayList();
                                    for (int i17 = 0; i17 < intValue3; i17++) {
                                        Object next7 = it6.next();
                                        Intrinsics.checkNotNull(next7, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue4 = ((Integer) next7).intValue();
                                        Object[] objArr3 = new Object[intValue4];
                                        for (int i18 = 0; i18 < intValue4; i18++) {
                                            objArr3[i18] = it6.next();
                                        }
                                        arrayList2.add(bq.a(objArr3));
                                    }
                                    ciVar.f446268c = arrayList2;
                                }
                            }
                            dk.this.onGetFileList(ciVar);
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        };
        Object[] array2 = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        a16.syncToNativeMethod(true, "getFileList", array2, function12);
    }

    public final int getFileListReqCount(boolean z16) {
        if (z16) {
            return 200;
        }
        if (isNormalGridMode()) {
            c cVar = c.f117352a;
            return ((int) ((cVar.g().getPageData().l() * 2) / ((((GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(cVar) - 3) - 8.0f) / 3.0f) - 10.0f))) * 3;
        }
        if (!this.isGridMode.getValue().booleanValue()) {
            return (int) ((c.f117352a.g().getPageData().l() * 1.5d) / 71.0f);
        }
        return ((int) (c.f117352a.g().getPageData().l() / ((int) (((GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(r5) - 5) + 1) / 5.0f)))) * 5;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
    public final void fetchPageFileList(boolean z16, final Function2<? super Boolean, ? super Boolean, Unit> function2) {
        List listOf;
        Object last;
        if (this.itemVMList.isEmpty() && this.filterType.getValue() == FTFilterType.ALL_FILE) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.feedListViewModel.feedCardViewModelList);
            if (!(last instanceof QQFTFileSkeletonCardVM)) {
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ADD QQFTFileSkeletonCardVM SkeletonSize=");
                m3.append(getSkeletonSize());
                m3.append(" / ");
                m3.append((Object) ULong.m693toStringimpl(m116getCurPageFirstLevelItemCountsVKNKU()));
                m3.append(TokenParser.SP);
                m3.append(getFileListReqCount(false));
                kLog.d("QQFlashTransferFileListViewModel", m3.toString());
                int skeletonSize = getSkeletonSize();
                for (int i3 = 0; i3 < skeletonSize; i3++) {
                    this.feedListViewModel.feedCardViewModelList.add(new QQFTFileSkeletonCardVM(this));
                }
            }
        }
        if (isCompressPage()) {
            this.isPullingCompressedFileFolderList.setValue(Boolean.TRUE);
            TimerKt.c(1000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$fetchCompressedFileFolder$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    if (QQFlashTransferViewModel.this.isPullingCompressedFileFolderList.getValue().booleanValue()) {
                        QQFlashTransferViewModel.this.footerRefreshState.setValue(FooterRefreshState.REFRESHING);
                    }
                    return Unit.INSTANCE;
                }
            });
            final boolean z17 = this.paginationInfo == null;
            QQFTRepo qQFTRepo = this.repo;
            int i16 = this.sceneType;
            String str = this.compressedFileFolderId;
            String str2 = this.fileSetId;
            if (str2 == null) {
                str2 = "";
            }
            String value = this.parentId.getValue();
            int filterType = getFilterType();
            byte[] bArr = this.paginationInfo;
            final Function1<cf, Unit> function1 = new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$fetchCompressedFileFolder$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                /* JADX WARN: Removed duplicated region for block: B:53:0x024c  */
                @Override // kotlin.jvm.functions.Function1
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Unit invoke(cf cfVar) {
                    String str3;
                    List<ab> list;
                    List<ab> list2;
                    cf cfVar2 = cfVar;
                    MutableState<Boolean> mutableState = QQFlashTransferViewModel.this.isPullingCompressedFileFolderList;
                    Boolean bool = Boolean.FALSE;
                    mutableState.setValue(bool);
                    QQFlashTransferViewModel.this.footerRefreshState.setValue(FooterRefreshState.IDLE);
                    QQFlashTransferViewModel.this.isLoadingData.setValue(bool);
                    QQFlashTransferViewModel.this.clearFileSkeletonView();
                    if (cfVar2.f446252a == 0 && !cfVar2.f446254c.isEmpty()) {
                        KLog kLog2 = KLog.INSTANCE;
                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchCompressedFileFolder result=");
                        m16.append(cfVar2.f446252a);
                        m16.append(" fileListsSize=");
                        StringBuilder m17 = NearbyFDPageViewModel$$ExternalSyntheticOutline0.m(cfVar2.f446254c, m16, " paginationInfo=");
                        m17.append(QQFlashTransferViewModel.this.paginationInfo);
                        m17.append(" size=");
                        bp bpVar = QQFlashTransferViewModel.this.fileLists;
                        List<ab> list3 = null;
                        m17.append((bpVar == null || (list2 = bpVar.f446183a) == null) ? null : Integer.valueOf(list2.size()));
                        m17.append(" isEnd=");
                        m17.append(cfVar2.f446254c.get(0).f446185c);
                        m17.append(" isCache=");
                        NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0.m(m17, cfVar2.f446254c.get(0).f446186d, kLog2, "getCompressedFileFolder");
                        if (QQFlashTransferViewModel.this.parentId.getValue().length() == 0) {
                            QQFlashTransferViewModel.this.dirFileCount.setValue(Integer.valueOf((int) cfVar2.f446255d));
                            QQFlashTransferViewModel.this.dirFileSize.setValue(Long.valueOf(cfVar2.f446256e));
                            StringBuilder m18 = QQFlashTransferViewModel$fetchCompressedFileFolder$2$$ExternalSyntheticOutline0.m(cfVar2.f446255d, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchCompressedFileFolder update dirFileCount="), " dirFileSize=");
                            m18.append((Object) ULong.m693toStringimpl(cfVar2.f446256e));
                            kLog2.d("getCompressedFileFolder", m18.toString());
                        }
                        if (z17) {
                            QQFlashTransferViewModel.this.fileLists = cfVar2.f446254c.get(0);
                            QQFlashTransferViewModel qQFlashTransferViewModel = QQFlashTransferViewModel.this;
                            QQFlashTransferViewModel.access$initFileListData(qQFlashTransferViewModel, qQFlashTransferViewModel.hasTapSelectAll.getValue().booleanValue());
                        } else {
                            bp bpVar2 = QQFlashTransferViewModel.this.fileLists;
                            if (bpVar2 != null && (list = bpVar2.f446183a) != null) {
                                list3 = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
                            }
                            if (list3 != null) {
                                list3.addAll(cfVar2.f446254c.get(0).f446183a);
                                QQFlashTransferViewModel qQFlashTransferViewModel2 = QQFlashTransferViewModel.this;
                                bp bpVar3 = qQFlashTransferViewModel2.fileLists;
                                if (bpVar3 != null) {
                                    bpVar3.f446183a = list3;
                                }
                                QQFlashTransferViewModel.access$initLoadMoreFileListData(qQFlashTransferViewModel2, qQFlashTransferViewModel2.hasTapSelectAll.getValue().booleanValue(), cfVar2.f446254c.get(0).f446183a);
                            }
                        }
                        QQFlashTransferViewModel.this.paginationInfo = cfVar2.f446254c.get(0).f446184b;
                        QQFlashTransferViewModel.this.hasLoadAll.setValue(Boolean.valueOf(cfVar2.f446254c.get(0).f446185c));
                        if (QQFlashTransferViewModel.this.hasLoadAll.getValue().booleanValue() && QQFlashTransferViewModel.this.hasTapSelectAll.getValue().booleanValue()) {
                            QQFlashTransferViewModel.this.hasTapSelectAll.setValue(bool);
                        }
                        Function2<Boolean, Boolean, Unit> function22 = function2;
                        if (function22 != null) {
                            function22.invoke(Boolean.valueOf(cfVar2.f446254c.get(0).f446185c), bool);
                        }
                        QQFlashTransferViewModel.access$updateEmptyView(QQFlashTransferViewModel.this);
                    } else {
                        Function2<Boolean, Boolean, Unit> function23 = function2;
                        if (function23 != null) {
                            Boolean bool2 = Boolean.TRUE;
                            function23.invoke(bool2, bool2);
                        }
                        KLog kLog3 = KLog.INSTANCE;
                        StringBuilder m19 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchCompressedFileFolder error: result=");
                        m19.append(cfVar2.f446252a);
                        m19.append(" errMs=");
                        m19.append(cfVar2.f446253b);
                        m19.append(" remaining_time=");
                        NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(QQFlashTransferViewModel$fetchCompressedFileFolder$2$$ExternalSyntheticOutline0.m(cfVar2.f446257f, m19, " remaining_msg="), cfVar2.f446258g, kLog3, "getCompressedFileFolder");
                        if (UnsignedKt.ulongCompare(cfVar2.f446257f, ULong.m648constructorimpl(0L)) > 0) {
                            if (cfVar2.f446258g.length() > 0) {
                                str3 = cfVar2.f446258g;
                                QQFlashTransferViewModel.this.hasLoadAll.setValue(Boolean.TRUE);
                                QQFlashTransferViewModel.this.getEmptyListCardVM().displayText.setValue(str3);
                                if (cfVar2.f446252a != 0) {
                                    QQFlashTransferViewModel.this.footerRefreshState.setValue(FooterRefreshState.FAILURE);
                                }
                                QQFlashTransferViewModel qQFlashTransferViewModel3 = QQFlashTransferViewModel.this;
                                qQFlashTransferViewModel3.feedListViewModel.feedCardViewModelList.add(qQFlashTransferViewModel3.getEmptyListCardVM());
                            }
                        }
                        int i17 = cfVar2.f446252a;
                        if (i17 != 0) {
                            QQFlashTransferViewModel.this.repo.getClass();
                            if (i17 != 110100) {
                                switch (i17) {
                                    case BusinessInfoCheckUpdateItem.UIAPPID_MINI_APP_PANEL /* 110000 */:
                                        str3 = "\u538b\u7f29\u5305\u6587\u4ef6\u5df2\u635f\u574f\uff0c\u65e0\u6cd5\u6253\u5f00";
                                        break;
                                    case IPermissionType.MANAGE_BIND_GROUP /* 110001 */:
                                        str3 = "\u538b\u7f29\u5305\u5df2\u52a0\u5bc6\uff0c\u8bf7\u4e0b\u8f7d\u540e\u67e5\u770b";
                                        break;
                                    case IPermissionType.MANAGE_UNBIND_GROUP /* 110002 */:
                                        str3 = "\u538b\u7f29\u5305\u8fc7\u5927\uff0c\u8bf7\u4e0b\u8f7d\u540e\u67e5\u770b";
                                        break;
                                    case IPermissionType.MANAGE_SORT_GROUP /* 110003 */:
                                        str3 = "\u538b\u7f29\u5305\u5185\u6587\u4ef6\u6570\u91cf\u8fc7\u591a\uff0c\u8bf7\u4e0b\u8f7d\u540e\u67e5\u770b";
                                        break;
                                    case 110004:
                                        str3 = "\u4e0d\u652f\u6301\u9884\u89c8\u7684\u538b\u7f29\u5305\u7c7b\u578b\uff0c\u8bf7\u4e0b\u8f7d\u540e\u67e5\u770b";
                                        break;
                                    case 110005:
                                        str3 = "\u538b\u7f29\u5305\u5bc6\u7801\u9519\u8bef\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165";
                                        break;
                                }
                                QQFlashTransferViewModel.this.hasLoadAll.setValue(Boolean.TRUE);
                                QQFlashTransferViewModel.this.getEmptyListCardVM().displayText.setValue(str3);
                                if (cfVar2.f446252a != 0) {
                                }
                                QQFlashTransferViewModel qQFlashTransferViewModel32 = QQFlashTransferViewModel.this;
                                qQFlashTransferViewModel32.feedListViewModel.feedCardViewModelList.add(qQFlashTransferViewModel32.getEmptyListCardVM());
                            }
                        }
                        str3 = "\u52a0\u8f7d\u51fa\u9519\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                        QQFlashTransferViewModel.this.hasLoadAll.setValue(Boolean.TRUE);
                        QQFlashTransferViewModel.this.getEmptyListCardVM().displayText.setValue(str3);
                        if (cfVar2.f446252a != 0) {
                        }
                        QQFlashTransferViewModel qQFlashTransferViewModel322 = QQFlashTransferViewModel.this;
                        qQFlashTransferViewModel322.feedListViewModel.feedCardViewModelList.add(qQFlashTransferViewModel322.getEmptyListCardVM());
                    }
                    return Unit.INSTANCE;
                }
            };
            qQFTRepo.getClass();
            CollectionsKt__CollectionsKt.emptyList();
            l lVar = new l("", 0, 0, new byte[0], 0);
            lVar.f446381a = value;
            lVar.f446385e = filterType;
            lVar.f446382b = 1;
            lVar.f446383c = 200;
            if (bArr != null) {
                lVar.f446384d = bArr;
            }
            listOf = CollectionsKt__CollectionsJVMKt.listOf(lVar);
            KLog kLog2 = KLog.INSTANCE;
            StringBuilder m16 = PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(j.a("QQFTRepo compressedFileFolderId=", str, " fileSetId=", str2, " parentId="), value, " filterType=", filterType, " paginationInfoSize=");
            m16.append(bArr != null ? Integer.valueOf(bArr.length) : null);
            kLog2.d("getCompressedFileFolder", m16.toString());
            IKernelFlashTransferService a16 = IKernelFlashTransferService.f344757i.a();
            final dj djVar = new dj() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.repo.QQFTRepo$getCompressedFileFolder$1
                @Override // ws3.dj
                public final void onGetCompressedFileFolder(final cf cfVar) {
                    final Function1<cf, Unit> function12 = function1;
                    SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.repo.QQFTRepo$getCompressedFileFolder$1$onGetCompressedFileFolder$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            function12.invoke(cfVar);
                            return Unit.INSTANCE;
                        }
                    });
                }
            };
            a16.getClass();
            ArrayList arrayList = new ArrayList();
            ArrayList m17 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m("seq");
            m17.add(1);
            m17.add("fileSetId");
            m17.add(str2);
            m17.add("cliFileId");
            m17.add(str);
            m17.add("srvFileId");
            m17.add("");
            m17.add("reqInfos");
            m17.add(Integer.valueOf(listOf.size()));
            Iterator it = listOf.iterator();
            while (it.hasNext()) {
                Object[] a17 = p.a((l) it.next());
                m17.add(Integer.valueOf(a17.length));
                CollectionsKt__MutableCollectionsKt.addAll(m17, a17);
            }
            m17.add("sceneType");
            m17.add(Integer.valueOf(i16));
            m17.add("isUseCache");
            m17.add(0);
            Object[] array = m17.toArray(new Object[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            arrayList.add(Integer.valueOf(array.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, array);
            arrayList.add(String.valueOf(djVar.hashCode()));
            Function1<Object, Unit> function12 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$getCompressedFileFolder$kernelCallback$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    List emptyList;
                    Object[] objArr = obj instanceof Object[] ? (Object[]) obj : null;
                    if (objArr != null) {
                        if (!(objArr.length == 0)) {
                            Iterator it5 = ArrayIteratorKt.iterator(objArr);
                            if (Intrinsics.areEqual((String) dr.a(it5, "null cannot be cast to non-null type kotlin.String"), "onGetCompressedFileFolder")) {
                                Object next = it5.next();
                                Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
                                int intValue = ((Integer) next).intValue();
                                Object[] objArr2 = new Object[intValue];
                                for (int i17 = 0; i17 < intValue; i17++) {
                                    objArr2[i17] = it5.next();
                                }
                                Iterator it6 = ArrayIteratorKt.iterator(objArr2);
                                emptyList = CollectionsKt__CollectionsKt.emptyList();
                                cf cfVar = new cf(0, 0, "", emptyList, 0L, 0L, 0L, "", null);
                                while (it6.hasNext()) {
                                    Object next2 = it6.next();
                                    if (Intrinsics.areEqual(next2, "seq")) {
                                        Object next3 = it6.next();
                                        Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int");
                                        ((Integer) next3).intValue();
                                    } else if (Intrinsics.areEqual(next2, "result")) {
                                        Object next4 = it6.next();
                                        Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.Int");
                                        cfVar.f446252a = ((Integer) next4).intValue();
                                    } else if (Intrinsics.areEqual(next2, "errMs")) {
                                        Object next5 = it6.next();
                                        Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.String");
                                        cfVar.f446253b = (String) next5;
                                    } else if (Intrinsics.areEqual(next2, "fileLists")) {
                                        Object next6 = it6.next();
                                        Intrinsics.checkNotNull(next6, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue2 = ((Integer) next6).intValue();
                                        ArrayList arrayList2 = new ArrayList();
                                        for (int i18 = 0; i18 < intValue2; i18++) {
                                            Object next7 = it6.next();
                                            Intrinsics.checkNotNull(next7, "null cannot be cast to non-null type kotlin.Int");
                                            int intValue3 = ((Integer) next7).intValue();
                                            Object[] objArr3 = new Object[intValue3];
                                            for (int i19 = 0; i19 < intValue3; i19++) {
                                                objArr3[i19] = it6.next();
                                            }
                                            arrayList2.add(bq.a(objArr3));
                                        }
                                        cfVar.f446254c = arrayList2;
                                    } else if (Intrinsics.areEqual(next2, "totalFileCount")) {
                                        Object next8 = it6.next();
                                        Intrinsics.checkNotNull(next8, "null cannot be cast to non-null type kotlin.String");
                                        cfVar.f446255d = vs3.a.b((String) next8);
                                    } else if (Intrinsics.areEqual(next2, "totalFileSize")) {
                                        Object next9 = it6.next();
                                        Intrinsics.checkNotNull(next9, "null cannot be cast to non-null type kotlin.String");
                                        cfVar.f446256e = vs3.a.b((String) next9);
                                    } else if (Intrinsics.areEqual(next2, "remainingTime")) {
                                        Object next10 = it6.next();
                                        Intrinsics.checkNotNull(next10, "null cannot be cast to non-null type kotlin.String");
                                        cfVar.f446257f = vs3.a.b((String) next10);
                                    } else if (Intrinsics.areEqual(next2, "remainingMsg")) {
                                        Object next11 = it6.next();
                                        Intrinsics.checkNotNull(next11, "null cannot be cast to non-null type kotlin.String");
                                        cfVar.f446258g = (String) next11;
                                    }
                                }
                                dj.this.onGetCompressedFileFolder(cfVar);
                                return Unit.INSTANCE;
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
            };
            Object[] array2 = arrayList.toArray(new Object[0]);
            Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            a16.syncToNativeMethod(true, "getCompressedFileFolder", array2, function12);
            return;
        }
        if (this.clusterId.length() == 0) {
            fetchFileList(this.isLoadingData.getValue().booleanValue(), z16, this.paginationInfo, function2);
        } else if (this.clusterType >= 0) {
            fetchFileSetClusteringDetail(z16, this.paginationInfo, function2);
        }
    }
}
