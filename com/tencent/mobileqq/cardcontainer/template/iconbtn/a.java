package com.tencent.mobileqq.cardcontainer.template.iconbtn;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\t\u0010\fR\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0018\u0010\fR\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u001a\u0010\fR\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0016\u0010\f\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/template/iconbtn/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", h.F, "()Ljava/lang/String;", "itemId", "b", "g", "imageLightUrl", "c", "f", "imageDarkUrl", "d", "bgLightUrl", "e", "bgDarkUrl", "j", "title", "i", QQWinkConstants.TAB_SUBTITLE, TuxUIConstants.POP_BTN_TEXT, "btnScheme", "cardScheme", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String itemId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String imageLightUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String imageDarkUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String bgLightUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String bgDarkUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String title;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String subTitle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String btnText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String btnScheme;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String cardScheme;

    public a(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, str4, str5, str6, str7, str8, str9, str10);
            return;
        }
        this.itemId = str;
        this.imageLightUrl = str2;
        this.imageDarkUrl = str3;
        this.bgLightUrl = str4;
        this.bgDarkUrl = str5;
        this.title = str6;
        this.subTitle = str7;
        this.btnText = str8;
        this.btnScheme = str9;
        this.cardScheme = str10;
    }

    @Nullable
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.bgDarkUrl;
    }

    @Nullable
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.bgLightUrl;
    }

    @Nullable
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.btnScheme;
    }

    @Nullable
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.btnText;
    }

    @Nullable
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.cardScheme;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.itemId, aVar.itemId) && Intrinsics.areEqual(this.imageLightUrl, aVar.imageLightUrl) && Intrinsics.areEqual(this.imageDarkUrl, aVar.imageDarkUrl) && Intrinsics.areEqual(this.bgLightUrl, aVar.bgLightUrl) && Intrinsics.areEqual(this.bgDarkUrl, aVar.bgDarkUrl) && Intrinsics.areEqual(this.title, aVar.title) && Intrinsics.areEqual(this.subTitle, aVar.subTitle) && Intrinsics.areEqual(this.btnText, aVar.btnText) && Intrinsics.areEqual(this.btnScheme, aVar.btnScheme) && Intrinsics.areEqual(this.cardScheme, aVar.cardScheme)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.imageDarkUrl;
    }

    @Nullable
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.imageLightUrl;
    }

    @Nullable
    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.itemId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int hashCode9;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        String str = this.itemId;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.imageLightUrl;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.imageDarkUrl;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str4 = this.bgLightUrl;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        String str5 = this.bgDarkUrl;
        if (str5 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str5.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        String str6 = this.title;
        if (str6 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str6.hashCode();
        }
        int i27 = (i26 + hashCode6) * 31;
        String str7 = this.subTitle;
        if (str7 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = str7.hashCode();
        }
        int i28 = (i27 + hashCode7) * 31;
        String str8 = this.btnText;
        if (str8 == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = str8.hashCode();
        }
        int i29 = (i28 + hashCode8) * 31;
        String str9 = this.btnScheme;
        if (str9 == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = str9.hashCode();
        }
        int i36 = (i29 + hashCode9) * 31;
        String str10 = this.cardScheme;
        if (str10 != null) {
            i3 = str10.hashCode();
        }
        return i36 + i3;
    }

    @Nullable
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.subTitle;
    }

    @Nullable
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.title;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return "IconBtnBizModel(itemId=" + this.itemId + ", imageLightUrl=" + this.imageLightUrl + ", imageDarkUrl=" + this.imageDarkUrl + ", bgLightUrl=" + this.bgLightUrl + ", bgDarkUrl=" + this.bgDarkUrl + ", title=" + this.title + ", subTitle=" + this.subTitle + ", btnText=" + this.btnText + ", btnScheme=" + this.btnScheme + ", cardScheme=" + this.cardScheme + ")";
    }
}
