package i;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.os.Process;
import com.tencent.mobileqq.qqbattery.feature.g;

/* compiled from: P */
/* loaded from: classes.dex */
public final class e {

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public long f406972a;

        /* renamed from: b, reason: collision with root package name */
        public long f406973b;

        /* renamed from: c, reason: collision with root package name */
        public long f406974c;

        /* renamed from: d, reason: collision with root package name */
        public long f406975d;

        /* renamed from: e, reason: collision with root package name */
        public long f406976e;

        /* renamed from: f, reason: collision with root package name */
        public long f406977f;

        /* renamed from: g, reason: collision with root package name */
        public long f406978g;

        /* renamed from: h, reason: collision with root package name */
        public long f406979h;
    }

    public static a a(Context context) {
        try {
            NetworkStatsManager networkStatsManager = (NetworkStatsManager) context.getSystemService("netstats");
            if (networkStatsManager == null) {
                return null;
            }
            a aVar = new a();
            NetworkStats querySummary = networkStatsManager.querySummary(1, null, 0L, System.currentTimeMillis());
            while (querySummary.hasNextBucket()) {
                try {
                    NetworkStats.Bucket bucket = new NetworkStats.Bucket();
                    if (querySummary.getNextBucket(bucket) && bucket.getUid() == Process.myUid()) {
                        aVar.f406972a += bucket.getRxBytes();
                        aVar.f406973b += bucket.getTxBytes();
                        aVar.f406974c += bucket.getRxPackets();
                        aVar.f406975d += bucket.getTxPackets();
                    }
                } finally {
                }
            }
            querySummary.close();
            querySummary = networkStatsManager.querySummary(0, null, 0L, System.currentTimeMillis());
            while (querySummary.hasNextBucket()) {
                try {
                    NetworkStats.Bucket bucket2 = new NetworkStats.Bucket();
                    if (querySummary.getNextBucket(bucket2) && bucket2.getUid() == Process.myUid()) {
                        aVar.f406976e += bucket2.getRxBytes();
                        aVar.f406977f += bucket2.getTxBytes();
                        aVar.f406978g += bucket2.getRxPackets();
                        aVar.f406979h += bucket2.getTxPackets();
                    }
                } finally {
                }
            }
            querySummary.close();
            return aVar;
        } catch (Throwable th5) {
            StringBuilder a16 = g.a("querySummary fail: ");
            a16.append(th5.getMessage());
            com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_RadioStatUtil", a16.toString(), new Object[0]);
            return null;
        }
    }
}
