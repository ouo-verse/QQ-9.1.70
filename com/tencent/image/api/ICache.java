package com.tencent.image.api;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface ICache {
    void evictAll();

    Object get(String str);

    byte getNormalPriority();

    Object put(String str, Object obj, byte b16);

    void remove(String str);
}
