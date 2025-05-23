package com.tencent.ad.tangram.videoceiling;

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
public final class AdVideoCeiling {
    private static final String TAG = "AdVideoCeiling";
    private static volatile AdVideoCeiling sInstance;
    private WeakReference<AdVideoCeilingAdapter> adapter;

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public static final class Params {
        public WeakReference<Activity> activity;

        /* renamed from: ad, reason: collision with root package name */
        @Nullable
        public Ad f61336ad;
        public Bundle extrasForIntent;
        public boolean useVerticalTransitionBetweenActivities;
        public String vid;

        @Nullable
        public String videoUrl;

        @Nullable
        public String webUrl;

        @Nullable
        public String widthHeightRatio;
        public boolean videoPlayForced = false;
        public boolean videoLoop = true;
        public int actionCode = 0;

        public boolean isValid() {
            Ad ad5;
            WeakReference<Activity> weakReference = this.activity;
            if (weakReference != null && weakReference.get() != null && (ad5 = this.f61336ad) != null && ad5.isValid() && !TextUtils.isEmpty(this.webUrl) && ((!TextUtils.isEmpty(this.videoUrl) || !TextUtils.isEmpty(this.vid)) && !TextUtils.isEmpty(this.widthHeightRatio))) {
                return true;
            }
            return false;
        }
    }

    AdVideoCeiling() {
    }

    @Nullable
    private AdVideoCeilingAdapter getAdapter() {
        WeakReference<AdVideoCeilingAdapter> weakReference = this.adapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static AdVideoCeiling getInstance() {
        if (sInstance == null) {
            synchronized (AdVideoCeiling.class) {
                if (sInstance == null) {
                    sInstance = new AdVideoCeiling();
                }
            }
        }
        return sInstance;
    }

    public void setAdapter(WeakReference<AdVideoCeilingAdapter> weakReference) {
        this.adapter = weakReference;
    }

    public AdError show(Params params) {
        AdVideoCeilingAdapter adapter = getAdapter();
        if (adapter == null) {
            AdLog.e(TAG, "show error");
            return new AdError(303);
        }
        return adapter.show(params);
    }
}
