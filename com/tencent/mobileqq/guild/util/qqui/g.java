package com.tencent.mobileqq.guild.util.qqui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.StringRes;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class g {
    private static String a(Context context, @StringRes int i3, Object... objArr) {
        String str;
        try {
            str = context.getString(i3, objArr);
        } catch (Resources.NotFoundException unused) {
            QLog.e("QQToastUtil", 1, "showQQToast resNotFound: " + i3);
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static void b(int i3) {
        c(-1, i3);
    }

    public static void c(int i3, int i16) {
        BaseApplication context = BaseApplication.getContext();
        QQToast.makeText(context, i3, i16, 1).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    public static void d(int i3, @StringRes int i16, Object... objArr) {
        BaseApplication context = BaseApplication.getContext();
        String a16 = a(context, i16, objArr);
        if (TextUtils.isEmpty(a16)) {
            return;
        }
        QQToast.makeText(context, i3, a16, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    @SuppressLint({"WrongConstant"})
    public static void e(int i3, Drawable drawable, @StringRes int i16, Object... objArr) {
        BaseApplication context = BaseApplication.getContext();
        String a16 = a(context, i16, objArr);
        if (TextUtils.isEmpty(a16)) {
            return;
        }
        QQToast qQToast = new QQToast(context);
        qQToast.setToastIcon(drawable);
        qQToast.setType(i3);
        qQToast.setToastMsg(a16);
        qQToast.setDuration(0);
        qQToast.setThemeId(1000);
        qQToast.show();
    }

    public static void f(int i3, String str) {
        BaseApplication context = BaseApplication.getContext();
        QQToast.makeText(context, i3, str, 1).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }
}
