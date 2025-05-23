package com.tencent.opentelemetry.api.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.common.AttributeType;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class InternalAttributeKeyImpl<T> implements AttributeKey<T> {
    static IPatchRedirector $redirector_;
    private final int hashCode;
    private final String key;
    private byte[] keyUtf8;
    private final AttributeType type;

    InternalAttributeKeyImpl(AttributeType attributeType, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) attributeType, (Object) str);
            return;
        }
        if (attributeType != null) {
            this.type = attributeType;
            if (str != null) {
                this.key = str;
                this.hashCode = buildHashCode(attributeType, str);
                return;
            }
            throw new NullPointerException("Null key");
        }
        throw new NullPointerException("Null type");
    }

    private int buildHashCode() {
        return buildHashCode(this.type, this.key);
    }

    public static <T> AttributeKey<T> create(@Nullable String str, AttributeType attributeType) {
        if (str == null) {
            str = "";
        }
        return new InternalAttributeKeyImpl(attributeType, str);
    }

    public boolean equals(@Nullable Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InternalAttributeKeyImpl)) {
            return false;
        }
        InternalAttributeKeyImpl internalAttributeKeyImpl = (InternalAttributeKeyImpl) obj;
        if (this.type.equals(internalAttributeKeyImpl.getType()) && this.key.equals(internalAttributeKeyImpl.getKey())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.api.common.AttributeKey
    public String getKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.key;
    }

    public byte[] getKeyUtf8() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        byte[] bArr = this.keyUtf8;
        if (bArr == null) {
            byte[] bytes = this.key.getBytes(Charset.forName("UTF-8"));
            this.keyUtf8 = bytes;
            return bytes;
        }
        return bArr;
    }

    @Override // com.tencent.opentelemetry.api.common.AttributeKey
    public AttributeType getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AttributeType) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.type;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.hashCode;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.key;
    }

    private static int buildHashCode(AttributeType attributeType, String str) {
        return ((attributeType.hashCode() ^ 1000003) * 1000003) ^ str.hashCode();
    }
}
