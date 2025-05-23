package com.huawei.hms.activity.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ForegroundBusResponseMgr {

    /* renamed from: b, reason: collision with root package name */
    private static final ForegroundBusResponseMgr f36631b = new ForegroundBusResponseMgr();

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, BusResponseCallback> f36632a = new HashMap();

    public static ForegroundBusResponseMgr getInstance() {
        return f36631b;
    }

    public BusResponseCallback get(String str) {
        BusResponseCallback busResponseCallback;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f36632a) {
            busResponseCallback = this.f36632a.get(str);
        }
        return busResponseCallback;
    }

    public void registerObserver(String str, BusResponseCallback busResponseCallback) {
        if (!TextUtils.isEmpty(str) && busResponseCallback != null) {
            synchronized (this.f36632a) {
                if (!this.f36632a.containsKey(str)) {
                    this.f36632a.put(str, busResponseCallback);
                }
            }
        }
    }

    public void unRegisterObserver(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f36632a) {
            this.f36632a.remove(str);
        }
    }
}
