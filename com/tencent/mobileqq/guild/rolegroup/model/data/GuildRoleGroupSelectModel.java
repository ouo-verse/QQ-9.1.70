package com.tencent.mobileqq.guild.rolegroup.model.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.guild.rolegroup.fragments.GuildRoleGroupSelectDialog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildRoleGroupSelectModel implements Parcelable {
    public static final Parcelable.Creator<GuildRoleGroupSelectModel> CREATOR = new a();
    private List<String> C;
    private Bundle D;

    /* renamed from: d, reason: collision with root package name */
    private int f232636d;

    /* renamed from: e, reason: collision with root package name */
    private String f232637e;

    /* renamed from: f, reason: collision with root package name */
    private String f232638f;

    /* renamed from: h, reason: collision with root package name */
    private int f232639h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f232640i;

    /* renamed from: m, reason: collision with root package name */
    private GuildRoleGroupSelectDialog.a f232641m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements Parcelable.Creator<GuildRoleGroupSelectModel> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuildRoleGroupSelectModel createFromParcel(Parcel parcel) {
            return new GuildRoleGroupSelectModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildRoleGroupSelectModel[] newArray(int i3) {
            return new GuildRoleGroupSelectModel[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private int f232642a;

        /* renamed from: e, reason: collision with root package name */
        private boolean f232646e;

        /* renamed from: f, reason: collision with root package name */
        private GuildRoleGroupSelectDialog.a f232647f;

        /* renamed from: h, reason: collision with root package name */
        private Bundle f232649h;

        /* renamed from: b, reason: collision with root package name */
        private String f232643b = "";

        /* renamed from: c, reason: collision with root package name */
        private String f232644c = "";

        /* renamed from: d, reason: collision with root package name */
        private int f232645d = -1;

        /* renamed from: g, reason: collision with root package name */
        private List<String> f232648g = new ArrayList();

        public GuildRoleGroupSelectModel i() {
            return new GuildRoleGroupSelectModel(this);
        }

        public b j(GuildRoleGroupSelectDialog.a aVar) {
            this.f232647f = aVar;
            return this;
        }

        public b k(String str) {
            this.f232644c = str;
            return this;
        }

        public b l(int i3) {
            this.f232645d = i3;
            return this;
        }

        public b m(int i3) {
            this.f232642a = i3;
            return this;
        }

        public b n(String str) {
            this.f232643b = str;
            return this;
        }

        public b o(List<String> list) {
            this.f232648g.addAll(list);
            return this;
        }

        public b p(boolean z16) {
            this.f232646e = z16;
            return this;
        }
    }

    GuildRoleGroupSelectModel(b bVar) {
        this.f232637e = "";
        this.f232638f = "";
        this.f232639h = -1;
        this.C = new ArrayList();
        this.f232636d = bVar.f232642a;
        this.f232637e = bVar.f232643b;
        this.f232638f = bVar.f232644c;
        this.f232639h = bVar.f232645d;
        this.f232640i = bVar.f232646e;
        this.f232641m = bVar.f232647f;
        this.C = bVar.f232648g;
        this.D = bVar.f232649h;
    }

    public GuildRoleGroupSelectDialog.a a() {
        return this.f232641m;
    }

    public String b() {
        return this.f232638f;
    }

    public int c() {
        return this.f232639h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f232636d;
    }

    public String f() {
        return this.f232637e;
    }

    public List<String> g() {
        return this.C;
    }

    public boolean j() {
        return this.f232640i;
    }

    public String toString() {
        return "GuildRoleGroupSelectModel{mFromType=" + this.f232636d + ", mGuildId='" + this.f232637e + ", mChannelId='" + this.f232638f + ", mChannelType='" + this.f232639h + ", mSubmitModify=" + this.f232640i + ", mSelectedIdList=" + this.C + ", mExtra=" + this.D + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f232636d);
        parcel.writeString(this.f232637e);
        parcel.writeString(this.f232638f);
        parcel.writeInt(this.f232639h);
        parcel.writeByte(this.f232640i ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.C);
        parcel.writeBundle(this.D);
    }

    protected GuildRoleGroupSelectModel(Parcel parcel) {
        this.f232637e = "";
        this.f232638f = "";
        this.f232639h = -1;
        this.C = new ArrayList();
        this.f232636d = parcel.readInt();
        this.f232637e = parcel.readString();
        this.f232638f = parcel.readString();
        this.f232639h = parcel.readInt();
        this.f232640i = parcel.readByte() != 0;
        this.C = parcel.createStringArrayList();
        this.D = parcel.readBundle();
    }
}
