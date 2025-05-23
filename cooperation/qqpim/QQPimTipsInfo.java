package cooperation.qqpim;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes28.dex */
public class QQPimTipsInfo implements Parcelable {
    public static final Parcelable.Creator<QQPimTipsInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public int f390793d;

    /* renamed from: e, reason: collision with root package name */
    public String f390794e;

    /* renamed from: f, reason: collision with root package name */
    public byte f390795f;

    /* renamed from: h, reason: collision with root package name */
    public int f390796h;

    /* loaded from: classes28.dex */
    class a implements Parcelable.Creator<QQPimTipsInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QQPimTipsInfo createFromParcel(Parcel parcel) {
            return new QQPimTipsInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QQPimTipsInfo[] newArray(int i3) {
            return new QQPimTipsInfo[i3];
        }
    }

    public QQPimTipsInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f390793d);
        parcel.writeString(this.f390794e);
        parcel.writeByte(this.f390795f);
        parcel.writeInt(this.f390796h);
    }

    QQPimTipsInfo(Parcel parcel) {
        this.f390793d = parcel.readInt();
        this.f390794e = parcel.readString();
        this.f390795f = parcel.readByte();
        this.f390796h = parcel.readInt();
    }
}
