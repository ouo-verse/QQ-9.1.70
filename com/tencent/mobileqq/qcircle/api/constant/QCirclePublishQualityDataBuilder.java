package com.tencent.mobileqq.qcircle.api.constant;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.io.Serializable;

/* loaded from: classes16.dex */
public class QCirclePublishQualityDataBuilder implements Parcelable, Serializable {
    public static final Parcelable.Creator<QCirclePublishQualityDataBuilder> CREATOR = new a();
    public static String T_UPLOAD_SESSION_REPORT = "T_UPLOAD_SESSION_REPORT";
    private String attachInfo;
    private String cost;
    private String desc;
    private String ext1;
    private String ext2;
    private String ext3;
    private String ext4;
    private String ext5;
    private String ext6;
    private String index;
    private String key;
    private String keyEventId;
    private String keyRetCode;
    private long reportTimeMillis;
    private String traceId;

    /* loaded from: classes16.dex */
    class a implements Parcelable.Creator<QCirclePublishQualityDataBuilder> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QCirclePublishQualityDataBuilder createFromParcel(Parcel parcel) {
            return new QCirclePublishQualityDataBuilder(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QCirclePublishQualityDataBuilder[] newArray(int i3) {
            return new QCirclePublishQualityDataBuilder[i3];
        }
    }

