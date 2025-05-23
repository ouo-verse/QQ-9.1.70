package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum RewardAdSceneType implements WireEnum {
    REWARD_AD_SCENE_TYPE_UNKNOWN(0),
    REWARD_AD_SCENE_TYPE_QQ_VIDEO(1),
    REWARD_AD_SCENE_TYPE_SWITCH(2);

    public static final ProtoAdapter<RewardAdSceneType> ADAPTER = new EnumAdapter<RewardAdSceneType>() { // from class: com.tencent.tvideo.protocol.pb.RewardAdSceneType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            RewardAdSceneType rewardAdSceneType = RewardAdSceneType.REWARD_AD_SCENE_TYPE_UNKNOWN;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdSceneType fromValue(int i3) {
            return RewardAdSceneType.fromValue(i3);
        }
    };
    private final int value;

    RewardAdSceneType(int i3) {
        this.value = i3;
    }

    public static RewardAdSceneType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return null;
                }
                return REWARD_AD_SCENE_TYPE_SWITCH;
            }
            return REWARD_AD_SCENE_TYPE_QQ_VIDEO;
        }
        return REWARD_AD_SCENE_TYPE_UNKNOWN;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
