package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum RewardAdRewardUnlockType implements WireEnum {
    REWARD_AD_UNLOCK_REWARD_TYPE_UNKNOWN(0),
    REWARD_AD_UNLOCK_REWARD_TYPE_COMMODITY_VOUCHER(1);

    public static final ProtoAdapter<RewardAdRewardUnlockType> ADAPTER = new EnumAdapter<RewardAdRewardUnlockType>() { // from class: com.tencent.tvideo.protocol.pb.RewardAdRewardUnlockType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            RewardAdRewardUnlockType rewardAdRewardUnlockType = RewardAdRewardUnlockType.REWARD_AD_UNLOCK_REWARD_TYPE_UNKNOWN;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdRewardUnlockType fromValue(int i3) {
            return RewardAdRewardUnlockType.fromValue(i3);
        }
    };
    private final int value;

    RewardAdRewardUnlockType(int i3) {
        this.value = i3;
    }

    public static RewardAdRewardUnlockType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                return null;
            }
            return REWARD_AD_UNLOCK_REWARD_TYPE_COMMODITY_VOUCHER;
        }
        return REWARD_AD_UNLOCK_REWARD_TYPE_UNKNOWN;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
