package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum AdFloatCardEntityType implements WireEnum {
    AD_FLOAT_CARD_TYPE_IDLE(0),
    AD_FLOAT_CARD_TYPE_SMALL(1),
    AD_FLOAT_CARD_TYPE_BIG(2);

    public static final ProtoAdapter<AdFloatCardEntityType> ADAPTER = new EnumAdapter<AdFloatCardEntityType>() { // from class: com.tencent.tvideo.protocol.pb.AdFloatCardEntityType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            AdFloatCardEntityType adFloatCardEntityType = AdFloatCardEntityType.AD_FLOAT_CARD_TYPE_IDLE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdFloatCardEntityType fromValue(int i3) {
            return AdFloatCardEntityType.fromValue(i3);
        }
    };
    private final int value;

    AdFloatCardEntityType(int i3) {
        this.value = i3;
    }

    public static AdFloatCardEntityType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return null;
                }
                return AD_FLOAT_CARD_TYPE_BIG;
            }
            return AD_FLOAT_CARD_TYPE_SMALL;
        }
        return AD_FLOAT_CARD_TYPE_IDLE;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
