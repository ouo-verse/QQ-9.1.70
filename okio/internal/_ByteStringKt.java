package okio.internal;

import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okio.Buffer;
import okio.ByteString;
import okio._Base64Kt;
import okio._JvmPlatformKt;
import okio._UtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0080\b\u001a\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\r\u0010\u0011\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a\r\u0010\u0013\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a\u0015\u0010\u0014\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0080\b\u001a-\u0010\u0016\u001a\u00020\u0017*\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0080\b\u001a\u000f\u0010\u001c\u001a\u0004\u0018\u00010\f*\u00020\u0012H\u0080\b\u001a\r\u0010\u001d\u001a\u00020\f*\u00020\u0012H\u0080\b\u001a\r\u0010\u001e\u001a\u00020\f*\u00020\u0012H\u0080\b\u001a\u0015\u0010\u001f\u001a\u00020 *\u00020\f2\u0006\u0010!\u001a\u00020\tH\u0080\b\u001a\u0015\u0010\u001f\u001a\u00020 *\u00020\f2\u0006\u0010!\u001a\u00020\fH\u0080\b\u001a\u0017\u0010\"\u001a\u00020 *\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010#H\u0080\b\u001a\u0015\u0010$\u001a\u00020%*\u00020\f2\u0006\u0010&\u001a\u00020\u0007H\u0080\b\u001a\r\u0010'\u001a\u00020\u0007*\u00020\fH\u0080\b\u001a\r\u0010(\u001a\u00020\u0007*\u00020\fH\u0080\b\u001a\r\u0010)\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a\u001d\u0010*\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0007H\u0080\b\u001a\r\u0010,\u001a\u00020\t*\u00020\fH\u0080\b\u001a\u001d\u0010-\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0007H\u0080\b\u001a\u001d\u0010-\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u0007H\u0080\b\u001a-\u0010.\u001a\u00020 *\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0080\b\u001a-\u0010.\u001a\u00020 *\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0080\b\u001a\u0015\u00100\u001a\u00020 *\u00020\f2\u0006\u00101\u001a\u00020\tH\u0080\b\u001a\u0015\u00100\u001a\u00020 *\u00020\f2\u0006\u00101\u001a\u00020\fH\u0080\b\u001a\u001d\u00102\u001a\u00020\f*\u00020\f2\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0080\b\u001a\r\u00105\u001a\u00020\f*\u00020\fH\u0080\b\u001a\r\u00106\u001a\u00020\f*\u00020\fH\u0080\b\u001a\r\u00107\u001a\u00020\t*\u00020\fH\u0080\b\u001a\u001d\u00108\u001a\u00020\f*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0080\b\u001a\r\u00109\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a\r\u0010:\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a$\u0010;\u001a\u00020\u0017*\u00020\f2\u0006\u0010<\u001a\u00020=2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0000\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006>"}, d2 = {"HEX_DIGIT_CHARS", "", "getHEX_DIGIT_CHARS$annotations", "()V", "getHEX_DIGIT_CHARS", "()[C", "codePointIndexToCharIndex", "", ReportConstant.COSTREPORT_PREFIX, "", "codePointCount", "commonOf", "Lokio/ByteString;", "data", "decodeHexDigit", "c", "", "commonBase64", "", "commonBase64Url", "commonCompareTo", "other", "commonCopyInto", "", "offset", "target", "targetOffset", "byteCount", "commonDecodeBase64", "commonDecodeHex", "commonEncodeUtf8", "commonEndsWith", "", "suffix", "commonEquals", "", "commonGetByte", "", c.G, "commonGetSize", "commonHashCode", "commonHex", "commonIndexOf", "fromIndex", "commonInternalArray", "commonLastIndexOf", "commonRangeEquals", "otherOffset", "commonStartsWith", "prefix", "commonSubstring", "beginIndex", "endIndex", "commonToAsciiLowercase", "commonToAsciiUppercase", "commonToByteArray", "commonToByteString", "commonToString", "commonUtf8", "commonWrite", "buffer", "Lokio/Buffer;", "okio"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes29.dex */
public final class _ByteStringKt {

    @NotNull
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARN: Removed duplicated region for block: B:174:0x0217 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0047 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0081 A[EDGE_INSN: B:267:0x0081->B:268:0x0081 BREAK  A[LOOP:1: B:249:0x0051->B:276:0x0088, LOOP_LABEL: LOOP:0: B:2:0x0008->B:43:0x0008], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00da A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x016c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int codePointIndexToCharIndex(byte[] bArr, int i3) {
        int i16;
        byte b16;
        int i17;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z36;
        boolean z37;
        int i18;
        int i19;
        boolean z38;
        boolean z39;
        boolean z46;
        boolean z47;
        boolean z48;
        boolean z49;
        int i26;
        boolean z55;
        boolean z56;
        boolean z57;
        boolean z58;
        int i27;
        boolean z59;
        boolean z65;
        boolean z66;
        int length = bArr.length;
        int i28 = 0;
        int i29 = 0;
        int i36 = 0;
        loop0: while (i28 < length) {
            byte b17 = bArr[i28];
            if (b17 >= 0) {
                int i37 = i36 + 1;
                if (i36 == i3) {
                    return i29;
                }
                if (b17 != 10 && b17 != 13) {
                    if (b17 >= 0 && b17 <= 31) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (!z19) {
                        if (Byte.MAX_VALUE <= b17 && b17 <= 159) {
                            z27 = true;
                        } else {
                            z27 = false;
                        }
                        if (!z27) {
                            z26 = false;
                            if (z26) {
                                return -1;
                            }
                        }
                    }
                    z26 = true;
                    if (z26) {
                    }
                }
                if (b17 == 65533) {
                    return -1;
                }
                if (b17 < 65536) {
                    i16 = 1;
                } else {
                    i16 = 2;
                }
                i29 += i16;
                i28++;
                while (true) {
                    i36 = i37;
                    if (i28 < length && (b16 = bArr[i28]) >= 0) {
                        i28++;
                        i37 = i36 + 1;
                        if (i36 == i3) {
                            return i29;
                        }
                        if (b16 != 10 && b16 != 13) {
                            if (b16 >= 0 && b16 <= 31) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (!z16) {
                                if (Byte.MAX_VALUE <= b16 && b16 <= 159) {
                                    z18 = true;
                                } else {
                                    z18 = false;
                                }
                                if (!z18) {
                                    z17 = false;
                                    if (z17) {
                                        break loop0;
                                    }
                                }
                            }
                            z17 = true;
                            if (z17) {
                            }
                        }
                        if (b16 == 65533) {
                            break loop0;
                        }
                        if (b16 < 65536) {
                            i17 = 1;
                        } else {
                            i17 = 2;
                        }
                        i29 += i17;
                    }
                }
                return -1;
            }
            if ((b17 >> 5) == -2) {
                int i38 = i28 + 1;
                if (length <= i38) {
                    if (i36 != i3) {
                        return -1;
                    }
                    return i29;
                }
                byte b18 = bArr[i38];
                if ((b18 & 192) == 128) {
                    z58 = true;
                } else {
                    z58 = false;
                }
                if (!z58) {
                    if (i36 != i3) {
                        return -1;
                    }
                    return i29;
                }
                int i39 = (b18 ^ 3968) ^ (b17 << 6);
                if (i39 < 128) {
                    if (i36 != i3) {
                        return -1;
                    }
                    return i29;
                }
                i18 = i36 + 1;
                if (i36 == i3) {
                    return i29;
                }
                if (i39 != 10 && i39 != 13) {
                    if (i39 >= 0 && i39 <= 31) {
                        z59 = true;
                    } else {
                        z59 = false;
                    }
                    if (!z59) {
                        if (127 <= i39 && i39 <= 159) {
                            z66 = true;
                        } else {
                            z66 = false;
                        }
                        if (!z66) {
                            z65 = false;
                            if (z65) {
                                return -1;
                            }
                        }
                    }
                    z65 = true;
                    if (z65) {
                    }
                }
                if (i39 == 65533) {
                    return -1;
                }
                if (i39 < 65536) {
                    i27 = 1;
                } else {
                    i27 = 2;
                }
                i29 += i27;
                Unit unit = Unit.INSTANCE;
                i28 += 2;
            } else if ((b17 >> 4) == -2) {
                int i46 = i28 + 2;
                if (length <= i46) {
                    if (i36 != i3) {
                        return -1;
                    }
                    return i29;
                }
                byte b19 = bArr[i28 + 1];
                if ((b19 & 192) == 128) {
                    z47 = true;
                } else {
                    z47 = false;
                }
                if (!z47) {
                    if (i36 != i3) {
                        return -1;
                    }
                    return i29;
                }
                byte b26 = bArr[i46];
                if ((b26 & 192) == 128) {
                    z48 = true;
                } else {
                    z48 = false;
                }
                if (!z48) {
                    if (i36 != i3) {
                        return -1;
                    }
                    return i29;
                }
                int i47 = ((b26 ^ (-123008)) ^ (b19 << 6)) ^ (b17 << 12);
                if (i47 < 2048) {
                    if (i36 != i3) {
                        return -1;
                    }
                    return i29;
                }
                if (55296 <= i47 && i47 <= 57343) {
                    z49 = true;
                } else {
                    z49 = false;
                }
                if (z49) {
                    if (i36 != i3) {
                        return -1;
                    }
                    return i29;
                }
                i18 = i36 + 1;
                if (i36 == i3) {
                    return i29;
                }
                if (i47 != 10 && i47 != 13) {
                    if (i47 >= 0 && i47 <= 31) {
                        z55 = true;
                    } else {
                        z55 = false;
                    }
                    if (!z55) {
                        if (127 <= i47 && i47 <= 159) {
                            z57 = true;
                        } else {
                            z57 = false;
                        }
                        if (!z57) {
                            z56 = false;
                            if (z56) {
                                return -1;
                            }
                        }
                    }
                    z56 = true;
                    if (z56) {
                    }
                }
                if (i47 == 65533) {
                    return -1;
                }
                if (i47 < 65536) {
                    i26 = 1;
                } else {
                    i26 = 2;
                }
                i29 += i26;
                Unit unit2 = Unit.INSTANCE;
                i28 += 3;
            } else if ((b17 >> 3) == -2) {
                int i48 = i28 + 3;
                if (length <= i48) {
                    if (i36 != i3) {
                        return -1;
                    }
                    return i29;
                }
                byte b27 = bArr[i28 + 1];
                if ((b27 & 192) == 128) {
                    z28 = true;
                } else {
                    z28 = false;
                }
                if (!z28) {
                    if (i36 != i3) {
                        return -1;
                    }
                    return i29;
                }
                byte b28 = bArr[i28 + 2];
                if ((b28 & 192) == 128) {
                    z29 = true;
                } else {
                    z29 = false;
                }
                if (!z29) {
                    if (i36 != i3) {
                        return -1;
                    }
                    return i29;
                }
                byte b29 = bArr[i48];
                if ((b29 & 192) == 128) {
                    z36 = true;
                } else {
                    z36 = false;
                }
                if (!z36) {
                    if (i36 != i3) {
                        return -1;
                    }
                    return i29;
                }
                int i49 = (((b29 ^ 3678080) ^ (b28 << 6)) ^ (b27 << 12)) ^ (b17 << RegisterType.REFERENCE);
                if (i49 > 1114111) {
                    if (i36 != i3) {
                        return -1;
                    }
                    return i29;
                }
                if (55296 <= i49 && i49 <= 57343) {
                    z37 = true;
                } else {
                    z37 = false;
                }
                if (z37) {
                    if (i36 != i3) {
                        return -1;
                    }
                    return i29;
                }
                if (i49 < 65536) {
                    if (i36 != i3) {
                        return -1;
                    }
                    return i29;
                }
                i18 = i36 + 1;
                if (i36 == i3) {
                    return i29;
                }
                if (i49 != 10 && i49 != 13) {
                    if (i49 >= 0 && i49 <= 31) {
                        z38 = true;
                    } else {
                        z38 = false;
                    }
                    if (!z38) {
                        if (127 <= i49 && i49 <= 159) {
                            z46 = true;
                        } else {
                            z46 = false;
                        }
                        if (!z46) {
                            z39 = false;
                            if (z39) {
                                return -1;
                            }
                        }
                    }
                    z39 = true;
                    if (z39) {
                    }
                }
                if (i49 == 65533) {
                    return -1;
                }
                if (i49 < 65536) {
                    i19 = 1;
                } else {
                    i19 = 2;
                }
                i29 += i19;
                Unit unit3 = Unit.INSTANCE;
                i28 += 4;
            } else {
                if (i36 != i3) {
                    return -1;
                }
                return i29;
            }
            i36 = i18;
        }
        return i29;
    }

    @NotNull
    public static final String commonBase64(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return _Base64Kt.encodeBase64$default(byteString.getData(), null, 1, null);
    }

    @NotNull
    public static final String commonBase64Url(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return _Base64Kt.encodeBase64(byteString.getData(), _Base64Kt.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(@NotNull ByteString byteString, @NotNull ByteString other) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int size = byteString.size();
        int size2 = other.size();
        int min = Math.min(size, size2);
        for (int i3 = 0; i3 < min; i3++) {
            int i16 = byteString.getByte(i3) & 255;
            int i17 = other.getByte(i3) & 255;
            if (i16 != i17) {
                if (i16 < i17) {
                    return -1;
                }
                return 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        if (size < size2) {
            return -1;
        }
        return 1;
    }

    public static final void commonCopyInto(@NotNull ByteString byteString, int i3, @NotNull byte[] target, int i16, int i17) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        ArraysKt___ArraysJvmKt.copyInto(byteString.getData(), target, i16, i3, i17 + i3);
    }

    @Nullable
    public static final ByteString commonDecodeBase64(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] decodeBase64ToArray = _Base64Kt.decodeBase64ToArray(str);
        if (decodeBase64ToArray != null) {
            return new ByteString(decodeBase64ToArray);
        }
        return null;
    }

    @NotNull
    public static final ByteString commonDecodeHex(@NotNull String str) {
        boolean z16;
        Intrinsics.checkNotNullParameter(str, "<this>");
        int i3 = 0;
        if (str.length() % 2 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            int i16 = length - 1;
            if (i16 >= 0) {
                while (true) {
                    int i17 = i3 + 1;
                    int i18 = i3 * 2;
                    bArr[i3] = (byte) ((decodeHexDigit(str.charAt(i18)) << 4) + decodeHexDigit(str.charAt(i18 + 1)));
                    if (i17 > i16) {
                        break;
                    }
                    i3 = i17;
                }
            }
            return new ByteString(bArr);
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Unexpected hex string: ", str).toString());
    }

    @NotNull
    public static final ByteString commonEncodeUtf8(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        ByteString byteString = new ByteString(_JvmPlatformKt.asUtf8ToByteArray(str));
        byteString.setUtf8$okio(str);
        return byteString;
    }

    public static final boolean commonEndsWith(@NotNull ByteString byteString, @NotNull ByteString suffix) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return byteString.rangeEquals(byteString.size() - suffix.size(), suffix, 0, suffix.size());
    }

    public static final boolean commonEquals(@NotNull ByteString byteString, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        if (obj == byteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString2 = (ByteString) obj;
            if (byteString2.size() == byteString.getData().length && byteString2.rangeEquals(0, byteString.getData(), 0, byteString.getData().length)) {
                return true;
            }
        }
        return false;
    }

    public static final byte commonGetByte(@NotNull ByteString byteString, int i3) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.getData()[i3];
    }

    public static final int commonGetSize(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.getData().length;
    }

    public static final int commonHashCode(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        int hashCode = byteString.getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int hashCode2 = Arrays.hashCode(byteString.getData());
        byteString.setHashCode$okio(hashCode2);
        return hashCode2;
    }

    @NotNull
    public static final String commonHex(@NotNull ByteString byteString) {
        String concatToString;
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        char[] cArr = new char[byteString.getData().length * 2];
        byte[] data = byteString.getData();
        int length = data.length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            byte b16 = data[i3];
            i3++;
            int i17 = i16 + 1;
            cArr[i16] = getHEX_DIGIT_CHARS()[(b16 >> 4) & 15];
            i16 = i17 + 1;
            cArr[i17] = getHEX_DIGIT_CHARS()[b16 & RegisterType.DOUBLE_HI];
        }
        concatToString = StringsKt__StringsJVMKt.concatToString(cArr);
        return concatToString;
    }

    public static final int commonIndexOf(@NotNull ByteString byteString, @NotNull byte[] other, int i3) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = byteString.getData().length - other.length;
        int max = Math.max(i3, 0);
        if (max > length) {
            return -1;
        }
        while (true) {
            int i16 = max + 1;
            if (_UtilKt.arrayRangeEquals(byteString.getData(), max, other, 0, other.length)) {
                return max;
            }
            if (max != length) {
                max = i16;
            } else {
                return -1;
            }
        }
    }

    @NotNull
    public static final byte[] commonInternalArray(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.getData();
    }

    public static final int commonLastIndexOf(@NotNull ByteString byteString, @NotNull ByteString other, int i3) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return byteString.lastIndexOf(other.internalArray$okio(), i3);
    }

    @NotNull
    public static final ByteString commonOf(@NotNull byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        byte[] copyOf = Arrays.copyOf(data, data.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        return new ByteString(copyOf);
    }

    public static final boolean commonRangeEquals(@NotNull ByteString byteString, int i3, @NotNull ByteString other, int i16, int i17) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return other.rangeEquals(i16, byteString.getData(), i3, i17);
    }

    public static final boolean commonStartsWith(@NotNull ByteString byteString, @NotNull ByteString prefix) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return byteString.rangeEquals(0, prefix, 0, prefix.size());
    }

    @NotNull
    public static final ByteString commonSubstring(@NotNull ByteString byteString, int i3, int i16) {
        boolean z16;
        boolean z17;
        byte[] copyOfRange;
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(byteString, i16);
        boolean z18 = true;
        if (i3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (resolveDefaultParameter <= byteString.getData().length) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                if (resolveDefaultParameter - i3 < 0) {
                    z18 = false;
                }
                if (z18) {
                    if (i3 != 0 || resolveDefaultParameter != byteString.getData().length) {
                        copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(byteString.getData(), i3, resolveDefaultParameter);
                        return new ByteString(copyOfRange);
                    }
                    return byteString;
                }
                throw new IllegalArgumentException("endIndex < beginIndex".toString());
            }
            throw new IllegalArgumentException(("endIndex > length(" + byteString.getData().length + ')').toString());
        }
        throw new IllegalArgumentException("beginIndex < 0".toString());
    }

    @NotNull
    public static final ByteString commonToAsciiLowercase(@NotNull ByteString byteString) {
        byte b16;
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        for (int i3 = 0; i3 < byteString.getData().length; i3++) {
            byte b17 = byteString.getData()[i3];
            byte b18 = (byte) 65;
            if (b17 >= b18 && b17 <= (b16 = (byte) 90)) {
                byte[] data = byteString.getData();
                byte[] copyOf = Arrays.copyOf(data, data.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i3] = (byte) (b17 + 32);
                for (int i16 = i3 + 1; i16 < copyOf.length; i16++) {
                    byte b19 = copyOf[i16];
                    if (b19 >= b18 && b19 <= b16) {
                        copyOf[i16] = (byte) (b19 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return byteString;
    }

    @NotNull
    public static final ByteString commonToAsciiUppercase(@NotNull ByteString byteString) {
        byte b16;
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        for (int i3 = 0; i3 < byteString.getData().length; i3++) {
            byte b17 = byteString.getData()[i3];
            byte b18 = (byte) 97;
            if (b17 >= b18 && b17 <= (b16 = (byte) 122)) {
                byte[] data = byteString.getData();
                byte[] copyOf = Arrays.copyOf(data, data.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i3] = (byte) (b17 - 32);
                for (int i16 = i3 + 1; i16 < copyOf.length; i16++) {
                    byte b19 = copyOf[i16];
                    if (b19 >= b18 && b19 <= b16) {
                        copyOf[i16] = (byte) (b19 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return byteString;
    }

    @NotNull
    public static final byte[] commonToByteArray(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        byte[] data = byteString.getData();
        byte[] copyOf = Arrays.copyOf(data, data.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @NotNull
    public static final ByteString commonToByteString(@NotNull byte[] bArr, int i3, int i16) {
        byte[] copyOfRange;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        _UtilKt.checkOffsetAndCount(bArr.length, i3, i16);
        copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(bArr, i3, i16 + i3);
        return new ByteString(copyOfRange);
    }

    @NotNull
    public static final String commonToString(@NotNull ByteString byteString) {
        boolean z16;
        String replace$default;
        String replace$default2;
        String replace$default3;
        boolean z17;
        byte[] copyOfRange;
        ByteString byteString2 = byteString;
        Intrinsics.checkNotNullParameter(byteString2, "<this>");
        boolean z18 = true;
        if (byteString.getData().length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            int codePointIndexToCharIndex = codePointIndexToCharIndex(byteString.getData(), 64);
            if (codePointIndexToCharIndex == -1) {
                if (byteString.getData().length <= 64) {
                    return "[hex=" + byteString.hex() + ']';
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[size=");
                sb5.append(byteString.getData().length);
                sb5.append(" hex=");
                int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(byteString2, 64);
                if (resolveDefaultParameter <= byteString.getData().length) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    if (resolveDefaultParameter + 0 < 0) {
                        z18 = false;
                    }
                    if (z18) {
                        if (resolveDefaultParameter != byteString.getData().length) {
                            copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(byteString.getData(), 0, resolveDefaultParameter);
                            byteString2 = new ByteString(copyOfRange);
                        }
                        sb5.append(byteString2.hex());
                        sb5.append("\u2026]");
                        return sb5.toString();
                    }
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                }
                throw new IllegalArgumentException(("endIndex > length(" + byteString.getData().length + ')').toString());
            }
            String utf8 = byteString.utf8();
            if (utf8 != null) {
                String substring = utf8.substring(0, codePointIndexToCharIndex);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                replace$default = StringsKt__StringsJVMKt.replace$default(substring, "\\", "\\\\", false, 4, (Object) null);
                replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "\n", RedTouch.NEWLINE_CHAR, false, 4, (Object) null);
                replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "\r", "\\r", false, 4, (Object) null);
                if (codePointIndexToCharIndex < utf8.length()) {
                    return "[size=" + byteString.getData().length + " text=" + replace$default3 + "\u2026]";
                }
                return "[text=" + replace$default3 + ']';
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        return "[size=0]";
    }

    @NotNull
    public static final String commonUtf8(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        String utf8 = byteString.getUtf8();
        if (utf8 == null) {
            String utf8String = _JvmPlatformKt.toUtf8String(byteString.internalArray$okio());
            byteString.setUtf8$okio(utf8String);
            return utf8String;
        }
        return utf8;
    }

    public static final void commonWrite(@NotNull ByteString byteString, @NotNull Buffer buffer, int i3, int i16) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        buffer.write(byteString.getData(), i3, i16);
    }

    public static final int decodeHexDigit(char c16) {
        boolean z16;
        boolean z17;
        boolean z18 = true;
        if ('0' <= c16 && c16 <= '9') {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return c16 - '0';
        }
        char c17 = 'a';
        if ('a' <= c16 && c16 <= 'f') {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            c17 = EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET;
            if ('A' > c16 || c16 > 'F') {
                z18 = false;
            }
            if (!z18) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Unexpected hex digit: ", Character.valueOf(c16)));
            }
        }
        return (c16 - c17) + 10;
    }

    @NotNull
    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static final boolean commonEndsWith(@NotNull ByteString byteString, @NotNull byte[] suffix) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return byteString.rangeEquals(byteString.size() - suffix.length, suffix, 0, suffix.length);
    }

    public static final int commonLastIndexOf(@NotNull ByteString byteString, @NotNull byte[] other, int i3) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(_UtilKt.resolveDefaultParameter(byteString, i3), byteString.getData().length - other.length);
        if (min < 0) {
            return -1;
        }
        while (true) {
            int i16 = min - 1;
            if (_UtilKt.arrayRangeEquals(byteString.getData(), min, other, 0, other.length)) {
                return min;
            }
            if (i16 < 0) {
                return -1;
            }
            min = i16;
        }
    }

    public static final boolean commonRangeEquals(@NotNull ByteString byteString, int i3, @NotNull byte[] other, int i16, int i17) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return i3 >= 0 && i3 <= byteString.getData().length - i17 && i16 >= 0 && i16 <= other.length - i17 && _UtilKt.arrayRangeEquals(byteString.getData(), i3, other, i16, i17);
    }

    public static final boolean commonStartsWith(@NotNull ByteString byteString, @NotNull byte[] prefix) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return byteString.rangeEquals(0, prefix, 0, prefix.length);
    }

    public static /* synthetic */ void getHEX_DIGIT_CHARS$annotations() {
    }
}
