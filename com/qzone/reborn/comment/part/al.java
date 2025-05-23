package com.qzone.reborn.comment.part;

import android.text.Editable;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.widget.QZoneCommentEditText;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001fB\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0017R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/qzone/reborn/comment/part/al;", "Lcom/qzone/reborn/base/k;", "Lxc/i;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "C9", "initViewModel", "onInitView", ICustomDataEditor.NUMBER_PARAM_3, "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "d", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "getInitParams", "()Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "initParams", "Lcom/qzone/reborn/comment/widget/QZoneCommentEditText;", "e", "Lcom/qzone/reborn/comment/widget/QZoneCommentEditText;", "mEtInput", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mTextSurplusView", "Ldd/b;", tl.h.F, "Ldd/b;", "mInputViewModel", "<init>", "(Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;)V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class al extends com.qzone.reborn.base.k implements xc.i {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QZoneCommentPanelParams initParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneCommentEditText mEtInput;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mTextSurplusView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private dd.b mInputViewModel;

    public al(QZoneCommentPanelParams initParams) {
        Intrinsics.checkNotNullParameter(initParams, "initParams");
        this.initParams = initParams;
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(dd.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneInputViewModel::class.java)");
        this.mInputViewModel = (dd.b) viewModel;
    }

    @Override // xc.i
    public void n3() {
        int maxInputLength = this.initParams.getMaxInputLength();
        QZoneCommentEditText qZoneCommentEditText = this.mEtInput;
        TextView textView = null;
        if (qZoneCommentEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
            qZoneCommentEditText = null;
        }
        Editable editableText = qZoneCommentEditText.getEditableText();
        int length = editableText != null ? editableText.length() : 0;
        if (maxInputLength == 0 || length < maxInputLength - 10) {
            TextView textView2 = this.mTextSurplusView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTextSurplusView");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
            return;
        }
        if (length <= maxInputLength) {
            TextView textView3 = this.mTextSurplusView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTextSurplusView");
                textView3 = null;
            }
            textView3.setTextColor(getContext().getColor(R.color.f156545dr));
            TextView textView4 = this.mTextSurplusView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTextSurplusView");
                textView4 = null;
            }
            textView4.setText(com.qzone.util.l.a(R.string.m5j) + (maxInputLength - length) + com.qzone.util.l.a(R.string.m5k));
            TextView textView5 = this.mTextSurplusView;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTextSurplusView");
            } else {
                textView = textView5;
            }
            textView.setVisibility(0);
            return;
        }
        TextView textView6 = this.mTextSurplusView;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTextSurplusView");
            textView6 = null;
        }
        textView6.setTextColor(getContext().getColor(R.color.f156546ds));
        TextView textView7 = this.mTextSurplusView;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTextSurplusView");
            textView7 = null;
        }
        textView7.setText(com.qzone.util.l.a(R.string.m5h) + (length - maxInputLength) + com.qzone.util.l.a(R.string.m5l));
        TextView textView8 = this.mTextSurplusView;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTextSurplusView");
        } else {
            textView = textView8;
        }
        textView.setVisibility(0);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        registerIoc(this, xc.i.class);
        C9(rootView);
        initViewModel();
    }

    private final void C9(View rootView) {
        View findViewById = rootView.findViewById(R.id.ms_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026zone_comment_panel_input)");
        this.mEtInput = (QZoneCommentEditText) findViewById;
        View findViewById2 = rootView.findViewById(R.id.msx);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026mment_panel_text_surplus)");
        this.mTextSurplusView = (TextView) findViewById2;
    }
}
