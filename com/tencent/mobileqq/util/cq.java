package com.tencent.mobileqq.util;

import com.tencent.mobileqq.utils.abtest.ABTestController;

/* compiled from: P */
/* loaded from: classes20.dex */
public class cq {
    public static void a() {
        ABTestController.getInstance().getExpEntity("exp_zplan_emote_rec_test").reportExpExposure();
    }

    public static boolean b() {
        return ABTestController.getInstance().getExpEntity("exp_zplan_emote_rec_test").isContrast();
    }

    public static boolean c() {
        return ABTestController.getInstance().getExpEntity("exp_zplan_emote_rec_test").isExperiment("exp_zplan_emote_rec_test_B");
    }

    public static boolean d() {
        return ABTestController.getInstance().getExpEntity("exp_zplan_emote_rec_test").isExperiment("exp_zplan_emote_rec_test_C");
    }

    public static boolean e() {
        return ABTestController.getInstance().getExpEntity("exp_zplan_emote_rec_test").isExperiment("exp_zplan_emote_rec_test_D");
    }
}
