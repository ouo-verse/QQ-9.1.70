package com.tencent.qqnt.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/bean/c;", "", "Lcom/tencent/qqnt/bean/e;", "a", "Lcom/tencent/qqnt/bean/e;", "b", "()Lcom/tencent/qqnt/bean/e;", "secPrompt", "Lcom/tencent/qqnt/bean/d;", "Lcom/tencent/qqnt/bean/d;", "()Lcom/tencent/qqnt/bean/d;", "kaiYang", "<init>", "(Lcom/tencent/qqnt/bean/e;Lcom/tencent/qqnt/bean/d;)V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final e secPrompt;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final d kaiYang;

    public c(@Nullable e eVar, @Nullable d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar, (Object) dVar);
        } else {
            this.secPrompt = eVar;
            this.kaiYang = dVar;
        }
    }

    @Nullable
    public final d a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.kaiYang;
    }

    @Nullable
    public final e b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (e) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.secPrompt;
    }
}
