package com.tencent.mobileqq.weather.util;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends ViewOutlineProvider {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f313629a;

        a(float f16) {
            this.f313629a = f16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16));
            }
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) outline);
            } else {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), ViewUtils.dip2px(this.f313629a));
            }
        }
    }

    public static String a(int i3) {
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    return "";
                }
                return "\u7ea2\u8272";
            }
            return "\u6a59\u8272";
        }
        return "\u9ec4\u8272";
    }

    public static String b(String str, String str2) {
        try {
            Uri parse = Uri.parse(URLDecoder.decode(str));
            if (parse != null && parse.getQueryParameter(str2) != null) {
                return parse.getQueryParameter(str2);
            }
            return "";
        } catch (Exception e16) {
            QLog.e("WeatherHelper", 1, "Error when uri parse page url param", e16);
            return "";
        }
    }

    public static String c(String str, int i3) {
        List<String> pathSegments;
        try {
            Uri parse = Uri.parse(URLDecoder.decode(str));
            if (parse != null && (pathSegments = parse.getPathSegments()) != null && pathSegments.size() > i3) {
                return pathSegments.get(i3);
            }
        } catch (Exception e16) {
            QLog.e("WeatherHelper", 1, "Error when uri parse page url path", e16);
        }
        return "";
    }

    public static float d(View view) {
        if (view != null && view.getVisibility() == 0 && view.isShown()) {
            Rect rect = new Rect();
            if (!view.getGlobalVisibleRect(rect)) {
                return 0.0f;
            }
            int dpToPx = ViewUtils.dpToPx(80.0f);
            if (rect.left < ViewUtils.getScreenWidth() && rect.top < ViewUtils.getScreenHeight() && rect.right > 0 && rect.bottom > dpToPx) {
                int i3 = rect.top;
                if (i3 >= 0 && i3 <= dpToPx) {
                    rect.top = dpToPx;
                }
                float f16 = -1.0f;
                try {
                    f16 = ((rect.width() * 1.0f) * rect.height()) / (view.getWidth() * view.getHeight());
                    QLog.e("WeatherHelper", 2, "getPercentageOfRealVisibleRect:top:", Integer.valueOf(rect.top), ",bottom:", Integer.valueOf(rect.bottom));
                    return f16;
                } catch (Exception e16) {
                    QLog.e("WeatherHelper", 1, "getPercentageOfRealVisibleRect", e16);
                    return f16;
                }
            }
        }
        return 0.0f;
    }

    public static Drawable e(String str) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        try {
            obtain.mLoadingDrawable = new ColorDrawable(0);
            obtain.mFailedDrawable = new ColorDrawable(0);
            URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
            if (drawable == null) {
                return null;
            }
            return drawable;
        } catch (Throwable th5) {
            QLog.d("WeatherHelper", 1, "getUrlDrawable error: " + th5);
            return null;
        }
    }

    public static boolean f(Context context, String str) {
        if (context != null && i.b(context, str)) {
            return true;
        }
        return false;
    }

    public static boolean g() {
        return QQTheme.isNowThemeIsNight();
    }

    public static boolean h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("https://weather.mp.qq.com/pages/");
    }

    public static boolean i(String str) {
        if (!"2658655094".equals(str) && !"3142131160".equals(str)) {
            return false;
        }
        return true;
    }

    public static void j(View view, float f16) {
        view.setOutlineProvider(new a(f16));
        view.setClipToOutline(true);
    }
}
