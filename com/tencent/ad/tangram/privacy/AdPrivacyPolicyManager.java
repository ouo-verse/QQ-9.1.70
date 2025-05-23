package com.tencent.ad.tangram.privacy;

import android.support.annotation.Nullable;
import com.tencent.ad.tangram.annotation.AdKeep;
import java.lang.ref.WeakReference;

@AdKeep
/* loaded from: classes3.dex */
public final class AdPrivacyPolicyManager {
    private static volatile AdPrivacyPolicyManager instance;
    private volatile WeakReference<AdPrivacyPolicyManagerAdapter> adapter;

    @Nullable
    private AdPrivacyPolicyManagerAdapter getAdapter() {
        if (this.adapter != null) {
            return this.adapter.get();
        }
        return null;
    }

    public static AdPrivacyPolicyManager getInstance() {
        if (instance == null) {
            synchronized (AdPrivacyPolicyManager.class) {
                if (instance == null) {
                    instance = new AdPrivacyPolicyManager();
                }
            }
        }
        return instance;
    }

    public boolean isAllowed() {
        AdPrivacyPolicyManagerAdapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.isAllowed();
        }
        return false;
    }

    public void setAdapter(WeakReference<AdPrivacyPolicyManagerAdapter> weakReference) {
        this.adapter = weakReference;
    }
}
