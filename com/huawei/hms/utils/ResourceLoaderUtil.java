package com.huawei.hms.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class ResourceLoaderUtil {

    /* renamed from: a, reason: collision with root package name */
    private static Context f37717a;

    /* renamed from: b, reason: collision with root package name */
    private static String f37718b;

    public static int getAnimId(String str) {
        return f37717a.getResources().getIdentifier(str, "anim", f37718b);
    }

    public static int getColorId(String str) {
        return f37717a.getResources().getIdentifier(str, "color", f37718b);
    }

    public static int getDimenId(String str) {
        return f37717a.getResources().getIdentifier(str, "dimen", f37718b);
    }

    public static Drawable getDrawable(String str) {
        return f37717a.getResources().getDrawable(getDrawableId(str));
    }

    public static int getDrawableId(String str) {
        return f37717a.getResources().getIdentifier(str, "drawable", f37718b);
    }

    public static int getIdId(String str) {
        return f37717a.getResources().getIdentifier(str, "id", f37718b);
    }

    public static int getLayoutId(String str) {
        return f37717a.getResources().getIdentifier(str, TtmlNode.TAG_LAYOUT, f37718b);
    }

    public static String getString(String str) {
        return f37717a.getResources().getString(getStringId(str));
    }

    public static int getStringId(String str) {
        return f37717a.getResources().getIdentifier(str, HippyControllerProps.STRING, f37718b);
    }

    public static int getStyleId(String str) {
        return f37717a.getResources().getIdentifier(str, "style", f37718b);
    }

    public static Context getmContext() {
        return f37717a;
    }

    public static void setmContext(Context context) {
        f37717a = context;
        f37718b = context.getPackageName();
    }

    public static String getString(String str, Object... objArr) {
        return f37717a.getResources().getString(getStringId(str), objArr);
    }
}
