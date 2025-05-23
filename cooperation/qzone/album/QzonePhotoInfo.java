package cooperation.qzone.album;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes28.dex */
public class QzonePhotoInfo implements Parcelable {
    public static final Parcelable.Creator<QzonePhotoInfo> CREATOR = new Parcelable.Creator<QzonePhotoInfo>() { // from class: cooperation.qzone.album.QzonePhotoInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QzonePhotoInfo createFromParcel(Parcel parcel) {
            return new QzonePhotoInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QzonePhotoInfo[] newArray(int i3) {
            return new QzonePhotoInfo[i3];
        }
    };
    public String mAlbumId;
    public int mBigHeight;
    public String mBigUrl;
    public int mBigWidth;
    public long mShootTime;
    public Map<Integer, String> mShouzhang_extend_map;
    public long mUploadTime;
    public String mlloc;

    public QzonePhotoInfo() {
        this.mAlbumId = "";
        this.mBigUrl = "";
        this.mBigWidth = 0;
        this.mBigHeight = 0;
        this.mlloc = "";
        this.mShouzhang_extend_map = new HashMap();
        this.mShootTime = 0L;
        this.mUploadTime = 0L;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.mAlbumId);
        parcel.writeString(this.mBigUrl);
        parcel.writeInt(this.mBigWidth);
        parcel.writeInt(this.mBigHeight);
        parcel.writeString(this.mlloc);
        parcel.writeMap(this.mShouzhang_extend_map);
        parcel.writeLong(this.mShootTime);
        parcel.writeLong(this.mUploadTime);
    }

    protected QzonePhotoInfo(Parcel parcel) {
        this.mAlbumId = "";
        this.mBigUrl = "";
        this.mBigWidth = 0;
        this.mBigHeight = 0;
        this.mlloc = "";
        this.mShouzhang_extend_map = new HashMap();
        this.mShootTime = 0L;
        this.mUploadTime = 0L;
        this.mAlbumId = parcel.readString();
        this.mBigUrl = parcel.readString();
        this.mBigWidth = parcel.readInt();
        this.mBigHeight = parcel.readInt();
        this.mlloc = parcel.readString();
        this.mShouzhang_extend_map = parcel.readHashMap(Map.class.getClassLoader());
        this.mShootTime = parcel.readLong();
        this.mUploadTime = parcel.readLong();
    }
}
