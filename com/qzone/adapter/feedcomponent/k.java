package com.qzone.adapter.feedcomponent;

import android.util.SparseArray;
import java.util.Properties;

/* compiled from: P */
/* loaded from: classes39.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public SparseArray<Long> f41921a = new SparseArray<>();

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public k clone() {
        k kVar = new k();
        kVar.f41921a = this.f41921a.clone();
        return kVar;
    }

    public void c() {
        int i3;
        for (0; i3 < this.f41921a.size(); i3 + 1) {
            try {
                i3 = (this.f41921a.get(i3) != null && this.f41921a.get(i3).longValue() > 0) ? i3 + 1 : 0;
                com.qzone.proxy.feedcomponent.b.c("FeedStatics", "FeedTimeInfo invalid. index:" + i3);
                return;
            } catch (Throwable th5) {
                com.qzone.proxy.feedcomponent.b.d("FeedStatics", "", th5);
                return;
            }
        }
        Properties properties = new Properties();
        long longValue = this.f41921a.get(5).longValue() - this.f41921a.get(0).longValue();
        properties.put("total", Long.valueOf(longValue));
        properties.put("srv_rsp", Long.valueOf(this.f41921a.get(1).longValue() - this.f41921a.get(0).longValue()));
        properties.put("rsp_decode", Long.valueOf(this.f41921a.get(2).longValue() - this.f41921a.get(1).longValue()));
        properties.put("cache_update", Long.valueOf(this.f41921a.get(3).longValue() - this.f41921a.get(2).longValue()));
        properties.put("cache_load", Long.valueOf(this.f41921a.get(4).longValue() - this.f41921a.get(3).longValue()));
        properties.put("notify_ui", Long.valueOf(this.f41921a.get(5).longValue() - this.f41921a.get(4).longValue()));
        com.qzone.proxy.feedcomponent.b.i("FeedStatics", "Feed\u5217\u8868\u52a0\u8f7d\u8017\u65f6 " + properties.toString());
        i.H().e2("feed_load_time", properties, (int) longValue);
    }

    public void d() {
        this.f41921a.clear();
    }

    public void b(int i3) {
        if (i3 == 0) {
            this.f41921a.clear();
        }
        this.f41921a.append(i3, Long.valueOf(System.currentTimeMillis()));
    }
}
