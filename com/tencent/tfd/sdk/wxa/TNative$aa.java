package com.tencent.tfd.sdk.wxa;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TNative$aa {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes26.dex */
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

    public static native SparseArray<Object> a77(SparseArray<Object> sparseArray, Context context, Map<String, String> map, Map<Integer, String> map2, int i3);

    public static native SparseArray<Object> b77(SparseArray<Object> sparseArray, byte[] bArr, Map<String, String> map, int i3);

    public static native SparseArray<Object> c77(SparseArray<Object> sparseArray, Context context);

    public static native SparseArray<Object> d77(SparseArray<Object> sparseArray, Context context, int i3);

    public static native SparseArray<Object> e77(SparseArray<Object> sparseArray, Context context, Map<String, String> map, int i3);

    public static native SparseArray<Object> f77(SparseArray<Object> sparseArray, byte[] bArr, int i3);

    public static native SparseArray<Object> g77(SparseArray<Object> sparseArray, Context context, Map<String, String> map, int i3);

    public static native SparseArray<Object> h77(SparseArray<Object> sparseArray, Context context, Map<String, String> map, int i3);

    public static native SparseArray<Object> i77(SparseArray<Object> sparseArray, Context context, Map<String, String> map);
}
