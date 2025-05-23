package com.tencent.mobileqq.apollo.res.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.vip.h;
import mqq.app.AppRuntime;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IApolloQueueDownloader extends QRouteApi, h {
    @Override // com.tencent.mobileqq.vip.h
    /* synthetic */ int cancelTask(boolean z16, String str);

    @Override // com.tencent.mobileqq.vip.h
    /* synthetic */ g getTask(String str);

    void init(AppRuntime appRuntime, Object obj);

    @Override // com.tencent.mobileqq.vip.h
    /* synthetic */ void onDestroy();

    @Override // com.tencent.mobileqq.vip.h
    /* synthetic */ void startDownload(g gVar, f fVar, Bundle bundle);
}
