package com.tencent.kuikly.core.nvi.serialization.json;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.StringsKt__StringsKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0006\u0010\r\u001a\u00020\u0000J\b\u0010\u000e\u001a\u0004\u0018\u00010\u0000J\u0006\u0010\u000f\u001a\u00020\u0000J\u0006\u0010\u0010\u001a\u00020\u0000J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\nJ\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001J\u0016\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\nJ\u001e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\nJ\b\u0010\u001a\u001a\u00020\nH\u0016R$\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001bj\b\u0012\u0004\u0012\u00020\u0004`\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001dR\u0018\u0010\"\u001a\u00060\u001fj\u0002` 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/kuikly/core/nvi/serialization/json/JSONStringer;", "", "", "b", "Lcom/tencent/kuikly/core/nvi/serialization/json/JSONStringer$Scope;", "i", "topOfStack", "j", "g", "a", "", "value", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "e", "k", "d", "name", "f", DomainData.DOMAIN_NAME, GlobalUtil.DEF_STRING, "openBracket", h.F, "nonempty", "closeBracket", "c", "toString", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "stack", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Ljava/lang/StringBuilder;", "out", "<init>", "()V", "Scope", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class JSONStringer {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<Scope> stack = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final StringBuilder out = new StringBuilder();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/kuikly/core/nvi/serialization/json/JSONStringer$Scope;", "", "(Ljava/lang/String;I)V", "EMPTY_ARRAY", "NONEMPTY_ARRAY", "EMPTY_OBJECT", "DANGLING_KEY", "NONEMPTY_OBJECT", "NULL_OBJ", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public enum Scope {
        EMPTY_ARRAY,
        NONEMPTY_ARRAY,
        EMPTY_OBJECT,
        DANGLING_KEY,
        NONEMPTY_OBJECT,
        NULL_OBJ
    }

    private final void a() throws JSONException {
        Scope i3 = i();
        if (i3 == Scope.NONEMPTY_OBJECT) {
            this.out.append(',');
        } else if (i3 != Scope.EMPTY_OBJECT) {
            throw new JSONException("Nesting problem");
        }
        g();
        j(Scope.DANGLING_KEY);
    }

    private final void b() throws JSONException {
        if (this.stack.isEmpty()) {
            return;
        }
        Scope i3 = i();
        if (i3 == Scope.EMPTY_ARRAY) {
            j(Scope.NONEMPTY_ARRAY);
            g();
        } else if (i3 == Scope.NONEMPTY_ARRAY) {
            this.out.append(',');
            g();
        } else if (i3 == Scope.DANGLING_KEY) {
            this.out.append(MsgSummary.STR_COLON);
            j(Scope.NONEMPTY_OBJECT);
        } else if (i3 != Scope.NULL_OBJ) {
            throw new JSONException("Nesting problem");
        }
    }

    private final Scope i() throws JSONException {
        if (!this.stack.isEmpty()) {
            Scope scope = this.stack.get(r0.size() - 1);
            Intrinsics.checkNotNullExpressionValue(scope, "stack[stack.size - 1]");
            return scope;
        }
        throw new JSONException("Nesting problem");
    }

    private final void j(Scope topOfStack) {
        this.stack.set(r0.size() - 1, topOfStack);
    }

    private final void m(String value) {
        int checkRadix;
        String padStart;
        this.out.append("\"");
        int length = value.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = value.charAt(i3);
            boolean z16 = true;
            if (!(charAt == '\"' || charAt == '\\') && charAt != '/') {
                z16 = false;
            }
            if (z16) {
                StringBuilder sb5 = this.out;
                sb5.append('\\');
                sb5.append(charAt);
            } else if (charAt == '\t') {
                this.out.append("\\t");
            } else if (charAt == '\b') {
                this.out.append("\\b");
            } else if (charAt == '\n') {
                this.out.append(RedTouch.NEWLINE_CHAR);
            } else if (charAt == '\r') {
                this.out.append("\\r");
            } else if (charAt <= 31) {
                StringBuilder sb6 = this.out;
                StringBuilder sb7 = new StringBuilder();
                sb7.append("\\u");
                checkRadix = CharsKt__CharJVMKt.checkRadix(16);
                String num = Integer.toString(charAt, checkRadix);
                Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
                padStart = StringsKt__StringsKt.padStart(num, 4, '0');
                sb7.append(padStart);
                sb6.append(sb7.toString());
            } else {
                this.out.append(charAt);
            }
        }
        this.out.append("\"");
    }

    public final JSONStringer c(Scope empty, Scope nonempty, String closeBracket) throws JSONException {
        Intrinsics.checkNotNullParameter(empty, "empty");
        Intrinsics.checkNotNullParameter(nonempty, "nonempty");
        Intrinsics.checkNotNullParameter(closeBracket, "closeBracket");
        Scope i3 = i();
        if (i3 != nonempty && i3 != empty) {
            throw new JSONException("Nesting problem");
        }
        this.stack.remove(r3.size() - 1);
        if (i3 == nonempty) {
            g();
        }
        this.out.append(closeBracket);
        return this;
    }

    public final JSONStringer d() throws JSONException {
        return c(Scope.EMPTY_ARRAY, Scope.NONEMPTY_ARRAY, "]");
    }

    public final JSONStringer e() throws JSONException {
        return c(Scope.EMPTY_OBJECT, Scope.NONEMPTY_OBJECT, "}");
    }

    public final JSONStringer f(String name) throws JSONException {
        Intrinsics.checkNotNullParameter(name, "name");
        a();
        m(name);
        return this;
    }

    public final JSONStringer h(Scope empty, String openBracket) throws JSONException {
        Intrinsics.checkNotNullParameter(empty, "empty");
        Intrinsics.checkNotNullParameter(openBracket, "openBracket");
        if (this.stack.isEmpty()) {
            if (this.out.length() > 0) {
                throw new JSONException("Nesting problem: multiple top-level roots");
            }
        }
        b();
        this.stack.add(empty);
        this.out.append(openBracket);
        return this;
    }

    public final JSONStringer k() throws JSONException {
        return h(Scope.EMPTY_ARRAY, "[");
    }

    public final JSONStringer l() throws JSONException {
        return h(Scope.EMPTY_OBJECT, "{");
    }

    public final JSONStringer n(Object value) throws JSONException {
        if (!this.stack.isEmpty()) {
            if (value instanceof b) {
                ((b) value).x(this);
                return this;
            }
            if (value instanceof e) {
                ((e) value).E(this);
                return this;
            }
            b();
            if (value instanceof Boolean) {
                this.out.append(((Boolean) value).booleanValue());
            } else if (value instanceof Number) {
                this.out.append(a.f117418a.a((Number) value));
            } else if (value == null) {
                this.out.append("null");
            } else {
                m(value.toString());
            }
            return this;
        }
        throw new JSONException("Nesting problem");
    }

    public String toString() {
        if (this.out.length() == 0) {
            return "{}";
        }
        String sb5 = this.out.toString();
        Intrinsics.checkNotNullExpressionValue(sb5, "{\n            out.toString()\n        }");
        return sb5;
    }

    private final void g() {
    }
}
