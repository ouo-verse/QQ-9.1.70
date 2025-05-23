package com.tencent.sqshow.zootopia.utils;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/af;", "", "Landroid/content/Context;", "context", "", "assertName", "a", "Ljava/io/Closeable;", "stream", "", "b", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class af {

    /* renamed from: a, reason: collision with root package name */
    public static final af f373257a = new af();

    af() {
    }

    public final String a(Context context, String assertName) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(assertName, "assertName");
        String str = context.getCacheDir().getAbsolutePath() + File.separator + assertName;
        try {
            File file = new File(str);
            inputStream = context.getAssets().open(assertName);
            try {
                if (file.length() == inputStream.available()) {
                    b(inputStream);
                    b(null);
                    return str;
                }
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    for (int read = inputStream.read(bArr); read > 0; read = inputStream.read(bArr)) {
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    b(inputStream);
                    b(fileOutputStream);
                    return str;
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        QLog.e("zootopiaFileUtils", 1, "copyAssetFileToStorageIfNeed, error, ", th);
                        if (!(inputStream instanceof Closeable)) {
                            inputStream = null;
                        }
                        b(inputStream);
                        if (!(fileOutputStream instanceof Closeable)) {
                            fileOutputStream = null;
                        }
                        b(fileOutputStream);
                        return null;
                    } catch (Throwable th6) {
                        if (!(inputStream instanceof Closeable)) {
                            inputStream = null;
                        }
                        b(inputStream);
                        b(fileOutputStream instanceof Closeable ? fileOutputStream : null);
                        throw th6;
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                fileOutputStream = null;
            }
        } catch (Throwable th8) {
            th = th8;
            inputStream = null;
            fileOutputStream = null;
        }
    }

    public final void b(Closeable stream) {
        if (stream == null) {
            return;
        }
        try {
            stream.close();
        } catch (Throwable th5) {
            QLog.e("zootopiaFileUtils", 1, "safelyCloseStream, error, ", th5);
        }
    }
}
