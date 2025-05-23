package com.tencent.biz.qqcircle.utils;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSPersonalEditViewModel;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleProfile$QQGroup;

/* compiled from: P */
/* loaded from: classes5.dex */
public class af {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.d("QCircleTextUtils", 1, "feed id is null");
            return "";
        }
        if (str.startsWith("share_fake_")) {
            QLog.d("QCircleTextUtils", 4, "feed id is fake id");
            return str.substring(11);
        }
        return str;
    }

    public static QFSPersonalEditViewModel.Group b(int i3, List<QQCircleProfile$QQGroup> list) {
        StringBuilder sb5 = new StringBuilder();
        boolean z16 = true;
        if (i3 != 1) {
            z16 = false;
        }
        QFSPersonalEditViewModel.Group group = new QFSPersonalEditViewModel.Group(z16, "", new ArrayList());
        if (RFSafeListUtils.isEmpty(list)) {
            return group;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        for (QQCircleProfile$QQGroup qQCircleProfile$QQGroup : list) {
            String str = qQCircleProfile$QQGroup.name.get();
            arrayList.add(Long.valueOf(qQCircleProfile$QQGroup.f429310id.get()));
            if ("".equals(sb5.toString())) {
                sb5.append(str);
            } else {
                sb5.append("\uff0c");
                sb5.append(str);
            }
        }
        group.setShowText(sb5.toString());
        group.setIdList(arrayList);
        return group;
    }

    public static String c(String str) {
        return d(str, QCircleApplication.APP.getResources().getString(R.string.fyn));
    }

    public static String d(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split("-");
        StringBuilder sb5 = new StringBuilder();
        for (String str3 : split) {
            if (!TextUtils.isEmpty(str3) && !str3.equals(str2)) {
                if (!TextUtils.isEmpty(sb5)) {
                    sb5.append("\u00b7");
                }
                sb5.append(str3);
            }
        }
        return sb5.toString();
    }
}
