package com.tencent.qqprotect.common;

import android.os.Build;
import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.common.pb.SafeReport$ReqBody;
import com.tencent.qqprotect.common.pb.SafeReport$RspBody;
import java.nio.charset.StandardCharsets;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            if (i3 == 0 && bArr != null) {
                SafeReport$RspBody safeReport$RspBody = new SafeReport$RspBody();
                try {
                    safeReport$RspBody.mergeFrom(bArr);
                    if (safeReport$RspBody.uint32_result.has() && QLog.isColorLevel()) {
                        QLog.d("QSRPT", 2, String.format("report result: %d", Integer.valueOf(safeReport$RspBody.uint32_result.get())));
                    }
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(AppInterface appInterface, SafeReport$ReqBody safeReport$ReqBody) {
        if (safeReport$ReqBody == null) {
            return;
        }
        if (appInterface == null) {
            appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        }
        ProtoUtils.d(appInterface, new a(), safeReport$ReqBody.toByteArray(), "MqqSafeDataRpt.MQDun");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int c(int i3) {
        if (i3 > 100) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String d(int i3) {
        try {
            byte[] c16 = com.tencent.mobileqq.guid.c.f213821a.c();
            if (c16 == null) {
                c16 = "".getBytes(StandardCharsets.UTF_8);
            }
            String t16 = ah.t();
            String Q = ah.Q(MobileQQ.sMobileQQ);
            String e16 = b.e();
            String f16 = b.f();
            String str = Build.CPU_ABI;
            String model = DeviceInfoMonitor.getModel();
            String str2 = Build.MANUFACTURER;
            d dVar = new d();
            dVar.c(c16).b(t16).b(Q).b(e16).b(f16).b(str).b(model).b(str2);
            if (i3 >= 2) {
                dVar.b(com.tencent.qqprotect.common.a.a()).a(AppSetting.f()).b("").b("").b("");
            }
            return dVar.toString();
        } catch (Throwable th5) {
            th5.printStackTrace();
            if (i3 < 2) {
                return ",,,,,,,";
            }
            return ",,,,,,,,,,,";
        }
    }
}
