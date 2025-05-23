package com.tencent.beacon.base.net;

import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BResponse {
    public byte[] body;
    public int code;
    public Map<String, List<String>> headers;

    /* renamed from: msg, reason: collision with root package name */
    public String f77698msg;

    public BResponse(Map<String, List<String>> map, int i3, String str, byte[] bArr) {
        this.headers = map;
        this.code = i3;
        this.f77698msg = str;
        this.body = bArr;
    }

    public String toString() {
        return "BResponse{code=" + this.code + ", msg='" + this.f77698msg + "'}";
    }
}
