package es2;

import com.tencent.mobileqq.pb.CodedOutputStreamMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0003\u001a\"\u0010\t\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u0006*\b\u0012\u0004\u0012\u00028\u00000\b\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/pb/PBBytesField;", "", "a", "Lcom/tencent/mobileqq/pb/PBUInt64Field;", "", "b", "Lcom/tencent/mobileqq/pb/MessageMicro;", "T", "Lcom/tencent/mobileqq/pb/PBRepeatMessageField;", "c", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    @Nullable
    public static final byte[] a(@NotNull PBBytesField pBBytesField) {
        Intrinsics.checkNotNullParameter(pBBytesField, "<this>");
        if (pBBytesField.has()) {
            return pBBytesField.get().toByteArray();
        }
        return null;
    }

    public static final long b(@NotNull PBUInt64Field pBUInt64Field) {
        Intrinsics.checkNotNullParameter(pBUInt64Field, "<this>");
        if (pBUInt64Field.has()) {
            return pBUInt64Field.get();
        }
        return 0L;
    }

    @Nullable
    public static final <T extends MessageMicro<T>> byte[] c(@NotNull PBRepeatMessageField<T> pBRepeatMessageField) {
        Intrinsics.checkNotNullParameter(pBRepeatMessageField, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(pBRepeatMessageField.computeSize(1));
        try {
            CodedOutputStreamMicro newInstance = CodedOutputStreamMicro.newInstance(byteArrayOutputStream);
            pBRepeatMessageField.writeTo(newInstance, 1);
            newInstance.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            return null;
        }
    }
}
