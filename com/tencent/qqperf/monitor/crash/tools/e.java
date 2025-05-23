package com.tencent.qqperf.monitor.crash.tools;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.tools.g;

/* compiled from: P */
/* loaded from: classes25.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static MMKVOptionEntity f363224a;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f363225a;

        /* renamed from: b, reason: collision with root package name */
        String f363226b;

        /* renamed from: c, reason: collision with root package name */
        long f363227c;

        /* renamed from: d, reason: collision with root package name */
        int f363228d;

        /* renamed from: e, reason: collision with root package name */
        long f363229e;

        public String toString() {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("LastCrashRecordInfoItem{crashName='");
            String str = this.f363225a;
            String str2 = "null";
            if (str == null) {
                str = "null";
            }
            sb5.append(str);
            sb5.append('\'');
            sb5.append(", crashStack='");
            String str3 = this.f363226b;
            if (str3 != null) {
                str2 = str3;
            }
            sb5.append(str2);
            sb5.append('\'');
            sb5.append(", crashTime=");
            sb5.append(this.f363227c);
            sb5.append(", crashPid=");
            sb5.append(this.f363228d);
            sb5.append(", processStartTime=");
            sb5.append(this.f363229e);
            sb5.append('}');
            return sb5.toString();
        }
    }

    private static a a(MMKVOptionEntity mMKVOptionEntity) {
        if (mMKVOptionEntity == null) {
            QLog.e("LastCrashInfoHelper", 1, "decodeLastCrashRecordInfoItem failed parameter has null");
            return null;
        }
        String decodeString = mMKVOptionEntity.decodeString("key_last_crash_name", "");
        String decodeString2 = mMKVOptionEntity.decodeString("key_last_crash_stack", "");
        long decodeLong = mMKVOptionEntity.decodeLong("key_last_crash_time", -1L);
        int decodeInt = mMKVOptionEntity.decodeInt("key_last_crash_pid", -1);
        long decodeLong2 = mMKVOptionEntity.decodeLong("key_last_crash_pTime", -1L);
        if (StringUtil.isEmpty(decodeString)) {
            return null;
        }
        a aVar = new a();
        aVar.f363225a = decodeString;
        aVar.f363226b = decodeString2;
        aVar.f363227c = decodeLong;
        aVar.f363228d = decodeInt;
        aVar.f363229e = decodeLong2;
        return aVar;
    }

    private static void b(a aVar, MMKVOptionEntity mMKVOptionEntity) {
        if (aVar != null && mMKVOptionEntity != null) {
            mMKVOptionEntity.encodeString("key_last_crash_name", aVar.f363225a);
            mMKVOptionEntity.encodeString("key_last_crash_stack", aVar.f363226b);
            mMKVOptionEntity.encodeLong("key_last_crash_time", aVar.f363227c);
            mMKVOptionEntity.encodeInt("key_last_crash_pid", aVar.f363228d);
            mMKVOptionEntity.encodeLong("key_last_crash_pTime", aVar.f363229e);
            mMKVOptionEntity.commitSync();
            if (QLog.isColorLevel()) {
                QLog.w("LastCrashInfoHelper", 2, "encodeLastCrashRecordInfoItem end new crash is " + aVar.toString());
                return;
            }
            return;
        }
        QLog.e("LastCrashInfoHelper", 1, "encodeLastCrashRecordInfoItem failed parameter has null");
    }

    @Nullable
    public static a c(@NonNull Context context) {
        MMKVOptionEntity d16 = d(context);
        if (d16 == null) {
            QLog.e("LastCrashInfoHelper", 1, "startUpRecordProcess failed mmkvOptionEntity is null");
            return null;
        }
        return a(d16);
    }

    private static MMKVOptionEntity d(@NonNull Context context) {
        if (f363224a == null) {
            f363224a = QMMKV.from(context, "BuglySdkInfos");
        }
        return f363224a;
    }

    public static void e(@NonNull Context context, @NonNull String str, @NonNull String str2, long j3) {
        MMKVOptionEntity d16 = d(context);
        if (d16 == null) {
            QLog.e("LastCrashInfoHelper", 1, "recordLastCrashInfo failed mmkvOptionEntity is null");
            return;
        }
        if (!StringUtil.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.w("LastCrashInfoHelper", 2, "recordLastCrashInfo new crash is " + str);
            }
            a aVar = new a();
            aVar.f363225a = str;
            aVar.f363226b = str2;
            aVar.f363227c = j3;
            g.b a16 = g.a(context);
            aVar.f363228d = a16.f363235a;
            aVar.f363229e = a16.f363236b;
            b(aVar, d16);
        }
    }
}
