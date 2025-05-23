package com.tencent.mobileqq.guild.live.fragment.base;

import android.content.Context;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import nq1.c;
import nq1.g;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class QQGuildLiveRoomBaseFragment extends QQGuildLiveModuleBaseFragment implements c {
    protected final g mQQGuildLiveModuleControl = new g();

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mQQGuildLiveModuleControl.e(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (!isAdded()) {
            return super.onBackEvent();
        }
        for (Fragment fragment : getChildFragmentManager().getFragments()) {
            if ((fragment instanceof QQGuildLiveModuleBaseFragment) && ((QQGuildLiveModuleBaseFragment) fragment).onBackEvent()) {
                return true;
            }
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.mQQGuildLiveModuleControl.e(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void replaceFragment(@IdRes int i3, @NonNull QQGuildLiveModuleBaseFragment qQGuildLiveModuleBaseFragment) {
        qQGuildLiveModuleBaseFragment.setRootFragmentLifecycleOwner(this);
        qQGuildLiveModuleBaseFragment.setQQGuildLiveModuleControl(this.mQQGuildLiveModuleControl);
        Fragment findFragmentById = getChildFragmentManager().findFragmentById(i3);
        if (findFragmentById != null) {
            getChildFragmentManager().beginTransaction().remove(findFragmentById).commitAllowingStateLoss();
        }
        getChildFragmentManager().beginTransaction().replace(i3, qQGuildLiveModuleBaseFragment).commitAllowingStateLoss();
    }
}
