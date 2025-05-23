package com.tencent.mobileqq.filemanager.util;

import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ReflectBuilder<T> {

    /* renamed from: a, reason: collision with root package name */
    private int f209298a = 12288;

    /* renamed from: b, reason: collision with root package name */
    private Class<?>[] f209299b;

    /* renamed from: c, reason: collision with root package name */
    private Object[] f209300c;

    /* renamed from: d, reason: collision with root package name */
    private Class<?> f209301d;

    /* renamed from: e, reason: collision with root package name */
    private String f209302e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f209303f;

    /* renamed from: g, reason: collision with root package name */
    private Object f209304g;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    static class WrongParamException extends Exception {
        WrongParamException() {
            Log.d("WrongParamException", "\u65b9\u6cd5\u53c2\u6570\u8bbe\u7f6e\u6709\u95ee\u9898");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectBuilder<T> a(Object... objArr) {
        Object[] objArr2 = new Object[objArr.length];
        this.f209300c = objArr2;
        System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectBuilder<T> b(Class<?>... clsArr) {
        Class<?>[] clsArr2 = new Class[clsArr.length];
        this.f209299b = clsArr2;
        System.arraycopy(clsArr, 0, clsArr2, 0, clsArr.length);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() throws WrongParamException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (this.f209298a == 8192 && this.f209301d != null && this.f209304g != null && !TextUtils.isEmpty(this.f209302e)) {
            Class<?>[] clsArr = this.f209299b;
            if (clsArr.length == this.f209300c.length) {
                Method declaredMethod = this.f209301d.getDeclaredMethod(this.f209302e, clsArr);
                if (this.f209303f) {
                    declaredMethod.setAccessible(true);
                }
                declaredMethod.invoke(this.f209304g, this.f209300c);
                return;
            }
            throw new WrongParamException();
        }
        throw new WrongParamException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectBuilder<T> d(boolean z16) {
        this.f209303f = z16;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectBuilder<T> e(String str) {
        this.f209302e = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectBuilder<T> f(Class<?> cls, Object obj) {
        this.f209301d = cls;
        this.f209304g = obj;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectBuilder<T> g(int i3) {
        this.f209298a = i3;
        return this;
    }
}
