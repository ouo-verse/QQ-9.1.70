package com.huawei.hms.health;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.hihealth.HiHealthKitClient;
import com.huawei.hms.hihealth.HiHealthStatusCodes;
import com.huawei.hms.hihealth.data.ActivityRecord;
import com.huawei.hms.hihealth.data.AppInfo;
import com.huawei.hms.hihealth.data.ComponentInfo;
import com.huawei.hms.hihealth.data.HealthKitApiInvoker;
import com.huawei.hms.hihealth.options.ActivityRecordDeleteOptions;
import com.huawei.hms.hihealth.options.ActivityRecordInsertOptions;
import com.huawei.hms.hihealth.options.ActivityRecordReadOptions;
import com.huawei.hms.hihealth.options.OnActivityRecordListener;
import com.huawei.hms.hihealth.result.ActivityRecordResult;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aace implements com.huawei.hms.hihealth.aabd {
    private static volatile aace aaba;
    private static volatile HealthKitApiInvoker aabb;
    private final String aab = HiHealthKitClient.getInstance().getContext().getPackageName();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class aab implements Callable<Void> {
        final /* synthetic */ ActivityRecord aab;
        final /* synthetic */ HealthKitApiInvoker aaba;

        aab(ActivityRecord activityRecord, HealthKitApiInvoker healthKitApiInvoker) {
            this.aab = activityRecord;
            this.aaba = healthKitApiInvoker;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            ActivityRecord activityRecord;
            if (TextUtils.isEmpty(this.aab.getPackageName())) {
                activityRecord = aace.this.aaba(this.aab);
            } else {
                activityRecord = this.aab;
            }
            this.aaba.setInterfaceProvider("ActivityRecordsController");
            this.aaba.setInterfaceInvoked("beginActivityRecord");
            this.aaba.setRequestBody(aacu.aab(activityRecord));
            aaci.aabc().aab(this.aaba);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class aaba implements Callable<Void> {
        private final ActivityRecord aab;
        private final ComponentName aaba;
        private final OnActivityRecordListener aabb;

        public aaba(ActivityRecord activityRecord, ComponentName componentName, OnActivityRecordListener onActivityRecordListener) {
            this.aab = activityRecord;
            this.aaba = componentName;
            this.aabb = onActivityRecordListener;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            ActivityRecord activityRecord;
            if (TextUtils.isEmpty(this.aab.getPackageName())) {
                activityRecord = aace.this.aaba(this.aab);
            } else {
                activityRecord = this.aab;
            }
            ComponentInfo componentInfo = new ComponentInfo();
            componentInfo.setAppType("Android");
            if (this.aaba != null) {
                Intent intent = new Intent();
                intent.setComponent(this.aaba);
                intent.addCategory("android.intent.category.BROWSABLE");
                if (intent.resolveActivity(HiHealthKitClient.getInstance().getContext().getPackageManager()) != null) {
                    componentInfo.setPackageName(this.aaba.getPackageName());
                    componentInfo.setClassName(this.aaba.getClassName());
                } else {
                    throw new IllegalArgumentException("can not resolve the component");
                }
            }
            aack.aabf().aab().aab(activityRecord, componentInfo, new aacf(this));
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class aabb implements Callable<Void> {
        private final String aab;

        public aabb(String str) {
            this.aab = str;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            aack.aabf().aab().aab(this.aab);
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class aabc implements Callable<ComponentInfo> {
        /* synthetic */ aabc(aab aabVar) {
        }

        @Override // java.util.concurrent.Callable
        public ComponentInfo call() throws Exception {
            return aack.aabf().aab().aabh();
        }
    }

    public Task<ComponentInfo> aab() {
        return aacs.aab(2, new aabc(null));
    }

    public Task<Void> aaba(PendingIntent pendingIntent) {
        throw new SecurityException(String.valueOf(HiHealthStatusCodes.API_FUNCTION_UNAVAILABLE));
    }

    public Task<Void> aab(PendingIntent pendingIntent) {
        throw new SecurityException(String.valueOf(HiHealthStatusCodes.API_FUNCTION_UNAVAILABLE));
    }

    public Task<List<ActivityRecord>> aaba(@Nullable final String str) {
        final HealthKitApiInvoker healthKitApiInvoker = new HealthKitApiInvoker(aabb);
        return aacs.aab(new Callable() { // from class: com.huawei.hms.health.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List aab2;
                aab2 = aace.aab(HealthKitApiInvoker.this, str);
                return aab2;
            }
        });
    }

    public static aace aaba() {
        if (aaba == null) {
            synchronized (aace.class) {
                if (aaba == null) {
                    aaba = new aace();
                    aabb = aaci.aabc().aaba();
                }
            }
        }
        return aaba;
    }

    public Task<Void> aab(ActivityRecord activityRecord) {
        Preconditions.checkNotNull(activityRecord, "ActivityRecord cannot be null.");
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Preconditions.checkArgument(activityRecord.getEndTime(timeUnit) == 0, "Cannot start the activityRecord which has already ended.");
        Preconditions.checkArgument(activityRecord.getStartTime(timeUnit) <= System.currentTimeMillis(), "can not start an ActivityRecord in the future time.");
        return aacs.aab(new aab(activityRecord, new HealthKitApiInvoker(aabb)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ActivityRecord aaba(ActivityRecord activityRecord) {
        String timeZone;
        if (TextUtils.isEmpty(activityRecord.getTimeZone())) {
            timeZone = new SimpleDateFormat("Z", Locale.getDefault()).format(new Date());
        } else {
            timeZone = activityRecord.getTimeZone();
        }
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long startTime = activityRecord.getStartTime(timeUnit);
        long endTime = activityRecord.getEndTime(timeUnit);
        String name = activityRecord.getName();
        String id5 = activityRecord.getId();
        String desc = activityRecord.getDesc();
        int aab2 = aacc.aab(activityRecord.getActivityType());
        Long valueOf = Long.valueOf(activityRecord.getDurationTime(timeUnit));
        String str = this.aab;
        return new ActivityRecord(startTime, endTime, name, id5, desc, aab2, valueOf, new AppInfo(str, str, str, str), activityRecord.getActivitySummary(), timeZone, activityRecord.getDetails(), activityRecord.getMetadata(), activityRecord.getDeviceInfo(), activityRecord.getSubDataRelationList(), activityRecord.getGzipDetail());
    }

    public Task<Void> aab(ActivityRecord activityRecord, ComponentName componentName, OnActivityRecordListener onActivityRecordListener) {
        Preconditions.checkNotNull(activityRecord, "ActivityRecord cannot be null.");
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Preconditions.checkArgument(activityRecord.getEndTime(timeUnit) == 0, "Cannot start the activityRecord which has already ended.");
        Preconditions.checkArgument(activityRecord.getStartTime(timeUnit) <= System.currentTimeMillis(), "can not start an ActivityRecord in the future time.");
        return aacs.aabb(2, new aaba(activityRecord, componentName, onActivityRecordListener));
    }

    public Task<Void> aab(final ActivityRecordDeleteOptions activityRecordDeleteOptions) {
        final HealthKitApiInvoker healthKitApiInvoker = new HealthKitApiInvoker(aabb);
        return aacs.aab(new Callable() { // from class: com.huawei.hms.health.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void aab2;
                aab2 = aace.aab(HealthKitApiInvoker.this, activityRecordDeleteOptions);
                return aab2;
            }
        });
    }

    public Task<Void> aab(final ActivityRecordInsertOptions activityRecordInsertOptions) {
        final HealthKitApiInvoker healthKitApiInvoker = new HealthKitApiInvoker(aabb);
        return aacs.aab(new Callable() { // from class: com.huawei.hms.health.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void aab2;
                aab2 = aace.aab(HealthKitApiInvoker.this, activityRecordInsertOptions);
                return aab2;
            }
        });
    }

    public Task<ActivityRecordResult> aab(final ActivityRecordReadOptions activityRecordReadOptions) {
        final HealthKitApiInvoker healthKitApiInvoker = new HealthKitApiInvoker(aabb);
        return aacs.aab(new Callable() { // from class: com.huawei.hms.health.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ActivityRecordResult aab2;
                aab2 = aace.aab(HealthKitApiInvoker.this, activityRecordReadOptions);
                return aab2;
            }
        });
    }

    public Task<Void> aab(String str) {
        Preconditions.checkNotNull(str, "activityRecordId cannot be null.");
        return aacs.aabb(2, new aabb(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ActivityRecordResult aab(HealthKitApiInvoker healthKitApiInvoker, ActivityRecordReadOptions activityRecordReadOptions) throws Exception {
        healthKitApiInvoker.setInterfaceProvider("ActivityRecordsController");
        healthKitApiInvoker.setInterfaceInvoked("getActivityRecord");
        healthKitApiInvoker.setRequestBody(aacu.aab(activityRecordReadOptions));
        return (ActivityRecordResult) aacu.aab(aaci.aabc().aaba(healthKitApiInvoker), (Type) ActivityRecordResult.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void aab(HealthKitApiInvoker healthKitApiInvoker, ActivityRecordDeleteOptions activityRecordDeleteOptions) throws Exception {
        healthKitApiInvoker.setInterfaceProvider("ActivityRecordsController");
        healthKitApiInvoker.setInterfaceInvoked("deleteActivityRecord");
        healthKitApiInvoker.setRequestBody(aacu.aab(activityRecordDeleteOptions));
        aaci.aabc().aab(healthKitApiInvoker);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List aab(HealthKitApiInvoker healthKitApiInvoker, String str) throws Exception {
        healthKitApiInvoker.setInterfaceProvider("ActivityRecordsController");
        healthKitApiInvoker.setInterfaceInvoked("endActivityRecord");
        healthKitApiInvoker.setRequestBody(str);
        return aacu.aab(aaci.aabc().aab(healthKitApiInvoker), ActivityRecord.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void aab(HealthKitApiInvoker healthKitApiInvoker, ActivityRecordInsertOptions activityRecordInsertOptions) throws Exception {
        String str;
        Throwable th5;
        healthKitApiInvoker.setInterfaceProvider("ActivityRecordsController");
        healthKitApiInvoker.setInterfaceInvoked("addActivityRecord");
        String aab2 = aacu.aab(activityRecordInsertOptions);
        if (aab2 != null) {
            if (aab2.length() > 256000.0f) {
                String str2 = "";
                if (TextUtils.isEmpty(aab2)) {
                    aabz.aabc("util", "compressGzip input is empty!");
                } else {
                    try {
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                                try {
                                    gZIPOutputStream.write(aab2.getBytes(StandardCharsets.UTF_8));
                                    gZIPOutputStream.flush();
                                    gZIPOutputStream.close();
                                    str = new String(byteArrayOutputStream.toByteArray(), StandardCharsets.ISO_8859_1);
                                    try {
                                        gZIPOutputStream.close();
                                        byteArrayOutputStream.close();
                                        str2 = str;
                                    } catch (Throwable th6) {
                                        th5 = th6;
                                        try {
                                            throw th5;
                                        } finally {
                                        }
                                    }
                                } finally {
                                }
                            } catch (Throwable th7) {
                                str = "";
                                th5 = th7;
                            }
                        } catch (IOException unused) {
                            aabz.aab("util", "compressGzip IOException");
                            StringBuilder aab3 = com.huawei.hms.health.aab.aab("compressing rate is ");
                            aab3.append(aab2.length() / str2.length());
                            aabz.aabb("util", aab3.toString());
                            healthKitApiInvoker.setRequestBody(str2);
                            healthKitApiInvoker.setGzip(true);
                            aaci.aabc().aab(healthKitApiInvoker);
                            return null;
                        }
                    } catch (IOException unused2) {
                        str2 = str;
                        aabz.aab("util", "compressGzip IOException");
                        StringBuilder aab32 = com.huawei.hms.health.aab.aab("compressing rate is ");
                        aab32.append(aab2.length() / str2.length());
                        aabz.aabb("util", aab32.toString());
                        healthKitApiInvoker.setRequestBody(str2);
                        healthKitApiInvoker.setGzip(true);
                        aaci.aabc().aab(healthKitApiInvoker);
                        return null;
                    }
                }
                StringBuilder aab322 = com.huawei.hms.health.aab.aab("compressing rate is ");
                aab322.append(aab2.length() / str2.length());
                aabz.aabb("util", aab322.toString());
                healthKitApiInvoker.setRequestBody(str2);
                healthKitApiInvoker.setGzip(true);
            } else {
                healthKitApiInvoker.setRequestBody(aab2);
            }
        }
        aaci.aabc().aab(healthKitApiInvoker);
        return null;
    }
}
