package com.tencent.aio.runtime;

import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.dispatcher.HandlerPoster;
import com.tencent.aio.main.fragment.ChatFragment;
import com.tencent.aio.runtime.permission.AIOPermissionRequester;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.VMMessenger;
import com.tencent.mvi.base.route.j;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 22\u00020\u0001:\u0001\u0013B-\u0012\u0006\u00109\u001a\u000205\u0012\u0006\u0010<\u001a\u00020\b\u0012\u0006\u0010?\u001a\u00020\u0002\u0012\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\f0@\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\"\u0010\u001a\u001a\u00020\u00148\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001d\u001a\u00020\u00148@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\u0017R\u001d\u0010!\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001f\u0010 R\u001b\u0010%\u001a\u00020\"8@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b#\u0010$R\u001b\u0010)\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b'\u0010(R\u001b\u0010-\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b+\u0010,R\u001b\u00101\u001a\u00020.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b/\u00100R\u001b\u00104\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b2\u00103R\u001a\u00109\u001a\u0002058\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0011\u00106\u001a\u0004\b7\u00108R\u0014\u0010<\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010?\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\f0@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006F"}, d2 = {"Lcom/tencent/aio/runtime/AIOContextImpl;", "Lcom/tencent/aio/api/runtime/a;", "Landroidx/lifecycle/LifecycleOwner;", "d", "Lcom/tencent/mvi/base/route/j;", "e", "Lml3/b;", "b", "Lcom/tencent/aio/data/AIOParam;", "g", "Landroidx/fragment/app/Fragment;", "c", "Lts/a;", "f", "Lcom/tencent/aio/main/businesshelper/c;", h.F, "Lts/d;", "i", "Lcom/tencent/mvi/api/runtime/a;", "a", "", "Z", ReportConstant.COSTREPORT_PREFIX, "()Z", "v", "(Z)V", "messengerInit", "Lkotlin/Lazy;", "t", "optLiveData", "Lcom/tencent/aio/dispatcher/HandlerPoster;", "p", "()Lcom/tencent/aio/dispatcher/HandlerPoster;", "innerPoster", "Lcom/tencent/aio/runtime/dispatcher/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/aio/runtime/dispatcher/a;", "mBuildDispatcher", "Lcom/tencent/aio/runtime/emitter/a;", DomainData.DOMAIN_NAME, "()Lcom/tencent/aio/runtime/emitter/a;", "emitter", "Lcom/tencent/aio/runtime/permission/AIOPermissionRequester;", "u", "()Lcom/tencent/aio/runtime/permission/AIOPermissionRequester;", "permissionRequester", "Lcom/tencent/aio/runtime/b;", "r", "()Lcom/tencent/aio/runtime/b;", "messenger", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lts/a;", "activityLauncher", "Lcom/tencent/aio/main/fragment/ChatFragment;", "Lcom/tencent/aio/main/fragment/ChatFragment;", "o", "()Lcom/tencent/aio/main/fragment/ChatFragment;", "fragment", "j", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "k", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lkotlin/Function0;", "l", "Lkotlin/jvm/functions/Function0;", "buildLauncher", "<init>", "(Lcom/tencent/aio/main/fragment/ChatFragment;Lcom/tencent/aio/data/AIOParam;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class AIOContextImpl extends com.tencent.aio.api.runtime.a {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private volatile boolean messengerInit;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy optLiveData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy innerPoster;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mBuildDispatcher;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy emitter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy permissionRequester;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Lazy messenger;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy activityLauncher;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ChatFragment fragment;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final AIOParam aioParam;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final Function0<ts.a> buildLauncher;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/runtime/AIOContextImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.runtime.AIOContextImpl$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53512);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOContextImpl(@NotNull ChatFragment fragment, @NotNull AIOParam aioParam, @NotNull LifecycleOwner lifecycleOwner, @NotNull Function0<? extends ts.a> buildLauncher) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(buildLauncher, "buildLauncher");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, fragment, aioParam, lifecycleOwner, buildLauncher);
            return;
        }
        this.fragment = fragment;
        this.aioParam = aioParam;
        this.lifecycleOwner = lifecycleOwner;
        this.buildLauncher = buildLauncher;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<Boolean>() { // from class: com.tencent.aio.runtime.AIOContextImpl$optLiveData$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) AIOContextImpl.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                AIOParam aIOParam;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 1, (Object) this)).booleanValue();
                }
                aIOParam = AIOContextImpl.this.aioParam;
                return ft.a.e(aIOParam);
            }
        });
        this.optLiveData = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<HandlerPoster>() { // from class: com.tencent.aio.runtime.AIOContextImpl$innerPoster$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) AIOContextImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final HandlerPoster invoke() {
                AIOParam aIOParam;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return (HandlerPoster) iPatchRedirector2.redirect((short) 1, (Object) this);
                }
                aIOParam = AIOContextImpl.this.aioParam;
                boolean g16 = ft.a.g(aIOParam);
                com.tencent.aio.base.log.a.f69187b.d("AIOContextImpl", "optUseDispatcher " + g16);
                if (g16) {
                    return new HandlerPoster(Looper.getMainLooper(), 50);
                }
                return null;
            }
        });
        this.innerPoster = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOContextImpl$mBuildDispatcher$2.INSTANCE);
        this.mBuildDispatcher = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(AIOContextImpl$emitter$2.INSTANCE);
        this.emitter = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<AIOPermissionRequester>() { // from class: com.tencent.aio.runtime.AIOContextImpl$permissionRequester$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) AIOContextImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIOPermissionRequester invoke() {
                LifecycleOwner lifecycleOwner2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return (AIOPermissionRequester) iPatchRedirector2.redirect((short) 1, (Object) this);
                }
                ChatFragment o16 = AIOContextImpl.this.o();
                lifecycleOwner2 = AIOContextImpl.this.lifecycleOwner;
                return new AIOPermissionRequester(o16, lifecycleOwner2);
            }
        });
        this.permissionRequester = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.aio.runtime.AIOContextImpl$messenger$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) AIOContextImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final b invoke() {
                AIOParam aIOParam;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return (b) iPatchRedirector2.redirect((short) 1, (Object) this);
                }
                AIOContextImpl.this.v(true);
                aIOParam = AIOContextImpl.this.aioParam;
                boolean c16 = ft.a.c(aIOParam);
                com.tencent.aio.base.log.a.f69187b.d("AIOContextImpl", "messengerToggle open " + c16);
                return new b(new VMMessenger(c16, AIOContextImpl.this));
            }
        });
        this.messenger = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ts.a>() { // from class: com.tencent.aio.runtime.AIOContextImpl$activityLauncher$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) AIOContextImpl.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ts.a invoke() {
                Function0 function0;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return (ts.a) iPatchRedirector2.redirect((short) 1, (Object) this);
                }
                function0 = AIOContextImpl.this.buildLauncher;
                return (ts.a) function0.invoke();
            }
        });
        this.activityLauncher = lazy7;
    }

    private final ts.a m() {
        return (ts.a) this.activityLauncher.getValue();
    }

    private final com.tencent.aio.runtime.emitter.a n() {
        return (com.tencent.aio.runtime.emitter.a) this.emitter.getValue();
    }

    private final HandlerPoster p() {
        return (HandlerPoster) this.innerPoster.getValue();
    }

    private final b r() {
        return (b) this.messenger.getValue();
    }

    private final AIOPermissionRequester u() {
        return (AIOPermissionRequester) this.permissionRequester.getValue();
    }

    @Override // com.tencent.mvi.api.runtime.b
    @Nullable
    public com.tencent.mvi.api.runtime.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (com.tencent.mvi.api.runtime.a) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return p();
    }

    @Override // com.tencent.mvi.api.runtime.b
    @NotNull
    public ml3.b b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ml3.b) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return n();
    }

    @Override // com.tencent.mvi.api.runtime.b
    @NotNull
    public Fragment c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Fragment) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.fragment;
    }

    @Override // com.tencent.mvi.api.runtime.b
    @NotNull
    public LifecycleOwner d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LifecycleOwner) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.lifecycleOwner;
    }

    @Override // com.tencent.mvi.api.runtime.b
    @NotNull
    public j e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (j) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return r();
    }

    @Override // com.tencent.aio.api.runtime.a
    @NotNull
    public ts.a f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ts.a) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return m();
    }

    @Override // com.tencent.aio.api.runtime.a
    @NotNull
    public AIOParam g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (AIOParam) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.aioParam;
    }

    @Override // com.tencent.aio.api.runtime.a
    @Nullable
    public com.tencent.aio.main.businesshelper.c h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.aio.main.businesshelper.c) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        ChatFragment chatFragment = this.fragment;
        if (!(chatFragment instanceof ChatFragment)) {
            chatFragment = null;
        }
        if (chatFragment == null) {
            return null;
        }
        return chatFragment.getFirstScreenHelper$sdk_debug();
    }

    @Override // com.tencent.aio.api.runtime.a
    @NotNull
    public ts.d i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (ts.d) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return u();
    }

    @NotNull
    public final ChatFragment o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ChatFragment) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.fragment;
    }

    @NotNull
    public final com.tencent.aio.runtime.dispatcher.a q() {
        Object value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            value = iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            value = this.mBuildDispatcher.getValue();
        }
        return (com.tencent.aio.runtime.dispatcher.a) value;
    }

    public final boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
        }
        return this.messengerInit;
    }

    public final boolean t() {
        Object value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            value = iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            value = this.optLiveData.getValue();
        }
        return ((Boolean) value).booleanValue();
    }

    public final void v(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.messengerInit = z16;
        }
    }
}
