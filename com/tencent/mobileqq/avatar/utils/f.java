package com.tencent.mobileqq.avatar.utils;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vip.api.VipData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \u00122\u00020\u0001:\u0001/Bk\u0012\u0006\u0010*\u001a\u00020\r\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010,\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\r\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u001f\u001a\u00020\r\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010'\u001a\u00020$\u0012\b\b\u0002\u0010)\u001a\u00020\r\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001f\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001e\u0010\u0011R\u0017\u0010\"\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b\u001d\u0010!R\u0017\u0010#\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b\u0016\u0010!R\u0017\u0010'\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010%\u001a\u0004\b\u000e\u0010&R\u0017\u0010)\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b(\u0010\u0011\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/avatar/utils/f;", "Lcom/tencent/qqnt/avatar/bean/a;", "", "d", "toString", "", "e", "J", "j", "()J", DomainData.DOMAIN_NAME, "(J)V", "pendantId", "", "f", "I", "i", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(I)V", "pendantDiyId", "Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo;", "g", "Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo;", "l", "()Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo;", "o", "(Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo;)V", "vipNum", h.F, "k", "targetId", "Ljava/lang/String;", "()Ljava/lang/String;", "peerUin", "peerUid", "", "Z", "()Z", "needQueryFromNet", "getSpecialShapeMaskId", "specialShapeMaskId", "avatarType", "id", "size", "<init>", "(ILjava/lang/String;IJILcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo;ILjava/lang/String;Ljava/lang/String;ZI)V", "a", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class f extends com.tencent.qqnt.avatar.bean.a {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long pendantId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int pendantDiyId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private VipData.VipNumberInfo vipNum;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int targetId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String peerUin;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String peerUid;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final boolean needQueryFromNet;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final int specialShapeMaskId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/avatar/utils/f$a;", "", "<init>", "()V", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.avatar.utils.f$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29886);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ f(int i3, String str, int i16, long j3, int i17, VipData.VipNumberInfo vipNumberInfo, int i18, String str2, String str3, boolean z16, int i19, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, i16, j3, i17, vipNumberInfo, i18, (i26 & 128) != 0 ? "" : str2, (i26 & 256) != 0 ? "" : str3, (i26 & 512) != 0 ? false : z16, (i26 & 1024) != 0 ? 0 : i19);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Long.valueOf(j3), Integer.valueOf(i17), vipNumberInfo, Integer.valueOf(i18), str2, str3, Boolean.valueOf(z16), Integer.valueOf(i19), Integer.valueOf(i26), defaultConstructorMarker);
    }

    @Override // com.tencent.qqnt.avatar.bean.a
    @NotNull
    public String d() {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        int a16 = a();
        String c16 = c();
        int e16 = e();
        VipData.VipNumberInfo vipNumberInfo = this.vipNum;
        Integer num2 = null;
        if (vipNumberInfo != null) {
            num = Integer.valueOf(vipNumberInfo.getNumberItemId());
        } else {
            num = null;
        }
        VipData.VipNumberInfo vipNumberInfo2 = this.vipNum;
        if (vipNumberInfo2 != null) {
            num2 = Integer.valueOf(vipNumberInfo2.getNumberIdx());
        }
        return "3_" + a16 + "_" + c16 + "_" + e16 + "_" + num + "_" + num2;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.needQueryFromNet;
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.peerUid;
    }

    @NotNull
    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.peerUin;
    }

    public final int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.pendantDiyId;
    }

    public final long j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.pendantId;
    }

    public final int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.targetId;
    }

    @Nullable
    public final VipData.VipNumberInfo l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (VipData.VipNumberInfo) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.vipNum;
    }

    public final void m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.pendantDiyId = i3;
        }
    }

    public final void n(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        } else {
            this.pendantId = j3;
        }
    }

    public final void o(@Nullable VipData.VipNumberInfo vipNumberInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) vipNumberInfo);
        } else {
            this.vipNum = vipNumberInfo;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return "VasPendantBean(pendantId=" + this.pendantId + ", pendantDiyId=" + this.pendantDiyId + ", vipNum=" + this.vipNum + ", targetId=" + this.targetId + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(int i3, @Nullable String str, int i16, long j3, int i17, @Nullable VipData.VipNumberInfo vipNumberInfo, int i18, @NotNull String peerUin, @NotNull String peerUid, boolean z16, int i19) {
        super(3, i3, str, i16);
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Long.valueOf(j3), Integer.valueOf(i17), vipNumberInfo, Integer.valueOf(i18), peerUin, peerUid, Boolean.valueOf(z16), Integer.valueOf(i19));
            return;
        }
        this.pendantId = j3;
        this.pendantDiyId = i17;
        this.vipNum = vipNumberInfo;
        this.targetId = i18;
        this.peerUin = peerUin;
        this.peerUid = peerUid;
        this.needQueryFromNet = z16;
        this.specialShapeMaskId = i19;
    }
}
