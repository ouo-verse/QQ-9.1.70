package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;

/* compiled from: P */
/* loaded from: classes23.dex */
public class JsError {

    /* renamed from: a, reason: collision with root package name */
    private final IX5JsError f368970a;

    /* JADX INFO: Access modifiers changed from: protected */
    public JsError(IX5JsError iX5JsError) {
        this.f368970a = iX5JsError;
    }

    public String getMessage() {
        return this.f368970a.getMessage();
    }

    public String getStack() {
        return this.f368970a.getStack();
    }
}
