package com.tencent.ad.tangram.statistics;

import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdReporterForOuterJump {
    private static final String TAG = "AdReporterForOuterJump";
    private static volatile AdReporterForOuterJump sInstance;
    private WeakReference<AdReporterForOuterJumpAdapter> mAdapter;

    private AdReporterForOuterJumpAdapter getAdapter() {
        WeakReference<AdReporterForOuterJumpAdapter> weakReference = this.mAdapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static AdReporterForOuterJump getInstance() {
        if (sInstance == null) {
            synchronized (AdReporterForOuterJump.class) {
                if (sInstance == null) {
                    sInstance = new AdReporterForOuterJump();
                }
            }
        }
        return sInstance;
    }

    public void onClick(Ad ad5) {
        AdReporterForOuterJumpAdapter adapter = getAdapter();
        if (adapter == null) {
            AdLog.e(TAG, "[onClick] error, adapter is null");
        } else {
            adapter.onClick(ad5);
        }
    }

    public void setAdapter(WeakReference<AdReporterForOuterJumpAdapter> weakReference) {
        this.mAdapter = weakReference;
    }
}
