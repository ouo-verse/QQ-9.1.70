package hynb.y;

import android.util.Base64;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jf.dexlib2.dexbacked.raw.HeaderItem;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static int f406916b;

    /* renamed from: a, reason: collision with root package name */
    public b f406917a = new b(10);

    public boolean a() {
        if (f406916b == 0) {
            ByteBuffer.allocate(4).putInt(HeaderItem.LITTLE_ENDIAN_TAG).array();
            if (ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN)) {
                f406916b = 1;
            } else {
                f406916b = 2;
            }
        }
        return f406916b != 1;
    }

    public final int b(int i3) {
        return !a() ? Integer.reverseBytes(i3) : i3;
    }

    public final long b(long j3) {
        return !a() ? Long.reverseBytes(j3) : j3;
    }

    public final short a(short s16) {
        return !a() ? Short.reverseBytes(s16) : s16;
    }

    public final a a(byte b16) {
        this.f406917a.a(b16);
        return this;
    }

    public final a a(byte[] bArr) {
        this.f406917a.a(bArr);
        return this;
    }

    public final a a(int i3) {
        this.f406917a.a(b(i3));
        return this;
    }

    public final a a(long j3) {
        this.f406917a.a(Long.valueOf(b(j3)));
        return this;
    }

    public final a a(String str) {
        this.f406917a.a(str);
        return this;
    }

    public String a(Long l3, String str, String str2, String str3, byte[] bArr, long j3) {
        Integer num = 3;
        a a16 = a((byte) 1).a(num.intValue()).a(l3.longValue()).a(Long.valueOf(j3).longValue()).a(str).a(str2).a(str3).a(bArr);
        Integer num2 = 0;
        a16.a(num2.intValue());
        short s16 = (short) (((short) this.f406917a.f406919b) + 2);
        b bVar = new b(s16 + 10);
        bVar.a(a(s16));
        bVar.a(this.f406917a.a());
        return Base64.encodeToString(bVar.a(), 2);
    }
}
