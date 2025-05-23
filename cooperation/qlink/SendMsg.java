package cooperation.qlink;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes28.dex */
public class SendMsg implements Parcelable {
    public static final Parcelable.Creator<SendMsg> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public String f390486d;

    /* renamed from: e, reason: collision with root package name */
    public final Bundle f390487e = new Bundle();

    /* renamed from: f, reason: collision with root package name */
    long f390488f = -1;

    /* renamed from: h, reason: collision with root package name */
    long f390489h = -1;

    /* renamed from: i, reason: collision with root package name */
    int f390490i;

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
        this.f390486d = str;
    }

    private void b(Parcel parcel) {
        try {
            this.f390490i = parcel.readInt();
            this.f390486d = parcel.readString();
            this.f390488f = parcel.readLong();
            this.f390487e.clear();
            this.f390487e.putAll(parcel.readBundle(Thread.currentThread().getContextClassLoader()));
        } catch (RuntimeException e16) {
            QLog.d("SendMsg", 2, "readFromParcel RuntimeException", e16);
            throw e16;
        }
    }

    public String a() {
        return this.f390486d;
    }

    public void c(int i3) {
        this.f390490i = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(long j3) {
        this.f390488f = j3;
    }

    public String toString() {
        return "SendMsg appSeq:" + this.f390490i + " serviceCmd:" + this.f390486d + " timeout:" + this.f390488f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        try {
            parcel.writeInt(this.f390490i);
            parcel.writeString(this.f390486d);
            parcel.writeLong(this.f390488f);
            parcel.writeBundle(this.f390487e);
        } catch (RuntimeException e16) {
            QLog.d("SendMsg", 2, "writeToParcel RuntimeException", e16);
            throw e16;
        }
    }

    public SendMsg(Parcel parcel) {
        b(parcel);
    }
}
