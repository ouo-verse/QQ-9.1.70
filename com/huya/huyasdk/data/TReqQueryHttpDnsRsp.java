package com.huya.huyasdk.data;

import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class TReqQueryHttpDnsRsp {
    public int iEnvType;
    public Map<String, HttpDnsItem> mDomain2Ip;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class HttpDnsItem {
        public long iExpireTime;
        public List<String> vIp;
        public List<String> vIpv6;
    }
}
