package com.sina.weibo.sdk.net;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: s, reason: collision with root package name */
    private HashMap<String, String> f61267s = new HashMap<>();

    public final String k() {
        StringBuilder sb5 = new StringBuilder();
        boolean z16 = true;
        for (String str : this.f61267s.keySet()) {
            if (z16) {
                z16 = false;
            } else {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            String str2 = this.f61267s.get(str);
            if (!TextUtils.isEmpty(str2)) {
                try {
                    sb5.append(URLEncoder.encode(str, "UTF-8"));
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(URLEncoder.encode(str2, "UTF-8"));
                } catch (UnsupportedEncodingException e16) {
                    e16.printStackTrace();
                }
            }
        }
        return sb5.toString();
    }

    public final void put(String str, String str2) {
        this.f61267s.put(str, str2);
    }
}
