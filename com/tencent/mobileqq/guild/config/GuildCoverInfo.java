package com.tencent.mobileqq.guild.config;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.guild.config.GuildCoverConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildCoverInfo implements Parcelable {
    private String C;

    /* renamed from: d, reason: collision with root package name */
    private String f216052d;

    /* renamed from: e, reason: collision with root package name */
    private String f216053e;

    /* renamed from: f, reason: collision with root package name */
    private String f216054f;

    /* renamed from: h, reason: collision with root package name */
    private String f216055h;

    /* renamed from: i, reason: collision with root package name */
    private String f216056i;

    /* renamed from: m, reason: collision with root package name */
    private String f216057m;
    public static final int D = Color.argb(255, 34, 34, 34);
    public static final int E = Color.argb(32, 0, 0, 0);
    public static CopyOnWriteArrayList<GuildCoverInfo> F = new CopyOnWriteArrayList<>();
    public static final Parcelable.Creator<GuildCoverInfo> CREATOR = new a();

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a implements Parcelable.Creator<GuildCoverInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuildCoverInfo createFromParcel(Parcel parcel) {
            return new GuildCoverInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildCoverInfo[] newArray(int i3) {
            return new GuildCoverInfo[i3];
        }
    }

    public GuildCoverInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f216052d = str;
        this.f216053e = str2;
        this.f216054f = str3;
        this.f216055h = str4;
        this.f216056i = str5;
        this.f216057m = str6;
        this.C = str7;
    }

    public static CopyOnWriteArrayList<GuildCoverInfo> b() {
        CopyOnWriteArrayList<GuildCoverInfo> copyOnWriteArrayList = F;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            GuildCoverConfigParser.b bVar = (GuildCoverConfigParser.b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100556");
            CopyOnWriteArrayList<GuildCoverInfo> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
            F = copyOnWriteArrayList2;
            if (bVar != null) {
                copyOnWriteArrayList2.addAll(bVar.e());
            }
        }
        return F;
    }

    public static GuildCoverInfo e(String str) {
        CopyOnWriteArrayList<GuildCoverInfo> b16 = b();
        if (!b16.isEmpty()) {
            Iterator<GuildCoverInfo> it = b16.iterator();
            while (it.hasNext()) {
                GuildCoverInfo next = it.next();
                if (next.f216052d.equals(str)) {
                    return next;
                }
            }
        }
        return new GuildCoverInfo(str, "", "", "", "", "", "");
    }

    public String a() {
        return this.f216056i;
    }

    public String c() {
        return this.f216055h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "GuildCoverInfo{id='" + this.f216052d + "', name='" + this.f216053e + "', nameColor='" + this.f216054f + "', url='" + this.f216055h + "', bgUrl='" + this.f216056i + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f216052d);
        parcel.writeString(this.f216053e);
        parcel.writeString(this.f216054f);
        parcel.writeString(this.f216055h);
        parcel.writeString(this.f216056i);
        parcel.writeString(this.f216057m);
        parcel.writeString(this.C);
    }

    protected GuildCoverInfo(Parcel parcel) {
        this.f216052d = "";
        this.f216053e = "";
        this.f216054f = "";
        this.f216055h = "";
        this.f216056i = "";
        this.f216057m = "";
        this.C = "";
        this.f216052d = parcel.readString();
        this.f216053e = parcel.readString();
        this.f216054f = parcel.readString();
        this.f216055h = parcel.readString();
        this.f216056i = parcel.readString();
        this.f216057m = parcel.readString();
        this.C = parcel.readString();
    }
}
