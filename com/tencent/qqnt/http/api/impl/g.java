package com.tencent.qqnt.http.api.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.http.api.l;
import com.tencent.qqnt.http.api.m;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0017B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0004\u001a\u00020\u0003J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/http/api/impl/g;", "Lcom/tencent/qqnt/http/api/impl/a;", "Lokhttp3/Callback;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lokhttp3/Call;", "call", "Ljava/io/IOException;", "e", "onFailure", "Lokhttp3/Response;", "response", "onResponse", "", "c", "g", "Lcom/tencent/qqnt/http/api/b;", "task", "Lcom/tencent/qqnt/http/api/impl/e;", "onCall", "<init>", "(Lcom/tencent/qqnt/http/api/b;Lcom/tencent/qqnt/http/api/impl/e;)V", tl.h.F, "a", "http_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class g extends a implements Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/http/api/impl/g$a;", "", "", "NO_NETWORK_RETRY_TIME_INTERVAL", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "http_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.http.api.impl.g$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32541);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull com.tencent.qqnt.http.api.b task, @NotNull e onCall) {
        super(task, onCall);
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(onCall, "onCall");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) task, (Object) onCall);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m();
    }

    @Override // com.tencent.qqnt.http.api.impl.a
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        com.tencent.qqnt.http.api.h p16 = e().p();
        if (p16 != null) {
            return p16.a();
        }
        return false;
    }

    @Override // com.tencent.qqnt.http.api.impl.a
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.g();
        if (f()) {
            m();
        } else {
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.qqnt.http.api.impl.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.l(g.this);
                }
            }, 128, null, true, 6000L);
        }
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            if (!d().hasSameTask(e())) {
                d().generateCall(e()).enqueue(this);
            }
        } catch (Exception e16) {
            j(e16);
            m a16 = a();
            QLog.w("NTHttp.ProcessTaskCallBack", 1, "task:" + e().u() + " submit error,taskResult:" + a16, e16);
            l v3 = e().v();
            if (v3 != null) {
                v3.onFailed(e(), a16);
            }
        }
    }

    @Override // okhttp3.Callback
    public void onFailure(@NotNull Call call, @NotNull IOException e16) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) call, (Object) e16);
            return;
        }
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(e16, "e");
        QLog.e("NTHttp.ProcessTaskCallBack", 1, "task:" + e().u() + " connect error", e16);
        d().onCallFinish(call, e());
        b.a(e());
        h(call, e16);
        if (b()) {
            QLog.i("NTHttp.ProcessTaskCallBack", 1, "task:" + e().u() + " retry");
            g();
            return;
        }
        m a16 = a();
        QLog.w("NTHttp.ProcessTaskCallBack", 1, "task:" + e().u() + " execute error,taskResult:" + a16);
        l v3 = e().v();
        if (v3 != null) {
            v3.onFailed(e(), a16);
        }
        d().notifySameTask(e(), a16);
        com.tencent.qqnt.http.api.i iVar = com.tencent.qqnt.http.api.i.f356996a;
        com.tencent.qqnt.http.api.b e17 = e();
        c a17 = com.tencent.qqnt.http.okhttp3.c.a(call);
        if (a17 != null) {
            j3 = a17.a();
        } else {
            j3 = -1;
        }
        iVar.b(e17, a16, j3);
    }

    @Override // okhttp3.Callback
    public void onResponse(@NotNull Call call, @NotNull Response response) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) call, (Object) response);
            return;
        }
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        d().onCallFinish(call, e());
        long j3 = -1;
        if (i(response)) {
            m a16 = a();
            QLog.i("NTHttp.ProcessTaskCallBack", 1, "task:" + e().u() + " execute success,taskResult:" + a16 + " transSize:" + e().s());
            l v3 = e().v();
            if (v3 != null) {
                v3.onSuccess(e(), a16);
            }
            d().notifySameTask(e(), a16);
            com.tencent.qqnt.http.api.i iVar = com.tencent.qqnt.http.api.i.f356996a;
            com.tencent.qqnt.http.api.b e16 = e();
            c a17 = com.tencent.qqnt.http.okhttp3.c.a(call);
            if (a17 != null) {
                j3 = a17.a();
            }
            iVar.b(e16, a16, j3);
            return;
        }
        b.a(e());
        if (b()) {
            QLog.i("NTHttp.ProcessTaskCallBack", 1, "task:" + e().u() + " retry");
            g();
            return;
        }
        m a18 = a();
        QLog.w("NTHttp.ProcessTaskCallBack", 1, "task:" + e().u() + " execute error,taskResult:" + a18);
        l v16 = e().v();
        if (v16 != null) {
            v16.onFailed(e(), a18);
        }
        d().notifySameTask(e(), a18);
        com.tencent.qqnt.http.api.i iVar2 = com.tencent.qqnt.http.api.i.f356996a;
        com.tencent.qqnt.http.api.b e17 = e();
        c a19 = com.tencent.qqnt.http.okhttp3.c.a(call);
        if (a19 != null) {
            j3 = a19.a();
        }
        iVar2.b(e17, a18, j3);
    }
}
