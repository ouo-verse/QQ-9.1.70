package com.qzone.reborn.comment.part;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.widget.QZoneCommentEditText;
import com.qzone.reborn.comment.widget.QZoneSharePanelView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001/B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/qzone/reborn/comment/part/ak;", "Lcom/qzone/reborn/base/k;", "Lxc/e;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "E9", "G9", "D9", "onInitView", "view", "c3", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "d", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "getInitParams", "()Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "initParams", "Lcom/qzone/reborn/comment/widget/QZoneCommentEditText;", "e", "Lcom/qzone/reborn/comment/widget/QZoneCommentEditText;", "mEtInput", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", "mPanelContainer", tl.h.F, "mInputContainer", "Lcom/qzone/reborn/comment/widget/QZoneSharePanelView;", "i", "Lcom/qzone/reborn/comment/widget/QZoneSharePanelView;", "mSharePanelView", "Ldd/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ldd/b;", "mInputViewModel", "Ldd/a;", BdhLogUtil.LogTag.Tag_Conn, "Ldd/a;", "mDataViewModel", "", "D", "Z", "mHasInputFocus", "<init>", "(Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;)V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ak extends com.qzone.reborn.base.k implements xc.e {

    /* renamed from: C, reason: from kotlin metadata */
    private dd.a mDataViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mHasInputFocus;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QZoneCommentPanelParams initParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneCommentEditText mEtInput;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mPanelContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mInputContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneSharePanelView mSharePanelView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private dd.b mInputViewModel;

    public ak(QZoneCommentPanelParams initParams) {
        Intrinsics.checkNotNullParameter(initParams, "initParams");
        this.initParams = initParams;
    }

    private final void D9() {
        ViewGroup viewGroup = this.mPanelContainer;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanelContainer");
            viewGroup = null;
        }
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        QZoneSharePanelView qZoneSharePanelView = this.mSharePanelView;
        if (qZoneSharePanelView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSharePanelView");
            qZoneSharePanelView = null;
        }
        layoutParams.height = qZoneSharePanelView.q0();
        ViewGroup viewGroup3 = this.mPanelContainer;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanelContainer");
        } else {
            viewGroup2 = viewGroup3;
        }
        viewGroup2.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(ak this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16 && this$0.mHasInputFocus) {
            cd.n.INSTANCE.a(this$0.getActivity(), true);
        }
    }

    private final void G9() {
        dd.a aVar = this.mDataViewModel;
        QZoneSharePanelView qZoneSharePanelView = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDataViewModel");
            aVar = null;
        }
        if (aVar.j().getValue() == null) {
            return;
        }
        cd.n.INSTANCE.a(getActivity(), false);
        QZoneCommentEditText qZoneCommentEditText = this.mEtInput;
        if (qZoneCommentEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
            qZoneCommentEditText = null;
        }
        qZoneCommentEditText.clearFocus();
        ViewGroup viewGroup = this.mPanelContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanelContainer");
            viewGroup = null;
        }
        viewGroup.setVisibility(0);
        QZoneSharePanelView qZoneSharePanelView2 = this.mSharePanelView;
        if (qZoneSharePanelView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSharePanelView");
            qZoneSharePanelView2 = null;
        }
        qZoneSharePanelView2.setVisibility(0);
        QZoneSharePanelView qZoneSharePanelView3 = this.mSharePanelView;
        if (qZoneSharePanelView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSharePanelView");
            qZoneSharePanelView3 = null;
        }
        dd.a aVar2 = this.mDataViewModel;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDataViewModel");
            aVar2 = null;
        }
        qZoneSharePanelView3.setData(aVar2.j().getValue());
        dd.a aVar3 = this.mDataViewModel;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDataViewModel");
            aVar3 = null;
        }
        boolean isNativeAd = QZoneAdFeedDataExtKt.isNativeAd(aVar3.j().getValue());
        ViewGroup viewGroup2 = this.mInputContainer;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputContainer");
            viewGroup2 = null;
        }
        viewGroup2.setVisibility(isNativeAd ? 8 : 0);
        QZoneSharePanelView qZoneSharePanelView4 = this.mSharePanelView;
        if (qZoneSharePanelView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSharePanelView");
        } else {
            qZoneSharePanelView = qZoneSharePanelView4;
        }
        qZoneSharePanelView.setShareButtonEnable(isNativeAd);
        D9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        registerIoc(this, xc.e.class);
        ViewModel viewModel = getViewModel(dd.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneInputViewModel::class.java)");
        this.mInputViewModel = (dd.b) viewModel;
        ViewModel viewModel2 = getViewModel(dd.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QZoneInputDataViewModel::class.java)");
        this.mDataViewModel = (dd.a) viewModel2;
        E9(rootView);
        G9();
    }

    @Override // xc.e
    public void c3(View view) {
        this.mHasInputFocus = true;
    }

    private final void E9(View rootView) {
        View findViewById = rootView.findViewById(R.id.ms_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026zone_comment_panel_input)");
        this.mEtInput = (QZoneCommentEditText) findViewById;
        View findViewById2 = rootView.findViewById(R.id.msw);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026comment_panel_share_view)");
        this.mSharePanelView = (QZoneSharePanelView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f162813ms0);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026_comment_panel_container)");
        this.mPanelContainer = (ViewGroup) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.msb);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026nt_panel_input_container)");
        this.mInputContainer = (ViewGroup) findViewById4;
        QZoneCommentEditText qZoneCommentEditText = this.mEtInput;
        if (qZoneCommentEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
            qZoneCommentEditText = null;
        }
        qZoneCommentEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.qzone.reborn.comment.part.aj
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                ak.F9(ak.this, view, z16);
            }
        });
    }
}
