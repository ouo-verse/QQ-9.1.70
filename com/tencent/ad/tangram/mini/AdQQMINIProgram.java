package com.tencent.ad.tangram.mini;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

@AdKeep
/* loaded from: classes3.dex */
public final class AdQQMINIProgram {
    private static final String TAG = "AdQQMINIProgram";
    private static volatile AdQQMINIProgram sInstance;
    private WeakReference<AdQQMINIProgramAdapter> adapter;

    @AdKeep
    /* loaded from: classes3.dex */
    public static final class Params {

        /* renamed from: ad, reason: collision with root package name */
        public Ad f61321ad;
        public WeakReference<Context> context;
        public Bundle extrasForIntent;

        public boolean isValid() {
            Ad ad5;
            WeakReference<Context> weakReference = this.context;
            if (weakReference != null && weakReference.get() != null && (ad5 = this.f61321ad) != null && ad5.isValid() && !TextUtils.isEmpty(this.f61321ad.getUrlForLandingPage())) {
                return true;
            }
            return false;
        }
    }

    AdQQMINIProgram() {
    }

    @Nullable
    private AdQQMINIProgramAdapter getAdapter() {
        WeakReference<AdQQMINIProgramAdapter> weakReference = this.adapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static AdQQMINIProgram getInstance() {
        if (sInstance == null) {
            synchronized (AdQQMINIProgram.class) {
                if (sInstance == null) {
                    sInstance = new AdQQMINIProgram();
                }
            }
        }
        return sInstance;
    }

    public void setAdapter(WeakReference<AdQQMINIProgramAdapter> weakReference) {
        this.adapter = weakReference;
    }

    public AdError show(Params params) {
        AdQQMINIProgramAdapter adapter = getAdapter();
        if (adapter == null) {
            AdLog.e(TAG, "show");
            return new AdError(304);
        }
        return adapter.show(params);
    }
}
