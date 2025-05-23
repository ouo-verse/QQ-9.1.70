package com.tencent.component.network.module.common;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/* loaded from: classes5.dex */
public class ProgressResponseBody extends ResponseBody {
    private BufferedSource bufferedSource;
    private final ProgressListener progressListener;
    private final ResponseBody responseBody;

    /* loaded from: classes5.dex */
    public interface ProgressListener {
        void update(long j3, long j16, boolean z16);
    }

    public ProgressResponseBody(ResponseBody responseBody, ProgressListener progressListener) {
        this.responseBody = responseBody;
        this.progressListener = progressListener;
    }

    @Override // okhttp3.ResponseBody
    /* renamed from: contentLength */
    public long getContentLength() {
        return this.responseBody.getContentLength();
    }

    @Override // okhttp3.ResponseBody
    /* renamed from: contentType */
    public MediaType get$contentType() {
        return this.responseBody.get$contentType();
    }

    @Override // okhttp3.ResponseBody
    /* renamed from: source */
    public BufferedSource getBodySource() {
        if (this.bufferedSource == null) {
            this.bufferedSource = Okio.buffer(source(this.responseBody.getBodySource()));
        }
        return this.bufferedSource;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.tencent.component.network.module.common.ProgressResponseBody.1
            long totalBytesRead = 0;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j3) throws IOException {
                long j16;
                boolean z16;
                long read = super.read(buffer, j3);
                long j17 = this.totalBytesRead;
                if (read != -1) {
                    j16 = read;
                } else {
                    j16 = 0;
                }
                this.totalBytesRead = j17 + j16;
                if (ProgressResponseBody.this.progressListener != null) {
                    ProgressListener progressListener = ProgressResponseBody.this.progressListener;
                    long j18 = this.totalBytesRead;
                    long contentLength = ProgressResponseBody.this.responseBody.getContentLength();
                    if (read == -1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    progressListener.update(j18, contentLength, z16);
                }
                return read;
            }
        };
    }
}
