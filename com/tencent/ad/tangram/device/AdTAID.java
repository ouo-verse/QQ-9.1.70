package com.tencent.ad.tangram.device;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.biz.common.util.WebViewConstants;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdTAID {
    private static final String TAG = "AdTAID";
    private static volatile AdTAID sInstance;
    private volatile WeakReference<AdTAIDAdapter> adapter;

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public static final class Entity {
        public String aidTicket;
        public int errorCodeForAidTicket = Integer.MIN_VALUE;
        public int errorCodeForTaidTicket = Integer.MIN_VALUE;
        public long expiredTimeMillis = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        public int originErrorCode = Integer.MIN_VALUE;
        public String taidTicket;
        public Throwable throwable;
    }

    AdTAID() {
    }

    @Nullable
    private AdTAIDAdapter getAdapter() {
        if (this.adapter != null) {
            return this.adapter.get();
        }
        return null;
    }

    public static AdTAID getInstance() {
        if (sInstance == null) {
            synchronized (AdTAID.class) {
                if (sInstance == null) {
                    sInstance = new AdTAID();
                }
            }
        }
        return sInstance;
    }

    @Nullable
    public Entity getEntity(Context context) {
        AdTAIDAdapter adapter = getAdapter();
        if (adapter == null) {
            AdLog.e(TAG, "getEntity error, adapter is null");
            return null;
        }
        return adapter.getEntity(context);
    }

    public void init(Context context) {
        AdTAIDAdapter adapter = getAdapter();
        if (adapter == null) {
            AdLog.e(TAG, "getEntity error, adapter is null");
        } else {
            adapter.init(context);
        }
    }

    public void setAdapter(WeakReference<AdTAIDAdapter> weakReference) {
        this.adapter = weakReference;
    }
}
