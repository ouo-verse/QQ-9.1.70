package com.qq.e.comm.plugin.k;

import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.tencent.ams.adcore.mma.api.Countly;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ab {
    public static void a(String str) {
        if (GDTADManager.getInstance().getSM().getInteger("mmaEnabled", 1) != 0 && !TextUtils.isEmpty(str)) {
            Countly.sharedInstance().init(GDTADManager.getInstance().getAppContext(), GDTADManager.getInstance().getSM().getString("mmaConfigUrl"));
            af.b(Countly.sharedInstance().getReportUrl(str));
        }
    }
}
