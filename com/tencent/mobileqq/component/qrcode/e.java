package com.tencent.mobileqq.component.qrcode;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR#\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u00118\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014R\u0017\u0010\u0019\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\t\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/component/qrcode/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "d", "()I", "minVersion", "b", "c", "maxVersion", "", "Lcom/tencent/mobileqq/component/qrcode/d;", "Ljava/util/Map;", "()Ljava/util/Map;", "logoSizeMap", "Lcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;", "Lcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;", "()Lcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;", "errorCorrectionLevel", "<init>", "(IILjava/util/Map;Lcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;)V", "qrcode_component_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final /* data */ class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int minVersion;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int maxVersion;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, d> logoSizeMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ErrorCorrectionLevel errorCorrectionLevel;

    public e() {
        this(0, 0, null, null, 15, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            return;
        }
        iPatchRedirector.redirect((short) 15, (Object) this);
    }

    @NotNull
    public final ErrorCorrectionLevel a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ErrorCorrectionLevel) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.errorCorrectionLevel;
    }

    @NotNull
    public final Map<Integer, d> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.logoSizeMap;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.maxVersion;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.minVersion;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof e)) {
            return false;
        }
        e eVar = (e) other;
        if (this.minVersion == eVar.minVersion && this.maxVersion == eVar.maxVersion && Intrinsics.areEqual(this.logoSizeMap, eVar.logoSizeMap) && this.errorCorrectionLevel == eVar.errorCorrectionLevel) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return (((((this.minVersion * 31) + this.maxVersion) * 31) + this.logoSizeMap.hashCode()) * 31) + this.errorCorrectionLevel.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "GenerateQRParams(minVersion=" + this.minVersion + ", maxVersion=" + this.maxVersion + ", logoSizeMap=" + this.logoSizeMap + ", errorCorrectionLevel=" + this.errorCorrectionLevel + ")";
    }

    public e(int i3, int i16, @NotNull Map<Integer, d> logoSizeMap, @NotNull ErrorCorrectionLevel errorCorrectionLevel) {
        Intrinsics.checkNotNullParameter(logoSizeMap, "logoSizeMap");
        Intrinsics.checkNotNullParameter(errorCorrectionLevel, "errorCorrectionLevel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), logoSizeMap, errorCorrectionLevel);
            return;
        }
        this.minVersion = i3;
        this.maxVersion = i16;
        this.logoSizeMap = logoSizeMap;
        this.errorCorrectionLevel = errorCorrectionLevel;
    }

    public /* synthetic */ e(int i3, int i16, Map map, ErrorCorrectionLevel errorCorrectionLevel, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 3 : i3, (i17 & 2) != 0 ? 4 : i16, (i17 & 4) != 0 ? d.INSTANCE.a() : map, (i17 & 8) != 0 ? ErrorCorrectionLevel.Q : errorCorrectionLevel);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), map, errorCorrectionLevel, Integer.valueOf(i17), defaultConstructorMarker);
    }
}
