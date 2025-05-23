package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* loaded from: classes27.dex */
public enum AdParseType implements WireEnum {
    AD_PARSE_TYPE_UNKNOWN(0),
    AD_PARSE_TYPE_NONE(1),
    AD_PARSE_TYPE_NEED_PARSE(2);

    public static final ProtoAdapter<AdParseType> ADAPTER = new EnumAdapter<AdParseType>() { // from class: com.tencent.tvideo.protocol.pb.AdParseType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            AdParseType adParseType = AdParseType.AD_PARSE_TYPE_UNKNOWN;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdParseType fromValue(int i3) {
            return AdParseType.fromValue(i3);
        }
    };
    private final int value;

    AdParseType(int i3) {
        this.value = i3;
    }

    public static AdParseType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return null;
                }
                return AD_PARSE_TYPE_NEED_PARSE;
            }
            return AD_PARSE_TYPE_NONE;
        }
        return AD_PARSE_TYPE_UNKNOWN;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
