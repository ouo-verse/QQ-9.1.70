package com.tencent.mobileqq.qcircle.api.data;

import com.tencent.mobileqq.qmmkv.QMMKV;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleExposeDataBean {
    public static String sIsSupportHEVC = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeString("key_sp_is_support_hevc", null);
}
