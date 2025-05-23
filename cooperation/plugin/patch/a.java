package cooperation.plugin.patch;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\r\u001a\u00020\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcooperation/plugin/patch/a;", "Lcooperation/plugin/patch/b;", "Ljava/io/OutputStream;", "c", "Ljava/io/InputStream;", "d", "", "a", "", "b", "", "Ljava/lang/String;", "path", "tempDirectory", "Ljava/io/File;", "file", "<init>", "(Ljava/lang/String;Ljava/io/File;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String path;

    public a(@NotNull String tempDirectory, @Nullable File file) {
        Intrinsics.checkNotNullParameter(tempDirectory, "tempDirectory");
        String absolutePath = file != null ? file.getAbsolutePath() : null;
        if (absolutePath == null) {
            absolutePath = new File(tempDirectory, UUID.randomUUID().toString()).getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "File(tempDirectory, UUID\u2026.toString()).absolutePath");
        }
        this.path = absolutePath;
    }

    @Override // cooperation.plugin.patch.b
    @NotNull
    public Object a() {
        return this.path;
    }

    @Override // cooperation.plugin.patch.b
    @NotNull
    public byte[] b() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        i.f390366a.c(d(), byteArrayOutputStream, true, true);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "ByteArrayOutputStream().\u2026   it.toByteArray()\n    }");
        return byteArray;
    }

    @Override // cooperation.plugin.patch.b
    @NotNull
    public OutputStream c() {
        return new FileOutputStream(this.path);
    }

    @Override // cooperation.plugin.patch.b
    @NotNull
    public InputStream d() {
        return new FileInputStream(this.path);
    }

    public /* synthetic */ a(String str, File file, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : file);
    }
}
