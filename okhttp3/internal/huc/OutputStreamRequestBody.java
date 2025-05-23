package okhttp3.internal.huc;

import com.tencent.mobileqq.tritonaudio.webaudio.AudioContext;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Timeout;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class OutputStreamRequestBody extends RequestBody {
    boolean closed;
    private long expectedContentLength;
    private OutputStream outputStream;
    private Timeout timeout;

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        return this.expectedContentLength;
    }

    @Override // okhttp3.RequestBody
    /* renamed from: contentType */
    public final MediaType getContentType() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initOutputStream(final BufferedSink bufferedSink, final long j3) {
        this.timeout = bufferedSink.getTimeout();
        this.expectedContentLength = j3;
        this.outputStream = new OutputStream() { // from class: okhttp3.internal.huc.OutputStreamRequestBody.1
            private long bytesReceived;

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                OutputStreamRequestBody.this.closed = true;
                long j16 = j3;
                if (j16 != -1 && this.bytesReceived < j16) {
                    throw new ProtocolException("expected " + j3 + " bytes but received " + this.bytesReceived);
                }
                bufferedSink.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                if (OutputStreamRequestBody.this.closed) {
                    return;
                }
                bufferedSink.flush();
            }

            @Override // java.io.OutputStream
            public void write(int i3) throws IOException {
                write(new byte[]{(byte) i3}, 0, 1);
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i3, int i16) throws IOException {
                if (!OutputStreamRequestBody.this.closed) {
                    long j16 = j3;
                    if (j16 != -1 && this.bytesReceived + i16 > j16) {
                        throw new ProtocolException("expected " + j3 + " bytes but received " + this.bytesReceived + i16);
                    }
                    this.bytesReceived += i16;
                    try {
                        bufferedSink.write(bArr, i3, i16);
                        return;
                    } catch (InterruptedIOException e16) {
                        throw new SocketTimeoutException(e16.getMessage());
                    }
                }
                throw new IOException(AudioContext.State.CLOSED);
            }
        };
    }

    public final boolean isClosed() {
        return this.closed;
    }

    public final OutputStream outputStream() {
        return this.outputStream;
    }

    public final Timeout timeout() {
        return this.timeout;
    }

    public Request prepareToSendRequest(Request request) throws IOException {
        return request;
    }
}
