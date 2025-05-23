package com.tencent.state;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.compat.f;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.state.square.SquareBaseKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import ne0.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u0000 42\u00020\u0001:\u00014B\u0005\u00a2\u0006\u0002\u0010\u0002J.\u0010\f\u001a\u00020\r\"\n\b\u0000\u0010\u000e\u0018\u0001*\u00020\u000f2\u0014\b\b\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u00020\r0\u0011H\u0086\b\u00f8\u0001\u0000JB\u0010\f\u001a\u00020\r\"\n\b\u0000\u0010\u000e\u0018\u0001*\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0014\b\b\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u00020\r0\u0011H\u0086\b\u00f8\u0001\u0000JF\u0010\f\u001a\u00020\r\"\b\b\u0000\u0010\u000e*\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u00020\r0\u0011J4\u0010\u0018\u001a\u0004\u0018\u0001H\u000e\"\n\b\u0000\u0010\u000e\u0018\u0001*\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0086\b\u00a2\u0006\u0002\u0010\u0019J=\u0010\u0018\u001a\u0004\u0018\u0001H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00172\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001cH\u0014J\b\u0010\u001d\u001a\u00020\nH&J\u0012\u0010\u001e\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#H\u0016J\u0012\u0010$\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010%\u001a\u00020\rH\u0016J\b\u0010&\u001a\u00020\rH\u0016J\u0010\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\nH\u0016J\b\u0010)\u001a\u00020\rH\u0016J\b\u0010*\u001a\u00020\rH\u0016J\b\u0010+\u001a\u00020\rH\u0016J\b\u0010,\u001a\u00020\rH\u0016J\u001a\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020/2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0018\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u000203H\u0015R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u00065"}, d2 = {"Lcom/tencent/state/VasBaseLifecycleFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "()V", "dispatcher", "Lcom/tencent/state/FragmentComponentDispatcher;", "getDispatcher", "()Lcom/tencent/state/FragmentComponentDispatcher;", "setDispatcher", "(Lcom/tencent/state/FragmentComponentDispatcher;)V", "isHide", "", "isResume", "forEachComponent", "", "T", "Lcom/tencent/state/FragmentComponent;", "block", "Lkotlin/Function1;", VipFunCallConstants.KEY_GROUP, "Lcom/tencent/state/VasBaseFragmentComponentGroup;", "tag", "", "clazz", "Ljava/lang/Class;", "getComponent", "(Lcom/tencent/state/VasBaseFragmentComponentGroup;Ljava/lang/Object;)Lcom/tencent/state/FragmentComponent;", "(Ljava/lang/Class;Lcom/tencent/state/VasBaseFragmentComponentGroup;Ljava/lang/Object;)Lcom/tencent/state/FragmentComponent;", "getComponents", "", "isTopFragment", "onActivityCreated", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onAttach", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onDestroyView", "onHiddenChanged", "hidden", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", "onStart", DKHippyEvent.EVENT_STOP, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "Landroid/view/View;", "onVisibilityChanged", "isVisible", "from", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class VasBaseLifecycleFragment extends QPublicBaseFragment {
    private static final String TAG = "VasBaseLifecycleFragment";
    private FragmentComponentDispatcher dispatcher;
    private boolean isHide;
    private boolean isResume;

    public static /* synthetic */ FragmentComponent getComponent$default(VasBaseLifecycleFragment vasBaseLifecycleFragment, Class cls, VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup, Object obj, int i3, Object obj2) {
        if (obj2 == null) {
            if ((i3 & 2) != 0) {
                vasBaseFragmentComponentGroup = null;
            }
            if ((i3 & 4) != 0) {
                obj = null;
            }
            return vasBaseLifecycleFragment.getComponent(cls, vasBaseFragmentComponentGroup, obj);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getComponent");
    }

    public final <T extends FragmentComponent> void forEachComponent(Class<T> clazz, VasBaseFragmentComponentGroup group, Object tag, Function1<? super T, Unit> block) {
        List<FragmentComponent> components;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(block, "block");
        FragmentComponentDispatcher fragmentComponentDispatcher = this.dispatcher;
        if (fragmentComponentDispatcher == null || (components = fragmentComponentDispatcher.getComponents()) == null) {
            return;
        }
        for (FragmentComponent fragmentComponent : components) {
            if (group == null || (VasBaseFragmentComponent.class.isAssignableFrom(fragmentComponent.getClass()) && (!(!Intrinsics.areEqual(((VasBaseFragmentComponent) fragmentComponent).getParent(), group)) || !(!Intrinsics.areEqual(group, fragmentComponent))))) {
                if (clazz.isAssignableFrom(fragmentComponent.getClass())) {
                    if (tag == null || (VasBaseFragmentComponent.class.isAssignableFrom(fragmentComponent.getClass()) && !(!Intrinsics.areEqual(((VasBaseFragmentComponent) fragmentComponent).getTag(), tag)))) {
                        block.invoke(fragmentComponent);
                    }
                } else if (VasBaseFragmentComponentGroup.class.isAssignableFrom(fragmentComponent.getClass())) {
                    ((VasBaseFragmentComponentGroup) fragmentComponent).forEachComponent(clazz, tag, block);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.tencent.state.FragmentComponent] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.tencent.state.FragmentComponent] */
    public final <T extends FragmentComponent> T getComponent(Class<T> clazz, VasBaseFragmentComponentGroup group, Object tag) {
        ?? r26;
        List<FragmentComponent> components;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        FragmentComponentDispatcher fragmentComponentDispatcher = this.dispatcher;
        if (fragmentComponentDispatcher != null && (components = fragmentComponentDispatcher.getComponents()) != null) {
            r26 = 0;
            for (FragmentComponent fragmentComponent : components) {
                if (clazz.isAssignableFrom(fragmentComponent.getClass())) {
                    r26 = fragmentComponent;
                } else if (group != null) {
                    if (group.getClass().isAssignableFrom(fragmentComponent.getClass())) {
                        r26 = group.getComponent(clazz, tag);
                    }
                } else if (VasBaseFragmentComponentGroup.class.isAssignableFrom(fragmentComponent.getClass())) {
                    r26 = ((VasBaseFragmentComponentGroup) fragmentComponent).getComponent(clazz, tag);
                }
                if (r26 != 0) {
                    break;
                }
            }
        } else {
            r26 = 0;
        }
        boolean z16 = r26 instanceof FragmentComponent;
        T t16 = r26;
        if (!z16) {
            t16 = null;
        }
        if (t16 != null) {
            return t16;
        }
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof VasBaseLifecycleFragment)) {
            parentFragment = null;
        }
        VasBaseLifecycleFragment vasBaseLifecycleFragment = (VasBaseLifecycleFragment) parentFragment;
        if (vasBaseLifecycleFragment != null) {
            return (T) getComponent$default(vasBaseLifecycleFragment, clazz, null, null, 6, null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<FragmentComponent> getComponents() {
        List<FragmentComponent> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final FragmentComponentDispatcher getDispatcher() {
        return this.dispatcher;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    public abstract boolean isTopFragment();

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        SquareBaseKt.getSquareLog().i(TAG, '[' + getClass().getSimpleName() + "] onActivityCreated");
        super.onActivityCreated(savedInstanceState);
        FragmentComponentDispatcher fragmentComponentDispatcher = this.dispatcher;
        if (fragmentComponentDispatcher != null) {
            fragmentComponentDispatcher.onFragmentActivityCreated(getFragmentManager(), this, savedInstanceState);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        SquareBaseKt.getSquareLog().i(TAG, '[' + getClass().getSimpleName() + "] onAttach");
        super.onAttach(activity);
        this.dispatcher = new FragmentComponentDispatcher(getComponents());
        forEachComponent(VasBaseFragmentComponent.class, null, null, new Function1<VasBaseFragmentComponent, Unit>() { // from class: com.tencent.state.VasBaseLifecycleFragment$onAttach$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VasBaseFragmentComponent vasBaseFragmentComponent) {
                invoke2(vasBaseFragmentComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(VasBaseFragmentComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.initialize(VasBaseLifecycleFragment.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        SquareBaseKt.getSquareLog().i(TAG, '[' + getClass().getSimpleName() + "] onCreate");
        FragmentComponentDispatcher fragmentComponentDispatcher = this.dispatcher;
        if (fragmentComponentDispatcher != null) {
            fragmentComponentDispatcher.onFragmentPreCreated(getFragmentManager(), this, savedInstanceState);
        }
        super.onCreate(savedInstanceState);
        FragmentComponentDispatcher fragmentComponentDispatcher2 = this.dispatcher;
        if (fragmentComponentDispatcher2 != null) {
            fragmentComponentDispatcher2.onFragmentCreated(getFragmentManager(), this, savedInstanceState);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        SquareBaseKt.getSquareLog().i(TAG, '[' + getClass().getSimpleName() + "] onDestroy");
        super.onDestroy();
        FragmentComponentDispatcher fragmentComponentDispatcher = this.dispatcher;
        if (fragmentComponentDispatcher != null) {
            fragmentComponentDispatcher.onFragmentDestroyed(getFragmentManager(), this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        SquareBaseKt.getSquareLog().i(TAG, '[' + getClass().getSimpleName() + "] onDestroyView");
        super.onDestroyView();
        FragmentComponentDispatcher fragmentComponentDispatcher = this.dispatcher;
        if (fragmentComponentDispatcher != null) {
            fragmentComponentDispatcher.onFragmentViewDestroyed(getFragmentManager(), this);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        SquareBaseKt.getSquareLog().i(TAG, '[' + getClass().getSimpleName() + "] onHiddenChanged, hidden=" + hidden);
        this.isHide = hidden;
        onVisibilityChanged(this.isResume && !hidden && isTopFragment(), "onHiddenChanged");
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        SquareBaseKt.getSquareLog().i(TAG, '[' + getClass().getSimpleName() + "] onPause");
        super.onPause();
        FragmentComponentDispatcher fragmentComponentDispatcher = this.dispatcher;
        if (fragmentComponentDispatcher != null) {
            fragmentComponentDispatcher.onFragmentPaused(getFragmentManager(), this);
        }
        this.isResume = false;
        onVisibilityChanged(false, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        SquareBaseKt.getSquareLog().i(TAG, '[' + getClass().getSimpleName() + "] onResume");
        super.onResume();
        FragmentComponentDispatcher fragmentComponentDispatcher = this.dispatcher;
        if (fragmentComponentDispatcher != null) {
            fragmentComponentDispatcher.onFragmentResumed(getFragmentManager(), this);
        }
        this.isResume = true;
        onVisibilityChanged(!this.isHide && isTopFragment(), "onResume");
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        SquareBaseKt.getSquareLog().i(TAG, '[' + getClass().getSimpleName() + "] onStart");
        super.onStart();
        FragmentComponentDispatcher fragmentComponentDispatcher = this.dispatcher;
        if (fragmentComponentDispatcher != null) {
            fragmentComponentDispatcher.onFragmentStarted(getFragmentManager(), this);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        SquareBaseKt.getSquareLog().i(TAG, '[' + getClass().getSimpleName() + "] onStop");
        super.onStop();
        FragmentComponentDispatcher fragmentComponentDispatcher = this.dispatcher;
        if (fragmentComponentDispatcher != null) {
            fragmentComponentDispatcher.onFragmentStopped(getFragmentManager(), this);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        SquareBaseKt.getSquareLog().i(TAG, '[' + getClass().getSimpleName() + "] onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        FragmentComponentDispatcher fragmentComponentDispatcher = this.dispatcher;
        if (fragmentComponentDispatcher != null) {
            fragmentComponentDispatcher.onFragmentViewCreated(getFragmentManager(), this, view, savedInstanceState);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onVisibilityChanged(boolean isVisible, String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        SquareBaseKt.getSquareLog().i(TAG, '[' + getClass().getSimpleName() + "] onVisibilityChanged, isVisible=" + isVisible + ", from:" + from);
        FragmentComponentDispatcher fragmentComponentDispatcher = this.dispatcher;
        if (fragmentComponentDispatcher != null) {
            fragmentComponentDispatcher.onFragmentVisibilityChanged(getFragmentManager(), this, isVisible);
        }
    }

    protected final void setDispatcher(FragmentComponentDispatcher fragmentComponentDispatcher) {
        this.dispatcher = fragmentComponentDispatcher;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return a.c(this, str, cls);
    }

    public static /* synthetic */ FragmentComponent getComponent$default(VasBaseLifecycleFragment vasBaseLifecycleFragment, VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup, Object obj, int i3, Object obj2) {
        if (obj2 == null) {
            if ((i3 & 1) != 0) {
                vasBaseFragmentComponentGroup = null;
            }
            if ((i3 & 2) != 0) {
                obj = null;
            }
            Intrinsics.reifiedOperationMarker(4, "T");
            return vasBaseLifecycleFragment.getComponent(FragmentComponent.class, vasBaseFragmentComponentGroup, obj);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getComponent");
    }

    public final /* synthetic */ <T extends FragmentComponent> T getComponent(VasBaseFragmentComponentGroup group, Object tag) {
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) getComponent(FragmentComponent.class, group, tag);
    }

    public final /* synthetic */ <T extends FragmentComponent> void forEachComponent(Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Intrinsics.reifiedOperationMarker(4, "T");
        forEachComponent(FragmentComponent.class, null, null, block);
    }

    public final /* synthetic */ <T extends FragmentComponent> void forEachComponent(VasBaseFragmentComponentGroup group, Object tag, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Intrinsics.reifiedOperationMarker(4, "T");
        forEachComponent(FragmentComponent.class, group, tag, block);
    }
}
