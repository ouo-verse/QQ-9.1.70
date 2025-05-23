package com.tencent.local_edit.andserver.http.multipart;

import androidx.annotation.NonNull;
import com.tencent.local_edit.andserver.util.MediaType;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.fileupload.UploadContext;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a implements UploadContext {

    /* renamed from: a, reason: collision with root package name */
    private final com.tencent.local_edit.andserver.http.e f119829a;

    public a(@NonNull com.tencent.local_edit.andserver.http.e eVar) {
        this.f119829a = eVar;
    }

    @Override // org.apache.commons.fileupload.UploadContext
    public long contentLength() {
        return this.f119829a.length();
    }

    @Override // org.apache.commons.fileupload.RequestContext
    public String getCharacterEncoding() {
        return this.f119829a.b();
    }

    @Override // org.apache.commons.fileupload.RequestContext
    public int getContentLength() {
        long contentLength = contentLength();
        if (contentLength > TTL.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) contentLength;
    }

    @Override // org.apache.commons.fileupload.RequestContext
    public String getContentType() {
        MediaType contentType = this.f119829a.contentType();
        if (contentType == null) {
            return null;
        }
        return contentType.toString();
    }

    @Override // org.apache.commons.fileupload.RequestContext
    public InputStream getInputStream() throws IOException {
        return this.f119829a.stream();
    }

    public String toString() {
        return String.format("ContentLength=%s, Mime=%s", Long.valueOf(contentLength()), getContentType());
    }
}
