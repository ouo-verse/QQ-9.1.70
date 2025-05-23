package com.tencent.mobileqq.engineering.preload;

import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;

/* loaded from: classes12.dex */
public abstract class BasePreLoadTask<T> {
    public long mPreloadExpiredTime = 0;
    public boolean mIsOnlyRunOnce = true;

    public abstract void onRemove();

    public abstract void startLoadData(OnPreLoadListener<T> onPreLoadListener);
}
