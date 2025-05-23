package com.tencent.gdtad.basics.motivebrowsing;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0002\"\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bB\u001b\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\u001a\u0010\u001eB#\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001a\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0014\u0010\u000e\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0016\u00a8\u0006#"}, d2 = {"Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingTitle;", "Landroid/widget/RelativeLayout;", "", "e", "Landroid/graphics/drawable/Drawable;", "b", "d", "", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "", "c", "f", "Lkotlin/Function0;", NodeProps.ON_CLICK, "setOnCloseClickListener", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "tvBrowsing", "Landroid/view/View;", "Landroid/view/View;", "imgClose", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "countDownContainer", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", tl.h.F, "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GdtMotiveBrowsingTitle extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView tvBrowsing;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View imgClose;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout countDownContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0018\u0010\u0019J4\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016JR\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0017\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingTitle$b;", "Landroid/text/style/ReplacementSpan;", "Landroid/graphics/Paint;", "paint", "", "text", "", "start", "end", "Landroid/graphics/Paint$FontMetricsInt;", "fm", "getSize", "Landroid/graphics/Canvas;", PM.CANVAS, "", HippyTKDListViewAdapter.X, "top", "y", "bottom", "", "draw", "d", "I", "fixWidth", "<init>", "(I)V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends ReplacementSpan {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int fixWidth;

        public b(int i3) {
            this.fixWidth = i3;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(@NotNull Canvas canvas, @Nullable CharSequence text, int start, int end, float x16, int top, int y16, int bottom, @NotNull Paint paint) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(paint, "paint");
            if (!TextUtils.isEmpty(text)) {
                float max = Math.max(0.0f, (this.fixWidth - paint.measureText(text, start, end)) / 2);
                Intrinsics.checkNotNull(text);
                canvas.drawText(text, start, end, x16 + max, y16, paint);
            }
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(@NotNull Paint paint, @Nullable CharSequence text, int start, int end, @Nullable Paint.FontMetricsInt fm5) {
            Intrinsics.checkNotNullParameter(paint, "paint");
            return this.fixWidth;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GdtMotiveBrowsingTitle(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Drawable b() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(ViewUtils.dpToPx(18.0f));
        gradientDrawable.setStroke(ViewUtils.dpToPx(1.0f), Color.parseColor("#E5E5E5"));
        return gradientDrawable;
    }

    private final CharSequence c(int second) {
        if (second > 0) {
            b bVar = new b(ViewUtils.dpToPx(23.0f));
            String valueOf = String.valueOf(second);
            String string = getResources().getString(R.string.f1378107v, valueOf);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026n_browsing, secondString)");
            SpannableString spannableString = new SpannableString(string);
            spannableString.setSpan(bVar, 2, valueOf.length() + 2, 17);
            return spannableString;
        }
        String string2 = getResources().getString(R.string.f1378307x);
        Intrinsics.checkNotNullExpressionValue(string2, "{\n        resources.getS\u2026ount_down_complete)\n    }");
        return string2;
    }

    private final void d() {
        int dpToPx = ViewUtils.dpToPx(33.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dpToPx, dpToPx);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.imgClose = new GdtMotiveBrowsingImage(context);
        layoutParams.addRule(11);
        View view = this.imgClose;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgClose");
            view = null;
        }
        view.setLayoutParams(layoutParams);
        View view3 = this.imgClose;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgClose");
        } else {
            view2 = view3;
        }
        addView(view2);
    }

    private final void e() {
        int dpToPx = ViewUtils.dpToPx(16.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, ViewUtils.dpToPx(33.0f));
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.countDownContainer = linearLayout;
        linearLayout.setBackground(b());
        LinearLayout linearLayout2 = this.countDownContainer;
        LinearLayout linearLayout3 = null;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
            linearLayout2 = null;
        }
        linearLayout2.setPadding(dpToPx, 0, dpToPx, 0);
        LinearLayout linearLayout4 = this.countDownContainer;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
            linearLayout4 = null;
        }
        linearLayout4.setOrientation(0);
        LinearLayout linearLayout5 = this.countDownContainer;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
            linearLayout5 = null;
        }
        linearLayout5.setGravity(16);
        LinearLayout linearLayout6 = this.countDownContainer;
        if (linearLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
            linearLayout6 = null;
        }
        linearLayout6.setLayoutParams(layoutParams);
        TextView textView = new TextView(getContext());
        textView.setText(getResources().getString(R.string.f1378407y));
        textView.setId(R.id.vm6);
        textView.setTextColor(-16777216);
        textView.setTextSize(1, 14.0f);
        LinearLayout linearLayout7 = this.countDownContainer;
        if (linearLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
            linearLayout7 = null;
        }
        linearLayout7.addView(textView);
        View view = new View(getContext());
        int dpToPx2 = ViewUtils.dpToPx(1.0f);
        int dpToPx3 = ViewUtils.dpToPx(20.0f);
        int dpToPx4 = ViewUtils.dpToPx(10.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dpToPx2, dpToPx3);
        layoutParams2.leftMargin = dpToPx4;
        layoutParams2.rightMargin = dpToPx4;
        view.setLayoutParams(layoutParams2);
        view.setBackgroundColor(Color.parseColor("#E5E5E5"));
        LinearLayout linearLayout8 = this.countDownContainer;
        if (linearLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
            linearLayout8 = null;
        }
        linearLayout8.addView(view);
        TextView textView2 = new TextView(getContext());
        this.tvBrowsing = textView2;
        textView2.setId(R.id.vm5);
        TextView textView3 = this.tvBrowsing;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvBrowsing");
            textView3 = null;
        }
        textView3.setTextColor(-16777216);
        TextView textView4 = this.tvBrowsing;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvBrowsing");
            textView4 = null;
        }
        textView4.setTextSize(1, 14.0f);
        LinearLayout linearLayout9 = this.countDownContainer;
        if (linearLayout9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
            linearLayout9 = null;
        }
        TextView textView5 = this.tvBrowsing;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvBrowsing");
            textView5 = null;
        }
        linearLayout9.addView(textView5);
        LinearLayout linearLayout10 = this.countDownContainer;
        if (linearLayout10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
            linearLayout10 = null;
        }
        linearLayout10.setVisibility(8);
        LinearLayout linearLayout11 = this.countDownContainer;
        if (linearLayout11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
        } else {
            linearLayout3 = linearLayout11;
        }
        addView(linearLayout3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function0 onClick, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(onClick, "$onClick");
        onClick.invoke();
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void f(int second) {
        LinearLayout linearLayout = this.countDownContainer;
        TextView textView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        TextView textView2 = this.tvBrowsing;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvBrowsing");
            textView2 = null;
        }
        textView2.setVisibility(0);
        TextView textView3 = this.tvBrowsing;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvBrowsing");
        } else {
            textView = textView3;
        }
        textView.setText(c(second));
    }

    public final void setOnCloseClickListener(@NotNull final Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        View view = this.imgClose;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgClose");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.gdtad.basics.motivebrowsing.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GdtMotiveBrowsingTitle.g(Function0.this, view2);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GdtMotiveBrowsingTitle(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GdtMotiveBrowsingTitle(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        ImmersiveUtils.setStatusTextColor(true, ((Activity) context).getWindow());
        int dpToPx = ViewUtils.dpToPx(63.0f);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(context);
            dpToPx += statusBarHeight;
            int dpToPx2 = ViewUtils.dpToPx(15.0f);
            setPadding(dpToPx2, statusBarHeight + dpToPx2, dpToPx2, dpToPx2);
        }
        setLayoutParams(new RelativeLayout.LayoutParams(-1, dpToPx));
        setBackgroundColor(-1);
        e();
        d();
    }
}
