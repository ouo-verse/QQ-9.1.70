package cooperation.qappcenter.remote;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qphone.base.util.QLog;
import cooperation.qappcenter.remote.a;

/* compiled from: P */
/* loaded from: classes28.dex */
public class SendMsg implements Parcelable {
    public static final Parcelable.Creator<SendMsg> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public String f390390d;

    /* renamed from: e, reason: collision with root package name */
    public final Bundle f390391e = new Bundle();

    /* renamed from: f, reason: collision with root package name */
    long f390392f = -1;

    /* renamed from: h, reason: collision with root package name */
    long f390393h = -1;

    /* renamed from: i, reason: collision with root package name */
    int f390394i;

    /* renamed from: m, reason: collision with root package name */
    public cooperation.qappcenter.remote.a f390395m;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements Parcelable.Creator<SendMsg> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SendMsg createFromParcel(Parcel parcel) {
            return new SendMsg(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SendMsg[] newArray(int i3) {
            return new SendMsg[i3];
        }
    }

    public SendMsg(String str) {
        this.f390390d = str;
    }

    private void e(Parcel parcel) {
        try {
            this.f390394i = parcel.readInt();
            this.f390390d = parcel.readString();
            this.f390392f = parcel.readLong();
            this.f390391e.clear();
            this.f390391e.putAll(parcel.readBundle(getClass().getClassLoader()));
            this.f390395m = a.AbstractBinderC10103a.j(parcel.readStrongBinder());
        } catch (RuntimeException e16) {
            QLog.w("SendMsg", 1, "readFromParcel RuntimeException", e16);
            throw e16;
        }
    }

    public cooperation.qappcenter.remote.a a() {
        return this.f390395m;
    }

    public int b() {
        return this.f390394i;
    }

    public String c() {
        return this.f390390d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "SendMsg appSeq:" + this.f390394i + " serviceCmd:" + this.f390390d + " timeout:" + this.f390392f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        try {
            parcel.writeInt(this.f390394i);
            parcel.writeString(this.f390390d);
            parcel.writeLong(this.f390392f);
            parcel.writeBundle(this.f390391e);
            parcel.writeStrongInterface(this.f390395m);
        } catch (RuntimeException e16) {
            QLog.w("SendMsg", 1, "writeToParcel RuntimeException", e16);
            throw e16;
        }
    }

    public SendMsg(Parcel parcel) {
        e(parcel);
    }
}
