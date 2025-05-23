package com.tencent.local_edit.andserver.http;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.apache.httpcore.protocol.HttpContext;

/* compiled from: P */
/* loaded from: classes7.dex */
public class i implements a {

    /* renamed from: a, reason: collision with root package name */
    private HttpContext f119798a;

    public i(HttpContext httpContext) {
        this.f119798a = httpContext;
    }

    @Override // com.tencent.local_edit.andserver.http.a
    @Nullable
    public Object getAttribute(@NonNull String str) {
        return this.f119798a.getAttribute(str);
    }

    @Override // com.tencent.local_edit.andserver.http.a
    public void setAttribute(@NonNull String str, @NonNull Object obj) {
        this.f119798a.setAttribute(str, obj);
    }
}
