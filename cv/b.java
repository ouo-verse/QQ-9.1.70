package cv;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    private static volatile b f391880d;

    /* renamed from: a, reason: collision with root package name */
    private Handler f391881a;

    /* renamed from: b, reason: collision with root package name */
    private Class<?> f391882b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<cv.a> f391883c;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                QLog.d("LinkTurboKitReflectProxy", 1, "handleMessage msg is illegal");
                return;
            }
            if (message.what == 0) {
                b.this.c(message);
                return;
            }
            QLog.d("LinkTurboKitReflectProxy", 1, "unHandle msg event " + message.what);
        }
    }

    b() {
        this.f391881a = null;
        Looper c16 = gv.a.a().c();
        if (c16 != null) {
            QLog.d("LinkTurboKitReflectProxy", 1, "inti kitHandler");
            this.f391881a = new a(c16);
        }
        try {
            this.f391882b = Class.forName("com.hihonor.android.emcom.EmcomManagerEx");
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
        }
    }

    public static b b() {
        if (f391880d == null) {
            synchronized (b.class) {
                if (f391880d == null) {
                    f391880d = new b();
                }
            }
        }
        return f391880d;
    }

    public void f(cv.a aVar) {
        this.f391883c = new WeakReference<>(aVar);
    }

    public boolean d(Bundle bundle) {
        try {
            this.f391882b.getMethod("notifyAppInfo", Bundle.class).invoke(null, bundle);
            return true;
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
            return false;
        } catch (NoSuchMethodException e17) {
            e17.printStackTrace();
            return false;
        } catch (InvocationTargetException e18) {
            e18.printStackTrace();
            return false;
        }
    }

    public void g(cv.a aVar) {
        this.f391883c = null;
    }

    public int e(int i3, int i16, int i17) {
        try {
            Class<?> cls = this.f391882b;
            Class<?> cls2 = Integer.TYPE;
            Object invoke = cls.getMethod("registerApp", cls2, cls2, cls2, Handler.class).invoke(null, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), this.f391881a);
            r0 = invoke instanceof Integer ? ((Integer) invoke).intValue() : -99;
            QLog.d("LinkTurboKitReflectProxy", 1, "testGetLinkTurboVersion res is\uff1a" + r0);
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
        } catch (IllegalArgumentException e17) {
            e17.printStackTrace();
        } catch (NoClassDefFoundError e18) {
            e18.printStackTrace();
        } catch (NoSuchMethodException e19) {
            e19.printStackTrace();
        } catch (UnsupportedOperationException e26) {
            e26.printStackTrace();
        } catch (InvocationTargetException e27) {
            e27.printStackTrace();
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        WeakReference<cv.a> weakReference;
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Integer) {
                int i3 = message.arg1;
                int intValue = ((Integer) obj).intValue();
                if (i3 != 1 || (weakReference = this.f391883c) == null || weakReference.get() == null) {
                    return;
                }
                this.f391883c.get().a(intValue == 0);
                return;
            }
        }
        QLog.d("LinkTurboKitReflectProxy", 1, "handleLinkTurboStateChanged msg is illegal");
    }
}
