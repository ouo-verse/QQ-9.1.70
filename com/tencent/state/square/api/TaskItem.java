package com.tencent.state.square.api;

import androidx.fragment.app.a;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\u0002\u0010\u0014J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\u0005H\u00c6\u0003J\t\u00100\u001a\u00020\u000bH\u00c6\u0003J\t\u00101\u001a\u00020\u0011H\u00c6\u0003J\t\u00102\u001a\u00020\u0013H\u00c6\u0003J\t\u00103\u001a\u00020\u0005H\u00c6\u0003J\t\u00104\u001a\u00020\u0005H\u00c6\u0003J\t\u00105\u001a\u00020\u0005H\u00c6\u0003J\t\u00106\u001a\u00020\u0005H\u00c6\u0003J\t\u00107\u001a\u00020\u0005H\u00c6\u0003J\t\u00108\u001a\u00020\u000bH\u00c6\u0003J\t\u00109\u001a\u00020\u000bH\u00c6\u0003J\t\u0010:\u001a\u00020\u0003H\u00c6\u0003J\u008b\u0001\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u00c6\u0001J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010?\u001a\u00020\u000bH\u00d6\u0001J\t\u0010@\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010'R\u0011\u0010\u000f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u0006A"}, d2 = {"Lcom/tencent/state/square/api/TaskItem;", "", "questId", "", "icon", "", "name", "desc", "questJumpTitle", ZPlanPublishSource.FROM_SCHEME, "currentCnt", "", "amount", "itemId", "itemIcon", "rewardItemCnt", "jumpType", "Lcom/tencent/state/square/api/JumpType;", "state", "Lcom/tencent/state/square/api/TaskState;", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIJLjava/lang/String;ILcom/tencent/state/square/api/JumpType;Lcom/tencent/state/square/api/TaskState;)V", "getAmount", "()I", "setAmount", "(I)V", "getCurrentCnt", "setCurrentCnt", "getDesc", "()Ljava/lang/String;", "getIcon", "getItemIcon", "getItemId", "()J", "getJumpType", "()Lcom/tencent/state/square/api/JumpType;", "getName", "getQuestId", "getQuestJumpTitle", "setQuestJumpTitle", "(Ljava/lang/String;)V", "getRewardItemCnt", "getScheme", "getState", "()Lcom/tencent/state/square/api/TaskState;", "setState", "(Lcom/tencent/state/square/api/TaskState;)V", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final /* data */ class TaskItem {
    private int amount;
    private int currentCnt;

    @NotNull
    private final String desc;

    @NotNull
    private final String icon;

    @NotNull
    private final String itemIcon;
    private final long itemId;

    @NotNull
    private final JumpType jumpType;

    @NotNull
    private final String name;
    private final long questId;

    @NotNull
    private String questJumpTitle;
    private final int rewardItemCnt;

    @NotNull
    private final String scheme;

    @NotNull
    private TaskState state;

    public TaskItem() {
        this(0L, null, null, null, null, null, 0, 0, 0L, null, 0, null, null, InitSkin.DRAWABLE_COUNT, null);
    }

    /* renamed from: component1, reason: from getter */
    public final long getQuestId() {
        return this.questId;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final String getItemIcon() {
        return this.itemIcon;
    }

    /* renamed from: component11, reason: from getter */
    public final int getRewardItemCnt() {
        return this.rewardItemCnt;
    }

    @NotNull
    /* renamed from: component12, reason: from getter */
    public final JumpType getJumpType() {
        return this.jumpType;
    }

    @NotNull
    /* renamed from: component13, reason: from getter */
    public final TaskState getState() {
        return this.state;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getQuestJumpTitle() {
        return this.questJumpTitle;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getScheme() {
        return this.scheme;
    }

    /* renamed from: component7, reason: from getter */
    public final int getCurrentCnt() {
        return this.currentCnt;
    }

    /* renamed from: component8, reason: from getter */
    public final int getAmount() {
        return this.amount;
    }

    /* renamed from: component9, reason: from getter */
    public final long getItemId() {
        return this.itemId;
    }

    @NotNull
    public final TaskItem copy(long questId, @NotNull String icon, @NotNull String name, @NotNull String desc, @NotNull String questJumpTitle, @NotNull String scheme, int currentCnt, int amount, long itemId, @NotNull String itemIcon, int rewardItemCnt, @NotNull JumpType jumpType, @NotNull TaskState state) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(questJumpTitle, "questJumpTitle");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(itemIcon, "itemIcon");
        Intrinsics.checkNotNullParameter(jumpType, "jumpType");
        Intrinsics.checkNotNullParameter(state, "state");
        return new TaskItem(questId, icon, name, desc, questJumpTitle, scheme, currentCnt, amount, itemId, itemIcon, rewardItemCnt, jumpType, state);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof TaskItem) {
                TaskItem taskItem = (TaskItem) other;
                if (this.questId != taskItem.questId || !Intrinsics.areEqual(this.icon, taskItem.icon) || !Intrinsics.areEqual(this.name, taskItem.name) || !Intrinsics.areEqual(this.desc, taskItem.desc) || !Intrinsics.areEqual(this.questJumpTitle, taskItem.questJumpTitle) || !Intrinsics.areEqual(this.scheme, taskItem.scheme) || this.currentCnt != taskItem.currentCnt || this.amount != taskItem.amount || this.itemId != taskItem.itemId || !Intrinsics.areEqual(this.itemIcon, taskItem.itemIcon) || this.rewardItemCnt != taskItem.rewardItemCnt || !Intrinsics.areEqual(this.jumpType, taskItem.jumpType) || !Intrinsics.areEqual(this.state, taskItem.state)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int getAmount() {
        return this.amount;
    }

    public final int getCurrentCnt() {
        return this.currentCnt;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    public final String getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getItemIcon() {
        return this.itemIcon;
    }

    public final long getItemId() {
        return this.itemId;
    }

    @NotNull
    public final JumpType getJumpType() {
        return this.jumpType;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final long getQuestId() {
        return this.questId;
    }

    @NotNull
    public final String getQuestJumpTitle() {
        return this.questJumpTitle;
    }

    public final int getRewardItemCnt() {
        return this.rewardItemCnt;
    }

    @NotNull
    public final String getScheme() {
        return this.scheme;
    }

    @NotNull
    public final TaskState getState() {
        return this.state;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int a16 = a.a(this.questId) * 31;
        String str = this.icon;
        int i28 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i29 = (a16 + i3) * 31;
        String str2 = this.name;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i36 = (i29 + i16) * 31;
        String str3 = this.desc;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i37 = (i36 + i17) * 31;
        String str4 = this.questJumpTitle;
        if (str4 != null) {
            i18 = str4.hashCode();
        } else {
            i18 = 0;
        }
        int i38 = (i37 + i18) * 31;
        String str5 = this.scheme;
        if (str5 != null) {
            i19 = str5.hashCode();
        } else {
            i19 = 0;
        }
        int a17 = (((((((i38 + i19) * 31) + this.currentCnt) * 31) + this.amount) * 31) + a.a(this.itemId)) * 31;
        String str6 = this.itemIcon;
        if (str6 != null) {
            i26 = str6.hashCode();
        } else {
            i26 = 0;
        }
        int i39 = (((a17 + i26) * 31) + this.rewardItemCnt) * 31;
        JumpType jumpType = this.jumpType;
        if (jumpType != null) {
            i27 = jumpType.hashCode();
        } else {
            i27 = 0;
        }
        int i46 = (i39 + i27) * 31;
        TaskState taskState = this.state;
        if (taskState != null) {
            i28 = taskState.hashCode();
        }
        return i46 + i28;
    }

    public final void setAmount(int i3) {
        this.amount = i3;
    }

    public final void setCurrentCnt(int i3) {
        this.currentCnt = i3;
    }

    public final void setQuestJumpTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.questJumpTitle = str;
    }

    public final void setState(@NotNull TaskState taskState) {
        Intrinsics.checkNotNullParameter(taskState, "<set-?>");
        this.state = taskState;
    }

    @NotNull
    public String toString() {
        return "TaskItem(questId=" + this.questId + ", icon=" + this.icon + ", name=" + this.name + ", desc=" + this.desc + ", questJumpTitle=" + this.questJumpTitle + ", scheme=" + this.scheme + ", currentCnt=" + this.currentCnt + ", amount=" + this.amount + ", itemId=" + this.itemId + ", itemIcon=" + this.itemIcon + ", rewardItemCnt=" + this.rewardItemCnt + ", jumpType=" + this.jumpType + ", state=" + this.state + ")";
    }

    public TaskItem(long j3, @NotNull String icon, @NotNull String name, @NotNull String desc, @NotNull String questJumpTitle, @NotNull String scheme, int i3, int i16, long j16, @NotNull String itemIcon, int i17, @NotNull JumpType jumpType, @NotNull TaskState state) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(questJumpTitle, "questJumpTitle");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(itemIcon, "itemIcon");
        Intrinsics.checkNotNullParameter(jumpType, "jumpType");
        Intrinsics.checkNotNullParameter(state, "state");
        this.questId = j3;
        this.icon = icon;
        this.name = name;
        this.desc = desc;
        this.questJumpTitle = questJumpTitle;
        this.scheme = scheme;
        this.currentCnt = i3;
        this.amount = i16;
        this.itemId = j16;
        this.itemIcon = itemIcon;
        this.rewardItemCnt = i17;
        this.jumpType = jumpType;
        this.state = state;
    }

    public /* synthetic */ TaskItem(long j3, String str, String str2, String str3, String str4, String str5, int i3, int i16, long j16, String str6, int i17, JumpType jumpType, TaskState taskState, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 0L : j3, (i18 & 2) != 0 ? "" : str, (i18 & 4) != 0 ? "" : str2, (i18 & 8) != 0 ? "" : str3, (i18 & 16) != 0 ? "" : str4, (i18 & 32) != 0 ? "" : str5, (i18 & 64) != 0 ? 0 : i3, (i18 & 128) != 0 ? 0 : i16, (i18 & 256) == 0 ? j16 : 0L, (i18 & 512) == 0 ? str6 : "", (i18 & 1024) == 0 ? i17 : 0, (i18 & 2048) != 0 ? JumpType.DISMISS : jumpType, (i18 & 4096) != 0 ? TaskState.TO_COMPLETE : taskState);
    }
}
