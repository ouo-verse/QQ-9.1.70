package com.tencent.mobileqq.guild.base.extension;

import android.content.Context;
import androidx.recyclerview.widget.LinearSmoothScroller;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J0\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/base/extension/j;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateDtToFit", "c", "I", "getOffset", "()I", "offset", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
final class j extends LinearSmoothScroller {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int offset;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull Context context, int i3) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.offset = i3;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public int calculateDtToFit(int viewStart, int viewEnd, int boxStart, int boxEnd, int snapPreference) {
        return (boxStart - viewStart) + this.offset;
    }
}
