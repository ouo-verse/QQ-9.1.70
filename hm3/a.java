package hm3;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/nostra13/universalimageloader/core/DisplayImageOptions;", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {
    @NotNull
    public static final DisplayImageOptions a() {
        DisplayImageOptions getHeadImageOptions = new DisplayImageOptions.Builder().showImageForEmptyUri(R.drawable.msa).showImageOnFail(R.drawable.msa).cacheInMemory(false).cacheOnDisk(true).considerExifParams(false).bitmapConfig(Bitmap.Config.ARGB_8888).delayBeforeLoading(1).displayer(new SimpleBitmapDisplayer()).build();
        Intrinsics.checkNotNullExpressionValue(getHeadImageOptions, "getHeadImageOptions");
        return getHeadImageOptions;
    }
}
