package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TailColor implements Parcelable {
    public static final Parcelable.Creator<TailColor> CREATOR = new Parcelable.Creator<TailColor>() { // from class: cooperation.qzone.model.TailColor.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TailColor createFromParcel(Parcel parcel) {
            return new TailColor(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TailColor[] newArray(int i3) {
            return new TailColor[i3];
        }
    };
    public String backgroundColor;
    public String textColor;
    public String token;

    public TailColor() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.token);
        parcel.writeString(this.textColor);
        parcel.writeString(this.backgroundColor);
    }

    protected TailColor(Parcel parcel) {
        this.token = parcel.readString();
        this.textColor = parcel.readString();
        this.backgroundColor = parcel.readString();
    }
}
