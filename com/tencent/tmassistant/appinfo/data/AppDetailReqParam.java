package com.tencent.tmassistant.appinfo.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes26.dex */
public class AppDetailReqParam implements Parcelable {
    public static final Parcelable.Creator<AppDetailReqParam> CREATOR = new a();
    public List<AppParam> apps;
    public String biz;

    /* loaded from: classes26.dex */
    class a implements Parcelable.Creator<AppDetailReqParam> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppDetailReqParam createFromParcel(Parcel parcel) {
            return new AppDetailReqParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppDetailReqParam[] newArray(int i3) {
            return new AppDetailReqParam[i3];
        }
    }

    public AppDetailReqParam() {
        this.apps = new ArrayList();
        this.biz = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeTypedList(this.apps);
        parcel.writeString(this.biz);
    }

    protected AppDetailReqParam(Parcel parcel) {
        this.apps = new ArrayList();
        this.biz = "";
        this.apps = parcel.createTypedArrayList(AppParam.CREATOR);
        this.biz = parcel.readString();
    }
}
