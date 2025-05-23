package com.tencent.opentelemetry.api.baggage.propagation;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.baggage.Baggage;
import com.tencent.opentelemetry.api.baggage.BaggageBuilder;
import com.tencent.opentelemetry.api.baggage.BaggageEntry;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.context.e;
import com.tencent.opentelemetry.context.propagation.TextMapGetter;
import com.tencent.opentelemetry.context.propagation.TextMapPropagator;
import com.tencent.opentelemetry.context.propagation.TextMapSetter;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import javax.annotation.Nullable;

/* loaded from: classes22.dex */
public class W3CBaggagePropagator implements TextMapPropagator {
    static IPatchRedirector $redirector_ = null;
    private static final String FIELD = "baggage";
    private static final List<String> FIELDS;
    private static final W3CBaggagePropagator INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15860);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            FIELDS = Collections.singletonList(FIELD);
            INSTANCE = new W3CBaggagePropagator();
        }
    }

    W3CBaggagePropagator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void extractEntries(String str, BaggageBuilder baggageBuilder) {
        new Parser(str).parseInto(baggageBuilder);
    }

    public static W3CBaggagePropagator getInstance() {
        return INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$inject$0(StringBuilder sb5, String str, BaggageEntry baggageEntry) {
        sb5.append(str);
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(baggageEntry.getValue());
        String value = baggageEntry.getMetadata().getValue();
        if (value != null && !value.isEmpty()) {
            sb5.append(";");
            sb5.append(value);
        }
        sb5.append(",");
    }

    @Override // com.tencent.opentelemetry.context.propagation.TextMapPropagator
    public <C> Context extract(Context context, @Nullable C c16, TextMapGetter<C> textMapGetter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Context) iPatchRedirector.redirect((short) 4, this, context, c16, textMapGetter);
        }
        if (context == null) {
            return e.m();
        }
        if (textMapGetter == null) {
            return context;
        }
        String str = textMapGetter.get(c16, FIELD);
        if (str == null) {
            return context;
        }
        if (str.isEmpty()) {
            return context;
        }
        BaggageBuilder c17 = com.tencent.opentelemetry.api.baggage.a.c();
        try {
            extractEntries(str, c17);
            return context.with(c17.build());
        } catch (RuntimeException unused) {
            return context;
        }
    }

    @Override // com.tencent.opentelemetry.context.propagation.TextMapPropagator
    public Collection<String> fields() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Collection) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return FIELDS;
    }

    @Override // com.tencent.opentelemetry.context.propagation.TextMapPropagator
    public <C> void inject(Context context, @Nullable C c16, TextMapSetter<C> textMapSetter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, c16, textMapSetter);
            return;
        }
        if (context != null && textMapSetter != null) {
            Baggage f16 = com.tencent.opentelemetry.api.baggage.a.f(context);
            if (f16.isEmpty()) {
                return;
            }
            final StringBuilder sb5 = new StringBuilder();
            f16.forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.api.baggage.propagation.a
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    W3CBaggagePropagator.lambda$inject$0(sb5, (String) obj, (BaggageEntry) obj2);
                }
            });
            if (sb5.length() > 0) {
                sb5.setLength(sb5.length() - 1);
                textMapSetter.set(c16, FIELD, sb5.toString());
            }
        }
    }
}
