package com.tencent.mobileqq.qqguildsdk.manager;

import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.cu;
import com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleDate;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleDayItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleGuildSurface;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleSendArkGuildInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleUser;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateScheduleCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateScheduleLimitQueryCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProEditScheduleCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetScheduleDetailCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetScheduleListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetScheduleListNewCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetScheduleUsersCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetSchedulesStatusCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProModifyScheduleInviteStatusCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSendScheduleArkMessageCallback;
import java.util.ArrayList;
import vh2.ce;
import vh2.cf;
import vh2.cg;
import vh2.ch;
import vh2.ci;
import vh2.cj;
import vh2.ck;
import vh2.cl;
import vh2.cm;
import vh2.cn;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final GPSManagerEngine f268422a;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqguildsdk.manager.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    class C8344a implements IGProSendScheduleArkMessageCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ cn f268423a;

        C8344a(cn cnVar) {
            this.f268423a = cnVar;
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSendScheduleArkMessageCallback
        public void onSendArkMessage(int i3, String str) {
            this.f268423a.onSendArkMessage(i3, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class b implements IGProCreateScheduleLimitQueryCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ cf f268425a;

        b(cf cfVar) {
            this.f268425a = cfVar;
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateScheduleLimitQueryCallback
        public void onCreateScheduleLimitQuery(int i3, String str, int i16) {
            this.f268425a.onCreateScheduleLimitQuery(i3, str, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class c implements IGProCreateScheduleCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f268427a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f268428b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ce f268429c;

        c(String str, String str2, ce ceVar) {
            this.f268427a = str;
            this.f268428b = str2;
            this.f268429c = ceVar;
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateScheduleCallback
        public void onCreateSchedule(int i3, String str, GProScheduleInfo gProScheduleInfo) {
            GuildScheduleInfo m06 = com.tencent.mobileqq.qqguildsdk.util.g.m0(gProScheduleInfo);
            if (i3 == 0) {
                a.this.f268422a.ej(104, "createSchedule", this.f268427a, this.f268428b, m06);
            }
            this.f268429c.a(i3, str, m06);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class d implements IGProEditScheduleCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f268431a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f268432b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f268433c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ cg f268434d;

        d(String str, String str2, int i3, cg cgVar) {
            this.f268431a = str;
            this.f268432b = str2;
            this.f268433c = i3;
            this.f268434d = cgVar;
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProEditScheduleCallback
        public void onEditSchedule(int i3, String str, GProScheduleInfo gProScheduleInfo) {
            GuildScheduleInfo m06 = com.tencent.mobileqq.qqguildsdk.util.g.m0(gProScheduleInfo);
            if (i3 == 0) {
                a.this.f268422a.ej(105, "editSchedule", this.f268431a, this.f268432b, m06, Integer.valueOf(this.f268433c));
            }
            this.f268434d.a(i3, str, m06);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class e implements IGProGetScheduleDetailCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ch f268436a;

        e(ch chVar) {
            this.f268436a = chVar;
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetScheduleDetailCallback
        public void onGetScheduleDetail(int i3, String str, GProScheduleInfo gProScheduleInfo, int i16, boolean z16, GProScheduleGuildSurface gProScheduleGuildSurface) {
            this.f268436a.a(i3, str, com.tencent.mobileqq.qqguildsdk.util.g.n0(gProScheduleInfo, gProScheduleGuildSurface), i16, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class f implements IGProGetScheduleListCallback {
        f(ci ciVar) {
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetScheduleListCallback
        public void onGetScheduleList(int i3, String str, ArrayList<GProScheduleInfo> arrayList) {
            com.tencent.mobileqq.qqguildsdk.util.g.o0(arrayList);
            throw null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class g implements IGProGetScheduleListNewCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ cj f268439a;

        g(cj cjVar) {
            this.f268439a = cjVar;
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetScheduleListNewCallback
        public void onGetScheduleListNew(int i3, String str, ArrayList<GProScheduleDayItem> arrayList, String str2) {
            this.f268439a.onGetScheduleListNew(i3, str, com.tencent.mobileqq.qqguildsdk.util.g.l0(arrayList), str2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class h implements IGProGetSchedulesStatusCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ck f268441a;

        h(ck ckVar) {
            this.f268441a = ckVar;
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetSchedulesStatusCallback
        public void onGetSchedulesStatus(int i3, String str, ArrayList<GProScheduleDate> arrayList) {
            this.f268441a.onGetSchedulesStatus(i3, str, com.tencent.mobileqq.qqguildsdk.util.g.j0(arrayList));
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class i implements IGProModifyScheduleInviteStatusCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f268443a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f268444b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f268445c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f268446d;

        i(String str, String str2, String str3, int i3, cm cmVar) {
            this.f268443a = str;
            this.f268444b = str2;
            this.f268445c = str3;
            this.f268446d = i3;
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProModifyScheduleInviteStatusCallback
        public void onModifyInviteStatus(int i3, String str) {
            if (i3 == 0) {
                a.this.f268422a.ej(106, "modifyScheduleInviteStatus", this.f268443a, this.f268444b, this.f268445c, Integer.valueOf(this.f268446d));
            }
            throw null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class j implements IGProGetScheduleUsersCallback {
        j(cl clVar) {
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetScheduleUsersCallback
        public void onGetScheduleUsers(int i3, String str, ArrayList<GProScheduleUser> arrayList, boolean z16, byte[] bArr, int i16, int i17) {
            com.tencent.mobileqq.qqguildsdk.util.g.s0(arrayList);
            throw null;
        }
    }

    public a(GPSManagerEngine gPSManagerEngine) {
        this.f268422a = gPSManagerEngine;
    }

    public void b(String str, String str2, GuildScheduleInfo guildScheduleInfo, ce ceVar) {
        this.f268422a.yd(str, str2, com.tencent.mobileqq.qqguildsdk.util.g.N(guildScheduleInfo), new c(str, str2, ceVar));
    }

    public void c(String str, cf cfVar) {
        this.f268422a.zd(str, new b(cfVar));
    }

    public void d(String str, String str2, GuildScheduleInfo guildScheduleInfo, int i3, cg cgVar) {
        this.f268422a.Dd(str, str2, com.tencent.mobileqq.qqguildsdk.util.g.N(guildScheduleInfo), i3, new d(str, str2, i3, cgVar));
    }

    public void e(String str, String str2, String str3, ch chVar) {
        this.f268422a.Lf(str, str2, str3, new e(chVar));
    }

    public void f(String str, String str2, long j3, ci ciVar) {
        this.f268422a.Mf(str, str2, j3, new f(ciVar));
    }

    public void g(String str, String str2, int i3, long j3, String str3, cj cjVar) {
        if (str3 == null) {
            str3 = "";
        }
        this.f268422a.Nf(str, str2, i3, j3, str3, new g(cjVar));
    }

    public void h(String str, String str2, String str3, int i3, byte[] bArr, cl clVar) {
        this.f268422a.Of(str, str2, str3, i3, bArr, new j(clVar));
    }

    public void i(String str, String str2, long j3, long j16, ck ckVar) {
        this.f268422a.Pf(str, str2, j3, j16, new h(ckVar));
    }

    public void j(String str, String str2, String str3, int i3, cm cmVar) {
        this.f268422a.dj(str, str2, str3, i3, new i(str, str2, str3, i3, cmVar));
    }

    public void k(ArrayList<Long> arrayList, ArrayList<Long> arrayList2, ArrayList<cu> arrayList3, cu cuVar, long j3, int i3, String str, String str2, String str3, byte[] bArr, cn cnVar) {
        String str4;
        String str5;
        String str6;
        ArrayList<GProScheduleSendArkGuildInfo> P = com.tencent.mobileqq.qqguildsdk.util.g.P(arrayList3);
        GProScheduleSendArkGuildInfo O = com.tencent.mobileqq.qqguildsdk.util.g.O(cuVar);
        if (str == null) {
            str4 = "";
        } else {
            str4 = str;
        }
        if (str2 == null) {
            str5 = "";
        } else {
            str5 = str2;
        }
        if (str3 == null) {
            str6 = "";
        } else {
            str6 = str3;
        }
        this.f268422a.Aj(arrayList, arrayList2, P, O, j3, i3, str4, str5, str6, bArr, new C8344a(cnVar));
    }
}
