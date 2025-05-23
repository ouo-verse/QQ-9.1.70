package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum AdType implements WireEnum {
    AD_TYPE_UNKNOWN(0),
    AD_TYPE_MID(1),
    AD_TYPE_SEGMENT_REWARD(2);

    public static final ProtoAdapter<AdType> ADAPTER = new EnumAdapter<AdType>() { // from class: com.tencent.tvideo.protocol.pb.AdType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            AdType adType = AdType.AD_TYPE_UNKNOWN;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdType fromValue(int i3) {
            return AdType.fromValue(i3);
        }
    };
    private final int value;

    AdType(int i3) {
        this.value = i3;
    }

    public static AdType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return null;
                }
                return AD_TYPE_SEGMENT_REWARD;
            }
            return AD_TYPE_MID;
        }
        return AD_TYPE_UNKNOWN;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
