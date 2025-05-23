package com.tencent.opentelemetry.sdk.resources;

import com.google.auto.value.AutoValue;
import com.google.auto.value.extension.memoized.Memoized;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.common.AttributesBuilder;
import com.tencent.opentelemetry.api.common.f;
import com.tencent.opentelemetry.api.internal.StringUtils;
import com.tencent.opentelemetry.api.internal.Utils;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import java.util.Objects;
import java.util.Properties;
import java.util.function.BiConsumer;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class Resource {
    static IPatchRedirector $redirector_ = null;
    private static final Resource DEFAULT;
    private static final Resource EMPTY;
    private static final String ERROR_MESSAGE_INVALID_CHARS = " should be a ASCII string with a length greater than 0 and not exceed 255 characters.";
    private static final String ERROR_MESSAGE_INVALID_VALUE = " should be a ASCII string with a length not exceed 255 characters.";
    private static final Resource MANDATORY;
    private static final int MAX_LENGTH = 255;
    private static final String SDK_VERSION = "1.0.38";
    private static final String TAG;
    private static final Resource TELEMETRY_SDK;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9226);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        TAG = Resource.class.getName();
        EMPTY = create(f.b());
        Resource create = create(f.c(ResourceAttributes.SERVICE_NAME, "android"));
        MANDATORY = create;
        Resource create2 = create(f.a().put((AttributeKey<AttributeKey<String>>) ResourceAttributes.TELEMETRY_SDK_NAME, (AttributeKey<String>) "opentelemetry").put((AttributeKey<AttributeKey<String>>) ResourceAttributes.TELEMETRY_SDK_LANGUAGE, (AttributeKey<String>) "android").put((AttributeKey<AttributeKey<String>>) ResourceAttributes.TELEMETRY_SDK_VERSION, (AttributeKey<String>) SDK_VERSION).build());
        TELEMETRY_SDK = create2;
        DEFAULT = create.merge(create2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Resource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public static ResourceBuilder builder() {
        return new ResourceBuilder();
    }

    private static void checkAttributes(Attributes attributes) {
        attributes.forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.sdk.resources.a
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Resource.lambda$checkAttributes$0((AttributeKey) obj, obj2);
            }
        });
    }

    public static Resource create(Attributes attributes) {
        return create(attributes, null);
    }

    public static Resource empty() {
        return EMPTY;
    }

    public static Resource getDefault() {
        return DEFAULT;
    }

    public static Resource getTelemetrySdk() {
        return TELEMETRY_SDK;
    }

    private static boolean isValid(String str) {
        if (str.length() <= 255 && StringUtils.isPrintableString(str)) {
            return true;
        }
        return false;
    }

    private static boolean isValidAndNotEmpty(AttributeKey<?> attributeKey) {
        if (!attributeKey.getKey().isEmpty() && isValid(attributeKey.getKey())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkAttributes$0(AttributeKey attributeKey, Object obj) {
        Utils.checkArgument(isValidAndNotEmpty(attributeKey), "Attribute key should be a ASCII string with a length greater than 0 and not exceed 255 characters.");
        Objects.requireNonNull(obj, "Attribute value should be a ASCII string with a length not exceed 255 characters.");
    }

    @Nullable
    private static String readVersion() {
        Properties properties = new Properties();
        try {
            properties.load(Resource.class.getResourceAsStream("/com/tencent/opentelemetry/sdk/version.properties"));
            return properties.getProperty("sdk.version");
        } catch (Exception unused) {
            return "unknown";
        }
    }

    public abstract Attributes getAttributes();

    @Nullable
    public abstract String getSchemaUrl();

    @Memoized
    public abstract int hashCode();

    public Resource merge(@Nullable Resource resource) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Resource) iPatchRedirector.redirect((short) 1, (Object) this, (Object) resource);
        }
        if (resource == null) {
            return this;
        }
        AttributesBuilder a16 = f.a();
        a16.putAll(getAttributes());
        a16.putAll(resource.getAttributes());
        if (resource.getSchemaUrl() == null) {
            return create(a16.build(), getSchemaUrl());
        }
        if (getSchemaUrl() == null) {
            return create(a16.build(), resource.getSchemaUrl());
        }
        if (!resource.getSchemaUrl().equals(getSchemaUrl())) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.d(TAG, "Attempting to merge Resources with different schemaUrls. The resulting Resource will have no schemaUrl assigned. Schema 1: " + getSchemaUrl() + " Schema 2: " + resource.getSchemaUrl());
            }
            return create(a16.build(), null);
        }
        return create(a16.build(), getSchemaUrl());
    }

    public ResourceBuilder toBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ResourceBuilder) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return builder().putAll(this);
    }

    public static Resource create(Attributes attributes, @Nullable String str) {
        Objects.requireNonNull(attributes, "attributes");
        checkAttributes(attributes);
        return new AutoValue_Resource(str, attributes);
    }
}
