package com.tencent.luggage.wxa.p003do;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import com.tencent.luggage.wxa.aa.k;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e {
    public static void a(Activity activity, View view) {
        if (a() && activity.getResources().getConfiguration().orientation != 2) {
            activity.getWindow().setFlags(1024, 1024);
            activity.getWindow().addFlags(2048);
            view.setPadding(0, a(activity), 0, 0);
        }
    }

    public static boolean a() {
        try {
            return ((Boolean) Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Exception unused) {
            String str = Build.DEVICE;
            if (str.equals("mx2")) {
                return true;
            }
            if (!str.equals("mx")) {
                str.equals("m9");
            }
            return false;
        }
    }

    public static int a(Context context) {
        return k.a(context);
    }
}
