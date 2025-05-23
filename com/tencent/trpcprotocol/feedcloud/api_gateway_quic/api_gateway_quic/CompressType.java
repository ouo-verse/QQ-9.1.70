package com.tencent.trpcprotocol.feedcloud.api_gateway_quic.api_gateway_quic;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes10.dex */
public enum CompressType implements WireEnum {
    COMPRESS_TYPE_NOOP(0),
    COMPRESS_TYPE_GZIP(1),
    COMPRESS_TYPE_ZSTD(20),
    COMPRESS_TYPE_ZSTD_DICTIONARY(21);

    public static final ProtoAdapter<CompressType> ADAPTER = new EnumAdapter<CompressType>() { // from class: com.tencent.trpcprotocol.feedcloud.api_gateway_quic.api_gateway_quic.CompressType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            CompressType compressType = CompressType.COMPRESS_TYPE_NOOP;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CompressType fromValue(int i3) {
            return CompressType.fromValue(i3);
        }
    };
    private final int value;

    CompressType(int i3) {
        this.value = i3;
    }

    public static CompressType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                return null;
            }
            return COMPRESS_TYPE_GZIP;
        }
        return COMPRESS_TYPE_NOOP;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
