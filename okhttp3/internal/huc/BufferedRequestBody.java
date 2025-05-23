package okhttp3.internal.huc;

import java.io.IOException;
import okhttp3.Request;
import okio.Buffer;
import okio.BufferedSink;

/* compiled from: P */
/* loaded from: classes19.dex */
final class BufferedRequestBody extends OutputStreamRequestBody {
    final Buffer buffer;
    long contentLength;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BufferedRequestBody(long j3) {
        Buffer buffer = new Buffer();
        this.buffer = buffer;
        this.contentLength = -1L;
        initOutputStream(buffer, j3);
    }

    @Override // okhttp3.internal.huc.OutputStreamRequestBody, okhttp3.RequestBody
    public long contentLength() throws IOException {
        return this.contentLength;
    }

    @Override // okhttp3.internal.huc.OutputStreamRequestBody
    public Request prepareToSendRequest(Request request) throws IOException {
        if (request.header("Content-Length") != null) {
            return request;
        }
        outputStream().close();
        this.contentLength = this.buffer.size();
        return request.newBuilder().removeHeader("Transfer-Encoding").header("Content-Length", Long.toString(this.buffer.size())).build();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        this.buffer.copyTo(bufferedSink.getBufferField(), 0L, this.buffer.size());
    }
}
