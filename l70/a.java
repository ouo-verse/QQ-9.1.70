package l70;

import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import feedcloud.FeedCloudMeta$StBarrage;
import tz3.i;
import tz3.k;
import wz3.e;
import wz3.f;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* compiled from: P */
    /* renamed from: l70.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C10708a {

        /* renamed from: a, reason: collision with root package name */
        private com.tencent.rfw.barrage.data.a f413901a;

        /* renamed from: b, reason: collision with root package name */
        private int f413902b;

        /* renamed from: c, reason: collision with root package name */
        private float f413903c = 1.0f;

        public com.tencent.rfw.barrage.data.a a() {
            return this.f413901a;
        }

        public float b() {
            return this.f413903c;
        }

        public C10708a c(com.tencent.rfw.barrage.data.a aVar) {
            this.f413901a = aVar;
            return this;
        }

        public C10708a d(int i3) {
            this.f413902b = i3;
            return this;
        }

        public C10708a e(float f16) {
            this.f413903c = f16;
            return this;
        }
    }

    private static int a(com.tencent.rfw.barrage.data.a aVar) {
        return (int) ((c(aVar) / 64.0f) * 1000.0f);
    }

    private static int b(com.tencent.rfw.barrage.data.a aVar) {
        String str;
        if (aVar == null) {
            wz3.b.a("RFWBarrageTimeUtils", "[getBarrageDrawWidth] barrage should not be null.");
            return 0;
        }
        if (!(aVar.l() instanceof m70.a)) {
            return 0;
        }
        FeedCloudMeta$StBarrage a16 = ((m70.a) aVar.l()).a();
        if (a16 == null) {
            str = "";
        } else {
            str = a16.content.get();
        }
        k l3 = i.l();
        return i.l().k() + ((int) (f.f(l3.l(), str) + l3.g() + l3.g()));
    }

    private static int c(com.tencent.rfw.barrage.data.a aVar) {
        return e.b(b(aVar));
    }

    private static int d() {
        try {
            return Integer.parseInt(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_enable_re_notify_resume", String.valueOf(7000)));
        } catch (Exception e16) {
            wz3.b.a("RFWBarrageTimeUtils", "[getDefaultBarrageDrawTimeMillisecond] error:" + e16);
            return 7000;
        }
    }

    private static int e(com.tencent.rfw.barrage.data.a aVar) {
        return (int) ((c(aVar) / 58.0f) * 1000.0f);
    }

    public static void f(C10708a c10708a, boolean z16) {
        if (c10708a == null) {
            wz3.b.c("RFWBarrageTimeUtils", "[updateBarrageTime] barrage time param should not be null.");
        } else {
            g(c10708a.a(), c10708a.b(), z16);
        }
    }

    private static void g(com.tencent.rfw.barrage.data.a aVar, float f16, boolean z16) {
        int a16;
        FeedCloudMeta$StBarrage feedCloudMeta$StBarrage;
        if (aVar == null) {
            wz3.b.a("RFWBarrageTimeUtils", "[updateBarrageDistribute] barrage should not be null.");
            return;
        }
        int b16 = b(aVar);
        if (o70.a.c()) {
            a16 = d();
        } else if (z16) {
            a16 = e(aVar);
        } else {
            a16 = a(aVar);
        }
        Object l3 = aVar.l();
        PBUInt64Field pBUInt64Field = null;
        if (l3 instanceof m70.a) {
            feedCloudMeta$StBarrage = ((m70.a) l3).a();
        } else {
            feedCloudMeta$StBarrage = null;
        }
        long j3 = 0;
        if (o70.a.b()) {
            if (feedCloudMeta$StBarrage != null) {
                pBUInt64Field = feedCloudMeta$StBarrage.pannelOpenTime;
                if (pBUInt64Field.get() == 0) {
                    pBUInt64Field = feedCloudMeta$StBarrage.feedPlayTime;
                }
            }
        } else if (feedCloudMeta$StBarrage != null) {
            pBUInt64Field = feedCloudMeta$StBarrage.feedPlayTime;
        }
        if (pBUInt64Field != null) {
            j3 = pBUInt64Field.get();
        }
        aVar.A0(j3);
        aVar.r0(new vz3.f(a16));
        aVar.t0("SPEED", Float.valueOf(f16));
        aVar.s0(1.0f / f16);
        if (aVar instanceof com.tencent.rfw.barrage.data.d) {
            ((com.tencent.rfw.barrage.data.d) aVar).E0(b16 / a16);
        }
    }
}
