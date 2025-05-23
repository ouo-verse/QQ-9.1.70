package com.tencent.rdelivery.reshub.net;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\"\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005\u001aH\u0010\u0013\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000026\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\nH\u0002\u00a8\u0006\u0014"}, d2 = {"Ljava/io/InputStream;", "Ljava/io/File;", "file", "", "totalSize", "Lcom/tencent/rdelivery/reshub/net/c;", "progressCallback", "", "b", "inputStream", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "length", "", "buffer", "", "onBufferRead", "a", "reshub-net_debug"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class FileUtilKt {
    private static final void a(InputStream inputStream, Function2<? super Integer, ? super byte[], Unit> function2) {
        byte[] bArr = new byte[16384];
        int read = inputStream.read(bArr);
        while (read != -1) {
            function2.invoke(Integer.valueOf(read), bArr);
            read = inputStream.read(bArr);
        }
    }

    public static final boolean b(@NotNull final InputStream saveToFile, @NotNull File file, final long j3, @NotNull final c progressCallback) {
        Intrinsics.checkParameterIsNotNull(saveToFile, "$this$saveToFile");
        Intrinsics.checkParameterIsNotNull(file, "file");
        Intrinsics.checkParameterIsNotNull(progressCallback, "progressCallback");
        try {
            final FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                final Ref.LongRef longRef = new Ref.LongRef();
                longRef.element = 0L;
                a(saveToFile, new Function2<Integer, byte[], Unit>() { // from class: com.tencent.rdelivery.reshub.net.FileUtilKt$saveToFile$$inlined$use$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, byte[] bArr) {
                        invoke(num.intValue(), bArr);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i3, @NotNull byte[] buffer) {
                        Intrinsics.checkParameterIsNotNull(buffer, "buffer");
                        fileOutputStream.write(buffer, 0, i3);
                        Ref.LongRef longRef2 = longRef;
                        long j16 = longRef2.element + i3;
                        longRef2.element = j16;
                        progressCallback.onProgress(j16, j3);
                    }
                });
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, null);
                return true;
            } finally {
            }
        } catch (IOException e16) {
            e16.printStackTrace();
            file.delete();
            return false;
        }
    }
}
