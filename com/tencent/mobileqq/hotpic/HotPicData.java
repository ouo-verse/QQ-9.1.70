package com.tencent.mobileqq.hotpic;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "url,tag,picIndex")
/* loaded from: classes9.dex */
public class HotPicData extends Entity implements Cloneable, Parcelable {
    static IPatchRedirector $redirector_ = null;
    public static final Parcelable.Creator<HotPicData> CREATOR;
    public static final int DATA_GIF = 1;
    public static final int DATA_VIDEO = 2;
    public static final String HOT_PIC_EXTRA = "HOT_PIC_EXTRA";
    public static final String HOT_PIC_HAS_EXTRA = "HOT_PIC_HAS_EXTRA";
    public static final String HOT_PIC_SEND = "HOT_PIC_SEND_PIC";
    public static final String HOT_PIC_TRANS_FILESIZE = "HOT_PIC_TRANS_FILESIZE";
    public static final String HOT_PIC_TRANS_MD5 = "HOT_PIC_TRANS_MD5";
    public static final String HOT_PIC_TRANS_THUMB_MD5 = "HOT_PIC_TRANS_THUMB_MD5";
    public String appid;
    public String filePath;
    public long fileSize;
    public int fileType;
    public int height;
    public String homepageUrl;
    public String iconUrl;
    public String jumpUrl;
    public String md5;
    public String name;
    public int originalHeight;
    public String originalMD5;
    public String originalUrl;
    public int originalWidth;
    public long oringinalSize;
    public String picId;
    public int picIndex;
    public String resourceId;
    public int sourceType;
    public String srcDesc;
    public int srcType;
    public int tag;
    public String thumbImgFileId;
    public int thumbImgHeight;
    public String thumbImgMD5;
    public int thumbImgWidth;
    public long thumbSize;
    public String url;
    public int version;
    public long videoDuration;
    public String videoFileId;
    public int videoFormat;
    public int videoHeight;
    public String videoIconUrl;
    public String videoMD5;
    public String videoName;
    public String videoOther;
    public long videoSize;
    public int videoWidth;
    public int width;

    /* loaded from: classes9.dex */
    class a implements Parcelable.Creator<HotPicData> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HotPicData createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (HotPicData) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new HotPicData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public HotPicData[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (HotPicData[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new HotPicData[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37022);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            CREATOR = new a();
        }
    }

    public HotPicData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this);
    }

    public Object clone() throws CloneNotSupportedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return super.clone();
    }

    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 0;
    }

    public int getDataType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return 1;
        }
        return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "HotPicData{url='" + this.url + "', md5='" + this.md5 + "', fileSize=" + this.fileSize + ", width=" + this.width + ", height=" + this.height + ", originalMD5='" + this.originalMD5 + "', oringinalSize=" + this.oringinalSize + ", originalWidth=" + this.originalWidth + ", originalHeight=" + this.originalHeight + ", originalUrl='" + this.originalUrl + "', fileType=" + this.fileType + ", picIndex=" + this.picIndex + ", sourceType=" + this.sourceType + ", filePath='" + this.filePath + "', version=" + this.version + ", appid='" + this.appid + "', iconUrl='" + this.iconUrl + "', name='" + this.name + "', jumpUrl='" + this.jumpUrl + "', resourceId='" + this.resourceId + "', videoMD5='" + this.videoMD5 + "', videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", videoFileId='" + this.videoFileId + "', videoSize=" + this.videoSize + ", videoName='" + this.videoName + "', videoDuration=" + this.videoDuration + ", videoFormat=" + this.videoFormat + ", thumbImgMD5='" + this.thumbImgMD5 + "', thumbImgWidth=" + this.thumbImgWidth + ", thumbImgHeight=" + this.thumbImgHeight + ", thumbImgFileId='" + this.thumbImgFileId + "', thumbSize=" + this.thumbSize + ", srcType=" + this.srcType + ", srcDesc='" + this.srcDesc + "', homepageUrl='" + this.homepageUrl + "', videoIconUrl='" + this.videoIconUrl + "', videoOther='" + this.videoOther + "', tag=" + this.tag + "', picId='" + this.picId + '}';
    }

    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.url);
        parcel.writeString(this.md5);
        parcel.writeLong(this.fileSize);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeString(this.originalMD5);
        parcel.writeLong(this.oringinalSize);
        parcel.writeInt(this.originalWidth);
        parcel.writeInt(this.originalHeight);
        parcel.writeString(this.originalUrl);
        parcel.writeInt(this.fileType);
        parcel.writeInt(this.picIndex);
        parcel.writeInt(this.sourceType);
        parcel.writeString(this.filePath);
        parcel.writeInt(this.version);
        parcel.writeString(this.appid);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.name);
        parcel.writeString(this.jumpUrl);
        parcel.writeString(this.resourceId);
        parcel.writeString(this.videoMD5);
        parcel.writeInt(this.videoWidth);
        parcel.writeInt(this.videoHeight);
        parcel.writeString(this.videoFileId);
        parcel.writeLong(this.videoSize);
        parcel.writeString(this.videoName);
        parcel.writeLong(this.videoDuration);
        parcel.writeInt(this.videoFormat);
        parcel.writeString(this.thumbImgMD5);
        parcel.writeInt(this.thumbImgWidth);
        parcel.writeInt(this.thumbImgHeight);
        parcel.writeString(this.thumbImgFileId);
        parcel.writeLong(this.thumbSize);
        parcel.writeInt(this.srcType);
        parcel.writeString(this.srcDesc);
        parcel.writeString(this.homepageUrl);
        parcel.writeString(this.videoIconUrl);
        parcel.writeString(this.videoOther);
        parcel.writeInt(this.tag);
        parcel.writeString(this.picId);
    }

    public HotPicData(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel);
            return;
        }
        this.url = parcel.readString();
        this.md5 = parcel.readString();
        this.fileSize = parcel.readLong();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.originalMD5 = parcel.readString();
        this.oringinalSize = parcel.readLong();
        this.originalWidth = parcel.readInt();
        this.originalHeight = parcel.readInt();
        this.originalUrl = parcel.readString();
        this.fileType = parcel.readInt();
        this.picIndex = parcel.readInt();
        this.sourceType = parcel.readInt();
        this.filePath = parcel.readString();
        this.version = parcel.readInt();
        this.appid = parcel.readString();
        this.iconUrl = parcel.readString();
        this.name = parcel.readString();
        this.jumpUrl = parcel.readString();
        this.resourceId = parcel.readString();
        this.videoMD5 = parcel.readString();
        this.videoWidth = parcel.readInt();
        this.videoHeight = parcel.readInt();
        this.videoFileId = parcel.readString();
        this.videoSize = parcel.readLong();
        this.videoName = parcel.readString();
        this.videoDuration = parcel.readLong();
        this.videoFormat = parcel.readInt();
        this.thumbImgMD5 = parcel.readString();
        this.thumbImgWidth = parcel.readInt();
        this.thumbImgHeight = parcel.readInt();
        this.thumbImgFileId = parcel.readString();
        this.thumbSize = parcel.readLong();
        this.srcType = parcel.readInt();
        this.srcDesc = parcel.readString();
        this.homepageUrl = parcel.readString();
        this.videoIconUrl = parcel.readString();
        this.videoOther = parcel.readString();
        this.tag = parcel.readInt();
        this.picId = parcel.readString();
    }
}
