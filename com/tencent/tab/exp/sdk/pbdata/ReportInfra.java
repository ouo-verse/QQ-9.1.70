package com.tencent.tab.exp.sdk.pbdata;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes26.dex */
public enum ReportInfra implements WireEnum {
    REPORT_INFRA_UNSPECIFIED(0),
    REPORT_INFRA_ATTA(100),
    REPORT_INFRA_DATONG(101),
    REPORT_INFRA_BEACON(102);

    public static final ProtoAdapter<ReportInfra> ADAPTER = ProtoAdapter.newEnumAdapter(ReportInfra.class);
    private final int value;

    ReportInfra(int i3) {
        this.value = i3;
    }

    public static ReportInfra fromValue(int i3) {
        if (i3 != 0) {
            switch (i3) {
                case 100:
                    return REPORT_INFRA_ATTA;
                case 101:
                    return REPORT_INFRA_DATONG;
                case 102:
                    return REPORT_INFRA_BEACON;
                default:
                    return null;
            }
        }
        return REPORT_INFRA_UNSPECIFIED;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
