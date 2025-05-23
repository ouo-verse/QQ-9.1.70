package com.tencent.mobileqq.guild.usecases;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.ez;
import vh2.aa;

/* compiled from: P */
/* loaded from: classes14.dex */
public class FetchGuildInfoUseCase implements aa {

    /* renamed from: a, reason: collision with root package name */
    private final String f235309a;

    /* renamed from: b, reason: collision with root package name */
    private final a f235310b;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        void a(@NonNull ri1.a aVar, @NonNull GuildInfo guildInfo);
    }

    public FetchGuildInfoUseCase(String str, a aVar) {
        this.f235309a = str;
        this.f235310b = aVar;
    }

    public static void c(String str, @NonNull a aVar) {
        new FetchGuildInfoUseCase(str, aVar).b();
    }

    @Override // vh2.aa
    public void a(int i3, String str, ez ezVar, IGProSecurityResult iGProSecurityResult, long j3) {
        ri1.a c16 = ri1.a.c(i3, str, iGProSecurityResult);
        if (i3 == 0 && ezVar != null) {
            this.f235310b.a(c16, new GuildInfo(ezVar.getGuildID(), ezVar.getGuildName(), ezVar.getJoinSig()));
            return;
        }
        this.f235310b.a(c16, new GuildInfo());
    }

    public void b() {
        ((IGPSService) ch.S0(IGPSService.class, "")).fetchGuildInfoByInviteCode(this.f235309a, this);
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class GuildInfo implements Parcelable {
        public static final Parcelable.Creator<GuildInfo> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        public final String f235311d;

        /* renamed from: e, reason: collision with root package name */
        public final String f235312e;

        /* renamed from: f, reason: collision with root package name */
        public final String f235313f;

        /* compiled from: P */
        /* loaded from: classes14.dex */
        class a implements Parcelable.Creator<GuildInfo> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public GuildInfo createFromParcel(Parcel parcel) {
                return new GuildInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public GuildInfo[] newArray(int i3) {
                return new GuildInfo[i3];
            }
        }

        public GuildInfo(String str, String str2, String str3) {
            this.f235311d = str;
            this.f235312e = str2;
            this.f235313f = str3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NonNull
        public String toString() {
            return "GuildInfo{guildId='" + this.f235311d + "', guildName='" + this.f235312e + "', joinSignature='" + this.f235313f + "'}";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f235311d);
            parcel.writeString(this.f235312e);
            parcel.writeString(this.f235313f);
        }

        public GuildInfo() {
            this("", "", "");
        }

        protected GuildInfo(Parcel parcel) {
            this.f235311d = parcel.readString();
            this.f235312e = parcel.readString();
            this.f235313f = parcel.readString();
        }
    }
}
