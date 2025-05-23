package com.tencent.biz.pubaccount.weishi.presenter;

import com.tencent.biz.pubaccount.weishi.a;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a<V extends com.tencent.biz.pubaccount.weishi.a> implements com.tencent.biz.pubaccount.weishi.d<V> {

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<V> f81237d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f81238e = false;

    @Override // com.tencent.biz.pubaccount.weishi.d
    public void attachView(V v3) {
        this.f81237d = new WeakReference<>(v3);
        this.f81238e = false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.d
    public void detachView() {
        WeakReference<V> weakReference = this.f81237d;
        if (weakReference != null) {
            weakReference.clear();
            this.f81237d = null;
        }
    }

    public V x0() {
        WeakReference<V> weakReference = this.f81237d;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.tencent.biz.pubaccount.weishi.d
    public void destroy() {
        this.f81238e = true;
    }
}
