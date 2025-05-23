package com.tencent.mobileqq.winkpublish.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;

/* compiled from: P */
/* loaded from: classes21.dex */
public abstract class UploadLocalConfig implements Parcelable {
    public static final Parcelable.Creator<UploadLocalConfig> CREATOR = new a();
    public static final int TYPE_GUILD = 2;
    public static final int TYPE_QFS = 1;
    public static final int TYPE_QFS_AVATAR = 3;
    String cacheName;
    String spKey;
    String tag;
    int type;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements Parcelable.Creator<UploadLocalConfig> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UploadLocalConfig createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt != 1) {
                if (readInt != 2) {
                    if (readInt == 3) {
                        return new QFSAvatarUploadLocalConfig(parcel);
                    }
                    throw new RuntimeException("invalid type: " + readInt);
                }
                return new GuildUploadLocalConfig(parcel);
            }
            return new QFSUploadLocalConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public UploadLocalConfig[] newArray(int i3) {
            return new UploadLocalConfig[i3];
        }
    }

    public UploadLocalConfig(String str, String str2, String str3) {
        this.tag = str;
        this.spKey = str2;
        this.cacheName = str3;
        this.type = getUniqueType();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getSpKey() {
        return this.spKey;
    }

    public String getTag() {
        return this.tag;
    }

    public String getTaskCacheName() {
        return this.cacheName;
    }

    public abstract int getUniqueType();

    public abstract void mapReportEndKey(QCirclePublishQualityDataBuilder qCirclePublishQualityDataBuilder);

    public abstract void mapReportStartKey(String str);

    public void readFromParcel(Parcel parcel) {
        this.tag = parcel.readString();
        this.spKey = parcel.readString();
        this.cacheName = parcel.readString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("UploadLocalConfig{\n");
        stringBuffer.append("tag='");
        stringBuffer.append(this.tag);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append(", spKey='");
        stringBuffer.append(this.spKey);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append(", cacheName='");
        stringBuffer.append(this.cacheName);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public abstract void uploadQualityReport(QCirclePublishQualityDataBuilder qCirclePublishQualityDataBuilder);

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(getUniqueType());
        parcel.writeString(this.tag);
        parcel.writeString(this.spKey);
        parcel.writeString(this.cacheName);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public UploadLocalConfig(Parcel parcel) {
        readFromParcel(parcel);
        this.type = getUniqueType();
    }
}
