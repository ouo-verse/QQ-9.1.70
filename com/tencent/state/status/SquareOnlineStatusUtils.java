package com.tencent.state.status;

import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.utils.RegexUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/status/SquareOnlineStatusUtils;", "", "()V", "getUrlDrawable", "Landroid/graphics/drawable/Drawable;", "url", "", "loadingDrawable", "failedDrawable", "fadeInImage", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareOnlineStatusUtils {
    public static final SquareOnlineStatusUtils INSTANCE = new SquareOnlineStatusUtils();

    SquareOnlineStatusUtils() {
    }

    public final Drawable getUrlDrawable(String url, Drawable loadingDrawable, Drawable failedDrawable, boolean fadeInImage) {
        URLDrawable.URLDrawableOptions urlDrawableOptions;
        if (!RegexUtils.isValidUrl$default(RegexUtils.INSTANCE, url, false, 2, null)) {
            return null;
        }
        if (loadingDrawable == null && failedDrawable == null) {
            urlDrawableOptions = SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null);
        } else {
            urlDrawableOptions = SquareUtil.INSTANCE.getUrlDrawableOptions(loadingDrawable, failedDrawable);
        }
        urlDrawableOptions.mPlayGifImage = true;
        urlDrawableOptions.mUseApngImage = true;
        URLDrawable drawable = URLDrawable.getDrawable(url, urlDrawableOptions);
        Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
        if (drawable.getStatus() != 1) {
            drawable.startDownload();
        }
        drawable.setFadeInImage(fadeInImage);
        return drawable;
    }

    public static /* synthetic */ Drawable getUrlDrawable$default(SquareOnlineStatusUtils squareOnlineStatusUtils, String str, Drawable drawable, Drawable drawable2, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            drawable = null;
        }
        if ((i3 & 4) != 0) {
            drawable2 = null;
        }
        if ((i3 & 8) != 0) {
            z16 = true;
        }
        return squareOnlineStatusUtils.getUrlDrawable(str, drawable, drawable2, z16);
    }
}
