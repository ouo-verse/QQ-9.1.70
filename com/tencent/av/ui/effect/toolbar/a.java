package com.tencent.av.ui.effect.toolbar;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.DataReport;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    public static void a(String str) {
        int i3;
        String str2;
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof VideoAppInterface) {
            i3 = ((VideoAppInterface) runtime).z("BEAUTY_SKIN");
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            str2 = "0X80076B4";
        } else {
            str2 = "0X80076B3";
        }
        b(str2);
        AVCoreLog.printColorLog("EffectToolbarDataReport", "DataReport onUserBeauty:" + str + "|" + i3);
    }

    public static void b(String str) {
        DataReport.T(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
    }
}
