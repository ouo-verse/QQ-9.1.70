package com.qzone.reborn.comment.part;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.LocalMultiProcConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/qzone/reborn/comment/part/m;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "E9", "G9", "D9", "onInitView", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "d", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "getInitParams", "()Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "initParams", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "mForwardCommentArea", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "f", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "mForwardCommentIcon", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "mForwardCommentHint", "Ldd/b;", "i", "Ldd/b;", "mInputViewModel", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "mIsForwardAndComment", "<init>", "(Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class m extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QZoneCommentPanelParams initParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mForwardCommentArea;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QUICheckBox mForwardCommentIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mForwardCommentHint;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private dd.b mInputViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsForwardAndComment;

    public m(QZoneCommentPanelParams initParams) {
        Intrinsics.checkNotNullParameter(initParams, "initParams");
        this.initParams = initParams;
    }

    private final void D9() {
        boolean z16 = !this.mIsForwardAndComment;
        this.mIsForwardAndComment = z16;
        LocalMultiProcConfig.putBool("forward_and_comment", z16);
        G9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(m this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void G9() {
        LinearLayout linearLayout = this.mForwardCommentArea;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mForwardCommentArea");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        QUICheckBox qUICheckBox = this.mForwardCommentIcon;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mForwardCommentIcon");
            qUICheckBox = null;
        }
        qUICheckBox.setChecked(this.mIsForwardAndComment);
        LinearLayout linearLayout3 = this.mForwardCommentArea;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mForwardCommentArea");
        } else {
            linearLayout2 = linearLayout3;
        }
        linearLayout2.setContentDescription(com.qzone.util.l.a(this.mIsForwardAndComment ? R.string.f2194166c : R.string.f2194266d));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(dd.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneInputViewModel::class.java)");
        this.mInputViewModel = (dd.b) viewModel;
        E9(rootView);
        G9();
    }

    private final void E9(View rootView) {
        View findViewById = rootView.findViewById(R.id.mro);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026forward_and_comment_area)");
        this.mForwardCommentArea = (LinearLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.mrp);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026forward_and_comment_icon)");
        this.mForwardCommentIcon = (QUICheckBox) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.mrn);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026orward_and_comment__hint)");
        this.mForwardCommentHint = (TextView) findViewById3;
        LinearLayout linearLayout = this.mForwardCommentArea;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mForwardCommentArea");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.comment.part.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m.F9(m.this, view);
            }
        });
        this.mIsForwardAndComment = LocalMultiProcConfig.getBool("forward_and_comment", true);
    }
}
