package com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ad;
import com.google.protobuf.bk;

/* compiled from: P */
/* loaded from: classes25.dex */
public enum ChannelRoleType implements bk {
    Role_Invalid(0),
    Role_Voice_Normal(1),
    Role_Voice_Host(2),
    UNRECOGNIZED(-1);

    public static final int Role_Invalid_VALUE = 0;
    public static final int Role_Voice_Host_VALUE = 2;
    public static final int Role_Voice_Normal_VALUE = 1;
    private final int value;
    private static final ad.d<ChannelRoleType> internalValueMap = new ad.d<ChannelRoleType>() { // from class: com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.ChannelRoleType.a
        @Override // com.google.protobuf.ad.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ChannelRoleType findValueByNumber(int i3) {
            return ChannelRoleType.forNumber(i3);
        }
    };
    private static final ChannelRoleType[] VALUES = values();

    ChannelRoleType(int i3) {
        this.value = i3;
    }

    public static ChannelRoleType forNumber(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return null;
                }
                return Role_Voice_Host;
            }
            return Role_Voice_Normal;
        }
        return Role_Invalid;
    }

    public static final Descriptors.c getDescriptor() {
        return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.a().o().get(1);
    }

    public static ad.d<ChannelRoleType> internalGetValueMap() {
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
    public static ChannelRoleType valueOf(int i3) {
        return forNumber(i3);
    }

    public static ChannelRoleType valueOf(Descriptors.d dVar) {
        if (dVar.m() == getDescriptor()) {
            if (dVar.l() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[dVar.l()];
        }
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }
}
