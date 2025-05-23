package com.tencent.mobileqq.guild.main.visitor.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.text.style.DynamicDrawableSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.widget.PatchedTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014R\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/main/visitor/view/AnimatableSpanTextView;", "Lcom/tencent/mobileqq/widget/PatchedTextView;", "", "text", "Landroid/widget/TextView$BufferType;", "type", "", IECSearchBar.METHOD_SET_TEXT, "Landroid/graphics/drawable/Drawable;", "who", "", "verifyDrawable", "", "f", "Ljava/util/List;", "spanDrawables", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class AnimatableSpanTextView extends PatchedTextView {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<? extends Drawable> spanDrawables;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnimatableSpanTextView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mobileqq.widget.PatchedTextView, android.widget.TextView
    public void setText(@NotNull CharSequence text, @NotNull TextView.BufferType type) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(type, "type");
        CharSequence text2 = getText();
        super.setText(text, type);
        if (text2 == text) {
            return;
        }
        List<? extends Drawable> list = this.spanDrawables;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((Drawable) it.next()).setCallback(null);
            }
        }
        this.spanDrawables = null;
        if (!(text instanceof Spanned)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.spanDrawables = arrayList;
        CharSequence text3 = getText();
        Intrinsics.checkNotNull(text3, "null cannot be cast to non-null type android.text.Spanned");
        Spanned spanned = (Spanned) text3;
        EmoticonSpan[] emoticonSpans = (EmoticonSpan[]) spanned.getSpans(0, spanned.length(), EmoticonSpan.class);
        Intrinsics.checkNotNullExpressionValue(emoticonSpans, "emoticonSpans");
        for (EmoticonSpan emoticonSpan : emoticonSpans) {
            Drawable drawable = emoticonSpan.getDrawable();
            if (drawable != null) {
                Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
                arrayList.add(drawable);
                drawable.setCallback(this);
            }
        }
        DynamicDrawableSpan[] dynamicDrawableSpans = (DynamicDrawableSpan[]) spanned.getSpans(0, spanned.length(), DynamicDrawableSpan.class);
        Intrinsics.checkNotNullExpressionValue(dynamicDrawableSpans, "dynamicDrawableSpans");
        for (DynamicDrawableSpan dynamicDrawableSpan : dynamicDrawableSpans) {
            Drawable drawable2 = dynamicDrawableSpan.getDrawable();
            if (drawable2 != null) {
                Intrinsics.checkNotNullExpressionValue(drawable2, "drawable");
                arrayList.add(drawable2);
                drawable2.setCallback(this);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected boolean verifyDrawable(@NotNull Drawable who) {
        Intrinsics.checkNotNullParameter(who, "who");
        return true;
    }

    public /* synthetic */ AnimatableSpanTextView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnimatableSpanTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
