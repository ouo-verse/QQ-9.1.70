package com.tencent.luggage.wxa.in;

import com.tencent.luggage.wxa.tn.e;
import com.tencent.mobileqq.mini.cache.Entry;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends c {
    public abstract String b();

    public Object c() {
        if (Intrinsics.areEqual(b(), "Int")) {
            return 0;
        }
        if (Intrinsics.areEqual(b(), "Float")) {
            return Float.valueOf(0.0f);
        }
        if (!Intrinsics.areEqual(b(), Entry.DATA_TYPE_STRING)) {
            if (Intrinsics.areEqual(b(), "Long")) {
                return 0L;
            }
            if (e.f141559a) {
                throw new RuntimeException("invalid data type " + b());
            }
        }
        return "";
    }

    public String d() {
        return a() + util.base64_pad_url + b();
    }
}
