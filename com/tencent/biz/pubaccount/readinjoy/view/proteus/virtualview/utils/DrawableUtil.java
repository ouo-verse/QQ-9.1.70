package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;

/* compiled from: P */
/* loaded from: classes4.dex */
public class DrawableUtil {
    private static final String TAG = "DrawableUtil";
    private static DrawableHelper drawableHelper;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface DrawableCallBack {
        void onCallBack(boolean z16, Drawable drawable);
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface DrawableHelper {
        Drawable getDrawable(Context context, String str, Drawable drawable, Drawable drawable2);

        Drawable getDrawableFromNet(Context context, String str, Drawable drawable, Drawable drawable2, int i3, int i16, DrawableCallBack drawableCallBack);
    }

    public static Drawable getDrawable(Context context, String str, Drawable drawable, Drawable drawable2) {
        if (str == null) {
            return null;
        }
        DrawableHelper drawableHelper2 = drawableHelper;
        Drawable drawable3 = drawableHelper2 != null ? drawableHelper2.getDrawable(context, str, drawable, drawable2) : null;
        if (drawable3 != null) {
            return drawable3;
        }
        Integer drawableResourceId = ImageCommon.getDrawableResourceId(str);
        if (drawableResourceId != null) {
            try {
                return context.getResources().getDrawable(drawableResourceId.intValue());
            } catch (Resources.NotFoundException unused) {
                LogUtil.QLog.d("readinjoy.proteus", 2, "getDrawable: cant find in resources dir, do nothing");
            }
        }
        LogUtil.QLog.e("readinjoy.proteus", 2, "getDrawable: cant find path :" + str);
        return null;
    }

    public static Drawable getDrawableFromNet(Context context, String str, Drawable drawable, Drawable drawable2, int i3, int i16, DrawableCallBack drawableCallBack) {
        DrawableHelper drawableHelper2 = drawableHelper;
        if (drawableHelper2 == null) {
            return null;
        }
        return drawableHelper2.getDrawableFromNet(context, str, drawable, drawable2, i3, i16, drawableCallBack);
    }

    public static StateListDrawable getSelector(Drawable drawable, Drawable drawable2, Drawable drawable3) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (drawable2 != null) {
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, drawable2);
        }
        if (drawable3 != null) {
            stateListDrawable.addState(new int[]{R.attr.state_selected}, drawable3);
        }
        if (drawable != null) {
            stateListDrawable.addState(new int[0], drawable);
        }
        return stateListDrawable;
    }

    public static void setDrawableHelper(DrawableHelper drawableHelper2) {
        if (drawableHelper2 == null) {
            return;
        }
        drawableHelper = drawableHelper2;
    }

    public static StateListDrawable getSelector(String str, String str2, String str3) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (str2 != null) {
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, getDrawable(str2));
        }
        if (str3 != null) {
            stateListDrawable.addState(new int[]{R.attr.state_selected}, getDrawable(str3));
        }
        if (str != null) {
            stateListDrawable.addState(new int[0], getDrawable(str));
        }
        return stateListDrawable;
    }

    public static Drawable getDrawable(String str) {
        return new ColorDrawable(Utils.parseColor(str));
    }
}
