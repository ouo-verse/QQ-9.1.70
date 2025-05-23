package com.tencent.sqshow.zootopia.view;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.style.LineHeightSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\f\u0010\u0010B#\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\f\u0010\u0013J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/sqshow/zootopia/view/ZplanExcludeFontPaddingTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "text", "Landroid/text/SpannableStringBuilder;", "a", "Landroid/widget/TextView$BufferType;", "type", "", IECSearchBar.METHOD_SET_TEXT, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZplanExcludeFontPaddingTextView extends AppCompatTextView {

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J8\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/sqshow/zootopia/view/ZplanExcludeFontPaddingTextView$a", "Landroid/text/style/LineHeightSpan;", "", "text", "", "start", "end", "spanstartv", NodeProps.LINE_HEIGHT, "Landroid/graphics/Paint$FontMetricsInt;", "fm", "", "chooseHeight", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements LineHeightSpan {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Rect f373343e;

        a(Rect rect) {
            this.f373343e = rect;
        }

        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(CharSequence text, int start, int end, int spanstartv, int lineHeight, Paint.FontMetricsInt fm5) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(fm5, "fm");
            int i3 = fm5.descent - fm5.ascent;
            int textSize = (int) ZplanExcludeFontPaddingTextView.this.getTextSize();
            Rect rect = this.f373343e;
            int max = Math.max(textSize, rect.bottom - rect.top);
            int abs = Math.abs(fm5.ascent - this.f373343e.top);
            int i16 = fm5.descent - this.f373343e.bottom;
            int i17 = (i3 - max) / 2;
            if (i17 < Math.min(abs, i16)) {
                fm5.ascent += i17;
                fm5.descent -= i17;
            } else if (abs < i16) {
                int i18 = this.f373343e.top;
                fm5.ascent = i18;
                fm5.descent = max + i18;
            } else {
                int i19 = this.f373343e.bottom;
                fm5.descent = i19;
                fm5.ascent = i19 - max;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanExcludeFontPaddingTextView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setIncludeFontPadding(false);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence text, TextView.BufferType type) {
        super.setText(a(text), type);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanExcludeFontPaddingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setIncludeFontPadding(false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanExcludeFontPaddingTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        setIncludeFontPadding(false);
    }

    private final SpannableStringBuilder a(CharSequence text) {
        if (text == null) {
            return null;
        }
        Rect rect = new Rect();
        getPaint().getTextBounds(text.toString(), 0, text.length(), rect);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
        spannableStringBuilder.setSpan(new a(rect), 0, text.length(), 33);
        return spannableStringBuilder;
    }
}
