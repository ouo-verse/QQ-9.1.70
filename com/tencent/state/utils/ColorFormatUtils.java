package com.tencent.state.utils;

import android.graphics.Color;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/utils/ColorFormatUtils;", "", "()V", "parse", "", "colorString", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ColorFormatUtils {
    public static final ColorFormatUtils INSTANCE = new ColorFormatUtils();

    ColorFormatUtils() {
    }

    public final Integer parse(String colorString) {
        try {
            return Integer.valueOf(Color.parseColor(colorString));
        } catch (Throwable th5) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ColorFormatUtils", String.valueOf(th5), null, 4, null);
            return null;
        }
    }
}
