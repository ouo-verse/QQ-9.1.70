package com.tencent.local_edit.annotation;

import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;

/* compiled from: P */
/* loaded from: classes7.dex */
public enum RequestMethod {
    GET("GET"),
    HEAD("HEAD"),
    POST("POST"),
    PUT(HttpPut.METHOD_NAME),
    PATCH("PATCH"),
    DELETE("DELETE"),
    OPTIONS(HttpOptions.METHOD_NAME),
    TRACE("TRACE");

    private String value;

    RequestMethod(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public String value() {
        return this.value;
    }
}
