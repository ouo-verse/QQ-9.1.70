package com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qqcircle.adapter.QFSCommentBlock;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentInputWindowConfig;
import com.tencent.biz.qqcircle.bizparts.ag;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSCommentInputButNotSendEvent;
import com.tencent.biz.qqcircle.immersive.gallery.viewmodel.QFSGalleryDetailViewModel;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010K\u001a\u00020J\u0012\u0006\u00104\u001a\u000201\u00a2\u0006\u0004\bL\u0010MJ\"\u0010\u0007\u001a\u00020\u00062\u0018\u0010\u0005\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0014J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\tJ\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0014J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0019\u001a\u00020\u000bH\u0014J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0014J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0014J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H\u0014J\u0012\u0010$\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010#H\u0016J$\u0010(\u001a\u001e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010&0%j\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010&`'H\u0016J\u0012\u0010*\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010\u000bH\u0014J\u001a\u0010-\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010+2\b\u0010)\u001a\u0004\u0018\u00010\u000bJ\u0018\u00100\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010/\u001a\u00020.R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u00106R\u0016\u0010:\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010H\u00a8\u0006N"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/QFSNewContentDetailBodyCommentPart;", "Lcom/tencent/biz/qqcircle/bizparts/ag;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Le30/b;", "uiStateData", "", "M9", "feedBlockData", "Lcom/tencent/biz/qqcircle/beans/QFSCommentInfo;", "J9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "N9", "Lcom/tencent/biz/qqcircle/immersive/feed/event/QFSCommentInputButNotSendEvent;", "e", "L9", "onInitView", "initViewModel", "commentInfo", "I9", "init", "getContainer", "Lcom/tencent/biz/qqcircle/fragments/QCircleBlockContainer;", "getBlockContainer", "getCommentBottomBar", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "getTextInputView", "", "tailText", "updateListEmptyTextView", "getLogTag", "", "isShowLoading", "setLoadingStatus", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "view", "scrollItemToVisibleAboveInputLayout", "Lcom/tencent/biz/richframework/part/block/BlockContainer;", ParseCommon.CONTAINER, "O9", "", "pxNum", "K9", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "d", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "mInitBean", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "mContainer", "f", "Lcom/tencent/biz/qqcircle/fragments/QCircleBlockContainer;", "mBlockContainer", "Landroid/widget/RelativeLayout;", tl.h.F, "Landroid/widget/RelativeLayout;", "mCommentBottomBar", "i", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "mTextInput", "Landroid/widget/LinearLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/LinearLayout;", "mEmptyView", "Lcom/tencent/biz/qqcircle/immersive/gallery/viewmodel/QFSGalleryDetailViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qqcircle/immersive/gallery/viewmodel/QFSGalleryDetailViewModel;", "mViewModel", "Lcom/tencent/biz/qqcircle/adapter/QFSCommentBlock;", "block", "<init>", "(Lcom/tencent/biz/qqcircle/adapter/QFSCommentBlock;Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSNewContentDetailBodyCommentPart extends ag {

    /* renamed from: C, reason: from kotlin metadata */
    private QFSGalleryDetailViewModel mViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QCircleInitBean mInitBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QCircleBlockContainer mBlockContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mCommentBottomBar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QCircleAsyncTextView mTextInput;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mEmptyView;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001J\"\u0010\u0007\u001a\u00020\u00062\u0018\u0010\u0005\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/QFSNewContentDetailBodyCommentPart$a", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Le30/b;", "listUIStateData", "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a implements Observer<UIStateData<List<e30.b>>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable UIStateData<List<e30.b>> listUIStateData) {
            QFSNewContentDetailBodyCommentPart.this.M9(listUIStateData);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/QFSNewContentDetailBodyCommentPart$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                VideoReport.traversePage(recyclerView);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/QFSNewContentDetailBodyCommentPart$c", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@Nullable View v3) {
            EventCollector.getInstance().onViewClickedBefore(v3);
            QFSNewContentDetailBodyCommentPart.this.showCommentInputWindow();
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSNewContentDetailBodyCommentPart(@NotNull QFSCommentBlock block, @NotNull QCircleInitBean mInitBean) {
        super(block);
        Intrinsics.checkNotNullParameter(block, "block");
        Intrinsics.checkNotNullParameter(mInitBean, "mInitBean");
        this.mInitBean = mInitBean;
        this.mIsNeedShowPublishIcon = false;
    }

    private final QFSCommentInfo J9(e30.b feedBlockData) {
        QFSCommentInfo qFSCommentInfo = new QFSCommentInfo();
        FeedCloudMeta$StFeed g16 = feedBlockData.g();
        qFSCommentInfo.mFeed = g16;
        qFSCommentInfo.mFeedBlockData = feedBlockData;
        g16.commentTextInfo.normalCommentBoxDesc.set(com.tencent.biz.qqcircle.utils.h.a(R.string.f1920946k));
        QFSCommentInfo.ActionBean actionBean = new QFSCommentInfo.ActionBean();
        actionBean.mNeedShowTopFeedDesc = false;
        qFSCommentInfo.mActionBean = actionBean;
        return qFSCommentInfo;
    }

    private final void L9(QFSCommentInputButNotSendEvent e16) {
        QFSCommentInfo qFSCommentInfo = this.mInfo;
        if (qFSCommentInfo != null && qFSCommentInfo.mFeed != null) {
            QFSCommentInputWindowConfig qFSCommentInputWindowConfig = new QFSCommentInputWindowConfig();
            if (e16.showAt) {
                qFSCommentInputWindowConfig.needShowAt = true;
            }
            if (e16.showEmoji) {
                qFSCommentInputWindowConfig.isShowEmoji = true;
            }
            if (e16.showImage) {
                qFSCommentInputWindowConfig.isShowHalfScreenPicPanel = true;
            }
            this.mInfo.mCmtPanelSource = 1;
            showCommentInputWindow(null, null, qFSCommentInputWindowConfig);
            boolean showCommentInputWindow = showCommentInputWindow();
            QLog.d(getTAG(), 1, "[handleQFSCommentInputButNotSendEvent] isShowInput = " + showCommentInputWindow);
            return;
        }
        QLog.e(getTAG(), 1, "[handleQFSCommentInputButNotSendEvent] mInfo == null || mInfo.mFeed == null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9(UIStateData<List<e30.b>> uiStateData) {
        e30.b bVar;
        Object orNull;
        if (uiStateData == null) {
            QLog.e(getTAG(), 1, "[handleUiStatus] uiStateData == null");
            return;
        }
        int state = uiStateData.getState();
        QLog.d(getTAG(), 1, "[handleUiStatus] state = " + state);
        if (state != 2 && state != 3) {
            return;
        }
        List<e30.b> data = uiStateData.getData();
        if (data != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(data, 0);
            bVar = (e30.b) orNull;
        } else {
            bVar = null;
        }
        if (bVar == null) {
            QLog.e(getTAG(), 1, "[handleUiStatus] feedBlockData == null");
        } else {
            I9(J9(bVar));
        }
    }

    private final void N9(View rootView) {
        View findViewById = rootView.findViewById(R.id.f47221wp);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Fr\u2026fs_mix_feed_gallery_page)");
        FrameLayout frameLayout = (FrameLayout) findViewById;
        this.mContainer = frameLayout;
        QCircleBlockContainer qCircleBlockContainer = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            frameLayout = null;
        }
        View findViewById2 = frameLayout.findViewById(R.id.f47241wr);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContainer.findViewById<\u2026page_center_content_view)");
        this.mBlockContainer = (QCircleBlockContainer) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f47231wq);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById<Re\u2026_gallery_page_bottom_bar)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById3;
        this.mCommentBottomBar = relativeLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentBottomBar");
            relativeLayout = null;
        }
        View findViewById4 = relativeLayout.findViewById(R.id.f47261wt);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mCommentBottomBar.findVi\u2026_gallery_page_input_hint)");
        this.mTextInput = (QCircleAsyncTextView) findViewById4;
        QCircleBlockContainer qCircleBlockContainer2 = this.mBlockContainer;
        if (qCircleBlockContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlockContainer");
        } else {
            qCircleBlockContainer = qCircleBlockContainer2;
        }
        qCircleBlockContainer.getRecyclerView().addOnScrollListener(new b());
    }

    public final void I9(@NotNull QFSCommentInfo commentInfo) {
        Intrinsics.checkNotNullParameter(commentInfo, "commentInfo");
        initCommentInfo(commentInfo);
    }

    public final void K9(@Nullable BlockContainer container, int pxNum) {
        if (container != null && container.getRecyclerView().getChildCount() > 0) {
            NestScrollRecyclerView recyclerView = container.getRecyclerView();
            View childAt = recyclerView.getChildAt(recyclerView.getChildCount() - 1);
            if (childAt == null || !(recyclerView.findContainingViewHolder(childAt) instanceof PullLoadMoreAdapter.LoadMoreViewHolder)) {
                return;
            }
            childAt.setPadding(childAt.getPaddingLeft(), childAt.getPaddingTop(), childAt.getPaddingRight(), pxNum);
        }
    }

    public final void O9(@Nullable final BlockContainer container, @Nullable final View view) {
        if (view == null) {
            return;
        }
        view.getLocationOnScreen(r0);
        final int[] iArr = {0, iArr[1] + view.getHeight()};
        final int J = QFSCommentHelper.L().J();
        if (iArr[1] > J && container != null) {
            container.getRecyclerView().scrollBy(0, iArr[1] - J);
            K9(container, iArr[1] - J);
            RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.QFSNewContentDetailBodyCommentPart$scrollItemToVisible$1
                @Override // java.lang.Runnable
                public void run() {
                    view.getLocationOnScreen(iArr);
                    int[] iArr2 = iArr;
                    iArr2[1] = iArr2[1] + view.getHeight();
                    if (iArr[1] > J) {
                        container.getRecyclerView().scrollBy(0, iArr[1] - J);
                    }
                }
            }, 1L, true);
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    @Nullable
    protected QCircleBlockContainer getBlockContainer() {
        QCircleBlockContainer qCircleBlockContainer = this.mBlockContainer;
        if (qCircleBlockContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlockContainer");
            return null;
        }
        return qCircleBlockContainer;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    @NotNull
    protected View getCommentBottomBar() {
        RelativeLayout relativeLayout = this.mCommentBottomBar;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentBottomBar");
            return null;
        }
        return relativeLayout;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    @NotNull
    protected View getContainer() {
        QCircleBlockContainer qCircleBlockContainer = this.mBlockContainer;
        if (qCircleBlockContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlockContainer");
            return null;
        }
        return qCircleBlockContainer;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<?>> getEventClass() {
        ArrayList<Class<?>> eventClass = super.getEventClass();
        if (eventClass == null) {
            eventClass = new ArrayList<>();
        }
        eventClass.add(QFSCommentInputButNotSendEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSNewContentDetailBodyCommentPart";
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    @Nullable
    protected QCircleAsyncTextView getTextInputView() {
        QCircleAsyncTextView qCircleAsyncTextView = this.mTextInput;
        if (qCircleAsyncTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTextInput");
            return null;
        }
        return qCircleAsyncTextView;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag, com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.a
    public void init() {
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.bizparts.ag
    public void initViewModel() {
        super.initViewModel();
        ViewModel viewModel = getViewModel(QFSGalleryDetailViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel<QFSGalleryD\u2026ailViewModel::class.java)");
        QFSGalleryDetailViewModel qFSGalleryDetailViewModel = (QFSGalleryDetailViewModel) viewModel;
        this.mViewModel = qFSGalleryDetailViewModel;
        if (qFSGalleryDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            qFSGalleryDetailViewModel = null;
        }
        qFSGalleryDetailViewModel.j().observeForever(new a());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        N9(rootView);
        initViewModel();
        if (!this.mInitBean.isForceFromNetwork()) {
            I9(J9(new e30.b(this.mInitBean.getFeed())));
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent e16) {
        super.onReceiveEvent(e16);
        if (e16 instanceof QFSCommentInputButNotSendEvent) {
            L9((QFSCommentInputButNotSendEvent) e16);
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    protected void scrollItemToVisibleAboveInputLayout(@Nullable View view) {
        NestScrollRecyclerView nestScrollRecyclerView;
        registerKeyboardEvent();
        QCircleBlockContainer blockContainer = getBlockContainer();
        QCircleBlockContainer qCircleBlockContainer = null;
        if (blockContainer != null) {
            nestScrollRecyclerView = blockContainer.getRecyclerView();
        } else {
            nestScrollRecyclerView = null;
        }
        if (nestScrollRecyclerView == null) {
            return;
        }
        View childAt = nestScrollRecyclerView.getChildAt(nestScrollRecyclerView.getChildCount() - 1);
        if (!(childAt instanceof QFSNewContentDetailBodyCommentView)) {
            QLog.e(getTAG(), 1, "[scrollItemToVisibleAboveInputLayout] commentView is not QFSNewContentDetailBodyCommentView");
            return;
        }
        QFSNewContentDetailBodyCommentView qFSNewContentDetailBodyCommentView = (QFSNewContentDetailBodyCommentView) childAt;
        if (qFSNewContentDetailBodyCommentView.getChildCount() <= 0) {
            QLog.e(getTAG(), 1, "[scrollItemToVisibleAboveInputLayout] bodyCommentView.getChildCount() <= 0");
            return;
        }
        View childAt2 = qFSNewContentDetailBodyCommentView.getChildAt(0);
        Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) childAt2;
        int[] iArr = new int[2];
        viewGroup.getChildAt(0).getLocationOnScreen(iArr);
        if (iArr[1] - (cx.a(52.0f) + ImmersiveUtils.getStatusBarHeight(getContext())) < 0) {
            View childAt3 = viewGroup.getChildAt(2);
            if (childAt3 instanceof QCircleBlockContainer) {
                qCircleBlockContainer = (QCircleBlockContainer) childAt3;
            }
            O9(qCircleBlockContainer, view);
            return;
        }
        O9(getBlockContainer(), view);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    protected void updateListEmptyTextView(@NotNull String tailText) {
        Intrinsics.checkNotNullParameter(tailText, "tailText");
        View findViewById = this.mBlock.getBlockContainer().getRootView().findViewById(R.id.f4887216);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mBlock.getBlockContainer\u2026_page_comment_empty_view)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.mEmptyView = linearLayout;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
            linearLayout = null;
        }
        linearLayout.findViewById(R.id.f361113o).setOnClickListener(new c());
        LinearLayout linearLayout3 = this.mEmptyView;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
            linearLayout3 = null;
        }
        linearLayout3.setVisibility(8);
        if (this.mBlock.getItemCount() != 0) {
            LinearLayout linearLayout4 = this.mEmptyView;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
            } else {
                linearLayout2 = linearLayout4;
            }
            linearLayout2.setVisibility(8);
            if (this.mBlock.getBlockContainer() != null) {
                this.mBlock.getBlockContainer().setVisibility(0);
                return;
            }
            return;
        }
        LinearLayout linearLayout5 = this.mEmptyView;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
        } else {
            linearLayout2 = linearLayout5;
        }
        linearLayout2.setVisibility(0);
        if (this.mBlock.getBlockContainer() != null) {
            this.mBlock.getBlockContainer().setVisibility(8);
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    protected void setLoadingStatus(boolean isShowLoading) {
    }
}
