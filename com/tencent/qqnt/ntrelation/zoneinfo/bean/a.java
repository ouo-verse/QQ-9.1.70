package com.tencent.qqnt.ntrelation.zoneinfo.bean;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010!\u001a\u00020\u001b\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010,\u001a\u00020\b\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b1\u00102J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u001a\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010!\u001a\u00020\u001b8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010%\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\"\u0010,\u001a\u00020\b8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u00100\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u000b\u001a\u0004\b.\u0010\r\"\u0004\b/\u0010\u000f\u00a8\u00063"}, d2 = {"Lcom/tencent/qqnt/ntrelation/zoneinfo/bean/a;", "Lcom/tencent/qqnt/ntrelation/zoneinfo/bean/c;", "", "toString", "", "hashCode", "", "other", "", "equals", "G", "Ljava/lang/String;", "a", "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;)V", "uid", "H", "o", DomainData.DOMAIN_NAME, "uin", "I", "j", "()I", "r", "(I)V", "feedType", "", "J", "f", "()J", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(J)V", "feedTime", "K", "b", "k", "feedContent", "L", "Z", "c", "()Z", "l", "(Z)V", "feedHasPhoto", "M", "e", "p", "feedPhotoUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;ZLjava/lang/String;)V", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final /* data */ class a extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String uid;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String uin;

    /* renamed from: I, reason: from kotlin metadata */
    private int feedType;

    /* renamed from: J, reason: from kotlin metadata */
    private long feedTime;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private String feedContent;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean feedHasPhoto;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private String feedPhotoUrl;

    public a() {
        this(null, null, 0, 0L, null, false, null, 127, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 28)) {
            return;
        }
        iPatchRedirector.redirect((short) 28, (Object) this);
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.bean.c, com.tencent.qqnt.ntrelation.baseinfo.bean.a
    @NotNull
    /* renamed from: a */
    public String getUid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.uid;
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.bean.c
    @Nullable
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.feedContent;
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.bean.c
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.feedHasPhoto;
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.bean.c
    @Nullable
    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.feedPhotoUrl;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(getUid(), aVar.getUid()) && Intrinsics.areEqual(o(), aVar.o()) && j() == aVar.j() && f() == aVar.f() && Intrinsics.areEqual(b(), aVar.b()) && c() == aVar.c() && Intrinsics.areEqual(e(), aVar.e())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.bean.c
    public long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return this.feedTime;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        int hashCode2 = ((((((getUid().hashCode() * 31) + o().hashCode()) * 31) + j()) * 31) + androidx.fragment.app.a.a(f())) * 31;
        int i3 = 0;
        if (b() == null) {
            hashCode = 0;
        } else {
            hashCode = b().hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        boolean c16 = c();
        int i17 = c16;
        if (c16) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        if (e() != null) {
            i3 = e().hashCode();
        }
        return i18 + i3;
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.bean.c
    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.feedType;
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.bean.c
    public void k(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            this.feedContent = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.bean.c
    public void l(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.feedHasPhoto = z16;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.bean.c
    public void m(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.uid = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.bean.c
    public void n(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.uin = str;
        }
    }

    @NotNull
    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.uin;
    }

    public void p(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        } else {
            this.feedPhotoUrl = str;
        }
    }

    public void q(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, j3);
        } else {
            this.feedTime = j3;
        }
    }

    public void r(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.feedType = i3;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return "NTZoneDetailInfo(uid=" + getUid() + ", uin=" + o() + ", feedType=" + j() + ", feedTime=" + f() + ", feedContent=" + b() + ", feedHasPhoto=" + c() + ", feedPhotoUrl=" + e() + ")";
    }

    public /* synthetic */ a(String str, String str2, int i3, long j3, String str3, boolean z16, String str4, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? 0L : j3, (i16 & 16) != 0 ? "" : str3, (i16 & 32) != 0 ? false : z16, (i16 & 64) != 0 ? "" : str4);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3), Long.valueOf(j3), str3, Boolean.valueOf(z16), str4, Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull String uid, @NotNull String uin, int i3, long j3, @Nullable String str, boolean z16, @Nullable String str2) {
        super(null, null, 3, null);
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(uin, "uin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, uid, uin, Integer.valueOf(i3), Long.valueOf(j3), str, Boolean.valueOf(z16), str2);
            return;
        }
        this.uid = uid;
        this.uin = uin;
        this.feedType = i3;
        this.feedTime = j3;
        this.feedContent = str;
        this.feedHasPhoto = z16;
        this.feedPhotoUrl = str2;
    }
}
