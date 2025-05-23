package com.tencent.mobileqq.qqguildsdk.manager;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine;
import vh2.ai;
import vh2.am;
import vh2.ar;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final GPSManagerEngine f268458a;

    /* renamed from: b, reason: collision with root package name */
    private yh2.c f268459b;

    /* renamed from: c, reason: collision with root package name */
    private yh2.b f268460c;

    /* renamed from: d, reason: collision with root package name */
    private yh2.a f268461d;

    public e(GPSManagerEngine gPSManagerEngine) {
        this.f268458a = gPSManagerEngine;
    }

    public void a() {
        this.f268459b = null;
        this.f268460c = null;
        this.f268461d = null;
    }

    @MainThread
    public void b(String str, String str2, int i3, boolean z16, @NonNull ai aiVar) {
        yh2.a aVar = this.f268461d;
        if (aVar == null) {
            this.f268461d = new yh2.a(this.f268458a, str, str2);
        } else if (z16 || !str.equals(aVar.d()) || !str2.equals(this.f268461d.c())) {
            this.f268461d = new yh2.a(this.f268458a, str, str2);
        }
        this.f268461d.b(i3, aiVar);
    }

    @MainThread
    public void c(String str, String str2, String str3, String str4, int i3, boolean z16, @NonNull am amVar) {
        yh2.b bVar = this.f268460c;
        if (bVar == null) {
            this.f268460c = new yh2.b(this.f268458a, str, str2, str3, str4);
        } else if (z16 || !str.equals(bVar.e()) || !str2.equals(this.f268460c.d()) || !str3.equals(this.f268460c.c()) || !str4.equals(this.f268460c.f())) {
            this.f268460c = new yh2.b(this.f268458a, str, str2, str3, str4);
        }
        this.f268460c.b(i3, amVar);
    }

    @MainThread
    public void d(String str, String str2, String str3, String str4, int i3, boolean z16, @NonNull ar arVar) {
        yh2.c cVar = this.f268459b;
        if (cVar == null) {
            this.f268459b = new yh2.c(this.f268458a, str, str2, str3, str4);
        } else if (z16 || !str.equals(cVar.e()) || !str2.equals(this.f268459b.d()) || !str3.equals(this.f268459b.c()) || !str4.equals(this.f268459b.f())) {
            this.f268459b = new yh2.c(this.f268458a, str, str2, str3, str4);
        }
        this.f268459b.b(i3, arVar);
    }
}
