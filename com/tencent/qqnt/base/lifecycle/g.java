package com.tencent.qqnt.base.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001\u0005B\u001f\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010\u0016\u001a\u00020\u0001\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\u0006\u0010\u0007\u001a\u00020\u0004J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u0014\u0010\u0016\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006("}, d2 = {"Lcom/tencent/qqnt/base/lifecycle/g;", "Landroidx/lifecycle/LifecycleRegistry;", "Landroidx/lifecycle/LifecycleObserver;", "observer", "", "a", "c", "b", "addObserver", "removeObserver", "Landroidx/lifecycle/Lifecycle$State;", "getCurrentState", "state", "markState", "setCurrentState", "Landroidx/lifecycle/Lifecycle$Event;", "event", "handleLifecycleEvent", "", "getObserverCount", "f", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "Lcom/tencent/qqnt/base/lifecycle/LifecycleDispatcher;", "g", "Lcom/tencent/qqnt/base/lifecycle/LifecycleDispatcher;", "dispatcher", "Lcom/tencent/mobileqq/inject/b;", h.F, "Lcom/tencent/mobileqq/inject/b;", "getSAppSetting", "()Lcom/tencent/mobileqq/inject/b;", "setSAppSetting", "(Lcom/tencent/mobileqq/inject/b;)V", "sAppSetting", "Landroidx/lifecycle/LifecycleOwner;", "owner", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/LifecycleRegistry;Lcom/tencent/qqnt/base/lifecycle/LifecycleDispatcher;)V", "i", "ntui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class g extends LifecycleRegistry {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: j, reason: collision with root package name */
    private static ArrayList f353037j;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleRegistry lifecycleRegistry;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleDispatcher dispatcher;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Service/QQNTUI/Inject_AppSetting.yml", version = 1)
    @Nullable
    private com.tencent.mobileqq.inject.b sAppSetting;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/base/lifecycle/g$a;", "", "", "ILLEGAL_OBSERVER_MSG", "Ljava/lang/String;", "SYSTEM_ANDROID_PREFIX", "TAG", "<init>", "()V", "ntui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.base.lifecycle.g$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40745);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f353037j = arrayList;
        arrayList.add(com.tencent.mobileqq.injector.d.class);
        INSTANCE = new Companion(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull LifecycleOwner owner, @NotNull LifecycleRegistry lifecycleRegistry, @NotNull LifecycleDispatcher dispatcher) {
        super(owner);
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(lifecycleRegistry, "lifecycleRegistry");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, owner, lifecycleRegistry, dispatcher);
        } else {
            this.lifecycleRegistry = lifecycleRegistry;
            this.dispatcher = dispatcher;
        }
    }

    private final void a(LifecycleObserver observer) {
        boolean startsWith$default;
        String clsName = observer.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(clsName, "clsName");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(clsName, "androidx.", false, 2, null);
        QLog.d("LifecycleManager", 1, "checkSystemObserver: " + clsName + ", isSystemObserver: " + startsWith$default);
        b();
        com.tencent.mobileqq.inject.b bVar = this.sAppSetting;
        Intrinsics.checkNotNull(bVar);
        bVar.isDebugVersion();
    }

    @Override // androidx.lifecycle.LifecycleRegistry, androidx.lifecycle.Lifecycle
    public void addObserver(@NotNull LifecycleObserver observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) observer);
            return;
        }
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!(observer instanceof b)) {
            a(observer);
            this.lifecycleRegistry.addObserver(observer);
        } else {
            this.dispatcher.b((b) observer);
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (this.sAppSetting == null) {
            c();
        }
    }

    @QAutoInitMethod
    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.sAppSetting = (com.tencent.mobileqq.inject.b) com.tencent.mobileqq.qroute.utils.b.a(f353037j);
        }
    }

    @Override // androidx.lifecycle.LifecycleRegistry, androidx.lifecycle.Lifecycle
    @NotNull
    public Lifecycle.State getCurrentState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Lifecycle.State) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        Lifecycle.State currentState = this.lifecycleRegistry.getCurrentState();
        Intrinsics.checkNotNullExpressionValue(currentState, "lifecycleRegistry.currentState");
        return currentState;
    }

    @Override // androidx.lifecycle.LifecycleRegistry
    public int getObserverCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.lifecycleRegistry.getObserverCount() + this.dispatcher.f();
    }

    @Override // androidx.lifecycle.LifecycleRegistry
    public void handleLifecycleEvent(@NotNull Lifecycle.Event event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) event);
        } else {
            Intrinsics.checkNotNullParameter(event, "event");
            this.lifecycleRegistry.handleLifecycleEvent(event);
        }
    }

    @Override // androidx.lifecycle.LifecycleRegistry
    public void markState(@NotNull Lifecycle.State state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) state);
        } else {
            Intrinsics.checkNotNullParameter(state, "state");
            this.lifecycleRegistry.markState(state);
        }
    }

    @Override // androidx.lifecycle.LifecycleRegistry, androidx.lifecycle.Lifecycle
    public void removeObserver(@NotNull LifecycleObserver observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) observer);
            return;
        }
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (observer instanceof b) {
            this.dispatcher.h((b) observer);
        }
        this.lifecycleRegistry.removeObserver(observer);
    }

    @Override // androidx.lifecycle.LifecycleRegistry
    public void setCurrentState(@NotNull Lifecycle.State state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) state);
        } else {
            Intrinsics.checkNotNullParameter(state, "state");
            this.lifecycleRegistry.setCurrentState(state);
        }
    }
}
