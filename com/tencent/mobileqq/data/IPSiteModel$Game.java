package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class IPSiteModel$Game implements Parcelable {
    public static final Parcelable.Creator<IPSiteModel$Game> CREATOR = new a();
    public String cover;
    public String desc;
    public List<IPSiteModel$GameRich> gameRiches;

    /* renamed from: id, reason: collision with root package name */
    public String f203082id;
    public String jumpUrl;
    public String name;
    public String recommDesc;

    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IPSiteModel$Game createFromParcel(Parcel parcel) {
            IPSiteModel$Game iPSiteModel$Game = new IPSiteModel$Game();
            iPSiteModel$Game.cover = parcel.readString();
            iPSiteModel$Game.desc = parcel.readString();
            iPSiteModel$Game.f203082id = parcel.readString();
            iPSiteModel$Game.jumpUrl = parcel.readString();
            iPSiteModel$Game.name = parcel.readString();
            iPSiteModel$Game.recommDesc = parcel.readString();
            if (iPSiteModel$Game.gameRiches == null) {
                iPSiteModel$Game.gameRiches = new ArrayList();
            }
            iPSiteModel$Game.gameRiches.clear();
            parcel.readList(iPSiteModel$Game.gameRiches, IPSiteModel$GameRich.class.getClassLoader());
            return iPSiteModel$Game;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public IPSiteModel$Game[] newArray(int i3) {
            return new IPSiteModel$Game[i3];
        }
    }

    public IPSiteModel$Game() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "Game{cover='" + this.cover + "', desc='" + this.desc + "', id='" + this.f203082id + "', jumpUrl='" + this.jumpUrl + "', name='" + this.name + "', recommDesc='" + this.recommDesc + "', gameRiches=" + this.gameRiches + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.cover);
        parcel.writeString(this.desc);
        parcel.writeString(this.f203082id);
        parcel.writeString(this.jumpUrl);
        parcel.writeString(this.name);
        parcel.writeString(this.recommDesc);
        parcel.writeList(this.gameRiches);
    }

    public IPSiteModel$Game(String str, String str2, String str3, String str4, String str5, String str6, List<IPSiteModel$GameRich> list) {
        this.cover = str;
        this.desc = str2;
        this.f203082id = str3;
        this.jumpUrl = str4;
        this.name = str5;
        this.recommDesc = str6;
        this.gameRiches = list;
    }
}
