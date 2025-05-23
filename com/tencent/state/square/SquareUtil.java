package com.tencent.state.square;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.Window;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.common.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0018\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/state/square/SquareUtil;", "", "()V", "SHAKE_FROM_AVATAR", "", "SHAKE_FROM_LIBRARY_NOTICE", "SHAKE_FROM_LIKE", "TAG", "", "canPlayWithDownload", "", "getScreenHeight", "percent", "", "getScreenWidth", "getStatusBarHeight", "context", "Landroid/content/Context;", "getUrlDrawableOptions", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "loadingDrawable", "Landroid/graphics/drawable/Drawable;", "failedDrawable", "setKeepScreen", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "isKeepOn", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class SquareUtil {

    @NotNull
    public static final SquareUtil INSTANCE = new SquareUtil();
    public static final int SHAKE_FROM_AVATAR = 3;
    public static final int SHAKE_FROM_LIBRARY_NOTICE = 2;
    public static final int SHAKE_FROM_LIKE = 1;

    @NotNull
    public static final String TAG = "SquareUtil";

    SquareUtil() {
    }

    public static /* synthetic */ int getScreenHeight$default(SquareUtil squareUtil, float f16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = 1.0f;
        }
        return squareUtil.getScreenHeight(f16);
    }

    public static /* synthetic */ int getScreenWidth$default(SquareUtil squareUtil, float f16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = 1.0f;
        }
        return squareUtil.getScreenWidth(f16);
    }

    public static /* synthetic */ URLDrawable.URLDrawableOptions getUrlDrawableOptions$default(SquareUtil squareUtil, Drawable drawable, Drawable drawable2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            drawable = new ColorDrawable(0);
        }
        if ((i3 & 2) != 0) {
            drawable2 = drawable;
        }
        return squareUtil.getUrlDrawableOptions(drawable, drawable2);
    }

    public final boolean canPlayWithDownload() {
        return true;
    }

    public final int getScreenHeight(float percent) {
        Resources resources;
        DisplayMetrics displayMetrics;
        Application app = SquareBase.INSTANCE.getApp();
        if (app != null && (resources = app.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            return (int) (displayMetrics.heightPixels * percent);
        }
        return 0;
    }

    public final int getScreenWidth(float percent) {
        Resources resources;
        DisplayMetrics displayMetrics;
        Application app = SquareBase.INSTANCE.getApp();
        if (app != null && (resources = app.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            return (int) (displayMetrics.widthPixels * percent);
        }
        return 0;
    }

    public final int getStatusBarHeight(@NotNull Context context) {
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            i3 = context.getResources().getDimensionPixelSize(identifier);
        } else {
            i3 = -1;
        }
        if (i3 <= 0) {
            return ViewExtensionsKt.dip(context, 25.0f);
        }
        return i3;
    }

    @NotNull
    public final URLDrawable.URLDrawableOptions getUrlDrawableOptions(@Nullable Drawable loadingDrawable, @Nullable Drawable failedDrawable) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = loadingDrawable;
        obtain.mFailedDrawable = failedDrawable;
        obtain.mKeyAddWHSuffix = false;
        obtain.mUseAutoScaleParams = false;
        Intrinsics.checkNotNullExpressionValue(obtain, "URLDrawable.URLDrawableO\u2026\u4e0b\u8f7d\u56fe\u7247\u4e0d\u9700\u8981\u505adpi\u9002\u914d\u7f29\u653e\n        }");
        return obtain;
    }

    public final void setKeepScreen(@Nullable Activity r75, boolean isKeepOn) {
        try {
            if (isKeepOn) {
                if (r75 != null) {
                    Window window = r75.getWindow();
                    if (window != null) {
                        window.addFlags(128);
                    }
                }
            } else if (r75 != null) {
                Window window2 = r75.getWindow();
                if (window2 != null) {
                    window2.clearFlags(128);
                }
            }
        } catch (Exception e16) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "setKeepScreen error " + e16, null, 4, null);
        }
    }
}
