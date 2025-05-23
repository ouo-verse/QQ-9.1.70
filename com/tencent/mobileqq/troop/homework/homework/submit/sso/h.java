package com.tencent.mobileqq.troop.homework.homework.submit.sso;

import com.google.protobuf.CodedOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/h;", "", "Lcom/google/protobuf/CodedOutputStream;", "output", "", "writeTo", "", "getSerializedSize", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface h {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class a {
        @NotNull
        public static byte[] a(@NotNull h hVar) {
            try {
                byte[] bArr = new byte[hVar.getSerializedSize()];
                CodedOutputStream output = CodedOutputStream.i0(bArr);
                Intrinsics.checkNotNullExpressionValue(output, "output");
                hVar.writeTo(output);
                output.d();
                return bArr;
            } catch (IOException e16) {
                throw new RuntimeException("error occurs when serialize message(should never happened): " + e16.getMessage());
            }
        }
    }

    int getSerializedSize();

    void writeTo(@NotNull CodedOutputStream output);
}
