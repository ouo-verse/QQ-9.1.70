package com.tencent.luggage.wxa.be;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.k0;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends k0 {
    private static final int CTRL_INDEX = 856;
    public static final String NAME = "onTextViewLinkClick";

    /* renamed from: a, reason: collision with root package name */
    public String f122397a;

    public b b(String str) {
        this.f122397a = str;
        return this;
    }

    public void b(com.tencent.luggage.wxa.xd.d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", this.f122397a);
        w.d("MicroMsg.JsApiEventTextViewLinkClick", "onTextViewLinkClick, url:%s", this.f122397a);
        setData(hashMap).setContext(dVar).dispatch();
    }
}
