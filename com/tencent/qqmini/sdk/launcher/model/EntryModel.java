package com.tencent.qqmini.sdk.launcher.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes23.dex */
public class EntryModel implements Parcelable {
    public static final Parcelable.Creator<EntryModel> CREATOR = new Parcelable.Creator<EntryModel>() { // from class: com.tencent.qqmini.sdk.launcher.model.EntryModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EntryModel createFromParcel(Parcel parcel) {
            return new EntryModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EntryModel[] newArray(int i3) {
            return new EntryModel[i3];
        }
    };
    public static final int TYPE_C2C = 0;
    public static final int TYPE_FULLMINI = 10;
    public static final int TYPE_GROUP = 1;
    public static final int TYPE_HALFMINI = 9;
    public long dwGroupClassExt;
    private String entryDataHash;
    public boolean isAdmin;
    public Bundle mArguments;
    public String name;
    public String reportData;
    public String titleBarClassName;
    public String titlebarIconUrl;
    public int type;
    public long uin;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getEntryHash() {
        return this.entryDataHash;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.type);
        parcel.writeLong(this.uin);
        parcel.writeString(this.name);
        parcel.writeByte(this.isAdmin ? (byte) 1 : (byte) 0);
        parcel.writeString(this.entryDataHash);
        parcel.writeLong(this.dwGroupClassExt);
        parcel.writeString(this.reportData);
        parcel.writeString(this.titlebarIconUrl);
        parcel.writeString(this.titleBarClassName);
        parcel.writeBundle(this.mArguments);
    }

    public EntryModel(int i3, long j3, String str, boolean z16, long j16, String str2) {
        this.titleBarClassName = "";
        this.type = i3;
        this.uin = j3;
        this.name = str;
        this.isAdmin = z16;
        this.dwGroupClassExt = j16;
        this.reportData = str2;
        this.entryDataHash = UUID.randomUUID().toString();
    }

    EntryModel(Parcel parcel) {
        this.titleBarClassName = "";
        this.type = parcel.readInt();
        this.uin = parcel.readLong();
        this.name = parcel.readString();
        this.isAdmin = parcel.readByte() != 0;
        this.entryDataHash = parcel.readString();
        this.dwGroupClassExt = parcel.readLong();
        this.reportData = parcel.readString();
        this.titlebarIconUrl = parcel.readString();
        this.titleBarClassName = parcel.readString();
        this.mArguments = parcel.readBundle();
    }
}
