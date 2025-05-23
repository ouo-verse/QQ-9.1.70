package com.tencent.mobileqq.guild.home.schedule.models;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u001a\u0010\u0010\u001a\u00020\u00048\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\fR\u001a\u0010\u0015\u001a\u00020\u00028\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001a\u001a\u00020\b8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/models/c;", "Lcom/tencent/mobileqq/guild/home/schedule/models/d;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "I", "()I", "result", "c", "getType", "type", "d", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "e", "Z", "a", "()Z", "isToday", "<init>", "(I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.home.schedule.models.c, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class ErrorItem implements d {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int result;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int type = 6;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String text = "Error";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isToday;

    public ErrorItem(int i3) {
        this.result = i3;
    }

    @Override // com.tencent.mobileqq.guild.home.schedule.models.d
    /* renamed from: a, reason: from getter */
    public boolean getIsToday() {
        return this.isToday;
    }

    /* renamed from: b, reason: from getter */
    public final int getResult() {
        return this.result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof ErrorItem) && this.result == ((ErrorItem) other).result) {
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
        return this.result;
    }

    @NotNull
    public String toString() {
        return "ErrorItem(result=" + this.result + ")";
    }
}
