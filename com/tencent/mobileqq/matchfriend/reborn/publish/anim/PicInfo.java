package com.tencent.mobileqq.matchfriend.reborn.publish.anim;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/m;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/view/View;", "a", "Landroid/view/View;", "c", "()Landroid/view/View;", "startImageView", "b", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "imageHeight", "imageWidth", "<init>", "(Landroid/view/View;Ljava/lang/Integer;Ljava/lang/Integer;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.matchfriend.reborn.publish.anim.m, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class PicInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final View startImageView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final Integer imageHeight;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final Integer imageWidth;

    public PicInfo() {
        this(null, null, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final Integer getImageHeight() {
        return this.imageHeight;
    }

    /* renamed from: b, reason: from getter */
    public final Integer getImageWidth() {
        return this.imageWidth;
    }

    /* renamed from: c, reason: from getter */
    public final View getStartImageView() {
        return this.startImageView;
    }

    public int hashCode() {
        View view = this.startImageView;
        int hashCode = (view == null ? 0 : view.hashCode()) * 31;
        Integer num = this.imageHeight;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.imageWidth;
        return hashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "PicInfo(startImageView=" + this.startImageView + ", imageHeight=" + this.imageHeight + ", imageWidth=" + this.imageWidth + ")";
    }

    public PicInfo(View view, Integer num, Integer num2) {
        this.startImageView = view;
        this.imageHeight = num;
        this.imageWidth = num2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PicInfo)) {
            return false;
        }
        PicInfo picInfo = (PicInfo) other;
        return Intrinsics.areEqual(this.startImageView, picInfo.startImageView) && Intrinsics.areEqual(this.imageHeight, picInfo.imageHeight) && Intrinsics.areEqual(this.imageWidth, picInfo.imageWidth);
    }

    public /* synthetic */ PicInfo(View view, Integer num, Integer num2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : view, (i3 & 2) != 0 ? 0 : num, (i3 & 4) != 0 ? 0 : num2);
    }
}
