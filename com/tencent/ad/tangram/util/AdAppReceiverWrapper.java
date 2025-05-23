package com.tencent.ad.tangram.util;

import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdClickUtil;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdAppReceiverWrapper {
    private static final String TAG = "AdAppReceiverWrapper";
    private static volatile AdAppReceiverWrapper sInstance;
    private WeakReference<Adapter> mWeakAdapter;

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public interface Adapter {
        void observe(AdClickUtil.Params params, AdClickUtil.Result result);
    }

    AdAppReceiverWrapper() {
    }

    private Adapter getAdapter() {
        WeakReference<Adapter> weakReference = this.mWeakAdapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static AdAppReceiverWrapper getInstance() {
        if (sInstance == null) {
            synchronized (AdAppReceiverWrapper.class) {
                if (sInstance == null) {
                    sInstance = new AdAppReceiverWrapper();
                }
            }
        }
        return sInstance;
    }

    public void observe(AdClickUtil.Params params, AdClickUtil.Result result) {
        Adapter adapter = getAdapter();
        if (adapter == null) {
            AdLog.e(TAG, "[observe] error, adapter is null");
        } else {
            AdLog.i(TAG, "[observe]");
            adapter.observe(params, result);
        }
    }

    public void setAdapter(WeakReference<Adapter> weakReference) {
        this.mWeakAdapter = weakReference;
    }
}
