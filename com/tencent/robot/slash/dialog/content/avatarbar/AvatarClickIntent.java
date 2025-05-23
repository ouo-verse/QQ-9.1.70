package com.tencent.robot.slash.dialog.content.avatarbar;

import com.tencent.robot.slash.dialog.content.avatarbar.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/avatarbar/d;", "Lol3/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "avatarPosition", "Lcom/tencent/robot/slash/dialog/content/avatarbar/b$c;", "e", "Lcom/tencent/robot/slash/dialog/content/avatarbar/b$c;", "b", "()Lcom/tencent/robot/slash/dialog/content/avatarbar/b$c;", "uiData", "<init>", "(ILcom/tencent/robot/slash/dialog/content/avatarbar/b$c;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.slash.dialog.content.avatarbar.d, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class AvatarClickIntent implements ol3.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int avatarPosition;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final b.UIModelData uiData;

    public AvatarClickIntent(int i3, @NotNull b.UIModelData uiData) {
        Intrinsics.checkNotNullParameter(uiData, "uiData");
        this.avatarPosition = i3;
        this.uiData = uiData;
    }

    /* renamed from: a, reason: from getter */
    public final int getAvatarPosition() {
        return this.avatarPosition;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final b.UIModelData getUiData() {
        return this.uiData;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AvatarClickIntent)) {
            return false;
        }
        AvatarClickIntent avatarClickIntent = (AvatarClickIntent) other;
        if (this.avatarPosition == avatarClickIntent.avatarPosition && Intrinsics.areEqual(this.uiData, avatarClickIntent.uiData)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.avatarPosition * 31) + this.uiData.hashCode();
    }

    @NotNull
    public String toString() {
        return "AvatarClickIntent(avatarPosition=" + this.avatarPosition + ", uiData=" + this.uiData + ")";
    }
}
