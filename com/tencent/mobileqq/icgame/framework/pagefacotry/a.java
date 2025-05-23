package com.tencent.mobileqq.icgame.framework.pagefacotry;

import android.text.TextUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.framework.component.d;
import com.tencent.mobileqq.icgame.framework.component.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import g32.g;
import g32.h;
import g32.j;
import g32.l;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004:\u00021\nBI\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010,\u001a\u00020#\u0012\u0006\u0010\u0007\u001a\u00020\u001c\u0012\u0018\b\u0002\u0010.\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0018\u00010-\u0012\b\b\u0002\u0010\"\u001a\u00020 \u00a2\u0006\u0004\b/\u00100J)\u0010\n\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\bH\u0096\u0001J\"\u0010\u000e\u001a\u00020\r\"\b\b\u0001\u0010\u000b*\u00020\u00062\u0006\u0010\f\u001a\u00028\u0001H\u0096\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\rJ\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\r\u0010\u0016\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0007\u001a\u00020\u001c8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0002\u0010'R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/pagefacotry/a;", "Lcom/tencent/mobileqq/icgame/framework/component/e;", BdhLogUtil.LogTag.Tag_Conn, "Lg32/g;", "Lg32/h;", "Ljava/lang/Class;", "Lg32/b;", "key", "Lg32/j;", "listener", "b", "E", "event", "", "w0", "(Lg32/b;)V", "c", "f", "g", "Lcom/tencent/mobileqq/icgame/framework/component/d;", "", "e", "d", "()Lcom/tencent/mobileqq/icgame/framework/component/e;", "Ljava/lang/Class;", "getComponentClazz$ic_game_base_impl_release", "()Ljava/lang/Class;", "componentClazz", "", "Ljava/lang/String;", "getKey$ic_game_base_impl_release", "()Ljava/lang/String;", "Lg32/c;", "Lg32/c;", "eventBroadcaster", "Lf32/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lf32/a;", "selfComponentContext", "Lcom/tencent/mobileqq/icgame/framework/component/e;", "componentImpl", "D", "Lcom/tencent/mobileqq/icgame/framework/component/d;", "connectableComponent", "rootComponentContext", "", "eventList", "<init>", "(Ljava/lang/Class;Lf32/a;Ljava/lang/String;Ljava/util/List;Lg32/c;)V", "a", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a<C extends e> implements g, h {

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
    private final g32.c eventBroadcaster;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ C7925a f237370h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ b<C> f237371i;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f32.a selfComponentContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0007\u001a\u00020\u00012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005H\u0096\u0001\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/pagefacotry/a$a;", "Lg32/g;", "Ljava/lang/Class;", "Lg32/b;", "key", "Lg32/j;", "listener", "b", "Lg32/c;", "eventBroadcaster", "<init>", "(Lg32/c;)V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.icgame.framework.pagefacotry.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static final class C7925a implements g {

        /* renamed from: d, reason: collision with root package name */
        private final /* synthetic */ g32.c f237373d;

        public C7925a(@NotNull g32.c eventBroadcaster) {
            Intrinsics.checkNotNullParameter(eventBroadcaster, "eventBroadcaster");
            this.f237373d = eventBroadcaster;
        }

        @Override // g32.g
        @NotNull
        public g b(@NotNull Class<? extends g32.b> key, @NotNull j<? extends g32.b> listener) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(listener, "listener");
            return this.f237373d.b(key, listener);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\u00020\u0003B+\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J!\u0010\b\u001a\u00020\u0007\"\b\b\u0002\u0010\u0005*\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/pagefacotry/a$b;", "Lcom/tencent/mobileqq/icgame/framework/component/e;", BdhLogUtil.LogTag.Tag_Conn, "Lg32/h;", "Lg32/b;", "E", "event", "", "w0", "(Lg32/b;)V", "Lg32/c;", "d", "Lg32/c;", "eventBroadcaster", "", "e", "Ljava/lang/String;", "key", "Ljava/lang/Class;", "f", "Ljava/lang/Class;", "clazz", "<init>", "(Lg32/c;Ljava/lang/String;Ljava/lang/Class;)V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b<C extends e> implements h {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final g32.c eventBroadcaster;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String key;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Class<C> clazz;

        public b(@NotNull g32.c eventBroadcaster, @NotNull String key, @Nullable Class<C> cls) {
            Intrinsics.checkNotNullParameter(eventBroadcaster, "eventBroadcaster");
            Intrinsics.checkNotNullParameter(key, "key");
            this.eventBroadcaster = eventBroadcaster;
            this.key = key;
            this.clazz = cls;
        }

        @Override // g32.h
        public <E extends g32.b> void w0(@NotNull E event) {
            Intrinsics.checkNotNullParameter(event, "event");
            Class<C> cls = this.clazz;
            if (cls == null || TextUtils.isEmpty(this.key)) {
                return;
            }
            if (event.getTag() == null) {
                event.b(new l(this.key, cls));
            }
            this.eventBroadcaster.w0(event);
        }
    }

    public a(@NotNull Class<C> componentClazz, @NotNull f32.a rootComponentContext, @NotNull String key, @Nullable List<? extends Class<? extends g32.b>> list, @NotNull g32.c eventBroadcaster) {
        Intrinsics.checkNotNullParameter(componentClazz, "componentClazz");
        Intrinsics.checkNotNullParameter(rootComponentContext, "rootComponentContext");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(eventBroadcaster, "eventBroadcaster");
        this.componentClazz = componentClazz;
        this.key = key;
        this.eventBroadcaster = eventBroadcaster;
        this.f237370h = new C7925a(eventBroadcaster);
        this.f237371i = new b<>(eventBroadcaster, key, componentClazz);
        this.connectableComponent = new d(null, this);
        this.selfComponentContext = new com.tencent.mobileqq.icgame.framework.component.c(rootComponentContext, this, key);
    }

    @Override // g32.g
    @NotNull
    public g b(@NotNull Class<? extends g32.b> key, @NotNull j<? extends g32.b> listener) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.f237370h.b(key, listener);
    }

    public final void c() {
        C c16 = (C) ComponentFactory.f237355a.a(this.componentClazz, this.selfComponentContext);
        this.componentImpl = c16;
        d dVar = this.connectableComponent;
        Intrinsics.checkNotNull(c16);
        dVar.c(c16);
        f32.a aVar = this.selfComponentContext;
        if (aVar instanceof com.tencent.mobileqq.icgame.framework.component.c) {
            C c17 = this.componentImpl;
            Intrinsics.checkNotNull(c17);
            ((com.tencent.mobileqq.icgame.framework.component.c) aVar).a(c17);
        }
    }

    @NotNull
    public final C d() {
        C c16 = this.componentImpl;
        Intrinsics.checkNotNull(c16);
        return c16;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final d getConnectableComponent() {
        return this.connectableComponent;
    }

    public final void f() {
        C c16 = this.componentImpl;
        Intrinsics.checkNotNull(c16);
        c16.k();
    }

    public final void g() {
        C c16 = this.componentImpl;
        Intrinsics.checkNotNull(c16);
        c16.i();
    }

    @Override // g32.h
    public <E extends g32.b> void w0(@NotNull E event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f237371i.w0(event);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ a(Class cls, f32.a aVar, String str, List list, g32.c cVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(cls, aVar, str, r4, (i3 & 16) != 0 ? new g32.c(str, r4) : cVar);
        List list2 = (i3 & 8) != 0 ? null : list;
    }
}
