package com.tencent.mobileqq.qqcoroutine_api;

import com.tencent.mobileqq.qcoroutine.api.DispatcherType;
import com.tencent.mobileqq.qcoroutine.api.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqcoroutine_api/a;", "Lcom/tencent/mobileqq/qcoroutine/api/b;", "<init>", "()V", "QQCoroutine_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f262384e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39229);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f262384e = new a();
        }
    }

    a() {
        super(false, DispatcherType.MAIN);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
