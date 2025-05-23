package com.tencent.mobileqq.richmediabrowser.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.Externalizable;

@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IPictureBusinessApi extends QRouteApi {
    String getActionDataFromStructMsg(Externalizable externalizable);

    String[] parseQQComicParams(Externalizable externalizable);
}
