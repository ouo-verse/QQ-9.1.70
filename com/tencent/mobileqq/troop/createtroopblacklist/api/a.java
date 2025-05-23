package com.tencent.mobileqq.troop.createtroopblacklist.api;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.createtroopblacklist.CreateTroopUnblockType;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001\rBU\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\"\u0010#J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0018\u0010\u000fR\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u001a\u0010\u000fR\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0011\u0010\u000fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/troop/createtroopblacklist/api/a;", "", "Lcom/tencent/mobileqq/troop/createtroopblacklist/CreateTroopUnblockType;", "type", "", "g", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "errMsg", "b", "c", "leftBtnText", "d", "setLeftBtnUrl", "(Ljava/lang/String;)V", "leftBtnUrl", "e", "rightBtnText", "f", "rightBtnUrl", "errTitle", "Lcom/tencent/mobileqq/troop/createtroopblacklist/CreateTroopUnblockType;", "getType", "()Lcom/tencent/mobileqq/troop/createtroopblacklist/CreateTroopUnblockType;", "setType", "(Lcom/tencent/mobileqq/troop/createtroopblacklist/CreateTroopUnblockType;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/troop/createtroopblacklist/CreateTroopUnblockType;)V", h.F, "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String errMsg;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String leftBtnText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String leftBtnUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String rightBtnText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String rightBtnUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String errTitle;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CreateTroopUnblockType type;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/createtroopblacklist/api/a$a;", "", "", "UNBLOCK_H5_URL", "Ljava/lang/String;", "UNBLOCK_MINI_APP_URL", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.createtroopblacklist.api.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f294753a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23263);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[CreateTroopUnblockType.values().length];
            try {
                iArr[CreateTroopUnblockType.FACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f294753a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23265);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        this(null, null, null, null, null, null, null, 127, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 24)) {
            return;
        }
        iPatchRedirector.redirect((short) 24, (Object) this);
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.errMsg;
    }

    @Nullable
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.errTitle;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.leftBtnText;
    }

    @Nullable
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.leftBtnUrl;
    }

    @Nullable
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.rightBtnText;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.errMsg, aVar.errMsg) && Intrinsics.areEqual(this.leftBtnText, aVar.leftBtnText) && Intrinsics.areEqual(this.leftBtnUrl, aVar.leftBtnUrl) && Intrinsics.areEqual(this.rightBtnText, aVar.rightBtnText) && Intrinsics.areEqual(this.rightBtnUrl, aVar.rightBtnUrl) && Intrinsics.areEqual(this.errTitle, aVar.errTitle) && this.type == aVar.type) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.rightBtnUrl;
    }

    public final void g(@NotNull CreateTroopUnblockType type) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) type);
            return;
        }
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        if (b.f294753a[type.ordinal()] == 1) {
            str = "https://accounts.qq.com/safe/message/unlock?lock_info=9_2";
        } else {
            str = "mqqapi://miniapp/open?_atype=0&_mappid=1109048181&_mvid=&_path=pkgOther%2Fpages%2Fscene_dismissed%2Findex&_vt=3&via=tencent_csd&_sig=2171357820&_nq=type%3Dtime_block%26function_type%3D9";
        }
        this.leftBtnUrl = str;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        int hashCode4 = ((this.errMsg.hashCode() * 31) + this.leftBtnText.hashCode()) * 31;
        String str = this.leftBtnUrl;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode4 + hashCode) * 31;
        String str2 = this.rightBtnText;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.rightBtnUrl;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str4 = this.errTitle;
        if (str4 != null) {
            i3 = str4.hashCode();
        }
        return ((i18 + i3) * 31) + this.type.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "CreateTroopSecurityParams{ errMsg: " + this.errMsg + ",  errTitle: " + this.errTitle + ",leftBtnText: " + this.leftBtnText + ", leftBtnUrl: " + this.leftBtnUrl + ", rightBtnText: " + this.rightBtnText + ", rightBtnUrl: " + this.rightBtnUrl + " }";
    }

    public a(@NotNull String errMsg, @NotNull String leftBtnText, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull CreateTroopUnblockType type) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(leftBtnText, "leftBtnText");
        Intrinsics.checkNotNullParameter(type, "type");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, errMsg, leftBtnText, str, str2, str3, str4, type);
            return;
        }
        this.errMsg = errMsg;
        this.leftBtnText = leftBtnText;
        this.leftBtnUrl = str;
        this.rightBtnText = str2;
        this.rightBtnUrl = str3;
        this.errTitle = str4;
        this.type = type;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ a(String str, String str2, String str3, String str4, String str5, String str6, CreateTroopUnblockType createTroopUnblockType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r6, r7, (i3 & 4) != 0 ? "mqqapi://miniapp/open?_atype=0&_mappid=1109048181&_mvid=&_path=pkgOther%2Fpages%2Fscene_dismissed%2Findex&_vt=3&via=tencent_csd&_sig=2171357820&_nq=type%3Dtime_block%26function_type%3D9" : str3, (i3 & 8) != 0 ? HardCodeUtil.qqStr(R.string.f1380608j) : str4, (i3 & 16) != 0 ? null : str5, (i3 & 32) != 0 ? HardCodeUtil.qqStr(R.string.frc) : str6, (i3 & 64) != 0 ? CreateTroopUnblockType.TIME : createTroopUnblockType);
        String str7;
        String str8;
        if ((i3 & 1) != 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String qqStr = HardCodeUtil.qqStr(R.string.f1355801u);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(com.tencent.mobile\u2026.forbid_create_troop_msg)");
            String format = String.format(qqStr, Arrays.copyOf(new Object[]{HardCodeUtil.qqStr(R.string.f1356101x)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            str7 = format;
        } else {
            str7 = str;
        }
        if ((i3 & 2) != 0) {
            String qqStr2 = HardCodeUtil.qqStr(R.string.f1356101x);
            Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(com.tencent.mobile\u2026ring.forbid_goto_process)");
            str8 = qqStr2;
        } else {
            str8 = str2;
        }
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, str5, str6, createTroopUnblockType, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
