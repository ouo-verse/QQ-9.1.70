package com.tencent.qqnt.http.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.http.api.m;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/http/api/impl/i;", "Lcom/tencent/qqnt/http/api/impl/a;", "Lcom/tencent/qqnt/http/api/m;", "k", "Lcom/tencent/qqnt/http/api/b;", "task", "Lcom/tencent/qqnt/http/api/impl/e;", "onCall", "<init>", "(Lcom/tencent/qqnt/http/api/b;Lcom/tencent/qqnt/http/api/impl/e;)V", tl.h.F, "a", "http_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class i extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/http/api/impl/i$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "http_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.http.api.impl.i$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32693);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull com.tencent.qqnt.http.api.b task, @NotNull e onCall) {
        super(task, onCall);
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(onCall, "onCall");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) task, (Object) onCall);
        }
    }

    @NotNull
    public final m k() {
        boolean z16;
        c a16;
        c a17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (m) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        while (true) {
            try {
                Call generateCall = d().generateCall(e());
                try {
                    z16 = i(generateCall.execute());
                } catch (IOException e16) {
                    h(generateCall, e16);
                    QLog.w("NTHttp.TaskProcess", 1, "task:" + e().u() + " connect error, ", e16);
                    z16 = false;
                }
                d().onCallFinish(generateCall, e());
                m a18 = a();
                long j3 = -1;
                if (z16) {
                    QLog.i("NTHttp.TaskProcess", 1, "task:" + e().u() + " execute success,taskResult:" + a18 + " transSize:" + e().s());
                    com.tencent.qqnt.http.api.i iVar = com.tencent.qqnt.http.api.i.f356996a;
                    com.tencent.qqnt.http.api.b e17 = e();
                    if (generateCall != null && (a16 = com.tencent.qqnt.http.okhttp3.c.a(generateCall)) != null) {
                        j3 = a16.a();
                    }
                    iVar.b(e17, a18, j3);
                    return a18;
                }
                b.a(e());
                if (b()) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("NTHttp.TaskProcess", 1, "task:" + e().u() + " retry");
                    }
                    g();
                } else {
                    QLog.w("NTHttp.TaskProcess", 1, "task:" + e().u() + " execute error,taskResult:" + a18);
                    com.tencent.qqnt.http.api.i iVar2 = com.tencent.qqnt.http.api.i.f356996a;
                    com.tencent.qqnt.http.api.b e18 = e();
                    if (generateCall != null && (a17 = com.tencent.qqnt.http.okhttp3.c.a(generateCall)) != null) {
                        j3 = a17.a();
                    }
                    iVar2.b(e18, a18, j3);
                    return a18;
                }
            } catch (Exception e19) {
                j(e19);
                m a19 = a();
                QLog.w("NTHttp.TaskProcess", 1, "task:" + e().u() + " submit error,taskResult:" + a19, e19);
                return a19;
            }
        }
    }
}
