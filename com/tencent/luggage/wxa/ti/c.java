package com.tencent.luggage.wxa.ti;

import android.media.AudioRecord;
import android.os.HandlerThread;
import com.tencent.luggage.wxa.ti.a;
import com.tencent.luggage.wxa.ti.e;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.w;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends e {

    /* renamed from: e, reason: collision with root package name */
    public AudioRecord f141385e;

    /* renamed from: g, reason: collision with root package name */
    public a.b f141387g;

    /* renamed from: i, reason: collision with root package name */
    public boolean f141389i;

    /* renamed from: j, reason: collision with root package name */
    public int f141390j;

    /* renamed from: k, reason: collision with root package name */
    public int f141391k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f141392l;

    /* renamed from: f, reason: collision with root package name */
    public HandlerThread f141386f = null;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f141388h = null;

    /* renamed from: m, reason: collision with root package name */
    public AudioRecord.OnRecordPositionUpdateListener f141393m = new a();

    public c(AudioRecord audioRecord, a.b bVar, boolean z16, int i3, int i16) {
        this.f141385e = audioRecord;
        this.f141387g = bVar;
        this.f141389i = z16;
        this.f141390j = i3;
        this.f141391k = i16;
    }

    @Override // com.tencent.luggage.wxa.ti.e
    public void b() {
        this.f141385e.setRecordPositionUpdateListener(null);
        this.f141385e = null;
        this.f141386f.quit();
        this.f141386f = null;
    }

    @Override // com.tencent.luggage.wxa.ti.e
    public boolean a() {
        if (this.f141386f != null) {
            w.b("MicroMsg.RecordModeAsyncCallback", "alreay started record");
            return false;
        }
        HandlerThread b16 = com.tencent.luggage.wxa.cq.d.b("RecordModeAsyncCallback_handlerThread", 10);
        this.f141386f = b16;
        b16.start();
        this.f141385e.setRecordPositionUpdateListener(this.f141393m, b0.a(this.f141386f.getLooper()));
        this.f141385e.setPositionNotificationPeriod(this.f141390j);
        if (this.f141389i || this.f141388h == null) {
            this.f141388h = new byte[this.f141391k];
        }
        int read = this.f141385e.read(this.f141388h, 0, this.f141391k);
        w.a("MicroMsg.RecordModeAsyncCallback", "startRecord, read ret: " + read);
        a.b bVar = this.f141387g;
        if (bVar == null || read <= 0) {
            return true;
        }
        bVar.a(this.f141388h, read);
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements AudioRecord.OnRecordPositionUpdateListener {
        public a() {
        }

        @Override // android.media.AudioRecord.OnRecordPositionUpdateListener
        public void onPeriodicNotification(AudioRecord audioRecord) {
            c cVar = c.this;
            if (!cVar.f141421c && cVar.f141385e != null) {
                if (c.this.f141389i || c.this.f141388h == null) {
                    c cVar2 = c.this;
                    cVar2.f141388h = new byte[cVar2.f141391k];
                }
                int read = c.this.f141385e.read(c.this.f141388h, 0, c.this.f141391k);
                w.a("MicroMsg.RecordModeAsyncCallback", "OnRecordPositionUpdateListener, read ret: " + read);
                c cVar3 = c.this;
                e.a aVar = cVar3.f141419a;
                if (aVar != null) {
                    aVar.a(read, cVar3.f141388h);
                }
                if (read > c.this.f141388h.length) {
                    read = c.this.f141388h.length;
                }
                if (c.this.f141392l && read > 0) {
                    Arrays.fill(c.this.f141388h, 0, read, (byte) 0);
                }
                if (c.this.f141387g != null && read > 0) {
                    c.this.f141387g.a(c.this.f141388h, read);
                }
            }
        }

        @Override // android.media.AudioRecord.OnRecordPositionUpdateListener
        public void onMarkerReached(AudioRecord audioRecord) {
        }
    }
}
