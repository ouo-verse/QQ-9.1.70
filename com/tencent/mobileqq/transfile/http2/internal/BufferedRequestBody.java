package com.tencent.mobileqq.transfile.http2.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import okhttp3.Request;
import okio.Buffer;
import okio.BufferedSink;

/* compiled from: P */
/* loaded from: classes19.dex */
final class BufferedRequestBody extends OutputStreamRequestBody {
    static IPatchRedirector $redirector_;
    final Buffer buffer;
    long contentLength;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BufferedRequestBody(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
            return;
        }
        Buffer buffer = new Buffer();
        this.buffer = buffer;
        this.contentLength = -1L;
        initOutputStream(buffer, j3);
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.OutputStreamRequestBody, okhttp3.RequestBody
    public long contentLength() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.contentLength;
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.OutputStreamRequestBody
    public Request prepareToSendRequest(Request request) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Request) iPatchRedirector.redirect((short) 3, (Object) this, (Object) request);
        }
        if (request.header("Content-Length") != null) {
            return request;
        }
        outputStream().close();
        this.contentLength = this.buffer.size();
        return request.newBuilder().removeHeader("Transfer-Encoding").header("Content-Length", Long.toString(this.buffer.size())).build();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bufferedSink);
        } else {
            this.buffer.copyTo(bufferedSink.getBufferField(), 0L, this.buffer.size());
        }
    }
}
