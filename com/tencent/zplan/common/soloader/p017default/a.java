package com.tencent.zplan.common.soloader.p017default;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.zplan.common.soloader.b;
import com.tencent.zplan.common.soloader.d;
import com.tencent.zplan.common.utils.LogUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lx4.d;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0002\u0015\u0016B\u000f\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/zplan/common/soloader/default/a;", "Lcom/tencent/zplan/common/soloader/b;", "", "soNickname", "Ljava/io/File;", "d", "Lcom/tencent/zplan/common/soloader/a;", "load", "prepare", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", "getPriority", "()I", "priority", "<init>", "(Landroid/content/Context;)V", "e", "a", "b", "common_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class a implements b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/zplan/common/soloader/default/a$b;", "Lcom/tencent/zplan/common/soloader/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/io/File;", "a", "Ljava/io/File;", "getExternalSoFile", "()Ljava/io/File;", "externalSoFile", "b", "getSandboxSoFile", "sandboxSoFile", "<init>", "(Ljava/io/File;Ljava/io/File;)V", "common_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.common.soloader.default.a$b, reason: from toString */
    /* loaded from: classes27.dex */
    public static final /* data */ class DebugSoItem implements com.tencent.zplan.common.soloader.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final File externalSoFile;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final File sandboxSoFile;

        public DebugSoItem(@NotNull File externalSoFile, @Nullable File file) {
            Intrinsics.checkNotNullParameter(externalSoFile, "externalSoFile");
            this.externalSoFile = externalSoFile;
            this.sandboxSoFile = file;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof DebugSoItem) {
                    DebugSoItem debugSoItem = (DebugSoItem) other;
                    if (!Intrinsics.areEqual(this.externalSoFile, debugSoItem.externalSoFile) || !Intrinsics.areEqual(this.sandboxSoFile, debugSoItem.sandboxSoFile)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i3;
            File file = this.externalSoFile;
            int i16 = 0;
            if (file != null) {
                i3 = file.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = i3 * 31;
            File file2 = this.sandboxSoFile;
            if (file2 != null) {
                i16 = file2.hashCode();
            }
            return i17 + i16;
        }

        @NotNull
        public String toString() {
            return "DebugSoItem(externalSoFile=" + this.externalSoFile + ", sandboxSoFile=" + this.sandboxSoFile + ")";
        }

        public /* synthetic */ DebugSoItem(File file, File file2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(file, (i3 & 2) != 0 ? null : file2);
        }
    }

    public a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    private final File d(String soNickname) {
        String canonicalPath;
        File externalFilesDir = this.context.getExternalFilesDir("zp_libs");
        if (externalFilesDir != null && (canonicalPath = externalFilesDir.getCanonicalPath()) != null) {
            return new File(canonicalPath + "/lib" + soNickname + ".so");
        }
        return null;
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NotNull b other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return b.a.a(this, other);
    }

    @Override // com.tencent.zplan.common.soloader.b
    public int getPriority() {
        return 0;
    }

    @Override // com.tencent.zplan.common.soloader.b
    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    @Nullable
    public com.tencent.zplan.common.soloader.a load(@NotNull String soNickname) {
        Intrinsics.checkNotNullParameter(soNickname, "soNickname");
        d dVar = d.f385270a;
        StringBuilder sb5 = new StringBuilder();
        File filesDir = this.context.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "context.filesDir");
        sb5.append(filesDir.getPath());
        sb5.append("/zp_libs");
        File file = new File(dVar.b(new File(sb5.toString())).getPath() + "/lib" + soNickname + ".so");
        File d16 = d(soNickname);
        if (d16 != null) {
            try {
                if (d16.exists()) {
                    dVar.a(dVar.c(file));
                    FilesKt__UtilsKt.copyTo$default(d16, file, false, 0, 6, null);
                    dVar.a(d16);
                }
            } catch (Exception e16) {
                lx4.d a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    d.a.a(a16, "DebugSoLoader", 1, "try copy " + d16 + " failed, soNickName=" + soNickname + TokenParser.SP + e16, null, 8, null);
                }
            }
            try {
                if (!file.exists()) {
                    return null;
                }
                System.load(file.getCanonicalPath());
                return new DebugSoItem(d16, file);
            } catch (Throwable th5) {
                lx4.d a17 = LogUtil.f385285b.a();
                if (a17 != null) {
                    d.a.a(a17, "DebugSoLoader", 1, "try load " + d16 + " failed, soNickName=" + soNickname + TokenParser.SP + th5, null, 8, null);
                }
            }
        }
        return null;
    }

    @Override // com.tencent.zplan.common.soloader.b
    @Nullable
    public com.tencent.zplan.common.soloader.a prepare(@NotNull String soNickname) {
        Intrinsics.checkNotNullParameter(soNickname, "soNickname");
        File d16 = d(soNickname);
        File file = null;
        byte b16 = 0;
        if (d16 == null || !d16.exists()) {
            return null;
        }
        return new DebugSoItem(d16, file, 2, b16 == true ? 1 : 0);
    }
}
