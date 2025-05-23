package com.tencent.tav.core;

import androidx.annotation.NonNull;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AssetExtension {
    public static final String SCENE_EXPORT = "export";
    public static final String SCENE_PLAY = "play";
    public static final String SCENE_THUMBNAIL = "thumbnail";
    private volatile ConcurrentHashMap<String, Object> extensionMap = new ConcurrentHashMap<>();
    private final String scene;

    public AssetExtension(@NonNull String str) {
        this.scene = str;
    }

    public void addExtension(@NonNull String str, @NonNull Object obj) {
        this.extensionMap.put(str, obj);
    }

    public boolean containsKey(@NonNull String str) {
        return this.extensionMap.containsKey(str);
    }

    public boolean containsValue(@NonNull String str) {
        return this.extensionMap.containsValue(str);
    }

    public String getScene() {
        return this.scene;
    }

    public Object remove(@NonNull String str) {
        return this.extensionMap.remove(str);
    }
}
