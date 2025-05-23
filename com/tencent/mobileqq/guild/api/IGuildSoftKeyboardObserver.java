package com.tencent.mobileqq.guild.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildSoftKeyboardObserver extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface a {
    }

    void destroy();

    void newSoftKeyboardObserverImpl(View view, a aVar);
}
