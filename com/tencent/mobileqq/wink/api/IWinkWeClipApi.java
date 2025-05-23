package com.tencent.mobileqq.wink.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import i83.h;
import i83.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&J\u001e\u0010\u0010\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0003\u001a\u00020\u0002H&J1\u0010\u0010\u001a\u00020\u00042\u0018\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00120\u00112\u0006\u0010\u0003\u001a\u00020\u0016H&\u00a2\u0006\u0004\b\u0010\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0004H&J\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H&J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001e\u001a\u00020\u0013H&J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0013H&\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/wink/api/IWinkWeClipApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Li83/c;", "listener", "", "mediaScan", "stopScan", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "resDownLoadListener", "preDownloadWeClipModel", "Li83/i;", "preloadListener", "preloadWeClipModel", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", s4.c.PICS, "doClipForward", "", "Lkotlin/Pair;", "", "Landroid/graphics/Bitmap;", "bitmaps", "Li83/h;", "([Lkotlin/Pair;Li83/h;)V", "releaseClip", "", "feature1", "feature2", "", "getSimilarityFromClipFeature", "photoId", "loadImageFeature", "removeImageFeature", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IWinkWeClipApi extends QRouteApi {
    void doClipForward(@NotNull List<? extends LocalMediaInfo> pics, @NotNull i83.c listener);

    void doClipForward(@NotNull Pair<String, Bitmap>[] bitmaps, @NotNull h listener);

    float getSimilarityFromClipFeature(@NotNull float[] feature1, @NotNull float[] feature2);

    @Nullable
    float[] loadImageFeature(@NotNull String photoId);

    void mediaScan(@NotNull i83.c listener);

    void preDownloadWeClipModel(@NotNull ResDownLoadListener resDownLoadListener);

    void preloadWeClipModel(@NotNull i preloadListener);

    void releaseClip();

    void removeImageFeature(@NotNull String photoId);

    void stopScan();
}
