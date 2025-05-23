package c45;

import c45.d;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import pbandk.internal.binary.kotlin.KotlinBinaryWireDecoder;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class i {
    public static final <T extends d> T a(d.a<T> aVar, byte[] bArr) {
        return aVar.b(new e45.c(new KotlinBinaryWireDecoder(new f45.a(bArr, bArr.length))));
    }

    public static final <T extends j> T b(T t16, byte[] bArr) {
        T t17 = (T) t16.decodeWith(new e45.c(new KotlinBinaryWireDecoder(new f45.a(bArr, bArr.length))));
        Intrinsics.checkNotNull(t17, "null cannot be cast to non-null type T of pbandk.MessageKt.decodeFromByteArray");
        return t17;
    }

    public static final <T extends l> String c(T t16) {
        String decodeToString;
        decodeToString = StringsKt__StringsJVMKt.decodeToString(d45.a.b(d(t16)));
        return decodeToString;
    }

    public static final <T extends e> byte[] d(T t16) {
        if (t16 instanceof l) {
            int protoSize = t16.getProtoSize();
            f45.c cVar = new f45.c(new f45.b(new byte[protoSize]), protoSize);
            ((l) t16).writeMessage(cVar);
            return cVar.d();
        }
        if (t16 instanceof d) {
            int protoSize2 = t16.getProtoSize();
            f45.c cVar2 = new f45.c(new f45.b(new byte[protoSize2]), protoSize2);
            cVar2.a((d) t16);
            return cVar2.d();
        }
        throw new Error("Unsupported interface");
    }
}
