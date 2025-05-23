package com.qzone.reborn.feedx.scroller;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\n\u00a2\u0006\u0004\b\u001d\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J\u001a\u0010\t\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/feedx/scroller/n;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "", "getVerticalSnapPreference", "dx", "calculateTimeForScrolling", "Landroid/view/View;", "view", "snapPreference", "calculateDyToMakeVisible", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "d", "I", "getMScrollTime", "()I", "setMScrollTime", "(I)V", "mScrollTime", "e", "getMOffsetY", "a", "mOffsetY", "<init>", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class n extends LinearSmoothScroller {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Context context;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mScrollTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mOffsetY;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final void a(int i3) {
        this.mOffsetY = i3;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public int calculateDyToMakeVisible(View view, int snapPreference) {
        return super.calculateDyToMakeVisible(view, snapPreference) + this.mOffsetY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public int calculateTimeForScrolling(int dx5) {
        int i3 = this.mScrollTime;
        return i3 <= 0 ? super.calculateTimeForScrolling(dx5) : i3;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    protected int getVerticalSnapPreference() {
        return -1;
    }
}
