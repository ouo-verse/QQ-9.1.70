package com.tencent.mobileqq.tvideo.net.utils;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/tvideo/net/utils/a;", "", "", "data", "a", "Ljava/util/concurrent/atomic/AtomicInteger;", "b", "Ljava/util/concurrent/atomic/AtomicInteger;", "autoIncrementNum", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f304498a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicInteger autoIncrementNum = new AtomicInteger(0);

    a() {
    }

    @Nullable
    public final byte[] a(@Nullable byte[] data) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        byte[] bArr = null;
        try {
            try {
                bArr = new byte[dataInputStream.readInt() - 4];
                dataInputStream.read(bArr);
                try {
                    byteArrayInputStream.close();
                    dataInputStream.close();
                } catch (Exception unused) {
                }
                return bArr;
            } catch (Throwable th5) {
                try {
                    byteArrayInputStream.close();
                    dataInputStream.close();
                } catch (Exception unused2) {
                }
                throw th5;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            try {
                byteArrayInputStream.close();
                dataInputStream.close();
            } catch (Exception unused3) {
            }
            return bArr;
        }
    }
}
