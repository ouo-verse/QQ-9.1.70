package com.tencent.libra.cache;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.request.Option;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes7.dex */
public class i implements ICache {

    /* renamed from: b, reason: collision with root package name */
    private final c f118637b;

    /* renamed from: a, reason: collision with root package name */
    private final Set<String> f118636a = new CopyOnWriteArraySet();

    /* renamed from: c, reason: collision with root package name */
    private final BitmapPool f118638c = new h();

    public i(c cVar) {
        this.f118637b = cVar;
    }

    private Business a(Option option) {
        c cVar = this.f118637b;
        if (cVar == null) {
            return Business.Default;
        }
        return cVar.getBusiness(option);
    }

    private PageHierarchy b(Option option) {
        c cVar = this.f118637b;
        if (cVar == null) {
            return null;
        }
        return cVar.getSubBusiness(option);
    }

    @Override // com.tencent.libra.cache.ICache
    public void addToCache(LibraRequestKey libraRequestKey, EngineResource engineResource, Option option) {
        if (libraRequestKey != null && engineResource != null) {
            String libraRequestKey2 = libraRequestKey.toString();
            this.f118636a.add(libraRequestKey2);
            ImageCacheHelper.f98636a.j(libraRequestKey2, new g(engineResource), a(option), b(option), null);
        }
    }

    @Override // com.tencent.libra.cache.ICache
    public void clearAll() {
        Iterator<String> it = this.f118636a.iterator();
        while (it.hasNext()) {
            ImageCacheHelper.f98636a.m(it.next());
        }
        this.f118636a.clear();
    }

    @Override // com.tencent.libra.cache.ICache
    public BitmapPool getBitmapPool() {
        return this.f118638c;
    }

    @Override // com.tencent.libra.cache.ICache
    public EngineResource<?> getCache(LibraRequestKey libraRequestKey) {
        Object g16 = ImageCacheHelper.f98636a.g(libraRequestKey.toString());
        if (g16 instanceof g) {
            return ((g) g16).a();
        }
        return null;
    }

    @Override // com.tencent.libra.cache.ICache
    public int getCacheSize() {
        return (int) com.tencent.cache.core.manager.api.c.f98725d.g();
    }

    @Override // com.tencent.libra.cache.ICache
    public void removeCache(LibraRequestKey libraRequestKey) {
        if (libraRequestKey == null) {
            RFWLog.e("LibraPicLoader_QQLibraCache", RFWLog.USR, "[removeCache] key should not is empty.");
            return;
        }
        String libraRequestKey2 = libraRequestKey.toString();
        this.f118636a.remove(libraRequestKey2);
        ImageCacheHelper.f98636a.m(libraRequestKey2);
    }
}
