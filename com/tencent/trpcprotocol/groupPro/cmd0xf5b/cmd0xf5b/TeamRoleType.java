package com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ad;
import com.google.protobuf.bk;

/* compiled from: P */
/* loaded from: classes25.dex */
public enum TeamRoleType implements bk {
    TEAM_ROLE_TYPE_AUDIENCE(0),
    TEAM_ROLE_TYPE_CAPTAIN(1),
    TEAM_ROLE_TYPE_MEMBER(2),
    UNRECOGNIZED(-1);

    public static final int TEAM_ROLE_TYPE_AUDIENCE_VALUE = 0;
    public static final int TEAM_ROLE_TYPE_CAPTAIN_VALUE = 1;
    public static final int TEAM_ROLE_TYPE_MEMBER_VALUE = 2;
    private final int value;
    private static final ad.d<TeamRoleType> internalValueMap = new ad.d<TeamRoleType>() { // from class: com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.TeamRoleType.a
        @Override // com.google.protobuf.ad.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TeamRoleType findValueByNumber(int i3) {
            return TeamRoleType.forNumber(i3);
        }
    };
    private static final TeamRoleType[] VALUES = values();

    TeamRoleType(int i3) {
        this.value = i3;
    }

    public static TeamRoleType forNumber(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return null;
                }
                return TEAM_ROLE_TYPE_MEMBER;
            }
            return TEAM_ROLE_TYPE_CAPTAIN;
        }
        return TEAM_ROLE_TYPE_AUDIENCE;
    }

    public static final Descriptors.c getDescriptor() {
        return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.a().o().get(2);
    }

    public static ad.d<TeamRoleType> internalGetValueMap() {
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
    public static TeamRoleType valueOf(int i3) {
        return forNumber(i3);
    }

    public static TeamRoleType valueOf(Descriptors.d dVar) {
        if (dVar.m() == getDescriptor()) {
            if (dVar.l() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[dVar.l()];
        }
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }
}
