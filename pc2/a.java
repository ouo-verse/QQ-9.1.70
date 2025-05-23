package pc2;

import androidx.annotation.NonNull;
import trpc.qq_onlinestatus.olympic_medal.OlympicMedalEvent$MedalEventInfo;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f425890a;

    /* renamed from: b, reason: collision with root package name */
    private int f425891b;

    /* renamed from: c, reason: collision with root package name */
    private long f425892c;

    /* renamed from: d, reason: collision with root package name */
    private long f425893d;

    /* renamed from: e, reason: collision with root package name */
    private int f425894e;

    /* renamed from: f, reason: collision with root package name */
    private String f425895f;

    public a() {
        this.f425890a = false;
        this.f425891b = -1;
        this.f425892c = -1L;
        this.f425893d = -1L;
        this.f425894e = -1;
        this.f425895f = null;
    }

    public int a() {
        return this.f425891b;
    }

    public boolean b() {
        return this.f425890a;
    }

    public String c() {
        return this.f425895f;
    }

    public long d() {
        return this.f425893d;
    }

    public long e() {
        return this.f425892c;
    }

    public int f() {
        return this.f425894e;
    }

    public void g(a aVar) {
        this.f425895f = aVar.c();
        this.f425894e = aVar.f();
        this.f425891b = aVar.a();
    }

    public void h(OlympicMedalEvent$MedalEventInfo olympicMedalEvent$MedalEventInfo) {
        if (olympicMedalEvent$MedalEventInfo.event_id.has()) {
            this.f425891b = olympicMedalEvent$MedalEventInfo.event_id.get();
        }
        if (olympicMedalEvent$MedalEventInfo.start.has()) {
            this.f425892c = olympicMedalEvent$MedalEventInfo.start.get();
        }
        if (olympicMedalEvent$MedalEventInfo.end.has()) {
            this.f425893d = olympicMedalEvent$MedalEventInfo.end.get();
        }
        if (olympicMedalEvent$MedalEventInfo.f437236msg.has()) {
            this.f425895f = olympicMedalEvent$MedalEventInfo.f437236msg.get();
        }
    }

    public void i(boolean z16) {
        this.f425890a = z16;
    }

    public void j(int i3) {
        this.f425894e = i3;
    }

    @NonNull
    public String toString() {
        return "OlympicMedalEventInfo@{isValid=" + this.f425890a + " eventId=" + this.f425891b + " start=" + this.f425892c + " end=" + this.f425893d + " pullInterval=" + this.f425894e + " msg=" + this.f425895f + "}\n";
    }

    public a(int i3, long j3, long j16, String str) {
        this.f425890a = true;
        this.f425891b = i3;
        this.f425892c = j3;
        this.f425893d = j16;
        this.f425894e = -1;
        this.f425895f = str;
    }
}
