package com.tencent.mobileqq.zplan.aio.panel.item;

import android.graphics.drawable.Drawable;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001f\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/item/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lkotlinx/coroutines/Deferred;", "Landroid/graphics/drawable/Drawable;", "a", "Lkotlinx/coroutines/Deferred;", "()Lkotlinx/coroutines/Deferred;", "drawableJob", "", "b", UserInfo.SEX_FEMALE, "c", "()F", "widthDp", "heightDp", "<init>", "(Lkotlinx/coroutines/Deferred;FF)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.aio.panel.item.a, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class Identifying {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final Deferred<Drawable> drawableJob;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final float widthDp;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final float heightDp;

    /* JADX WARN: Multi-variable type inference failed */
    public Identifying(Deferred<? extends Drawable> drawableJob, float f16, float f17) {
        Intrinsics.checkNotNullParameter(drawableJob, "drawableJob");
        this.drawableJob = drawableJob;
        this.widthDp = f16;
        this.heightDp = f17;
    }

    public final Deferred<Drawable> a() {
        return this.drawableJob;
    }

    /* renamed from: b, reason: from getter */
    public final float getHeightDp() {
        return this.heightDp;
    }

    /* renamed from: c, reason: from getter */
    public final float getWidthDp() {
        return this.widthDp;
    }

    public int hashCode() {
        return (((this.drawableJob.hashCode() * 31) + Float.floatToIntBits(this.widthDp)) * 31) + Float.floatToIntBits(this.heightDp);
    }

    public String toString() {
        return "Identifying(drawableJob=" + this.drawableJob + ", widthDp=" + this.widthDp + ", heightDp=" + this.heightDp + ")";
    }

    public /* synthetic */ Identifying(Deferred deferred, float f16, float f17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(deferred, (i3 & 2) != 0 ? 25.0f : f16, (i3 & 4) != 0 ? 13.0f : f17);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Identifying)) {
            return false;
        }
        Identifying identifying = (Identifying) other;
        return Intrinsics.areEqual(this.drawableJob, identifying.drawableJob) && Float.compare(this.widthDp, identifying.widthDp) == 0 && Float.compare(this.heightDp, identifying.heightDp) == 0;
    }
}
