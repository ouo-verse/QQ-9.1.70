package com.tencent.turingfd.sdk.xq;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.InvocationHandler;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TNative$aa {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class bb implements ServiceConnection {
        static IPatchRedirector $redirector_;

        public bb() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.ServiceConnection
        public native void onServiceConnected(ComponentName componentName, IBinder iBinder);

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
            }
        }
    }

    public TNative$aa() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static native SparseArray<Object> a89_A931D6BEC30CD812(SparseArray<Object> sparseArray, Context context, Map<String, String> map, Map<Integer, String> map2, int i3);

    public static native SparseArray<Object> b89_A931D6BEC30CD812(SparseArray<Object> sparseArray, byte[] bArr, Map<String, String> map, int i3);

    public static native SparseArray<Object> c89_A931D6BEC30CD812(SparseArray<Object> sparseArray, Context context);

    public static native SparseArray<Object> d89_A931D6BEC30CD812(SparseArray<Object> sparseArray, Context context, int i3);

    public static native SparseArray<Object> e89_A931D6BEC30CD812(SparseArray<Object> sparseArray, Context context, Map<String, String> map, int i3);

    public static native SparseArray<Object> f89_A931D6BEC30CD812(SparseArray<Object> sparseArray, byte[] bArr, int i3);

    public static native SparseArray<Object> g89_A931D6BEC30CD812(SparseArray<Object> sparseArray, Context context, Map<String, String> map, int i3);

    public static native SparseArray<Object> h89_A931D6BEC30CD812(SparseArray<Object> sparseArray, Context context, Map<String, String> map, int i3);

    public static native SparseArray<Object> i89_A931D6BEC30CD812(SparseArray<Object> sparseArray, Context context, Map<String, String> map, Object obj, Object obj2, Object obj3);

    public static native String j89_A931D6BEC30CD812();

    public static native byte[] k89_A931D6BEC30CD812(byte[] bArr);

    public static native void l89_A931D6BEC30CD812(InvocationHandler invocationHandler, AtomicReference<Object> atomicReference, ClassLoader classLoader);

    public static native SparseArray<Object> m89_A931D6BEC30CD812(SparseArray<Object> sparseArray, Context context, Map<String, String> map, int i3);
}
