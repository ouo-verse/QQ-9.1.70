package com.tencent.qimei.o;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c A[Catch: Exception -> 0x0056, TryCatch #0 {Exception -> 0x0056, blocks: (B:7:0x0020, B:11:0x0026, B:13:0x002c, B:15:0x0038, B:17:0x003e, B:31:0x0005, B:33:0x0013, B:35:0x0019), top: B:30:0x0005 }] */
    @com.tencent.qimei.p.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Activity getLauncherActivity(Context context) {
        Intent launchIntentForPackage;
        ComponentName component;
        String className;
        SparseArray<WeakReference<Activity>> sparseArray;
        int i3;
        if (context != null) {
            try {
                launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(context.getPackageManager(), context.getPackageName());
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (launchIntentForPackage != null && (component = launchIntentForPackage.getComponent()) != null) {
                className = component.getClassName();
                if (className != null || (sparseArray = b.f343354a) == null) {
                    return null;
                }
                for (i3 = 0; i3 < sparseArray.size(); i3++) {
                    WeakReference<Activity> weakReference = sparseArray.get(sparseArray.keyAt(i3));
                    if (weakReference != null && weakReference.get() != null) {
                        Activity activity = weakReference.get();
                        if (activity.getClass().getName().equals(className)) {
                            return activity;
                        }
                    }
                }
                return null;
            }
        }
        className = null;
        if (className != null) {
            return null;
        }
        while (i3 < sparseArray.size()) {
        }
        return null;
    }
}
