package com.tencent.mobileqq.teamwork.menu;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes18.dex */
public class MenuConfig$ToolBoxPageConfig implements Parcelable {
    public static final Parcelable.Creator<MenuConfig$ToolBoxPageConfig> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public String f292177d;

    /* renamed from: e, reason: collision with root package name */
    public List<Integer> f292178e;

    /* loaded from: classes18.dex */
    class a implements Parcelable.Creator<MenuConfig$ToolBoxPageConfig> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MenuConfig$ToolBoxPageConfig createFromParcel(Parcel parcel) {
            return new MenuConfig$ToolBoxPageConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MenuConfig$ToolBoxPageConfig[] newArray(int i3) {
            return new MenuConfig$ToolBoxPageConfig[i3];
        }
    }

    public MenuConfig$ToolBoxPageConfig(String str, List<Integer> list) {
        this.f292177d = str;
        this.f292178e = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f292177d);
        parcel.writeList(this.f292178e);
    }

    protected MenuConfig$ToolBoxPageConfig(Parcel parcel) {
        this.f292177d = parcel.readString();
        this.f292178e = parcel.readArrayList(MenuConfig$ToolBoxPageConfig.class.getClassLoader());
    }
}
