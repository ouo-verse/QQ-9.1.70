package com.qzone.publish.business.publishqueue;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.publish.business.task.QZoneQueueTask;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<Long, a> f51141a = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f51142a;

        /* renamed from: b, reason: collision with root package name */
        public int f51143b;

        /* renamed from: c, reason: collision with root package name */
        public int f51144c;

        /* renamed from: d, reason: collision with root package name */
        public int f51145d;

        /* renamed from: e, reason: collision with root package name */
        public HashMap<String, String> f51146e;

        public a() {
        }

        public String toString() {
            return "UploadInfo [leftCount=" + this.f51142a + ", successCount=" + this.f51143b + ", failedCount=" + this.f51144c + ", maxCount=" + this.f51145d + "]";
        }

        public a(int i3, int i16, int i17, int i18) {
            this.f51142a = i3;
            this.f51143b = i16;
            this.f51144c = i17;
            this.f51145d = i18;
        }
    }

    static {
        String[] split;
        String[] split2;
        String j06 = u5.b.j0("key_upload_task_flag", "", LoginData.getInstance().getUin());
        QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "values:" + j06);
        if (TextUtils.isEmpty(j06) || (split = j06.split("\\|")) == null) {
            return;
        }
        for (String str : split) {
            if (!TextUtils.isEmpty(str) && (split2 = str.split(",")) != null && split2.length >= 5) {
                try {
                    f51141a.put(Long.valueOf(Long.parseLong(split2[0])), new a(Integer.parseInt(split2[1]), Integer.parseInt(split2[2]), Integer.parseInt(split2[3]), Integer.parseInt(split2[4])));
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void a(long j3, int i3) {
        if (f51141a.containsKey(Long.valueOf(j3))) {
            return;
        }
        a aVar = new a();
        aVar.f51142a = i3;
        aVar.f51145d = i3;
        f51141a.put(Long.valueOf(j3), aVar);
        j();
    }

    public static a b(long j3, boolean z16, Map<String, String> map) {
        a aVar = f51141a.get(Long.valueOf(j3));
        if (z16) {
            aVar.f51143b++;
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "successCount:" + aVar.f51143b);
            if (aVar.f51146e == null) {
                aVar.f51146e = new HashMap<>();
            }
            if (map != null) {
                aVar.f51146e.putAll(map);
            }
        } else {
            aVar.f51144c++;
        }
        if (aVar.f51143b == aVar.f51145d) {
            f51141a.remove(Long.valueOf(j3));
        }
        aVar.f51142a--;
        j();
        return aVar;
    }

    public static boolean c(long j3) {
        return f51141a.containsKey(Long.valueOf(j3));
    }

    public static long d(long j3) {
        return u5.b.J("upload_multi_pic_pref_cache", String.valueOf(j3), 0L);
    }

    public static a e(long j3) {
        return f51141a.get(Long.valueOf(j3));
    }

    public static boolean f(QZoneQueueTask qZoneQueueTask) {
        int exactType = qZoneQueueTask.getExactType();
        if (exactType != 2 && exactType != 16 && exactType != 15 && exactType != 5) {
            return true;
        }
        long batchId = qZoneQueueTask.getBatchId();
        return c(batchId) ? e(batchId).f51145d <= 0 : qZoneQueueTask.getState() != 7;
    }

    public static void g(long j3) {
        if (f51141a.containsKey(Long.valueOf(j3))) {
            a aVar = f51141a.get(Long.valueOf(j3));
            aVar.f51142a--;
            int i3 = aVar.f51145d - 1;
            aVar.f51145d = i3;
            if (i3 == 0) {
                f51141a.remove(Long.valueOf(j3));
            }
            j();
        }
    }

    public static void h(long j3) {
        a aVar;
        int i3;
        if (!c(j3) || (i3 = (aVar = f51141a.get(Long.valueOf(j3))).f51142a) <= 0) {
            return;
        }
        aVar.f51142a = i3 + 1;
        j();
    }

    public static void i(long j3, long j16) {
        u5.b.t0("upload_multi_pic_pref_cache", String.valueOf(j3), j16);
    }

    private static void j() {
        if (f51141a.size() > 0) {
            StringBuilder sb5 = new StringBuilder();
            for (Map.Entry<Long, a> entry : f51141a.entrySet()) {
                a value = entry.getValue();
                sb5.append(entry.getKey());
                sb5.append(",");
                sb5.append(value.f51142a);
                sb5.append(",");
                sb5.append(value.f51143b);
                sb5.append(",");
                sb5.append(value.f51144c);
                sb5.append(",");
                sb5.append(value.f51145d);
                sb5.append("|");
            }
            u5.b.x0("key_upload_task_flag", sb5.substring(0, sb5.lastIndexOf("|")), LoginData.getInstance().getUin());
            return;
        }
        u5.b.A0("key_upload_task_flag", LoginData.getInstance().getUin());
    }
}
