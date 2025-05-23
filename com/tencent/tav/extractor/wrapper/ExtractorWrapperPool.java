package com.tencent.tav.extractor.wrapper;

import com.tencent.tav.extractor.AssetExtractor;
import java.util.HashMap;

/* loaded from: classes26.dex */
public class ExtractorWrapperPool {
    private static final HashMap<String, ExtractorWrapper> extractorHashMap = new HashMap<>();

    public static synchronized void clear() {
        synchronized (ExtractorWrapperPool.class) {
            extractorHashMap.clear();
        }
    }

    public static synchronized boolean contains(String str) {
        boolean containsKey;
        synchronized (ExtractorWrapperPool.class) {
            containsKey = extractorHashMap.containsKey(str);
        }
        return containsKey;
    }

    public static synchronized void fillIn(String str, AssetExtractor assetExtractor) {
        synchronized (ExtractorWrapperPool.class) {
            ExtractorWrapper extractorWrapper = get(str);
            extractorWrapper.checkAndLoad(assetExtractor);
            assetExtractor.setSize(extractorWrapper.getVideoSize());
            assetExtractor.setDuration(extractorWrapper.getDuration());
            assetExtractor.setPreferRotation(extractorWrapper.getPreferRotation());
        }
    }

    public static synchronized ExtractorWrapper get(String str) {
        ExtractorWrapper extractorWrapper;
        synchronized (ExtractorWrapperPool.class) {
            HashMap<String, ExtractorWrapper> hashMap = extractorHashMap;
            extractorWrapper = hashMap.get(str);
            if (extractorWrapper == null) {
                extractorWrapper = new ExtractorWrapper(str);
            }
            hashMap.put(str, extractorWrapper);
        }
        return extractorWrapper;
    }

    public static synchronized void load(String str) {
        synchronized (ExtractorWrapperPool.class) {
            AssetExtractor assetExtractor = new AssetExtractor();
            assetExtractor.setDataSource(str);
            get(str).checkAndLoad(assetExtractor);
        }
    }

    public static synchronized void put(ExtractorWrapper extractorWrapper) {
        synchronized (ExtractorWrapperPool.class) {
            extractorHashMap.put(extractorWrapper.getVideoPath(), extractorWrapper);
        }
    }

    public static synchronized void load(AssetExtractor assetExtractor) {
        synchronized (ExtractorWrapperPool.class) {
            get(assetExtractor.getSourcePath()).checkAndLoad(assetExtractor);
        }
    }
}
