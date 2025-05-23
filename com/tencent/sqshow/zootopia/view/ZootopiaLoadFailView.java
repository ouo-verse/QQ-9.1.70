package com.tencent.sqshow.zootopia.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n74.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/sqshow/zootopia/view/ZootopiaLoadFailView;", "Landroid/widget/RelativeLayout;", "", "b", "c", "Ln74/e;", "d", "Ln74/e;", "binding", "Landroid/widget/Button;", "e", "Landroid/widget/Button;", "a", "()Landroid/widget/Button;", "btnNetworkError", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZootopiaLoadFailView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final e binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Button btnNetworkError;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaLoadFailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        e f16 = e.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context),this)");
        this.binding = f16;
        Button button = f16.f419330b;
        Intrinsics.checkNotNullExpressionValue(button, "binding.btnNetworkError");
        this.btnNetworkError = button;
    }

    /* renamed from: a, reason: from getter */
    public final Button getBtnNetworkError() {
        return this.btnNetworkError;
    }

    public final void b() {
        this.binding.f419331c.setImageResource(R.drawable.ikk);
        this.binding.f419332d.setText("\u529f\u80fd\u5185\u6d4b\u4e2d\uff0c\u656c\u8bf7\u671f\u5f85");
        this.binding.f419330b.setVisibility(8);
    }

    public final void c() {
        this.binding.f419331c.setImageResource(R.drawable.ibt);
        this.binding.f419332d.setText("\u54ce\u5440\uff0c\u51fa\u9519\u5566\uff01\u8bf7\u70b9\u51fb\u91cd\u8bd5~");
        this.binding.f419330b.setVisibility(0);
    }
}
