package com.tencent.opentelemetry.sdk.resources;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import javax.annotation.Nullable;

/* compiled from: P */
/* renamed from: com.tencent.opentelemetry.sdk.resources.$AutoValue_Resource, reason: invalid class name */
/* loaded from: classes22.dex */
abstract class C$AutoValue_Resource extends Resource {
    static IPatchRedirector $redirector_;
    private final Attributes attributes;
    private final String schemaUrl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C$AutoValue_Resource(@Nullable String str, Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) attributes);
            return;
        }
        this.schemaUrl = str;
        if (attributes != null) {
            this.attributes = attributes;
            return;
        }
        throw new NullPointerException("Null attributes");
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Resource)) {
            return false;
        }
        Resource resource = (Resource) obj;
        String str = this.schemaUrl;
        if (str != null ? str.equals(resource.getSchemaUrl()) : resource.getSchemaUrl() == null) {
            if (this.attributes.equals(resource.getAttributes())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.resources.Resource
    public Attributes getAttributes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Attributes) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.attributes;
    }

    @Override // com.tencent.opentelemetry.sdk.resources.Resource
    @Nullable
    public String getSchemaUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.schemaUrl;
    }

    @Override // com.tencent.opentelemetry.sdk.resources.Resource
    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        String str = this.schemaUrl;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((hashCode ^ 1000003) * 1000003) ^ this.attributes.hashCode();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "Resource{schemaUrl=" + this.schemaUrl + ", attributes=" + this.attributes + "}";
    }
}
