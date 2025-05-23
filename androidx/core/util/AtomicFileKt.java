package androidx.core.util;

import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\u0016\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u001a3\u0010\u0007\u001a\u00020\b*\u00020\u00022!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\nH\u0087\b\u00f8\u0001\u0000\u001a\u0014\u0010\u000f\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\u0007\u001a\u001e\u0010\u0011\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0013"}, d2 = {"readBytes", "", "Landroid/util/AtomicFile;", "readText", "", HttpMsg.CHARSET, "Ljava/nio/charset/Charset;", "tryWrite", "", "block", "Lkotlin/Function1;", "Ljava/io/FileOutputStream;", "Lkotlin/ParameterName;", "name", "out", "writeBytes", HippyControllerProps.ARRAY, "writeText", "text", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class AtomicFileKt {
    @RequiresApi(17)
    @NotNull
    public static final byte[] readBytes(@NotNull android.util.AtomicFile readBytes) {
        Intrinsics.checkNotNullParameter(readBytes, "$this$readBytes");
        byte[] readFully = readBytes.readFully();
        Intrinsics.checkNotNullExpressionValue(readFully, "readFully()");
        return readFully;
    }

    @RequiresApi(17)
    @NotNull
    public static final String readText(@NotNull android.util.AtomicFile readText, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(readText, "$this$readText");
        Intrinsics.checkNotNullParameter(charset, "charset");
        byte[] readFully = readText.readFully();
        Intrinsics.checkNotNullExpressionValue(readFully, "readFully()");
        return new String(readFully, charset);
    }

    public static /* synthetic */ String readText$default(android.util.AtomicFile atomicFile, Charset charset, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return readText(atomicFile, charset);
    }

    @RequiresApi(17)
    public static final void tryWrite(@NotNull android.util.AtomicFile tryWrite, @NotNull Function1<? super FileOutputStream, Unit> block) {
        Intrinsics.checkNotNullParameter(tryWrite, "$this$tryWrite");
        Intrinsics.checkNotNullParameter(block, "block");
        FileOutputStream stream = tryWrite.startWrite();
        try {
            Intrinsics.checkNotNullExpressionValue(stream, "stream");
            block.invoke(stream);
            InlineMarker.finallyStart(1);
            tryWrite.finishWrite(stream);
            InlineMarker.finallyEnd(1);
        } catch (Throwable th5) {
            InlineMarker.finallyStart(1);
            tryWrite.failWrite(stream);
            InlineMarker.finallyEnd(1);
            throw th5;
        }
    }

    @RequiresApi(17)
    public static final void writeBytes(@NotNull android.util.AtomicFile writeBytes, @NotNull byte[] array) {
        Intrinsics.checkNotNullParameter(writeBytes, "$this$writeBytes");
        Intrinsics.checkNotNullParameter(array, "array");
        FileOutputStream stream = writeBytes.startWrite();
        try {
            Intrinsics.checkNotNullExpressionValue(stream, "stream");
            stream.write(array);
            writeBytes.finishWrite(stream);
        } catch (Throwable th5) {
            writeBytes.failWrite(stream);
            throw th5;
        }
    }

    @RequiresApi(17)
    public static final void writeText(@NotNull android.util.AtomicFile writeText, @NotNull String text, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(writeText, "$this$writeText");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        byte[] bytes = text.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        writeBytes(writeText, bytes);
    }

    public static /* synthetic */ void writeText$default(android.util.AtomicFile atomicFile, String str, Charset charset, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        writeText(atomicFile, str, charset);
    }
}
