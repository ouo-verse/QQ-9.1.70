package com.tencent.luggage.wxa.qm;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum g implements com.tencent.luggage.wxa.ca.i {
    INSTANCE;


    /* renamed from: a, reason: collision with root package name */
    public volatile Object f138937a = null;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final List f138938a = Arrays.asList(com.tencent.luggage.wxa.z8.d.f146416d);
    }

    g() {
    }

    public final f b() {
        return new f();
    }

    @Override // com.tencent.luggage.wxa.ca.i
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public f get() {
        Object obj = this.f138937a;
        if (obj == null) {
            synchronized (this) {
                obj = this.f138937a;
                if (obj == null) {
                    obj = b();
                    this.f138937a = obj;
                }
            }
        }
        return (f) obj;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "provider " + f.class.getName();
    }

    @Override // com.tencent.luggage.wxa.ca.i
    public Object a(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case 1026760592:
                if (str.equals("onProcess")) {
                    c16 = 0;
                    break;
                }
                break;
            case 1028554796:
                if (str.equals("creator")) {
                    c16 = 1;
                    break;
                }
                break;
            case 1063801905:
                if (str.equals("accountAware")) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return a.f138938a;
            case 1:
                return Void.class;
            case 2:
                return Boolean.FALSE;
            default:
                return null;
        }
    }

    @Override // com.tencent.luggage.wxa.ca.i
    public boolean a(Object obj) {
        return Objects.equals(obj, com.tencent.luggage.wxa.p9.g.class);
    }
}
