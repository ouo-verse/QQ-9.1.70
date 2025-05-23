package lk0;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class g implements Cloneable {
    public String D;

    /* renamed from: d, reason: collision with root package name */
    public String f414937d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f414938e;

    /* renamed from: f, reason: collision with root package name */
    public String f414939f;

    /* renamed from: i, reason: collision with root package name */
    public String f414941i;

    /* renamed from: m, reason: collision with root package name */
    public int f414942m;

    /* renamed from: h, reason: collision with root package name */
    public h f414940h = new h();
    public ArrayList<String> C = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(String str, int i3) {
        this.f414941i = str;
        this.f414942m = i3;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("SpanText:[");
        sb5.append("\n |-");
        sb5.append("spanType :");
        sb5.append(this.f414937d);
        if ("image".equals(this.f414937d)) {
            sb5.append("\n |-");
            sb5.append("src :");
            sb5.append(this.f414939f);
        } else if ("text".equals(this.f414937d)) {
            sb5.append("\n |-");
            sb5.append("text :");
            sb5.append(this.f414938e);
        }
        sb5.append("]");
        return sb5.toString();
    }
}
