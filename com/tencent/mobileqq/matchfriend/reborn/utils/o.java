package com.tencent.mobileqq.matchfriend.reborn.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\"\u0010\u001f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b \u0010\u000fR\"\u0010#\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\f\u001a\u0004\b\u0019\u0010\r\"\u0004\b\"\u0010\u000fR\"\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0015\u0010\r\"\u0004\b$\u0010\u000f\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/utils/o;", "", "Landroid/content/Context;", "context", "", "resId", "a", "Landroid/content/res/ColorStateList;", "g", "", "j", "b", "I", "()I", "setColorBgBottomStandard", "(I)V", "colorBgBottomStandard", "c", tl.h.F, "setColorTextPrimary", "colorTextPrimary", "d", "i", "setColorTextSecondary", "colorTextSecondary", "e", "Landroid/content/res/ColorStateList;", "f", "()Landroid/content/res/ColorStateList;", "setColorSLTextSecondary", "(Landroid/content/res/ColorStateList;)V", "colorSLTextSecondary", "setColorFillLightPrimary", "colorFillLightPrimary", "setColorOverlayStandardPrimary", "colorOverlayStandardPrimary", "setColorOverlayLight", "colorOverlayLight", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f245489a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int colorBgBottomStandard;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int colorTextPrimary;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int colorTextSecondary;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static ColorStateList colorSLTextSecondary;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static int colorFillLightPrimary;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static int colorOverlayStandardPrimary;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static int colorOverlayLight;

    static {
        o oVar = new o();
        f245489a = oVar;
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "sMobileQQ.applicationContext");
        colorBgBottomStandard = oVar.a(applicationContext, R.color.qui_common_bg_bottom_standard);
        Context applicationContext2 = MobileQQ.sMobileQQ.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "sMobileQQ.applicationContext");
        colorTextPrimary = oVar.a(applicationContext2, R.color.qui_common_text_primary);
        Context applicationContext3 = MobileQQ.sMobileQQ.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext3, "sMobileQQ.applicationContext");
        colorTextSecondary = oVar.a(applicationContext3, R.color.qui_common_text_secondary);
        Context applicationContext4 = MobileQQ.sMobileQQ.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext4, "sMobileQQ.applicationContext");
        colorSLTextSecondary = oVar.g(applicationContext4, R.color.qui_common_text_secondary);
        Context applicationContext5 = MobileQQ.sMobileQQ.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext5, "sMobileQQ.applicationContext");
        colorFillLightPrimary = oVar.a(applicationContext5, R.color.qui_common_fill_light_primary);
        Context applicationContext6 = MobileQQ.sMobileQQ.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext6, "sMobileQQ.applicationContext");
        colorOverlayStandardPrimary = oVar.a(applicationContext6, R.color.qui_common_overlay_standard_primary);
        Context applicationContext7 = MobileQQ.sMobileQQ.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext7, "sMobileQQ.applicationContext");
        colorOverlayLight = oVar.a(applicationContext7, R.color.qui_common_overlay_light);
    }

    o() {
    }

    private final int a(Context context, int resId) {
        return context.getResources().getColor(resId);
    }

    private final ColorStateList g(Context context, int resId) {
        ColorStateList colorStateList = context.getResources().getColorStateList(resId);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "context.resources.getColorStateList(resId)");
        return colorStateList;
    }

    public final int b() {
        return colorBgBottomStandard;
    }

    public final int c() {
        return colorFillLightPrimary;
    }

    public final int d() {
        return colorOverlayLight;
    }

    public final int e() {
        return colorOverlayStandardPrimary;
    }

    public final ColorStateList f() {
        return colorSLTextSecondary;
    }

    public final int h() {
        return colorTextPrimary;
    }

    public final int i() {
        return colorTextSecondary;
    }

    public final void j(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        colorBgBottomStandard = a(context, R.color.qui_common_bg_bottom_standard);
        colorTextPrimary = a(context, R.color.qui_common_text_primary);
        colorTextSecondary = a(context, R.color.qui_common_text_secondary);
        colorSLTextSecondary = g(context, R.color.qui_common_text_secondary);
        colorFillLightPrimary = a(context, R.color.qui_common_fill_light_primary);
        colorOverlayStandardPrimary = a(context, R.color.qui_common_overlay_standard_primary);
        colorOverlayLight = a(context, R.color.qui_common_overlay_light);
    }
}
