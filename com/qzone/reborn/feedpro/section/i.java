package com.qzone.reborn.feedpro.section;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.business.tianshu.QZoneCommentQuickInputHelper;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\u000b\u001a\u00020\nH\u0014J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0014J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\fH\u0017J\b\u0010\u0014\u001a\u00020\u0003H\u0016R\u0014\u0010\u0017\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/qzone/reborn/feedpro/section/i;", "Lne/a;", "Landroid/view/View$OnClickListener;", "", UserInfo.SEX_FEMALE, "G", "", tl.h.F, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "u", "Landroid/view/View;", "containerView", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", HippyTKDListViewAdapter.X, "v", NodeProps.ON_CLICK, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "E", "Ljava/lang/String;", "TAG", "Landroid/view/View;", "mCommentInputContainer", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "mAvatarView", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "mTvCommentInput", "Lde/a;", "I", "Lde/a;", "mCommentIoc", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class i extends ne.a implements View.OnClickListener {

    /* renamed from: E, reason: from kotlin metadata */
    private final String TAG = "QzoneFeedProCommentInputSection";

    /* renamed from: F, reason: from kotlin metadata */
    private View mCommentInputContainer;

    /* renamed from: G, reason: from kotlin metadata */
    private QZoneUserAvatarView mAvatarView;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView mTvCommentInput;

    /* renamed from: I, reason: from kotlin metadata */
    private de.a mCommentIoc;

    private final void F() {
        fo.b g16 = new fo.b().l(new LinkedHashMap()).i(CommonFeedExtKt.getFeedUniqueKey(getMFeedData())).k(ExposurePolicy.REPORT_NONE).j(EndExposurePolicy.REPORT_NONE).g(ClickPolicy.REPORT_ALL);
        View view = this.mCommentInputContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentInputContainer");
            view = null;
        }
        fo.c.o(view, "em_qz_feed_comment_box", g16);
    }

    private final void G() {
        de.a aVar = this.mCommentIoc;
        if (aVar == null) {
            aVar = (de.a) g(de.a.class);
        }
        this.mCommentIoc = aVar;
        if (aVar != null) {
            aVar.y6(getMFeedData(), getMPosition(), 5, 0);
            aVar.T8(getMFeedData(), null, getMPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(i this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ne.a
    /* renamed from: h, reason: from getter */
    public String getTAG() {
        return this.TAG;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        switch (v3.getId()) {
            case R.id.mrr /* 1745224632 */:
            case R.id.mrs /* 1745224633 */:
                G();
                break;
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // ne.a, vg.c
    public void onDestroy() {
        super.onDestroy();
        QZoneCommentQuickInputHelper.n().r();
    }

    @Override // ne.a
    protected int q() {
        return R.id.nnc;
    }

    @Override // ne.a
    protected boolean u() {
        return false;
    }

    @Override // ne.a
    protected void z(View containerView) {
        QZoneUserAvatarView qZoneUserAvatarView;
        View view;
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.ncf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026(R.id.qzone_user_head_iv)");
        QZoneUserAvatarView qZoneUserAvatarView2 = (QZoneUserAvatarView) findViewById;
        this.mAvatarView = qZoneUserAvatarView2;
        if (qZoneUserAvatarView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatarView");
            qZoneUserAvatarView2 = null;
        }
        qZoneUserAvatarView2.setUser(LoginData.getInstance().getUin());
        QZoneUserAvatarView qZoneUserAvatarView3 = this.mAvatarView;
        if (qZoneUserAvatarView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatarView");
            qZoneUserAvatarView3 = null;
        }
        qZoneUserAvatarView3.setIsShieldJumpToMainPage(true);
        QZoneUserAvatarView qZoneUserAvatarView4 = this.mAvatarView;
        if (qZoneUserAvatarView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatarView");
            qZoneUserAvatarView4 = null;
        }
        qZoneUserAvatarView4.setOnClickHookListener(new QZoneUserAvatarView.a() { // from class: com.qzone.reborn.feedpro.section.h
            @Override // com.qzone.reborn.feedx.widget.QZoneUserAvatarView.a
            public final void a(View view2) {
                i.H(i.this, view2);
            }
        });
        com.qzone.reborn.feedpro.utils.aa aaVar = com.qzone.reborn.feedpro.utils.aa.f54263a;
        QZoneUserAvatarView qZoneUserAvatarView5 = this.mAvatarView;
        if (qZoneUserAvatarView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatarView");
            qZoneUserAvatarView = null;
        } else {
            qZoneUserAvatarView = qZoneUserAvatarView5;
        }
        com.qzone.reborn.feedpro.utils.aa.i(aaVar, qZoneUserAvatarView, getActivity(), 0, true, 2, null);
        View findViewById2 = containerView.findViewById(R.id.mrs);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026d.qzone_comment_input_tv)");
        this.mTvCommentInput = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.mrr);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026_comment_input_container)");
        this.mCommentInputContainer = findViewById3;
        if (findViewById3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentInputContainer");
            findViewById3 = null;
        }
        findViewById3.setOnClickListener(this);
        QZoneUserAvatarView qZoneUserAvatarView6 = this.mAvatarView;
        if (qZoneUserAvatarView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatarView");
            qZoneUserAvatarView6 = null;
        }
        AccessibilityUtil.s(qZoneUserAvatarView6, com.qzone.util.l.a(R.string.gqm));
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        View view2 = this.mCommentInputContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentInputContainer");
            view = null;
        } else {
            view = view2;
        }
        com.qzone.reborn.feedpro.utils.aa.g(aaVar, view, activity, 0, false, 6, null);
    }

    @Override // ne.a
    protected void x(CommonFeed feedData) {
        if (feedData == null) {
            return;
        }
        if (!com.qzone.reborn.feedpro.utils.ap.f54313a.c(feedData)) {
            View mContainerView = getMContainerView();
            if (mContainerView != null) {
                mContainerView.setVisibility(8);
            }
        } else {
            View mContainerView2 = getMContainerView();
            if (mContainerView2 != null) {
                mContainerView2.setVisibility(0);
            }
        }
        TextView textView = null;
        if (CommonFeedExtKt.isFakeFeed(feedData)) {
            TextView textView2 = this.mTvCommentInput;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvCommentInput");
                textView2 = null;
            }
            textView2.setEnabled(false);
            View view = this.mCommentInputContainer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommentInputContainer");
                view = null;
            }
            view.setEnabled(false);
        } else {
            TextView textView3 = this.mTvCommentInput;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvCommentInput");
                textView3 = null;
            }
            textView3.setEnabled(true);
            View view2 = this.mCommentInputContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommentInputContainer");
                view2 = null;
            }
            view2.setEnabled(true);
        }
        TextView textView4 = this.mTvCommentInput;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvCommentInput");
        } else {
            textView = textView4;
        }
        textView.setText(com.qzone.util.l.a(R.string.f21933665));
        F();
    }
}
