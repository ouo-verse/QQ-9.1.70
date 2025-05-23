package org.light;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes29.dex */
public class TextPlaceHolder implements Parcelable {
    public static final Parcelable.Creator<TextPlaceHolder> CREATOR = new Parcelable.Creator<TextPlaceHolder>() { // from class: org.light.TextPlaceHolder.1
        @Override // android.os.Parcelable.Creator
        public TextPlaceHolder createFromParcel(Parcel parcel) {
            return new TextPlaceHolder(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TextPlaceHolder[] newArray(int i3) {
            return new TextPlaceHolder[i3];
        }
    };
    public int entityId;
    public int fillColor;
    public String key;
    public float layerHeight;
    public float layerWidth;
    public int maxLength;
    public int replaceIndex;
    public String text;

    public TextPlaceHolder(String str, String str2, int i3, int i16) {
        this.key = str;
        this.text = str2;
        this.fillColor = i3;
        this.maxLength = i16;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.key);
        parcel.writeString(this.text);
        parcel.writeInt(this.fillColor);
        parcel.writeInt(this.maxLength);
        parcel.writeFloat(this.layerWidth);
        parcel.writeFloat(this.layerHeight);
        parcel.writeInt(this.replaceIndex);
        parcel.writeInt(this.entityId);
    }

    public TextPlaceHolder(String str, String str2, int i3, int i16, float f16, float f17, int i17, int i18) {
        this.key = str;
        this.text = str2;
        this.fillColor = i3;
        this.maxLength = i16;
        this.layerWidth = f16;
        this.layerHeight = f17;
        this.replaceIndex = i17;
        this.entityId = i18;
    }

    protected TextPlaceHolder(Parcel parcel) {
        this.key = "";
        this.text = "";
        this.key = parcel.readString();
        this.text = parcel.readString();
        this.fillColor = parcel.readInt();
        this.maxLength = parcel.readInt();
        this.layerWidth = parcel.readFloat();
        this.layerHeight = parcel.readFloat();
        this.replaceIndex = parcel.readInt();
        this.entityId = parcel.readInt();
    }
}
