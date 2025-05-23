package com.tencent.mobileqq.icgame.framework.pagefacotry;

import android.text.TextUtils;
import com.tencent.mobileqq.icgame.framework.component.e;
import com.tencent.mobileqq.icgame.framework.exception.QQLiveException;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0019B5\b\u0002\u0012\u000e\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0012\u0006\u0010\"\u001a\u00020\u0005\u0012\u0006\u0010%\u001a\u00020#\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010&\u00a2\u0006\u0004\b5\u00106J0\u0010\t\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fJ\b\u0010\u000e\u001a\u0004\u0018\u00010\u0000J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0007J\"\u0010\u0013\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007J;\u0010\u0018\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00022!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\n0\u0014R\u001f\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\"\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010$R\u0016\u0010(\u001a\u0004\u0018\u00010&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001e\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010,R!\u00101\u001a\b\u0012\u0004\u0012\u00020\u00000.8@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010/\u001a\u0004\b)\u00100R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\u0007028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/pagefacotry/ComponentNode;", "", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/icgame/framework/component/e;", "child", "", "key", "Lo32/b;", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "j", "", "d", "Lcom/tencent/mobileqq/icgame/framework/pagefacotry/a;", "g", h.F, "switchConfig", "", "c", "Lcom/tencent/mobileqq/icgame/framework/component/h;", "l", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "invoke", "k", "a", "Ljava/lang/Class;", "i", "()Ljava/lang/Class;", "selfComponentClazz", "b", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "componentKey", "Lf32/a;", "Lf32/a;", "rootComponentContext", "Lcom/tencent/mobileqq/icgame/framework/page/manager/a;", "Lcom/tencent/mobileqq/icgame/framework/page/manager/a;", "componentRuntimeProvider", "e", "Lcom/tencent/mobileqq/icgame/framework/pagefacotry/ComponentNode;", "parentNode", "Lcom/tencent/mobileqq/icgame/framework/pagefacotry/a;", "componentRuntime", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Lazy;", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "childComponentList", "", "Ljava/util/List;", "componentNodeAddSwitchList", "<init>", "(Ljava/lang/Class;Ljava/lang/String;Lf32/a;Lcom/tencent/mobileqq/icgame/framework/page/manager/a;)V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ComponentNode {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Class<? extends e> selfComponentClazz;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String componentKey;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f32.a rootComponentContext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.mobileqq.icgame.framework.page.manager.a componentRuntimeProvider;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ComponentNode parentNode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private a<? extends e> componentRuntime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy childComponentList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<o32.b> componentNodeAddSwitchList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015Jh\u0010\u0013\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0018\b\u0002\u0010\r\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u0002\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/pagefacotry/ComponentNode$a;", "", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/icgame/framework/component/e;", "clazz", "", "key", "Lcom/tencent/mobileqq/icgame/framework/pagefacotry/ComponentNode;", "parentNode", "Lf32/a;", "rootComponentContext", "", "Lg32/b;", "eventList", "Lcom/tencent/mobileqq/icgame/framework/page/manager/a;", "componentRuntimeProvider", "", "Lo32/b;", "componentNodeAddSwitchList", "a", "<init>", "()V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.icgame.framework.pagefacotry.ComponentNode$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ComponentNode b(Companion companion, Class cls, String str, ComponentNode componentNode, f32.a aVar, List list, com.tencent.mobileqq.icgame.framework.page.manager.a aVar2, List list2, int i3, Object obj) {
            List list3;
            com.tencent.mobileqq.icgame.framework.page.manager.a aVar3;
            List list4;
            if ((i3 & 16) != 0) {
                list3 = null;
            } else {
                list3 = list;
            }
            if ((i3 & 32) != 0) {
                aVar3 = null;
            } else {
                aVar3 = aVar2;
            }
            if ((i3 & 64) != 0) {
                list4 = null;
            } else {
                list4 = list2;
            }
            return companion.a(cls, str, componentNode, aVar, list3, aVar3, list4);
        }

        @NotNull
        public final ComponentNode a(@NotNull Class<? extends e> clazz, @NotNull String key, @Nullable ComponentNode parentNode, @NotNull f32.a rootComponentContext, @Nullable List<? extends Class<? extends g32.b>> eventList, @Nullable com.tencent.mobileqq.icgame.framework.page.manager.a componentRuntimeProvider, @Nullable List<o32.b> componentNodeAddSwitchList) {
            a aVar;
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(rootComponentContext, "rootComponentContext");
            ComponentNode componentNode = new ComponentNode(clazz, key, rootComponentContext, componentRuntimeProvider, null);
            componentNode.parentNode = parentNode;
            if (componentRuntimeProvider == null || (aVar = componentRuntimeProvider.b(clazz, key)) == null) {
                aVar = new a(clazz, rootComponentContext, key, eventList, null, 16, null);
            }
            componentNode.componentRuntime = aVar;
            if (componentNodeAddSwitchList != null) {
                Iterator<T> it = componentNodeAddSwitchList.iterator();
                while (it.hasNext()) {
                    componentNode.c((o32.b) it.next());
                }
            }
            return componentNode;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/icgame/framework/pagefacotry/ComponentNode$b", "Lo32/b;", "", "key", "", "a", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements o32.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<String, Boolean> f237366a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super String, Boolean> function1) {
            this.f237366a = function1;
        }

        @Override // o32.b
        public boolean a(@NotNull String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return this.f237366a.invoke(key).booleanValue();
        }
    }

    public /* synthetic */ ComponentNode(Class cls, String str, f32.a aVar, com.tencent.mobileqq.icgame.framework.page.manager.a aVar2, DefaultConstructorMarker defaultConstructorMarker) {
        this(cls, str, aVar, aVar2);
    }

    private final boolean d(o32.b r36, String key) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.componentNodeAddSwitchList);
        arrayList.add(r36);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((o32.b) it.next()).a(key)) {
                return false;
            }
        }
        return true;
    }

    private final ComponentNode j(Class<? extends e> child, String key, o32.b r112) {
        if (TextUtils.isEmpty(key)) {
            e32.c.d(new QQLiveException());
            key = child.getSimpleName();
        }
        String str = key;
        Intrinsics.checkNotNull(str);
        if (!d(r112, str)) {
            return null;
        }
        ComponentNode a16 = INSTANCE.a(child, str, this, this.rootComponentContext, h32.a.INSTANCE.a(child), this.componentRuntimeProvider, this.componentNodeAddSwitchList);
        e().add(a16);
        return a16;
    }

    public static /* synthetic */ ComponentNode m(ComponentNode componentNode, Class cls, o32.b bVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bVar = o32.a.f421872a;
        }
        return componentNode.l(cls, bVar);
    }

    public final void c(@NotNull o32.b switchConfig) {
        Intrinsics.checkNotNullParameter(switchConfig, "switchConfig");
        if (this.componentNodeAddSwitchList.contains(switchConfig)) {
            return;
        }
        this.componentNodeAddSwitchList.add(switchConfig);
    }

    @NotNull
    public final CopyOnWriteArrayList<ComponentNode> e() {
        return (CopyOnWriteArrayList) this.childComponentList.getValue();
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getComponentKey() {
        return this.componentKey;
    }

    @NotNull
    public final a<e> g() {
        a aVar = this.componentRuntime;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("componentRuntime");
            return null;
        }
        return aVar;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final ComponentNode getParentNode() {
        return this.parentNode;
    }

    @NotNull
    public final Class<? extends e> i() {
        return this.selfComponentClazz;
    }

    @Nullable
    public final ComponentNode k(@NotNull Class<? extends com.tencent.mobileqq.icgame.framework.component.h> child, @NotNull Function1<? super String, Boolean> invoke) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(invoke, "invoke");
        return l(child, new b(invoke));
    }

    @Nullable
    public final ComponentNode l(@NotNull Class<? extends com.tencent.mobileqq.icgame.framework.component.h> child, @NotNull o32.b r36) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(r36, "switch");
        return j(child, child.getSimpleName(), r36);
    }

    ComponentNode(Class<? extends e> cls, String str, f32.a aVar, com.tencent.mobileqq.icgame.framework.page.manager.a aVar2) {
        Lazy lazy;
        this.selfComponentClazz = cls;
        this.componentKey = str;
        this.rootComponentContext = aVar;
        this.componentRuntimeProvider = aVar2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CopyOnWriteArrayList<ComponentNode>>() { // from class: com.tencent.mobileqq.icgame.framework.pagefacotry.ComponentNode$childComponentList$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CopyOnWriteArrayList<ComponentNode> invoke() {
                return new CopyOnWriteArrayList<>();
            }
        });
        this.childComponentList = lazy;
        this.componentNodeAddSwitchList = new ArrayList();
    }
}
