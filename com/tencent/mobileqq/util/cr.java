package com.tencent.mobileqq.util;

import com.tencent.mobileqq.utils.abtest.ABTestController;

/* compiled from: P */
/* loaded from: classes20.dex */
public class cr {
    public static void a() {
        ABTestController.getInstance().getExpEntity("exp_zplan_emote_rec_no").reportExpExposure();
    }

    public static boolean b() {
        return ABTestController.getInstance().getExpEntity("exp_zplan_emote_rec_no").isExperiment("exp_zplan_emote_rec_no_B");
    }

    public static boolean c() {
        return ABTestController.getInstance().getExpEntity("exp_zplan_emote_rec_no").isContrast();
    }
}
