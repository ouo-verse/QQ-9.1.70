package com.tencent.local_edit.andserver.http;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.local_edit.andserver.http.cookie.Cookie;
import com.tencent.local_edit.andserver.util.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.httpcore.Header;
import org.apache.httpcore.HttpEntity;
import org.apache.httpcore.HttpResponse;
import org.apache.httpcore.message.BasicHeader;

/* compiled from: P */
/* loaded from: classes7.dex */
public class k implements c {

    /* renamed from: b, reason: collision with root package name */
    private static final q11.a f119814b = new q11.b();

    /* renamed from: a, reason: collision with root package name */
    private HttpResponse f119815a;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private static class b implements HttpEntity {

        /* renamed from: d, reason: collision with root package name */
        private h f119816d;

        @Override // org.apache.httpcore.HttpEntity
        public InputStream getContent() throws IOException {
            return null;
        }

        @Override // org.apache.httpcore.HttpEntity
        public Header getContentEncoding() {
            return null;
        }

        @Override // org.apache.httpcore.HttpEntity
        public long getContentLength() {
            return this.f119816d.contentLength();
        }

        @Override // org.apache.httpcore.HttpEntity
        public Header getContentType() {
            MediaType contentType = this.f119816d.contentType();
            if (contentType == null) {
                return null;
            }
            return new BasicHeader("Content-Type", contentType.toString());
        }

        @Override // org.apache.httpcore.HttpEntity
        public boolean isChunked() {
            return this.f119816d.isChunked();
        }

        @Override // org.apache.httpcore.HttpEntity
        public boolean isRepeatable() {
            return this.f119816d.isRepeatable();
        }

        @Override // org.apache.httpcore.HttpEntity
        public boolean isStreaming() {
            return false;
        }

        @Override // org.apache.httpcore.HttpEntity
        public void writeTo(OutputStream outputStream) throws IOException {
            this.f119816d.writeTo(outputStream);
        }

        b(h hVar) {
            this.f119816d = hVar;
        }

        @Override // org.apache.httpcore.HttpEntity
        public void consumeContent() {
        }
    }

    public k(HttpResponse httpResponse) {
        this.f119815a = httpResponse;
    }

    @Override // com.tencent.local_edit.andserver.http.c
    public void a(@NonNull String str, long j3) {
        setHeader(str, com.tencent.local_edit.andserver.util.c.a(j3));
    }

    @Override // com.tencent.local_edit.andserver.http.c
    public void b(h hVar) {
        this.f119815a.setEntity(new b(hVar));
    }

    @Override // com.tencent.local_edit.andserver.http.c
    public void c(@NonNull Cookie cookie) {
        d("Set-Cookie", f119814b.a(cookie));
    }

    public void d(@NonNull String str, @NonNull String str2) {
        this.f119815a.addHeader(str, str2);
    }

    @Override // com.tencent.local_edit.andserver.http.c
    @Nullable
    public String getHeader(@NonNull String str) {
        Header firstHeader = this.f119815a.getFirstHeader(str);
        if (firstHeader == null) {
            return null;
        }
        return firstHeader.getValue();
    }

    @Override // com.tencent.local_edit.andserver.http.c
    public void setHeader(@NonNull String str, @NonNull String str2) {
        this.f119815a.setHeader(str, str2);
    }

    @Override // com.tencent.local_edit.andserver.http.c
    public void setStatus(int i3) {
        this.f119815a.setStatusCode(i3);
    }
}
