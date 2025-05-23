package com.tencent.qqnt.kernel.msf;

import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"", "", "extra", "a", "kernel_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    @Nullable
    public static final byte[] a(@NotNull byte[] bArr, @NotNull String extra) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(extra, "extra");
        byte[] bArr2 = new byte[0];
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        try {
            try {
                int readInt = dataInputStream.readInt() - 4;
                if (readInt > 52428800) {
                    QLog.d("KMsgServlet", 1, "pb size over size: " + readInt + ", extra: " + extra);
                }
                bArr2 = new byte[readInt];
                dataInputStream.read(bArr2);
                try {
                    byteArrayInputStream.close();
                    dataInputStream.close();
                } catch (IOException unused) {
                }
                return bArr2;
            } catch (IOException e16) {
                e16.printStackTrace();
                try {
                    byteArrayInputStream.close();
                    dataInputStream.close();
                } catch (IOException unused2) {
                }
                return bArr2;
            }
        } catch (Throwable th5) {
            try {
                byteArrayInputStream.close();
                dataInputStream.close();
            } catch (IOException unused3) {
            }
            throw th5;
        }
    }

    public static /* synthetic */ byte[] b(byte[] bArr, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        return a(bArr, str);
    }
}
