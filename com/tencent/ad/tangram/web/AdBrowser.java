package com.tencent.ad.tangram.web;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdBrowser {
    private static final String TAG = "AdBrowser";
    private static volatile AdBrowser sInstance;
    private WeakReference<AdBrowserAdapter> adapter;

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public static final class Params {
        public WeakReference<Activity> activity;

        /* renamed from: ad, reason: collision with root package name */
        public Ad f61348ad;
        public Bundle extrasForIntent;
        public String url;
        public boolean useVerticalTransitionBetweenActivities;
        public boolean forcePortrait = false;
        public int actionCode = 0;

        public boolean isValid() {
            WeakReference<Activity> weakReference = this.activity;
            if (weakReference != null && weakReference.get() != null && !TextUtils.isEmpty(this.url)) {
                return true;
            }
            return false;
        }
    }

    AdBrowser() {
    }

    @Nullable
    private AdBrowserAdapter getAdapter() {
        WeakReference<AdBrowserAdapter> weakReference = this.adapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static AdBrowser getInstance() {
        if (sInstance == null) {
            synchronized (AdBrowser.class) {
                if (sInstance == null) {
                    sInstance = new AdBrowser();
                }
            }
        }
        return sInstance;
    }

    public void setAdapter(WeakReference<AdBrowserAdapter> weakReference) {
        this.adapter = weakReference;
    }

    public AdError show(Params params) {
        AdBrowserAdapter adapter = getAdapter();
        if (adapter == null) {
            AdLog.e(TAG, "show error");
            return new AdError(301);
        }
        return adapter.show(params);
    }

    public AdError showWithoutAd(Params params) {
        AdBrowserAdapter adapter = getAdapter();
        if (adapter == null) {
            AdLog.e(TAG, "showWithoutAd error");
            return new AdError(301);
        }
        return adapter.showWithoutAd(params);
    }
}
