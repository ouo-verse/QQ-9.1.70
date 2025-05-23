package com.tencent.qqmini.minigame;

/* compiled from: P */
/* loaded from: classes23.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f346359b;

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC9388a f346360a;

    /* compiled from: P */
    /* renamed from: com.tencent.qqmini.minigame.a$a, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public interface InterfaceC9388a {
        void a(String str, String str2);
    }

    public static a a() {
        if (f346359b == null) {
            synchronized (a.class) {
                if (f346359b == null) {
                    f346359b = new a();
                }
            }
        }
        return f346359b;
    }

    public void b(String str, String str2) {
        InterfaceC9388a interfaceC9388a = this.f346360a;
        if (interfaceC9388a != null) {
            interfaceC9388a.a(str, str2);
        }
    }

    public void c(InterfaceC9388a interfaceC9388a) {
        this.f346360a = interfaceC9388a;
    }
}
