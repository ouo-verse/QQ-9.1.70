package l11;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.local_edit.andserver.http.h;
import com.tencent.local_edit.andserver.util.MediaType;
import com.tencent.local_edit.andserver.util.d;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import org.apache.commons.io.Charsets;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b implements h {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f413642a;

    /* renamed from: b, reason: collision with root package name */
    private MediaType f413643b;

    public b(String str) {
        this(str, MediaType.TEXT_PLAIN);
    }

    @Override // com.tencent.local_edit.andserver.http.h
    public long contentLength() {
        return this.f413642a.length;
    }

    @Override // com.tencent.local_edit.andserver.http.h
    @Nullable
    public MediaType contentType() {
        if (this.f413643b.getCharset() == null) {
            return new MediaType(this.f413643b.getType(), this.f413643b.getSubtype(), Charsets.toCharset("utf-8"));
        }
        return this.f413643b;
    }

    @Override // com.tencent.local_edit.andserver.http.h
    public boolean isChunked() {
        return false;
    }

    @Override // com.tencent.local_edit.andserver.http.h
    public boolean isRepeatable() {
        return true;
    }

    @Override // com.tencent.local_edit.andserver.http.h
    public void writeTo(@NonNull OutputStream outputStream) throws IOException {
        d.j(outputStream, this.f413642a);
    }

    public b(String str, MediaType mediaType) {
        if (str != null) {
            this.f413643b = mediaType;
            if (mediaType == null) {
                this.f413643b = new MediaType(MediaType.TEXT_PLAIN, Charsets.toCharset("utf-8"));
            }
            Charset charset = this.f413643b.getCharset();
            this.f413642a = str.getBytes(charset == null ? Charsets.toCharset("utf-8") : charset);
            return;
        }
        throw new IllegalArgumentException("The content cannot be null.");
    }
}
