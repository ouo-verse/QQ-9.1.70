package com.tencent.av.utils;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class g {
    public static Drawable a(Context context, int i3) {
        if (context == null) {
            return null;
        }
        int screenWidth = ba.getScreenWidth(context);
        int screenHeight = ba.getScreenHeight(context);
        if (QLog.isColorLevel()) {
            QLog.d("BitmapTools", 2, "screenWidth = " + screenWidth + " # screenHeight =" + screenHeight);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (screenWidth <= 480) {
            options.inSampleSize = 4;
        } else {
            if (screenWidth <= 720) {
                options.inSampleSize = 2;
            }
            return null;
        }
        try {
            return new BitmapDrawable(context.getResources(), BitmapFactory.decodeResource(context.getResources(), i3, options));
        } catch (Exception | OutOfMemoryError unused) {
        }
    }
}