    public QCirclePublishQualityDataBuilder() {
        this.ext1 = "";
        this.ext2 = "";
        this.ext3 = "";
        this.ext4 = "";
        this.ext5 = "";
        this.ext6 = "";
        this.traceId = "";
        this.keyEventId = "";
        this.keyRetCode = "";
        this.desc = "";
        this.attachInfo = "";
        this.index = "";
        this.key = "";
        this.cost = "";
        this.reportTimeMillis = 0L;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAttachInfo() {
        return this.attachInfo;
    }

    public String getCost() {
        return this.cost;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getExt1() {
        return this.ext1;
    }

    public String getExt2() {
        return this.ext2;
    }

    public String getExt3() {
        return this.ext3;
    }

    public String getExt4() {
        return this.ext4;
    }

    public String getExt5() {
        return this.ext5;
    }

    public String getExt6() {
        return this.ext6;
    }

    public String getIndex() {
        return this.index;
    }

    public String getKey() {
        return this.key;
    }

    public String getKeyEventId() {
        return this.keyEventId;
    }

    public String getKeyRetCode() {
        return this.keyRetCode;
    }

    public long getReportTimeMillis() {
        return this.reportTimeMillis;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void readFromParcel(Parcel parcel) {
        this.ext1 = parcel.readString();
        this.ext2 = parcel.readString();
        this.ext3 = parcel.readString();
        this.ext4 = parcel.readString();
        this.ext5 = parcel.readString();
        this.ext6 = parcel.readString();
        this.traceId = parcel.readString();
        this.keyEventId = parcel.readString();
        this.keyRetCode = parcel.readString();
        this.desc = parcel.readString();
        this.attachInfo = parcel.readString();
        this.index = parcel.readString();
        this.key = parcel.readString();
        this.cost = parcel.readString();
        this.reportTimeMillis = parcel.readLong();
    }

    public QCirclePublishQualityDataBuilder setAttachInfo(String str) {
        this.attachInfo = str;
        return this;
    }

    public QCirclePublishQualityDataBuilder setCost(String str) {
        this.cost = str;
        return this;
    }

    public QCirclePublishQualityDataBuilder setDesc(String str) {
        this.desc = str;
        return this;
    }

    public QCirclePublishQualityDataBuilder setExt1(String str) {
        this.ext1 = str;
        return this;
    }

    public QCirclePublishQualityDataBuilder setExt2(String str) {
        this.ext2 = str;
        return this;
    }

    public QCirclePublishQualityDataBuilder setExt3(String str) {
        this.ext3 = str;
        return this;
    }

    public QCirclePublishQualityDataBuilder setExt4(String str) {
        this.ext4 = str;
        return this;
    }

    public QCirclePublishQualityDataBuilder setExt5(String str) {
        this.ext5 = str;
        return this;
    }

    public QCirclePublishQualityDataBuilder setExt6(String str) {
        this.ext6 = str;
        return this;
    }

    public QCirclePublishQualityDataBuilder setIndex(String str) {
        this.index = str;
        return this;
    }

    public QCirclePublishQualityDataBuilder setKey(String str) {
        this.key = str;
        return this;
    }

    public QCirclePublishQualityDataBuilder setKeyEventId(String str) {
        this.keyEventId = str;
        return this;
    }

    public QCirclePublishQualityDataBuilder setKeyRetCode(String str) {
        this.keyRetCode = str;
        return this;
    }

    public QCirclePublishQualityDataBuilder setReportTimeMillis(long j3) {
        this.reportTimeMillis = j3;
        return this;
    }

    public QCirclePublishQualityDataBuilder setTraceId(String str) {
        if (str != null) {
            this.traceId = str;
        }
        return this;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("QCirclePublishQualityDataBuilder{");
        if (!TextUtils.isEmpty(this.keyEventId) && !this.keyEventId.contains(T_UPLOAD_SESSION_REPORT)) {
            stringBuffer.append("ext1='");
            stringBuffer.append(this.ext1);
            stringBuffer.append('\'');
        }
        stringBuffer.append(", ext2='");
        stringBuffer.append(this.ext2);
        stringBuffer.append('\'');
        stringBuffer.append(", ext3='");
        stringBuffer.append(this.ext3);
        stringBuffer.append('\'');
        stringBuffer.append(", ext4='");
        stringBuffer.append(this.ext4);
        stringBuffer.append('\'');
        stringBuffer.append(", ext5='");
        stringBuffer.append(this.ext5);
        stringBuffer.append('\'');
        stringBuffer.append(", ext6='");
        stringBuffer.append(this.ext6);
        stringBuffer.append('\'');
        stringBuffer.append(", traceId='");
        stringBuffer.append(this.traceId);
        stringBuffer.append('\'');
        stringBuffer.append(", keyEventId='");
        stringBuffer.append(this.keyEventId);
        stringBuffer.append('\'');
        stringBuffer.append(", keyRetCode='");
        stringBuffer.append(this.keyRetCode);
        stringBuffer.append('\'');
        stringBuffer.append(", desc='");
        stringBuffer.append(this.desc);
        stringBuffer.append('\'');
        stringBuffer.append(", attachInfo='");
        stringBuffer.append(this.attachInfo);
        stringBuffer.append('\'');
        stringBuffer.append(", index='");
        stringBuffer.append(this.index);
        stringBuffer.append('\'');
        stringBuffer.append(", key='");
        stringBuffer.append(this.key);
        stringBuffer.append('\'');
        stringBuffer.append(", cost='");
        stringBuffer.append(this.cost);
        stringBuffer.append('\'');
        stringBuffer.append(", reportTimeMillis='");
        stringBuffer.append(this.reportTimeMillis);
        stringBuffer.append('\'');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.ext1);
        parcel.writeString(this.ext2);
        parcel.writeString(this.ext3);
        parcel.writeString(this.ext4);
        parcel.writeString(this.ext5);
        parcel.writeString(this.ext6);
        parcel.writeString(this.traceId);
        parcel.writeString(this.keyEventId);
        parcel.writeString(this.keyRetCode);
        parcel.writeString(this.desc);
        parcel.writeString(this.attachInfo);
        parcel.writeString(this.index);
        parcel.writeString(this.key);
        parcel.writeString(this.cost);
        parcel.writeLong(this.reportTimeMillis);
    }

    public QCirclePublishQualityDataBuilder setKeyRetCode(Long l3) {
        this.keyRetCode = String.valueOf(l3);
        return this;
    }

    protected QCirclePublishQualityDataBuilder(Parcel parcel) {
        this.ext1 = "";
        this.ext2 = "";
        this.ext3 = "";
        this.ext4 = "";
        this.ext5 = "";
        this.ext6 = "";
        this.traceId = "";
        this.keyEventId = "";
        this.keyRetCode = "";
        this.desc = "";
        this.attachInfo = "";
        this.index = "";
        this.key = "";
        this.cost = "";
        this.reportTimeMillis = 0L;
        this.ext1 = parcel.readString();
        this.ext2 = parcel.readString();
        this.ext3 = parcel.readString();
        this.ext4 = parcel.readString();
        this.ext5 = parcel.readString();
        this.ext6 = parcel.readString();
        this.traceId = parcel.readString();
        this.keyEventId = parcel.readString();
        this.keyRetCode = parcel.readString();
        this.desc = parcel.readString();
        this.attachInfo = parcel.readString();
        this.index = parcel.readString();
        this.key = parcel.readString();
        this.cost = parcel.readString();
        this.reportTimeMillis = parcel.readLong();
    }
}
