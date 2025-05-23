package com.tencent.mobileqq.guild.nt.qcircle.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IOutboxTaskQueueApi extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
    }

    void addPausedTask(a aVar);

    void init();

    a newTask(Object obj);
}
