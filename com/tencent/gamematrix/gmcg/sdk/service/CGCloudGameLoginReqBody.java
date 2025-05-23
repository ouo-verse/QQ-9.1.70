package com.tencent.gamematrix.gmcg.sdk.service;

import com.tencent.gamematrix.gmcg.api.GmCgAutoLoginIdType;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGCloudGameLoginReqBody {
    public String bussid;
    public int channel;
    public String code;
    public String deviceid;
    public String dst_access_token;
    public String dst_openid;
    public String game_payload;
    public String gameid;
    public String identity;
    public String os_type;
    public String param1;
    public String param2;
    public String param3;

    @GmCgAutoLoginIdType
    public int type;
}
