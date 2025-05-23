package com.tencent.mobileqq.intervideo.groupvideo.clearcache.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.intervideo.groupvideo.clearcache.api.ICacheClear;

/* compiled from: P */
/* loaded from: classes33.dex */
public class CacheClearImpl implements ICacheClear {
    private static final String CLEAR_CACHE_ACTION = "com.tencent.mobile.odapp.clearCache";
    private static final String TAG = "CacheClearImpl";

    @Override // com.tencent.mobileqq.intervideo.groupvideo.clearcache.api.ICacheClear
    public void cleanCache(Context context) {
        context.sendBroadcast(new Intent(CLEAR_CACHE_ACTION));
    }
}
