package kotlin.experimental;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0004\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\u0000\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\f\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0003*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\u0005\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\f\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\f\u00a8\u0006\u0007"}, d2 = {"and", "", "other", "", "inv", "or", "xor", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class BitwiseOperationsKt {
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte and(byte b16, byte b17) {
        return (byte) (b16 & b17);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte inv(byte b16) {
        return (byte) (~b16);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte or(byte b16, byte b17) {
        return (byte) (b16 | b17);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte xor(byte b16, byte b17) {
        return (byte) (b16 ^ b17);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short and(short s16, short s17) {
        return (short) (s16 & s17);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short inv(short s16) {
        return (short) (~s16);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short or(short s16, short s17) {
        return (short) (s16 | s17);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short xor(short s16, short s17) {
        return (short) (s16 ^ s17);
    }
}
