package com.tencent.mobileqq.dov.story.api;

import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IStoryEntityManager extends QRouteApi {
    EntityManager createEntityManager();
}
