package di3;

import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\r"}, d2 = {"Ldi3/b;", "", "", "path", "", "b", "subFileDirName", "Ljava/io/File;", "c", "dirPath", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f393984a = new b();

    b() {
    }

    private final void b(String path) {
        FileUtils.createFileIfNotExits(path + "/.nomedia");
    }

    public final File c(String subFileDirName) {
        Intrinsics.checkNotNullParameter(subFileDirName, "subFileDirName");
        File file = new File(a.f393982a.a(), subFileDirName);
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "dir.absolutePath");
        b(absolutePath);
        return file;
    }

    public final void a(String dirPath) {
        File[] listFiles;
        if (dirPath == null || dirPath.length() == 0) {
            return;
        }
        File file = new File(dirPath);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            if (listFiles.length == 0) {
                return;
            }
            for (File file2 : listFiles) {
                if (file2.exists() && file2.isDirectory()) {
                    f393984a.a(file2.getAbsolutePath());
                    file2.delete();
                } else {
                    file2.delete();
                }
            }
        }
    }
}
