package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* loaded from: classes27.dex */
public enum AdVideoEncodeProtocolType implements WireEnum {
    AD_VIDEO_ENCODE_PROTOCOL_H264(0),
    AD_VIDEO_ENCODE_PROTOCOL_H265(1);

    public static final ProtoAdapter<AdVideoEncodeProtocolType> ADAPTER = new EnumAdapter<AdVideoEncodeProtocolType>() { // from class: com.tencent.tvideo.protocol.pb.AdVideoEncodeProtocolType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            AdVideoEncodeProtocolType adVideoEncodeProtocolType = AdVideoEncodeProtocolType.AD_VIDEO_ENCODE_PROTOCOL_H264;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdVideoEncodeProtocolType fromValue(int i3) {
            return AdVideoEncodeProtocolType.fromValue(i3);
        }
    };
    private final int value;

    AdVideoEncodeProtocolType(int i3) {
        this.value = i3;
    }

    public static AdVideoEncodeProtocolType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                return null;
            }
            return AD_VIDEO_ENCODE_PROTOCOL_H265;
        }
        return AD_VIDEO_ENCODE_PROTOCOL_H264;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
