package com.qzone.reborn.feedx.presenter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.util.QZoneFrdHotVideo00064Reporter;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.share.QZoneFeedXBottomSheetMenuMore;
import com.qzone.reborn.share.c;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0014J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/qzone/reborn/feedx/presenter/y;", "Lvg/a;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "wording", "", "L", "k", "", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", BdhLogUtil.LogTag.Tag_Conn, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, UserInfo.SEX_FEMALE, "Landroid/view/View;", "rightBtn", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "titleView", "Lgf/h;", "H", "Lgf/h;", JsonRuleKey.OPERATOR, "<init>", "()V", "I", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class y extends vg.a {
    private static final int J = ef.d.b(50);
    private static final int K = ef.d.b(10);

    /* renamed from: F, reason: from kotlin metadata */
    private View rightBtn;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView titleView;

    /* renamed from: H, reason: from kotlin metadata */
    private gf.h operator;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(final y this$0, BusinessFeedData businessFeedData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.operator == null) {
            this$0.operator = (gf.h) this$0.j(gf.h.class);
        }
        QZoneFrdHotVideo00064Reporter.INSTANCE.reportRightMenuClick();
        gf.h hVar = this$0.operator;
        if (hVar != null) {
            hVar.h2(businessFeedData, this$0.f441567m, new QZoneFeedXBottomSheetMenuMore.i() { // from class: com.qzone.reborn.feedx.presenter.x
                @Override // com.qzone.reborn.share.QZoneFeedXBottomSheetMenuMore.i
                public final void a(int i3, BusinessFeedData businessFeedData2, c.a aVar) {
                    y.K(y.this, i3, businessFeedData2, aVar);
                }
            });
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(y this$0, int i3, BusinessFeedData businessFeedData, c.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (businessFeedData == null || aVar == null) {
            return;
        }
        String str = aVar.f59486c;
        if (str == null) {
            str = "";
        }
        this$0.L(businessFeedData, str);
    }

    private final void L(BusinessFeedData feedData, String wording) {
        if (com.qzone.proxy.feedcomponent.model.c.b(feedData) || com.qzone.proxy.feedcomponent.model.c.c(feedData)) {
            QZoneFrdHotVideo00064Reporter.reportNegativeFeedbackClick(wording);
        }
    }

    @Override // vg.a
    protected void C(View containerView) {
        LinearLayout linearLayout = containerView instanceof LinearLayout ? (LinearLayout) containerView : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.getLayoutParams().height = J;
        linearLayout.setGravity(16);
        View findViewById = linearLayout.findViewById(R.id.nek);
        findViewById.setBackgroundResource(com.qzone.adapter.feedcomponent.j.h(719));
        this.rightBtn = findViewById;
        TextView textView = (TextView) linearLayout.findViewById(R.id.nhh);
        textView.setTextColor(textView.getContext().getColor(R.color.qui_common_text_secondary));
        this.titleView = textView;
        View view = this.rightBtn;
        int i3 = K;
        QZoneFeedxViewUtils.a(view, i3, i3, i3, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFeedFrdHotVideoTitlePresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nlp;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    protected void A(final BusinessFeedData feedData) {
        if (feedData == null) {
            return;
        }
        View view = this.rightBtn;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    y.J(y.this, feedData, view2);
                }
            });
        }
        TextView textView = this.titleView;
        if (textView != null) {
            textView.setText(feedData.getRecommHeader().leftTitle);
        }
    }
}
