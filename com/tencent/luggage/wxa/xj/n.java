package com.tencent.luggage.wxa.xj;

import android.app.ActivityManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.uk.n0;
import com.tencent.luggage.wxa.wj.c;
import com.tencent.mm.graphics.MMBitmapFactory;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class n {
    public static ActivityManager.TaskDescription a(c.a aVar) {
        int a16 = n0.a(aVar.d());
        if (aVar.b() > 0) {
            if (Build.VERSION.SDK_INT >= 28) {
                return new ActivityManager.TaskDescription(aVar.c(), aVar.b(), a16);
            }
            try {
                return new ActivityManager.TaskDescription(aVar.c(), MMBitmapFactory.a(z.j(), aVar.b()), a16);
            } catch (Exception e16) {
                w.b("Luggage.WXA.WindowAndroidActivityFactory", "decode bitmap failed e=%s", e16);
                return new ActivityManager.TaskDescription(aVar.c(), (Bitmap) null, a16);
            }
        }
        return new ActivityManager.TaskDescription(aVar.c(), aVar.a(), a16);
    }

    public static boolean a(Configuration configuration, Configuration configuration2) {
        return (configuration != null && configuration2 != null && configuration.screenWidthDp == configuration2.screenWidthDp && configuration.screenHeightDp == configuration2.screenHeightDp && configuration.smallestScreenWidthDp == configuration2.smallestScreenWidthDp) ? false : true;
    }
}
