package com.tencent.gdtad.params;

import androidx.fragment.app.a;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vas.VasUserData;
import com.tencent.mobileqq.vas.util.VasUtil;
import cooperation.vip.tianshu.TianShuMMKVConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.fileupload.FileUploadBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001FBu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\fj\b\u0012\u0004\u0012\u00020\u0005`\r\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0013J\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\u0005H\u00c6\u0003J\t\u00106\u001a\u00020\u0005H\u00c6\u0003J\t\u00107\u001a\u00020\u0003H\u00c6\u0003J\t\u00108\u001a\u00020\u0005H\u00c6\u0003J\t\u00109\u001a\u00020\u0003H\u00c6\u0003J\t\u0010:\u001a\u00020\u0003H\u00c6\u0003J\t\u0010;\u001a\u00020\tH\u00c6\u0003J\t\u0010<\u001a\u00020\u0003H\u00c6\u0003J\u0019\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\u00050\fj\b\u0012\u0004\u0012\u00020\u0005`\rH\u00c6\u0003J\t\u0010>\u001a\u00020\u0005H\u00c6\u0003J\t\u0010?\u001a\u00020\u0005H\u00c6\u0003J\u0091\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\fj\b\u0012\u0004\u0012\u00020\u0005`\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010D\u001a\u00020\u0003H\u00d6\u0001J\t\u0010E\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\fj\b\u0012\u0004\u0012\u00020\u0005`\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0019\"\u0004\b-\u0010\u001bR\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0019\"\u0004\b/\u0010\u001bR\u001a\u0010\u0011\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001d\"\u0004\b1\u0010\u001fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001d\"\u0004\b3\u0010\u001f\u00a8\u0006G"}, d2 = {"Lcom/tencent/gdtad/params/GdtSsoReportParam;", "", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "", "aid", "", "adPosType", "actionType", TianShuMMKVConstant.UserActionKey.ACTION_TIME, "", TangramHippyConstants.FEEDS_INDEX, "experimentId", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", FileUploadBase.ATTACHMENT, "adPosId", "traceId", VasUserData.Key.QQ_VER, "osType", "(ILjava/lang/String;IIJILjava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getActionTime", "()J", "setActionTime", "(J)V", "getActionType", "()I", "setActionType", "(I)V", "getAdPosId", "()Ljava/lang/String;", "setAdPosId", "(Ljava/lang/String;)V", "getAdPosType", "setAdPosType", "getAid", "setAid", "getAttachment", "setAttachment", "getBusiType", "setBusiType", "getExperimentId", "()Ljava/util/ArrayList;", "setExperimentId", "(Ljava/util/ArrayList;)V", "getFeedsIndex", "setFeedsIndex", "getOsType", "setOsType", "getQqVer", "setQqVer", "getTraceId", "setTraceId", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "Builder", "qqad-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class GdtSsoReportParam {
    private long actionTime;
    private int actionType;

    @NotNull
    private String adPosId;
    private int adPosType;

    @NotNull
    private String aid;

    @NotNull
    private String attachment;
    private int busiType;

    @NotNull
    private ArrayList<String> experimentId;
    private int feedsIndex;
    private int osType;

    @NotNull
    private String qqVer;

    @NotNull
    private String traceId;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\bJ\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0006J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0006J\u001e\u0010!\u001a\u00020\u00002\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000ej\b\u0012\u0004\u0012\u00020\b`\u000fJ\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0006J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000ej\b\u0012\u0004\u0012\u00020\b`\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0013*\u0004\u0018\u00010\b0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/tencent/gdtad/params/GdtSsoReportParam$Builder;", "", "()V", TianShuMMKVConstant.UserActionKey.ACTION_TIME, "", "actionType", "", "adPosId", "", "adPosType", "aid", FileUploadBase.ATTACHMENT, IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "experimentId", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", TangramHippyConstants.FEEDS_INDEX, "osType", VasUserData.Key.QQ_VER, "kotlin.jvm.PlatformType", "traceId", "uin", "build", "Lcom/tencent/gdtad/params/GdtSsoReportParam;", "setAId", "aId", "setActionTime", "setActionType", "setAdPosId", "setAdPosType", "posType", "setAttachment", "setBusiType", "setExperimentId", "setFeedsIndex", "setTraceId", "qqad-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Builder {
        private int actionType;
        private int adPosType;
        private int feedsIndex;
        private int busiType = 15;

        @Nullable
        private String uin = VasUtil.getCurrentUin();

        @NotNull
        private String aid = "";
        private long actionTime = NetConnInfoCenter.getServerTime();

        @NotNull
        private ArrayList<String> experimentId = new ArrayList<>();

        @NotNull
        private String attachment = "";

        @NotNull
        private String adPosId = "";

        @NotNull
        private String traceId = "";
        private String qqVer = ah.P();
        private int osType = 2;

        @NotNull
        public final GdtSsoReportParam build() {
            int i3 = this.busiType;
            String str = this.aid;
            int i16 = this.adPosType;
            int i17 = this.actionType;
            long j3 = this.actionTime;
            int i18 = this.feedsIndex;
            ArrayList<String> arrayList = this.experimentId;
            String str2 = this.attachment;
            String str3 = this.adPosId;
            String str4 = this.traceId;
            String qqVer = this.qqVer;
            Intrinsics.checkNotNullExpressionValue(qqVer, "qqVer");
            return new GdtSsoReportParam(i3, str, i16, i17, j3, i18, arrayList, str2, str3, str4, qqVer, this.osType);
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
        public final Builder setAdPosId(@NotNull String adPosId) {
            Intrinsics.checkNotNullParameter(adPosId, "adPosId");
            this.adPosId = adPosId;
            return this;
        }

        @NotNull
        public final Builder setAdPosType(int posType) {
            this.adPosType = posType;
            return this;
        }

        @NotNull
        public final Builder setAttachment(@NotNull String attachment) {
            Intrinsics.checkNotNullParameter(attachment, "attachment");
            this.attachment = attachment;
            return this;
        }

        @NotNull
        public final Builder setBusiType(int busiType) {
            this.busiType = busiType;
            return this;
        }

        @NotNull
        public final Builder setExperimentId(@NotNull ArrayList<String> experimentId) {
            Intrinsics.checkNotNullParameter(experimentId, "experimentId");
            this.experimentId = experimentId;
            return this;
        }

        @NotNull
        public final Builder setFeedsIndex(int feedsIndex) {
            this.feedsIndex = feedsIndex;
            return this;
        }

        @NotNull
        public final Builder setTraceId(@NotNull String traceId) {
            Intrinsics.checkNotNullParameter(traceId, "traceId");
            this.traceId = traceId;
            return this;
        }
    }

    public GdtSsoReportParam(int i3, @NotNull String aid, int i16, int i17, long j3, int i18, @NotNull ArrayList<String> experimentId, @NotNull String attachment, @NotNull String adPosId, @NotNull String traceId, @NotNull String qqVer, int i19) {
        Intrinsics.checkNotNullParameter(aid, "aid");
        Intrinsics.checkNotNullParameter(experimentId, "experimentId");
        Intrinsics.checkNotNullParameter(attachment, "attachment");
        Intrinsics.checkNotNullParameter(adPosId, "adPosId");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(qqVer, "qqVer");
        this.busiType = i3;
        this.aid = aid;
        this.adPosType = i16;
        this.actionType = i17;
        this.actionTime = j3;
        this.feedsIndex = i18;
        this.experimentId = experimentId;
        this.attachment = attachment;
        this.adPosId = adPosId;
        this.traceId = traceId;
        this.qqVer = qqVer;
        this.osType = i19;
    }

    /* renamed from: component1, reason: from getter */
    public final int getBusiType() {
        return this.busiType;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    @NotNull
    /* renamed from: component11, reason: from getter */
    public final String getQqVer() {
        return this.qqVer;
    }

    /* renamed from: component12, reason: from getter */
    public final int getOsType() {
        return this.osType;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getAid() {
        return this.aid;
    }

    /* renamed from: component3, reason: from getter */
    public final int getAdPosType() {
        return this.adPosType;
    }

    /* renamed from: component4, reason: from getter */
    public final int getActionType() {
        return this.actionType;
    }

    /* renamed from: component5, reason: from getter */
    public final long getActionTime() {
        return this.actionTime;
    }

    /* renamed from: component6, reason: from getter */
    public final int getFeedsIndex() {
        return this.feedsIndex;
    }

    @NotNull
    public final ArrayList<String> component7() {
        return this.experimentId;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getAttachment() {
        return this.attachment;
    }

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final String getAdPosId() {
        return this.adPosId;
    }

    @NotNull
    public final GdtSsoReportParam copy(int busiType, @NotNull String aid, int adPosType, int actionType, long actionTime, int feedsIndex, @NotNull ArrayList<String> experimentId, @NotNull String attachment, @NotNull String adPosId, @NotNull String traceId, @NotNull String qqVer, int osType) {
        Intrinsics.checkNotNullParameter(aid, "aid");
        Intrinsics.checkNotNullParameter(experimentId, "experimentId");
        Intrinsics.checkNotNullParameter(attachment, "attachment");
        Intrinsics.checkNotNullParameter(adPosId, "adPosId");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(qqVer, "qqVer");
        return new GdtSsoReportParam(busiType, aid, adPosType, actionType, actionTime, feedsIndex, experimentId, attachment, adPosId, traceId, qqVer, osType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GdtSsoReportParam)) {
            return false;
        }
        GdtSsoReportParam gdtSsoReportParam = (GdtSsoReportParam) other;
        if (this.busiType == gdtSsoReportParam.busiType && Intrinsics.areEqual(this.aid, gdtSsoReportParam.aid) && this.adPosType == gdtSsoReportParam.adPosType && this.actionType == gdtSsoReportParam.actionType && this.actionTime == gdtSsoReportParam.actionTime && this.feedsIndex == gdtSsoReportParam.feedsIndex && Intrinsics.areEqual(this.experimentId, gdtSsoReportParam.experimentId) && Intrinsics.areEqual(this.attachment, gdtSsoReportParam.attachment) && Intrinsics.areEqual(this.adPosId, gdtSsoReportParam.adPosId) && Intrinsics.areEqual(this.traceId, gdtSsoReportParam.traceId) && Intrinsics.areEqual(this.qqVer, gdtSsoReportParam.qqVer) && this.osType == gdtSsoReportParam.osType) {
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
    public final String getAdPosId() {
        return this.adPosId;
    }

    public final int getAdPosType() {
        return this.adPosType;
    }

    @NotNull
    public final String getAid() {
        return this.aid;
    }

    @NotNull
    public final String getAttachment() {
        return this.attachment;
    }

    public final int getBusiType() {
        return this.busiType;
    }

    @NotNull
    public final ArrayList<String> getExperimentId() {
        return this.experimentId;
    }

    public final int getFeedsIndex() {
        return this.feedsIndex;
    }

    public final int getOsType() {
        return this.osType;
    }

    @NotNull
    public final String getQqVer() {
        return this.qqVer;
    }

    @NotNull
    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.busiType * 31) + this.aid.hashCode()) * 31) + this.adPosType) * 31) + this.actionType) * 31) + a.a(this.actionTime)) * 31) + this.feedsIndex) * 31) + this.experimentId.hashCode()) * 31) + this.attachment.hashCode()) * 31) + this.adPosId.hashCode()) * 31) + this.traceId.hashCode()) * 31) + this.qqVer.hashCode()) * 31) + this.osType;
    }

    public final void setActionTime(long j3) {
        this.actionTime = j3;
    }

    public final void setActionType(int i3) {
        this.actionType = i3;
    }

    public final void setAdPosId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.adPosId = str;
    }

    public final void setAdPosType(int i3) {
        this.adPosType = i3;
    }

    public final void setAid(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.aid = str;
    }

    public final void setAttachment(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.attachment = str;
    }

    public final void setBusiType(int i3) {
        this.busiType = i3;
    }

    public final void setExperimentId(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.experimentId = arrayList;
    }

    public final void setFeedsIndex(int i3) {
        this.feedsIndex = i3;
    }

    public final void setOsType(int i3) {
        this.osType = i3;
    }

    public final void setQqVer(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.qqVer = str;
    }

    public final void setTraceId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.traceId = str;
    }

    @NotNull
    public String toString() {
        return "GdtSsoReportParam(busiType=" + this.busiType + ", aid=" + this.aid + ", adPosType=" + this.adPosType + ", actionType=" + this.actionType + ", actionTime=" + this.actionTime + ", feedsIndex=" + this.feedsIndex + ", experimentId=" + this.experimentId + ", attachment=" + this.attachment + ", adPosId=" + this.adPosId + ", traceId=" + this.traceId + ", qqVer=" + this.qqVer + ", osType=" + this.osType + ')';
    }
}
