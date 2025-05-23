package com.tencent.qne.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qne/model/d;", "Lcom/tencent/qne/model/b;", "<init>", "()V", "qne_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes22.dex */
public final class d extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final d f344351c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14833);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f344351c = new d();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    d() {
        super("kirin_9000s", r0, null);
        List listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"BRA-AL00", "ALN-AL00", "ALN-AL80", "ALN-AL10", "ALT-AL10", "GRL-AL10"});
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
