package mi3;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lmi3/a;", "", "", "path", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f416857a = new a();

    a() {
    }

    public final boolean a(String path) {
        if (path == null || path.length() == 0) {
            QLog.e("FileUtil", 1, "deleteFile fail with path:" + path);
            return false;
        }
        try {
            File file = new File(path);
            if (file.exists() && !file.isDirectory()) {
                return file.delete();
            }
        } catch (Exception e16) {
            QLog.e("FileUtil", 1, "deleteFile path=" + path + " exception", e16);
        }
        return false;
    }
}
