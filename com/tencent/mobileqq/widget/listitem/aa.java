package com.tencent.mobileqq.widget.listitem;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ1\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/aa;", "", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "on", "", "block", "Lcom/tencent/mobileqq/widget/listitem/aa$a;", "c", "<init>", "()V", "a", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class aa {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final aa f316999a = new aa();

    aa() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(WeakReference blockRef, AccessibilityManager accessibilityManager, boolean z16) {
        boolean z17;
        Intrinsics.checkNotNullParameter(blockRef, "$blockRef");
        Function1 function1 = (Function1) blockRef.get();
        if (function1 != null) {
            if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
                z17 = true;
            } else {
                z17 = false;
            }
            function1.invoke(Boolean.valueOf(z17));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(WeakReference blockRef, AccessibilityManager accessibilityManager, boolean z16) {
        boolean z17;
        Intrinsics.checkNotNullParameter(blockRef, "$blockRef");
        Function1 function1 = (Function1) blockRef.get();
        if (function1 != null) {
            if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
                z17 = true;
            } else {
                z17 = false;
            }
            function1.invoke(Boolean.valueOf(z17));
        }
    }

    @NotNull
    public final a c(@NotNull Context context, @NotNull Function1<? super Boolean, Unit> block) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        final AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager == null) {
            block.invoke(Boolean.TRUE);
            return new a(null, null, null, null, 15, null);
        }
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            z16 = true;
        } else {
            z16 = false;
        }
        block.invoke(Boolean.valueOf(z16));
        final WeakReference weakReference = new WeakReference(block);
        AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener = new AccessibilityManager.AccessibilityStateChangeListener() { // from class: com.tencent.mobileqq.widget.listitem.y
            @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
            public final void onAccessibilityStateChanged(boolean z17) {
                aa.d(weakReference, accessibilityManager, z17);
            }
        };
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: com.tencent.mobileqq.widget.listitem.z
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z17) {
                aa.e(weakReference, accessibilityManager, z17);
            }
        };
        accessibilityManager.addAccessibilityStateChangeListener(accessibilityStateChangeListener);
        accessibilityManager.addTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        return new a(accessibilityManager, accessibilityStateChangeListener, touchExplorationStateChangeListener, block);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BT\b\u0000\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012%\b\u0002\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR3\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/aa$a;", "", "", "a", "Landroid/view/accessibility/AccessibilityManager;", "Landroid/view/accessibility/AccessibilityManager;", "manager", "Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "b", "Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "listener1", "Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;", "c", "Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;", "listener2", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "on", "d", "Lkotlin/jvm/functions/Function1;", "block", "<init>", "(Landroid/view/accessibility/AccessibilityManager;Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;Lkotlin/jvm/functions/Function1;)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final AccessibilityManager manager;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final AccessibilityManager.AccessibilityStateChangeListener listener1;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final AccessibilityManager.TouchExplorationStateChangeListener listener2;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Function1<? super Boolean, Unit> block;

        public a(@Nullable AccessibilityManager accessibilityManager, @Nullable AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener, @Nullable AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener, @Nullable Function1<? super Boolean, Unit> function1) {
            this.manager = accessibilityManager;
            this.listener1 = accessibilityStateChangeListener;
            this.listener2 = touchExplorationStateChangeListener;
            this.block = function1;
        }

        public final void a() {
            AccessibilityManager accessibilityManager;
            AccessibilityManager accessibilityManager2;
            this.block = null;
            AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener = this.listener1;
            if (accessibilityStateChangeListener != null && (accessibilityManager2 = this.manager) != null) {
                accessibilityManager2.removeAccessibilityStateChangeListener(accessibilityStateChangeListener);
            }
            AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.listener2;
            if (touchExplorationStateChangeListener != null && (accessibilityManager = this.manager) != null) {
                accessibilityManager.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
            }
        }

        public /* synthetic */ a(AccessibilityManager accessibilityManager, AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener, AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : accessibilityManager, (i3 & 2) != 0 ? null : accessibilityStateChangeListener, (i3 & 4) != 0 ? null : touchExplorationStateChangeListener, (i3 & 8) != 0 ? null : function1);
        }
    }
}
