package com.tencent.mobileqq.wink.utils;

import androidx.lifecycle.Lifecycle;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/WinkOnceLifecycleScope;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "equalToLifecycleEvent", "", "lifecycleEvent", "Landroidx/lifecycle/Lifecycle$Event;", "getLifecycleEvent", "ScopeOnCreate", "ScopeOnStart", "ScopeOnResume", "ScopeOnPause", "ScopeOnStop", "ScopeOnDestroy", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public enum WinkOnceLifecycleScope {
    ScopeOnCreate(1),
    ScopeOnStart(2),
    ScopeOnResume(3),
    ScopeOnPause(4),
    ScopeOnStop(5),
    ScopeOnDestroy(6);

    private final int value;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f326647a;

        static {
            int[] iArr = new int[WinkOnceLifecycleScope.values().length];
            try {
                iArr[WinkOnceLifecycleScope.ScopeOnCreate.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WinkOnceLifecycleScope.ScopeOnStart.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WinkOnceLifecycleScope.ScopeOnResume.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WinkOnceLifecycleScope.ScopeOnPause.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[WinkOnceLifecycleScope.ScopeOnStop.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[WinkOnceLifecycleScope.ScopeOnDestroy.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f326647a = iArr;
        }
    }

    WinkOnceLifecycleScope(int i3) {
        this.value = i3;
    }

    public final boolean equalToLifecycleEvent(@NotNull Lifecycle.Event lifecycleEvent) {
        Intrinsics.checkNotNullParameter(lifecycleEvent, "lifecycleEvent");
        if (getLifecycleEvent() == lifecycleEvent) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Lifecycle.Event getLifecycleEvent() {
        switch (a.f326647a[ordinal()]) {
            case 1:
                return Lifecycle.Event.ON_CREATE;
            case 2:
                return Lifecycle.Event.ON_START;
            case 3:
                return Lifecycle.Event.ON_RESUME;
            case 4:
                return Lifecycle.Event.ON_PAUSE;
            case 5:
                return Lifecycle.Event.ON_STOP;
            case 6:
                return Lifecycle.Event.ON_DESTROY;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final int getValue() {
        return this.value;
    }
}
