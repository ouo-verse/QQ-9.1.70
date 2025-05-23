package com.tencent.mobileqq.flock.utils;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.flock.feeddetail.request.FlockJoinRequest;
import com.tencent.mobileqq.flock.utils.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/flock/utils/e;", "", "Ly45/b;", "feed", "Lcom/tencent/mobileqq/flock/utils/e$a;", "callback", "", "b", "<init>", "()V", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f210484a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/flock/utils/e$a;", "", "", "onSuccess", "", "code", "", "msg", "onError", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface a {
        void onError(long code, @Nullable String msg2);

        void onSuccess();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49474);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f210484a = new e();
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(a callback, BaseRequest baseRequest, boolean z16, long j3, String str, a55.d dVar) {
        String str2;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        int i3 = RFWLog.USR;
        if (baseRequest != null) {
            str2 = baseRequest.getTraceId();
        } else {
            str2 = null;
        }
        RFWLog.i("FlockJoinGroupUtil", i3, "joinGroup, traceId:" + str2 + ", isSuccess:" + z16 + ", retCode:" + j3 + ", errMsg:" + str);
        if (z16 && j3 == 0 && dVar != null) {
            callback.onSuccess();
        } else {
            callback.onError(j3, str);
        }
    }

    public final void b(@NotNull y45.b feed, @NotNull final a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) feed, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(callback, "callback");
        VSNetworkHelper.getInstance().sendRequest(new FlockJoinRequest(feed), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.flock.utils.d
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                e.c(e.a.this, baseRequest, z16, j3, str, (a55.d) obj);
            }
        });
    }
}
