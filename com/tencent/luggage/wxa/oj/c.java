package com.tencent.luggage.wxa.oj;

import com.tencent.luggage.wxa.eo.g;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.o;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.apache.commons.lang.ArrayUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface c {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a extends com.tencent.luggage.wxa.eo.c {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.oj.c$a$-CC, reason: invalid class name */
        /* loaded from: classes8.dex */
        public final /* synthetic */ class CC {
            public static c a() {
                return (c) Proxy.newProxyInstance(c.class.getClassLoader(), new Class[]{c.class}, new C6553a());
            }

            public static c b(v vVar) {
                if (vVar.D().getStatusBar() == null) {
                    return a();
                }
                com.tencent.luggage.wxa.k0.d.a(g.a(a.class));
                if (!((com.tencent.luggage.wxa.j4.a) vVar.a(com.tencent.luggage.wxa.j4.a.class)).f130781b.b()) {
                    return new com.tencent.luggage.wxa.oj.a(vVar);
                }
                return new com.tencent.luggage.wxa.oj.b(vVar);
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.oj.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6553a extends o {
            @Override // com.tencent.luggage.wxa.uk.o, java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) {
                w.d("Luggage.WXA.IPageStatusBarHelper.Dummy", "dummy invoke method(%s) args(%s)", method.getName(), ArrayUtils.toString(objArr, "NULL"));
                return super.invoke(obj, method, objArr);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum b {
        SHOWN,
        HIDDEN
    }

    void a();

    void b();

    void c();

    void d();

    b getCurrentState();
}
