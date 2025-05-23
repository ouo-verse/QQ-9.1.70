package com.tencent.aelight.camera.ae.camera.ui.simple;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes32.dex */
public class AioCaptureReportParams implements Parcelable {
    public static final Parcelable.Creator<AioCaptureReportParams> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public int f63271d;

    /* renamed from: e, reason: collision with root package name */
    public int f63272e;

    /* renamed from: f, reason: collision with root package name */
    public int f63273f;

    /* loaded from: classes32.dex */
    class a implements Parcelable.Creator<AioCaptureReportParams> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AioCaptureReportParams createFromParcel(Parcel parcel) {
            return new AioCaptureReportParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AioCaptureReportParams[] newArray(int i3) {
            return new AioCaptureReportParams[i3];
        }
    }

    public AioCaptureReportParams() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f63271d);
        parcel.writeInt(this.f63272e);
        parcel.writeInt(this.f63273f);
    }

    protected AioCaptureReportParams(Parcel parcel) {
        this.f63271d = parcel.readInt();
        this.f63272e = parcel.readInt();
        this.f63273f = parcel.readInt();
    }
}
