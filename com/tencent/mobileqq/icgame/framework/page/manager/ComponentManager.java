package com.tencent.mobileqq.icgame.framework.page.manager;

import android.view.ViewGroup;
import com.tencent.mobileqq.icgame.framework.exception.ComponentKeyInvalidException;
import com.tencent.mobileqq.icgame.framework.exception.ParentComponentNotFoundException;
import com.tencent.mobileqq.icgame.framework.page.Page;
import com.tencent.mobileqq.icgame.framework.pagefacotry.ComponentNode;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m32.ComponentInitEvent;
import m32.ComponentUnInitEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0001 B\u0017\u0012\u0006\u0010)\u001a\u00020'\u0012\u0006\u0010,\u001a\u00020*\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0016\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00112\u0006\u0010\u0015\u001a\u00020\u0014J;\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u00112\u000e\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u0014H\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001d2\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0017\u0010!\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b#\u0010\"J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b$\u0010\"J\u000f\u0010%\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010(R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010+R0\u00100\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00020-j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0002`.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010/R\u001a\u00104\u001a\b\u0012\u0004\u0012\u000202018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u00103R\u001a\u00105\u001a\b\u0012\u0004\u0012\u000202018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u00103R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u00108R\u001b\u0010<\u001a\u0002098FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010:\u001a\u0004\b6\u0010;\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/page/manager/ComponentManager;", "", "Lcom/tencent/mobileqq/icgame/framework/pagefacotry/ComponentNode;", "cn", "", "i", "node", "j", "k", "", "c", "Landroid/view/ViewGroup;", "rootViewGroup", "Lf32/a;", "rootComponentContext", h.F, "(Landroid/view/ViewGroup;Lf32/a;)V", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/icgame/framework/component/e;", "clazz", "", "key", "d", "Lcom/tencent/mobileqq/icgame/framework/component/h;", "componentClazz", "parentComponentClazz", "parentKey", "l", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/icgame/framework/pagefacotry/ComponentNode;", "Lcom/tencent/mobileqq/icgame/framework/pagefacotry/a;", "e", "(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/icgame/framework/pagefacotry/a;", "a", "b", "(Lcom/tencent/mobileqq/icgame/framework/pagefacotry/ComponentNode;)V", "g", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()V", "Lcom/tencent/mobileqq/icgame/framework/page/manager/c;", "Lcom/tencent/mobileqq/icgame/framework/page/manager/c;", "extInterfaceManager", "Lcom/tencent/mobileqq/icgame/framework/page/Page;", "Lcom/tencent/mobileqq/icgame/framework/page/Page;", "page", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "Ljava/util/LinkedHashMap;", "componentNodeMap", "", "Ll32/c;", "Ljava/util/List;", "afterCreateComponentNodeList", "buildTreeNodeHandlerList", "f", "Landroid/view/ViewGroup;", "Lf32/a;", "Lcom/tencent/mobileqq/icgame/framework/page/manager/a;", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/icgame/framework/page/manager/a;", "componentRuntimeProvider", "<init>", "(Lcom/tencent/mobileqq/icgame/framework/page/manager/c;Lcom/tencent/mobileqq/icgame/framework/page/Page;)V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ComponentManager {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c extInterfaceManager;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Page page;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedHashMap<String, ComponentNode> componentNodeMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<l32.c> afterCreateComponentNodeList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<l32.c> buildTreeNodeHandlerList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewGroup rootViewGroup;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private f32.a rootComponentContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy componentRuntimeProvider;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/page/manager/ComponentManager$a;", "", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/icgame/framework/component/e;", "clazz", "", "key", "a", "<init>", "()V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.icgame.framework.page.manager.ComponentManager$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a(@NotNull Class<? extends com.tencent.mobileqq.icgame.framework.component.e> clazz, @NotNull String key) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(key, "key");
            return clazz.getName() + "_" + key;
        }

        Companion() {
        }
    }

    public ComponentManager(@NotNull c extInterfaceManager, @NotNull Page page) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(extInterfaceManager, "extInterfaceManager");
        Intrinsics.checkNotNullParameter(page, "page");
        this.extInterfaceManager = extInterfaceManager;
        this.page = page;
        this.componentNodeMap = new LinkedHashMap<>();
        this.afterCreateComponentNodeList = new ArrayList();
        this.buildTreeNodeHandlerList = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.mobileqq.icgame.framework.page.manager.ComponentManager$componentRuntimeProvider$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a();
            }
        });
        this.componentRuntimeProvider = lazy;
    }

    private final boolean c(ComponentNode cn5) {
        return !this.componentNodeMap.containsKey(INSTANCE.a(cn5.i(), cn5.getComponentKey()));
    }

    private final void i(ComponentNode cn5) {
        if (c(cn5)) {
            this.componentNodeMap.put(INSTANCE.a(cn5.i(), cn5.getComponentKey()), cn5);
            cn5.g().c();
            for (l32.c cVar : this.afterCreateComponentNodeList) {
                if (cVar.b(cn5)) {
                    ViewGroup viewGroup = this.rootViewGroup;
                    if (viewGroup == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("rootViewGroup");
                        viewGroup = null;
                    }
                    cVar.a(cn5, viewGroup, this.extInterfaceManager);
                }
            }
            for (ComponentNode it : cn5.e()) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                i(it);
            }
            return;
        }
        throw new ComponentKeyInvalidException("key is invalid: " + cn5.getComponentKey());
    }

    private final void j(ComponentNode node) {
        node.g().f();
        this.page.w0(new ComponentInitEvent(node.getComponentKey()));
    }

    private final void k(ComponentNode node) {
        node.g().g();
        this.page.w0(new ComponentUnInitEvent(node.getComponentKey()));
    }

    public final void a(@NotNull ComponentNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        i(node);
    }

    public final void b(@NotNull ComponentNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        for (l32.c cVar : this.buildTreeNodeHandlerList) {
            if (cVar.b(node)) {
                ViewGroup viewGroup = this.rootViewGroup;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rootViewGroup");
                    viewGroup = null;
                }
                cVar.a(node, viewGroup, this.extInterfaceManager);
            }
        }
        for (ComponentNode it : node.e()) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            b(it);
        }
    }

    @Nullable
    public final ComponentNode d(@NotNull Class<? extends com.tencent.mobileqq.icgame.framework.component.e> clazz, @NotNull String key) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(key, "key");
        return this.componentNodeMap.get(INSTANCE.a(clazz, key));
    }

    @Nullable
    public final com.tencent.mobileqq.icgame.framework.pagefacotry.a<com.tencent.mobileqq.icgame.framework.component.e> e(@NotNull Class<? extends com.tencent.mobileqq.icgame.framework.component.e> clazz, @NotNull String key) {
        com.tencent.mobileqq.icgame.framework.pagefacotry.a<com.tencent.mobileqq.icgame.framework.component.e> aVar;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(key, "key");
        ComponentNode componentNode = this.componentNodeMap.get(INSTANCE.a(clazz, key));
        if (componentNode != null) {
            aVar = componentNode.g();
        } else {
            aVar = null;
        }
        if (aVar == null && this.rootComponentContext != null) {
            a f16 = f();
            f32.a aVar2 = this.rootComponentContext;
            Intrinsics.checkNotNull(aVar2);
            return f16.c(clazz, key, aVar2, h32.a.INSTANCE.a(clazz));
        }
        return aVar;
    }

    @NotNull
    public final a f() {
        return (a) this.componentRuntimeProvider.getValue();
    }

    public final void g(@NotNull ComponentNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        j(node);
        for (ComponentNode it : node.e()) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            g(it);
        }
    }

    public final void h(@NotNull ViewGroup rootViewGroup, @NotNull f32.a rootComponentContext) {
        Intrinsics.checkNotNullParameter(rootViewGroup, "rootViewGroup");
        Intrinsics.checkNotNullParameter(rootComponentContext, "rootComponentContext");
        this.rootViewGroup = rootViewGroup;
        this.rootComponentContext = rootComponentContext;
        this.buildTreeNodeHandlerList.add(new l32.d());
        l32.a aVar = new l32.a();
        l32.b bVar = new l32.b();
        this.afterCreateComponentNodeList.add(aVar);
        this.afterCreateComponentNodeList.add(bVar);
    }

    @Nullable
    public final synchronized ComponentNode l(@NotNull Class<? extends com.tencent.mobileqq.icgame.framework.component.h> componentClazz, @NotNull Class<? extends com.tencent.mobileqq.icgame.framework.component.e> parentComponentClazz, @NotNull String parentKey) {
        Intrinsics.checkNotNullParameter(componentClazz, "componentClazz");
        Intrinsics.checkNotNullParameter(parentComponentClazz, "parentComponentClazz");
        Intrinsics.checkNotNullParameter(parentKey, "parentKey");
        String a16 = INSTANCE.a(parentComponentClazz, parentKey);
        ComponentNode componentNode = this.componentNodeMap.get(a16);
        ComponentNode componentNode2 = null;
        if (componentNode == null) {
            e32.c.d(new ParentComponentNotFoundException("parentKey:" + a16 + " is not found!!"));
            return null;
        }
        ComponentNode m3 = ComponentNode.m(componentNode, componentClazz, null, 2, null);
        if (m3 != null) {
            i(m3);
            b(m3);
            j(m3);
            componentNode2 = m3;
        }
        return componentNode2;
    }

    public final void m() {
        this.componentNodeMap.clear();
        f().a();
    }

    public final void n(@NotNull ComponentNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        k(node);
        for (ComponentNode it : node.e()) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            n(it);
        }
    }
}
