package com.tencent.mobileqq.multiaio.utils;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a() {
        if (Build.VERSION.SDK_INT > 25) {
            Runtime.getRuntime().gc();
            Runtime.getRuntime().gc();
            Runtime.getRuntime().runFinalization();
        } else {
            for (int i3 = 0; i3 < 2; i3++) {
                ArrayList arrayList = new ArrayList();
                do {
                    arrayList.add(new WeakReference(new byte[100]));
                } while (((WeakReference) arrayList.get((int) (Math.random() * arrayList.size()))).get() != null);
            }
        }
    }
}
