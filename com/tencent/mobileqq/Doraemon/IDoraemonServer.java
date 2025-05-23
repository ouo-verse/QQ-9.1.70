package com.tencent.mobileqq.Doraemon;

import android.os.Bundle;
import android.os.Messenger;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes9.dex */
public interface IDoraemonServer extends QRouteApi {
    void sendToClient(int i3, Bundle bundle, int i16, Messenger messenger);
}
