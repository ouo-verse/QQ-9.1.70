package com.tencent.mobileqq.ark.api;

import com.tencent.mobileqq.ark.vipreport.d;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IArkVipReport extends QRouteApi {
    public static final String SCENE_OPEN_LOGIN = "OpenLogin";
    public static final String SCENE_OPEN_SHARE = "OpenShare";

    void addEventToScene(String str, boolean z16, long j3, HashMap<String, String> hashMap);

    void initScene(String str, d dVar);

    void startSceneByEvent(String str, long j3);
}
