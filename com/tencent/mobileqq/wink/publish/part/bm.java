package com.tencent.mobileqq.wink.publish.part;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.publish.adapter.PublishAssociateLabelAdapter;
import com.tencent.mobileqq.wink.publish.base.BaseBlockContainer;
import com.tencent.mobileqq.wink.publish.event.PublishChangeTagPanelStateEvent;
import com.tencent.mobileqq.wink.publish.event.PublishContentGetFocusEvent;
import com.tencent.mobileqq.wink.publish.event.PublishKeyboardEvent;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishTagViewModel;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta$StTagInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 E2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001FB\u0007\u00a2\u0006\u0004\bC\u0010DJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u001e\u0010\r\u001a\u00020\u00062\u0014\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\tH\u0002J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0016J\u001a\u0010#\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0012\u0010%\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010)\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030'0&j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030'`(H\u0016R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010A\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/part/bm;", "Lcom/tencent/mobileqq/wink/publish/part/j;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "K9", "F9", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lfeedcloud/FeedCloudMeta$StTagInfo;", "listUIStateData", "N9", "", "isSuccess", "isLoadmore", "isFinish", "M9", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "H9", "J9", "O9", "Lcom/tencent/mobileqq/wink/publish/event/PublishChangeTagPanelStateEvent;", "event", "I9", "", "B9", "mRootView", "onInitView", "onBackEvent", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/mobileqq/wink/publish/base/BaseBlockContainer;", "d", "Lcom/tencent/mobileqq/wink/publish/base/BaseBlockContainer;", "mPanelContainer", "e", "Landroid/view/View;", "mPanelLayout", "Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishViewModel;", "f", "Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishViewModel;", "mPublishViewModel", "Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishTagViewModel;", tl.h.F, "Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishTagViewModel;", "tagViewModel", "Lcom/tencent/mobileqq/wink/publish/adapter/PublishAssociateLabelAdapter;", "i", "Lcom/tencent/mobileqq/wink/publish/adapter/PublishAssociateLabelAdapter;", "mAdapter", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "mOnScrollListener", BdhLogUtil.LogTag.Tag_Conn, "Z", "mIsInit", "<init>", "()V", "D", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class bm extends j implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mIsInit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private BaseBlockContainer mPanelContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mPanelLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private PublishViewModel mPublishViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private PublishTagViewModel tagViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private PublishAssociateLabelAdapter mAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView.OnScrollListener mOnScrollListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/publish/part/bm$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                VideoReport.traverseExposure();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/publish/part/bm$c", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            View view = bm.this.mPanelLayout;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPanelLayout");
                view = null;
            }
            view.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/publish/part/bm$d", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d extends RecyclerView.OnScrollListener {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (1 == newState) {
                SimpleEventBus.getInstance().dispatchEvent(new PublishKeyboardEvent(false));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
        }
    }

    private final void F9() {
        PublishTagViewModel publishTagViewModel = this.tagViewModel;
        if (publishTagViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagViewModel");
            publishTagViewModel = null;
        }
        publishTagViewModel.O1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.publish.part.bk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                bm.G9(bm.this, (UIStateData) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(bm this$0, UIStateData uIStateData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(uIStateData);
        String msg2 = uIStateData.getMsg();
        PublishTagViewModel publishTagViewModel = this$0.tagViewModel;
        PublishTagViewModel publishTagViewModel2 = null;
        if (publishTagViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagViewModel");
            publishTagViewModel = null;
        }
        if (publishTagViewModel.getQuery() != null && !TextUtils.isEmpty(msg2)) {
            PublishTagViewModel publishTagViewModel3 = this$0.tagViewModel;
            if (publishTagViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tagViewModel");
                publishTagViewModel3 = null;
            }
            if (!Intrinsics.areEqual(publishTagViewModel3.getQuery(), msg2)) {
                if (QLog.isColorLevel()) {
                    String str = af.L;
                    PublishTagViewModel publishTagViewModel4 = this$0.tagViewModel;
                    if (publishTagViewModel4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tagViewModel");
                    } else {
                        publishTagViewModel2 = publishTagViewModel4;
                    }
                    QLog.d(str, 2, "onChanged... req:" + publishTagViewModel2.getQuery() + " rsp:" + msg2);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                String str2 = af.L;
                PublishTagViewModel publishTagViewModel5 = this$0.tagViewModel;
                if (publishTagViewModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tagViewModel");
                } else {
                    publishTagViewModel2 = publishTagViewModel5;
                }
                QLog.d(str2, 2, "onChanged... req:" + publishTagViewModel2.getQuery() + " rsp:" + msg2);
            }
        }
        int state = uIStateData.getState();
        if (state != 0) {
            if (state != 2 && state != 3) {
                if (state != 4) {
                    return;
                }
            } else {
                this$0.N9(uIStateData);
                return;
            }
        }
        this$0.J9();
    }

    private final RecyclerView.OnScrollListener H9() {
        if (this.mOnScrollListener == null) {
            this.mOnScrollListener = new b();
        }
        return this.mOnScrollListener;
    }

    private final void I9(PublishChangeTagPanelStateEvent event) {
        int i3 = event.state;
        if (i3 != 0) {
            if (i3 == 1) {
                J9();
                return;
            }
            return;
        }
        O9();
    }

    private final void J9() {
        if (getActivity() != null && this.mIsInit) {
            View view = this.mPanelLayout;
            PublishViewModel publishViewModel = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPanelLayout");
                view = null;
            }
            if (view.getVisibility() != 8) {
                Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154784rz);
                loadAnimation.setDuration(200L);
                loadAnimation.setAnimationListener(new c());
                View view2 = this.mPanelLayout;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPanelLayout");
                    view2 = null;
                }
                view2.clearAnimation();
                View view3 = this.mPanelLayout;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPanelLayout");
                    view3 = null;
                }
                view3.startAnimation(loadAnimation);
                PublishViewModel publishViewModel2 = this.mPublishViewModel;
                if (publishViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPublishViewModel");
                } else {
                    publishViewModel = publishViewModel2;
                }
                publishViewModel.A3(false);
            }
        }
    }

    private final void K9(View rootView) {
        View findViewById = rootView.findViewById(R.id.f31350qt);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qcircle_lable_panel)");
        BaseBlockContainer baseBlockContainer = (BaseBlockContainer) findViewById;
        this.mPanelContainer = baseBlockContainer;
        BaseBlockContainer baseBlockContainer2 = null;
        if (baseBlockContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanelContainer");
            baseBlockContainer = null;
        }
        baseBlockContainer.setLayoutManagerType(1, 1);
        BaseBlockContainer baseBlockContainer3 = this.mPanelContainer;
        if (baseBlockContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanelContainer");
            baseBlockContainer3 = null;
        }
        baseBlockContainer3.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(2);
        BaseBlockContainer baseBlockContainer4 = this.mPanelContainer;
        if (baseBlockContainer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanelContainer");
            baseBlockContainer4 = null;
        }
        baseBlockContainer4.setEnableLoadMore(true);
        BaseBlockContainer baseBlockContainer5 = this.mPanelContainer;
        if (baseBlockContainer5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanelContainer");
            baseBlockContainer5 = null;
        }
        baseBlockContainer5.setEnableRefresh(false);
        BaseBlockContainer baseBlockContainer6 = this.mPanelContainer;
        if (baseBlockContainer6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanelContainer");
            baseBlockContainer6 = null;
        }
        baseBlockContainer6.setParentFragment(getHostFragment());
        BaseBlockContainer baseBlockContainer7 = this.mPanelContainer;
        if (baseBlockContainer7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanelContainer");
            baseBlockContainer7 = null;
        }
        baseBlockContainer7.getRecyclerView().setNestedScrollingEnabled(true);
        ArrayList<MultiViewBlock> arrayList = new ArrayList<>();
        PublishAssociateLabelAdapter publishAssociateLabelAdapter = new PublishAssociateLabelAdapter(null);
        this.mAdapter = publishAssociateLabelAdapter;
        arrayList.add(publishAssociateLabelAdapter);
        PublishAssociateLabelAdapter publishAssociateLabelAdapter2 = this.mAdapter;
        if (publishAssociateLabelAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            publishAssociateLabelAdapter2 = null;
        }
        publishAssociateLabelAdapter2.setOnLoadDataDelegate(new MultiViewBlock.OnLoadDataDelegate() { // from class: com.tencent.mobileqq.wink.publish.part.bl
            @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
            public final void onLoadData(LoadInfo loadInfo, Object obj) {
                bm.L9(bm.this, loadInfo, obj);
            }
        });
        BaseBlockContainer baseBlockContainer8 = this.mPanelContainer;
        if (baseBlockContainer8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanelContainer");
            baseBlockContainer8 = null;
        }
        baseBlockContainer8.registerBlock(arrayList);
        PublishAssociateLabelAdapter publishAssociateLabelAdapter3 = this.mAdapter;
        if (publishAssociateLabelAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            publishAssociateLabelAdapter3 = null;
        }
        BaseBlockContainer baseBlockContainer9 = this.mPanelContainer;
        if (baseBlockContainer9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanelContainer");
            baseBlockContainer9 = null;
        }
        publishAssociateLabelAdapter3.j0(baseBlockContainer9.getRecyclerView());
        PublishAssociateLabelAdapter publishAssociateLabelAdapter4 = this.mAdapter;
        if (publishAssociateLabelAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            publishAssociateLabelAdapter4 = null;
        }
        publishAssociateLabelAdapter4.addOnScrollListener(H9());
        BaseBlockContainer baseBlockContainer10 = this.mPanelContainer;
        if (baseBlockContainer10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanelContainer");
            baseBlockContainer10 = null;
        }
        baseBlockContainer10.getRecyclerView().addOnScrollListener(new d());
        BaseBlockContainer baseBlockContainer11 = this.mPanelContainer;
        if (baseBlockContainer11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanelContainer");
        } else {
            baseBlockContainer2 = baseBlockContainer11;
        }
        baseBlockContainer2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(bm this$0, LoadInfo loadInfo, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (loadInfo.isLoadMoreState()) {
            PublishTagViewModel publishTagViewModel = this$0.tagViewModel;
            if (publishTagViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tagViewModel");
                publishTagViewModel = null;
            }
            publishTagViewModel.a2("", true);
        }
    }

    private final void M9(boolean isSuccess, boolean isLoadmore, boolean isFinish) {
        PublishAssociateLabelAdapter publishAssociateLabelAdapter = this.mAdapter;
        PublishAssociateLabelAdapter publishAssociateLabelAdapter2 = null;
        if (publishAssociateLabelAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            publishAssociateLabelAdapter = null;
        }
        if (publishAssociateLabelAdapter.getBlockMerger() != null) {
            PublishAssociateLabelAdapter publishAssociateLabelAdapter3 = this.mAdapter;
            if (publishAssociateLabelAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                publishAssociateLabelAdapter3 = null;
            }
            publishAssociateLabelAdapter3.getLoadInfo().setCurrentState(4);
            PublishAssociateLabelAdapter publishAssociateLabelAdapter4 = this.mAdapter;
            if (publishAssociateLabelAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                publishAssociateLabelAdapter4 = null;
            }
            publishAssociateLabelAdapter4.getLoadInfo().setFinish(isFinish);
            BaseBlockContainer baseBlockContainer = this.mPanelContainer;
            if (baseBlockContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPanelContainer");
                baseBlockContainer = null;
            }
            baseBlockContainer.setRefreshing(false);
            PublishAssociateLabelAdapter publishAssociateLabelAdapter5 = this.mAdapter;
            if (publishAssociateLabelAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                publishAssociateLabelAdapter5 = null;
            }
            publishAssociateLabelAdapter5.getBlockMerger().showHint(false);
            PublishAssociateLabelAdapter publishAssociateLabelAdapter6 = this.mAdapter;
            if (publishAssociateLabelAdapter6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                publishAssociateLabelAdapter6 = null;
            }
            publishAssociateLabelAdapter6.getBlockMerger().setNoMoreHint("");
            PublishAssociateLabelAdapter publishAssociateLabelAdapter7 = this.mAdapter;
            if (publishAssociateLabelAdapter7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            } else {
                publishAssociateLabelAdapter2 = publishAssociateLabelAdapter7;
            }
            publishAssociateLabelAdapter2.getBlockMerger().onLoadMoreCompleted(isSuccess, isFinish);
            QLog.d(af.L, 4, "iscuccess:" + isSuccess + " isfinish:" + isFinish);
        }
    }

    private final void N9(UIStateData<List<FeedCloudMeta$StTagInfo>> listUIStateData) {
        if (listUIStateData.getData() != null) {
            BaseBlockContainer baseBlockContainer = null;
            if (!listUIStateData.getIsLoadMore()) {
                PublishAssociateLabelAdapter publishAssociateLabelAdapter = this.mAdapter;
                if (publishAssociateLabelAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                    publishAssociateLabelAdapter = null;
                }
                publishAssociateLabelAdapter.setData(listUIStateData.getData());
            } else {
                PublishAssociateLabelAdapter publishAssociateLabelAdapter2 = this.mAdapter;
                if (publishAssociateLabelAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                    publishAssociateLabelAdapter2 = null;
                }
                publishAssociateLabelAdapter2.addData(listUIStateData.getData());
            }
            M9(true, listUIStateData.getIsLoadMore(), listUIStateData.getIsFinish());
            O9();
            if (!listUIStateData.getIsLoadMore()) {
                BaseBlockContainer baseBlockContainer2 = this.mPanelContainer;
                if (baseBlockContainer2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPanelContainer");
                    baseBlockContainer2 = null;
                }
                if (baseBlockContainer2.getRecyclerView() != null) {
                    BaseBlockContainer baseBlockContainer3 = this.mPanelContainer;
                    if (baseBlockContainer3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPanelContainer");
                    } else {
                        baseBlockContainer = baseBlockContainer3;
                    }
                    baseBlockContainer.getRecyclerView().smoothScrollToPosition(0);
                }
            }
        }
    }

    private final void O9() {
        if (getActivity() != null && this.mIsInit) {
            View view = this.mPanelLayout;
            PublishViewModel publishViewModel = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPanelLayout");
                view = null;
            }
            if (view.getVisibility() == 0 || getActivity().isFinishing()) {
                return;
            }
            View view2 = this.mPanelLayout;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPanelLayout");
                view2 = null;
            }
            view2.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f155027v4);
            loadAnimation.setAnimationListener(new e());
            loadAnimation.setDuration(200L);
            View view3 = this.mPanelLayout;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPanelLayout");
                view3 = null;
            }
            view3.clearAnimation();
            View view4 = this.mPanelLayout;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPanelLayout");
                view4 = null;
            }
            view4.startAnimation(loadAnimation);
            PublishViewModel publishViewModel2 = this.mPublishViewModel;
            if (publishViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPublishViewModel");
            } else {
                publishViewModel = publishViewModel2;
            }
            publishViewModel.A3(true);
            SimpleEventBus.getInstance().dispatchEvent(new PublishContentGetFocusEvent());
        }
    }

    @Override // com.tencent.mobileqq.wink.publish.part.j
    @NotNull
    public String B9() {
        return "PublishTagPanelPart";
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(PublishChangeTagPanelStateEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (this.mIsInit) {
            View view = this.mPanelLayout;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPanelLayout");
                view = null;
            }
            if (view.getVisibility() == 0) {
                J9();
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View mRootView) {
        super.onInitView(mRootView);
        Intrinsics.checkNotNull(mRootView);
        View findViewById = mRootView.findViewById(R.id.f32770un);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView!!.findViewById\u2026id.qcircle_tag_container)");
        this.mPanelLayout = findViewById;
        View findViewById2 = mRootView.findViewById(R.id.f31350qt);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.qcircle_lable_panel)");
        this.mPanelContainer = (BaseBlockContainer) findViewById2;
        ViewModel viewModel = getViewModel(PublishViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(PublishViewModel::class.java)");
        this.mPublishViewModel = (PublishViewModel) viewModel;
        ViewModel viewModel2 = getViewModel(PublishTagViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(PublishTagViewModel::class.java)");
        this.tagViewModel = (PublishTagViewModel) viewModel2;
        K9(mRootView);
        F9();
        this.mIsInit = true;
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        PublishAssociateLabelAdapter publishAssociateLabelAdapter = this.mAdapter;
        if (publishAssociateLabelAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            publishAssociateLabelAdapter = null;
        }
        publishAssociateLabelAdapter.removeOnScrollListener(H9());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof PublishChangeTagPanelStateEvent) {
            I9((PublishChangeTagPanelStateEvent) event);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/publish/part/bm$e", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            VideoReport.traverseExposure();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
        }
    }
}
