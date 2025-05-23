package com.tencent.biz.qqcircle.immersive.views.search.util;

import android.content.Context;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPrerenderManager;
import java.util.Map;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Integer> f91263a = new ArrayMap();

    /* renamed from: b, reason: collision with root package name */
    private final MutableLiveData<String> f91264b = new MutableLiveData<>(null);

    /* renamed from: c, reason: collision with root package name */
    private String f91265c;

    public void a(Context context) {
        QFSSearchPrerenderManager.E(context).S(this);
    }

    public MutableLiveData<String> b() {
        return this.f91264b;
    }

    public int c(String str) {
        int i3 = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        synchronized (this.f91263a) {
            Integer num = this.f91263a.get(str);
            if (num != null) {
                i3 = num.intValue();
            }
        }
        return i3;
    }

    public String d() {
        return this.f91265c;
    }

    public void e() {
        this.f91264b.setValue(null);
        synchronized (this.f91263a) {
            this.f91263a.clear();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return Objects.equals(this.f91265c, ((h) obj).f91265c);
        }
        return false;
    }

    public void f(String str) {
        this.f91264b.setValue(str);
    }

    public void g(String str) {
        this.f91265c = str;
    }

    public void h(String str, int i3) {
        boolean z16;
        Integer num;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String value = this.f91264b.getValue();
        if (!TextUtils.equals(str, value)) {
            this.f91264b.setValue(str);
            z16 = true;
        } else {
            z16 = false;
        }
        synchronized (this.f91263a) {
            if (z16) {
                if (!TextUtils.isEmpty(value)) {
                    num = this.f91263a.get(value);
                } else {
                    num = null;
                }
                this.f91263a.clear();
                if (num != null) {
                    this.f91263a.put(value, num);
                }
            }
            this.f91263a.put(str, Integer.valueOf(i3));
        }
    }

    public int hashCode() {
        return Objects.hash(this.f91265c);
    }
}
