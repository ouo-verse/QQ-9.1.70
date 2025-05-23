package com.tencent.tmassistant.common.jce;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class ResponseHeadErrorCode implements Serializable {
    public static final int _EC_BUSINESS_ERROR = -11;
    public static final int _EC_SERVER_INTERNAL_ERROR = -10;

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f380378a = true;
    private String __T;
    private int __value;
    private static ResponseHeadErrorCode[] __values = new ResponseHeadErrorCode[2];
    public static final ResponseHeadErrorCode EC_SERVER_INTERNAL_ERROR = new ResponseHeadErrorCode(0, -10, "EC_SERVER_INTERNAL_ERROR");
    public static final ResponseHeadErrorCode EC_BUSINESS_ERROR = new ResponseHeadErrorCode(1, -11, "EC_BUSINESS_ERROR");

    ResponseHeadErrorCode(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static ResponseHeadErrorCode convert(int i3) {
        int i16 = 0;
        while (true) {
            ResponseHeadErrorCode[] responseHeadErrorCodeArr = __values;
            if (i16 < responseHeadErrorCodeArr.length) {
                if (responseHeadErrorCodeArr[i16].value() == i3) {
                    return __values[i16];
                }
                i16++;
            } else {
                if (f380378a) {
                    return null;
                }
                throw new AssertionError();
            }
        }
    }

    public String toString() {
        return this.__T;
    }

    public int value() {
        return this.__value;
    }

    public static ResponseHeadErrorCode convert(String str) {
        int i3 = 0;
        while (true) {
            ResponseHeadErrorCode[] responseHeadErrorCodeArr = __values;
            if (i3 < responseHeadErrorCodeArr.length) {
                if (responseHeadErrorCodeArr[i3].toString().equals(str)) {
                    return __values[i3];
                }
                i3++;
            } else {
                if (f380378a) {
                    return null;
                }
                throw new AssertionError();
            }
        }
    }
}
