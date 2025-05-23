package com.tencent.mobileqq.qqlive.data.room.realtime;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes17.dex */
public final class MetricsType {
    private static final /* synthetic */ MetricsType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final MetricsType COMMENT_NUM;
    public static final MetricsType CUMULATIVE_UV;
    public static final MetricsType CUR_UV;
    public static final MetricsType DEFAULT;
    public static final MetricsType GIFT_AMOUNT;
    public static final MetricsType GIFT_GIVER_NUM;
    public static final MetricsType NEW_FANS_NUM;
    public static final MetricsType NUM_OF_LIKE;
    public static final MetricsType TOTAL_LIVE_TIME;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56731);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        MetricsType metricsType = new MetricsType("DEFAULT", 0);
        DEFAULT = metricsType;
        MetricsType metricsType2 = new MetricsType("GIFT_AMOUNT", 1);
        GIFT_AMOUNT = metricsType2;
        MetricsType metricsType3 = new MetricsType("NEW_FANS_NUM", 2);
        NEW_FANS_NUM = metricsType3;
        MetricsType metricsType4 = new MetricsType("COMMENT_NUM", 3);
        COMMENT_NUM = metricsType4;
        MetricsType metricsType5 = new MetricsType("GIFT_GIVER_NUM", 4);
        GIFT_GIVER_NUM = metricsType5;
        MetricsType metricsType6 = new MetricsType("TOTAL_LIVE_TIME", 5);
        TOTAL_LIVE_TIME = metricsType6;
        MetricsType metricsType7 = new MetricsType("CUMULATIVE_UV", 6);
        CUMULATIVE_UV = metricsType7;
        MetricsType metricsType8 = new MetricsType("CUR_UV", 7);
        CUR_UV = metricsType8;
        MetricsType metricsType9 = new MetricsType("NUM_OF_LIKE", 8);
        NUM_OF_LIKE = metricsType9;
        $VALUES = new MetricsType[]{metricsType, metricsType2, metricsType3, metricsType4, metricsType5, metricsType6, metricsType7, metricsType8, metricsType9};
    }

    MetricsType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static MetricsType valueOf(String str) {
        return (MetricsType) Enum.valueOf(MetricsType.class, str);
    }

    public static MetricsType[] values() {
        return (MetricsType[]) $VALUES.clone();
    }
}
