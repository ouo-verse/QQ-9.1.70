package com.tencent.aelight.camera.qqstory.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IGategoryItemManager extends QRouteApi {
    String getItemName(Object obj);

    String getJumApp(Object obj);

    boolean isCombo(Object obj);
}
