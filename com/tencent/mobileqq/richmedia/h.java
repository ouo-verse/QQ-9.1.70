package com.tencent.mobileqq.richmedia;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<String, a> f281590a = new ConcurrentHashMap<>(10);

    public boolean a(String str) {
        d.a("VideoCompoundController", "removeProcessor, key = " + str);
        if (str == null || this.f281590a.remove(str) == null) {
            return false;
        }
        return true;
    }
}
