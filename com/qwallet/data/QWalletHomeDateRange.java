package com.qwallet.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$DateRange;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QWalletHomeDateRange implements Parcelable {
    public static final Parcelable.Creator<QWalletHomeDateRange> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public long f41526d;

    /* renamed from: e, reason: collision with root package name */
    public long f41527e;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<QWalletHomeDateRange> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QWalletHomeDateRange createFromParcel(Parcel parcel) {
            return new QWalletHomeDateRange(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QWalletHomeDateRange[] newArray(int i3) {
            return new QWalletHomeDateRange[i3];
        }
    }

    public QWalletHomeDateRange() {
    }

    public static QWalletHomeDateRange a(QWalletHomePage$DateRange qWalletHomePage$DateRange) {
        QWalletHomeDateRange qWalletHomeDateRange = new QWalletHomeDateRange();
        qWalletHomeDateRange.f41526d = qWalletHomePage$DateRange.begin.get();
        qWalletHomeDateRange.f41527e = qWalletHomePage$DateRange.end.get();
        return qWalletHomeDateRange;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        QWalletHomeDateRange qWalletHomeDateRange = (QWalletHomeDateRange) obj;
        if (this.f41526d == qWalletHomeDateRange.f41526d && this.f41527e == qWalletHomeDateRange.f41527e) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.f41526d), Long.valueOf(this.f41527e));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f41526d);
        parcel.writeLong(this.f41527e);
    }

    protected QWalletHomeDateRange(Parcel parcel) {
        this.f41526d = parcel.readLong();
        this.f41527e = parcel.readLong();
    }
}
