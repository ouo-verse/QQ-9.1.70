package com.tencent.state.square.guide;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u0007H\u00d6\u0001J\b\u0010\u001f\u001a\u00020\u0005H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011\u00a8\u0006 "}, d2 = {"Lcom/tencent/state/square/guide/CreateRoleRedDotBubbleConfig;", "", "isLimitFreq", "", "bubbleText", "", "bubbleDisplayTime", "", "jumpSchema", "(ZLjava/lang/String;ILjava/lang/String;)V", "getBubbleDisplayTime", "()I", "setBubbleDisplayTime", "(I)V", "getBubbleText", "()Ljava/lang/String;", "setBubbleText", "(Ljava/lang/String;)V", "()Z", "setLimitFreq", "(Z)V", "getJumpSchema", "setJumpSchema", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class CreateRoleRedDotBubbleConfig {
    private int bubbleDisplayTime;
    private String bubbleText;
    private boolean isLimitFreq;
    private String jumpSchema;

    public CreateRoleRedDotBubbleConfig() {
        this(false, null, 0, null, 15, null);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsLimitFreq() {
        return this.isLimitFreq;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBubbleText() {
        return this.bubbleText;
    }

    /* renamed from: component3, reason: from getter */
    public final int getBubbleDisplayTime() {
        return this.bubbleDisplayTime;
    }

    /* renamed from: component4, reason: from getter */
    public final String getJumpSchema() {
        return this.jumpSchema;
    }

    public final CreateRoleRedDotBubbleConfig copy(boolean isLimitFreq, String bubbleText, int bubbleDisplayTime, String jumpSchema) {
        Intrinsics.checkNotNullParameter(bubbleText, "bubbleText");
        Intrinsics.checkNotNullParameter(jumpSchema, "jumpSchema");
        return new CreateRoleRedDotBubbleConfig(isLimitFreq, bubbleText, bubbleDisplayTime, jumpSchema);
    }

    public final int getBubbleDisplayTime() {
        return this.bubbleDisplayTime;
    }

    public final String getBubbleText() {
        return this.bubbleText;
    }

    public final String getJumpSchema() {
        return this.jumpSchema;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z16 = this.isLimitFreq;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        String str = this.bubbleText;
        int hashCode = (((i3 + (str != null ? str.hashCode() : 0)) * 31) + this.bubbleDisplayTime) * 31;
        String str2 = this.jumpSchema;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final boolean isLimitFreq() {
        return this.isLimitFreq;
    }

    public final void setBubbleDisplayTime(int i3) {
        this.bubbleDisplayTime = i3;
    }

    public final void setBubbleText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bubbleText = str;
    }

    public final void setJumpSchema(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jumpSchema = str;
    }

    public final void setLimitFreq(boolean z16) {
        this.isLimitFreq = z16;
    }

    public String toString() {
        return '{' + this.isLimitFreq + ", " + this.bubbleText + ", " + this.bubbleDisplayTime + ", " + this.jumpSchema + '}';
    }

    public CreateRoleRedDotBubbleConfig(boolean z16, String bubbleText, int i3, String jumpSchema) {
        Intrinsics.checkNotNullParameter(bubbleText, "bubbleText");
        Intrinsics.checkNotNullParameter(jumpSchema, "jumpSchema");
        this.isLimitFreq = z16;
        this.bubbleText = bubbleText;
        this.bubbleDisplayTime = i3;
        this.jumpSchema = jumpSchema;
    }

    public /* synthetic */ CreateRoleRedDotBubbleConfig(boolean z16, String str, int i3, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? false : z16, (i16 & 2) != 0 ? "\u6253\u626e\u4e0b\u81ea\u5df1\uff0c\u548c\u670b\u53cb\u4eec\u4e00\u8d77\u73a9\u5427!" : str, (i16 & 4) != 0 ? 3 : i3, (i16 & 8) != 0 ? "" : str2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateRoleRedDotBubbleConfig)) {
            return false;
        }
        CreateRoleRedDotBubbleConfig createRoleRedDotBubbleConfig = (CreateRoleRedDotBubbleConfig) other;
        return this.isLimitFreq == createRoleRedDotBubbleConfig.isLimitFreq && Intrinsics.areEqual(this.bubbleText, createRoleRedDotBubbleConfig.bubbleText) && this.bubbleDisplayTime == createRoleRedDotBubbleConfig.bubbleDisplayTime && Intrinsics.areEqual(this.jumpSchema, createRoleRedDotBubbleConfig.jumpSchema);
    }

    public static /* synthetic */ CreateRoleRedDotBubbleConfig copy$default(CreateRoleRedDotBubbleConfig createRoleRedDotBubbleConfig, boolean z16, String str, int i3, String str2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            z16 = createRoleRedDotBubbleConfig.isLimitFreq;
        }
        if ((i16 & 2) != 0) {
            str = createRoleRedDotBubbleConfig.bubbleText;
        }
        if ((i16 & 4) != 0) {
            i3 = createRoleRedDotBubbleConfig.bubbleDisplayTime;
        }
        if ((i16 & 8) != 0) {
            str2 = createRoleRedDotBubbleConfig.jumpSchema;
        }
        return createRoleRedDotBubbleConfig.copy(z16, str, i3, str2);
    }
}
