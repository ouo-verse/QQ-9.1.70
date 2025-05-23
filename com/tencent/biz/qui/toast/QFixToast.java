package com.tencent.biz.qui.toast;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;
import android.widget.Toast;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import ud0.d;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFixToast extends Toast {

    /* renamed from: b, reason: collision with root package name */
    private static Field f95348b;

    /* renamed from: a, reason: collision with root package name */
    private boolean f95349a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class InternalRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final Runnable f95350d;

        InternalRunnable(Runnable runnable) {
            this.f95350d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f95350d.run();
            } catch (WindowManager.BadTokenException | IllegalStateException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements Handler.Callback {

        /* renamed from: d, reason: collision with root package name */
        private final Handler f95351d;

        public a(Handler handler) {
            this.f95351d = handler;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                this.f95351d.handleMessage(message);
                return true;
            } catch (WindowManager.BadTokenException | IllegalStateException e16) {
                e16.printStackTrace();
                return true;
            }
        }
    }

    public QFixToast(Context context) {
        super(context);
        this.f95349a = false;
        a();
    }

    private void a() {
        if (Build.VERSION.SDK_INT <= 29) {
            Object e16 = e();
            if (e16 == null) {
                d.b(com.tencent.mobileqq.widget.QFixToast.TAG, d.f438810d, "fixTNAndroid7BadToken get Toast TN Field Failed");
                return;
            }
            if (this.f95349a) {
                d.b(com.tencent.mobileqq.widget.QFixToast.TAG, d.f438810d, "fixTNAndroid7BadToken has Hook");
                return;
            }
            Object c16 = c(e16, "mShow");
            if (c16 instanceof Runnable) {
                this.f95349a = g(e16, "mShow", new InternalRunnable((Runnable) c16));
            }
            if (!this.f95349a) {
                Object c17 = c(e16, "mHandler");
                if (c17 instanceof Handler) {
                    this.f95349a = g(c17, "mCallback", new a((Handler) c17));
                }
            }
            if (!this.f95349a && d.h()) {
                d.a(com.tencent.mobileqq.widget.QFixToast.TAG, d.f438811e, "tryToHook error.");
            }
        }
    }

    protected static Field b(Object obj, String str) {
        Field field;
        Class<?> cls = obj.getClass();
        while (true) {
            field = null;
            if (cls == Object.class || cls == null) {
                break;
            }
            try {
                field = cls.getDeclaredField(str);
                break;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return field;
    }

    protected static Object c(Object obj, String str) {
        return d(obj, b(obj, str));
    }

    protected static Object d(Object obj, Field field) {
        if (field != null) {
            try {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                return field.get(obj);
            } catch (Exception e16) {
                e16.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    private void f() {
        if (f95348b == null) {
            try {
                Field declaredField = Toast.class.getDeclaredField("mTN");
                f95348b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                d.b(com.tencent.mobileqq.widget.QFixToast.TAG, d.f438810d, "get Toast TN Field Failed");
            }
        }
    }

    protected static boolean g(Object obj, String str, Object obj2) {
        Field b16 = b(obj, str);
        if (b16 != null) {
            try {
                if (Modifier.isFinal(b16.getModifiers())) {
                    Field declaredField = Field.class.getDeclaredField("accessFlags");
                    declaredField.setAccessible(true);
                    declaredField.setInt(b16, b16.getModifiers() & (-17));
                }
                if (!b16.isAccessible()) {
                    b16.setAccessible(true);
                }
                b16.set(obj, obj2);
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
                return false;
            }
        }
        return false;
    }

    protected Object e() {
        if (f95348b == null) {
            f();
        }
        Field field = f95348b;
        if (field == null) {
            return null;
        }
        try {
            return field.get(this);
        } catch (IllegalAccessException unused) {
            d.b(com.tencent.mobileqq.widget.QFixToast.TAG, d.f438810d, "get Toast TN obj Failed");
            return null;
        }
    }
}
