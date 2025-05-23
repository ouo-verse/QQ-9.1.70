package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class IPSiteModel$Comic implements Parcelable {
    public static final Parcelable.Creator<IPSiteModel$Comic> CREATOR = new a();
    public List<IPSiteModel$ComicRich> comicRiches;
    public int comicType;
    public String cover;
    public String desc;

    /* renamed from: id, reason: collision with root package name */
    public String f203081id;
    public String jumpUrl;
    public String name;
    public String recommDesc;
    public String typeName;

    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IPSiteModel$Comic createFromParcel(Parcel parcel) {
            IPSiteModel$Comic iPSiteModel$Comic = new IPSiteModel$Comic();
            iPSiteModel$Comic.comicType = parcel.readInt();
            iPSiteModel$Comic.cover = parcel.readString();
            iPSiteModel$Comic.desc = parcel.readString();
            iPSiteModel$Comic.f203081id = parcel.readString();
            iPSiteModel$Comic.jumpUrl = parcel.readString();
            iPSiteModel$Comic.name = parcel.readString();
            iPSiteModel$Comic.recommDesc = parcel.readString();
            iPSiteModel$Comic.typeName = parcel.readString();
            if (iPSiteModel$Comic.comicRiches == null) {
                iPSiteModel$Comic.comicRiches = new ArrayList();
            }
            iPSiteModel$Comic.comicRiches.clear();
            parcel.readList(iPSiteModel$Comic.comicRiches, IPSiteModel$ComicRich.class.getClassLoader());
            return iPSiteModel$Comic;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public IPSiteModel$Comic[] newArray(int i3) {
            return new IPSiteModel$Comic[i3];
        }
    }

    public IPSiteModel$Comic() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "Comic{comicType=" + this.comicType + ", cover='" + this.cover + "', desc='" + this.desc + "', id='" + this.f203081id + "', jumpUrl='" + this.jumpUrl + "', name='" + this.name + "', recommDesc='" + this.recommDesc + "', typeName='" + this.typeName + "', comicRiches=" + this.comicRiches + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.comicType);
        parcel.writeString(this.cover);
        parcel.writeString(this.desc);
        parcel.writeString(this.f203081id);
        parcel.writeString(this.jumpUrl);
        parcel.writeString(this.name);
        parcel.writeString(this.recommDesc);
        parcel.writeString(this.typeName);
        parcel.writeList(this.comicRiches);
    }

    public IPSiteModel$Comic(int i3, String str, String str2, String str3, String str4, String str5, String str6, String str7, List<IPSiteModel$ComicRich> list) {
        this.comicType = i3;
        this.cover = str;
        this.desc = str2;
        this.f203081id = str3;
        this.jumpUrl = str4;
        this.name = str5;
        this.recommDesc = str6;
        this.typeName = str7;
        this.comicRiches = list;
    }
}
