package p51;

import android.content.Context;
import java.io.File;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\r"}, d2 = {"Lp51/e;", "", "Landroid/content/Context;", "context", "Ljava/io/File;", "b", "", "version", "", "c", "a", "<init>", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f425350a = new e();

    e() {
    }

    private final File b(Context context) {
        File file = new File(context.getFilesDir(), "tencent/minibox/plugin");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "using_version");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    @Nullable
    public final String a(@NotNull Context context) {
        int i3;
        Object first;
        Intrinsics.checkParameterIsNotNull(context, "context");
        File b16 = b(context);
        if (!b16.exists() || !b16.isDirectory()) {
            return null;
        }
        File[] listFiles = b16.listFiles();
        if (listFiles != null) {
            i3 = listFiles.length;
        } else {
            i3 = 0;
        }
        if (i3 > 0 && listFiles != null) {
            first = ArraysKt___ArraysKt.first(listFiles);
            File file = (File) first;
            if (file == null) {
                return null;
            }
            return file.getName();
        }
        return null;
    }

    public final void c(@NotNull Context context, @NotNull String version) {
        int i3;
        Object first;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(version, "version");
        File b16 = b(context);
        if (!b16.exists()) {
            b16.mkdirs();
        }
        File[] listFiles = b16.listFiles();
        File file = new File(b16, version);
        if (listFiles != null) {
            i3 = listFiles.length;
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            if (listFiles != null) {
                first = ArraysKt___ArraysKt.first(listFiles);
                File file2 = (File) first;
                if (file2 != null) {
                    file2.renameTo(file);
                    return;
                }
                return;
            }
            return;
        }
        m51.a.c(file.getCanonicalPath());
    }
}
