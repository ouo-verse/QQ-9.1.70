package com.tencent.mobileqq.Doraemon;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes9.dex */
public interface IDoraemonClient extends QRouteApi {
    void sendToServer(int i3, Bundle bundle, d dVar);
}
