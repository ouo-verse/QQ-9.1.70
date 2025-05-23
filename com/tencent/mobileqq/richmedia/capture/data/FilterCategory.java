package com.tencent.mobileqq.richmedia.capture.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.aelight.camera.struct.editor.FilterCategoryItem;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FilterCategory implements Parcelable {
    public static final Parcelable.Creator<FilterCategory> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public int f281354d;

    /* renamed from: e, reason: collision with root package name */
    public String f281355e;

    /* renamed from: f, reason: collision with root package name */
    public List<FilterCategoryItem> f281356f;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Parcelable.Creator<FilterCategory> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FilterCategory createFromParcel(Parcel parcel) {
            return new FilterCategory(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FilterCategory[] newArray(int i3) {
            return new FilterCategory[i3];
        }
    }

    protected FilterCategory(Parcel parcel) {
        this.f281354d = parcel.readInt();
        this.f281355e = parcel.readString();
        this.f281356f = parcel.createTypedArrayList(FilterCategoryItem.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f281354d);
        parcel.writeString(this.f281355e);
        parcel.writeTypedList(this.f281356f);
    }
}
