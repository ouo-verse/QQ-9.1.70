package com.tencent.cache.core.manager.store;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.cache.core.size.task.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class h extends com.tencent.cache.core.bitmap.cache.c<String, Object> {
    static IPatchRedirector $redirector_;

    public h(int i3, int i16) {
        super(i16, 0, 2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.cache.core.bitmap.cache.c
    public int a(String str, com.tencent.cache.core.bitmap.cache.b<String, Object> cacheItem, boolean z16, com.tencent.cache.core.bitmap.base.lrucache.b lruCache) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, str, cacheItem, Boolean.valueOf(z16), lruCache)).intValue();
        }
        String key = str;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(cacheItem, "cacheItem");
        Intrinsics.checkNotNullParameter(lruCache, "lruCache");
        if (cacheItem.f98663e == 0) {
            com.tencent.cache.core.size.task.a aVar = com.tencent.cache.core.size.task.a.D;
            Intrinsics.checkNotNullParameter(cacheItem, "cacheItem");
            Intrinsics.checkNotNullParameter(lruCache, "lruCache");
            com.tencent.cache.api.util.c cVar = com.tencent.cache.api.util.c.f98640a;
            Object obj = cacheItem.f98664f;
            Intrinsics.checkNotNull(obj);
            int e16 = com.tencent.cache.api.util.c.e(cVar, obj, false, true, false, 8, null);
            if (e16 != 0) {
                i3 = e16;
            } else if (!aVar.d()) {
                i3 = 204800;
            } else {
                Message obtain = Message.obtain();
                if (obtain != null) {
                    com.tencent.cache.core.size.task.a.f98811i++;
                    obtain.what = 2;
                    obtain.obj = new a.b(cacheItem, z16, lruCache);
                    Handler handler = com.tencent.cache.core.size.task.a.f98808e;
                    if (handler != null) {
                        handler.sendMessage(obtain);
                    }
                }
            }
            cacheItem.f98663e = i3;
        }
        return cacheItem.f98663e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003f, code lost:
    
        if (r5.isRecycled() == false) goto L21;
     */
    @Override // com.tencent.cache.core.bitmap.cache.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i(boolean z16, String str, Object oldValue, Object obj) {
        Bitmap bitmap;
        com.tencent.cache.api.e eVar;
        Bitmap bitmap2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, oldValue, obj);
            return;
        }
        String key = str;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        Pair<Integer, Integer> pair = i.f98784a;
        if (oldValue instanceof Bitmap) {
            bitmap = (Bitmap) oldValue;
        }
        if ((oldValue instanceof com.tencent.cache.api.e) && (bitmap2 = (eVar = (com.tencent.cache.api.e) oldValue).getBitmap()) != null && !bitmap2.isRecycled()) {
            bitmap = eVar.getBitmap();
        } else {
            bitmap = null;
        }
        if (bitmap != null && !bitmap.isRecycled() && com.tencent.cache.core.manager.api.c.f98725d.d().G() && bitmap.isMutable()) {
            i.f98786c.d(bitmap);
        }
    }
}
