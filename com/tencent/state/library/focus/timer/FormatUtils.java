package com.tencent.state.library.focus.timer;

import com.tencent.mobileqq.mini.api.MiniConst;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/library/focus/timer/FormatUtils;", "", "()V", "convertLikeNum", "", "likeNum", "", "(Ljava/lang/Long;)Ljava/lang/String;", "convertTime", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class FormatUtils {
    public static final FormatUtils INSTANCE = new FormatUtils();

    FormatUtils() {
    }

    public final String convertLikeNum(Long likeNum) {
        if (likeNum == null) {
            return "";
        }
        if (likeNum.longValue() < 10000) {
            return String.valueOf(likeNum.longValue());
        }
        StringBuilder sb5 = new StringBuilder();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(((float) likeNum.longValue()) / 10000.0f)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        sb5.append(format);
        sb5.append("\u4e07");
        return sb5.toString();
    }

    public final String convertTime(long second) {
        if (second <= 0) {
            return "0\u79d2";
        }
        long j3 = 60;
        long j16 = second / j3;
        long j17 = (second % j3) % j3;
        if (j16 > 0) {
            return String.valueOf(j16) + "\u5206\u949f " + j17 + "\u79d2";
        }
        return String.valueOf(j17) + "\u79d2";
    }
}
