package com.tencent.qqnt.aio.interceptor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\fJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R6\u0010\r\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u0006j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0007`\b8\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u0012\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/interceptor/a;", "", "", "chatType", "Lcom/tencent/qqnt/aio/interceptor/g;", "a", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "getInterceptorClassList$annotations", "()V", "interceptorClassList", "", "c", "Ljava/util/List;", "interceptors", "<init>", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f351159a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/interceptor/Inject_aioStart_interceptor.yml", version = 3)
    @NotNull
    private static final ArrayList<Class<g>> interceptorClassList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<g> interceptors;

    static {
        int collectionSizeOrDefault;
        Object first;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51103);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f351159a = new a();
        ArrayList<Class<g>> arrayList = new ArrayList<>();
        interceptorClassList = arrayList;
        arrayList.add(c.class);
        arrayList.add(FriendVerifyTempAIOInterceptor.class);
        arrayList.add(b.class);
        arrayList.add(f.class);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Constructor<?>[] constructors = ((Class) it.next()).getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "it.constructors");
            first = ArraysKt___ArraysKt.first(constructors);
            Object newInstance = ((Constructor) first).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.aio.interceptor.IAIOStartInterceptor");
            arrayList2.add((g) newInstance);
        }
        interceptors = arrayList2;
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final g a(int chatType) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (g) iPatchRedirector.redirect((short) 2, (Object) this, chatType);
        }
        Iterator<T> it = interceptors.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((g) obj).a(chatType)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (g) obj;
    }
}
