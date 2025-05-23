package com.tencent.kuikly.core.nvi.serialization.json;

import com.tencent.ark.ark;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000eR\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/kuikly/core/nvi/serialization/json/f;", "", "", "a", "", "message", "Lcom/tencent/kuikly/core/nvi/serialization/json/JSONException;", "j", "", "i", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", h.F, "Lcom/tencent/kuikly/core/nvi/serialization/json/b;", "e", "", "f", "g", "excluded", "c", "d", "quote", "b", "Ljava/lang/String;", "jsonStr", "I", com.tencent.luggage.wxa.c8.c.G, ark.ARKMETADATA_JSON, "<init>", "(Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String jsonStr;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int pos;

    public f(String json) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(json, "json");
        this.jsonStr = json;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(json, "\ufeff", false, 2, null);
        if (startsWith$default) {
            String substring = this.jsonStr.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            this.jsonStr = substring;
        }
    }

    private final int a() throws JSONException {
        int indexOf$default;
        while (this.pos < this.jsonStr.length()) {
            String str = this.jsonStr;
            int i3 = this.pos;
            this.pos = i3 + 1;
            char charAt = str.charAt(i3);
            if (!(((charAt == '\t' || charAt == ' ') || charAt == '\n') || charAt == '\r')) {
                if (charAt == '/') {
                    if (this.pos == this.jsonStr.length()) {
                        return charAt;
                    }
                    char charAt2 = this.jsonStr.charAt(this.pos);
                    if (charAt2 == '*') {
                        int i16 = this.pos + 1;
                        this.pos = i16;
                        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) this.jsonStr, "*/", i16, false, 4, (Object) null);
                        if (indexOf$default != -1) {
                            this.pos = indexOf$default + 2;
                        } else {
                            throw j("Unterminated comment");
                        }
                    } else {
                        if (charAt2 != '/') {
                            return charAt;
                        }
                        this.pos++;
                        i();
                    }
                } else {
                    if (charAt != '#') {
                        return charAt;
                    }
                    i();
                }
            }
        }
        return -1;
    }

    private final String c(String excluded) {
        int indexOf$default;
        int i3 = this.pos;
        while (this.pos < this.jsonStr.length()) {
            char charAt = this.jsonStr.charAt(this.pos);
            if (charAt != '\r' && charAt != '\n') {
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) excluded, charAt, 0, false, 6, (Object) null);
                if (indexOf$default == -1) {
                    this.pos++;
                }
            }
            String substring = this.jsonStr.substring(i3, this.pos);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return substring;
        }
        String substring2 = this.jsonStr.substring(i3);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        return substring2;
    }

    private final b e() throws JSONException {
        b bVar = new b();
        while (true) {
            int a16 = a();
            if (a16 == -1) {
                throw j("Unterminated array");
            }
            if (a16 != 44 && a16 != 59) {
                if (a16 == 93) {
                    return bVar;
                }
                this.pos--;
                bVar.t(d());
                int a17 = a();
                if (a17 != 44 && a17 != 59) {
                    if (a17 == 93) {
                        return bVar;
                    }
                    throw j("Unterminated array");
                }
            }
        }
    }

    private final char f() throws JSONException {
        int checkRadix;
        String str = this.jsonStr;
        int i3 = this.pos;
        this.pos = i3 + 1;
        char charAt = str.charAt(i3);
        if (charAt != 'u') {
            if (charAt == 't') {
                return '\t';
            }
            if (charAt == 'b') {
                return '\b';
            }
            if (charAt == 'n') {
                return '\n';
            }
            if (charAt == 'r') {
                return '\r';
            }
            if (charAt == 'f') {
                return '\f';
            }
            return (charAt != '\'' && charAt == '\"') ? charAt : charAt;
        }
        if (this.pos + 4 <= this.jsonStr.length()) {
            String str2 = this.jsonStr;
            int i16 = this.pos;
            String substring = str2.substring(i16, i16 + 4);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            this.pos += 4;
            try {
                checkRadix = CharsKt__CharJVMKt.checkRadix(16);
                return (char) Integer.parseInt(substring, checkRadix);
            } catch (NumberFormatException unused) {
                throw j("Invalid escape sequence: " + substring);
            }
        }
        throw j("Unterminated escape sequence");
    }

    private final Object g() throws JSONException {
        int indexOf$default;
        boolean startsWith$default;
        String substring;
        int i3;
        int checkRadix;
        long parseLong;
        boolean startsWith$default2;
        boolean startsWith$default3;
        String c16 = c("{}[]/\\:,=;# \t");
        if (!(c16.length() == 0)) {
            if (Intrinsics.areEqual("true", c16)) {
                return Boolean.TRUE;
            }
            if (Intrinsics.areEqual("false", c16)) {
                return Boolean.FALSE;
            }
            if (Intrinsics.areEqual("null", c16)) {
                return null;
            }
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) c16, '.', 0, false, 6, (Object) null);
            if (indexOf$default == -1) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(c16, RelationNTPushServiceImpl.PRE_HEX_STRING, false, 2, null);
                try {
                    if (!startsWith$default) {
                        startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(c16, "0X", false, 2, null);
                        if (!startsWith$default2) {
                            startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(c16, "0", false, 2, null);
                            if (!startsWith$default3 || c16.length() <= 1) {
                                i3 = 10;
                                substring = c16;
                            } else {
                                substring = c16.substring(1);
                                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                                i3 = 8;
                            }
                            checkRadix = CharsKt__CharJVMKt.checkRadix(i3);
                            parseLong = Long.parseLong(substring, checkRadix);
                            if (parseLong > TTL.MAX_VALUE && parseLong >= WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                                return Integer.valueOf((int) parseLong);
                            }
                            return Long.valueOf(parseLong);
                        }
                    }
                    checkRadix = CharsKt__CharJVMKt.checkRadix(i3);
                    parseLong = Long.parseLong(substring, checkRadix);
                    if (parseLong > TTL.MAX_VALUE) {
                    }
                    return Long.valueOf(parseLong);
                } catch (NumberFormatException unused) {
                }
                substring = c16.substring(2);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                i3 = 16;
            }
            try {
                return Double.valueOf(Double.parseDouble(c16));
            } catch (NumberFormatException unused2) {
                return c16 + "";
            }
        }
        throw j("Expected literal value");
    }

    private final e h() throws JSONException {
        String simpleName;
        e eVar = new e();
        int a16 = a();
        if (a16 == 125) {
            return eVar;
        }
        if (a16 != -1) {
            this.pos--;
        }
        while (true) {
            Object d16 = d();
            if (!(d16 instanceof String)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Names must be strings, but ");
                sb5.append(d16);
                sb5.append(" is of type ");
                if (d16 == null) {
                    simpleName = "null";
                } else {
                    simpleName = Reflection.getOrCreateKotlinClass(d16.getClass()).getSimpleName();
                }
                sb5.append(simpleName);
                throw j(sb5.toString());
            }
            int a17 = a();
            if (a17 != 58 && a17 != 61) {
                throw j("Expected ':' after " + d16);
            }
            if (this.pos < this.jsonStr.length() && Character.valueOf(this.jsonStr.charAt(this.pos)).equals(Character.valueOf(Typography.greater))) {
                this.pos++;
            }
            eVar.v((String) d16, d());
            int a18 = a();
            if (a18 != 44 && a18 != 59) {
                if (a18 == 125) {
                    return eVar;
                }
                throw j("Unterminated object");
            }
        }
    }

    private final void i() {
        while (this.pos < this.jsonStr.length()) {
            char charAt = this.jsonStr.charAt(this.pos);
            if (charAt != '\r' && charAt != '\n') {
                this.pos++;
            } else {
                this.pos++;
                return;
            }
        }
    }

    private final JSONException j(String message) {
        return new JSONException(message + this);
    }

    public final String b(char quote) throws JSONException {
        int i3 = this.pos;
        StringBuilder sb5 = null;
        while (this.pos < this.jsonStr.length()) {
            String str = this.jsonStr;
            int i16 = this.pos;
            this.pos = i16 + 1;
            char charAt = str.charAt(i16);
            if (charAt == quote) {
                if (sb5 == null) {
                    StringBuilder sb6 = new StringBuilder();
                    String substring = this.jsonStr.substring(i3, this.pos - 1);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    sb6.append(substring);
                    sb6.append("");
                    return sb6.toString();
                }
                sb5.append((CharSequence) this.jsonStr, i3, this.pos - 1);
                String sb7 = sb5.toString();
                Intrinsics.checkNotNullExpressionValue(sb7, "{\n                    bu\u2026tring()\n                }");
                return sb7;
            }
            if (charAt == '\\') {
                if (this.pos != this.jsonStr.length()) {
                    if (sb5 == null) {
                        sb5 = new StringBuilder();
                    }
                    sb5.append((CharSequence) this.jsonStr, i3, this.pos - 1);
                    sb5.append(f());
                    i3 = this.pos;
                } else {
                    throw j("Unterminated escape sequence");
                }
            }
        }
        throw j("Unterminated string");
    }

    public final Object d() throws JSONException {
        int a16 = a();
        if (a16 == -1) {
            throw j("End of input");
        }
        if (a16 == 34 || a16 == 39) {
            return b((char) a16);
        }
        if (a16 == 91) {
            return e();
        }
        if (a16 != 123) {
            this.pos--;
            return g();
        }
        return h();
    }
}
