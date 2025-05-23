package com.tencent.mobileqq.partner.signin;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0014\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020#0\"\u0012\b\b\u0002\u0010-\u001a\u00020\u0004\u0012\b\b\u0002\u0010/\u001a\u00020\u0002\u0012\b\b\u0002\u00101\u001a\u00020\u0002\u0012\b\b\u0002\u00103\u001a\u00020\u0002\u0012\b\b\u0002\u00106\u001a\u00020\u0002\u0012\b\b\u0002\u00108\u001a\u00020\u0002\u00a2\u0006\u0004\b9\u0010:J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010*\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\n\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR\"\u0010/\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u001c\u001a\u0004\b\u0010\u0010\u001e\"\u0004\b.\u0010 R\"\u00101\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001c\u001a\u0004\b\u0015\u0010\u001e\"\u0004\b0\u0010 R\"\u00103\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\t\u0010\u001e\"\u0004\b2\u0010 R\"\u00106\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u001c\u001a\u0004\b4\u0010\u001e\"\u0004\b5\u0010 R\"\u00108\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u001c\u001a\u0004\b$\u0010\u001e\"\u0004\b7\u0010 \u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/partner/signin/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "d", "()I", "o", "(I)V", "errCode", "b", "i", ReportConstant.COSTREPORT_PREFIX, "partnerStatus", "", "c", "J", "f", "()J", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(J)V", "markId", "Ljava/lang/String;", tl.h.F, "()Ljava/lang/String;", "r", "(Ljava/lang/String;)V", "partnerName", "", "Lcom/tencent/mobileqq/partner/signin/a;", "e", "Ljava/util/List;", "g", "()Ljava/util/List;", "setMemberSignInList", "(Ljava/util/List;)V", "memberSignInList", "k", "u", "togetherSignInDays", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "bgImageUrl", DomainData.DOMAIN_NAME, "buttonText", "l", "backgroundText", "j", "t", "themeColor", "p", "labelText", "<init>", "(IIJLjava/lang/String;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "mutualmark_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final /* data */ class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int errCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int partnerStatus;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long markId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String partnerName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<a> memberSignInList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int togetherSignInDays;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String bgImageUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String buttonText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String backgroundText;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String themeColor;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String labelText;

    public b() {
        this(0, 0, 0L, null, null, 0, null, null, null, null, null, 2047, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 40)) {
            return;
        }
        iPatchRedirector.redirect((short) 40, (Object) this);
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.backgroundText;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.bgImageUrl;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.buttonText;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.errCode;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.labelText;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (this.errCode == bVar.errCode && this.partnerStatus == bVar.partnerStatus && this.markId == bVar.markId && Intrinsics.areEqual(this.partnerName, bVar.partnerName) && Intrinsics.areEqual(this.memberSignInList, bVar.memberSignInList) && this.togetherSignInDays == bVar.togetherSignInDays && Intrinsics.areEqual(this.bgImageUrl, bVar.bgImageUrl) && Intrinsics.areEqual(this.buttonText, bVar.buttonText) && Intrinsics.areEqual(this.backgroundText, bVar.backgroundText) && Intrinsics.areEqual(this.themeColor, bVar.themeColor) && Intrinsics.areEqual(this.labelText, bVar.labelText)) {
            return true;
        }
        return false;
    }

    public final long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.markId;
    }

    @NotNull
    public final List<a> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.memberSignInList;
    }

    @NotNull
    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.partnerName;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Integer) iPatchRedirector.redirect((short) 38, (Object) this)).intValue();
        }
        return (((((((((((((((((((this.errCode * 31) + this.partnerStatus) * 31) + androidx.fragment.app.a.a(this.markId)) * 31) + this.partnerName.hashCode()) * 31) + this.memberSignInList.hashCode()) * 31) + this.togetherSignInDays) * 31) + this.bgImageUrl.hashCode()) * 31) + this.buttonText.hashCode()) * 31) + this.backgroundText.hashCode()) * 31) + this.themeColor.hashCode()) * 31) + this.labelText.hashCode();
    }

    public final int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.partnerStatus;
    }

    @NotNull
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.themeColor;
    }

    public final int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.togetherSignInDays;
    }

    public final void l(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.backgroundText = str;
        }
    }

    public final void m(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.bgImageUrl = str;
        }
    }

    public final void n(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.buttonText = str;
        }
    }

    public final void o(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.errCode = i3;
        }
    }

    public final void p(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.labelText = str;
        }
    }

    public final void q(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        } else {
            this.markId = j3;
        }
    }

    public final void r(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.partnerName = str;
        }
    }

    public final void s(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.partnerStatus = i3;
        }
    }

    public final void t(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.themeColor = str;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (String) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return "PartnerSignInData(errCode=" + this.errCode + ", partnerStatus=" + this.partnerStatus + ", markId=" + this.markId + ", partnerName=" + this.partnerName + ", memberSignInList=" + this.memberSignInList + ", togetherSignInDays=" + this.togetherSignInDays + ", bgImageUrl=" + this.bgImageUrl + ", buttonText=" + this.buttonText + ", backgroundText=" + this.backgroundText + ", themeColor=" + this.themeColor + ", labelText=" + this.labelText + ")";
    }

    public final void u(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.togetherSignInDays = i3;
        }
    }

    public b(int i3, int i16, long j3, @NotNull String partnerName, @NotNull List<a> memberSignInList, int i17, @NotNull String bgImageUrl, @NotNull String buttonText, @NotNull String backgroundText, @NotNull String themeColor, @NotNull String labelText) {
        Intrinsics.checkNotNullParameter(partnerName, "partnerName");
        Intrinsics.checkNotNullParameter(memberSignInList, "memberSignInList");
        Intrinsics.checkNotNullParameter(bgImageUrl, "bgImageUrl");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        Intrinsics.checkNotNullParameter(backgroundText, "backgroundText");
        Intrinsics.checkNotNullParameter(themeColor, "themeColor");
        Intrinsics.checkNotNullParameter(labelText, "labelText");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), partnerName, memberSignInList, Integer.valueOf(i17), bgImageUrl, buttonText, backgroundText, themeColor, labelText);
            return;
        }
        this.errCode = i3;
        this.partnerStatus = i16;
        this.markId = j3;
        this.partnerName = partnerName;
        this.memberSignInList = memberSignInList;
        this.togetherSignInDays = i17;
        this.bgImageUrl = bgImageUrl;
        this.buttonText = buttonText;
        this.backgroundText = backgroundText;
        this.themeColor = themeColor;
        this.labelText = labelText;
    }

    public /* synthetic */ b(int i3, int i16, long j3, String str, List list, int i17, String str2, String str3, String str4, String str5, String str6, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 0 : i3, (i18 & 2) != 0 ? 1 : i16, (i18 & 4) != 0 ? 0L : j3, (i18 & 8) != 0 ? "" : str, (i18 & 16) != 0 ? new ArrayList() : list, (i18 & 32) != 0 ? 0 : i17, (i18 & 64) != 0 ? "" : str2, (i18 & 128) != 0 ? "" : str3, (i18 & 256) != 0 ? "" : str4, (i18 & 512) != 0 ? "" : str5, (i18 & 1024) != 0 ? "" : str6);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), str, list, Integer.valueOf(i17), str2, str3, str4, str5, str6, Integer.valueOf(i18), defaultConstructorMarker);
    }
}
