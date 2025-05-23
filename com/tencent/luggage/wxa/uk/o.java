package com.tencent.luggage.wxa.uk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.apache.commons.lang.ArrayUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class o implements InvocationHandler {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends o {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f142770a;

        public a(String str) {
            this.f142770a = str;
        }

        @Override // com.tencent.luggage.wxa.uk.o, java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            com.tencent.luggage.wxa.tn.w.d(this.f142770a, "dummy invoke method(%s) args(%s)", method.getName(), ArrayUtils.toString(objArr, "NULL"));
            return super.invoke(obj, method, objArr);
        }
    }

    public static Object a(String str, Class cls) {
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(str)));
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        Class<?> returnType = method.getReturnType();
        if (returnType.equals(Integer.TYPE)) {
            return 0;
        }
        if (returnType.equals(Long.TYPE)) {
            return 0L;
        }
        if (returnType.equals(Double.TYPE)) {
            return Double.valueOf(0.0d);
        }
        if (returnType.equals(Float.TYPE)) {
            return Float.valueOf(0.0f);
        }
        if (returnType.equals(Short.TYPE) || returnType.equals(Byte.TYPE) || returnType.equals(Character.TYPE)) {
            return 0;
        }
        if (returnType.equals(Boolean.TYPE)) {
            return Boolean.FALSE;
        }
        if (returnType.equals(Boolean.class)) {
            return Boolean.FALSE;
        }
        returnType.isInterface();
        return null;
    }
}
