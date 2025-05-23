package com.tencent.mobileqq.ad.cardad.data;

import com.heytap.databaseengine.model.UserInfo;
import com.qzone.personalize.model.CustomNaviCacheData;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0018\u0012\b\b\u0002\u0010$\u001a\u00020\u0007\u0012\b\b\u0002\u0010)\u001a\u00020\u0004\u00a2\u0006\u0004\b*\u0010+J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\"\u0010\u001e\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\n\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010$\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0019\u0010!\"\u0004\b\"\u0010#R\"\u0010)\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010%\u001a\u0004\b\u001f\u0010&\"\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/data/y;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/gdtad/aditem/GdtAd;", "a", "Lcom/tencent/gdtad/aditem/GdtAd;", "f", "()Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "setBtnBgColor", "(Ljava/lang/String;)V", "btnBgColor", "c", "setBtnTextColor", CustomNaviCacheData.BTN_TEXT_COLOR, "", "d", UserInfo.SEX_FEMALE, "()F", "setAdRadius", "(F)V", "adRadius", "e", "Z", "()Z", "setEnableShake", "(Z)V", "enableShake", "I", "()I", "setExpoType", "(I)V", "expoType", "<init>", "(Lcom/tencent/gdtad/aditem/GdtAd;Ljava/lang/String;Ljava/lang/String;FZI)V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final /* data */ class y {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GdtAd gdtAd;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String btnBgColor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String btnTextColor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float adRadius;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean enableShake;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int expoType;

    public y(@NotNull GdtAd gdtAd, @NotNull String btnBgColor, @NotNull String btnTextColor, float f16, boolean z16, int i3) {
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        Intrinsics.checkNotNullParameter(btnBgColor, "btnBgColor");
        Intrinsics.checkNotNullParameter(btnTextColor, "btnTextColor");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, gdtAd, btnBgColor, btnTextColor, Float.valueOf(f16), Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        this.gdtAd = gdtAd;
        this.btnBgColor = btnBgColor;
        this.btnTextColor = btnTextColor;
        this.adRadius = f16;
        this.enableShake = z16;
        this.expoType = i3;
    }

    public final float a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }
        return this.adRadius;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.btnBgColor;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.btnTextColor;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.enableShake;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.expoType;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof y)) {
            return false;
        }
        y yVar = (y) other;
        if (Intrinsics.areEqual(this.gdtAd, yVar.gdtAd) && Intrinsics.areEqual(this.btnBgColor, yVar.btnBgColor) && Intrinsics.areEqual(this.btnTextColor, yVar.btnTextColor) && Float.compare(this.adRadius, yVar.adRadius) == 0 && this.enableShake == yVar.enableShake && this.expoType == yVar.expoType) {
            return true;
        }
        return false;
    }

    @NotNull
    public final GdtAd f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (GdtAd) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.gdtAd;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        int hashCode = ((((((this.gdtAd.hashCode() * 31) + this.btnBgColor.hashCode()) * 31) + this.btnTextColor.hashCode()) * 31) + Float.floatToIntBits(this.adRadius)) * 31;
        boolean z16 = this.enableShake;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + this.expoType;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return "CardAdData(gdtAd=" + this.gdtAd + ", btnBgColor=" + this.btnBgColor + ", btnTextColor=" + this.btnTextColor + ", adRadius=" + this.adRadius + ", enableShake=" + this.enableShake + ", expoType=" + this.expoType + ')';
    }
}
