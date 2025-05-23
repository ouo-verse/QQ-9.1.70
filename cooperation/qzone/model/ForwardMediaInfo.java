package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ForwardMediaInfo implements Parcelable {
    public static final Parcelable.Creator<ForwardMediaInfo> CREATOR = new Parcelable.Creator<ForwardMediaInfo>() { // from class: cooperation.qzone.model.ForwardMediaInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ForwardMediaInfo createFromParcel(Parcel parcel) {
            return new ForwardMediaInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ForwardMediaInfo[] newArray(int i3) {
            return new ForwardMediaInfo[i3];
        }
    };
    public static final int MEDIA_TYPE_FILE_PIC = 3;
    public static final int MEDIA_TYPE_FILE_VIDEO = 4;
    public static final int MEDIA_TYPE_PIC = 1;
    public static final int MEDIA_TYPE_UNKNOWN = 0;
    public static final int MEDIA_TYPE_VIDEO = 2;
    public String dittoUin;
    public String downloadIndex;
    public Integer fileBizId;
    public int fileFormat;
    public String fileMd5;
    public String fileName;
    public String filePath;
    public String fileSha;
    public String fileSha3;
    public long fileSize;
    public String fileSubId;
    public int fileTime;
    public String fileUuid;
    public int invalidState;
    public Boolean isFlashPic;
    public String md5HexStr;
    public int mediaType;
    public long msgTime;
    public String originImageMd5;
    public String originImageUrl;
    public String originVideoMd5;
    public boolean original;
    public int picHeight;
    public int picSubType;
    public int picWidth;
    public String sourcePath;
    public int storeID;
    public String summary;
    public int thumbHeight;
    public String thumbMd5;
    public Map<Integer, String> thumbPath;
    public int thumbSize;
    public int thumbWidth;
    public long uin;
    public String videoMd5;

    public ForwardMediaInfo() {
        this.mediaType = 0;
        this.uin = 0L;
        this.dittoUin = "";
        this.storeID = 0;
        this.invalidState = 0;
        this.filePath = "";
        this.fileName = "";
        this.videoMd5 = "";
        this.thumbMd5 = "";
        this.fileUuid = "";
        this.fileSubId = "";
        this.originVideoMd5 = "";
        this.md5HexStr = "";
        this.originImageMd5 = "";
        this.fileSha = "";
        this.fileSha3 = "";
        this.fileMd5 = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public String toString() {
        return "ForwardMediaInfo{+ storeID='" + this.storeID + "', + msgTime='" + this.msgTime + "', + fileName='" + this.fileName + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.mediaType);
        parcel.writeLong(this.uin);
        parcel.writeString(this.dittoUin);
        parcel.writeLong(this.msgTime);
        parcel.writeMap(this.thumbPath);
        parcel.writeString(this.filePath);
        parcel.writeString(this.fileName);
        parcel.writeString(this.videoMd5);
        parcel.writeString(this.thumbMd5);
        parcel.writeInt(this.fileTime);
        parcel.writeInt(this.thumbSize);
        parcel.writeInt(this.fileFormat);
        parcel.writeLong(this.fileSize);
        parcel.writeInt(this.thumbWidth);
        parcel.writeInt(this.thumbHeight);
        parcel.writeString(this.fileUuid);
        parcel.writeString(this.fileSubId);
        int i16 = 0;
        if (this.fileBizId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.fileBizId.intValue());
        }
        parcel.writeString(this.originVideoMd5);
        parcel.writeInt(this.picSubType);
        parcel.writeInt(this.picWidth);
        parcel.writeInt(this.picHeight);
        parcel.writeByte(this.original ? (byte) 1 : (byte) 0);
        parcel.writeString(this.md5HexStr);
        parcel.writeString(this.sourcePath);
        parcel.writeString(this.downloadIndex);
        parcel.writeString(this.summary);
        parcel.writeString(this.originImageMd5);
        parcel.writeString(this.originImageUrl);
        Boolean bool = this.isFlashPic;
        if (bool != null) {
            if (bool.booleanValue()) {
                i16 = 1;
            } else {
                i16 = 2;
            }
        }
        parcel.writeByte((byte) i16);
        parcel.writeString(this.fileSha);
        parcel.writeString(this.fileSha3);
        parcel.writeString(this.fileMd5);
        parcel.writeInt(this.storeID);
    }

    protected ForwardMediaInfo(Parcel parcel) {
        this.mediaType = 0;
        this.uin = 0L;
        this.dittoUin = "";
        this.storeID = 0;
        this.invalidState = 0;
        this.filePath = "";
        this.fileName = "";
        this.videoMd5 = "";
        this.thumbMd5 = "";
        this.fileUuid = "";
        this.fileSubId = "";
        this.originVideoMd5 = "";
        this.md5HexStr = "";
        this.originImageMd5 = "";
        this.fileSha = "";
        this.fileSha3 = "";
        this.fileMd5 = "";
        this.mediaType = parcel.readInt();
        this.uin = parcel.readLong();
        this.dittoUin = parcel.readString();
        this.msgTime = parcel.readLong();
        this.thumbPath = parcel.readHashMap(getClass().getClassLoader());
        this.filePath = parcel.readString();
        this.fileName = parcel.readString();
        this.videoMd5 = parcel.readString();
        this.thumbMd5 = parcel.readString();
        this.fileTime = parcel.readInt();
        this.thumbSize = parcel.readInt();
        this.fileFormat = parcel.readInt();
        this.fileSize = parcel.readLong();
        this.thumbWidth = parcel.readInt();
        this.thumbHeight = parcel.readInt();
        this.fileUuid = parcel.readString();
        this.fileSubId = parcel.readString();
        Boolean bool = null;
        if (parcel.readByte() == 0) {
            this.fileBizId = null;
        } else {
            this.fileBizId = Integer.valueOf(parcel.readInt());
        }
        this.originVideoMd5 = parcel.readString();
        this.picSubType = parcel.readInt();
        this.picWidth = parcel.readInt();
        this.picHeight = parcel.readInt();
        this.original = parcel.readByte() != 0;
        this.md5HexStr = parcel.readString();
        this.sourcePath = parcel.readString();
        this.downloadIndex = parcel.readString();
        this.summary = parcel.readString();
        this.originImageMd5 = parcel.readString();
        this.originImageUrl = parcel.readString();
        byte readByte = parcel.readByte();
        if (readByte != 0) {
            bool = Boolean.valueOf(readByte == 1);
        }
        this.isFlashPic = bool;
        this.fileSha = parcel.readString();
        this.fileSha3 = parcel.readString();
        this.fileMd5 = parcel.readString();
        this.storeID = parcel.readInt();
    }
}
