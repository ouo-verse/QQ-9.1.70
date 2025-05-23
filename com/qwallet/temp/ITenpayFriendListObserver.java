package com.qwallet.temp;

import android.os.ResultReceiver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface ITenpayFriendListObserver extends QRouteApi {
    void add(String str, ResultReceiver resultReceiver);

    void destroy();
}
