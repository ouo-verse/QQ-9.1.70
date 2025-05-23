package okhttp3.internal;

import com.tencent.luggage.wxa.c8.c;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0002\u001a\"\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\f\u0010\r\u001a\u00020\u0001*\u00020\u0003H\u0002\u001a\f\u0010\u000e\u001a\u0004\u0018\u00010\u0003*\u00020\u0003\u00a8\u0006\u000f"}, d2 = {"decodeIpv4Suffix", "", "input", "", c.G, "", "limit", "address", "", "addressOffset", "decodeIpv6", "Ljava/net/InetAddress;", "inet6AddressToAscii", "containsInvalidHostnameAsciiCodes", "toCanonicalHost", "okhttp"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes28.dex */
public final class HostnamesKt {
    private static final boolean containsInvalidHostnameAsciiCodes(String str) {
        int indexOf$default;
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (Intrinsics.compare((int) charAt, 31) > 0 && Intrinsics.compare((int) charAt, 127) < 0) {
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) " #%/:?@[\\]", charAt, 0, false, 6, (Object) null);
                if (indexOf$default != -1) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    private static final boolean decodeIpv4Suffix(String str, int i3, int i16, byte[] bArr, int i17) {
        int i18 = i17;
        while (i3 < i16) {
            if (i18 == bArr.length) {
                return false;
            }
            if (i18 != i17) {
                if (str.charAt(i3) != '.') {
                    return false;
                }
                i3++;
            }
            int i19 = i3;
            int i26 = 0;
            while (i19 < i16) {
                char charAt = str.charAt(i19);
                if (Intrinsics.compare((int) charAt, 48) < 0 || Intrinsics.compare((int) charAt, 57) > 0) {
                    break;
                }
                if ((i26 == 0 && i3 != i19) || (i26 = ((i26 * 10) + charAt) - 48) > 255) {
                    return false;
                }
                i19++;
            }
            if (i19 - i3 == 0) {
                return false;
            }
            bArr[i18] = (byte) i26;
            i18++;
            i3 = i19;
        }
        if (i18 != i17 + 4) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0099, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final InetAddress decodeIpv6(String str, int i3, int i16) {
        boolean startsWith$default;
        boolean startsWith$default2;
        int i17;
        boolean startsWith$default3;
        byte[] bArr = new byte[16];
        int i18 = i3;
        int i19 = -1;
        int i26 = -1;
        int i27 = 0;
        while (true) {
            if (i18 < i16) {
                if (i27 == 16) {
                    return null;
                }
                int i28 = i18 + 2;
                if (i28 <= i16) {
                    startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(str, "::", i18, false, 4, null);
                    if (startsWith$default3) {
                        if (i19 != -1) {
                            return null;
                        }
                        i27 += 2;
                        if (i28 == i16) {
                            i19 = i27;
                            break;
                        }
                        i26 = i28;
                        i19 = i27;
                        i18 = i26;
                        int i29 = 0;
                        while (i18 < i16) {
                            int parseHexDigit = Util.parseHexDigit(str.charAt(i18));
                            if (parseHexDigit == -1) {
                                break;
                            }
                            i29 = (i29 << 4) + parseHexDigit;
                            i18++;
                        }
                        i17 = i18 - i26;
                        if (i17 == 0 || i17 > 4) {
                            break;
                        }
                        int i36 = i27 + 1;
                        bArr[i27] = (byte) ((i29 >>> 8) & 255);
                        i27 = i36 + 1;
                        bArr[i36] = (byte) (i29 & 255);
                    }
                }
                if (i27 != 0) {
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, ":", i18, false, 4, null);
                    if (!startsWith$default) {
                        startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str, ".", i18, false, 4, null);
                        if (!startsWith$default2 || !decodeIpv4Suffix(str, i26, i16, bArr, i27 - 2)) {
                            return null;
                        }
                        i27 += 2;
                    } else {
                        i18++;
                    }
                }
                i26 = i18;
                i18 = i26;
                int i292 = 0;
                while (i18 < i16) {
                }
                i17 = i18 - i26;
                if (i17 == 0) {
                    break;
                }
                break;
            }
            break;
        }
        if (i27 != 16) {
            if (i19 == -1) {
                return null;
            }
            int i37 = i27 - i19;
            System.arraycopy(bArr, i19, bArr, 16 - i37, i37);
            Arrays.fill(bArr, i19, (16 - i27) + i19, (byte) 0);
        }
        return InetAddress.getByAddress(bArr);
    }

    private static final String inet6AddressToAscii(byte[] bArr) {
        int i3 = -1;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (i17 < bArr.length) {
            int i19 = i17;
            while (i19 < 16 && bArr[i19] == 0 && bArr[i19 + 1] == 0) {
                i19 += 2;
            }
            int i26 = i19 - i17;
            if (i26 > i18 && i26 >= 4) {
                i3 = i17;
                i18 = i26;
            }
            i17 = i19 + 2;
        }
        Buffer buffer = new Buffer();
        while (i16 < bArr.length) {
            if (i16 == i3) {
                buffer.writeByte(58);
                i16 += i18;
                if (i16 == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i16 > 0) {
                    buffer.writeByte(58);
                }
                buffer.writeHexadecimalUnsignedLong((Util.and(bArr[i16], 255) << 8) | Util.and(bArr[i16 + 1], 255));
                i16 += 2;
            }
        }
        return buffer.readUtf8();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0073 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0039  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String toCanonicalHost(@NotNull String toCanonicalHost) {
        boolean contains$default;
        boolean startsWith$default;
        InetAddress decodeIpv6;
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(toCanonicalHost, "$this$toCanonicalHost");
        boolean z16 = false;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) toCanonicalHost, (CharSequence) ":", false, 2, (Object) null);
        if (contains$default) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(toCanonicalHost, "[", false, 2, null);
            if (startsWith$default) {
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(toCanonicalHost, "]", false, 2, null);
                if (endsWith$default) {
                    decodeIpv6 = decodeIpv6(toCanonicalHost, 1, toCanonicalHost.length() - 1);
                    if (decodeIpv6 != null) {
                        return null;
                    }
                    byte[] address = decodeIpv6.getAddress();
                    if (address.length == 16) {
                        Intrinsics.checkNotNullExpressionValue(address, "address");
                        return inet6AddressToAscii(address);
                    }
                    if (address.length == 4) {
                        return decodeIpv6.getHostAddress();
                    }
                    throw new AssertionError("Invalid IPv6 address: '" + toCanonicalHost + '\'');
                }
            }
            decodeIpv6 = decodeIpv6(toCanonicalHost, 0, toCanonicalHost.length());
            if (decodeIpv6 != null) {
            }
        } else {
            try {
                String ascii = IDN.toASCII(toCanonicalHost);
                Intrinsics.checkNotNullExpressionValue(ascii, "IDN.toASCII(host)");
                Locale locale = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
                if (ascii != null) {
                    String lowerCase = ascii.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    if (lowerCase.length() == 0) {
                        z16 = true;
                    }
                    if (!z16 && !containsInvalidHostnameAsciiCodes(lowerCase)) {
                        return lowerCase;
                    }
                    return null;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }
}
