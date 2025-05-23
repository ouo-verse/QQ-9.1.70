package com.tencent.mobileqq.icgame.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b%\b\u0086\b\u0018\u0000 B2\u00020\u0001:\u0001CBw\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0011\u0012\u0006\u0010\u001b\u001a\u00020\u0011\u00a2\u0006\u0004\b?\u0010@B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b?\u0010AJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0095\u0001\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u0011H\u00c6\u0001J\t\u0010\u001d\u001a\u00020\fH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010!\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u00d6\u0003R\u0017\u0010\r\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\u000e\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b&\u0010#\u001a\u0004\b'\u0010%R\u0017\u0010\u000f\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b'\u0010#\u001a\u0004\b(\u0010%R\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b)\u0010#\u001a\u0004\b*\u0010%R\u0017\u0010\u0012\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010\u0013\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b/\u0010#\u001a\u0004\b0\u0010%R\u0017\u0010\u0014\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b1\u0010,\u001a\u0004\b2\u0010.R\u0017\u0010\u0015\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b3\u0010#\u001a\u0004\b/\u0010%R\u0017\u0010\u0016\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b4\u0010#\u001a\u0004\b5\u0010%R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0017\u0010\u0018\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b:\u0010#\u001a\u0004\b;\u0010%R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b<\u00107\u001a\u0004\b&\u00109R\u0017\u0010\u001a\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b7\u0010,\u001a\u0004\b=\u0010.R\u0017\u0010\u001b\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b,\u0010,\u001a\u0004\b>\u0010.\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/icgame/login/LiveLoginInfo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "t", "u", "describeContents", "", "appId", CommonConstant.KEY_ACCESS_TOKEN, "openId", "businessUid", "", "tinyId", "uin", "uid", "nickname", PhotoCategorySummaryInfo.AVATAR_URL, "sex", ICustomDataEditor.STRING_ARRAY_PARAM_2, "a2ExpireTime", "loginTime", "openidExpireTime", "a", "toString", "hashCode", "", "other", "equals", "d", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "e", "f", DomainData.DOMAIN_NAME, h.F, "k", "i", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()J", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ReportConstant.COSTREPORT_PREFIX, BdhLogUtil.LogTag.Tag_Conn, "r", "D", "E", "j", UserInfo.SEX_FEMALE, "I", "p", "()I", "G", "c", "H", "l", "o", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;IJJ)V", "(Landroid/os/Parcel;)V", "K", "b", "ic-game-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final /* data */ class LiveLoginInfo implements Parcelable {

    /* renamed from: C, reason: from kotlin metadata and from toString */
    private final long uid;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    @NotNull
    private final String nickname;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    @NotNull
    private final String avatarUrl;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    private final int sex;

    /* renamed from: G, reason: from kotlin metadata and from toString */
    @NotNull
    private final String a2;

    /* renamed from: H, reason: from kotlin metadata and from toString */
    private final int a2ExpireTime;

    /* renamed from: I, reason: from kotlin metadata and from toString */
    private final long loginTime;

    /* renamed from: J, reason: from kotlin metadata and from toString */
    private final long openidExpireTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String appId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String accessToken;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String openId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String businessUid;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final long tinyId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String uin;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<LiveLoginInfo> CREATOR = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/icgame/login/LiveLoginInfo$a", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/icgame/login/LiveLoginInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/icgame/login/LiveLoginInfo;", "ic-game-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements Parcelable.Creator<LiveLoginInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LiveLoginInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LiveLoginInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public LiveLoginInfo[] newArray(int size) {
            return new LiveLoginInfo[size];
        }
    }

    public LiveLoginInfo(@NotNull String appId, @NotNull String accessToken, @NotNull String openId, @NotNull String businessUid, long j3, @NotNull String uin, long j16, @NotNull String nickname, @NotNull String avatarUrl, int i3, @NotNull String a26, int i16, long j17, long j18) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(openId, "openId");
        Intrinsics.checkNotNullParameter(businessUid, "businessUid");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(a26, "a2");
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
        this.openidExpireTime = j18;
    }

    @NotNull
    public final LiveLoginInfo a(@NotNull String appId, @NotNull String accessToken, @NotNull String openId, @NotNull String businessUid, long tinyId, @NotNull String uin, long uid, @NotNull String nickname, @NotNull String avatarUrl, int sex, @NotNull String a26, int a2ExpireTime, long loginTime, long openidExpireTime) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(openId, "openId");
        Intrinsics.checkNotNullParameter(businessUid, "businessUid");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(a26, "a2");
        return new LiveLoginInfo(appId, accessToken, openId, businessUid, tinyId, uin, uid, nickname, avatarUrl, sex, a26, a2ExpireTime, loginTime, openidExpireTime);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getA2() {
        return this.a2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final int getA2ExpireTime() {
        return this.a2ExpireTime;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LiveLoginInfo)) {
            return false;
        }
        LiveLoginInfo liveLoginInfo = (LiveLoginInfo) other;
        if (Intrinsics.areEqual(this.appId, liveLoginInfo.appId) && Intrinsics.areEqual(this.accessToken, liveLoginInfo.accessToken) && Intrinsics.areEqual(this.openId, liveLoginInfo.openId) && Intrinsics.areEqual(this.businessUid, liveLoginInfo.businessUid) && this.tinyId == liveLoginInfo.tinyId && Intrinsics.areEqual(this.uin, liveLoginInfo.uin) && this.uid == liveLoginInfo.uid && Intrinsics.areEqual(this.nickname, liveLoginInfo.nickname) && Intrinsics.areEqual(this.avatarUrl, liveLoginInfo.avatarUrl) && this.sex == liveLoginInfo.sex && Intrinsics.areEqual(this.a2, liveLoginInfo.a2) && this.a2ExpireTime == liveLoginInfo.a2ExpireTime && this.loginTime == liveLoginInfo.loginTime && this.openidExpireTime == liveLoginInfo.openidExpireTime) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.appId.hashCode() * 31) + this.accessToken.hashCode()) * 31) + this.openId.hashCode()) * 31) + this.businessUid.hashCode()) * 31) + androidx.fragment.app.a.a(this.tinyId)) * 31) + this.uin.hashCode()) * 31) + androidx.fragment.app.a.a(this.uid)) * 31) + this.nickname.hashCode()) * 31) + this.avatarUrl.hashCode()) * 31) + this.sex) * 31) + this.a2.hashCode()) * 31) + this.a2ExpireTime) * 31) + androidx.fragment.app.a.a(this.loginTime)) * 31) + androidx.fragment.app.a.a(this.openidExpireTime);
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getBusinessUid() {
        return this.businessUid;
    }

    /* renamed from: l, reason: from getter */
    public final long getLoginTime() {
        return this.loginTime;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final String getOpenId() {
        return this.openId;
    }

    /* renamed from: o, reason: from getter */
    public final long getOpenidExpireTime() {
        return this.openidExpireTime;
    }

    /* renamed from: p, reason: from getter */
    public final int getSex() {
        return this.sex;
    }

    /* renamed from: q, reason: from getter */
    public final long getTinyId() {
        return this.tinyId;
    }

    /* renamed from: r, reason: from getter */
    public final long getUid() {
        return this.uid;
    }

    @NotNull
    /* renamed from: s, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public final boolean t() {
        long serverTime = NetConnInfoCenter.getServerTime();
        long j3 = this.loginTime;
        if (serverTime - j3 >= 7200) {
            rt0.a.INSTANCE.q("ICGameLogin|ICGameLiveLoginInfo", "isExpired", "loginTime expired, now=" + serverTime + ", loginTime=" + j3);
            return true;
        }
        long j16 = (serverTime - j3) + 259200;
        int i3 = this.a2ExpireTime;
        if (j16 >= i3) {
            rt0.a.INSTANCE.q("ICGameLogin|ICGameLiveLoginInfo", "isExpired", "a2 expired, now=" + serverTime + ", loginTime=" + j3 + ", expireTime=" + i3);
            return true;
        }
        long seconds = TimeUnit.DAYS.toSeconds(3L) + serverTime;
        long j17 = this.openidExpireTime;
        if (seconds >= j17) {
            rt0.a.INSTANCE.q("ICGameLogin|ICGameLiveLoginInfo", "isExpired", "accessToken, now=" + serverTime + ", expireTime=" + j17);
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        return "LiveLoginInfo(appId=" + this.appId + ", accessToken=" + this.accessToken + ", openId=" + this.openId + ", businessUid=" + this.businessUid + ", tinyId=" + this.tinyId + ", uin=" + this.uin + ", uid=" + this.uid + ", nickname=" + this.nickname + ", avatarUrl=" + this.avatarUrl + ", sex=" + this.sex + ", a2=" + this.a2 + ", a2ExpireTime=" + this.a2ExpireTime + ", loginTime=" + this.loginTime + ", openidExpireTime=" + this.openidExpireTime + ")";
    }

    public final boolean u() {
        boolean isBlank;
        boolean isBlank2;
        boolean isBlank3;
        if (this.uid > 0 && this.tinyId > 0) {
            isBlank = StringsKt__StringsJVMKt.isBlank(this.a2);
            if (!isBlank) {
                isBlank2 = StringsKt__StringsJVMKt.isBlank(this.openId);
                if (!isBlank2) {
                    isBlank3 = StringsKt__StringsJVMKt.isBlank(this.accessToken);
                    if ((!isBlank3) && !t()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
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
        parcel.writeLong(this.openidExpireTime);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LiveLoginInfo(@NotNull Parcel parcel) {
        this(r4, r5, r6, r7, r8, r10, r11, r13, r14, r15, r0 == null ? "" : r0, parcel.readInt(), parcel.readLong(), parcel.readLong());
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
    }
}
