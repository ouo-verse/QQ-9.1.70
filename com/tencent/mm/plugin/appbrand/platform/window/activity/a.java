package com.tencent.mm.plugin.appbrand.platform.window.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.o;
import com.tencent.luggage.wxa.xj.l;
import com.tencent.luggage.wxa.xj.m;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.apache.commons.lang.ArrayUtils;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface a {
    void a(Configuration configuration);

    boolean a();

    int b();

    /* compiled from: P */
    /* renamed from: com.tencent.mm.plugin.appbrand.platform.window.activity.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C7063a {

        /* compiled from: P */
        /* renamed from: com.tencent.mm.plugin.appbrand.platform.window.activity.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C7064a extends o {
            @Override // com.tencent.luggage.wxa.uk.o, java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) {
                w.d("Luggage.WXA.WindowAndroidActivityCutoutHandler.Dummy", "dummy invoke method(%s) args(%s)", method.getName(), ArrayUtils.toString(objArr, "NULL"));
                return super.invoke(obj, method, objArr);
            }
        }

        public static a a(Activity activity) {
            if (activity == null) {
                return a();
            }
            if (Build.VERSION.SDK_INT >= 28) {
                return new l(activity);
            }
            return new m(activity);
        }

        public static a a() {
            return (a) Proxy.newProxyInstance(a.class.getClassLoader(), new Class[]{a.class}, new C7064a());
        }
    }
}
