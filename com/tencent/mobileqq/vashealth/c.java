package com.tencent.mobileqq.vashealth;

import android.os.Bundle;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vashealth/c;", "", "", "retCode", "sensorStep", "Lcom/tencent/mobileqq/vashealth/c$a;", "callback", "", "b", "c", "", "g", "", "f", "", "e", "<init>", "()V", "a", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f312250a = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/vashealth/c$a;", "", "", "retCode", "step", "", "a", "health-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface a {
        void a(int retCode, int step);
    }

    c() {
    }

    private final void b(int retCode, int sensorStep, a callback) {
        if (callback == null) {
            return;
        }
        int i3 = SSOHttpUtils.e()[1];
        if (SSOHttpUtils.n(i3)) {
            callback.a(retCode, i3);
            QLog.d("HealthCommonMethods", 1, "use device sdk step:", Integer.valueOf(i3));
        } else {
            callback.a(retCode, sensorStep);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Ref.IntRef retCode, a callback, int i3, boolean z16, Bundle bundle) {
        int i16;
        HashMap hashMap;
        boolean z17;
        Intrinsics.checkNotNullParameter(retCode, "$retCode");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (z16) {
            QLog.i("HealthCommonMethods", 1, "receive stepInfoJson: " + bundle.getString("StepInfoJSON"));
            int i17 = 0;
            try {
                retCode.element = 0;
                Serializable serializable = bundle.getSerializable(StepCounterConstants.ATTR_STEP_COUNT_HISTORY);
                if (serializable instanceof HashMap) {
                    hashMap = (HashMap) serializable;
                } else {
                    hashMap = null;
                }
                long d16 = SSOHttpUtils.d() / 1000;
                if (hashMap != null && hashMap.containsKey(Long.valueOf(d16))) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    Object obj = hashMap.get(Long.valueOf(d16));
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    int intValue = ((Integer) obj).intValue();
                    try {
                        QLog.d("HealthCommonMethods", 2, " day key is: " + d16 + ", current step: " + intValue);
                        i17 = intValue;
                    } catch (JSONException e16) {
                        i16 = intValue;
                        e = e16;
                        try {
                            QLog.e("HealthCommonMethods", 1, "receive stepInfoJson failed exception is:" + e);
                            callback.a(-1, 0);
                            f312250a.b(retCode.element, i16, callback);
                            return;
                        } catch (Throwable th5) {
                            th = th5;
                            i17 = i16;
                            f312250a.b(retCode.element, i17, callback);
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        i17 = intValue;
                        f312250a.b(retCode.element, i17, callback);
                        throw th;
                    }
                }
                f312250a.b(retCode.element, i17, callback);
            } catch (JSONException e17) {
                e = e17;
                i16 = 0;
            } catch (Throwable th7) {
                th = th7;
            }
        }
    }

    public final void c(@NotNull final a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        try {
            NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), u.class);
            newIntent.putExtra("msf_cmd_type", StepCounterConstants.CMD_REFRESH_STEPS);
            newIntent.putExtra(StepCounterConstants.ATTR_IS_REPORT_STEP, true);
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = -1;
            com.tencent.mobileqq.vashealth.step.k kVar = com.tencent.mobileqq.vashealth.step.k.f312340a;
            if (kVar.j()) {
                int b16 = com.tencent.mobileqq.vashealth.step.e.f312337a.b(String.valueOf(com.tencent.mobileqq.vashealth.step.l.f312344a.a(0)));
                intRef.element = kVar.q();
                QLog.d("HealthCommonMethods", 2, " current step: " + b16);
                b(intRef.element, b16, callback);
                return;
            }
            newIntent.setObserver(new BusinessObserver() { // from class: com.tencent.mobileqq.vashealth.b
                @Override // mqq.observer.BusinessObserver
                public final void onReceive(int i3, boolean z16, Bundle bundle) {
                    c.d(Ref.IntRef.this, callback, i3, z16, bundle);
                }
            });
            peekAppRuntime.startServlet(newIntent);
        } catch (Exception e16) {
            callback.a(-1, 0);
            QLog.e("HealthCommonMethods", 1, e16, new Object[0]);
        }
    }

    public final long e() {
        try {
            return MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin();
        } catch (Throwable th5) {
            QLog.e("HealthCommonMethods", 1, "get uin failed, error is " + th5);
            return 0L;
        }
    }

    @NotNull
    public final String f() {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public final boolean g() {
        if (PadUtil.a(BaseApplication.getContext()) == DeviceType.TABLET) {
            return true;
        }
        return false;
    }
}
