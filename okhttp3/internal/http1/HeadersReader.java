package okhttp3.internal.http1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lokhttp3/internal/http1/HeadersReader;", "", "source", "Lokio/BufferedSource;", "(Lokio/BufferedSource;)V", "headerLimit", "", "getSource", "()Lokio/BufferedSource;", "readHeaders", "Lokhttp3/Headers;", "readLine", "", "Companion", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes28.dex */
public final class HeadersReader {
    private static final int HEADER_LIMIT = 262144;
    private long headerLimit;

    @NotNull
    private final BufferedSource source;

    public HeadersReader(@NotNull BufferedSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.headerLimit = 262144;
    }

    @NotNull
    public final BufferedSource getSource() {
        return this.source;
    }

    @NotNull
    public final Headers readHeaders() {
        boolean z16;
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String readLine = readLine();
            if (readLine.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return builder.build();
            }
            builder.addLenient$okhttp(readLine);
        }
    }

    @NotNull
    public final String readLine() {
        String readUtf8LineStrict = this.source.readUtf8LineStrict(this.headerLimit);
        this.headerLimit -= readUtf8LineStrict.length();
        return readUtf8LineStrict;
    }
}
