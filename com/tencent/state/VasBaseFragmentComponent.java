package com.tencent.state;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.FragmentComponent;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J.\u0010\u001d\u001a\u00020\u001e\"\n\b\u0000\u0010\u001f\u0018\u0001*\u00020\u00012\u0014\b\b\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u00020\u001e0!H\u0084\b\u00f8\u0001\u0000J.\u0010\"\u001a\u00020\u001e\"\n\b\u0000\u0010\u001f\u0018\u0001*\u00020\u00012\u0014\b\b\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u00020\u001e0!H\u0084\b\u00f8\u0001\u0000J.\u0010#\u001a\u00020\u001e\"\n\b\u0000\u0010\u001f\u0018\u0001*\u00020\u00012\u0014\b\b\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u00020\u001e0!H\u0084\b\u00f8\u0001\u0000J(\u0010$\u001a\u0004\u0018\u0001H\u001f\"\n\b\u0000\u0010\u001f\u0018\u0001*\u00020\u00012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0084\b\u00a2\u0006\u0002\u0010%J\u001c\u0010&\u001a\u0004\u0018\u0001H\u001f\"\n\b\u0000\u0010\u001f\u0018\u0001*\u00020\u0001H\u0084\b\u00a2\u0006\u0002\u0010'J\b\u0010(\u001a\u0004\u0018\u00010)J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010\u0007\u001a\u00020+H\u0016J\u001a\u0010,\u001a\u00020\u001e2\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020+H\u0016R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\fR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u00060"}, d2 = {"Lcom/tencent/state/VasBaseFragmentComponent;", "Lcom/tencent/state/FragmentComponent;", "()V", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/app/QBaseActivity;", "getActivity", "()Lcom/tencent/mobileqq/app/QBaseActivity;", "fragment", "Lcom/tencent/state/VasBaseFragment;", "getFragment", "()Lcom/tencent/state/VasBaseFragment;", "setFragment", "(Lcom/tencent/state/VasBaseFragment;)V", HippyNestedScrollComponent.PRIORITY_PARENT, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/state/VasBaseFragmentComponentGroup;", "getParent", "()Ljava/lang/ref/WeakReference;", "setParent", "(Ljava/lang/ref/WeakReference;)V", "parentFragment", "getParentFragment", "setParentFragment", "tag", "", "getTag", "()Ljava/lang/Object;", "setTag", "(Ljava/lang/Object;)V", "forEachComponent", "", "T", "block", "Lkotlin/Function1;", "forEachComponentInGroup", "forEachComponentWithTag", "getComponent", "(Ljava/lang/Object;)Lcom/tencent/state/FragmentComponent;", "getParentComponent", "()Lcom/tencent/state/FragmentComponent;", "getParentGroupFragment", "Lcom/tencent/state/VasBaseGroupFragment;", "initialize", "Landroidx/fragment/app/Fragment;", "onFragmentDestroyed", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class VasBaseFragmentComponent implements FragmentComponent {
    private VasBaseFragment fragment;
    private WeakReference<VasBaseFragmentComponentGroup> parent;
    private VasBaseFragment parentFragment;
    private Object tag;

    /* JADX INFO: Access modifiers changed from: protected */
    public final /* synthetic */ <T extends FragmentComponent> void forEachComponent(Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        VasBaseFragment vasBaseFragment = this.fragment;
        if (vasBaseFragment != null) {
            Intrinsics.reifiedOperationMarker(4, "T");
            vasBaseFragment.forEachComponent(FragmentComponent.class, null, null, block);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final /* synthetic */ <T extends FragmentComponent> void forEachComponentInGroup(Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        VasBaseFragment vasBaseFragment = this.fragment;
        if (vasBaseFragment != null) {
            Intrinsics.reifiedOperationMarker(4, "T");
            WeakReference<VasBaseFragmentComponentGroup> parent = getParent();
            vasBaseFragment.forEachComponent(FragmentComponent.class, parent != null ? parent.get() : null, null, block);
        }
    }

    protected final /* synthetic */ <T extends FragmentComponent> void forEachComponentWithTag(Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        VasBaseFragment vasBaseFragment = this.fragment;
        if (vasBaseFragment != null) {
            Intrinsics.reifiedOperationMarker(4, "T");
            vasBaseFragment.forEachComponent(FragmentComponent.class, null, getTag(), block);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final QBaseActivity getActivity() {
        VasBaseFragment vasBaseFragment = this.fragment;
        FragmentActivity activity = vasBaseFragment != null ? vasBaseFragment.getActivity() : null;
        return (QBaseActivity) (activity instanceof QBaseActivity ? activity : null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final /* synthetic */ <T extends FragmentComponent> T getComponent(Object tag) {
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if (vasBaseFragmentComponentGroup2 != null) {
            Intrinsics.reifiedOperationMarker(4, "T");
            T t16 = (T) vasBaseFragmentComponentGroup2.getComponent(FragmentComponent.class, tag);
            if (t16 != null) {
                return t16;
            }
        }
        WeakReference<VasBaseFragmentComponentGroup> parent = getParent();
        if (parent != null && (vasBaseFragmentComponentGroup = parent.get()) != null) {
            Intrinsics.reifiedOperationMarker(4, "T");
            T t17 = (T) vasBaseFragmentComponentGroup.getComponent(FragmentComponent.class, tag);
            if (t17 != null) {
                return t17;
            }
        }
        VasBaseFragment vasBaseFragment = this.fragment;
        if (vasBaseFragment != null) {
            Intrinsics.reifiedOperationMarker(4, "T");
            T t18 = (T) VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, FragmentComponent.class, null, tag, 2, null);
            if (t18 != null) {
                return t18;
            }
        }
        VasBaseFragment vasBaseFragment2 = this.parentFragment;
        if (vasBaseFragment2 == null) {
            return null;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, FragmentComponent.class, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final VasBaseFragment getFragment() {
        return this.fragment;
    }

    public final WeakReference<VasBaseFragmentComponentGroup> getParent() {
        return this.parent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final /* synthetic */ <T extends FragmentComponent> T getParentComponent() {
        VasBaseFragment vasBaseFragment = this.parentFragment;
        if (vasBaseFragment == null) {
            return null;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, FragmentComponent.class, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final VasBaseFragment getParentFragment() {
        return this.parentFragment;
    }

    public final VasBaseGroupFragment getParentGroupFragment() {
        VasBaseFragment vasBaseFragment = this.parentFragment;
        if (!(vasBaseFragment instanceof VasBaseGroupFragment)) {
            vasBaseFragment = null;
        }
        return (VasBaseGroupFragment) vasBaseFragment;
    }

    public Object getTag() {
        return this.tag;
    }

    public void initialize(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (!(fragment instanceof VasBaseFragment)) {
            fragment = null;
        }
        VasBaseFragment vasBaseFragment = (VasBaseFragment) fragment;
        this.fragment = vasBaseFragment;
        Fragment parentFragment = vasBaseFragment != null ? vasBaseFragment.getParentFragment() : null;
        this.parentFragment = (VasBaseFragment) (parentFragment instanceof VasBaseFragment ? parentFragment : null);
    }

    @Override // com.tencent.state.FragmentComponent
    public boolean onBackPressed(FragmentManager fragmentManager, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        return FragmentComponent.DefaultImpls.onBackPressed(this, fragmentManager, f16);
    }

    @Override // com.tencent.state.FragmentComponent
    public void onFragmentActivityCreated(FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(f16, "f");
        FragmentComponent.DefaultImpls.onFragmentActivityCreated(this, fragmentManager, f16, bundle);
    }

    @Override // com.tencent.state.FragmentComponent
    public void onFragmentCreated(FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(f16, "f");
        FragmentComponent.DefaultImpls.onFragmentCreated(this, fragmentManager, f16, bundle);
    }

    @Override // com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        FragmentComponent.DefaultImpls.onFragmentDestroyed(this, fm5, f16);
        this.fragment = null;
        this.parentFragment = null;
    }

    @Override // com.tencent.state.FragmentComponent
    public void onFragmentPaused(FragmentManager fragmentManager, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        FragmentComponent.DefaultImpls.onFragmentPaused(this, fragmentManager, f16);
    }

    @Override // com.tencent.state.FragmentComponent
    public void onFragmentPreCreated(FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(f16, "f");
        FragmentComponent.DefaultImpls.onFragmentPreCreated(this, fragmentManager, f16, bundle);
    }

    @Override // com.tencent.state.FragmentComponent
    public void onFragmentResumed(FragmentManager fragmentManager, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        FragmentComponent.DefaultImpls.onFragmentResumed(this, fragmentManager, f16);
    }

    @Override // com.tencent.state.FragmentComponent
    public void onFragmentSaveInstanceState(FragmentManager fragmentManager, Fragment f16, Bundle outState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(outState, "outState");
        FragmentComponent.DefaultImpls.onFragmentSaveInstanceState(this, fragmentManager, f16, outState);
    }

    @Override // com.tencent.state.FragmentComponent
    public void onFragmentStarted(FragmentManager fragmentManager, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        FragmentComponent.DefaultImpls.onFragmentStarted(this, fragmentManager, f16);
    }

    @Override // com.tencent.state.FragmentComponent
    public void onFragmentStopped(FragmentManager fragmentManager, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        FragmentComponent.DefaultImpls.onFragmentStopped(this, fragmentManager, f16);
    }

    @Override // com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment f16, View v3, Bundle bundle) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        FragmentComponent.DefaultImpls.onFragmentViewCreated(this, fragmentManager, f16, v3, bundle);
    }

    @Override // com.tencent.state.FragmentComponent
    public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        FragmentComponent.DefaultImpls.onFragmentViewDestroyed(this, fragmentManager, f16);
    }

    @Override // com.tencent.state.FragmentComponent
    public void onFragmentVisibilityChanged(FragmentManager fragmentManager, Fragment f16, boolean z16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        FragmentComponent.DefaultImpls.onFragmentVisibilityChanged(this, fragmentManager, f16, z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setFragment(VasBaseFragment vasBaseFragment) {
        this.fragment = vasBaseFragment;
    }

    public final void setParent(WeakReference<VasBaseFragmentComponentGroup> weakReference) {
        this.parent = weakReference;
    }

    protected final void setParentFragment(VasBaseFragment vasBaseFragment) {
        this.parentFragment = vasBaseFragment;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public static /* synthetic */ FragmentComponent getComponent$default(VasBaseFragmentComponent vasBaseFragmentComponent, Object obj, int i3, Object obj2) {
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        if (obj2 == null) {
            Object obj3 = (i3 & 1) != 0 ? null : obj;
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(vasBaseFragmentComponent instanceof VasBaseFragmentComponentGroup) ? null : vasBaseFragmentComponent);
            if (vasBaseFragmentComponentGroup2 != null) {
                Intrinsics.reifiedOperationMarker(4, "T");
                FragmentComponent component = vasBaseFragmentComponentGroup2.getComponent(FragmentComponent.class, obj3);
                if (component != null) {
                    return component;
                }
            }
            WeakReference<VasBaseFragmentComponentGroup> parent = vasBaseFragmentComponent.getParent();
            if (parent != null && (vasBaseFragmentComponentGroup = parent.get()) != null) {
                Intrinsics.reifiedOperationMarker(4, "T");
                FragmentComponent component2 = vasBaseFragmentComponentGroup.getComponent(FragmentComponent.class, obj3);
                if (component2 != null) {
                    return component2;
                }
            }
            VasBaseFragment vasBaseFragment = vasBaseFragmentComponent.fragment;
            if (vasBaseFragment != null) {
                Intrinsics.reifiedOperationMarker(4, "T");
                FragmentComponent component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, FragmentComponent.class, null, obj3, 2, null);
                if (component$default != null) {
                    return component$default;
                }
            }
            VasBaseFragment vasBaseFragment2 = vasBaseFragmentComponent.parentFragment;
            if (vasBaseFragment2 == null) {
                return null;
            }
            Intrinsics.reifiedOperationMarker(4, "T");
            return VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, FragmentComponent.class, null, null, 6, null);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getComponent");
    }
}
