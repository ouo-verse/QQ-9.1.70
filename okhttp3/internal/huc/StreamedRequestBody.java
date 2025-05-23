package okhttp3.internal.huc;

import java.io.IOException;
import okhttp3.internal.http.UnrepeatableRequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Pipe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes19.dex */
public final class StreamedRequestBody extends OutputStreamRequestBody implements UnrepeatableRequestBody {
    private final Pipe pipe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreamedRequestBody(long j3) {
        Pipe pipe = new Pipe(8192L);
        this.pipe = pipe;
        initOutputStream(Okio.buffer(pipe.sink()), j3);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Buffer buffer = new Buffer();
        while (this.pipe.source().read(buffer, 8192L) != -1) {
            bufferedSink.write(buffer, buffer.size());
        }
    }
}
