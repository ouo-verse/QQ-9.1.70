package com.tencent.biz.qqcircle.helpers;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.mobileqq.qcircle.api.utils.QCircleSecurityStatusUtil;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleSac$SenceBeatInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d {
    public static boolean a(int i3, boolean z16) {
        QQCircleSac$SenceBeatInfo writeSenceBeatInfo = QCircleSecurityStatusUtil.getWriteSenceBeatInfo(i3);
        if (writeSenceBeatInfo == null) {
            return false;
        }
        QLog.d("QCircleSecurityStatusHelper", 1, "checkSenceBeat | got sence beat | sence=" + writeSenceBeatInfo.sence.get() + " | desc=" + writeSenceBeatInfo.desc.get());
        String str = writeSenceBeatInfo.desc.get();
        if (z16 && !TextUtils.isEmpty(str)) {
            QCircleToast.l(QCircleToast.f91644d, str, 0, true, com.tencent.biz.qqcircle.immersive.utils.r.E0());
        }
        return true;
    }
}
