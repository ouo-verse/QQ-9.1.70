package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum AdFreeFlowType implements WireEnum {
    AD_FREE_FLOW_TYPE_UNKNOWN(0),
    AD_FREE_FLOW_TYPE_NONE(1),
    AD_FREE_FLOW_TYPE_UNICOM(2),
    AD_FREE_FLOW_TYPE_MOBILE(3),
    AD_FREE_FLOW_TYPE_MOBILE_TELE(4);

    public static final ProtoAdapter<AdFreeFlowType> ADAPTER = new EnumAdapter<AdFreeFlowType>() { // from class: com.tencent.tvideo.protocol.pb.AdFreeFlowType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            AdFreeFlowType adFreeFlowType = AdFreeFlowType.AD_FREE_FLOW_TYPE_UNKNOWN;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdFreeFlowType fromValue(int i3) {
            return AdFreeFlowType.fromValue(i3);
        }
    };
    private final int value;

    AdFreeFlowType(int i3) {
        this.value = i3;
    }

    public static AdFreeFlowType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return null;
                        }
                        return AD_FREE_FLOW_TYPE_MOBILE_TELE;
                    }
                    return AD_FREE_FLOW_TYPE_MOBILE;
                }
                return AD_FREE_FLOW_TYPE_UNICOM;
            }
            return AD_FREE_FLOW_TYPE_NONE;
        }
        return AD_FREE_FLOW_TYPE_UNKNOWN;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
