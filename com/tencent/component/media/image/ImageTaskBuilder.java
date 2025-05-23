package com.tencent.component.media.image;

import android.content.Context;
import android.util.Log;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.sharpP.SharpPUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ImageTaskBuilder {
    private static Context mContext = ImageManagerEnv.getAppContext();
    public static Map<String, Long> stampMap = new HashMap();
    public static Map<String, Long> stampMap2 = new HashMap();

    public static ImageTask buildImageTask(ImageKey imageKey) {
        byte b16 = imageKey.flag;
        if (b16 == 3) {
            return RecycleResourceTask.obtain(UICallbackTask.obtain(MessageQueueDownloadMultiplexTask.obtain(DownloadImageTask.obtain(imageKey))));
        }
        if (b16 == 1) {
            return RecycleResourceTask.obtain(UICallbackTask.obtain(FetchCachedImageTask.obtain(MessageQueueDecodeMultiplexTask.obtain(CancelableDecodeImageTask.obtain(imageKey)))));
        }
        if (b16 == 2) {
            ImageLoader.Options options = imageKey.options;
            if (options != null && options.isGifPlayWhileDownloading && !SharpPUtils.isSharpP(imageKey.url)) {
                Log.d("kaedelin", "isSharpp:" + SharpPUtils.isSharpP(imageKey.url) + " isGifPlayWhileDownloading:" + imageKey.options.isGifPlayWhileDownloading + "  hashCodeEx:" + imageKey.hashCodeEx() + " url:" + imageKey.url);
                return RecycleResourceTask.obtain(UICallbackTask.obtain(FetchCachedImageTask.obtain(MessageQueueDecodeMultiplexTask.obtain(CancelStreamDecodeGifTask.obtain((ImageTask) MessageQueueDownloadMultiplexTask.obtain(DownloadImageTask.obtain(imageKey)))))));
            }
            return RecycleResourceTask.obtain(UICallbackTask.obtain(FetchCachedImageTask.obtain(MessageQueueDecodeMultiplexTask.obtain(CancelableDecodeImageTask.obtain((ImageTask) MessageQueueDownloadMultiplexTask.obtain(DownloadImageTask.obtain(imageKey)))))));
        }
        return null;
    }
}
