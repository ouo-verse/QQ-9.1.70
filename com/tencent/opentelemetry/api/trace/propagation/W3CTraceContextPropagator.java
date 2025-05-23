package com.tencent.opentelemetry.api.trace.propagation;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.internal.OtelEncodingUtils;
import com.tencent.opentelemetry.api.internal.TemporaryBuffers;
import com.tencent.opentelemetry.api.internal.Utils;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.api.trace.SpanContext;
import com.tencent.opentelemetry.api.trace.SpanId;
import com.tencent.opentelemetry.api.trace.TraceId;
import com.tencent.opentelemetry.api.trace.TraceState;
import com.tencent.opentelemetry.api.trace.TraceStateBuilder;
import com.tencent.opentelemetry.api.trace.b;
import com.tencent.opentelemetry.api.trace.e;
import com.tencent.opentelemetry.api.trace.f;
import com.tencent.opentelemetry.api.trace.g;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.context.propagation.TextMapGetter;
import com.tencent.opentelemetry.context.propagation.TextMapPropagator;
import com.tencent.opentelemetry.context.propagation.TextMapSetter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* loaded from: classes22.dex */
public final class W3CTraceContextPropagator implements TextMapPropagator {
    static IPatchRedirector $redirector_ = null;
    private static final W3CTraceContextPropagator INSTANCE;
    private static final int SPAN_ID_HEX_SIZE;
    private static final int SPAN_ID_OFFSET;
    private static final String TAG;
    private static final char TRACEPARENT_DELIMITER = '-';
    private static final int TRACEPARENT_DELIMITER_SIZE = 1;
    private static final int TRACEPARENT_HEADER_SIZE;
    private static final char TRACESTATE_ENTRY_DELIMITER = ',';
    private static final Pattern TRACESTATE_ENTRY_DELIMITER_SPLIT_PATTERN;
    private static final char TRACESTATE_KEY_VALUE_DELIMITER = '=';
    private static final int TRACESTATE_MAX_MEMBERS = 32;
    private static final int TRACESTATE_MAX_SIZE = 512;
    private static final int TRACE_ID_HEX_SIZE;
    private static final int TRACE_ID_OFFSET = 3;
    private static final int TRACE_OPTION_HEX_SIZE;
    private static final int TRACE_OPTION_OFFSET;
    public static final String TRACE_PARENT = "traceparent";
    public static final String TRACE_STATE = "tracestate";
    private static final Set<String> VALID_VERSIONS;
    private static final String VERSION = "00";
    private static final String VERSION_00 = "00";
    private static final int VERSION_SIZE = 2;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16414);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        TAG = W3CTraceContextPropagator.class.getName();
        int length = TraceId.getLength();
        TRACE_ID_HEX_SIZE = length;
        int length2 = SpanId.getLength();
        SPAN_ID_HEX_SIZE = length2;
        int d16 = f.d();
        TRACE_OPTION_HEX_SIZE = d16;
        int i3 = length + 3 + 1;
        SPAN_ID_OFFSET = i3;
        int i16 = i3 + length2 + 1;
        TRACE_OPTION_OFFSET = i16;
        TRACEPARENT_HEADER_SIZE = i16 + d16;
        TRACESTATE_ENTRY_DELIMITER_SPLIT_PATTERN = Pattern.compile("[ \t]*,[ \t]*");
        INSTANCE = new W3CTraceContextPropagator();
        VALID_VERSIONS = new HashSet();
        for (int i17 = 0; i17 < 255; i17++) {
            String hexString = Long.toHexString(i17);
            if (hexString.length() < 2) {
                hexString = '0' + hexString;
            }
            VALID_VERSIONS.add(hexString);
        }
    }

    W3CTraceContextPropagator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static SpanContext extractContextFromTraceParent(String str) {
        boolean z16;
        int length = str.length();
        int i3 = TRACEPARENT_HEADER_SIZE;
        if ((length == i3 || (str.length() > i3 && str.charAt(i3) == '-')) && str.charAt(2) == '-' && str.charAt(SPAN_ID_OFFSET - 1) == '-' && str.charAt(TRACE_OPTION_OFFSET - 1) == '-') {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.e(TAG, "Unparseable traceparent header. Returning INVALID span context.");
            }
            return e.g();
        }
        String substring = str.substring(0, 2);
        if (!VALID_VERSIONS.contains(substring)) {
            return e.g();
        }
        if (substring.equals("00") && str.length() > i3) {
            return e.g();
        }
        String substring2 = str.substring(3, TraceId.getLength() + 3);
        int i16 = SPAN_ID_OFFSET;
        String substring3 = str.substring(i16, SpanId.getLength() + i16);
        int i17 = TRACE_OPTION_OFFSET;
        char charAt = str.charAt(i17);
        char charAt2 = str.charAt(i17 + 1);
        if (OtelEncodingUtils.isValidBase16Character(charAt) && OtelEncodingUtils.isValidBase16Character(charAt2)) {
            return e.f(substring2, substring3, f.a(OtelEncodingUtils.byteFromBase16(charAt, charAt2)), g.b());
        }
        return e.g();
    }

    private static <C> SpanContext extractImpl(@Nullable C c16, TextMapGetter<C> textMapGetter) {
        String str = textMapGetter.get(c16, TRACE_PARENT);
        if (str == null) {
            return e.g();
        }
        SpanContext extractContextFromTraceParent = extractContextFromTraceParent(str);
        if (!extractContextFromTraceParent.isValid()) {
            return extractContextFromTraceParent;
        }
        String str2 = textMapGetter.get(c16, TRACE_STATE);
        if (str2 != null && !str2.isEmpty()) {
            try {
                return e.f(extractContextFromTraceParent.getTraceId(), extractContextFromTraceParent.getSpanId(), extractContextFromTraceParent.getTraceFlags(), extractTraceState(str2));
            } catch (IllegalArgumentException unused) {
                if (DefaultPrintLogger.isDebug()) {
                    DefaultPrintLogger.e(TAG, "Unparseable tracestate header. Returning span context without state.");
                }
            }
        }
        return extractContextFromTraceParent;
    }

    private static TraceState extractTraceState(String str) {
        boolean z16;
        boolean z17;
        TraceStateBuilder a16 = g.a();
        String[] split = TRACESTATE_ENTRY_DELIMITER_SPLIT_PATTERN.split(str);
        if (split.length <= 32) {
            z16 = true;
        } else {
            z16 = false;
        }
        Utils.checkArgument(z16, "TraceState has too many elements.");
        for (int length = split.length - 1; length >= 0; length--) {
            String str2 = split[length];
            int indexOf = str2.indexOf(61);
            if (indexOf != -1) {
                z17 = true;
            } else {
                z17 = false;
            }
            Utils.checkArgument(z17, "Invalid TraceState list-member format.");
            a16.put(str2.substring(0, indexOf), str2.substring(indexOf + 1));
        }
        TraceState build = a16.build();
        if (build.size() != split.length) {
            return g.b();
        }
        return build;
    }

    public static W3CTraceContextPropagator getInstance() {
        return INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$injectImpl$0(StringBuilder sb5, String str, String str2) {
        if (sb5.length() != 0) {
            sb5.append(TRACESTATE_ENTRY_DELIMITER);
        }
        sb5.append(str);
        sb5.append(TRACESTATE_KEY_VALUE_DELIMITER);
        sb5.append(str2);
    }

    @Override // com.tencent.opentelemetry.context.propagation.TextMapPropagator
    public <C> Context extract(Context context, @Nullable C c16, TextMapGetter<C> textMapGetter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Context) iPatchRedirector.redirect((short) 5, this, context, c16, textMapGetter);
        }
        if (context == null) {
            return com.tencent.opentelemetry.context.e.m();
        }
        if (textMapGetter == null) {
            return context;
        }
        SpanContext extractImpl = extractImpl(c16, textMapGetter);
        if (!extractImpl.isValid()) {
            return context;
        }
        return context.with(b.t(extractImpl));
    }

    @Override // com.tencent.opentelemetry.context.propagation.TextMapPropagator
    public Collection<String> fields() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Collection) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(TRACE_PARENT);
        arrayList.add(TRACE_STATE);
        return arrayList;
    }

    @Override // com.tencent.opentelemetry.context.propagation.TextMapPropagator
    public <C> void inject(Context context, @Nullable C c16, TextMapSetter<C> textMapSetter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, c16, textMapSetter);
            return;
        }
        if (context != null && textMapSetter != null) {
            SpanContext spanContext = b.q(context).getSpanContext();
            if (!spanContext.isValid()) {
                return;
            }
            injectImpl(spanContext, c16, textMapSetter);
        }
    }

    public <C> void injectImpl(SpanContext spanContext, @Nullable C c16, TextMapSetter<C> textMapSetter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, spanContext, c16, textMapSetter);
            return;
        }
        int i3 = TRACEPARENT_HEADER_SIZE;
        char[] chars = TemporaryBuffers.chars(i3);
        chars[0] = "00".charAt(0);
        chars[1] = "00".charAt(1);
        chars[2] = TRACEPARENT_DELIMITER;
        String traceId = spanContext.getTraceId();
        traceId.getChars(0, traceId.length(), chars, 3);
        int i16 = SPAN_ID_OFFSET;
        chars[i16 - 1] = TRACEPARENT_DELIMITER;
        String spanId = spanContext.getSpanId();
        spanId.getChars(0, spanId.length(), chars, i16);
        int i17 = TRACE_OPTION_OFFSET;
        chars[i17 - 1] = TRACEPARENT_DELIMITER;
        String asHex = spanContext.getTraceFlags().asHex();
        chars[i17] = asHex.charAt(0);
        chars[i17 + 1] = asHex.charAt(1);
        textMapSetter.set(c16, TRACE_PARENT, new String(chars, 0, i3));
        TraceState traceState = spanContext.getTraceState();
        if (traceState.isEmpty()) {
            return;
        }
        final StringBuilder sb5 = new StringBuilder(512);
        traceState.forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.api.trace.propagation.a
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                W3CTraceContextPropagator.lambda$injectImpl$0(sb5, (String) obj, (String) obj2);
            }
        });
        textMapSetter.set(c16, TRACE_STATE, sb5.toString());
    }
}
