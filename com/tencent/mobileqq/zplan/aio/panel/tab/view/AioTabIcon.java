package com.tencent.mobileqq.zplan.aio.panel.tab.view;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.internal.view.SupportMenu;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010*\u001a\u00020)\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\b\b\u0002\u0010-\u001a\u00020\t\u00a2\u0006\u0004\b.\u0010/J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0016R*\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8\u0006@FX\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0014R(\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010(\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/tab/view/AioTabIcon;", "Landroid/widget/RelativeLayout;", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "selected", "", "setSelected", "", "value", "d", "I", "getIconResInt", "()I", "setIconResInt", "(I)V", "iconResInt", "Landroid/view/View;", "e", "Landroid/view/View;", "backgroundView", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "iconView", h.F, "redDotHintView", "Lkotlin/Function0;", "i", "Lkotlin/jvm/functions/Function0;", "getOnClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "onClickListener", "getRedDotHint", "()Z", "setRedDotHint", "(Z)V", "redDotHint", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class AioTabIcon extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int iconResInt;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final View backgroundView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ImageView iconView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final View redDotHintView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> onClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/aio/panel/tab/view/AioTabIcon$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f331321a;

        a(View view) {
            this.f331321a = view;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), g.c(this.f331321a, 16.0f));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/aio/panel/tab/view/AioTabIcon$b", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), Math.min(view.getWidth(), view.getHeight()) / 2.0f);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AioTabIcon(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setIconResInt(int i3) {
        Drawable.ConstantState constantState;
        Drawable newDrawable;
        this.iconResInt = i3;
        ImageView imageView = this.iconView;
        Drawable drawable = AppCompatResources.getDrawable(getContext(), this.iconResInt);
        imageView.setBackground((drawable == null || (constantState = drawable.getConstantState()) == null || (newDrawable = constantState.newDrawable()) == null) ? null : newDrawable.mutate());
        setSelected(isSelected());
        if (i3 == R.drawable.i4p) {
            ViewGroup.LayoutParams layoutParams = this.iconView.getLayoutParams();
            layoutParams.width = g.c(this, 20.0f);
            layoutParams.height = g.c(this, 20.0f);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.iconView.getLayoutParams();
            layoutParams2.width = g.c(this, 18.0f);
            layoutParams2.height = g.c(this, 18.0f);
        }
    }

    public final void setOnClickListener(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onClickListener = function0;
    }

    public final void setRedDotHint(boolean z16) {
        this.redDotHintView.setVisibility(z16 ? 0 : 8);
    }

    @Override // android.view.View
    public void setSelected(boolean selected) {
        int color;
        int color2;
        super.setSelected(selected);
        View view = this.backgroundView;
        if (selected) {
            color = getResources().getColor(R.color.qui_common_brand_standard, null);
        } else {
            color = getResources().getColor(R.color.qui_common_overlay_light, null);
        }
        view.setBackgroundColor(color);
        Drawable background = this.iconView.getBackground();
        if (background == null) {
            return;
        }
        if (selected) {
            color2 = getResources().getColor(R.color.qui_common_on_brand_primary, null);
        } else {
            color2 = getResources().getColor(R.color.qui_common_icon_secondary, null);
        }
        background.setColorFilter(new PorterDuffColorFilter(color2, PorterDuff.Mode.MULTIPLY));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AioTabIcon(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AioTabIcon(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AioTabIcon(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.iconResInt = R.drawable.i4o;
        View view = new View(context, attributeSet, i3);
        addView(view);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        view.setClipToOutline(true);
        view.setOutlineProvider(new a(view));
        view.setZ(0.0f);
        this.backgroundView = view;
        ImageView imageView = new ImageView(context, attributeSet, i3);
        addView(imageView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g.c(imageView, 20.0f), g.c(imageView, 20.0f));
        layoutParams.addRule(13, -1);
        imageView.setLayoutParams(layoutParams);
        imageView.setZ(1.0f);
        this.iconView = imageView;
        View view2 = new View(context, attributeSet, i3);
        addView(view2);
        view2.setBackgroundColor(SupportMenu.CATEGORY_MASK);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(g.c(view2, 4.0f), g.c(view2, 4.0f));
        int c16 = g.c(view2, 2.0f);
        layoutParams2.setMargins(c16, c16, c16, c16);
        layoutParams2.addRule(11);
        layoutParams2.addRule(10);
        view2.setLayoutParams(layoutParams2);
        view2.setClipToOutline(true);
        view2.setOutlineProvider(new b());
        view2.setZ(2.0f);
        this.redDotHintView = view2;
        this.onClickListener = new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aio.panel.tab.view.AioTabIcon$onClickListener$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        setSelected(false);
        setIconResInt(this.iconResInt);
        setRedDotHint(false);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        boolean z16 = false;
        if (event != null && event.getAction() == 0) {
            z16 = true;
        }
        if (z16) {
            this.onClickListener.invoke();
        }
        return super.onTouchEvent(event);
    }
}
