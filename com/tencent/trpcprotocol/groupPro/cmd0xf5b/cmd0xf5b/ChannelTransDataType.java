package com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ad;
import com.google.protobuf.bk;

/* compiled from: P */
/* loaded from: classes25.dex */
public enum ChannelTransDataType implements bk {
    CHANNEL_TRANS_DATATYPE_DEFAUTL(0),
    CHANNEL_TRANS_DATATYPE_USERLIST(1),
    UNRECOGNIZED(-1);

    public static final int CHANNEL_TRANS_DATATYPE_DEFAUTL_VALUE = 0;
    public static final int CHANNEL_TRANS_DATATYPE_USERLIST_VALUE = 1;
    private final int value;
    private static final ad.d<ChannelTransDataType> internalValueMap = new ad.d<ChannelTransDataType>() { // from class: com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.ChannelTransDataType.a
        @Override // com.google.protobuf.ad.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ChannelTransDataType findValueByNumber(int i3) {
            return ChannelTransDataType.forNumber(i3);
        }
    };
    private static final ChannelTransDataType[] VALUES = values();

    ChannelTransDataType(int i3) {
        this.value = i3;
    }

    public static ChannelTransDataType forNumber(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                return null;
            }
            return CHANNEL_TRANS_DATATYPE_USERLIST;
        }
        return CHANNEL_TRANS_DATATYPE_DEFAUTL;
    }

    public static final Descriptors.c getDescriptor() {
        return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.a().o().get(3);
    }

    public static ad.d<ChannelTransDataType> internalGetValueMap() {
        return internalValueMap;
    }

    public final Descriptors.c getDescriptorForType() {
        return getDescriptor();
    }

    @Override // com.google.protobuf.ad.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public final Descriptors.d getValueDescriptor() {
        return getDescriptor().o().get(ordinal());
    }

    @Deprecated
    public static ChannelTransDataType valueOf(int i3) {
        return forNumber(i3);
    }

    public static ChannelTransDataType valueOf(Descriptors.d dVar) {
        if (dVar.m() == getDescriptor()) {
            if (dVar.l() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[dVar.l()];
        }
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }
}
