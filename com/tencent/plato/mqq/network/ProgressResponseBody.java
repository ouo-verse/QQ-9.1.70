package com.tencent.plato.mqq.network;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/* loaded from: classes22.dex */
public class ProgressResponseBody extends ResponseBody {
    static IPatchRedirector $redirector_;

    @Nullable
    private BufferedSource mBufferedSource;
    private final ProgressListener mProgressListener;
    private final ResponseBody mResponseBody;
    private long mTotalBytesRead;

    public ProgressResponseBody(ResponseBody responseBody, ProgressListener progressListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) responseBody, (Object) progressListener);
            return;
        }
        this.mResponseBody = responseBody;
        this.mProgressListener = progressListener;
        this.mTotalBytesRead = 0L;
    }

    @Override // okhttp3.ResponseBody
    /* renamed from: contentLength */
    public long getContentLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        try {
            return this.mResponseBody.getContentLength();
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    @Override // okhttp3.ResponseBody
    /* renamed from: contentType */
    public MediaType get$contentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MediaType) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mResponseBody.get$contentType();
    }

    @Override // okhttp3.ResponseBody
    /* renamed from: source */
    public BufferedSource getSource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (BufferedSource) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.mBufferedSource == null) {
            try {
                this.mBufferedSource = Okio.buffer(source(this.mResponseBody.getSource()));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return this.mBufferedSource;
    }

    public long totalBytesRead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.mTotalBytesRead;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.tencent.plato.mqq.network.ProgressResponseBody.1
            static IPatchRedirector $redirector_;

            {
                super(source);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProgressResponseBody.this, (Object) source);
                }
            }

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j3) throws IOException {
                long j16;
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Long) iPatchRedirector.redirect((short) 2, this, buffer, Long.valueOf(j3))).longValue();
                }
                long read = super.read(buffer, j3);
                ProgressResponseBody progressResponseBody = ProgressResponseBody.this;
                long j17 = progressResponseBody.mTotalBytesRead;
                if (read != -1) {
                    j16 = read;
                } else {
                    j16 = 0;
                }
                progressResponseBody.mTotalBytesRead = j17 + j16;
                ProgressListener progressListener = ProgressResponseBody.this.mProgressListener;
                long j18 = ProgressResponseBody.this.mTotalBytesRead;
                long contentLength = ProgressResponseBody.this.mResponseBody.getContentLength();
                if (read == -1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                progressListener.onProgress(j18, contentLength, z16);
                return read;
            }
        };
    }
}
