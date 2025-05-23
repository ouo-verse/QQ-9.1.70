package com.gyf.immersionbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes2.dex */
class SpecialBarFontUtils {
    private static int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
    private static Method mSetStatusBarColorIcon;
    private static Method mSetStatusBarDarkIcon;
    private static Field mStatusBarColorFiled;

    static {
        try {
            mSetStatusBarColorIcon = Activity.class.getMethod("setStatusBarDarkIcon", Integer.TYPE);
        } catch (NoSuchMethodException unused) {
        }
        try {
            mSetStatusBarDarkIcon = Activity.class.getMethod("setStatusBarDarkIcon", Boolean.TYPE);
        } catch (NoSuchMethodException unused2) {
        }
        try {
            mStatusBarColorFiled = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException unused3) {
        }
        try {
            SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);
        } catch (IllegalAccessException | NoSuchFieldException unused4) {
        }
    }

    SpecialBarFontUtils() {
    }

    private static boolean changeMeizuFlag(WindowManager.LayoutParams layoutParams, String str, boolean z16) {
        int i3;
        try {
            Field declaredField = layoutParams.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            int i16 = declaredField.getInt(layoutParams);
            Field declaredField2 = layoutParams.getClass().getDeclaredField("meizuFlags");
            declaredField2.setAccessible(true);
            int i17 = declaredField2.getInt(layoutParams);
            if (z16) {
                i3 = i16 | i17;
            } else {
                i3 = (~i16) & i17;
            }
            if (i17 != i3) {
                declaredField2.setInt(layoutParams, i3);
                return true;
            }
            return false;
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
            return false;
        } catch (IllegalArgumentException e17) {
            e17.printStackTrace();
            return false;
        } catch (NoSuchFieldException e18) {
            e18.printStackTrace();
            return false;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    static boolean isBlackColor(int i3, int i16) {
        if (toGrey(i3) < i16) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"PrivateApi"})
    public static void setMIUIBarDark(Window window, String str, boolean z16) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i3 = cls2.getField(str).getInt(cls2);
                Class<?> cls3 = Integer.TYPE;
                Method method = cls.getMethod("setExtraFlags", cls3, cls3);
                if (z16) {
                    method.invoke(window, Integer.valueOf(i3), Integer.valueOf(i3));
                } else {
                    method.invoke(window, 0, Integer.valueOf(i3));
                }
            } catch (Exception unused) {
            }
        }
    }

    private static void setStatusBarColor(Window window, int i3) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Field field = mStatusBarColorFiled;
        if (field != null) {
            try {
                if (field.getInt(attributes) != i3) {
                    mStatusBarColorFiled.set(attributes, Integer.valueOf(i3));
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
            }
        }
    }

    public static void setStatusBarDarkIcon(Activity activity, int i3) {
        Method method = mSetStatusBarColorIcon;
        if (method != null) {
            try {
                method.invoke(activity, Integer.valueOf(i3));
                return;
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
                return;
            } catch (InvocationTargetException e17) {
                e17.printStackTrace();
                return;
            }
        }
        boolean isBlackColor = isBlackColor(i3, 50);
        if (mStatusBarColorFiled != null) {
            setStatusBarDarkIcon(activity, isBlackColor, isBlackColor);
            setStatusBarDarkIcon(activity.getWindow(), i3);
        } else {
            setStatusBarDarkIcon(activity, isBlackColor);
        }
    }

    static int toGrey(int i3) {
        return (((((i3 & ITVKAsset.VOD_ASSET_MASK_BIT) >> 16) * 38) + (((65280 & i3) >> 8) * 75)) + ((i3 & 255) * 15)) >> 7;
    }

    public static void setStatusBarDarkIcon(Window window, int i3) {
        try {
            setStatusBarColor(window, i3);
            setStatusBarDarkIcon(window.getDecorView(), true);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void setStatusBarDarkIcon(Activity activity, boolean z16) {
        setStatusBarDarkIcon(activity, z16, true);
    }

    private static void setStatusBarDarkIcon(View view, boolean z16) {
        int i3;
        int systemUiVisibility = view.getSystemUiVisibility();
        if (z16) {
            i3 = SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | systemUiVisibility;
        } else {
            i3 = (~SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) & systemUiVisibility;
        }
        if (i3 != systemUiVisibility) {
            view.setSystemUiVisibility(i3);
        }
    }

    public static void setStatusBarDarkIcon(Window window, boolean z16) {
        setStatusBarDarkIcon(window.getDecorView(), z16);
        setStatusBarColor(window, 0);
    }

    private static void setStatusBarDarkIcon(Activity activity, boolean z16, boolean z17) {
        Method method = mSetStatusBarDarkIcon;
        if (method == null) {
            if (z17) {
                setStatusBarDarkIcon(activity.getWindow(), z16);
                return;
            }
            return;
        }
        try {
            method.invoke(activity, Boolean.valueOf(z16));
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
        } catch (InvocationTargetException e17) {
            e17.printStackTrace();
        }
    }
}
