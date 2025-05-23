package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b.\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 _2\u00020\u0001:\u0001_B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010Z\u001a\u00020\u0007H\u0016J\b\u0010[\u001a\u00020\u0016H\u0016J\u0018\u0010\\\u001a\u00020]2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010^\u001a\u00020\u0007H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR\u001a\u0010\u001e\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR\u001a\u0010!\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001a\u0010$\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011R\u001a\u0010'\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001aR\u001a\u0010*\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\t\"\u0004\b,\u0010\u000bR\u001a\u0010-\u001a\u00020.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0018\"\u0004\b5\u0010\u001aR\u001a\u00106\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0018\"\u0004\b8\u0010\u001aR\u001a\u00109\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\t\"\u0004\b;\u0010\u000bR\u001a\u0010<\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u000f\"\u0004\b>\u0010\u0011R\u001a\u0010?\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0018\"\u0004\bA\u0010\u001aR\u001a\u0010B\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0018\"\u0004\bD\u0010\u001aR\u001a\u0010E\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\t\"\u0004\bG\u0010\u000bR\u001a\u0010H\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0018\"\u0004\bJ\u0010\u001aR\u001a\u0010K\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\t\"\u0004\bM\u0010\u000bR\u001a\u0010N\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0018\"\u0004\bP\u0010\u001aR\u001a\u0010Q\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0018\"\u0004\bS\u0010\u001aR\u001a\u0010T\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\t\"\u0004\bV\u0010\u000bR\u001a\u0010W\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u0018\"\u0004\bY\u0010\u001a\u00a8\u0006`"}, d2 = {"Lcom/tencent/qqmini/sdk/launcher/model/StartupReportData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "adFlag", "", "getAdFlag", "()I", "setAdFlag", "(I)V", "apkgSize", "", "getApkgSize", "()J", "setApkgSize", "(J)V", "apkgState", "getApkgState", "setApkgState", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "appInfoFlag", "getAppInfoFlag", "setAppInfoFlag", "appType", "getAppType", "setAppType", AdMetricTag.EVENT_NAME, "getEventName", "setEventName", "eventTime", "getEventTime", "setEventTime", "extReportData", "getExtReportData", "setExtReportData", "gameEngineFlag", "getGameEngineFlag", "setGameEngineFlag", "hasPaused", "", "getHasPaused", "()Z", "setHasPaused", "(Z)V", "jsLibVersion", "getJsLibVersion", "setJsLibVersion", "mode", "getMode", "setMode", "preloadFlag", "getPreloadFlag", "setPreloadFlag", "relativeTime", "getRelativeTime", "setRelativeTime", "reportEventKey", "getReportEventKey", "setReportEventKey", "reportEventValue", "getReportEventValue", "setReportEventValue", "startupFlag", "getStartupFlag", "setStartupFlag", "startupId", "getStartupId", "setStartupId", "startupScene", "getStartupScene", "setStartupScene", "tritonVersion", "getTritonVersion", "setTritonVersion", "versionId", "getVersionId", "setVersionId", "versionType", "getVersionType", "setVersionType", "via", "getVia", "setVia", "describeContents", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "CREATOR", "lib_minilauncher_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final class StartupReportData implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int adFlag;
    private long apkgSize;
    private int apkgState;

    @NotNull
    private String appId;
    private int appInfoFlag;
    private int appType;

    @NotNull
    private String eventName;
    private long eventTime;

    @NotNull
    private String extReportData;
    private int gameEngineFlag;
    private boolean hasPaused;

    @NotNull
    private String jsLibVersion;

    @NotNull
    private String mode;
    private int preloadFlag;
    private long relativeTime;

    @NotNull
    private String reportEventKey;

    @NotNull
    private String reportEventValue;
    private int startupFlag;

    @NotNull
    private String startupId;
    private int startupScene;

    @NotNull
    private String tritonVersion;

    @NotNull
    private String versionId;
    private int versionType;

    @NotNull
    private String via;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqmini/sdk/launcher/model/StartupReportData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qqmini/sdk/launcher/model/StartupReportData;", "()V", "copy", "data", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/qqmini/sdk/launcher/model/StartupReportData;", "lib_minilauncher_internalRelease"}, k = 1, mv = {1, 1, 16})
    /* renamed from: com.tencent.qqmini.sdk.launcher.model.StartupReportData$CREATOR, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion implements Parcelable.Creator<StartupReportData> {
        Companion() {
        }

        @NotNull
        public final StartupReportData copy(@NotNull StartupReportData data) {
            Intrinsics.checkParameterIsNotNull(data, "data");
            StartupReportData startupReportData = new StartupReportData();
            startupReportData.setStartupId(data.getStartupId());
            startupReportData.setEventName(data.getEventName());
            startupReportData.setEventTime(data.getEventTime());
            startupReportData.setRelativeTime(data.getRelativeTime());
            startupReportData.setAppId(data.getAppId());
            startupReportData.setStartupScene(data.getStartupScene());
            startupReportData.setAppType(data.getAppType());
            startupReportData.setAppInfoFlag(data.getAppInfoFlag());
            startupReportData.setGameEngineFlag(data.getGameEngineFlag());
            startupReportData.setStartupFlag(data.getStartupFlag());
            startupReportData.setPreloadFlag(data.getPreloadFlag());
            startupReportData.setAdFlag(data.getAdFlag());
            startupReportData.setApkgState(data.getApkgState());
            startupReportData.setApkgSize(data.getApkgSize());
            startupReportData.setVersionType(data.getVersionType());
            startupReportData.setVersionId(data.getVersionId());
            startupReportData.setVia(data.getVia());
            startupReportData.setMode(data.getMode());
            startupReportData.setExtReportData(data.getExtReportData());
            startupReportData.setReportEventKey(data.getReportEventKey());
            startupReportData.setReportEventValue(data.getReportEventValue());
            startupReportData.setJsLibVersion(data.getJsLibVersion());
            startupReportData.setTritonVersion(data.getTritonVersion());
            startupReportData.setHasPaused(data.getHasPaused());
            return startupReportData;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public StartupReportData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new StartupReportData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public StartupReportData[] newArray(int size) {
            return new StartupReportData[size];
        }
    }

    public StartupReportData() {
        this.startupId = "";
        this.eventName = "";
        this.appId = "";
        this.versionId = "";
        this.via = "";
        this.mode = "";
        this.extReportData = "";
        this.reportEventKey = "";
        this.reportEventValue = "";
        this.jsLibVersion = "";
        this.tritonVersion = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getAdFlag() {
        return this.adFlag;
    }

    public final long getApkgSize() {
        return this.apkgSize;
    }

    public final int getApkgState() {
        return this.apkgState;
    }

    @NotNull
    public final String getAppId() {
        return this.appId;
    }

    public final int getAppInfoFlag() {
        return this.appInfoFlag;
    }

    public final int getAppType() {
        return this.appType;
    }

    @NotNull
    public final String getEventName() {
        return this.eventName;
    }

    public final long getEventTime() {
        return this.eventTime;
    }

    @NotNull
    public final String getExtReportData() {
        return this.extReportData;
    }

    public final int getGameEngineFlag() {
        return this.gameEngineFlag;
    }

    public final boolean getHasPaused() {
        return this.hasPaused;
    }

    @NotNull
    public final String getJsLibVersion() {
        return this.jsLibVersion;
    }

    @NotNull
    public final String getMode() {
        return this.mode;
    }

    public final int getPreloadFlag() {
        return this.preloadFlag;
    }

    public final long getRelativeTime() {
        return this.relativeTime;
    }

    @NotNull
    public final String getReportEventKey() {
        return this.reportEventKey;
    }

    @NotNull
    public final String getReportEventValue() {
        return this.reportEventValue;
    }

    public final int getStartupFlag() {
        return this.startupFlag;
    }

    @NotNull
    public final String getStartupId() {
        return this.startupId;
    }

    public final int getStartupScene() {
        return this.startupScene;
    }

    @NotNull
    public final String getTritonVersion() {
        return this.tritonVersion;
    }

    @NotNull
    public final String getVersionId() {
        return this.versionId;
    }

    public final int getVersionType() {
        return this.versionType;
    }

    @NotNull
    public final String getVia() {
        return this.via;
    }

    public final void setAdFlag(int i3) {
        this.adFlag = i3;
    }

    public final void setApkgSize(long j3) {
        this.apkgSize = j3;
    }

    public final void setApkgState(int i3) {
        this.apkgState = i3;
    }

    public final void setAppId(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.appId = str;
    }

    public final void setAppInfoFlag(int i3) {
        this.appInfoFlag = i3;
    }

    public final void setAppType(int i3) {
        this.appType = i3;
    }

    public final void setEventName(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.eventName = str;
    }

    public final void setEventTime(long j3) {
        this.eventTime = j3;
    }

    public final void setExtReportData(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.extReportData = str;
    }

    public final void setGameEngineFlag(int i3) {
        this.gameEngineFlag = i3;
    }

    public final void setHasPaused(boolean z16) {
        this.hasPaused = z16;
    }

    public final void setJsLibVersion(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.jsLibVersion = str;
    }

    public final void setMode(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.mode = str;
    }

    public final void setPreloadFlag(int i3) {
        this.preloadFlag = i3;
    }

    public final void setRelativeTime(long j3) {
        this.relativeTime = j3;
    }

    public final void setReportEventKey(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.reportEventKey = str;
    }

    public final void setReportEventValue(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.reportEventValue = str;
    }

    public final void setStartupFlag(int i3) {
        this.startupFlag = i3;
    }

    public final void setStartupId(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.startupId = str;
    }

    public final void setStartupScene(int i3) {
        this.startupScene = i3;
    }

    public final void setTritonVersion(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.tritonVersion = str;
    }

    public final void setVersionId(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.versionId = str;
    }

    public final void setVersionType(int i3) {
        this.versionType = i3;
    }

    public final void setVia(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.via = str;
    }

    @NotNull
    public String toString() {
        return "StartupReportData(startupId='" + this.startupId + "', eventName='" + this.eventName + "', appId='" + this.appId + "', startupScene=" + this.startupScene + ", eventTime=" + this.eventTime + ", relativeTime=" + this.relativeTime + ", appType=" + this.appType + ", appInfoFlag=" + this.appInfoFlag + ", gameEngineFlag=" + this.gameEngineFlag + ", startupFlag=" + this.startupFlag + ", preloadFlag=" + this.preloadFlag + ", adFlag=" + this.adFlag + ", apkgState=" + this.apkgState + ", apkgSize=" + this.apkgSize + ", versionType=" + this.versionType + ", versionId='" + this.versionId + "', via='" + this.via + "', mode='" + this.mode + "', extReportData='" + this.extReportData + "', reportEventKey='" + this.reportEventKey + "', reportEventValue='" + this.reportEventValue + "', jsLibVersion='" + this.jsLibVersion + "', tritonVersion='" + this.tritonVersion + "', hasPaused='" + this.hasPaused + "')";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.startupId);
        parcel.writeString(this.eventName);
        parcel.writeString(this.appId);
        parcel.writeInt(this.startupScene);
        parcel.writeLong(this.eventTime);
        parcel.writeLong(this.relativeTime);
        parcel.writeInt(this.appType);
        parcel.writeInt(this.appInfoFlag);
        parcel.writeInt(this.gameEngineFlag);
        parcel.writeInt(this.startupFlag);
        parcel.writeInt(this.preloadFlag);
        parcel.writeInt(this.adFlag);
        parcel.writeInt(this.apkgState);
        parcel.writeLong(this.apkgSize);
        parcel.writeInt(this.versionType);
        parcel.writeString(this.versionId);
        parcel.writeString(this.via);
        parcel.writeString(this.mode);
        parcel.writeString(this.extReportData);
        parcel.writeString(this.reportEventKey);
        parcel.writeString(this.reportEventValue);
        parcel.writeString(this.jsLibVersion);
        parcel.writeString(this.tritonVersion);
        parcel.writeInt(this.hasPaused ? 1 : 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StartupReportData(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        String readString = parcel.readString();
        this.startupId = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.eventName = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        this.appId = readString3 == null ? "" : readString3;
        this.startupScene = parcel.readInt();
        this.eventTime = parcel.readLong();
        this.relativeTime = parcel.readLong();
        this.appType = parcel.readInt();
        this.appInfoFlag = parcel.readInt();
        this.gameEngineFlag = parcel.readInt();
        this.startupFlag = parcel.readInt();
        this.preloadFlag = parcel.readInt();
        this.adFlag = parcel.readInt();
        this.apkgState = parcel.readInt();
        this.apkgSize = parcel.readLong();
        this.versionType = parcel.readInt();
        String readString4 = parcel.readString();
        this.versionId = readString4 == null ? "" : readString4;
        String readString5 = parcel.readString();
        this.via = readString5 == null ? "" : readString5;
        String readString6 = parcel.readString();
        this.mode = readString6 == null ? "" : readString6;
        String readString7 = parcel.readString();
        this.extReportData = readString7 == null ? "" : readString7;
        String readString8 = parcel.readString();
        this.reportEventKey = readString8 == null ? "" : readString8;
        String readString9 = parcel.readString();
        this.reportEventValue = readString9 == null ? "" : readString9;
        String readString10 = parcel.readString();
        this.jsLibVersion = readString10 == null ? "" : readString10;
        String readString11 = parcel.readString();
        this.tritonVersion = readString11 != null ? readString11 : "";
        this.hasPaused = parcel.readInt() == 1;
    }
}
