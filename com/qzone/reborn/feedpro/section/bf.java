package com.qzone.reborn.feedpro.section;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import com.qzone.proxy.feedcomponent.text.TopicTextCell;
import com.qzone.proxy.feedcomponent.text.UserNameCell;
import com.qzone.reborn.feedpro.widget.QzoneFeedProTextContentView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedDataUtilKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u001c\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001a\u0010\u0011\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\b\u0010\u0017\u001a\u00020\u000fH\u0014J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u000bH\u0014J\u0012\u0010\u001a\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/qzone/reborn/feedpro/section/bf;", "Lne/a;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "", "summaryText", "", "P", "L", "Lcom/qzone/proxy/feedcomponent/text/TextCell;", "cell", "Landroid/view/View;", "view", "I", "M", "", "J", "H", "K", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, tl.h.F, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "containerView", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, "Lcom/qzone/reborn/feedpro/widget/QzoneFeedProTextContentView;", "E", "Lcom/qzone/reborn/feedpro/widget/QzoneFeedProTextContentView;", "mContentSummary", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class bf extends ne.a {

    /* renamed from: E, reason: from kotlin metadata */
    private QzoneFeedProTextContentView mContentSummary;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/qzone/reborn/feedpro/section/bf$b", "Lcom/qzone/proxy/feedcomponent/text/TextCellLayout$OnCellClickListener;", "Lcom/qzone/proxy/feedcomponent/text/TextCell;", "cell", "Landroid/view/View;", "view", "", NodeProps.ON_CLICK, "Lcom/qzone/proxy/feedcomponent/text/CellTextView$OnTextOperater;", JsonRuleKey.OPERATOR, "", NodeProps.ON_LONG_CLICK, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements TextCellLayout.OnCellClickListener {
        b() {
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public void onClick(TextCell cell, View view) {
            Intrinsics.checkNotNullParameter(cell, "cell");
            Intrinsics.checkNotNullParameter(view, "view");
            bf.this.I(cell, view);
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public boolean onLongClick(View view, CellTextView.OnTextOperater operator) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(operator, "operator");
            return false;
        }
    }

    private final void H(CommonFeed feedData, View view) {
        if (com.qzone.reborn.feedx.util.x.f55790a.c(n())) {
            return;
        }
        ho.m f16 = ho.i.f();
        Intrinsics.checkNotNullExpressionValue(f16, "detailPro()");
        ho.m.c(f16, getActivity(), feedData, view, 0, 8, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("feedid", CommonFeedExtKt.getFeedUniqueKey(getMFeedData()));
        fo.c.b("dt_clck", this.mContentSummary, "em_qz_feed_text", new fo.b().l(linkedHashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(TextCell cell, View view) {
        if (cell instanceof UserNameCell) {
            UserNameCell userNameCell = (UserNameCell) cell;
            if (userNameCell.getUin() != null) {
                Long uin = userNameCell.getUin();
                Intrinsics.checkNotNullExpressionValue(uin, "cell.getUin()");
                if (uin.longValue() > 0) {
                    Activity activity = getActivity();
                    Long uin2 = userNameCell.getUin();
                    Intrinsics.checkNotNullExpressionValue(uin2, "cell.getUin()");
                    ho.h.b(activity, uin2.longValue());
                    return;
                }
            }
        }
        if (cell instanceof TopicTextCell) {
            TopicTextCell topicTextCell = (TopicTextCell) cell;
            if (!TextUtils.isEmpty(topicTextCell.text) && !TextUtils.isEmpty(topicTextCell.getUrl())) {
                QLog.i("QzoneFeedProTextContentSection", 2, "topic url is " + topicTextCell.getUrl());
                ho.i.q(getActivity(), topicTextCell.getUrl());
                return;
            }
        }
        if (cell == null || TextUtils.isEmpty(cell.getUrl()) || view == null) {
            return;
        }
        yo.d.d(cell.getUrl(), view.getContext(), null);
    }

    private final boolean J(CommonFeed feedData, View view) {
        Activity c16 = com.qzone.reborn.feedx.widget.i.c(view);
        if (c16 == null) {
            QLog.e(getTAG(), 1, "onLongClick  activity == null");
            return false;
        }
        return xd.c.A(feedData, view, feedData, c16);
    }

    private final void K() {
        QzoneFeedProTextContentView qzoneFeedProTextContentView = this.mContentSummary;
        if (qzoneFeedProTextContentView != null) {
            Activity activity = getActivity();
            Intrinsics.checkNotNull(activity);
            qzoneFeedProTextContentView.setTextColor(activity.getResources().getColor(R.color.qui_common_text_primary));
            qzoneFeedProTextContentView.setTextSize(com.qzone.reborn.util.r.f59560a.e(18));
            qzoneFeedProTextContentView.setPadding(0, 0, 0, 0);
            com.qzone.reborn.feedpro.utils.r rVar = com.qzone.reborn.feedpro.utils.r.f54359a;
            qzoneFeedProTextContentView.setTextColorLink(rVar.b(getActivity()));
            qzoneFeedProTextContentView.setTextColorLinkBackground(rVar.a(getActivity()));
        }
    }

    private final void L() {
        QzoneFeedProTextContentView qzoneFeedProTextContentView = this.mContentSummary;
        Intrinsics.checkNotNull(qzoneFeedProTextContentView);
        qzoneFeedProTextContentView.setOnCellClickListener(new b());
    }

    private final void M(final CommonFeed feedData) {
        QzoneFeedProTextContentView qzoneFeedProTextContentView = this.mContentSummary;
        Intrinsics.checkNotNull(qzoneFeedProTextContentView);
        qzoneFeedProTextContentView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.section.bd
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bf.N(bf.this, feedData, view);
            }
        });
        QzoneFeedProTextContentView qzoneFeedProTextContentView2 = this.mContentSummary;
        Intrinsics.checkNotNull(qzoneFeedProTextContentView2);
        qzoneFeedProTextContentView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.qzone.reborn.feedpro.section.be
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean O;
                O = bf.O(bf.this, feedData, view);
                return O;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(bf this$0, CommonFeed commonFeed, View v3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v3, "v");
        this$0.H(commonFeed, v3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean O(bf this$0, CommonFeed commonFeed, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        return this$0.J(commonFeed, view);
    }

    private final void P(CommonFeed feedData, String summaryText) {
        QzoneFeedProTextContentView qzoneFeedProTextContentView = this.mContentSummary;
        Intrinsics.checkNotNull(qzoneFeedProTextContentView);
        qzoneFeedProTextContentView.setRichText(summaryText);
        QzoneFeedProTextContentView qzoneFeedProTextContentView2 = this.mContentSummary;
        Intrinsics.checkNotNull(qzoneFeedProTextContentView2);
        qzoneFeedProTextContentView2.setLineSpace(ImmersiveUtils.dpToPx(1.5f));
        QzoneFeedProTextContentView qzoneFeedProTextContentView3 = this.mContentSummary;
        Intrinsics.checkNotNull(qzoneFeedProTextContentView3);
        qzoneFeedProTextContentView3.setVisibility(0);
        QzoneFeedProTextContentView qzoneFeedProTextContentView4 = this.mContentSummary;
        Intrinsics.checkNotNull(qzoneFeedProTextContentView4);
        ViewGroup.LayoutParams layoutParams = qzoneFeedProTextContentView4.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = -ImmersiveUtils.dpToPx(1.5f);
        layoutParams2.bottomMargin = -ImmersiveUtils.dpToPx(1.5f);
        M(feedData);
        L();
        QLog.d("QzoneFeedProTextContentSection", 1, "setupContentSummary   | feedUniqueKey = " + CommonFeedExtKt.getFeedUniqueKey(feedData) + " | pos = " + getMPosition() + " | summaryText = " + summaryText + " | hashCode = " + hashCode());
    }

    private final void Q() {
        QzoneFeedProTextContentView qzoneFeedProTextContentView = this.mContentSummary;
        if (qzoneFeedProTextContentView != null) {
            if (!com.qzone.reborn.feedx.util.x.f55790a.c(n())) {
                qzoneFeedProTextContentView.setMaxLine(6);
                qzoneFeedProTextContentView.setShowMore(true);
                qzoneFeedProTextContentView.setShowMoreTextSize(com.qzone.reborn.util.r.f59560a.e(18));
                qzoneFeedProTextContentView.setShowMoreTextUnClickable(true);
                qzoneFeedProTextContentView.setShowMoreTextColor(com.qzone.reborn.feedpro.utils.r.f54359a.b(getActivity()));
                return;
            }
            qzoneFeedProTextContentView.setShowMore(false);
            qzoneFeedProTextContentView.setMaxLine(-1);
            qzoneFeedProTextContentView.setShowMoreTextSize(0.0f);
            qzoneFeedProTextContentView.setShowMoreTextUnClickable(false);
            qzoneFeedProTextContentView.setShowMoreTextColor(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ne.a
    /* renamed from: h */
    public String getTAG() {
        return "QzoneFeedProTextContentSection";
    }

    @Override // ne.a
    protected int q() {
        return R.id.nob;
    }

    @Override // ne.a
    protected boolean u() {
        return false;
    }

    @Override // ne.a
    protected void z(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.mContentSummary = (QzoneFeedProTextContentView) containerView.findViewById(R.id.mxb);
    }

    @Override // ne.a
    protected void x(CommonFeed feedData) {
        if (feedData != null) {
            View mContainerView = getMContainerView();
            if (mContainerView != null) {
                mContainerView.setVisibility(8);
            }
            K();
            Q();
            String feedContentSummary = CommonFeedDataUtilKt.getFeedContentSummary(feedData);
            if (TextUtils.isEmpty(feedContentSummary)) {
                return;
            }
            P(feedData, feedContentSummary);
            View mContainerView2 = getMContainerView();
            if (mContainerView2 == null) {
                return;
            }
            mContainerView2.setVisibility(0);
        }
    }
}
