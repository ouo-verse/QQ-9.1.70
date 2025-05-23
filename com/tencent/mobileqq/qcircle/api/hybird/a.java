package com.tencent.mobileqq.qcircle.api.hybird;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f261697a;

    public static a b() {
        if (f261697a == null) {
            synchronized (a.class) {
                if (f261697a == null) {
                    f261697a = new a();
                }
            }
        }
        return f261697a;
    }

    public static void c(Intent intent, String str) {
        if (intent == null) {
            QLog.e("QCircleHybirdStyleFactory", 1, "getIntentByParseUrl intent is null");
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
            QLog.e("QCircleHybirdStyleFactory", 1, "getStyleFromUrl error " + e16.getMessage());
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
            QLog.e("QCircleHybirdStyleFactory", 1, "getStyleFromUrl error " + e16.getMessage());
            e16.printStackTrace();
        }
        return false;
    }

    public QCircleWebViewTitleStyle a(Context context, String str, String str2) {
        QCircleWebViewTitleStyle qCircleWebViewTitleStyle = new QCircleWebViewTitleStyle();
        if (context == null) {
            QLog.d("QCircleHybirdStyleFactory", 1, "context is null return default");
            return qCircleWebViewTitleStyle;
        }
        if (TextUtils.equals("1", str2)) {
            int d16 = QFSQUIUtilsKt.d(BaseApplication.getContext(), R.color.qui_common_bg_bottom_standard);
            qCircleWebViewTitleStyle.f313797d = d16;
            qCircleWebViewTitleStyle.f313798e = d16;
        } else {
            qCircleWebViewTitleStyle.f313797d = context.getResources().getColor(R.color.cam);
            qCircleWebViewTitleStyle.f313798e = context.getResources().getColor(R.color.cam);
        }
        qCircleWebViewTitleStyle.f313799f = context.getResources().getColor(R.color.black);
        if (!TextUtils.isEmpty(str)) {
            qCircleWebViewTitleStyle.f261695i = Integer.parseInt(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            qCircleWebViewTitleStyle.f261696m = Integer.parseInt(str2);
        }
        return qCircleWebViewTitleStyle;
    }

    public QCircleWebViewTitleStyle d(Context context, String str) {
        String str2;
        String str3;
        Uri parse;
        String str4 = "";
        try {
            parse = Uri.parse(str);
        } catch (Exception e16) {
            e = e16;
            str2 = "";
        }
        if (parse == null) {
            str3 = "";
            QLog.d("QCircleHybirdStyleFactory", 1, "[getStyleFromUrl] leftBackIcon=" + str4 + ", isQUIPage=" + str3);
            return a(context, str4, str3);
        }
        str2 = parse.getQueryParameter("left_back_icon");
        try {
            str3 = parse.getQueryParameter("isQUIPage");
        } catch (Exception e17) {
            e = e17;
            QLog.e("QCircleHybirdStyleFactory", 1, "getStyleFromUrl error " + e.getMessage());
            e.printStackTrace();
            str3 = "";
            str4 = str2;
            QLog.d("QCircleHybirdStyleFactory", 1, "[getStyleFromUrl] leftBackIcon=" + str4 + ", isQUIPage=" + str3);
            return a(context, str4, str3);
        }
        str4 = str2;
        QLog.d("QCircleHybirdStyleFactory", 1, "[getStyleFromUrl] leftBackIcon=" + str4 + ", isQUIPage=" + str3);
        return a(context, str4, str3);
    }
}
