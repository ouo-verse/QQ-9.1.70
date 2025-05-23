package com.tencent.luggage.wxa.aa;

import java.security.PrivilegedAction;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f implements PrivilegedAction {

    /* renamed from: a, reason: collision with root package name */
    public String f121004a;

    /* renamed from: b, reason: collision with root package name */
    public String f121005b;

    public f(String str) {
        this.f121004a = str;
    }

    @Override // java.security.PrivilegedAction
    public Object run() {
        String property = System.getProperty(this.f121004a);
        if (property == null) {
            return this.f121005b;
        }
        return property;
    }
}
