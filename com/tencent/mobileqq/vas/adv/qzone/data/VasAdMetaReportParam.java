package com.tencent.mobileqq.vas.adv.qzone.data;

import androidx.fragment.app.a;
import com.tencent.mobileqq.vas.adv.common.pb.adv_report;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001*BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0002\u0010\fJ\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\bH\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\t\u0010#\u001a\u00020\nH\u00c6\u0003JQ\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u00c6\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010(\u001a\u00020\u0003H\u00d6\u0001J\t\u0010)\u001a\u00020\nH\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/qzone/data/VasAdMetaReportParam;", "", "advPos", "", "actionType", "actionValue", "feedIndex", "uin", "", "subscribeId", "", "recommendCookie", "(IIIIJLjava/lang/String;Ljava/lang/String;)V", "getActionType", "()I", "getActionValue", "getAdvPos", "getFeedIndex", "getRecommendCookie", "()Ljava/lang/String;", "rewardReportInfo", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$RewardReportInfo;", "getRewardReportInfo", "()Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$RewardReportInfo;", "setRewardReportInfo", "(Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$RewardReportInfo;)V", "getSubscribeId", "getUin", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "Builder", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final /* data */ class VasAdMetaReportParam {
    private final int actionType;
    private final int actionValue;
    private final int advPos;
    private final int feedIndex;

    @NotNull
    private final String recommendCookie;

    @NotNull
    private adv_report.RewardReportInfo rewardReportInfo;

    @Nullable
    private final String subscribeId;
    private final long uin;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010)\u001a\u00020*R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\u001e\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/qzone/data/VasAdMetaReportParam$Builder;", "", "()V", "actionType", "", "getActionType", "()Ljava/lang/Integer;", "setActionType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "actionValue", "getActionValue", "setActionValue", "advPos", "getAdvPos", "setAdvPos", "feedIndex", "getFeedIndex", "setFeedIndex", "recommendCookie", "", "getRecommendCookie", "()Ljava/lang/String;", "setRecommendCookie", "(Ljava/lang/String;)V", "rewardReportInfo", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$RewardReportInfo;", "getRewardReportInfo", "()Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$RewardReportInfo;", "setRewardReportInfo", "(Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$RewardReportInfo;)V", "subscribeId", "getSubscribeId", "setSubscribeId", "uin", "", "getUin", "()Ljava/lang/Long;", "setUin", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "build", "Lcom/tencent/mobileqq/vas/adv/qzone/data/VasAdMetaReportParam;", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Builder {

        @Nullable
        private Integer actionType;

        @Nullable
        private Integer actionValue;

        @Nullable
        private Integer advPos;

        @Nullable
        private Integer feedIndex;

        @Nullable
        private String recommendCookie;

        @NotNull
        private adv_report.RewardReportInfo rewardReportInfo = new adv_report.RewardReportInfo();

        @Nullable
        private String subscribeId;

        @Nullable
        private Long uin;

        @NotNull
        public final VasAdMetaReportParam build() {
            Integer num = this.advPos;
            Intrinsics.checkNotNull(num);
            int intValue = num.intValue();
            Integer num2 = this.actionType;
            Intrinsics.checkNotNull(num2);
            int intValue2 = num2.intValue();
            Integer num3 = this.actionValue;
            Intrinsics.checkNotNull(num3);
            int intValue3 = num3.intValue();
            Integer num4 = this.feedIndex;
            Intrinsics.checkNotNull(num4);
            int intValue4 = num4.intValue();
            Long l3 = this.uin;
            Intrinsics.checkNotNull(l3);
            long longValue = l3.longValue();
            String str = this.subscribeId;
            String str2 = this.recommendCookie;
            Intrinsics.checkNotNull(str2);
            VasAdMetaReportParam vasAdMetaReportParam = new VasAdMetaReportParam(intValue, intValue2, intValue3, intValue4, longValue, str, str2);
            vasAdMetaReportParam.setRewardReportInfo(this.rewardReportInfo);
            return vasAdMetaReportParam;
        }

        @Nullable
        public final Integer getActionType() {
            return this.actionType;
        }

        @Nullable
        public final Integer getActionValue() {
            return this.actionValue;
        }

        @Nullable
        public final Integer getAdvPos() {
            return this.advPos;
        }

        @Nullable
        public final Integer getFeedIndex() {
            return this.feedIndex;
        }

        @Nullable
        public final String getRecommendCookie() {
            return this.recommendCookie;
        }

        @NotNull
        public final adv_report.RewardReportInfo getRewardReportInfo() {
            return this.rewardReportInfo;
        }

        @Nullable
        public final String getSubscribeId() {
            return this.subscribeId;
        }

        @Nullable
        public final Long getUin() {
            return this.uin;
        }

        public final void setActionType(@Nullable Integer num) {
            this.actionType = num;
        }

        public final void setActionValue(@Nullable Integer num) {
            this.actionValue = num;
        }

        public final void setAdvPos(@Nullable Integer num) {
            this.advPos = num;
        }

        public final void setFeedIndex(@Nullable Integer num) {
            this.feedIndex = num;
        }

        public final void setRecommendCookie(@Nullable String str) {
            this.recommendCookie = str;
        }

        public final void setRewardReportInfo(@NotNull adv_report.RewardReportInfo rewardReportInfo) {
            Intrinsics.checkNotNullParameter(rewardReportInfo, "<set-?>");
            this.rewardReportInfo = rewardReportInfo;
        }

        public final void setSubscribeId(@Nullable String str) {
            this.subscribeId = str;
        }

        public final void setUin(@Nullable Long l3) {
            this.uin = l3;
        }
    }

    public VasAdMetaReportParam(int i3, int i16, int i17, int i18, long j3, @Nullable String str, @NotNull String recommendCookie) {
        Intrinsics.checkNotNullParameter(recommendCookie, "recommendCookie");
        this.advPos = i3;
        this.actionType = i16;
        this.actionValue = i17;
        this.feedIndex = i18;
        this.uin = j3;
        this.subscribeId = str;
        this.recommendCookie = recommendCookie;
        this.rewardReportInfo = new adv_report.RewardReportInfo();
    }

    public static /* synthetic */ VasAdMetaReportParam copy$default(VasAdMetaReportParam vasAdMetaReportParam, int i3, int i16, int i17, int i18, long j3, String str, String str2, int i19, Object obj) {
        int i26;
        int i27;
        int i28;
        int i29;
        long j16;
        String str3;
        String str4;
        if ((i19 & 1) != 0) {
            i26 = vasAdMetaReportParam.advPos;
        } else {
            i26 = i3;
        }
        if ((i19 & 2) != 0) {
            i27 = vasAdMetaReportParam.actionType;
        } else {
            i27 = i16;
        }
        if ((i19 & 4) != 0) {
            i28 = vasAdMetaReportParam.actionValue;
        } else {
            i28 = i17;
        }
        if ((i19 & 8) != 0) {
            i29 = vasAdMetaReportParam.feedIndex;
        } else {
            i29 = i18;
        }
        if ((i19 & 16) != 0) {
            j16 = vasAdMetaReportParam.uin;
        } else {
            j16 = j3;
        }
        if ((i19 & 32) != 0) {
            str3 = vasAdMetaReportParam.subscribeId;
        } else {
            str3 = str;
        }
        if ((i19 & 64) != 0) {
            str4 = vasAdMetaReportParam.recommendCookie;
        } else {
            str4 = str2;
        }
        return vasAdMetaReportParam.copy(i26, i27, i28, i29, j16, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAdvPos() {
        return this.advPos;
    }

    /* renamed from: component2, reason: from getter */
    public final int getActionType() {
        return this.actionType;
    }

    /* renamed from: component3, reason: from getter */
    public final int getActionValue() {
        return this.actionValue;
    }

    /* renamed from: component4, reason: from getter */
    public final int getFeedIndex() {
        return this.feedIndex;
    }

    /* renamed from: component5, reason: from getter */
    public final long getUin() {
        return this.uin;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getSubscribeId() {
        return this.subscribeId;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getRecommendCookie() {
        return this.recommendCookie;
    }

    @NotNull
    public final VasAdMetaReportParam copy(int advPos, int actionType, int actionValue, int feedIndex, long uin, @Nullable String subscribeId, @NotNull String recommendCookie) {
        Intrinsics.checkNotNullParameter(recommendCookie, "recommendCookie");
        return new VasAdMetaReportParam(advPos, actionType, actionValue, feedIndex, uin, subscribeId, recommendCookie);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VasAdMetaReportParam)) {
            return false;
        }
        VasAdMetaReportParam vasAdMetaReportParam = (VasAdMetaReportParam) other;
        if (this.advPos == vasAdMetaReportParam.advPos && this.actionType == vasAdMetaReportParam.actionType && this.actionValue == vasAdMetaReportParam.actionValue && this.feedIndex == vasAdMetaReportParam.feedIndex && this.uin == vasAdMetaReportParam.uin && Intrinsics.areEqual(this.subscribeId, vasAdMetaReportParam.subscribeId) && Intrinsics.areEqual(this.recommendCookie, vasAdMetaReportParam.recommendCookie)) {
            return true;
        }
        return false;
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final int getActionValue() {
        return this.actionValue;
    }

    public final int getAdvPos() {
        return this.advPos;
    }

    public final int getFeedIndex() {
        return this.feedIndex;
    }

    @NotNull
    public final String getRecommendCookie() {
        return this.recommendCookie;
    }

    @NotNull
    public final adv_report.RewardReportInfo getRewardReportInfo() {
        return this.rewardReportInfo;
    }

    @Nullable
    public final String getSubscribeId() {
        return this.subscribeId;
    }

    public final long getUin() {
        return this.uin;
    }

    public int hashCode() {
        int hashCode;
        int a16 = ((((((((this.advPos * 31) + this.actionType) * 31) + this.actionValue) * 31) + this.feedIndex) * 31) + a.a(this.uin)) * 31;
        String str = this.subscribeId;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((a16 + hashCode) * 31) + this.recommendCookie.hashCode();
    }

    public final void setRewardReportInfo(@NotNull adv_report.RewardReportInfo rewardReportInfo) {
        Intrinsics.checkNotNullParameter(rewardReportInfo, "<set-?>");
        this.rewardReportInfo = rewardReportInfo;
    }

    @NotNull
    public String toString() {
        return "VasAdMetaReportParam(advPos=" + this.advPos + ", actionType=" + this.actionType + ", actionValue=" + this.actionValue + ", feedIndex=" + this.feedIndex + ", uin=" + this.uin + ", subscribeId=" + this.subscribeId + ", recommendCookie=" + this.recommendCookie + ')';
    }

    public /* synthetic */ VasAdMetaReportParam(int i3, int i16, int i17, int i18, long j3, String str, String str2, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, i17, i18, j3, str, (i19 & 64) != 0 ? "" : str2);
    }
}
