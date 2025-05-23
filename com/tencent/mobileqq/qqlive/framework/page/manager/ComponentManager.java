package com.tencent.mobileqq.qqlive.framework.page.manager;

import android.view.ViewGroup;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.framework.exception.ComponentKeyInvalidException;
import com.tencent.mobileqq.qqlive.framework.page.Page;
import com.tencent.mobileqq.qqlive.framework.pagefacotry.ComponentNode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010#\u001a\u00020!\u0012\u0006\u0010&\u001a\u00020$\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0016\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00112\u0006\u0010\u0015\u001a\u00020\u0014J/\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00172\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010%R0\u0010*\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00020'j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0002`(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010)R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020,0+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010-R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020,0+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010-R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u00102R\u001b\u00106\u001a\u0002038FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u00104\u001a\u0004\b0\u00105\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/page/manager/ComponentManager;", "", "Lcom/tencent/mobileqq/qqlive/framework/pagefacotry/ComponentNode;", "cn", "", "i", "node", "j", "k", "", "c", "Landroid/view/ViewGroup;", "rootViewGroup", "Lfi2/a;", "rootComponentContext", h.F, "(Landroid/view/ViewGroup;Lfi2/a;)V", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/qqlive/framework/component/e;", "clazz", "", "key", "d", "Lcom/tencent/mobileqq/qqlive/framework/pagefacotry/a;", "e", "(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/qqlive/framework/pagefacotry/a;", "a", "b", "(Lcom/tencent/mobileqq/qqlive/framework/pagefacotry/ComponentNode;)V", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "()V", "Lcom/tencent/mobileqq/qqlive/framework/page/manager/c;", "Lcom/tencent/mobileqq/qqlive/framework/page/manager/c;", "extInterfaceManager", "Lcom/tencent/mobileqq/qqlive/framework/page/Page;", "Lcom/tencent/mobileqq/qqlive/framework/page/Page;", "page", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "Ljava/util/LinkedHashMap;", "componentNodeMap", "", "Lcom/tencent/mobileqq/qqlive/framework/page/manager/handler/c;", "Ljava/util/List;", "afterCreateComponentNodeList", "buildTreeNodeHandlerList", "f", "Landroid/view/ViewGroup;", "Lfi2/a;", "Lcom/tencent/mobileqq/qqlive/framework/page/manager/a;", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/qqlive/framework/page/manager/a;", "componentRuntimeProvider", "<init>", "(Lcom/tencent/mobileqq/qqlive/framework/page/manager/c;Lcom/tencent/mobileqq/qqlive/framework/page/Page;)V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class ComponentManager {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

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
    private final List<com.tencent.mobileqq.qqlive.framework.page.manager.handler.c> afterCreateComponentNodeList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.qqlive.framework.page.manager.handler.c> buildTreeNodeHandlerList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewGroup rootViewGroup;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private fi2.a rootComponentContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy componentRuntimeProvider;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/page/manager/ComponentManager$a;", "", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/qqlive/framework/component/e;", "clazz", "", "key", "a", "<init>", "()V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.framework.page.manager.ComponentManager$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final String a(@NotNull Class<? extends com.tencent.mobileqq.qqlive.framework.component.e> clazz, @NotNull String key) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) clazz, (Object) key);
            }
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(key, "key");
            return clazz.getName() + util.base64_pad_url + key;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36027);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ComponentManager(@NotNull c extInterfaceManager, @NotNull Page page) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(extInterfaceManager, "extInterfaceManager");
        Intrinsics.checkNotNullParameter(page, "page");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) extInterfaceManager, (Object) page);
            return;
        }
        this.extInterfaceManager = extInterfaceManager;
        this.page = page;
        this.componentNodeMap = new LinkedHashMap<>();
        this.afterCreateComponentNodeList = new ArrayList();
        this.buildTreeNodeHandlerList = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(ComponentManager$componentRuntimeProvider$2.INSTANCE);
        this.componentRuntimeProvider = lazy;
    }

    private final boolean c(ComponentNode cn5) {
        return !this.componentNodeMap.containsKey(INSTANCE.a(cn5.i(), cn5.f()));
    }

    private final void i(ComponentNode cn5) {
        if (c(cn5)) {
            this.componentNodeMap.put(INSTANCE.a(cn5.i(), cn5.f()), cn5);
            cn5.g().c();
            for (com.tencent.mobileqq.qqlive.framework.page.manager.handler.c cVar : this.afterCreateComponentNodeList) {
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
        throw new ComponentKeyInvalidException("key is invalid: " + cn5.f());
    }

    private final void j(ComponentNode node) {
        node.g().f();
        this.page.C0(new com.tencent.mobileqq.qqlive.framework.pageevent.a(node.f()));
    }

    private final void k(ComponentNode node) {
        node.g().g();
        this.page.C0(new com.tencent.mobileqq.qqlive.framework.pageevent.b(node.f()));
    }

    public final void a(@NotNull ComponentNode node) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) node);
        } else {
            Intrinsics.checkNotNullParameter(node, "node");
            i(node);
        }
    }

    public final void b(@NotNull ComponentNode node) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) node);
            return;
        }
        Intrinsics.checkNotNullParameter(node, "node");
        for (com.tencent.mobileqq.qqlive.framework.page.manager.handler.c cVar : this.buildTreeNodeHandlerList) {
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
    public final ComponentNode d(@NotNull Class<? extends com.tencent.mobileqq.qqlive.framework.component.e> clazz, @NotNull String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ComponentNode) iPatchRedirector.redirect((short) 4, (Object) this, (Object) clazz, (Object) key);
        }
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(key, "key");
        return this.componentNodeMap.get(INSTANCE.a(clazz, key));
    }

    @Nullable
    public final com.tencent.mobileqq.qqlive.framework.pagefacotry.a<com.tencent.mobileqq.qqlive.framework.component.e> e(@NotNull Class<? extends com.tencent.mobileqq.qqlive.framework.component.e> clazz, @NotNull String key) {
        com.tencent.mobileqq.qqlive.framework.pagefacotry.a<com.tencent.mobileqq.qqlive.framework.component.e> aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.mobileqq.qqlive.framework.pagefacotry.a) iPatchRedirector.redirect((short) 11, (Object) this, (Object) clazz, (Object) key);
        }
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
            fi2.a aVar2 = this.rootComponentContext;
            Intrinsics.checkNotNull(aVar2);
            return f16.c(clazz, key, aVar2, com.tencent.mobileqq.qqlive.framework.eventbroadcaster.annotation.a.INSTANCE.a(clazz));
        }
        return aVar;
    }

    @NotNull
    public final a f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (a) this.componentRuntimeProvider.getValue();
    }

    public final void g(@NotNull ComponentNode node) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) node);
            return;
        }
        Intrinsics.checkNotNullParameter(node, "node");
        j(node);
        for (ComponentNode it : node.e()) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            g(it);
        }
    }

    public final void h(@NotNull ViewGroup rootViewGroup, @NotNull fi2.a rootComponentContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootViewGroup, (Object) rootComponentContext);
            return;
        }
        Intrinsics.checkNotNullParameter(rootViewGroup, "rootViewGroup");
        Intrinsics.checkNotNullParameter(rootComponentContext, "rootComponentContext");
        this.rootViewGroup = rootViewGroup;
        this.rootComponentContext = rootComponentContext;
        this.buildTreeNodeHandlerList.add(new com.tencent.mobileqq.qqlive.framework.page.manager.handler.d());
        com.tencent.mobileqq.qqlive.framework.page.manager.handler.a aVar = new com.tencent.mobileqq.qqlive.framework.page.manager.handler.a();
        com.tencent.mobileqq.qqlive.framework.page.manager.handler.b bVar = new com.tencent.mobileqq.qqlive.framework.page.manager.handler.b();
        this.afterCreateComponentNodeList.add(aVar);
        this.afterCreateComponentNodeList.add(bVar);
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            this.componentNodeMap.clear();
            f().a();
        }
    }

    public final void m(@NotNull ComponentNode node) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) node);
            return;
        }
        Intrinsics.checkNotNullParameter(node, "node");
        k(node);
        for (ComponentNode it : node.e()) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            m(it);
        }
    }
}
