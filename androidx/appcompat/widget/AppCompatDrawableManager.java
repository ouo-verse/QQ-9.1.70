package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.graphics.ColorUtils;
import com.tencent.mobileqq.R;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class AppCompatDrawableManager {
    private static final boolean DEBUG = false;
    private static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    private static AppCompatDrawableManager INSTANCE = null;
    private static final String TAG = "AppCompatDrawableManag";
    private ResourceManagerInternal mResourceManager;

    public static synchronized AppCompatDrawableManager get() {
        AppCompatDrawableManager appCompatDrawableManager;
        synchronized (AppCompatDrawableManager.class) {
            if (INSTANCE == null) {
                preload();
            }
            appCompatDrawableManager = INSTANCE;
        }
        return appCompatDrawableManager;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i3, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (AppCompatDrawableManager.class) {
            porterDuffColorFilter = ResourceManagerInternal.getPorterDuffColorFilter(i3, mode);
        }
        return porterDuffColorFilter;
    }

    public static synchronized void preload() {
        synchronized (AppCompatDrawableManager.class) {
            if (INSTANCE == null) {
                AppCompatDrawableManager appCompatDrawableManager = new AppCompatDrawableManager();
                INSTANCE = appCompatDrawableManager;
                appCompatDrawableManager.mResourceManager = ResourceManagerInternal.get();
                INSTANCE.mResourceManager.setHooks(new ResourceManagerInternal.ResourceManagerHooks() { // from class: androidx.appcompat.widget.AppCompatDrawableManager.1
                    private final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL = {R.drawable.m_t, R.drawable.m_r, R.drawable.m9k};
                    private final int[] TINT_COLOR_CONTROL_NORMAL = {R.drawable.m9s, R.drawable.j0z, R.drawable.m9x, R.drawable.m9t, R.drawable.m9u, R.drawable.m9w, R.drawable.m9v};
                    private final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED = {R.drawable.m_q, R.drawable.m_s, R.drawable.m9r, R.drawable.f160015j14, R.drawable.m_k, R.drawable.m_m, R.drawable.m_o, R.drawable.m_l, R.drawable.m_n, R.drawable.m_p};
                    private final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY = {R.drawable.m_b, R.drawable.j0c, R.drawable.m_a};
                    private final int[] TINT_COLOR_CONTROL_STATE_LIST = {R.drawable.f160014j13, R.drawable.f160016j15};
                    private final int[] TINT_CHECKABLE_BUTTON_LIST = {R.drawable.j07, R.drawable.j0a, R.drawable.j08, R.drawable.j0b};

                    private boolean arrayContains(int[] iArr, int i3) {
                        for (int i16 : iArr) {
                            if (i16 == i3) {
                                return true;
                            }
                        }
                        return false;
                    }

                    private ColorStateList createBorderlessButtonColorStateList(@NonNull Context context) {
                        return createButtonColorStateList(context, 0);
                    }

                    private ColorStateList createButtonColorStateList(@NonNull Context context, @ColorInt int i3) {
                        int themeAttrColor = ThemeUtils.getThemeAttrColor(context, R.attr.a7p);
                        return new ColorStateList(new int[][]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.PRESSED_STATE_SET, ThemeUtils.FOCUSED_STATE_SET, ThemeUtils.EMPTY_STATE_SET}, new int[]{ThemeUtils.getDisabledThemeAttrColor(context, R.attr.a7m), ColorUtils.compositeColors(themeAttrColor, i3), ColorUtils.compositeColors(themeAttrColor, i3), i3});
                    }

                    private ColorStateList createColoredButtonColorStateList(@NonNull Context context) {
                        return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R.attr.a7k));
                    }

                    private ColorStateList createDefaultButtonColorStateList(@NonNull Context context) {
                        return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R.attr.a7m));
                    }

                    private ColorStateList createSwitchThumbColorStateList(Context context) {
                        int[][] iArr = new int[3];
                        int[] iArr2 = new int[3];
                        ColorStateList themeAttrColorStateList = ThemeUtils.getThemeAttrColorStateList(context, R.attr.a8j);
                        if (themeAttrColorStateList != null && themeAttrColorStateList.isStateful()) {
                            int[] iArr3 = ThemeUtils.DISABLED_STATE_SET;
                            iArr[0] = iArr3;
                            iArr2[0] = themeAttrColorStateList.getColorForState(iArr3, 0);
                            iArr[1] = ThemeUtils.CHECKED_STATE_SET;
                            iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.a7o);
                            iArr[2] = ThemeUtils.EMPTY_STATE_SET;
                            iArr2[2] = themeAttrColorStateList.getDefaultColor();
                        } else {
                            iArr[0] = ThemeUtils.DISABLED_STATE_SET;
                            iArr2[0] = ThemeUtils.getDisabledThemeAttrColor(context, R.attr.a8j);
                            iArr[1] = ThemeUtils.CHECKED_STATE_SET;
                            iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.a7o);
                            iArr[2] = ThemeUtils.EMPTY_STATE_SET;
                            iArr2[2] = ThemeUtils.getThemeAttrColor(context, R.attr.a8j);
                        }
                        return new ColorStateList(iArr, iArr2);
                    }

                    private void setPorterDuffColorFilter(Drawable drawable, int i3, PorterDuff.Mode mode) {
                        if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                            drawable = drawable.mutate();
                        }
                        if (mode == null) {
                            mode = AppCompatDrawableManager.DEFAULT_MODE;
                        }
                        drawable.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(i3, mode));
                    }

                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    public Drawable createDrawableFor(@NonNull ResourceManagerInternal resourceManagerInternal, @NonNull Context context, int i3) {
                        if (i3 == R.drawable.j0d) {
                            return new LayerDrawable(new Drawable[]{resourceManagerInternal.getDrawable(context, R.drawable.j0c), resourceManagerInternal.getDrawable(context, R.drawable.m9r)});
                        }
                        return null;
                    }

                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    public ColorStateList getTintListForDrawableRes(@NonNull Context context, int i3) {
                        if (i3 == R.drawable.j0g) {
                            return AppCompatResources.getColorStateList(context, R.color.b39);
                        }
                        if (i3 == R.drawable.m_i) {
                            return AppCompatResources.getColorStateList(context, R.color.b3b);
                        }
                        if (i3 == R.drawable.f160013j12) {
                            return createSwitchThumbColorStateList(context);
                        }
                        if (i3 == R.drawable.j0_) {
                            return createDefaultButtonColorStateList(context);
                        }
                        if (i3 == R.drawable.j06) {
                            return createBorderlessButtonColorStateList(context);
                        }
                        if (i3 == R.drawable.j09) {
                            return createColoredButtonColorStateList(context);
                        }
                        if (i3 != R.drawable.m_h && i3 != R.drawable.f160012j11) {
                            if (arrayContains(this.TINT_COLOR_CONTROL_NORMAL, i3)) {
                                return ThemeUtils.getThemeAttrColorStateList(context, R.attr.a7q);
                            }
                            if (arrayContains(this.TINT_COLOR_CONTROL_STATE_LIST, i3)) {
                                return AppCompatResources.getColorStateList(context, R.color.b38);
                            }
                            if (arrayContains(this.TINT_CHECKABLE_BUTTON_LIST, i3)) {
                                return AppCompatResources.getColorStateList(context, R.color.b37);
                            }
                            if (i3 == R.drawable.j0y) {
                                return AppCompatResources.getColorStateList(context, R.color.b3_);
                            }
                            return null;
                        }
                        return AppCompatResources.getColorStateList(context, R.color.b3a);
                    }

                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    public PorterDuff.Mode getTintModeForDrawableRes(int i3) {
                        if (i3 == R.drawable.f160013j12) {
                            return PorterDuff.Mode.MULTIPLY;
                        }
                        return null;
                    }

                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    public boolean tintDrawable(@NonNull Context context, int i3, @NonNull Drawable drawable) {
                        if (i3 == R.drawable.f160011j10) {
                            LayerDrawable layerDrawable = (LayerDrawable) drawable;
                            setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(android.R.id.background), ThemeUtils.getThemeAttrColor(context, R.attr.a7q), AppCompatDrawableManager.DEFAULT_MODE);
                            setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress), ThemeUtils.getThemeAttrColor(context, R.attr.a7q), AppCompatDrawableManager.DEFAULT_MODE);
                            setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(android.R.id.progress), ThemeUtils.getThemeAttrColor(context, R.attr.a7o), AppCompatDrawableManager.DEFAULT_MODE);
                            return true;
                        }
                        if (i3 != R.drawable.j0w && i3 != R.drawable.j0v && i3 != R.drawable.j0x) {
                            return false;
                        }
                        LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                        setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(android.R.id.background), ThemeUtils.getDisabledThemeAttrColor(context, R.attr.a7q), AppCompatDrawableManager.DEFAULT_MODE);
                        setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(android.R.id.secondaryProgress), ThemeUtils.getThemeAttrColor(context, R.attr.a7o), AppCompatDrawableManager.DEFAULT_MODE);
                        setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(android.R.id.progress), ThemeUtils.getThemeAttrColor(context, R.attr.a7o), AppCompatDrawableManager.DEFAULT_MODE);
                        return true;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0070 A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0055  */
                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public boolean tintDrawableUsingColorFilter(@NonNull Context context, int i3, @NonNull Drawable drawable) {
                        PorterDuff.Mode mode;
                        int i16;
                        boolean z16;
                        int round;
                        PorterDuff.Mode mode2 = AppCompatDrawableManager.DEFAULT_MODE;
                        if (arrayContains(this.COLORFILTER_TINT_COLOR_CONTROL_NORMAL, i3)) {
                            i16 = R.attr.a7q;
                        } else if (arrayContains(this.COLORFILTER_COLOR_CONTROL_ACTIVATED, i3)) {
                            i16 = R.attr.a7o;
                        } else {
                            if (arrayContains(this.COLORFILTER_COLOR_BACKGROUND_MULTIPLY, i3)) {
                                mode2 = PorterDuff.Mode.MULTIPLY;
                            } else {
                                if (i3 == R.drawable.m_4) {
                                    z16 = true;
                                    round = Math.round(40.8f);
                                    i16 = 16842800;
                                    mode = mode2;
                                    if (z16) {
                                        return false;
                                    }
                                    if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                                        drawable = drawable.mutate();
                                    }
                                    drawable.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(ThemeUtils.getThemeAttrColor(context, i16), mode));
                                    if (round != -1) {
                                        drawable.setAlpha(round);
                                    }
                                    return true;
                                }
                                if (i3 != R.drawable.j0f) {
                                    mode = mode2;
                                    i16 = 0;
                                    z16 = false;
                                    round = -1;
                                    if (z16) {
                                    }
                                }
                            }
                            mode = mode2;
                            round = -1;
                            i16 = 16842801;
                            z16 = true;
                            if (z16) {
                            }
                        }
                        mode = mode2;
                        z16 = true;
                        round = -1;
                        if (z16) {
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void tintDrawable(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        ResourceManagerInternal.tintDrawable(drawable, tintInfo, iArr);
    }

    public synchronized Drawable getDrawable(@NonNull Context context, @DrawableRes int i3) {
        return this.mResourceManager.getDrawable(context, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ColorStateList getTintList(@NonNull Context context, @DrawableRes int i3) {
        return this.mResourceManager.getTintList(context, i3);
    }

    public synchronized void onConfigurationChanged(@NonNull Context context) {
        this.mResourceManager.onConfigurationChanged(context);
    }

    synchronized Drawable onDrawableLoadedFromResources(@NonNull Context context, @NonNull VectorEnabledTintResources vectorEnabledTintResources, @DrawableRes int i3) {
        return this.mResourceManager.onDrawableLoadedFromResources(context, vectorEnabledTintResources, i3);
    }

    boolean tintDrawableUsingColorFilter(@NonNull Context context, @DrawableRes int i3, @NonNull Drawable drawable) {
        return this.mResourceManager.tintDrawableUsingColorFilter(context, i3, drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable getDrawable(@NonNull Context context, @DrawableRes int i3, boolean z16) {
        return this.mResourceManager.getDrawable(context, i3, z16);
    }
}
