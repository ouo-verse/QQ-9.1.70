package com.tencent.mobileqq.gamecenter.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qqmini.miniapp.widget.media.live.TXJSAdapterConstants;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b4\u0018\u0000 h2\u00020\u0001:\u0001iB\t\b\u0016\u00a2\u0006\u0004\bd\u0010eB\u0011\b\u0016\u0012\u0006\u0010f\u001a\u00020\u0004\u00a2\u0006\u0004\bd\u0010gJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016R$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\"\u0010\u001a\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\f\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R$\u0010#\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\f\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0010R$\u0010&\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\f\u001a\u0004\b'\u0010\u000e\"\u0004\b(\u0010\u0010R$\u0010)\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\f\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010\u0010R\"\u0010-\u001a\u00020,8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00103\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\f\u001a\u0004\b4\u0010\u000e\"\u0004\b5\u0010\u0010R\"\u00107\u001a\u0002068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010=\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010\f\u001a\u0004\b>\u0010\u000e\"\u0004\b?\u0010\u0010R$\u0010@\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010\f\u001a\u0004\bA\u0010\u000e\"\u0004\bB\u0010\u0010R$\u0010C\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010\f\u001a\u0004\bD\u0010\u000e\"\u0004\bE\u0010\u0010R$\u0010F\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010\f\u001a\u0004\bG\u0010\u000e\"\u0004\bH\u0010\u0010R$\u0010I\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010\f\u001a\u0004\bJ\u0010\u000e\"\u0004\bK\u0010\u0010R$\u0010L\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010\f\u001a\u0004\bM\u0010\u000e\"\u0004\bN\u0010\u0010R\"\u0010O\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010\u001b\u001a\u0004\bP\u0010\u001d\"\u0004\bQ\u0010\u001fR$\u0010R\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010\f\u001a\u0004\bS\u0010\u000e\"\u0004\bT\u0010\u0010R$\u0010U\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010\f\u001a\u0004\bV\u0010\u000e\"\u0004\bW\u0010\u0010R$\u0010X\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010\f\u001a\u0004\bY\u0010\u000e\"\u0004\bZ\u0010\u0010R\"\u0010[\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b[\u0010\u001b\u001a\u0004\b\\\u0010\u001d\"\u0004\b]\u0010\u001fR\"\u0010^\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010\u001b\u001a\u0004\b_\u0010\u001d\"\u0004\b`\u0010\u001fR\"\u0010a\u001a\u0002068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\ba\u00108\u001a\u0004\bb\u0010:\"\u0004\bc\u0010<\u00a8\u0006j"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/data/GameInfo;", "Landroid/os/Parcelable;", "", "toString", "Landroid/os/Parcel;", "dest", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", VirtualAppProxy.KEY_GAME_ID, "Ljava/lang/String;", "getGameId", "()Ljava/lang/String;", "setGameId", "(Ljava/lang/String;)V", "appId", "getAppId", "setAppId", "gameName", "getGameName", "setGameName", "configUrl", "getConfigUrl", "setConfigUrl", TXJSAdapterConstants.PLAYER_KEY_PLAY_TYPE, "I", "getPlayType", "()I", "setPlayType", "(I)V", "extraInfo", "getExtraInfo", "setExtraInfo", WadlProxyConsts.KEY_JUMP_URL, "getJumpUrl", "setJumpUrl", "iconUrl", "getIconUrl", "setIconUrl", "loadingUrl", "getLoadingUrl", "setLoadingUrl", "", "autoLogin", "Z", "getAutoLogin", "()Z", "setAutoLogin", "(Z)V", "pskey", "getPskey", "setPskey", "", "startQueueTimeStamp", "J", "getStartQueueTimeStamp", "()J", "setStartQueueTimeStamp", "(J)V", "gameData", "getGameData", "setGameData", "oaid", "getOaid", "setOaid", "dcEventReqCmd", "getDcEventReqCmd", "setDcEventReqCmd", "dcEventReqData", "getDcEventReqData", "setDcEventReqData", "reportChannelId", "getReportChannelId", "setReportChannelId", "reportActId", "getReportActId", "setReportActId", "callbackId", "getCallbackId", "setCallbackId", CommonConstant.KEY_ACCESS_TOKEN, "getAccessToken", "setAccessToken", "payToken", "getPayToken", "setPayToken", "openId", "getOpenId", "setOpenId", "autoLoginForType5Switch", "getAutoLoginForType5Switch", "setAutoLoginForType5Switch", "cloudGameLoginParamV1Switch", "getCloudGameLoginParamV1Switch", "setCloudGameLoginParamV1Switch", "launchGameTimeStamp", "getLaunchGameTimeStamp", "setLaunchGameTimeStamp", "<init>", "()V", "parcel", "(Landroid/os/Parcel;)V", "CREATOR", "a", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GameInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private String accessToken;

    @Nullable
    private String appId;
    private boolean autoLogin;
    private int autoLoginForType5Switch;
    private int callbackId;
    private int cloudGameLoginParamV1Switch;

    @Nullable
    private String configUrl;

    @Nullable
    private String dcEventReqCmd;

    @Nullable
    private String dcEventReqData;

    @Nullable
    private String extraInfo;

    @Nullable
    private String gameData;

    @Nullable
    private String gameId;

    @Nullable
    private String gameName;

    @Nullable
    private String iconUrl;

    @Nullable
    private String jumpUrl;
    private long launchGameTimeStamp;

    @Nullable
    private String loadingUrl;

    @Nullable
    private String oaid;

    @Nullable
    private String openId;

    @Nullable
    private String payToken;
    private int playType;

    @Nullable
    private String pskey;

    @Nullable
    private String reportActId;

    @Nullable
    private String reportChannelId;
    private long startQueueTimeStamp;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/data/GameInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/gamecenter/data/GameInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/gamecenter/data/GameInfo;", "<init>", "()V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.gamecenter.data.GameInfo$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion implements Parcelable.Creator<GameInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GameInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GameInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GameInfo[] newArray(int size) {
            return new GameInfo[size];
        }

        Companion() {
        }
    }

    public GameInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public String getAccessToken() {
        return this.accessToken;
    }

    @Nullable
    public String getAppId() {
        return this.appId;
    }

    public boolean getAutoLogin() {
        return this.autoLogin;
    }

    public int getAutoLoginForType5Switch() {
        return this.autoLoginForType5Switch;
    }

    public int getCallbackId() {
        return this.callbackId;
    }

    public int getCloudGameLoginParamV1Switch() {
        return this.cloudGameLoginParamV1Switch;
    }

    @Nullable
    public String getConfigUrl() {
        return this.configUrl;
    }

    @Nullable
    public String getDcEventReqCmd() {
        return this.dcEventReqCmd;
    }

    @Nullable
    public String getDcEventReqData() {
        return this.dcEventReqData;
    }

    @Nullable
    public String getExtraInfo() {
        return this.extraInfo;
    }

    @Nullable
    public String getGameData() {
        return this.gameData;
    }

    @Nullable
    public String getGameId() {
        return this.gameId;
    }

    @Nullable
    public String getGameName() {
        return this.gameName;
    }

    @Nullable
    public String getIconUrl() {
        return this.iconUrl;
    }

    @Nullable
    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public long getLaunchGameTimeStamp() {
        return this.launchGameTimeStamp;
    }

    @Nullable
    public String getLoadingUrl() {
        return this.loadingUrl;
    }

    @Nullable
    public String getOaid() {
        return this.oaid;
    }

    @Nullable
    public String getOpenId() {
        return this.openId;
    }

    @Nullable
    public String getPayToken() {
        return this.payToken;
    }

    public int getPlayType() {
        return this.playType;
    }

    @Nullable
    public String getPskey() {
        return this.pskey;
    }

    @Nullable
    public String getReportActId() {
        return this.reportActId;
    }

    @Nullable
    public String getReportChannelId() {
        return this.reportChannelId;
    }

    public long getStartQueueTimeStamp() {
        return this.startQueueTimeStamp;
    }

    public void setAccessToken(@Nullable String str) {
        this.accessToken = str;
    }

    public void setAppId(@Nullable String str) {
        this.appId = str;
    }

    public void setAutoLogin(boolean z16) {
        this.autoLogin = z16;
    }

    public void setAutoLoginForType5Switch(int i3) {
        this.autoLoginForType5Switch = i3;
    }

    public void setCallbackId(int i3) {
        this.callbackId = i3;
    }

    public void setCloudGameLoginParamV1Switch(int i3) {
        this.cloudGameLoginParamV1Switch = i3;
    }

    public void setConfigUrl(@Nullable String str) {
        this.configUrl = str;
    }

    public void setDcEventReqCmd(@Nullable String str) {
        this.dcEventReqCmd = str;
    }

    public void setDcEventReqData(@Nullable String str) {
        this.dcEventReqData = str;
    }

    public void setExtraInfo(@Nullable String str) {
        this.extraInfo = str;
    }

    public void setGameData(@Nullable String str) {
        this.gameData = str;
    }

    public void setGameId(@Nullable String str) {
        this.gameId = str;
    }

    public void setGameName(@Nullable String str) {
        this.gameName = str;
    }

    public void setIconUrl(@Nullable String str) {
        this.iconUrl = str;
    }

    public void setJumpUrl(@Nullable String str) {
        this.jumpUrl = str;
    }

    public void setLaunchGameTimeStamp(long j3) {
        this.launchGameTimeStamp = j3;
    }

    public void setLoadingUrl(@Nullable String str) {
        this.loadingUrl = str;
    }

    public void setOaid(@Nullable String str) {
        this.oaid = str;
    }

    public void setOpenId(@Nullable String str) {
        this.openId = str;
    }

    public void setPayToken(@Nullable String str) {
        this.payToken = str;
    }

    public void setPlayType(int i3) {
        this.playType = i3;
    }

    public void setPskey(@Nullable String str) {
        this.pskey = str;
    }

    public void setReportActId(@Nullable String str) {
        this.reportActId = str;
    }

    public void setReportChannelId(@Nullable String str) {
        this.reportChannelId = str;
    }

    public void setStartQueueTimeStamp(long j3) {
        this.startQueueTimeStamp = j3;
    }

    @NotNull
    public String toString() {
        return "GameInfo(gameId=" + getGameId() + ", appId=" + getAppId() + ", gameName=" + getGameName() + ", configUrl=" + getConfigUrl() + ", playType=" + getPlayType() + ", extraInfo=" + getExtraInfo() + ", jumpUrl=" + getJumpUrl() + ", iconUrl=" + getIconUrl() + ", loadingUrl=" + getLoadingUrl() + ", autoLogin=" + getAutoLogin() + ", pskey=" + getPskey() + ", startQueueTimeStamp=" + getStartQueueTimeStamp() + ", gameData=" + getGameData() + ", oaid=" + getOaid() + ", callbackId=" + getCallbackId() + ", accessToken=" + getAccessToken() + ", payToken=" + getPayToken() + ", openId=" + getOpenId() + ", autoLoginForType5Switch=" + getAutoLoginForType5Switch() + ", cloudGameLoginParamV1Switch=" + getCloudGameLoginParamV1Switch() + ", launchGameTimeStamp=" + getLaunchGameTimeStamp() + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(getGameId());
        dest.writeString(getAppId());
        dest.writeString(getGameName());
        dest.writeString(getConfigUrl());
        dest.writeInt(getPlayType());
        dest.writeString(getExtraInfo());
        dest.writeString(getJumpUrl());
        dest.writeString(getIconUrl());
        dest.writeString(getLoadingUrl());
        dest.writeByte(getAutoLogin() ? (byte) 1 : (byte) 0);
        dest.writeString(getPskey());
        dest.writeLong(getStartQueueTimeStamp());
        dest.writeString(getGameData());
        dest.writeString(getOaid());
        dest.writeString(getDcEventReqCmd());
        dest.writeString(getDcEventReqData());
        dest.writeString(getReportChannelId());
        dest.writeString(getReportActId());
        dest.writeInt(getCallbackId());
        dest.writeString(getAccessToken());
        dest.writeString(getPayToken());
        dest.writeString(getOpenId());
        dest.writeInt(getAutoLoginForType5Switch());
        dest.writeInt(getCloudGameLoginParamV1Switch());
        dest.writeLong(getLaunchGameTimeStamp());
    }

    public GameInfo(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        setGameId(parcel.readString());
        setAppId(parcel.readString());
        setGameName(parcel.readString());
        setConfigUrl(parcel.readString());
        setPlayType(parcel.readInt());
        setExtraInfo(parcel.readString());
        setJumpUrl(parcel.readString());
        setIconUrl(parcel.readString());
        setLoadingUrl(parcel.readString());
        setAutoLogin(parcel.readByte() != 0);
        setPskey(parcel.readString());
        setStartQueueTimeStamp(parcel.readLong());
        setGameData(parcel.readString());
        setOaid(parcel.readString());
        setDcEventReqCmd(parcel.readString());
        setDcEventReqData(parcel.readString());
        setReportChannelId(parcel.readString());
        setReportActId(parcel.readString());
        setCallbackId(parcel.readInt());
        setAccessToken(parcel.readString());
        setPayToken(parcel.readString());
        setOpenId(parcel.readString());
        setAutoLoginForType5Switch(parcel.readInt());
        setCloudGameLoginParamV1Switch(parcel.readInt());
        setLaunchGameTimeStamp(parcel.readLong());
    }
}
