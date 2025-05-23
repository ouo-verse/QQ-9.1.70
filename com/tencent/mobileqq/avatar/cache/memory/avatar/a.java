package com.tencent.mobileqq.avatar.cache.memory.avatar;

import android.graphics.Bitmap;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.cache.api.util.Priority;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.relation.common.config.toggle.c;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a implements w91.a<Bitmap> {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static long f199943c;

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f199944a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f199945b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20402);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f199943c = 86400000L;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f199944a = new ConcurrentHashMap<>(4);
        this.f199945b = true;
        this.f199945b = !c.f364694g.g(false);
    }

    @Override // w91.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap get(String str) {
        ConcurrentHashMap<String, Long> concurrentHashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Bitmap) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f(str);
        if (f16 != null && (concurrentHashMap = this.f199944a) != null && concurrentHashMap.containsKey(str)) {
            Long l3 = this.f199944a.get(str);
            if (l3 != null) {
                if (System.currentTimeMillis() - l3.longValue() > f199943c && this.f199945b) {
                    this.f199944a.remove(str);
                    imageCacheHelper.m(str);
                } else {
                    return f16;
                }
            }
            return null;
        }
        return f16;
    }

    @Override // w91.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean put(String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) bitmap)).booleanValue();
        }
        return put(str, bitmap, (byte) 2);
    }

    @Override // w91.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean put(String str, Bitmap bitmap, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, str, bitmap, Byte.valueOf(b16))).booleanValue();
        }
        ImageCacheHelper.f98636a.k(str, bitmap, Business.Conversation, Priority.values()[b16], null);
        ConcurrentHashMap<String, Long> concurrentHashMap = this.f199944a;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(str, Long.valueOf(System.currentTimeMillis()));
        }
        return true;
    }

    @Override // w91.a
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    @Override // w91.a
    public void remove(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        ImageCacheHelper.f98636a.m(str);
        ConcurrentHashMap<String, Long> concurrentHashMap = this.f199944a;
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(str);
        }
    }
}
