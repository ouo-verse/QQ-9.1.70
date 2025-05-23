package com.tencent.cache.core.util;

import com.tencent.cache.api.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class d extends Lambda implements Function1<Map.Entry<? extends String, ? extends List<? extends com.tencent.cache.core.bitmap.cache.b<?, ?>>>, CharSequence> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final d f98835a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14817);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f98835a = new d();
        }
    }

    public d() {
        super(1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Type inference failed for: r8v11, types: [java.lang.CharSequence, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public CharSequence invoke(Map.Entry<? extends String, ? extends List<? extends com.tencent.cache.core.bitmap.cache.b<?, ?>>> entry) {
        Class<?> cls;
        com.tencent.cache.core.bitmap.cache.b<?, ?> bVar;
        V v3;
        com.tencent.cache.core.bitmap.cache.b<?, ?> bVar2;
        V v16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) entry);
        }
        Map.Entry<? extends String, ? extends List<? extends com.tencent.cache.core.bitmap.cache.b<?, ?>>> it = entry;
        Intrinsics.checkNotNullParameter(it, "it");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[ businessName:");
        StringBuilder a16 = h.a(sb5, it.getKey(), ", ", "itemCount:");
        a16.append(it.getValue().size());
        a16.append(", ");
        a16.append("sizeSum:");
        Iterator<T> it5 = it.getValue().iterator();
        boolean z16 = false;
        int i3 = 0;
        while (it5.hasNext()) {
            i3 += ((com.tencent.cache.core.bitmap.cache.b) it5.next()).f98663e;
        }
        a16.append(i3);
        a16.append(", ");
        a16.append("firstItemType:");
        List<? extends com.tencent.cache.core.bitmap.cache.b<?, ?>> value = it.getValue();
        Class<?> cls2 = null;
        if (!(!value.isEmpty())) {
            value = null;
        }
        List<? extends com.tencent.cache.core.bitmap.cache.b<?, ?>> list = value;
        if (list != null && (bVar2 = list.get(0)) != null && (v16 = bVar2.f98664f) != 0) {
            cls = v16.getClass();
        } else {
            cls = null;
        }
        a16.append(cls);
        a16.append(", ");
        a16.append("secondItemType:");
        List<? extends com.tencent.cache.core.bitmap.cache.b<?, ?>> value2 = it.getValue();
        if (value2.size() > 1) {
            z16 = true;
        }
        if (!z16) {
            value2 = null;
        }
        List<? extends com.tencent.cache.core.bitmap.cache.b<?, ?>> list2 = value2;
        if (list2 != null && (bVar = list2.get(1)) != null && (v3 = bVar.f98664f) != 0) {
            cls2 = v3.getClass();
        }
        a16.append(cls2);
        a16.append(" ]");
        return a16.toString();
    }
}
