package com.tencent.gdtad.wxmini;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.startup.step.InitSkin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0001@B\u0089\u0001\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t\u0012\b\b\u0002\u0010\u001c\u001a\u00020\t\u0012\b\b\u0002\u0010\u001f\u001a\u00020\t\u0012\b\b\u0002\u0010\"\u001a\u00020\t\u0012\b\b\u0002\u0010%\u001a\u00020\t\u0012\b\b\u0002\u0010(\u001a\u00020\t\u0012\b\b\u0002\u0010+\u001a\u00020\t\u0012\b\b\u0002\u0010.\u001a\u00020\t\u0012\b\b\u0002\u00102\u001a\u000201\u0012\b\b\u0002\u00108\u001a\u00020\u0004\u00a2\u0006\u0004\b;\u0010<B\u0011\b\u0016\u0012\u0006\u0010=\u001a\u00020\u0002\u00a2\u0006\u0004\b;\u0010>J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010\u001c\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\"\u0010\u001f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\"\u0010\"\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\"\u0010%\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u000b\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR\"\u0010(\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u000b\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR\"\u0010+\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u000b\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000fR\"\u0010.\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u000b\u001a\u0004\b/\u0010\r\"\u0004\b0\u0010\u000fR\"\u00102\u001a\u0002018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00108\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010\u0011\u001a\u0004\b9\u0010\u0013\"\u0004\b:\u0010\u0015\u00a8\u0006A"}, d2 = {"Lcom/tencent/gdtad/wxmini/GdtWXMiniData;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "channelAppID", "Ljava/lang/String;", "getChannelAppID", "()Ljava/lang/String;", "setChannelAppID", "(Ljava/lang/String;)V", "openType", "I", "getOpenType", "()I", "setOpenType", "(I)V", "token", "getToken", "setToken", "appID", "getAppID", "setAppID", "userName", "getUserName", "setUserName", "path", "getPath", "setPath", "traceData", "getTraceData", "setTraceData", "aid", "getAid", "setAid", "posId", "getPosId", "setPosId", "traceId", "getTraceId", "setTraceId", "extData", "getExtData", "setExtData", "", "reportForLink", "Z", "getReportForLink", "()Z", "setReportForLink", "(Z)V", "adErrorCode", "getAdErrorCode", "setAdErrorCode", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V", "parcel", "(Landroid/os/Parcel;)V", "CREATOR", "a", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GdtWXMiniData implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String IPC_DATA_NAME = "gdt_wxmini_data";
    private int adErrorCode;

    @NotNull
    private String aid;

    @NotNull
    private String appID;

    @NotNull
    private String channelAppID;

    @NotNull
    private String extData;
    private int openType;

    @NotNull
    private String path;

    @NotNull
    private String posId;
    private boolean reportForLink;

    @NotNull
    private String token;

    @NotNull
    private String traceData;

    @NotNull
    private String traceId;

    @NotNull
    private String userName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/gdtad/wxmini/GdtWXMiniData$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/gdtad/wxmini/GdtWXMiniData;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/gdtad/wxmini/GdtWXMiniData;", "", "IPC_DATA_NAME", "Ljava/lang/String;", "<init>", "()V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.gdtad.wxmini.GdtWXMiniData$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion implements Parcelable.Creator<GdtWXMiniData> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GdtWXMiniData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GdtWXMiniData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GdtWXMiniData[] newArray(int size) {
            return new GdtWXMiniData[size];
        }

        Companion() {
        }
    }

    public GdtWXMiniData() {
        this(null, 0, null, null, null, null, null, null, null, null, null, false, 0, InitSkin.DRAWABLE_COUNT, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getAdErrorCode() {
        return this.adErrorCode;
    }

    @NotNull
    public final String getAid() {
        return this.aid;
    }

    @NotNull
    public final String getAppID() {
        return this.appID;
    }

    @NotNull
    public final String getChannelAppID() {
        return this.channelAppID;
    }

    @NotNull
    public final String getExtData() {
        return this.extData;
    }

    public final int getOpenType() {
        return this.openType;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    @NotNull
    public final String getPosId() {
        return this.posId;
    }

    public final boolean getReportForLink() {
        return this.reportForLink;
    }

    @NotNull
    public final String getToken() {
        return this.token;
    }

    @NotNull
    public final String getTraceData() {
        return this.traceData;
    }

    @NotNull
    public final String getTraceId() {
        return this.traceId;
    }

    @NotNull
    public final String getUserName() {
        return this.userName;
    }

    public final void setAdErrorCode(int i3) {
        this.adErrorCode = i3;
    }

    public final void setAid(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.aid = str;
    }

    public final void setAppID(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appID = str;
    }

    public final void setChannelAppID(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channelAppID = str;
    }

    public final void setExtData(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extData = str;
    }

    public final void setOpenType(int i3) {
        this.openType = i3;
    }

    public final void setPath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.path = str;
    }

    public final void setPosId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.posId = str;
    }

    public final void setReportForLink(boolean z16) {
        this.reportForLink = z16;
    }

    public final void setToken(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.token = str;
    }

    public final void setTraceData(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.traceData = str;
    }

    public final void setTraceId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.traceId = str;
    }

    public final void setUserName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userName = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.channelAppID);
        dest.writeInt(this.openType);
        dest.writeString(this.token);
        dest.writeString(this.appID);
        dest.writeString(this.userName);
        dest.writeString(this.path);
        dest.writeString(this.traceData);
        dest.writeString(this.aid);
        dest.writeString(this.posId);
        dest.writeString(this.traceId);
        dest.writeString(this.extData);
        dest.writeInt(this.reportForLink ? 1 : 0);
        dest.writeInt(this.adErrorCode);
    }

    public GdtWXMiniData(@NotNull String channelAppID, int i3, @NotNull String token, @NotNull String appID, @NotNull String userName, @NotNull String path, @NotNull String traceData, @NotNull String aid, @NotNull String posId, @NotNull String traceId, @NotNull String extData, boolean z16, int i16) {
        Intrinsics.checkNotNullParameter(channelAppID, "channelAppID");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(appID, "appID");
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(traceData, "traceData");
        Intrinsics.checkNotNullParameter(aid, "aid");
        Intrinsics.checkNotNullParameter(posId, "posId");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(extData, "extData");
        this.channelAppID = channelAppID;
        this.openType = i3;
        this.token = token;
        this.appID = appID;
        this.userName = userName;
        this.path = path;
        this.traceData = traceData;
        this.aid = aid;
        this.posId = posId;
        this.traceId = traceId;
        this.extData = extData;
        this.reportForLink = z16;
        this.adErrorCode = i16;
    }

    public /* synthetic */ GdtWXMiniData(String str, int i3, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z16, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? Integer.MAX_VALUE : i3, (i17 & 4) != 0 ? "" : str2, (i17 & 8) != 0 ? "" : str3, (i17 & 16) != 0 ? "" : str4, (i17 & 32) != 0 ? "" : str5, (i17 & 64) != 0 ? "" : str6, (i17 & 128) != 0 ? "" : str7, (i17 & 256) != 0 ? "" : str8, (i17 & 512) != 0 ? "" : str9, (i17 & 1024) == 0 ? str10 : "", (i17 & 2048) != 0 ? false : z16, (i17 & 4096) == 0 ? i16 : 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GdtWXMiniData(@NotNull Parcel parcel) {
        this(null, 0, null, null, null, null, null, null, null, null, null, false, 0, InitSkin.DRAWABLE_COUNT, null);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        this.channelAppID = readString == null ? "" : readString;
        this.openType = parcel.readInt();
        String readString2 = parcel.readString();
        this.token = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        this.appID = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        this.userName = readString4 == null ? "" : readString4;
        String readString5 = parcel.readString();
        this.path = readString5 == null ? "" : readString5;
        String readString6 = parcel.readString();
        this.traceData = readString6 == null ? "" : readString6;
        String readString7 = parcel.readString();
        this.aid = readString7 == null ? "" : readString7;
        String readString8 = parcel.readString();
        this.posId = readString8 == null ? "" : readString8;
        String readString9 = parcel.readString();
        this.traceId = readString9 == null ? "" : readString9;
        String readString10 = parcel.readString();
        this.extData = readString10 != null ? readString10 : "";
        this.reportForLink = parcel.readInt() == 1;
        this.adErrorCode = parcel.readInt();
    }
}
