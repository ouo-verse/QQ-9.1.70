package com.tencent.ad.tangram.interpage;

import android.support.annotation.Nullable;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdClickUtil;
import java.lang.ref.WeakReference;

@AdKeep
/* loaded from: classes3.dex */
public final class AdInterPage {
    private static final String TAG = "AdInterPage";
    private static volatile AdInterPage sInstance;
    private WeakReference<AdInterPageAdapter> mAdapter;

    AdInterPage() {
    }

    @Nullable
    private AdInterPageAdapter getAdapter() {
        WeakReference<AdInterPageAdapter> weakReference = this.mAdapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static AdInterPage getInstance() {
        if (sInstance == null) {
            synchronized (AdInterPage.class) {
                if (sInstance == null) {
                    sInstance = new AdInterPage();
                }
            }
        }
        return sInstance;
    }

    public void setAdapter(WeakReference<AdInterPageAdapter> weakReference) {
        this.mAdapter = weakReference;
    }

    public AdError showOlympicPage(AdClickUtil.Params params) {
        AdInterPageAdapter adapter = getAdapter();
        if (adapter == null) {
            AdLog.e(TAG, "show error");
            return new AdError(400);
        }
        return adapter.showOlympicPage(params);
    }
}
