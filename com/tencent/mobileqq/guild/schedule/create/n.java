package com.tencent.mobileqq.guild.schedule.create;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.schedule.create.selectchannel.GuildScheduleSelectChannelDialogFragment;
import com.tencent.mobileqq.guild.schedule.create.selectremindertype.GuildScheduleSelectReminderTypeDialogFragment;
import com.tencent.mobileqq.guild.util.aa;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo;
import com.tencent.qphone.base.util.QLog;
import vh2.ce;
import vh2.cg;

/* compiled from: P */
/* loaded from: classes14.dex */
public class n extends com.tencent.mobileqq.mvvm.c<l> {
    private final MutableLiveData<Long> C;
    private final MutableLiveData<Long> D;
    private final MutableLiveData<Integer> E;
    private final MutableLiveData<GuildScheduleChannelInfo> F;
    private final MutableLiveData<Boolean> G;
    private String H;
    private String I;
    private IGProChannelInfo J;
    private IGPSService K;
    private long L;
    private boolean M;
    private int N;
    private boolean P;
    private long Q;

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<String> f233092i;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<String> f233093m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements ce {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f233094a;

        a(f fVar) {
            this.f233094a = fVar;
        }

        @Override // vh2.ce
        public void a(int i3, String str, GuildScheduleInfo guildScheduleInfo) {
            this.f233094a.a(true, i3, str, guildScheduleInfo);
            n.this.Q = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements cg {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f233096a;

        b(f fVar) {
            this.f233096a = fVar;
        }

        @Override // vh2.cg
        public void a(int i3, String str, GuildScheduleInfo guildScheduleInfo) {
            this.f233096a.a(false, i3, str, guildScheduleInfo);
            n.this.Q = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements ky1.a {
        c() {
        }

        @Override // ky1.a
        public void a(lf1.a aVar) {
            String aVar2;
            if (aVar == null) {
                aVar2 = "";
            } else {
                aVar2 = aVar.toString();
            }
            ty1.a.b("gpro_quality#event#schedule_channel_publish", "schedule_publish_st_channel_picked", ty1.a.e("schedule_publish_start_channel", aVar2));
            n.this.m2(n.this.T1(aVar));
            n.this.P = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class d implements ly1.a {
        d() {
        }

        @Override // ly1.a
        public void a(boolean z16, int i3) {
            if (z16) {
                ty1.a.b("gpro_quality#event#schedule_channel_publish", "schedule_publish_notice_picked", ty1.a.e("schedule_publish_notice", String.valueOf(i3)));
                n.this.o2(i3);
                n.this.P = true;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class e implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        private final AppInterface f233100a;

        public e(AppInterface appInterface) {
            this.f233100a = appInterface;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new n(new l(this.f233100a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface f {
        void a(boolean z16, int i3, String str, GuildScheduleInfo guildScheduleInfo);
    }

    public n(l lVar) {
        super(lVar);
        this.f233092i = new MutableLiveData<>();
        this.f233093m = new MutableLiveData<>();
        this.C = new MutableLiveData<>();
        this.D = new MutableLiveData<>();
        this.E = new MutableLiveData<>();
        this.F = new MutableLiveData<>();
        this.G = new MutableLiveData<>();
        this.N = 0;
        this.P = false;
    }

    private void P1() {
        if (!TextUtils.isEmpty(this.f233092i.getValue()) && !TextUtils.isEmpty(this.f233092i.getValue().trim())) {
            if (this.C.getValue() != null && this.C.getValue().longValue() != 0) {
                if (this.D.getValue() != null && this.D.getValue().longValue() != 0) {
                    this.G.setValue(Boolean.TRUE);
                    return;
                } else {
                    this.G.setValue(Boolean.FALSE);
                    return;
                }
            }
            this.G.setValue(Boolean.FALSE);
            return;
        }
        this.G.setValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GuildScheduleChannelInfo T1(lf1.a aVar) {
        if (aVar != null && aVar.f414445c != null) {
            return new GuildScheduleChannelInfo.a().h(Long.parseLong(aVar.f414445c.getChannelUin())).m(aVar.f414445c.getType()).j(Long.parseLong(aVar.f414445c.getGuildId())).i(aVar.f414445c.getChannelName()).g();
        }
        return new GuildScheduleChannelInfo();
    }

    private boolean i2() {
        if (!TextUtils.isEmpty(this.f233092i.getValue()) && !TextUtils.isEmpty(this.f233092i.getValue().trim())) {
            if (this.C.getValue() == null) {
                aa.g("\u65e5\u7a0b\u5f00\u59cb\u65f6\u95f4\u672a\u9009\u62e9");
                return false;
            }
            if (!m.g(this.C.getValue().longValue())) {
                aa.g("\u5f00\u59cb\u65f6\u95f4\u4e0d\u80fd\u65e9\u4e8e\u5f53\u524d\u65f6\u95f4\u3002");
                return false;
            }
            if (this.E.getValue() != null && !m.h(this.C.getValue().longValue(), this.E.getValue().intValue())) {
                aa.g("\u63d0\u9192\u65f6\u95f4\u4e0d\u80fd\u65e9\u4e8e\u5f53\u524d\u65f6\u95f4\u3002");
                return false;
            }
            if (this.D.getValue() == null) {
                aa.g("\u65e5\u7a0b\u7ed3\u675f\u65f6\u95f4\u672a\u9009\u62e9");
                return false;
            }
            int f16 = m.f(this.C.getValue().longValue(), this.D.getValue().longValue());
            if (f16 != 0) {
                if (f16 < 0) {
                    aa.g("\u7ed3\u675f\u65f6\u95f4\u4e0d\u80fd\u65e9\u4e8e\u5f00\u59cb\u65f6\u95f4\u3002");
                } else if (f16 > 0) {
                    aa.g("\u65e5\u7a0b\u6301\u7eed\u65f6\u95f4\u8d85\u8fc77\u5929\uff0c\u8bf7\u91cd\u65b0\u9009\u62e9\u3002");
                }
                return false;
            }
            return true;
        }
        aa.g("\u65e5\u7a0b\u540d\u5b57\u4e3a\u7a7a");
        return false;
    }

    public void O1() {
        this.N++;
    }

    public void Q1() {
        this.N = 0;
    }

    public boolean R1(int i3) {
        if (this.N < i3) {
            return true;
        }
        return false;
    }

    public void S1(f fVar) {
        String str;
        long j3;
        int i3;
        long j16 = 0;
        if (this.Q > 0 && System.currentTimeMillis() - this.Q < 1000) {
            return;
        }
        if (!i2()) {
            QLog.i("Guild.sch.GuildScheduleCreateView", 1, "createSchedule params invalid");
            return;
        }
        this.Q = System.currentTimeMillis();
        GuildScheduleChannelInfo value = this.F.getValue();
        if (value == null) {
            value = new GuildScheduleChannelInfo();
        }
        String str2 = "";
        if (this.f233092i.getValue() == null) {
            str = "";
        } else {
            str = this.f233092i.getValue().trim();
        }
        if (this.f233093m.getValue() != null) {
            str2 = this.f233093m.getValue();
        }
        if (this.C.getValue() != null) {
            j3 = this.C.getValue().longValue();
        } else {
            j3 = 0;
        }
        if (this.D.getValue() != null) {
            j16 = this.D.getValue().longValue();
        }
        if (this.E.getValue() != null) {
            i3 = this.E.getValue().intValue();
        } else {
            i3 = 0;
        }
        GuildScheduleInfo y16 = new GuildScheduleInfo.a().K(this.L).R(str).A(str2).Q(j3).E(j16).J(i3).z(value).y();
        if (this.M) {
            getRepository().j(this.H, this.I, y16, new a(fVar));
        } else {
            getRepository().l(this.H, this.I, y16, new b(fVar));
        }
    }

    public String U1() {
        return this.I;
    }

    public String W1() {
        ly1.b a16;
        if (this.E.getValue() == null || (a16 = ly1.b.a(this.E.getValue().intValue())) == null) {
            return "null";
        }
        return a16.b();
    }

    public MutableLiveData<Boolean> X1() {
        return this.G;
    }

    public LiveData<String> Z1() {
        return this.f233093m;
    }

    public LiveData<Long> a2() {
        return this.D;
    }

    public LiveData<GuildScheduleChannelInfo> b2() {
        return this.F;
    }

    public LiveData<String> c2() {
        return this.f233092i;
    }

    public LiveData<Integer> d2() {
        return this.E;
    }

    public LiveData<Long> e2() {
        return this.C;
    }

    public void f2(String str, String str2, long j3, boolean z16) {
        this.H = str;
        this.I = str2;
        this.L = j3;
        this.M = z16;
        IGPSService iGPSService = (IGPSService) ((l) this.mRepository).k().getRuntimeService(IGPSService.class, "");
        this.K = iGPSService;
        this.J = iGPSService.getChannelInfo(this.I);
    }

    public boolean g2() {
        return this.M;
    }

    public long getAppId() {
        IGProAppChnnPreInfo appChnnPreInfo = this.K.getAppChnnPreInfo(this.J.getGuildId(), this.J.getChannelUin());
        if (appChnnPreInfo != null) {
            return appChnnPreInfo.getAppid();
        }
        return 0L;
    }

    public IGProChannelInfo getChannelInfo() {
        return this.J;
    }

    public int getChannelType() {
        return this.J.getType();
    }

    public String getGuildId() {
        return this.H;
    }

    public boolean h2() {
        return this.P;
    }

    public void j2(boolean z16) {
        this.P = z16;
    }

    public void k2(String str) {
        this.f233093m.setValue(str);
    }

    public void l2(long j3) {
        this.D.setValue(Long.valueOf(j3));
        P1();
    }

    public void m2(GuildScheduleChannelInfo guildScheduleChannelInfo) {
        this.F.setValue(guildScheduleChannelInfo);
    }

    public void n2(String str) {
        this.f233092i.setValue(str);
        P1();
    }

    public void o2(int i3) {
        this.E.setValue(Integer.valueOf(i3));
    }

    public void p2(long j3) {
        this.C.setValue(Long.valueOf(j3));
        P1();
    }

    public void q2(Fragment fragment) {
        int i3;
        if (this.E.getValue() != null) {
            i3 = this.E.getValue().intValue();
        } else {
            i3 = 0;
        }
        GuildScheduleSelectReminderTypeDialogFragment.zh(fragment, i3, new d());
    }

    public void r2(Fragment fragment) {
        GuildScheduleSelectChannelDialogFragment.yh(fragment, this.H, new c());
    }
}
