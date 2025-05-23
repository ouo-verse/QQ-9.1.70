package com.tencent.luggage.wxa.zd;

import java.util.Collections;

/* compiled from: P */
/* loaded from: classes9.dex */
public enum r implements com.tencent.luggage.wxa.ca.i {
    INSTANCE;


    /* renamed from: a, reason: collision with root package name */
    public volatile Object f146559a = null;

    r() {
    }

    @Override // com.tencent.luggage.wxa.ca.i
    public boolean a(Object obj) {
        return false;
    }

    public final q b() {
        return new q();
    }

    @Override // com.tencent.luggage.wxa.ca.i
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public q get() {
        Object obj = this.f146559a;
        if (obj == null) {
            synchronized (this) {
                obj = this.f146559a;
                if (obj == null) {
                    obj = b();
                    this.f146559a = obj;
                }
            }
        }
        return (q) obj;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "provider " + q.class.getName();
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
