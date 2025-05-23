package okio;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import java.io.Closeable;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007\u00a2\u0006\u0002\b\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0001\u001a\n\u0010\u0003\u001a\u00020\u0005*\u00020\u0006\u001aA\u0010\u0007\u001a\u0002H\b\"\u0010\b\u0000\u0010\t*\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b\"\u0004\b\u0001\u0010\b*\u0002H\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\b0\rH\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u000f"}, d2 = {"blackholeSink", "Lokio/Sink;", "blackhole", "buffer", "Lokio/BufferedSink;", "Lokio/BufferedSource;", "Lokio/Source;", TransFileControllerImpl.VALUE_USE_PRE_CONN, BdhLogUtil.LogTag.Tag_Req, "T", "Ljava/io/Closeable;", "Lokio/Closeable;", "block", "Lkotlin/Function1;", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "okio"}, k = 5, mv = {1, 5, 1}, xi = 48, xs = "okio/Okio")
/* loaded from: classes29.dex */
public final /* synthetic */ class Okio__OkioKt {
    @JvmName(name = "blackhole")
    @NotNull
    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    @NotNull
    public static final BufferedSource buffer(@NotNull Source source) {
        Intrinsics.checkNotNullParameter(source, "<this>");
        return new buffer(source);
    }

    public static final <T extends Closeable, R> R use(T t16, @NotNull Function1<? super T, ? extends R> block) {
        R r16;
        Intrinsics.checkNotNullParameter(block, "block");
        Throwable th5 = null;
        try {
            r16 = block.invoke(t16);
        } catch (Throwable th6) {
            th5 = th6;
            r16 = null;
        }
        if (t16 != null) {
            try {
                t16.close();
            } catch (Throwable th7) {
                if (th5 != null) {
                    ExceptionsKt__ExceptionsKt.addSuppressed(th5, th7);
                } else {
                    th5 = th7;
                }
            }
        }
        if (th5 == null) {
            Intrinsics.checkNotNull(r16);
            return r16;
        }
        throw th5;
    }

    @NotNull
    public static final BufferedSink buffer(@NotNull Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "<this>");
        return new buffer(sink);
    }
}
