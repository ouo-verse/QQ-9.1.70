package com.tencent.mobileqq.zootopia.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0014R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaRankLoadingView;", "Landroid/widget/FrameLayout;", "", "text", "", "a", "b", "Landroid/view/View;", "changedView", "", "visibility", "onVisibilityChanged", "Lfi3/z;", "d", "Lfi3/z;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaRankLoadingView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final fi3.z binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaRankLoadingView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.binding.f399441c.setText(text);
        this.binding.f399441c.setVisibility(0);
        this.binding.f399442d.setVisibility(8);
        this.binding.f399440b.setVisibility(0);
        this.binding.f399442d.animate().rotation(1.0f).cancel();
    }

    public final void b() {
        this.binding.f399441c.setVisibility(8);
        this.binding.f399442d.setVisibility(0);
        this.binding.f399440b.setVisibility(8);
        ViewPropertyAnimator rotation = this.binding.f399442d.animate().rotation(RemoteMessageConst.MAX_TTL * 2.0f);
        rotation.setInterpolator(new LinearInterpolator());
        rotation.setDuration(3600 * 1000);
        rotation.start();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (!Intrinsics.areEqual(changedView, this) || visibility == 0) {
            return;
        }
        this.binding.f399442d.animate().rotation(1.0f).cancel();
    }

    public /* synthetic */ ZootopiaRankLoadingView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaRankLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        fi3.z g16 = fi3.z.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
    }
}
