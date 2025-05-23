package com.tencent.map.tools.net.http;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;

/* loaded from: classes9.dex */
public class HttpProxyRule extends JsonComposer {

    @Json(name = "domain")
    public String domain;

    @Json(name = "proxy_domain")
    public String proxyDomain;

    public boolean match(String str) {
        Uri parse;
        String scheme;
        String host;
        if (str == null || (scheme = (parse = Uri.parse(str)).getScheme()) == null || !scheme.startsWith("http") || (host = parse.getHost()) == null || TextUtils.isEmpty(host)) {
            return false;
        }
        return host.matches(this.domain);
    }

    public String replaceHost(String str) {
        String host;
        if (str == null) {
            return null;
        }
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (scheme != null && scheme.startsWith("http") && (host = parse.getHost()) != null && !TextUtils.isEmpty(host) && host.matches(this.domain)) {
            return parse.buildUpon().encodedAuthority(this.proxyDomain).build().toString();
        }
        return str;
    }
}
