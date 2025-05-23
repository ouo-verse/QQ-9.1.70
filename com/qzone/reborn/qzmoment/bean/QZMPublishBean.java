package com.qzone.reborn.qzmoment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import cooperation.qzone.LbsDataV2;

/* loaded from: classes37.dex */
public class QZMPublishBean extends QZMInitBean implements Parcelable {
    public static final Parcelable.Creator<QZMPublishBean> CREATOR = new a();
    public String mBackPath;
    public String mContent;
    public String mFrontPath;
    public LbsDataV2.PoiInfo mPoiInfo;
    public long mTaskId;
    public String mTraceId;

    /* loaded from: classes37.dex */
    class a implements Parcelable.Creator<QZMPublishBean> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QZMPublishBean createFromParcel(Parcel parcel) {
            QZMPublishBean qZMPublishBean = new QZMPublishBean();
            if (parcel != null) {
                qZMPublishBean.mTaskId = parcel.readLong();
                qZMPublishBean.mTraceId = parcel.readString();
                qZMPublishBean.mFrontPath = parcel.readString();
                qZMPublishBean.mBackPath = parcel.readString();
                qZMPublishBean.mContent = parcel.readString();
                qZMPublishBean.mPoiInfo = (LbsDataV2.PoiInfo) parcel.readParcelable(LbsDataV2.PoiInfo.class.getClassLoader());
            }
            return qZMPublishBean;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QZMPublishBean[] newArray(int i3) {
            return new QZMPublishBean[i3];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isInValid() {
        return TextUtils.isEmpty(this.mFrontPath) || TextUtils.isEmpty(this.mBackPath) || !FileUtils.fileExists(this.mFrontPath) || !FileUtils.fileExists(this.mBackPath);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.mTaskId);
        parcel.writeString(this.mTraceId);
        parcel.writeString(this.mFrontPath);
        parcel.writeString(this.mBackPath);
        parcel.writeString(this.mContent);
        parcel.writeParcelable(this.mPoiInfo, i3);
    }
}
