package com.tencent.gdtad.params;

import androidx.fragment.app.a;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vas.VasUserData;
import cooperation.vip.tianshu.TianShuMMKVConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001.B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0005H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\bH\u00c6\u0003J\t\u0010%\u001a\u00020\u0005H\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010'\u001a\u00020\u0005H\u00c6\u0003JO\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010,\u001a\u00020\u0003H\u00d6\u0001J\t\u0010-\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018\u00a8\u0006/"}, d2 = {"Lcom/tencent/gdtad/params/GdtSsoReportMiniParam;", "", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "", "aid", "", "actionType", TianShuMMKVConstant.UserActionKey.ACTION_TIME, "", VasUserData.Key.QQ_VER, "osType", "appId", "(ILjava/lang/String;IJLjava/lang/String;ILjava/lang/String;)V", "getActionTime", "()J", "setActionTime", "(J)V", "getActionType", "()I", "setActionType", "(I)V", "getAid", "()Ljava/lang/String;", "setAid", "(Ljava/lang/String;)V", "getAppId", "setAppId", "getBusiType", "setBusiType", "getOsType", "setOsType", "getQqVer", "setQqVer", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "Builder", "qqad-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class GdtSsoReportMiniParam {
    private long actionTime;
    private int actionType;

    @NotNull
    private String aid;

    @NotNull
    private String appId;
    private int busiType;
    private int osType;

    @NotNull
    private String qqVer;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \r*\u0004\u0018\u00010\b0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/gdtad/params/GdtSsoReportMiniParam$Builder;", "", "()V", TianShuMMKVConstant.UserActionKey.ACTION_TIME, "", "actionType", "", "aid", "", "appId", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "osType", VasUserData.Key.QQ_VER, "kotlin.jvm.PlatformType", "build", "Lcom/tencent/gdtad/params/GdtSsoReportMiniParam;", "setAId", "aId", "setActionTime", "setActionType", "setAppId", "setBusiType", "qqad-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Builder {
        private int actionType;
        private int busiType = 11;

        @NotNull
        private String aid = "";
        private long actionTime = NetConnInfoCenter.getServerTime();
        private String qqVer = ah.P();
        private int osType = 2;

        @NotNull
        private String appId = "";

        @NotNull
        public final GdtSsoReportMiniParam build() {
            int i3 = this.busiType;
            String str = this.aid;
            int i16 = this.actionType;
            long j3 = this.actionTime;
            String qqVer = this.qqVer;
            Intrinsics.checkNotNullExpressionValue(qqVer, "qqVer");
            return new GdtSsoReportMiniParam(i3, str, i16, j3, qqVer, this.osType, this.appId);
        }

        @NotNull
        public final Builder setAId(@NotNull String aId) {
            Intrinsics.checkNotNullParameter(aId, "aId");
            this.aid = aId;
            return this;
        }

        @NotNull
        public final Builder setActionTime(long actionTime) {
            this.actionTime = actionTime;
            return this;
        }

        @NotNull
        public final Builder setActionType(int actionType) {
            this.actionType = actionType;
            return this;
        }

        @NotNull
        public final Builder setAppId(@NotNull String appId) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            this.appId = appId;
            return this;
        }

        @NotNull
        public final Builder setBusiType(int busiType) {
            this.busiType = busiType;
            return this;
        }
    }

    public GdtSsoReportMiniParam(int i3, @NotNull String aid, int i16, long j3, @NotNull String qqVer, int i17, @NotNull String appId) {
        Intrinsics.checkNotNullParameter(aid, "aid");
        Intrinsics.checkNotNullParameter(qqVer, "qqVer");
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.busiType = i3;
        this.aid = aid;
        this.actionType = i16;
        this.actionTime = j3;
        this.qqVer = qqVer;
        this.osType = i17;
        this.appId = appId;
    }

    public static /* synthetic */ GdtSsoReportMiniParam copy$default(GdtSsoReportMiniParam gdtSsoReportMiniParam, int i3, String str, int i16, long j3, String str2, int i17, String str3, int i18, Object obj) {
        int i19;
        String str4;
        int i26;
        long j16;
        String str5;
        int i27;
        String str6;
        if ((i18 & 1) != 0) {
            i19 = gdtSsoReportMiniParam.busiType;
        } else {
            i19 = i3;
        }
        if ((i18 & 2) != 0) {
            str4 = gdtSsoReportMiniParam.aid;
        } else {
            str4 = str;
        }
        if ((i18 & 4) != 0) {
            i26 = gdtSsoReportMiniParam.actionType;
        } else {
            i26 = i16;
        }
        if ((i18 & 8) != 0) {
            j16 = gdtSsoReportMiniParam.actionTime;
        } else {
            j16 = j3;
        }
        if ((i18 & 16) != 0) {
            str5 = gdtSsoReportMiniParam.qqVer;
        } else {
            str5 = str2;
        }
        if ((i18 & 32) != 0) {
            i27 = gdtSsoReportMiniParam.osType;
        } else {
            i27 = i17;
        }
        if ((i18 & 64) != 0) {
            str6 = gdtSsoReportMiniParam.appId;
        } else {
            str6 = str3;
        }
        return gdtSsoReportMiniParam.copy(i19, str4, i26, j16, str5, i27, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final int getBusiType() {
        return this.busiType;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getAid() {
        return this.aid;
    }

    /* renamed from: component3, reason: from getter */
    public final int getActionType() {
        return this.actionType;
    }

    /* renamed from: component4, reason: from getter */
    public final long getActionTime() {
        return this.actionTime;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getQqVer() {
        return this.qqVer;
    }

    /* renamed from: component6, reason: from getter */
    public final int getOsType() {
        return this.osType;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    @NotNull
    public final GdtSsoReportMiniParam copy(int busiType, @NotNull String aid, int actionType, long actionTime, @NotNull String qqVer, int osType, @NotNull String appId) {
        Intrinsics.checkNotNullParameter(aid, "aid");
        Intrinsics.checkNotNullParameter(qqVer, "qqVer");
        Intrinsics.checkNotNullParameter(appId, "appId");
        return new GdtSsoReportMiniParam(busiType, aid, actionType, actionTime, qqVer, osType, appId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GdtSsoReportMiniParam)) {
            return false;
        }
        GdtSsoReportMiniParam gdtSsoReportMiniParam = (GdtSsoReportMiniParam) other;
        if (this.busiType == gdtSsoReportMiniParam.busiType && Intrinsics.areEqual(this.aid, gdtSsoReportMiniParam.aid) && this.actionType == gdtSsoReportMiniParam.actionType && this.actionTime == gdtSsoReportMiniParam.actionTime && Intrinsics.areEqual(this.qqVer, gdtSsoReportMiniParam.qqVer) && this.osType == gdtSsoReportMiniParam.osType && Intrinsics.areEqual(this.appId, gdtSsoReportMiniParam.appId)) {
            return true;
        }
        return false;
    }

    public final long getActionTime() {
        return this.actionTime;
    }

    public final int getActionType() {
        return this.actionType;
    }

    @NotNull
    public final String getAid() {
        return this.aid;
    }

    @NotNull
    public final String getAppId() {
        return this.appId;
    }

    public final int getBusiType() {
        return this.busiType;
    }

    public final int getOsType() {
        return this.osType;
    }

    @NotNull
    public final String getQqVer() {
        return this.qqVer;
    }

    public int hashCode() {
        return (((((((((((this.busiType * 31) + this.aid.hashCode()) * 31) + this.actionType) * 31) + a.a(this.actionTime)) * 31) + this.qqVer.hashCode()) * 31) + this.osType) * 31) + this.appId.hashCode();
    }

    public final void setActionTime(long j3) {
        this.actionTime = j3;
    }

    public final void setActionType(int i3) {
        this.actionType = i3;
    }

    public final void setAid(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.aid = str;
    }

    public final void setAppId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appId = str;
    }

    public final void setBusiType(int i3) {
        this.busiType = i3;
    }

    public final void setOsType(int i3) {
        this.osType = i3;
    }

    public final void setQqVer(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.qqVer = str;
    }

    @NotNull
    public String toString() {
        return "GdtSsoReportMiniParam(busiType=" + this.busiType + ", aid=" + this.aid + ", actionType=" + this.actionType + ", actionTime=" + this.actionTime + ", qqVer=" + this.qqVer + ", osType=" + this.osType + ", appId=" + this.appId + ')';
    }
}
