package com.tencent.state.square.api;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/square/api/ISquareBatteryServiceObserver;", "", "onBatteryChange", "", "oldCapacity", "", "newCapacity", "onPowerConnectChange", "oldState", "", "newState", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface ISquareBatteryServiceObserver {
    void onBatteryChange(int oldCapacity, int newCapacity);

    void onPowerConnectChange(boolean oldState, boolean newState);
}
