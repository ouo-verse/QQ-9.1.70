package com.tencent.mobileqq.minigame.publicaccount.hippy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.compat.f;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.minigame.publicaccount.utils.PublicAccountUtil;
import com.tencent.mobileqq.pad.m;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0016J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/minigame/publicaccount/hippy/MiniGamePAHippyFragment;", "Lcom/tencent/mobileqq/minigame/publicaccount/hippy/MiniGamePAHippyBaseFragment;", "()V", "navBar", "Lcom/tencent/mobileqq/widget/navbar/NavBarCommon;", "getLayoutResId", "", "initNavBar", "", "initViews", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onPostThemeChanged", "setNavBar", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGamePAHippyFragment extends MiniGamePAHippyBaseFragment {
    private NavBarCommon navBar;

    private final void initNavBar() {
        this.navBar = (NavBarCommon) getRootView().findViewById(R.id.z9s);
        setNavBar();
    }

    private final void setNavBar() {
        NavBarCommon navBarCommon = this.navBar;
        if (navBarCommon != null) {
            navBarCommon.setTitle(navBarCommon.getContext().getText(R.string.f167742dr));
            navBarCommon.setRightImage(navBarCommon.getContext().getResources().getDrawable(R.drawable.qui_chat_settings));
            navBarCommon.setOnItemSelectListener(new com.tencent.mobileqq.widget.navbar.a() { // from class: com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyFragment$setNavBar$1$1
                @Override // com.tencent.mobileqq.widget.navbar.a
                public void onItemSelect(View v3, int item) {
                    if (item != 1) {
                        if (item != 5) {
                            return;
                        }
                        PublicAccountUtil.openAccountDetail(MiniGamePAHippyFragment.this.getActivity());
                    } else if (AppSetting.t(MiniGamePAHippyFragment.this.getActivity())) {
                        FragmentActivity activity = MiniGamePAHippyFragment.this.getActivity();
                        Intrinsics.checkNotNull(activity);
                        m.b(activity);
                    } else {
                        FragmentActivity activity2 = MiniGamePAHippyFragment.this.getActivity();
                        Intrinsics.checkNotNull(activity2);
                        activity2.finish();
                    }
                }

                public void onItemLonClick(View v3, int item) {
                }
            });
            ViewGroup.LayoutParams layoutParams = navBarCommon.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.setMargins(0, cc2.b.a(getActivity()) - 1, 0, 0);
            int fixedWidth = ((IHippySetting) QRoute.api(IHippySetting.class)).getFixedWidth(getModuleName());
            if (fixedWidth > 0) {
                layoutParams2.width = fixedWidth;
            }
            navBarCommon.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment
    public int getLayoutResId() {
        return R.layout.fib;
    }

    @Override // com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment
    public void initViews() {
        super.initViews();
        initNavBar();
    }

    @Override // com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        getParameters().putBoolean(OpenHippyInfo.EXTRA_KEY_IS_STATUSBAR_DARKFONT, !isNightTheme());
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override // com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        boolean isNightTheme = isNightTheme();
        if (QLog.isColorLevel()) {
            QLog.d(MiniGamePAHippyBaseFragment.TAG, 2, "onPostThemeChanged isNightTheme=" + isNightTheme);
        }
        getParameters().putBoolean(OpenHippyInfo.EXTRA_KEY_IS_STATUSBAR_DARKFONT, !isNightTheme);
        notifyHippyThemeChange(isNightTheme);
    }

    @Override // com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
