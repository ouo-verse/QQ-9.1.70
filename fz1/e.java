package fz1;

import java.util.Objects;

/* compiled from: P */
/* loaded from: classes14.dex */
public class e extends b {

    /* renamed from: a, reason: collision with root package name */
    private String f400968a;

    /* renamed from: b, reason: collision with root package name */
    private String f400969b;

    /* renamed from: c, reason: collision with root package name */
    private String f400970c;

    public e(String str, String str2, String str3) {
        this.f400968a = str;
        this.f400969b = str2;
        this.f400970c = str3;
    }

    @Override // fz1.b
    public int a() {
        return 2;
    }

    public String b() {
        return this.f400970c;
    }

    public String c() {
        return this.f400968a;
    }

    @Override // fz1.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (Objects.equals(this.f400968a, eVar.f400968a) && Objects.equals(this.f400969b, eVar.f400969b) && Objects.equals(this.f400970c, eVar.f400970c)) {
            return true;
        }
        return false;
    }
}
