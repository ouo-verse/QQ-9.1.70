package com.tencent.luggage.wxa.xd;

/* compiled from: P */
/* loaded from: classes9.dex */
public class r extends p {
    private static final int CTRL_INDEX = 248;
    private static final String NAME = "onUserCaptureScreen";

    public static void c(d dVar) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandOnUserCaptureScreenEvent", "user capture screen event dispatch, appId:%s", dVar.getAppId());
        new r().setContext(dVar).dispatch();
    }
}
