package com.tencent.mobileqq.nearby;

import android.app.Activity;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface c {

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f252553a;

        /* renamed from: b, reason: collision with root package name */
        public int f252554b;

        /* renamed from: c, reason: collision with root package name */
        public int f252555c;

        /* renamed from: d, reason: collision with root package name */
        public int f252556d;

        /* renamed from: e, reason: collision with root package name */
        public int f252557e;

        public String toString() {
            return "uin=" + this.f252553a + ",freeLikeCount=" + this.f252554b + ",payLikeCount=" + this.f252555c + ",totalPerCount=" + this.f252556d + ",source=" + this.f252557e;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f252558a;

        /* renamed from: b, reason: collision with root package name */
        public String f252559b;

        /* renamed from: c, reason: collision with root package name */
        public long f252560c;

        /* renamed from: d, reason: collision with root package name */
        public int f252561d;

        /* renamed from: e, reason: collision with root package name */
        public int f252562e;

        /* renamed from: f, reason: collision with root package name */
        public int f252563f;

        /* renamed from: g, reason: collision with root package name */
        public int f252564g;

        public String toString() {
            return "ret=" + this.f252558a + ",uin=" + this.f252560c + ",succFreeLikeCnt=" + this.f252561d + ",succPayLikeCnt=" + this.f252562e + ",todayLikeCnt=" + this.f252563f + ",totalPayStockCnt=" + this.f252564g + ",errMsg=" + this.f252559b;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.nearby.c$c, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C8137c {

        /* renamed from: a, reason: collision with root package name */
        public int f252565a;

        /* renamed from: b, reason: collision with root package name */
        public int f252566b;

        /* renamed from: c, reason: collision with root package name */
        public String f252567c;

        /* renamed from: d, reason: collision with root package name */
        public String f252568d;

        /* renamed from: e, reason: collision with root package name */
        public Object f252569e;

        /* renamed from: f, reason: collision with root package name */
        public int f252570f;

        /* renamed from: g, reason: collision with root package name */
        public int f252571g;

        /* renamed from: h, reason: collision with root package name */
        public int f252572h;

        /* renamed from: i, reason: collision with root package name */
        public int f252573i;

        public String toString() {
            return "[level=" + this.f252565a + ",stockPerLike=" + this.f252566b + ",freeLikePeopleLimit=" + this.f252570f + ",freeLikeOneLimit=" + this.f252571g + ",stockCount=" + this.f252572h + ",freeLikePeopleCount=" + this.f252573i + ",buyStockUrl=" + this.f252567c + ",updateLevelUrl=" + this.f252568d + "]";
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface d {
        void a(String str, boolean z16);
    }

    void a(String str, boolean z16);

    void b(int i3, int i16, int i17);

    void c(Object obj, List<Object> list, int i3);

    boolean d(long j3);

    void e(Activity activity, Object obj, String str, Object obj2, String str2);
}
