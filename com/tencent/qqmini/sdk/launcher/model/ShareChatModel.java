package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ShareChatModel implements Parcelable {
    public static final Parcelable.Creator<ShareChatModel> CREATOR = new Parcelable.Creator<ShareChatModel>() { // from class: com.tencent.qqmini.sdk.launcher.model.ShareChatModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareChatModel createFromParcel(Parcel parcel) {
            return new ShareChatModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareChatModel[] newArray(int i3) {
            return new ShareChatModel[i3];
        }
    };
    public static final int TYPE_C2C = 1;
    public static final int TYPE_GROUP = 2;
    private String entryDataHash;
    public String name;
    public Map<String, String> reportData;
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
        parcel.writeString(this.entryDataHash);
        parcel.writeMap(this.reportData);
    }

    public ShareChatModel(int i3, long j3, String str) {
        this.type = i3;
        this.uin = j3;
        this.name = str;
        this.entryDataHash = UUID.randomUUID().toString();
    }

    ShareChatModel(Parcel parcel) {
        this.type = parcel.readInt();
        this.uin = parcel.readLong();
        this.name = parcel.readString();
        this.entryDataHash = parcel.readString();
        if (this.reportData == null) {
            this.reportData = new HashMap();
        }
        parcel.readMap(this.reportData, Map.class.getClassLoader());
    }
}
