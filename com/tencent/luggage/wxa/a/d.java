package com.tencent.luggage.wxa.a;

import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public int f120464a;

    /* renamed from: b, reason: collision with root package name */
    public long f120465b;

    public d(long j3, int i3) {
        this.f120465b = j3;
        this.f120464a = i3;
    }

    public int a() {
        return this.f120464a;
    }

    public int b() {
        return (int) this.f120465b;
    }

    public static d a(String str, int i3, int i16, boolean z16) {
        if (i3 >= i16) {
            return null;
        }
        if (z16) {
            char charAt = str.charAt(i3);
            if (charAt != '+') {
                r1 = charAt == '-';
            }
            i3++;
        }
        long j3 = 0;
        int i17 = i3;
        while (i17 < i16) {
            char charAt2 = str.charAt(i17);
            if (charAt2 < '0' || charAt2 > '9') {
                break;
            }
            long j16 = j3 * 10;
            long j17 = charAt2 - '0';
            if (r1) {
                j3 = j16 - j17;
                if (j3 < WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                    return null;
                }
            } else {
                j3 = j16 + j17;
                if (j3 > TTL.MAX_VALUE) {
                    return null;
                }
            }
            i17++;
        }
        if (i17 == i3) {
            return null;
        }
        return new d(j3, i17);
    }

    public static d a(String str, int i3, int i16) {
        long j3;
        int i17;
        if (i3 >= i16) {
            return null;
        }
        long j16 = 0;
        int i18 = i3;
        while (i18 < i16) {
            char charAt = str.charAt(i18);
            if (charAt < '0' || charAt > '9') {
                if (charAt >= 'A' && charAt <= 'F') {
                    j3 = j16 * 16;
                    i17 = charAt - 'A';
                } else {
                    if (charAt < 'a' || charAt > 'f') {
                        break;
                    }
                    j3 = j16 * 16;
                    i17 = charAt - 'a';
                }
                j16 = j3 + i17 + 10;
            } else {
                j16 = (j16 * 16) + (charAt - '0');
            }
            if (j16 > 4294967295L) {
                return null;
            }
            i18++;
        }
        if (i18 == i3) {
            return null;
        }
        return new d(j16, i18);
    }
}
