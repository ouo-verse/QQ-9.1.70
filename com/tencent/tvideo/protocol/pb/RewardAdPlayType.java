package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* loaded from: classes27.dex */
public enum RewardAdPlayType implements WireEnum {
    REWARD_AD_PLAY_TYPE_UNKNOWN(0),
    REWARD_AD_PLAY_TYPE_QQ_VIDEO(1),
    REWARD_AD_PLAY_TYPE_SWITCH(2);

    public static final ProtoAdapter<RewardAdPlayType> ADAPTER = new EnumAdapter<RewardAdPlayType>() { // from class: com.tencent.tvideo.protocol.pb.RewardAdPlayType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            RewardAdPlayType rewardAdPlayType = RewardAdPlayType.REWARD_AD_PLAY_TYPE_UNKNOWN;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdPlayType fromValue(int i3) {
            return RewardAdPlayType.fromValue(i3);
        }
    };
    private final int value;

    RewardAdPlayType(int i3) {
        this.value = i3;
    }

    public static RewardAdPlayType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return null;
                }
                return REWARD_AD_PLAY_TYPE_SWITCH;
            }
            return REWARD_AD_PLAY_TYPE_QQ_VIDEO;
        }
        return REWARD_AD_PLAY_TYPE_UNKNOWN;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
