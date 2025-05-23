package com.tencent.beacon.event.c;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private volatile long f77910a = 0;

    /* renamed from: b, reason: collision with root package name */
    private volatile long f77911b = 0;

    /* renamed from: c, reason: collision with root package name */
    private volatile long f77912c = 0;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ g f77913d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(g gVar) {
        this.f77913d = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        AtomicLong atomicLong;
        AtomicLong atomicLong2;
        AtomicLong atomicLong3;
        Context context;
        SharedPreferences a16;
        String str;
        long j3;
        long j16;
        long j17;
        long j18;
        long j19;
        long j26;
        long j27;
        long j28;
        synchronized (this.f77913d) {
            atomicLong = this.f77913d.f77932r;
            long j29 = atomicLong.get();
            atomicLong2 = this.f77913d.f77931q;
            long j36 = atomicLong2.get();
            atomicLong3 = this.f77913d.f77933s;
            long j37 = atomicLong3.get();
            if (this.f77910a == j29 && this.f77911b == j36 && this.f77912c == j37) {
                return;
            }
            this.f77910a = j29;
            this.f77911b = j36;
            this.f77912c = j37;
            g gVar = this.f77913d;
            context = gVar.f77927m;
            a16 = gVar.a(context);
            SharedPreferences.Editor edit = a16.edit();
            if (com.tencent.beacon.base.util.b.a(edit)) {
                j16 = this.f77913d.f77930p;
                SharedPreferences.Editor putLong = edit.putLong("on_date", j16).putLong("realtime_log_id", this.f77910a).putLong("normal_log_id", this.f77911b).putLong("immediate_log_id", this.f77912c);
                j17 = this.f77913d.f77934t;
                SharedPreferences.Editor putLong2 = putLong.putLong("realtime_min_log_id", j17);
                j18 = this.f77913d.f77935u;
                SharedPreferences.Editor putLong3 = putLong2.putLong("realtime_max_log_id", j18);
                j19 = this.f77913d.f77936v;
                SharedPreferences.Editor putLong4 = putLong3.putLong("normal_min_log_id", j19);
                j26 = this.f77913d.f77937w;
                SharedPreferences.Editor putLong5 = putLong4.putLong("normal_max_log_id", j26);
                j27 = this.f77913d.f77938x;
                SharedPreferences.Editor putLong6 = putLong5.putLong("immediate_min_log_id", j27);
                j28 = this.f77913d.f77939y;
                putLong6.putLong("immediate_max_log_id", j28).apply();
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[LogID ");
            str = this.f77913d.f77928n;
            sb5.append(str);
            sb5.append("]");
            String sb6 = sb5.toString();
            j3 = this.f77913d.f77930p;
            com.tencent.beacon.base.util.c.a(sb6, "  write serial to sp, date: %s ,realtime: %d, normal: %d, immediate: %d ", Long.valueOf(j3), Long.valueOf(this.f77910a), Long.valueOf(this.f77911b), Long.valueOf(this.f77912c));
        }
    }
}
