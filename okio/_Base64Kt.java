package okio;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u000e\u0010\t\u001a\u0004\u0018\u00010\u0001*\u00020\nH\u0000\u001a\u0016\u0010\u000b\u001a\u00020\n*\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u0001H\u0000\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005\u00a8\u0006\r"}, d2 = {"BASE64", "", "getBASE64$annotations", "()V", "getBASE64", "()[B", "BASE64_URL_SAFE", "getBASE64_URL_SAFE$annotations", "getBASE64_URL_SAFE", "decodeBase64ToArray", "", "encodeBase64", "map", "okio"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes29.dex */
public final class _Base64Kt {

    @NotNull
    private static final byte[] BASE64;

    @NotNull
    private static final byte[] BASE64_URL_SAFE;

    static {
        ByteString.Companion companion = ByteString.Companion;
        BASE64 = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        BASE64_URL_SAFE = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00b8 A[LOOP:1: B:14:0x003e->B:25:0x00b8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b4 A[SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final byte[] decodeBase64ToArray(@NotNull String str) {
        int i3;
        int i16;
        int i17;
        boolean z16;
        boolean z17;
        boolean z18;
        int i18;
        char charAt;
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        while (length > 0 && ((charAt = str.charAt(length - 1)) == '=' || charAt == '\n' || charAt == '\r' || charAt == ' ' || charAt == '\t')) {
            length--;
        }
        int i19 = (int) ((length * 6) / 8);
        byte[] bArr = new byte[i19];
        if (length > 0) {
            int i26 = 0;
            i16 = 0;
            int i27 = 0;
            int i28 = 0;
            while (true) {
                int i29 = i26 + 1;
                char charAt2 = str.charAt(i26);
                if ('A' <= charAt2 && charAt2 <= 'Z') {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    i18 = charAt2 - 'A';
                } else {
                    if ('a' <= charAt2 && charAt2 <= 'z') {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        i18 = charAt2 - 'G';
                    } else {
                        if ('0' <= charAt2 && charAt2 <= '9') {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (z18) {
                            i18 = charAt2 + 4;
                        } else if (charAt2 != '+' && charAt2 != '-') {
                            if (charAt2 != '/' && charAt2 != '_') {
                                if (charAt2 != '\n' && charAt2 != '\r' && charAt2 != ' ' && charAt2 != '\t') {
                                    return null;
                                }
                                if (i29 < length) {
                                    i3 = i27;
                                    i17 = i28;
                                    break;
                                }
                                i26 = i29;
                            } else {
                                i18 = 63;
                            }
                        } else {
                            i18 = 62;
                        }
                    }
                }
                i28 = (i28 << 6) | i18;
                i27++;
                if (i27 % 4 == 0) {
                    int i36 = i16 + 1;
                    bArr[i16] = (byte) (i28 >> 16);
                    int i37 = i36 + 1;
                    bArr[i36] = (byte) (i28 >> 8);
                    i16 = i37 + 1;
                    bArr[i37] = (byte) i28;
                }
                if (i29 < length) {
                }
            }
        } else {
            i3 = 0;
            i16 = 0;
            i17 = 0;
        }
        int i38 = i3 % 4;
        if (i38 == 1) {
            return null;
        }
        if (i38 != 2) {
            if (i38 == 3) {
                int i39 = i17 << 6;
                int i46 = i16 + 1;
                bArr[i16] = (byte) (i39 >> 16);
                i16 = i46 + 1;
                bArr[i46] = (byte) (i39 >> 8);
            }
        } else {
            bArr[i16] = (byte) ((i17 << 12) >> 16);
            i16++;
        }
        if (i16 == i19) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, i16);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    @NotNull
    public static final String encodeBase64(@NotNull byte[] bArr, @NotNull byte[] map) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            int i17 = i3 + 1;
            byte b16 = bArr[i3];
            int i18 = i17 + 1;
            byte b17 = bArr[i17];
            int i19 = i18 + 1;
            byte b18 = bArr[i18];
            int i26 = i16 + 1;
            bArr2[i16] = map[(b16 & 255) >> 2];
            int i27 = i26 + 1;
            bArr2[i26] = map[((b16 & 3) << 4) | ((b17 & 255) >> 4)];
            int i28 = i27 + 1;
            bArr2[i27] = map[((b17 & RegisterType.DOUBLE_HI) << 2) | ((b18 & 255) >> 6)];
            i16 = i28 + 1;
            bArr2[i28] = map[b18 & 63];
            i3 = i19;
        }
        int length2 = bArr.length - length;
        if (length2 != 1) {
            if (length2 == 2) {
                int i29 = i3 + 1;
                byte b19 = bArr[i3];
                byte b26 = bArr[i29];
                int i36 = i16 + 1;
                bArr2[i16] = map[(b19 & 255) >> 2];
                int i37 = i36 + 1;
                bArr2[i36] = map[((b19 & 3) << 4) | ((b26 & 255) >> 4)];
                bArr2[i37] = map[(b26 & RegisterType.DOUBLE_HI) << 2];
                bArr2[i37 + 1] = (byte) 61;
            }
        } else {
            byte b27 = bArr[i3];
            int i38 = i16 + 1;
            bArr2[i16] = map[(b27 & 255) >> 2];
            int i39 = i38 + 1;
            bArr2[i38] = map[(b27 & 3) << 4];
            byte b28 = (byte) 61;
            bArr2[i39] = b28;
            bArr2[i39 + 1] = b28;
        }
        return _JvmPlatformKt.toUtf8String(bArr2);
    }

    public static /* synthetic */ String encodeBase64$default(byte[] bArr, byte[] bArr2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bArr2 = BASE64;
        }
        return encodeBase64(bArr, bArr2);
    }

    @NotNull
    public static final byte[] getBASE64() {
        return BASE64;
    }

    @NotNull
    public static final byte[] getBASE64_URL_SAFE() {
        return BASE64_URL_SAFE;
    }

    public static /* synthetic */ void getBASE64$annotations() {
    }

    public static /* synthetic */ void getBASE64_URL_SAFE$annotations() {
    }
}
