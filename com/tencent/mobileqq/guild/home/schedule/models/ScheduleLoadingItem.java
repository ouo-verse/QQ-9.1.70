package com.tencent.mobileqq.guild.home.schedule.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000e\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0013\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0018\u001a\u00020\b8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/models/e;", "Lcom/tencent/mobileqq/guild/home/schedule/models/d;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "I", "getType", "()I", "type", "c", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "d", "Z", "a", "()Z", "isToday", "<init>", "(ILjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.home.schedule.models.e, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class ScheduleLoadingItem implements d {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String text;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isToday;

    public ScheduleLoadingItem(int i3, @NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.type = i3;
        this.text = text;
    }

    @Override // com.tencent.mobileqq.guild.home.schedule.models.d
    /* renamed from: a, reason: from getter */
    public boolean getIsToday() {
        return this.isToday;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScheduleLoadingItem)) {
            return false;
        }
        ScheduleLoadingItem scheduleLoadingItem = (ScheduleLoadingItem) other;
        if (getType() == scheduleLoadingItem.getType() && Intrinsics.areEqual(getText(), scheduleLoadingItem.getText())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.home.schedule.models.d
    @NotNull
    public String getText() {
        return this.text;
    }

    @Override // com.tencent.mobileqq.guild.home.schedule.models.d
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return (getType() * 31) + getText().hashCode();
    }

    @NotNull
    public String toString() {
        return "ScheduleLoadingItem(type=" + getType() + ", text=" + getText() + ")";
    }
}
