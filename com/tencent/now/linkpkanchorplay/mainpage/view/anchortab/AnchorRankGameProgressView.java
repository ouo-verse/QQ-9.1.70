package com.tencent.now.linkpkanchorplay.mainpage.view.anchortab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.component.appx.utils.AppUtils;
import com.tencent.misc.utils.b;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u001d\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/mainpage/view/anchortab/AnchorRankGameProgressView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "z0", "", "rankValue", "progressWidth", "totalWidth", "", "A0", "rankMaxValue", "setProgressValue", "Landroid/view/View;", "d", "Landroid/view/View;", "rankGradeProgressView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "cursorValueView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "f", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class AnchorRankGameProgressView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View rankGradeProgressView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView cursorValueView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorRankGameProgressView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A0(long rankValue, int progressWidth, int totalWidth) {
        float measureText = this.cursorValueView.getPaint().measureText(String.valueOf(rankValue));
        int dip2px = AppUtils.UI.dip2px(12.0f);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.topToBottom = R.id.ucj;
        float paddingLeft = ((measureText + this.cursorValueView.getPaddingLeft()) + this.cursorValueView.getPaddingRight()) / 2;
        if (progressWidth + dip2px < paddingLeft) {
            layoutParams.leftToLeft = 0;
        } else if ((totalWidth - progressWidth) + dip2px < paddingLeft) {
            layoutParams.rightToRight = 0;
        } else {
            layoutParams.leftToLeft = R.id.ucj;
            layoutParams.rightToRight = R.id.ucj;
        }
        this.cursorValueView.setLayoutParams(layoutParams);
    }

    private final int z0() {
        return AppUtils.UI.getScreenMetrics().widthPixels - AppUtils.UI.dip2px(132.0f);
    }

    public final void setProgressValue(long rankValue, long rankMaxValue) {
        int z06 = z0();
        int i3 = (int) (((((float) rankValue) * 1.0f) / ((float) rankMaxValue)) * z06);
        if (i3 <= 0) {
            i3 = 1;
        }
        this.rankGradeProgressView.getLayoutParams().width = i3;
        this.cursorValueView.setText(String.valueOf(rankValue));
        A0(rankValue, i3, z06);
    }

    public /* synthetic */ AnchorRankGameProgressView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorRankGameProgressView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.dx8, this);
        View findViewById = findViewById(R.id.f70223kv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.rank_grade_progress_view)");
        this.rankGradeProgressView = findViewById;
        View findViewById2 = findViewById(R.id.ucm);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.cursor_value)");
        TextView textView = (TextView) findViewById2;
        this.cursorValueView = textView;
        b.b(textView);
    }
}
