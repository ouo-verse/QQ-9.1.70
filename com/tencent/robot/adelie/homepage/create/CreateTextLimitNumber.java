package com.tencent.robot.adelie.homepage.create;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/al;", "", "", "toString", "", "hashCode", "other", "", "equals", "name", "I", "b", "()I", "desc", "a", "prompt", "c", "welcomeMsg", "d", "<init>", "(IIII)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.adelie.homepage.create.al, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class CreateTextLimitNumber {

    @SerializedName("desc")
    private final int desc;

    @SerializedName("name")
    private final int name;

    @SerializedName("prompt")
    private final int prompt;

    @SerializedName("welcomeMsg")
    private final int welcomeMsg;

    public CreateTextLimitNumber() {
        this(0, 0, 0, 0, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getDesc() {
        return this.desc;
    }

    /* renamed from: b, reason: from getter */
    public final int getName() {
        return this.name;
    }

    /* renamed from: c, reason: from getter */
    public final int getPrompt() {
        return this.prompt;
    }

    /* renamed from: d, reason: from getter */
    public final int getWelcomeMsg() {
        return this.welcomeMsg;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateTextLimitNumber)) {
            return false;
        }
        CreateTextLimitNumber createTextLimitNumber = (CreateTextLimitNumber) other;
        if (this.name == createTextLimitNumber.name && this.desc == createTextLimitNumber.desc && this.prompt == createTextLimitNumber.prompt && this.welcomeMsg == createTextLimitNumber.welcomeMsg) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.name * 31) + this.desc) * 31) + this.prompt) * 31) + this.welcomeMsg;
    }

    @NotNull
    public String toString() {
        return "CreateTextLimitNumber(name=" + this.name + ", desc=" + this.desc + ", prompt=" + this.prompt + ", welcomeMsg=" + this.welcomeMsg + ")";
    }

    public CreateTextLimitNumber(int i3, int i16, int i17, int i18) {
        this.name = i3;
        this.desc = i16;
        this.prompt = i17;
        this.welcomeMsg = i18;
    }

    public /* synthetic */ CreateTextLimitNumber(int i3, int i16, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? 10 : i3, (i19 & 2) != 0 ? 150 : i16, (i19 & 4) != 0 ? 10000 : i17, (i19 & 8) != 0 ? 150 : i18);
    }
}
