package com.tencent.ad.tangram.triple;

import android.support.annotation.Nullable;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdClickUtil;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdTripleLink {
    private static final String TAG = "AdTripleLink";
    private static volatile AdTripleLink sInstance;
    private WeakReference<AdTripleLinkAdapter> mAdapter;

    AdTripleLink() {
    }

    @Nullable
    private AdTripleLinkAdapter getAdapter() {
        WeakReference<AdTripleLinkAdapter> weakReference = this.mAdapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static AdTripleLink getInstance() {
        if (sInstance == null) {
            synchronized (AdTripleLink.class) {
                if (sInstance == null) {
                    sInstance = new AdTripleLink();
                }
            }
        }
        return sInstance;
    }

    public void setAdapter(WeakReference<AdTripleLinkAdapter> weakReference) {
        this.mAdapter = weakReference;
    }

    public AdError show(AdClickUtil.Params params, AdClickUtil.URLObject uRLObject) {
        AdTripleLinkAdapter adapter = getAdapter();
        if (adapter == null) {
            AdLog.e(TAG, "show error");
            return new AdError(309);
        }
        return adapter.show(params, uRLObject);
    }
}
