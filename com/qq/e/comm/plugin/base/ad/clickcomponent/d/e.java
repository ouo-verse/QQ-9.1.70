package com.qq.e.comm.plugin.base.ad.clickcomponent.d;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.qq.e.comm.plugin.k.al;
import com.qq.e.comm.plugin.k.az;
import com.qq.e.comm.util.GDTLogger;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e {
    private static Method a(Class cls) {
        Class cls2 = Integer.TYPE;
        Method a16 = al.a(cls, "startMiniApp", Context.class, String.class, cls2, cls2);
        return a16 == null ? al.a(cls, "startMiniApp", Activity.class, String.class, cls2, cls2) : a16;
    }

    public static boolean a() {
        Class a16 = al.a("com.tencent.qqmini.sdk.MiniSDK");
        return (a16 == null || a(a16) == null) ? false : true;
    }

    public static <T> int a(String str, Context context, T t16) {
        GDTLogger.d("try to lunch qq game");
        Activity a16 = az.a(context);
        if (a16 == null && (a16 = az.a(a(t16))) == null) {
            return 4;
        }
        Class a17 = al.a("com.tencent.qqmini.sdk.MiniSDK");
        if (a17 == null) {
            GDTLogger.d("lunch failed, no class find");
            return 2;
        }
        Method a18 = a(a17);
        if (a18 == null) {
            GDTLogger.d("lunch failed, no method find");
            return 3;
        }
        try {
            al.a(a17, a18, a16, str, 2, 2001);
            return 1;
        } catch (Exception e16) {
            GDTLogger.d("lunch failed, running time error :" + e16.getMessage());
            return 6;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> Context a(T t16) {
        if (t16 instanceof View) {
            return ((View) t16).getContext();
        }
        return null;
    }
}
