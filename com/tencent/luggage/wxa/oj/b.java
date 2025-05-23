package com.tencent.luggage.wxa.oj;

import android.app.Activity;
import android.content.Context;
import com.tencent.luggage.wxa.j4.a;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.mj.i;
import com.tencent.luggage.wxa.oj.c;
import com.tencent.luggage.wxa.ok.g;
import com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements c {

    /* renamed from: a, reason: collision with root package name */
    public final v f136548a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f136549b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f136550a;

        static {
            int[] iArr = new int[a.EnumC6326a.values().length];
            f136550a = iArr;
            try {
                iArr[a.EnumC6326a.FULLSCREEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f136550a[a.EnumC6326a.HIDE_STATUS_BAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f136550a[a.EnumC6326a.HIDE_NAVIGATION_BAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f136550a[a.EnumC6326a.NORMAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public b(v vVar) {
        AtomicReference atomicReference = new AtomicReference();
        this.f136549b = atomicReference;
        atomicReference.set(c.b.SHOWN);
        this.f136548a = vVar;
    }

    @Override // com.tencent.luggage.wxa.oj.c
    public void d() {
        Activity activity;
        if (this.f136548a.D() instanceof WindowAndroidActivityImpl) {
            activity = ((WindowAndroidActivityImpl) this.f136548a.D()).j();
        } else {
            this.f136548a.D();
            activity = null;
        }
        if (activity != null) {
            int i3 = a.f136550a[((com.tencent.luggage.wxa.j4.a) this.f136548a.a(com.tencent.luggage.wxa.j4.a.class)).f130781b.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            g.a((Context) activity, false);
                            return;
                        }
                        return;
                    } else {
                        g.a((Context) activity, false);
                        g.b((Context) activity, true);
                        return;
                    }
                }
                g.a((Context) activity, false);
                i iVar = (i) this.f136548a.f(i.class);
                if (iVar != null) {
                    iVar.a();
                    return;
                }
                return;
            }
            g.a((Context) activity, true);
        }
    }

    @Override // com.tencent.luggage.wxa.oj.c
    public c.b getCurrentState() {
        return (c.b) this.f136549b.get();
    }

    @Override // com.tencent.luggage.wxa.oj.c
    public void a() {
    }

    @Override // com.tencent.luggage.wxa.oj.c
    public void b() {
    }

    @Override // com.tencent.luggage.wxa.oj.c
    public void c() {
    }
}
