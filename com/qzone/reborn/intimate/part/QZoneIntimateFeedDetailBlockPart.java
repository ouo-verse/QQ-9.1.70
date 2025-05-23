package com.qzone.reborn.intimate.part;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.base.QZoneBaseBlockContainer;
import com.qzone.util.ToastUtil;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 12\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00012B#\u0012\u0006\u0010+\u001a\u00020*\u0012\u0012\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010-0,\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J\u0016\u0010\n\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\f\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0014J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u00063"}, d2 = {"Lcom/qzone/reborn/intimate/part/QZoneIntimateFeedDetailBlockPart;", "Lcom/qzone/reborn/base/d;", "Landroidx/lifecycle/Observer;", "Laf/b;", "", "Q9", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "listUIStateData", "O9", "T9", "data", "P9", "R9", "V9", "", "getLogTag", "Lwe/b;", "C9", "Landroid/view/View;", "mRootView", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "commentInfoBean", "S9", "Lnk/aq;", "e", "Lnk/aq;", "mDetailViewModel", "f", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "mFeedData", "Lcom/qzone/reborn/intimate/block/b;", tl.h.F, "Lcom/qzone/reborn/intimate/block/b;", "mDetailAdapter", "Lcom/qzone/reborn/feedx/block/j;", "i", "Lcom/qzone/reborn/feedx/block/j;", "mCommentAdapter", "", "peerBlockFindViewId", "", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "peerBlocks", "<init>", "(ILjava/util/List;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateFeedDetailBlockPart extends com.qzone.reborn.base.d implements Observer<af.b> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private nk.aq mDetailViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private BusinessFeedData mFeedData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.intimate.block.b mDetailAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedx.block.j mCommentAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneIntimateFeedDetailBlockPart(int i3, List<? extends MultiViewBlock<?>> peerBlocks) {
        super(i3, peerBlocks);
        Intrinsics.checkNotNullParameter(peerBlocks, "peerBlocks");
        for (MultiViewBlock<?> multiViewBlock : peerBlocks) {
            if (multiViewBlock instanceof com.qzone.reborn.intimate.block.b) {
                this.mDetailAdapter = (com.qzone.reborn.intimate.block.b) multiViewBlock;
            } else if (multiViewBlock instanceof com.qzone.reborn.feedx.block.j) {
                this.mCommentAdapter = (com.qzone.reborn.feedx.block.j) multiViewBlock;
            }
        }
    }

    private final void P9(BusinessFeedData data) {
        this.mFeedData = data;
        ze.a a16 = ze.a.a();
        BusinessFeedData businessFeedData = this.mFeedData;
        com.qzone.reborn.intimate.block.b bVar = null;
        String a17 = businessFeedData != null ? ef.b.a(businessFeedData) : null;
        BusinessFeedData businessFeedData2 = this.mFeedData;
        a16.observerGlobalState(new af.b(a17, businessFeedData2 != null ? businessFeedData2.getCommentInfo() : null), this);
        com.qzone.reborn.intimate.block.b bVar2 = this.mDetailAdapter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDetailAdapter");
            bVar2 = null;
        }
        bVar2.getDataList().clear();
        com.qzone.reborn.intimate.block.b bVar3 = this.mDetailAdapter;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDetailAdapter");
        } else {
            bVar = bVar3;
        }
        bVar.getDataList().add(data);
        this.mBlockContainer.setVisibility(0);
        V9(data);
    }

    private final void Q9() {
        this.mBlockContainer.getBlockMerger().setNoMoreHint(HardCodeUtil.qqStr(R.string.mdt));
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(101, 10);
        recycledViewPool.setMaxRecycledViews(102, 10);
        this.mBlockContainer.getRecyclerView().setRecycledViewPool(recycledViewPool);
        NestScrollRecyclerView recyclerView = this.mBlockContainer.getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "mBlockContainer.recyclerView");
        com.qzone.reborn.feedx.util.v.a(recyclerView);
    }

    private final void R9() {
        BlockContainer blockContainer = this.mBlockContainer;
        if (blockContainer == null || blockContainer.getBlockMerger() == null) {
            return;
        }
        this.mBlockContainer.getBlockMerger().notifyDataSetChanged();
    }

    private final void T9(UIStateData<BusinessFeedData> listUIStateData) {
        QLog.e("QZoneIntimateFeedDetailBlockPart", 1, "handleDetailRsp() return error  | retCode = " + listUIStateData.getRetCode() + " | msg = " + listUIStateData.getMsg());
        com.qzone.reborn.intimate.block.b bVar = this.mDetailAdapter;
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
            com.qzone.reborn.intimate.block.b bVar2 = this.mDetailAdapter;
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
            R9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void V9(BusinessFeedData data) {
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
        com.qzone.reborn.feedx.block.j jVar4 = this.mCommentAdapter;
        if (jVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentAdapter");
        } else {
            jVar2 = jVar4;
        }
        jVar2.notifyLoadingComplete(true, true);
    }

    @Override // com.qzone.reborn.base.d
    protected we.b<?> C9() {
        com.qzone.reborn.intimate.block.b bVar = this.mDetailAdapter;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDetailAdapter");
        return null;
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateFeedDetailBlockPart";
    }

    @Override // com.qzone.reborn.base.c, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View mRootView) {
        MutableLiveData<UIStateData<BusinessFeedData>> R1;
        super.onInitView(mRootView);
        this.mDetailViewModel = (nk.aq) getViewModel(nk.aq.class);
        this.mBlockContainer.setLayoutManagerType(1, 1);
        this.mBlockContainer.setParentFragment(getHostFragment());
        this.mBlockContainer.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(2);
        this.mBlockContainer.setEnableLoadMore(true);
        this.mBlockContainer.setEnableRefresh(true);
        nk.aq aqVar = this.mDetailViewModel;
        if (aqVar != null && (R1 = aqVar.R1()) != null) {
            Fragment hostFragment = getHostFragment();
            final Function1<UIStateData<BusinessFeedData>, Unit> function1 = new Function1<UIStateData<BusinessFeedData>, Unit>() { // from class: com.qzone.reborn.intimate.part.QZoneIntimateFeedDetailBlockPart$onInitView$1
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
                    QZoneIntimateFeedDetailBlockPart.this.O9(businessFeedDataUIStateData);
                }
            };
            R1.observe(hostFragment, new Observer() { // from class: com.qzone.reborn.intimate.part.bk
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZoneIntimateFeedDetailBlockPart.U9(Function1.this, obj);
                }
            });
        }
        Q9();
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        BlockContainer blockContainer = this.mBlockContainer;
        if (blockContainer instanceof QZoneBaseBlockContainer) {
            Intrinsics.checkNotNull(blockContainer, "null cannot be cast to non-null type com.qzone.reborn.base.QZoneBaseBlockContainer");
            ((QZoneBaseBlockContainer) blockContainer).c();
        }
        nk.aq aqVar = this.mDetailViewModel;
        if (aqVar != null) {
            Intrinsics.checkNotNull(aqVar);
            aqVar.L1();
        }
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: S9, reason: merged with bridge method [inline-methods] */
    public void onChanged(af.b commentInfoBean) {
        if (commentInfoBean != null) {
            String b16 = commentInfoBean.b();
            BusinessFeedData businessFeedData = this.mFeedData;
            if (TextUtils.equals(b16, businessFeedData != null ? ef.b.a(businessFeedData) : null)) {
                BusinessFeedData businessFeedData2 = this.mFeedData;
                if (businessFeedData2 != null) {
                    businessFeedData2.setCommentInfo(commentInfoBean.a());
                }
                V9(this.mFeedData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9(UIStateData<BusinessFeedData> listUIStateData) {
        if (listUIStateData == null) {
            return;
        }
        int state = listUIStateData.getState();
        com.qzone.reborn.intimate.block.b bVar = null;
        if (state == 0) {
            QLog.e("QZoneIntimateFeedDetailBlockPart", 1, "handleDetailRsp() return empty data");
            com.qzone.reborn.intimate.block.b bVar2 = this.mDetailAdapter;
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
            T9(listUIStateData);
            return;
        }
        com.qzone.reborn.intimate.block.b bVar3 = this.mDetailAdapter;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDetailAdapter");
        } else {
            bVar = bVar3;
        }
        bVar.notifyLoadingComplete(true, listUIStateData.getIsFinish());
        BusinessFeedData data = listUIStateData.getData();
        Intrinsics.checkNotNullExpressionValue(data, "listUIStateData.data");
        P9(data);
    }
}
