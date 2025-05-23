package cooperation.qzone;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QZoneShareData implements Parcelable {
    public static final Parcelable.Creator<QZoneShareData> CREATOR = new Parcelable.Creator<QZoneShareData>() { // from class: cooperation.qzone.QZoneShareData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QZoneShareData createFromParcel(Parcel parcel) {
            return new QZoneShareData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QZoneShareData[] newArray(int i3) {
            return new QZoneShareData[i3];
        }
    };
    public static final int FROM_DEFAULT = 0;
    public static final int FROM_H5 = 2;
    public static final int FROM_THIRD_PARTY_SHARE = 1;
    public static final int OTHER_PLATFORM_NOT_SHOW = 0;
    public static final int OTHER_PLATFORM_SHOW = 1;
    public String action;
    public String appName;
    public long appid;
    public String extString;
    public int from;
    public int iUrlInfoFrm;
    public String jFrom;
    public String mDefaultForwardReason;
    public String mHint;
    public ArrayList<String> mImageUrls;
    public long mShareBeginTime;
    public String mSummary;
    public String mTitle;
    public String mWebUrl;
    public String openId;
    public String pkgname;
    public Map<String, String> qzoneShareInfo;
    public String shareUin;
    public int showShareOtherPlat;
    public String targetUrl;
    public Map<String, String> xcxMapEx;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "appid:" + this.appid + " openId:" + this.openId + " mTitle:" + this.mTitle + " mSummary:" + this.mSummary + " targetUrl:" + this.targetUrl + " mImageUrl:" + this.mImageUrls.toString() + " appName:" + this.appName + " shareUin:" + this.shareUin + " extString:" + this.extString + " from:" + this.from + " action:" + this.action + " pkgname:" + this.pkgname + " iUrlInfoFrm" + this.iUrlInfoFrm + " mWebUrl:" + this.mWebUrl;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.appid);
        parcel.writeString(this.openId);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mSummary);
        parcel.writeString(this.targetUrl);
        parcel.writeStringList(this.mImageUrls);
        parcel.writeString(this.appName);
        parcel.writeString(this.shareUin);
        parcel.writeString(this.extString);
        parcel.writeInt(this.iUrlInfoFrm);
        parcel.writeInt(this.from);
        parcel.writeString(this.action);
        parcel.writeString(this.pkgname);
        parcel.writeInt(this.showShareOtherPlat);
        parcel.writeString(this.jFrom);
        parcel.writeLong(this.mShareBeginTime);
        parcel.writeString(this.mHint);
        parcel.writeString(this.mDefaultForwardReason);
        parcel.writeString(this.mWebUrl);
        parcel.writeMap(this.qzoneShareInfo);
    }

    public QZoneShareData() {
    }

    QZoneShareData(Parcel parcel) {
        this.appid = parcel.readLong();
        this.openId = parcel.readString();
        this.mTitle = parcel.readString();
        this.mSummary = parcel.readString();
        this.targetUrl = parcel.readString();
        ArrayList<String> arrayList = new ArrayList<>();
        this.mImageUrls = arrayList;
        parcel.readStringList(arrayList);
        this.appName = parcel.readString();
        this.shareUin = parcel.readString();
        this.extString = parcel.readString();
        this.iUrlInfoFrm = parcel.readInt();
        this.from = parcel.readInt();
        this.action = parcel.readString();
        this.pkgname = parcel.readString();
        this.showShareOtherPlat = parcel.readInt();
        this.jFrom = parcel.readString();
        this.mShareBeginTime = parcel.readLong();
        this.mHint = parcel.readString();
        this.mDefaultForwardReason = parcel.readString();
        this.mWebUrl = parcel.readString();
        this.qzoneShareInfo = parcel.readHashMap(Map.class.getClassLoader());
    }
}
