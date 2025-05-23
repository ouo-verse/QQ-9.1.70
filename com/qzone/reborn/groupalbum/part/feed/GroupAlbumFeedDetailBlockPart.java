package com.qzone.reborn.groupalbum.part.feed;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.reborn.base.QZoneBaseBlockContainer;
import com.qzone.reborn.groupalbum.part.feed.GroupAlbumFeedDetailBlockPart;
import com.qzone.reborn.groupalbum.viewmodel.GroupAlbumFeedDetailViewModel;
import com.qzone.util.ToastUtil;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 92\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001:B#\u0012\u0006\u00103\u001a\u00020\u0011\u0012\u0012\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010504\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J\u0016\u0010\n\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\f\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0014J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u0016R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u0006;"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/feed/GroupAlbumFeedDetailBlockPart;", "Lcom/qzone/reborn/base/d;", "Landroidx/lifecycle/Observer;", "Laf/b;", "", "W9", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "listUIStateData", "T9", "ba", "data", "V9", "Y9", "ga", "da", "U9", "", "globalPosition", "S9", "", "getLogTag", "Lwe/b;", "C9", "Landroid/view/View;", "mRootView", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "commentInfoBean", "aa", "Lcom/qzone/reborn/groupalbum/viewmodel/GroupAlbumFeedDetailViewModel;", "e", "Lcom/qzone/reborn/groupalbum/viewmodel/GroupAlbumFeedDetailViewModel;", "mDetailViewModel", "f", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "mFeedData", "", tl.h.F, "Z", "mIsFirstScroll", "Lcom/qzone/reborn/groupalbum/block/b;", "i", "Lcom/qzone/reborn/groupalbum/block/b;", "mDetailAdapter", "Lcom/qzone/reborn/feedx/block/j;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/block/j;", "mCommentAdapter", "peerBlockFindViewId", "", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "peerBlocks", "<init>", "(ILjava/util/List;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumFeedDetailBlockPart extends com.qzone.reborn.base.d implements Observer<af.b> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private GroupAlbumFeedDetailViewModel mDetailViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private BusinessFeedData mFeedData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFirstScroll;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.groupalbum.block.b mDetailAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedx.block.j mCommentAdapter;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/groupalbum/part/feed/GroupAlbumFeedDetailBlockPart$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f56720d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GroupAlbumFeedDetailBlockPart f56721e;

        b(int i3, GroupAlbumFeedDetailBlockPart groupAlbumFeedDetailBlockPart) {
            this.f56720d = i3;
            this.f56721e = groupAlbumFeedDetailBlockPart;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(RecyclerView.ViewHolder it, int i3) {
            Intrinsics.checkNotNullParameter(it, "$it");
            it.itemView.setBackgroundColor(i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                recyclerView.removeOnScrollListener(this);
                final RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(this.f56720d);
                if (findViewHolderForAdapterPosition != null) {
                    GroupAlbumFeedDetailBlockPart groupAlbumFeedDetailBlockPart = this.f56721e;
                    final int color = groupAlbumFeedDetailBlockPart.getContext().getColor(R.color.qui_common_bg_bottom_light);
                    int color2 = groupAlbumFeedDetailBlockPart.getContext().getColor(R.color.qui_common_brand_light);
                    Runnable runnable = new Runnable() { // from class: com.qzone.reborn.groupalbum.part.feed.o
                        @Override // java.lang.Runnable
                        public final void run() {
                            GroupAlbumFeedDetailBlockPart.b.e(RecyclerView.ViewHolder.this, color);
                        }
                    };
                    findViewHolderForAdapterPosition.itemView.setBackgroundColor(color2);
                    ((BlockPart) groupAlbumFeedDetailBlockPart).mBlockContainer.postDelayed(runnable, 3000L);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupAlbumFeedDetailBlockPart(int i3, List<? extends MultiViewBlock<?>> peerBlocks) {
        super(i3, peerBlocks);
        Intrinsics.checkNotNullParameter(peerBlocks, "peerBlocks");
        this.mIsFirstScroll = true;
        for (MultiViewBlock<?> multiViewBlock : peerBlocks) {
            if (multiViewBlock instanceof com.qzone.reborn.groupalbum.block.b) {
                this.mDetailAdapter = (com.qzone.reborn.groupalbum.block.b) multiViewBlock;
            } else if (multiViewBlock instanceof com.qzone.reborn.feedx.block.j) {
                this.mCommentAdapter = (com.qzone.reborn.feedx.block.j) multiViewBlock;
            }
        }
    }

    private final void S9(int globalPosition) {
        this.mBlockContainer.getRecyclerView().addOnScrollListener(new b(globalPosition, this));
    }

    private final void U9() {
        GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = this.mDetailViewModel;
        if (TextUtils.isEmpty(groupAlbumFeedDetailViewModel != null ? groupAlbumFeedDetailViewModel.getLocationCommentId() : null)) {
            return;
        }
        com.qzone.reborn.feedx.block.j jVar = this.mCommentAdapter;
        if (jVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentAdapter");
            jVar = null;
        }
        if (bl.b(jVar.getDataList())) {
            return;
        }
        com.qzone.reborn.feedx.block.j jVar2 = this.mCommentAdapter;
        if (jVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentAdapter");
            jVar2 = null;
        }
        List<pg.a> dataList = jVar2.getDataList();
        int size = dataList.size();
        int i3 = 0;
        Comment comment = null;
        int i16 = -1;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            }
            String str = dataList.get(i3).f426125c.commentid;
            GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel2 = this.mDetailViewModel;
            if (TextUtils.equals(str, groupAlbumFeedDetailViewModel2 != null ? groupAlbumFeedDetailViewModel2.getLocationCommentId() : null) && i16 == -1) {
                comment = dataList.get(i3).f426125c;
                i16 = i3;
            }
            Reply reply = dataList.get(i3).f426126d;
            String str2 = reply != null ? reply.replyId : null;
            GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel3 = this.mDetailViewModel;
            if (TextUtils.equals(str2, groupAlbumFeedDetailViewModel3 != null ? groupAlbumFeedDetailViewModel3.getLocationReplyId() : null)) {
                break;
            } else {
                i3++;
            }
        }
        int i17 = i3 == -1 ? i16 : i3;
        if (i17 >= 0) {
            com.qzone.reborn.feedx.block.j jVar3 = this.mCommentAdapter;
            if (jVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommentAdapter");
                jVar3 = null;
            }
            int globalPosition = jVar3.getGlobalPosition(i17);
            this.mBlockContainer.getRecyclerView().smoothScrollToPosition(globalPosition);
            S9(globalPosition);
        }
        String str3 = comment != null ? comment.commentid : null;
        String str4 = comment != null ? comment.comment : null;
        GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel4 = this.mDetailViewModel;
        String locationCommentId = groupAlbumFeedDetailViewModel4 != null ? groupAlbumFeedDetailViewModel4.getLocationCommentId() : null;
        GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel5 = this.mDetailViewModel;
        QLog.i("GroupAlbumFeedDetailBlockPart", 1, "handleScrollToCommentLocationPos  | commentPos = " + i16 + " | replyPos = " + i3 + " | targetPos = " + i17 + " | comment.id = " + str3 + " | comment.content = " + str4 + " | locationCommentId = " + locationCommentId + " | locationReplyId = " + (groupAlbumFeedDetailViewModel5 != null ? groupAlbumFeedDetailViewModel5.getLocationReplyId() : null));
    }

    private final void V9(BusinessFeedData data) {
        this.mFeedData = data;
        ze.a a16 = ze.a.a();
        BusinessFeedData businessFeedData = this.mFeedData;
        com.qzone.reborn.groupalbum.block.b bVar = null;
        String a17 = businessFeedData != null ? ef.b.a(businessFeedData) : null;
        BusinessFeedData businessFeedData2 = this.mFeedData;
        a16.observerGlobalState(new af.b(a17, businessFeedData2 != null ? businessFeedData2.getCommentInfo() : null), this);
        com.qzone.reborn.groupalbum.block.b bVar2 = this.mDetailAdapter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDetailAdapter");
            bVar2 = null;
        }
        bVar2.getDataList().clear();
        com.qzone.reborn.groupalbum.block.b bVar3 = this.mDetailAdapter;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDetailAdapter");
        } else {
            bVar = bVar3;
        }
        bVar.getDataList().add(data);
        ga(data);
        Y9();
        da();
    }

    private final void W9() {
        this.mBlockContainer.getBlockMerger().setNoMoreHint("");
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(101, 10);
        recycledViewPool.setMaxRecycledViews(102, 10);
        this.mBlockContainer.getRecyclerView().setRecycledViewPool(recycledViewPool);
        com.qzone.reborn.feedx.block.j jVar = this.mCommentAdapter;
        if (jVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentAdapter");
            jVar = null;
        }
        jVar.setOnLoadDataDelegate(new MultiViewBlock.OnLoadDataDelegate() { // from class: com.qzone.reborn.groupalbum.part.feed.n
            @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
            public final void onLoadData(LoadInfo loadInfo, Object obj) {
                GroupAlbumFeedDetailBlockPart.X9(GroupAlbumFeedDetailBlockPart.this, loadInfo, obj);
            }
        });
        NestScrollRecyclerView recyclerView = this.mBlockContainer.getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "mBlockContainer.recyclerView");
        com.qzone.reborn.feedx.util.v.a(recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(GroupAlbumFeedDetailBlockPart this$0, LoadInfo loadInfo, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(loadInfo, "loadInfo");
        if (loadInfo.isFinish()) {
            return;
        }
        QLog.d(this$0.getTAG(), 1, "onLoadMoreStart ");
        GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = this$0.mDetailViewModel;
        if (groupAlbumFeedDetailViewModel != null) {
            groupAlbumFeedDetailViewModel.r2();
        }
    }

    private final void Y9() {
        BlockContainer blockContainer = this.mBlockContainer;
        if (blockContainer == null || blockContainer.getBlockMerger() == null) {
            return;
        }
        if (this.mBlockContainer.getRecyclerView().isComputingLayout() && com.qzone.reborn.configx.g.f53821a.d().k()) {
            this.mBlockContainer.getRecyclerView().post(new Runnable() { // from class: com.qzone.reborn.groupalbum.part.feed.l
                @Override // java.lang.Runnable
                public final void run() {
                    GroupAlbumFeedDetailBlockPart.Z9(GroupAlbumFeedDetailBlockPart.this);
                }
            });
        } else {
            this.mBlockContainer.getBlockMerger().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(GroupAlbumFeedDetailBlockPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mBlockContainer.getBlockMerger().notifyDataSetChanged();
    }

    private final void ba(UIStateData<BusinessFeedData> listUIStateData) {
        QLog.e("GroupAlbumFeedDetailBlockPart", 1, "handleDetailRsp() return error  | retCode = " + listUIStateData.getRetCode() + " | msg = " + listUIStateData.getMsg());
        com.qzone.reborn.groupalbum.block.b bVar = this.mDetailAdapter;
        com.qzone.reborn.feedx.block.j jVar = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDetailAdapter");
            bVar = null;
        }
        bVar.notifyLoadingComplete(false);
        if (!TextUtils.isEmpty(listUIStateData.getMsg())) {
            ToastUtil.s(listUIStateData.getMsg(), 1);
        }
        if (listUIStateData.getRetCode() == -10650) {
            com.qzone.reborn.groupalbum.block.b bVar2 = this.mDetailAdapter;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDetailAdapter");
                bVar2 = null;
            }
            bVar2.clearData();
            com.qzone.reborn.feedx.block.j jVar2 = this.mCommentAdapter;
            if (jVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommentAdapter");
            } else {
                jVar = jVar2;
            }
            jVar.clearData();
            Y9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void da() {
        if (!com.qzone.reborn.configx.g.f53821a.d().j() && this.mIsFirstScroll) {
            this.mIsFirstScroll = false;
            runOnActivityUiThread(new Runnable() { // from class: com.qzone.reborn.groupalbum.part.feed.m
                @Override // java.lang.Runnable
                public final void run() {
                    GroupAlbumFeedDetailBlockPart.ea(GroupAlbumFeedDetailBlockPart.this);
                }
            }, 800L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(GroupAlbumFeedDetailBlockPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.U9();
    }

    private final void ga(BusinessFeedData data) {
        List<pg.a> infoList = com.qzone.reborn.feedx.util.u.b(data);
        com.qzone.reborn.feedx.block.j jVar = this.mCommentAdapter;
        com.qzone.reborn.feedx.block.j jVar2 = null;
        if (jVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentAdapter");
            jVar = null;
        }
        jVar.getDataList().clear();
        com.qzone.reborn.feedx.block.j jVar3 = this.mCommentAdapter;
        if (jVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentAdapter");
            jVar3 = null;
        }
        List<pg.a> dataList = jVar3.getDataList();
        Intrinsics.checkNotNullExpressionValue(infoList, "infoList");
        dataList.addAll(infoList);
        GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = this.mDetailViewModel;
        boolean z16 = !(groupAlbumFeedDetailViewModel != null ? groupAlbumFeedDetailViewModel.o2() : false);
        com.qzone.reborn.feedx.block.j jVar4 = this.mCommentAdapter;
        if (jVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentAdapter");
        } else {
            jVar2 = jVar4;
        }
        jVar2.notifyLoadingComplete(true, z16);
        QLog.d("GroupAlbumFeedDetailBlockPart", 1, "updateDetailCommentData infoList.size=" + infoList.size() + " , isFinish=" + z16);
    }

    @Override // com.qzone.reborn.base.d
    protected we.b<?> C9() {
        com.qzone.reborn.groupalbum.block.b bVar = this.mDetailAdapter;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDetailAdapter");
        return null;
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumFeedDetailBlockPart";
    }

    @Override // com.qzone.reborn.base.c, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View mRootView) {
        MutableLiveData<UIStateData<BusinessFeedData>> i26;
        super.onInitView(mRootView);
        this.mDetailViewModel = (GroupAlbumFeedDetailViewModel) getViewModel(GroupAlbumFeedDetailViewModel.class);
        this.mBlockContainer.setLayoutManagerType(1, 1);
        this.mBlockContainer.setParentFragment(getHostFragment());
        this.mBlockContainer.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(2);
        this.mBlockContainer.setEnableLoadMore(true);
        this.mBlockContainer.setEnableRefresh(true);
        GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = this.mDetailViewModel;
        if (groupAlbumFeedDetailViewModel != null && (i26 = groupAlbumFeedDetailViewModel.i2()) != null) {
            Fragment hostFragment = getHostFragment();
            final Function1<UIStateData<BusinessFeedData>, Unit> function1 = new Function1<UIStateData<BusinessFeedData>, Unit>() { // from class: com.qzone.reborn.groupalbum.part.feed.GroupAlbumFeedDetailBlockPart$onInitView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(UIStateData<BusinessFeedData> uIStateData) {
                    invoke2(uIStateData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(UIStateData<BusinessFeedData> businessFeedDataUIStateData) {
                    Intrinsics.checkNotNullParameter(businessFeedDataUIStateData, "businessFeedDataUIStateData");
                    GroupAlbumFeedDetailBlockPart.this.T9(businessFeedDataUIStateData);
                }
            };
            i26.observe(hostFragment, new Observer() { // from class: com.qzone.reborn.groupalbum.part.feed.k
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GroupAlbumFeedDetailBlockPart.ca(Function1.this, obj);
                }
            });
        }
        W9();
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        BlockContainer blockContainer = this.mBlockContainer;
        if (blockContainer instanceof QZoneBaseBlockContainer) {
            Intrinsics.checkNotNull(blockContainer, "null cannot be cast to non-null type com.qzone.reborn.base.QZoneBaseBlockContainer");
            ((QZoneBaseBlockContainer) blockContainer).c();
        }
        GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = this.mDetailViewModel;
        if (groupAlbumFeedDetailViewModel != null) {
            Intrinsics.checkNotNull(groupAlbumFeedDetailViewModel);
            groupAlbumFeedDetailViewModel.L1();
        }
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: aa, reason: merged with bridge method [inline-methods] */
    public void onChanged(af.b commentInfoBean) {
        if (commentInfoBean != null) {
            String b16 = commentInfoBean.b();
            BusinessFeedData businessFeedData = this.mFeedData;
            if (TextUtils.equals(b16, businessFeedData != null ? ef.b.a(businessFeedData) : null)) {
                BusinessFeedData businessFeedData2 = this.mFeedData;
                if (businessFeedData2 != null) {
                    businessFeedData2.setCommentInfo(commentInfoBean.a());
                }
                ga(this.mFeedData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9(UIStateData<BusinessFeedData> listUIStateData) {
        if (listUIStateData == null) {
            return;
        }
        int state = listUIStateData.getState();
        com.qzone.reborn.groupalbum.block.b bVar = null;
        if (state == 0) {
            QLog.e("GroupAlbumFeedDetailBlockPart", 1, "handleDetailRsp() return empty data");
            com.qzone.reborn.groupalbum.block.b bVar2 = this.mDetailAdapter;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDetailAdapter");
            } else {
                bVar = bVar2;
            }
            bVar.notifyLoadingComplete(false);
            return;
        }
        if (state != 2 && state != 3) {
            if (state != 4) {
                return;
            }
            ba(listUIStateData);
            return;
        }
        com.qzone.reborn.groupalbum.block.b bVar3 = this.mDetailAdapter;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDetailAdapter");
        } else {
            bVar = bVar3;
        }
        bVar.notifyLoadingComplete(true, listUIStateData.getIsFinish());
        BusinessFeedData data = listUIStateData.getData();
        Intrinsics.checkNotNullExpressionValue(data, "listUIStateData.data");
        V9(data);
    }
}
