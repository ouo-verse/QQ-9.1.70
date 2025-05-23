package com.tencent.mobileqq.qwallet.hb.panel.preview;

import android.app.Dialog;
import android.content.Context;
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
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qwallet.QPayBaseFragment;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.panel.m;
import com.tencent.mobileqq.qwallet.hb.panel.recommend.SkinRecommendViewModel;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.LoadingUtil;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J&\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\b\u0010\u0019\u001a\u00020\u0017H\u0016R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR/\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00050 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/preview/SkinPreviewEntryFragment;", "Lcom/tencent/mobileqq/qwallet/QPayBaseFragment;", "Lcom/tencent/mobileqq/qwallet/hb/panel/b;", "Landroid/app/Dialog;", "loadingDialog", "", "sh", "showLoadingDialog", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "skinId", "Q5", "Lcom/tencent/mobileqq/base/FragmentAnimation;", "getFragmentAnimation", "", "isStatusBarImmersive", "isAllowLandscape", "Lcom/tencent/mobileqq/qwallet/hb/panel/preview/SkinPreviewEntryViewModel;", "E", "Lkotlin/Lazy;", "rh", "()Lcom/tencent/mobileqq/qwallet/hb/panel/preview/SkinPreviewEntryViewModel;", "viewModel", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", UserInfo.SEX_FEMALE, "Lkotlin/jvm/functions/Function1;", "notifyRefreshCallback", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class SkinPreviewEntryFragment extends QPayBaseFragment implements com.tencent.mobileqq.qwallet.hb.panel.b {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SkinPreviewEntryViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.preview.SkinPreviewEntryFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelStore invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            ViewModelStore viewModelStore = requireActivity.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<ViewModelProvider.Factory>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.preview.SkinPreviewEntryFragment$special$$inlined$activityViewModels$default$2
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

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Function1<Integer, Unit> notifyRefreshCallback = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.preview.SkinPreviewEntryFragment$notifyRefreshCallback$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(int i3) {
            MobileQQ.sMobileQQ.sendBroadcast(new Intent("com.tencent.mobileqq.qwallet.hb.skin.refresh").putExtra("hb_skin_refresh_from", 1).putExtra("hb_skin_refresh_skin_id", i3));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public final SkinPreviewEntryViewModel rh() {
        return (SkinPreviewEntryViewModel) this.viewModel.getValue();
    }

    private final void sh(final Dialog loadingDialog) {
        rh().P1(new Function4<Boolean, Integer, Integer, String, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.preview.SkinPreviewEntryFragment$requestPhonePanel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, Integer num2, String str) {
                invoke(bool.booleanValue(), num.intValue(), num2.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, int i3, int i16, @Nullable String str) {
                SkinPreviewEntryViewModel rh5;
                SkinPreviewEntryViewModel rh6;
                Function1 function1;
                SkinPreviewEntryViewModel rh7;
                Context context = SkinPreviewEntryFragment.this.getContext();
                FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
                if (fragmentActivity != null && !fragmentActivity.isFinishing()) {
                    loadingDialog.dismiss();
                    if (z16) {
                        SkinPreviewDialogFragment a16 = SkinPreviewDialogFragment.INSTANCE.a(3, i3, QQTheme.isNowThemeIsNight() ? R.style.a7g : R.style.a7e);
                        rh5 = SkinPreviewEntryFragment.this.rh();
                        if (rh5.getCurrentSessionInfo() != null) {
                            rh7 = SkinPreviewEntryFragment.this.rh();
                            if (rh7.getCurrentHbType() != -1) {
                                a16.Jh(SkinPreviewEntryFragment.this);
                            }
                        }
                        rh6 = SkinPreviewEntryFragment.this.rh();
                        SkinRecommendViewModel skinRecommendVM = rh6.getSkinRecommendVM();
                        function1 = SkinPreviewEntryFragment.this.notifyRefreshCallback;
                        skinRecommendVM.q2(new WeakReference<>(function1));
                        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "fragmentActivity.supportFragmentManager");
                        a16.show(supportFragmentManager, "skin_preview_dialog_fragment");
                        final SkinPreviewEntryFragment skinPreviewEntryFragment = SkinPreviewEntryFragment.this;
                        FragmentKt.setFragmentResultListener(a16, "skin_preview_request", new Function2<String, Bundle, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.preview.SkinPreviewEntryFragment$requestPhonePanel$1.1
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(String str2, Bundle bundle) {
                                invoke2(str2, bundle);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull String requestKey, @NotNull Bundle bundle) {
                                Intrinsics.checkNotNullParameter(requestKey, "requestKey");
                                Intrinsics.checkNotNullParameter(bundle, "bundle");
                                QLog.d(QPublicBaseFragment.TAG, 1, "onActivityResult: " + requestKey + " " + bundle);
                                Intent intent = new Intent();
                                intent.putExtras(bundle);
                                intent.putExtra(IQWalletHbApi.KEY_HB_SKIN_PREVIEW_RESULT_CODE, 0);
                                intent.putExtra(IQWalletHbApi.KEY_HB_SKIN_PREVIEW_RESULT_MSG, "user cancel");
                                SkinPreviewEntryFragment.this.setResult(-1, intent);
                                SkinPreviewEntryFragment.this.finish();
                            }
                        });
                        return;
                    }
                    QLog.d(QPublicBaseFragment.TAG, 1, "requestAuthPhonePanel: is not success");
                    Intent intent = new Intent();
                    intent.putExtra(IQWalletHbApi.KEY_HB_SKIN_PREVIEW_RESULT_CODE, i16);
                    if (str == null) {
                        str = "";
                    }
                    intent.putExtra(IQWalletHbApi.KEY_HB_SKIN_PREVIEW_RESULT_MSG, str);
                    SkinPreviewEntryFragment.this.setResult(-1, intent);
                    SkinPreviewEntryFragment.this.finish();
                    return;
                }
                QLog.d(QPublicBaseFragment.TAG, 2, "showSkinPreview: activity is finishing " + fragmentActivity);
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

    @Override // com.tencent.mobileqq.qwallet.hb.panel.b
    public void Q5(int skinId) {
        m.f277567a.f(rh().getCurrentSessionInfo(), getContext(), rh().getCurrentHbType(), Integer.valueOf(skinId), true);
    }

    @Override // com.tencent.mobileqq.qwallet.QPayBaseFragment
    @NotNull
    public FragmentAnimation getFragmentAnimation() {
        return FragmentAnimation.NONE;
    }

    @Override // com.tencent.mobileqq.qwallet.QPayBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean isAllowLandscape() {
        return true;
    }

    @Override // com.tencent.mobileqq.qwallet.QPayBaseFragment
    protected boolean isStatusBarImmersive() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.hk6, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.qwallet.QPayBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        sh(showLoadingDialog());
    }
}
