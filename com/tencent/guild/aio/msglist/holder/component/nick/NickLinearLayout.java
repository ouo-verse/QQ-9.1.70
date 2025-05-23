package com.tencent.guild.aio.msglist.holder.component.nick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013B\u0019\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0012\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0014R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/nick/NickLinearLayout;", "Landroid/widget/LinearLayout;", "", "size", "", "setExtraWidth", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "d", "I", "getExtraWidthSize", "()I", "setExtraWidthSize", "(I)V", "extraWidthSize", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class NickLinearLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int extraWidthSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NickLinearLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0071  */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        boolean z16;
        boolean z17;
        TextView textView;
        LinearLayout.LayoutParams layoutParams;
        if (getOrientation() == 0) {
            int i3 = this.extraWidthSize;
            int childCount = getChildCount();
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            int i16 = 0;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 0);
            TextView textView2 = null;
            int i17 = i3;
            boolean z18 = false;
            int i18 = 0;
            while (true) {
                z16 = true;
                if (i18 >= childCount || z18) {
                    break;
                }
                View childAt = getChildAt(i18);
                if (childAt != null && childAt.getVisibility() != 8) {
                    if (childAt instanceof TextView) {
                        TextView textView3 = (TextView) childAt;
                        if (textView3.getEllipsize() != null) {
                            if (textView2 == null) {
                                textView3.setMaxWidth(Integer.MAX_VALUE);
                                z17 = z18;
                                textView = textView3;
                            } else {
                                textView = textView2;
                                z17 = true;
                            }
                            measureChildWithMargins(childAt, makeMeasureSpec, 0, heightMeasureSpec, 0);
                            ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                            layoutParams = (LinearLayout.LayoutParams) layoutParams2;
                            if (layoutParams.weight <= 0.0f) {
                                z16 = false;
                            }
                            i17 += childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
                            z18 = z17 | z16;
                            textView2 = textView;
                        }
                    }
                    z17 = z18;
                    textView = textView2;
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, heightMeasureSpec, 0);
                    ViewGroup.LayoutParams layoutParams22 = childAt.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams22, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    layoutParams = (LinearLayout.LayoutParams) layoutParams22;
                    if (layoutParams.weight <= 0.0f) {
                    }
                    i17 += childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
                    z18 = z17 | z16;
                    textView2 = textView;
                }
                i18++;
            }
            if (textView2 != null && i17 != 0) {
                z16 = false;
            }
            if (!(z18 | z16) && i17 > size) {
                Intrinsics.checkNotNull(textView2);
                int measuredWidth = textView2.getMeasuredWidth() - (i17 - size);
                if (measuredWidth >= 0) {
                    i16 = measuredWidth;
                }
                textView2.setMaxWidth(i16);
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public final void setExtraWidth(int size) {
        this.extraWidthSize = size;
    }

    public final void setExtraWidthSize(int i3) {
        this.extraWidthSize = i3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NickLinearLayout(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
    }
}
