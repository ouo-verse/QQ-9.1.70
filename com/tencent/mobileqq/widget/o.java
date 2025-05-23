package com.tencent.mobileqq.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.IUIServiceProxy;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class o implements FormItemConstants {

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f317121d = {R.drawable.common_strip_setting_bg, R.drawable.common_strip_setting_top, R.drawable.common_strip_setting_middle, R.drawable.common_strip_setting_bottom};

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f317122e = {R.drawable.skin_setting_strip_bg_unpressed, R.drawable.skin_setting_strip_top_unpressed, R.drawable.skin_setting_strip_middle_unpressed, R.drawable.skin_setting_strip_bottom_unpressed};

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f317123f = {R.drawable.lkh, R.drawable.lkh, R.drawable.lkk, R.drawable.lkk};

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f317124h = {R.drawable.jne, R.drawable.jne, R.drawable.jnk, R.drawable.jnk};

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f317125i = {R.drawable.lki, R.drawable.lkj, R.drawable.lkg, R.drawable.lkf};

    /* renamed from: m, reason: collision with root package name */
    private static final int[] f317126m = {R.drawable.jng, R.drawable.jni, R.drawable.jnc, R.drawable.jn_};
    private static String C = QQTheme.getCurrentThemeId();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a extends LevelListDrawable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f317127d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Drawable f317128e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Drawable f317129f;

        a(boolean z16, Drawable drawable, Drawable drawable2) {
            this.f317127d = z16;
            this.f317128e = drawable;
            this.f317129f = drawable2;
        }

        @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            boolean z16;
            if (o.l() && this.f317127d) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return this.f317128e.getPadding(rect);
            }
            return this.f317129f.getPadding(rect);
        }

        @Override // android.graphics.drawable.Drawable
        public void invalidateSelf() {
            int i3;
            if (o.l() && this.f317127d) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            setLevel(i3 ^ 1);
            super.invalidateSelf();
        }
    }

    public static ColorStateList a(Resources resources, int i3) {
        if (i3 != 1) {
            if (i3 != 2 && i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        return resources.getColorStateList(R.color.qui_common_text_primary);
                    }
                    return resources.getColorStateList(R.color.qui_common_text_allwhite_primary);
                }
                return resources.getColorStateList(R.color.skin_qq_setting_deep_clean);
            }
            return resources.getColorStateList(R.color.qui_common_text_secondary);
        }
        return resources.getColorStateList(R.color.qui_common_brand_standard);
    }

    public static float b() {
        if (!l()) {
            return 0.0f;
        }
        return 10.0f;
    }

    public static int c(int i3, int i16) {
        if (i3 == 1) {
            return 0;
        }
        if (i16 == 0) {
            return 1;
        }
        if (i16 == i3 - 1) {
            return 3;
        }
        return 2;
    }

    public static ColorStateList d(Resources resources, int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            return resources.getColorStateList(R.color.skin_black_only_night);
                        }
                        return resources.getColorStateList(R.color.skin_color_white);
                    }
                    return resources.getColorStateList(R.color.skin_qq_setting_deep_clean_only_night);
                }
                return resources.getColorStateList(R.color.skin_gray_group_item_only_night);
            }
            return resources.getColorStateList(R.color.skin_gray_only_night);
        }
        return resources.getColorStateList(R.color.skin_blue_only_night);
    }

    private static int[] e(boolean z16, boolean z17) {
        if (!l()) {
            if (z16) {
                if (o()) {
                    return f317123f;
                }
                return f317121d;
            }
            if (o()) {
                return f317124h;
            }
            return f317122e;
        }
        if (z17 && z16) {
            return f317125i;
        }
        if (z17) {
            return f317126m;
        }
        if (z16) {
            if (o()) {
                return f317123f;
            }
            return f317121d;
        }
        if (o()) {
            return f317124h;
        }
        return f317122e;
    }

    private static int f(int i3) {
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 2;
        }
        if (i3 == 3) {
            return 3;
        }
        return 0;
    }

    public static Drawable g(Resources resources, int i3, boolean z16) {
        return h(resources, i3, z16, true);
    }

    public static Drawable h(Resources resources, int i3, boolean z16, boolean z17) {
        return i(resources, i3, z16, z17, resources.getDrawable(e(z16, false)[f(i3)]));
    }

    public static Drawable i(Resources resources, int i3, boolean z16, boolean z17, Drawable drawable) {
        Drawable drawable2 = resources.getDrawable(e(z16, true)[f(i3)]);
        a aVar = new a(z17, drawable2, drawable);
        aVar.addLevel(0, 0, drawable2);
        aVar.addLevel(1, 1, drawable);
        if (l() && z17) {
            aVar.setLevel(0);
        } else {
            aVar.setLevel(1);
        }
        return aVar;
    }

    private static boolean j() {
        if (!"1000".equals(C) && !"1103".equals(C) && !QQTheme.isThemeSimpleUI(C)) {
            return true;
        }
        return false;
    }

    public static void k() {
        String currentThemeId = QQTheme.getCurrentThemeId();
        C = currentThemeId;
        QLog.d("FormResHelper", 1, "sCurThemeId : ", currentThemeId);
    }

    public static boolean l() {
        boolean isLargeFont = ((IUIServiceProxy) QRoute.api(IUIServiceProxy.class)).isLargeFont();
        if ((o() || !j()) && !isLargeFont) {
            return true;
        }
        return false;
    }

    public static void m(View view, int i3, boolean z16) {
        if (view == null || !l()) {
            return;
        }
        view.setBackgroundDrawable(g(view.getResources(), i3, z16));
    }

    public static void n(View view, int i3, boolean z16, Drawable drawable) {
        if (view == null) {
            return;
        }
        view.setBackgroundDrawable(i(view.getResources(), i3, z16, true, drawable));
    }

    private static boolean o() {
        try {
            return ((IUIServiceProxy) QRoute.api(IUIServiceProxy.class)).useQUIToken();
        } catch (Exception unused) {
            return false;
        }
    }
}
