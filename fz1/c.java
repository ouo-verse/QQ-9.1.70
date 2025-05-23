package fz1;

import java.util.Objects;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c extends b {

    /* renamed from: a, reason: collision with root package name */
    private int f400966a;

    /* renamed from: b, reason: collision with root package name */
    private String f400967b;

    public c(int i3, String str) {
        this.f400966a = i3;
        this.f400967b = str;
    }

    @Override // fz1.b
    public int a() {
        return 1;
    }

    public int b() {
        return this.f400966a;
    }

    public String c() {
        return this.f400967b;
    }

    @Override // fz1.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f400966a == cVar.f400966a && Objects.equals(this.f400967b, cVar.f400967b)) {
            return true;
        }
        return false;
    }
}
