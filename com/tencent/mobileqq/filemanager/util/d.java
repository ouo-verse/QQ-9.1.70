package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import com.tencent.mobileqq.filemanager.api.IFMToastUtil;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d {
    public static IFMToastUtil a() {
        return (IFMToastUtil) QRoute.api(IFMToastUtil.class);
    }

    public static void b(Context context, int i3, int i16) {
        a().toast(context, i3, i16);
    }

    public static void c(int i3) {
        a().toastDefault(i3);
    }

    public static void d(String str) {
        a().toastDefault(str);
    }

    public static void e(int i3) {
        a().toastError(i3);
    }

    public static void f(String str) {
        a().toastError(str);
    }

    public static void g(int i3) {
        a().toastSuc(i3);
    }

    public static void h(String str) {
        a().toastSuc(str);
    }

    public static void i(String str) {
        a().toastSucLong(str);
    }
}
