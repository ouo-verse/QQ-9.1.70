package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes10.dex */
public class Setting extends Entity implements Parcelable {
    public static final Parcelable.Creator<Setting> CREATOR = new a();
    public byte bFaceFlags;
    public byte bHeadType;
    public byte bSourceType;
    public byte bUsrType;
    public byte dynamicZplanFaceFlag;
    public byte staticZplanFaceFlag;

    @unique
    public String uin;
    public long updateTimestamp;
    public String url;
    public String zplanFaceBgUrl;
    public int zplanFaceClipPercent;
    public long headImgTimestamp = 0;
    public short systemHeadID = 0;
    public byte apngFaceFlag = 0;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator<Setting> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Setting createFromParcel(Parcel parcel) {
            Setting setting = new Setting();
            setting.readFromParcel(parcel);
            return setting;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Setting[] newArray(int i3) {
            return new Setting[i3];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.uin = parcel.readString();
        this.headImgTimestamp = parcel.readLong();
        this.systemHeadID = (short) parcel.readInt();
        this.bFaceFlags = parcel.readByte();
        this.bUsrType = parcel.readByte();
        this.bHeadType = parcel.readByte();
        this.url = parcel.readString();
        this.bSourceType = parcel.readByte();
        this.updateTimestamp = parcel.readLong();
        this.staticZplanFaceFlag = parcel.readByte();
        this.dynamicZplanFaceFlag = parcel.readByte();
        this.zplanFaceBgUrl = parcel.readString();
        this.zplanFaceClipPercent = parcel.readInt();
        this.apngFaceFlag = parcel.readByte();
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(64);
        sb5.append("[uin:");
        sb5.append(this.uin);
        sb5.append(",headImgTimestamp:");
        sb5.append(this.headImgTimestamp);
        sb5.append(",systemHeadId:");
        sb5.append((int) this.systemHeadID);
        sb5.append(",bFaceFlags:");
        sb5.append((int) this.bFaceFlags);
        sb5.append(",bUsrType:");
        sb5.append((int) this.bUsrType);
        sb5.append(",bHeadType:");
        sb5.append((int) this.bHeadType);
        sb5.append(",bSourceType:");
        sb5.append((int) this.bSourceType);
        sb5.append(",updateTimestamp:");
        sb5.append(this.updateTimestamp);
        sb5.append(",url:");
        sb5.append(this.url);
        sb5.append(",staticZplanFaceFlag:");
        sb5.append((int) this.staticZplanFaceFlag);
        sb5.append(",dynamicZplanFaceFlag:");
        sb5.append((int) this.dynamicZplanFaceFlag);
        sb5.append(",zplanFaceBgUrl:");
        sb5.append(this.zplanFaceBgUrl);
        sb5.append(",zplanFaceClipPercent:");
        sb5.append(this.zplanFaceClipPercent);
        sb5.append(",apngFaceFlag:");
        sb5.append((int) this.apngFaceFlag);
        sb5.append("]");
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.uin);
        parcel.writeLong(this.headImgTimestamp);
        parcel.writeInt(this.systemHeadID);
        parcel.writeByte(this.bFaceFlags);
        parcel.writeByte(this.bUsrType);
        parcel.writeByte(this.bHeadType);
        parcel.writeString(this.url);
        parcel.writeByte(this.bSourceType);
        parcel.writeLong(this.updateTimestamp);
        parcel.writeByte(this.staticZplanFaceFlag);
        parcel.writeByte(this.dynamicZplanFaceFlag);
        parcel.writeString(this.zplanFaceBgUrl);
        parcel.writeInt(this.zplanFaceClipPercent);
        parcel.writeByte(this.apngFaceFlag);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Setting m175clone() {
        Setting setting = new Setting();
        setting.uin = this.uin;
        setting.headImgTimestamp = this.headImgTimestamp;
        setting.systemHeadID = this.systemHeadID;
        setting.bFaceFlags = this.bFaceFlags;
        setting.bUsrType = this.bUsrType;
        setting.bHeadType = this.bHeadType;
        setting.url = this.url;
        setting.bSourceType = this.bSourceType;
        setting.updateTimestamp = this.updateTimestamp;
        setting.staticZplanFaceFlag = this.staticZplanFaceFlag;
        setting.dynamicZplanFaceFlag = this.dynamicZplanFaceFlag;
        setting.zplanFaceBgUrl = this.zplanFaceBgUrl;
        setting.zplanFaceClipPercent = this.zplanFaceClipPercent;
        setting.apngFaceFlag = this.apngFaceFlag;
        return setting;
    }
}
