package com.qq.e.comm.plugin.i.b;

import android.content.Context;
import com.qq.e.comm.plugin.i.i;
import com.qq.e.comm.plugin.i.j;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f39499a;

    /* renamed from: b, reason: collision with root package name */
    private j f39500b;

    a(Context context) {
        this.f39500b = new j(context);
    }

    public static a a(Context context) {
        if (f39499a == null) {
            synchronized (a.class) {
                if (f39499a == null) {
                    f39499a = new a(context);
                }
            }
        }
        return f39499a;
    }

    public void b(String str) {
        j jVar = this.f39500b;
        if (jVar != null) {
            jVar.a(str);
        }
    }

    public List<i> a(String str) {
        return this.f39500b.b(str);
    }

    public boolean a(String str, int i3) {
        return this.f39500b.a(str, i3);
    }

    public void a(i iVar) {
        j jVar = this.f39500b;
        if (jVar != null) {
            jVar.a(iVar);
        }
    }

    public void a(String str, int i3, long j3) {
        j jVar = this.f39500b;
        if (jVar != null) {
            jVar.a(str, i3, j3);
        }
    }

    public void a() {
        j jVar = this.f39500b;
        if (jVar != null) {
            jVar.a();
        }
    }
}
