package com.tencent.mobileqq.zplan.aigc.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0003\u001f\f B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/view/CustomRadioButtonGroup;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mobileqq/zplan/aigc/view/CustomRadioButtonGroup$b;", "button", "", "d", "", "iconResId", "", "text", "", "isDefaultSelected", "b", "Lcom/tencent/mobileqq/zplan/aigc/view/CustomRadioButtonGroup$c;", "callback", "setSelectCallback", "Lcom/tencent/mobileqq/zplan/aigc/view/CustomRadioButtonGroup$b;", "selectedButton", "e", "Lcom/tencent/mobileqq/zplan/aigc/view/CustomRadioButtonGroup$c;", "selectCallback", "f", "I", "size", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", h.F, "a", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class CustomRadioButtonGroup extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private b selectedButton;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private c selectCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int size;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/view/CustomRadioButtonGroup$c;", "", "", "index", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface c {
        void a(int index);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomRadioButtonGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        setOrientation(1);
        setBackgroundResource(R.drawable.h1x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(CustomRadioButtonGroup this$0, b button, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(button, "$button");
        this$0.d(button);
    }

    private final void d(b button) {
        b bVar = this.selectedButton;
        if (bVar != null && bVar != null) {
            bVar.setSelected(false);
        }
        button.setSelected(true);
        c cVar = this.selectCallback;
        if (cVar != null) {
            cVar.a(button.getIndex());
        }
        this.selectedButton = button;
    }

    public final void b(int iconResId, String text, boolean isDefaultSelected) {
        Intrinsics.checkNotNullParameter(text, "text");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int i3 = this.size;
        this.size = i3 + 1;
        final b bVar = new b(context, i3, isDefaultSelected);
        bVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        bVar.b(iconResId);
        bVar.c(text);
        bVar.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomRadioButtonGroup.c(CustomRadioButtonGroup.this, bVar, view);
            }
        });
        if (isDefaultSelected) {
            this.selectedButton = bVar;
        }
        addView(bVar);
    }

    public final void setSelectCallback(c callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.selectCallback = callback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/view/CustomRadioButtonGroup$b;", "Landroid/widget/LinearLayout;", "", "iconResId", "", "b", "", "text", "c", "", "selected", "setSelected", "d", "I", "a", "()I", "index", "e", "Z", "isDefaultSelected", "()Z", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "iconImageView", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "textView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;IZ)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends LinearLayout {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int index;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isDefaultSelected;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final ImageView iconImageView;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final TextView textView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context, int i3, boolean z16) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            this.index = i3;
            this.isDefaultSelected = z16;
            setOrientation(1);
            setGravity(16);
            setBackgroundResource(z16 ? R.drawable.h1t : R.drawable.h1u);
            setSelected(z16);
            ImageView imageView = new ImageView(context);
            this.iconImageView = imageView;
            imageView.setLayoutParams(new LinearLayout.LayoutParams(50, 50));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams).gravity = 1;
            ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams2).bottomMargin = 5;
            addView(imageView);
            TextView textView = new TextView(context);
            this.textView = textView;
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 1;
            textView.setLayoutParams(layoutParams3);
            textView.setTextColor(-16777216);
            textView.setTextSize(10.0f);
            addView(textView);
        }

        /* renamed from: a, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        public final void b(int iconResId) {
            this.iconImageView.setImageResource(iconResId);
        }

        public final void c(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.textView.setText(text);
        }

        @Override // android.view.View
        public void setSelected(boolean selected) {
            if (selected) {
                setBackgroundResource(R.drawable.h1t);
            } else {
                setBackgroundResource(R.drawable.h1u);
            }
        }
    }
}
