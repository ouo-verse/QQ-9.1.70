package com.tencent.ad.tangram;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.ad.tangram.annotation.AdKeep;

@AdKeep
/* loaded from: classes3.dex */
public final class AdClickLocationParams implements Parcelable {
    public static final Parcelable.Creator<AdClickLocationParams> CREATOR = new Parcelable.Creator<AdClickLocationParams>() { // from class: com.tencent.ad.tangram.AdClickLocationParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdClickLocationParams createFromParcel(Parcel parcel) {
            return new AdClickLocationParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdClickLocationParams[] newArray(int i3) {
            return new AdClickLocationParams[i3];
        }
    };
    public int indexOfCarouselAd;
    public int indexOfMPDA;

    public AdClickLocationParams() {
        this.indexOfCarouselAd = Integer.MIN_VALUE;
        this.indexOfMPDA = Integer.MIN_VALUE;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isDefault() {
        if (this.indexOfCarouselAd == Integer.MIN_VALUE && this.indexOfMPDA == Integer.MIN_VALUE) {
            return true;
        }
        return false;
    }

    public boolean isValid(Ad ad5) {
        boolean isValidForCarouselAd = isValidForCarouselAd(ad5);
        boolean isValidForMPDA = isValidForMPDA(ad5);
        if (!isDefault() && isValidForCarouselAd && isValidForMPDA) {
            return false;
        }
        return true;
    }

    public boolean isValidForCarouselAd(Ad ad5) {
        int i3;
        if (ad5 != null && ad5.isValid() && (i3 = this.indexOfCarouselAd) >= 0 && i3 < ad5.getCarouselAdCount()) {
            return true;
        }
        return false;
    }

    public boolean isValidForMPDA(Ad ad5) {
        int i3;
        if (ad5 != null && ad5.isValid() && (i3 = this.indexOfMPDA) >= 0 && i3 < ad5.getMDPACount()) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "AdClickLocationParams(indexOfCarouselAd=" + this.indexOfCarouselAd + ", indexOfMPDA=" + this.indexOfMPDA + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.indexOfCarouselAd);
        parcel.writeInt(this.indexOfMPDA);
    }

    protected AdClickLocationParams(Parcel parcel) {
        this.indexOfCarouselAd = Integer.MIN_VALUE;
        this.indexOfMPDA = Integer.MIN_VALUE;
        this.indexOfCarouselAd = parcel.readInt();
        this.indexOfMPDA = parcel.readInt();
    }
}
