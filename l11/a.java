package l11;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.local_edit.andserver.http.h;
import com.tencent.local_edit.andserver.util.MediaType;
import com.tencent.local_edit.andserver.util.d;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a implements h {

    /* renamed from: a, reason: collision with root package name */
    private InputStream f413638a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f413639b;

    /* renamed from: c, reason: collision with root package name */
    private long f413640c;

    /* renamed from: d, reason: collision with root package name */
    private MediaType f413641d;

    public a(InputStream inputStream) {
        this(inputStream, MediaType.APPLICATION_OCTET_STREAM);
    }

    @Override // com.tencent.local_edit.andserver.http.h
    public long contentLength() {
        if (this.f413640c == 0) {
            InputStream inputStream = this.f413638a;
            if (inputStream instanceof FileInputStream) {
                try {
                    long size = ((FileInputStream) inputStream).getChannel().size();
                    this.f413640c = size;
                    return size;
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
        }
        return this.f413640c;
    }

    @Override // com.tencent.local_edit.andserver.http.h
    @Nullable
    public MediaType contentType() {
        return this.f413641d;
    }

    @Override // com.tencent.local_edit.andserver.http.h
    public boolean isChunked() {
        return this.f413639b;
    }

    @Override // com.tencent.local_edit.andserver.http.h
    public boolean isRepeatable() {
        return false;
    }

    @Override // com.tencent.local_edit.andserver.http.h
    public void writeTo(@NonNull OutputStream outputStream) throws IOException {
        d.i(this.f413638a, outputStream);
        d.a(this.f413638a);
    }

    public a(InputStream inputStream, MediaType mediaType) {
        this(inputStream, true, 0L, mediaType);
    }

    public a(InputStream inputStream, boolean z16, long j3, MediaType mediaType) {
        this.f413638a = inputStream;
        this.f413639b = z16;
        this.f413640c = j3;
        this.f413641d = mediaType;
    }
}
