package org.light;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TextAsset implements Parcelable {
    public static final Parcelable.Creator<TextAsset> CREATOR = new Parcelable.Creator<TextAsset>() { // from class: org.light.TextAsset.1
        @Override // android.os.Parcelable.Creator
        public TextAsset createFromParcel(Parcel parcel) {
            return new TextAsset(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TextAsset[] newArray(int i3) {
            return new TextAsset[i3];
        }
    };
    public int fillColor;
    public String text;

    public TextAsset(String str, int i3) {
        this.text = str;
        this.fillColor = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.text);
        parcel.writeInt(this.fillColor);
    }

    protected TextAsset(Parcel parcel) {
        this.text = "";
        this.fillColor = 0;
        this.text = parcel.readString();
        this.fillColor = parcel.readInt();
    }
}
