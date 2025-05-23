package com.qzone.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.component.annotation.NeedParcel;

/* compiled from: P */
/* loaded from: classes37.dex */
public class RapidCommentExpressionInfo implements Parcelable {
    public static final Parcelable.Creator<RapidCommentExpressionInfo> CREATOR = new a();

    @NeedParcel
    public long C;

    @NeedParcel
    public boolean D;

    @NeedParcel
    public String E;

    /* renamed from: d, reason: collision with root package name */
    @NeedParcel
    public String f60639d;

    /* renamed from: e, reason: collision with root package name */
    @NeedParcel
    public long f60640e;

    /* renamed from: f, reason: collision with root package name */
    @NeedParcel
    public String f60641f;

    /* renamed from: h, reason: collision with root package name */
    @NeedParcel
    public String f60642h;

    /* renamed from: i, reason: collision with root package name */
    @NeedParcel
    public String f60643i;

    /* renamed from: m, reason: collision with root package name */
    @NeedParcel
    public String f60644m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements Parcelable.Creator<RapidCommentExpressionInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RapidCommentExpressionInfo createFromParcel(Parcel parcel) {
            RapidCommentExpressionInfo rapidCommentExpressionInfo = new RapidCommentExpressionInfo();
            rapidCommentExpressionInfo.f60639d = parcel.readString();
            rapidCommentExpressionInfo.f60640e = parcel.readLong();
            rapidCommentExpressionInfo.f60641f = parcel.readString();
            rapidCommentExpressionInfo.f60642h = parcel.readString();
            rapidCommentExpressionInfo.f60643i = parcel.readString();
            rapidCommentExpressionInfo.f60644m = parcel.readString();
            rapidCommentExpressionInfo.C = parcel.readLong();
            rapidCommentExpressionInfo.D = parcel.readInt() > 0;
            rapidCommentExpressionInfo.E = parcel.readString();
            return rapidCommentExpressionInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RapidCommentExpressionInfo[] newArray(int i3) {
            return new RapidCommentExpressionInfo[i3];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f60639d);
        parcel.writeLong(this.f60640e);
        parcel.writeString(this.f60641f);
        parcel.writeString(this.f60642h);
        parcel.writeString(this.f60643i);
        parcel.writeString(this.f60644m);
        parcel.writeLong(this.C);
        parcel.writeInt(this.D ? 1 : 0);
        parcel.writeString(this.E);
    }
}
