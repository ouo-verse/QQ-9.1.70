package com.tencent.mobileqq.guild.media.gift;

import android.animation.AnimatorSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\t\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/media/gift/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "d", "(I)V", "giftId", "Z", "c", "()Z", "e", "(Z)V", "needReStart", "Landroid/animation/AnimatorSet;", "Landroid/animation/AnimatorSet;", "()Landroid/animation/AnimatorSet;", "setAnimSet", "(Landroid/animation/AnimatorSet;)V", "animSet", "<init>", "(IZLandroid/animation/AnimatorSet;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.media.gift.k, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class ViewAnimBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int giftId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean needReStart;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private AnimatorSet animSet;

    public ViewAnimBean(int i3, boolean z16, @NotNull AnimatorSet animSet) {
        Intrinsics.checkNotNullParameter(animSet, "animSet");
        this.giftId = i3;
        this.needReStart = z16;
        this.animSet = animSet;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final AnimatorSet getAnimSet() {
        return this.animSet;
    }

    /* renamed from: b, reason: from getter */
    public final int getGiftId() {
        return this.giftId;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getNeedReStart() {
        return this.needReStart;
    }

    public final void d(int i3) {
        this.giftId = i3;
    }

    public final void e(boolean z16) {
        this.needReStart = z16;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewAnimBean)) {
            return false;
        }
        ViewAnimBean viewAnimBean = (ViewAnimBean) other;
        if (this.giftId == viewAnimBean.giftId && this.needReStart == viewAnimBean.needReStart && Intrinsics.areEqual(this.animSet, viewAnimBean.animSet)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = this.giftId * 31;
        boolean z16 = this.needReStart;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return ((i3 + i16) * 31) + this.animSet.hashCode();
    }

    @NotNull
    public String toString() {
        return "ViewAnimBean(giftId=" + this.giftId + ", needReStart=" + this.needReStart + ", animSet=" + this.animSet + ")";
    }
}
