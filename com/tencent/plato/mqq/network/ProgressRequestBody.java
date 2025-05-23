package com.tencent.plato.mqq.network;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/* loaded from: classes22.dex */
public class ProgressRequestBody extends RequestBody {
    static IPatchRedirector $redirector_;
    private BufferedSink mBufferedSink;
    private final ProgressListener mProgressListener;
    private final RequestBody mRequestBody;

    public ProgressRequestBody(RequestBody requestBody, ProgressListener progressListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) requestBody, (Object) progressListener);
        } else {
            this.mRequestBody = requestBody;
            this.mProgressListener = progressListener;
        }
    }

    private Sink sink(Sink sink) {
        return new ForwardingSink(sink) { // from class: com.tencent.plato.mqq.network.ProgressRequestBody.1
            static IPatchRedirector $redirector_;
            long bytesWritten;
            long contentLength;

            {
                super(sink);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProgressRequestBody.this, (Object) sink);
                } else {
                    this.bytesWritten = 0L;
                    this.contentLength = 0L;
                }
            }

            @Override // okio.ForwardingSink, okio.Sink
            public void write(Buffer buffer, long j3) throws IOException {
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, buffer, Long.valueOf(j3));
                    return;
                }
                super.write(buffer, j3);
                if (this.contentLength == 0) {
                    this.contentLength = ProgressRequestBody.this.contentLength();
                }
                this.bytesWritten += j3;
                ProgressListener progressListener = ProgressRequestBody.this.mProgressListener;
                long j16 = this.bytesWritten;
                long j17 = this.contentLength;
                if (j16 == j17) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                progressListener.onProgress(j16, j17, z16);
            }
        };
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.mRequestBody.contentLength();
    }

    @Override // okhttp3.RequestBody
    /* renamed from: contentType */
    public MediaType getContentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MediaType) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mRequestBody.getContentType();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bufferedSink);
            return;
        }
        try {
            if (this.mBufferedSink == null) {
                this.mBufferedSink = Okio.buffer(sink(bufferedSink));
            }
            this.mRequestBody.writeTo(this.mBufferedSink);
            this.mBufferedSink.flush();
        } catch (IllegalStateException e16) {
            Log.e("ProgressRequestBody", "ProgressRequestBody exp:" + e16.getMessage());
        }
    }
}
