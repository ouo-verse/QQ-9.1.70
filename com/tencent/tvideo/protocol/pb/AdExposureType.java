package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum AdExposureType implements WireEnum {
    AD_EXPOSURE_TYPE_UNKNOWN(0),
    AD_EXPOSURE_TYPE_NORMAL(1),
    AD_EXPOSURE_TYPE_STAGE(2);

    public static final ProtoAdapter<AdExposureType> ADAPTER = new EnumAdapter<AdExposureType>() { // from class: com.tencent.tvideo.protocol.pb.AdExposureType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            AdExposureType adExposureType = AdExposureType.AD_EXPOSURE_TYPE_UNKNOWN;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdExposureType fromValue(int i3) {
            return AdExposureType.fromValue(i3);
        }
    };
    private final int value;

    AdExposureType(int i3) {
        this.value = i3;
    }

    public static AdExposureType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return null;
                }
                return AD_EXPOSURE_TYPE_STAGE;
            }
            return AD_EXPOSURE_TYPE_NORMAL;
        }
        return AD_EXPOSURE_TYPE_UNKNOWN;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
