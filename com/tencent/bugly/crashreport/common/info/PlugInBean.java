package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes5.dex */
public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new Parcelable.Creator<PlugInBean>() { // from class: com.tencent.bugly.crashreport.common.info.PlugInBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PlugInBean createFromParcel(Parcel parcel) {
            return new PlugInBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PlugInBean[] newArray(int i3) {
            return new PlugInBean[i3];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final String f97833a;

    /* renamed from: b, reason: collision with root package name */
    public final String f97834b;

    /* renamed from: c, reason: collision with root package name */
    public final String f97835c;

    public PlugInBean(String str, String str2, String str3) {
        this.f97833a = str;
        this.f97834b = str2;
        this.f97835c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "plid:" + this.f97833a + " plV:" + this.f97834b + " plUUID:" + this.f97835c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f97833a);
        parcel.writeString(this.f97834b);
        parcel.writeString(this.f97835c);
    }

    public PlugInBean(Parcel parcel) {
        this.f97833a = parcel.readString();
        this.f97834b = parcel.readString();
        this.f97835c = parcel.readString();
    }
}
