package com.tencent.ad.tangram.halfScreenDownload;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdClickLocationParams;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdHalfScreenDownload {
    private static final String TAG = "AdHalfScreenDownload";
    private static volatile AdHalfScreenDownload sInstance;
    private WeakReference<AdHalfScreenDownloadAdapter> mWeakAdapter;

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public static final class Params {

        /* renamed from: ad, reason: collision with root package name */
        public Ad f61320ad;
        public AdClickLocationParams clickLocationParams;
        public Bundle extrasForIntent;
        public WeakReference<Activity> weakActivity;

        public boolean isValid() {
            Ad ad5;
            WeakReference<Activity> weakReference = this.weakActivity;
            if (weakReference != null && weakReference.get() != null && (ad5 = this.f61320ad) != null && ad5.isEnableHalfScreenDownload() && !TextUtils.isEmpty(this.f61320ad.getAppIconUrl()) && !TextUtils.isEmpty(this.f61320ad.getAppDownloadUrlApi()) && !TextUtils.isEmpty(this.f61320ad.getAppChannelAppName()) && !TextUtils.isEmpty(this.f61320ad.getAppChannelPrivacyUrl()) && !TextUtils.isEmpty(this.f61320ad.getAppChannelVersionName()) && !TextUtils.isEmpty(this.f61320ad.getAppChannelPermissionUrl()) && !TextUtils.isEmpty(this.f61320ad.getAppChannelAuthorName()) && !TextUtils.isEmpty(this.f61320ad.getAppChannelFeatureListUrl())) {
                return true;
            }
            return false;
        }
    }

    AdHalfScreenDownload() {
    }

    public static AdHalfScreenDownload getInstance() {
        if (sInstance == null) {
            synchronized (AdHalfScreenDownload.class) {
                if (sInstance == null) {
                    sInstance = new AdHalfScreenDownload();
                }
            }
        }
        return sInstance;
    }

    @Nullable
    public AdHalfScreenDownloadAdapter getAdapter() {
        WeakReference<AdHalfScreenDownloadAdapter> weakReference = this.mWeakAdapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void setAdapter(WeakReference<AdHalfScreenDownloadAdapter> weakReference) {
        this.mWeakAdapter = weakReference;
    }

    public AdError show(Params params) {
        AdHalfScreenDownloadAdapter adapter = getAdapter();
        if (adapter == null) {
            AdLog.e(TAG, "show error");
            return new AdError(300);
        }
        return adapter.show(params);
    }
}
