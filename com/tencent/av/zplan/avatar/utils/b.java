package com.tencent.av.zplan.avatar.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import com.tencent.aelight.camera.api.IWinkZShowViewForOnlineStatusProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u001e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002\u001a\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e\u00a8\u0006\u0012"}, d2 = {"Landroid/content/res/Resources;", "res", "", "position", "rootWidth", "rootHeight", "Landroid/graphics/Rect;", "outRect", "", "c", "currentRect", "b", "Landroid/content/Context;", "context", "", "showProgress", "Lcom/tencent/aelight/camera/api/IWinkZShowViewForOnlineStatusProvider$a;", "a", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class b {
    @NotNull
    public static final IWinkZShowViewForOnlineStatusProvider.a a(@NotNull Context context, boolean z16) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.f17859373);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026plan_call_loading_avatar)");
        return ((IWinkZShowViewForOnlineStatusProvider) QRoute.api(IWinkZShowViewForOnlineStatusProvider.class)).getLoadingView(context, new IWinkZShowViewForOnlineStatusProvider.LoadViewConfig(string, 0, 0, z16, ViewUtils.dpToPx(124.0f), 0, 38, null));
    }

    public static final int b(@NotNull Rect currentRect, int i3, int i16) {
        Intrinsics.checkNotNullParameter(currentRect, "currentRect");
        int i17 = i3 / 2;
        int i18 = i16 / 2;
        int centerX = currentRect.centerX();
        int centerY = currentRect.centerY();
        if (centerX < i17 && centerY < i18) {
            return 1;
        }
        if (centerX < i17 && centerY > i18) {
            return 4;
        }
        if (centerX > i17 && centerY < i18) {
            return 2;
        }
        if (centerX > i17 && centerY > i18) {
            return 3;
        }
        return 0;
    }

    public static final void c(@NotNull Resources res, int i3, int i16, int i17, @NotNull Rect outRect) {
        int i18;
        int i19;
        int i26;
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        int dimensionPixelSize = res.getDimensionPixelSize(R.dimen.b27);
        int dimensionPixelSize2 = res.getDimensionPixelSize(R.dimen.f159623b24);
        int dimensionPixelSize3 = res.getDimensionPixelSize(R.dimen.f159624b25);
        int dimensionPixelSize4 = res.getDimensionPixelSize(R.dimen.b26);
        int dpToPx = ViewUtils.dpToPx(70.0f);
        int dpToPx2 = ViewUtils.dpToPx(140.0f);
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        dimensionPixelSize3 = 0;
                        i18 = 0;
                        i19 = 0;
                        i26 = 0;
                    } else {
                        i19 = dimensionPixelSize3 + dimensionPixelSize;
                        int i27 = (i17 - dimensionPixelSize4) - dpToPx2;
                        i26 = i27;
                        i18 = i27 - dimensionPixelSize2;
                    }
                } else {
                    int i28 = i16 - dimensionPixelSize3;
                    int i29 = (i17 - dimensionPixelSize4) - dpToPx2;
                    i26 = i29;
                    i18 = i29 - dimensionPixelSize2;
                    dimensionPixelSize3 = i28 - dimensionPixelSize;
                    i19 = i28;
                }
            } else {
                int i36 = i16 - dimensionPixelSize3;
                i18 = dimensionPixelSize4 + dpToPx;
                i26 = i18 + dimensionPixelSize2;
                dimensionPixelSize3 = i36 - dimensionPixelSize;
                i19 = i36;
            }
        } else {
            i18 = dimensionPixelSize4 + dpToPx;
            i19 = dimensionPixelSize3 + dimensionPixelSize;
            i26 = i18 + dimensionPixelSize2;
        }
        outRect.set(dimensionPixelSize3, i18, i19, i26);
    }
}
