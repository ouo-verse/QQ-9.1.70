package com.tencent.mobileqq.guild.quicksearch.resultview.history;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public final class GuildQuickSearchData implements Parcelable {
    public static final Parcelable.Creator<GuildQuickSearchData> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private final List<String> f231830d;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements Parcelable.Creator<GuildQuickSearchData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuildQuickSearchData createFromParcel(Parcel parcel) {
            return new GuildQuickSearchData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildQuickSearchData[] newArray(int i3) {
            return new GuildQuickSearchData[i3];
        }
    }

    public GuildQuickSearchData() {
        this.f231830d = new ArrayList();
    }

    public List<String> a() {
        return this.f231830d;
    }

    public void b(List<String> list) {
        this.f231830d.clear();
        this.f231830d.addAll(list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeStringList(this.f231830d);
    }

    public GuildQuickSearchData(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.f231830d = arrayList;
        parcel.readStringList(arrayList);
    }
}
