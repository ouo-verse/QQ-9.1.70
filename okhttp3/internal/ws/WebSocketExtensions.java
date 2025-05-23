package okhttp3.internal.ws;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Headers;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nJ\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003JN\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00d6\u0001J\u000e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lokhttp3/internal/ws/WebSocketExtensions;", "", "perMessageDeflate", "", "clientMaxWindowBits", "", "clientNoContextTakeover", "serverMaxWindowBits", "serverNoContextTakeover", "unknownValues", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)V", "Ljava/lang/Integer;", "component1", "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "component6", "copy", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)Lokhttp3/internal/ws/WebSocketExtensions;", "equals", "other", "hashCode", "noContextTakeover", "clientOriginated", "toString", "", "Companion", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes22.dex */
public final /* data */ class WebSocketExtensions {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";

    @JvmField
    @Nullable
    public final Integer clientMaxWindowBits;

    @JvmField
    public final boolean clientNoContextTakeover;

    @JvmField
    public final boolean perMessageDeflate;

    @JvmField
    @Nullable
    public final Integer serverMaxWindowBits;

    @JvmField
    public final boolean serverNoContextTakeover;

    @JvmField
    public final boolean unknownValues;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lokhttp3/internal/ws/WebSocketExtensions$Companion;", "", "()V", "HEADER_WEB_SOCKET_EXTENSION", "", "parse", "Lokhttp3/internal/ws/WebSocketExtensions;", "responseHeaders", "Lokhttp3/Headers;", "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes22.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final WebSocketExtensions parse(@NotNull Headers responseHeaders) throws IOException {
            boolean equals;
            boolean equals2;
            String str;
            boolean equals3;
            boolean equals4;
            boolean equals5;
            boolean equals6;
            Integer intOrNull;
            Integer intOrNull2;
            Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
            int size = responseHeaders.size();
            boolean z16 = false;
            Integer num = null;
            boolean z17 = false;
            Integer num2 = null;
            boolean z18 = false;
            boolean z19 = false;
            for (int i3 = 0; i3 < size; i3++) {
                equals = StringsKt__StringsJVMKt.equals(responseHeaders.name(i3), WebSocketExtensions.HEADER_WEB_SOCKET_EXTENSION, true);
                if (equals) {
                    String value = responseHeaders.value(i3);
                    int i16 = 0;
                    while (i16 < value.length()) {
                        int delimiterOffset$default = Util.delimiterOffset$default(value, ',', i16, 0, 4, (Object) null);
                        int delimiterOffset = Util.delimiterOffset(value, ';', i16, delimiterOffset$default);
                        String trimSubstring = Util.trimSubstring(value, i16, delimiterOffset);
                        int i17 = delimiterOffset + 1;
                        equals2 = StringsKt__StringsJVMKt.equals(trimSubstring, "permessage-deflate", true);
                        if (equals2) {
                            if (z16) {
                                z19 = true;
                            }
                            while (i17 < delimiterOffset$default) {
                                int delimiterOffset2 = Util.delimiterOffset(value, ';', i17, delimiterOffset$default);
                                int delimiterOffset3 = Util.delimiterOffset(value, '=', i17, delimiterOffset2);
                                String trimSubstring2 = Util.trimSubstring(value, i17, delimiterOffset3);
                                if (delimiterOffset3 < delimiterOffset2) {
                                    str = StringsKt__StringsKt.removeSurrounding(Util.trimSubstring(value, delimiterOffset3 + 1, delimiterOffset2), (CharSequence) "\"");
                                } else {
                                    str = null;
                                }
                                int i18 = delimiterOffset2 + 1;
                                equals3 = StringsKt__StringsJVMKt.equals(trimSubstring2, "client_max_window_bits", true);
                                if (!equals3) {
                                    equals4 = StringsKt__StringsJVMKt.equals(trimSubstring2, "client_no_context_takeover", true);
                                    if (!equals4) {
                                        equals5 = StringsKt__StringsJVMKt.equals(trimSubstring2, "server_max_window_bits", true);
                                        if (!equals5) {
                                            equals6 = StringsKt__StringsJVMKt.equals(trimSubstring2, "server_no_context_takeover", true);
                                            if (equals6) {
                                                if (z18) {
                                                    z19 = true;
                                                }
                                                if (str != null) {
                                                    z19 = true;
                                                }
                                                z18 = true;
                                            }
                                            z19 = true;
                                        } else {
                                            if (num2 != null) {
                                                z19 = true;
                                            }
                                            if (str != null) {
                                                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
                                                num2 = intOrNull;
                                            } else {
                                                num2 = null;
                                            }
                                            if (num2 != null) {
                                            }
                                            z19 = true;
                                        }
                                    } else {
                                        if (z17) {
                                            z19 = true;
                                        }
                                        if (str != null) {
                                            z19 = true;
                                        }
                                        z17 = true;
                                    }
                                    i17 = i18;
                                } else {
                                    if (num != null) {
                                        z19 = true;
                                    }
                                    if (str != null) {
                                        intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
                                        num = intOrNull2;
                                    } else {
                                        num = null;
                                    }
                                    if (num != null) {
                                        i17 = i18;
                                    }
                                    z19 = true;
                                    i17 = i18;
                                }
                            }
                            i16 = i17;
                            z16 = true;
                        } else {
                            i16 = i17;
                            z19 = true;
                        }
                    }
                }
            }
            return new WebSocketExtensions(z16, num, z17, num2, z18, z19);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WebSocketExtensions() {
        this(false, null, false, null, false, false, 63, null);
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z16, Integer num, boolean z17, Integer num2, boolean z18, boolean z19, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = webSocketExtensions.perMessageDeflate;
        }
        if ((i3 & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        Integer num3 = num;
        if ((i3 & 4) != 0) {
            z17 = webSocketExtensions.clientNoContextTakeover;
        }
        boolean z26 = z17;
        if ((i3 & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        Integer num4 = num2;
        if ((i3 & 16) != 0) {
            z18 = webSocketExtensions.serverNoContextTakeover;
        }
        boolean z27 = z18;
        if ((i3 & 32) != 0) {
            z19 = webSocketExtensions.unknownValues;
        }
        return webSocketExtensions.copy(z16, num3, z26, num4, z27, z19);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getPerMessageDeflate() {
        return this.perMessageDeflate;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getClientMaxWindowBits() {
        return this.clientMaxWindowBits;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getClientNoContextTakeover() {
        return this.clientNoContextTakeover;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getServerMaxWindowBits() {
        return this.serverMaxWindowBits;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getServerNoContextTakeover() {
        return this.serverNoContextTakeover;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getUnknownValues() {
        return this.unknownValues;
    }

    @NotNull
    public final WebSocketExtensions copy(boolean perMessageDeflate, @Nullable Integer clientMaxWindowBits, boolean clientNoContextTakeover, @Nullable Integer serverMaxWindowBits, boolean serverNoContextTakeover, boolean unknownValues) {
        return new WebSocketExtensions(perMessageDeflate, clientMaxWindowBits, clientNoContextTakeover, serverMaxWindowBits, serverNoContextTakeover, unknownValues);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof WebSocketExtensions) {
                WebSocketExtensions webSocketExtensions = (WebSocketExtensions) other;
                if (this.perMessageDeflate != webSocketExtensions.perMessageDeflate || !Intrinsics.areEqual(this.clientMaxWindowBits, webSocketExtensions.clientMaxWindowBits) || this.clientNoContextTakeover != webSocketExtensions.clientNoContextTakeover || !Intrinsics.areEqual(this.serverMaxWindowBits, webSocketExtensions.serverMaxWindowBits) || this.serverNoContextTakeover != webSocketExtensions.serverNoContextTakeover || this.unknownValues != webSocketExtensions.unknownValues) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    public int hashCode() {
        int i3;
        boolean z16 = this.perMessageDeflate;
        int i16 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i17 = r06 * 31;
        Integer num = this.clientMaxWindowBits;
        int i18 = 0;
        if (num != null) {
            i3 = num.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = (i17 + i3) * 31;
        ?? r26 = this.clientNoContextTakeover;
        int i26 = r26;
        if (r26 != 0) {
            i26 = 1;
        }
        int i27 = (i19 + i26) * 31;
        Integer num2 = this.serverMaxWindowBits;
        if (num2 != null) {
            i18 = num2.hashCode();
        }
        int i28 = (i27 + i18) * 31;
        ?? r27 = this.serverNoContextTakeover;
        int i29 = r27;
        if (r27 != 0) {
            i29 = 1;
        }
        int i36 = (i28 + i29) * 31;
        boolean z17 = this.unknownValues;
        if (!z17) {
            i16 = z17 ? 1 : 0;
        }
        return i36 + i16;
    }

    public final boolean noContextTakeover(boolean clientOriginated) {
        if (clientOriginated) {
            return this.clientNoContextTakeover;
        }
        return this.serverNoContextTakeover;
    }

    @NotNull
    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ")";
    }

    public WebSocketExtensions(boolean z16, @Nullable Integer num, boolean z17, @Nullable Integer num2, boolean z18, boolean z19) {
        this.perMessageDeflate = z16;
        this.clientMaxWindowBits = num;
        this.clientNoContextTakeover = z17;
        this.serverMaxWindowBits = num2;
        this.serverNoContextTakeover = z18;
        this.unknownValues = z19;
    }

    public /* synthetic */ WebSocketExtensions(boolean z16, Integer num, boolean z17, Integer num2, boolean z18, boolean z19, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? false : z17, (i3 & 8) == 0 ? num2 : null, (i3 & 16) != 0 ? false : z18, (i3 & 32) != 0 ? false : z19);
    }
}
