package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.lo.o;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 52\u00020\u0001:\u0004\u0019\u001c (B'\b\u0007\u0012\u0006\u0010/\u001a\u00020.\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100\u0012\b\b\u0002\u00102\u001a\u00020\f\u00a2\u0006\u0004\b3\u00104J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u00020\u00042\b\b\u0001\u0010\r\u001a\u00020\fJ\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\fH\u0002R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00066"}, d2 = {"Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandTranslateLayout;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandTranslateLayout$f;", "onTranslateRectCallback", "", "setOnTranslateRectCallback", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandTranslateLayout$d;", "onHideCallback", "setOnHideCallback", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandTranslateLayout$e;", "onTranslateClick", "setOnTranslateClick", "", "color", "setStyleColor", "state", "a", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "tv", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "iv", "Landroid/widget/ProgressBar;", "c", "Landroid/widget/ProgressBar;", "pb", "d", "Landroid/widget/LinearLayout;", TtmlNode.TAG_LAYOUT, "Landroid/view/View;", "e", "Landroid/view/View;", "getDivider", "()Landroid/view/View;", "setDivider", "(Landroid/view/View;)V", "divider", "", "f", "Z", "canNotifyRectChange", "g", "I", "currentState", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", h.F, "luggage-wxa-app_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class AppBrandTranslateLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final TextView tv;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final ImageView iv;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final ProgressBar pb;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final LinearLayout layout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public View divider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public boolean canNotifyRectChange;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public int currentState;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AppBrandTranslateLayout.b(AppBrandTranslateLayout.this);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (AppBrandTranslateLayout.this.canNotifyRectChange) {
                AppBrandTranslateLayout.this.canNotifyRectChange = false;
                AppBrandTranslateLayout.c(AppBrandTranslateLayout.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface d {
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface e {
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface f {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AppBrandTranslateLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final /* synthetic */ e b(AppBrandTranslateLayout appBrandTranslateLayout) {
        appBrandTranslateLayout.getClass();
        return null;
    }

    public static final /* synthetic */ f c(AppBrandTranslateLayout appBrandTranslateLayout) {
        appBrandTranslateLayout.getClass();
        return null;
    }

    @Nullable
    public final View getDivider() {
        return this.divider;
    }

    public final void setDivider(@Nullable View view) {
        this.divider = view;
    }

    public final void setOnHideCallback(@NotNull d onHideCallback) {
        Intrinsics.checkNotNullParameter(onHideCallback, "onHideCallback");
    }

    public final void setOnTranslateClick(@NotNull e onTranslateClick) {
        Intrinsics.checkNotNullParameter(onTranslateClick, "onTranslateClick");
    }

    public final void setOnTranslateRectCallback(@NotNull f onTranslateRectCallback) {
        Intrinsics.checkNotNullParameter(onTranslateRectCallback, "onTranslateRectCallback");
    }

    public final void setStyleColor(@ColorInt int color) {
        Drawable drawable = null;
        if (color == -1) {
            View view = this.divider;
            Intrinsics.checkNotNull(view);
            view.setBackgroundResource(R.color.b5h);
            this.tv.setTextColor(z.a(R.color.b5q));
            this.iv.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
            ProgressBar progressBar = this.pb;
            Drawable drawable2 = ContextCompat.getDrawable(z.c(), R.drawable.k7g);
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, o.a(getContext(), 16), o.a(getContext(), 16));
                drawable = drawable2;
            }
            progressBar.setIndeterminateDrawable(drawable);
            return;
        }
        View view2 = this.divider;
        Intrinsics.checkNotNull(view2);
        view2.setBackgroundResource(R.color.b5i);
        this.tv.setTextColor(z.a(R.color.b5r));
        this.iv.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        ProgressBar progressBar2 = this.pb;
        Drawable drawable3 = ContextCompat.getDrawable(z.c(), R.drawable.k7d);
        if (drawable3 != null) {
            drawable3.setBounds(0, 0, o.a(getContext(), 16), o.a(getContext(), 16));
            drawable = drawable3;
        }
        progressBar2.setIndeterminateDrawable(drawable);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AppBrandTranslateLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AppBrandTranslateLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    public final void a(int state) {
        this.currentState = state;
        if (state == 0) {
            this.layout.setVisibility(0);
            this.tv.setText(getResources().getString(R.string.z2m));
            this.iv.setImageResource(R.raw.f169262at);
            this.iv.setAlpha(1.0f);
            this.tv.setAlpha(1.0f);
            this.pb.setVisibility(8);
            this.iv.setVisibility(0);
            View view = this.divider;
            if (view == null) {
                return;
            }
            view.setVisibility(0);
            return;
        }
        if (state == 1) {
            this.layout.setVisibility(0);
            this.tv.setText(getResources().getString(R.string.z2l));
            this.iv.setAlpha(1.0f);
            this.tv.setAlpha(1.0f);
            this.pb.setVisibility(0);
            this.iv.setVisibility(8);
            View view2 = this.divider;
            if (view2 == null) {
                return;
            }
            view2.setVisibility(0);
            return;
        }
        if (state != 2) {
            this.iv.setVisibility(8);
            this.pb.setVisibility(8);
            this.layout.setVisibility(8);
            View view3 = this.divider;
            if (view3 == null) {
                return;
            }
            view3.setVisibility(8);
            return;
        }
        this.layout.setVisibility(0);
        this.tv.setText(getResources().getString(R.string.z2k));
        this.iv.setImageResource(R.raw.f169263au);
        this.iv.setAlpha(1.0f);
        this.tv.setAlpha(1.0f);
        this.pb.setVisibility(8);
        this.iv.setVisibility(0);
        View view4 = this.divider;
        if (view4 == null) {
            return;
        }
        view4.setVisibility(0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AppBrandTranslateLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.dxt, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.s_j);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.action\u2026capsule_translate_layout)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.layout = linearLayout;
        View findViewById2 = findViewById(R.id.s_l);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.actionbar_capsule_translate_tv)");
        this.tv = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.s_i);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.actionbar_capsule_translate_iv)");
        this.iv = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.s_k);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.actionbar_capsule_translate_pb)");
        this.pb = (ProgressBar) findViewById4;
        linearLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.j_a));
        a(-1);
        setOnClickListener(new a());
        getViewTreeObserver().addOnGlobalLayoutListener(new b());
        this.currentState = -1;
    }
}
