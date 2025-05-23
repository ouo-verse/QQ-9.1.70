package com.tencent.mobileqq.qqguildsdk.engine;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqguildsdk.data.GProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildSourceId;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.ei;
import com.tencent.mobileqq.qqguildsdk.data.fk;
import com.tencent.mobileqq.qqguildsdk.data.fn;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVMemberGroupListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterAudioLiveChannelRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildInfoAndMemberListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildListSortInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.cj;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCmd0x1258ExtendRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetGuildAndChannelReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuild;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildInit;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildRole;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRolePermission;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuestGuildInfoWithChannelListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchRoleListPermissionCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchRolePermissionCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import vh2.ak;
import vh2.am;
import vh2.ao;
import vh2.ap;
import vh2.aq;
import vh2.ar;
import vh2.bd;
import vh2.bg;
import vh2.bq;
import vh2.bv;
import vh2.bw;
import vh2.bx;
import vh2.cc;
import vh2.cd;
import vh2.cr;
import vh2.cs;
import vh2.ct;
import vh2.cw;
import vh2.cx;
import vh2.cy;
import vh2.cz;
import vh2.da;
import vh2.db;
import wh2.ac;
import wh2.dv;
import wh2.eh;
import wh2.em;

/* compiled from: P */
/* loaded from: classes17.dex */
public class z extends GPSManagerEngine {

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements da {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f268314a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ da f268315b;

        a(String str, da daVar) {
            this.f268314a = str;
            this.f268315b = daVar;
        }

        @Override // vh2.da
        public void a(int i3, IGProGuildInfo iGProGuildInfo, String str) {
            if (i3 == 0) {
                iGProGuildInfo = z.this.jl(this.f268314a);
                z.this.ej(4, "setGuildTop", this.f268314a);
            }
            this.f268315b.a(i3, iGProGuildInfo, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class aa implements di2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ak f268317a;

        aa(ak akVar) {
            this.f268317a = akVar;
        }

        @Override // di2.a
        public void a(int i3, String str, List<GProGuildRoleInfo> list) {
            com.tencent.mobileqq.qqguildsdk.util.h.n("GPSManagerEngine", false, "sdk callback", "fetchMemberRoleList", "callback", i3, str, "roleList: " + list.toString());
            this.f268317a.a(i3, str, com.tencent.mobileqq.qqguildsdk.util.g.D0(list));
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class ab implements di2.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ bx f268319a;

        ab(bx bxVar) {
            this.f268319a = bxVar;
        }

        @Override // di2.h
        public void a(int i3, String str, List<GProGuildRoleInfo> list) {
            List<IGProGuildRoleInfo> D0 = com.tencent.mobileqq.qqguildsdk.util.g.D0(list);
            com.tencent.mobileqq.qqguildsdk.util.h.n("GPSManagerEngine", false, "sdk callback", "loadMemberRoleList", "callback", i3, str, "roleList: " + D0.toString());
            this.f268319a.a(i3, str, D0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class ac implements dv {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ dv f268321a;

        ac(dv dvVar) {
            this.f268321a = dvVar;
        }

        @Override // wh2.dv
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
            dv dvVar = this.f268321a;
            if (dvVar != null) {
                dvVar.a(i3, str, iGProSecurityResult);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class ad implements di2.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f268323a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f268324b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ bq f268325c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f268326d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f268327e;

        ad(List list, List list2, bq bqVar, String str, boolean z16) {
            this.f268323a = list;
            this.f268324b = list2;
            this.f268325c = bqVar;
            this.f268326d = str;
            this.f268327e = z16;
        }

        @Override // di2.f
        public void a(int i3, String str, @NonNull List<GProUserInfo> list, @NonNull List<String> list2) {
            int i16;
            if (i3 == 0) {
                for (GProUserInfo gProUserInfo : list) {
                    this.f268323a.add(gProUserInfo);
                    this.f268324b.remove(gProUserInfo.getTinyId());
                }
                if (this.f268324b.size() == 0) {
                    this.f268325c.a(i3, str, this.f268323a, new ArrayList());
                    com.tencent.mobileqq.qqguildsdk.util.h.c("GPSManagerEngine", false, "sdk callback", "fetchSvrUserList", " db enought", i3, str, "guildId : " + this.f268326d);
                    return;
                }
                com.tencent.mobileqq.qqguildsdk.util.h.c("GPSManagerEngine", false, "sdk callback", "fetchSvrUserList", " db result = 0\uff0cnot enought", i3, str, "guildId : " + this.f268326d);
            } else {
                com.tencent.mobileqq.qqguildsdk.util.h.n("GPSManagerEngine", true, "sdk callback", "fetchDBUserList", " fail", i3, str, "guildId : " + this.f268326d);
            }
            if (this.f268327e && this.f268324b.size() > 0) {
                z.this.rm(this.f268326d, "0", this.f268324b, 105, this.f268325c, this.f268323a);
                return;
            }
            bq bqVar = this.f268325c;
            if (this.f268323a.size() > 0) {
                i16 = 0;
            } else {
                i16 = i3;
            }
            bqVar.a(i16, str, this.f268323a, list2);
            com.tencent.mobileqq.qqguildsdk.util.h.c("GPSManagerEngine", false, "sdk callback", "fetchSvrUserList", " db not enought\uff0cand not fetch svr", i3, str, "guildId : " + this.f268326d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class ae implements di2.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f268329a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ bq f268330b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f268331c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f268332d;

        ae(String str, bq bqVar, List list, List list2) {
            this.f268329a = str;
            this.f268330b = bqVar;
            this.f268331c = list;
            this.f268332d = list2;
        }

        @Override // di2.f
        public void a(int i3, String str, @NonNull List<GProUserInfo> list, @NonNull List<String> list2) {
            if (i3 != 0) {
                com.tencent.mobileqq.qqguildsdk.util.h.n("GPSManagerEngine", true, "sdk callback", "fetchSvrUserList", "gain svr user list", i3, str, "guildId : " + this.f268329a);
                this.f268330b.a(i3, str, this.f268331c, this.f268332d);
                return;
            }
            for (GProUserInfo gProUserInfo : list) {
                this.f268331c.add(gProUserInfo);
                this.f268332d.remove(gProUserInfo.getTinyId());
            }
            this.f268330b.a(i3, str, this.f268331c, this.f268332d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class af implements db {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ db f268334a;

        af(db dbVar) {
            this.f268334a = dbVar;
        }

        @Override // vh2.db
        public void onSetGuildWeakNotifyDisplay(int i3, String str, int i16) {
            db dbVar = this.f268334a;
            if (dbVar != null) {
                dbVar.onSetGuildWeakNotifyDisplay(i3, str, i16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class ag implements cz {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ cz f268336a;

        ag(cz czVar) {
            this.f268336a = czVar;
        }

        @Override // vh2.cz
        public void a(int i3, String str, int i16) {
            cz czVar = this.f268336a;
            if (czVar != null) {
                czVar.a(i3, str, i16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class ah implements bv {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f268338a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ bv f268339b;

        ah(String str, bv bvVar) {
            this.f268338a = str;
            this.f268339b = bvVar;
        }

        @Override // vh2.bv
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
            if (i3 == 0 && z.this.vm(iGProSecurityResult)) {
                z.this.ej(8, "addGuild", this.f268338a);
            }
            this.f268339b.a(i3, str, iGProSecurityResult, iGProJoinGuildResult);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class ai implements di2.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f268341a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ vh2.g f268342b;

        ai(String str, vh2.g gVar) {
            this.f268341a = str;
            this.f268342b = gVar;
        }

        @Override // di2.e
        public void a(int i3, String str, GProChannelInfo gProChannelInfo, IGProSecurityResult iGProSecurityResult, com.tencent.mobileqq.qqguildsdk.data.b bVar, List<com.tencent.mobileqq.qqguildsdk.data.b> list) {
            String str2;
            if (("guildId \uff1a" + this.f268341a + gProChannelInfo) != null) {
                str2 = ", channelId:" + gProChannelInfo.getChannelUin();
            } else {
                str2 = "";
            }
            com.tencent.mobileqq.qqguildsdk.util.h.c("GPSManagerEngine", false, "sdk callback", "createChannelWithId", "new id", i3, str, str2);
            if ((i3 == 0 || i3 == 29300) && z.this.vm(iGProSecurityResult)) {
                z.this.Tk(gProChannelInfo);
                z.this.ej(6, "createChannelWithId", gProChannelInfo);
            }
            this.f268342b.a(i3, str, gProChannelInfo, iGProSecurityResult);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class aj implements cd {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f268344a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f268345b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ cd f268346c;

        aj(String str, String str2, cd cdVar) {
            this.f268344a = str;
            this.f268345b = str2;
            this.f268346c = cdVar;
        }

        @Override // vh2.cd
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
            if (i3 == 0 && z.this.vm(iGProSecurityResult)) {
                z.this.Bl(this.f268344a, this.f268345b);
            }
            this.f268346c.a(i3, str, iGProSecurityResult);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class b implements ct {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f268348a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ct f268349b;

        b(String str, ct ctVar) {
            this.f268348a = str;
            this.f268349b = ctVar;
        }

        @Override // vh2.ct
        public void a(int i3, IGProChannelInfo iGProChannelInfo, String str, IGProSecurityResult iGProSecurityResult) {
            if (i3 == 0 && z.this.vm(iGProSecurityResult)) {
                iGProChannelInfo = z.this.cl(this.f268348a);
                z.this.ej(5, "setChannelName", this.f268348a);
                if (iGProChannelInfo != null) {
                    z.this.ej(19, "setChannelName", com.tencent.mobileqq.qqguildsdk.data.g.a(iGProChannelInfo));
                }
            }
            this.f268349b.a(i3, iGProChannelInfo, str, iGProSecurityResult);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class c implements cs {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f268351a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f268352b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f268353c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ cs f268354d;

        c(String str, String str2, int i3, cs csVar) {
            this.f268351a = str;
            this.f268352b = str2;
            this.f268353c = i3;
            this.f268354d = csVar;
        }

        @Override // vh2.cs
        public void a(int i3, IGProChannelInfo iGProChannelInfo, String str) {
            if (i3 == 0) {
                iGProChannelInfo = z.this.el().f(this.f268351a);
                z.this.ej(5, "customChannelMsgNotifyType", this.f268351a);
                z.this.ej(12, "customChannelMsgNotifyType", this.f268352b, this.f268351a, Integer.valueOf(this.f268353c));
                if (iGProChannelInfo != null) {
                    z.this.ej(19, "customChannelMsgNotifyType", com.tencent.mobileqq.qqguildsdk.data.g.a(iGProChannelInfo));
                }
            }
            this.f268354d.a(i3, iGProChannelInfo, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class d implements vh2.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f268356a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ vh2.c f268357b;

        d(List list, vh2.c cVar) {
            this.f268356a = list;
            this.f268357b = cVar;
        }

        @Override // vh2.c
        public void a(int i3, String str, String str2, List<IGProChannelInfo> list) {
            if (i3 == 0) {
                list = new ArrayList<>();
                for (com.tencent.mobileqq.qqguildsdk.data.f fVar : this.f268356a) {
                    String a16 = fVar.a();
                    int b16 = fVar.b();
                    IGProChannelInfo f16 = z.this.el().f(a16);
                    list.add(f16);
                    z.this.ej(5, "customChannelMsgNotifyType", a16);
                    z.this.ej(12, "customChannelMsgNotifyType", str2, a16, Integer.valueOf(b16));
                    if (f16 != null) {
                        z.this.ej(19, "customChannelMsgNotifyType", com.tencent.mobileqq.qqguildsdk.data.g.a(f16));
                    }
                }
            }
            this.f268357b.a(i3, str, str2, list);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class e implements cx {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f268359a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ cx f268360b;

        e(String str, cx cxVar) {
            this.f268359a = str;
            this.f268360b = cxVar;
        }

        @Override // vh2.cx
        public void a(int i3, IGProGuildInfo iGProGuildInfo, String str, IGProSecurityResult iGProSecurityResult) {
            if (i3 == 0 && z.this.vm(iGProSecurityResult)) {
                iGProGuildInfo = z.this.jl(this.f268359a);
                z.this.ej(4, "setGuildName", this.f268359a);
            }
            this.f268360b.a(i3, iGProGuildInfo, str, iGProSecurityResult);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class f implements cw {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ cw f268362a;

        f(cw cwVar) {
            this.f268362a = cwVar;
        }

        @Override // vh2.cw
        public void a(int i3, String str, String str2, int i16) {
            this.f268362a.a(i3, str, str2, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class g implements bw {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ bw f268364a;

        g(bw bwVar) {
            this.f268364a = bwVar;
        }

        @Override // vh2.bw
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult, List<ei> list) {
            this.f268364a.a(i3, str, iGProSecurityResult, list);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class h implements di2.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f268366a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ bg f268367b;

        h(String str, bg bgVar) {
            this.f268366a = str;
            this.f268367b = bgVar;
        }

        @Override // di2.d
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult, com.tencent.mobileqq.qqguildsdk.data.b bVar, List<com.tencent.mobileqq.qqguildsdk.data.b> list) {
            if (i3 == 0 && z.this.vm(iGProSecurityResult)) {
                z.this.el().n(this.f268366a, bVar, list);
            }
            this.f268367b.a(i3, str, iGProSecurityResult);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class i implements di2.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f268369a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ bg f268370b;

        i(String str, bg bgVar) {
            this.f268369a = str;
            this.f268370b = bgVar;
        }

        @Override // di2.d
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult, com.tencent.mobileqq.qqguildsdk.data.b bVar, List<com.tencent.mobileqq.qqguildsdk.data.b> list) {
            if (i3 == 0 && z.this.vm(iGProSecurityResult)) {
                z.this.el().b(this.f268369a, bVar, list);
            }
            this.f268370b.a(i3, str, iGProSecurityResult);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class j implements di2.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f268372a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ bg f268373b;

        j(String str, bg bgVar) {
            this.f268372a = str;
            this.f268373b = bgVar;
        }

        @Override // di2.d
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult, com.tencent.mobileqq.qqguildsdk.data.b bVar, List<com.tencent.mobileqq.qqguildsdk.data.b> list) {
            if (i3 == 0 && z.this.vm(iGProSecurityResult)) {
                z.this.el().m(this.f268372a, bVar, list);
            }
            this.f268373b.a(i3, str, iGProSecurityResult);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class k implements cy {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ cy f268375a;

        k(cy cyVar) {
            this.f268375a = cyVar;
        }

        @Override // vh2.cy
        public void onSetGuildListSort(int i3, String str) {
            cy cyVar = this.f268375a;
            if (cyVar != null) {
                cyVar.onSetGuildListSort(i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class l implements di2.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f268377a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ bg f268378b;

        l(String str, bg bgVar) {
            this.f268377a = str;
            this.f268378b = bgVar;
        }

        @Override // di2.d
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult, com.tencent.mobileqq.qqguildsdk.data.b bVar, List<com.tencent.mobileqq.qqguildsdk.data.b> list) {
            if (i3 == 0 && z.this.vm(iGProSecurityResult)) {
                z.this.el().a(this.f268377a, bVar, list);
            }
            this.f268378b.a(i3, str, iGProSecurityResult);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class m implements di2.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f268380a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ bg f268381b;

        m(String str, bg bgVar) {
            this.f268380a = str;
            this.f268381b = bgVar;
        }

        @Override // di2.d
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult, com.tencent.mobileqq.qqguildsdk.data.b bVar, List<com.tencent.mobileqq.qqguildsdk.data.b> list) {
            if (i3 == 0 && z.this.vm(iGProSecurityResult)) {
                z.this.el().p(this.f268380a, bVar, list);
            }
            this.f268381b.a(i3, str, iGProSecurityResult);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class n implements di2.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f268383a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ bg f268384b;

        n(String str, bg bgVar) {
            this.f268383a = str;
            this.f268384b = bgVar;
        }

        @Override // di2.d
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult, com.tencent.mobileqq.qqguildsdk.data.b bVar, List<com.tencent.mobileqq.qqguildsdk.data.b> list) {
            if (i3 == 0 && z.this.vm(iGProSecurityResult)) {
                z.this.el().o(this.f268383a, bVar, list);
            }
            this.f268384b.a(i3, str, iGProSecurityResult);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class o implements cd {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f268386a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ cd f268387b;

        o(String str, cd cdVar) {
            this.f268386a = str;
            this.f268387b = cdVar;
        }

        @Override // vh2.cd
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
            if (i3 == 0 && z.this.vm(iGProSecurityResult)) {
                z.this.ej(4, "setGuildProfile", this.f268386a);
            }
            this.f268387b.a(i3, str, iGProSecurityResult);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class p implements dv {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f268389a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ dv f268390b;

        p(long j3, dv dvVar) {
            this.f268389a = j3;
            this.f268390b = dvVar;
        }

        @Override // wh2.dv
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
            if (i3 == 0 && z.this.vm(iGProSecurityResult)) {
                z.this.ej(4, "setTopicSquareEntranceSwitch", Long.toString(this.f268389a));
            }
            this.f268390b.a(i3, str, iGProSecurityResult);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class q implements cd {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ cd f268392a;

        q(cd cdVar) {
            this.f268392a = cdVar;
        }

        @Override // vh2.cd
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
            this.f268392a.a(i3, str, iGProSecurityResult);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class r implements di2.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f268394a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ vh2.i f268395b;

        r(String str, vh2.i iVar) {
            this.f268394a = str;
            this.f268395b = iVar;
        }

        @Override // di2.g
        public void a(int i3, String str, GProGuildRoleInfo gProGuildRoleInfo, IGProSecurityResult iGProSecurityResult) {
            com.tencent.mobileqq.qqguildsdk.util.h.n("GPSManagerEngine", false, "sdk callback", "createRole", "callback", i3, str, "guildId: " + this.f268394a + ", roleInfo: " + gProGuildRoleInfo.toString());
            this.f268395b.a(i3, str, gProGuildRoleInfo, iGProSecurityResult);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class s implements cd {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ cd f268397a;

        s(cd cdVar) {
            this.f268397a = cdVar;
        }

        @Override // vh2.cd
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
            com.tencent.mobileqq.qqguildsdk.util.h.n("GPSManagerEngine", false, "sdk callback", "deleteRole", "callback", i3, str, null);
            this.f268397a.a(i3, str, iGProSecurityResult);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class t implements cd {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ cd f268399a;

        t(cd cdVar) {
            this.f268399a = cdVar;
        }

        @Override // vh2.cd
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
            com.tencent.mobileqq.qqguildsdk.util.h.n("GPSManagerEngine", false, "sdk callback", "setRoleInfo", "callback", i3, str, null);
            this.f268399a.a(i3, str, iGProSecurityResult);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class u implements cd {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ cd f268401a;

        u(cd cdVar) {
            this.f268401a = cdVar;
        }

        @Override // vh2.cd
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
            com.tencent.mobileqq.qqguildsdk.util.h.n("GPSManagerEngine", false, "sdk callback", "setRoleOrder", "callback", i3, str, null);
            this.f268401a.a(i3, str, iGProSecurityResult);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class v implements eh {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ eh f268403a;

        v(eh ehVar) {
            this.f268403a = ehVar;
        }

        @Override // wh2.eh
        public void a(int i3, String str, IGProGuildListSortInfo iGProGuildListSortInfo) {
            eh ehVar = this.f268403a;
            if (ehVar != null) {
                ehVar.a(i3, str, iGProGuildListSortInfo);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class w implements cd {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ cd f268405a;

        w(cd cdVar) {
            this.f268405a = cdVar;
        }

        @Override // vh2.cd
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
            com.tencent.mobileqq.qqguildsdk.util.h.n("GPSManagerEngine", false, "sdk callback", "setRoleMembers", "callback", i3, str, null);
            this.f268405a.a(i3, str, iGProSecurityResult);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class x implements cd {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ cd f268407a;

        x(cd cdVar) {
            this.f268407a = cdVar;
        }

        @Override // vh2.cd
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
            com.tencent.mobileqq.qqguildsdk.util.h.n("GPSManagerEngine", false, "sdk callback", "setMemberRoles", "callback", i3, str, null);
            this.f268407a.a(i3, str, iGProSecurityResult);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class y implements di2.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ aq f268409a;

        y(aq aqVar) {
            this.f268409a = aqVar;
        }

        @Override // di2.c
        public void a(int i3, String str, long j3, List<GProGuildRoleInfo> list, List<GProGuildRoleInfo> list2) {
            com.tencent.mobileqq.qqguildsdk.util.h.n("GPSManagerEngine", false, "sdk callback", "fetchRoleList", "callback", i3, str, "limit: " + j3 + ", roleList: " + list.toString());
            this.f268409a.a(i3, str, com.tencent.mobileqq.qqguildsdk.util.g.D0(list), com.tencent.mobileqq.qqguildsdk.util.g.D0(list2));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqguildsdk.engine.z$z, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    class C8343z implements di2.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ap f268411a;

        C8343z(ap apVar) {
            this.f268411a = apVar;
        }

        @Override // di2.b
        public void a(int i3, String str, GProGuildRoleInfo gProGuildRoleInfo) {
            com.tencent.mobileqq.qqguildsdk.util.h.n("GPSManagerEngine", false, "sdk callback", "fetchRole", "callback", i3, str, "roleInfo: " + gProGuildRoleInfo.toString());
            this.f268411a.a(i3, str, gProGuildRoleInfo);
        }
    }

    public z(@NonNull AppRuntime appRuntime, @NonNull com.tencent.mobileqq.qqguildsdk.wrapper.a aVar) {
        super(appRuntime, aVar);
        com.tencent.mobileqq.qqguildsdk.util.h.p("GPSManagerEngine", true, "", "new GPSAsynManagerEngine", "", toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Am(String str, dv dvVar, int i3, String str2, IGProSecurityResult iGProSecurityResult) {
        if (i3 == 0 && vm(iGProSecurityResult)) {
            Al(str, true);
            ej(11, "destroyGuild", str);
        }
        dvVar.a(i3, str2, iGProSecurityResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Dm(vh2.k kVar, int i3, String str, int i16) {
        if (i3 == 0) {
            ej(111, "fetchFeedsNotifySwitch", Integer.valueOf(i16), Boolean.FALSE);
        }
        kVar.onResult(i3, str, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Fm(final IGProFetchGuestGuildInfoWithChannelListCallback iGProFetchGuestGuildInfoWithChannelListCallback, final int i3, final String str, final String str2, final GProGuild gProGuild, final GProGuildInit gProGuildInit, final int i16, final GProCmd0x1258ExtendRsp gProCmd0x1258ExtendRsp) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.q
            @Override // java.lang.Runnable
            public final void run() {
                IGProFetchGuestGuildInfoWithChannelListCallback.this.onFetchGuestGuildInfoWithChannelList(i3, str, str2, gProGuild, gProGuildInit, i16, gProCmd0x1258ExtendRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Hm(final wh2.ap apVar, final int i3, final String str, final IGProGuildInfoAndMemberListRsp iGProGuildInfoAndMemberListRsp) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.p
            @Override // java.lang.Runnable
            public final void run() {
                wh2.ap.this.a(i3, str, iGProGuildInfoAndMemberListRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Im(xh2.a aVar, int i3, String str, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, long j3) {
        aVar.a(i3, str, com.tencent.mobileqq.qqguildsdk.util.g.v(arrayList), com.tencent.mobileqq.qqguildsdk.util.g.v(arrayList2), com.tencent.mobileqq.qqguildsdk.util.g.Y0(arrayList3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Jm(xh2.b bVar, int i3, String str, GProGuildRole gProGuildRole, GProRolePermission gProRolePermission, ArrayList arrayList, ArrayList arrayList2) {
        bVar.a(i3, str, new GProGuildRoleInfo(gProGuildRole), com.tencent.mobileqq.qqguildsdk.data.ad.a(gProRolePermission), com.tencent.mobileqq.qqguildsdk.data.ad.c(arrayList), com.tencent.mobileqq.qqguildsdk.util.g.H0(arrayList2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Km(String str, dv dvVar, int i3, String str2, IGProSecurityResult iGProSecurityResult) {
        if (i3 == 0 && vm(iGProSecurityResult)) {
            Al(str, true);
            ej(9, "removeGuild", str);
        }
        dvVar.a(i3, str2, iGProSecurityResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Lm(String str, cr crVar, int i3, IGProChannelInfo iGProChannelInfo, String str2, IGProSecurityResult iGProSecurityResult) {
        crVar.a(i3, cl(str), str2, iGProSecurityResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Mm(String str, boolean z16, cd cdVar, int i3, String str2, IGProSecurityResult iGProSecurityResult) {
        if (i3 == 0 && vm(iGProSecurityResult)) {
            ej(101, "setDirectMsgBlack", str, Boolean.valueOf(z16));
        }
        cdVar.a(i3, str2, iGProSecurityResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Nm(int i3, boolean z16, cd cdVar, int i16, String str, IGProSecurityResult iGProSecurityResult) {
        if (i16 == 0 && vm(iGProSecurityResult)) {
            ej(107, "setDirectMsgNotifyForGuild", Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        cdVar.a(i16, str, iGProSecurityResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Om(String str, int i3, cd cdVar, int i16, String str2, IGProSecurityResult iGProSecurityResult) {
        if (i16 == 0 && vm(iGProSecurityResult)) {
            ej(103, "setDirectMsgNotifyType", str, Integer.valueOf(i3));
        }
        cdVar.a(i16, str2, iGProSecurityResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Pm(int i3, cd cdVar, int i16, String str, IGProSecurityResult iGProSecurityResult) {
        if (i16 == 0 && vm(iGProSecurityResult)) {
            ej(102, "setDirectMsgSwitchStatus", Integer.valueOf(i3));
        }
        cdVar.a(i16, str, iGProSecurityResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Qm(int i3, vh2.k kVar, int i16, String str, int i17) {
        if (i16 == 0) {
            ej(111, "setFeedCommentsNotifySwitch", Integer.valueOf(i3), Boolean.TRUE);
        }
        kVar.onResult(i16, str, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Sm(String str, cd cdVar, int i3, String str2, IGProSecurityResult iGProSecurityResult) {
        if (i3 == 0 && vm(iGProSecurityResult) && jl(str) != null) {
            ej(4, "setGuildShutUp", str);
        }
        cdVar.a(i3, str2, iGProSecurityResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Um(String str, cd cdVar, int i3, String str2, IGProSecurityResult iGProSecurityResult) {
        IGProChannelInfo cl5;
        if (i3 == 0 && vm(iGProSecurityResult) && (cl5 = cl(str)) != null) {
            ej(5, "updateForumChannelSortMode", str);
            ej(19, "updateForumChannelSortMode", com.tencent.mobileqq.qqguildsdk.data.g.a(cl5));
        }
        cdVar.a(i3, str2, iGProSecurityResult);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private fk tm(fk fkVar) {
        int i3;
        String str;
        String str2;
        String guildId = fkVar.getGuildId();
        String channelId = fkVar.getChannelId();
        long topTimestamp = fkVar.getTopTimestamp();
        String guildName = fkVar.getGuildName();
        String channelName = fkVar.getChannelName();
        long avatarSeq = fkVar.getAvatarSeq();
        int channelType = fkVar.getChannelType();
        long appId = fkVar.getAppId();
        IGProGuildInfo jl5 = jl(guildId);
        if (jl5 != null) {
            String guildName2 = jl5.getGuildName();
            if (!TextUtils.isEmpty(guildName2)) {
                guildName = guildName2;
            }
            avatarSeq = jl5.getAvatarSeq();
        }
        long j3 = avatarSeq;
        IGProChannelInfo cl5 = cl(channelId);
        if (cl5 != null) {
            String channelName2 = cl5.getChannelName();
            if (!TextUtils.isEmpty(channelName2)) {
                channelName = channelName2;
            }
            int type = cl5.getType();
            if (type != 0) {
                i3 = type;
                if (guildName != null) {
                    com.tencent.mobileqq.qqguildsdk.util.h.k("GPSManagerEngine", 1, "sdk interface", "getQQMsgListChannels guildName is null, gid:" + guildId + ",cid:" + channelId);
                    str = "";
                } else {
                    str = guildName;
                }
                if (channelName != null) {
                    com.tencent.mobileqq.qqguildsdk.util.h.k("GPSManagerEngine", 1, "sdk interface", "getQQMsgListChannels channelName is null, gid:" + guildId + ",cid:" + channelId);
                    str2 = "";
                } else {
                    str2 = channelName;
                }
                return new fk(guildId, channelId, topTimestamp, str, str2, j3, i3, appId);
            }
        }
        i3 = channelType;
        if (guildName != null) {
        }
        if (channelName != null) {
        }
        return new fk(guildId, channelId, topTimestamp, str, str2, j3, i3, appId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void xm(String str, dv dvVar, int i3, String str2, IGProSecurityResult iGProSecurityResult) {
        if (i3 == 0 && vm(iGProSecurityResult)) {
            ej(4, "changeGuildAllowSearch", str);
        }
        dvVar.a(i3, str2, iGProSecurityResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ym(vh2.h hVar, int i3, String str, IGProSecurityResult iGProSecurityResult, boolean z16, com.tencent.mobileqq.qqguildsdk.data.k kVar) {
        if (i3 == 0 && vm(iGProSecurityResult)) {
            ej(100, "createDirectMsgSession", kVar);
        }
        hVar.a(i3, str, iGProSecurityResult, z16, kVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void Ad(String str, String str2, int i3, cs csVar) {
        super.Ad(str, str2, i3, new c(str2, str, i3, csVar));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void Bj(String str, String str2, int i3, cd cdVar) {
        super.Bj(str, str2, i3, cdVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void Cd(String str, String str2, cd cdVar) {
        super.Cd(str, str2, new s(cdVar));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void Ed(com.tencent.mobileqq.qqguildsdk.data.genc.ai aiVar, final wh2.x xVar) {
        super.Ed(aiVar, new wh2.x() { // from class: com.tencent.mobileqq.qqguildsdk.engine.u
            @Override // wh2.x
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProEnterAudioLiveChannelRsp iGProEnterAudioLiveChannelRsp) {
                wh2.x.this.a(i3, str, iGProSecurityResult, iGProEnterAudioLiveChannelRsp);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void Fj(String str, String str2, int i3, @NonNull cd cdVar) {
        super.Fj(str, str2, i3, cdVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void Gd(com.tencent.mobileqq.qqguildsdk.data.genc.m mVar, final wh2.ac acVar) {
        super.Gd(mVar, new wh2.ac() { // from class: com.tencent.mobileqq.qqguildsdk.engine.r
            @Override // wh2.ac
            public final void a(int i3, String str, IGProAVMemberGroupListRsp iGProAVMemberGroupListRsp) {
                ac.this.a(i3, str, iGProAVMemberGroupListRsp);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public fk Hf(String str, String str2) {
        return tm(super.Hf(str, str2));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public List<fk> If() {
        List<fk> If = super.If();
        ArrayList arrayList = new ArrayList();
        Iterator<fk> it = If.iterator();
        while (it.hasNext()) {
            arrayList.add(tm(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void Ij(String str, final String str2, int i3, final cr crVar) {
        super.Ij(str, str2, i3, new cr() { // from class: com.tencent.mobileqq.qqguildsdk.engine.o
            @Override // vh2.cr
            public final void a(int i16, IGProChannelInfo iGProChannelInfo, String str3, IGProSecurityResult iGProSecurityResult) {
                z.this.Lm(str2, crVar, i16, iGProChannelInfo, str3, iGProSecurityResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void Jj(String str, String str2, String str3, ct ctVar) {
        super.Jj(str, str2, str3, new b(str2, ctVar));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void Kj(String str, String str2, int i3, cd cdVar) {
        super.Kj(str, str2, i3, cdVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void Lj(String str, String str2, int i3, @NonNull cd cdVar) {
        super.Lj(str, str2, i3, cdVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void Nk(String str, final String str2, int i3, @NonNull final cd cdVar) {
        super.Nk(str, str2, i3, new cd() { // from class: com.tencent.mobileqq.qqguildsdk.engine.l
            @Override // vh2.cd
            public final void a(int i16, String str3, IGProSecurityResult iGProSecurityResult) {
                z.this.Um(str2, cdVar, i16, str3, iGProSecurityResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void Pj(String str, String str2, int i3, cd cdVar) {
        super.Pj(str, str2, i3, cdVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void Tj(final String str, final boolean z16, final cd cdVar) {
        super.Tj(str, z16, new cd() { // from class: com.tencent.mobileqq.qqguildsdk.engine.b
            @Override // vh2.cd
            public final void a(int i3, String str2, IGProSecurityResult iGProSecurityResult) {
                z.this.Mm(str, z16, cdVar, i3, str2, iGProSecurityResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void Uj(final int i3, final boolean z16, final cd cdVar) {
        super.Uj(i3, z16, new cd() { // from class: com.tencent.mobileqq.qqguildsdk.engine.w
            @Override // vh2.cd
            public final void a(int i16, String str, IGProSecurityResult iGProSecurityResult) {
                z.this.Nm(i3, z16, cdVar, i16, str, iGProSecurityResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void Vj(final String str, final int i3, final cd cdVar) {
        super.Vj(str, i3, new cd() { // from class: com.tencent.mobileqq.qqguildsdk.engine.c
            @Override // vh2.cd
            public final void a(int i16, String str2, IGProSecurityResult iGProSecurityResult) {
                z.this.Om(str, i3, cdVar, i16, str2, iGProSecurityResult);
            }
        });
    }

    public void Vm(String str, String str2, bx bxVar) {
        Wi(str, str2, new ab(bxVar));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void Wj(final int i3, int i16, final cd cdVar) {
        super.Wj(i3, i16, new cd() { // from class: com.tencent.mobileqq.qqguildsdk.engine.d
            @Override // vh2.cd
            public final void a(int i17, String str, IGProSecurityResult iGProSecurityResult) {
                z.this.Pm(i3, cdVar, i17, str, iGProSecurityResult);
            }
        });
    }

    public void Wm(String str, List<String> list, bq bqVar, @NonNull List<IGProUserInfo> list2, boolean z16) {
        Xi(str, list, new ad(list2, list, bqVar, str, z16));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl
    public void X0(final String str, boolean z16, final dv dvVar) {
        super.X0(str, z16, new dv() { // from class: com.tencent.mobileqq.qqguildsdk.engine.f
            @Override // wh2.dv
            public final void a(int i3, String str2, IGProSecurityResult iGProSecurityResult) {
                z.this.xm(str, dvVar, i3, str2, iGProSecurityResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl
    public void X1(cj cjVar, final wh2.ap apVar) {
        super.X1(cjVar, new wh2.ap() { // from class: com.tencent.mobileqq.qqguildsdk.engine.s
            @Override // wh2.ap
            public final void a(int i3, String str, IGProGuildInfoAndMemberListRsp iGProGuildInfoAndMemberListRsp) {
                z.this.Hm(apVar, i3, str, iGProGuildInfoAndMemberListRsp);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void Xj(final int i3, final vh2.k kVar) {
        super.Xj(i3, new vh2.k() { // from class: com.tencent.mobileqq.qqguildsdk.engine.y
            @Override // vh2.k
            public final void onResult(int i16, String str, int i17) {
                z.this.Qm(i3, kVar, i16, str, i17);
            }
        });
    }

    public void Xm(String str, long j3, boolean z16, bg bgVar) {
        tj(str, j3, z16, new j(str, bgVar));
    }

    public void Ym(String str, String str2, long j3, bg bgVar) {
        Cj(str, str2, j3, new h(str, bgVar));
    }

    public void Zm(String str, com.tencent.mobileqq.qqguildsdk.data.b bVar, ArrayList<com.tencent.mobileqq.qqguildsdk.data.b> arrayList, bg bgVar) {
        Dj(str, bVar, arrayList, new n(str, bgVar));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void ak(String str, int i3, cw cwVar) {
        super.ak(str, i3, new f(cwVar));
    }

    public void an(String str, ArrayList<Long> arrayList, bg bgVar) {
        Ej(str, arrayList, new m(str, bgVar));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl
    public void b5(String str, int i3, int i16, eh ehVar) {
        super.b5(str, i3, i16, new v(ehVar));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void bk(ArrayList<String> arrayList, cy cyVar) {
        super.bk(arrayList, new k(cyVar));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void ck(String str, String str2, cx cxVar) {
        super.ck(str, str2, new e(str, cxVar));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl
    public void d5(String str, boolean z16, final em emVar) {
        super.d5(str, z16, new em() { // from class: com.tencent.mobileqq.qqguildsdk.engine.i
            @Override // wh2.em
            public final void onResult(int i3, String str2) {
                em.this.onResult(i3, str2);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void de(final vh2.k kVar) {
        super.de(new vh2.k() { // from class: com.tencent.mobileqq.qqguildsdk.engine.a
            @Override // vh2.k
            public final void onResult(int i3, String str, int i16) {
                z.this.Dm(kVar, i3, str, i16);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void dk(String str, String str2, cd cdVar) {
        super.dk(str, str2, new o(str, cdVar));
    }

    public void dm(String str, long j3, String str2, bg bgVar) {
        qd(str, j3, str2, new l(str, bgVar));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void eg(String str, String str2, ArrayList<String> arrayList, bw bwVar) {
        super.eg(str, str2, arrayList, new g(bwVar));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void ek(String str, int i3, cd cdVar) {
        super.ek(str, i3, new q(cdVar));
    }

    public void em(String str, com.tencent.mobileqq.qqguildsdk.data.d dVar, long j3, int i3, com.tencent.mobileqq.qqguildsdk.data.b bVar, vh2.g gVar) {
        List<com.tencent.mobileqq.qqguildsdk.data.cy> bl5 = bl(str);
        com.tencent.mobileqq.qqguildsdk.data.b bVar2 = new com.tencent.mobileqq.qqguildsdk.data.b("", 0L);
        ArrayList<com.tencent.mobileqq.qqguildsdk.data.b> arrayList = new ArrayList<>();
        com.tencent.mobileqq.qqguildsdk.data.b bVar3 = bVar2;
        for (com.tencent.mobileqq.qqguildsdk.data.cy cyVar : bl5) {
            if (TextUtils.isEmpty(cyVar.getCategoryName())) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<IGProChannelInfo> it = cyVar.getChannelList().iterator();
                while (it.hasNext()) {
                    arrayList2.add(it.next().getChannelUin());
                }
                bVar3 = new com.tencent.mobileqq.qqguildsdk.data.b("", cyVar.getCategoryId(), arrayList2);
            } else {
                ArrayList arrayList3 = new ArrayList();
                Iterator<IGProChannelInfo> it5 = cyVar.getChannelList().iterator();
                while (it5.hasNext()) {
                    arrayList3.add(it5.next().getChannelUin());
                }
                arrayList.add(new com.tencent.mobileqq.qqguildsdk.data.b(cyVar.getCategoryName(), cyVar.getCategoryId(), arrayList3));
            }
        }
        td(str, dVar, j3, i3, bVar, bVar3, arrayList, new ai(str, gVar));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl
    public void f5(long j3, int i3, dv dvVar) {
        super.f5(j3, i3, new ac(dvVar));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void fk(final String str, long j3, final cd cdVar) {
        super.fk(str, j3, new cd() { // from class: com.tencent.mobileqq.qqguildsdk.engine.k
            @Override // vh2.cd
            public final void a(int i3, String str2, IGProSecurityResult iGProSecurityResult) {
                z.this.Sm(str, cdVar, i3, str2, iGProSecurityResult);
            }
        });
    }

    public void fm(String str, String str2, bg bgVar) {
        ud(str, str2, new i(str, bgVar));
    }

    public void gm(String str, com.tencent.mobileqq.qqguildsdk.data.d dVar, long j3, @NonNull final bd bdVar) {
        List<com.tencent.mobileqq.qqguildsdk.data.cy> bl5 = bl(str);
        com.tencent.mobileqq.qqguildsdk.data.b bVar = new com.tencent.mobileqq.qqguildsdk.data.b("", 0L);
        ArrayList<com.tencent.mobileqq.qqguildsdk.data.b> arrayList = new ArrayList<>();
        com.tencent.mobileqq.qqguildsdk.data.b bVar2 = bVar;
        for (com.tencent.mobileqq.qqguildsdk.data.cy cyVar : bl5) {
            if (TextUtils.isEmpty(cyVar.getCategoryName())) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<IGProChannelInfo> it = cyVar.getChannelList().iterator();
                while (it.hasNext()) {
                    arrayList2.add(it.next().getChannelUin());
                }
                bVar2 = new com.tencent.mobileqq.qqguildsdk.data.b("", cyVar.getCategoryId(), arrayList2);
            } else {
                ArrayList arrayList3 = new ArrayList();
                Iterator<IGProChannelInfo> it5 = cyVar.getChannelList().iterator();
                while (it5.hasNext()) {
                    arrayList3.add(it5.next().getChannelUin());
                }
                arrayList.add(new com.tencent.mobileqq.qqguildsdk.data.b(cyVar.getCategoryName(), cyVar.getCategoryId(), arrayList3));
            }
        }
        wd(str, dVar, j3, bVar2, arrayList, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.h
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
            public final void onResult(int i3, String str2) {
                bd.this.onResult(i3, str2);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void hd(String str, GuildSourceId guildSourceId, String str2, bv bvVar) {
        super.hd(str, guildSourceId, str2, new ah(str, bvVar));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void hk(String str, boolean z16, da daVar) {
        super.hk(str, z16, new a(str, daVar));
    }

    public void hm(String str, fn fnVar, List<String> list, vh2.i iVar) {
        xd(str, fnVar, list, new r(str, iVar));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void ik(String str, int i3, cz czVar) {
        super.ik(str, i3, new ag(czVar));
    }

    public void im(int i3, GProGetGuildAndChannelReq gProGetGuildAndChannelReq, final IGProFetchGuestGuildInfoWithChannelListCallback iGProFetchGuestGuildInfoWithChannelListCallback) {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GPSManagerEngine", 1, "fetchGuestGuildInfoWithChannelList kernelGuildService is null");
        } else {
            iKernelGuildService.fetchGuestGuildInfoWithChannelList(i3, gProGetGuildAndChannelReq, new IGProFetchGuestGuildInfoWithChannelListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.g
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuestGuildInfoWithChannelListCallback
                public final void onFetchGuestGuildInfoWithChannelList(int i16, String str, String str2, GProGuild gProGuild, GProGuildInit gProGuildInit, int i17, GProCmd0x1258ExtendRsp gProCmd0x1258ExtendRsp) {
                    z.this.Fm(iGProFetchGuestGuildInfoWithChannelListCallback, i16, str, str2, gProGuild, gProGuildInit, i17, gProCmd0x1258ExtendRsp);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl
    public void j4(final String str, final dv dvVar) {
        super.j4(str, new dv() { // from class: com.tencent.mobileqq.qqguildsdk.engine.t
            @Override // wh2.dv
            public final void a(int i3, String str2, IGProSecurityResult iGProSecurityResult) {
                z.this.Km(str, dvVar, i3, str2, iGProSecurityResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void jk(String str, boolean z16, @NonNull final cc ccVar) {
        super.jk(str, z16, new cc() { // from class: com.tencent.mobileqq.qqguildsdk.engine.m
            @Override // vh2.cc
            public final void onResult(int i3, String str2) {
                cc.this.onResult(i3, str2);
            }
        });
    }

    public void jm(String str, String str2, int i3, boolean z16, @NonNull vh2.ai aiVar) {
        nl().b(str, str2, i3, z16, aiVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void kk(String str, int i3, db dbVar) {
        super.kk(str, i3, new af(dbVar));
    }

    public void km(String str, String str2, String str3, int i3, ak akVar) {
        ve(str, str2, str3, i3, new aa(akVar));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void ld(String str, HashMap<Integer, Boolean> hashMap, @NonNull final cc ccVar) {
        super.ld(str, hashMap, new cc() { // from class: com.tencent.mobileqq.qqguildsdk.engine.x
            @Override // vh2.cc
            public final void onResult(int i3, String str2) {
                cc.this.onResult(i3, str2);
            }
        });
    }

    public void lm(String str, String str2, String str3, String str4, int i3, boolean z16, @NonNull am amVar) {
        nl().c(str, str2, str3, str4, i3, z16, amVar);
    }

    public void mm(String str, String str2, boolean z16, int i3, ap apVar) {
        Ae(str, str2, z16, i3, new C8343z(apVar));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void nd(String str, List<com.tencent.mobileqq.qqguildsdk.data.f> list, vh2.c cVar) {
        super.nd(str, list, new d(list, cVar));
    }

    public void nm(String str, int i3, int i16, aq aqVar) {
        Be(str, i3, i16, new y(aqVar));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void ok(String str, String str2, String str3, String str4, List<String> list, List<String> list2, cd cdVar) {
        super.ok(str, str2, str3, str4, list, list2, new x(cdVar));
    }

    public void om(String str, int i3, final xh2.a aVar) {
        super.Ce(str, i3, new IGProFetchRoleListPermissionCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.n
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchRoleListPermissionCallback
            public final void onFetchRoleListPermissionCallback(int i16, String str2, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, long j3) {
                z.Im(xh2.a.this, i16, str2, arrayList, arrayList2, arrayList3, j3);
            }
        });
    }

    public void pm(String str, String str2, String str3, String str4, int i3, boolean z16, @NonNull ar arVar) {
        nl().d(str, str2, str3, str4, i3, z16, arVar);
    }

    public void qm(String str, String str2, int i3, final xh2.b bVar) {
        super.Ee(str, str2, i3, new IGProFetchRolePermissionCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.v
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchRolePermissionCallback
            public final void onFetchRolePermissionCallback(int i16, String str3, GProGuildRole gProGuildRole, GProRolePermission gProRolePermission, ArrayList arrayList, ArrayList arrayList2) {
                z.Jm(xh2.b.this, i16, str3, gProGuildRole, gProRolePermission, arrayList, arrayList2);
            }
        });
    }

    public void rm(String str, String str2, List<String> list, int i3, bq bqVar, @NonNull List<IGProUserInfo> list2) {
        Fe(str, str2, list, i3, new ae(str, bqVar, list2, list));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl
    public void s5(long j3, boolean z16, dv dvVar) {
        super.s5(j3, z16, new p(j3, dvVar));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void sj(String str, String str2, int i3, cd cdVar) {
        super.sj(str, str2, i3, new aj(str, str2, cdVar));
    }

    public void sm(String str, String str2, List<String> list, boolean z16, boolean z17, bq bqVar) {
        ArrayList arrayList = new ArrayList();
        if (z16) {
            rm(str, str2, list, 105, bqVar, arrayList);
        } else {
            Wm(str, list, bqVar, arrayList, z17);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void tk(String str, String str2, fn fnVar, cd cdVar) {
        super.tk(str, str2, fnVar, new t(cdVar));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void uk(String str, String str2, String str3, String str4, List<String> list, List<String> list2, cd cdVar) {
        super.uk(str, str2, str3, str4, list, list2, new w(cdVar));
    }

    public List<IGProChannelInfo> um(String str, int i3) {
        return el().i(str, i3);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl
    public void v1(final String str, final dv dvVar) {
        super.v1(str, new dv() { // from class: com.tencent.mobileqq.qqguildsdk.engine.j
            @Override // wh2.dv
            public final void a(int i3, String str2, IGProSecurityResult iGProSecurityResult) {
                z.this.Am(str, dvVar, i3, str2, iGProSecurityResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void vd(@NonNull com.tencent.mobileqq.qqguildsdk.data.i iVar, final vh2.h hVar) {
        super.vd(iVar, new vh2.h() { // from class: com.tencent.mobileqq.qqguildsdk.engine.e
            @Override // vh2.h
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, boolean z16, com.tencent.mobileqq.qqguildsdk.data.k kVar) {
                z.this.ym(hVar, i3, str, iGProSecurityResult, z16, kVar);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void vk(String str, List<String> list, cd cdVar) {
        super.vk(str, list, new u(cdVar));
    }

    public boolean vm(IGProSecurityResult iGProSecurityResult) {
        if (iGProSecurityResult != null && ((int) iGProSecurityResult.get$actionCode()) != 0 && ((int) iGProSecurityResult.get$actionCode()) != 4) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void ye(int i3, int i16, ao aoVar) {
        super.ye(i3, i16, aoVar);
    }
}
