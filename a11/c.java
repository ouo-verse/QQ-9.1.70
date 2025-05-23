package a11;

import com.tencent.libra.util.apng.decode.APNGParser;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"La11/c;", "", "Lcom/tencent/libra/util/apng/decode/c;", "fctlChunk", "", "b", "", "apngPath", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f25347a = new c();

    c() {
    }

    private final long b(com.tencent.libra.util.apng.decode.c fctlChunk) {
        long roundToLong;
        short s16 = fctlChunk.f118827j;
        short s17 = fctlChunk.f118828k;
        if (s17 <= 0) {
            s17 = 100;
        }
        roundToLong = MathKt__MathJVMKt.roundToLong((s16 * 1000.0f) / s17);
        return roundToLong;
    }

    public final long a(@NotNull String apngPath) throws IOException {
        Intrinsics.checkNotNullParameter(apngPath, "apngPath");
        long j3 = 0;
        if (!FileUtils.fileExistsAndNotEmpty(apngPath)) {
            return 0L;
        }
        for (com.tencent.libra.util.apng.decode.b bVar : APNGParser.c(new h11.a(new u01.b(apngPath).obtain()))) {
            if (bVar instanceof com.tencent.libra.util.apng.decode.c) {
                j3 += b((com.tencent.libra.util.apng.decode.c) bVar);
            }
        }
        return j3;
    }
}
