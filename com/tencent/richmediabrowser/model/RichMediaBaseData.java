package com.tencent.richmediabrowser.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class RichMediaBaseData implements Parcelable {
    public static final Parcelable.Creator<RichMediaBaseData> CREATOR = new Parcelable.Creator<RichMediaBaseData>() { // from class: com.tencent.richmediabrowser.model.RichMediaBaseData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RichMediaBaseData createFromParcel(Parcel parcel) {
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RichMediaBaseData[] newArray(int i3) {
            return new RichMediaBaseData[i3];
        }
    };
    public String filePath;
    public int fileType;

    /* renamed from: id, reason: collision with root package name */
    public String f365136id;
    public boolean isLocal;
    public int progress;
    public int status;
    public String url;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract int getType();

    public void readFromParcel(Parcel parcel) {
        this.f365136id = parcel.readString();
        this.url = parcel.readString();
        this.filePath = parcel.readString();
        boolean z16 = true;
        if (parcel.readInt() != 1) {
            z16 = false;
        }
        this.isLocal = z16;
        this.fileType = parcel.readInt();
        this.status = parcel.readInt();
        this.progress = parcel.readInt();
    }

    public void updateProgress(int i3) {
        this.progress = i3;
    }

    public void updateStatus(int i3) {
        this.status = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f365136id);
        parcel.writeString(this.url);
        parcel.writeString(this.filePath);
        parcel.writeInt(this.isLocal ? 1 : 0);
        parcel.writeInt(this.fileType);
        parcel.writeInt(this.status);
        parcel.writeInt(this.progress);
    }
}
