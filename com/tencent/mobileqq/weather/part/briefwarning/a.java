package com.tencent.mobileqq.weather.part.briefwarning;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u000bR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000f\u0010\u0014R\u0017\u0010\u0019\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R'\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0012\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/weather/part/briefwarning/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "briefIcon", "b", "briefText", "c", "getBriefJumpUrl", "briefJumpUrl", "d", "I", "()I", "briefType", "e", "Z", "()Z", "isEnableShowBrief", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/weather/part/briefwarning/e;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "warningDataList", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/util/ArrayList;)V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String briefIcon;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String briefText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String briefJumpUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int briefType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isEnableShowBrief;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<e> warningDataList;

    public a(@NotNull String briefIcon, @NotNull String briefText, @NotNull String briefJumpUrl, int i3, boolean z16, @NotNull ArrayList<e> warningDataList) {
        Intrinsics.checkNotNullParameter(briefIcon, "briefIcon");
        Intrinsics.checkNotNullParameter(briefText, "briefText");
        Intrinsics.checkNotNullParameter(briefJumpUrl, "briefJumpUrl");
        Intrinsics.checkNotNullParameter(warningDataList, "warningDataList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, briefIcon, briefText, briefJumpUrl, Integer.valueOf(i3), Boolean.valueOf(z16), warningDataList);
            return;
        }
        this.briefIcon = briefIcon;
        this.briefText = briefText;
        this.briefJumpUrl = briefJumpUrl;
        this.briefType = i3;
        this.isEnableShowBrief = z16;
        this.warningDataList = warningDataList;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.briefIcon;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.briefText;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.briefType;
    }

    @NotNull
    public final ArrayList<e> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.warningDataList;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.isEnableShowBrief;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.briefIcon, aVar.briefIcon) && Intrinsics.areEqual(this.briefText, aVar.briefText) && Intrinsics.areEqual(this.briefJumpUrl, aVar.briefJumpUrl) && this.briefType == aVar.briefType && this.isEnableShowBrief == aVar.isEnableShowBrief && Intrinsics.areEqual(this.warningDataList, aVar.warningDataList)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        int hashCode = ((((((this.briefIcon.hashCode() * 31) + this.briefText.hashCode()) * 31) + this.briefJumpUrl.hashCode()) * 31) + this.briefType) * 31;
        boolean z16 = this.isEnableShowBrief;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + this.warningDataList.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return "WeatherBriefAndWarningData(briefIcon=" + this.briefIcon + ", briefText=" + this.briefText + ", briefJumpUrl=" + this.briefJumpUrl + ", briefType=" + this.briefType + ", isEnableShowBrief=" + this.isEnableShowBrief + ", warningDataList=" + this.warningDataList + ")";
    }
}
