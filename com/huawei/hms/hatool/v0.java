package com.huawei.hms.hatool;

import android.content.Context;
import android.util.Pair;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class v0 implements g {

    /* renamed from: a, reason: collision with root package name */
    private Context f37236a = q0.i();

    /* renamed from: b, reason: collision with root package name */
    private String f37237b;

    /* renamed from: c, reason: collision with root package name */
    private String f37238c;

    /* renamed from: d, reason: collision with root package name */
    private String f37239d;

    public v0(String str, String str2, String str3) {
        this.f37237b = str;
        this.f37238c = str2;
        this.f37239d = str3;
    }

    private void a(String str, List<b1> list) {
        Pair<String, String> a16 = n1.a(str);
        new u(list, (String) a16.first, (String) a16.second, this.f37239d).a();
    }

    @Override // java.lang.Runnable
    public void run() {
        Map<String, List<b1>> a16;
        v.c("hmsSdk", "eventReportTask is running");
        boolean a17 = c0.a(this.f37236a);
        if (a17) {
            v.c("hmsSdk", "workKey is refresh,begin report all data");
            this.f37238c = "alltype";
        }
        try {
            try {
                a16 = c1.a(this.f37236a, this.f37237b, this.f37238c);
            } catch (IllegalArgumentException e16) {
                v.e("hmsSdk", "readEventRecords handData IllegalArgumentException:" + e16.getMessage());
                if ("alltype".equals(this.f37238c)) {
                    d.a(this.f37236a, "stat_v2_1", new String[0]);
                    d.a(this.f37236a, "cached_v2_1", new String[0]);
                } else {
                    String a18 = n1.a(this.f37237b, this.f37238c);
                    d.a(this.f37236a, "stat_v2_1", a18);
                    d.a(this.f37236a, "cached_v2_1", a18);
                }
            } catch (Exception e17) {
                v.e("hmsSdk", "readEventRecords handData Exception:" + e17.getMessage());
                if ("alltype".equals(this.f37238c)) {
                    d.a(this.f37236a, "stat_v2_1", new String[0]);
                    d.a(this.f37236a, "cached_v2_1", new String[0]);
                } else {
                    String a19 = n1.a(this.f37237b, this.f37238c);
                    d.a(this.f37236a, "stat_v2_1", a19);
                    d.a(this.f37236a, "cached_v2_1", a19);
                }
            }
            if (a16.size() == 0) {
                v.b("hmsSdk", "no have events to report: tag:%s : type:%s", this.f37237b, this.f37238c);
                if ("alltype".equals(this.f37238c)) {
                    d.a(this.f37236a, "stat_v2_1", new String[0]);
                    d.a(this.f37236a, "cached_v2_1", new String[0]);
                    return;
                } else {
                    String a26 = n1.a(this.f37237b, this.f37238c);
                    d.a(this.f37236a, "stat_v2_1", a26);
                    d.a(this.f37236a, "cached_v2_1", a26);
                    return;
                }
            }
            for (Map.Entry<String, List<b1>> entry : a16.entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
            if ("alltype".equals(this.f37238c)) {
                d.a(this.f37236a, "stat_v2_1", new String[0]);
                d.a(this.f37236a, "cached_v2_1", new String[0]);
            } else {
                String a27 = n1.a(this.f37237b, this.f37238c);
                d.a(this.f37236a, "stat_v2_1", a27);
                d.a(this.f37236a, "cached_v2_1", a27);
            }
            if (a17) {
                v.c("hmsSdk", "refresh local key");
                o0.d().b();
            }
        } catch (Throwable th5) {
            if ("alltype".equals(this.f37238c)) {
                d.a(this.f37236a, "stat_v2_1", new String[0]);
                d.a(this.f37236a, "cached_v2_1", new String[0]);
            } else {
                String a28 = n1.a(this.f37237b, this.f37238c);
                d.a(this.f37236a, "stat_v2_1", a28);
                d.a(this.f37236a, "cached_v2_1", a28);
            }
            throw th5;
        }
    }
}
