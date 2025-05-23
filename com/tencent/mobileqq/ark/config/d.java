package com.tencent.mobileqq.ark.config;

import android.text.TextUtils;
import java.util.LinkedHashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
class d extends c {

    /* renamed from: a, reason: collision with root package name */
    private String f199252a;

    public d(String str) {
        this.f199252a = str;
    }

    @Override // com.tencent.mobileqq.ark.config.c
    public Object a(Object obj) {
        if (obj == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = (LinkedHashMap) obj;
        if (TextUtils.isEmpty(this.f199252a)) {
            return null;
        }
        return linkedHashMap.get(this.f199252a);
    }
}
