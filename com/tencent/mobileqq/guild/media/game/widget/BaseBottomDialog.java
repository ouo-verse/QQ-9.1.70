package com.tencent.mobileqq.guild.media.game.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u000fH&R\"\u0010\u0017\u001a\u00020\f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/media/game/widget/BaseBottomDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "sh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/app/Dialog;", "onCreateDialog", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "onStart", "", "qh", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "vh", "(Landroid/view/View;)V", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/google/android/material/bottomsheet/a;", "D", "Lcom/google/android/material/bottomsheet/a;", "ph", "()Lcom/google/android/material/bottomsheet/a;", "th", "(Lcom/google/android/material/bottomsheet/a;)V", "baseDialog", "Lbt1/h;", "E", "Lbt1/h;", "rh", "()Lbt1/h;", "uh", "(Lbt1/h;)V", "roomViewModel", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class BaseBottomDialog extends BottomSheetDialogFragment {

    /* renamed from: C, reason: from kotlin metadata */
    public View rootView;

    /* renamed from: D, reason: from kotlin metadata */
    public com.google.android.material.bottomsheet.a baseDialog;

    /* renamed from: E, reason: from kotlin metadata */
    public bt1.h roomViewModel;

    private final void sh() {
        BottomSheetBehavior<FrameLayout> behavior = ph().getBehavior();
        behavior.setPeekHeight(0);
        behavior.setState(3);
    }

    @NotNull
    public final View getRootView() {
        View view = this.rootView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        return null;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
        Window window = aVar.getWindow();
        Intrinsics.checkNotNull(window);
        window.getAttributes().windowAnimations = R.style.a0o;
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Dialog dialog = getDialog();
        Intrinsics.checkNotNull(dialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        th((com.google.android.material.bottomsheet.a) dialog);
        View inflate = inflater.inflate(qh(), container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(getLayoutID(), container, false)");
        vh(inflate);
        Window window = ph().getWindow();
        Intrinsics.checkNotNull(window);
        window.clearFlags(2);
        sh();
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.lifecycle.ViewModelStoreOwner");
        ViewModel viewModel = new ViewModelProvider(activity, new bt1.a(1L)).get(bt1.h.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(\n     \u2026oomViewModel::class.java]");
        uh((bt1.h) viewModel);
        View rootView = getRootView();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, rootView);
        return rootView;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Object parent = getRootView().getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        ((View) parent).setBackgroundColor(0);
    }

    @NotNull
    public final com.google.android.material.bottomsheet.a ph() {
        com.google.android.material.bottomsheet.a aVar = this.baseDialog;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("baseDialog");
        return null;
    }

    public abstract int qh();

    @NotNull
    public final bt1.h rh() {
        bt1.h hVar = this.roomViewModel;
        if (hVar != null) {
            return hVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
        return null;
    }

    public final void th(@NotNull com.google.android.material.bottomsheet.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.baseDialog = aVar;
    }

    public final void uh(@NotNull bt1.h hVar) {
        Intrinsics.checkNotNullParameter(hVar, "<set-?>");
        this.roomViewModel = hVar;
    }

    public final void vh(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.rootView = view;
    }
}
