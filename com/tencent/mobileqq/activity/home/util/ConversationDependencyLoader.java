package com.tencent.mobileqq.activity.home.util;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.EventPerfTrace;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00032\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0002R)\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t0\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR)\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t0\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/activity/home/util/ConversationDependencyLoader;", "", "", "f", "", "name", DomainData.DOMAIN_NAME, "l", "", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "a", "Lkotlin/Lazy;", "k", "()Ljava/util/List;", "routeApiList", "b", "j", "classList", "c", "Ljava/util/List;", "classNameList", "Lcom/tencent/mobileqq/activity/home/util/f;", "d", "Lcom/tencent/mobileqq/activity/home/util/f;", "taskDispatcher", "Lcom/tencent/util/EventPerfTrace;", "e", "Lcom/tencent/util/EventPerfTrace;", "trace", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class ConversationDependencyLoader {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy routeApiList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy classList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> classNameList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f taskDispatcher;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final EventPerfTrace trace;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/home/util/ConversationDependencyLoader$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.home.util.ConversationDependencyLoader$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51669);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ConversationDependencyLoader() {
        Lazy lazy;
        Lazy lazy2;
        List<String> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(ConversationDependencyLoader$routeApiList$2.INSTANCE);
            this.routeApiList = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(ConversationDependencyLoader$classList$2.INSTANCE);
            this.classList = lazy2;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"com.tencent.mobileqq.security.SecControllerInjectImpl", "com.tencent.mobileqq.activity.NotificationActivity", "com.tencent.biz.richframework.part.TagData", "com.tencent.mobileqq.minigame.splash.SplashMiniGameStarter", "com.tencent.mobileqq.app.identity.AccountPhoneUnityManager", "com.tencent.mobileqq.loginwelcome.LoginWelcomeManager", "com.tencent.mobileqq.app.identity.AccountIdentityManager"});
            this.classNameList = listOf;
            this.taskDispatcher = new f();
            EventPerfTrace eventPerfTrace = new EventPerfTrace("ConversationDependencyLoader", false, 2, null);
            this.trace = eventPerfTrace;
            eventPerfTrace.addEvent("init");
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void f() {
        for (final Class<? extends QRouteApi> cls : k()) {
            this.taskDispatcher.b(new Runnable() { // from class: com.tencent.mobileqq.activity.home.util.b
                @Override // java.lang.Runnable
                public final void run() {
                    ConversationDependencyLoader.g(cls);
                }
            });
        }
        this.taskDispatcher.b(new Runnable() { // from class: com.tencent.mobileqq.activity.home.util.c
            @Override // java.lang.Runnable
            public final void run() {
                ConversationDependencyLoader.h(ConversationDependencyLoader.this);
            }
        });
        for (final String str : this.classNameList) {
            this.taskDispatcher.b(new Runnable() { // from class: com.tencent.mobileqq.activity.home.util.d
                @Override // java.lang.Runnable
                public final void run() {
                    ConversationDependencyLoader.i(ConversationDependencyLoader.this, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Class c16) {
        Intrinsics.checkNotNullParameter(c16, "$c");
        QRoute.api(c16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ConversationDependencyLoader this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.trace.addEvent("handle class list begin");
        Iterator<Class<? extends Object>> it = this$0.j().iterator();
        while (it.hasNext()) {
            it.next().getClass();
        }
        this$0.trace.addEvent("handle class list end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ConversationDependencyLoader this$0, String c16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(c16, "$c");
        this$0.n(c16);
    }

    private final List<Class<? extends Object>> j() {
        return (List) this.classList.getValue();
    }

    private final List<Class<? extends QRouteApi>> k() {
        return (List) this.routeApiList.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(final ConversationDependencyLoader this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.trace.addEvent("prepare");
        this$0.f();
        this$0.trace.addEvent(TencentLocation.RUN_MODE);
        this$0.taskDispatcher.c(4, new Function0<Unit>() { // from class: com.tencent.mobileqq.activity.home.util.ConversationDependencyLoader$load$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConversationDependencyLoader.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                EventPerfTrace eventPerfTrace;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    eventPerfTrace = ConversationDependencyLoader.this.trace;
                    eventPerfTrace.finish();
                }
            }
        });
    }

    private final void n(String name) {
        try {
            Class.forName(name);
        } catch (Exception e16) {
            QLog.w("SplashActivity", 1, "[loadClass] name=" + name + " exc=" + e16);
        }
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.home.util.a
                @Override // java.lang.Runnable
                public final void run() {
                    ConversationDependencyLoader.m(ConversationDependencyLoader.this);
                }
            }, 16, null, false);
            this.trace.addEvent("load");
        }
    }
}
