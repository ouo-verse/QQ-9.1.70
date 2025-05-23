package okhttp3.internal.http;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.Protocol;
import okhttp3.Response;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lokhttp3/internal/http/StatusLine;", "", AudienceReportConst.PROTOCOL, "Lokhttp3/Protocol;", "code", "", "message", "", "(Lokhttp3/Protocol;ILjava/lang/String;)V", "toString", "Companion", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes28.dex */
public final class StatusLine {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_MISDIRECTED_REQUEST = 421;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;

    @JvmField
    public final int code;

    @JvmField
    @NotNull
    public final String message;

    @JvmField
    @NotNull
    public final Protocol protocol;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lokhttp3/internal/http/StatusLine$Companion;", "", "()V", "HTTP_CONTINUE", "", "HTTP_MISDIRECTED_REQUEST", "HTTP_PERM_REDIRECT", "HTTP_TEMP_REDIRECT", "get", "Lokhttp3/internal/http/StatusLine;", "response", "Lokhttp3/Response;", "parse", "statusLine", "", "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes28.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final StatusLine get(@NotNull Response response) {
            Intrinsics.checkNotNullParameter(response, "response");
            return new StatusLine(response.protocol(), response.code(), response.message());
        }

        @NotNull
        public final StatusLine parse(@NotNull String statusLine) throws IOException {
            boolean startsWith$default;
            boolean startsWith$default2;
            Protocol protocol2;
            int i3;
            String str;
            Intrinsics.checkNotNullParameter(statusLine, "statusLine");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(statusLine, "HTTP/1.", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(statusLine, "ICY ", false, 2, null);
                if (startsWith$default2) {
                    protocol2 = Protocol.HTTP_1_0;
                    i3 = 4;
                } else {
                    throw new ProtocolException("Unexpected status line: " + statusLine);
                }
            } else {
                i3 = 9;
                if (statusLine.length() >= 9 && statusLine.charAt(8) == ' ') {
                    int charAt = statusLine.charAt(7) - '0';
                    if (charAt == 0) {
                        protocol2 = Protocol.HTTP_1_0;
                    } else if (charAt == 1) {
                        protocol2 = Protocol.HTTP_1_1;
                    } else {
                        throw new ProtocolException("Unexpected status line: " + statusLine);
                    }
                } else {
                    throw new ProtocolException("Unexpected status line: " + statusLine);
                }
            }
            int i16 = i3 + 3;
            if (statusLine.length() >= i16) {
                try {
                    String substring = statusLine.substring(i3, i16);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    int parseInt = Integer.parseInt(substring);
                    if (statusLine.length() > i16) {
                        if (statusLine.charAt(i16) == ' ') {
                            str = statusLine.substring(i3 + 4);
                            Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).substring(startIndex)");
                        } else {
                            throw new ProtocolException("Unexpected status line: " + statusLine);
                        }
                    } else {
                        str = "";
                    }
                    return new StatusLine(protocol2, parseInt, str);
                } catch (NumberFormatException unused) {
                    throw new ProtocolException("Unexpected status line: " + statusLine);
                }
            }
            throw new ProtocolException("Unexpected status line: " + statusLine);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public StatusLine(@NotNull Protocol protocol2, int i3, @NotNull String message) {
        Intrinsics.checkNotNullParameter(protocol2, "protocol");
        Intrinsics.checkNotNullParameter(message, "message");
        this.protocol = protocol2;
        this.code = i3;
        this.message = message;
    }

    @NotNull
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.protocol == Protocol.HTTP_1_0) {
            sb5.append("HTTP/1.0");
        } else {
            sb5.append("HTTP/1.1");
        }
        sb5.append(TokenParser.SP);
        sb5.append(this.code);
        sb5.append(TokenParser.SP);
        sb5.append(this.message);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        return sb6;
    }
}
