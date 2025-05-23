package com.tencent.mobileqq.crossend.communication;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface INativeEventDispatcher extends QRouteApi {
    public static final int WEB_TYPE_DEFAULT = 0;
    public static final int WEB_TYPE_H5 = 1;
    public static final int WEB_TYPE_HIPPY = 3;
    public static final int WEB_TYPE_LUA = 4;
    public static final int WEB_TYPE_MINI = 2;

    void request(int i3, Object obj, String str, JSONObject jSONObject);
}
