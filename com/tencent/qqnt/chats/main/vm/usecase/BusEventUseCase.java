package com.tencent.qqnt.chats.main.vm.usecase;

import android.content.Context;
import androidx.annotation.UiThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.chats.core.adapter.itemdata.payload.j;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u000bH\u0003J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000fH\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0019R4\u0010\u001f\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u001c0\u001bj\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u001c`\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001e\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/BusEventUseCase;", "Lzv3/c;", "Lcom/tencent/qqnt/bus/event/a;", "event", "", "f", "Lcom/tencent/qqnt/bus/event/e;", "g", "Lcom/tencent/qqnt/bus/event/g;", "ev", "e", "Lcom/tencent/qqnt/bus/event/c;", "c", h.F, "i", "Lzv3/a;", "B5", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "d", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "recentContactRepo", "", "Z", "isReigster", "Lcom/tencent/qqnt/bus/api/IBusManager;", "Lcom/tencent/qqnt/bus/api/IBusManager;", "busManager", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "eventList", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;)V", "a", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class BusEventUseCase implements zv3.c {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IRecentContactRepo recentContactRepo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isReigster;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IBusManager busManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Class<? extends zv3.a>> eventList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/BusEventUseCase$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.vm.usecase.BusEventUseCase$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46210);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public BusEventUseCase(@NotNull Context context, @NotNull IRecentContactRepo recentContactRepo) {
        ArrayList<Class<? extends zv3.a>> arrayListOf;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(recentContactRepo, "recentContactRepo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) recentContactRepo);
            return;
        }
        this.recentContactRepo = recentContactRepo;
        QRouteApi api = QRoute.api(IBusManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IBusManager::class.java)");
        this.busManager = (IBusManager) api;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(com.tencent.qqnt.bus.event.g.class, com.tencent.qqnt.bus.event.e.class, com.tencent.qqnt.bus.event.a.class, com.tencent.qqnt.bus.event.c.class);
        this.eventList = arrayListOf;
    }

    @UiThread
    private final void c(final com.tencent.qqnt.bus.event.c ev5) {
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar;
        Object obj;
        boolean z16;
        List<com.tencent.qqnt.chats.core.adapter.itemdata.g> d16 = this.recentContactRepo.d();
        if (d16 != null) {
            Iterator<T> it = d16.iterator();
            while (true) {
                gVar = null;
                if (it.hasNext()) {
                    obj = it.next();
                    com.tencent.qqnt.chats.core.adapter.itemdata.g gVar2 = (com.tencent.qqnt.chats.core.adapter.itemdata.g) obj;
                    if (Intrinsics.areEqual(gVar2.k(), ev5.c()) && ev5.a() == gVar2.n()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            com.tencent.qqnt.chats.core.adapter.itemdata.g gVar3 = (com.tencent.qqnt.chats.core.adapter.itemdata.g) obj;
            if (gVar3 != null) {
                if (!gVar3.H() || ev5.b()) {
                    gVar = gVar3;
                }
                if (gVar != null) {
                    this.recentContactRepo.n(gVar.s(), new IOperateCallback() { // from class: com.tencent.qqnt.chats.main.vm.usecase.a
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                        public final void onResult(int i3, String str) {
                            BusEventUseCase.d(com.tencent.qqnt.bus.event.c.this, i3, str);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(com.tencent.qqnt.bus.event.c ev5, int i3, String str) {
        Intrinsics.checkNotNullParameter(ev5, "$ev");
        QLog.d("Chats-BusEventUseCase", 4, "handleDelItemEvent: uid=" + ev5.c() + ", chatType=" + ev5.a() + ", res=" + i3 + ", msg=" + str);
    }

    private final void e(final com.tencent.qqnt.bus.event.g ev5) {
        if (!QLog.isDebugVersion()) {
            return;
        }
        QLog.d("Chats-BusEventUseCase", 4, "handleDemoUpdateEvent: uid=" + ev5.b() + ", chatType=" + ev5.a());
        final Object[] objArr = {j.f354601a};
        this.recentContactRepo.l(new Function1<com.tencent.qqnt.chats.core.adapter.itemdata.g, Boolean>() { // from class: com.tencent.qqnt.chats.main.vm.usecase.BusEventUseCase$handleDemoUpdateEvent$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.bus.event.g.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                }
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(Intrinsics.areEqual(it.k(), com.tencent.qqnt.bus.event.g.this.b()) && com.tencent.qqnt.bus.event.g.this.a() == it.n());
            }
        }, new Function1<com.tencent.qqnt.chats.core.adapter.itemdata.g, Object[]>(objArr) { // from class: com.tencent.qqnt.chats.main.vm.usecase.BusEventUseCase$handleDemoUpdateEvent$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Object[] $payload;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$payload = objArr;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) objArr);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Object[] invoke(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Object[]) iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                }
                Intrinsics.checkNotNullParameter(it, "it");
                return this.$payload;
            }
        });
    }

    private final void f(final com.tencent.qqnt.bus.event.a event) {
        if (!event.b().isEmpty()) {
            this.recentContactRepo.l(new Function1<com.tencent.qqnt.chats.core.adapter.itemdata.g, Boolean>() { // from class: com.tencent.qqnt.chats.main.vm.usecase.BusEventUseCase$handleRefreshAvatar$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.bus.event.a.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g it) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(com.tencent.qqnt.bus.event.a.this.b().contains(Long.valueOf(it.l())));
                }
            }, BusEventUseCase$handleRefreshAvatar$2.INSTANCE);
        } else if (event.a() != 0) {
            this.recentContactRepo.l(new Function1<com.tencent.qqnt.chats.core.adapter.itemdata.g, Boolean>() { // from class: com.tencent.qqnt.chats.main.vm.usecase.BusEventUseCase$handleRefreshAvatar$3
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.bus.event.a.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g it) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(com.tencent.qqnt.bus.event.a.this.a() == it.l());
                }
            }, BusEventUseCase$handleRefreshAvatar$4.INSTANCE);
        }
    }

    private final void g(final com.tencent.qqnt.bus.event.e event) {
        com.tencent.qqnt.chats.utils.h.f355549a.e("Chats-BusEventUseCase-handleRefreshEvent", true, new Function0<Unit>(event) { // from class: com.tencent.qqnt.chats.main.vm.usecase.BusEventUseCase$handleRefreshEvent$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.qqnt.bus.event.e $event;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$event = event;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) BusEventUseCase.this, (Object) event);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IRecentContactRepo iRecentContactRepo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                iRecentContactRepo = BusEventUseCase.this.recentContactRepo;
                iRecentContactRepo.l(new Function1<com.tencent.qqnt.chats.core.adapter.itemdata.g, Boolean>(objectRef, this.$event) { // from class: com.tencent.qqnt.chats.main.vm.usecase.BusEventUseCase$handleRefreshEvent$1.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ com.tencent.qqnt.bus.event.e $event;
                    final /* synthetic */ Ref.ObjectRef<com.tencent.qqnt.bus.event.d> $tmp;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.$tmp = objectRef;
                        this.$event = r5;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) objectRef, (Object) r5);
                        }
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
                    
                        if (r5.a() != r9.n()) goto L18;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:17:0x004d, code lost:
                    
                        r5 = false;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:34:0x0068, code lost:
                    
                        if (r5.a() == r9.n()) goto L19;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:36:0x0076, code lost:
                    
                        if (kotlin.jvm.internal.Intrinsics.areEqual(r5.d(), r9.k()) != false) goto L19;
                     */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r2v1 */
                    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Boolean invoke(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
                        T t16;
                        boolean z16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) item);
                        }
                        Intrinsics.checkNotNullParameter(item, "item");
                        Ref.ObjectRef<com.tencent.qqnt.bus.event.d> objectRef2 = this.$tmp;
                        Iterator<T> it = this.$event.a().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                t16 = 0;
                                break;
                            }
                            t16 = it.next();
                            com.tencent.qqnt.bus.event.d dVar = (com.tencent.qqnt.bus.event.d) t16;
                            if (dVar.c()) {
                                if (dVar.a() != -1) {
                                }
                                z16 = true;
                            } else {
                                if (dVar.d().length() == 0) {
                                }
                            }
                            if (z16) {
                                break;
                            }
                        }
                        objectRef2.element = t16;
                        return Boolean.valueOf(this.$tmp.element != null);
                    }
                }, new Function1<com.tencent.qqnt.chats.core.adapter.itemdata.g, Object[]>(objectRef) { // from class: com.tencent.qqnt.chats.main.vm.usecase.BusEventUseCase$handleRefreshEvent$1.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Ref.ObjectRef<com.tencent.qqnt.bus.event.d> $tmp;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.$tmp = objectRef;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) objectRef);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final Object[] invoke(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g it) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            return (Object[]) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        }
                        Intrinsics.checkNotNullParameter(it, "it");
                        com.tencent.qqnt.bus.event.d dVar = this.$tmp.element;
                        if (dVar != null) {
                            return dVar.b();
                        }
                        return null;
                    }
                });
            }
        });
    }

    @Override // zv3.c
    public void B5(@NotNull zv3.a event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.isReigster) {
            return;
        }
        if (event instanceof com.tencent.qqnt.bus.event.g) {
            e((com.tencent.qqnt.bus.event.g) event);
            return;
        }
        if (event instanceof com.tencent.qqnt.bus.event.c) {
            c((com.tencent.qqnt.bus.event.c) event);
        } else if (event instanceof com.tencent.qqnt.bus.event.e) {
            g((com.tencent.qqnt.bus.event.e) event);
        } else if (event instanceof com.tencent.qqnt.bus.event.a) {
            f((com.tencent.qqnt.bus.event.a) event);
        }
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.isReigster = true;
        Iterator<T> it = this.eventList.iterator();
        while (it.hasNext()) {
            this.busManager.registerEvent((Class) it.next(), this);
        }
        QLog.d("Chats-BusEventUseCase", 1, "registerEvents: eventList=" + this.eventList);
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.isReigster = false;
        Iterator<T> it = this.eventList.iterator();
        while (it.hasNext()) {
            this.busManager.unRegisterEvent((Class) it.next(), this);
        }
        QLog.d("Chats-BusEventUseCase", 1, "unregisterEvents: eventList=" + this.eventList);
    }
}
