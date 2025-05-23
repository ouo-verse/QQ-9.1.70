package com.qzone.reborn.feedpro.widget.header;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0007\n\u0002\b\u0011\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\b\u0003\u00105\u001a\u00020\u0006\u0012\b\b\u0003\u00106\u001a\u00020\u0006\u0012\b\b\u0003\u00107\u001a\u00020\u0006\u0012\b\b\u0003\u00108\u001a\u00020\u0006\u0012\b\b\u0002\u00109\u001a\u00020,\u0012\b\b\u0002\u0010:\u001a\u00020,\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\b\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0006R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016R\u0017\u0010\"\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010%\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010!R\u0017\u0010(\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010!R\u0017\u0010+\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010!R\u0017\u00101\u001a\u00020,8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0017\u00104\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b2\u0010\u001f\u001a\u0004\b3\u0010!\u00a8\u0006="}, d2 = {"Lcom/qzone/reborn/feedpro/widget/header/l;", "", "", "b", "Landroid/graphics/drawable/StateListDrawable;", "a", "", "color", "c", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/graphics/drawable/LayerDrawable;", "Landroid/graphics/drawable/LayerDrawable;", "getPressedLayerDrawable", "()Landroid/graphics/drawable/LayerDrawable;", "pressedLayerDrawable", "Landroid/graphics/drawable/GradientDrawable;", "Landroid/graphics/drawable/GradientDrawable;", "getPressedDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "pressedDrawable", "d", "getPressedOverlayDrawable", "pressedOverlayDrawable", "e", "getDefaultDrawable", "defaultDrawable", "f", "I", "getDefaultBgColor", "()I", "defaultBgColor", "g", "getPressedBgColor", "pressedBgColor", tl.h.F, "getOverlayBgColor", "overlayBgColor", "i", "getStrokeColor", "strokeColor", "", "j", UserInfo.SEX_FEMALE, "getCornerRadiusPx", "()F", "cornerRadiusPx", "k", "getStrokeWidthPx", "strokeWidthPx", "defaultBgColorRes", "pressedBgColorRes", "overlayBgColorRes", "strokeColorRes", "cornerRadiusDp", "strokeWidthDp", "<init>", "(Landroid/content/Context;IIIIFF)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final LayerDrawable pressedLayerDrawable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final GradientDrawable pressedDrawable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final GradientDrawable pressedOverlayDrawable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final GradientDrawable defaultDrawable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int defaultBgColor;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int pressedBgColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int overlayBgColor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int strokeColor;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final float cornerRadiusPx;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final int strokeWidthPx;

    public l(Context context, int i3, int i16, int i17, int i18, float f16, float f17) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.pressedDrawable = gradientDrawable;
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.pressedOverlayDrawable = gradientDrawable2;
        this.defaultDrawable = new GradientDrawable();
        this.defaultBgColor = ContextCompat.getColor(context, i3);
        this.pressedBgColor = ContextCompat.getColor(context, i16);
        this.overlayBgColor = ContextCompat.getColor(context, i17);
        this.strokeColor = ContextCompat.getColor(context, i18);
        this.cornerRadiusPx = ef.d.a(Float.valueOf(f16));
        this.strokeWidthPx = (int) ef.d.a(Float.valueOf(f17));
        b();
        this.pressedLayerDrawable = new LayerDrawable(new GradientDrawable[]{gradientDrawable, gradientDrawable2});
    }

    private final void b() {
        GradientDrawable gradientDrawable = this.pressedDrawable;
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(this.cornerRadiusPx);
        gradientDrawable.setColor(this.pressedBgColor);
        gradientDrawable.setStroke(this.strokeWidthPx, this.strokeColor);
        GradientDrawable gradientDrawable2 = this.pressedOverlayDrawable;
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius(this.cornerRadiusPx);
        gradientDrawable2.setColor(this.overlayBgColor);
        GradientDrawable gradientDrawable3 = this.defaultDrawable;
        gradientDrawable3.setShape(0);
        gradientDrawable3.setCornerRadius(this.cornerRadiusPx);
        gradientDrawable3.setColor(this.defaultBgColor);
        gradientDrawable3.setStroke(this.strokeWidthPx, this.strokeColor);
    }

    public final StateListDrawable a() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, this.pressedLayerDrawable);
        stateListDrawable.addState(new int[0], this.defaultDrawable);
        return stateListDrawable;
    }

    public final void c(int color) {
        this.defaultDrawable.setStroke(this.strokeWidthPx, color);
        this.defaultDrawable.invalidateSelf();
        if (this.pressedLayerDrawable.getNumberOfLayers() > 0) {
            Drawable drawable = this.pressedLayerDrawable.getDrawable(0);
            GradientDrawable gradientDrawable = drawable instanceof GradientDrawable ? (GradientDrawable) drawable : null;
            if (gradientDrawable != null) {
                gradientDrawable.setStroke(this.strokeWidthPx, color);
            }
        }
        this.pressedLayerDrawable.invalidateSelf();
    }

    public /* synthetic */ l(Context context, int i3, int i16, int i17, int i18, float f16, float f17, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i19 & 2) != 0 ? com.tencent.mobileqq.R.color.qui_common_bg_bottom_light : i3, (i19 & 4) == 0 ? i16 : com.tencent.mobileqq.R.color.qui_common_bg_bottom_light, (i19 & 8) != 0 ? com.tencent.mobileqq.R.color.qui_common_overlay_standard_secondary : i17, (i19 & 16) != 0 ? com.tencent.mobileqq.R.color.qui_common_icon_primary : i18, (i19 & 32) != 0 ? 12.0f : f16, (i19 & 64) != 0 ? 0.6f : f17);
    }
}
