package com.tencent.gamecenter.wadl.sdk.downloader.task;

import android.os.SystemClock;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private f f107444b;

    /* renamed from: a, reason: collision with root package name */
    private long f107443a = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f107445c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f107446d = 0;

    /* renamed from: e, reason: collision with root package name */
    private long f107447e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f107448f = 0;

    /* renamed from: g, reason: collision with root package name */
    private List<C1132a> f107449g = new LinkedList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.gamecenter.wadl.sdk.downloader.task.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1132a {

        /* renamed from: a, reason: collision with root package name */
        int f107450a;

        /* renamed from: b, reason: collision with root package name */
        int f107451b = 0;

        public C1132a(int i3) {
            this.f107450a = i3;
        }
    }

    public a(f fVar) {
        this.f107444b = fVar;
    }

    private int a() {
        if (this.f107449g.size() == 0) {
            return 0;
        }
        long j3 = 0;
        for (C1132a c1132a : this.f107449g) {
            if (c1132a.f107451b <= 2000) {
                j3 += c1132a.f107450a;
                if (j3 < 0) {
                    com.tencent.gamecenter.wadl.sdk.common.e.b.e("Wadl-downloader-CostTimeCounter", "sum:" + j3 + ",len:" + c1132a.f107450a);
                }
            }
        }
        return (int) ((j3 * 1000) / 2000);
    }

    public void b() {
        System.currentTimeMillis();
    }

    public void c() {
        System.currentTimeMillis();
    }

    public void d() {
        this.f107443a = SystemClock.elapsedRealtime();
    }

    private void a(int i3) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = elapsedRealtime - this.f107443a;
        this.f107443a = elapsedRealtime;
        this.f107444b.f107512k += j3;
        b(i3);
        this.f107444b.f107517p = this.f107448f;
    }

    private void b(int i3) {
        boolean z16 = true;
        boolean z17 = i3 <= 0;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i16 = (int) (elapsedRealtime - this.f107446d);
        this.f107446d = elapsedRealtime;
        if (this.f107449g.size() != 0) {
            for (C1132a c1132a : this.f107449g) {
                int i17 = c1132a.f107451b + i16;
                c1132a.f107451b = i17;
                if (!z17 && i17 > 2000) {
                    c1132a.f107451b = 0;
                    c1132a.f107450a = i3;
                    z17 = true;
                }
            }
            if (!z17) {
                if (this.f107449g.size() > (2000 / com.tencent.gamecenter.wadl.sdk.downloader.a.a.f107278c) + 1) {
                    com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-CostTimeCounter", "records.size():" + this.f107449g.size());
                } else {
                    this.f107449g.add(new C1132a(i3));
                }
            }
            if (elapsedRealtime - this.f107447e <= 200) {
                z16 = false;
            }
        } else if (!z17) {
            this.f107449g.add(new C1132a(i3));
        }
        if (z16) {
            this.f107448f = a();
            this.f107447e = elapsedRealtime;
        }
    }

    public void a(int i3, int i16) {
        this.f107445c += i16;
        a(i3);
    }
}
