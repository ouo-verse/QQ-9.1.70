package com.tencent.opentelemetry.context.propagation;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.context.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes22.dex */
final class MultiTextMapPropagator implements TextMapPropagator {
    static IPatchRedirector $redirector_;
    private final Collection<String> allFields;
    private final TextMapPropagator[] textPropagators;

    MultiTextMapPropagator(TextMapPropagator... textMapPropagatorArr) {
        this((List<TextMapPropagator>) Arrays.asList(textMapPropagatorArr));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) textMapPropagatorArr);
    }

    private static List<String> getAllFields(TextMapPropagator[] textMapPropagatorArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (TextMapPropagator textMapPropagator : textMapPropagatorArr) {
            linkedHashSet.addAll(textMapPropagator.fields());
        }
        return new ArrayList(linkedHashSet);
    }

    @Override // com.tencent.opentelemetry.context.propagation.TextMapPropagator
    public <C> Context extract(Context context, @Nullable C c16, TextMapGetter<C> textMapGetter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Context) iPatchRedirector.redirect((short) 5, this, context, c16, textMapGetter);
        }
        if (context == null) {
            return e.m();
        }
        if (textMapGetter == null) {
            return context;
        }
        for (TextMapPropagator textMapPropagator : this.textPropagators) {
            context = textMapPropagator.extract(context, c16, textMapGetter);
        }
        return context;
    }

    @Override // com.tencent.opentelemetry.context.propagation.TextMapPropagator
    public Collection<String> fields() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Collection) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.allFields;
    }

    @Override // com.tencent.opentelemetry.context.propagation.TextMapPropagator
    public <C> void inject(Context context, @Nullable C c16, TextMapSetter<C> textMapSetter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, c16, textMapSetter);
            return;
        }
        if (context != null && textMapSetter != null) {
            for (TextMapPropagator textMapPropagator : this.textPropagators) {
                textMapPropagator.inject(context, c16, textMapSetter);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiTextMapPropagator(List<TextMapPropagator> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            return;
        }
        TextMapPropagator[] textMapPropagatorArr = new TextMapPropagator[list.size()];
        this.textPropagators = textMapPropagatorArr;
        list.toArray(textMapPropagatorArr);
        this.allFields = Collections.unmodifiableList(getAllFields(textMapPropagatorArr));
    }
}
