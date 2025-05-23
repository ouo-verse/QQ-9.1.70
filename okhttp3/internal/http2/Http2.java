package okhttp3.internal.http2;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadLooperPrinter2;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal.Util;
import okio.ByteString;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bJ\u0015\u0010\"\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u000bH\u0000\u00a2\u0006\u0002\b#J.\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\n\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0014\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lokhttp3/internal/http2/Http2;", "", "()V", "BINARY", "", "", "[Ljava/lang/String;", "CONNECTION_PREFACE", "Lokio/ByteString;", "FLAGS", "FLAG_ACK", "", "FLAG_COMPRESSED", "FLAG_END_HEADERS", "FLAG_END_PUSH_PROMISE", "FLAG_END_STREAM", "FLAG_NONE", "FLAG_PADDED", "FLAG_PRIORITY", "FRAME_NAMES", "INITIAL_MAX_FRAME_SIZE", "TYPE_CONTINUATION", "TYPE_DATA", "TYPE_GOAWAY", "TYPE_HEADERS", "TYPE_PING", "TYPE_PRIORITY", "TYPE_PUSH_PROMISE", "TYPE_RST_STREAM", "TYPE_SETTINGS", "TYPE_WINDOW_UPDATE", "formatFlags", "type", WadlProxyConsts.FLAGS, "formattedType", "formattedType$okhttp", "frameLog", "inbound", "", "streamId", "length", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes28.dex */
public final class Http2 {
    private static final String[] BINARY;
    public static final int FLAG_ACK = 1;
    public static final int FLAG_COMPRESSED = 32;
    public static final int FLAG_END_HEADERS = 4;
    public static final int FLAG_END_PUSH_PROMISE = 4;
    public static final int FLAG_END_STREAM = 1;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_PADDED = 8;
    public static final int FLAG_PRIORITY = 32;
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    public static final int TYPE_CONTINUATION = 9;
    public static final int TYPE_DATA = 0;
    public static final int TYPE_GOAWAY = 7;
    public static final int TYPE_HEADERS = 1;
    public static final int TYPE_PING = 6;
    public static final int TYPE_PRIORITY = 2;
    public static final int TYPE_PUSH_PROMISE = 5;
    public static final int TYPE_RST_STREAM = 3;
    public static final int TYPE_SETTINGS = 4;
    public static final int TYPE_WINDOW_UPDATE = 8;

    @NotNull
    public static final Http2 INSTANCE = new Http2();

    @JvmField
    @NotNull
    public static final ByteString CONNECTION_PREFACE = ByteString.INSTANCE.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] FRAME_NAMES = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    private static final String[] FLAGS = new String[64];

    static {
        String replace$default;
        String[] strArr = new String[256];
        for (int i3 = 0; i3 < 256; i3++) {
            String binaryString = Integer.toBinaryString(i3);
            Intrinsics.checkNotNullExpressionValue(binaryString, "Integer.toBinaryString(it)");
            replace$default = StringsKt__StringsJVMKt.replace$default(Util.format("%8s", binaryString), TokenParser.SP, '0', false, 4, (Object) null);
            strArr[i3] = replace$default;
        }
        BINARY = strArr;
        String[] strArr2 = FLAGS;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        strArr2[1 | 8] = Intrinsics.stringPlus("END_STREAM", "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i16 = 0; i16 < 3; i16++) {
            int i17 = iArr2[i16];
            int i18 = iArr[0];
            String[] strArr3 = FLAGS;
            int i19 = i18 | i17;
            strArr3[i19] = strArr3[i18] + "|" + strArr3[i17];
            strArr3[i19 | 8] = strArr3[i18] + "|" + strArr3[i17] + "|PADDED";
        }
        int length = FLAGS.length;
        for (int i26 = 0; i26 < length; i26++) {
            String[] strArr4 = FLAGS;
            if (strArr4[i26] == null) {
                strArr4[i26] = BINARY[i26];
            }
        }
    }

    Http2() {
    }

    @NotNull
    public final String formatFlags(int type, int flags) {
        String str;
        String replace$default;
        String replace$default2;
        if (flags == 0) {
            return "";
        }
        if (type != 2 && type != 3) {
            if (type != 4 && type != 6) {
                if (type != 7 && type != 8) {
                    String[] strArr = FLAGS;
                    if (flags < strArr.length) {
                        str = strArr[flags];
                        Intrinsics.checkNotNull(str);
                    } else {
                        str = BINARY[flags];
                    }
                    String str2 = str;
                    if (type == 5 && (flags & 4) != 0) {
                        replace$default2 = StringsKt__StringsJVMKt.replace$default(str2, "HEADERS", "PUSH_PROMISE", false, 4, (Object) null);
                        return replace$default2;
                    }
                    if (type == 0 && (flags & 32) != 0) {
                        replace$default = StringsKt__StringsJVMKt.replace$default(str2, "PRIORITY", "COMPRESSED", false, 4, (Object) null);
                        return replace$default;
                    }
                    return str2;
                }
            } else {
                if (flags == 1) {
                    return "ACK";
                }
                return BINARY[flags];
            }
        }
        return BINARY[flags];
    }

    @NotNull
    public final String formattedType$okhttp(int type) {
        String[] strArr = FRAME_NAMES;
        if (type < strArr.length) {
            return strArr[type];
        }
        return Util.format("0x%02x", Integer.valueOf(type));
    }

    @NotNull
    public final String frameLog(boolean inbound, int streamId, int length, int type, int flags) {
        String str;
        String formattedType$okhttp = formattedType$okhttp(type);
        String formatFlags = formatFlags(type, flags);
        if (inbound) {
            str = ThreadLooperPrinter2.STOP_PREFIX;
        } else {
            str = ThreadLooperPrinter2.START_PREFIX;
        }
        return Util.format("%s 0x%08x %5d %-13s %s", str, Integer.valueOf(streamId), Integer.valueOf(length), formattedType$okhttp, formatFlags);
    }
}
