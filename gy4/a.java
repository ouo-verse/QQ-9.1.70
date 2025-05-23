package gy4;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0007J\u001e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lgy4/a;", "", "", "b", "", "a", "", "value", "dest", "", "destOffset", "", "d", "", "c", "[C", "ENCODING", "[B", "DECODING", "<init>", "()V", "zplan-tracing_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final char[] ENCODING;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final byte[] DECODING;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f403894c;

    static {
        a aVar = new a();
        f403894c = aVar;
        ENCODING = aVar.b();
        DECODING = aVar.a();
    }

    a() {
    }

    private final byte[] a() {
        byte[] bArr = new byte[128];
        Arrays.fill(bArr, (byte) -1);
        for (int i3 = 0; i3 < 16; i3++) {
            bArr["0123456789abcdef".charAt(i3)] = (byte) i3;
        }
        return bArr;
    }

    private final char[] b() {
        char[] cArr = new char[512];
        for (int i3 = 0; i3 <= 255; i3++) {
            cArr[i3] = "0123456789abcdef".charAt(i3 >>> 4);
            cArr[i3 | 256] = "0123456789abcdef".charAt(i3 & 15);
        }
        return cArr;
    }

    @JvmStatic
    public static final void d(long value, @NotNull char[] dest, int destOffset) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        a aVar = f403894c;
        aVar.c((byte) ((value >> 56) & 255), dest, destOffset);
        aVar.c((byte) ((value >> 48) & 255), dest, destOffset + 2);
        aVar.c((byte) ((value >> 40) & 255), dest, destOffset + 4);
        aVar.c((byte) ((value >> 32) & 255), dest, destOffset + 6);
        aVar.c((byte) ((value >> 24) & 255), dest, destOffset + 8);
        aVar.c((byte) ((value >> 16) & 255), dest, destOffset + 10);
        aVar.c((byte) ((value >> 8) & 255), dest, destOffset + 12);
        aVar.c((byte) (value & 255), dest, destOffset + 14);
    }

    public final void c(byte value, @NotNull char[] dest, int destOffset) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        int i3 = value & 255;
        char[] cArr = ENCODING;
        dest[destOffset] = cArr[i3];
        dest[destOffset + 1] = cArr[i3 | 256];
    }
}
