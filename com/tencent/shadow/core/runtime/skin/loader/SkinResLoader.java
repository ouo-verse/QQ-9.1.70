package com.tencent.shadow.core.runtime.skin.loader;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Array;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SkinResLoader {
    private static final ColorStateList COLORSTATELIST_NULL = null;
    private static final int COLOR_NULL = 0;
    private static final int DIMEN_NULL = 0;
    private static final Drawable DRAWABLE_NULL = null;
    private static final String RES_COLOR = "color";
    private static final String RES_DIMEN = "dimen";
    private static final String RES_DRAWABLE = "drawable";
    private static final String TAG = "SkinResLoader";

    public static int getColor(int i3, String str) {
        if (i3 <= 0) {
            Log.e(TAG, "getColor invalid resId : " + i3);
            return 0;
        }
        Resources resources = ContextHolder.getContext().getResources();
        Resources skinResource = SkinManager.getsInstance().getSkinResource();
        String packageName = SkinManager.getsInstance().getPackageName();
        try {
            int color = resources.getColor(i3);
            if (skinResource == null) {
                return color;
            }
            if (str == null) {
                try {
                    str = resources.getResourceEntryName(i3);
                } catch (Resources.NotFoundException unused) {
                    Log.e(TAG, "getColor skin NotFoundException resId : " + i3);
                    return color;
                }
            }
            int identifier = skinResource.getIdentifier(str, "color", packageName);
            return identifier <= 0 ? color : skinResource.getColor(identifier);
        } catch (Resources.NotFoundException unused2) {
            Log.e(TAG, "getColor default NotFoundException resId : " + i3);
            return 0;
        }
    }

    private static int getColorByName(Resources resources, String str, String str2) {
        if (resources == null) {
            return 0;
        }
        try {
            int identifier = resources.getIdentifier(str, "color", str2);
            if (identifier <= 0) {
                return 0;
            }
            return resources.getColor(identifier);
        } catch (Resources.NotFoundException unused) {
            Log.i(TAG, "getColor skin NotFoundException resId ");
            return 0;
        }
    }

    public static ColorStateList getColorStateList(int i3, String str) {
        if (i3 <= 0) {
            Log.e(TAG, "getColorStateList invalid resId : " + i3);
            return COLORSTATELIST_NULL;
        }
        Resources resources = ContextHolder.getContext().getResources();
        Resources skinResource = SkinManager.getsInstance().getSkinResource();
        String packageName = SkinManager.getsInstance().getPackageName();
        try {
            ColorStateList colorStateList = resources.getColorStateList(i3);
            if (skinResource == null) {
                return colorStateList;
            }
            if (str == null) {
                try {
                    str = resources.getResourceEntryName(i3);
                } catch (Resources.NotFoundException unused) {
                    Log.e(TAG, "getColorStateList skin NotFoundException resId : " + i3);
                    return colorStateList;
                }
            }
            int identifier = skinResource.getIdentifier(str, "color", packageName);
            if (identifier <= 0) {
                return colorStateList;
            }
            return skinResource.getColorStateList(identifier);
        } catch (Resources.NotFoundException unused2) {
            Log.w(TAG, "getColorStateList try to getColor\uff0c default NotFoundException resId : " + i3);
            return makeColorStateList(getColor(i3, str));
        }
    }

    public static float getDimenPx(int i3) {
        if (i3 <= 0) {
            Log.e(TAG, "getDimenPx invalid resId : " + i3);
            return 0.0f;
        }
        Resources resources = ContextHolder.getContext().getResources();
        Resources skinResource = SkinManager.getsInstance().getSkinResource();
        String packageName = SkinManager.getsInstance().getPackageName();
        try {
            int dimensionPixelSize = resources.getDimensionPixelSize(i3);
            if (skinResource == null) {
                return dimensionPixelSize;
            }
            try {
                if (skinResource.getIdentifier(resources.getResourceEntryName(i3), RES_DIMEN, packageName) <= 0) {
                    return dimensionPixelSize;
                }
                return skinResource.getDimensionPixelSize(r1);
            } catch (Resources.NotFoundException unused) {
                Log.e(TAG, "getDimenPx skin NotFoundException resId : " + i3);
                return dimensionPixelSize;
            }
        } catch (Resources.NotFoundException unused2) {
            Log.e(TAG, "getDimenPx default NotFoundException resId : " + i3);
            return 0.0f;
        }
    }

    public static Drawable getDrawable(int i3, String str) {
        if (i3 <= 0) {
            Log.e(TAG, "getDrawable invalid resId : " + i3);
            return DRAWABLE_NULL;
        }
        Resources resources = ContextHolder.getContext().getResources();
        Resources skinResource = SkinManager.getsInstance().getSkinResource();
        String packageName = SkinManager.getsInstance().getPackageName();
        try {
            Drawable drawable = resources.getDrawable(i3);
            if (skinResource == null) {
                return drawable;
            }
            if (str == null) {
                try {
                    str = resources.getResourceEntryName(i3);
                } catch (Resources.NotFoundException unused) {
                    Log.i(TAG, "getDrawable skin NotFoundException resId : " + i3);
                    return drawable;
                }
            }
            int identifier = skinResource.getIdentifier(str, RES_DRAWABLE, packageName);
            return identifier <= 0 ? drawable : skinResource.getDrawable(identifier, null);
        } catch (Resources.NotFoundException unused2) {
            Log.e(TAG, "getDrawable default NotFoundException resId : " + i3);
            return DRAWABLE_NULL;
        }
    }

    private static Drawable getDrawableByName(Resources resources, String str, String str2) {
        if (resources == null) {
            return null;
        }
        try {
            int identifier = resources.getIdentifier(str, RES_DRAWABLE, str2);
            if (identifier <= 0) {
                return null;
            }
            return resources.getDrawable(identifier, null);
        } catch (Resources.NotFoundException unused) {
            Log.i(TAG, "getDrawable skin NotFoundException resId ");
            return null;
        }
    }

    private static ColorStateList makeColorStateList(int i3) {
        return new ColorStateList((int[][]) Array.newInstance((Class<?>) Integer.TYPE, 1, 1), new int[]{i3});
    }

    public static int getColor(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        ContextHolder.getContext().getResources();
        Resources skinResource = SkinManager.getsInstance().getSkinResource();
        String packageName = SkinManager.getsInstance().getPackageName();
        int colorByName = getColorByName(skinResource, str, packageName);
        return colorByName == 0 ? getColorByName(skinResource, str, packageName) : colorByName;
    }

    public static Drawable getDrawable(String str) {
        if (TextUtils.isEmpty(str)) {
            return DRAWABLE_NULL;
        }
        Resources resources = ContextHolder.getContext().getResources();
        Drawable drawableByName = getDrawableByName(SkinManager.getsInstance().getSkinResource(), str, SkinManager.getsInstance().getPackageName());
        return drawableByName == null ? getDrawableByName(resources, str, ContextHolder.getContext().getPackageName()) : drawableByName;
    }
}
