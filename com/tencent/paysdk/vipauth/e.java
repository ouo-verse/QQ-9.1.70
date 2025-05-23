package com.tencent.paysdk.vipauth;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00028\u0001\u00a2\u0006\u0004\b\t\u0010\u0007R(\u0010\u0004\u001a\u0004\u0018\u00018\u00002\b\u0010\n\u001a\u0004\u0018\u00018\u00008\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR(\u0010\b\u001a\u0004\u0018\u00018\u00012\b\u0010\n\u001a\u0004\u0018\u00018\u00018\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\u000b\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/paysdk/vipauth/e;", "PayItem", "Response", "", "payItem", "", "b", "(Ljava/lang/Object;)V", "response", "c", "<set-?>", "a", "Ljava/lang/Object;", "getPayItem", "()Ljava/lang/Object;", "<init>", "()V", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes22.dex */
public final class e<PayItem, Response> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PayItem payItem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Response response;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Nullable
    public final Response a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Response) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.response;
    }

    public final void b(PayItem payItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) payItem);
        } else {
            this.payItem = payItem;
        }
    }

    public final void c(Response response) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) response);
        } else {
            this.response = response;
        }
    }
}
