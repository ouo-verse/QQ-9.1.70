package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum RewardAdErrorType implements WireEnum {
    REWARD_AD_ERROR_TYPE_UNKNOWN(0),
    REWARD_AD_ERROR_TYPE_FREQUENCY(1),
    REWARD_AD_ERROR_TYPE_PARAMS_INVALID(2);

    public static final ProtoAdapter<RewardAdErrorType> ADAPTER = new EnumAdapter<RewardAdErrorType>() { // from class: com.tencent.tvideo.protocol.pb.RewardAdErrorType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            RewardAdErrorType rewardAdErrorType = RewardAdErrorType.REWARD_AD_ERROR_TYPE_UNKNOWN;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdErrorType fromValue(int i3) {
            return RewardAdErrorType.fromValue(i3);
        }
    };
    private final int value;

    RewardAdErrorType(int i3) {
        this.value = i3;
    }

    public static RewardAdErrorType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return null;
                }
                return REWARD_AD_ERROR_TYPE_PARAMS_INVALID;
            }
            return REWARD_AD_ERROR_TYPE_FREQUENCY;
        }
        return REWARD_AD_ERROR_TYPE_UNKNOWN;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
