package com.tencent.gamematrix.gmcg.sdk.service;

import com.google.gson.JsonObject;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGMergeLaunchCloudGameReqBody {
    public List<BodyBean> body;
    public String deviceid;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class BodyBean {
        public boolean failGoOn;
        public JsonObject request;
        public String url;
    }
}
