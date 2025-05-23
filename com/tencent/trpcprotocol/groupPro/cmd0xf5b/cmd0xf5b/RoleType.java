package com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ad;
import com.google.protobuf.bk;

/* compiled from: P */
/* loaded from: classes25.dex */
public enum RoleType implements bk {
    Role_Normal_Member(0),
    Role_Admin(1),
    Role_Owner(2),
    UNRECOGNIZED(-1);

    public static final int Role_Admin_VALUE = 1;
    public static final int Role_Normal_Member_VALUE = 0;
    public static final int Role_Owner_VALUE = 2;
    private final int value;
    private static final ad.d<RoleType> internalValueMap = new ad.d<RoleType>() { // from class: com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.RoleType.a
        @Override // com.google.protobuf.ad.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RoleType findValueByNumber(int i3) {
            return RoleType.forNumber(i3);
        }
    };
    private static final RoleType[] VALUES = values();

    RoleType(int i3) {
        this.value = i3;
    }

    public static RoleType forNumber(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return null;
                }
                return Role_Owner;
            }
            return Role_Admin;
        }
        return Role_Normal_Member;
    }

    public static final Descriptors.c getDescriptor() {
        return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.a().o().get(0);
    }

    public static ad.d<RoleType> internalGetValueMap() {
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
    public static RoleType valueOf(int i3) {
        return forNumber(i3);
    }

    public static RoleType valueOf(Descriptors.d dVar) {
        if (dVar.m() == getDescriptor()) {
            if (dVar.l() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[dVar.l()];
        }
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }
}
