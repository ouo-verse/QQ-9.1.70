package com.tencent.mobileqq.vas.comm.api.notify;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ServiceAssMsgTemplateItem implements Parcelable {
    public static final Parcelable.Creator<ServiceAssMsgTemplateItem> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public String f308939d;

    /* renamed from: e, reason: collision with root package name */
    public int f308940e;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements Parcelable.Creator<ServiceAssMsgTemplateItem> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ServiceAssMsgTemplateItem createFromParcel(Parcel parcel) {
            ServiceAssMsgTemplateItem serviceAssMsgTemplateItem = new ServiceAssMsgTemplateItem();
            serviceAssMsgTemplateItem.a(parcel);
            return serviceAssMsgTemplateItem;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ServiceAssMsgTemplateItem[] newArray(int i3) {
            return new ServiceAssMsgTemplateItem[i3];
        }
    }

    public ServiceAssMsgTemplateItem() {
        this.f308939d = "";
    }

    public void a(Parcel parcel) {
        if (parcel != null) {
            this.f308939d = parcel.readString();
            this.f308940e = parcel.readInt();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        if (parcel != null) {
            parcel.writeString(this.f308939d);
            parcel.writeInt(this.f308940e);
        }
    }

    public ServiceAssMsgTemplateItem(String str, int i3) {
        this.f308939d = str;
        this.f308940e = i3;
    }
}
