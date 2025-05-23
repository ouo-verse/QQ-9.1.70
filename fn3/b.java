package fn3;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0006\u0010\u0001\u001a\u00020\u0000\"\u0014\u0010\u0003\u001a\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0001\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/nostra13/universalimageloader/core/DisplayImageOptions;", "a", "Lcom/nostra13/universalimageloader/core/DisplayImageOptions;", "gHeadImgOptions", "qq-live-link-pk-anchorplay-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final DisplayImageOptions f400123a;

    static {
        DisplayImageOptions build = new DisplayImageOptions.Builder().cacheInMemory(true).bitmapConfig(Bitmap.Config.RGB_565).showImageForEmptyUri(R.drawable.ogj).showImageOnLoading(R.drawable.ogj).showImageOnFail(R.drawable.ogj).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n        .cache\u2026default)\n        .build()");
        f400123a = build;
    }

    @NotNull
    public static final DisplayImageOptions a() {
        return f400123a;
    }
}
