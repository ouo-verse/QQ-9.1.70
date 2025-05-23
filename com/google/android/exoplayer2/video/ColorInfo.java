package com.google.android.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class ColorInfo implements Parcelable {
    public static final Parcelable.Creator<ColorInfo> CREATOR = new Parcelable.Creator<ColorInfo>() { // from class: com.google.android.exoplayer2.video.ColorInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ColorInfo[] newArray(int i3) {
            return new ColorInfo[0];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ColorInfo createFromParcel(Parcel parcel) {
            return new ColorInfo(parcel);
        }
    };
    public final int colorRange;
    public final int colorSpace;
    public final int colorTransfer;
    private int hashCode;
    public final byte[] hdrStaticInfo;

    public ColorInfo(int i3, int i16, int i17, byte[] bArr) {
        this.colorSpace = i3;
        this.colorRange = i16;
        this.colorTransfer = i17;
        this.hdrStaticInfo = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ColorInfo.class != obj.getClass()) {
            return false;
        }
        ColorInfo colorInfo = (ColorInfo) obj;
        if (this.colorSpace == colorInfo.colorSpace && this.colorRange == colorInfo.colorRange && this.colorTransfer == colorInfo.colorTransfer && Arrays.equals(this.hdrStaticInfo, colorInfo.hdrStaticInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = ((((((527 + this.colorSpace) * 31) + this.colorRange) * 31) + this.colorTransfer) * 31) + Arrays.hashCode(this.hdrStaticInfo);
        }
        return this.hashCode;
    }

    public String toString() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ColorInfo(");
        sb5.append(this.colorSpace);
        sb5.append(", ");
        sb5.append(this.colorRange);
        sb5.append(", ");
        sb5.append(this.colorTransfer);
        sb5.append(", ");
        if (this.hdrStaticInfo != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append(")");
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int i16;
        parcel.writeInt(this.colorSpace);
        parcel.writeInt(this.colorRange);
        parcel.writeInt(this.colorTransfer);
        if (this.hdrStaticInfo != null) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        parcel.writeInt(i16);
        byte[] bArr = this.hdrStaticInfo;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }

    ColorInfo(Parcel parcel) {
        this.colorSpace = parcel.readInt();
        this.colorRange = parcel.readInt();
        this.colorTransfer = parcel.readInt();
        this.hdrStaticInfo = parcel.readInt() != 0 ? parcel.createByteArray() : null;
    }
}
