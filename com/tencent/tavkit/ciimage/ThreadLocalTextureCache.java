package com.tencent.tavkit.ciimage;

import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.video.Releasable;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ThreadLocalTextureCache implements Releasable {
    private static final ThreadLocal<ThreadLocalTextureCache> TEXTURE_CACHE = new ThreadLocal<ThreadLocalTextureCache>() { // from class: com.tencent.tavkit.ciimage.ThreadLocalTextureCache.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public ThreadLocalTextureCache initialValue() {
            return new ThreadLocalTextureCache();
        }
    };
    private final String mTAG;
    private final HashMap<String, TextureInfo> textureCache;

    public static ThreadLocalTextureCache getInstance() {
        return TEXTURE_CACHE.get();
    }

    public synchronized TextureInfo getTextureInfo(String str) {
        return this.textureCache.get(str);
    }

    public synchronized void putTextureInfo(String str, TextureInfo textureInfo) {
        Logger.d(this.mTAG, "putTextureInfo() called with: key = [" + str + "], textureInfo = [" + textureInfo + "]");
        this.textureCache.put(str, textureInfo);
    }

    @Override // com.tencent.tavkit.composition.video.Releasable
    public synchronized void release() {
        Logger.d(this.mTAG, "release() called, textureCache = " + this.textureCache);
        Iterator<TextureInfo> it = this.textureCache.values().iterator();
        while (it.hasNext()) {
            it.next().release();
        }
        this.textureCache.clear();
    }

    public synchronized void remove(String str) {
        this.textureCache.remove(str);
    }

    ThreadLocalTextureCache() {
        String str = "ThreadLocalTextureCache@" + Integer.toHexString(hashCode());
        this.mTAG = str;
        Logger.d(str, "ThreadLocalTextureCache() called, thread = " + Thread.currentThread().getName());
        this.textureCache = new HashMap<>();
    }
}
