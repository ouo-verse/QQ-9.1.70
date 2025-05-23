package com.tencent.mobileqq.guild.schedule.list;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.home.schedule.viewmodels.GuildHomeScheduleViewModel;
import com.tencent.mobileqq.guild.schedule.create.GuildScheduleCreateFragment;
import com.tencent.mobileqq.guild.schedule.list.k;
import com.tencent.mobileqq.guild.util.as;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.cs;
import com.tencent.mobileqq.qqguildsdk.data.ct;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContact;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUnreadCntInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildGetMsgAbstractsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IUnreadCntCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.CalendarElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import vh2.cf;
import vh2.cj;
import vh2.ck;

/* compiled from: P */
/* loaded from: classes14.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private final GuildScheduleListFragment f233289a;

    /* renamed from: b, reason: collision with root package name */
    private final AppInterface f233290b;

    /* renamed from: c, reason: collision with root package name */
    private GuildClientParams f233291c;

    /* renamed from: d, reason: collision with root package name */
    private long f233292d = -1;

    /* renamed from: e, reason: collision with root package name */
    private int f233293e = 2;

    /* renamed from: f, reason: collision with root package name */
    private boolean f233294f = false;

    /* renamed from: g, reason: collision with root package name */
    public int f233295g = 0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f233296h = true;

    /* renamed from: i, reason: collision with root package name */
    private String f233297i = "";

    /* renamed from: j, reason: collision with root package name */
    private final py1.a f233298j = new py1.a();

    /* renamed from: k, reason: collision with root package name */
    private final GPServiceObserver f233299k = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a extends GPServiceObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(GuildScheduleInfo guildScheduleInfo) {
            k.this.T(guildScheduleInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(GuildScheduleInfo guildScheduleInfo) {
            k.this.W(guildScheduleInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(GuildScheduleInfo guildScheduleInfo) {
            k.this.U(guildScheduleInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(String str, int i3) {
            k.this.V(str, i3);
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onCreateSchedule(String str, String str2, final GuildScheduleInfo guildScheduleInfo) {
            if (guildScheduleInfo != null && TextUtils.equals(str, k.this.z()) && TextUtils.equals(str2, k.this.w())) {
                k.this.Z(new Runnable() { // from class: com.tencent.mobileqq.guild.schedule.list.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        k.a.this.h(guildScheduleInfo);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onEditSchedule(String str, String str2, final GuildScheduleInfo guildScheduleInfo, int i3) {
            if (guildScheduleInfo != null && TextUtils.equals(str, k.this.z()) && TextUtils.equals(str2, k.this.w())) {
                if (i3 == 2) {
                    k.this.Z(new Runnable() { // from class: com.tencent.mobileqq.guild.schedule.list.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            k.a.this.k(guildScheduleInfo);
                        }
                    });
                } else {
                    k.this.Z(new Runnable() { // from class: com.tencent.mobileqq.guild.schedule.list.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            k.a.this.l(guildScheduleInfo);
                        }
                    });
                }
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onModifyScheduleInviteStatus(String str, String str2, final String str3, final int i3) {
            if (TextUtils.equals(str, k.this.z()) && TextUtils.equals(str2, k.this.w())) {
                k.this.Z(new Runnable() { // from class: com.tencent.mobileqq.guild.schedule.list.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        k.a.this.m(str3, i3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements d {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.schedule.list.k.d
        public void a(String str) {
            k.this.t(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements cj {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ py1.a f233302a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f233303b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f233304c;

        c(py1.a aVar, int i3, boolean z16) {
            this.f233302a = aVar;
            this.f233303b = i3;
            this.f233304c = z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(py1.a aVar, int i3, String str, int i16, ArrayList arrayList, boolean z16) {
            k kVar = k.this;
            kVar.X(aVar, i3, str, i16, kVar.v(arrayList), z16);
        }

        @Override // vh2.cj
        public void onGetScheduleListNew(final int i3, final String str, final ArrayList<cs> arrayList, String str2) {
            String[] strArr = new String[6];
            int i16 = 0;
            strArr[0] = "schedule_list_result_code";
            strArr[1] = String.valueOf(i3);
            strArr[2] = "schedule_list_result_msg";
            strArr[3] = str;
            strArr[4] = "schedule_list_result_size";
            if (arrayList != null) {
                i16 = arrayList.size();
            }
            strArr[5] = String.valueOf(i16);
            ty1.a.b("gpro_quality#event#schedule_channel_list", "schedule_list_schedule_result", ty1.a.e(strArr));
            if (i3 == 0) {
                k.this.f233297i = str2;
            }
            k kVar = k.this;
            final py1.a aVar = this.f233302a;
            final int i17 = this.f233303b;
            final boolean z16 = this.f233304c;
            kVar.Z(new Runnable() { // from class: com.tencent.mobileqq.guild.schedule.list.l
                @Override // java.lang.Runnable
                public final void run() {
                    k.c.this.b(aVar, i3, str, i17, arrayList, z16);
                }
            });
            GuildHomeScheduleViewModel.D2(arrayList, "updateSchedules");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface d {
        void a(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface e {
        void a(boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(GuildScheduleListFragment guildScheduleListFragment, AppInterface appInterface) {
        this.f233289a = guildScheduleListFragment;
        this.f233290b = appInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void G(d dVar, int i3, String str, ArrayList arrayList) {
        if (arrayList != null && arrayList.size() >= 1) {
            ArrayList<MsgAbstractElement> elements = ((MsgAbstract) arrayList.get(0)).getElements();
            if (elements != null && elements.size() >= 1) {
                CalendarElement calendarElement = elements.get(0).getCalendarElement();
                if (calendarElement != null && calendarElement.getExpireTimeMs() >= NetConnInfoCenter.getServerTimeMillis() && !TextUtils.isEmpty(calendarElement.getSchema())) {
                    QLog.i("Guild.sch.ScheduleListPresenter", 1, "schedule schema:" + calendarElement.getSchema());
                    dVar.a(calendarElement.getSchema());
                    return;
                }
                dVar.a(null);
                return;
            }
            dVar.a(null);
            return;
        }
        dVar.a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void H(final d dVar, String str, uh2.c cVar, String str2, int i3, String str3, ArrayList arrayList) {
        if (arrayList != null && arrayList.size() >= 1 && ((GProUnreadCntInfo) arrayList.get(0)).getAllUnreadCnt().getCnt() != 0) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            arrayList2.add(str);
            cVar.getMsgAbstracts(str2, arrayList2, new IGProGuildGetMsgAbstractsCallback() { // from class: com.tencent.mobileqq.guild.schedule.list.e
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildGetMsgAbstractsCallback
                public final void onGetMsgAbstracts(int i16, String str4, ArrayList arrayList3) {
                    k.G(k.d.this, i16, str4, arrayList3);
                }
            });
        } else {
            QLog.i("Guild.sch.ScheduleListPresenter", 1, "schedule had read");
            dVar.a(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(final e eVar, final py1.a aVar, final int i3, final String str, final int i16) {
        Z(new Runnable() { // from class: com.tencent.mobileqq.guild.schedule.list.f
            @Override // java.lang.Runnable
            public final void run() {
                k.this.I(i3, str, i16, eVar, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void K(int i3, String str) {
        QLog.i("Guild.sch.ScheduleListPresenter", 1, "result:" + i3 + ",msg:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void L(uh2.c cVar, GProContact gProContact, int i3, String str, ArrayList arrayList) {
        if (arrayList != null && !arrayList.isEmpty() && ((GProUnreadCntInfo) arrayList.get(0)).getAllUnreadCnt().getCnt() != 0) {
            cVar.setGProMsgRead(gProContact, new IGuildOperateCallback() { // from class: my1.i
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback
                public final void onResult(int i16, String str2) {
                    com.tencent.mobileqq.guild.schedule.list.k.K(i16, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(String str) {
        t(str);
        i0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(int i3, String str, long j3, long j16, ArrayList arrayList) {
        if (i3 != 0) {
            QLog.e("Guild.sch.ScheduleListPresenter", 1, "getSchedulesStatus, code:" + i3 + ", message:" + str);
            return;
        }
        if (!this.f233289a.isAdded()) {
            return;
        }
        this.f233289a.Ki(j3, j16, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(final long j3, final long j16, final int i3, final String str, final ArrayList arrayList) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: my1.k
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.mobileqq.guild.schedule.list.k.this.N(i3, str, j3, j16, arrayList);
            }
        });
    }

    private void P() {
        Bundle arguments = this.f233289a.getArguments();
        if (arguments == null) {
            return;
        }
        this.f233291c = (GuildClientParams) arguments.getParcelable("launch_params");
        s(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public void I(int i3, String str, int i16, e eVar, py1.a aVar) {
        boolean z16;
        if (!this.f233289a.isAdded()) {
            return;
        }
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (eVar != null) {
            eVar.a(z16);
        }
        if (!z16) {
            QLog.e("Guild.sch.ScheduleListPresenter", 1, "createScheduleLimitQuery, code:" + i3 + ", message:" + str);
            QQToastUtil.showQQToast(1, R.string.f155241gz);
            return;
        }
        if (i16 == 2) {
            Calendar calendar = Calendar.getInstance();
            if (aVar.d() < System.currentTimeMillis()) {
                calendar.setTimeInMillis(System.currentTimeMillis());
            } else {
                calendar.set(aVar.f428062a, aVar.f428063b, aVar.f428064c);
            }
            GuildScheduleCreateFragment.wi(this.f233289a.getContext(), this.f233291c, calendar.getTimeInMillis());
            return;
        }
        this.f233289a.Hi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(GuildScheduleInfo guildScheduleInfo) {
        if (!this.f233289a.isAdded()) {
            return;
        }
        this.f233296h = false;
        this.f233293e = 1;
        this.f233292d = guildScheduleInfo.getScheduleId();
        py1.a a16 = py1.a.a(guildScheduleInfo.getStartTimeMs());
        c0(0);
        QLog.i("Guild.sch.ScheduleListPresenter", 1, "cherish onScheduleCreated ..." + this.f233298j.equals(a16));
        if (this.f233298j.equals(a16)) {
            j0(a16);
        } else {
            this.f233298j.f(a16);
            j0(a16);
        }
        l0(a16.f428062a, a16.f428063b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(GuildScheduleInfo guildScheduleInfo) {
        if (!this.f233289a.isAdded()) {
            return;
        }
        this.f233296h = false;
        this.f233289a.Wh(guildScheduleInfo);
        py1.a aVar = this.f233298j;
        l0(aVar.f428062a, aVar.f428063b);
        r(this.f233289a.Zh());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(String str, int i3) {
        if (!this.f233289a.isAdded()) {
            return;
        }
        try {
            this.f233296h = false;
            this.f233289a.mi(Long.parseLong(str), i3);
            py1.a aVar = this.f233298j;
            l0(aVar.f428062a, aVar.f428063b);
        } catch (NumberFormatException unused) {
            QLog.e("Guild.sch.ScheduleListPresenter", 1, "invalidate params, scheduleId:" + str + ", inviteStatus:" + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(GuildScheduleInfo guildScheduleInfo) {
        if (!this.f233289a.isAdded()) {
            return;
        }
        this.f233296h = false;
        this.f233289a.li(guildScheduleInfo);
        py1.a aVar = this.f233298j;
        l0(aVar.f428062a, aVar.f428063b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(py1.a aVar, int i3, String str, int i16, List<GuildScheduleInfo> list, boolean z16) {
        boolean z17;
        if (!this.f233289a.isAdded()) {
            return;
        }
        if (i3 == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            QLog.e("Guild.sch.ScheduleListPresenter", 1, "cherish getScheduleList, code:" + i3 + ", message:" + str);
            this.f233289a.Ji();
            return;
        }
        this.f233289a.Bi(aVar, list);
        if (z16) {
            if (i16 == 0) {
                return;
            }
            if (i16 == 1) {
                this.f233289a.Xh(this.f233292d, aVar);
            } else {
                this.f233289a.Xh(-1L, aVar);
            }
        }
        r(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(Runnable runnable) {
        ThreadManagerV2.getUIHandlerV2().post(runnable);
    }

    private void e0() {
        if (!this.f233296h) {
            this.f233296h = true;
        } else {
            h0();
        }
    }

    private void h0() {
        i0(true);
    }

    private void i0(boolean z16) {
        py1.a ai5 = this.f233289a.ai();
        k0(ai5, z16);
        l0(ai5.f428062a, ai5.f428063b);
    }

    private void r(List<GuildScheduleInfo> list) {
        boolean z16;
        long d16 = new py1.a().d();
        long d17 = new py1.a().d() + 86400000;
        Iterator<GuildScheduleInfo> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                long dateMs = it.next().getDateMs() - d16;
                if (dateMs >= 0 && dateMs < 86400000) {
                    z16 = true;
                    break;
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16 && this.f233289a.ai().d() >= d16 && this.f233289a.ai().d() < d17) {
            this.f233289a.Sh(new py1.a());
        }
    }

    private void s(final d dVar) {
        GuildClientParams guildClientParams = this.f233291c;
        if (guildClientParams != null && !TextUtils.isEmpty(guildClientParams.G()) && !TextUtils.isEmpty(this.f233291c.u())) {
            final String G = this.f233291c.G();
            final String u16 = this.f233291c.u();
            final uh2.c gProGuildMsgService = ((IGProSession) this.f233290b.getRuntimeService(IGProSession.class, "all")).getGProGuildMsgService();
            gProGuildMsgService.G(new GProContact(4, u16, G), new IUnreadCntCallback() { // from class: com.tencent.mobileqq.guild.schedule.list.d
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IUnreadCntCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    k.H(k.d.this, u16, gProGuildMsgService, G, i3, str, arrayList);
                }
            });
            return;
        }
        dVar.a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str) {
        if (TextUtils.isEmpty(str)) {
            GuildClientParams guildClientParams = this.f233291c;
            if (guildClientParams == null) {
                str = null;
            } else {
                str = guildClientParams.V();
            }
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                Uri parse = Uri.parse(str);
                long d16 = az.d(parse.getQueryParameter("schedule_id"), -1L);
                long d17 = az.d(parse.getQueryParameter("starttimems"), 0L);
                long d18 = new py1.a().d();
                if (d17 >= d18) {
                    this.f233293e = 1;
                    this.f233292d = d16;
                    this.f233298j.g(d17);
                } else {
                    this.f233293e = 2;
                    this.f233292d = -1L;
                    this.f233298j.g(d18);
                }
            } catch (Exception e16) {
                QLog.e("Guild.sch.ScheduleListPresenter", 1, e16, new Object[0]);
                this.f233293e = 2;
                this.f233292d = -1L;
                this.f233298j.f(new py1.a());
            }
        }
    }

    private IGPSService y() {
        return (IGPSService) this.f233290b.getRuntimeService(IGPSService.class, "");
    }

    public String A() {
        if (this.f233291c == null) {
            return "";
        }
        return Y();
    }

    public py1.a B() {
        return this.f233298j;
    }

    public GuildClientParams C() {
        return this.f233291c;
    }

    public int D() {
        return this.f233295g;
    }

    public boolean E() {
        return this.f233294f;
    }

    public boolean F() {
        boolean h06 = ch.h0(w());
        boolean isCurrentGuildManager = ((IQQGuildService) this.f233290b.getRuntimeService(IQQGuildService.class, "")).isCurrentGuildManager(this.f233290b, z());
        boolean i3 = as.i(z(), w(), 30005);
        if (!isCurrentGuildManager && !h06 && !i3) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q() {
        P();
        y().addObserver(this.f233299k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S() {
        y().deleteObserver(this.f233299k);
    }

    public String Y() {
        IGProGuildInfo guildInfo;
        if (this.f233291c.G() == null || (guildInfo = ((IGPSService) ch.R0(IGPSService.class)).getGuildInfo(this.f233291c.G())) == null || guildInfo.getGuildName() == null) {
            return "";
        }
        return guildInfo.getGuildName();
    }

    public void a0() {
        GuildClientParams guildClientParams = this.f233291c;
        if (guildClientParams != null && !TextUtils.isEmpty(guildClientParams.u()) && !TextUtils.isEmpty(this.f233291c.G())) {
            String G = this.f233291c.G();
            String u16 = this.f233291c.u();
            final uh2.c gProGuildMsgService = ((IGProSession) this.f233290b.getRuntimeService(IGProSession.class, "all")).getGProGuildMsgService();
            if (gProGuildMsgService == null) {
                return;
            }
            final GProContact gProContact = new GProContact(4, u16, G);
            gProGuildMsgService.G(gProContact, new IUnreadCntCallback() { // from class: my1.h
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IUnreadCntCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    com.tencent.mobileqq.guild.schedule.list.k.L(uh2.c.this, gProContact, i3, str, arrayList);
                }
            });
        }
    }

    public void b0(boolean z16) {
        this.f233294f = z16;
    }

    public void c0(int i3) {
        this.f233295g = i3;
    }

    public void d0(int i3) {
        this.f233293e = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f0(boolean z16) {
        if (z16) {
            c0(0);
            g0();
        } else {
            e0();
        }
    }

    void g0() {
        this.f233296h = true;
        s(new d() { // from class: com.tencent.mobileqq.guild.schedule.list.b
            @Override // com.tencent.mobileqq.guild.schedule.list.k.d
            public final void a(String str) {
                k.this.M(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j0(py1.a aVar) {
        k0(aVar, true);
    }

    @SuppressLint({"WrongConstant"})
    void k0(py1.a aVar, boolean z16) {
        QLog.d("Guild.sch.ScheduleListPresenter", 1, "kevinbao updateSchedules, GuildCalendarDate date:" + aVar);
        int i3 = this.f233295g;
        int i16 = this.f233293e;
        if (aVar == null) {
            return;
        }
        if ("".equals(this.f233297i) && i3 != 0) {
            QLog.i("Guild.sch.ScheduleListPresenter", 1, "cherish updateSchedules " + i3);
            return;
        }
        if (!this.f233298j.equals(aVar)) {
            this.f233298j.f(aVar);
        }
        String z17 = z();
        String w3 = w();
        IGPSService y16 = y();
        long d16 = aVar.d();
        ty1.a.b("gpro_quality#event#schedule_channel_list", "schedule_list_request_schedule", ty1.a.e("guild_id", z17, "channel_id", w3, "schedule_list_param_type", String.valueOf(i3), "schedule_list_param_time", String.valueOf(d16)));
        QLog.i("Guild.sch.ScheduleListPresenter", 1, "[onGetScheduleListNew] time = " + d16 + ", type = " + i3);
        y16.getScheduleListNew(z17, w3, i3, d16, this.f233297i, new c(aVar, i16, z16));
        QLog.i("Guild.sch.ScheduleListPresenter", 1, "updateSchedules, guildId:" + z17 + ", channelId:" + w3 + ", year:" + aVar.f428062a + ", month:" + (aVar.f428063b + 1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l0(int i3, int i16) {
        if (this.f233291c == null) {
            QLog.e("Guild.sch.ScheduleListPresenter", 1, "updateStatuses, params can not be null.");
            return;
        }
        py1.b<Long> Yh = this.f233289a.Yh(i3, i16);
        final long longValue = Yh.a().longValue();
        final long longValue2 = Yh.b().longValue();
        String G = this.f233291c.G();
        String u16 = this.f233291c.u();
        y().getSchedulesStatus(G, u16, longValue, longValue2, new ck() { // from class: my1.j
            @Override // vh2.ck
            public final void onGetSchedulesStatus(int i17, String str, ArrayList arrayList) {
                com.tencent.mobileqq.guild.schedule.list.k.this.O(longValue, longValue2, i17, str, arrayList);
            }
        });
        QLog.i("Guild.sch.ScheduleListPresenter", 1, "updateStatuses, guildId:" + G + ", channelId:" + u16 + ", year:" + i3 + ", month:" + (i16 + 1));
    }

    public void u(final e eVar, final py1.a aVar) {
        y().createScheduleLimitQuery(z(), new cf() { // from class: com.tencent.mobileqq.guild.schedule.list.c
            @Override // vh2.cf
            public final void onCreateScheduleLimitQuery(int i3, String str, int i16) {
                k.this.J(eVar, aVar, i3, str, i16);
            }
        });
    }

    List<GuildScheduleInfo> v(ArrayList<cs> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<cs> it = arrayList.iterator();
        while (it.hasNext()) {
            cs next = it.next();
            Iterator<ct> it5 = next.b().iterator();
            while (it5.hasNext()) {
                GuildScheduleInfo a16 = it5.next().a();
                a16.setDateMs(next.a());
                arrayList2.add(a16);
            }
        }
        return arrayList2;
    }

    public String w() {
        GuildClientParams guildClientParams = this.f233291c;
        if (guildClientParams == null) {
            return "";
        }
        return guildClientParams.u();
    }

    public IGProChannelInfo x() {
        if (TextUtils.isEmpty(w())) {
            return null;
        }
        return y().getChannelInfo(w());
    }

    public String z() {
        GuildClientParams guildClientParams = this.f233291c;
        if (guildClientParams == null) {
            return "";
        }
        return guildClientParams.G();
    }
}
