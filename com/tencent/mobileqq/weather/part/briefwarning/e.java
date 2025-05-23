package com.tencent.mobileqq.weather.part.briefwarning;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\r\u0010\u0010R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/weather/part/briefwarning/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "pagePos", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "warningIconUrl", "c", "f", "warningText", "warningArea", "e", "g", "warningTime", "warningColor", "warningJumpUrl", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final /* data */ class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int pagePos;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String warningIconUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String warningText;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String warningArea;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String warningTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String warningColor;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String warningJumpUrl;

    public e(int i3, @NotNull String warningIconUrl, @NotNull String warningText, @NotNull String warningArea, @NotNull String warningTime, @NotNull String warningColor, @NotNull String warningJumpUrl) {
        Intrinsics.checkNotNullParameter(warningIconUrl, "warningIconUrl");
        Intrinsics.checkNotNullParameter(warningText, "warningText");
        Intrinsics.checkNotNullParameter(warningArea, "warningArea");
        Intrinsics.checkNotNullParameter(warningTime, "warningTime");
        Intrinsics.checkNotNullParameter(warningColor, "warningColor");
        Intrinsics.checkNotNullParameter(warningJumpUrl, "warningJumpUrl");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), warningIconUrl, warningText, warningArea, warningTime, warningColor, warningJumpUrl);
            return;
        }
        this.pagePos = i3;
        this.warningIconUrl = warningIconUrl;
        this.warningText = warningText;
        this.warningArea = warningArea;
        this.warningTime = warningTime;
        this.warningColor = warningColor;
        this.warningJumpUrl = warningJumpUrl;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.pagePos;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.warningArea;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.warningColor;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.warningIconUrl;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.warningJumpUrl;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof e)) {
            return false;
        }
        e eVar = (e) other;
        if (this.pagePos == eVar.pagePos && Intrinsics.areEqual(this.warningIconUrl, eVar.warningIconUrl) && Intrinsics.areEqual(this.warningText, eVar.warningText) && Intrinsics.areEqual(this.warningArea, eVar.warningArea) && Intrinsics.areEqual(this.warningTime, eVar.warningTime) && Intrinsics.areEqual(this.warningColor, eVar.warningColor) && Intrinsics.areEqual(this.warningJumpUrl, eVar.warningJumpUrl)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.warningText;
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.warningTime;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return (((((((((((this.pagePos * 31) + this.warningIconUrl.hashCode()) * 31) + this.warningText.hashCode()) * 31) + this.warningArea.hashCode()) * 31) + this.warningTime.hashCode()) * 31) + this.warningColor.hashCode()) * 31) + this.warningJumpUrl.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return "WeatherWarningData(pagePos=" + this.pagePos + ", warningIconUrl=" + this.warningIconUrl + ", warningText=" + this.warningText + ", warningArea=" + this.warningArea + ", warningTime=" + this.warningTime + ", warningColor=" + this.warningColor + ", warningJumpUrl=" + this.warningJumpUrl + ")";
    }
}
