package com.tencent.cache.core.manager.control;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class a extends Lambda implements Function1<Map.Entry<String, Integer>, CharSequence> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final a f98726a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13751);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f98726a = new a();
        }
    }

    public a() {
        super(1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.CharSequence, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public CharSequence invoke(Map.Entry<String, Integer> entry) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) entry);
        }
        Map.Entry<String, Integer> entry2 = entry;
        Intrinsics.checkNotNullParameter(entry2, "entry");
        return entry2.getKey() + "-" + entry2.getValue().intValue();
    }
}
