package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum RewardAdReportType implements WireEnum {
    REWARD_AD_REPORT_TYPE_UNKNOWN(0),
    REWARD_AD_REPORT_TYPE_START(1),
    REWARD_AD_REPORT_TYPE_REACH(2),
    REWARD_AD_REPORT_TYPE_MIDDLE(3),
    REWARD_AD_REPORT_TYPE_END(4),
    REWARD_AD_REPORT_TYPE_UNLOCK(5),
    REWARD_AD_REPORT_TYPE_LOGIN(6);

    public static final ProtoAdapter<RewardAdReportType> ADAPTER = new EnumAdapter<RewardAdReportType>() { // from class: com.tencent.tvideo.protocol.pb.RewardAdReportType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            RewardAdReportType rewardAdReportType = RewardAdReportType.REWARD_AD_REPORT_TYPE_UNKNOWN;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdReportType fromValue(int i3) {
            return RewardAdReportType.fromValue(i3);
        }
    };
    private final int value;

    RewardAdReportType(int i3) {
        this.value = i3;
    }

    public static RewardAdReportType fromValue(int i3) {
        switch (i3) {
            case 0:
                return REWARD_AD_REPORT_TYPE_UNKNOWN;
            case 1:
                return REWARD_AD_REPORT_TYPE_START;
            case 2:
                return REWARD_AD_REPORT_TYPE_REACH;
            case 3:
                return REWARD_AD_REPORT_TYPE_MIDDLE;
            case 4:
                return REWARD_AD_REPORT_TYPE_END;
            case 5:
                return REWARD_AD_REPORT_TYPE_UNLOCK;
            case 6:
                return REWARD_AD_REPORT_TYPE_LOGIN;
            default:
                return null;
        }
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
