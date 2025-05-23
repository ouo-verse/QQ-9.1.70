package com.tencent.mobileqq.qqlive.framework.page.manager;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.framework.exception.QQLiveException;
import com.tencent.mobileqq.qqlive.framework.page.Page;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bJ\u001c\u0010\u000e\u001a\u00020\u00042\u0014\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\f0\u000bJ\u0006\u0010\u000f\u001a\u00020\u0004J\u0012\u0010\u0013\u001a\u00020\u00042\n\u0010\u0012\u001a\u00060\u0010R\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0004R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0015R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0016R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/page/manager/b;", "", "Lfi2/b;", "connectorContext", "", "f", "Lcom/tencent/mobileqq/qqlive/framework/connector/b;", "connector", "", "isExtConnector", "b", "", "Ljava/lang/Class;", "connectorClassList", "a", "c", "Lcom/tencent/mobileqq/qqlive/framework/page/Page$c;", "Lcom/tencent/mobileqq/qqlive/framework/page/Page;", "interfaceConnector", "d", "e", "Lfi2/b;", "Ljava/util/List;", "connectorList", "extConnectorList", "<init>", "()V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private fi2.b connectorContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.qqlive.framework.connector.b> connectorList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.qqlive.framework.connector.b> extConnectorList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004RP\u0010\r\u001a>\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\t0\bj\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\t`\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/page/manager/b$a;", "", "Lfi2/b;", "connectorContext", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/qqlive/framework/connector/b;", "clazzConnector", "a", "Ljava/util/HashMap;", "Ljava/lang/reflect/Constructor;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "clazzConnectorMap", "<init>", "()V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f271297a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final HashMap<Class<? extends com.tencent.mobileqq.qqlive.framework.connector.b>, Constructor<? extends com.tencent.mobileqq.qqlive.framework.connector.b>> clazzConnectorMap;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36035);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f271297a = new a();
                clazzConnectorMap = new HashMap<>();
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final com.tencent.mobileqq.qqlive.framework.connector.b a(@NotNull fi2.b connectorContext, @NotNull Class<? extends com.tencent.mobileqq.qqlive.framework.connector.b> clazzConnector) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mobileqq.qqlive.framework.connector.b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) connectorContext, (Object) clazzConnector);
            }
            Intrinsics.checkNotNullParameter(connectorContext, "connectorContext");
            Intrinsics.checkNotNullParameter(clazzConnector, "clazzConnector");
            HashMap<Class<? extends com.tencent.mobileqq.qqlive.framework.connector.b>, Constructor<? extends com.tencent.mobileqq.qqlive.framework.connector.b>> hashMap = clazzConnectorMap;
            Constructor<? extends com.tencent.mobileqq.qqlive.framework.connector.b> constructor = hashMap.get(clazzConnector);
            if (constructor == null) {
                try {
                    constructor = clazzConnector.getConstructor(fi2.b.class);
                    hashMap.put(clazzConnector, constructor);
                } catch (NoSuchMethodException e16) {
                    e16.printStackTrace();
                }
            }
            if (constructor == null) {
                com.tencent.mobileqq.qqlive.framework.c.d(new QQLiveException("Please check constructor is ok"));
            }
            Intrinsics.checkNotNull(constructor);
            com.tencent.mobileqq.qqlive.framework.connector.b newInstance = constructor.newInstance(connectorContext);
            Intrinsics.checkNotNullExpressionValue(newInstance, "constructor!!.newInstance(connectorContext)");
            return newInstance;
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.connectorList = new ArrayList();
            this.extConnectorList = new ArrayList();
        }
    }

    public final void a(@NotNull List<Class<? extends com.tencent.mobileqq.qqlive.framework.connector.b>> connectorClassList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) connectorClassList);
            return;
        }
        Intrinsics.checkNotNullParameter(connectorClassList, "connectorClassList");
        for (Class<? extends com.tencent.mobileqq.qqlive.framework.connector.b> cls : connectorClassList) {
            List<com.tencent.mobileqq.qqlive.framework.connector.b> list = this.connectorList;
            a aVar = a.f271297a;
            fi2.b bVar = this.connectorContext;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("connectorContext");
                bVar = null;
            }
            list.add(aVar.a(bVar, cls));
        }
    }

    public final void b(@NotNull com.tencent.mobileqq.qqlive.framework.connector.b connector, boolean isExtConnector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, connector, Boolean.valueOf(isExtConnector));
            return;
        }
        Intrinsics.checkNotNullParameter(connector, "connector");
        this.connectorList.add(connector);
        if (isExtConnector) {
            this.extConnectorList.add(connector);
        }
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Iterator<T> it = this.connectorList.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.qqlive.framework.connector.b) it.next()).a();
        }
    }

    public final void d(@NotNull Page.c interfaceConnector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) interfaceConnector);
            return;
        }
        Intrinsics.checkNotNullParameter(interfaceConnector, "interfaceConnector");
        Iterator<T> it = this.connectorList.iterator();
        while (it.hasNext()) {
            List<com.tencent.mobileqq.qqlive.framework.interfaceService.a<?>> c16 = ((com.tencent.mobileqq.qqlive.framework.connector.b) it.next()).c();
            if (c16 != null) {
                Iterator<T> it5 = c16.iterator();
                while (it5.hasNext()) {
                    com.tencent.mobileqq.qqlive.framework.interfaceService.a aVar = (com.tencent.mobileqq.qqlive.framework.interfaceService.a) it5.next();
                    Object b16 = aVar.b();
                    if (b16 != null) {
                        Class a16 = aVar.a();
                        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
                        interfaceConnector.a(a16, b16);
                    }
                }
            }
        }
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator<T> it = this.connectorList.iterator();
        while (it.hasNext()) {
            sb5.append(((com.tencent.mobileqq.qqlive.framework.connector.b) it.next()).getClass().getSimpleName());
            sb5.append("\n");
        }
        com.tencent.mobileqq.qqlive.framework.log.b.f271266a.i("PageSdk_TAG", "ConnectorList: \n" + ((Object) sb5));
    }

    public final void f(@NotNull fi2.b connectorContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) connectorContext);
        } else {
            Intrinsics.checkNotNullParameter(connectorContext, "connectorContext");
            this.connectorContext = connectorContext;
        }
    }
}
