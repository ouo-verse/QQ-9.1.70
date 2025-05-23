package com.tencent.state.view;

import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.SpecialStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u00a8\u0006\u0005"}, d2 = {"isBatteryStatus", "", "Lcom/tencent/state/square/data/OnlineStatus;", "isCustomStatus", "isWeather", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class OnlineStatusBubbleViewHelperKt {
    public static final boolean isBatteryStatus(OnlineStatus isBatteryStatus) {
        Intrinsics.checkNotNullParameter(isBatteryStatus, "$this$isBatteryStatus");
        return isBatteryStatus.getTopStatusId() == 11 && isBatteryStatus.getId() == 1000;
    }

    public static final boolean isCustomStatus(OnlineStatus isCustomStatus) {
        Intrinsics.checkNotNullParameter(isCustomStatus, "$this$isCustomStatus");
        if (isCustomStatus.getTopStatusId() == 11 && isCustomStatus.getId() == 2000) {
            SpecialStatus extraData = isCustomStatus.getExtraData();
            if ((extraData != null ? extraData.getId() : null) != null) {
                SpecialStatus extraData2 = isCustomStatus.getExtraData();
                if ((extraData2 != null ? extraData2.getType() : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean isWeather(OnlineStatus isWeather) {
        Intrinsics.checkNotNullParameter(isWeather, "$this$isWeather");
        return isWeather.getTopStatusId() == 11 && isWeather.getId() == 1030;
    }
}
