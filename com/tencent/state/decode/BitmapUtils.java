package com.tencent.state.decode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u001a\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\bJ\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/decode/BitmapUtils;", "", "()V", "TAG", "", "createBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", DownloadInfo.spKey_Config, "Landroid/graphics/Bitmap$Config;", "decode", "context", "Landroid/content/Context;", "res", "setImageSource", "", "view", "Landroid/widget/ImageView;", "url", "file", "Ljava/io/File;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes33.dex */
public final class BitmapUtils {
    public static final BitmapUtils INSTANCE = new BitmapUtils();
    public static final String TAG = "BitmapUtils";

    BitmapUtils() {
    }

    public final Bitmap createBitmap(int width, int height, Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        try {
            return Bitmap.createBitmap(width, height, config);
        } catch (Exception e16) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "BitmapUtils", "create error " + e16, null, 4, null);
            return null;
        }
    }

    public final void setImageSource(ImageView view, String url, File file) {
        URLDrawable drawable;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(file, "file");
        URLDrawable.URLDrawableOptions urlDrawableOptions$default = SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null);
        if (file.exists()) {
            drawable = URLDrawable.getFileDrawable(file.getAbsolutePath(), urlDrawableOptions$default);
        } else {
            drawable = URLDrawable.getDrawable(url, urlDrawableOptions$default);
        }
        drawable.setFadeInImage(false);
        view.setImageDrawable(drawable);
    }

    public final Bitmap decode(Context context, int res) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return null;
        }
        return BitmapFactory.decodeResource(resources, res);
    }
}
