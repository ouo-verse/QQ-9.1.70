package com.tencent.mobileqq.troop.homework.homework.submit.sso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\u0004\u0005\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/a;", "Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/h;", "<init>", "()V", "Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/b;", "Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/e;", "Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/j;", "Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/k;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public abstract class a implements h {
    static IPatchRedirector $redirector_;

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
