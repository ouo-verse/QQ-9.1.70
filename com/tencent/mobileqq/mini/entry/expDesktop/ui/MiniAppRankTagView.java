package com.tencent.mobileqq.mini.entry.expDesktop.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/MiniAppRankTagView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attributes", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "contentTextView", "Landroid/widget/TextView;", "dp4", "", "dp8", "sp12", "", "updateContent", "", "content", "", "updateType", "fillColor", "Landroid/content/res/ColorStateList;", "textColor", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppRankTagView extends RelativeLayout {
    private TextView contentTextView;
    private final int dp4;
    private final int dp8;
    private final float sp12;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniAppRankTagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        int c16 = com.tencent.biz.qui.quicommon.e.c(4.0f);
        this.dp4 = c16;
        int c17 = com.tencent.biz.qui.quicommon.e.c(8.0f);
        this.dp8 = c17;
        this.sp12 = 12.0f;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(15);
        TextView textView = new TextView(context);
        this.contentTextView = textView;
        textView.setMaxLines(1);
        this.contentTextView.setEllipsize(TextUtils.TruncateAt.END);
        linearLayout.addView(this.contentTextView, new ViewGroup.LayoutParams(-2, -2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(linearLayout, layoutParams);
        setPadding(c17, c16, c17, c16);
        this.contentTextView.setTextSize(12.0f);
        setClickable(false);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.ui.d
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean _init_$lambda$0;
                _init_$lambda$0 = MiniAppRankTagView._init_$lambda$0(MiniAppRankTagView.this, view, motionEvent);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(MiniAppRankTagView this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isClickable()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            view.setAlpha(0.5f);
        } else if (action == 1 || action == 3) {
            view.setAlpha(1.0f);
        }
        return false;
    }

    public final void updateContent(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.contentTextView.setText(content);
    }

    public final void updateType(ColorStateList fillColor, ColorStateList textColor) {
        Intrinsics.checkNotNullParameter(fillColor, "fillColor");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(fillColor);
        gradientDrawable.setCornerRadius(com.tencent.biz.qui.quicommon.e.c(6.0f));
        setBackground(gradientDrawable);
        this.contentTextView.setTextColor(textColor);
    }

    public /* synthetic */ MiniAppRankTagView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }
}
