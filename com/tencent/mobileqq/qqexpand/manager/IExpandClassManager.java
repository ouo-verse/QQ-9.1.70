package com.tencent.mobileqq.qqexpand.manager;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IExpandClassManager extends QRouteApi {
    String getExpandHandlerClassName();

    Class getExpandLimitChatManagerClass();

    Class getExpandManagerClass();
}
