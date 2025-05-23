package com.tencent.mobileqq.nearbypro.request;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.pb.ByteStringMicro;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jf.dexlib2.analysis.RegisterType;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u0003\u001a\u001b\u0010\u000b\u001a\u00020\u0003\"\b\b\u0000\u0010\n*\u00020\t*\u00028\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\r\u001a\u00020\u0007\"\b\b\u0000\u0010\n*\u00020\t*\u00028\u0000\u00a2\u0006\u0004\b\r\u0010\u000e\u001a%\u0010\u0010\u001a\u00028\u0000\"\b\b\u0000\u0010\n*\u00020\t*\u00028\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"", "command", "serviceType", "", "bodyBytes", "Ltencent/im/oidb/oidb_sso$OIDBSSOPkg;", "a", "", "e", "Lcom/google/protobuf/nano/MessageNano;", "T", "c", "(Lcom/google/protobuf/nano/MessageNano;)[B", "d", "(Lcom/google/protobuf/nano/MessageNano;)Ljava/lang/String;", "data", "b", "(Lcom/google/protobuf/nano/MessageNano;[B)Lcom/google/protobuf/nano/MessageNano;", "qq_nearby_pro_base_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c {
    @NotNull
    public static final oidb_sso$OIDBSSOPkg a(int i3, int i16, @Nullable byte[] bArr) {
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(i3);
        oidb_sso_oidbssopkg.uint32_service_type.set(i16);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.str_client_version.set(j.a().getVersion());
        if (bArr != null) {
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(bArr));
        }
        return oidb_sso_oidbssopkg;
    }

    @NotNull
    public static final <T extends MessageNano> T b(@NotNull T t16, @Nullable byte[] bArr) throws InvalidProtocolBufferNanoException {
        Intrinsics.checkNotNullParameter(t16, "<this>");
        if (bArr != null) {
            MessageNano.mergeFrom(t16, bArr);
        }
        return t16;
    }

    @NotNull
    public static final <T extends MessageNano> byte[] c(@NotNull T t16) {
        Intrinsics.checkNotNullParameter(t16, "<this>");
        byte[] byteArray = MessageNano.toByteArray(t16);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(this)");
        return byteArray;
    }

    @NotNull
    public static final <T extends MessageNano> String d(@NotNull T t16) {
        Intrinsics.checkNotNullParameter(t16, "<this>");
        return e(c(t16));
    }

    @NotNull
    public static final String e(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        StringBuilder sb5 = new StringBuilder(bArr.length * 2);
        for (byte b16 : bArr) {
            sb5.append("0123456789abcdef".charAt((b16 >> 4) & 15));
            sb5.append("0123456789abcdef".charAt(b16 & RegisterType.DOUBLE_HI));
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "result.toString()");
        return sb6;
    }
}
