package com.tencent.mtt.hippy.a;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

/* compiled from: P */
/* loaded from: classes20.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static String f336963a = "debugUrl";

    /* renamed from: b, reason: collision with root package name */
    private String f336964b;

    /* renamed from: c, reason: collision with root package name */
    private String f336965c;

    /* renamed from: d, reason: collision with root package name */
    private String f336966d;

    /* renamed from: e, reason: collision with root package name */
    private String f336967e;

    /* renamed from: f, reason: collision with root package name */
    private String f336968f;

    public g(String str) {
        a(str);
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            URL url = new URL(str);
            this.f336964b = url.getProtocol();
            this.f336965c = url.getHost();
            this.f336966d = url.getPath();
            int port = url.getPort();
            if (port > 0) {
                this.f336965c += ":" + port;
            }
            this.f336968f = b(url.getQuery());
            if (this.f336966d.startsWith("/")) {
                this.f336966d = this.f336966d.substring(1);
            }
            int indexOf = this.f336966d.indexOf("/");
            if (indexOf >= 0) {
                this.f336967e = this.f336966d.substring(0, indexOf);
            }
            LogUtils.i("Hippy DevRemoteServerData", String.format("parseUrl host:%s, versionId:%s", this.f336965c, this.f336967e));
        } catch (Exception e16) {
            LogUtils.e("Hippy DevRemoteServerData", "parseUrl error", e16);
        }
    }

    public String b() {
        return this.f336965c;
    }

    public String c() {
        return this.f336967e;
    }

    public String d() {
        return this.f336966d;
    }

    public String e() {
        return this.f336964b;
    }

    public String f() {
        return this.f336968f;
    }

    private String b(String str) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
            int indexOf = str2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
            if (indexOf >= 0) {
                if (f336963a.equals(str2.substring(0, indexOf))) {
                    return URLDecoder.decode(str2.substring(indexOf + 1), "UTF-8");
                }
            }
        }
        return null;
    }

    public boolean a() {
        return !TextUtils.isEmpty(this.f336965c);
    }
}
