package com.tencent.mobileqq.troop.api.troopcreate;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopCreateForStructMsg extends QRouteApi {
    boolean instanceofImgaeShare();

    void onDestroy();

    void sendStructingMsg(AppRuntime appRuntime, String str, int i3, BusinessObserver businessObserver);

    void setAbsStructMsgFromByte(byte[] bArr);
}
