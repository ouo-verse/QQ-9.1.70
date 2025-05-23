package com.tencent.component.media.image;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.ImageLoader;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ImageKey {
    public String bigUrl;
    public int inSampleSize;
    private int keySeq;
    public int orgHeight;
    public int orgWidth;
    public String srUrl;
    public Integer urlKeyHashCode;
    private static LinkedList<ImageKey> mObjectCache = new LinkedList<>();
    private static int keyIndex = 0;
    public String urlKey = null;
    public String url = null;
    public boolean isNetworkUrl = true;
    public ImageLoader.ImageLoadListener listener = null;
    public ImageLoader.Options options = null;
    public String filePath = null;
    public byte flag = 0;
    public ImageLoader.ImageDownloadListener imglistener = null;
    public ImageLoader.StreamDownloadListener streamDownloadListener = null;
    public boolean needCallBackProcessPercent = false;
    public boolean needSuperResolution = true;
    public boolean isSuperResolutionUrl = false;
    public boolean isHighScaleUrl = false;
    private int hashCodeEx = 0;

    static {
        clearAndInitSize();
    }

    ImageKey(int i3) {
        this.keySeq = i3;
    }

    public static void clearAndInitSize() {
        synchronized (mObjectCache) {
            mObjectCache.clear();
            for (int i3 = 0; i3 < 100; i3++) {
                LinkedList<ImageKey> linkedList = mObjectCache;
                int i16 = keyIndex;
                keyIndex = i16 + 1;
                linkedList.add(new ImageKey(i16));
            }
        }
    }

    public static ImageKey copy(ImageKey imageKey) {
        ImageKey obtain = obtain();
        obtain.urlKey = imageKey.urlKey;
        obtain.url = imageKey.url;
        obtain.isNetworkUrl = imageKey.isNetworkUrl;
        obtain.filePath = imageKey.filePath;
        obtain.flag = imageKey.flag;
        obtain.imglistener = imageKey.imglistener;
        obtain.needCallBackProcessPercent = imageKey.needCallBackProcessPercent;
        obtain.listener = imageKey.listener;
        obtain.streamDownloadListener = imageKey.streamDownloadListener;
        obtain.options = ImageLoader.Options.copy(imageKey.options);
        obtain.needSuperResolution = imageKey.needSuperResolution;
        obtain.srUrl = imageKey.srUrl;
        obtain.bigUrl = imageKey.bigUrl;
        obtain.isSuperResolutionUrl = imageKey.isSuperResolutionUrl;
        obtain.isHighScaleUrl = imageKey.isHighScaleUrl;
        return obtain;
    }

    private static boolean equalsObject(Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        }
        return obj.equals(obj2);
    }

    public static String getUrlKey(String str, boolean z16, boolean z17) {
        String isNeedToSplitCache = isNeedToSplitCache(str);
        String str2 = getUrlKey4NoneHighScale(str, z16) + isNeedToSplitCache;
        if (!z17 || str2.contains("srhs=1")) {
            return str2;
        }
        return str2 + "srhs=1";
    }

    public static String getUrlKey4NoneHighScale(String str, boolean z16) {
        if (!z16) {
            z16 = ImageManager.isNetworkUrl(str);
        }
        if (z16) {
            int indexOf = str.indexOf(47, 8);
            int indexOf2 = str.indexOf("ek=1");
            if (indexOf2 == -1 && (indexOf2 = str.indexOf(35)) == -1) {
                indexOf2 = str.length();
            }
            int i3 = indexOf + 1;
            if (i3 >= 0 && i3 <= indexOf2 && indexOf2 <= str.length()) {
                return str.substring(i3, indexOf2);
            }
            return str;
        }
        return str;
    }

    public static String isNeedToSplitCache(String str) {
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("t");
            if (!TextUtils.isEmpty(queryParameter)) {
                if (!queryParameter.equals("6") && !queryParameter.equals("7") && !queryParameter.equals("8")) {
                    return "";
                }
                return "t=" + queryParameter;
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static ImageKey obtain() {
        ImageKey poll;
        synchronized (mObjectCache) {
            poll = mObjectCache.poll();
            if (poll == null) {
                int i3 = keyIndex;
                keyIndex = i3 + 1;
                poll = new ImageKey(i3);
            }
            poll.hashCodeEx = 0;
        }
        return poll;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00bc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(Object obj) {
        boolean z16;
        boolean z17;
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof ImageKey)) {
            ImageKey imageKey = (ImageKey) obj;
            if (equalsObject(this.urlKey, imageKey.urlKey) && equalsObject(this.url, imageKey.url) && equalsObject(this.listener, imageKey.listener)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
            ImageLoader.Options options = this.options;
            if (options != null && imageKey.options != null) {
                if (equalsObject(Integer.valueOf(options.clipHeight), Integer.valueOf(imageKey.options.clipHeight)) && equalsObject(Integer.valueOf(this.options.clipWidth), Integer.valueOf(imageKey.options.clipWidth)) && equalsObject(Boolean.valueOf(this.options.needShowGifAnimation), Boolean.valueOf(imageKey.options.needShowGifAnimation)) && equalsObject(this.options.extraProcessor, imageKey.options.extraProcessor) && equalsObject(this.options.imageConfig, imageKey.options.imageConfig)) {
                    String str = this.options.fileRootPath;
                    if (equalsObject(str, str) && equalsObject(Boolean.valueOf(this.options.needShowPhotoGifAnimation), Boolean.valueOf(imageKey.options.needShowPhotoGifAnimation))) {
                        z17 = true;
                        if (z17) {
                            return false;
                        }
                        if (this.listener == null || imageKey.listener == null) {
                            return true;
                        }
                        if (equalsObject(Boolean.valueOf(this.options.useMainThread), Boolean.valueOf(imageKey.options.useMainThread)) && equalsObject(this.options.obj, imageKey.options.obj) && equalsObject(Integer.valueOf(this.options.arg1), Integer.valueOf(imageKey.options.arg1)) && equalsObject(Integer.valueOf(this.options.arg2), Integer.valueOf(imageKey.options.arg2))) {
                            return true;
                        }
                        return false;
                    }
                }
                z17 = false;
                if (z17) {
                }
            } else if (options == null && imageKey.options == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int type;
        int hashCode3;
        int hashCode4;
        Integer num = this.urlKeyHashCode;
        int i3 = 0;
        if (num != null && num.intValue() != -1) {
            hashCode = this.urlKeyHashCode.intValue();
        } else {
            String str = this.url;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
        }
        int i16 = (hashCode + 0) * 31;
        ImageLoader.ImageLoadListener imageLoadListener = this.listener;
        if (imageLoadListener == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = imageLoadListener.hashCode();
        }
        int i17 = i16 + hashCode2;
        ImageLoader.Options options = this.options;
        if (options != null) {
            int i18 = ((((((i17 * 31) + options.clipHeight) * 31) + options.clipWidth) * 31) + (options.needShowGifAnimation ? 1 : 0)) * 31;
            ImageProcessor imageProcessor = options.extraProcessor;
            if (imageProcessor == null) {
                type = 0;
            } else {
                type = imageProcessor.getType();
            }
            int i19 = (i18 + type) * 31;
            Bitmap.Config config = this.options.imageConfig;
            if (config == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = config.hashCode();
            }
            int i26 = (i19 + hashCode3) * 31;
            String str2 = this.options.fileRootPath;
            if (str2 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = str2.hashCode();
            }
            int i27 = (i26 + hashCode4) * 31;
            ImageLoader.Options options2 = this.options;
            int i28 = i27 + (options2.needShowPhotoGifAnimation ? 1 : 0);
            if (this.listener != null) {
                int i29 = ((i28 * 31) + (options2.useMainThread ? 1 : 0)) * 31;
                Object obj = options2.obj;
                if (obj != null) {
                    i3 = obj.hashCode();
                }
                int i36 = (i29 + i3) * 31;
                ImageLoader.Options options3 = this.options;
                return ((i36 + options3.arg1) * 31) + options3.arg2;
            }
            return i28;
        }
        return i17;
    }

    public int hashCodeEx() {
        int hashCode;
        int type;
        int hashCode2;
        if (this.hashCodeEx == 0) {
            String str = this.urlKey;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode + 0;
            ImageLoader.Options options = this.options;
            if (options != null) {
                int i17 = ((((((i16 * 31) + options.clipHeight) * 31) + options.clipWidth) * 31) + (options.needShowGifAnimation ? 1 : 0)) * 31;
                ImageProcessor imageProcessor = options.extraProcessor;
                if (imageProcessor == null) {
                    type = 0;
                } else {
                    type = imageProcessor.getType();
                }
                int i18 = (i17 + type) * 31;
                Bitmap.Config config = this.options.imageConfig;
                if (config == null) {
                    hashCode2 = 0;
                } else {
                    hashCode2 = config.hashCode();
                }
                int i19 = (i18 + hashCode2) * 31;
                String str2 = this.options.fileRootPath;
                if (str2 != null) {
                    i3 = str2.hashCode();
                }
                i16 = ((i19 + i3) * 31) + (this.options.needShowPhotoGifAnimation ? 1 : 0);
            }
            this.hashCodeEx = i16;
        }
        return this.hashCodeEx;
    }

    public boolean isAvatarUrl() {
        if (TextUtils.isEmpty(this.url)) {
            return false;
        }
        return this.url.startsWith("avatar://");
    }

    public boolean isSame(ImageKey imageKey) {
        if (imageKey == null || imageKey.keySeq != this.keySeq) {
            return false;
        }
        return true;
    }

    public boolean needDecode() {
        byte b16 = this.flag;
        if (b16 == 1 || b16 == 2) {
            return true;
        }
        return false;
    }

    public void recycle() {
        this.urlKey = null;
        this.url = null;
        this.isNetworkUrl = true;
        this.filePath = null;
        this.flag = (byte) 0;
        this.imglistener = null;
        this.needCallBackProcessPercent = false;
        this.listener = null;
        this.streamDownloadListener = null;
        if (this.options != null) {
            this.options = null;
        }
        this.hashCodeEx = 0;
        this.needSuperResolution = true;
        this.srUrl = null;
        this.bigUrl = null;
        this.isSuperResolutionUrl = false;
        this.isHighScaleUrl = false;
        synchronized (mObjectCache) {
            mObjectCache.add(this);
        }
    }

    public void setUrl(String str) {
        this.url = str;
        this.isNetworkUrl = ImageManager.isNetworkUrl(str);
        boolean isSuperResolutionUrl = ImageManagerEnv.g().isSuperResolutionUrl(str);
        this.isSuperResolutionUrl = isSuperResolutionUrl;
        boolean z16 = isSuperResolutionUrl && ImageManagerEnv.g().isHighScaleUrl(str);
        this.isHighScaleUrl = z16;
        if (this.isNetworkUrl) {
            this.urlKey = getUrlKey(str, true, z16);
        } else {
            this.urlKey = str;
        }
    }

    public static String getUrlKey(String str, boolean z16) {
        return getUrlKey(str, z16, ImageManagerEnv.g().isHighScaleUrl(str));
    }

    public void setUrl(ImageUrl imageUrl) {
        this.url = imageUrl.url;
        this.isNetworkUrl = imageUrl.isNetWorkUrl;
        this.isSuperResolutionUrl = imageUrl.isSuperResolutionUrl;
        this.isHighScaleUrl = imageUrl.isHighScaleUrl;
        this.urlKey = imageUrl.urlKey;
        this.urlKeyHashCode = imageUrl.urlKeyHashCode;
    }
}
