package com.tencent.mobileqq.qwallet.pet.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J&\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\b\u0010\u0015\u001a\u00020\u0013H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/fragment/HalfKuiklyEntryFragment;", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "Landroid/os/Bundle;", "arguments", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "qh", "sh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, Constants.FILE_INSTANCE_STATE, "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/mobileqq/base/FragmentAnimation;", "getFragmentAnimation", "", "isStatusBarImmersive", "isAllowLandscape", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class HalfKuiklyEntryFragment extends QWalletBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#JP\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\tH\u0007R\u0014\u0010\u0011\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u0014\u0010\u001a\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0014\u0010\u001b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0014R\u0014\u0010\u001d\u001a\u00020\u001c8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0012R\u0014\u0010 \u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u0012R\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0014\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/fragment/HalfKuiklyEntryFragment$a;", "", "Landroidx/fragment/app/Fragment;", "fragment", "", "url", "title", "merchantLogo", "merchantTitle", "", "heightPercentage", "opacity", "", "showStatusBar", "requestCode", "", "a", "COLOR_BIT_MAX", "I", "KEY_EXTRA_SHOW_STATUS_BAR", "Ljava/lang/String;", "KEY_HEIGHT_PERCENTAGE", "KEY_KUIKLY_TITLE", "KEY_KUIKLY_URL", "KEY_LAUNCH_BY_INTERFACE", "KEY_MERCHANT_LOGO", "KEY_MERCHANT_TITLE", "KEY_OPACITY", "", "MASK_WINDOW_DELAY", "J", "OPACITY_DEFAULT", "PERCENT_MAX", "TAG", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.pet.fragment.HalfKuiklyEntryFragment$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Fragment fragment, @NotNull String url, @NotNull String title, @NotNull String merchantLogo, @NotNull String merchantTitle, int heightPercentage, int opacity, boolean showStatusBar, int requestCode) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(merchantLogo, "merchantLogo");
            Intrinsics.checkNotNullParameter(merchantTitle, "merchantTitle");
            Intent intent = new Intent();
            intent.putExtra("url", url);
            intent.putExtra("title", title);
            intent.putExtra("qwMerchantLogo", merchantLogo);
            intent.putExtra("qwMerchantTitle", merchantTitle);
            intent.putExtra("qwHeightPercentage", heightPercentage);
            intent.putExtra("qwOpacity", opacity);
            intent.putExtra("qwLaunchByInterface", true);
            intent.putExtra("qwShowStatusBar", showStatusBar);
            intent.putExtra("public_fragment_window_feature", 1);
            if (fragment instanceof QBaseFragment) {
                QPublicFragmentActivity.b.g((QBaseFragment) fragment, intent, QPublicTransFragmentActivity.class, HalfKuiklyEntryFragment.class, requestCode);
                return;
            }
            FragmentActivity activity = fragment.getActivity();
            if (activity != null && !activity.isFinishing()) {
                QPublicFragmentActivity.b.e(fragment.getActivity(), intent, QPublicTransFragmentActivity.class, HalfKuiklyEntryFragment.class, requestCode);
                return;
            }
            if (activity != null) {
                bool = Boolean.valueOf(activity.isFinishing());
            } else {
                bool = null;
            }
            QLog.w("HalfKuiklyEntryFragment", 1, "start fail, fragment=" + fragment + " activity=" + activity + " isFinish=" + bool);
        }

        Companion() {
        }
    }

    private final void qh(final Bundle arguments, final View rootView) {
        if (arguments.getBoolean("qwLaunchByInterface")) {
            arguments.remove("qwLaunchByInterface");
            rootView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qwallet.pet.fragment.c
                @Override // java.lang.Runnable
                public final void run() {
                    HalfKuiklyEntryFragment.rh(arguments, rootView);
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rh(Bundle arguments, View this_apply) {
        Intrinsics.checkNotNullParameter(arguments, "$arguments");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.setBackgroundColor(Color.argb((arguments.getInt("qwOpacity", 50) * 255) / 100, 0, 0, 0));
    }

    private final void sh() {
        HalfKuiklyDialogFragment halfKuiklyDialogFragment = new HalfKuiklyDialogFragment();
        halfKuiklyDialogFragment.setArguments(getArguments());
        halfKuiklyDialogFragment.show(requireActivity().getSupportFragmentManager(), "qwallet_half_kuikly_dialog_fragment");
        FragmentKt.setFragmentResultListener(halfKuiklyDialogFragment, "qwallet_half_kuikly_request", new Function2<String, Bundle, Unit>() { // from class: com.tencent.mobileqq.qwallet.pet.fragment.HalfKuiklyEntryFragment$startHalfDialogFragment$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
                invoke2(str, bundle);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String requestKey, @NotNull Bundle bundle) {
                Intrinsics.checkNotNullParameter(requestKey, "requestKey");
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                QLog.d("HalfKuiklyEntryFragment", 1, "onActivityResult: " + requestKey + " " + bundle);
                FragmentActivity activity = HalfKuiklyEntryFragment.this.getActivity();
                if (activity != null) {
                    activity.setResult(-1, new Intent().putExtras(bundle));
                }
                FragmentActivity activity2 = HalfKuiklyEntryFragment.this.getActivity();
                if (activity2 != null) {
                    activity2.finish();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    @NotNull
    public FragmentAnimation getFragmentAnimation() {
        return FragmentAnimation.NONE;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean isAllowLandscape() {
        return true;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    protected boolean isStatusBarImmersive() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.f_n, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        qh(arguments, view);
        sh();
    }
}
