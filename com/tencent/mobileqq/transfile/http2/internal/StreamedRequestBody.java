package com.tencent.mobileqq.transfile.http2.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Pipe;

/* compiled from: P */
/* loaded from: classes19.dex */
final class StreamedRequestBody extends OutputStreamRequestBody {
    static IPatchRedirector $redirector_;
    private final Pipe pipe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreamedRequestBody(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
            return;
        }
        Pipe pipe = new Pipe(8192L);
        this.pipe = pipe;
        initOutputStream(Okio.buffer(pipe.sink()), j3);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bufferedSink);
            return;
        }
        Buffer buffer = new Buffer();
        while (this.pipe.source().read(buffer, 8192L) != -1) {
            bufferedSink.write(buffer, buffer.size());
        }
    }
}
