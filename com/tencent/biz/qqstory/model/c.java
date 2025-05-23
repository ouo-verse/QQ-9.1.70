package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class c<DATA> {

    /* renamed from: c, reason: collision with root package name */
    public static final String f94037c = "com.tencent.biz.qqstory.model.c";

    /* renamed from: a, reason: collision with root package name */
    protected DATA f94038a;

    /* renamed from: b, reason: collision with root package name */
    protected List<a<DATA>> f94039b = new CopyOnWriteArrayList();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a<DATA> {
        void b(boolean z16, DATA data);
    }

    protected abstract void a(com.tencent.biz.qqstory.model.lbs.a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(boolean z16, DATA data) {
        Iterator<a<DATA>> it = this.f94039b.iterator();
        while (it.hasNext()) {
            it.next().b(z16, data);
        }
    }

    public void c() {
        hd0.c.a(f94037c, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.f94039b.clear();
    }

    public void d() {
        hd0.c.a(f94037c, "onInit");
    }

    public void e(@NonNull a<DATA> aVar) {
        if (!this.f94039b.contains(aVar)) {
            this.f94039b.add(aVar);
        }
    }

    public void f(com.tencent.biz.qqstory.model.lbs.a aVar) {
        a(aVar);
    }

    public void g(@NonNull a<DATA> aVar) {
        if (this.f94039b.contains(aVar)) {
            this.f94039b.remove(aVar);
        }
    }
}
