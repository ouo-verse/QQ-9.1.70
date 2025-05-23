package com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util;

import com.tencent.mobileqq.app.AppConstants;
import kotlin.Pair;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class BaseKt {
    public static final Pair<String, String> getToChineseUnit(long j3) {
        String[] strArr = {"", "\u4e07", "\u4e07+"};
        if (j3 <= AppConstants.LBS_HELLO_UIN_LONGVALUE) {
            return new Pair<>(String.valueOf(j3), strArr[0]);
        }
        if (j3 >= 10000000) {
            return new Pair<>("999", strArr[2]);
        }
        double rint = Math.rint((j3 / 10000.0d) * 10.0f) / 10.0d;
        if (rint % 1.0d == 0.0d) {
            return new Pair<>(String.valueOf((int) rint), strArr[1]);
        }
        return new Pair<>(String.valueOf(rint), strArr[1]);
    }
}
