package com.tencent.mobileqq.intervideo.groupvideo.cschannel;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IODCsChannel extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
        void a(int i3, byte[] bArr, Bundle bundle);
    }

    IODCsChannel get(AppInterface appInterface, long j3);

    IODCsChannel get(AppInterface appInterface, long j3, String str, String str2);

    void login(int i3, byte[] bArr, int i16, a aVar);

    void sendOIDBRequest(int i3, byte[] bArr, Bundle bundle, a aVar);

    void sendRequest(int i3, byte[] bArr, a aVar);

    void sendRequest(int i3, byte[] bArr, boolean z16, int i16, a aVar);

    void sendRequest(int i3, byte[] bArr, boolean z16, a aVar);
}
