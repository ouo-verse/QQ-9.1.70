package com.tencent.filament.zplanservice.channel;

import com.tencent.filament.zplanservice.channel.handler.MsfHandler;
import com.tencent.filament.zplanservice.channel.handler.QQAppHandler;
import com.tencent.filament.zplanservice.channel.handler.QQMCHandler;
import com.tencent.filament.zplanservice.channel.handler.QQSchemeHandler;
import com.tencent.filament.zplanservice.channel.handler.QQWebviewHandler;
import com.tencent.filament.zplanservice.channel.handler.ZPlanInfoHandler;
import com.tencent.filament.zplanservice.channel.handler.annotation.EventName;
import com.tencent.filament.zplanservice.util.log.FLog;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0002R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u0007\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0011R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00138@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/filament/zplanservice/channel/d;", "", "handler", "", "c", "", "", "a", "Ljava/util/Map;", "_proxyHandlers", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/reflect/Method;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "()Ljava/util/concurrent/ConcurrentHashMap;", "proxyHandlerMethod", "", "Ljava/util/List;", "proxyHandlerClassList", "", "()Ljava/util/Map;", "proxyHandlers", "<init>", "()V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final List<Object> proxyHandlerClassList;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final d f106356d = new d();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, Object> _proxyHandlers = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, Method> proxyHandlerMethod = new ConcurrentHashMap<>();

    static {
        List<Object> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf(new MsfHandler(), new QQAppHandler(), new QQMCHandler(), new QQSchemeHandler(), new QQWebviewHandler(), new com.tencent.filament.zplanservice.channel.handler.c(), new com.tencent.filament.zplanservice.channel.handler.b(), new com.tencent.filament.zplanservice.channel.handler.d(), new ZPlanInfoHandler());
        proxyHandlerClassList = listOf;
        Iterator<T> it = listOf.iterator();
        while (it.hasNext()) {
            f106356d.c(it.next());
        }
    }

    d() {
    }

    private final void c(Object handler) {
        Method[] declaredMethods = handler.getClass().getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "handler.javaClass.declaredMethods");
        for (Method method : declaredMethods) {
            EventName eventName = (EventName) method.getAnnotation(EventName.class);
            if (eventName != null) {
                FLog.INSTANCE.i("ProxyEventHandler", eventName.name() + ", " + handler);
                Map<String, Object> map = _proxyHandlers;
                map.containsKey(eventName.name());
                map.put(eventName.name(), handler);
            }
        }
    }

    @NotNull
    public final ConcurrentHashMap<String, Method> a() {
        return proxyHandlerMethod;
    }

    @NotNull
    public final Map<String, Object> b() {
        return _proxyHandlers;
    }
}
