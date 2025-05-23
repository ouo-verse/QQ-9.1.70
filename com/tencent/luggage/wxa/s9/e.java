package com.tencent.luggage.wxa.s9;

import android.media.AudioRecord;
import android.os.Build;
import com.tencent.luggage.wxa.t9.x;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public a f140211a = null;

    /* renamed from: b, reason: collision with root package name */
    public a f140212b = null;

    /* renamed from: c, reason: collision with root package name */
    public a f140213c = null;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        boolean a();

        boolean setEnabled(boolean z16);
    }

    public boolean a(AudioRecord audioRecord, int i3) {
        w.a("MicroMsg.MMAudioPreProcess", "api " + Build.VERSION.SDK_INT);
        if (com.tencent.luggage.wxa.aa.a.a(16)) {
            return false;
        }
        if (audioRecord == null) {
            w.a("MicroMsg.MMAudioPreProcess", "audio is null");
            return false;
        }
        if (1 == i3) {
            com.tencent.luggage.wxa.t9.e eVar = x.f141187m;
            if (eVar.O != 1) {
                w.a("MicroMsg.MMAudioPreProcess", "disable by config");
                return false;
            }
            if (eVar.P != 2) {
                g gVar = new g(audioRecord);
                this.f140211a = gVar;
                if (gVar.a()) {
                    this.f140211a.setEnabled(true);
                }
            }
            if (x.f141187m.Q != 2) {
                c cVar = new c(audioRecord);
                this.f140212b = cVar;
                if (cVar.a()) {
                    this.f140212b.setEnabled(true);
                }
            }
            if (x.f141187m.R != 2) {
                f fVar = new f(audioRecord);
                this.f140213c = fVar;
                if (fVar.a()) {
                    this.f140213c.setEnabled(true);
                }
            }
            return true;
        }
        if (x.f141187m.f141015k != 1) {
            w.a("MicroMsg.MMAudioPreProcess", "disable by config");
            return false;
        }
        g gVar2 = new g(audioRecord);
        this.f140211a = gVar2;
        if (gVar2.a()) {
            this.f140211a.setEnabled(true);
        }
        c cVar2 = new c(audioRecord);
        this.f140212b = cVar2;
        if (cVar2.a()) {
            this.f140212b.setEnabled(true);
        }
        f fVar2 = new f(audioRecord);
        this.f140213c = fVar2;
        if (fVar2.a()) {
            this.f140213c.setEnabled(true);
        }
        return true;
    }
}
