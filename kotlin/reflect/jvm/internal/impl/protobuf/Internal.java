package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes28.dex */
public class Internal {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final ByteBuffer EMPTY_BYTE_BUFFER;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface EnumLite {
        int getNumber();
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface EnumLiteMap<T extends EnumLite> {
        T findValueByNumber(int i3);
    }

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(bArr);
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return Utf8.isValidUtf8(bArr);
    }

    public static String toStringUtf8(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            throw new RuntimeException("UTF-8 not supported?", e16);
        }
    }
}
