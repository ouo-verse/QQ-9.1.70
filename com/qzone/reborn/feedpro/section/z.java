package com.qzone.reborn.feedpro.section;

import android.app.Activity;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.reborn.feedpro.widget.QzoneFeedProTextContentView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedDataUtilKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\b\u0010\u0014\u001a\u00020\rH\u0014J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\tH\u0014J\u0012\u0010\u0017\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/qzone/reborn/feedpro/section/z;", "Lne/a;", "", "K", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "commonFeed", "M", "Landroid/view/View;", "v", "I", "view", "", "J", "P", "", tl.h.F, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "containerView", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, "Lcom/qzone/reborn/feedpro/widget/QzoneFeedProTextContentView;", "E", "Lcom/qzone/reborn/feedpro/widget/QzoneFeedProTextContentView;", "mContentSummary", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class z extends ne.a {

    /* renamed from: E, reason: from kotlin metadata */
    private QzoneFeedProTextContentView mContentSummary;

    private final void I(View v3) {
        ho.m f16 = ho.i.f();
        Intrinsics.checkNotNullExpressionValue(f16, "detailPro()");
        ho.m.c(f16, getActivity(), getMFeedData(), v3, 0, 8, null);
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
            qzoneFeedProTextContentView.setTextSize(ViewUtils.dpToPx(16.0f));
            qzoneFeedProTextContentView.setLineSpace(ImmersiveUtils.dpToPx(2.0f));
            qzoneFeedProTextContentView.setPadding(0, 0, 0, 0);
            com.qzone.reborn.feedpro.utils.r rVar = com.qzone.reborn.feedpro.utils.r.f54359a;
            qzoneFeedProTextContentView.setTextColorLink(rVar.b(getActivity()));
            qzoneFeedProTextContentView.setTextColorLinkBackground(rVar.a(getActivity()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List L(z this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return com.qzone.reborn.feedx.widget.b.c(list, com.qzone.reborn.feedpro.utils.r.f54359a.b(this$0.getActivity()));
    }

    private final void M(final CommonFeed commonFeed) {
        QzoneFeedProTextContentView qzoneFeedProTextContentView = this.mContentSummary;
        if (qzoneFeedProTextContentView != null) {
            qzoneFeedProTextContentView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.section.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    z.N(z.this, view);
                }
            });
            qzoneFeedProTextContentView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.qzone.reborn.feedpro.section.x
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean O;
                    O = z.O(z.this, commonFeed, view);
                    return O;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(z this$0, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v3, "v");
        this$0.I(v3);
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean O(z this$0, CommonFeed commonFeed, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(commonFeed, "$commonFeed");
        Intrinsics.checkNotNullParameter(view, "view");
        return this$0.J(commonFeed, view);
    }

    private final void P() {
        QzoneFeedProTextContentView qzoneFeedProTextContentView = this.mContentSummary;
        if (qzoneFeedProTextContentView != null) {
            if (!com.qzone.reborn.feedx.util.x.f55790a.c(n())) {
                qzoneFeedProTextContentView.setMaxLine(6);
                qzoneFeedProTextContentView.setShowMore(true);
                qzoneFeedProTextContentView.setShowMoreTextSize(com.qzone.reborn.util.r.f59560a.e(16));
                qzoneFeedProTextContentView.setShowMoreTextUnClickable(true);
                qzoneFeedProTextContentView.setShowMoreTextColor(com.qzone.reborn.feedpro.utils.r.f54359a.b(getActivity()));
                return;
            }
            qzoneFeedProTextContentView.setShowMore(false);
            qzoneFeedProTextContentView.setMaxLine(-1);
            qzoneFeedProTextContentView.setShowMoreTextSize(0.0f);
            qzoneFeedProTextContentView.setShowMoreTextUnClickable(false);
            qzoneFeedProTextContentView.setShowMoreTextColor(com.qzone.reborn.feedpro.utils.r.f54359a.b(getActivity()));
        }
    }

    private final void Q(CommonFeed feedData) {
        QzoneFeedProTextContentView qzoneFeedProTextContentView = this.mContentSummary;
        if (qzoneFeedProTextContentView != null) {
            qzoneFeedProTextContentView.setPreDecorateListener(new CellTextView.d() { // from class: com.qzone.reborn.feedpro.section.v
                @Override // com.qzone.proxy.feedcomponent.text.CellTextView.d
                public final List a(List list) {
                    List R;
                    R = z.R(z.this, list);
                    return R;
                }
            });
            String str = xd.c.k(feedData) + CommonFeedDataUtilKt.getFeedContentSummary(feedData);
            if (str.length() == 0) {
                qzoneFeedProTextContentView.setVisibility(8);
            } else {
                qzoneFeedProTextContentView.setRichText(str);
                qzoneFeedProTextContentView.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List R(z this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return xd.c.f(list, com.qzone.reborn.feedpro.utils.r.f54359a.b(this$0.getActivity()), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ne.a
    /* renamed from: h */
    public String getTAG() {
        return "QzoneFeedProForwardTextContentSection";
    }

    @Override // ne.a
    protected int q() {
        return R.id.f162982no2;
    }

    @Override // ne.a
    protected boolean u() {
        return true;
    }

    @Override // ne.a
    protected void z(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        QzoneFeedProTextContentView qzoneFeedProTextContentView = (QzoneFeedProTextContentView) containerView.findViewById(R.id.f20999w);
        this.mContentSummary = qzoneFeedProTextContentView;
        if (qzoneFeedProTextContentView != null) {
            com.qzone.reborn.feedpro.utils.r rVar = com.qzone.reborn.feedpro.utils.r.f54359a;
            qzoneFeedProTextContentView.setTextColorLink(rVar.b(getActivity()));
            qzoneFeedProTextContentView.setTextColorLinkBackground(rVar.a(getActivity()));
            qzoneFeedProTextContentView.setPreDecorateListener(new CellTextView.d() { // from class: com.qzone.reborn.feedpro.section.y
                @Override // com.qzone.proxy.feedcomponent.text.CellTextView.d
                public final List a(List list) {
                    List L;
                    L = z.L(z.this, list);
                    return L;
                }
            });
        }
    }

    @Override // ne.a
    protected void x(CommonFeed feedData) {
        if (feedData != null) {
            QzoneFeedProTextContentView qzoneFeedProTextContentView = this.mContentSummary;
            if (qzoneFeedProTextContentView != null) {
                qzoneFeedProTextContentView.setVisibility(8);
            }
            K();
            Q(feedData);
            M(feedData);
            P();
        }
    }
}
