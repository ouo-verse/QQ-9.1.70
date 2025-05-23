package com.tencent.biz.qqstory.model;

import android.os.Handler;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TrimmableManager implements e {

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArraySet<f> f94020a = new CopyOnWriteArraySet<>();

    /* renamed from: b, reason: collision with root package name */
    private Handler f94021b = new Handler(ThreadManagerV2.getSubThreadLooper());

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a implements f {
        @Override // com.tencent.biz.qqstory.model.f
        public void trimMemory(int i3) {
            if (i3 == 1 || i3 == 2) {
                URLDrawable.clearMemoryCache();
            }
        }
    }

    public TrimmableManager() {
        this.f94020a.add(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i3) {
        hd0.c.v("TrimmableManager", "trimMemory : level = %d", Integer.valueOf(i3));
        if (i3 == 0 || i3 == 1 || i3 == 2) {
            Iterator<f> it = this.f94020a.iterator();
            while (it.hasNext()) {
                it.next().trimMemory(i3);
            }
            System.gc();
        }
    }

    public void c(final int i3) {
        this.f94021b.post(new Runnable() { // from class: com.tencent.biz.qqstory.model.TrimmableManager.1
            @Override // java.lang.Runnable
            public void run() {
                TrimmableManager.this.b(i3);
            }
        });
    }

    @Override // com.tencent.biz.qqstory.model.e
    public void onDestroy() {
    }

    @Override // com.tencent.biz.qqstory.model.e
    public void onInit() {
    }
}
