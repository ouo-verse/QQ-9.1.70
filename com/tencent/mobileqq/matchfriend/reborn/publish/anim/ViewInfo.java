package com.tencent.mobileqq.matchfriend.reborn.publish.anim;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0011\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\n\u0010\u0016\"\u0004\b\u001a\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/p;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "c", "()F", "g", "(F)V", HippyTKDListViewAdapter.X, "b", "d", tl.h.F, "y", "I", "()I", "f", "(I)V", "width", "e", "height", "<init>", "(FFII)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.matchfriend.reborn.publish.anim.p, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class ViewInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private float x;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private float y;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int width;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int height;

    public ViewInfo() {
        this(0.0f, 0.0f, 0, 0, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: b, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: c, reason: from getter */
    public final float getX() {
        return this.x;
    }

    /* renamed from: d, reason: from getter */
    public final float getY() {
        return this.y;
    }

    public final void e(int i3) {
        this.height = i3;
    }

    public final void f(int i3) {
        this.width = i3;
    }

    public final void g(float f16) {
        this.x = f16;
    }

    public final void h(float f16) {
        this.y = f16;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y)) * 31) + this.width) * 31) + this.height;
    }

    public String toString() {
        return "ViewInfo(x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public ViewInfo(float f16, float f17, int i3, int i16) {
        this.x = f16;
        this.y = f17;
        this.width = i3;
        this.height = i16;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewInfo)) {
            return false;
        }
        ViewInfo viewInfo = (ViewInfo) other;
        return Float.compare(this.x, viewInfo.x) == 0 && Float.compare(this.y, viewInfo.y) == 0 && this.width == viewInfo.width && this.height == viewInfo.height;
    }

    public /* synthetic */ ViewInfo(float f16, float f17, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0.0f : f16, (i17 & 2) != 0 ? 0.0f : f17, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }
}
