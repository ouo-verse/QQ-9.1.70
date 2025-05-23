package com.tencent.mobileqq.widget.tip;

import android.content.Context;
import android.graphics.Color;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QUIDefaultBubbleTip extends a {

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes20.dex */
    public @interface BubbleStyle {
        public static final int GENERIC_STRONG_DARK = 1;
        public static final int GENERIC_STRONG_LIGHT = 2;
        public static final int GENERIC_WEAK_DARK = 3;
        public static final int GENERIC_WEAK_LIGHT = 4;
        public static final int OPERATIONAL = 5;
        public static final int VIDEO = 6;
    }

    protected QUIDefaultBubbleTip(Context context) {
        super(context);
    }

    private void A0(boolean z16, boolean z17) {
        long j3;
        if (z16) {
            p0(-1);
            W(Color.parseColor("#B3000000"));
        } else {
            p0(-16777216);
            W(-1);
            e0(true);
        }
        if (z17) {
            j3 = -1;
        } else {
            j3 = 3000;
        }
        b0(j3);
    }

    private void B0() {
        p0(-1);
        W(Color.parseColor("#0099FF"));
    }

    private void C0() {
        int parseColor = Color.parseColor("#66616161");
        p0(-1);
        W(parseColor);
        c0(true);
    }

    public static a r(Context context) {
        QUIDefaultBubbleTip qUIDefaultBubbleTip = new QUIDefaultBubbleTip(context);
        qUIDefaultBubbleTip.m0(1).q0(14.0f).j0(10.0f, 8.0f, 10.0f, 8.0f).b0(3000L);
        return qUIDefaultBubbleTip;
    }

    @Override // com.tencent.mobileqq.widget.tip.a
    public void s0() {
        switch (this.f317531o) {
            case 1:
                A0(true, true);
                break;
            case 2:
                A0(false, true);
                break;
            case 3:
                A0(true, false);
                break;
            case 4:
                A0(false, false);
                break;
            case 5:
                B0();
                break;
            case 6:
                C0();
                break;
        }
        super.s0();
    }
}
