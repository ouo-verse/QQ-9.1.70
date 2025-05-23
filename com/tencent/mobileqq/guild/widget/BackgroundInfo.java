package com.tencent.mobileqq.guild.widget;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "()F", "cornerRadius", "b", "I", "c", "()I", "strokeColor", "solidColor", "<init>", "(FII)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.widget.a, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class BackgroundInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final float cornerRadius;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int strokeColor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int solidColor;

    public BackgroundInfo(float f16, int i3, int i16) {
        this.cornerRadius = f16;
        this.strokeColor = i3;
        this.solidColor = i16;
    }

    /* renamed from: a, reason: from getter */
    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    /* renamed from: b, reason: from getter */
    public final int getSolidColor() {
        return this.solidColor;
    }

    /* renamed from: c, reason: from getter */
    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BackgroundInfo)) {
            return false;
        }
        BackgroundInfo backgroundInfo = (BackgroundInfo) other;
        if (Float.compare(this.cornerRadius, backgroundInfo.cornerRadius) == 0 && this.strokeColor == backgroundInfo.strokeColor && this.solidColor == backgroundInfo.solidColor) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.cornerRadius) * 31) + this.strokeColor) * 31) + this.solidColor;
    }

    @NotNull
    public String toString() {
        return "BackgroundInfo(cornerRadius=" + this.cornerRadius + ", strokeColor=" + this.strokeColor + ", solidColor=" + this.solidColor + ")";
    }
}
