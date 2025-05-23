package com.tencent.mobileqq.bigbrother;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface ISourceIDSetter extends QRouteApi {
    void setTeleScreenRefID(String str);

    void setTeleScreenSourceID(String str);
}
