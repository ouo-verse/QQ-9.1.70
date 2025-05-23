package okio;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a\u0011\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0007H\u0080\b\u001a4\u0010\u0010\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u00f8\u0001\u0000\u001a4\u0010\u0017\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u00f8\u0001\u0000\u001a4\u0010\u0018\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u00f8\u0001\u0000\u001a4\u0010\u0019\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u00f8\u0001\u0000\u001a4\u0010\u001a\u001a\u00020\u0016*\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u00f8\u0001\u0000\u001a4\u0010\u001c\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u00f8\u0001\u0000\u001a%\u0010\u001d\u001a\u00020\u001e*\u00020\u001b2\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u0001H\u0007\u00a2\u0006\u0002\b\u001f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006 "}, d2 = {"HIGH_SURROGATE_HEADER", "", "LOG_SURROGATE_HEADER", "MASK_2BYTES", "MASK_3BYTES", "MASK_4BYTES", "REPLACEMENT_BYTE", "", "REPLACEMENT_CHARACTER", "", "REPLACEMENT_CODE_POINT", "isIsoControl", "", "codePoint", "isUtf8Continuation", "byte", "process2Utf8Bytes", "", "beginIndex", "endIndex", "yield", "Lkotlin/Function1;", "", "process3Utf8Bytes", "process4Utf8Bytes", "processUtf16Chars", "processUtf8Bytes", "", "processUtf8CodePoints", "utf8Size", "", "size", "okio"}, k = 2, mv = {1, 5, 1}, xi = 48)
@JvmName(name = "Utf8")
/* loaded from: classes29.dex */
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = '\ufffd';
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int i3) {
        boolean z16;
        boolean z17;
        if (i3 >= 0 && i3 <= 31) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        if (127 <= i3 && i3 <= 159) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return true;
        }
        return false;
    }

    public static final boolean isUtf8Continuation(byte b16) {
        if ((b16 & 192) == 128) {
            return true;
        }
        return false;
    }

    public static final int process2Utf8Bytes(@NotNull byte[] bArr, int i3, int i16, @NotNull Function1<? super Integer, Unit> yield) {
        boolean z16;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(yield, "yield");
        int i17 = i3 + 1;
        if (i16 <= i17) {
            yield.invoke(65533);
            return 1;
        }
        byte b16 = bArr[i3];
        byte b17 = bArr[i17];
        if ((b17 & 192) == 128) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            yield.invoke(65533);
            return 1;
        }
        int i18 = (b17 ^ 3968) ^ (b16 << 6);
        if (i18 < 128) {
            yield.invoke(65533);
            return 2;
        }
        yield.invoke(Integer.valueOf(i18));
        return 2;
    }

    public static final int process3Utf8Bytes(@NotNull byte[] bArr, int i3, int i16, @NotNull Function1<? super Integer, Unit> yield) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(yield, "yield");
        int i17 = i3 + 2;
        boolean z18 = false;
        if (i16 <= i17) {
            yield.invoke(65533);
            int i18 = i3 + 1;
            if (i16 > i18) {
                if ((bArr[i18] & 192) == 128) {
                    z18 = true;
                }
                if (z18) {
                    return 2;
                }
            }
            return 1;
        }
        byte b16 = bArr[i3];
        byte b17 = bArr[i3 + 1];
        if ((b17 & 192) == 128) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            yield.invoke(65533);
            return 1;
        }
        byte b18 = bArr[i17];
        if ((b18 & 192) == 128) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            yield.invoke(65533);
            return 2;
        }
        int i19 = ((b18 ^ (-123008)) ^ (b17 << 6)) ^ (b16 << 12);
        if (i19 < 2048) {
            yield.invoke(65533);
            return 3;
        }
        if (55296 <= i19 && i19 <= 57343) {
            z18 = true;
        }
        if (z18) {
            yield.invoke(65533);
            return 3;
        }
        yield.invoke(Integer.valueOf(i19));
        return 3;
    }

    public static final int process4Utf8Bytes(@NotNull byte[] bArr, int i3, int i16, @NotNull Function1<? super Integer, Unit> yield) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(yield, "yield");
        int i17 = i3 + 3;
        boolean z26 = false;
        if (i16 <= i17) {
            yield.invoke(65533);
            int i18 = i3 + 1;
            if (i16 > i18) {
                if ((bArr[i18] & 192) == 128) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (z19) {
                    int i19 = i3 + 2;
                    if (i16 > i19) {
                        if ((bArr[i19] & 192) == 128) {
                            z26 = true;
                        }
                        if (z26) {
                            return 3;
                        }
                    }
                    return 2;
                }
            }
            return 1;
        }
        byte b16 = bArr[i3];
        byte b17 = bArr[i3 + 1];
        if ((b17 & 192) == 128) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            yield.invoke(65533);
            return 1;
        }
        byte b18 = bArr[i3 + 2];
        if ((b18 & 192) == 128) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            yield.invoke(65533);
            return 2;
        }
        byte b19 = bArr[i17];
        if ((b19 & 192) == 128) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z18) {
            yield.invoke(65533);
            return 3;
        }
        int i26 = (((b19 ^ 3678080) ^ (b18 << 6)) ^ (b17 << 12)) ^ (b16 << RegisterType.REFERENCE);
        if (i26 > 1114111) {
            yield.invoke(65533);
            return 4;
        }
        if (55296 <= i26 && i26 <= 57343) {
            z26 = true;
        }
        if (z26) {
            yield.invoke(65533);
            return 4;
        }
        if (i26 < 65536) {
            yield.invoke(65533);
            return 4;
        }
        yield.invoke(Integer.valueOf(i26));
        return 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0118, code lost:
    
        if (r9 == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0095, code lost:
    
        if (r9 == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void processUtf16Chars(@NotNull byte[] bArr, int i3, int i16, @NotNull Function1<? super Character, Unit> yield) {
        char c16;
        int i17;
        boolean z16;
        boolean z17;
        char c17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(yield, "yield");
        int i18 = i3;
        while (i18 < i16) {
            byte b16 = bArr[i18];
            if (b16 >= 0) {
                yield.invoke(Character.valueOf((char) b16));
                i18++;
                while (i18 < i16) {
                    byte b17 = bArr[i18];
                    if (b17 >= 0) {
                        i18++;
                        yield.invoke(Character.valueOf((char) b17));
                    }
                }
            } else {
                boolean z28 = false;
                if ((b16 >> 5) == -2) {
                    int i19 = i18 + 1;
                    if (i16 > i19) {
                        byte b18 = bArr[i19];
                        if ((b18 & 192) == 128) {
                            z28 = true;
                        }
                        if (z28) {
                            int i26 = (b16 << 6) ^ (b18 ^ 3968);
                            if (i26 < 128) {
                                c16 = (char) 65533;
                            } else {
                                c16 = (char) i26;
                            }
                            yield.invoke(Character.valueOf(c16));
                            Unit unit = Unit.INSTANCE;
                            i17 = 2;
                        }
                    }
                    yield.invoke(Character.valueOf((char) 65533));
                    Unit unit2 = Unit.INSTANCE;
                    i17 = 1;
                } else if ((b16 >> 4) == -2) {
                    int i27 = i18 + 2;
                    if (i16 <= i27) {
                        yield.invoke(Character.valueOf((char) 65533));
                        Unit unit3 = Unit.INSTANCE;
                        int i28 = i18 + 1;
                        if (i16 > i28) {
                            if ((bArr[i28] & 192) == 128) {
                                z28 = true;
                            }
                        }
                        i17 = 1;
                    } else {
                        byte b19 = bArr[i18 + 1];
                        if ((b19 & 192) == 128) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!z16) {
                            yield.invoke(Character.valueOf((char) 65533));
                            Unit unit4 = Unit.INSTANCE;
                            i17 = 1;
                        } else {
                            byte b26 = bArr[i27];
                            if ((b26 & 192) == 128) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (!z17) {
                                yield.invoke(Character.valueOf((char) 65533));
                                Unit unit5 = Unit.INSTANCE;
                                i17 = 2;
                            } else {
                                int i29 = (b16 << 12) ^ ((b26 ^ (-123008)) ^ (b19 << 6));
                                if (i29 >= 2048) {
                                    if (55296 <= i29 && i29 <= 57343) {
                                        z28 = true;
                                    }
                                    if (!z28) {
                                        c17 = (char) i29;
                                        yield.invoke(Character.valueOf(c17));
                                        Unit unit6 = Unit.INSTANCE;
                                        i17 = 3;
                                    }
                                }
                                c17 = (char) 65533;
                                yield.invoke(Character.valueOf(c17));
                                Unit unit62 = Unit.INSTANCE;
                                i17 = 3;
                            }
                        }
                    }
                } else if ((b16 >> 3) == -2) {
                    int i36 = i18 + 3;
                    if (i16 <= i36) {
                        yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                        Unit unit7 = Unit.INSTANCE;
                        int i37 = i18 + 1;
                        if (i16 > i37) {
                            if ((bArr[i37] & 192) == 128) {
                                z27 = true;
                            } else {
                                z27 = false;
                            }
                            if (z27) {
                                int i38 = i18 + 2;
                                if (i16 > i38) {
                                    if ((bArr[i38] & 192) == 128) {
                                        z28 = true;
                                    }
                                }
                                i17 = 2;
                            }
                        }
                        i17 = 1;
                    } else {
                        byte b27 = bArr[i18 + 1];
                        if ((b27 & 192) == 128) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (!z18) {
                            yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                            Unit unit8 = Unit.INSTANCE;
                            i17 = 1;
                        } else {
                            byte b28 = bArr[i18 + 2];
                            if ((b28 & 192) == 128) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            if (!z19) {
                                yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                Unit unit9 = Unit.INSTANCE;
                                i17 = 2;
                            } else {
                                byte b29 = bArr[i36];
                                if ((b29 & 192) == 128) {
                                    z26 = true;
                                } else {
                                    z26 = false;
                                }
                                if (!z26) {
                                    yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                    Unit unit10 = Unit.INSTANCE;
                                    i17 = 3;
                                } else {
                                    int i39 = (b16 << RegisterType.REFERENCE) ^ (((b29 ^ 3678080) ^ (b28 << 6)) ^ (b27 << 12));
                                    if (i39 <= 1114111) {
                                        if (55296 <= i39 && i39 <= 57343) {
                                            z28 = true;
                                        }
                                        if (!z28 && i39 >= 65536 && i39 != 65533) {
                                            yield.invoke(Character.valueOf((char) ((i39 >>> 10) + HIGH_SURROGATE_HEADER)));
                                            yield.invoke(Character.valueOf((char) ((i39 & 1023) + LOG_SURROGATE_HEADER)));
                                            Unit unit11 = Unit.INSTANCE;
                                            i17 = 4;
                                        }
                                    }
                                    yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                    Unit unit112 = Unit.INSTANCE;
                                    i17 = 4;
                                }
                            }
                        }
                    }
                } else {
                    yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                    i18++;
                }
                i18 += i17;
            }
        }
    }

    public static final void processUtf8Bytes(@NotNull String str, int i3, int i16, @NotNull Function1<? super Byte, Unit> yield) {
        boolean z16;
        int i17;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(yield, "yield");
        while (i3 < i16) {
            char charAt = str.charAt(i3);
            if (Intrinsics.compare((int) charAt, 128) < 0) {
                yield.invoke(Byte.valueOf((byte) charAt));
                i3++;
                while (i3 < i16 && Intrinsics.compare((int) str.charAt(i3), 128) < 0) {
                    yield.invoke(Byte.valueOf((byte) str.charAt(i3)));
                    i3++;
                }
            } else {
                if (Intrinsics.compare((int) charAt, 2048) < 0) {
                    yield.invoke(Byte.valueOf((byte) ((charAt >> 6) | 192)));
                    yield.invoke(Byte.valueOf((byte) ((charAt & '?') | 128)));
                } else {
                    boolean z17 = false;
                    if ('\ud800' <= charAt && charAt <= '\udfff') {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        yield.invoke(Byte.valueOf((byte) ((charAt >> '\f') | 224)));
                        yield.invoke(Byte.valueOf((byte) (((charAt >> 6) & 63) | 128)));
                        yield.invoke(Byte.valueOf((byte) ((charAt & '?') | 128)));
                    } else {
                        if (Intrinsics.compare((int) charAt, 56319) <= 0 && i16 > (i17 = i3 + 1)) {
                            char charAt2 = str.charAt(i17);
                            if ('\udc00' <= charAt2 && charAt2 <= '\udfff') {
                                z17 = true;
                            }
                            if (z17) {
                                int charAt3 = ((charAt << '\n') + str.charAt(i17)) - 56613888;
                                yield.invoke(Byte.valueOf((byte) ((charAt3 >> 18) | 240)));
                                yield.invoke(Byte.valueOf((byte) (((charAt3 >> 12) & 63) | 128)));
                                yield.invoke(Byte.valueOf((byte) (((charAt3 >> 6) & 63) | 128)));
                                yield.invoke(Byte.valueOf((byte) ((charAt3 & 63) | 128)));
                                i3 += 2;
                            }
                        }
                        yield.invoke((byte) 63);
                    }
                }
                i3++;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0116, code lost:
    
        if (r9 == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0093, code lost:
    
        if (r9 == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void processUtf8CodePoints(@NotNull byte[] bArr, int i3, int i16, @NotNull Function1<? super Integer, Unit> yield) {
        int valueOf;
        int i17;
        boolean z16;
        boolean z17;
        int valueOf2;
        boolean z18;
        boolean z19;
        boolean z26;
        int valueOf3;
        boolean z27;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(yield, "yield");
        int i18 = i3;
        while (i18 < i16) {
            byte b16 = bArr[i18];
            if (b16 >= 0) {
                yield.invoke(Integer.valueOf(b16));
                i18++;
                while (i18 < i16) {
                    byte b17 = bArr[i18];
                    if (b17 >= 0) {
                        i18++;
                        yield.invoke(Integer.valueOf(b17));
                    }
                }
            } else {
                boolean z28 = false;
                if ((b16 >> 5) == -2) {
                    int i19 = i18 + 1;
                    if (i16 > i19) {
                        byte b18 = bArr[i19];
                        if ((b18 & 192) == 128) {
                            z28 = true;
                        }
                        if (z28) {
                            int i26 = (b16 << 6) ^ (b18 ^ 3968);
                            if (i26 < 128) {
                                valueOf = 65533;
                            } else {
                                valueOf = Integer.valueOf(i26);
                            }
                            yield.invoke(valueOf);
                            Unit unit = Unit.INSTANCE;
                            i17 = 2;
                        }
                    }
                    yield.invoke(65533);
                    Unit unit2 = Unit.INSTANCE;
                    i17 = 1;
                } else if ((b16 >> 4) == -2) {
                    int i27 = i18 + 2;
                    if (i16 <= i27) {
                        yield.invoke(65533);
                        Unit unit3 = Unit.INSTANCE;
                        int i28 = i18 + 1;
                        if (i16 > i28) {
                            if ((bArr[i28] & 192) == 128) {
                                z28 = true;
                            }
                        }
                        i17 = 1;
                    } else {
                        byte b19 = bArr[i18 + 1];
                        if ((b19 & 192) == 128) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!z16) {
                            yield.invoke(65533);
                            Unit unit4 = Unit.INSTANCE;
                            i17 = 1;
                        } else {
                            byte b26 = bArr[i27];
                            if ((b26 & 192) == 128) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (!z17) {
                                yield.invoke(65533);
                                Unit unit5 = Unit.INSTANCE;
                                i17 = 2;
                            } else {
                                int i29 = (b16 << 12) ^ ((b26 ^ (-123008)) ^ (b19 << 6));
                                if (i29 >= 2048) {
                                    if (55296 <= i29 && i29 <= 57343) {
                                        z28 = true;
                                    }
                                    if (!z28) {
                                        valueOf2 = Integer.valueOf(i29);
                                        yield.invoke(valueOf2);
                                        Unit unit6 = Unit.INSTANCE;
                                        i17 = 3;
                                    }
                                }
                                valueOf2 = 65533;
                                yield.invoke(valueOf2);
                                Unit unit62 = Unit.INSTANCE;
                                i17 = 3;
                            }
                        }
                    }
                } else if ((b16 >> 3) == -2) {
                    int i36 = i18 + 3;
                    if (i16 <= i36) {
                        yield.invoke(65533);
                        Unit unit7 = Unit.INSTANCE;
                        int i37 = i18 + 1;
                        if (i16 > i37) {
                            if ((bArr[i37] & 192) == 128) {
                                z27 = true;
                            } else {
                                z27 = false;
                            }
                            if (z27) {
                                int i38 = i18 + 2;
                                if (i16 > i38) {
                                    if ((bArr[i38] & 192) == 128) {
                                        z28 = true;
                                    }
                                }
                                i17 = 2;
                            }
                        }
                        i17 = 1;
                    } else {
                        byte b27 = bArr[i18 + 1];
                        if ((b27 & 192) == 128) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (!z18) {
                            yield.invoke(65533);
                            Unit unit8 = Unit.INSTANCE;
                            i17 = 1;
                        } else {
                            byte b28 = bArr[i18 + 2];
                            if ((b28 & 192) == 128) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            if (!z19) {
                                yield.invoke(65533);
                                Unit unit9 = Unit.INSTANCE;
                                i17 = 2;
                            } else {
                                byte b29 = bArr[i36];
                                if ((b29 & 192) == 128) {
                                    z26 = true;
                                } else {
                                    z26 = false;
                                }
                                if (!z26) {
                                    yield.invoke(65533);
                                    Unit unit10 = Unit.INSTANCE;
                                    i17 = 3;
                                } else {
                                    int i39 = (b16 << RegisterType.REFERENCE) ^ (((b29 ^ 3678080) ^ (b28 << 6)) ^ (b27 << 12));
                                    if (i39 <= 1114111) {
                                        if (55296 <= i39 && i39 <= 57343) {
                                            z28 = true;
                                        }
                                        if (!z28 && i39 >= 65536) {
                                            valueOf3 = Integer.valueOf(i39);
                                            yield.invoke(valueOf3);
                                            Unit unit11 = Unit.INSTANCE;
                                            i17 = 4;
                                        }
                                    }
                                    valueOf3 = 65533;
                                    yield.invoke(valueOf3);
                                    Unit unit112 = Unit.INSTANCE;
                                    i17 = 4;
                                }
                            }
                        }
                    }
                } else {
                    yield.invoke(65533);
                    i18++;
                }
                i18 += i17;
            }
        }
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return size$default(str, 0, 0, 3, null);
    }

    public static /* synthetic */ long size$default(String str, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = 0;
        }
        if ((i17 & 2) != 0) {
            i16 = str.length();
        }
        return size(str, i3, i16);
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String str, int i3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return size$default(str, i3, 0, 2, null);
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String str, int i3, int i16) {
        int i17;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (!(i3 >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("beginIndex < 0: ", Integer.valueOf(i3)).toString());
        }
        if (i16 >= i3) {
            if (!(i16 <= str.length())) {
                throw new IllegalArgumentException(("endIndex > string.length: " + i16 + " > " + str.length()).toString());
            }
            long j3 = 0;
            while (i3 < i16) {
                char charAt = str.charAt(i3);
                if (charAt < '\u0080') {
                    j3++;
                } else {
                    if (charAt < '\u0800') {
                        i17 = 2;
                    } else if (charAt < '\ud800' || charAt > '\udfff') {
                        i17 = 3;
                    } else {
                        int i18 = i3 + 1;
                        char charAt2 = i18 < i16 ? str.charAt(i18) : (char) 0;
                        if (charAt > '\udbff' || charAt2 < '\udc00' || charAt2 > '\udfff') {
                            j3++;
                            i3 = i18;
                        } else {
                            j3 += 4;
                            i3 += 2;
                        }
                    }
                    j3 += i17;
                }
                i3++;
            }
            return j3;
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + i16 + " < " + i3).toString());
    }
}
