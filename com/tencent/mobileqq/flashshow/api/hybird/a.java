package com.tencent.mobileqq.flashshow.api.hybird;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f209848a;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static a b() {
        if (f209848a == null) {
            synchronized (a.class) {
                if (f209848a == null) {
                    f209848a = new a();
                }
            }
        }
        return f209848a;
    }

    public static void c(Intent intent, String str) {
        if (intent == null) {
            QLog.e("FSHybirdStyleFactory", 1, "getIntentByParseUrl intent is null");
            return;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                if ("1".equals(parse.getQueryParameter("show_right_cancel"))) {
                    intent.putExtra("rightTopCancel", true);
                }
                if ("1".equals(parse.getQueryParameter("move_web_view_top"))) {
                    intent.putExtra("webViewMoveTop", true);
                }
            }
        } catch (Exception e16) {
            QLog.e("FSHybirdStyleFactory", 1, "getStyleFromUrl error " + e16.getMessage());
            e16.printStackTrace();
        }
    }

    public static boolean e(String str) {
        try {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String queryParameter = parse.getQueryParameter("_wv");
                if (TextUtils.isEmpty(queryParameter)) {
                    return false;
                }
                if ((Long.parseLong(queryParameter) & 524288) == 0) {
                    return false;
                }
                return true;
            }
        } catch (Exception e16) {
            QLog.e("FSHybirdStyleFactory", 1, "getStyleFromUrl error " + e16.getMessage());
            e16.printStackTrace();
        }
        return false;
    }

    public FSWebViewTitleStyle a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (FSWebViewTitleStyle) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        FSWebViewTitleStyle fSWebViewTitleStyle = new FSWebViewTitleStyle();
        if (context == null) {
            QLog.d("FSHybirdStyleFactory", 1, "context is null return default");
            return fSWebViewTitleStyle;
        }
        fSWebViewTitleStyle.f313797d = context.getResources().getColor(R.color.biy);
        fSWebViewTitleStyle.f313798e = context.getResources().getColor(R.color.biy);
        fSWebViewTitleStyle.f313799f = context.getResources().getColor(R.color.black);
        fSWebViewTitleStyle.f313800h = context.getResources().getColor(R.color.black);
        return fSWebViewTitleStyle;
    }

    public FSWebViewTitleStyle d(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (FSWebViewTitleStyle) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) str);
        }
        FSWebViewTitleStyle a16 = a(context);
        try {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String queryParameter = parse.getQueryParameter("left_back_icon");
                if (!TextUtils.isEmpty(queryParameter)) {
                    a16.f209847i = Integer.parseInt(queryParameter);
                }
            }
        } catch (Exception e16) {
            QLog.e("FSHybirdStyleFactory", 1, "getStyleFromUrl error " + e16.getMessage());
            e16.printStackTrace();
        }
        return a16;
    }
}
