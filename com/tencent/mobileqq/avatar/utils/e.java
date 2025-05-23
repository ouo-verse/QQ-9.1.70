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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 \u00112\u00020\u0001:\u0001,By\u0012\u0006\u0010'\u001a\u00020\u0005\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010)\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u001f\u0012\b\b\u0002\u0010$\u001a\u00020\u0005\u0012\b\b\u0002\u0010&\u001a\u00020\u001f\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\tR\u0017\u0010\u0019\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u0018\u0010\tR\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001cR\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001b\u001a\u0004\b\u0017\u0010\u001cR\u0017\u0010#\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u0014\u0010\"R\u0017\u0010$\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0007\u001a\u0004\b \u0010\tR\u0017\u0010&\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b%\u0010\"\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/avatar/utils/e;", "Lcom/tencent/qqnt/avatar/bean/a;", "", "d", "toString", "", "e", "I", "f", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(I)V", "faceId", "Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo;", "Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo;", "getVipNum", "()Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo;", DomainData.DOMAIN_NAME, "(Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo;)V", "vipNum", "g", "j", "shopSource", h.F, "l", "useSource", "i", "Ljava/lang/String;", "()Ljava/lang/String;", "peerUin", "peerUid", "", "k", "Z", "()Z", "needQueryFromNet", "specialShapeMaskId", "getCanShowEmpty", "canShowEmpty", "avatarType", "id", "size", "<init>", "(ILjava/lang/String;IILcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo;IILjava/lang/String;Ljava/lang/String;ZIZ)V", "a", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class e extends com.tencent.qqnt.avatar.bean.a {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int faceId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private VipData.VipNumberInfo vipNum;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int shopSource;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int useSource;

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

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final boolean canShowEmpty;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/avatar/utils/e$a;", "", "<init>", "()V", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.avatar.utils.e$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29878);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ e(int i3, String str, int i16, int i17, VipData.VipNumberInfo vipNumberInfo, int i18, int i19, String str2, String str3, boolean z16, int i26, boolean z17, int i27, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, i16, i17, vipNumberInfo, (i27 & 32) != 0 ? 0 : i18, (i27 & 64) != 0 ? -1 : i19, (i27 & 128) != 0 ? "" : str2, (i27 & 256) != 0 ? "" : str3, (i27 & 512) != 0 ? false : z16, (i27 & 1024) != 0 ? 0 : i26, (i27 & 2048) != 0 ? false : z17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17), vipNumberInfo, Integer.valueOf(i18), Integer.valueOf(i19), str2, str3, Boolean.valueOf(z16), Integer.valueOf(i26), Boolean.valueOf(z17), Integer.valueOf(i27), defaultConstructorMarker);
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
        return "2_" + a16 + "_" + c16 + "_" + e16 + "_" + num + "_" + num2;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.faceId;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.needQueryFromNet;
    }

    @NotNull
    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.peerUid;
    }

    @NotNull
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.peerUin;
    }

    public final int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.shopSource;
    }

    public final int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.specialShapeMaskId;
    }

    public final int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.useSource;
    }

    public final void m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.faceId = i3;
        }
    }

    public final void n(@Nullable VipData.VipNumberInfo vipNumberInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) vipNumberInfo);
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
        return "VasAvatarBean(faceId=" + this.faceId + ", vipNum=" + this.vipNum + ", shopSource=" + this.shopSource + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(int i3, @Nullable String str, int i16, int i17, @Nullable VipData.VipNumberInfo vipNumberInfo, int i18, int i19, @NotNull String peerUin, @NotNull String peerUid, boolean z16, int i26, boolean z17) {
        super(2, i3, str, i16);
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17), vipNumberInfo, Integer.valueOf(i18), Integer.valueOf(i19), peerUin, peerUid, Boolean.valueOf(z16), Integer.valueOf(i26), Boolean.valueOf(z17));
            return;
        }
        this.faceId = i17;
        this.vipNum = vipNumberInfo;
        this.shopSource = i18;
        this.useSource = i19;
        this.peerUin = peerUin;
        this.peerUid = peerUid;
        this.needQueryFromNet = z16;
        this.specialShapeMaskId = i26;
        this.canShowEmpty = z17;
    }
}
