package com.huawei.hms.health;

import android.util.Log;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.api.CommonStatusCodes;
import com.huawei.hms.hihealth.HiHealthStatusCodes;
import com.huawei.hms.hihealth.data.DataCollector;
import com.huawei.hms.hihealth.data.DataType;
import com.huawei.hms.support.api.client.Status;
import java.util.Collection;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aabz {
    public static <R extends com.huawei.hms.hihealth.result.aab, T> Task<R> aab(Task<T> task, aacz<T> aaczVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        task.addOnCompleteListener(new aact(taskCompletionSource, aaczVar));
        return taskCompletionSource.getTask();
    }

    public static Boolean aaba(Collection collection) {
        return Boolean.valueOf(!aab(collection).booleanValue());
    }

    public static void aabb(String str, String str2) {
        Log.i("HmsHealth_kit " + str, str2);
    }

    public static void aabc(String str, String str2) {
        Log.w("HmsHealth_kit " + str, str2);
    }

    public static DataCollector aab(DataType dataType) {
        return new DataCollector.Builder().setPackageName("com.huawei.hms.health").setDataStreamName("default").setDataGenerateType(1).setDataType(dataType).build();
    }

    public static void aaba(String str, String str2) {
        Log.e("HmsHealth_kit " + str, str2);
    }

    public static Boolean aab(Collection collection) {
        return Boolean.valueOf(collection == null || collection.isEmpty());
    }

    public static void aab(String str, String str2) {
        Log.e("HmsHealth_kit " + str, str2);
    }

    public static void aab(String str, String str2, Object... objArr) {
        String str3 = "HmsHealth_kit " + str;
        try {
            str2 = String.format(str2, objArr);
        } catch (Exception unused) {
            aabc("util", "strFormat exception");
        }
        Log.e(str3, str2);
    }

    public static Status aab(String str) {
        if (!((str == null || str.length() == 0) ? false : Pattern.matches("^[-\\+]?[\\d]*$", str))) {
            return new Status(Status.FAILURE.getStatusCode(), str);
        }
        try {
            int parseInt = Integer.parseInt(str);
            return Math.abs(parseInt) < 5000 ? new Status(parseInt, CommonStatusCodes.getStatusCodeString(parseInt)) : new Status(parseInt, HiHealthStatusCodes.getStatusCodeMessage(parseInt));
        } catch (NumberFormatException unused) {
            return new Status(Status.FAILURE.getStatusCode(), str);
        }
    }
}
