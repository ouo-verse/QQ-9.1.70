package com.tencent.luggage.wxa.y0;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class a {
    public static boolean a(Context context) {
        boolean z16;
        if (new Intent("android.media.action.IMAGE_CAPTURE").resolveActivity(context.getPackageManager()) != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            Context applicationContext = context.getApplicationContext();
            Toast.makeText(applicationContext, applicationContext.getString(R.string.f241457rx), 1).show();
        }
        return z16;
    }
}
