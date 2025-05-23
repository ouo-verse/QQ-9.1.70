package com.tencent.mobileqq.statistics.tianjige.tracers;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tianjige.e;
import com.tencent.mobileqq.tianjige.f;
import com.tencent.mobileqq.tianjige.i;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J\u001c\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0010\u001a\u00020\u000fH\u0002\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/statistics/tianjige/tracers/a;", "", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/mobileqq/data/MessageRecord;", "mr", "", "resendByUser", "", "retryIndex", "", WadlProxyConsts.PARAM_TIME_OUT, "", "f", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "resp", "c", "b", "d", "e", "", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f290151a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61769);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f290151a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Map<String, String> a(FromServiceMsg resp) {
        ArrayMap arrayMap = new ArrayMap();
        e.a(resp, arrayMap);
        return arrayMap;
    }

    @JvmStatic
    public static final void b(@NotNull ToServiceMsg req, @NotNull FromServiceMsg resp) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(resp, "resp");
        com.tencent.mobileqq.statistics.tianjige.metrics.a.f290143a.d(req, resp);
        String c16 = i.c(req);
        if (TextUtils.isEmpty(c16)) {
            return;
        }
        f.b().g(c16, "UIRefresh", null);
        f.b().a(c16, 0, f290151a.a(resp));
    }

    @JvmStatic
    public static final void c(@NotNull ToServiceMsg req, @NotNull FromServiceMsg resp) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(resp, "resp");
        String c16 = i.c(req);
        if (TextUtils.isEmpty(c16)) {
            return;
        }
        f.b().g(c16, "RecvRespFromMSF", new i.a().d(0).a());
    }

    @JvmStatic
    public static final void d(@NotNull ToServiceMsg req, @NotNull FromServiceMsg resp) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(resp, "resp");
        String c16 = i.c(req);
        if (TextUtils.isEmpty(c16)) {
            return;
        }
        f.b().g(c16, "RecvRespFromMSF", new i.a().d(resp.getResultCode()).c(resp.getBusinessFailMsg()).a());
        f.b().a(c16, -1, f290151a.a(resp));
    }

    @JvmStatic
    public static final void e(@NotNull ToServiceMsg req, @NotNull FromServiceMsg resp) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(resp, "resp");
        String c16 = i.c(req);
        if (TextUtils.isEmpty(c16)) {
            return;
        }
        f.b().g(c16, "RecvRespFromMSF", new i.a().d(resp.getResultCode()).c("timeout").a());
        f.b().a(c16, -1, f290151a.a(resp));
    }

    @JvmStatic
    public static final void f(@NotNull ToServiceMsg request, @NotNull MessageRecord mr5, boolean resendByUser, int retryIndex, long timeOut) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(mr5, "mr");
        if (TextUtils.isEmpty(mr5.telemetryTracerKey)) {
            return;
        }
        f.b().j(mr5.telemetryTracerKey, "SendMessageInner", request, new i.a().b("retryIndex", String.valueOf(retryIndex)).b("retryTimeout", String.valueOf(timeOut)).b("isResendByUser", String.valueOf(resendByUser)).a());
    }
}
