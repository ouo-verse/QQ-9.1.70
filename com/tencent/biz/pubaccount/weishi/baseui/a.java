package com.tencent.biz.pubaccount.weishi.baseui;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class a<T> implements c<T> {

    /* renamed from: d, reason: collision with root package name */
    protected View f80414d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, b<T>> f80415e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    protected Context f80416f;

    /* renamed from: h, reason: collision with root package name */
    public T f80417h;

    public a(Context context, View view) {
        this.f80416f = context;
        this.f80414d = view;
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(int i3, b<T> bVar) {
        bVar.r((ViewStub) this.f80414d.findViewById(i3));
        this.f80415e.put(String.valueOf(bVar.hashCode()), bVar);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void onPageSelected(int i3) {
        Map<String, b<T>> map = this.f80415e;
        if (map != null) {
            Iterator<Map.Entry<String, b<T>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                b<T> value = it.next().getValue();
                if (value instanceof qz.a) {
                    ((qz.a) value).x(i3);
                }
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void recycle() {
        Map<String, b<T>> map = this.f80415e;
        if (map != null) {
            Iterator<Map.Entry<String, b<T>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().i();
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void setData(T t16) {
        this.f80417h = t16;
        Map<String, b<T>> map = this.f80415e;
        if (map != null) {
            Iterator<Map.Entry<String, b<T>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().j(t16);
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void setPosition(int i3) {
        Map<String, b<T>> map = this.f80415e;
        if (map != null) {
            Iterator<Map.Entry<String, b<T>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().k(i3);
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void f(int i3) {
    }
}
