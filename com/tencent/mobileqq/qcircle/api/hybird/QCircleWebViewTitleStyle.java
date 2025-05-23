package com.tencent.mobileqq.qcircle.api.hybird;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.webview.WebViewTitleStyle;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleWebViewTitleStyle extends WebViewTitleStyle {
    public static final Parcelable.Creator<QCircleWebViewTitleStyle> CREATOR = new a();

    /* renamed from: i, reason: collision with root package name */
    public int f261695i;

    /* renamed from: m, reason: collision with root package name */
    public int f261696m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements Parcelable.Creator<QCircleWebViewTitleStyle> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QCircleWebViewTitleStyle createFromParcel(Parcel parcel) {
            return new QCircleWebViewTitleStyle(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QCircleWebViewTitleStyle[] newArray(int i3) {
            return new QCircleWebViewTitleStyle[i3];
        }
    }

    public QCircleWebViewTitleStyle() {
        this.f261696m = 0;
    }

    @Override // com.tencent.mobileqq.webview.WebViewTitleStyle, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mobileqq.webview.WebViewTitleStyle, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeInt(this.f261695i);
        parcel.writeInt(this.f261696m);
    }

    protected QCircleWebViewTitleStyle(Parcel parcel) {
        super(parcel);
        this.f261696m = 0;
        this.f261695i = parcel.readInt();
        this.f261696m = parcel.readInt();
    }
}
