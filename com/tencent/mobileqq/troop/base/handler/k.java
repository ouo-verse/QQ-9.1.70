package com.tencent.mobileqq.troop.base.handler;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopBeaconReporter;
import cooperation.qzone.QzoneIPCModule;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/troop/base/handler/k;", "", "", "a", "", "cmd", "", QzoneIPCModule.RESULT_CODE, "resultMsg", "", "costTime", "", "b", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f294613a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28312);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f294613a = new k();
        }
    }

    k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean a() {
        if (Math.random() < 0.01d) {
            return true;
        }
        return false;
    }

    public final void b(@NotNull String cmd, int resultCode, @NotNull String resultMsg, long costTime) {
        Map<String, ? extends Object> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, cmd, Integer.valueOf(resultCode), resultMsg, Long.valueOf(costTime));
            return;
        }
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(resultMsg, "resultMsg");
        if (a()) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("cmd", cmd), TuplesKt.to("result_code", Integer.valueOf(resultCode)), TuplesKt.to("result_msg", resultMsg), TuplesKt.to("cost_time", String.valueOf(costTime)));
            ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("group_quality_succ_rate_proto", mapOf);
        }
    }
}
