package com.tenpay.proxy;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.mobileqq.widget.AnimationView;
import common.qzone.component.cache.common.FastLruCache;

/* loaded from: classes27.dex */
public class ObjectProxy {
    private com.tencent.mobileqq.qwallet.hb.a frameAnimHelper;
    private FastLruCache<String, String> mMemoryCache;

    public ObjectProxy() {
    }

    public String get(String str) {
        return this.mMemoryCache.b(str);
    }

    public void put(String str, String str2) {
        this.mMemoryCache.c(str, str2);
    }

    public void startAnimFrame(Context context, LinearLayout linearLayout, String str, boolean z16, int i3, boolean z17, AnimationView.MyAnimationListener myAnimationListener) {
        com.tencent.mobileqq.qwallet.hb.a aVar = new com.tencent.mobileqq.qwallet.hb.a(context, linearLayout, i3, z17, myAnimationListener);
        this.frameAnimHelper = aVar;
        aVar.b(str, z16);
    }

    public void stopAnimFrame() {
        com.tencent.mobileqq.qwallet.hb.a aVar = this.frameAnimHelper;
        if (aVar != null) {
            aVar.c();
        }
    }

    public ObjectProxy(int i3) {
        this.mMemoryCache = new FastLruCache<>(i3);
    }
}
