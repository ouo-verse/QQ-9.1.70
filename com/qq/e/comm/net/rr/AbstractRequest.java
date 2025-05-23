package com.qq.e.comm.net.rr;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.e.comm.util.StringUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class AbstractRequest implements Request {

    /* renamed from: b, reason: collision with root package name */
    private int f38303b;

    /* renamed from: c, reason: collision with root package name */
    private int f38304c;

    /* renamed from: d, reason: collision with root package name */
    private int f38305d;

    /* renamed from: e, reason: collision with root package name */
    private String f38306e;

    /* renamed from: j, reason: collision with root package name */
    private int f38311j;

    /* renamed from: k, reason: collision with root package name */
    private byte[] f38312k;

    /* renamed from: a, reason: collision with root package name */
    private boolean f38302a = true;

    /* renamed from: f, reason: collision with root package name */
    private Map<String, String> f38307f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private Map<String, String> f38308g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private Map<String, String> f38309h = Collections.unmodifiableMap(this.f38307f);

    /* renamed from: i, reason: collision with root package name */
    private Map<String, String> f38310i = Collections.unmodifiableMap(this.f38308g);

    public AbstractRequest(String str, int i3, byte[] bArr) {
        this.f38306e = str;
        this.f38311j = i3;
        this.f38312k = bArr == null ? null : (byte[]) bArr.clone();
    }

    @Override // com.qq.e.comm.net.rr.Request
    public void addHeader(String str, String str2) {
        if (!StringUtil.isEmpty(str) && !StringUtil.isEmpty(str2)) {
            this.f38307f.put(str, str2);
        }
    }

    @Override // com.qq.e.comm.net.rr.Request
    public void addQuery(String str, String str2) {
        this.f38308g.put(str, str2);
    }

    @Override // com.qq.e.comm.net.rr.Request
    public int getConnectionTimeOut() {
        return this.f38304c;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public int getMethod() {
        return this.f38311j;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public byte[] getPostData() throws Exception {
        return this.f38312k;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public int getPriority() {
        return this.f38303b;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public Map<String, String> getQuerys() {
        return this.f38310i;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public int getSocketTimeOut() {
        return this.f38305d;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public Map<String, String> getUnmodifiableHeaders() {
        return this.f38309h;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public String getUrl() {
        return this.f38306e;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public String getUrlWithParas() {
        if (!TextUtils.isEmpty(this.f38306e) && !getQuerys().isEmpty()) {
            Uri.Builder buildUpon = Uri.parse(this.f38306e).buildUpon();
            if (buildUpon == null) {
                return this.f38306e;
            }
            for (Map.Entry<String, String> entry : getQuerys().entrySet()) {
                buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
            }
            return buildUpon.build().toString();
        }
        return this.f38306e;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public boolean isAutoClose() {
        return this.f38302a;
    }

    public void setAutoClose(boolean z16) {
        this.f38302a = z16;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public void setConnectionTimeOut(int i3) {
        this.f38304c = i3;
    }

    public void setPriority(int i3) {
        this.f38303b = i3;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public void setSocketTimeOut(int i3) {
        this.f38305d = i3;
    }

    public AbstractRequest(String str, Map<String, String> map, int i3) {
        this.f38306e = str;
        this.f38311j = i3;
        if (2 == i3) {
            StringBuilder sb5 = new StringBuilder();
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String encode = URLEncoder.encode(entry.getKey(), "utf-8");
                    String encode2 = URLEncoder.encode(entry.getValue(), "utf-8");
                    if (sb5.length() > 0) {
                        sb5.append(ContainerUtils.FIELD_DELIMITER);
                    }
                    sb5.append(encode);
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(encode2);
                }
                if (sb5.length() > 0) {
                    this.f38312k = sb5.toString().getBytes("utf-8");
                    addHeader("Content-Type", "application/x-www-form-urlencoded");
                }
            } catch (UnsupportedEncodingException e16) {
                throw new IllegalArgumentException(e16);
            }
        }
    }
}
