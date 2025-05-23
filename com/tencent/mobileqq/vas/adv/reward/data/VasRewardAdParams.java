package com.tencent.mobileqq.vas.adv.reward.data;

import androidx.fragment.app.a;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001$BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0006H\u00c6\u0003JQ\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00d6\u0001J\t\u0010#\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/reward/data/VasRewardAdParams;", "", "advPos", "", "rewardType", "rewardItem", "", "rewardText", "uin", "", "gdtBizId", "bizSrcId", "(IILjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getAdvPos", "()I", "getBizSrcId", "()Ljava/lang/String;", "getGdtBizId", "getRewardItem", "getRewardText", "getRewardType", "getUin", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "Builder", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final /* data */ class VasRewardAdParams {
    private final int advPos;

    @NotNull
    private final String bizSrcId;

    @NotNull
    private final String gdtBizId;

    @NotNull
    private final String rewardItem;

    @Nullable
    private final String rewardText;
    private final int rewardType;
    private final long uin;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010#\u001a\u00020$R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/reward/data/VasRewardAdParams$Builder;", "", "()V", "advPos", "", "getAdvPos", "()Ljava/lang/Integer;", "setAdvPos", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "bizSrcId", "", "getBizSrcId", "()Ljava/lang/String;", "setBizSrcId", "(Ljava/lang/String;)V", "gdtBizId", "getGdtBizId", "setGdtBizId", "rewardItem", "getRewardItem", "setRewardItem", "rewardText", "getRewardText", "setRewardText", "rewardType", "getRewardType", "setRewardType", "uin", "", "getUin", "()Ljava/lang/Long;", "setUin", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "build", "Lcom/tencent/mobileqq/vas/adv/reward/data/VasRewardAdParams;", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Builder {

        @Nullable
        private Integer advPos;

        @Nullable
        private String bizSrcId;

        @Nullable
        private String gdtBizId;

        @Nullable
        private String rewardItem;

        @Nullable
        private String rewardText;

        @Nullable
        private Integer rewardType;

        @Nullable
        private Long uin;

        @NotNull
        public final VasRewardAdParams build() {
            long longAccountUin;
            Integer num = this.advPos;
            Intrinsics.checkNotNull(num);
            int intValue = num.intValue();
            Integer num2 = this.rewardType;
            Intrinsics.checkNotNull(num2);
            int intValue2 = num2.intValue();
            String str = this.rewardItem;
            Intrinsics.checkNotNull(str);
            String str2 = this.rewardText;
            Long l3 = this.uin;
            if (l3 != null) {
                longAccountUin = l3.longValue();
            } else {
                longAccountUin = MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin();
            }
            String str3 = this.gdtBizId;
            if (str3 == null) {
                str3 = VasAdvConstant.VAS_GDT_BIZ_ID;
            }
            String str4 = str3;
            String str5 = this.bizSrcId;
            if (str5 == null) {
                str5 = "biz_src_jc_vip";
            }
            return new VasRewardAdParams(intValue, intValue2, str, str2, longAccountUin, str4, str5);
        }

        @Nullable
        public final Integer getAdvPos() {
            return this.advPos;
        }

        @Nullable
        public final String getBizSrcId() {
            return this.bizSrcId;
        }

        @Nullable
        public final String getGdtBizId() {
            return this.gdtBizId;
        }

        @Nullable
        public final String getRewardItem() {
            return this.rewardItem;
        }

        @Nullable
        public final String getRewardText() {
            return this.rewardText;
        }

        @Nullable
        public final Integer getRewardType() {
            return this.rewardType;
        }

        @Nullable
        public final Long getUin() {
            return this.uin;
        }

        public final void setAdvPos(@Nullable Integer num) {
            this.advPos = num;
        }

        public final void setBizSrcId(@Nullable String str) {
            this.bizSrcId = str;
        }

        public final void setGdtBizId(@Nullable String str) {
            this.gdtBizId = str;
        }

        public final void setRewardItem(@Nullable String str) {
            this.rewardItem = str;
        }

        public final void setRewardText(@Nullable String str) {
            this.rewardText = str;
        }

        public final void setRewardType(@Nullable Integer num) {
            this.rewardType = num;
        }

        public final void setUin(@Nullable Long l3) {
            this.uin = l3;
        }
    }

    public VasRewardAdParams(int i3, int i16, @NotNull String rewardItem, @Nullable String str, long j3, @NotNull String gdtBizId, @NotNull String bizSrcId) {
        Intrinsics.checkNotNullParameter(rewardItem, "rewardItem");
        Intrinsics.checkNotNullParameter(gdtBizId, "gdtBizId");
        Intrinsics.checkNotNullParameter(bizSrcId, "bizSrcId");
        this.advPos = i3;
        this.rewardType = i16;
        this.rewardItem = rewardItem;
        this.rewardText = str;
        this.uin = j3;
        this.gdtBizId = gdtBizId;
        this.bizSrcId = bizSrcId;
    }

    public static /* synthetic */ VasRewardAdParams copy$default(VasRewardAdParams vasRewardAdParams, int i3, int i16, String str, String str2, long j3, String str3, String str4, int i17, Object obj) {
        int i18;
        int i19;
        String str5;
        String str6;
        long j16;
        String str7;
        String str8;
        if ((i17 & 1) != 0) {
            i18 = vasRewardAdParams.advPos;
        } else {
            i18 = i3;
        }
        if ((i17 & 2) != 0) {
            i19 = vasRewardAdParams.rewardType;
        } else {
            i19 = i16;
        }
        if ((i17 & 4) != 0) {
            str5 = vasRewardAdParams.rewardItem;
        } else {
            str5 = str;
        }
        if ((i17 & 8) != 0) {
            str6 = vasRewardAdParams.rewardText;
        } else {
            str6 = str2;
        }
        if ((i17 & 16) != 0) {
            j16 = vasRewardAdParams.uin;
        } else {
            j16 = j3;
        }
        if ((i17 & 32) != 0) {
            str7 = vasRewardAdParams.gdtBizId;
        } else {
            str7 = str3;
        }
        if ((i17 & 64) != 0) {
            str8 = vasRewardAdParams.bizSrcId;
        } else {
            str8 = str4;
        }
        return vasRewardAdParams.copy(i18, i19, str5, str6, j16, str7, str8);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAdvPos() {
        return this.advPos;
    }

    /* renamed from: component2, reason: from getter */
    public final int getRewardType() {
        return this.rewardType;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getRewardItem() {
        return this.rewardItem;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getRewardText() {
        return this.rewardText;
    }

    /* renamed from: component5, reason: from getter */
    public final long getUin() {
        return this.uin;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getGdtBizId() {
        return this.gdtBizId;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getBizSrcId() {
        return this.bizSrcId;
    }

    @NotNull
    public final VasRewardAdParams copy(int advPos, int rewardType, @NotNull String rewardItem, @Nullable String rewardText, long uin, @NotNull String gdtBizId, @NotNull String bizSrcId) {
        Intrinsics.checkNotNullParameter(rewardItem, "rewardItem");
        Intrinsics.checkNotNullParameter(gdtBizId, "gdtBizId");
        Intrinsics.checkNotNullParameter(bizSrcId, "bizSrcId");
        return new VasRewardAdParams(advPos, rewardType, rewardItem, rewardText, uin, gdtBizId, bizSrcId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VasRewardAdParams)) {
            return false;
        }
        VasRewardAdParams vasRewardAdParams = (VasRewardAdParams) other;
        if (this.advPos == vasRewardAdParams.advPos && this.rewardType == vasRewardAdParams.rewardType && Intrinsics.areEqual(this.rewardItem, vasRewardAdParams.rewardItem) && Intrinsics.areEqual(this.rewardText, vasRewardAdParams.rewardText) && this.uin == vasRewardAdParams.uin && Intrinsics.areEqual(this.gdtBizId, vasRewardAdParams.gdtBizId) && Intrinsics.areEqual(this.bizSrcId, vasRewardAdParams.bizSrcId)) {
            return true;
        }
        return false;
    }

    public final int getAdvPos() {
        return this.advPos;
    }

    @NotNull
    public final String getBizSrcId() {
        return this.bizSrcId;
    }

    @NotNull
    public final String getGdtBizId() {
        return this.gdtBizId;
    }

    @NotNull
    public final String getRewardItem() {
        return this.rewardItem;
    }

    @Nullable
    public final String getRewardText() {
        return this.rewardText;
    }

    public final int getRewardType() {
        return this.rewardType;
    }

    public final long getUin() {
        return this.uin;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((this.advPos * 31) + this.rewardType) * 31) + this.rewardItem.hashCode()) * 31;
        String str = this.rewardText;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((((((hashCode2 + hashCode) * 31) + a.a(this.uin)) * 31) + this.gdtBizId.hashCode()) * 31) + this.bizSrcId.hashCode();
    }

    @NotNull
    public String toString() {
        return "VasRewardAdParams(advPos=" + this.advPos + ", rewardType=" + this.rewardType + ", rewardItem=" + this.rewardItem + ", rewardText=" + this.rewardText + ", uin=" + this.uin + ", gdtBizId=" + this.gdtBizId + ", bizSrcId=" + this.bizSrcId + ')';
    }

    public /* synthetic */ VasRewardAdParams(int i3, int i16, String str, String str2, long j3, String str3, String str4, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, str, str2, j3, (i17 & 32) != 0 ? VasAdvConstant.VAS_GDT_BIZ_ID : str3, (i17 & 64) != 0 ? "biz_src_jc_vip" : str4);
    }
}
