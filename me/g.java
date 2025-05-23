package me;

import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProPicMixVideoView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import me.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001#\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lme/g;", "Lne/a;", "", tl.h.F, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "u", "Landroid/view/View;", "containerView", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", HippyTKDListViewAdapter.X, "Landroid/widget/FrameLayout;", "E", "Landroid/widget/FrameLayout;", "mMultiPicViewContainer", "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/RecyclerView;", "mMultiPicView", "Landroidx/recyclerview/widget/GridLayoutManager;", "G", "Landroidx/recyclerview/widget/GridLayoutManager;", "mGridLayoutManager", "Lme/i;", "H", "Lme/i;", "mMultiPicAdapter", "Lyd/a;", "I", "Lyd/a;", "mAdData", "me/g$a", "J", "Lme/g$a;", "mItemDecoration", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class g extends ne.a {

    /* renamed from: E, reason: from kotlin metadata */
    private FrameLayout mMultiPicViewContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private RecyclerView mMultiPicView;

    /* renamed from: G, reason: from kotlin metadata */
    private GridLayoutManager mGridLayoutManager;

    /* renamed from: H, reason: from kotlin metadata */
    private i mMultiPicAdapter;

    /* renamed from: I, reason: from kotlin metadata */
    private yd.a mAdData;

    /* renamed from: J, reason: from kotlin metadata */
    private final a mItemDecoration = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"me/g$a", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a extends RecyclerView.ItemDecoration {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int roundToInt;
            int roundToInt2;
            CommonCellMedia cellMedia;
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            CommonFeed mFeedData = g.this.getMFeedData();
            List<CommonMedia> mediaItems = (mFeedData == null || (cellMedia = mFeedData.getCellMedia()) == null) ? null : cellMedia.getMediaItems();
            List<CommonMedia> list = mediaItems;
            if (list == null || list.isEmpty()) {
                super.getItemOffsets(outRect, view, parent, state);
                return;
            }
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            outRect.top = 0;
            int i3 = childAdapterPosition % 3;
            if (i3 == 0) {
                outRect.left = 0;
                roundToInt = MathKt__MathJVMKt.roundToInt((QzoneFeedProPicMixVideoView.INSTANCE.a() / 3) * 2);
                outRect.right = roundToInt;
            } else if (i3 != 1) {
                roundToInt2 = MathKt__MathJVMKt.roundToInt((QzoneFeedProPicMixVideoView.INSTANCE.a() / 3) * 2);
                outRect.left = roundToInt2;
                outRect.right = 0;
            } else {
                QzoneFeedProPicMixVideoView.Companion companion = QzoneFeedProPicMixVideoView.INSTANCE;
                outRect.left = companion.a() / 3;
                outRect.right = companion.a() / 3;
            }
            if (childAdapterPosition < mediaItems.size() - 3) {
                outRect.bottom = QzoneFeedProPicMixVideoView.INSTANCE.a();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"me/g$b", "Lme/i$a;", "", "onItemClick", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements i.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CommonFeed f416586b;

        b(CommonFeed commonFeed) {
            this.f416586b = commonFeed;
        }

        @Override // me.i.a
        public void onItemClick() {
            g6.c cVar = g6.c.f401419a;
            Activity activity = g.this.getActivity();
            RecyclerView recyclerView = g.this.mMultiPicView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMultiPicView");
                recyclerView = null;
            }
            CommonFeed commonFeed = this.f416586b;
            cVar.g(activity, recyclerView, commonFeed != null ? xd.c.h(commonFeed) : null, FeedElement.PHOTO, 5, g.this.getMPosition(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ne.a
    /* renamed from: h */
    public String getTAG() {
        return "QZoneAdFeedMultiPicSection";
    }

    @Override // ne.a
    protected int q() {
        return R.id.f162975nn0;
    }

    @Override // ne.a
    protected boolean u() {
        return false;
    }

    @Override // ne.a
    protected void x(CommonFeed feedData) {
        CommonCellMedia cellMedia;
        yd.a h16 = xd.c.h(feedData);
        if (TextUtils.isEmpty(yd.b.l(this.mAdData)) || !TextUtils.equals(yd.b.l(this.mAdData), yd.b.l(h16))) {
            this.mAdData = h16;
            i iVar = new i();
            this.mMultiPicAdapter = iVar;
            i iVar2 = null;
            iVar.k0((feedData == null || (cellMedia = feedData.getCellMedia()) == null) ? null : cellMedia.getMediaItems(), new b(feedData));
            RecyclerView recyclerView = this.mMultiPicView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMultiPicView");
                recyclerView = null;
            }
            i iVar3 = this.mMultiPicAdapter;
            if (iVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMultiPicAdapter");
                iVar3 = null;
            }
            recyclerView.setAdapter(iVar3);
            i iVar4 = this.mMultiPicAdapter;
            if (iVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMultiPicAdapter");
            } else {
                iVar2 = iVar4;
            }
            iVar2.notifyDataSetChanged();
        }
    }

    @Override // ne.a
    protected void z(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.mvn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026d_ad_multi_pic_container)");
        this.mMultiPicViewContainer = (FrameLayout) findViewById;
        View findViewById2 = containerView.findViewById(R.id.mvm);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026.qzone_feed_ad_multi_pic)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.mMultiPicView = recyclerView;
        GridLayoutManager gridLayoutManager = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMultiPicView");
            recyclerView = null;
        }
        recyclerView.addItemDecoration(this.mItemDecoration);
        this.mGridLayoutManager = new GridLayoutManager(getActivity(), 3);
        RecyclerView recyclerView2 = this.mMultiPicView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMultiPicView");
            recyclerView2 = null;
        }
        GridLayoutManager gridLayoutManager2 = this.mGridLayoutManager;
        if (gridLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGridLayoutManager");
        } else {
            gridLayoutManager = gridLayoutManager2;
        }
        recyclerView2.setLayoutManager(gridLayoutManager);
    }
}
