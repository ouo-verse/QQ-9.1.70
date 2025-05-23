package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum RewardAdOpenType implements WireEnum {
    REWARD_AD_OPEN_TYPE_UNKNOWN(0),
    REWARD_AD_OPEN_TYPE_USER_OPEN(1),
    REWARD_AD_OPEN_TYPE_AUTO_OPEN(2);

    public static final ProtoAdapter<RewardAdOpenType> ADAPTER = new EnumAdapter<RewardAdOpenType>() { // from class: com.tencent.tvideo.protocol.pb.RewardAdOpenType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            RewardAdOpenType rewardAdOpenType = RewardAdOpenType.REWARD_AD_OPEN_TYPE_UNKNOWN;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdOpenType fromValue(int i3) {
            return RewardAdOpenType.fromValue(i3);
        }
    };
    private final int value;

    RewardAdOpenType(int i3) {
        this.value = i3;
    }

    public static RewardAdOpenType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return null;
                }
                return REWARD_AD_OPEN_TYPE_AUTO_OPEN;
            }
            return REWARD_AD_OPEN_TYPE_USER_OPEN;
        }
        return REWARD_AD_OPEN_TYPE_UNKNOWN;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
