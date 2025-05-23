package com.tencent.luggage.wxa.ff;

import androidx.annotation.Nullable;
import com.tencent.live2.jsplugin.V2TXJSAdapterError;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public int f126108a;

    /* renamed from: b, reason: collision with root package name */
    public String f126109b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Map<String, Object> f126110c;

    public h() {
        this.f126108a = 0;
        this.f126109b = "Success";
        this.f126110c = null;
    }

    public h(int i3, String str) {
        this.f126110c = null;
        this.f126108a = i3;
        this.f126109b = str;
    }

    public h(V2TXJSAdapterError v2TXJSAdapterError) {
        this.f126108a = 0;
        this.f126109b = "Success";
        this.f126110c = null;
        this.f126108a = v2TXJSAdapterError.errorCode;
        this.f126109b = v2TXJSAdapterError.errorInfo;
        this.f126110c = v2TXJSAdapterError.resultMap;
    }
}
