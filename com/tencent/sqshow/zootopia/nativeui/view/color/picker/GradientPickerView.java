package com.tencent.sqshow.zootopia.nativeui.view.color.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.sqshow.zootopia.nativeui.view.color.picker.GradientColorView;
import com.tencent.sqshow.zootopia.nativeui.view.color.picker.GradientPickerView;
import com.tencent.sqshow.zootopia.utils.i;
import da4.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u0012\u0006\u0010+\u001a\u00020\u000f\u00a2\u0006\u0004\b,\u0010-B\u001f\b\u0017\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u00a2\u0006\u0004\b,\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0016\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u000fJ\u0006\u0010\u0015\u001a\u00020\fJ\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016J\u001a\u0010\u001b\u001a\u00020\u00022\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00020\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001fR\u0016\u0010#\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\"R$\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010&\u00a8\u0006/"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/GradientPickerView;", "Landroid/widget/RelativeLayout;", "", "k", h.F, "Landroid/view/View;", "view", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", NodeProps.COLORS, "c", "", "fraction", "setColors", "", "color", "setColor", "g", "e", "f", "d", "Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/GradientColorView$b;", "onFractionChangedListener", "setOnFractionChangedListener", "Lkotlin/Function1;", "callback", "setOnThumbChangedListener", "Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/GradientColorView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/GradientColorView;", "gradientColorView", "Landroid/view/View;", "leftThumbView", "rightThumbView", "I", "selectedThumb", "i", "Lkotlin/jvm/functions/Function1;", "[I", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class GradientPickerView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GradientColorView gradientColorView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View leftThumbView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View rightThumbView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int selectedThumb;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Function1<? super Integer, Unit> callback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int[] colors;

    public GradientPickerView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
    }

    private final void c(int[] colors) {
        int length = colors.length;
        for (int i3 = 0; i3 < length; i3++) {
            colors[i3] = a.f393479a.b(colors[i3]);
        }
    }

    private final void h() {
        View view = this.leftThumbView;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: ca4.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    GradientPickerView.i(GradientPickerView.this, view2);
                }
            });
        }
        View view2 = this.rightThumbView;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: ca4.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    GradientPickerView.j(GradientPickerView.this, view3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(GradientPickerView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.selectedThumb == 1) {
            this$0.selectedThumb = 0;
            this$0.l(this$0.leftThumbView);
            this$0.m(this$0.rightThumbView);
            Function1<? super Integer, Unit> function1 = this$0.callback;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(this$0.selectedThumb));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(GradientPickerView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.selectedThumb == 0) {
            this$0.selectedThumb = 1;
            this$0.m(this$0.leftThumbView);
            this$0.l(this$0.rightThumbView);
            Function1<? super Integer, Unit> function1 = this$0.callback;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(this$0.selectedThumb));
            }
        }
    }

    public final float d() {
        GradientColorView gradientColorView = this.gradientColorView;
        if (gradientColorView != null) {
            return gradientColorView.getMFraction();
        }
        return 0.0f;
    }

    public final int e() {
        int[] iArr = this.colors;
        if (iArr.length == 0) {
            return 0;
        }
        return iArr[0];
    }

    public final int f() {
        int[] iArr = this.colors;
        if (iArr.length == 0) {
            return 0;
        }
        return iArr[iArr.length - 1];
    }

    /* renamed from: g, reason: from getter */
    public final int getSelectedThumb() {
        return this.selectedThumb;
    }

    public final void setColor(int color) {
        Drawable background;
        int[] iArr = this.colors;
        if (iArr.length == 0) {
            return;
        }
        if (this.selectedThumb == 0) {
            iArr[0] = color;
            GradientColorView gradientColorView = this.gradientColorView;
            if (gradientColorView != null) {
                gradientColorView.setColors(iArr);
            }
            View view = this.leftThumbView;
            background = view != null ? view.getBackground() : null;
            Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            ((GradientDrawable) background).setColor(color);
            return;
        }
        iArr[iArr.length - 1] = color;
        GradientColorView gradientColorView2 = this.gradientColorView;
        if (gradientColorView2 != null) {
            gradientColorView2.setColors(iArr);
        }
        View view2 = this.rightThumbView;
        background = view2 != null ? view2.getBackground() : null;
        Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) background).setColor(color);
    }

    public final void setColors(int[] colors, float fraction) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        if (colors.length == 0) {
            return;
        }
        this.colors = colors;
        c(colors);
        GradientColorView gradientColorView = this.gradientColorView;
        if (gradientColorView != null) {
            gradientColorView.setColors(colors, fraction);
        }
        View view = this.leftThumbView;
        Drawable background = view != null ? view.getBackground() : null;
        Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) background).setColor(colors[0]);
        View view2 = this.rightThumbView;
        Drawable background2 = view2 != null ? view2.getBackground() : null;
        Intrinsics.checkNotNull(background2, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) background2).setColor(colors[colors.length - 1]);
    }

    public final void setOnFractionChangedListener(GradientColorView.b onFractionChangedListener) {
        Intrinsics.checkNotNullParameter(onFractionChangedListener, "onFractionChangedListener");
        GradientColorView gradientColorView = this.gradientColorView;
        if (gradientColorView != null) {
            gradientColorView.setOnFractionChangedListener(onFractionChangedListener);
        }
    }

    public final void setOnThumbChangedListener(Function1<? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    public GradientPickerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.colors = new int[0];
        View.inflate(context, R.layout.dco, this);
        k();
        h();
    }

    private final void l(View view) {
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.width = i.b(24);
        }
        if (layoutParams != null) {
            layoutParams.height = i.b(24);
        }
        if (view == null) {
            return;
        }
        view.setLayoutParams(layoutParams);
    }

    private final void m(View view) {
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.width = i.b(15);
        }
        if (layoutParams != null) {
            layoutParams.height = i.b(15);
        }
        if (view == null) {
            return;
        }
        view.setLayoutParams(layoutParams);
    }

    private final void k() {
        this.gradientColorView = (GradientColorView) findViewById(R.id.r4z);
        this.leftThumbView = findViewById(R.id.r3r);
        this.rightThumbView = findViewById(R.id.r3s);
    }

    public GradientPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public /* synthetic */ GradientPickerView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }
}
