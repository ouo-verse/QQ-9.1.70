package com.tencent.opentelemetry.sdk.extension;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.common.AttributesBuilder;
import com.tencent.opentelemetry.api.common.f;
import com.tencent.opentelemetry.sdk.resources.Resource;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import javax.annotation.Nullable;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class OsResource {
    static IPatchRedirector $redirector_;
    private static final Resource INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8754);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = buildResource();
        }
    }

    OsResource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static Resource buildResource() {
        String str;
        try {
            String property = System.getProperty("os.name");
            if (property == null) {
                return Resource.empty();
            }
            AttributesBuilder a16 = f.a();
            String os5 = getOs(property);
            if (os5 != null) {
                a16.put((AttributeKey<AttributeKey<String>>) ResourceAttributes.OS_TYPE, (AttributeKey<String>) os5);
            }
            try {
                str = System.getProperty("os.version");
            } catch (SecurityException unused) {
                str = null;
            }
            if (str != null) {
                property = property + TokenParser.SP + str;
            }
            a16.put((AttributeKey<AttributeKey<String>>) ResourceAttributes.OS_DESCRIPTION, (AttributeKey<String>) property);
            return Resource.create(a16.build(), "https://opentelemetry.io/schemas/1.4.0");
        } catch (SecurityException unused2) {
            return Resource.empty();
        }
    }

    public static Resource get() {
        return INSTANCE;
    }

    @Nullable
    private static String getOs(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("windows")) {
            return "windows";
        }
        if (lowerCase.startsWith("linux")) {
            return "linux";
        }
        if (lowerCase.startsWith("mac")) {
            return ResourceAttributes.OsTypeValues.DARWIN;
        }
        if (lowerCase.startsWith(ResourceAttributes.OsTypeValues.FREEBSD)) {
            return ResourceAttributes.OsTypeValues.FREEBSD;
        }
        if (lowerCase.startsWith(ResourceAttributes.OsTypeValues.NETBSD)) {
            return ResourceAttributes.OsTypeValues.NETBSD;
        }
        if (lowerCase.startsWith(ResourceAttributes.OsTypeValues.OPENBSD)) {
            return ResourceAttributes.OsTypeValues.OPENBSD;
        }
        if (lowerCase.startsWith(ResourceAttributes.OsTypeValues.DRAGONFLYBSD)) {
            return ResourceAttributes.OsTypeValues.DRAGONFLYBSD;
        }
        if (lowerCase.startsWith("hp-ux")) {
            return ResourceAttributes.OsTypeValues.HPUX;
        }
        if (lowerCase.startsWith(ResourceAttributes.OsTypeValues.AIX)) {
            return ResourceAttributes.OsTypeValues.AIX;
        }
        if (lowerCase.startsWith(ResourceAttributes.OsTypeValues.SOLARIS)) {
            return ResourceAttributes.OsTypeValues.SOLARIS;
        }
        if (lowerCase.startsWith("z/os")) {
            return ResourceAttributes.OsTypeValues.Z_OS;
        }
        return null;
    }
}
