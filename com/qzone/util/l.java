package com.qzone.util;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public static BaseApplicationImpl f59826a = BaseApplicationImpl.sApplication;

    public static String a(int i3) {
        try {
            return f59826a.getResources().getString(i3);
        } catch (Exception e16) {
            QZLog.e(HardCodeUtil.TAG, "[qqStr]", e16);
            return "";
        }
    }
}
