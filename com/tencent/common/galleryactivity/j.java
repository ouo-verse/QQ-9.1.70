package com.tencent.common.galleryactivity;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.widget.Gallery;

/* compiled from: P */
/* loaded from: classes5.dex */
public class j {
    static IPatchRedirector $redirector_;

    public static Rect a(int i3, int i16, int i17, int i18, Object obj) {
        return b(i3, i16, i17, i18, true, obj);
    }

    public static Rect b(int i3, int i16, int i17, int i18, boolean z16, Object obj) {
        boolean z17;
        char c16;
        AIOImageData aIOImageData;
        String str;
        int i19;
        float aIOImageScale = Gallery.getAIOImageScale(i3, i16, i17, i18);
        if (i16 >= i3 * 3) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && ((i3 > i17 || i16 > i18) && (i3 >= (i19 = URLDrawableHelper.AIO_IMAGE_MAX_SIZE) || i16 >= i19))) {
            aIOImageScale = Math.min(i17 / i3, Gallery.MAX_SCALE_DEFAULT);
            c16 = '1';
        } else {
            c16 = 17;
        }
        if (z16 || aIOImageScale <= 1.0f) {
            i3 = (int) (i3 * aIOImageScale);
            i16 = (int) (i16 * aIOImageScale);
        }
        Rect rect = new Rect(0, 0, i3, i16);
        if (c16 == '1') {
            rect.offset((i17 - i3) / 2, 0);
        } else if (c16 == 17) {
            rect.offset((i17 - i3) / 2, (i18 - i16) / 2);
            if (obj != null && (obj instanceof AIOImageData) && (str = (aIOImageData = (AIOImageData) obj).f179576g0) != null && str.length() != 0 && !aIOImageData.f179576g0.equals("null")) {
                rect.offset(0, (int) (BaseApplicationImpl.sApplication.getResources().getDisplayMetrics().density * (-15.0f) * aIOImageScale));
            }
        }
        return rect;
    }

    public static float c(int i3, int i16, int i17, int i18) {
        if (i3 <= 0 || i16 <= 0 || i17 <= 0 || i18 <= 0) {
            return 1.0f;
        }
        if (i3 < i17 || i16 < (i18 * i3) / i17) {
            if (i3 < i17 && i16 >= i18) {
                return 1.0f;
            }
            if (i3 < i17 || i16 >= (i18 * i3) / i17) {
                if (i3 <= i17 && i16 <= i18) {
                    if (i3 >= i17 || i3 <= i17 / 2 || i18 <= (i17 / i3) * i16) {
                        return 1.0f;
                    }
                } else {
                    return Math.min(i18 / i16, i17 / i3);
                }
            }
        }
        return i17 / i3;
    }

    public static Rect d(View view) {
        Rect rect = new Rect(view.getPaddingLeft(), view.getPaddingTop(), view.getWidth() - view.getPaddingRight(), view.getHeight() - view.getPaddingBottom());
        e(view, rect);
        return rect;
    }

    public static boolean e(View view, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        Point point = new Point();
        if (width <= 0 || height <= 0) {
            return false;
        }
        if (rect == null) {
            rect = new Rect();
            rect.set(0, 0, width, height);
        }
        point.set(-view.getScrollX(), -view.getScrollY());
        rect.offset((width - rect.width()) / 2, (height - rect.height()) / 2);
        if (viewGroup != null && !viewGroup.getChildVisibleRect(view, rect, point)) {
            return false;
        }
        return true;
    }
}
