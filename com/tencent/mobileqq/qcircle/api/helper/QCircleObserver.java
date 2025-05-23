package com.tencent.mobileqq.qcircle.api.helper;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleObserver implements BusinessObserver {
    private static final String TAG = "QCircleObserver";

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        if (i3 == 1) {
            int intValue = ((Integer) obj).intValue();
            QLog.d(TAG, 2, "TYPE_UPDATE_RED_POINT_DISPLAY repointNum");
            onUpdateRedPoint(intValue);
        }
    }

    protected void onUpdateRedPoint(int i3) {
    }
}
