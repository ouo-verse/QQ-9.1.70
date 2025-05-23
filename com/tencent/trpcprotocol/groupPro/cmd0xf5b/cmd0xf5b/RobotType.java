package com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ad;
import com.google.protobuf.bk;

/* compiled from: P */
/* loaded from: classes25.dex */
public enum RobotType implements bk {
    ROBOT_TYPE_DEFAULT(0),
    ROBOT_TYPE_TEAM(1),
    UNRECOGNIZED(-1);

    public static final int ROBOT_TYPE_DEFAULT_VALUE = 0;
    public static final int ROBOT_TYPE_TEAM_VALUE = 1;
    private final int value;
    private static final ad.d<RobotType> internalValueMap = new ad.d<RobotType>() { // from class: com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.RobotType.a
        @Override // com.google.protobuf.ad.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RobotType findValueByNumber(int i3) {
            return RobotType.forNumber(i3);
        }
    };
    private static final RobotType[] VALUES = values();

    RobotType(int i3) {
        this.value = i3;
    }

    public static RobotType forNumber(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                return null;
            }
            return ROBOT_TYPE_TEAM;
        }
        return ROBOT_TYPE_DEFAULT;
    }

    public static final Descriptors.c getDescriptor() {
        return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.a().o().get(4);
    }

    public static ad.d<RobotType> internalGetValueMap() {
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
    public static RobotType valueOf(int i3) {
        return forNumber(i3);
    }

    public static RobotType valueOf(Descriptors.d dVar) {
        if (dVar.m() == getDescriptor()) {
            if (dVar.l() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[dVar.l()];
        }
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }
}
