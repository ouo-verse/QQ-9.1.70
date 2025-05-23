package com.tencent.mobileqq.gateway.localphone.ecdh;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginStatus;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import java.util.Random;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J6\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/gateway/localphone/ecdh/j;", "", "", "tag", "", "isSuccess", "", "serviceType", "phoneType", QzoneIPCModule.RESULT_CODE, "", "costTime", "", "a", "b", "Z", "GET_PHONE_NEED_REPORT", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f213630a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean GET_PHONE_NEED_REPORT;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19435);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f213630a = new j();
        boolean z16 = true;
        if (new Random().nextInt(10) != 1) {
            z16 = false;
        }
        GET_PHONE_NEED_REPORT = z16;
    }

    j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull String tag, boolean isSuccess, int serviceType, int phoneType, int resultCode, long costTime) {
        boolean contains;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, tag, Boolean.valueOf(isSuccess), Integer.valueOf(serviceType), Integer.valueOf(phoneType), Integer.valueOf(resultCode), Long.valueOf(costTime));
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (!GET_PHONE_NEED_REPORT) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("isSuccess", String.valueOf(isSuccess));
        hashMap.put("serviceType", String.valueOf(serviceType));
        hashMap.put("retCode", String.valueOf(resultCode));
        hashMap.put("costTime", String.valueOf(costTime));
        hashMap.put("phoneType", String.valueOf(phoneType));
        contains = ArraysKt___ArraysKt.contains(g.f213618a.e(), serviceType);
        if (contains) {
            hashMap.put(QAdLoginDefine$LoginStatus.IS_LOGIN, "true");
        } else {
            hashMap.put(QAdLoginDefine$LoginStatus.IS_LOGIN, "false");
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime.isLogin()) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = "";
        }
        QQBeaconReport.report(str, tag, hashMap);
    }
}
