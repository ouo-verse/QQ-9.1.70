package com.tencent.state;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J$\u0010\r\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J$\u0010\u0011\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0012\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\u0013\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J$\u0010\u0014\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0015\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\u0016\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u001a\u0010\u0018\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\u0019\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J,\u0010\u001a\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u001d\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\u001e\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\bH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006 "}, d2 = {"Lcom/tencent/state/FragmentComponentDispatcher;", "Lcom/tencent/state/FragmentComponent;", "components", "", "(Ljava/util/List;)V", "getComponents", "()Ljava/util/List;", "onBackPressed", "", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "onFragmentActivityCreated", "", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onFragmentCreated", "onFragmentDestroyed", "onFragmentPaused", "onFragmentPreCreated", "onFragmentResumed", "onFragmentSaveInstanceState", "outState", "onFragmentStarted", "onFragmentStopped", "onFragmentViewCreated", "v", "Landroid/view/View;", "onFragmentViewDestroyed", "onFragmentVisibilityChanged", "isVisible", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class FragmentComponentDispatcher implements FragmentComponent {
    private final List<FragmentComponent> components;

    /* JADX WARN: Multi-variable type inference failed */
    public FragmentComponentDispatcher(List<? extends FragmentComponent> components) {
        Intrinsics.checkNotNullParameter(components, "components");
        this.components = components;
    }

    public final List<FragmentComponent> getComponents() {
        return this.components;
    }

    @Override // com.tencent.state.FragmentComponent
    public boolean onBackPressed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Iterator<T> it = this.components.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            if (((FragmentComponent) it.next()).onBackPressed(fm5, f16)) {
                z16 = true;
            }
        }
        return z16;
    }

    @Override // com.tencent.state.FragmentComponent
    public void onFragmentActivityCreated(FragmentManager fm5, Fragment f16, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Iterator<T> it = this.components.iterator();
        while (it.hasNext()) {
            ((FragmentComponent) it.next()).onFragmentActivityCreated(fm5, f16, savedInstanceState);
        }
    }

    @Override // com.tencent.state.FragmentComponent
    public void onFragmentCreated(FragmentManager fm5, Fragment f16, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Iterator<T> it = this.components.iterator();
        while (it.hasNext()) {
            ((FragmentComponent) it.next()).onFragmentCreated(fm5, f16, savedInstanceState);
        }
    }

    @Override // com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Iterator<T> it = this.components.iterator();
        while (it.hasNext()) {
            ((FragmentComponent) it.next()).onFragmentDestroyed(fm5, f16);
        }
    }

    @Override // com.tencent.state.FragmentComponent
    public void onFragmentPaused(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Iterator<T> it = this.components.iterator();
        while (it.hasNext()) {
            ((FragmentComponent) it.next()).onFragmentPaused(fm5, f16);
        }
    }

    @Override // com.tencent.state.FragmentComponent
    public void onFragmentPreCreated(FragmentManager fm5, Fragment f16, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Iterator<T> it = this.components.iterator();
        while (it.hasNext()) {
            ((FragmentComponent) it.next()).onFragmentPreCreated(fm5, f16, savedInstanceState);
        }
    }

    @Override // com.tencent.state.FragmentComponent
    public void onFragmentResumed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Iterator<T> it = this.components.iterator();
        while (it.hasNext()) {
            ((FragmentComponent) it.next()).onFragmentResumed(fm5, f16);
        }
    }

    @Override // com.tencent.state.FragmentComponent
    public void onFragmentSaveInstanceState(FragmentManager fm5, Fragment f16, Bundle outState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(outState, "outState");
        Iterator<T> it = this.components.iterator();
        while (it.hasNext()) {
            ((FragmentComponent) it.next()).onFragmentSaveInstanceState(fm5, f16, outState);
        }
    }

    @Override // com.tencent.state.FragmentComponent
    public void onFragmentStarted(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Iterator<T> it = this.components.iterator();
        while (it.hasNext()) {
            ((FragmentComponent) it.next()).onFragmentStarted(fm5, f16);
        }
    }

    @Override // com.tencent.state.FragmentComponent
    public void onFragmentStopped(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Iterator<T> it = this.components.iterator();
        while (it.hasNext()) {
            ((FragmentComponent) it.next()).onFragmentStopped(fm5, f16);
        }
    }

    @Override // com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        Iterator<T> it = this.components.iterator();
        while (it.hasNext()) {
            ((FragmentComponent) it.next()).onFragmentViewCreated(fm5, f16, v3, savedInstanceState);
        }
    }

    @Override // com.tencent.state.FragmentComponent
    public void onFragmentViewDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Iterator<T> it = this.components.iterator();
        while (it.hasNext()) {
            ((FragmentComponent) it.next()).onFragmentViewDestroyed(fm5, f16);
        }
    }

    @Override // com.tencent.state.FragmentComponent
    public void onFragmentVisibilityChanged(FragmentManager fm5, Fragment f16, boolean isVisible) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Iterator<T> it = this.components.iterator();
        while (it.hasNext()) {
            ((FragmentComponent) it.next()).onFragmentVisibilityChanged(fm5, f16, isVisible);
        }
    }
}
