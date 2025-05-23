package jl2;

import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Ljl2/a;", "", "", "absolutePath", "Ljava/nio/ByteBuffer;", "a", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f410583a = new a();

    a() {
    }

    @Nullable
    public final ByteBuffer a(@NotNull String absolutePath) {
        Intrinsics.checkNotNullParameter(absolutePath, "absolutePath");
        try {
            FileInputStream fileInputStream = new FileInputStream(absolutePath);
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                CloseableKt.closeFinally(fileInputStream, null);
                return wrap;
            } finally {
            }
        } catch (Exception e16) {
            QLog.w("QWallet.Pet.AssetUtils", 1, "readModel error: ", e16);
            return null;
        }
    }
}
