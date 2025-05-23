package com.tencent.luggage.wxa.tn;

import java.util.Collections;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum j0 implements com.tencent.luggage.wxa.ca.i {
    INSTANCE;


    /* renamed from: a, reason: collision with root package name */
    public volatile Object f141627a = null;

    j0() {
    }

    public final i0 b() {
        return new i0();
    }

    @Override // com.tencent.luggage.wxa.ca.i
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i0 get() {
        Object obj = this.f141627a;
        if (obj == null) {
            synchronized (this) {
                obj = this.f141627a;
                if (obj == null) {
                    obj = b();
                    this.f141627a = obj;
                }
            }
        }
        return (i0) obj;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "provider " + i0.class.getName();
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

    @Override // com.tencent.luggage.wxa.ca.i
    public boolean a(Object obj) {
        return Objects.equals(obj, com.tencent.luggage.wxa.fo.a.ASYNC);
    }
}
