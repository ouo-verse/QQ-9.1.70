package com.tencent.cache.core.manager.control;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class b extends Lambda implements Function1<Map.Entry<String, Map<String, Integer>>, CharSequence> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final b f98727a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13757);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f98727a = new b();
        }
    }

    public b() {
        super(1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.CharSequence, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public CharSequence invoke(Map.Entry<String, Map<String, Integer>> entry) {
        String joinToString$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) entry);
        }
        Map.Entry<String, Map<String, Integer>> it = entry;
        Intrinsics.checkNotNullParameter(it, "it");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(it.getValue().entrySet(), ",", null, null, 0, null, a.f98726a, 30, null);
        return it.getKey() + ":" + joinToString$default;
    }
}
