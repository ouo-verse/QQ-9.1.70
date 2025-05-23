package okhttp3.internal.http;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\u001a\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a\n\u0010\r\u001a\u00020\u0004*\u00020\u0006\u001a\u001a\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0012H\u0002\u001a\u000e\u0010\u0013\u001a\u0004\u0018\u00010\f*\u00020\u0010H\u0002\u001a\u000e\u0010\u0014\u001a\u0004\u0018\u00010\f*\u00020\u0010H\u0002\u001a\u001a\u0010\u0015\u001a\u00020\u000f*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\n\u001a\f\u0010\u001a\u001a\u00020\u0004*\u00020\u0010H\u0002\u001a\u0014\u0010\u001b\u001a\u00020\u0004*\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"QUOTED_STRING_DELIMITERS", "Lokio/ByteString;", "TOKEN_DELIMITERS", "hasBody", "", "response", "Lokhttp3/Response;", "parseChallenges", "", "Lokhttp3/Challenge;", "Lokhttp3/Headers;", "headerName", "", "promisesBody", "readChallengeHeader", "", "Lokio/Buffer;", "result", "", "readQuotedString", "readToken", "receiveHeaders", "Lokhttp3/CookieJar;", "url", "Lokhttp3/HttpUrl;", "headers", "skipCommasAndWhitespace", "startsWith", "prefix", "", "okhttp"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "HttpHeaders")
/* loaded from: classes28.dex */
public final class HttpHeaders {
    private static final ByteString QUOTED_STRING_DELIMITERS;
    private static final ByteString TOKEN_DELIMITERS;

    static {
        ByteString.Companion companion = ByteString.INSTANCE;
        QUOTED_STRING_DELIMITERS = companion.encodeUtf8("\"\\");
        TOKEN_DELIMITERS = companion.encodeUtf8("\t ,=");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "No longer supported", replaceWith = @ReplaceWith(expression = "response.promisesBody()", imports = {}))
    public static final boolean hasBody(@NotNull Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return promisesBody(response);
    }

