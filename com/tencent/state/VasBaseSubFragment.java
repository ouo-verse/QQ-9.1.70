package com.tencent.state;

import android.content.Intent;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.compat.f;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ne0.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\"\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0017\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0018\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/VasBaseSubFragment;", "Lcom/tencent/state/VasBaseFragment;", "()V", "groupFragment", "Lcom/tencent/state/VasBaseGroupFragment;", "getGroupFragment", "()Lcom/tencent/state/VasBaseGroupFragment;", "topFragment", "Landroidx/fragment/app/Fragment;", "getTopFragment", "()Landroidx/fragment/app/Fragment;", "hideFragment", "", "fragment", "isTopFragment", "", "onActivityResult", "requestCode", "", QzoneIPCModule.RESULT_CODE, "data", "Landroid/content/Intent;", "popFragment", "pushFragment", "showFragment", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class VasBaseSubFragment extends VasBaseFragment {
    public final VasBaseGroupFragment getGroupFragment() {
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof VasBaseGroupFragment)) {
            parentFragment = null;
        }
        return (VasBaseGroupFragment) parentFragment;
    }

    public Fragment getTopFragment() {
        ActivityResultCaller parentFragment = getParentFragment();
        if (!(parentFragment instanceof IFragmentManager)) {
            parentFragment = null;
        }
        IFragmentManager iFragmentManager = (IFragmentManager) parentFragment;
        if (iFragmentManager != null) {
            return iFragmentManager.getTopFragment();
        }
        return null;
    }

    @Override // com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    public void hideFragment(Fragment fragment) {
        ActivityResultCaller parentFragment = getParentFragment();
        if (!(parentFragment instanceof IFragmentManager)) {
            parentFragment = null;
        }
        IFragmentManager iFragmentManager = (IFragmentManager) parentFragment;
        if (iFragmentManager != null) {
            iFragmentManager.hideFragment(fragment);
        }
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment
    public boolean isTopFragment() {
        if (SquareRuntime.INSTANCE.hasNearbyMark()) {
            return getTopFragment() == null || Intrinsics.areEqual(getTopFragment(), this);
        }
        return Intrinsics.areEqual(getTopFragment(), this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        VasBaseGroupFragment groupFragment = getGroupFragment();
        if (groupFragment != null) {
            groupFragment.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    public void popFragment(Fragment fragment) {
        ActivityResultCaller parentFragment = getParentFragment();
        if (!(parentFragment instanceof IFragmentManager)) {
            parentFragment = null;
        }
        IFragmentManager iFragmentManager = (IFragmentManager) parentFragment;
        if (iFragmentManager != null) {
            iFragmentManager.popFragment(fragment);
        }
    }

    public void pushFragment(Fragment fragment) {
        ActivityResultCaller parentFragment = getParentFragment();
        if (!(parentFragment instanceof IFragmentManager)) {
            parentFragment = null;
        }
        IFragmentManager iFragmentManager = (IFragmentManager) parentFragment;
        if (iFragmentManager != null) {
            iFragmentManager.pushFragment(fragment);
        }
    }

    public void showFragment(Fragment fragment) {
        ActivityResultCaller parentFragment = getParentFragment();
        if (!(parentFragment instanceof IFragmentManager)) {
            parentFragment = null;
        }
        IFragmentManager iFragmentManager = (IFragmentManager) parentFragment;
        if (iFragmentManager != null) {
            iFragmentManager.showFragment(fragment);
        }
    }

    @Override // com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    @Override // com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return a.c(this, str, cls);
    }
}
