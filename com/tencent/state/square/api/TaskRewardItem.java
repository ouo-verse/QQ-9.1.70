package com.tencent.state.square.api;

import androidx.fragment.app.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000eJ\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0005H\u00c6\u0003J\t\u0010&\u001a\u00020\u0005H\u00c6\u0003J\t\u0010'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0005H\u00c6\u0003J\t\u0010)\u001a\u00020\nH\u00c6\u0003J\t\u0010*\u001a\u00020\nH\u00c6\u0003J\t\u0010+\u001a\u00020\nH\u00c6\u0003J\t\u0010,\u001a\u00020\nH\u00c6\u0003Jc\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\nH\u00c6\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00101\u001a\u00020\u0005H\u00d6\u0001J\t\u00102\u001a\u00020\nH\u00d6\u0001R\u001a\u0010\f\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010 R\u001a\u0010\r\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018\u00a8\u00063"}, d2 = {"Lcom/tencent/state/square/api/TaskRewardItem;", "", "questId", "", "questCurrentCnt", "", "targetAmount", "rewardItemId", "rewardItemCnt", "coinIcon", "", "pointIcon", "bgUrl", "specialUrl", "(JIIJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBgUrl", "()Ljava/lang/String;", "setBgUrl", "(Ljava/lang/String;)V", "getCoinIcon", "setCoinIcon", "getPointIcon", "setPointIcon", "getQuestCurrentCnt", "()I", "getQuestId", "()J", "getRewardItemCnt", "setRewardItemCnt", "(I)V", "getRewardItemId", "setRewardItemId", "(J)V", "getSpecialUrl", "setSpecialUrl", "getTargetAmount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final /* data */ class TaskRewardItem {

    @NotNull
    private String bgUrl;

    @NotNull
    private String coinIcon;

    @NotNull
    private String pointIcon;
    private final int questCurrentCnt;
    private final long questId;
    private int rewardItemCnt;
    private long rewardItemId;

    @NotNull
    private String specialUrl;
    private final int targetAmount;

    public TaskRewardItem() {
        this(0L, 0, 0, 0L, 0, null, null, null, null, 511, null);
    }

    public static /* synthetic */ TaskRewardItem copy$default(TaskRewardItem taskRewardItem, long j3, int i3, int i16, long j16, int i17, String str, String str2, String str3, String str4, int i18, Object obj) {
        long j17;
        int i19;
        int i26;
        long j18;
        int i27;
        String str5;
        String str6;
        String str7;
        String str8;
        if ((i18 & 1) != 0) {
            j17 = taskRewardItem.questId;
        } else {
            j17 = j3;
        }
        if ((i18 & 2) != 0) {
            i19 = taskRewardItem.questCurrentCnt;
        } else {
            i19 = i3;
        }
        if ((i18 & 4) != 0) {
            i26 = taskRewardItem.targetAmount;
        } else {
            i26 = i16;
        }
        if ((i18 & 8) != 0) {
            j18 = taskRewardItem.rewardItemId;
        } else {
            j18 = j16;
        }
        if ((i18 & 16) != 0) {
            i27 = taskRewardItem.rewardItemCnt;
        } else {
            i27 = i17;
        }
        if ((i18 & 32) != 0) {
            str5 = taskRewardItem.coinIcon;
        } else {
            str5 = str;
        }
        if ((i18 & 64) != 0) {
            str6 = taskRewardItem.pointIcon;
        } else {
            str6 = str2;
        }
        if ((i18 & 128) != 0) {
            str7 = taskRewardItem.bgUrl;
        } else {
            str7 = str3;
        }
        if ((i18 & 256) != 0) {
            str8 = taskRewardItem.specialUrl;
        } else {
            str8 = str4;
        }
        return taskRewardItem.copy(j17, i19, i26, j18, i27, str5, str6, str7, str8);
    }

    /* renamed from: component1, reason: from getter */
    public final long getQuestId() {
        return this.questId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getQuestCurrentCnt() {
        return this.questCurrentCnt;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTargetAmount() {
        return this.targetAmount;
    }

    /* renamed from: component4, reason: from getter */
    public final long getRewardItemId() {
        return this.rewardItemId;
    }

    /* renamed from: component5, reason: from getter */
    public final int getRewardItemCnt() {
        return this.rewardItemCnt;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getCoinIcon() {
        return this.coinIcon;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getPointIcon() {
        return this.pointIcon;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getBgUrl() {
        return this.bgUrl;
    }

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final String getSpecialUrl() {
        return this.specialUrl;
    }

    @NotNull
    public final TaskRewardItem copy(long questId, int questCurrentCnt, int targetAmount, long rewardItemId, int rewardItemCnt, @NotNull String coinIcon, @NotNull String pointIcon, @NotNull String bgUrl, @NotNull String specialUrl) {
        Intrinsics.checkNotNullParameter(coinIcon, "coinIcon");
        Intrinsics.checkNotNullParameter(pointIcon, "pointIcon");
        Intrinsics.checkNotNullParameter(bgUrl, "bgUrl");
        Intrinsics.checkNotNullParameter(specialUrl, "specialUrl");
        return new TaskRewardItem(questId, questCurrentCnt, targetAmount, rewardItemId, rewardItemCnt, coinIcon, pointIcon, bgUrl, specialUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof TaskRewardItem) {
                TaskRewardItem taskRewardItem = (TaskRewardItem) other;
                if (this.questId != taskRewardItem.questId || this.questCurrentCnt != taskRewardItem.questCurrentCnt || this.targetAmount != taskRewardItem.targetAmount || this.rewardItemId != taskRewardItem.rewardItemId || this.rewardItemCnt != taskRewardItem.rewardItemCnt || !Intrinsics.areEqual(this.coinIcon, taskRewardItem.coinIcon) || !Intrinsics.areEqual(this.pointIcon, taskRewardItem.pointIcon) || !Intrinsics.areEqual(this.bgUrl, taskRewardItem.bgUrl) || !Intrinsics.areEqual(this.specialUrl, taskRewardItem.specialUrl)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getBgUrl() {
        return this.bgUrl;
    }

    @NotNull
    public final String getCoinIcon() {
        return this.coinIcon;
    }

    @NotNull
    public final String getPointIcon() {
        return this.pointIcon;
    }

    public final int getQuestCurrentCnt() {
        return this.questCurrentCnt;
    }

    public final long getQuestId() {
        return this.questId;
    }

    public final int getRewardItemCnt() {
        return this.rewardItemCnt;
    }

    public final long getRewardItemId() {
        return this.rewardItemId;
    }

    @NotNull
    public final String getSpecialUrl() {
        return this.specialUrl;
    }

    public final int getTargetAmount() {
        return this.targetAmount;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int a16 = ((((((((a.a(this.questId) * 31) + this.questCurrentCnt) * 31) + this.targetAmount) * 31) + a.a(this.rewardItemId)) * 31) + this.rewardItemCnt) * 31;
        String str = this.coinIcon;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = (a16 + i3) * 31;
        String str2 = this.pointIcon;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        String str3 = this.bgUrl;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        String str4 = this.specialUrl;
        if (str4 != null) {
            i18 = str4.hashCode();
        }
        return i27 + i18;
    }

    public final void setBgUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bgUrl = str;
    }

    public final void setCoinIcon(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coinIcon = str;
    }

    public final void setPointIcon(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pointIcon = str;
    }

    public final void setRewardItemCnt(int i3) {
        this.rewardItemCnt = i3;
    }

    public final void setRewardItemId(long j3) {
        this.rewardItemId = j3;
    }

    public final void setSpecialUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.specialUrl = str;
    }

    @NotNull
    public String toString() {
        return "TaskRewardItem(questId=" + this.questId + ", questCurrentCnt=" + this.questCurrentCnt + ", targetAmount=" + this.targetAmount + ", rewardItemId=" + this.rewardItemId + ", rewardItemCnt=" + this.rewardItemCnt + ", coinIcon=" + this.coinIcon + ", pointIcon=" + this.pointIcon + ", bgUrl=" + this.bgUrl + ", specialUrl=" + this.specialUrl + ")";
    }

    public TaskRewardItem(long j3, int i3, int i16, long j16, int i17, @NotNull String coinIcon, @NotNull String pointIcon, @NotNull String bgUrl, @NotNull String specialUrl) {
        Intrinsics.checkNotNullParameter(coinIcon, "coinIcon");
        Intrinsics.checkNotNullParameter(pointIcon, "pointIcon");
        Intrinsics.checkNotNullParameter(bgUrl, "bgUrl");
        Intrinsics.checkNotNullParameter(specialUrl, "specialUrl");
        this.questId = j3;
        this.questCurrentCnt = i3;
        this.targetAmount = i16;
        this.rewardItemId = j16;
        this.rewardItemCnt = i17;
        this.coinIcon = coinIcon;
        this.pointIcon = pointIcon;
        this.bgUrl = bgUrl;
        this.specialUrl = specialUrl;
    }

    public /* synthetic */ TaskRewardItem(long j3, int i3, int i16, long j16, int i17, String str, String str2, String str3, String str4, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 0L : j3, (i18 & 2) != 0 ? 0 : i3, (i18 & 4) != 0 ? 0 : i16, (i18 & 8) == 0 ? j16 : 0L, (i18 & 16) == 0 ? i17 : 0, (i18 & 32) != 0 ? "" : str, (i18 & 64) != 0 ? "" : str2, (i18 & 128) != 0 ? "" : str3, (i18 & 256) == 0 ? str4 : "");
    }
}
