package com.huawei.hms.common.data;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface DataBufferObserver {
    void onDataChanged();

    void onDataRangeChanged(int i3, int i16);

    void onDataRangeInserted(int i3, int i16);

    void onDataRangeMoved(int i3, int i16, int i17);

    void onDataRangeRemoved(int i3, int i16);
}
