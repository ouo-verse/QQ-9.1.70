package com.sina.weibo.sdk.web;

import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.auth.AuthInfo;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes3.dex */
public class WebData implements Parcelable, Serializable {
    public static final Parcelable.Creator<WebData> CREATOR = new Parcelable.Creator<WebData>() { // from class: com.sina.weibo.sdk.web.WebData.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WebData createFromParcel(Parcel parcel) {
            return new WebData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WebData[] newArray(int i3) {
            return new WebData[i3];
        }
    };
    private static final long serialVersionUID = -4038177938155795889L;
    protected AuthInfo aB;
    protected String aC;
    protected int type;
    protected String url;

    public WebData(AuthInfo authInfo, int i3, String str, String str2) {
        this.aB = authInfo;
        this.type = i3;
        this.url = str;
        this.aC = str2;
    }

    public final AuthInfo a() {
        return this.aB;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String u() {
        return this.aC;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.aB, i3);
        parcel.writeInt(this.type);
        parcel.writeString(this.url);
        parcel.writeString(this.aC);
    }

    protected WebData(Parcel parcel) {
        this.aB = (AuthInfo) parcel.readParcelable(AuthInfo.class.getClassLoader());
        this.type = parcel.readInt();
        this.url = parcel.readString();
        this.aC = parcel.readString();
    }
}
