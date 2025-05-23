package com.tencent.ad.tangram.wechat;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

@AdKeep
/* loaded from: classes3.dex */
public final class AdWXMINIProgram {
    private static final String TAG = "AdWXMINIProgram";
    private static volatile AdWXMINIProgram sInstance;
    private WeakReference<AdWXMINIProgramAdapter> adapter;

    @AdKeep
    /* loaded from: classes3.dex */
    public static final class Params {

        /* renamed from: ad, reason: collision with root package name */
        public Ad f61351ad;
        public String appID;
        public String channelAppID;
        public String path;
        public String token;
        public String traceData;
        public String userName;
        public WeakReference<Activity> weakActivity;
        public int openType = Integer.MIN_VALUE;
        public boolean reportForLinkEvent = false;

        public boolean isValid() {
            WeakReference<Activity> weakReference = this.weakActivity;
            if (weakReference != null && weakReference.get() != null && !TextUtils.isEmpty(this.channelAppID) && !TextUtils.isEmpty(this.userName)) {
                return true;
            }
            return false;
        }
    }

    AdWXMINIProgram() {
    }

    private AdWXMINIProgramAdapter getAdapter() {
        WeakReference<AdWXMINIProgramAdapter> weakReference = this.adapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static AdWXMINIProgram getInstance() {
        if (sInstance == null) {
            synchronized (AdWXMINIProgram.class) {
                if (sInstance == null) {
                    sInstance = new AdWXMINIProgram();
                }
            }
        }
        return sInstance;
    }

    public void setAdapter(WeakReference<AdWXMINIProgramAdapter> weakReference) {
        this.adapter = weakReference;
    }

    public AdError show(Params params) {
        AdWXMINIProgramAdapter adapter = getAdapter();
        if (adapter == null) {
            AdLog.e(TAG, "show error, adapter is null");
            return new AdError(308);
        }
        return adapter.show(params);
    }
}
