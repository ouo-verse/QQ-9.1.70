package com.tencent.qqlive.tvkplayer.tools.httpdns;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mobileqq.app.identity.jwt.JsonWebSignature;
import com.tencent.oskplayer.util.SecretUtils;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKHttpDnsRequestBuilder {
    public static final int HTTPS_REQUEST_TYPE = 2;
    private static final String HTTPS_TOKEN = "httpDnsToken";
    public static final int HTTP_AES_REQUEST_TYPE = 1;
    public static final int HTTP_DES_REQUEST_TYPE = 0;
    private static final String HTTP_DNS_REQUEST_HTTPS_URL = "https://119.29.29.99/d";
    private static final String HTTP_DNS_REQUEST_HTTP_URL = "http://119.29.29.98/d";
    private static final String USER_ID = "httpDnsUserId";
    private final String mHostName;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private static class RequestParamKey {
        private static final String DOMAIN_NAME_QUERIED = "dn";
        private static final String ENCRYPT_ALGORITHM = "alg";
        private static final String HTTPS_TOKEN = "token";
        private static final String TP_TYPE = "type";
        private static final String TTL = "ttl";
        private static final String USER_ID = "id";

        RequestParamKey() {
        }
    }

    public TVKHttpDnsRequestBuilder(String str) {
        this.mHostName = str;
    }

    public Map<String, String> buildRequestParams() {
        HashMap hashMap = new HashMap();
        int i3 = TVKMediaPlayerConfig.PlayerConfig.http_dns_request_type;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    hashMap.put("dn", this.mHostName);
                    hashMap.put("token", HTTPS_TOKEN);
                }
            } else {
                hashMap.put(JsonWebSignature.ALGORITHM, "aes");
                hashMap.put("dn", TVKHttpDnsCryptoUtils.encrypt(this.mHostName, TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_AES));
            }
        } else {
            hashMap.put(JsonWebSignature.ALGORITHM, SecretUtils.DES);
            hashMap.put("dn", TVKHttpDnsCryptoUtils.encrypt(this.mHostName, TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_DES));
        }
        hashMap.put("id", USER_ID);
        hashMap.put(RemoteMessageConst.TTL, "1");
        hashMap.put("type", "addrs");
        return hashMap;
    }

    public String buildRequestUrl() {
        if (TVKMediaPlayerConfig.PlayerConfig.http_dns_request_type == 2) {
            return HTTP_DNS_REQUEST_HTTPS_URL;
        }
        return HTTP_DNS_REQUEST_HTTP_URL;
    }
}