    @NotNull
    public static final List<Challenge> parseChallenges(@NotNull Headers parseChallenges, @NotNull String headerName) {
        boolean equals;
        Intrinsics.checkNotNullParameter(parseChallenges, "$this$parseChallenges");
        Intrinsics.checkNotNullParameter(headerName, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = parseChallenges.size();
        for (int i3 = 0; i3 < size; i3++) {
            equals = StringsKt__StringsJVMKt.equals(headerName, parseChallenges.name(i3), true);
            if (equals) {
                try {
                    readChallengeHeader(new Buffer().writeUtf8(parseChallenges.value(i3)), arrayList);
                } catch (EOFException e16) {
                    Platform.INSTANCE.get().log("Unable to parse challenge", 5, e16);
                }
            }
        }
        return arrayList;
    }

    public static final boolean promisesBody(@NotNull Response promisesBody) {
        boolean equals;
        Intrinsics.checkNotNullParameter(promisesBody, "$this$promisesBody");
        if (Intrinsics.areEqual(promisesBody.request().method(), "HEAD")) {
            return false;
        }
        int code = promisesBody.code();
        if (((code >= 100 && code < 200) || code == 204 || code == 304) && Util.headersContentLength(promisesBody) == -1) {
            equals = StringsKt__StringsJVMKt.equals("chunked", Response.header$default(promisesBody, "Transfer-Encoding", null, 2, null), true);
            if (!equals) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0087, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0087, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void readChallengeHeader(Buffer buffer, List<Challenge> list) throws EOFException {
        String readToken;
        Map emptyMap;
        int skipAll;
        String readToken2;
        String repeat;
        while (true) {
            String str = null;
            while (true) {
                if (str == null) {
                    skipCommasAndWhitespace(buffer);
                    str = readToken(buffer);
                    if (str == null) {
                        return;
                    }
                }
                boolean skipCommasAndWhitespace = skipCommasAndWhitespace(buffer);
                readToken = readToken(buffer);
                if (readToken == null) {
                    if (buffer.exhausted()) {
                        emptyMap = MapsKt__MapsKt.emptyMap();
                        list.add(new Challenge(str, (Map<String, String>) emptyMap));
                        return;
                    }
                    return;
                }
                byte b16 = (byte) 61;
                skipAll = Util.skipAll(buffer, b16);
                boolean skipCommasAndWhitespace2 = skipCommasAndWhitespace(buffer);
                if (skipCommasAndWhitespace || (!skipCommasAndWhitespace2 && !buffer.exhausted())) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int skipAll2 = skipAll + Util.skipAll(buffer, b16);
                    while (true) {
                        if (readToken == null) {
                            readToken = readToken(buffer);
                            if (skipCommasAndWhitespace(buffer)) {
                                break;
                            } else {
                                skipAll2 = Util.skipAll(buffer, b16);
                            }
                        }
                        if (skipAll2 == 0) {
                            break;
                        }
                        if (skipAll2 > 1 || skipCommasAndWhitespace(buffer)) {
                            return;
                        }
                        if (startsWith(buffer, (byte) 34)) {
                            readToken2 = readQuotedString(buffer);
                        } else {
                            readToken2 = readToken(buffer);
                        }
                        if (readToken2 == null || ((String) linkedHashMap.put(readToken, readToken2)) != null) {
                            return;
                        }
                        if (!skipCommasAndWhitespace(buffer) && !buffer.exhausted()) {
                            return;
                        } else {
                            readToken = null;
                        }
                    }
                    list.add(new Challenge(str, linkedHashMap));
                    str = readToken;
                }
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(readToken);
            repeat = StringsKt__StringsJVMKt.repeat(ContainerUtils.KEY_VALUE_DELIMITER, skipAll);
            sb5.append(repeat);
            Map singletonMap = Collections.singletonMap(null, sb5.toString());
            Intrinsics.checkNotNullExpressionValue(singletonMap, "Collections.singletonMap\u2026ek + \"=\".repeat(eqCount))");
            list.add(new Challenge(str, (Map<String, String>) singletonMap));
        }
    }

    private static final String readQuotedString(Buffer buffer) throws EOFException {
        boolean z16;
        byte b16 = (byte) 34;
        if (buffer.readByte() == b16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Buffer buffer2 = new Buffer();
            while (true) {
                long indexOfElement = buffer.indexOfElement(QUOTED_STRING_DELIMITERS);
                if (indexOfElement == -1) {
                    return null;
                }
                if (buffer.getByte(indexOfElement) == b16) {
                    buffer2.write(buffer, indexOfElement);
                    buffer.readByte();
                    return buffer2.readUtf8();
                }
                if (buffer.size() == indexOfElement + 1) {
                    return null;
                }
                buffer2.write(buffer, indexOfElement);
                buffer.readByte();
                buffer2.write(buffer, 1L);
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private static final String readToken(Buffer buffer) {
        long indexOfElement = buffer.indexOfElement(TOKEN_DELIMITERS);
        if (indexOfElement == -1) {
            indexOfElement = buffer.size();
        }
        if (indexOfElement != 0) {
            return buffer.readUtf8(indexOfElement);
        }
        return null;
    }

    public static final void receiveHeaders(@NotNull CookieJar receiveHeaders, @NotNull HttpUrl url, @NotNull Headers headers) {
        Intrinsics.checkNotNullParameter(receiveHeaders, "$this$receiveHeaders");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (receiveHeaders == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> parseAll = Cookie.INSTANCE.parseAll(url, headers);
        if (parseAll.isEmpty()) {
            return;
        }
        receiveHeaders.saveFromResponse(url, parseAll);
    }

    private static final boolean skipCommasAndWhitespace(Buffer buffer) {
        boolean z16 = false;
        while (!buffer.exhausted()) {
            byte b16 = buffer.getByte(0L);
            if (b16 != 9 && b16 != 32) {
                if (b16 != 44) {
                    break;
                }
                buffer.readByte();
                z16 = true;
            } else {
                buffer.readByte();
            }
        }
        return z16;
    }

    private static final boolean startsWith(Buffer buffer, byte b16) {
        if (!buffer.exhausted() && buffer.getByte(0L) == b16) {
            return true;
        }
        return false;
    }
}
