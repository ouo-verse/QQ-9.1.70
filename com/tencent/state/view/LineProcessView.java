package com.tencent.state.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.state.view.ProgressDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/view/LineProcessView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "progressDrawable", "Lcom/tencent/state/view/ProgressDrawable;", "setProcess", "", "value", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class LineProcessView extends LinearLayout {
    private static final String TAG = "LineProcessView";
    private ProgressDrawable progressDrawable;

    public LineProcessView(Context context) {
        this(context, null, 0, 6, null);
    }

    public final void setProcess(float value) {
        ProgressDrawable progressDrawable = this.progressDrawable;
        if (progressDrawable != null) {
            if (value > 1.0f) {
                value = 1.0f;
            }
            progressDrawable.setProgress(value);
        }
    }

    public LineProcessView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ LineProcessView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LineProcessView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        ProgressDrawable progressDrawable = new ProgressDrawable(ProgressDrawableStyle.RECT);
        this.progressDrawable = progressDrawable;
        progressDrawable.setNeedRadius(true);
        ProgressDrawable progressDrawable2 = this.progressDrawable;
        if (progressDrawable2 != null) {
            progressDrawable2.setProgressType(ProgressDrawable.ProgressType.COUNT);
        }
        setBackground(this.progressDrawable);
    }
}
