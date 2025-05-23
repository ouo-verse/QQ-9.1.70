package com.tencent.aio.runtime.permission;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import tl.h;
import ts.d;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001\u000bB\u0017\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010+\u001a\u00020\r\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001b\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0013\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001dR+\u0010$\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030!0 0\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u0014\u001a\u0004\b\u0019\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010+\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006/"}, d2 = {"Lcom/tencent/aio/runtime/permission/AIOPermissionRequester;", "Lts/d;", "Landroidx/lifecycle/LifecycleEventObserver;", "", "c", "", QCircleDaTongConstant.ElementParamValue.PERMISSION, "Landroidx/activity/result/ActivityResultCallback;", "", "callback", "", "a", "checkSelfPermission", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "onStateChanged", "Landroidx/activity/result/ActivityResultRegistry;", "d", "Lkotlin/Lazy;", "f", "()Landroidx/activity/result/ActivityResultRegistry;", "registry", "Landroidx/activity/result/contract/ActivityResultContracts$RequestPermission;", "e", "()Landroidx/activity/result/contract/ActivityResultContracts$RequestPermission;", "contract", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "nextLocalRequestCode", "", "Ljava/lang/ref/WeakReference;", "Landroidx/activity/result/ActivityResultLauncher;", h.F, "()Ljava/util/List;", "launchers", "Landroidx/fragment/app/Fragment;", "i", "Landroidx/fragment/app/Fragment;", "fragment", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "<init>", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/LifecycleOwner;)V", BdhLogUtil.LogTag.Tag_Conn, "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class AIOPermissionRequester implements d, LifecycleEventObserver {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a C;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy registry;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy contract;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final AtomicInteger nextLocalRequestCode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy launchers;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Fragment fragment;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LifecycleOwner lifecycleOwner;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/runtime/permission/AIOPermissionRequester$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53565);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            C = new a(null);
        }
    }

    public AIOPermissionRequester(@NotNull Fragment fragment, @NotNull LifecycleOwner lifecycleOwner) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) fragment, (Object) lifecycleOwner);
            return;
        }
        this.fragment = fragment;
        this.lifecycleOwner = lifecycleOwner;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ActivityResultRegistry>() { // from class: com.tencent.aio.runtime.permission.AIOPermissionRequester$registry$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) AIOPermissionRequester.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ActivityResultRegistry invoke() {
                Fragment fragment2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return (ActivityResultRegistry) iPatchRedirector2.redirect((short) 1, (Object) this);
                }
                fragment2 = AIOPermissionRequester.this.fragment;
                FragmentActivity requireActivity = fragment2.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
                return requireActivity.getActivityResultRegistry();
            }
        });
        this.registry = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOPermissionRequester$contract$2.INSTANCE);
        this.contract = lazy2;
        this.nextLocalRequestCode = new AtomicInteger();
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOPermissionRequester$launchers$2.INSTANCE);
        this.launchers = lazy3;
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    private final int c() {
        return this.nextLocalRequestCode.getAndIncrement();
    }

    private final ActivityResultContracts.RequestPermission d() {
        return (ActivityResultContracts.RequestPermission) this.contract.getValue();
    }

    private final List<WeakReference<ActivityResultLauncher<?>>> e() {
        return (List) this.launchers.getValue();
    }

    private final ActivityResultRegistry f() {
        return (ActivityResultRegistry) this.registry.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [T, androidx.activity.result.ActivityResultLauncher] */
    @Override // ts.d
    public void a(@NotNull String permission, @NotNull ActivityResultCallback<Boolean> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) permission, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(callback, "callback");
        int c16 = c();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        String str = "AIOPermissionRequester" + c16;
        com.tencent.aio.base.log.a.f69187b.d("AIOPermissionRequester", "requestPermission " + str);
        ?? register = f().register(str, d(), new com.tencent.aio.runtime.launcher.a(callback, new Function0<Unit>() { // from class: com.tencent.aio.runtime.permission.AIOPermissionRequester$requestPermission$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) Ref.ObjectRef.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                    return;
                }
                ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher) Ref.ObjectRef.this.element;
                if (activityResultLauncher != null) {
                    activityResultLauncher.unregister();
                }
            }
        }));
        objectRef.element = register;
        register.launch(permission);
        e().add(new WeakReference<>((ActivityResultLauncher) objectRef.element));
    }

    @Override // ts.d
    public boolean checkSelfPermission(@NotNull String permission) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) permission)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(permission, "permission");
        if (ContextCompat.checkSelfPermission(this.fragment.requireContext(), permission) == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) source, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.lifecycleOwner.getLifecycle().removeObserver(this);
            Iterator<T> it = e().iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (com.tencent.aio.base.a.f69150c.a()) {
                    com.tencent.aio.base.log.a.f69187b.d("AIOPermissionRequester", "destroyUnregister " + ((ActivityResultLauncher) weakReference.get()) + TokenParser.SP);
                }
                ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher) weakReference.get();
                if (activityResultLauncher != null) {
                    activityResultLauncher.unregister();
                }
                weakReference.clear();
            }
        }
    }
}
