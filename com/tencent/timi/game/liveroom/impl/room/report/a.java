package com.tencent.timi.game.liveroom.impl.room.report;

import android.net.TrafficStats;
import androidx.annotation.VisibleForTesting;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f378455a;

    /* renamed from: b, reason: collision with root package name */
    private String f378456b;

    /* renamed from: c, reason: collision with root package name */
    private String f378457c;

    /* renamed from: d, reason: collision with root package name */
    private String f378458d;

    /* renamed from: e, reason: collision with root package name */
    private String f378459e;

    /* renamed from: f, reason: collision with root package name */
    private long f378460f;

    /* renamed from: g, reason: collision with root package name */
    private String f378461g;

    /* renamed from: h, reason: collision with root package name */
    private long f378462h;

    /* renamed from: i, reason: collision with root package name */
    private String f378463i;

    /* renamed from: j, reason: collision with root package name */
    private int f378464j;

    /* renamed from: k, reason: collision with root package name */
    private String f378465k;

    /* renamed from: l, reason: collision with root package name */
    private long f378466l;

    /* renamed from: m, reason: collision with root package name */
    private String f378467m;

    /* renamed from: n, reason: collision with root package name */
    private String f378468n;

    /* renamed from: o, reason: collision with root package name */
    private int f378469o;

    /* renamed from: p, reason: collision with root package name */
    private String f378470p;

    /* renamed from: q, reason: collision with root package name */
    private String f378471q;

    /* renamed from: r, reason: collision with root package name */
    private long f378472r;

    /* renamed from: s, reason: collision with root package name */
    private String f378473s;

    /* compiled from: P */
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.report.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C9952a {

        /* renamed from: a, reason: collision with root package name */
        private String f378474a;

        /* renamed from: b, reason: collision with root package name */
        private String f378475b;

        /* renamed from: c, reason: collision with root package name */
        private String f378476c;

        /* renamed from: d, reason: collision with root package name */
        private String f378477d;

        /* renamed from: e, reason: collision with root package name */
        private String f378478e;

        /* renamed from: f, reason: collision with root package name */
        private long f378479f;

        /* renamed from: g, reason: collision with root package name */
        private String f378480g;

        /* renamed from: h, reason: collision with root package name */
        private long f378481h;

        /* renamed from: i, reason: collision with root package name */
        private String f378482i;

        /* renamed from: j, reason: collision with root package name */
        private int f378483j;

        /* renamed from: k, reason: collision with root package name */
        private long f378484k;

        /* renamed from: l, reason: collision with root package name */
        private String f378485l;

        /* renamed from: m, reason: collision with root package name */
        private String f378486m;

        /* renamed from: n, reason: collision with root package name */
        private String f378487n;

        /* renamed from: o, reason: collision with root package name */
        private int f378488o;

        /* renamed from: p, reason: collision with root package name */
        private String f378489p;

        /* renamed from: q, reason: collision with root package name */
        private String f378490q;

        /* renamed from: r, reason: collision with root package name */
        private long f378491r;

        /* renamed from: s, reason: collision with root package name */
        private String f378492s;

        public C9952a A(String str) {
            this.f378486m = str;
            return this;
        }

        public C9952a B(String str) {
            this.f378490q = str;
            return this;
        }

        public C9952a C(String str) {
            this.f378475b = str;
            return this;
        }

        public C9952a D(String str) {
            this.f378476c = str;
            return this;
        }

        public C9952a E(String str) {
            this.f378489p = str;
            return this;
        }

        public C9952a F(long j3) {
            this.f378479f = j3;
            return this;
        }

        public C9952a G(String str) {
            this.f378487n = str;
            return this;
        }

        public C9952a H(String str) {
            this.f378480g = str;
            return this;
        }

        public C9952a I(int i3) {
            this.f378483j = i3;
            return this;
        }

        public C9952a J(String str) {
            this.f378478e = str;
            return this;
        }

        public C9952a K(long j3) {
            this.f378491r = j3;
            return this;
        }

        public C9952a L(String str) {
            this.f378492s = str;
            return this;
        }

        public C9952a M(String str) {
            this.f378477d = str;
            return this;
        }

        public a t() {
            return new a(this);
        }

        public C9952a u(String str) {
            this.f378485l = str;
            return this;
        }

        public C9952a v(long j3) {
            this.f378481h = j3;
            return this;
        }

        public C9952a w(String str) {
            this.f378482i = str;
            return this;
        }

        public C9952a x(String str) {
            this.f378474a = str;
            return this;
        }

        public C9952a y(long j3) {
            this.f378484k = j3;
            return this;
        }

        public C9952a z(int i3) {
            this.f378488o = i3;
            return this;
        }
    }

    a(C9952a c9952a) {
        this.f378455a = "";
        this.f378456b = "";
        this.f378457c = "";
        this.f378458d = "";
        this.f378459e = "";
        this.f378460f = 0L;
        this.f378461g = "";
        this.f378462h = 0L;
        this.f378463i = "";
        this.f378464j = 0;
        this.f378465k = "";
        this.f378466l = 0L;
        this.f378467m = "";
        this.f378468n = "";
        this.f378469o = 0;
        this.f378470p = "";
        this.f378471q = "";
        this.f378472r = 0L;
        this.f378473s = "";
        this.f378455a = c9952a.f378474a;
        this.f378456b = c9952a.f378475b;
        this.f378457c = c9952a.f378476c;
        this.f378458d = c9952a.f378477d;
        this.f378459e = c9952a.f378478e;
        this.f378460f = c9952a.f378479f;
        this.f378461g = c9952a.f378480g;
        this.f378462h = c9952a.f378481h;
        this.f378463i = c9952a.f378482i;
        this.f378464j = c9952a.f378483j;
        this.f378466l = c9952a.f378484k;
        this.f378467m = c9952a.f378485l;
        this.f378468n = c9952a.f378486m;
        this.f378465k = c9952a.f378487n;
        this.f378469o = c9952a.f378488o;
        this.f378470p = c9952a.f378489p;
        this.f378471q = c9952a.f378490q;
        this.f378472r = c9952a.f378491r;
        this.f378473s = c9952a.f378492s;
    }

    public void a() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("attaid", "05700064301");
            hashMap.put("token", "7178675152");
            hashMap.put(AudienceReportConst.TERMINAL_TYPE, "Android");
            hashMap.put("band", this.f378455a);
            hashMap.put("model", this.f378456b);
            hashMap.put("network_type", this.f378457c);
            hashMap.put("version", this.f378458d);
            hashMap.put("sub_version", this.f378459e);
            hashMap.put(AudienceReportConst.ROOM_ID, String.valueOf(this.f378460f));
            hashMap.put(AudienceReportConst.ROOM_NAME, this.f378461g);
            hashMap.put(AudienceReportConst.ANCHOR_ID, String.valueOf(this.f378462h));
            hashMap.put(AudienceReportConst.ANCHOR_NAME, this.f378463i);
            hashMap.put("room_type", String.valueOf(this.f378464j));
            hashMap.put("room_mode", this.f378465k);
            hashMap.put("end_time", String.valueOf(this.f378466l));
            hashMap.put("action_desc", this.f378467m);
            hashMap.put("info_desc", this.f378468n);
            hashMap.put("error_code", String.valueOf(this.f378469o));
            hashMap.put("program_id", this.f378470p);
            hashMap.put(ShortVideoConstants.MEDIA_INFO, this.f378471q);
            hashMap.put("time_cost", String.valueOf(this.f378472r));
            hashMap.put("trace_id", this.f378473s);
            StringBuilder sb5 = new StringBuilder("https://h.trace.qq.com/kv?");
            for (Map.Entry entry : hashMap.entrySet()) {
                sb5.append((String) entry.getKey());
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append((String) entry.getValue());
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb5.append("_dc");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(Math.random());
            QLog.d("AnchorQualityAttarReporter", 1, sb5.toString());
            b(sb5.toString());
        } catch (Exception e16) {
            QLog.e("AnchorQualityAttarReporter", 1, "set video clarify json fail! " + e16.getLocalizedMessage());
        }
    }

    @VisibleForTesting
    void b(String str) {
        TrafficStats.setThreadStatsTag(-255);
        em4.a.b(str, "AnchorQualityAttarReporter");
    }
}
