package com.tencent.state.battery;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/battery/ISquareBatteryStatusObserver;", "", "onBatteryInfoChange", "", "capacity", "", "levelChange", "", "powerConnect", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface ISquareBatteryStatusObserver {
    void onBatteryInfoChange(int capacity, boolean levelChange, boolean powerConnect);
}
