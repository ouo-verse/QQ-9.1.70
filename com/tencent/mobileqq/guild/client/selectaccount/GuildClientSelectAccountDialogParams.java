package com.tencent.mobileqq.guild.client.selectaccount;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.qqguildsdk.data.ej;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes12.dex */
public class GuildClientSelectAccountDialogParams implements Parcelable {
    public static final Parcelable.Creator<GuildClientSelectAccountDialogParams> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private final GuildClientParams f215412d;

    /* renamed from: e, reason: collision with root package name */
    private String f215413e;

    /* renamed from: f, reason: collision with root package name */
    private List<AccountInfo> f215414f;

    /* loaded from: classes12.dex */
    class a implements Parcelable.Creator<GuildClientSelectAccountDialogParams> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuildClientSelectAccountDialogParams createFromParcel(Parcel parcel) {
            return new GuildClientSelectAccountDialogParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildClientSelectAccountDialogParams[] newArray(int i3) {
            return new GuildClientSelectAccountDialogParams[i3];
        }
    }

    public GuildClientSelectAccountDialogParams(GuildClientParams guildClientParams) {
        this.f215413e = "";
        this.f215414f = new ArrayList();
        this.f215412d = guildClientParams;
    }

    public GuildClientSelectAccountDialogParams b(List<ej> list) {
        Iterator<ej> it = list.iterator();
        while (it.hasNext()) {
            this.f215414f.add(new AccountInfo(it.next()));
        }
        return this;
    }

    public List<AccountInfo> c() {
        return this.f215414f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public GuildClientParams e() {
        return this.f215412d;
    }

    public GuildClientSelectAccountDialogParams f(String str) {
        this.f215413e = str;
        return this;
    }

    public String getTitle() {
        return this.f215413e;
    }

    public String toString() {
        return "GuildClientSelectRoleDialogParams{, baseParams=" + this.f215412d.toString() + ", roleList=" + this.f215414f + ", title='" + this.f215413e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f215412d, i3);
        parcel.writeString(this.f215413e);
        parcel.writeList(this.f215414f);
    }

    /* loaded from: classes12.dex */
    public static class AccountInfo implements Parcelable {
        public static final Parcelable.Creator<AccountInfo> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        private final String f215415d;

        /* renamed from: e, reason: collision with root package name */
        private final String f215416e;

        /* renamed from: f, reason: collision with root package name */
        private final String f215417f;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f215418h;

        /* loaded from: classes12.dex */
        class a implements Parcelable.Creator<AccountInfo> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public AccountInfo createFromParcel(Parcel parcel) {
                return new AccountInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public AccountInfo[] newArray(int i3) {
                return new AccountInfo[i3];
            }
        }

        public AccountInfo(ej ejVar) {
            this.f215415d = ejVar.getRoleId();
            this.f215416e = ejVar.getRoleName();
            this.f215417f = ejVar.getRoleDescribe();
            this.f215418h = ejVar.getIsBind();
        }

        public String a() {
            return this.f215417f;
        }

        public String b() {
            return this.f215415d;
        }

        public String c() {
            return this.f215416e;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "RoleInfo{accountId='" + this.f215415d + "', accountName='" + this.f215416e + "', accountDescribe='" + this.f215417f + "', isBind=" + this.f215418h + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f215415d);
            parcel.writeString(this.f215416e);
            parcel.writeString(this.f215417f);
            parcel.writeByte(this.f215418h ? (byte) 1 : (byte) 0);
        }

        protected AccountInfo(Parcel parcel) {
            this.f215415d = parcel.readString();
            this.f215416e = parcel.readString();
            this.f215417f = parcel.readString();
            this.f215418h = parcel.readByte() != 0;
        }
    }

    protected GuildClientSelectAccountDialogParams(Parcel parcel) {
        this.f215413e = "";
        this.f215414f = new ArrayList();
        this.f215412d = (GuildClientParams) parcel.readParcelable(GuildClientParams.class.getClassLoader());
        this.f215413e = parcel.readString();
        this.f215414f = parcel.readArrayList(AccountInfo.class.getClassLoader());
    }

    public GuildClientSelectAccountDialogParams a() {
        return this;
    }
}
