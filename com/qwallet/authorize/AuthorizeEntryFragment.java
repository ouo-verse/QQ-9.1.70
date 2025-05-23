package com.qwallet.authorize;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.qwallet.authorize.dialog.AuthorizeDialogFragment;
import com.qwallet.authorize.dialog.AuthorizeViewModel;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.LoadingUtil;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Job;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J&\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\b\u0010\u0016\u001a\u00020\u0014H\u0016R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/qwallet/authorize/AuthorizeEntryFragment;", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "Landroid/app/Dialog;", "loadingDialog", "", "qh", "showLoadingDialog", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/base/FragmentAnimation;", "getFragmentAnimation", "", "isStatusBarImmersive", "isAllowLandscape", "Lcom/qwallet/authorize/dialog/AuthorizeViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "ph", "()Lcom/qwallet/authorize/dialog/AuthorizeViewModel;", "viewModel", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "D", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "qJob", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class AuthorizeEntryFragment extends QWalletBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AuthorizeViewModel.class), new Function0<ViewModelStore>() { // from class: com.qwallet.authorize.AuthorizeEntryFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelStore invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            ViewModelStore viewModelStore = requireActivity.get_viewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<ViewModelProvider.Factory>() { // from class: com.qwallet.authorize.AuthorizeEntryFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            return requireActivity.getDefaultViewModelProviderFactory();
        }
    });

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private b qJob;

    private final AuthorizeViewModel ph() {
        return (AuthorizeViewModel) this.viewModel.getValue();
    }

    private final void qh(final Dialog loadingDialog) {
        ph().Z1(new Function3<Boolean, Integer, String, Unit>() { // from class: com.qwallet.authorize.AuthorizeEntryFragment$requestPhonePanel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str) {
                invoke(bool.booleanValue(), num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, int i3, @NotNull String retMsg) {
                Intrinsics.checkNotNullParameter(retMsg, "retMsg");
                FragmentActivity outActivity = AuthorizeEntryFragment.this.getOutActivity();
                if (outActivity == null || outActivity.isFinishing()) {
                    return;
                }
                loadingDialog.dismiss();
                if (z16) {
                    AuthorizeDialogFragment authorizeDialogFragment = new AuthorizeDialogFragment();
                    authorizeDialogFragment.setArguments(AuthorizeEntryFragment.this.getArguments());
                    FragmentManager supportFragmentManager = AuthorizeEntryFragment.this.requireActivity().getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().supportFragmentManager");
                    authorizeDialogFragment.show(supportFragmentManager, "qwallet_authorize_dialog_fragment");
                    final AuthorizeEntryFragment authorizeEntryFragment = AuthorizeEntryFragment.this;
                    FragmentKt.setFragmentResultListener(authorizeDialogFragment, "qwallet_authorize_request", new Function2<String, Bundle, Unit>() { // from class: com.qwallet.authorize.AuthorizeEntryFragment$requestPhonePanel$1.1
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
                            QLog.d(QPublicBaseFragment.TAG, 1, "onActivityResult: " + requestKey + " " + bundle);
                            AuthorizeEntryFragment.this.setResult(-1, new Intent().putExtras(bundle));
                            AuthorizeEntryFragment.this.finish();
                        }
                    });
                    return;
                }
                QLog.d(QPublicBaseFragment.TAG, 1, "requestAuthPhonePanel: is not success " + retMsg);
                Intent intent = new Intent();
                intent.putExtra("extra_key_result_code", i3);
                intent.putExtra("extra_key_result_msg", "\u7f51\u7edc\u5f02\u5e38");
                AuthorizeEntryFragment.this.setResult(-1, intent);
                AuthorizeEntryFragment.this.finish();
            }
        });
    }

    private final Dialog showLoadingDialog() {
        Dialog loadingDialog = LoadingUtil.showLoadingDialog(getContext(), "\u52a0\u8f7d\u4e2d", false);
        Window window = loadingDialog.getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
        }
        loadingDialog.show();
        Intrinsics.checkNotNullExpressionValue(loadingDialog, "loadingDialog");
        return loadingDialog;
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
        View inflate = inflater.inflate(R.layout.hhw, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Job f16;
        super.onDestroy();
        b bVar = this.qJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        this.qJob = null;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Dialog showLoadingDialog = showLoadingDialog();
        this.qJob = ph().b2();
        qh(showLoadingDialog);
    }
}
