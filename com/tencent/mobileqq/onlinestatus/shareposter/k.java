package com.tencent.mobileqq.onlinestatus.shareposter;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static String f256282a = "QrCodeUtil";

    public static Bitmap a(View view, int i3) {
        Bitmap bitmap = null;
        if (view == null) {
            return null;
        }
        view.clearFocus();
        view.setPressed(false);
        try {
            view.setDrawingCacheEnabled(true);
            view.setDrawingCacheBackgroundColor(i3);
            view.buildDrawingCache();
            bitmap = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            return bitmap;
        } catch (Exception e16) {
            QLog.e(f256282a, 1, "shotViewBitmap error!", e16);
            return bitmap;
        }
    }
}
