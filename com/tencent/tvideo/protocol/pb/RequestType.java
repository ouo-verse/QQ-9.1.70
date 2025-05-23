package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum RequestType implements WireEnum {
    REQUEST_TYPE_UNKNOWN(0),
    REQUEST_TYPE_VIDEO_START(1),
    REQUEST_TYPE_TIMING(2);

    public static final ProtoAdapter<RequestType> ADAPTER = new EnumAdapter<RequestType>() { // from class: com.tencent.tvideo.protocol.pb.RequestType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            RequestType requestType = RequestType.REQUEST_TYPE_UNKNOWN;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RequestType fromValue(int i3) {
            return RequestType.fromValue(i3);
        }
    };
    private final int value;

    RequestType(int i3) {
        this.value = i3;
    }

    public static RequestType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return null;
                }
                return REQUEST_TYPE_TIMING;
            }
            return REQUEST_TYPE_VIDEO_START;
        }
        return REQUEST_TYPE_UNKNOWN;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
