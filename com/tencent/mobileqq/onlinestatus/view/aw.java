package com.tencent.mobileqq.onlinestatus.view;

import android.app.Activity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg;
import com.tencent.mobileqq.onlinestatus.bv;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment;
import com.tencent.mobileqq.onlinestatus.view.v;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class aw {
    public static long a(long j3) {
        if (j3 >= 40001) {
            return 40001L;
        }
        return j3;
    }

    public static v b(QBaseActivity qBaseActivity, OnLineStatusBlurBg onLineStatusBlurBg, v.a aVar, long j3) {
        if (j3 == 1040) {
            return new ConstellationView(qBaseActivity, onLineStatusBlurBg, aVar);
        }
        return null;
    }

    public static BaseStatusCardViewFragment c(QBaseActivity qBaseActivity, OnLineStatusBlurBg onLineStatusBlurBg, BaseStatusCardViewFragment.a aVar, long j3) {
        if (j3 == 1030) {
            return new WeatherView(qBaseActivity, onLineStatusBlurBg, aVar);
        }
        if (OnlineStatusToggleUtils.A() && j3 == 2017) {
            return new StepCountView(qBaseActivity, onLineStatusBlurBg, aVar);
        }
        if (j3 <= -100) {
            return new StatusFoldView(qBaseActivity, onLineStatusBlurBg, aVar, j3);
        }
        return null;
    }

    public static void d(Activity activity, long j3, v.a aVar) {
        if (com.tencent.mobileqq.onlinestatus.af.C().H() == null) {
            QLog.e("StatusCardViewBuilder", 1, "showOlympicStatusRankView item is null");
        } else {
            new al(activity, j3, aVar).show();
            bv.a("0X800BDA4");
        }
    }
}
