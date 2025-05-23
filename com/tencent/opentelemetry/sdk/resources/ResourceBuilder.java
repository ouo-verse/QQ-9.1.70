package com.tencent.opentelemetry.sdk.resources;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.common.AttributesBuilder;
import com.tencent.opentelemetry.api.common.f;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ResourceBuilder {
    static IPatchRedirector $redirector_;
    private final AttributesBuilder attributesBuilder;

    @Nullable
    private String schemaUrl;

    public ResourceBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.attributesBuilder = f.a();
        }
    }

    public Resource build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Resource) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return Resource.create(this.attributesBuilder.build(), this.schemaUrl);
    }

    public ResourceBuilder put(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ResourceBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        }
        if (str != null && str2 != null) {
            this.attributesBuilder.put(str, str2);
        }
        return this;
    }

    public ResourceBuilder putAll(Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (ResourceBuilder) iPatchRedirector.redirect((short) 12, (Object) this, (Object) attributes);
        }
        if (attributes != null) {
            this.attributesBuilder.putAll(attributes);
        }
        return this;
    }

    public ResourceBuilder setSchemaUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ResourceBuilder) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        }
        this.schemaUrl = str;
        return this;
    }

    public ResourceBuilder put(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ResourceBuilder) iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3));
        }
        if (str != null) {
            this.attributesBuilder.put(str, j3);
        }
        return this;
    }

    public ResourceBuilder putAll(Resource resource) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (ResourceBuilder) iPatchRedirector.redirect((short) 13, (Object) this, (Object) resource);
        }
        if (resource != null) {
            this.attributesBuilder.putAll(resource.getAttributes());
        }
        return this;
    }

    public ResourceBuilder put(String str, double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ResourceBuilder) iPatchRedirector.redirect((short) 4, this, str, Double.valueOf(d16));
        }
        if (str != null) {
            this.attributesBuilder.put(str, d16);
        }
        return this;
    }

    public ResourceBuilder put(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ResourceBuilder) iPatchRedirector.redirect((short) 5, this, str, Boolean.valueOf(z16));
        }
        if (str != null) {
            this.attributesBuilder.put(str, z16);
        }
        return this;
    }

    public ResourceBuilder put(String str, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ResourceBuilder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) strArr);
        }
        if (str != null && strArr != null) {
            this.attributesBuilder.put(str, strArr);
        }
        return this;
    }

    public ResourceBuilder put(String str, long... jArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ResourceBuilder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) jArr);
        }
        if (str != null && jArr != null) {
            this.attributesBuilder.put(str, jArr);
        }
        return this;
    }

    public ResourceBuilder put(String str, double... dArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ResourceBuilder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) dArr);
        }
        if (str != null && dArr != null) {
            this.attributesBuilder.put(str, dArr);
        }
        return this;
    }

    public ResourceBuilder put(String str, boolean... zArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ResourceBuilder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) zArr);
        }
        if (str != null && zArr != null) {
            this.attributesBuilder.put(str, zArr);
        }
        return this;
    }

    public <T> ResourceBuilder put(AttributeKey<T> attributeKey, T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ResourceBuilder) iPatchRedirector.redirect((short) 10, (Object) this, (Object) attributeKey, (Object) t16);
        }
        if (attributeKey != null && attributeKey.getKey() != null && attributeKey.getKey().length() > 0 && t16 != null) {
            this.attributesBuilder.put((AttributeKey<AttributeKey<T>>) attributeKey, (AttributeKey<T>) t16);
        }
        return this;
    }

    public ResourceBuilder put(AttributeKey<Long> attributeKey, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ResourceBuilder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) attributeKey, i3);
        }
        if (attributeKey != null && attributeKey.getKey() != null) {
            this.attributesBuilder.put(attributeKey, i3);
        }
        return this;
    }
}
