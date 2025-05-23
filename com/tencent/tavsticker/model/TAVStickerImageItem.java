package com.tencent.tavsticker.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import org.libpag.PAGLayer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVStickerImageItem extends TAVStickerLayerItem implements Parcelable {
    public static final Parcelable.Creator<TAVStickerImageItem> CREATOR = new Parcelable.Creator<TAVStickerImageItem>() { // from class: com.tencent.tavsticker.model.TAVStickerImageItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TAVStickerImageItem createFromParcel(Parcel parcel) {
            return new TAVStickerImageItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TAVStickerImageItem[] newArray(int i3) {
            return new TAVStickerImageItem[i3];
        }
    };
    private Bitmap bitmap;

    public TAVStickerImageItem() {
        this.bitmap = null;
        this.layerType = 5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String toString() {
        return "TAVStickerImageItem {layerIndex : " + this.layerIndex + ", layerName : " + this.layerName + ", layerType : " + this.layerType + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.layerIndex);
        String str = this.layerName;
        if (str == null) {
            str = "";
        }
        parcel.writeString(str);
        parcel.writeInt(this.layerType);
        parcel.writeParcelable(this.bitmap, i3);
    }

    public TAVStickerImageItem(PAGLayer pAGLayer) {
        super(pAGLayer);
        this.bitmap = null;
    }

    protected TAVStickerImageItem(Parcel parcel) {
        this.bitmap = null;
        if (parcel != null) {
            this.layerIndex = parcel.readInt();
            this.layerName = parcel.readString();
            this.layerType = parcel.readInt();
            this.bitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        }
    }
}
