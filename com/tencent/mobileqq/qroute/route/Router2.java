package com.tencent.mobileqq.qroute.route;

import android.content.Context;
import android.net.Uri;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.exception.QRouteException;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b,\u0010-J\u0016\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0014\u0010\n\u001a\u00020\t2\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J(\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u000f0\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0002J\u001e\u0010\u0016\u001a\u00020\u00152\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\rJ\u0010\u0010\u0017\u001a\u00020\u00152\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u0018\u001a\u00020\u0015J\u001a\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00022\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0004J\u0016\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u0002J\u0016\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u000bJ\u0017\u0010!\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001cH\u0000\u00a2\u0006\u0004\b!\u0010\"J\u001d\u0010$\u001a\u00028\u0000\"\u0004\b\u0000\u0010#2\u0006\u0010 \u001a\u00020\u001cH\u0000\u00a2\u0006\u0004\b$\u0010%R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/qroute/route/Router2;", "", "", PushClientConstants.TAG_CLASS_NAME, "Ljava/lang/Class;", tl.h.F, "path", "i", "clazz", "", "e", "Landroid/net/Uri;", "j", "", "paths", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/qroute/route/h;", "o", "Lcom/tencent/mobileqq/qroute/route/g;", "logger", "modules", "", "g", DomainData.DOMAIN_NAME, "f", "k", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qroute/route/Navigator;", "d", LayoutAttrDefine.CLICK_URI, "c", "navigator", "l", "(Lcom/tencent/mobileqq/qroute/route/Navigator;)V", "T", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/qroute/route/Navigator;)Ljava/lang/Object;", "a", "Ljava/util/List;", "Lkotlinx/coroutines/CoroutineScope;", "b", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "<init>", "()V", "QRoute_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes17.dex */
public final class Router2 {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static List<String> modules;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final CoroutineScope coroutineScope;

    /* renamed from: c, reason: collision with root package name */
    public static final Router2 f276492c;

