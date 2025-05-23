package com.tencent.biz.qqcircle.immersive.personal.bean;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.immersive.personal.data.w;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class v extends MutableLiveData<w> {

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static abstract class a implements Observer<w> {

        /* renamed from: d, reason: collision with root package name */
        private volatile String f88529d = "";

        /* renamed from: e, reason: collision with root package name */
        private final ConcurrentHashMap<String, Long> f88530e = new ConcurrentHashMap<>();

        /* renamed from: f, reason: collision with root package name */
        private w f88531f;

        /* renamed from: h, reason: collision with root package name */
        private w f88532h;

        public List<String> a() {
            return null;
        }

        public boolean b(w wVar, @NonNull w wVar2) {
            return true;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onChanged(w wVar) {
            Long l3;
            if (wVar == null) {
                return;
            }
            if (a() == null) {
                this.f88532h = wVar;
                if (b(this.f88531f, wVar)) {
                    d(wVar);
                }
                this.f88531f = wVar;
                return;
            }
            boolean z16 = true;
            if (TextUtils.equals(wVar.L(), this.f88529d)) {
                for (String str : a()) {
                    long h16 = wVar.h(str);
                    if (h16 != 0 && ((l3 = this.f88530e.get(str)) == null || h16 > l3.longValue())) {
                        this.f88530e.put(str, Long.valueOf(h16));
                        break;
                    }
                }
                z16 = false;
            } else {
                this.f88529d = wVar.L();
                this.f88530e.clear();
            }
            if (z16) {
                d(wVar);
            }
        }

        public abstract void d(@NonNull w wVar);
    }

    public void c(@NonNull LifecycleOwner lifecycleOwner, @NonNull a aVar) {
        super.observe(lifecycleOwner, aVar);
    }
}
