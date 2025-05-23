package com.tencent.qzonehub.reborn;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static int a() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", "qcircle_report_sdk_sample_rate", 5);
    }
}