    static {
        List<String> emptyList;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11426);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        f276492c = new Router2();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        modules = emptyList;
        coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
    }

    Router2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    private final int e(Class<?> clazz) {
        int i3 = -1;
        for (Class<? super Object> superclass = clazz.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            String name = superclass.getName();
            switch (name.hashCode()) {
                case -1926333898:
                    if (name.equals("androidx.fragment.app.Fragment")) {
                        i3 = 3;
                        break;
                    } else {
                        break;
                    }
                case -880360069:
                    if (name.equals("android.app.Activity")) {
                        i3 = 0;
                        break;
                    } else {
                        break;
                    }
                case -874662724:
                    if (name.equals("android.app.Fragment")) {
                        i3 = 2;
                        break;
                    } else {
                        break;
                    }
                case 762246857:
                    if (name.equals("android.app.Service")) {
                        i3 = 1;
                        break;
                    } else {
                        break;
                    }
            }
        }
        return i3;
    }

    private final Class<?> h(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e16) {
            k.d("Load " + className + " error!", e16);
            return null;
        }
    }

    private final String i(String path) {
        boolean startsWith$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(path, "/", false, 2, null);
        if (!startsWith$default) {
            return '/' + path;
        }
        return path;
    }

    private final Uri j(String path) {
        boolean z16;
        Uri uri = Uri.parse(i(path));
        Intrinsics.checkExpressionValueIsNotNull(uri, "uri");
        String path2 = uri.getPath();
        if (path2 != null && path2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (uri.getPathSegments().size() >= 2) {
                return uri;
            }
            throw new QRouteException(1001, "path \u81f3\u5c11\u9700\u89812\u7ea7\u8def\u5f84\uff0c\u6bd4\u5982/aa/bb!", null, 4, null);
        }
        throw new QRouteException(1001, "path must not be empty!", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Pair<String, h>> o(List<String> paths) {
        String joinToString$default;
        String removeSuffix;
        Pair pair;
        List<String> list = paths;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, "/", "/", null, i16, "", null, 36, null);
            removeSuffix = StringsKt__StringsKt.removeSuffix(joinToString$default, (CharSequence) "/");
            if (n.a().get(removeSuffix) == null) {
                pair = null;
            } else {
                InterceptorMetaData interceptorMetaData = n.a().get(removeSuffix);
                if (interceptorMetaData == null) {
                    Intrinsics.throwNpe();
                }
                pair = TuplesKt.to(removeSuffix, interceptorMetaData.b());
            }
            if (pair != null) {
                arrayList.add(pair);
            }
            i3 = i16;
        }
        return arrayList;
    }

    @NotNull
    public final Navigator c(@NotNull Context context, @NotNull Uri uri) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Navigator) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) uri);
        }
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        return new Navigator(context, uri);
    }

    @NotNull
    public final Navigator d(@NotNull Context context, @NotNull String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Navigator) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) path);
        }
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(path, "path");
        return c(context, j(path));
    }

    public final void f() {
        int collectionSizeOrDefault;
        Object obj;
        Object obj2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        boolean z16 = k.f276497b;
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Load RouterInitializer ");
            List<String> list = modules;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add("com.tencent.mobileqq.qroute.route.generated." + ((String) it.next()) + "_RouterInitializer");
            }
            sb5.append(arrayList);
            k.b(sb5.toString());
            for (String str : modules) {
                Class<?> h16 = f276492c.h("com.tencent.mobileqq.qroute.route.generated." + str + "_RouterInitializer");
                Object obj3 = null;
                if (h16 != null) {
                    obj = h16.newInstance();
                } else {
                    obj = null;
                }
                if (!(obj instanceof i)) {
                    obj2 = null;
                } else {
                    obj2 = obj;
                }
                i iVar = (i) obj2;
                if (iVar != null) {
                    iVar.loadIntoRoute(n.c());
                }
                if (obj instanceof f) {
                    obj3 = obj;
                }
                f fVar = (f) obj3;
                if (fVar != null) {
                    fVar.loadIntoInterceptor(n.a());
                }
            }
        } catch (Exception e16) {
            if (!z16) {
                k.d("UI Route init error!", e16);
                return;
            }
            throw new QRouteException(1000, "UI Route init error!", e16);
        }
    }

    public final void g(@Nullable g logger, @NotNull List<String> modules2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) logger, (Object) modules2);
            return;
        }
        Intrinsics.checkParameterIsNotNull(modules2, "modules");
        n(logger);
        modules = modules2;
        long currentTimeMillis = System.currentTimeMillis();
        f276492c.f();
        k.b("checkTime init route cost: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public final void k(@NotNull String path, @NotNull Class<?> clazz) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) path, (Object) clazz);
            return;
        }
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        HashMap<String, RouteMetaData> c16 = n.c();
        String i3 = i(path);
        int e16 = e(clazz);
        String name = clazz.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "clazz.name");
        String name2 = clazz.getName();
        Intrinsics.checkExpressionValueIsNotNull(name2, "clazz.name");
        RouteMetaData put = c16.put(i3, new RouteMetaData(0, null, null, e16, name, path, name2, 7, null));
        if (put != null) {
            k.c("\u5df2\u5b58\u5728\u8def\u5f84\u4e3a\uff1a" + path + " \u7684\u8def\u7531\u7ec4\u4ef6 " + put.b() + "\uff0c\u73b0\u5728\u88ab\u66ff\u6362\u4e3a: " + clazz.getName());
        }
    }

    public final void l(@NotNull Navigator navigator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) navigator);
        } else {
            Intrinsics.checkParameterIsNotNull(navigator, "navigator");
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new Router2$request$1(navigator, null), 3, null);
        }
    }

    public final <T> T m(@NotNull Navigator navigator) {
        Object runBlocking$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (T) iPatchRedirector.redirect((short) 8, (Object) this, (Object) navigator);
        }
        Intrinsics.checkParameterIsNotNull(navigator, "navigator");
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new Router2$requestWithReturn$1(navigator, null), 1, null);
        return (T) runBlocking$default;
    }

    public final void n(@Nullable g logger) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) logger);
        } else {
            k.f276496a = logger;
        }
    }
}
