package com.tencent.mobileqq.flock.scheme.parser;

import android.content.Context;
import b55.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ4\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/flock/scheme/parser/c;", "Lcom/tencent/mobileqq/flock/scheme/parser/d;", "Landroid/content/Context;", "context", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "params", "", "a", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c extends d {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.flock.scheme.parser.d
    public void a(@NotNull Context context, @NotNull HashMap<String, String> params) {
        g gVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        boolean z16 = false;
        int a16 = com.tencent.mobileqq.flock.scheme.a.a(params, "qevent_from", 0);
        long b16 = com.tencent.mobileqq.flock.scheme.a.b(params, "group_id", 0L);
        int a17 = com.tencent.mobileqq.flock.scheme.a.a(params, "tag_id", 0);
        String str = params.get("tag_name");
        if (a17 != 0) {
            if (str == null || str.length() == 0) {
                z16 = true;
            }
            if (!z16) {
                g gVar2 = new g();
                gVar2.f27973a = a17;
                gVar2.f27974b = str;
                gVar = gVar2;
                com.tencent.mobileqq.flock.a.e(com.tencent.mobileqq.flock.a.f209993a, context, a16, Long.valueOf(b16), null, gVar, 8, null);
            }
        }
        gVar = null;
        com.tencent.mobileqq.flock.a.e(com.tencent.mobileqq.flock.a.f209993a, context, a16, Long.valueOf(b16), null, gVar, 8, null);
    }
}
