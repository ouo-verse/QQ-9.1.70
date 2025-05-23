package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* loaded from: classes27.dex */
public enum AdPageType implements WireEnum {
    AD_PAGE_TYPE_UNKNOWN(0),
    AD_PAGE_TYPE_SPLIT(1),
    AD_PAGE_TYPE_HALF_LANDING_PAGE(2);

    public static final ProtoAdapter<AdPageType> ADAPTER = new EnumAdapter<AdPageType>() { // from class: com.tencent.tvideo.protocol.pb.AdPageType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            AdPageType adPageType = AdPageType.AD_PAGE_TYPE_UNKNOWN;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdPageType fromValue(int i3) {
            return AdPageType.fromValue(i3);
        }
    };
    private final int value;

    AdPageType(int i3) {
        this.value = i3;
    }

    public static AdPageType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return null;
                }
                return AD_PAGE_TYPE_HALF_LANDING_PAGE;
            }
            return AD_PAGE_TYPE_SPLIT;
        }
        return AD_PAGE_TYPE_UNKNOWN;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
