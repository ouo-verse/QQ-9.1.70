package cooperation.plugin.patch;

import java.util.zip.ZipEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0012\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u001b\u0010\n\u001a\u00020\u0007*\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"", "bytes", "Lcooperation/plugin/patch/b;", "b", "", "tempDirectory", "a", "Ljava/util/zip/ZipEntry;", "", "remove", "d", "(Ljava/util/zip/ZipEntry;Ljava/lang/Boolean;)Ljava/util/zip/ZipEntry;", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class j {
    @NotNull
    public static final b a(@NotNull String tempDirectory) {
        Intrinsics.checkNotNullParameter(tempDirectory, "tempDirectory");
        return new a(tempDirectory, null, 2, null);
    }

    @NotNull
    public static final b b(@Nullable byte[] bArr) {
        return new e(bArr);
    }

    public static /* synthetic */ b c(byte[] bArr, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bArr = null;
        }
        return b(bArr);
    }

    @NotNull
    public static final ZipEntry d(@NotNull ZipEntry zipEntry, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(zipEntry, "<this>");
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            zipEntry.setExtra(new byte[0]);
            zipEntry.setTime(0L);
        }
        return zipEntry;
    }
}
