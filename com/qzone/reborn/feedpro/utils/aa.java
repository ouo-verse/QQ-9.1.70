package com.qzone.reborn.feedpro.utils;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.tianshu.data.RedTouchConst;
import com.tencent.mobileqq.util.cn;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\f\u0010\b\u001a\u00020\u0007*\u00020\u0006H\u0002J\u0016\u0010\u000b\u001a\u00020\n*\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0004\u001a\u00020\u0003J,\u0010\u0011\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0003\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0007J,\u0010\u0014\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0003\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u0007J\u0016\u0010\u0015\u001a\u00020\n*\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0004\u001a\u00020\u0003J\u0016\u0010\u0016\u001a\u00020\n*\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0004\u001a\u00020\u0003R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/qzone/reborn/feedpro/utils/aa;", "", "Landroid/graphics/drawable/Drawable;", "", com.tencent.luggage.wxa.c8.c.f123400v, "j", "Landroid/widget/TextView;", "", "k", "Landroid/view/View;", "", "l", "Landroid/content/Context;", "context", "", "overlayColor", "needTransparentBg", "f", "Landroid/widget/ImageView;", RedTouchConst.PicDownload.ISCIRCLE, tl.h.F, "b", "d", "", "Ljava/lang/String;", "TAG", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class aa {

    /* renamed from: a, reason: collision with root package name */
    public static final aa f54263a = new aa();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String TAG = "QzoneFeedProPressedStateHelper";

    aa() {
    }

    private final Drawable j(Drawable drawable, float f16) {
        Drawable f17 = cn.f(drawable);
        f17.setAlpha((int) (f16 * 255));
        Intrinsics.checkNotNullExpressionValue(f17, "mutate(this).apply { set\u2026((alpha * 255).toInt()) }");
        return f17;
    }

    private final boolean k(TextView textView) {
        ColorStateList textColors = textView.getTextColors();
        if (textColors == null) {
            return false;
        }
        return textColors.isStateful() && textColors.getColorForState(new int[]{R.attr.state_pressed}, textColors.getDefaultColor()) != textColors.getDefaultColor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n(View view, float f16, View view2, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            view.setAlpha(f16);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        view.setAlpha(1.0f);
        return false;
    }

    public final void b(ImageView imageView, float f16) {
        Drawable drawable = imageView != null ? imageView.getDrawable() : null;
        if (drawable == null) {
            return;
        }
        if (drawable instanceof StateListDrawable) {
            RFWLog.i(TAG, RFWLog.USR, "[addAlphaPressedStateForDrawable] img drawable is already state drawable");
            return;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        int[] iArr = {R.attr.state_pressed};
        aa aaVar = f54263a;
        stateListDrawable.addState(iArr, aaVar.j(drawable, f16));
        stateListDrawable.addState(new int[0], aaVar.j(drawable, 1.0f));
        imageView.setImageDrawable(stateListDrawable);
    }

    public final void d(TextView textView, float f16) {
        if (textView != null && !k(textView)) {
            ColorStateList textColors = textView.getTextColors();
            if (textColors != null) {
                int defaultColor = textColors.getDefaultColor();
                textView.setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{GuildUIUtils.f235378a.E(defaultColor, f16), defaultColor}));
                return;
            }
            return;
        }
        RFWLog.i(TAG, RFWLog.USR, "[addAlphaPressedStateForTextColor] textColor is already stateful");
    }

    public final void l(final View view, final float f16) {
        if (view != null) {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.qzone.reborn.feedpro.utils.z
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    boolean n3;
                    n3 = aa.n(view, f16, view2, motionEvent);
                    return n3;
                }
            });
        }
    }

    public final Drawable f(View view, Context context, int i3, boolean z16) {
        Drawable colorDrawable;
        int shape;
        float cornerRadius;
        if (context == null) {
            RFWLog.e(TAG, RFWLog.USR, "[addOverlayPressedStateForBg] context is null");
            return null;
        }
        if (view == null || (colorDrawable = view.getBackground()) == null) {
            colorDrawable = z16 ? new ColorDrawable(0) : null;
        }
        if (view != null && colorDrawable != null && !(colorDrawable instanceof StateListDrawable)) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(ContextCompat.getColor(context, i3));
            if ((colorDrawable instanceof GradientDrawable) && Build.VERSION.SDK_INT >= 24) {
                GradientDrawable gradientDrawable2 = (GradientDrawable) colorDrawable;
                shape = gradientDrawable2.getShape();
                gradientDrawable.setShape(shape);
                cornerRadius = gradientDrawable2.getCornerRadius();
                gradientDrawable.setCornerRadius(cornerRadius);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{colorDrawable, gradientDrawable});
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, layerDrawable);
            stateListDrawable.addState(new int[0], colorDrawable);
            view.setBackground(stateListDrawable);
            return stateListDrawable;
        }
        RFWLog.i(TAG, RFWLog.USR, "[addOverlayPressedStateForBg] bg is null or already state drawable");
        return colorDrawable;
    }

    public final Drawable h(ImageView imageView, Context context, int i3, boolean z16) {
        if (context == null) {
            RFWLog.e(TAG, RFWLog.USR, "[addOverlayPressedStateForDrawable] context is null");
            return null;
        }
        Drawable drawable = imageView != null ? imageView.getDrawable() : null;
        if (imageView != null && drawable != null && !(drawable instanceof StateListDrawable)) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(ContextCompat.getColor(context, i3));
            if (z16) {
                gradientDrawable.setShape(1);
                gradientDrawable.setSize(drawable.getBounds().width(), drawable.getBounds().height());
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable, gradientDrawable});
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, layerDrawable);
            stateListDrawable.addState(new int[0], drawable);
            imageView.setImageDrawable(stateListDrawable);
            return stateListDrawable;
        }
        RFWLog.i(TAG, RFWLog.USR, "[addOverlayPressedStateForDrawable] image is null or already a state drawable");
        return drawable;
    }

    public static /* synthetic */ void c(aa aaVar, ImageView imageView, float f16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = 0.5f;
        }
        aaVar.b(imageView, f16);
    }

    public static /* synthetic */ void e(aa aaVar, TextView textView, float f16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = 0.5f;
        }
        aaVar.d(textView, f16);
    }

    public static /* synthetic */ void m(aa aaVar, View view, float f16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = 0.5f;
        }
        aaVar.l(view, f16);
    }

    public static /* synthetic */ Drawable g(aa aaVar, View view, Context context, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = com.tencent.mobileqq.R.color.qui_common_overlay_standard_secondary;
        }
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        return aaVar.f(view, context, i3, z16);
    }

    public static /* synthetic */ Drawable i(aa aaVar, ImageView imageView, Context context, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = com.tencent.mobileqq.R.color.qui_common_overlay_standard_secondary;
        }
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        return aaVar.h(imageView, context, i3, z16);
    }
}
