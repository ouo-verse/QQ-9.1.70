package com.qzone.reborn.intimate.part;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.qzone.reborn.intimate.block.QZoneIntimateFeedAdapter;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010.\u001a\u00020\u0013\u0012\u0012\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010/0\u0004\u00a2\u0006\u0004\b1\u00102J\u001e\u0010\b\u001a\u00020\u00072\u0014\u0010\u0006\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u0003H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J \u0010\u0010\u001a\u00020\u00072\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u000e\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015H\u0014J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001c\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00063"}, d2 = {"Lcom/qzone/reborn/intimate/part/bj;", "Lcom/qzone/reborn/base/d;", "Lqj/m;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "listUIStateData", "", "P9", "V9", "W9", "R9", "N9", "data", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "Q9", "U9", "T9", "", "O9", "Lwe/b;", "C9", "Landroid/view/View;", "mRootView", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "fa", "W5", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "e", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "mBlankView", "f", "Z", "mIsItemDecorationSetup", "Lnk/ar;", tl.h.F, "Lnk/ar;", "mFeedViewModel", "Lcom/qzone/reborn/intimate/block/QZoneIntimateFeedAdapter;", "i", "Lcom/qzone/reborn/intimate/block/QZoneIntimateFeedAdapter;", "mFeedListAdapter", "peerBlockFindViewId", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "peerBlocks", "<init>", "(ILjava/util/List;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class bj extends com.qzone.reborn.base.d implements qj.m {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneBlankStateView mBlankView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsItemDecorationSetup;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private nk.ar mFeedViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneIntimateFeedAdapter mFeedListAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bj(int i3, List<? extends MultiViewBlock<?>> peerBlocks) {
        super(i3, peerBlocks);
        Intrinsics.checkNotNullParameter(peerBlocks, "peerBlocks");
        for (Object obj : peerBlocks) {
            if (((MultiViewBlock) obj) instanceof QZoneIntimateFeedAdapter) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.qzone.reborn.intimate.block.QZoneIntimateFeedAdapter");
                this.mFeedListAdapter = (QZoneIntimateFeedAdapter) obj;
                return;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final void N9() {
        QZoneBlankStateView qZoneBlankStateView;
        QZoneBlankStateView qZoneBlankStateView2 = this.mBlankView;
        ViewGroup.LayoutParams layoutParams = qZoneBlankStateView2 != null ? qZoneBlankStateView2.getLayoutParams() : null;
        if (layoutParams == null || (qZoneBlankStateView = this.mBlankView) == null) {
            return;
        }
        layoutParams.height = QZoneFeedxViewUtils.f(qZoneBlankStateView);
        QZoneBlankStateView qZoneBlankStateView3 = this.mBlankView;
        if (qZoneBlankStateView3 == null) {
            return;
        }
        qZoneBlankStateView3.setLayoutParams(layoutParams);
    }

    private final int O9() {
        return getActivity().getResources().getColor(R.color.qui_common_border_light);
    }

    private final void R9() {
        String a16;
        MutableLiveData<UIStateData<QZoneIntimateSpaceBean>> U1;
        UIStateData<QZoneIntimateSpaceBean> value;
        QZoneIntimateSpaceBean data;
        nk.at atVar = (nk.at) z9(nk.at.class);
        if ((atVar == null || (U1 = atVar.U1()) == null || (value = U1.getValue()) == null || (data = value.getData()) == null) ? false : data.isMasterSpace()) {
            a16 = com.qzone.util.l.a(R.string.f169552v93);
        } else {
            a16 = com.qzone.util.l.a(R.string.f169551v92);
        }
        QZoneBlankStateView qZoneBlankStateView = this.mBlankView;
        if (qZoneBlankStateView != null) {
            qZoneBlankStateView.setData(com.qzone.reborn.feedx.util.k.h(getContext(), a16));
        }
        QLog.d(getTAG(), 4, "[initBlankViewData] emptyMsg = " + a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(bj this$0, UIStateData uIStateData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P9(uIStateData);
    }

    private final void T9() {
        this.mBlockContainer.setLayoutManagerType(1, 1);
        this.mBlockContainer.setParentFragment(getHostFragment());
        this.mBlockContainer.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(3);
        this.mBlockContainer.setEnableLoadMore(true);
        this.mBlockContainer.setEnableRefresh(false);
        this.mBlockContainer.getRecyclerView().setNestedScrollingEnabled(true);
        this.mBlockContainer.getRecyclerView().setOverScrollMode(0);
    }

    private final void U9() {
        if (this.mIsItemDecorationSetup || getActivity() == null) {
            return;
        }
        this.mIsItemDecorationSetup = true;
        com.qzone.reborn.feedx.widget.g gVar = new com.qzone.reborn.feedx.widget.g(getContext(), 0, DisplayUtil.dip2px(MobileQQ.sMobileQQ, 8.0f), O9());
        gVar.f(false);
        this.mBlockContainer.getRecyclerView().addItemDecoration(gVar);
    }

    private final void V9() {
        BlockMerger blockMerger;
        R9();
        N9();
        QZoneBlankStateView qZoneBlankStateView = this.mBlankView;
        if (qZoneBlankStateView != null) {
            qZoneBlankStateView.s0();
        }
        QZoneIntimateFeedAdapter qZoneIntimateFeedAdapter = this.mFeedListAdapter;
        if (qZoneIntimateFeedAdapter != null) {
            qZoneIntimateFeedAdapter.setDatas(null);
        }
        QZoneIntimateFeedAdapter qZoneIntimateFeedAdapter2 = this.mFeedListAdapter;
        if (qZoneIntimateFeedAdapter2 == null || (blockMerger = qZoneIntimateFeedAdapter2.getBlockMerger()) == null) {
            return;
        }
        blockMerger.showHint(false);
    }

    private final void W9() {
        this.mBlockContainer.setVisibility(4);
        N9();
        QZoneBlankStateView qZoneBlankStateView = this.mBlankView;
        if (qZoneBlankStateView != null) {
            qZoneBlankStateView.showErrorView();
        }
    }

    @Override // com.qzone.reborn.base.d
    protected we.b<?> C9() {
        return this.mFeedListAdapter;
    }

    @Override // qj.m
    public void W5() {
        scrollToTop();
    }

    @Override // qj.m
    public boolean fa() {
        return !com.qzone.reborn.feedx.util.ah.b(this.mBlockContainer != null ? r0.getRecyclerView() : null);
    }

    @Override // com.qzone.reborn.base.c, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View mRootView) {
        MutableLiveData<UIStateData<List<BusinessFeedData>>> T1;
        super.onInitView(mRootView);
        nk.ar arVar = (nk.ar) getViewModel(nk.ar.class);
        this.mFeedViewModel = arVar;
        if (arVar != null && (T1 = arVar.T1()) != null) {
            T1.observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.intimate.part.bi
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    bj.S9(bj.this, (UIStateData) obj);
                }
            });
        }
        T9();
        this.mBlankView = (QZoneBlankStateView) getPartRootView().findViewById(R.id.mqu);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        nk.ar arVar = this.mFeedViewModel;
        if (arVar != null) {
            arVar.L1();
        }
    }

    private final void P9(UIStateData<List<BusinessFeedData>> listUIStateData) {
        if (listUIStateData == null) {
            return;
        }
        int state = listUIStateData.getState();
        if (state == 0) {
            QZoneIntimateFeedAdapter qZoneIntimateFeedAdapter = this.mFeedListAdapter;
            if (qZoneIntimateFeedAdapter != null) {
                qZoneIntimateFeedAdapter.notifyLoadingComplete(false);
            }
            if (listUIStateData.getIsLoadMore()) {
                return;
            }
            V9();
            return;
        }
        if (state == 2 || state == 3) {
            QZoneIntimateFeedAdapter qZoneIntimateFeedAdapter2 = this.mFeedListAdapter;
            if (qZoneIntimateFeedAdapter2 != null) {
                qZoneIntimateFeedAdapter2.notifyLoadingComplete(true, listUIStateData.getIsFinish());
            }
            Q9(listUIStateData.getData(), listUIStateData.getIsLoadMore());
            return;
        }
        if (state != 4) {
            return;
        }
        QZoneIntimateFeedAdapter qZoneIntimateFeedAdapter3 = this.mFeedListAdapter;
        if (qZoneIntimateFeedAdapter3 != null) {
            qZoneIntimateFeedAdapter3.notifyLoadingComplete(false);
        }
        if (listUIStateData.getIsLoadMore()) {
            return;
        }
        W9();
    }

    private final void Q9(List<? extends BusinessFeedData> data, boolean isLoadMore) {
        if (data == null) {
            return;
        }
        this.mBlockContainer.setVisibility(0);
        QZoneBlankStateView qZoneBlankStateView = this.mBlankView;
        if (qZoneBlankStateView != null) {
            qZoneBlankStateView.o0();
        }
        if (this.mFeedListAdapter == null) {
            this.mFeedListAdapter = new QZoneIntimateFeedAdapter(null);
        }
        QZoneIntimateFeedAdapter qZoneIntimateFeedAdapter = this.mFeedListAdapter;
        if (qZoneIntimateFeedAdapter != null) {
            qZoneIntimateFeedAdapter.setDatas(data);
        }
        U9();
    }
}
