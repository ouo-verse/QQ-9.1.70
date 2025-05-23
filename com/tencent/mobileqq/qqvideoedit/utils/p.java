package com.tencent.mobileqq.qqvideoedit.utils;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a8\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\n"}, d2 = {"Landroid/widget/ImageView;", "view", "", "staticThumbUrl", "dynamicThumbUrl", "modeLoop", "Landroid/graphics/drawable/Drawable;", "defaultDrawable", "", "a", "qqvideoedit_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class p {
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0040 A[Catch: MalformedURLException -> 0x0072, TryCatch #0 {MalformedURLException -> 0x0072, blocks: (B:12:0x0028, B:15:0x0033, B:21:0x0040, B:32:0x0048), top: B:11:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(@NotNull ImageView view, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Drawable drawable) {
        boolean z16;
        URL url;
        URLDrawable drawable2;
        boolean z17;
        Intrinsics.checkNotNullParameter(view, "view");
        if (drawable == null) {
            drawable = ContextCompat.getDrawable(view.getContext(), R.color.bdf);
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            try {
                if (!Intrinsics.areEqual(str3, "none")) {
                    if (str2 != null && str2.length() != 0) {
                        z17 = false;
                        if (z17) {
                            obtain.mUseApngImage = true;
                            url = new URL(str2);
                            obtain.mLoadingDrawable = drawable;
                            obtain.mFailedDrawable = drawable;
                            obtain.mUseAutoScaleParams = false;
                            drawable2 = URLDrawable.getDrawable(url, obtain);
                            if (drawable2 == null) {
                                if (drawable2.getStatus() == 2 || drawable2.getStatus() == 3) {
                                    drawable2.restartDownload();
                                }
                            } else {
                                drawable2 = null;
                            }
                            drawable = drawable2;
                        }
                    }
                    z17 = true;
                    if (z17) {
                    }
                }
                url = new URL(str);
                obtain.mLoadingDrawable = drawable;
                obtain.mFailedDrawable = drawable;
                obtain.mUseAutoScaleParams = false;
                drawable2 = URLDrawable.getDrawable(url, obtain);
                if (drawable2 == null) {
                }
                drawable = drawable2;
            } catch (MalformedURLException e16) {
                String message = e16.getMessage();
                if (message != null) {
                    mj2.a.b("DisplayUtil", message);
                }
                view.setImageDrawable(drawable);
                return;
            }
        }
        view.setImageDrawable(drawable);
    }
}
