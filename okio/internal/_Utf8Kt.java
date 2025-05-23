package okio.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0003\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\u0007"}, d2 = {"commonAsUtf8ToByteArray", "", "", "commonToUtf8String", "beginIndex", "", "endIndex", "okio"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes29.dex */
public final class _Utf8Kt {
    @NotNull
    public static final byte[] commonAsUtf8ToByteArray(@NotNull String str) {
        boolean z16;
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bArr = new byte[str.length() * 4];
        int length = str.length();
        if (length > 0) {
            int i17 = 0;
            while (true) {
                int i18 = i17 + 1;
                char charAt = str.charAt(i17);
                if (Intrinsics.compare((int) charAt, 128) >= 0) {
                    int length2 = str.length();
                    int i19 = i17;
                    while (i17 < length2) {
                        char charAt2 = str.charAt(i17);
                        if (Intrinsics.compare((int) charAt2, 128) < 0) {
                            int i26 = i19 + 1;
                            bArr[i19] = (byte) charAt2;
                            i17++;
                            while (true) {
                                i19 = i26;
                                if (i17 < length2 && Intrinsics.compare((int) str.charAt(i17), 128) < 0) {
                                    i26 = i19 + 1;
                                    bArr[i19] = (byte) str.charAt(i17);
                                    i17++;
                                }
                            }
                        } else {
                            if (Intrinsics.compare((int) charAt2, 2048) < 0) {
                                int i27 = i19 + 1;
                                bArr[i19] = (byte) ((charAt2 >> 6) | 192);
                                byte b16 = (byte) ((charAt2 & '?') | 128);
                                i3 = i27 + 1;
                                bArr[i27] = b16;
                            } else {
                                boolean z17 = true;
                                if ('\ud800' <= charAt2 && charAt2 <= '\udfff') {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                if (!z16) {
                                    int i28 = i19 + 1;
                                    bArr[i19] = (byte) ((charAt2 >> '\f') | 224);
                                    int i29 = i28 + 1;
                                    bArr[i28] = (byte) (((charAt2 >> 6) & 63) | 128);
                                    byte b17 = (byte) ((charAt2 & '?') | 128);
                                    i3 = i29 + 1;
                                    bArr[i29] = b17;
                                } else {
                                    if (Intrinsics.compare((int) charAt2, 56319) <= 0 && length2 > (i16 = i17 + 1)) {
                                        char charAt3 = str.charAt(i16);
                                        if ('\udc00' > charAt3 || charAt3 > '\udfff') {
                                            z17 = false;
                                        }
                                        if (z17) {
                                            int charAt4 = ((charAt2 << '\n') + str.charAt(i16)) - 56613888;
                                            int i36 = i19 + 1;
                                            bArr[i19] = (byte) ((charAt4 >> 18) | 240);
                                            int i37 = i36 + 1;
                                            bArr[i36] = (byte) (((charAt4 >> 12) & 63) | 128);
                                            int i38 = i37 + 1;
                                            bArr[i37] = (byte) (((charAt4 >> 6) & 63) | 128);
                                            byte b18 = (byte) ((charAt4 & 63) | 128);
                                            i3 = i38 + 1;
                                            bArr[i38] = b18;
                                            i17 += 2;
                                            i19 = i3;
                                        }
                                    }
                                    i3 = i19 + 1;
                                    bArr[i19] = 63;
                                }
                            }
                            i17++;
                            i19 = i3;
                        }
                    }
                    byte[] copyOf = Arrays.copyOf(bArr, i19);
                    Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                    return copyOf;
                }
                bArr[i17] = (byte) charAt;
                if (i18 >= length) {
                    break;
                }
                i17 = i18;
            }
        }
        byte[] copyOf2 = Arrays.copyOf(bArr, str.length());
        Intrinsics.checkNotNullExpressionValue(copyOf2, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x011d, code lost:
    
        if (r12 == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0099, code lost:
    
        if (r5 == false) goto L23;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String commonToUtf8String(@NotNull byte[] bArr, int i3, int i16) {
        String concatToString;
        byte b16;
        boolean z16;
        int i17;
        int i18;
        boolean z17;
        boolean z18;
        boolean z19;
        int i19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z36;
        int i26;
        int i27;
        boolean z37;
        boolean z38;
        int i28 = i3;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (i28 >= 0 && i16 <= bArr.length && i28 <= i16) {
            char[] cArr = new char[i16 - i28];
            int i29 = 0;
            while (i28 < i16) {
                byte b17 = bArr[i28];
                if (b17 >= 0) {
                    int i36 = i29 + 1;
                    cArr[i29] = (char) b17;
                    i28++;
                    while (true) {
                        i29 = i36;
                        if (i28 < i16 && (b16 = bArr[i28]) >= 0) {
                            i28++;
                            i36 = i29 + 1;
                            cArr[i29] = (char) b16;
                        }
                    }
                } else {
                    if ((b17 >> 5) == -2) {
                        int i37 = i28 + 1;
                        if (i16 <= i37) {
                            i17 = i29 + 1;
                            cArr[i29] = (char) 65533;
                        } else {
                            byte b18 = bArr[i37];
                            if ((b18 & 192) == 128) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (!z16) {
                                i17 = i29 + 1;
                                cArr[i29] = (char) 65533;
                            } else {
                                int i38 = (b17 << 6) ^ (b18 ^ 3968);
                                if (i38 < 128) {
                                    i17 = i29 + 1;
                                    cArr[i29] = (char) 65533;
                                } else {
                                    i17 = i29 + 1;
                                    cArr[i29] = (char) i38;
                                }
                                Unit unit = Unit.INSTANCE;
                                i29 = i17;
                                i18 = 2;
                            }
                        }
                        Unit unit2 = Unit.INSTANCE;
                        i29 = i17;
                        i18 = 1;
                    } else {
                        if ((b17 >> 4) == -2) {
                            int i39 = i28 + 2;
                            if (i16 <= i39) {
                                i17 = i29 + 1;
                                cArr[i29] = (char) 65533;
                                Unit unit3 = Unit.INSTANCE;
                                int i46 = i28 + 1;
                                if (i16 > i46) {
                                    if ((bArr[i46] & 192) == 128) {
                                        z26 = true;
                                    } else {
                                        z26 = false;
                                    }
                                }
                                i29 = i17;
                                i18 = 1;
                            } else {
                                byte b19 = bArr[i28 + 1];
                                if ((b19 & 192) == 128) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                if (!z17) {
                                    i17 = i29 + 1;
                                    cArr[i29] = (char) 65533;
                                    Unit unit4 = Unit.INSTANCE;
                                    i29 = i17;
                                    i18 = 1;
                                } else {
                                    byte b26 = bArr[i39];
                                    if ((b26 & 192) == 128) {
                                        z18 = true;
                                    } else {
                                        z18 = false;
                                    }
                                    if (!z18) {
                                        i17 = i29 + 1;
                                        cArr[i29] = (char) 65533;
                                        Unit unit5 = Unit.INSTANCE;
                                        i29 = i17;
                                        i18 = 2;
                                    } else {
                                        int i47 = (b17 << 12) ^ ((b26 ^ (-123008)) ^ (b19 << 6));
                                        if (i47 < 2048) {
                                            i19 = i29 + 1;
                                            cArr[i29] = (char) 65533;
                                        } else {
                                            if (55296 <= i47 && i47 <= 57343) {
                                                z19 = true;
                                            } else {
                                                z19 = false;
                                            }
                                            if (z19) {
                                                i19 = i29 + 1;
                                                cArr[i29] = (char) 65533;
                                            } else {
                                                i19 = i29 + 1;
                                                cArr[i29] = (char) i47;
                                            }
                                        }
                                        Unit unit6 = Unit.INSTANCE;
                                        i29 = i19;
                                    }
                                }
                            }
                        } else if ((b17 >> 3) == -2) {
                            int i48 = i28 + 3;
                            if (i16 <= i48) {
                                i27 = i29 + 1;
                                cArr[i29] = Utf8.REPLACEMENT_CHARACTER;
                                Unit unit7 = Unit.INSTANCE;
                                int i49 = i28 + 1;
                                if (i16 > i49) {
                                    if ((bArr[i49] & 192) == 128) {
                                        z37 = true;
                                    } else {
                                        z37 = false;
                                    }
                                    if (z37) {
                                        int i56 = i28 + 2;
                                        if (i16 > i56) {
                                            if ((bArr[i56] & 192) == 128) {
                                                z38 = true;
                                            } else {
                                                z38 = false;
                                            }
                                        }
                                        i29 = i27;
                                        i18 = 2;
                                    }
                                }
                                i29 = i27;
                                i18 = 1;
                            } else {
                                byte b27 = bArr[i28 + 1];
                                if ((b27 & 192) == 128) {
                                    z27 = true;
                                } else {
                                    z27 = false;
                                }
                                if (!z27) {
                                    i27 = i29 + 1;
                                    cArr[i29] = Utf8.REPLACEMENT_CHARACTER;
                                    Unit unit8 = Unit.INSTANCE;
                                    i29 = i27;
                                    i18 = 1;
                                } else {
                                    byte b28 = bArr[i28 + 2];
                                    if ((b28 & 192) == 128) {
                                        z28 = true;
                                    } else {
                                        z28 = false;
                                    }
                                    if (!z28) {
                                        i27 = i29 + 1;
                                        cArr[i29] = Utf8.REPLACEMENT_CHARACTER;
                                        Unit unit9 = Unit.INSTANCE;
                                        i29 = i27;
                                        i18 = 2;
                                    } else {
                                        byte b29 = bArr[i48];
                                        if ((b29 & 192) == 128) {
                                            z29 = true;
                                        } else {
                                            z29 = false;
                                        }
                                        if (!z29) {
                                            i27 = i29 + 1;
                                            cArr[i29] = Utf8.REPLACEMENT_CHARACTER;
                                            Unit unit10 = Unit.INSTANCE;
                                            i29 = i27;
                                        } else {
                                            int i57 = (b17 << RegisterType.REFERENCE) ^ (((b29 ^ 3678080) ^ (b28 << 6)) ^ (b27 << 12));
                                            if (i57 > 1114111) {
                                                i26 = i29 + 1;
                                                cArr[i29] = Utf8.REPLACEMENT_CHARACTER;
                                            } else {
                                                if (55296 <= i57 && i57 <= 57343) {
                                                    z36 = true;
                                                } else {
                                                    z36 = false;
                                                }
                                                if (z36) {
                                                    i26 = i29 + 1;
                                                    cArr[i29] = Utf8.REPLACEMENT_CHARACTER;
                                                } else if (i57 < 65536) {
                                                    i26 = i29 + 1;
                                                    cArr[i29] = Utf8.REPLACEMENT_CHARACTER;
                                                } else if (i57 != 65533) {
                                                    int i58 = i29 + 1;
                                                    cArr[i29] = (char) ((i57 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                                    char c16 = (char) ((i57 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                                                    i26 = i58 + 1;
                                                    cArr[i58] = c16;
                                                } else {
                                                    i26 = i29 + 1;
                                                    cArr[i29] = Utf8.REPLACEMENT_CHARACTER;
                                                }
                                            }
                                            Unit unit11 = Unit.INSTANCE;
                                            i18 = 4;
                                            i29 = i26;
                                        }
                                    }
                                }
                            }
                        } else {
                            cArr[i29] = Utf8.REPLACEMENT_CHARACTER;
                            i28++;
                            i29++;
                        }
                        i18 = 3;
                    }
                    i28 += i18;
                }
            }
            concatToString = StringsKt__StringsJVMKt.concatToString(cArr, 0, i29);
            return concatToString;
        }
        throw new ArrayIndexOutOfBoundsException("size=" + bArr.length + " beginIndex=" + i28 + " endIndex=" + i16);
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = 0;
        }
        if ((i17 & 2) != 0) {
            i16 = bArr.length;
        }
        return commonToUtf8String(bArr, i3, i16);
    }
}
