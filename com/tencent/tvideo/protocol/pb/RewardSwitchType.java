package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum RewardSwitchType implements WireEnum {
    REWARD_SWITCH_TYPE_UNKNOWN(0),
    REWARD_SWITCH_TYPE_INTERRUPT(1),
    REWARD_SWITCH_TYPE_UNLOCK(2),
    REWARD_SWITCH_TYPE_END(3);

    public static final ProtoAdapter<RewardSwitchType> ADAPTER = new EnumAdapter<RewardSwitchType>() { // from class: com.tencent.tvideo.protocol.pb.RewardSwitchType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            RewardSwitchType rewardSwitchType = RewardSwitchType.REWARD_SWITCH_TYPE_UNKNOWN;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardSwitchType fromValue(int i3) {
            return RewardSwitchType.fromValue(i3);
        }
    };
    private final int value;

    RewardSwitchType(int i3) {
        this.value = i3;
    }

    public static RewardSwitchType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return null;
                    }
                    return REWARD_SWITCH_TYPE_END;
                }
                return REWARD_SWITCH_TYPE_UNLOCK;
            }
            return REWARD_SWITCH_TYPE_INTERRUPT;
        }
        return REWARD_SWITCH_TYPE_UNKNOWN;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
