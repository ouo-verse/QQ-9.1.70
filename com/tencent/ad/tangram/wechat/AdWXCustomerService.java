package com.tencent.ad.tangram.wechat;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdWXCustomerService {
    private static final String TAG = "AdWXCustomerService";
    private static volatile AdWXCustomerService sInstance;
    private WeakReference<AdWXCustomerServiceAdapter> mWeakAdapter;

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public static final class Params {

        /* renamed from: ad, reason: collision with root package name */
        public Ad f61350ad;
        public Bundle extrasForIntent;
        public WeakReference<Activity> waekActivity;

        public boolean isValid() {
            Ad ad5;
            WeakReference<Activity> weakReference = this.waekActivity;
            if (weakReference != null && weakReference.get() != null && (ad5 = this.f61350ad) != null && ad5.isWXCustomerService()) {
                return true;
            }
            return false;
        }
    }

    private AdWXCustomerServiceAdapter getAdapter() {
        WeakReference<AdWXCustomerServiceAdapter> weakReference = this.mWeakAdapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static AdWXCustomerService getInstance() {
        if (sInstance == null) {
            synchronized (AdWXCustomerService.class) {
                if (sInstance == null) {
                    sInstance = new AdWXCustomerService();
                }
            }
        }
        return sInstance;
    }

    public void setAdapter(WeakReference<AdWXCustomerServiceAdapter> weakReference) {
        this.mWeakAdapter = weakReference;
    }

    public AdError show(Params params) {
        AdWXCustomerServiceAdapter adapter = getAdapter();
        if (adapter == null) {
            AdLog.e(TAG, "[show] error, adapter is null");
            return new AdError(1);
        }
        return adapter.show(params);
    }
}
