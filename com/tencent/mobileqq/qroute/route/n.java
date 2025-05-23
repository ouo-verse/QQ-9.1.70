package com.tencent.mobileqq.qroute.route;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\"6\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002`\u00038\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"6\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\u0000j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t`\u00038\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u0004\u0010\u0007\"F\u0010\u000f\u001a.\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r0\u0000j\u0016\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r`\u00038\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b\n\u0010\u0007\u00a8\u0006\u0010"}, d2 = {"Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/qroute/route/RouteMetaData;", "Lkotlin/collections/HashMap;", "a", "Ljava/util/HashMap;", "c", "()Ljava/util/HashMap;", "routes", "Lcom/tencent/mobileqq/qroute/route/InterceptorMetaData;", "b", "pathInterceptors", "", "Lcom/tencent/mobileqq/qroute/route/j;", "", "routeTypeHandlers", "QRoute_debug"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "RouteTable")
/* loaded from: classes17.dex */
public final class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final HashMap<String, RouteMetaData> f276498a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final HashMap<String, InterceptorMetaData> f276499b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final HashMap<Integer, j<? extends Object>> f276500c;

    static {
        HashMap<Integer, j<? extends Object>> hashMapOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10024);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f276498a = new HashMap<>();
        f276499b = new HashMap<>();
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(0, new a()), TuplesKt.to(2, new c()), TuplesKt.to(3, new d()), TuplesKt.to(1, new p()), TuplesKt.to(-1, new l()));
        f276500c = hashMapOf;
    }

    @NotNull
    public static final HashMap<String, InterceptorMetaData> a() {
        return f276499b;
    }

    @NotNull
    public static final HashMap<Integer, j<? extends Object>> b() {
        return f276500c;
    }

    @NotNull
    public static final HashMap<String, RouteMetaData> c() {
        return f276498a;
    }
}
