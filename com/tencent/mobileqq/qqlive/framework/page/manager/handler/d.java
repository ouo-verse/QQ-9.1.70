package com.tencent.mobileqq.qqlive.framework.page.manager.handler;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.framework.component.i;
import com.tencent.mobileqq.qqlive.framework.exception.ParentViewErrorException;
import com.tencent.mobileqq.qqlive.framework.pagefacotry.ComponentNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/page/manager/handler/d;", "Lcom/tencent/mobileqq/qqlive/framework/page/manager/handler/c;", "Lcom/tencent/mobileqq/qqlive/framework/pagefacotry/ComponentNode;", "cn", "", "d", "Landroid/view/View;", "c", "node", "b", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/qqlive/framework/page/manager/c;", "extInterfaceManager", "", "a", "<init>", "()V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class d extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/page/manager/handler/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.framework.page.manager.handler.d$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36111);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final View c(ComponentNode cn5) {
        com.tencent.mobileqq.qqlive.framework.component.e eVar;
        com.tencent.mobileqq.qqlive.framework.pagefacotry.a<com.tencent.mobileqq.qqlive.framework.component.e> g16;
        ComponentNode h16 = cn5.h();
        if (h16 != null && (g16 = h16.g()) != null) {
            eVar = g16.d();
        } else {
            eVar = null;
        }
        if (!(eVar instanceof i)) {
            return null;
        }
        return ((i) eVar).l();
    }

    private final boolean d(ComponentNode cn5) {
        if (cn5 == null) {
            return false;
        }
        com.tencent.mobileqq.qqlive.framework.component.e d16 = cn5.g().d();
        if (d16 instanceof i) {
            i iVar = (i) d16;
            if (!iVar.a() && !iVar.d()) {
                return true;
            }
        }
        return d(cn5.h());
    }

    @Override // com.tencent.mobileqq.qqlive.framework.page.manager.handler.c
    public void a(@NotNull ComponentNode node, @NotNull ViewGroup rootView, @NotNull com.tencent.mobileqq.qqlive.framework.page.manager.c extInterfaceManager) {
        View view;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, node, rootView, extInterfaceManager);
            return;
        }
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(extInterfaceManager, "extInterfaceManager");
        com.tencent.mobileqq.qqlive.framework.component.e d16 = node.g().d();
        if (d16 instanceof i) {
            i iVar = (i) d16;
            if (!iVar.h() && !iVar.a()) {
                com.tencent.mobileqq.qqlive.framework.log.b.f271266a.i("UIComponentHandler", "injectView: " + node.i().getSimpleName() + " UI\u4e0d\u81ea\u52a8\u52a0\u8f7d");
                return;
            }
            if (iVar.m() != com.tencent.mobileqq.qqlive.framework.a.d()) {
                if (d(node.h())) {
                    com.tencent.mobileqq.qqlive.framework.log.b.f271266a.i("UIComponentHandler", "injectView: parent component is not inject view,wait...");
                    return;
                }
                view = c(node);
                if (view != null) {
                    if (!(view instanceof ViewGroup)) {
                        com.tencent.mobileqq.qqlive.framework.c.d(new ParentViewErrorException(node.i().getSimpleName() + " parentView is a View"));
                        return;
                    }
                } else {
                    throw new ParentViewErrorException(node.i().getSimpleName() + " no parent view");
                }
            } else {
                view = rootView;
            }
            long currentTimeMillis = System.currentTimeMillis();
            e eVar = e.f271304a;
            Context context = rootView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            eVar.a(context, (ViewGroup) view, iVar.g(), iVar.m(), iVar.f());
            long currentTimeMillis2 = System.currentTimeMillis();
            String simpleName = d16.getClass().getSimpleName();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(simpleName);
            if (TextUtils.equals(simpleName, d16.getKey())) {
                str = "";
            } else {
                str = util.base64_pad_url + d16.getKey();
            }
            sb5.append(str);
            String sb6 = sb5.toString();
            com.tencent.mobileqq.qqlive.framework.log.b.f271266a.i(com.tencent.mobileqq.qqlive.framework.a.c(), "inject view " + sb6 + " cost time: " + (currentTimeMillis2 - currentTimeMillis));
        }
    }

    @Override // com.tencent.mobileqq.qqlive.framework.page.manager.handler.c
    public boolean b(@NotNull ComponentNode node) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) node)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(node, "node");
        return node.g().d() instanceof i;
    }
}
