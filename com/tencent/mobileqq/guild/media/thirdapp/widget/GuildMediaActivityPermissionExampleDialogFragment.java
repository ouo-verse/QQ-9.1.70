package com.tencent.mobileqq.guild.media.thirdapp.widget;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/widget/GuildMediaActivityPermissionExampleDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/google/android/material/bottomsheet/a;", "dialog", "", "rh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/app/Dialog;", "onCreateDialog", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "onStart", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/widget/FrameLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "mBehavior", "D", "Landroid/view/ViewGroup;", "mRootView", "<init>", "()V", "E", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaActivityPermissionExampleDialogFragment extends BottomSheetDialogFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private BottomSheetBehavior<FrameLayout> mBehavior;

    /* renamed from: D, reason: from kotlin metadata */
    private ViewGroup mRootView;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/widget/GuildMediaActivityPermissionExampleDialogFragment$b", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f229569e;

        b(com.google.android.material.bottomsheet.a aVar) {
            this.f229569e = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewGroup viewGroup = GuildMediaActivityPermissionExampleDialogFragment.this.mRootView;
            BottomSheetBehavior bottomSheetBehavior = null;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                viewGroup = null;
            }
            viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            FrameLayout frameLayout = (FrameLayout) this.f229569e.getDelegate().findViewById(R.id.ugk);
            if (frameLayout != null) {
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                ViewGroup viewGroup2 = GuildMediaActivityPermissionExampleDialogFragment.this.mRootView;
                if (viewGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                    viewGroup2 = null;
                }
                layoutParams.height = viewGroup2.getMeasuredHeight();
                frameLayout.setLayoutParams(layoutParams);
                BottomSheetBehavior bottomSheetBehavior2 = GuildMediaActivityPermissionExampleDialogFragment.this.mBehavior;
                if (bottomSheetBehavior2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBehavior");
                    bottomSheetBehavior2 = null;
                }
                ViewGroup viewGroup3 = GuildMediaActivityPermissionExampleDialogFragment.this.mRootView;
                if (viewGroup3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                    viewGroup3 = null;
                }
                bottomSheetBehavior2.setPeekHeight(viewGroup3.getMeasuredHeight());
                BottomSheetBehavior bottomSheetBehavior3 = GuildMediaActivityPermissionExampleDialogFragment.this.mBehavior;
                if (bottomSheetBehavior3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBehavior");
                    bottomSheetBehavior3 = null;
                }
                int screenHeight = ViewUtils.getScreenHeight();
                ViewGroup viewGroup4 = GuildMediaActivityPermissionExampleDialogFragment.this.mRootView;
                if (viewGroup4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                    viewGroup4 = null;
                }
                bottomSheetBehavior3.setExpandedOffset(screenHeight - viewGroup4.getMeasuredHeight());
                BottomSheetBehavior bottomSheetBehavior4 = GuildMediaActivityPermissionExampleDialogFragment.this.mBehavior;
                if (bottomSheetBehavior4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBehavior");
                    bottomSheetBehavior4 = null;
                }
                ViewGroup viewGroup5 = GuildMediaActivityPermissionExampleDialogFragment.this.mRootView;
                if (viewGroup5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                    viewGroup5 = null;
                }
                bottomSheetBehavior4.setHalfExpandedRatio((viewGroup5.getMeasuredHeight() * 1.0f) / ViewUtils.getScreenHeight());
                BottomSheetBehavior bottomSheetBehavior5 = GuildMediaActivityPermissionExampleDialogFragment.this.mBehavior;
                if (bottomSheetBehavior5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBehavior");
                } else {
                    bottomSheetBehavior = bottomSheetBehavior5;
                }
                bottomSheetBehavior.setState(3);
            }
        }
    }

    private final void rh(com.google.android.material.bottomsheet.a dialog) {
        BottomSheetBehavior<FrameLayout> behavior = dialog.getBehavior();
        Intrinsics.checkNotNullExpressionValue(behavior, "dialog.behavior");
        this.mBehavior = behavior;
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = null;
        if (behavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBehavior");
            behavior = null;
        }
        behavior.setFitToContents(false);
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior2 = this.mBehavior;
        if (bottomSheetBehavior2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBehavior");
        } else {
            bottomSheetBehavior = bottomSheetBehavior2;
        }
        bottomSheetBehavior.setState(6);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
        Window window = aVar.getWindow();
        Intrinsics.checkNotNull(window);
        window.getAttributes().windowAnimations = R.style.a0o;
        rh(aVar);
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.ez7, container, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        this.mRootView = viewGroup;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, viewGroup);
        return viewGroup;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) getDialog();
        Intrinsics.checkNotNull(aVar);
        Window window = aVar.getWindow();
        Intrinsics.checkNotNull(window);
        window.findViewById(R.id.ugk).setBackgroundDrawable(new ColorDrawable(0));
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        }
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new b(aVar));
    }
}
