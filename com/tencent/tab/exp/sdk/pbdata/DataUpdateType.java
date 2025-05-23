package com.tencent.tab.exp.sdk.pbdata;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes26.dex */
public enum DataUpdateType implements WireEnum {
    DATA_UPDATE_TYPE_UNKNOWN(0),
    DATA_UPDATE_TYPE_ALL(1),
    DATA_UPDATE_TYPE_NO_NEED(2),
    DATA_UPDATE_TYPE_DIFF(3);

    public static final ProtoAdapter<DataUpdateType> ADAPTER = ProtoAdapter.newEnumAdapter(DataUpdateType.class);
    private final int value;

    DataUpdateType(int i3) {
        this.value = i3;
    }

    public static DataUpdateType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return null;
                    }
                    return DATA_UPDATE_TYPE_DIFF;
                }
                return DATA_UPDATE_TYPE_NO_NEED;
            }
            return DATA_UPDATE_TYPE_ALL;
        }
        return DATA_UPDATE_TYPE_UNKNOWN;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
