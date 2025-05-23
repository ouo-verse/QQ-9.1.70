package com.tencent.mobileqq.guild.live.fragment.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.live.livemanager.e;
import com.tencent.mobileqq.guild.window.o;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import nq1.g;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class QQGuildLiveModuleBaseFragment extends QPublicBaseFragment {
    protected g mLiveModuleControl;
    protected ViewModelStoreOwner mLiveRoomViewModelStoreOwner;

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void beforeFinish() {
        super.beforeFinish();
        if (!isAdded()) {
            return;
        }
        for (Fragment fragment : getChildFragmentManager().getFragments()) {
            if (fragment instanceof QQGuildLiveModuleBaseFragment) {
                ((QQGuildLiveModuleBaseFragment) fragment).beforeFinish();
            }
        }
    }

    public void finishActivity() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            getActivity().finish();
            getActivity().overridePendingTransition(0, R.anim.f154607of);
        }
    }

    public void finishActivityJudgePadWithAnim() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            if (AppSetting.t(getActivity())) {
                getActivity().onKeyDown(4, new KeyEvent(4, 4));
            } else {
                getActivity().finish();
                getActivity().overridePendingTransition(0, R.anim.f154607of);
            }
        }
    }

    public void finishActivityJudgePadWithoutAnim() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            if (AppSetting.t(getActivity()) && ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isSplashActivity(getActivity())) {
                getActivity().onKeyDown(4, new KeyEvent(4, 4));
            } else {
                getActivity().finish();
            }
        }
    }

    public AppRuntime getAppRuntime() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    @LayoutRes
    protected abstract int getLayoutId();

    public e getShowHideAnimHelper() {
        g gVar = this.mLiveModuleControl;
        if (gVar != null && gVar.a() != null) {
            return this.mLiveModuleControl.a().getLiveShowHideAnimHelper();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        super.onActivityResult(i3, i16, intent);
        for (Fragment fragment : getChildFragmentManager().getFragments()) {
            if (fragment instanceof QQGuildLiveModuleBaseFragment) {
                ((QQGuildLiveModuleBaseFragment) fragment).onActivityResult(i3, i16, intent);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        o.a().c("qqGuildLiveRoom", getActivity());
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(getLayoutId(), viewGroup, false);
        initView(inflate);
        initLiveDataObserver();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        if (!isAdded()) {
            return;
        }
        for (Fragment fragment : getChildFragmentManager().getFragments()) {
            if (fragment instanceof QQGuildLiveModuleBaseFragment) {
                ((QQGuildLiveModuleBaseFragment) fragment).onFinish();
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        for (Fragment fragment : getChildFragmentManager().getFragments()) {
            if (fragment instanceof QQGuildLiveModuleBaseFragment) {
                ((QQGuildLiveModuleBaseFragment) fragment).onNewIntent(intent);
            }
        }
    }

    public void setQQGuildLiveModuleControl(g gVar) {
        this.mLiveModuleControl = gVar;
    }

    public void setRootFragmentLifecycleOwner(@NonNull ViewModelStoreOwner viewModelStoreOwner) {
        this.mLiveRoomViewModelStoreOwner = viewModelStoreOwner;
    }

    protected void initLiveDataObserver() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initViewModel() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView(@NonNull View view) {
    }
}
