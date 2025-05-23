package cooperation.plugin.patch;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\nR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcooperation/plugin/patch/e;", "Lcooperation/plugin/patch/b;", "Ljava/io/OutputStream;", "c", "Ljava/io/InputStream;", "d", "", "a", "", "b", "[B", "bytes", "Ljava/io/ByteArrayOutputStream;", "Ljava/io/ByteArrayOutputStream;", "stream", "<init>", "([B)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class e implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final byte[] bytes;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ByteArrayOutputStream stream = new ByteArrayOutputStream();

    public e(@Nullable byte[] bArr) {
        this.bytes = bArr;
    }

    @Override // cooperation.plugin.patch.b
    @NotNull
    public Object a() {
        return b();
    }

    @Override // cooperation.plugin.patch.b
    @NotNull
    public byte[] b() {
        byte[] bArr = this.bytes;
        if (bArr == null) {
            byte[] byteArray = this.stream.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "stream.toByteArray()");
            return byteArray;
        }
        return bArr;
    }

    @Override // cooperation.plugin.patch.b
    @NotNull
    public OutputStream c() {
        return this.stream;
    }

    @Override // cooperation.plugin.patch.b
    @NotNull
    public InputStream d() {
        byte[] bArr = this.bytes;
        if (bArr == null) {
            bArr = this.stream.toByteArray();
        }
        return new ByteArrayInputStream(bArr);
    }
}
