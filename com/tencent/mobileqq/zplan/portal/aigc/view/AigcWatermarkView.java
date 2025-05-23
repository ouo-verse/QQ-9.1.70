package com.tencent.mobileqq.zplan.portal.aigc.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.avcore.jni.codec.NativeCodec;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import ei3.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010&\u001a\u00020\u0002\u00a2\u0006\u0004\b'\u0010(J$\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ0\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0014R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0014\u0010!\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001a\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/zplan/portal/aigc/view/AigcWatermarkView;", "Landroid/widget/FrameLayout;", "", HippyTKDListViewAdapter.X, "y", "Lkotlin/Pair;", "a", "Landroid/widget/TextView;", "b", "", "text", "", IECSearchBar.METHOD_SET_TEXT, "", "changed", "left", "top", "right", "bottom", "onLayout", "", "d", "Ljava/util/List;", "textViews", "", "e", UserInfo.SEX_FEMALE, "wordStride", "f", "lineStride", h.F, NativeCodec.STRIDE, "i", "textRotation", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AigcWatermarkView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<TextView> textViews;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final float wordStride;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final float lineStride;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final float stride;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final float textRotation;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AigcWatermarkView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Pair<Integer, Integer> a(int x16, int y16) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        int i3 = displayMetrics.widthPixels / 2;
        int i16 = displayMetrics.heightPixels / 2;
        float cos = (float) Math.cos((this.textRotation * 3.1415927f) / 180.0f);
        float sin = (float) Math.sin((this.textRotation * 3.1415927f) / 180.0f);
        float f16 = x16;
        float f17 = y16;
        return TuplesKt.to(Integer.valueOf((int) (i3 + ((((this.wordStride * f16) + (this.stride * f17)) * cos) - ((sin * f17) * this.lineStride)))), Integer.valueOf((int) (i16 + (((f16 * this.wordStride) + (this.stride * f17)) * sin) + (f17 * this.lineStride * cos))));
    }

    private final TextView b() {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setGravity(17);
        textView.setTextSize(17.0f);
        textView.setTextColor(-1);
        textView.setMaxLines(1);
        textView.setLetterSpacing(0.01f);
        textView.setAlpha(0.2f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setRotation(this.textRotation);
        this.textViews.add(textView);
        return textView;
    }

    public final void setText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        Iterator<TextView> it = this.textViews.iterator();
        while (it.hasNext()) {
            it.next().setText(text);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AigcWatermarkView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        measureChildren(0, 0);
        for (TextView textView : this.textViews) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.leftMargin -= textView.getMeasuredWidth() / 2;
            layoutParams2.topMargin -= textView.getMeasuredHeight() / 2;
        }
        super.onLayout(changed, left, top, right, bottom);
    }

    public /* synthetic */ AigcWatermarkView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AigcWatermarkView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Sequence<Pair> c16;
        Sequence c17;
        Sequence plus;
        boolean z16;
        boolean d16;
        Intrinsics.checkNotNullParameter(context, "context");
        this.textViews = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.text});
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026yOf(android.R.attr.text))");
        String string = obtainStyledAttributes.getString(0);
        string = string == null ? "" : string;
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, a.f396307a);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes2, "context.obtainStyledAttr\u2026leable.AigcWatermarkView)");
        this.wordStride = Math.max(obtainStyledAttributes2.getDimension(3, 100.0f), 100.0f);
        this.lineStride = Math.max(obtainStyledAttributes2.getDimension(0, 100.0f), 100.0f);
        this.stride = obtainStyledAttributes2.getDimension(2, 0.0f);
        this.textRotation = obtainStyledAttributes2.getFloat(1, 0.0f);
        DisplayMetrics dm5 = context.getResources().getDisplayMetrics();
        obtainStyledAttributes2.recycle();
        for (int i16 = 0; i16 < Integer.MAX_VALUE; i16++) {
            c16 = AigcWatermarkViewKt.c(i16);
            int i17 = 0;
            for (Pair pair : c16) {
                int intValue = ((Number) pair.component1()).intValue();
                int intValue2 = ((Number) pair.component2()).intValue();
                c17 = AigcWatermarkViewKt.c(1);
                plus = SequencesKt___SequencesKt.plus((Sequence<? extends Pair>) ((Sequence<? extends Object>) c17), TuplesKt.to(0, 0));
                Iterator it = plus.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z16 = false;
                        break;
                    }
                    Pair pair2 = (Pair) it.next();
                    Pair<Integer, Integer> a16 = a(((Number) pair2.component1()).intValue() + intValue, ((Number) pair2.component2()).intValue() + intValue2);
                    int intValue3 = a16.component1().intValue();
                    int intValue4 = a16.component2().intValue();
                    Intrinsics.checkNotNullExpressionValue(dm5, "dm");
                    d16 = AigcWatermarkViewKt.d(intValue3, intValue4, dm5);
                    if (d16) {
                        z16 = true;
                        break;
                    }
                }
                if (z16) {
                    i17++;
                    Pair<Integer, Integer> a17 = a(intValue, intValue2);
                    int intValue5 = a17.component1().intValue();
                    int intValue6 = a17.component2().intValue();
                    TextView b16 = b();
                    ViewGroup.LayoutParams layoutParams = b16.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    layoutParams2.leftMargin = intValue5;
                    layoutParams2.topMargin = intValue6;
                    addView(b16);
                }
            }
            if (i17 == 0) {
                break;
            }
        }
        setText(string);
    }
}
