package com.tencent.mobileqq.vashealth.huawei;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.hihealth.ConsentsController;
import com.huawei.hms.hihealth.DataController;
import com.huawei.hms.hihealth.HiHealthStatusCodes;
import com.huawei.hms.hihealth.HuaweiHiHealth;
import com.huawei.hms.hihealth.SettingController;
import com.huawei.hms.hihealth.data.DataType;
import com.huawei.hms.hihealth.data.Field;
import com.huawei.hms.hihealth.data.SamplePoint;
import com.huawei.hms.hihealth.data.SampleSet;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.vashealth.StepCounterPermissionUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HuaWeiStepAuthManager {

    /* renamed from: d, reason: collision with root package name */
    private static volatile HuaWeiStepAuthManager f312299d;

    /* renamed from: a, reason: collision with root package name */
    private final Context f312300a;

    /* renamed from: b, reason: collision with root package name */
    private final SettingController f312301b;

    /* renamed from: c, reason: collision with root package name */
    private volatile int f312302c = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements OnFailureListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f312303a;

        a(boolean z16) {
            this.f312303a = z16;
        }

        @Override // com.huawei.hmf.tasks.OnFailureListener
        public void onFailure(Exception exc) {
            QLog.e("HuaWeiStepAuthManager", 1, "getHealthAppAuthorization failed: " + exc);
            if (!(exc instanceof ApiException)) {
                return;
            }
            int statusCode = ((ApiException) exc).getStatusCode();
            StepCounterPermissionUtils.o(true);
            if (statusCode == 50005) {
                StepCounterPermissionUtils.p(false);
                if (this.f312303a) {
                    QLog.d("HuaWeiStepAuthManager", 1, "getHealthAppAuth failed and requestAuth, error code:" + statusCode);
                    HuaWeiStepAuthManager.this.m();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements OnSuccessListener<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f312305a;

        b(boolean z16) {
            this.f312305a = z16;
        }

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Boolean bool) {
            QLog.d("HuaWeiStepAuthManager", 1, "getHealthAppAuthorization is " + bool);
            if (bool.booleanValue()) {
                StepCounterPermissionUtils.o(true);
                StepCounterPermissionUtils.p(true);
                try {
                    HuaWeiStepAuthManager.this.k();
                    return;
                } catch (Exception e16) {
                    QLog.d("HuaWeiStepAuthManager", 1, "queryTodayStep fail, error is " + e16);
                    return;
                }
            }
            StepCounterPermissionUtils.p(false);
            StepCounterPermissionUtils.o(false);
            if (this.f312305a && HuaWeiStepAuthManager.e(HuaWeiStepAuthManager.this.f312300a)) {
                HuaWeiStepAuthManager.this.m();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class c implements OnFailureListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.vashealth.huawei.b f312307a;

        c(com.tencent.mobileqq.vashealth.huawei.b bVar) {
            this.f312307a = bVar;
        }

        @Override // com.huawei.hmf.tasks.OnFailureListener
        public void onFailure(Exception exc) {
            this.f312307a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class d implements OnSuccessListener<Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.vashealth.huawei.b f312309a;

        d(com.tencent.mobileqq.vashealth.huawei.b bVar) {
            this.f312309a = bVar;
        }

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r16) {
            this.f312309a.a();
            StepCounterPermissionUtils.p(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class e implements OnSuccessListener<SampleSet> {
        e() {
        }

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(SampleSet sampleSet) {
            QLog.d("HuaWeiStepAuthManager", 1, "Success read today summation from HMS core");
            if (sampleSet != null) {
                HuaWeiStepAuthManager.this.n(true, HuaWeiStepAuthManager.this.l(sampleSet));
            } else {
                HuaWeiStepAuthManager.this.n(false, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class f implements OnFailureListener {
        f() {
        }

        @Override // com.huawei.hmf.tasks.OnFailureListener
        public void onFailure(Exception exc) {
            String message = exc.getMessage();
            QLog.e("HuaWeiStepAuthManager", 1, message + MsgSummary.STR_COLON + HiHealthStatusCodes.getStatusCodeMessage(Integer.parseInt(message)));
            HuaWeiStepAuthManager.this.n(false, 0);
        }
    }

    public HuaWeiStepAuthManager(@NotNull Context context) {
        this.f312300a = context.getApplicationContext();
        if (Foreground.getTopActivity() == null) {
            QLog.e("HuaWeiStepAuthManager", 1, "sTopActivity is null");
            this.f312301b = HuaweiHiHealth.getSettingController(context);
        } else {
            this.f312301b = HuaweiHiHealth.getSettingController(Foreground.getTopActivity());
        }
    }

    public static boolean e(Context context) {
        boolean z16;
        float decodeLong = (float) QMMKV.from(context, "common_mmkv_configurations").decodeLong("recent_request_huawei_health_permission_time", 0L);
        QLog.d("HuaWeiStepAuthManager", 1, "allowHuaWeiRequestAuthPopUp time " + decodeLong + "  " + System.currentTimeMillis());
        if (((float) System.currentTimeMillis()) - decodeLong > 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("HuaWeiStepAuthManager", 1, "allowHuaWeiRequestAuthPopUp: " + z16);
        return z16;
    }

    private void g(boolean z16) {
        SettingController settingController = this.f312301b;
        if (settingController == null) {
            QLog.d("HuaWeiStepAuthManager", 1, "mSettingController is null, getHealthAppAuthorization cancel");
            return;
        }
        Task<Boolean> healthAppAuthorization = settingController.getHealthAppAuthorization();
        healthAppAuthorization.addOnFailureListener(new a(z16));
        healthAppAuthorization.addOnSuccessListener(new b(z16));
    }

    public static HuaWeiStepAuthManager h(Context context) {
        if (f312299d == null) {
            synchronized (HuaWeiStepAuthManager.class) {
                if (f312299d == null) {
                    f312299d = new HuaWeiStepAuthManager(context);
                }
            }
        }
        return f312299d;
    }

    private boolean i(long j3, long j16) {
        if (j3 >= com.tencent.mobileqq.vashealth.huawei.c.b() && j16 <= com.tencent.mobileqq.vashealth.huawei.c.a()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l(SampleSet sampleSet) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (SamplePoint samplePoint : sampleSet.getSamplePoints()) {
            QLog.d("HuaWeiStepAuthManager", 1, "Sample point type: " + samplePoint.getDataType().getName());
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            long startTime = samplePoint.getStartTime(timeUnit);
            long endTime = samplePoint.getEndTime(timeUnit);
            QLog.d("HuaWeiStepAuthManager", 1, "Start: " + simpleDateFormat.format(new Date(startTime)));
            QLog.d("HuaWeiStepAuthManager", 1, "End: " + simpleDateFormat.format(new Date(endTime)));
            for (Field field : samplePoint.getDataType().getFields()) {
                QLog.d("HuaWeiStepAuthManager", 1, "Field: " + field.getName() + " Value: " + samplePoint.getFieldValue(field));
                if (samplePoint.getFieldValue(field).asIntValue() != 0 && i(startTime, endTime)) {
                    this.f312302c = samplePoint.getFieldValue(field).asIntValue();
                    QLog.d("HuaWeiStepAuthManager", 1, "Today step value is: " + this.f312302c);
                    return this.f312302c;
                }
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        QMMKV.from(this.f312300a, "common_mmkv_configurations").encodeLong("recent_request_huawei_health_permission_time", System.currentTimeMillis());
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vashealth.huawei.HuaWeiStepAuthManager.3
            @Override // java.lang.Runnable
            public void run() {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("action", "com.tencent.huawei.step.auth_action");
                intent.putExtra("paramsBundle", bundle);
                intent.addFlags(268435456);
                QLog.d("HuaWeiStepAuthManager", 1, "start requestAuth activity");
                QPublicFragmentActivity.start(BaseApplication.getContext(), intent, HuaWeiStepAuthFragment.class);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z16, int i3) {
        Intent intent = new Intent();
        intent.setAction("com.tencent.huawei.step.broadcast_action");
        intent.setPackage(this.f312300a.getPackageName());
        intent.putExtra("authResult", z16);
        intent.putExtra("stepData", i3);
        this.f312300a.sendBroadcast(intent);
    }

    public void f(com.tencent.mobileqq.vashealth.huawei.b bVar) {
        ConsentsController consentsController = HuaweiHiHealth.getConsentsController(this.f312300a);
        if (consentsController == null) {
            QLog.d("HuaWeiStepAuthManager", 1, "consentsController is null, cancelHuaweiPermission cancel");
        } else {
            consentsController.cancelAuthorization(false).addOnSuccessListener(new d(bVar)).addOnFailureListener(new c(bVar));
        }
    }

    public void j(int i3, boolean z16) {
        QLog.d("HuaWeiStepAuthManager", 1, "queryHuaWeiSdkTodaySteps allowShowAuth: " + z16);
        g(z16);
    }

    public void k() {
        DataController dataController = HuaweiHiHealth.getDataController(this.f312300a);
        if (dataController == null) {
            QLog.d("HuaWeiStepAuthManager", 1, "dataController is null, queryTodayStep cancel");
            return;
        }
        Task<SampleSet> readTodaySummation = dataController.readTodaySummation(DataType.DT_CONTINUOUS_STEPS_DELTA);
        readTodaySummation.addOnSuccessListener(new e());
        readTodaySummation.addOnFailureListener(new f());
    }
}
