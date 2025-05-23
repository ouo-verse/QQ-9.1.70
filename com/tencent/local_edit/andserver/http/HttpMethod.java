package com.tencent.local_edit.andserver.http;

import java.util.Locale;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;

/* compiled from: P */
/* loaded from: classes7.dex */
public enum HttpMethod {
    GET("GET"),
    HEAD("HEAD"),
    POST("POST"),
    PUT(HttpPut.METHOD_NAME),
    PATCH("PATCH"),
    DELETE("DELETE"),
    OPTIONS(HttpOptions.METHOD_NAME),
    TRACE("TRACE");

    private String value;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f119792a;

        static {
            int[] iArr = new int[HttpMethod.values().length];
            f119792a = iArr;
            try {
                iArr[HttpMethod.POST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f119792a[HttpMethod.PUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f119792a[HttpMethod.PATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f119792a[HttpMethod.DELETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    HttpMethod(String str) {
        this.value = str;
    }

    public static HttpMethod reverse(String str) {
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        upperCase.hashCode();
        char c16 = '\uffff';
        switch (upperCase.hashCode()) {
            case -531492226:
                if (upperCase.equals(HttpOptions.METHOD_NAME)) {
                    c16 = 0;
                    break;
                }
                break;
            case 70454:
                if (upperCase.equals("GET")) {
                    c16 = 1;
                    break;
                }
                break;
            case 79599:
                if (upperCase.equals(HttpPut.METHOD_NAME)) {
                    c16 = 2;
                    break;
                }
                break;
            case 2213344:
                if (upperCase.equals("HEAD")) {
                    c16 = 3;
                    break;
                }
                break;
            case 2461856:
                if (upperCase.equals("POST")) {
                    c16 = 4;
                    break;
                }
                break;
            case 75900968:
                if (upperCase.equals("PATCH")) {
                    c16 = 5;
                    break;
                }
                break;
            case 80083237:
                if (upperCase.equals("TRACE")) {
                    c16 = 6;
                    break;
                }
                break;
            case 2012838315:
                if (upperCase.equals("DELETE")) {
                    c16 = 7;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return OPTIONS;
            case 1:
                return GET;
            case 2:
                return PUT;
            case 3:
                return HEAD;
            case 4:
                return POST;
            case 5:
                return PATCH;
            case 6:
                return TRACE;
            case 7:
                return DELETE;
            default:
                throw new UnsupportedOperationException(String.format("The value %1$s is not supported.", upperCase));
        }
    }

    public boolean allowBody() {
        int i3 = a.f119792a[ordinal()];
        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public String value() {
        return this.value;
    }
}
