package com.tencent.mobileqq.qqlive.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b#\b\u0086\b\u0018\u0000 +2\u00020\u0001:\u0001@Bo\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0011\u00a2\u0006\u0004\b=\u0010>B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b=\u0010?J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u008b\u0001\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u0011H\u00c6\u0001J\t\u0010\u001c\u001a\u00020\fH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010 \u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u00d6\u0003R\u0017\u0010\r\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u000e\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010$R\u0017\u0010\u000f\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b&\u0010\"\u001a\u0004\b'\u0010$R\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b(\u0010\"\u001a\u0004\b)\u0010$R\u0017\u0010\u0012\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\u0013\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b.\u0010\"\u001a\u0004\b/\u0010$R\u0017\u0010\u0014\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u0010-R\u0017\u0010\u0015\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b2\u0010\"\u001a\u0004\b.\u0010$R\u0017\u0010\u0016\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b3\u0010\"\u001a\u0004\b4\u0010$R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0017\u0010\u0018\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b9\u0010\"\u001a\u0004\b:\u0010$R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b;\u00106\u001a\u0004\b%\u00108R\u0017\u0010\u001a\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b6\u0010+\u001a\u0004\b<\u0010-\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/qqlive/login/LiveLoginInfo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "", ReportConstant.COSTREPORT_PREFIX, "t", "describeContents", "", "appId", CommonConstant.KEY_ACCESS_TOKEN, "openId", "businessUid", "", "tinyId", "uin", "uid", "nickname", PhotoCategorySummaryInfo.AVATAR_URL, "sex", ICustomDataEditor.STRING_ARRAY_PARAM_2, "a2ExpireTime", "loginTime", "a", "toString", "hashCode", "", "other", "equals", "d", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "e", "f", DomainData.DOMAIN_NAME, h.F, "k", "i", "J", "p", "()J", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "r", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "D", "E", "j", UserInfo.SEX_FEMALE, "I", "o", "()I", "G", "c", "H", "l", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;IJ)V", "(Landroid/os/Parcel;)V", "b", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class LiveLoginInfo implements Parcelable {
    static IPatchRedirector $redirector_;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<LiveLoginInfo> CREATOR;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private final long uid;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String nickname;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final String avatarUrl;

    /* renamed from: F, reason: from kotlin metadata */
    private final int sex;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final String a2;

    /* renamed from: H, reason: from kotlin metadata */
    private final int a2ExpireTime;

    /* renamed from: I, reason: from kotlin metadata */
    private final long loginTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String accessToken;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String openId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String businessUid;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final long tinyId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String uin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qqlive/login/LiveLoginInfo$a", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/qqlive/login/LiveLoginInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/qqlive/login/LiveLoginInfo;", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a implements Parcelable.Creator<LiveLoginInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LiveLoginInfo createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (LiveLoginInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LiveLoginInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public LiveLoginInfo[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (LiveLoginInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
            }
            return new LiveLoginInfo[size];
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/login/LiveLoginInfo$b;", "", "", "ACCESS_TOKEN_EXPIRE_TIME", "J", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/qqlive/login/LiveLoginInfo;", "CREATOR", "Landroid/os/Parcelable$Creator;", "LIVE_A2_GAP_EXPIRE_TIME", "", "LOG_TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.login.LiveLoginInfo$b, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30689);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 37)) {
            redirector.redirect((short) 37);
        } else {
            INSTANCE = new Companion(null);
            CREATOR = new a();
        }
    }

    public LiveLoginInfo(@NotNull String appId, @NotNull String accessToken, @NotNull String openId, @NotNull String businessUid, long j3, @NotNull String uin, long j16, @NotNull String nickname, @NotNull String avatarUrl, int i3, @NotNull String a26, int i16, long j17) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(openId, "openId");
        Intrinsics.checkNotNullParameter(businessUid, "businessUid");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(a26, "a2");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appId, accessToken, openId, businessUid, Long.valueOf(j3), uin, Long.valueOf(j16), nickname, avatarUrl, Integer.valueOf(i3), a26, Integer.valueOf(i16), Long.valueOf(j17));
            return;
        }
        this.appId = appId;
        this.accessToken = accessToken;
        this.openId = openId;
        this.businessUid = businessUid;
        this.tinyId = j3;
        this.uin = uin;
        this.uid = j16;
        this.nickname = nickname;
        this.avatarUrl = avatarUrl;
        this.sex = i3;
        this.a2 = a26;
        this.a2ExpireTime = i16;
        this.loginTime = j17;
    }

    @NotNull
    public final LiveLoginInfo a(@NotNull String appId, @NotNull String accessToken, @NotNull String openId, @NotNull String businessUid, long tinyId, @NotNull String uin, long uid, @NotNull String nickname, @NotNull String avatarUrl, int sex, @NotNull String a26, int a2ExpireTime, long loginTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (LiveLoginInfo) iPatchRedirector.redirect((short) 33, this, appId, accessToken, openId, businessUid, Long.valueOf(tinyId), uin, Long.valueOf(uid), nickname, avatarUrl, Integer.valueOf(sex), a26, Integer.valueOf(a2ExpireTime), Long.valueOf(loginTime));
        }
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(openId, "openId");
        Intrinsics.checkNotNullParameter(businessUid, "businessUid");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(a26, "a2");
        return new LiveLoginInfo(appId, accessToken, openId, businessUid, tinyId, uin, uid, nickname, avatarUrl, sex, a26, a2ExpireTime, loginTime);
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.a2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return 0;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.a2ExpireTime;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof LiveLoginInfo)) {
            return false;
        }
        LiveLoginInfo liveLoginInfo = (LiveLoginInfo) other;
        if (Intrinsics.areEqual(this.appId, liveLoginInfo.appId) && Intrinsics.areEqual(this.accessToken, liveLoginInfo.accessToken) && Intrinsics.areEqual(this.openId, liveLoginInfo.openId) && Intrinsics.areEqual(this.businessUid, liveLoginInfo.businessUid) && this.tinyId == liveLoginInfo.tinyId && Intrinsics.areEqual(this.uin, liveLoginInfo.uin) && this.uid == liveLoginInfo.uid && Intrinsics.areEqual(this.nickname, liveLoginInfo.nickname) && Intrinsics.areEqual(this.avatarUrl, liveLoginInfo.avatarUrl) && this.sex == liveLoginInfo.sex && Intrinsics.areEqual(this.a2, liveLoginInfo.a2) && this.a2ExpireTime == liveLoginInfo.a2ExpireTime && this.loginTime == liveLoginInfo.loginTime) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.accessToken;
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.appId;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this)).intValue();
        }
        return (((((((((((((((((((((((this.appId.hashCode() * 31) + this.accessToken.hashCode()) * 31) + this.openId.hashCode()) * 31) + this.businessUid.hashCode()) * 31) + androidx.fragment.app.a.a(this.tinyId)) * 31) + this.uin.hashCode()) * 31) + androidx.fragment.app.a.a(this.uid)) * 31) + this.nickname.hashCode()) * 31) + this.avatarUrl.hashCode()) * 31) + this.sex) * 31) + this.a2.hashCode()) * 31) + this.a2ExpireTime) * 31) + androidx.fragment.app.a.a(this.loginTime);
    }

    @NotNull
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.avatarUrl;
    }

    @NotNull
    public final String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.businessUid;
    }

    public final long l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        return this.loginTime;
    }

    @NotNull
    public final String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.nickname;
    }

    @NotNull
    public final String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.openId;
    }

    public final int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.sex;
    }

    public final long p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.tinyId;
    }

    public final long q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        return this.uid;
    }

    @NotNull
    public final String r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.uin;
    }

    public final boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        long j3 = this.loginTime;
        long j16 = serverTime - j3;
        if (j16 >= 0 && j16 < 6000) {
            long j17 = j16 + 259200;
            int i3 = this.a2ExpireTime;
            if (j17 >= i3) {
                AegisLogger.INSTANCE.w("Login|LiveLoginInfo", "isExpired", "a2 expired, now=" + serverTime + ", loginTime=" + j3 + ", expireTime=" + i3);
                return true;
            }
            return false;
        }
        AegisLogger.INSTANCE.w("Login|LiveLoginInfo", "isExpired", "accessToken expired, now=" + serverTime + ", loginTime=" + j3);
        return true;
    }

    public final boolean t() {
        boolean isBlank;
        boolean isBlank2;
        boolean isBlank3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        if (this.uid > 0 && this.tinyId > 0) {
            isBlank = StringsKt__StringsJVMKt.isBlank(this.a2);
            if (!isBlank) {
                isBlank2 = StringsKt__StringsJVMKt.isBlank(this.openId);
                if (!isBlank2) {
                    isBlank3 = StringsKt__StringsJVMKt.isBlank(this.accessToken);
                    if ((!isBlank3) && !s()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return "LiveLoginInfo(appId=" + this.appId + ", accessToken=" + this.accessToken + ", openId=" + this.openId + ", businessUid=" + this.businessUid + ", tinyId=" + this.tinyId + ", uin=" + this.uin + ", uid=" + this.uid + ", nickname=" + this.nickname + ", avatarUrl=" + this.avatarUrl + ", sex=" + this.sex + ", a2=" + this.a2 + ", a2ExpireTime=" + this.a2ExpireTime + ", loginTime=" + this.loginTime + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.appId);
        parcel.writeString(this.accessToken);
        parcel.writeString(this.openId);
        parcel.writeString(this.businessUid);
        parcel.writeLong(this.tinyId);
        parcel.writeString(this.uin);
        parcel.writeLong(this.uid);
        parcel.writeString(this.nickname);
        parcel.writeString(this.avatarUrl);
        parcel.writeInt(this.sex);
        parcel.writeString(this.a2);
        parcel.writeInt(this.a2ExpireTime);
        parcel.writeLong(this.loginTime);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LiveLoginInfo(@NotNull Parcel parcel) {
        this(r4, r5, r6, r7, r8, r10, r11, r13, r14, r15, r1 == null ? "" : r1, parcel.readInt(), parcel.readLong());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        String str2 = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        String str3 = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        String str4 = readString4 == null ? "" : readString4;
        long readLong = parcel.readLong();
        String readString5 = parcel.readString();
        String str5 = readString5 == null ? "" : readString5;
        long readLong2 = parcel.readLong();
        String readString6 = parcel.readString();
        String str6 = readString6 == null ? "" : readString6;
        String readString7 = parcel.readString();
        String str7 = readString7 == null ? "" : readString7;
        int readInt = parcel.readInt();
        String readString8 = parcel.readString();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            return;
        }
        iPatchRedirector.redirect((short) 15, (Object) this, (Object) parcel);
    }
}
