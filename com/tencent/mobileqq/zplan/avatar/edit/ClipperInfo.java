package com.tencent.mobileqq.zplan.avatar.edit;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0012\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0013\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/edit/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "D", "c", "()D", "startX", "b", "d", "startY", "clipWidth", "clipHeight", "<init>", "(DDDD)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.avatar.edit.c, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class ClipperInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final double startX;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final double startY;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final double clipWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final double clipHeight;

    public ClipperInfo() {
        this(0.0d, 0.0d, 0.0d, 0.0d, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final double getClipHeight() {
        return this.clipHeight;
    }

    /* renamed from: b, reason: from getter */
    public final double getClipWidth() {
        return this.clipWidth;
    }

    /* renamed from: c, reason: from getter */
    public final double getStartX() {
        return this.startX;
    }

    /* renamed from: d, reason: from getter */
    public final double getStartY() {
        return this.startY;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClipperInfo)) {
            return false;
        }
        ClipperInfo clipperInfo = (ClipperInfo) other;
        if (Double.compare(this.startX, clipperInfo.startX) == 0 && Double.compare(this.startY, clipperInfo.startY) == 0 && Double.compare(this.clipWidth, clipperInfo.clipWidth) == 0 && Double.compare(this.clipHeight, clipperInfo.clipHeight) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((com.tencent.biz.qqcircle.comment.recpic.a.a(this.startX) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.startY)) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.clipWidth)) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.clipHeight);
    }

    @NotNull
    public String toString() {
        return "ClipperInfo(startX=" + this.startX + ", startY=" + this.startY + ", clipWidth=" + this.clipWidth + ", clipHeight=" + this.clipHeight + ')';
    }

    public ClipperInfo(double d16, double d17, double d18, double d19) {
        this.startX = d16;
        this.startY = d17;
        this.clipWidth = d18;
        this.clipHeight = d19;
    }

    public /* synthetic */ ClipperInfo(double d16, double d17, double d18, double d19, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0d : d16, (i3 & 2) != 0 ? 0.0d : d17, (i3 & 4) != 0 ? 0.0d : d18, (i3 & 8) == 0 ? d19 : 0.0d);
    }
}
