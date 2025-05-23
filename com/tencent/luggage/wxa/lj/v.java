package com.tencent.luggage.wxa.lj;

import java.util.Collections;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum v implements com.tencent.luggage.wxa.ca.i {
    INSTANCE;


    /* renamed from: a, reason: collision with root package name */
    public volatile Object f133578a = null;

    v() {
    }

    @Override // com.tencent.luggage.wxa.ca.i
    public boolean a(Object obj) {
        return false;
    }

    public final u b() {
        return new u();
    }

    @Override // com.tencent.luggage.wxa.ca.i
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public u get() {
        Object obj = this.f133578a;
        if (obj == null) {
            synchronized (this) {
                obj = this.f133578a;
                if (obj == null) {
                    obj = b();
                    this.f133578a = obj;
                }
            }
        }
        return (u) obj;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "provider " + u.class.getName();
    }

    @Override // com.tencent.luggage.wxa.ca.i
    public Object a(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case 503774505:
                if (str.equals("dependencies")) {
                    c16 = 0;
                    break;
                }
                break;
            case 1026760592:
                if (str.equals("onProcess")) {
                    c16 = 1;
                    break;
                }
                break;
            case 1028554796:
                if (str.equals("creator")) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return Collections.EMPTY_LIST;
            case 1:
                return Collections.EMPTY_LIST;
            case 2:
                return Void.class;
            default:
                return null;
        }
    }
}
