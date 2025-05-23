package com.tencent.state;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import java.util.Iterator;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\"\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\nJ\"\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/state/FragmentHelper;", "Landroidx/lifecycle/LifecycleEventObserver;", "groupFragment", "Lcom/tencent/state/VasBaseGroupFragment;", "containerId", "", "(Lcom/tencent/state/VasBaseGroupFragment;I)V", "current", "Landroidx/fragment/app/Fragment;", "enable", "", "fragmentStack", "Ljava/util/Stack;", "checkEnable", "getTopFragment", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "popFragment", "fragment", "showOthers", "withAnimation", "pushFragment", "hideOthers", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class FragmentHelper implements LifecycleEventObserver {
    private static final String TAG = "FragmentHelper";
    private final int containerId;
    private Fragment current;
    private boolean enable;
    private final Stack<Fragment> fragmentStack;
    private final VasBaseGroupFragment groupFragment;

    public FragmentHelper(VasBaseGroupFragment groupFragment, int i3) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(groupFragment, "groupFragment");
        this.groupFragment = groupFragment;
        this.containerId = i3;
        this.fragmentStack = new Stack<>();
        this.enable = true;
        FragmentActivity activity = groupFragment.getActivity();
        if (activity == null || (lifecycle = activity.getLifecycle()) == null) {
            return;
        }
        lifecycle.addObserver(this);
    }

    private final boolean checkEnable() {
        if (!this.enable) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "checkEnable false", null, 4, null);
        }
        return this.enable;
    }

    public final Fragment getTopFragment() {
        if (this.fragmentStack.isEmpty()) {
            return this.current;
        }
        return this.fragmentStack.peek();
    }

    public final void onDestroy() {
        Lifecycle lifecycle;
        FragmentActivity activity = this.groupFragment.getActivity();
        if (activity == null || (lifecycle = activity.getLifecycle()) == null) {
            return;
        }
        lifecycle.removeObserver(this);
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event != Lifecycle.Event.ON_RESUME && event != Lifecycle.Event.ON_START) {
            if (event == Lifecycle.Event.ON_STOP) {
                this.enable = false;
                return;
            }
            return;
        }
        this.enable = true;
    }

    public final void popFragment(Fragment fragment, boolean showOthers, boolean withAnimation) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        SquareBaseKt.getSquareLog().i(TAG, "popFragment, " + this.groupFragment.getClass().getSimpleName() + ", " + fragment.getClass().getSimpleName() + ", " + showOthers + ", " + withAnimation);
        if (checkEnable()) {
            FragmentTransaction beginTransaction = this.groupFragment.getChildFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "groupFragment.childFragm\u2026anager.beginTransaction()");
            if (withAnimation) {
                beginTransaction.setCustomAnimations(R.anim.f154354jb, R.anim.f154354jb);
            }
            beginTransaction.remove(fragment);
            if (showOthers) {
                try {
                    for (Fragment fragment2 : this.fragmentStack) {
                        if (!Intrinsics.areEqual(fragment2, fragment)) {
                            beginTransaction.show(fragment2);
                        }
                    }
                } catch (Throwable th5) {
                    SquareBaseKt.getSquareLog().e(TAG, "popFragment throw t:", th5);
                    return;
                }
            }
            beginTransaction.commitAllowingStateLoss();
            this.fragmentStack.remove(fragment);
        }
    }

    public final void pushFragment(Fragment fragment, boolean hideOthers, boolean withAnimation) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        SquareBaseKt.getSquareLog().i(TAG, "pushFragment, " + this.groupFragment.getClass().getSimpleName() + ", " + fragment.getClass().getSimpleName() + ", " + hideOthers + ", " + withAnimation);
        if (checkEnable()) {
            final FragmentTransaction beginTransaction = this.groupFragment.getChildFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "groupFragment.childFragm\u2026anager.beginTransaction()");
            if (withAnimation) {
                beginTransaction.setCustomAnimations(R.anim.f154353ja, R.anim.f154353ja);
            }
            beginTransaction.add(this.containerId, fragment);
            if (hideOthers) {
                SquareBaseKt.getSquareThread().postOnUiDelayed(300L, new Function0<Unit>() { // from class: com.tencent.state.FragmentHelper$pushFragment$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Stack stack;
                        stack = FragmentHelper.this.fragmentStack;
                        Iterator it = stack.iterator();
                        while (it.hasNext()) {
                            beginTransaction.hide((Fragment) it.next());
                        }
                    }
                });
            }
            try {
                beginTransaction.commitAllowingStateLoss();
                this.fragmentStack.push(fragment);
            } catch (Throwable th5) {
                SquareBaseKt.getSquareLog().e(TAG, "pushFragment commitAllowingStateLoss throw t:", th5);
            }
        }
    }

    public static /* synthetic */ void popFragment$default(FragmentHelper fragmentHelper, Fragment fragment, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        fragmentHelper.popFragment(fragment, z16, z17);
    }

    public static /* synthetic */ void pushFragment$default(FragmentHelper fragmentHelper, Fragment fragment, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        fragmentHelper.pushFragment(fragment, z16, z17);
    }
}
