package com.tencent.tab.exp.sdk.pbdata;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes26.dex */
public enum RetCode implements WireEnum {
    RET_CODE_UNKNOWN(0),
    RET_CODE_SUCCESS(100),
    RET_CODE_NO_PERMISSION(101),
    RET_CODE_TRAFFIC_LIMIT(102),
    RET_CODE_APP_ID_ERR(103),
    RET_CODE_SERVER_ERR(104),
    RET_CODE_GUID_ERR(105),
    RET_CODE_INVALIDATE_PARAMS(106);

    public static final ProtoAdapter<RetCode> ADAPTER = ProtoAdapter.newEnumAdapter(RetCode.class);
    private final int value;

    RetCode(int i3) {
        this.value = i3;
    }

    public static RetCode fromValue(int i3) {
        if (i3 != 0) {
            switch (i3) {
                case 100:
                    return RET_CODE_SUCCESS;
                case 101:
                    return RET_CODE_NO_PERMISSION;
                case 102:
                    return RET_CODE_TRAFFIC_LIMIT;
                case 103:
                    return RET_CODE_APP_ID_ERR;
                case 104:
                    return RET_CODE_SERVER_ERR;
                case 105:
                    return RET_CODE_GUID_ERR;
                case 106:
                    return RET_CODE_INVALIDATE_PARAMS;
                default:
                    return null;
            }
        }
        return RET_CODE_UNKNOWN;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
