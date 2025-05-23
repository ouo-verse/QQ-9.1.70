package ku3;

import com.tencent.qqmini.sdk.launcher.log.QMLog;

/* compiled from: P */
/* loaded from: classes23.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f413045a;

    /* renamed from: b, reason: collision with root package name */
    public String f413046b;

    /* renamed from: c, reason: collision with root package name */
    public String f413047c;

    /* renamed from: d, reason: collision with root package name */
    public String f413048d;

    /* renamed from: e, reason: collision with root package name */
    public String f413049e;

    /* renamed from: f, reason: collision with root package name */
    public String f413050f;

    /* renamed from: g, reason: collision with root package name */
    public b f413051g;

    /* renamed from: h, reason: collision with root package name */
    public int f413052h;

    public void a(String str) {
        String str2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("isShow:");
        sb5.append(this.f413045a);
        sb5.append(",iconUrl:");
        sb5.append(this.f413046b);
        sb5.append(",pageUrl:");
        sb5.append(this.f413047c);
        sb5.append(",wording:");
        sb5.append(this.f413049e);
        sb5.append(",title:");
        sb5.append(this.f413050f);
        sb5.append(", displayDuration:");
        sb5.append(this.f413052h);
        sb5.append(",redDot:");
        b bVar = this.f413051g;
        if (bVar != null) {
            str2 = bVar.toString();
        } else {
            str2 = "null";
        }
        sb5.append(str2);
        QMLog.i(str, sb5.toString());
    }
}
