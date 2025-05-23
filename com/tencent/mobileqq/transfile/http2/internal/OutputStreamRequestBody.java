package com.tencent.mobileqq.transfile.http2.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
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
    static IPatchRedirector $redirector_;
    boolean closed;
    private long expectedContentLength;
    private OutputStream outputStream;
    private Timeout timeout;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OutputStreamRequestBody() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.expectedContentLength;
    }

    @Override // okhttp3.RequestBody
    /* renamed from: contentType */
    public final MediaType getContentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MediaType) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initOutputStream(BufferedSink bufferedSink, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, bufferedSink, Long.valueOf(j3));
            return;
        }
        this.timeout = bufferedSink.getTimeout();
        this.expectedContentLength = j3;
        this.outputStream = new OutputStream(j3, bufferedSink) { // from class: com.tencent.mobileqq.transfile.http2.internal.OutputStreamRequestBody.1
            static IPatchRedirector $redirector_;
            private long bytesReceived;
            final /* synthetic */ long val$expectedContentLength;
            final /* synthetic */ BufferedSink val$sink;

            {
                this.val$expectedContentLength = j3;
                this.val$sink = bufferedSink;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, OutputStreamRequestBody.this, Long.valueOf(j3), bufferedSink);
                }
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this);
                    return;
                }
                OutputStreamRequestBody.this.closed = true;
                long j16 = this.val$expectedContentLength;
                if (j16 != -1 && this.bytesReceived < j16) {
                    throw new ProtocolException("expected " + this.val$expectedContentLength + " bytes but received " + this.bytesReceived);
                }
                this.val$sink.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this);
                } else {
                    if (OutputStreamRequestBody.this.closed) {
                        return;
                    }
                    this.val$sink.flush();
                }
            }

            @Override // java.io.OutputStream
            public void write(int i3) throws IOException {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    write(new byte[]{(byte) i3}, 0, 1);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i3, int i16) throws IOException {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16));
                    return;
                }
                if (!OutputStreamRequestBody.this.closed) {
                    long j16 = this.val$expectedContentLength;
                    if (j16 != -1 && this.bytesReceived + i16 > j16) {
                        throw new ProtocolException("expected " + this.val$expectedContentLength + " bytes but received " + this.bytesReceived + i16);
                    }
                    this.bytesReceived += i16;
                    try {
                        this.val$sink.write(bArr, i3, i16);
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.closed;
    }

    public final OutputStream outputStream() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (OutputStream) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.outputStream;
    }

    public Request prepareToSendRequest(Request request) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Request) iPatchRedirector.redirect((short) 8, (Object) this, (Object) request);
        }
        return request;
    }

    public final Timeout timeout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Timeout) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.timeout;
    }
}
