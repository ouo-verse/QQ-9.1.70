package com.tencent.state;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.compat.f;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.state.report.TechReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.utils.DrawableUtil;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ne0.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0002\u0004\u0007\b&\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H&J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\"\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\b\u0010\u001f\u001a\u00020\u0012H\u0016J\b\u0010 \u001a\u00020\u0012H\u0016J\u0012\u0010!\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\"\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010#\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006%"}, d2 = {"Lcom/tencent/state/VasBaseGroupFragment;", "Lcom/tencent/state/VasBaseSubFragment;", "()V", "backPressCallback", "com/tencent/state/VasBaseGroupFragment$backPressCallback$1", "Lcom/tencent/state/VasBaseGroupFragment$backPressCallback$1;", "childFragmentObserver", "com/tencent/state/VasBaseGroupFragment$childFragmentObserver$1", "Lcom/tencent/state/VasBaseGroupFragment$childFragmentObserver$1;", "fragmentHelper", "Lcom/tencent/state/FragmentHelper;", "topFragment", "Landroidx/fragment/app/Fragment;", "getTopFragment", "()Landroidx/fragment/app/Fragment;", "getSubFragmentContainerId", "", "hideFragment", "", "fragment", "isTopFragment", "", "onActivityResult", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "Landroid/content/Intent;", "onAttach", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "onBackEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onLowMemory", "popFragment", "pushFragment", "showFragment", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class VasBaseGroupFragment extends VasBaseSubFragment {
    private static final String TAG = "VasBaseGroupFragment";
    private final VasBaseGroupFragment$backPressCallback$1 backPressCallback;
    private final VasBaseGroupFragment$childFragmentObserver$1 childFragmentObserver = new FragmentManager.FragmentLifecycleCallbacks() { // from class: com.tencent.state.VasBaseGroupFragment$childFragmentObserver$1
        private final void onFragmentChange() {
            VasBaseGroupFragment$backPressCallback$1 vasBaseGroupFragment$backPressCallback$1;
            vasBaseGroupFragment$backPressCallback$1 = VasBaseGroupFragment.this.backPressCallback;
            FragmentManager childFragmentManager = VasBaseGroupFragment.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            vasBaseGroupFragment$backPressCallback$1.setEnabled(childFragmentManager.getFragments().size() > 0);
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentAttached(FragmentManager fm5, Fragment f16, Context context) {
            Intrinsics.checkNotNullParameter(fm5, "fm");
            Intrinsics.checkNotNullParameter(f16, "f");
            Intrinsics.checkNotNullParameter(context, "context");
            onFragmentChange();
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentDetached(FragmentManager fm5, Fragment f16) {
            Intrinsics.checkNotNullParameter(fm5, "fm");
            Intrinsics.checkNotNullParameter(f16, "f");
            onFragmentChange();
        }
    };
    private FragmentHelper fragmentHelper;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.state.VasBaseGroupFragment$backPressCallback$1] */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.tencent.state.VasBaseGroupFragment$childFragmentObserver$1] */
    public VasBaseGroupFragment() {
        final boolean z16 = false;
        this.backPressCallback = new OnBackPressedCallback(z16) { // from class: com.tencent.state.VasBaseGroupFragment$backPressCallback$1
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                VasBaseGroupFragment.this.onBackEvent();
            }
        };
    }

    public abstract int getSubFragmentContainerId();

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.IFragmentManager
    public Fragment getTopFragment() {
        FragmentHelper fragmentHelper = this.fragmentHelper;
        if (fragmentHelper != null) {
            return fragmentHelper.getTopFragment();
        }
        return null;
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseLifecycleFragment
    public boolean isTopFragment() {
        Object firstOrNull;
        FragmentManager fragmentManager = getFragmentManager();
        List<Fragment> fragments = fragmentManager != null ? fragmentManager.getFragments() : null;
        if (fragments != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) fragments);
            if (Intrinsics.areEqual((Fragment) firstOrNull, this)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        List<FragmentComponent> components;
        FragmentComponentDispatcher dispatcher = getDispatcher();
        if (dispatcher == null || (components = dispatcher.getComponents()) == null) {
            return;
        }
        for (FragmentComponent fragmentComponent : components) {
            if (!(fragmentComponent instanceof IActivityResultHandler)) {
                fragmentComponent = null;
            }
            IActivityResultHandler iActivityResultHandler = (IActivityResultHandler) fragmentComponent;
            if (iActivityResultHandler != null) {
                iActivityResultHandler.doOnActivityResult(requestCode, resultCode, data);
            }
        }
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onAttach(activity);
        this.fragmentHelper = new FragmentHelper(this, getSubFragmentContainerId());
        getChildFragmentManager().registerFragmentLifecycleCallbacks(this.childFragmentObserver, true);
        if (!(activity instanceof FragmentActivity)) {
            activity = null;
        }
        FragmentActivity fragmentActivity = (FragmentActivity) activity;
        if (fragmentActivity == null || (onBackPressedDispatcher = fragmentActivity.getOnBackPressedDispatcher()) == null) {
            return;
        }
        onBackPressedDispatcher.addCallback(this, this.backPressCallback);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        Fragment topFragment = getTopFragment();
        if (!(topFragment instanceof VasBaseFragment)) {
            topFragment = null;
        }
        VasBaseFragment vasBaseFragment = (VasBaseFragment) topFragment;
        if (vasBaseFragment == null || !vasBaseFragment.onBackPressed()) {
            return onBackPressed();
        }
        return true;
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        FragmentHelper fragmentHelper = this.fragmentHelper;
        if (fragmentHelper != null) {
            fragmentHelper.onDestroy();
        }
        getChildFragmentManager().unregisterFragmentLifecycleCallbacks(this.childFragmentObserver);
        DrawableUtil.INSTANCE.onContextDestroy(getContext());
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        Map<String, Object> mutableMapOf;
        super.onLowMemory();
        SquareBaseKt.getSquareLog().i(TAG, "onLowMemory, isResumed: " + isResumed());
        if (!isResumed() && Square.INSTANCE.getConfig().getCommonUtils().getPerformanceConfig().getRemoveURLDrawableCacheOnLowMem()) {
            DrawableUtil.INSTANCE.onLowMemory(getContext());
            System.gc();
        }
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(TechReportConst.Key.KEY_TECH_TYPE, 2), TuplesKt.to(TechReportConst.Key.KEY_ITEM_1, Boolean.valueOf(isResumed())));
        squareReporter.reportEvent(TechReportConst.CustomEventId.EVENT_ID_DEV_TECH_REPORT, mutableMapOf);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return a.c(this, str, cls);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.IFragmentManager
    public void hideFragment(Fragment fragment) {
        FragmentHelper fragmentHelper;
        if (fragment == null || (fragmentHelper = this.fragmentHelper) == null) {
            return;
        }
        fragmentHelper.popFragment(fragment, true, true);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.IFragmentManager
    public void popFragment(Fragment fragment) {
        FragmentHelper fragmentHelper;
        if (fragment == null || (fragmentHelper = this.fragmentHelper) == null) {
            return;
        }
        FragmentHelper.popFragment$default(fragmentHelper, fragment, false, false, 6, null);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.IFragmentManager
    public void pushFragment(Fragment fragment) {
        FragmentHelper fragmentHelper;
        if (fragment == null || (fragmentHelper = this.fragmentHelper) == null) {
            return;
        }
        FragmentHelper.pushFragment$default(fragmentHelper, fragment, false, false, 6, null);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.IFragmentManager
    public void showFragment(Fragment fragment) {
        FragmentHelper fragmentHelper;
        if (fragment == null || (fragmentHelper = this.fragmentHelper) == null) {
            return;
        }
        fragmentHelper.pushFragment(fragment, true, true);
    }
}
