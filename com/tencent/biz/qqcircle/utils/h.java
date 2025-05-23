package com.tencent.biz.qqcircle.utils;

import com.tencent.qcircle.application.QCircleApplication;
import cooperation.qqcircle.helpers.QFSDynamicResourceManager;

/* compiled from: P */
/* loaded from: classes5.dex */
public class h {
    public static String a(int i3) {
        try {
            if (QFSDynamicResourceManager.g().isNeedDynamicRes(i3)) {
                return QFSDynamicResourceManager.g().obtainKeyToStrVal(i3, QCircleApplication.APP.getResources().getString(i3));
            }
            return QCircleApplication.APP.getResources().getString(i3);
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }
}
