package com.tencent.mobileqq.intervideo.groupvideo.clearcache.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface ICacheClear extends QRouteApi {
    void cleanCache(Context context);
}
