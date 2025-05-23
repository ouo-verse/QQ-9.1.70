package com.qzone.reborn.feedpro.section;

import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001)B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0014J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u0012\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/qzone/reborn/feedpro/section/m;", "Lne/a;", "Landroidx/lifecycle/Observer;", "Lzd/a;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "", "L", "N", "", tl.h.F, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "u", "Landroid/view/View;", "containerView", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, "Lcf/b;", "event", "r", "commentInfoBean", "I", "Lse/l;", "E", "Lse/l;", "mCommentAdapter", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "mLookMoreCommentView", "G", "Landroid/view/View;", "mContainer", "Landroidx/recyclerview/widget/RecyclerView;", "H", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class m extends ne.a implements Observer<zd.a> {

    /* renamed from: E, reason: from kotlin metadata */
    private se.l mCommentAdapter;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mLookMoreCommentView;

    /* renamed from: G, reason: from kotlin metadata */
    private View mContainer;

    /* renamed from: H, reason: from kotlin metadata */
    private RecyclerView mRecyclerView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/qzone/reborn/feedpro/section/m$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            se.l lVar = m.this.mCommentAdapter;
            se.l lVar2 = null;
            if (lVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommentAdapter");
                lVar = null;
            }
            if (lVar.getNUM_BACKGOURND_ICON() <= 1) {
                super.getItemOffsets(outRect, view, parent, state);
                return;
            }
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            se.l lVar3 = m.this.mCommentAdapter;
            if (lVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommentAdapter");
            } else {
                lVar2 = lVar3;
            }
            if (childAdapterPosition < lVar2.getNUM_BACKGOURND_ICON() - 1) {
                outRect.bottom = ImmersiveUtils.dpToPx(2.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(m this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ho.m f16 = ho.i.f();
        Intrinsics.checkNotNullExpressionValue(f16, "detailPro()");
        ho.m.c(f16, this$0.getActivity(), this$0.getMFeedData(), view, 0, 8, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean K(m this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() != 1 || com.qzone.reborn.feedx.util.x.f55790a.c(this$0.n())) {
            return false;
        }
        ho.m f16 = ho.i.f();
        Intrinsics.checkNotNullExpressionValue(f16, "detailPro()");
        Activity activity = this$0.getActivity();
        CommonFeed mFeedData = this$0.getMFeedData();
        RecyclerView recyclerView = this$0.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        ho.m.c(f16, activity, mFeedData, recyclerView, 0, 8, null);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11, types: [android.view.View] */
    private final void L(CommonFeed feedData) {
        se.l lVar = this.mCommentAdapter;
        RecyclerView recyclerView = null;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentAdapter");
            lVar = null;
        }
        lVar.j0(feedData, getMPosition());
        se.l lVar2 = this.mCommentAdapter;
        if (lVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentAdapter");
            lVar2 = null;
        }
        if (lVar2.getNUM_BACKGOURND_ICON() == 0) {
            se.l lVar3 = this.mCommentAdapter;
            if (lVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommentAdapter");
                lVar3 = null;
            }
            if (!lVar3.k0()) {
                ?? r56 = this.mContainer;
                if (r56 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                } else {
                    recyclerView = r56;
                }
                recyclerView.setVisibility(8);
                return;
            }
        }
        View view = this.mContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            view = null;
        }
        view.setVisibility(0);
        com.qzone.reborn.feedx.util.ag agVar = com.qzone.reborn.feedx.util.ag.f55738a;
        Runnable runnable = new Runnable() { // from class: com.qzone.reborn.feedpro.section.j
            @Override // java.lang.Runnable
            public final void run() {
                m.M(m.this);
            }
        };
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        agVar.b(5, runnable, recyclerView);
        N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(m this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        se.l lVar = this$0.mCommentAdapter;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentAdapter");
            lVar = null;
        }
        lVar.notifyDataSetChanged();
    }

    private final void N() {
        se.l lVar = this.mCommentAdapter;
        TextView textView = null;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentAdapter");
            lVar = null;
        }
        if (lVar.k0()) {
            TextView textView2 = this.mLookMoreCommentView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLookMoreCommentView");
                textView2 = null;
            }
            textView2.setVisibility(0);
            TextView textView3 = this.mLookMoreCommentView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLookMoreCommentView");
            } else {
                textView = textView3;
            }
            textView.setText(com.qzone.util.l.a(R.string.jmy));
            return;
        }
        TextView textView4 = this.mLookMoreCommentView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLookMoreCommentView");
        } else {
            textView = textView4;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ne.a
    /* renamed from: h */
    public String getTAG() {
        return "QzoneFeedProCommentSection";
    }

    @Override // ne.a
    protected int q() {
        return R.id.nnz;
    }

    @Override // ne.a
    public void r(cf.b event) {
        super.r(event);
        if (event instanceof be.a) {
            View view = null;
            if (((be.a) event).getIsVisible()) {
                View view2 = this.mContainer;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                    view2 = null;
                }
                View view3 = this.mContainer;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                    view3 = null;
                }
                int paddingLeft = view3.getPaddingLeft();
                int dpToPx = ImmersiveUtils.dpToPx(2.0f);
                View view4 = this.mContainer;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                    view4 = null;
                }
                int paddingRight = view4.getPaddingRight();
                View view5 = this.mContainer;
                if (view5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                } else {
                    view = view5;
                }
                view2.setPadding(paddingLeft, dpToPx, paddingRight, view.getPaddingBottom());
                return;
            }
            View view6 = this.mContainer;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                view6 = null;
            }
            View view7 = this.mContainer;
            if (view7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                view7 = null;
            }
            int paddingLeft2 = view7.getPaddingLeft();
            int dpToPx2 = ImmersiveUtils.dpToPx(6.0f);
            View view8 = this.mContainer;
            if (view8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                view8 = null;
            }
            int paddingRight2 = view8.getPaddingRight();
            View view9 = this.mContainer;
            if (view9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            } else {
                view = view9;
            }
            view6.setPadding(paddingLeft2, dpToPx2, paddingRight2, view.getPaddingBottom());
        }
    }

    @Override // ne.a
    protected boolean u() {
        return false;
    }

    @Override // ne.a
    protected void x(CommonFeed feedData) {
        L(feedData);
        if (TextUtils.isEmpty(CommonFeedExtKt.getFeedUniqueKey(feedData))) {
            return;
        }
        QLog.d("QzoneFeedProCommentSection", 1, "observeCommentData, dataId: " + CommonFeedExtKt.getFeedUniqueKey(feedData));
        int i3 = RFWLog.DEV;
        Object[] objArr = new Object[1];
        objArr[0] = "observe comment, feedsKey: " + CommonFeedExtKt.getFeedUniqueKey(feedData) + ", comment: " + (feedData != null ? feedData.getCellComment() : null) + ", section: " + this;
        RFWLog.d("QzoneFeedProCommentSection", i3, objArr);
        ze.a.a().observerGlobalState(new zd.a(f(), CommonFeedExtKt.getFeedUniqueKey(feedData), feedData != null ? feedData.getCellComment() : null), this);
    }

    @Override // ne.a
    protected void z(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.mw_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026ed_pro_comment_container)");
        this.mContainer = findViewById;
        View findViewById2 = containerView.findViewById(R.id.mwa);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026ne_feed_pro_comment_list)");
        this.mRecyclerView = (RecyclerView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.n9n);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026pro_look_more_comment_tv)");
        this.mLookMoreCommentView = (TextView) findViewById3;
        RecyclerView recyclerView = this.mRecyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(containerView.getContext()));
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setNestedScrollingEnabled(false);
        RecyclerView recyclerView4 = this.mRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView4 = null;
        }
        recyclerView4.setItemAnimator(null);
        this.mCommentAdapter = new se.l(n());
        RecyclerView recyclerView5 = this.mRecyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView5 = null;
        }
        se.l lVar = this.mCommentAdapter;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentAdapter");
            lVar = null;
        }
        recyclerView5.setAdapter(lVar);
        TextView textView = this.mLookMoreCommentView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLookMoreCommentView");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.section.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m.J(m.this, view);
            }
        });
        RecyclerView recyclerView6 = this.mRecyclerView;
        if (recyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView6 = null;
        }
        recyclerView6.setOnTouchListener(new View.OnTouchListener() { // from class: com.qzone.reborn.feedpro.section.l
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean K;
                K = m.K(m.this, view, motionEvent);
                return K;
            }
        });
        RecyclerView recyclerView7 = this.mRecyclerView;
        if (recyclerView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            recyclerView2 = recyclerView7;
        }
        recyclerView2.addItemDecoration(new b());
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void onChanged(zd.a commentInfoBean) {
        if (commentInfoBean == null || !TextUtils.equals(commentInfoBean.getFeedUniKey(), CommonFeedExtKt.getFeedUniqueKey(getMFeedData()))) {
            return;
        }
        RFWLog.d(getTAG(), RFWLog.CLR, "comment onChanged, feedsKey: " + commentInfoBean.getFeedUniKey() + ", comment: " + commentInfoBean.getCellComment() + ", section: " + this);
        CommonFeed mFeedData = getMFeedData();
        if (mFeedData != null) {
            mFeedData.setCellComment(commentInfoBean.getCellComment());
        }
        L(getMFeedData());
    }
}
