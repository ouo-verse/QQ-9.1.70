package com.tencent.mobileqq.activity.aio.zhitu;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.util.JSONUtils;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ZhituImgResponse implements Parcelable {
    public static final Parcelable.Creator<ZhituImgResponse> CREATOR = new a();
    public String coord;
    public String md5;
    public String pass;
    public String style;

    @JSONUtils.FieldName("text-color")
    public String textColor;
    public String url;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator<ZhituImgResponse> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ZhituImgResponse createFromParcel(Parcel parcel) {
            return new ZhituImgResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ZhituImgResponse[] newArray(int i3) {
            return new ZhituImgResponse[i3];
        }
    }

    public ZhituImgResponse() {
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
        String str = this.url;
        String str2 = ((ZhituImgResponse) obj).url;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.url;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ZhituImgResponse{url='" + this.url + "', textColor='" + this.textColor + "', md5='" + this.md5 + "', style='" + this.style + "', coord='" + this.coord + "', pass='" + this.pass + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.url);
        parcel.writeString(this.textColor);
        parcel.writeString(this.md5);
        parcel.writeString(this.style);
        parcel.writeString(this.coord);
        parcel.writeString(this.pass);
    }

    protected ZhituImgResponse(Parcel parcel) {
        this.url = parcel.readString();
        this.textColor = parcel.readString();
        this.md5 = parcel.readString();
        this.style = parcel.readString();
        this.coord = parcel.readString();
        this.pass = parcel.readString();
    }
}
