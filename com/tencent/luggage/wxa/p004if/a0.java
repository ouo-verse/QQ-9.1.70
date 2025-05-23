package com.tencent.luggage.wxa.p004if;

import com.tencent.luggage.wxa.ca.i;
import java.util.Collections;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum a0 implements i {
    INSTANCE;


    /* renamed from: a, reason: collision with root package name */
    public volatile Object f130168a = null;

    a0() {
    }

    @Override // com.tencent.luggage.wxa.ca.i
    public boolean a(Object obj) {
        return false;
    }

    public final z b() {
        return new z();
    }

    @Override // com.tencent.luggage.wxa.ca.i
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public z get() {
        Object obj = this.f130168a;
        if (obj == null) {
            synchronized (this) {
                obj = this.f130168a;
                if (obj == null) {
                    obj = b();
                    this.f130168a = obj;
                }
            }
        }
        return (z) obj;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "provider " + z.class.getName();
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
