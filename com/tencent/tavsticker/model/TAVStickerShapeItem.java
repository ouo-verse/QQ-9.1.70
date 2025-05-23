package com.tencent.tavsticker.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.libpag.PAGLayer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVStickerShapeItem extends TAVStickerLayerItem implements Parcelable {
    public static final Parcelable.Creator<TAVStickerShapeItem> CREATOR = new Parcelable.Creator<TAVStickerShapeItem>() { // from class: com.tencent.tavsticker.model.TAVStickerShapeItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TAVStickerShapeItem createFromParcel(Parcel parcel) {
            return new TAVStickerShapeItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TAVStickerShapeItem[] newArray(int i3) {
            return new TAVStickerShapeItem[i3];
        }
    };

    public TAVStickerShapeItem() {
        this.layerType = 4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "TAVStickerShapeItem {layerIndex : " + this.layerIndex + ", layerName : " + this.layerName + ", layerType : " + this.layerType + "}";
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
    }

    public TAVStickerShapeItem(PAGLayer pAGLayer) {
        super(pAGLayer);
    }

    protected TAVStickerShapeItem(Parcel parcel) {
        if (parcel != null) {
            this.layerIndex = parcel.readInt();
            this.layerName = parcel.readString();
            this.layerType = parcel.readInt();
        }
    }
}
