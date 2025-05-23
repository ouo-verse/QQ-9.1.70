package com.tencent.opentelemetry.sdk.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.internal.debug.SourceInfo;
import com.tencent.opentelemetry.sdk.metrics.internal.view.AttributesProcessor;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class AutoValue_View extends View {
    static IPatchRedirector $redirector_;
    private final Aggregation aggregation;
    private final AttributesProcessor attributesProcessor;
    private final String description;
    private final String name;
    private final SourceInfo sourceInfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_View(@Nullable String str, @Nullable String str2, Aggregation aggregation, AttributesProcessor attributesProcessor, SourceInfo sourceInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, aggregation, attributesProcessor, sourceInfo);
            return;
        }
        this.name = str;
        this.description = str2;
        if (aggregation != null) {
            this.aggregation = aggregation;
            if (attributesProcessor != null) {
                this.attributesProcessor = attributesProcessor;
                if (sourceInfo != null) {
                    this.sourceInfo = sourceInfo;
                    return;
                }
                throw new NullPointerException("Null sourceInfo");
            }
            throw new NullPointerException("Null attributesProcessor");
        }
        throw new NullPointerException("Null aggregation");
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof View)) {
            return false;
        }
        View view = (View) obj;
        String str = this.name;
        if (str != null ? str.equals(view.getName()) : view.getName() == null) {
            String str2 = this.description;
            if (str2 != null ? str2.equals(view.getDescription()) : view.getDescription() == null) {
                if (this.aggregation.equals(view.getAggregation()) && this.attributesProcessor.equals(view.getAttributesProcessor()) && this.sourceInfo.equals(view.getSourceInfo())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.View
    public Aggregation getAggregation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Aggregation) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.aggregation;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.View
    public AttributesProcessor getAttributesProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AttributesProcessor) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.attributesProcessor;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.View
    @Nullable
    public String getDescription() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.description;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.View
    @Nullable
    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.name;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.View
    public SourceInfo getSourceInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SourceInfo) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.sourceInfo;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        String str = this.name;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode ^ 1000003) * 1000003;
        String str2 = this.description;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return ((((((i16 ^ i3) * 1000003) ^ this.aggregation.hashCode()) * 1000003) ^ this.attributesProcessor.hashCode()) * 1000003) ^ this.sourceInfo.hashCode();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "View{name=" + this.name + ", description=" + this.description + ", aggregation=" + this.aggregation + ", attributesProcessor=" + this.attributesProcessor + ", sourceInfo=" + this.sourceInfo + "}";
    }
}
