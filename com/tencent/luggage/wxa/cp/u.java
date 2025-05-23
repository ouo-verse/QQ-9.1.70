package com.tencent.luggage.wxa.cp;

import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    public final d f123837a;

    /* renamed from: b, reason: collision with root package name */
    public Object f123838b;

    public u(d dVar) {
        this.f123837a = dVar;
    }

    public Object a(Map map, String str) {
        if (this.f123838b == null) {
            this.f123838b = this.f123837a.a(map);
            com.tencent.luggage.wxa.yp.b.c("VFS.FileSystemManager", "configure: " + str + " => " + this.f123838b);
        }
        return this.f123838b;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof u) && this.f123837a.equals(((u) obj).f123837a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return u.class.hashCode() ^ this.f123837a.hashCode();
    }

    public String toString() {
        d dVar = this.f123837a;
        if (dVar == null) {
            return "[NULL]";
        }
        return dVar.toString();
    }

    public u(u uVar) {
        this.f123837a = uVar.f123837a;
        this.f123838b = null;
    }
}
