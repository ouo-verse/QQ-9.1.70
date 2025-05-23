package com.xiaomi.push;

import com.xiaomi.push.dw;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes28.dex */
public class el implements am.b.d {

    /* renamed from: a, reason: collision with root package name */
    private XMPushService f388737a;

    /* renamed from: b, reason: collision with root package name */
    private am.b f388738b;

    /* renamed from: c, reason: collision with root package name */
    private ep f388739c;

    /* renamed from: e, reason: collision with root package name */
    private int f388741e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f388742f = false;

    /* renamed from: d, reason: collision with root package name */
    private am.c f388740d = am.c.binding;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f388744a;

        static {
            int[] iArr = new int[am.c.values().length];
            f388744a = iArr;
            try {
                iArr[am.c.unbind.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f388744a[am.c.binding.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f388744a[am.c.binded.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public el(XMPushService xMPushService, am.b bVar) {
        this.f388737a = xMPushService;
        this.f388738b = bVar;
    }

    private void d() {
        this.f388738b.n(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        d();
        if (!this.f388742f || this.f388741e == 11) {
            return;
        }
        ej a16 = dy.f().a();
        int i3 = a.f388744a[this.f388740d.ordinal()];
        if (i3 != 1) {
            if (i3 == 3) {
                a16.f24713a = ei.BIND_SUCCESS.a();
            }
        } else {
            int i16 = this.f388741e;
            if (i16 == 17) {
                a16.f24713a = ei.BIND_TCP_READ_TIMEOUT.a();
            } else if (i16 == 21) {
                a16.f24713a = ei.BIND_TIMEOUT.a();
            } else {
                try {
                    dw.a d16 = dw.d(dy.e().a());
                    a16.f24713a = d16.f388627a.a();
                    a16.c(d16.f388628b);
                } catch (NullPointerException unused) {
                    a16 = null;
                }
            }
        }
        if (a16 != null) {
            a16.b(this.f388739c.d());
            a16.d(this.f388738b.f389606b);
            a16.f388727b = 1;
            try {
                a16.a((byte) Integer.parseInt(this.f388738b.f389612h));
            } catch (NumberFormatException unused2) {
            }
            dy.f().i(a16);
        }
    }

    @Override // com.xiaomi.push.service.am.b.d
    public void a(am.c cVar, am.c cVar2, int i3) {
        if (!this.f388742f && cVar == am.c.binding) {
            this.f388740d = cVar2;
            this.f388741e = i3;
            this.f388742f = true;
        }
        this.f388737a.a(new XMPushService.j(4) { // from class: com.xiaomi.push.el.1
            @Override // com.xiaomi.push.service.XMPushService.j
            public void a() {
                el.this.e();
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String e() {
                return "Handling bind stats";
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f388738b.i(this);
        this.f388739c = this.f388737a.m454a();
    }
}
