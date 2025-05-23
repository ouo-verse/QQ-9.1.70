package com.tencent.mobileqq.emosm.control;

import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;

/* compiled from: P */
/* loaded from: classes6.dex */
public class EmoStepGroup extends EmoAsyncStep {
    protected EmoAsyncStep[] G;
    public String H;
    public int I;
    protected String[] J;

    private String k(String str) {
        char c16;
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        char c17 = charArray[0];
        if (c17 == '{') {
            c16 = '}';
        } else if (c17 == '[') {
            c16 = ']';
        } else {
            if (str.indexOf(",") == -1) {
                return str;
            }
            return str.substring(0, str.indexOf(","));
        }
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            char c18 = charArray[i16];
            if (c18 == c17) {
                i3++;
            } else if (c18 == c16) {
                i3--;
            }
            if (i3 == 0) {
                return str.substring(0, i16 + 1);
            }
        }
        return "";
    }

    private String[] l(String str) {
        int i3 = 0;
        if (str.length() <= 2) {
            return new String[0];
        }
        String substring = str.substring(1, str.length() - 1);
        int length = substring.length();
        StringBuilder sb5 = new StringBuilder(50);
        String str2 = substring;
        while (i3 < length) {
            if (str2.startsWith(",")) {
                i3++;
                str2 = substring.substring(i3, length);
            }
            String k3 = k(str2);
            sb5.append(k3);
            sb5.append("-");
            i3 += k3.length();
            str2 = substring.substring(i3, length);
        }
        return sb5.toString().split("-");
    }

    @Override // com.tencent.mobileqq.emosm.control.EmoAsyncStep
    public void f() {
        this.f204259f = TTL.MAX_VALUE;
        String[] l3 = l(this.H);
        this.J = l3;
        this.I = 0;
        this.G = new EmoAsyncStep[l3.length];
    }

    @Override // com.tencent.mobileqq.emosm.control.EmoAsyncStep
    public void i(int i3) {
        if (i3 != 4) {
            super.i(i3);
        }
        EmoAsyncStep[] emoAsyncStepArr = this.G;
        if ((i3 == 8 || i3 == 4) && emoAsyncStepArr != null) {
            for (EmoAsyncStep emoAsyncStep : emoAsyncStepArr) {
                if (emoAsyncStep != null) {
                    emoAsyncStep.i(i3);
                } else {
                    return;
                }
            }
        }
    }

    public EmoAsyncStep n() {
        int i3 = this.I;
        String[] strArr = this.J;
        if (i3 < strArr.length) {
            this.G[i3] = EmoCaptureAsyncStepFactory.a(this.f204260h, strArr[i3]);
            EmoAsyncStep[] emoAsyncStepArr = this.G;
            int i16 = this.I;
            EmoAsyncStep emoAsyncStep = emoAsyncStepArr[i16];
            emoAsyncStep.E = this.E;
            this.I = i16 + 1;
            return emoAsyncStep;
        }
        return null;
    }
}
