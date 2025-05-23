package com.tencent.mobileqq.winkpublish.report;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b4\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u0000 W2\u00020\u0001:\u0002VWB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u009b\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\u0002\u0010\u0016J\t\u00109\u001a\u00020\u0006H\u00c6\u0003J\t\u0010:\u001a\u00020\u0006H\u00c6\u0003J\t\u0010;\u001a\u00020\u0006H\u00c6\u0003J\t\u0010<\u001a\u00020\u0006H\u00c6\u0003J\t\u0010=\u001a\u00020\u0006H\u00c6\u0003J\t\u0010>\u001a\u00020\u0006H\u00c6\u0003J\t\u0010?\u001a\u00020\u0015H\u00c6\u0003J\t\u0010@\u001a\u00020\u0006H\u00c6\u0003J\t\u0010A\u001a\u00020\u0006H\u00c6\u0003J\t\u0010B\u001a\u00020\u0006H\u00c6\u0003J\t\u0010C\u001a\u00020\u0006H\u00c6\u0003J\t\u0010D\u001a\u00020\u0006H\u00c6\u0003J\t\u0010E\u001a\u00020\u0006H\u00c6\u0003J\t\u0010F\u001a\u00020\u0006H\u00c6\u0003J\t\u0010G\u001a\u00020\u0006H\u00c6\u0003J\u009f\u0001\u0010H\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u00c6\u0001J\b\u0010I\u001a\u00020JH\u0016J\u0013\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010NH\u00d6\u0003J\t\u0010O\u001a\u00020JH\u00d6\u0001J\u0006\u0010P\u001a\u00020QJ\t\u0010R\u001a\u00020\u0006H\u00d6\u0001J\u0018\u0010S\u001a\u00020T2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010U\u001a\u00020JH\u0016R\u001a\u0010\u0010\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0013\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001a\u0010\u000f\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0018\"\u0004\b(\u0010\u001aR\u001a\u0010\r\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010\u001aR\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0018\"\u0004\b.\u0010\u001aR\u001a\u0010\u0012\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0018\"\u0004\b0\u0010\u001aR\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0018\"\u0004\b6\u0010\u001aR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0018\"\u0004\b8\u0010\u001a\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/WinkPublishQualityReportData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "eventId", "", "traceId", "retCode", "ext1", "ext2", "ext3", "ext4", "ext5", "ext6", "desc", "attachInfo", "index", "key", QCircleWeakNetReporter.KEY_COST, "reportTimeMillis", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getAttachInfo", "()Ljava/lang/String;", "setAttachInfo", "(Ljava/lang/String;)V", "getCost", "setCost", "getDesc", "setDesc", "getEventId", "setEventId", "getExt1", "setExt1", "getExt2", "setExt2", "getExt3", "setExt3", "getExt4", "setExt4", "getExt5", "setExt5", "getExt6", "setExt6", "getIndex", "setIndex", "getKey", VasCommonJsbProxy.JSON_KEY_SET_KEY, "getReportTimeMillis", "()J", "setReportTimeMillis", "(J)V", "getRetCode", "setRetCode", "getTraceId", "setTraceId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "qcircleReportData", "Lcom/tencent/mobileqq/qcircle/api/constant/QCirclePublishQualityDataBuilder;", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "Builder", "CREATOR", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class WinkPublishQualityReportData implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private String attachInfo;

    @NotNull
    private String cost;

    @NotNull
    private String desc;

    @NotNull
    private String eventId;

    @NotNull
    private String ext1;

    @NotNull
    private String ext2;

    @NotNull
    private String ext3;

    @NotNull
    private String ext4;

    @NotNull
    private String ext5;

    @NotNull
    private String ext6;

    @NotNull
    private String index;

    @NotNull
    private String key;
    private long reportTimeMillis;

    @NotNull
    private String retCode;

    @NotNull
    private String traceId;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u0007\u001a\u00020\u0004J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/WinkPublishQualityReportData$Builder;", "", "()V", "reportData", "Lcom/tencent/mobileqq/winkpublish/report/WinkPublishQualityReportData;", "attachInfo", "", "build", QCircleWeakNetReporter.KEY_COST, "desc", "eventId", "ext1", "ext2", "ext3", "ext4", "ext5", "ext6", "index", "key", "retCode", "traceId", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class Builder {

        @NotNull
        private final WinkPublishQualityReportData reportData = new WinkPublishQualityReportData(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 32767, null);

        @NotNull
        public final Builder attachInfo(@Nullable String attachInfo) {
            WinkPublishQualityReportData winkPublishQualityReportData = this.reportData;
            if (attachInfo == null) {
                attachInfo = "";
            }
            winkPublishQualityReportData.setAttachInfo(attachInfo);
            return this;
        }

        @NotNull
        /* renamed from: build, reason: from getter */
        public final WinkPublishQualityReportData getReportData() {
            return this.reportData;
        }

        @NotNull
        public final Builder cost(@Nullable String cost) {
            WinkPublishQualityReportData winkPublishQualityReportData = this.reportData;
            if (cost == null) {
                cost = "";
            }
            winkPublishQualityReportData.setCost(cost);
            return this;
        }

        @NotNull
        public final Builder desc(@Nullable String desc) {
            WinkPublishQualityReportData winkPublishQualityReportData = this.reportData;
            if (desc == null) {
                desc = "";
            }
            winkPublishQualityReportData.setDesc(desc);
            return this;
        }

        @NotNull
        public final Builder eventId(@Nullable String eventId) {
            WinkPublishQualityReportData winkPublishQualityReportData = this.reportData;
            if (eventId == null) {
                eventId = "";
            }
            winkPublishQualityReportData.setEventId(eventId);
            return this;
        }

        @NotNull
        public final Builder ext1(@Nullable String ext1) {
            WinkPublishQualityReportData winkPublishQualityReportData = this.reportData;
            if (ext1 == null) {
                ext1 = "";
            }
            winkPublishQualityReportData.setExt1(ext1);
            return this;
        }

        @NotNull
        public final Builder ext2(@Nullable String ext2) {
            WinkPublishQualityReportData winkPublishQualityReportData = this.reportData;
            if (ext2 == null) {
                ext2 = "";
            }
            winkPublishQualityReportData.setExt2(ext2);
            return this;
        }

        @NotNull
        public final Builder ext3(@Nullable String ext3) {
            WinkPublishQualityReportData winkPublishQualityReportData = this.reportData;
            if (ext3 == null) {
                ext3 = "";
            }
            winkPublishQualityReportData.setExt3(ext3);
            return this;
        }

        @NotNull
        public final Builder ext4(@Nullable String ext4) {
            WinkPublishQualityReportData winkPublishQualityReportData = this.reportData;
            if (ext4 == null) {
                ext4 = "";
            }
            winkPublishQualityReportData.setExt4(ext4);
            return this;
        }

        @NotNull
        public final Builder ext5(@Nullable String ext5) {
            WinkPublishQualityReportData winkPublishQualityReportData = this.reportData;
            if (ext5 == null) {
                ext5 = "";
            }
            winkPublishQualityReportData.setExt5(ext5);
            return this;
        }

        @NotNull
        public final Builder ext6(@Nullable String ext6) {
            WinkPublishQualityReportData winkPublishQualityReportData = this.reportData;
            if (ext6 == null) {
                ext6 = "";
            }
            winkPublishQualityReportData.setExt6(ext6);
            return this;
        }

        @NotNull
        public final Builder index(@Nullable String index) {
            WinkPublishQualityReportData winkPublishQualityReportData = this.reportData;
            if (index == null) {
                index = "";
            }
            winkPublishQualityReportData.setIndex(index);
            return this;
        }

        @NotNull
        public final Builder key(@Nullable String key) {
            WinkPublishQualityReportData winkPublishQualityReportData = this.reportData;
            if (key == null) {
                key = "";
            }
            winkPublishQualityReportData.setKey(key);
            return this;
        }

        @NotNull
        public final Builder retCode(@Nullable String retCode) {
            WinkPublishQualityReportData winkPublishQualityReportData = this.reportData;
            if (retCode == null) {
                retCode = "";
            }
            winkPublishQualityReportData.setRetCode(retCode);
            return this;
        }

        @NotNull
        public final Builder traceId(@Nullable String traceId) {
            WinkPublishQualityReportData winkPublishQualityReportData = this.reportData;
            if (traceId == null) {
                traceId = "";
            }
            winkPublishQualityReportData.setTraceId(traceId);
            return this;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/WinkPublishQualityReportData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/winkpublish/report/WinkPublishQualityReportData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mobileqq/winkpublish/report/WinkPublishQualityReportData;", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData$CREATOR, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion implements Parcelable.Creator<WinkPublishQualityReportData> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public WinkPublishQualityReportData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WinkPublishQualityReportData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public WinkPublishQualityReportData[] newArray(int size) {
            return new WinkPublishQualityReportData[size];
        }
    }

    public WinkPublishQualityReportData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, 32767, null);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getEventId() {
        return this.eventId;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    /* renamed from: component11, reason: from getter */
    public final String getAttachInfo() {
        return this.attachInfo;
    }

    @NotNull
    /* renamed from: component12, reason: from getter */
    public final String getIndex() {
        return this.index;
    }

    @NotNull
    /* renamed from: component13, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    @NotNull
    /* renamed from: component14, reason: from getter */
    public final String getCost() {
        return this.cost;
    }

    /* renamed from: component15, reason: from getter */
    public final long getReportTimeMillis() {
        return this.reportTimeMillis;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getRetCode() {
        return this.retCode;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getExt1() {
        return this.ext1;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getExt2() {
        return this.ext2;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getExt3() {
        return this.ext3;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getExt4() {
        return this.ext4;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getExt5() {
        return this.ext5;
    }

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final String getExt6() {
        return this.ext6;
    }

    @NotNull
    public final WinkPublishQualityReportData copy(@NotNull String eventId, @NotNull String traceId, @NotNull String retCode, @NotNull String ext1, @NotNull String ext2, @NotNull String ext3, @NotNull String ext4, @NotNull String ext5, @NotNull String ext6, @NotNull String desc, @NotNull String attachInfo, @NotNull String index, @NotNull String key, @NotNull String cost, long reportTimeMillis) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(retCode, "retCode");
        Intrinsics.checkNotNullParameter(ext1, "ext1");
        Intrinsics.checkNotNullParameter(ext2, "ext2");
        Intrinsics.checkNotNullParameter(ext3, "ext3");
        Intrinsics.checkNotNullParameter(ext4, "ext4");
        Intrinsics.checkNotNullParameter(ext5, "ext5");
        Intrinsics.checkNotNullParameter(ext6, "ext6");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(cost, "cost");
        return new WinkPublishQualityReportData(eventId, traceId, retCode, ext1, ext2, ext3, ext4, ext5, ext6, desc, attachInfo, index, key, cost, reportTimeMillis);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkPublishQualityReportData)) {
            return false;
        }
        WinkPublishQualityReportData winkPublishQualityReportData = (WinkPublishQualityReportData) other;
        if (Intrinsics.areEqual(this.eventId, winkPublishQualityReportData.eventId) && Intrinsics.areEqual(this.traceId, winkPublishQualityReportData.traceId) && Intrinsics.areEqual(this.retCode, winkPublishQualityReportData.retCode) && Intrinsics.areEqual(this.ext1, winkPublishQualityReportData.ext1) && Intrinsics.areEqual(this.ext2, winkPublishQualityReportData.ext2) && Intrinsics.areEqual(this.ext3, winkPublishQualityReportData.ext3) && Intrinsics.areEqual(this.ext4, winkPublishQualityReportData.ext4) && Intrinsics.areEqual(this.ext5, winkPublishQualityReportData.ext5) && Intrinsics.areEqual(this.ext6, winkPublishQualityReportData.ext6) && Intrinsics.areEqual(this.desc, winkPublishQualityReportData.desc) && Intrinsics.areEqual(this.attachInfo, winkPublishQualityReportData.attachInfo) && Intrinsics.areEqual(this.index, winkPublishQualityReportData.index) && Intrinsics.areEqual(this.key, winkPublishQualityReportData.key) && Intrinsics.areEqual(this.cost, winkPublishQualityReportData.cost) && this.reportTimeMillis == winkPublishQualityReportData.reportTimeMillis) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getAttachInfo() {
        return this.attachInfo;
    }

    @NotNull
    public final String getCost() {
        return this.cost;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    public final String getEventId() {
        return this.eventId;
    }

    @NotNull
    public final String getExt1() {
        return this.ext1;
    }

    @NotNull
    public final String getExt2() {
        return this.ext2;
    }

    @NotNull
    public final String getExt3() {
        return this.ext3;
    }

    @NotNull
    public final String getExt4() {
        return this.ext4;
    }

    @NotNull
    public final String getExt5() {
        return this.ext5;
    }

    @NotNull
    public final String getExt6() {
        return this.ext6;
    }

    @NotNull
    public final String getIndex() {
        return this.index;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    public final long getReportTimeMillis() {
        return this.reportTimeMillis;
    }

    @NotNull
    public final String getRetCode() {
        return this.retCode;
    }

    @NotNull
    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((this.eventId.hashCode() * 31) + this.traceId.hashCode()) * 31) + this.retCode.hashCode()) * 31) + this.ext1.hashCode()) * 31) + this.ext2.hashCode()) * 31) + this.ext3.hashCode()) * 31) + this.ext4.hashCode()) * 31) + this.ext5.hashCode()) * 31) + this.ext6.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.attachInfo.hashCode()) * 31) + this.index.hashCode()) * 31) + this.key.hashCode()) * 31) + this.cost.hashCode()) * 31) + androidx.fragment.app.a.a(this.reportTimeMillis);
    }

    @NotNull
    public final QCirclePublishQualityDataBuilder qcircleReportData() {
        QCirclePublishQualityDataBuilder reportTimeMillis = new QCirclePublishQualityDataBuilder().setKeyEventId(this.eventId).setTraceId(this.traceId).setKeyRetCode(this.retCode).setExt1(this.ext1).setExt2(this.ext2).setExt3(this.ext3).setExt4(this.ext4).setExt5(this.ext5).setExt6(this.ext6).setDesc(this.desc).setAttachInfo(this.attachInfo).setIndex(this.index).setKey(this.key).setCost(this.cost).setReportTimeMillis(this.reportTimeMillis);
        Intrinsics.checkNotNullExpressionValue(reportTimeMillis, "QCirclePublishQualityDat\u2026eMillis(reportTimeMillis)");
        return reportTimeMillis;
    }

    public final void setAttachInfo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.attachInfo = str;
    }

    public final void setCost(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cost = str;
    }

    public final void setDesc(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.desc = str;
    }

    public final void setEventId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.eventId = str;
    }

    public final void setExt1(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext1 = str;
    }

    public final void setExt2(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext2 = str;
    }

    public final void setExt3(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext3 = str;
    }

    public final void setExt4(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext4 = str;
    }

    public final void setExt5(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext5 = str;
    }

    public final void setExt6(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext6 = str;
    }

    public final void setIndex(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.index = str;
    }

    public final void setKey(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.key = str;
    }

    public final void setReportTimeMillis(long j3) {
        this.reportTimeMillis = j3;
    }

    public final void setRetCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.retCode = str;
    }

    public final void setTraceId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.traceId = str;
    }

    @NotNull
    public String toString() {
        return "WinkPublishQualityReportData(eventId=" + this.eventId + ", traceId=" + this.traceId + ", retCode=" + this.retCode + ", ext1=" + this.ext1 + ", ext2=" + this.ext2 + ", ext3=" + this.ext3 + ", ext4=" + this.ext4 + ", ext5=" + this.ext5 + ", ext6=" + this.ext6 + ", desc=" + this.desc + ", attachInfo=" + this.attachInfo + ", index=" + this.index + ", key=" + this.key + ", cost=" + this.cost + ", reportTimeMillis=" + this.reportTimeMillis + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.eventId);
        parcel.writeString(this.traceId);
        parcel.writeString(this.retCode);
        parcel.writeString(this.ext1);
        parcel.writeString(this.ext2);
        parcel.writeString(this.ext3);
        parcel.writeString(this.ext4);
        parcel.writeString(this.ext5);
        parcel.writeString(this.ext6);
        parcel.writeString(this.desc);
        parcel.writeString(this.attachInfo);
        parcel.writeString(this.index);
        parcel.writeString(this.key);
        parcel.writeString(this.cost);
        parcel.writeLong(this.reportTimeMillis);
    }

    public WinkPublishQualityReportData(@NotNull String eventId, @NotNull String traceId, @NotNull String retCode, @NotNull String ext1, @NotNull String ext2, @NotNull String ext3, @NotNull String ext4, @NotNull String ext5, @NotNull String ext6, @NotNull String desc, @NotNull String attachInfo, @NotNull String index, @NotNull String key, @NotNull String cost, long j3) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(retCode, "retCode");
        Intrinsics.checkNotNullParameter(ext1, "ext1");
        Intrinsics.checkNotNullParameter(ext2, "ext2");
        Intrinsics.checkNotNullParameter(ext3, "ext3");
        Intrinsics.checkNotNullParameter(ext4, "ext4");
        Intrinsics.checkNotNullParameter(ext5, "ext5");
        Intrinsics.checkNotNullParameter(ext6, "ext6");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(cost, "cost");
        this.eventId = eventId;
        this.traceId = traceId;
        this.retCode = retCode;
        this.ext1 = ext1;
        this.ext2 = ext2;
        this.ext3 = ext3;
        this.ext4 = ext4;
        this.ext5 = ext5;
        this.ext6 = ext6;
        this.desc = desc;
        this.attachInfo = attachInfo;
        this.index = index;
        this.key = key;
        this.cost = cost;
        this.reportTimeMillis = j3;
    }

    public /* synthetic */ WinkPublishQualityReportData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? "" : str6, (i3 & 64) != 0 ? "" : str7, (i3 & 128) != 0 ? "" : str8, (i3 & 256) != 0 ? "" : str9, (i3 & 512) != 0 ? "" : str10, (i3 & 1024) != 0 ? "" : str11, (i3 & 2048) != 0 ? "" : str12, (i3 & 4096) != 0 ? "" : str13, (i3 & 8192) == 0 ? str14 : "", (i3 & 16384) != 0 ? 0L : j3);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public WinkPublishQualityReportData(@NotNull Parcel parcel) {
        this(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r0 == null ? "" : r0, parcel.readLong());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        String str2 = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        String str3 = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        String str4 = readString4 == null ? "" : readString4;
        String readString5 = parcel.readString();
        String str5 = readString5 == null ? "" : readString5;
        String readString6 = parcel.readString();
        String str6 = readString6 == null ? "" : readString6;
        String readString7 = parcel.readString();
        String str7 = readString7 == null ? "" : readString7;
        String readString8 = parcel.readString();
        String str8 = readString8 == null ? "" : readString8;
        String readString9 = parcel.readString();
        String str9 = readString9 == null ? "" : readString9;
        String readString10 = parcel.readString();
        String str10 = readString10 == null ? "" : readString10;
        String readString11 = parcel.readString();
        String str11 = readString11 == null ? "" : readString11;
        String readString12 = parcel.readString();
        String str12 = readString12 == null ? "" : readString12;
        String readString13 = parcel.readString();
        String str13 = readString13 == null ? "" : readString13;
        String readString14 = parcel.readString();
    }
}
