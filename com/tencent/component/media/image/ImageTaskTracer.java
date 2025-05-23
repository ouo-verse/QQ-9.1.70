package com.tencent.component.media.image;

import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.utils.LruCache;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ImageTaskTracer {
    private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_DecodeFailed = 8;
    private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_DecodeThreadDecoding = 4;
    private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_DecodeThreadPending = 3;
    private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_Download = 2;
    private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_DownloadFailed = 10;
    private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_ImageTaskLifeCycle = 9;
    private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_ListScrollWaitDecode = 6;
    private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_LruCacheEvicted = 5;
    private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_MsgGetNull = 7;
    private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_NonPreDecodeRequest = 1;
    private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_NonPreDecodeRequest_ExceedMemorySize = 14;
    private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_NonPreDecodeRequest_ListView_Sroll = 15;
    private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_NonPreDecodeRequest_NO_CODE = 12;
    private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_NonPreDecodeRequest_OptionNotMatch = 13;
    private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_Other = 11;
    private static int MM_REPORT_GET_IMAGE_SUCCESS_CODE;
    private static Object PLACEHOLDER = new Object();
    public static boolean OPEN_GET_IMAGE_SUCCESS_RECORDER = ImageManagerEnv.g().isOpenGetImageSuccessRecorder();
    private static ConcurrentHashMap<Integer, Object> mImagePreDecodeRequestRecorder = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Integer, Object> mImageDecodeThreadPendingRecorder = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Integer, Object> mImageDecodeThreadDecodingRecorder = new ConcurrentHashMap<>();
    private static LruCache<Integer, Object> mImageLruCacheEvictedRecorder = new LruCache<>(250);
    private static ConcurrentHashMap<String, Object> mImageDownloadRecorder = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Integer, Object> mImageMsgGetNullRecorder = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Integer, Object> mImageTaskLifeCycleRecorder = new ConcurrentHashMap<>();
    private static LruCache<Integer, Object> mImageDecodeFailedRecorder = new LruCache<>(150);
    private static LruCache<String, Object> mImageDownloadFailedRecorder = new LruCache<>(150);
    private static ConcurrentHashMap<String, Integer> mImagePreDecodeRequest_DecodeOptions = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Integer, Object> mImagePreDecodeRequest_ExceedMemorySize = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Object> mhasImagePreDecodeRequestIntrinsic = new ConcurrentHashMap<>();

    public static void addImageDecodeFailedRecord(int i3) {
        LruCache<Integer, Object> lruCache;
        if (OPEN_GET_IMAGE_SUCCESS_RECORDER && (lruCache = mImageDecodeFailedRecorder) != null) {
            lruCache.put(Integer.valueOf(i3), PLACEHOLDER);
        }
    }

    public static void addImageDecodeThreadDecodingRecord(int i3) {
        ConcurrentHashMap<Integer, Object> concurrentHashMap;
        if (OPEN_GET_IMAGE_SUCCESS_RECORDER && (concurrentHashMap = mImageDecodeThreadDecodingRecorder) != null) {
            concurrentHashMap.put(Integer.valueOf(i3), PLACEHOLDER);
        }
    }

    public static void addImageDecodeThreadPendingRecord(int i3) {
        ConcurrentHashMap<Integer, Object> concurrentHashMap;
        if (OPEN_GET_IMAGE_SUCCESS_RECORDER && (concurrentHashMap = mImageDecodeThreadPendingRecorder) != null) {
            concurrentHashMap.put(Integer.valueOf(i3), PLACEHOLDER);
        }
    }

    public static void addImageDownloadFailedRecord(String str) {
        LruCache<String, Object> lruCache;
        if (OPEN_GET_IMAGE_SUCCESS_RECORDER && (lruCache = mImageDownloadFailedRecorder) != null) {
            lruCache.put(str, PLACEHOLDER);
        }
    }

    public static void addImageDownloadRecord(String str) {
        ConcurrentHashMap<String, Object> concurrentHashMap;
        if (OPEN_GET_IMAGE_SUCCESS_RECORDER && (concurrentHashMap = mImageDownloadRecorder) != null) {
            concurrentHashMap.put(str, PLACEHOLDER);
        }
    }

    public static void addImageLruCacheEvictedRecord(int i3) {
        LruCache<Integer, Object> lruCache;
        if (OPEN_GET_IMAGE_SUCCESS_RECORDER && (lruCache = mImageLruCacheEvictedRecorder) != null) {
            lruCache.put(Integer.valueOf(i3), PLACEHOLDER);
        }
    }

    public static void addImageMsgGetNullRecord(int i3) {
        ConcurrentHashMap<Integer, Object> concurrentHashMap;
        if (OPEN_GET_IMAGE_SUCCESS_RECORDER && (concurrentHashMap = mImageMsgGetNullRecorder) != null) {
            concurrentHashMap.put(Integer.valueOf(i3), PLACEHOLDER);
        }
    }

    public static void addImagePreDecodeOptionsRecord(String str, ImageLoader.Options options) {
        ConcurrentHashMap<String, Integer> concurrentHashMap;
        if (OPEN_GET_IMAGE_SUCCESS_RECORDER && (concurrentHashMap = mImagePreDecodeRequest_DecodeOptions) != null) {
            concurrentHashMap.put(str, Integer.valueOf(getHashCodeEx(str, options)));
        }
    }

    public static void addImagePreDecodeRequestRecord(String str, ImageLoader.Options options) {
        ConcurrentHashMap<Integer, Object> concurrentHashMap;
        if (OPEN_GET_IMAGE_SUCCESS_RECORDER && (concurrentHashMap = mImagePreDecodeRequestRecorder) != null) {
            concurrentHashMap.put(Integer.valueOf(getHashCodeEx(str, options)), PLACEHOLDER);
        }
    }

    public static void addImagePreExceedMemorySizeRecord(String str, ImageLoader.Options options) {
        ConcurrentHashMap<Integer, Object> concurrentHashMap;
        if (OPEN_GET_IMAGE_SUCCESS_RECORDER && (concurrentHashMap = mImagePreDecodeRequest_ExceedMemorySize) != null) {
            concurrentHashMap.put(Integer.valueOf(getHashCodeEx(str, options)), PLACEHOLDER);
        }
    }

    public static void addImageTaskLifeCycleRecord(int i3) {
        ConcurrentHashMap<Integer, Object> concurrentHashMap;
        if (OPEN_GET_IMAGE_SUCCESS_RECORDER && (concurrentHashMap = mImageTaskLifeCycleRecorder) != null) {
            concurrentHashMap.put(Integer.valueOf(i3), PLACEHOLDER);
        }
    }

    public static void addhasImagePreDecodeRequestIntrinsicRecord(String str, ImageLoader.Options options) {
        ConcurrentHashMap<String, Object> concurrentHashMap;
        if (OPEN_GET_IMAGE_SUCCESS_RECORDER && (concurrentHashMap = mhasImagePreDecodeRequestIntrinsic) != null) {
            concurrentHashMap.put(str, PLACEHOLDER);
        }
    }

    private static int getHashCodeEx(String str, ImageLoader.Options options) {
        ImageKey obtain = ImageKey.obtain();
        obtain.setUrl(str);
        obtain.options = options;
        return obtain.hashCodeEx();
    }

    public static boolean hasImageDecodeFailedRecord(int i3) {
        LruCache<Integer, Object> lruCache;
        if (!OPEN_GET_IMAGE_SUCCESS_RECORDER || (lruCache = mImageDecodeFailedRecorder) == null || lruCache.get(Integer.valueOf(i3)) == null) {
            return false;
        }
        return true;
    }

    public static boolean hasImageDecodeThreadDecodingRecord(int i3) {
        ConcurrentHashMap<Integer, Object> concurrentHashMap;
        if (OPEN_GET_IMAGE_SUCCESS_RECORDER && (concurrentHashMap = mImageDecodeThreadDecodingRecorder) != null) {
            return concurrentHashMap.containsKey(Integer.valueOf(i3));
        }
        return false;
    }

    public static boolean hasImageDecodeThreadPendingRecord(int i3) {
        ConcurrentHashMap<Integer, Object> concurrentHashMap;
        if (OPEN_GET_IMAGE_SUCCESS_RECORDER && (concurrentHashMap = mImageDecodeThreadPendingRecorder) != null) {
            return concurrentHashMap.containsKey(Integer.valueOf(i3));
        }
        return false;
    }

    public static boolean hasImageDownloadFailedRecord(String str) {
        LruCache<String, Object> lruCache;
        if (!OPEN_GET_IMAGE_SUCCESS_RECORDER || (lruCache = mImageDownloadFailedRecorder) == null || lruCache.get(str) == null) {
            return false;
        }
        return true;
    }

    public static boolean hasImageDownloadRecord(String str) {
        ConcurrentHashMap<String, Object> concurrentHashMap;
        if (OPEN_GET_IMAGE_SUCCESS_RECORDER && (concurrentHashMap = mImageDownloadRecorder) != null) {
            return concurrentHashMap.containsKey(str);
        }
        return false;
    }

    public static boolean hasImageLruCacheEvictedRecord(int i3) {
        LruCache<Integer, Object> lruCache;
        if (!OPEN_GET_IMAGE_SUCCESS_RECORDER || (lruCache = mImageLruCacheEvictedRecorder) == null || lruCache.get(Integer.valueOf(i3)) == null) {
            return false;
        }
        return true;
    }

    public static boolean hasImageMsgGetNullRecord(int i3) {
        ConcurrentHashMap<Integer, Object> concurrentHashMap;
        if (OPEN_GET_IMAGE_SUCCESS_RECORDER && (concurrentHashMap = mImageMsgGetNullRecorder) != null) {
            return concurrentHashMap.containsKey(Integer.valueOf(i3));
        }
        return false;
    }

    public static boolean hasImagePreDecodeOptionsRecord(String str) {
        ConcurrentHashMap<String, Integer> concurrentHashMap;
        if (OPEN_GET_IMAGE_SUCCESS_RECORDER && (concurrentHashMap = mImagePreDecodeRequest_DecodeOptions) != null) {
            return concurrentHashMap.containsKey(str);
        }
        return false;
    }

    public static boolean hasImagePreDecodeRequestIntrinsicRecord(String str) {
        ConcurrentHashMap<String, Object> concurrentHashMap;
        if (OPEN_GET_IMAGE_SUCCESS_RECORDER && (concurrentHashMap = mhasImagePreDecodeRequestIntrinsic) != null) {
            return concurrentHashMap.containsKey(str);
        }
        return false;
    }

    public static boolean hasImagePreDecodeRequestRecord(int i3) {
        ConcurrentHashMap<Integer, Object> concurrentHashMap;
        if (OPEN_GET_IMAGE_SUCCESS_RECORDER && (concurrentHashMap = mImagePreDecodeRequestRecorder) != null) {
            return concurrentHashMap.containsKey(Integer.valueOf(i3));
        }
        return false;
    }

    public static boolean hasImagePreExceedMemorySizeRecord(int i3) {
        ConcurrentHashMap<Integer, Object> concurrentHashMap;
        if (OPEN_GET_IMAGE_SUCCESS_RECORDER && (concurrentHashMap = mImagePreDecodeRequest_ExceedMemorySize) != null) {
            return concurrentHashMap.containsKey(Integer.valueOf(i3));
        }
        return false;
    }

    public static boolean hasImageTaskLifeCycleRecord(int i3) {
        ConcurrentHashMap<Integer, Object> concurrentHashMap;
        if (OPEN_GET_IMAGE_SUCCESS_RECORDER && (concurrentHashMap = mImageTaskLifeCycleRecorder) != null) {
            return concurrentHashMap.containsKey(Integer.valueOf(i3));
        }
        return false;
    }

    public static void removeImageDecodeThreadDecodingRecord(int i3) {
        ConcurrentHashMap<Integer, Object> concurrentHashMap;
        if (OPEN_GET_IMAGE_SUCCESS_RECORDER && (concurrentHashMap = mImageDecodeThreadDecodingRecorder) != null) {
            concurrentHashMap.remove(Integer.valueOf(i3));
        }
    }

    public static void removeImageDecodeThreadPendingRecord(int i3) {
        ConcurrentHashMap<Integer, Object> concurrentHashMap;
        if (OPEN_GET_IMAGE_SUCCESS_RECORDER && (concurrentHashMap = mImageDecodeThreadPendingRecorder) != null) {
            concurrentHashMap.remove(Integer.valueOf(i3));
        }
    }

    public static void removeImageDownloadRecord(String str) {
        ConcurrentHashMap<String, Object> concurrentHashMap;
        if (OPEN_GET_IMAGE_SUCCESS_RECORDER && (concurrentHashMap = mImageDownloadRecorder) != null) {
            concurrentHashMap.remove(str);
        }
    }

    public static void removeImageMsgGetNullRecord(int i3) {
        ConcurrentHashMap<Integer, Object> concurrentHashMap;
        if (OPEN_GET_IMAGE_SUCCESS_RECORDER && (concurrentHashMap = mImageMsgGetNullRecorder) != null) {
            concurrentHashMap.remove(Integer.valueOf(i3));
        }
    }

    public static void removeImageTaskLifeCycleRecord(int i3) {
        ConcurrentHashMap<Integer, Object> concurrentHashMap;
        if (OPEN_GET_IMAGE_SUCCESS_RECORDER && (concurrentHashMap = mImageTaskLifeCycleRecorder) != null) {
            concurrentHashMap.remove(Integer.valueOf(i3));
        }
    }

    public static void traceImageGet(ImageKey imageKey, boolean z16) {
        if (OPEN_GET_IMAGE_SUCCESS_RECORDER) {
            if (z16) {
                ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_SUCCESS_CODE);
                return;
            }
            if (!hasImagePreDecodeRequestRecord(imageKey.hashCodeEx())) {
                if (hasImagePreDecodeRequestIntrinsicRecord(imageKey.url)) {
                    if (hasImagePreDecodeOptionsRecord(imageKey.url)) {
                        ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_NonPreDecodeRequest_OptionNotMatch);
                        return;
                    } else if (hasImagePreExceedMemorySizeRecord(imageKey.hashCodeEx())) {
                        ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_NonPreDecodeRequest_ExceedMemorySize);
                        return;
                    } else {
                        ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_NonPreDecodeRequest_ListView_Sroll);
                        return;
                    }
                }
                return;
            }
            if (hasImageDownloadRecord(imageKey.urlKey)) {
                ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_Download);
                return;
            }
            if (hasImageDecodeThreadPendingRecord(imageKey.hashCodeEx())) {
                ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_DecodeThreadPending);
                return;
            }
            if (hasImageDecodeThreadDecodingRecord(imageKey.hashCodeEx())) {
                ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_DecodeThreadDecoding);
                return;
            }
            if (hasImageLruCacheEvictedRecord(imageKey.hashCodeEx())) {
                ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_LruCacheEvicted);
                return;
            }
            if (ImageTaskManager.getInstance().hasWaitToDecodeImageTask(imageKey.hashCodeEx())) {
                ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_ListScrollWaitDecode);
                return;
            }
            if (hasImageMsgGetNullRecord(imageKey.hashCodeEx())) {
                ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_MsgGetNull);
                return;
            }
            if (hasImageDecodeFailedRecord(imageKey.hashCodeEx())) {
                ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_DecodeFailed);
                return;
            }
            if (hasImageTaskLifeCycleRecord(imageKey.hashCodeEx())) {
                ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_ImageTaskLifeCycle);
            } else if (hasImageDownloadFailedRecord(imageKey.urlKey)) {
                ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_DownloadFailed);
            } else {
                ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_Other);
            }
        }
    }
}
