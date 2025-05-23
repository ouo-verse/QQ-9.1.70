package com.nostra13.universalimageloader.utils;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class MemoryCacheUtils {
    private static final String URI_AND_SIZE_SEPARATOR = "_";
    private static final String WIDTH_AND_HEIGHT_SEPARATOR = "x";

    MemoryCacheUtils() {
    }

    public static Comparator<String> createFuzzyKeyComparator() {
        return new Comparator<String>() { // from class: com.nostra13.universalimageloader.utils.MemoryCacheUtils.1
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                return str.substring(0, str.lastIndexOf("_")).compareTo(str2.substring(0, str2.lastIndexOf("_")));
            }
        };
    }

    public static List<String> findCacheKeysForImageUri(String str, MemoryCache memoryCache) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : memoryCache.keys()) {
            if (str2.startsWith(str)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static List<Bitmap> findCachedBitmapsForImageUri(String str, MemoryCache memoryCache) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : memoryCache.keys()) {
            if (str2.startsWith(str)) {
                arrayList.add(memoryCache.get(str2));
            }
        }
        return arrayList;
    }

    public static String generateKey(String str, ImageSize imageSize) {
        return str + "_" + imageSize.getWidth() + "x" + imageSize.getHeight();
    }

    public static void removeFromCache(String str, MemoryCache memoryCache) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : memoryCache.keys()) {
            if (str2.startsWith(str)) {
                arrayList.add(str2);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            memoryCache.remove((String) it.next());
        }
    }
}
