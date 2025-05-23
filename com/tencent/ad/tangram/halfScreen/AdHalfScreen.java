package com.tencent.ad.tangram.halfScreen;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdHalfScreen {
    private static final String TAG = "AdHalfScreen";
    private static volatile AdHalfScreen sInstance;
    private WeakReference<AdHalfScreenAdapter> mAdapter;

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public static final class Params {
        public WeakReference<Activity> activity;
        public Bundle extrasForIntent;
        public String webUrl;

        public boolean isValid() {
            WeakReference<Activity> weakReference = this.activity;
            if (weakReference != null && weakReference.get() != null && !TextUtils.isEmpty(this.webUrl)) {
                return true;
            }
            return false;
        }
    }

    AdHalfScreen() {
    }

    public static AdHalfScreen getInstance() {
        if (sInstance == null) {
            synchronized (AdHalfScreen.class) {
                if (sInstance == null) {
                    sInstance = new AdHalfScreen();
                }
            }
        }
        return sInstance;
    }

    @Nullable
    public AdHalfScreenAdapter getAdapter() {
        WeakReference<AdHalfScreenAdapter> weakReference = this.mAdapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void setAdapter(WeakReference<AdHalfScreenAdapter> weakReference) {
        this.mAdapter = weakReference;
    }

    public AdError showWithoutAd(WeakReference<Activity> weakReference, String str) {
        AdHalfScreenAdapter adapter = getAdapter();
        if (adapter == null) {
            AdLog.e(TAG, "showWithoutAd error");
            return new AdError(306);
        }
        Params params = new Params();
        params.activity = weakReference;
        params.webUrl = str;
        return adapter.showWithoutAd(params);
    }
}
