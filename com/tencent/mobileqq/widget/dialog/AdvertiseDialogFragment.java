package com.tencent.mobileqq.widget.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\r\u001a\u00020\u0002H\u0016R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/widget/dialog/AdvertiseDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "", "sh", "Landroid/view/ViewGroup;", "root", "uh", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "rh", "vh", "Lcom/tencent/mobileqq/widget/dialog/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/dialog/b;", "getParams", "()Lcom/tencent/mobileqq/widget/dialog/b;", "params", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "qh", "()Landroid/widget/ImageView;", "wh", "(Landroid/widget/ImageView;)V", "closeBtn", "Landroid/widget/FrameLayout;", "E", "Landroid/widget/FrameLayout;", "contentContainerView", "<init>", "(Lcom/tencent/mobileqq/widget/dialog/b;)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public abstract class AdvertiseDialogFragment extends ReportAndroidXDialogFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final AdvertiseDialogParams params;

    /* renamed from: D, reason: from kotlin metadata */
    protected ImageView closeBtn;

    /* renamed from: E, reason: from kotlin metadata */
    private FrameLayout contentContainerView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvertiseDialogFragment(@NotNull AdvertiseDialogParams params) {
        super(R.layout.edo);
        Intrinsics.checkNotNullParameter(params, "params");
        this.params = params;
    }

    private final void sh() {
        ViewGroup.LayoutParams layoutParams = qh().getLayoutParams();
        layoutParams.width = ViewUtils.dpToPx(this.params.getCloseBtnDp());
        layoutParams.height = ViewUtils.dpToPx(this.params.getCloseBtnDp());
        qh().setImageResource(this.params.getCloseBtnRes());
        qh().setLayoutParams(layoutParams);
        qh().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.widget.dialog.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdvertiseDialogFragment.th(AdvertiseDialogFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void th(AdvertiseDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.vh();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void uh(ViewGroup root) {
        FrameLayout frameLayout = this.contentContainerView;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainerView");
            frameLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = ViewUtils.dpToPx(this.params.getContentMarginCloseBtnDp());
        FrameLayout frameLayout3 = this.contentContainerView;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainerView");
            frameLayout3 = null;
        }
        frameLayout3.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        FrameLayout frameLayout4 = this.contentContainerView;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainerView");
        } else {
            frameLayout2 = frameLayout4;
        }
        frameLayout2.addView(rh(root), layoutParams3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        View view2;
        Window window;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            view2 = window.getDecorView();
        } else {
            view2 = null;
        }
        if (view2 != null) {
            view2.setBackground(new ColorDrawable(0));
        }
        View findViewById = view.findViewById(R.id.close);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.close)");
        wh((ImageView) findViewById);
        sh();
        View findViewById2 = view.findViewById(R.id.b9n);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.contentContainer)");
        this.contentContainerView = (FrameLayout) findViewById2;
        uh((ViewGroup) view);
        setCancelable(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ImageView qh() {
        ImageView imageView = this.closeBtn;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
        return null;
    }

    @NotNull
    public abstract View rh(@NotNull ViewGroup root);

    public void vh() {
        dismiss();
    }

    protected final void wh(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.closeBtn = imageView;
    }
}
