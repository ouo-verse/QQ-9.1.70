package com.qzone.reborn.feedpro.part.detail;

import ELABORATE_FEED_REPORT.SingleExposeInfo;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.base.QZoneBaseBlockContainer;
import com.qzone.reborn.feedpro.event.QzoneFeedProDetailFirstRefreshEvent;
import com.qzone.reborn.feedpro.event.QzoneFeedProShowEmptyEvent;
import com.qzone.reborn.feedpro.utils.n;
import com.qzone.reborn.feedx.event.QZoneFeedxDetailAnimEvent;
import com.qzone.reborn.feedx.util.v;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellOperation;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 Q2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001RB#\u0012\u0006\u0010K\u001a\u00020J\u0012\u0012\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010M0L\u00a2\u0006\u0004\bO\u0010PJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010\u0016\u001a\u00020\u00042\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0006H\u0002J\u0018\u0010\u0018\u001a\u00020\u00042\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0006H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0003H\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u001a\u0010$\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0016J$\u0010)\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030'0&j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030'`(H\u0016J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020*H\u0016R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010DR\u0016\u0010I\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010D\u00a8\u0006S"}, d2 = {"Lcom/qzone/reborn/feedpro/part/detail/QzoneFeedProDetailBlockPart;", "Lcom/qzone/reborn/base/c;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/qzone/reborn/feedx/event/QZoneFeedxDetailAnimEvent;", "", "Y9", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "listUIStateData", "V9", "ma", "ga", "X9", "data", "W9", "ea", "", "isSuccess", "U9", "na", "Lcom/tencent/gdtad/aditem/GdtAd;", "commentUIStateData", "S9", "Lwd/b;", "T9", "event", "R9", "", "getLogTag", "Landroid/view/View;", "mRootView", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "onReceiveEvent", "Lcom/qzone/reborn/feedpro/block/f;", "d", "Lcom/qzone/reborn/feedpro/block/f;", "mDetailAdapter", "Lcom/qzone/reborn/feedpro/viewmodel/i;", "e", "Lcom/qzone/reborn/feedpro/viewmodel/i;", "mDetailViewModel", "Lcom/qzone/reborn/feedpro/block/h;", "f", "Lcom/qzone/reborn/feedpro/block/h;", "mCommentAdapter", "Lcom/qzone/reborn/feedpro/block/a;", tl.h.F, "Lcom/qzone/reborn/feedpro/block/a;", "mAdViewBlock", "i", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "mFeedData", "Lcom/qzone/reborn/feedpro/block/i;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedpro/block/i;", "mEmptyBlock", BdhLogUtil.LogTag.Tag_Conn, "Z", "mHasInitData", "D", "mIsNeedUpdateData", "E", "mIsFeedAnimPlaying", "", "peerBlockFindViewId", "", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "peerBlocks", "<init>", "(ILjava/util/List;)V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProDetailBlockPart extends com.qzone.reborn.base.c implements SimpleEventReceiver<QZoneFeedxDetailAnimEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mHasInitData;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mIsNeedUpdateData;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mIsFeedAnimPlaying;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedpro.block.f mDetailAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedpro.viewmodel.i mDetailViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedpro.block.h mCommentAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedpro.block.a mAdViewBlock;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private CommonFeed mFeedData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedpro.block.i mEmptyBlock;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProDetailBlockPart(int i3, List<? extends MultiViewBlock<?>> peerBlocks) {
        super(i3, peerBlocks);
        Intrinsics.checkNotNullParameter(peerBlocks, "peerBlocks");
        for (MultiViewBlock<?> multiViewBlock : peerBlocks) {
            if (multiViewBlock instanceof com.qzone.reborn.feedpro.block.f) {
                this.mDetailAdapter = (com.qzone.reborn.feedpro.block.f) multiViewBlock;
            } else if (multiViewBlock instanceof com.qzone.reborn.feedpro.block.h) {
                this.mCommentAdapter = (com.qzone.reborn.feedpro.block.h) multiViewBlock;
            } else if (multiViewBlock instanceof com.qzone.reborn.feedpro.block.i) {
                this.mEmptyBlock = (com.qzone.reborn.feedpro.block.i) multiViewBlock;
            } else if (multiViewBlock instanceof com.qzone.reborn.feedpro.block.a) {
                this.mAdViewBlock = (com.qzone.reborn.feedpro.block.a) multiViewBlock;
            }
        }
    }

    private final void R9(QZoneFeedxDetailAnimEvent event) {
        boolean isAnimPlaying = event.getIsAnimPlaying();
        this.mIsFeedAnimPlaying = isAnimPlaying;
        if (isAnimPlaying || !this.mIsNeedUpdateData) {
            return;
        }
        com.qzone.reborn.feedpro.viewmodel.i iVar = this.mDetailViewModel;
        W9(iVar != null ? iVar.d2() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9(UIStateData<GdtAd> commentUIStateData) {
        QLog.i("QZoneFeedxDetailBlockPart", 2, "handleDetailBottomAdRsp() commentUIStateData = " + commentUIStateData);
        if (commentUIStateData == null) {
            return;
        }
        int state = commentUIStateData.getState();
        if (state == 3) {
            com.qzone.reborn.feedpro.block.a aVar = this.mAdViewBlock;
            if (aVar != null) {
                aVar.l0(commentUIStateData.getData());
            }
            com.qzone.reborn.feedpro.block.a aVar2 = this.mAdViewBlock;
            if (aVar2 != null) {
                aVar2.notifyItemChanged(0);
                return;
            }
            return;
        }
        if (state != 4) {
            return;
        }
        QLog.e("QZoneFeedxDetailBlockPart", 1, "handleDetailBottomAdRsp() return error  | retCode = " + commentUIStateData.getRetCode() + " | msg = " + commentUIStateData.getMsg());
        com.qzone.reborn.feedpro.block.a aVar3 = this.mAdViewBlock;
        if (aVar3 != null) {
            aVar3.notifyLoadingComplete(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9(UIStateData<wd.b> commentUIStateData) {
        QLog.i("QZoneFeedxDetailBlockPart", 2, "handleDetailBottomAdRsp() commentUIStateData = " + commentUIStateData);
        if (commentUIStateData == null) {
            return;
        }
        int state = commentUIStateData.getState();
        if (state == 3) {
            na(this.mFeedData);
            return;
        }
        if (state != 4) {
            return;
        }
        QLog.e("QZoneFeedxDetailBlockPart", 1, "handleDetailBottomAdRsp() return error  | retCode = " + commentUIStateData.getRetCode() + " | msg = " + commentUIStateData.getMsg());
    }

    private final void W9(CommonFeed data) {
        com.qzone.reborn.feedpro.block.a aVar;
        List<wd.c> dataList;
        MutableLiveData<UIStateData<GdtAd>> i26;
        UIStateData<GdtAd> value;
        List<CommonFeed> dataList2;
        List<CommonFeed> dataList3;
        this.mFeedData = data;
        com.qzone.reborn.feedpro.block.f fVar = this.mDetailAdapter;
        if (fVar != null && (dataList3 = fVar.getDataList()) != null) {
            dataList3.clear();
        }
        com.qzone.reborn.feedpro.block.f fVar2 = this.mDetailAdapter;
        if (fVar2 != null && (dataList2 = fVar2.getDataList()) != null) {
            dataList2.add(data);
        }
        com.qzone.reborn.feedpro.block.a aVar2 = this.mAdViewBlock;
        if (aVar2 != null) {
            com.qzone.reborn.feedpro.viewmodel.i iVar = this.mDetailViewModel;
            aVar2.l0((iVar == null || (i26 = iVar.i2()) == null || (value = i26.getValue()) == null) ? null : value.getData());
        }
        na(data);
        com.qzone.reborn.feedpro.block.h hVar = this.mCommentAdapter;
        if (((hVar == null || (dataList = hVar.getDataList()) == null || !(dataList.isEmpty() ^ true)) ? false : true) && (aVar = this.mAdViewBlock) != null) {
            aVar.setBlockVisible(true);
        }
        ea();
        this.mIsNeedUpdateData = false;
    }

    private final void X9() {
        com.qzone.reborn.feedpro.block.f fVar = this.mDetailAdapter;
        if (fVar != null) {
            fVar.clearData();
        }
        com.qzone.reborn.feedpro.block.h hVar = this.mCommentAdapter;
        if (hVar != null) {
            hVar.clearData();
        }
        com.qzone.reborn.feedpro.block.a aVar = this.mAdViewBlock;
        if (aVar != null) {
            aVar.setBlockVisible(false);
        }
        ea();
    }

    private final void Y9() {
        MutableLiveData<CommonComment> l26;
        MutableLiveData<Boolean> g26;
        MutableLiveData<Boolean> q26;
        MutableLiveData<Boolean> p26;
        this.mBlockContainer.getBlockMerger().setCustomNoMoreDataView(new ImageView(getContext()));
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(101, 10);
        recycledViewPool.setMaxRecycledViews(102, 10);
        this.mBlockContainer.getRecyclerView().setRecycledViewPool(recycledViewPool);
        com.qzone.reborn.feedpro.viewmodel.i iVar = this.mDetailViewModel;
        if (iVar != null && (p26 = iVar.p2()) != null) {
            Fragment hostFragment = getHostFragment();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.feedpro.part.detail.QzoneFeedProDetailBlockPart$initDetailCommentView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    QzoneFeedProDetailBlockPart.this.U9(z16);
                }
            };
            p26.observe(hostFragment, new Observer() { // from class: com.qzone.reborn.feedpro.part.detail.o
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QzoneFeedProDetailBlockPart.Z9(Function1.this, obj);
                }
            });
        }
        com.qzone.reborn.feedpro.viewmodel.i iVar2 = this.mDetailViewModel;
        if (iVar2 != null && (q26 = iVar2.q2()) != null) {
            Fragment hostFragment2 = getHostFragment();
            final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.feedpro.part.detail.QzoneFeedProDetailBlockPart$initDetailCommentView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    QzoneFeedProDetailBlockPart.this.U9(z16);
                }
            };
            q26.observe(hostFragment2, new Observer() { // from class: com.qzone.reborn.feedpro.part.detail.p
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QzoneFeedProDetailBlockPart.aa(Function1.this, obj);
                }
            });
        }
        com.qzone.reborn.feedpro.viewmodel.i iVar3 = this.mDetailViewModel;
        if (iVar3 != null && (g26 = iVar3.g2()) != null) {
            Fragment hostFragment3 = getHostFragment();
            final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.feedpro.part.detail.QzoneFeedProDetailBlockPart$initDetailCommentView$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    com.qzone.reborn.feedpro.viewmodel.i iVar4;
                    MutableLiveData<UIStateData<CommonFeed>> f26;
                    UIStateData<CommonFeed> value;
                    if (z16) {
                        QzoneFeedProDetailBlockPart qzoneFeedProDetailBlockPart = QzoneFeedProDetailBlockPart.this;
                        iVar4 = qzoneFeedProDetailBlockPart.mDetailViewModel;
                        qzoneFeedProDetailBlockPart.na((iVar4 == null || (f26 = iVar4.f2()) == null || (value = f26.getValue()) == null) ? null : value.getData());
                    }
                }
            };
            g26.observe(hostFragment3, new Observer() { // from class: com.qzone.reborn.feedpro.part.detail.q
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QzoneFeedProDetailBlockPart.ba(Function1.this, obj);
                }
            });
        }
        com.qzone.reborn.feedpro.viewmodel.i iVar4 = this.mDetailViewModel;
        if (iVar4 != null && (l26 = iVar4.l2()) != null) {
            Fragment hostFragment4 = getHostFragment();
            final Function1<CommonComment, Unit> function14 = new Function1<CommonComment, Unit>() { // from class: com.qzone.reborn.feedpro.part.detail.QzoneFeedProDetailBlockPart$initDetailCommentView$4
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CommonComment commonComment) {
                    invoke2(commonComment);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(CommonComment comment) {
                    com.qzone.reborn.feedpro.block.h hVar;
                    Intrinsics.checkNotNullParameter(comment, "comment");
                    QzoneFeedProDetailBlockPart.this.U9(true);
                    hVar = QzoneFeedProDetailBlockPart.this.mCommentAdapter;
                    if (hVar != null) {
                        hVar.j0(comment);
                    }
                }
            };
            l26.observe(hostFragment4, new Observer() { // from class: com.qzone.reborn.feedpro.part.detail.r
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QzoneFeedProDetailBlockPart.ca(Function1.this, obj);
                }
            });
        }
        com.qzone.reborn.feedpro.block.h hVar = this.mCommentAdapter;
        if (hVar != null) {
            hVar.setOnLoadDataDelegate(new MultiViewBlock.OnLoadDataDelegate() { // from class: com.qzone.reborn.feedpro.part.detail.s
                @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
                public final void onLoadData(LoadInfo loadInfo, Object obj) {
                    QzoneFeedProDetailBlockPart.da(QzoneFeedProDetailBlockPart.this, loadInfo, obj);
                }
            });
        }
        NestScrollRecyclerView recyclerView = this.mBlockContainer.getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "mBlockContainer.recyclerView");
        v.a(recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(QzoneFeedProDetailBlockPart this$0, LoadInfo loadInfo, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(loadInfo, "loadInfo");
        if (loadInfo.isFinish()) {
            return;
        }
        QLog.d(this$0.getTAG(), 1, "onLoadMoreStart ");
        com.qzone.reborn.feedpro.viewmodel.i iVar = this$0.mDetailViewModel;
        if (iVar != null) {
            iVar.r2();
        }
    }

    private final void ea() {
        BlockContainer blockContainer = this.mBlockContainer;
        if (blockContainer == null || blockContainer.getBlockMerger() == null) {
            return;
        }
        this.mBlockContainer.getBlockMerger().notifyDataSetChanged();
    }

    private final void ga(UIStateData<CommonFeed> listUIStateData) {
        QLog.e("QZoneFeedxDetailBlockPart", 1, "handleDetailRsp() return error  | retCode = " + listUIStateData.getRetCode() + " | msg = " + listUIStateData.getMsg());
        com.qzone.reborn.feedpro.block.i iVar = this.mEmptyBlock;
        if (iVar != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            wd.e eVar = new wd.e();
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            eVar.d(com.qzone.reborn.feedpro.utils.p.b(context2, (int) listUIStateData.getRetCode()));
            eVar.f(ef.d.b(156));
            eVar.e(true);
            Unit unit = Unit.INSTANCE;
            iVar.n0(context, eVar);
        }
        com.qzone.reborn.feedpro.block.i iVar2 = this.mEmptyBlock;
        if (iVar2 != null) {
            iVar2.setBlockVisible(true);
        }
        com.qzone.reborn.feedpro.block.f fVar = this.mDetailAdapter;
        if (fVar != null) {
            fVar.notifyLoadingComplete(false);
        }
        X9();
        SimpleEventBus.getInstance().dispatchEvent(new QzoneFeedProShowEmptyEvent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void la(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void ma() {
        CommonCellOperation cellOperation;
        List listOf;
        CommonFeed commonFeed = this.mFeedData;
        if (commonFeed == null || (cellOperation = commonFeed.getCellOperation()) == null) {
            return;
        }
        SingleExposeInfo singleExposeInfo = new SingleExposeInfo();
        singleExposeInfo.mapFeedCookie = com.qzone.reborn.feedpro.scroller.b.s(cellOperation.getFeedReportCookie());
        singleExposeInfo.exposeTime = System.currentTimeMillis();
        com.qzone.misc.network.ttt.h g16 = com.qzone.misc.network.ttt.h.g();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(singleExposeInfo);
        g16.b(new ArrayList<>(listOf));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void na(CommonFeed data) {
        List<wd.c> dataList;
        List<wd.c> dataList2;
        MutableLiveData<UIStateData<wd.b>> j26;
        UIStateData<wd.b> value;
        com.qzone.reborn.feedpro.utils.n nVar = com.qzone.reborn.feedpro.utils.n.f54347a;
        com.qzone.reborn.feedpro.viewmodel.i iVar = this.mDetailViewModel;
        wd.b bVar = null;
        ConcurrentHashMap<String, n.a> h26 = iVar != null ? iVar.h2() : null;
        com.qzone.reborn.feedpro.viewmodel.i iVar2 = this.mDetailViewModel;
        if (iVar2 != null && (j26 = iVar2.j2()) != null && (value = j26.getValue()) != null) {
            bVar = value.getData();
        }
        List<wd.c> g16 = nVar.g(h26, data, bVar);
        com.qzone.reborn.feedpro.block.h hVar = this.mCommentAdapter;
        if (hVar != null && (dataList2 = hVar.getDataList()) != null) {
            dataList2.clear();
        }
        com.qzone.reborn.feedpro.block.h hVar2 = this.mCommentAdapter;
        if (hVar2 != null && (dataList = hVar2.getDataList()) != null) {
            dataList.addAll(g16);
        }
        com.qzone.reborn.feedpro.block.h hVar3 = this.mCommentAdapter;
        if (hVar3 != null) {
            com.qzone.reborn.feedpro.viewmodel.i iVar3 = this.mDetailViewModel;
            boolean z16 = false;
            if (iVar3 != null && iVar3.o2()) {
                z16 = true;
            }
            hVar3.notifyLoadingComplete(true, !z16);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<QZoneFeedxDetailAnimEvent>> getEventClass() {
        ArrayList<Class<QZoneFeedxDetailAnimEvent>> arrayList = new ArrayList<>();
        arrayList.add(QZoneFeedxDetailAnimEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxDetailBlockPart";
    }

    @Override // com.qzone.reborn.base.c, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View mRootView) {
        MutableLiveData<UIStateData<wd.b>> j26;
        MutableLiveData<UIStateData<GdtAd>> i26;
        MutableLiveData<Boolean> n26;
        MutableLiveData<UIStateData<CommonFeed>> f26;
        Intrinsics.checkNotNullParameter(mRootView, "mRootView");
        super.onInitView(mRootView);
        this.mDetailViewModel = (com.qzone.reborn.feedpro.viewmodel.i) getViewModel(com.qzone.reborn.feedpro.viewmodel.i.class);
        this.mBlockContainer.setLayoutManagerType(1, 1);
        this.mBlockContainer.setParentFragment(getHostFragment());
        this.mBlockContainer.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(2);
        this.mBlockContainer.setEnableLoadMore(true);
        this.mBlockContainer.setEnableRefresh(true);
        com.qzone.reborn.feedpro.viewmodel.i iVar = this.mDetailViewModel;
        if (iVar != null && (f26 = iVar.f2()) != null) {
            Fragment hostFragment = getHostFragment();
            final Function1<UIStateData<CommonFeed>, Unit> function1 = new Function1<UIStateData<CommonFeed>, Unit>() { // from class: com.qzone.reborn.feedpro.part.detail.QzoneFeedProDetailBlockPart$onInitView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(UIStateData<CommonFeed> uIStateData) {
                    invoke2(uIStateData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(UIStateData<CommonFeed> uIStateData) {
                    com.qzone.reborn.feedpro.block.f fVar;
                    fVar = QzoneFeedProDetailBlockPart.this.mDetailAdapter;
                    if (fVar != null) {
                        QzoneFeedProDetailBlockPart.this.V9(uIStateData);
                    }
                }
            };
            f26.observe(hostFragment, new Observer() { // from class: com.qzone.reborn.feedpro.part.detail.k
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QzoneFeedProDetailBlockPart.ha(Function1.this, obj);
                }
            });
        }
        com.qzone.reborn.feedpro.viewmodel.i iVar2 = this.mDetailViewModel;
        if (iVar2 != null && (n26 = iVar2.n2()) != null) {
            Fragment hostFragment2 = getHostFragment();
            final QzoneFeedProDetailBlockPart$onInitView$2 qzoneFeedProDetailBlockPart$onInitView$2 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.feedpro.part.detail.QzoneFeedProDetailBlockPart$onInitView$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean bool) {
                    if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                        SimpleEventBus.getInstance().dispatchEvent(new QzoneFeedProDetailFirstRefreshEvent(true));
                    }
                }
            };
            n26.observe(hostFragment2, new Observer() { // from class: com.qzone.reborn.feedpro.part.detail.l
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QzoneFeedProDetailBlockPart.ia(Function1.this, obj);
                }
            });
        }
        com.qzone.reborn.feedpro.viewmodel.i iVar3 = this.mDetailViewModel;
        if (iVar3 != null && (i26 = iVar3.i2()) != null) {
            Fragment hostFragment3 = getHostFragment();
            final QzoneFeedProDetailBlockPart$onInitView$3 qzoneFeedProDetailBlockPart$onInitView$3 = new QzoneFeedProDetailBlockPart$onInitView$3(this);
            i26.observe(hostFragment3, new Observer() { // from class: com.qzone.reborn.feedpro.part.detail.m
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QzoneFeedProDetailBlockPart.ja(Function1.this, obj);
                }
            });
        }
        com.qzone.reborn.feedpro.viewmodel.i iVar4 = this.mDetailViewModel;
        if (iVar4 != null && (j26 = iVar4.j2()) != null) {
            Fragment hostFragment4 = getHostFragment();
            final QzoneFeedProDetailBlockPart$onInitView$4 qzoneFeedProDetailBlockPart$onInitView$4 = new QzoneFeedProDetailBlockPart$onInitView$4(this);
            j26.observe(hostFragment4, new Observer() { // from class: com.qzone.reborn.feedpro.part.detail.n
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QzoneFeedProDetailBlockPart.la(Function1.this, obj);
                }
            });
        }
        Y9();
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        BlockContainer blockContainer = this.mBlockContainer;
        if (blockContainer instanceof QZoneBaseBlockContainer) {
            Intrinsics.checkNotNull(blockContainer, "null cannot be cast to non-null type com.qzone.reborn.base.QZoneBaseBlockContainer");
            ((QZoneBaseBlockContainer) blockContainer).c();
        }
        com.qzone.reborn.feedpro.viewmodel.i iVar = this.mDetailViewModel;
        if (iVar != null && iVar != null) {
            iVar.L1();
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof QZoneFeedxDetailAnimEvent) {
            R9((QZoneFeedxDetailAnimEvent) event);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U9(boolean isSuccess) {
        if (isSuccess) {
            com.qzone.reborn.feedpro.viewmodel.i iVar = this.mDetailViewModel;
            na(iVar != null ? iVar.d2() : null);
        } else {
            com.qzone.reborn.feedpro.block.h hVar = this.mCommentAdapter;
            if (hVar != null) {
                hVar.notifyLoadingComplete(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9(UIStateData<CommonFeed> listUIStateData) {
        if (listUIStateData == null) {
            return;
        }
        int state = listUIStateData.getState();
        if (state == 0) {
            QLog.e("QZoneFeedxDetailBlockPart", 1, "handleDetailRsp() return empty data");
            com.qzone.reborn.feedpro.block.f fVar = this.mDetailAdapter;
            if (fVar != null) {
                fVar.notifyLoadingComplete(false);
            }
        } else if (state == 2 || state == 3) {
            com.qzone.reborn.feedpro.block.f fVar2 = this.mDetailAdapter;
            if (fVar2 != null) {
                fVar2.notifyLoadingComplete(true, listUIStateData.getIsFinish());
            }
            this.mIsNeedUpdateData = true;
            if (!this.mHasInitData || !this.mIsFeedAnimPlaying) {
                W9(listUIStateData.getData());
                this.mHasInitData = true;
            }
        } else if (state == 4) {
            ga(listUIStateData);
        }
        if (listUIStateData.getState() == 3 && listUIStateData.getType() == 100) {
            ma();
        }
    }
}
