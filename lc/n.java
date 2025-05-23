package lc;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<Long, a> f414351a = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f414352a;

        /* renamed from: b, reason: collision with root package name */
        public int f414353b;

        /* renamed from: c, reason: collision with root package name */
        public int f414354c;

        /* renamed from: d, reason: collision with root package name */
        public int f414355d;

        /* renamed from: e, reason: collision with root package name */
        public HashMap<String, String> f414356e;

        public a() {
        }

        public String toString() {
            return "UploadInfo [leftCount=" + this.f414352a + ", successCount=" + this.f414353b + ", failedCount=" + this.f414354c + ", maxCount=" + this.f414355d + "]";
        }

        public a(int i3, int i16, int i17, int i18) {
            this.f414352a = i3;
            this.f414353b = i16;
            this.f414354c = i17;
            this.f414355d = i18;
        }
    }

    static {
        String[] split;
        String[] split2;
        String j06 = u5.b.j0("publishx_key_upload_task_flag", "", LoginData.getInstance().getUin());
        QZLog.i("QZPublishX_QZonePublishXUploadTaskBatchUtil", 1, "values:" + j06);
        if (TextUtils.isEmpty(j06) || (split = j06.split("\\|")) == null) {
            return;
        }
        for (String str : split) {
            if (!TextUtils.isEmpty(str) && (split2 = str.split(",")) != null && split2.length >= 5) {
                try {
                    f414351a.put(Long.valueOf(Long.parseLong(split2[0])), new a(Integer.parseInt(split2[1]), Integer.parseInt(split2[2]), Integer.parseInt(split2[3]), Integer.parseInt(split2[4])));
                } catch (Exception e16) {
                    QLog.e("QZPublishX_QZonePublishXUploadTaskBatchUtil", 1, "e = " + e16);
                }
            }
        }
    }

    public static void a(long j3, int i3) {
        if (f414351a.containsKey(Long.valueOf(j3))) {
            return;
        }
        a aVar = new a();
        aVar.f414352a = i3;
        aVar.f414355d = i3;
        f414351a.put(Long.valueOf(j3), aVar);
        e();
        QZLog.i("QZPublishX_QZonePublishXUploadTaskBatchUtil", 1, "addBatch | batchId=" + j3 + " | total=" + i3 + " | uploadInfo=" + aVar);
    }

    public static a b(long j3, boolean z16, Map<String, String> map, String str, String str2) {
        a aVar = f414351a.get(Long.valueOf(j3));
        if (aVar == null) {
            return new a();
        }
        if (z16) {
            aVar.f414353b++;
            if (aVar.f414356e == null) {
                aVar.f414356e = new HashMap<>();
            }
            if (map != null) {
                aVar.f414356e.putAll(map);
            }
        } else {
            aVar.f414354c++;
        }
        if (aVar.f414353b == aVar.f414355d) {
            f414351a.remove(Long.valueOf(j3));
        }
        aVar.f414352a--;
        e();
        QZLog.i("QZPublishX_QZonePublishXUploadTaskBatchUtil", 1, "completeTask | batchId=" + j3 + " | isSucc=" + z16 + " | albumId=" + str + " | clientKey=" + str2 + " | uploadInfo=" + aVar);
        return aVar;
    }

    public static boolean c(long j3) {
        return f414351a.containsKey(Long.valueOf(j3));
    }

    public static void d(long j3) {
        a aVar;
        if (!f414351a.containsKey(Long.valueOf(j3)) || (aVar = f414351a.get(Long.valueOf(j3))) == null) {
            return;
        }
        int i3 = aVar.f414355d - 1;
        aVar.f414355d = i3;
        if (i3 == 0) {
            f414351a.remove(Long.valueOf(j3));
        }
        e();
        QZLog.i("QZPublishX_QZonePublishXUploadTaskBatchUtil", 1, "removeTask | batchId=" + j3 + " | uploadInfo=" + aVar);
    }

    private static void e() {
        if (f414351a.size() > 0) {
            StringBuilder sb5 = new StringBuilder();
            for (Map.Entry<Long, a> entry : f414351a.entrySet()) {
                a value = entry.getValue();
                sb5.append(entry.getKey());
                sb5.append(",");
                sb5.append(value.f414352a);
                sb5.append(",");
                sb5.append(value.f414353b);
                sb5.append(",");
                sb5.append(value.f414354c);
                sb5.append(",");
                sb5.append(value.f414355d);
                sb5.append("|");
            }
            u5.b.x0("publishx_key_upload_task_flag", sb5.substring(0, sb5.lastIndexOf("|")), LoginData.getInstance().getUin());
            return;
        }
        u5.b.A0("publishx_key_upload_task_flag", LoginData.getInstance().getUin());
    }
}
