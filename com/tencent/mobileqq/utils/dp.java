package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import java.util.HashMap;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class dp {

    /* renamed from: a, reason: collision with root package name */
    private static final Random f307684a = new Random();

    public static void a(RelativeLayout relativeLayout, View view, int i3) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, i3);
        relativeLayout.addView(view, layoutParams);
    }

    public static void b(RelativeLayout relativeLayout, View view) {
        relativeLayout.addView(view, new RelativeLayout.LayoutParams(-1, -1));
    }

    public static void c(RelativeLayout relativeLayout, QUISecNavBar qUISecNavBar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        relativeLayout.addView(qUISecNavBar, layoutParams);
    }

    public static View d(Activity activity, int i3, ViewGroup viewGroup) {
        return LayoutInflater.from(activity).inflate(i3, viewGroup, false);
    }

    private static void e(QUISecNavBar qUISecNavBar) {
        qUISecNavBar.setId(View.generateViewId());
        qUISecNavBar.setCenterType(1);
        qUISecNavBar.setLeftType(2);
        qUISecNavBar.setRightType(2);
    }

    public static QUISecNavBar f(Context context, Boolean bool, Activity activity) {
        QUISecNavBar qUISecNavBar = new QUISecNavBar(context);
        e(qUISecNavBar);
        if (bool.booleanValue()) {
            qUISecNavBar.R(activity);
        }
        return qUISecNavBar;
    }

    public static QUISecNavBar g(Context context, Boolean bool, Fragment fragment) {
        QUISecNavBar qUISecNavBar = new QUISecNavBar(context);
        e(qUISecNavBar);
        if (bool.booleanValue()) {
            qUISecNavBar.S(fragment);
        }
        return qUISecNavBar;
    }

    public static RelativeLayout h(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        return relativeLayout;
    }

    public static void i(String str) {
        String currentUin;
        HashMap hashMap = new HashMap();
        hashMap.put("old_nav_bar", str);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            currentUin = "0";
        } else {
            currentUin = peekAppRuntime.getCurrentUin();
        }
        if (f307684a.nextInt(100) == 0) {
            com.tencent.mobileqq.beacon.a.c(currentUin, "use_old_nav_bar", hashMap);
        }
    }
}
