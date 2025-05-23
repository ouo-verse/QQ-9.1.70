package com.tencent.mobileqq.kandian.base.video.player;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;

/* compiled from: P */
/* loaded from: classes33.dex */
public class b {
    public static String a(int i3, int i16, int i17) {
        boolean z16 = true;
        boolean z17 = i16 == 1300080;
        if ((i3 != 202 || i16 != 108) && i16 != 1300062) {
            z16 = false;
        }
        if (z16) {
            return HardCodeUtil.qqStr(R.string.f2205269c) + " (" + i3 + "-" + i16 + ")";
        }
        if (i3 == 6000) {
            return HardCodeUtil.qqStr(R.string.v3_) + i3 + "-" + i16 + ")";
        }
        if (z17) {
            return HardCodeUtil.qqStr(R.string.v1e) + i3 + "-" + i16 + ")";
        }
        return HardCodeUtil.qqStr(R.string.f172887v24) + i3 + "-" + i16 + ")";
    }
}
