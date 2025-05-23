package com.tencent.opentelemetry.sdk.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.sdk.metrics.internal.view.AttributesProcessor;
import com.tencent.opentelemetry.sdk.metrics.internal.view.StringPredicates;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ViewBuilder {
    static IPatchRedirector $redirector_;
    private Aggregation aggregation;
    private String description;
    private String name;
    private AttributesProcessor processor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.name = null;
        this.description = null;
        this.aggregation = b.a();
        this.processor = AttributesProcessor.noop();
    }

    public ViewBuilder appendAllBaggageAttributes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ViewBuilder) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return appendFilteredBaggageAttributes(StringPredicates.ALL);
    }

    public ViewBuilder appendAttributes(Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ViewBuilder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) attributes);
        }
        this.processor = this.processor.then(AttributesProcessor.append(attributes));
        return this;
    }

    public ViewBuilder appendFilteredBaggageAttributes(Predicate<String> predicate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ViewBuilder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) predicate);
        }
        this.processor = this.processor.then(AttributesProcessor.appendBaggageByKeyName(predicate));
        return this;
    }

    public ViewBuilder appendFilteredBaggageAttributesByPattern(Pattern pattern) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ViewBuilder) iPatchRedirector.redirect((short) 10, (Object) this, (Object) pattern);
        }
        this.processor = this.processor.then(AttributesProcessor.appendBaggageByKeyName(StringPredicates.regex(pattern)));
        return this;
    }

    public View build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (View) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return View.create(this.name, this.description, this.aggregation, this.processor);
    }

    public ViewBuilder filterAttributes(Predicate<String> predicate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ViewBuilder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) predicate);
        }
        this.processor = this.processor.then(AttributesProcessor.filterByKeyName(predicate));
        return this;
    }

    public ViewBuilder setAggregation(Aggregation aggregation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ViewBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aggregation);
        }
        this.aggregation = aggregation;
        return this;
    }

    public ViewBuilder setAttributesProcessor(AttributesProcessor attributesProcessor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ViewBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) attributesProcessor);
        }
        this.processor = attributesProcessor;
        return this;
    }

    public ViewBuilder setDescription(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ViewBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        this.description = str;
        return this;
    }

    public ViewBuilder setName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ViewBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        this.name = str;
        return this;
    }

    public ViewBuilder filterAttributes(Pattern pattern) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ViewBuilder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) pattern);
        }
        this.processor = this.processor.then(AttributesProcessor.filterByKeyName(StringPredicates.regex(pattern)));
        return this;
    }
}
