package n04;

import com.tencent.rmonitor.common.util.e;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f417933a;

    /* renamed from: b, reason: collision with root package name */
    public final String f417934b;

    /* renamed from: c, reason: collision with root package name */
    public final String f417935c;

    /* renamed from: d, reason: collision with root package name */
    public final String f417936d;

    /* renamed from: e, reason: collision with root package name */
    public final int f417937e;

    /* renamed from: f, reason: collision with root package name */
    public final int f417938f;

    /* renamed from: g, reason: collision with root package name */
    public final int f417939g;

    /* renamed from: h, reason: collision with root package name */
    public final int f417940h;

    /* renamed from: i, reason: collision with root package name */
    public final int f417941i;

    /* renamed from: j, reason: collision with root package name */
    public final long f417942j;

    /* renamed from: k, reason: collision with root package name */
    public String f417943k;

    /* renamed from: l, reason: collision with root package name */
    public final long f417944l;

    public b(String str, String str2, String str3, String str4, int i3, int i16, int i17, int i18, int i19, long j3, String str5, long j16) {
        this.f417933a = str;
        this.f417934b = str2;
        this.f417936d = str3;
        this.f417935c = str4;
        this.f417937e = i3;
        this.f417938f = i16;
        this.f417939g = i17;
        this.f417940h = i18;
        this.f417941i = i19;
        this.f417942j = j3;
        this.f417943k = str5;
        this.f417944l = j16;
    }

    private boolean a(b bVar) {
        if (this.f417937e == bVar.f417937e && this.f417938f == bVar.f417938f && this.f417939g == bVar.f417939g && this.f417940h == bVar.f417940h && this.f417941i == bVar.f417941i && e.a(this.f417933a, bVar.f417933a) && e.a(this.f417935c, bVar.f417935c) && e.a(this.f417943k, bVar.f417943k)) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return a((b) obj);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f417933a, this.f417935c, Integer.valueOf(this.f417937e), Integer.valueOf(this.f417938f), Integer.valueOf(this.f417939g), Integer.valueOf(this.f417940h), Integer.valueOf(this.f417941i), this.f417943k});
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(256);
        sb5.append(this.f417944l);
        sb5.append(",");
        sb5.append(this.f417933a);
        sb5.append(",");
        sb5.append(this.f417939g);
        sb5.append(",");
        sb5.append(this.f417940h);
        sb5.append(",");
        sb5.append(this.f417937e);
        sb5.append(",");
        sb5.append(this.f417938f);
        sb5.append(",");
        sb5.append(this.f417935c);
        sb5.append(",");
        sb5.append(this.f417934b);
        sb5.append(",");
        sb5.append(this.f417936d);
        sb5.append(",");
        sb5.append(this.f417941i);
        sb5.append(",");
        sb5.append(this.f417942j);
        sb5.append(",");
        sb5.append(this.f417943k);
        sb5.append("\r\n");
        return String.format("ExceedBitmapInfo{%s}", sb5);
    }
}
