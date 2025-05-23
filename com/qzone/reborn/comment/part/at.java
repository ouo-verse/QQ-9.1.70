package com.qzone.reborn.comment.part;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/qzone/reborn/comment/part/at;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "I9", "L9", "H9", "view", "", "expandSize", "F9", "onInitView", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "d", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "getInitParams", "()Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "initParams", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "e", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "mForwardCommentIcon", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mForwardCommentHint", "Ldd/b;", tl.h.F, "Ldd/b;", "mInputViewModel", "", "i", "Z", "mIsForwardAndComment", "<init>", "(Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class at extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QZoneCommentPanelParams initParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QUICheckBox mForwardCommentIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mForwardCommentHint;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private dd.b mInputViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsForwardAndComment;

    public at(QZoneCommentPanelParams initParams) {
        Intrinsics.checkNotNullParameter(initParams, "initParams");
        this.initParams = initParams;
    }

    private final void F9(final View view, final int expandSize) {
        Object parent = view.getParent();
        final View view2 = parent instanceof View ? (View) parent : null;
        if (view2 == null) {
            return;
        }
        view2.post(new Runnable() { // from class: com.qzone.reborn.comment.part.as
            @Override // java.lang.Runnable
            public final void run() {
                at.G9(view, expandSize, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(View view, int i3, View parent) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(parent, "$parent");
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.left -= i3;
        rect.top -= i3;
        rect.right += i3;
        rect.bottom += i3;
        parent.setTouchDelegate(new TouchDelegate(rect, view));
    }

    private final void H9() {
        this.mIsForwardAndComment = !this.mIsForwardAndComment;
        com.qzone.reborn.util.i.b().l("forward_and_comment", this.mIsForwardAndComment);
        L9();
        QLog.i("QzoneForwardPanelForwardCommPart", 1, "ClickForwardComment:" + this.mIsForwardAndComment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(at this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(at this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void L9() {
        QUICheckBox qUICheckBox = this.mForwardCommentIcon;
        TextView textView = null;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mForwardCommentIcon");
            qUICheckBox = null;
        }
        qUICheckBox.setChecked(this.mIsForwardAndComment);
        TextView textView2 = this.mForwardCommentHint;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mForwardCommentHint");
        } else {
            textView = textView2;
        }
        textView.setContentDescription(com.qzone.util.l.a(this.mIsForwardAndComment ? R.string.f2194166c : R.string.f2194266d));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(dd.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneInputViewModel::class.java)");
        this.mInputViewModel = (dd.b) viewModel;
        I9(rootView);
        L9();
    }

    private final void I9(View rootView) {
        View findViewById = rootView.findViewById(R.id.mrp);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026forward_and_comment_icon)");
        this.mForwardCommentIcon = (QUICheckBox) findViewById;
        View findViewById2 = rootView.findViewById(R.id.mrn);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026orward_and_comment__hint)");
        this.mForwardCommentHint = (TextView) findViewById2;
        QUICheckBox qUICheckBox = this.mForwardCommentIcon;
        TextView textView = null;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mForwardCommentIcon");
            qUICheckBox = null;
        }
        F9(qUICheckBox, ef.d.b(5));
        QUICheckBox qUICheckBox2 = this.mForwardCommentIcon;
        if (qUICheckBox2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mForwardCommentIcon");
            qUICheckBox2 = null;
        }
        qUICheckBox2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.comment.part.aq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                at.J9(at.this, view);
            }
        });
        TextView textView2 = this.mForwardCommentHint;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mForwardCommentHint");
        } else {
            textView = textView2;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.comment.part.ar
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                at.K9(at.this, view);
            }
        });
        this.mIsForwardAndComment = com.qzone.reborn.util.i.b().d("forward_and_comment", true);
    }
}
