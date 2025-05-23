package com.tencent.libra.cache;

import androidx.annotation.NonNull;
import androidx.collection.LruCache;
import com.tencent.libra.decode.LibraRequestKey;

/* compiled from: P */
/* loaded from: classes7.dex */
public class RFWLruCache extends LruCache<LibraRequestKey, EngineResource<?>> {
    public RFWLruCache(Integer num) {
        super(num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.collection.LruCache
    public int sizeOf(@NonNull LibraRequestKey libraRequestKey, @NonNull EngineResource<?> engineResource) {
        return engineResource.getSize();
    }
}
