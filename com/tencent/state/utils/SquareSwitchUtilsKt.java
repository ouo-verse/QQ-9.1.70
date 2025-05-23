package com.tencent.state.utils;

import com.tencent.state.square.data.SquareDeviceInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005\u00a8\u0006\u0006"}, d2 = {"isMatch", "", "", "Lcom/tencent/state/utils/SquareDeviceFilter;", "deviceInfo", "Lcom/tencent/state/square/data/SquareDeviceInfo;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareSwitchUtilsKt {
    public static final boolean isMatch(List<SquareDeviceFilter> list, SquareDeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        List<SquareDeviceFilter> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return false;
        }
        Iterator<SquareDeviceFilter> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().isMatch(deviceInfo)) {
                return true;
            }
        }
        return false;
    }
}
