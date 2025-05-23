package cooperation.plugin.patch;

import com.tencent.commonsdk.zip.QZipInputStream;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ*\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fJ\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00102\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\f0\u0011J\u000e\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u0015J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001a\u001a\u00020\u0004\u00a8\u0006\u001e"}, d2 = {"Lcooperation/plugin/patch/i;", "", "Ljava/io/InputStream;", "inputStream", "Lcooperation/plugin/patch/b;", "IOBuffer", "", "b", "inputBuffer", "Ljava/io/OutputStream;", "outputStream", "a", "", "closeOutput", "closeInput", "c", "Lcom/tencent/commonsdk/zip/QZipInputStream;", "Lkotlin/Function1;", "Ljava/util/zip/ZipEntry;", "callback", "e", "", "path", "f", "", tl.h.F, "buffer", "g", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f390366a = new i();

    i() {
    }

    public static /* synthetic */ void d(i iVar, InputStream inputStream, OutputStream outputStream, boolean z16, boolean z17, int i3, Object obj) throws IOException {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        if ((i3 & 8) != 0) {
            z17 = false;
        }
        iVar.c(inputStream, outputStream, z16, z17);
    }

    public final void a(@NotNull b inputBuffer, @NotNull OutputStream outputStream) throws IOException {
        Intrinsics.checkNotNullParameter(inputBuffer, "inputBuffer");
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        c(inputBuffer.d(), outputStream, false, true);
    }

    public final void b(@NotNull InputStream inputStream, @NotNull b IOBuffer) throws IOException {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(IOBuffer, "IOBuffer");
        c(inputStream, IOBuffer.c(), true, false);
    }

    public final void c(@NotNull InputStream inputStream, @NotNull OutputStream outputStream, boolean closeOutput, boolean closeInput) throws IOException {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                break;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
        if (closeOutput) {
            outputStream.close();
        }
        if (closeInput) {
            inputStream.close();
        }
    }

    public final void e(@NotNull QZipInputStream inputStream, @NotNull Function1<? super ZipEntry, Boolean> callback) throws IOException {
        boolean z16;
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(callback, "callback");
        do {
            ZipEntry nextEntry = inputStream.getNextEntry();
            z16 = false;
            if (nextEntry != null && callback.invoke(nextEntry).booleanValue()) {
                z16 = true;
            }
        } while (z16);
    }

    public final boolean f(@NotNull String path) {
        int indexOf$default;
        Intrinsics.checkNotNullParameter(path, "path");
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) path, ".zip/", 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String g(@NotNull b buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        InputStream d16 = buffer.d();
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                byte[] bArr = new byte[4096];
                Ref.IntRef intRef = new Ref.IntRef();
                while (true) {
                    int read = d16.read(bArr);
                    intRef.element = read;
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                BigInteger bigInteger = new BigInteger(1, messageDigest.digest());
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%032x", Arrays.copyOf(new Object[]{bigInteger}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                try {
                    d16.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
                return format;
            } catch (IOException e17) {
                e17.printStackTrace();
                try {
                    d16.close();
                    return null;
                } catch (IOException e18) {
                    e18.printStackTrace();
                    return null;
                }
            }
        } catch (Throwable th5) {
            try {
                d16.close();
            } catch (IOException e19) {
                e19.printStackTrace();
            }
            throw th5;
        }
    }

    public final int h(@NotNull String path) {
        int indexOf$default;
        Intrinsics.checkNotNullParameter(path, "path");
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) path, ".zip/", 0, false, 6, (Object) null);
        return indexOf$default + 4;
    }
}
