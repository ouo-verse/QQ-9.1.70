package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum NetType implements WireEnum {
    NET_INVALID(0),
    NET_WIFI(1),
    NET_2G(2),
    NET_3G(3),
    NET_4G(4),
    NET_5G(5);

    public static final ProtoAdapter<NetType> ADAPTER = new EnumAdapter<NetType>() { // from class: com.tencent.tvideo.protocol.pb.NetType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            NetType netType = NetType.NET_INVALID;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NetType fromValue(int i3) {
            return NetType.fromValue(i3);
        }
    };
    private final int value;

    NetType(int i3) {
        this.value = i3;
    }

    public static NetType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                return null;
                            }
                            return NET_5G;
                        }
                        return NET_4G;
                    }
                    return NET_3G;
                }
                return NET_2G;
            }
            return NET_WIFI;
        }
        return NET_INVALID;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
