package com.tencent.local_edit.andserver.http;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.local_edit.andserver.util.MediaType;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class g implements b {

    /* renamed from: a, reason: collision with root package name */
    private b f119797a;

    public g(b bVar) {
        this.f119797a = bVar;
    }

    @Override // com.tencent.local_edit.andserver.http.b
    public long a(@NonNull String str) {
        return this.f119797a.a(str);
    }

    @Override // com.tencent.local_edit.andserver.http.b
    @Nullable
    public f b(@NonNull String str) {
        return this.f119797a.b(str);
    }

    @Override // com.tencent.local_edit.andserver.http.b
    @NonNull
    public List<MediaType> d() {
        return this.f119797a.d();
    }

    public b e() {
        return this.f119797a;
    }

    @Override // com.tencent.local_edit.andserver.http.a
    @Nullable
    public Object getAttribute(@NonNull String str) {
        return this.f119797a.getAttribute(str);
    }

    @Override // com.tencent.local_edit.andserver.http.b
    @Nullable
    public e getBody() throws UnsupportedOperationException {
        return this.f119797a.getBody();
    }

    @Override // com.tencent.local_edit.andserver.http.b
    @Nullable
    public MediaType getContentType() {
        return this.f119797a.getContentType();
    }

    @Override // com.tencent.local_edit.andserver.http.b
    @Nullable
    public String getHeader(@NonNull String str) {
        return this.f119797a.getHeader(str);
    }

    @Override // com.tencent.local_edit.andserver.http.b
    @NonNull
    public List<String> getHeaders(@NonNull String str) {
        return this.f119797a.getHeaders(str);
    }

    @Override // com.tencent.local_edit.andserver.http.b
    @NonNull
    public HttpMethod getMethod() {
        return this.f119797a.getMethod();
    }

    @Override // com.tencent.local_edit.andserver.http.b
    @Nullable
    public String getParameter(@NonNull String str) {
        return this.f119797a.getParameter(str);
    }

    @Override // com.tencent.local_edit.andserver.http.b
    @NonNull
    public String getPath() {
        return this.f119797a.getPath();
    }

    @Override // com.tencent.local_edit.andserver.http.b
    @NonNull
    public String getURI() {
        return this.f119797a.getURI();
    }

    @Override // com.tencent.local_edit.andserver.http.a
    public void setAttribute(@NonNull String str, @NonNull Object obj) {
        this.f119797a.setAttribute(str, obj);
    }
}
