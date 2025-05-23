package com.tencent.component.network.module.cache.file;

import com.tencent.component.network.module.cache.common.LruCache;
import com.tencent.component.network.utils.FileUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class FileCache<K> extends LruCache<K, String> {
    public FileCache(int i3) {
        super(i3);
    }

    private static int getFileSize(String str) {
        if (str != null && str.length() != 0) {
            return 1;
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.component.network.module.cache.common.LruCache
    protected /* bridge */ /* synthetic */ void entryRemoved(boolean z16, Object obj, String str, String str2) {
        entryRemoved2(z16, (boolean) obj, str, str2);
    }

    public void recycle(String str) {
        if (str != null) {
            FileUtils.delete(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.component.network.module.cache.common.LruCache
    protected /* bridge */ /* synthetic */ int sizeOf(Object obj, String str) {
        return sizeOf2((FileCache<K>) obj, str);
    }

    /* renamed from: entryRemoved, reason: avoid collision after fix types in other method */
    protected void entryRemoved2(boolean z16, K k3, String str, String str2) {
        if (str == str2) {
            return;
        }
        if (str == null || !str.equals(str2)) {
            synchronized (this) {
                recycle(str);
            }
        }
    }

    /* renamed from: sizeOf, reason: avoid collision after fix types in other method */
    protected int sizeOf2(K k3, String str) {
        return getFileSize(str);
    }
}
