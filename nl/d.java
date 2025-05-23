package nl;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.reborn.util.r;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0014J(\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010!R\u0016\u0010$\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010\u0018R\u0016\u0010&\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010\u001cR\u0016\u0010'\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010)\u00a8\u0006-"}, d2 = {"Lnl/d;", "Lnl/b;", "Lkl/a;", "data", "", "G", "H", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "", "position", "", "", "payload", "D", "", tl.h.F, "Ljava/lang/String;", "TAG", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "i", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "mMessageTv", "Landroid/widget/LinearLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/LinearLayout;", "mReplyBtn", BdhLogUtil.LogTag.Tag_Conn, "mReplyText", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "mOperatorLayout", "E", "mContextMessageTv", UserInfo.SEX_FEMALE, "mContextLayout", "mContentRoot", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "mContentPictureGrid", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends b {

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneRichTextView mReplyText;

    /* renamed from: D, reason: from kotlin metadata */
    private ViewGroup mOperatorLayout;

    /* renamed from: E, reason: from kotlin metadata */
    private QZoneRichTextView mContextMessageTv;

    /* renamed from: F, reason: from kotlin metadata */
    private LinearLayout mContextLayout;

    /* renamed from: G, reason: from kotlin metadata */
    private LinearLayout mContentRoot;

    /* renamed from: H, reason: from kotlin metadata */
    private RecyclerView mContentPictureGrid;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZoneNoticeCommentContentSection";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneRichTextView mMessageTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mReplyBtn;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(d this$0, kl.a data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.z(data);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void G(kl.a data) {
        QZoneRichTextView qZoneRichTextView = null;
        String d16 = ll.a.d(ll.a.f414984a, data.getCom.tenpay.sdk.util.UinConfigManager.KEY_ADS java.lang.String().noticeMessage, null, 2, null);
        QZoneRichTextView qZoneRichTextView2 = this.mMessageTv;
        if (qZoneRichTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMessageTv");
        } else {
            qZoneRichTextView = qZoneRichTextView2;
        }
        qZoneRichTextView.setRichText(d16);
        QLog.d(this.TAG, 1, "updateContent pos=" + this.mPosition + ", content=" + d16 + ", this=" + this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void onBindData(final kl.a data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        G(data);
        H(data);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: nl.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.F(d.this, data, view);
            }
        };
        LinearLayout linearLayout = this.mReplyBtn;
        QZoneRichTextView qZoneRichTextView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReplyBtn");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(onClickListener);
        QZoneRichTextView qZoneRichTextView2 = this.mReplyText;
        if (qZoneRichTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReplyText");
            qZoneRichTextView2 = null;
        }
        qZoneRichTextView2.setOnClickListener(onClickListener);
        QZoneRichTextView qZoneRichTextView3 = this.mMessageTv;
        if (qZoneRichTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMessageTv");
            qZoneRichTextView3 = null;
        }
        qZoneRichTextView3.setOnClickListener(getClickSpaceListener());
        ViewGroup viewGroup = this.mOperatorLayout;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOperatorLayout");
            viewGroup = null;
        }
        viewGroup.setOnClickListener(onClickListener);
        LinearLayout linearLayout2 = this.mContentRoot;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentRoot");
            linearLayout2 = null;
        }
        linearLayout2.setOnClickListener(onClickListener);
        LinearLayout linearLayout3 = this.mReplyBtn;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReplyBtn");
            linearLayout3 = null;
        }
        x(linearLayout3, "em_qz_reply_button");
        QZoneRichTextView qZoneRichTextView4 = this.mReplyText;
        if (qZoneRichTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReplyText");
            qZoneRichTextView4 = null;
        }
        x(qZoneRichTextView4, "em_qz_reply_button");
        QZoneRichTextView qZoneRichTextView5 = this.mMessageTv;
        if (qZoneRichTextView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMessageTv");
        } else {
            qZoneRichTextView = qZoneRichTextView5;
        }
        x(qZoneRichTextView, "em_qz_interactive_description_copy");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.n7r);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026(R.id.qzone_message_text)");
        this.mMessageTv = (QZoneRichTextView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.mim);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026ice_content_picture_grid)");
        this.mContentPictureGrid = (RecyclerView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.n7i);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026sage_notice_content_root)");
        this.mContentRoot = (LinearLayout) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.n7_);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026one_message_context_text)");
        this.mContextMessageTv = (QZoneRichTextView) findViewById4;
        View findViewById5 = containerView.findViewById(R.id.n78);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026e_message_context_layout)");
        this.mContextLayout = (LinearLayout) findViewById5;
        View findViewById6 = containerView.findViewById(R.id.mrf);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewBy\u2026tton_list_content_layout)");
        this.mOperatorLayout = (ViewGroup) findViewById6;
        View findViewById7 = containerView.findViewById(R.id.mrh);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "containerView.findViewBy\u2026zone_button_reply_layout)");
        this.mReplyBtn = (LinearLayout) findViewById7;
        View findViewById8 = containerView.findViewById(R.id.mri);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "containerView.findViewBy\u2026.qzone_button_reply_text)");
        this.mReplyText = (QZoneRichTextView) findViewById8;
        r rVar = r.f59560a;
        LinearLayout linearLayout = this.mReplyBtn;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReplyBtn");
            linearLayout = null;
        }
        LinearLayout linearLayout3 = this.mReplyBtn;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReplyBtn");
        } else {
            linearLayout2 = linearLayout3;
        }
        rVar.b(linearLayout, Utils.n(10.0f, linearLayout2.getResources()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.n8o, R.id.n8n};
    }

    private final void H(kl.a data) {
    }
}
