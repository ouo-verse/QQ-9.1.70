package com.tencent.state;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.update.HippyQQConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0001J2\u0010\r\u001a\u00020\u000b\"\b\b\u0000\u0010\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u00020\u000b0\u0013J<\u0010\r\u001a\u00020\u000b\"\b\b\u0000\u0010\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u00020\u000b0\u0013J1\u0010\u0016\u001a\u0004\u0018\u0001H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J$\u0010 \u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J$\u0010#\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010$\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J\u001a\u0010%\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J$\u0010&\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010'\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J\"\u0010(\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\"H\u0016J\u001a\u0010*\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J\u001a\u0010+\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J,\u0010,\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020.2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010/\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J\"\u00100\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001cH\u0016R+\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0004j\b\u0012\u0004\u0012\u00020\u0001`\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u00a8\u00062"}, d2 = {"Lcom/tencent/state/VasBaseFragmentComponentGroup;", "Lcom/tencent/state/VasBaseFragmentComponent;", "()V", Node.CHILDREN_ATTR, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getChildren", "()Ljava/util/ArrayList;", "children$delegate", "Lkotlin/Lazy;", "addComponent", "", HippyQQConstants.URL_COMPONENT_NAME, "forEachComponent", "T", "Lcom/tencent/state/FragmentComponent;", "clazz", "Ljava/lang/Class;", "block", "Lkotlin/Function1;", "tag", "", "getComponent", "(Ljava/lang/Class;Ljava/lang/Object;)Lcom/tencent/state/FragmentComponent;", "initialize", "fragment", "Landroidx/fragment/app/Fragment;", "onBackPressed", "", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "onFragmentActivityCreated", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onFragmentCreated", "onFragmentDestroyed", "onFragmentPaused", "onFragmentPreCreated", "onFragmentResumed", "onFragmentSaveInstanceState", "outState", "onFragmentStarted", "onFragmentStopped", "onFragmentViewCreated", "v", "Landroid/view/View;", "onFragmentViewDestroyed", "onFragmentVisibilityChanged", "isVisible", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public class VasBaseFragmentComponentGroup extends VasBaseFragmentComponent {

    /* renamed from: children$delegate, reason: from kotlin metadata */
    private final Lazy children;

    public VasBaseFragmentComponentGroup() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ArrayList<VasBaseFragmentComponent>>() { // from class: com.tencent.state.VasBaseFragmentComponentGroup$children$2
            @Override // kotlin.jvm.functions.Function0
            public final ArrayList<VasBaseFragmentComponent> invoke() {
                List emptyList;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return new ArrayList<>(emptyList);
            }
        });
        this.children = lazy;
    }

    private final ArrayList<VasBaseFragmentComponent> getChildren() {
        return (ArrayList) this.children.getValue();
    }

    public final void addComponent(VasBaseFragmentComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        getChildren().add(component);
        component.setParent(new WeakReference<>(this));
    }

    public final <T extends FragmentComponent> void forEachComponent(Class<T> clazz, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(block, "block");
        for (VasBaseFragmentComponent vasBaseFragmentComponent : getChildren()) {
            if (clazz.isAssignableFrom(vasBaseFragmentComponent.getClass())) {
                block.invoke(vasBaseFragmentComponent);
            }
        }
    }

    public final <T extends FragmentComponent> T getComponent(Class<T> clazz, Object tag) {
        Object obj;
        boolean isAssignableFrom;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        T t16;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        WeakReference<VasBaseFragmentComponentGroup> parent = getParent();
        if (parent != null && (vasBaseFragmentComponentGroup = parent.get()) != null && (t16 = (T) getComponent$default(vasBaseFragmentComponentGroup, clazz, null, 2, null)) != null) {
            return t16;
        }
        Iterator<T> it = getChildren().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            VasBaseFragmentComponent vasBaseFragmentComponent = (VasBaseFragmentComponent) obj;
            if (tag != null) {
                isAssignableFrom = Intrinsics.areEqual(vasBaseFragmentComponent.getTag(), tag) && clazz.isAssignableFrom(vasBaseFragmentComponent.getClass());
            } else {
                isAssignableFrom = clazz.isAssignableFrom(vasBaseFragmentComponent.getClass());
            }
            if (isAssignableFrom) {
                break;
            }
        }
        return (T) (obj instanceof FragmentComponent ? obj : null);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent
    public void initialize(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        super.initialize(fragment);
        Iterator<T> it = getChildren().iterator();
        while (it.hasNext()) {
            ((VasBaseFragmentComponent) it.next()).initialize(fragment);
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public boolean onBackPressed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Iterator<T> it = getChildren().iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            if (((VasBaseFragmentComponent) it.next()).onBackPressed(fm5, f16)) {
                z16 = true;
            }
        }
        return z16;
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentActivityCreated(FragmentManager fm5, Fragment f16, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Iterator<T> it = getChildren().iterator();
        while (it.hasNext()) {
            ((VasBaseFragmentComponent) it.next()).onFragmentActivityCreated(fm5, f16, savedInstanceState);
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentCreated(FragmentManager fm5, Fragment f16, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Iterator<T> it = getChildren().iterator();
        while (it.hasNext()) {
            ((VasBaseFragmentComponent) it.next()).onFragmentCreated(fm5, f16, savedInstanceState);
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Iterator<T> it = getChildren().iterator();
        while (it.hasNext()) {
            ((VasBaseFragmentComponent) it.next()).onFragmentDestroyed(fm5, f16);
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentPaused(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Iterator<T> it = getChildren().iterator();
        while (it.hasNext()) {
            ((VasBaseFragmentComponent) it.next()).onFragmentPaused(fm5, f16);
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentPreCreated(FragmentManager fm5, Fragment f16, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Iterator<T> it = getChildren().iterator();
        while (it.hasNext()) {
            ((VasBaseFragmentComponent) it.next()).onFragmentPreCreated(fm5, f16, savedInstanceState);
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentResumed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Iterator<T> it = getChildren().iterator();
        while (it.hasNext()) {
            ((VasBaseFragmentComponent) it.next()).onFragmentResumed(fm5, f16);
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentSaveInstanceState(FragmentManager fm5, Fragment f16, Bundle outState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(outState, "outState");
        Iterator<T> it = getChildren().iterator();
        while (it.hasNext()) {
            ((VasBaseFragmentComponent) it.next()).onFragmentSaveInstanceState(fm5, f16, outState);
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentStarted(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Iterator<T> it = getChildren().iterator();
        while (it.hasNext()) {
            ((VasBaseFragmentComponent) it.next()).onFragmentStarted(fm5, f16);
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentStopped(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Iterator<T> it = getChildren().iterator();
        while (it.hasNext()) {
            ((VasBaseFragmentComponent) it.next()).onFragmentStopped(fm5, f16);
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        Iterator<T> it = getChildren().iterator();
        while (it.hasNext()) {
            ((VasBaseFragmentComponent) it.next()).onFragmentViewCreated(fm5, f16, v3, savedInstanceState);
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Iterator<T> it = getChildren().iterator();
        while (it.hasNext()) {
            ((VasBaseFragmentComponent) it.next()).onFragmentViewDestroyed(fm5, f16);
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentVisibilityChanged(FragmentManager fm5, Fragment f16, boolean isVisible) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Iterator<T> it = getChildren().iterator();
        while (it.hasNext()) {
            ((VasBaseFragmentComponent) it.next()).onFragmentVisibilityChanged(fm5, f16, isVisible);
        }
    }

    public final <T extends FragmentComponent> void forEachComponent(Class<T> clazz, Object tag, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(block, "block");
        for (VasBaseFragmentComponent vasBaseFragmentComponent : getChildren()) {
            if (clazz.isAssignableFrom(vasBaseFragmentComponent.getClass()) && (tag == null || !(!Intrinsics.areEqual(vasBaseFragmentComponent.getTag(), tag)))) {
                block.invoke(vasBaseFragmentComponent);
            }
        }
    }

    public static /* synthetic */ FragmentComponent getComponent$default(VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup, Class cls, Object obj, int i3, Object obj2) {
        if (obj2 == null) {
            if ((i3 & 2) != 0) {
                obj = null;
            }
            return vasBaseFragmentComponentGroup.getComponent(cls, obj);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getComponent");
    }
}
