package com.tencent.mobileqq.onlinestatus.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes16.dex */
public class g {
    public static Bitmap a(Bitmap bitmap, int i3, Activity activity) {
        if (QLog.isColorLevel()) {
            QLog.d("onlinestate.DecorViewHelper", 2, "cropAIOFromDecorView() called with: input = [" + bitmap + "], contentHeight = [" + i3 + "], activity = [" + activity + "]");
        }
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i3 <= 0 || i3 >= height) {
            i3 = height;
        }
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(activity);
        int i16 = i3 - statusBarHeight;
        try {
            if (QLog.isColorLevel()) {
                QLog.d("onlinestate.DecorViewHelper", 2, "cropAIOFromDecorView() statusBarHeight = " + statusBarHeight + ", width =" + width + ", finalHeight = " + i16);
            }
            return Bitmap.createBitmap(bitmap, 0, statusBarHeight, width, i16);
        } catch (Throwable th5) {
            QLog.e("onlinestate.DecorViewHelper", 1, "cropAIOFromDecorView: ", th5);
            h.a();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap b(Context context, int i3, int i16) {
        View view;
        View view2;
        int i17;
        Bitmap createBitmap;
        Bitmap bitmap = null;
        if (context instanceof QBaseActivity) {
            QBaseActivity qBaseActivity = (QBaseActivity) context;
            if (i3 > 0) {
                view = qBaseActivity.findViewById(i3);
            } else {
                view = null;
            }
            if (view == null) {
                view = qBaseActivity.getWindow().getDecorView();
            }
            if (i16 > 0) {
                view2 = view.findViewById(i16);
            } else {
                view2 = null;
            }
            if (view2 != null) {
                i17 = view2.getVisibility();
                if (i17 == 0) {
                    view2.setVisibility(4);
                }
            } else {
                i17 = 8;
            }
            try {
                createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                createBitmap.setDensity(context.getResources().getDisplayMetrics().densityDpi);
                Canvas canvas = new Canvas(createBitmap);
                view.draw(canvas);
                canvas.setBitmap(null);
                bitmap = createBitmap;
            } catch (Throwable th6) {
                th = th6;
                bitmap = createBitmap;
                QLog.e("onlinestate.DecorViewHelper", 1, "getDecorViewBitmap: ", th);
                h.a();
                if (view2 != null) {
                }
                if (QLog.isColorLevel()) {
                }
                return bitmap;
            }
            if (view2 != null) {
                view2.setVisibility(i17);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("onlinestate.DecorViewHelper", 2, "getDecorViewBitmap() called with: context = [" + context + "], bitmap = " + bitmap);
        }
        return bitmap;
    }

    public static int c(Context context, int i3) {
        View view;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (i3 > 0) {
                view = activity.findViewById(i3);
            } else {
                view = null;
            }
            if (view == null) {
                view = activity.findViewById(R.id.content);
            }
            if (view != null) {
                return view.getHeight();
            }
            return 0;
        }
        return 0;
    }
}
