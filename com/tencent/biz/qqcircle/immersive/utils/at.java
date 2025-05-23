package com.tencent.biz.qqcircle.immersive.utils;

import android.view.View;
import android.view.ViewGroup;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.util.GlobalUtil;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes4.dex */
public class at {
    public static boolean a(int i3) {
        boolean z16;
        long e16 = e();
        long currentAccountLongUin = QCircleHostStubUtil.getCurrentAccountLongUin();
        if (currentAccountLongUin == 0) {
            return false;
        }
        long j3 = i3;
        int i16 = (int) (e16 % j3);
        if (i16 == currentAccountLongUin % j3) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("QFSSampleUtils", 4, "\u62bd\u4e2d\u7684\u5c3e\u6570\uff1a ", Integer.valueOf(i16), ",hit result\uff1a", Boolean.valueOf(z16));
        return z16;
    }

    private static List<View> b(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                View childAt = viewGroup.getChildAt(i3);
                arrayList.add(childAt);
                arrayList.addAll(b(childAt));
            }
        }
        return arrayList;
    }

    private static long c(int i3, int i16, int i17, int i18, int i19, int i26) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
        if (i3 != 0 || i16 != 0 || i17 != 0) {
            calendar.set(1, i3);
            calendar.set(2, i16);
            calendar.set(5, i17);
        }
        calendar.set(11, i18);
        calendar.set(12, i19);
        calendar.set(13, i26);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static String d(View view) {
        List<View> b16 = b(view);
        if (b16.isEmpty()) {
            return GlobalUtil.DEF_STRING;
        }
        StringBuilder sb5 = new StringBuilder();
        for (View view2 : b16) {
            sb5.append("[");
            sb5.append(view2.getClass().getSimpleName());
            sb5.append(",");
            sb5.append(view2.getId());
            sb5.append("]\n");
        }
        return sb5.toString();
    }

    public static int e() {
        return (int) (((((System.currentTimeMillis() - c(1970, 0, 1, 0, 0, 0)) / 1000) / 60) / 60) / 24);
    }
}
