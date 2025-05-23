package com.tencent.mobileqq.proavatar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R0\u0010\b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003`\u00058\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/proavatar/d;", "", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/proavatar/b;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "avatarInfoBusinessHandler", "", "c", "Ljava/util/List;", "a", "()Ljava/util/List;", "avatarInfoHandlers", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f259556a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QQAvatarImpl/Inject_ProAvatarComponentInit.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<b>> avatarInfoBusinessHandler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<b> avatarInfoHandlers;

    static {
        int collectionSizeOrDefault;
        List<b> mutableList;
        Object first;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17409);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f259556a = new d();
        ArrayList<Class<b>> arrayList = new ArrayList<>();
        avatarInfoBusinessHandler = arrayList;
        arrayList.add(com.tencent.mobileqq.proavatar.info.handler.a.class);
        arrayList.add(com.tencent.mobileqq.register.avatar.c.class);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Constructor<?>[] constructors = ((Class) it.next()).getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "it.constructors");
            first = ArraysKt___ArraysKt.first(constructors);
            arrayList2.add(((Constructor) first).newInstance(new Object[0]));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        avatarInfoHandlers = mutableList;
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final List<b> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return avatarInfoHandlers;
    }
}
