package oicq.wlogin_sdk.sharemem;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WloginLoginInfo implements Serializable, Parcelable {
    public static final Parcelable.Creator<WloginLoginInfo> CREATOR = new a();
    public static int TYPE_LOACL = 1;
    public static int TYPE_REMOTE = 2;
    private static final long serialVersionUID = 5551948389726789420L;
    public String mAccount;
    public long mAppid;
    public long mCreateTime;
    public String mFaceUrl;
    public int mLoginBitmap;
    public int mType;
    public long mUin;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a implements Parcelable.Creator<WloginLoginInfo> {
        @Override // android.os.Parcelable.Creator
        public WloginLoginInfo createFromParcel(Parcel parcel) {
            return new WloginLoginInfo(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public WloginLoginInfo[] newArray(int i3) {
            return new WloginLoginInfo[i3];
        }
    }

    WloginLoginInfo(Parcel parcel) {
        this.mFaceUrl = "";
        readFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.mAccount = parcel.readString();
        this.mUin = parcel.readLong();
        this.mAppid = parcel.readLong();
        this.mCreateTime = parcel.readLong();
        this.mType = parcel.readInt();
        this.mLoginBitmap = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.mAccount);
        parcel.writeLong(this.mUin);
        parcel.writeLong(this.mAppid);
        parcel.writeLong(this.mCreateTime);
        parcel.writeInt(this.mType);
        parcel.writeInt(this.mLoginBitmap);
    }

    public /* synthetic */ WloginLoginInfo(Parcel parcel, a aVar) {
        this(parcel);
    }

    public WloginLoginInfo(String str, long j3, long j16, String str2, long j17, int i3, int i16) {
        this.mAccount = str;
        this.mUin = j3;
        this.mAppid = j16;
        this.mFaceUrl = str2;
        this.mCreateTime = j17;
        this.mType = i3;
        this.mLoginBitmap = i16;
    }
}
