package com.tencent.now.linkpkanchorplay.guide;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqlive.utils.q;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0005B\u001d\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/guide/ViewPagerDotView;", "Landroid/widget/FrameLayout;", "", "dotSize", "", "a", "position", "b", "d", "I", "curIndex", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "e", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class ViewPagerDotView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int curIndex;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ViewPagerDotView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a(int dotSize) {
        for (int i3 = 0; i3 < dotSize; i3++) {
            TextView textView = new TextView(getContext());
            textView.setWidth(q.a(textView.getContext(), 6.0f));
            textView.setHeight(q.a(textView.getContext(), 6.0f));
            textView.setBackground(textView.getContext().getDrawable(R.drawable.f161970l40));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (i3 > 0) {
                layoutParams.leftMargin = q.a(getContext(), 12.0f);
            }
            addView(textView, layoutParams);
        }
        b(this.curIndex);
    }

    public final void b(int position) {
        getChildAt(position).setBackground(getContext().getDrawable(R.drawable.l3z));
        int i3 = this.curIndex;
        if (i3 == position) {
            return;
        }
        getChildAt(i3).setBackground(getContext().getDrawable(R.drawable.f161970l40));
        this.curIndex = position;
    }

    public /* synthetic */ ViewPagerDotView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ViewPagerDotView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
