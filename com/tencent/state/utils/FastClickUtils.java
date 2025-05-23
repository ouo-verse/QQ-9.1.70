package com.tencent.state.utils;

import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/utils/FastClickUtils;", "", "timeDelay", "", "(J)V", "lastClickTime", "isFastDoubleClick", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class FastClickUtils {
    private static final String TAG = "FastClickUtils";
    public static final long TIME_DELAY = 800;
    private long lastClickTime;
    private final long timeDelay;

    public FastClickUtils(long j3) {
        this.timeDelay = j3;
    }

    public final boolean isFastDoubleClick() {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - this.lastClickTime;
        long j16 = this.timeDelay;
        if (0 <= j3 && j16 > j3) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "click so fast", null, 4, null);
            return true;
        }
        this.lastClickTime = currentTimeMillis;
        return false;
    }
}
