package com.tencent.mobileqq.winkpublish.util;

import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.widget.QQToast;

/* compiled from: P */
/* loaded from: classes21.dex */
public class FSToastUtil {
    private static final long CODE_IN_BLACK = 10023;
    private static final long CODE_NO_PERMISSION = 10028;
    private static final long CODE_NO_UPDATE = 10022;
    public static int ICON_DEFAULT = 0;
    public static int ICON_ERROR = 1;
    public static int ICON_NONE = -1;
    public static int ICON_SUCCESS = 2;
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;

    FSToastUtil() {
    }

    public static void determineShowByCode(long j3, String str, int i3) {
        determineShowByCode(j3, ICON_DEFAULT, str, i3);
    }

    public static void makeTextAndShow(int i3, String str, int i16) {
        QQToast.makeText(RFWApplication.getApplication(), i3, str, i16).show();
    }

    public static void determineShowByCode(long j3, int i3, String str, int i16) {
        if (j3 == CODE_NO_UPDATE || j3 == CODE_IN_BLACK || j3 == CODE_NO_PERMISSION) {
            return;
        }
        QQToast.makeText(RFWApplication.getApplication(), i3, str, i16).show();
    }

    public static void makeTextAndShow(String str, int i3) {
        QQToast.makeText(RFWApplication.getApplication(), ICON_DEFAULT, str, i3).show();
    }
}
