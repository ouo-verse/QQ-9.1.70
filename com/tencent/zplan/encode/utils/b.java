package com.tencent.zplan.encode.utils;

import android.text.TextUtils;
import java.io.File;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/zplan/encode/utils/b;", "", "", "path", "", "a", "fromPath", "toPath", "b", "<init>", "()V", "base_util_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f385478a = new b();

    b() {
    }

    public final boolean a(String path) {
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        File file = new File(path);
        if (file.exists()) {
            return file.delete();
        }
        return true;
    }

    public final boolean b(String fromPath, String toPath) {
        if (fromPath == null || toPath == null) {
            return false;
        }
        File file = new File(fromPath);
        if (file.exists()) {
            return file.renameTo(new File(toPath));
        }
        return false;
    }
}
