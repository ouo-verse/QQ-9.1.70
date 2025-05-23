package com.tencent.now.linkpkanchorplay.mainpage.view.anchortab;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.misc.utils.b;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import em3.a;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/mainpage/view/anchortab/LabelTextView;", "Landroid/widget/LinearLayout;", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "a", "", "label", "value", "setTextInfo", "", NodeProps.MARGIN_TOP, "setTextLabelTopMargin", "", "textSize", "setTextInfoTextSize", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "textValue", "e", "textLabel", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class LabelTextView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView textValue;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView textLabel;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LabelTextView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a(AttributeSet attrs) {
        LayoutInflater.from(getContext()).inflate(R.layout.fdm, this);
        View findViewById = findViewById(R.id.f95835g2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<TextView>(R.id.text_value)");
        this.textValue = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.f95485f4);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<TextView>(R.id.text_label)");
        this.textLabel = (TextView) findViewById2;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, a.f396677i2);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026.styleable.LabelTextView)");
        String string = obtainStyledAttributes.getString(a.f396685j2);
        TextView textView = null;
        if (string != null) {
            TextView textView2 = this.textLabel;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textLabel");
                textView2 = null;
            }
            textView2.setText(string);
        }
        obtainStyledAttributes.recycle();
        TextView textView3 = this.textValue;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textValue");
        } else {
            textView = textView3;
        }
        b.b(textView);
    }

    public final void setTextInfo(@NotNull String label, @NotNull String value) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(value, "value");
        TextView textView = this.textLabel;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textLabel");
            textView = null;
        }
        textView.setText(label);
        TextView textView3 = this.textValue;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textValue");
        } else {
            textView2 = textView3;
        }
        textView2.setText(value);
    }

    public final void setTextInfoTextSize(float textSize) {
        TextView textView = this.textValue;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textValue");
            textView = null;
        }
        textView.setTextSize(textSize);
    }

    public final void setTextLabelTopMargin(int marginTop) {
        TextView textView = this.textLabel;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textLabel");
            textView = null;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = marginTop;
        TextView textView3 = this.textLabel;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textLabel");
        } else {
            textView2 = textView3;
        }
        textView2.setLayoutParams(layoutParams2);
    }

    public /* synthetic */ LabelTextView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LabelTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        a(attributeSet);
    }

    public final void setTextInfo(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        TextView textView = this.textValue;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textValue");
            textView = null;
        }
        textView.setText(value);
    }
}
