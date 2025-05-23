package com.tencent.mobileqq.qqlive.framework.pagefacotry;

import android.text.TextUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.framework.component.d;
import com.tencent.mobileqq.qqlive.framework.component.e;
import com.tencent.mobileqq.qqlive.framework.eventbroadcaster.g;
import com.tencent.mobileqq.qqlive.framework.eventbroadcaster.h;
import com.tencent.mobileqq.qqlive.framework.eventbroadcaster.j;
import com.tencent.mobileqq.qqlive.framework.eventbroadcaster.l;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004:\u00021\nBI\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010,\u001a\u00020#\u0012\u0006\u0010\u0007\u001a\u00020\u001c\u0012\u0018\b\u0002\u0010.\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0018\u00010-\u0012\b\b\u0002\u0010\"\u001a\u00020 \u00a2\u0006\u0004\b/\u00100J)\u0010\n\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\bH\u0096\u0001J\"\u0010\u000e\u001a\u00020\r\"\b\b\u0001\u0010\u000b*\u00020\u00062\u0006\u0010\f\u001a\u00028\u0001H\u0096\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\rJ\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\r\u0010\u0016\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0007\u001a\u00020\u001c8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0002\u0010'R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/pagefacotry/a;", "Lcom/tencent/mobileqq/qqlive/framework/component/e;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/g;", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/h;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/b;", "key", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/j;", "listener", "b", "E", "event", "", "C0", "(Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/b;)V", "c", "f", "g", "Lcom/tencent/mobileqq/qqlive/framework/component/d;", "", "e", "d", "()Lcom/tencent/mobileqq/qqlive/framework/component/e;", "Ljava/lang/Class;", "getComponentClazz$qq_live_base_impl_release", "()Ljava/lang/Class;", "componentClazz", "", "Ljava/lang/String;", "getKey$qq_live_base_impl_release", "()Ljava/lang/String;", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/c;", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/c;", "eventBroadcaster", "Lfi2/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lfi2/a;", "selfComponentContext", "Lcom/tencent/mobileqq/qqlive/framework/component/e;", "componentImpl", "D", "Lcom/tencent/mobileqq/qqlive/framework/component/d;", "connectableComponent", "rootComponentContext", "", "eventList", "<init>", "(Ljava/lang/Class;Lfi2/a;Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/c;)V", "a", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a<C extends e> implements g, h {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private C componentImpl;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final d connectableComponent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Class<C> componentClazz;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String key;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.framework.eventbroadcaster.c eventBroadcaster;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ C8365a f271322h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ b<C> f271323i;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final fi2.a selfComponentContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0007\u001a\u00020\u00012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005H\u0096\u0001\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/pagefacotry/a$a;", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/g;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/b;", "key", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/j;", "listener", "b", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/c;", "eventBroadcaster", "<init>", "(Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/c;)V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.framework.pagefacotry.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static final class C8365a implements g {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final /* synthetic */ com.tencent.mobileqq.qqlive.framework.eventbroadcaster.c f271325d;

        public C8365a(@NotNull com.tencent.mobileqq.qqlive.framework.eventbroadcaster.c eventBroadcaster) {
            Intrinsics.checkNotNullParameter(eventBroadcaster, "eventBroadcaster");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) eventBroadcaster);
            } else {
                this.f271325d = eventBroadcaster;
            }
        }

        @Override // com.tencent.mobileqq.qqlive.framework.eventbroadcaster.g
        @NotNull
        public g b(@NotNull Class<? extends com.tencent.mobileqq.qqlive.framework.eventbroadcaster.b> key, @NotNull j<? extends com.tencent.mobileqq.qqlive.framework.eventbroadcaster.b> listener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (g) iPatchRedirector.redirect((short) 4, (Object) this, (Object) key, (Object) listener);
            }
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(listener, "listener");
            return this.f271325d.b(key, listener);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\u00020\u0003B+\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J!\u0010\b\u001a\u00020\u0007\"\b\b\u0002\u0010\u0005*\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/pagefacotry/a$b;", "Lcom/tencent/mobileqq/qqlive/framework/component/e;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/h;", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/b;", "E", "event", "", "C0", "(Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/b;)V", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/c;", "d", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/c;", "eventBroadcaster", "", "e", "Ljava/lang/String;", "key", "Ljava/lang/Class;", "f", "Ljava/lang/Class;", "clazz", "<init>", "(Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/c;Ljava/lang/String;Ljava/lang/Class;)V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b<C extends e> implements h {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.qqlive.framework.eventbroadcaster.c eventBroadcaster;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String key;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Class<C> clazz;

        public b(@NotNull com.tencent.mobileqq.qqlive.framework.eventbroadcaster.c eventBroadcaster, @NotNull String key, @Nullable Class<C> cls) {
            Intrinsics.checkNotNullParameter(eventBroadcaster, "eventBroadcaster");
            Intrinsics.checkNotNullParameter(key, "key");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, eventBroadcaster, key, cls);
                return;
            }
            this.eventBroadcaster = eventBroadcaster;
            this.key = key;
            this.clazz = cls;
        }

        @Override // com.tencent.mobileqq.qqlive.framework.eventbroadcaster.h
        public <E extends com.tencent.mobileqq.qqlive.framework.eventbroadcaster.b> void C0(@NotNull E event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) event);
                return;
            }
            Intrinsics.checkNotNullParameter(event, "event");
            Class<C> cls = this.clazz;
            if (cls == null || TextUtils.isEmpty(this.key)) {
                return;
            }
            if (event.a() == null) {
                event.b(new l(this.key, cls));
            }
            this.eventBroadcaster.C0(event);
        }
    }

    public a(@NotNull Class<C> componentClazz, @NotNull fi2.a rootComponentContext, @NotNull String key, @Nullable List<? extends Class<? extends com.tencent.mobileqq.qqlive.framework.eventbroadcaster.b>> list, @NotNull com.tencent.mobileqq.qqlive.framework.eventbroadcaster.c eventBroadcaster) {
        Intrinsics.checkNotNullParameter(componentClazz, "componentClazz");
        Intrinsics.checkNotNullParameter(rootComponentContext, "rootComponentContext");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(eventBroadcaster, "eventBroadcaster");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, componentClazz, rootComponentContext, key, list, eventBroadcaster);
            return;
        }
        this.componentClazz = componentClazz;
        this.key = key;
        this.eventBroadcaster = eventBroadcaster;
        this.f271322h = new C8365a(eventBroadcaster);
        this.f271323i = new b<>(eventBroadcaster, key, componentClazz);
        this.connectableComponent = new d(null, this);
        this.selfComponentContext = new com.tencent.mobileqq.qqlive.framework.component.c(rootComponentContext, this, key);
    }

    @Override // com.tencent.mobileqq.qqlive.framework.eventbroadcaster.h
    public <E extends com.tencent.mobileqq.qqlive.framework.eventbroadcaster.b> void C0(@NotNull E event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) event);
        } else {
            Intrinsics.checkNotNullParameter(event, "event");
            this.f271323i.C0(event);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.framework.eventbroadcaster.g
    @NotNull
    public g b(@NotNull Class<? extends com.tencent.mobileqq.qqlive.framework.eventbroadcaster.b> key, @NotNull j<? extends com.tencent.mobileqq.qqlive.framework.eventbroadcaster.b> listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (g) iPatchRedirector.redirect((short) 7, (Object) this, (Object) key, (Object) listener);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.f271322h.b(key, listener);
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        C c16 = (C) ComponentFactory.f271308a.a(this.componentClazz, this.selfComponentContext);
        this.componentImpl = c16;
        d dVar = this.connectableComponent;
        Intrinsics.checkNotNull(c16);
        dVar.c(c16);
        fi2.a aVar = this.selfComponentContext;
        if (aVar instanceof com.tencent.mobileqq.qqlive.framework.component.c) {
            C c17 = this.componentImpl;
            Intrinsics.checkNotNull(c17);
            ((com.tencent.mobileqq.qqlive.framework.component.c) aVar).a(c17);
        }
    }

    @NotNull
    public final C d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (C) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        C c16 = this.componentImpl;
        Intrinsics.checkNotNull(c16);
        return c16;
    }

    @NotNull
    public final d e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (d) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.connectableComponent;
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        C c16 = this.componentImpl;
        Intrinsics.checkNotNull(c16);
        c16.k();
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        C c16 = this.componentImpl;
        Intrinsics.checkNotNull(c16);
        c16.i();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ a(Class cls, fi2.a aVar, String str, List list, com.tencent.mobileqq.qqlive.framework.eventbroadcaster.c cVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(cls, aVar, str, r5, (i3 & 16) != 0 ? new com.tencent.mobileqq.qqlive.framework.eventbroadcaster.c(str, r5) : cVar);
        List list2 = (i3 & 8) != 0 ? null : list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, cls, aVar, str, list, cVar, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
