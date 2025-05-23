package com.tencent.biz.pubaccount.weishi.player.wrapper;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;

/* compiled from: P */
/* loaded from: classes32.dex */
public class k {
    private static String b(int i3, int i16) {
        if (i3 == 6000) {
            return HardCodeUtil.qqStr(R.string.v3_) + i3 + "-" + i16 + ")";
        }
        if (i16 == 1300080) {
            return HardCodeUtil.qqStr(R.string.v1e) + i3 + "-" + i16 + ")";
        }
        return HardCodeUtil.qqStr(R.string.f172887v24) + i3 + "-" + i16 + ")";
    }

    private static String c(int i3, int i16) {
        if (i3 == 123) {
            if (i16 == 103) {
                return HardCodeUtil.qqStr(R.string.v3_) + i3 + "-" + i16 + ")";
            }
            return HardCodeUtil.qqStr(R.string.v2x) + i3 + "-" + i16 + ")";
        }
        if (i3 == 122) {
            if (i16 == 204) {
                return HardCodeUtil.qqStr(R.string.v2a) + i3 + "-" + i16 + ")";
            }
            if (i16 == 202) {
                return HardCodeUtil.qqStr(R.string.v0o) + i3 + "-" + i16 + ")";
            }
            return HardCodeUtil.qqStr(R.string.v3b) + i3 + "-" + i16 + ")";
        }
        if (i3 != 101) {
            return HardCodeUtil.qqStr(R.string.f172887v24) + i3 + "-" + i16 + ")";
        }
        if (i16 == 80) {
            return HardCodeUtil.qqStr(R.string.v1e) + i3 + "-" + i16 + ")";
        }
        return HardCodeUtil.qqStr(R.string.v1g) + i3 + "-" + i16 + ")";
    }

    public static String a(int i3, int i16, int i17) {
        if (i17 == 3) {
            return c(i3, i16);
        }
        return b(i3, i16);
    }
}
