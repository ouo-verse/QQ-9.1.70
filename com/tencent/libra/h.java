package com.tencent.libra;

import com.tencent.libra.base.model.Model;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J \u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/libra/h;", "", "Lcom/tencent/libra/base/model/Model;", "model", "Ljava/io/File;", "srcFile", "Ljava/io/InputStream;", "a", "Lu01/c;", "b", "<init>", "()V", "libra-extension-base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f118788a = new h();

    h() {
    }

    @Nullable
    public final InputStream a(@Nullable Model<?> model, @Nullable File srcFile) {
        if (model != null) {
            return model.c();
        }
        if (srcFile != null) {
            return new FileInputStream(srcFile);
        }
        return null;
    }

    @Nullable
    public final u01.c b(@Nullable Model<?> model, @Nullable File srcFile) {
        if (model != null) {
            return model.e();
        }
        if (srcFile != null) {
            return new u01.b(srcFile);
        }
        return null;
    }
}
