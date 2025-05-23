package kotlin.io;

import java.io.File;
import java.nio.charset.Charset;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"kotlin/io/FilesKt__FilePathComponentsKt", "kotlin/io/FilesKt__FileReadWriteKt", "kotlin/io/FilesKt__FileTreeWalkKt", "kotlin/io/FilesKt__UtilsKt"}, k = 4, mv = {1, 7, 1}, xi = 49)
/* loaded from: classes28.dex */
public final class FilesKt extends FilesKt__UtilsKt {
    FilesKt() {
    }

    public static /* bridge */ /* synthetic */ File copyTo$default(File file, File file2, boolean z16, int i3, int i16, Object obj) {
        return FilesKt__UtilsKt.copyTo$default(file, file2, z16, i3, i16, obj);
    }

    public static /* bridge */ /* synthetic */ boolean deleteRecursively(@NotNull File file) {
        return FilesKt__UtilsKt.deleteRecursively(file);
    }

    public static /* bridge */ /* synthetic */ FileTreeWalk walk$default(File file, FileWalkDirection fileWalkDirection, int i3, Object obj) {
        return FilesKt__FileTreeWalkKt.walk$default(file, fileWalkDirection, i3, obj);
    }

    public static /* bridge */ /* synthetic */ void writeText$default(File file, String str, Charset charset, int i3, Object obj) {
        FilesKt__FileReadWriteKt.writeText$default(file, str, charset, i3, obj);
    }
}
