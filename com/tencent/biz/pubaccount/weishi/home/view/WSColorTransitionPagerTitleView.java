package com.tencent.biz.pubaccount.weishi.home.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import e00.a;
import e00.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J(\u0010\r\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J(\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\"\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/home/view/WSColorTransitionPagerTitleView;", "Landroid/widget/TextView;", "Le00/a;", "", "index", "totalCount", "", "c", "a", "", "leavePercent", "", "leftToRight", "d", "enterPercent", "b", "I", "f", "()I", "setSelectedColor", "(I)V", "selectedColor", "e", "setNormalColor", "normalColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSColorTransitionPagerTitleView extends TextView implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int selectedColor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int normalColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WSColorTransitionPagerTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // e00.a
    public void a(int index, int totalCount) {
        setTextColor(this.normalColor);
    }

    @Override // e00.a
    public void b(int index, int totalCount, float enterPercent, boolean leftToRight) {
        setTextColor(b.a(enterPercent, this.normalColor, this.selectedColor));
    }

    @Override // e00.a
    public void c(int index, int totalCount) {
        setTextColor(this.selectedColor);
    }

    @Override // e00.a
    public void d(int index, int totalCount, float leavePercent, boolean leftToRight) {
        setTextColor(b.a(leavePercent, this.selectedColor, this.normalColor));
    }

    /* renamed from: e, reason: from getter */
    public final int getNormalColor() {
        return this.normalColor;
    }

    /* renamed from: f, reason: from getter */
    public final int getSelectedColor() {
        return this.selectedColor;
    }

    public final void setNormalColor(int i3) {
        this.normalColor = i3;
    }

    public final void setSelectedColor(int i3) {
        this.selectedColor = i3;
    }
}
