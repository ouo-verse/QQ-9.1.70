package com.tencent.opentelemetry.sdk.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
final class AutoValue_InstrumentationLibraryInfo extends InstrumentationLibraryInfo {
    static IPatchRedirector $redirector_;
    private final String name;
    private final String schemaUrl;
    private final String version;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_InstrumentationLibraryInfo(String str, @Nullable String str2, @Nullable String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3);
        } else {
            if (str != null) {
                this.name = str;
                this.version = str2;
                this.schemaUrl = str3;
                return;
            }
            throw new NullPointerException("Null name");
        }
    }

    public boolean equals(Object obj) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstrumentationLibraryInfo)) {
            return false;
        }
        InstrumentationLibraryInfo instrumentationLibraryInfo = (InstrumentationLibraryInfo) obj;
        if (this.name.equals(instrumentationLibraryInfo.getName()) && ((str = this.version) != null ? str.equals(instrumentationLibraryInfo.getVersion()) : instrumentationLibraryInfo.getVersion() == null)) {
            String str2 = this.schemaUrl;
            if (str2 == null) {
                if (instrumentationLibraryInfo.getSchemaUrl() == null) {
                    return true;
                }
            } else if (str2.equals(instrumentationLibraryInfo.getSchemaUrl())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.common.InstrumentationLibraryInfo
    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.name;
    }

    @Override // com.tencent.opentelemetry.sdk.common.InstrumentationLibraryInfo
    @Nullable
    public String getSchemaUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.schemaUrl;
    }

    @Override // com.tencent.opentelemetry.sdk.common.InstrumentationLibraryInfo
    @Nullable
    public String getVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.version;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        int hashCode2 = (this.name.hashCode() ^ 1000003) * 1000003;
        String str = this.version;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode2 ^ hashCode) * 1000003;
        String str2 = this.schemaUrl;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i16 ^ i3;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "InstrumentationLibraryInfo{name=" + this.name + ", version=" + this.version + ", schemaUrl=" + this.schemaUrl + "}";
    }
}
