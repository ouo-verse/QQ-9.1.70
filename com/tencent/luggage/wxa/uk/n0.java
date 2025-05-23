package com.tencent.luggage.wxa.uk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.luggage.wxa.xd.o1;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class n0 {
    public static int a(int i3) {
        return Color.rgb(Color.red(i3), Color.green(i3), Color.blue(i3));
    }

    public static int[] b(com.tencent.luggage.wxa.ic.d dVar) {
        int[] c16 = c(dVar);
        com.tencent.luggage.wxa.tn.w.g("Luggage.WXA.UIUtil", "getWindowWidthHeight: [x,y] = [%d,%d]", Integer.valueOf(c16[0]), Integer.valueOf(c16[1]));
        return c16;
    }

    public static int[] c(com.tencent.luggage.wxa.ic.d dVar) {
        View a16 = a(dVar);
        if (a16 != null && a16.isLaidOut()) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.WXA.UIUtil", "getWindowWidthHeight Method: normal");
            return new int[]{a16.getWidth(), a16.getHeight()};
        }
        if (dVar.getContext() instanceof Activity) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.WXA.UIUtil", "getWindowWidthHeight Method: windowAndroid");
            DisplayMetrics vDisplayMetrics = dVar.D().getVDisplayMetrics();
            int i3 = vDisplayMetrics.widthPixels;
            if (i3 > 0) {
                return new int[]{i3, vDisplayMetrics.heightPixels};
            }
            com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.UIUtil", "getWindowWidthHeight try Method(windowAndroid) but width<=0, use Method(Screen) instead");
            return a((com.tencent.luggage.wxa.xd.i) dVar);
        }
        com.tencent.luggage.wxa.tn.w.d("Luggage.WXA.UIUtil", "getWindowWidthHeight Method: Screen");
        return a((com.tencent.luggage.wxa.xd.i) dVar);
    }

    public static int[] b(com.tencent.luggage.wxa.xd.i iVar) {
        DisplayMetrics displayMetrics;
        com.tencent.luggage.wxa.wj.c n06 = iVar.getRuntime() != null ? iVar.getRuntime().n0() : null;
        if (n06 != null) {
            com.tencent.luggage.wxa.tn.w.e("Luggage.WXA.UIUtil", "getScreenSizeInner: V_DM");
            displayMetrics = n06.getVDisplayMetrics();
        } else {
            com.tencent.luggage.wxa.tn.w.e("Luggage.WXA.UIUtil", "getScreenSizeInner: normal DM");
            displayMetrics = iVar.getContext().getResources().getDisplayMetrics();
        }
        return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
    }

    public static boolean a(View view) {
        Activity a16;
        boolean isInMultiWindowMode;
        if (Build.VERSION.SDK_INT < 24 || view == null || (a16 = com.tencent.luggage.wxa.bo.a.a(view.getContext())) == null) {
            return false;
        }
        isInMultiWindowMode = a16.isInMultiWindowMode();
        return isInMultiWindowMode;
    }

    public static View a(com.tencent.luggage.wxa.ic.d dVar) {
        com.tencent.luggage.wxa.kj.v a16 = o1.a(dVar);
        if (a16 == null) {
            return null;
        }
        return a16.q0();
    }

    public static int[] a(com.tencent.luggage.wxa.xd.i iVar) {
        int[] b16 = b(iVar);
        com.tencent.luggage.wxa.tn.w.g("Luggage.WXA.UIUtil", "getScreenSize: [x,y] = [%d,%d]", Integer.valueOf(b16[0]), Integer.valueOf(b16[1]));
        return b16;
    }

    public static boolean a(Context context) {
        return b0.c(context);
    }

    public static int c(com.tencent.luggage.wxa.xd.i iVar) {
        int i3;
        View a16;
        int[] iArr = new int[2];
        if (!(iVar instanceof com.tencent.luggage.wxa.ic.d) || (a16 = a((com.tencent.luggage.wxa.ic.d) iVar)) == null) {
            i3 = 0;
        } else {
            a16.getLocationOnScreen(iArr);
            i3 = iArr[1];
        }
        com.tencent.luggage.wxa.tn.w.g("Luggage.WXA.UIUtil", "getScreenTop: [%d]", Integer.valueOf(i3));
        return i3;
    }
}
