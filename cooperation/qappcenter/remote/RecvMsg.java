package cooperation.qappcenter.remote;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes28.dex */
public class RecvMsg implements Parcelable, Cloneable {
    public static final Parcelable.Creator<RecvMsg> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public int f390375d;

    /* renamed from: e, reason: collision with root package name */
    public String f390376e;

    /* renamed from: f, reason: collision with root package name */
    public int f390377f;

    /* renamed from: h, reason: collision with root package name */
    public Bundle f390378h;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements Parcelable.Creator<RecvMsg> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RecvMsg createFromParcel(Parcel parcel) {
            return new RecvMsg(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RecvMsg[] newArray(int i3) {
            return new RecvMsg[i3];
        }
    }

    public RecvMsg() {
        this.f390378h = new Bundle();
    }

    public int a() {
        return this.f390378h.getInt(cooperation.qzone.remote.RecvMsg.SSOSEQ_KEY, -1);
    }

    public void b(Parcel parcel) {
        try {
            this.f390377f = parcel.readInt();
            this.f390375d = parcel.readInt();
            this.f390376e = parcel.readString();
            this.f390378h.clear();
            this.f390378h.putAll(parcel.readBundle(getClass().getClassLoader()));
        } catch (RuntimeException e16) {
            QLog.w("RecvMsg", 1, "readFromParcel RuntimeException", e16);
            throw e16;
        }
    }

    public void c(int i3, String str) {
        this.f390375d = i3;
        this.f390378h.putString("error", str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "RecvMsg ssoseq:" + a() + " resultCode:" + this.f390375d + " serviceCmd:" + this.f390376e + " appSeq:" + this.f390377f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        try {
            parcel.writeInt(this.f390377f);
            parcel.writeInt(this.f390375d);
            parcel.writeString(this.f390376e);
            parcel.writeBundle(this.f390378h);
        } catch (RuntimeException e16) {
            QLog.w("RecvMsg", 1, "writeToParcel RuntimeException", e16);
            throw e16;
        }
    }

    public RecvMsg(int i3, String str) {
        this.f390378h = new Bundle();
        this.f390375d = 1001;
        this.f390377f = i3;
        this.f390376e = str;
    }

    public RecvMsg(Parcel parcel) {
        this.f390378h = new Bundle();
        b(parcel);
    }
}
