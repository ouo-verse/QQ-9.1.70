package kd2;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.bugly.library.BuglyAppVersionMode;
import com.tencent.common.config.AppSetting;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.app.privacy.PrivacyPolicyHelper;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.mobileqq.utils.f;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.RMonitor;
import com.tencent.rmonitor.RMonitorConstants;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.util.QQDeviceInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\t\u001a\u00020\u0002H\u0007J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0003J\u0006\u0010\u000e\u001a\u00020\u0002\u00a8\u0006\u0011"}, d2 = {"Lkd2/e;", "", "", "a", "b", "", "fromBugly", "", h.F, "g", "", "f", "c", "d", "e", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f412062a = new e();

    e() {
    }

    @JvmStatic
    @NotNull
    public static final String a() {
        if (!Intrinsics.areEqual("CheckIn", AppSetting.g())) {
            return "900035564";
        }
        return "505400831e";
    }

    @JvmStatic
    @NotNull
    public static final String b() {
        if (!Intrinsics.areEqual("CheckIn", AppSetting.g())) {
            return "edf7897a";
        }
        return "b85a40c6-595f-4fda-8541-a3216a51b4fa";
    }

    private final String c() {
        return BuglyAppVersionMode.RELEASE;
    }

    @SuppressLint({"HardwareIds"})
    private final String d() {
        String str;
        if (!PrivacyPolicyHelper.isUserAllow()) {
            return null;
        }
        try {
            str = DeviceInfoMonitor.getString(MobileQQ.sMobileQQ.getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID);
        } catch (Throwable th5) {
            QLog.e("RMonitorCommon", 1, "Settings.Secure.getString exception", th5);
            str = "";
        }
        if (str == null) {
            QLog.d("RMonitorCommon", 1, "get device id is null");
        } else if (QLog.isColorLevel()) {
            QLog.d("RMonitorCommon", 2, "get device id is " + str);
        }
        return str;
    }

    private final int f() {
        if (QLog.getUIN_REPORTLOG_LEVEL() >= 2) {
            return RMonitorConstants.f365247q;
        }
        return RMonitorConstants.f365244n;
    }

    @JvmStatic
    @NotNull
    public static final String g() {
        boolean z16;
        String str;
        List<SimpleAccount> allAccounts = MobileQQ.sMobileQQ.getAllAccounts();
        List<SimpleAccount> list = allAccounts;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN;
        }
        SimpleAccount simpleAccount = allAccounts.get(0);
        if (simpleAccount != null) {
            str = simpleAccount.getUin();
        } else {
            str = null;
        }
        if (str == null) {
            return MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN;
        }
        return str;
    }

    @JvmStatic
    public static final void h(boolean fromBugly) {
        Logger.f365497g.m(new a());
        e eVar = f412062a;
        RMonitor.setProperty(104, Integer.valueOf(eVar.f()));
        RMonitor.setProperty(111, new b());
        String g16 = g();
        String str = AppSetting.f99551k + '.' + f.a(BaseApplication.getContext());
        if (fromBugly) {
            CrashReport.setProductVersion(MobileQQ.sMobileQQ, str);
            CrashReport.setUserId(MobileQQ.sMobileQQ, g16);
            CrashReport.setDeviceModel(MobileQQ.sMobileQQ, eVar.e());
            String d16 = eVar.d();
            if (d16 != null) {
                CrashReport.setDeviceId(MobileQQ.sMobileQQ, d16);
                CrashReport.setTestLabels(com.tencent.qqperf.tools.d.b());
                return;
            }
            return;
        }
        String qimei = QQDeviceInfo.getQIMEI();
        RMonitor.setProperty(107, BaseApplication.getContext());
        RMonitor.setProperty(100, b());
        RMonitor.setProperty(101, a());
        RMonitor.setProperty(103, str);
        RMonitor.setProperty(102, g16);
        RMonitor.setProperty(112, eVar.c());
        RMonitor.setProperty(106, qimei);
    }

    @NotNull
    public final String e() {
        if (PrivacyPolicyHelper.isUserAllow() && !TextUtils.isEmpty(DeviceInfoMonitor.getModel())) {
            String model = DeviceInfoMonitor.getModel();
            Intrinsics.checkNotNullExpressionValue(model, "{\n            Build.MODEL\n        }");
            return model;
        }
        return "default_model";
    }
}
