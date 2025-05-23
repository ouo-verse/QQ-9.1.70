package g02;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.profile.profilecard.main.l;
import com.tencent.mobileqq.guild.util.al;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildActiveValue;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import com.tencent.util.NumberUtil;
import com.tencent.util.QQToastUtil;
import mqq.util.WeakReference;
import or1.c;
import uu1.MissionModel;
import wh2.df;
import wh2.dv;

/* compiled from: P */
/* loaded from: classes14.dex */
public class g extends com.tencent.mobileqq.mvvm.c<wy1.a> implements com.tencent.mobileqq.guild.base.repository.a {
    public static ViewModelProvider.Factory R = new a();
    private String C;
    private IGProGuildInfo D;
    private final MutableLiveData<IGProGuildInfo> E;
    private c.a F;
    private MutableLiveData<String> G;
    private cn<Boolean> H;
    private cn<String> I;
    private cn<String> J;
    private cn<String> K;
    private cn<l> L;
    private MutableLiveData<MissionModel> M;
    private cn<Object> N;
    private cn<Boolean> P;
    private final dz1.a Q;

    /* renamed from: i, reason: collision with root package name */
    private final GPServiceObserver f401030i;

    /* renamed from: m, reason: collision with root package name */
    private final uu1.f f401031m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements ViewModelProvider.Factory {
        a() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new g(new wy1.a());
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b extends GPServiceObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserDisplayNameUpdate(String str) {
            String guildID = g.this.D.getGuildID();
            if (!TextUtils.isEmpty(g.this.C) && !TextUtils.isEmpty(guildID)) {
                if (g.this.C.equals(str)) {
                    String guildUserDisplayNameInternal = ((IGPSService) ch.R0(IGPSService.class)).getGuildUserDisplayNameInternal(guildID, g.this.C);
                    if (QLog.isColorLevel()) {
                        QLog.d("GuildMainSettingViewModel", 2, String.format("onUserDisplayNameUpdate displayName=%s", cq.w(guildUserDisplayNameInternal, 2)));
                    }
                    g.this.G.setValue(guildUserDisplayNameInternal);
                    return;
                }
                return;
            }
            QLog.e("GuildMainSettingViewModel", 2, String.format("onUserDisplayNameUpdate mSelfTid=%s, mGuildId=%s", g.this.C, guildID));
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class c implements uu1.f {
        c() {
        }

        @Override // uu1.f
        public void a(MissionModel missionModel) {
            if (g.this.D.getGuildID().equals(missionModel.getGuildId())) {
                g.this.M.setValue(missionModel);
                QLog.i("GuildMainSettingViewModel", 1, "onMissionUpdate");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class d implements c.a {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<g> f401034a;

        public d(g gVar) {
            this.f401034a = new WeakReference<>(gVar);
        }
    }

    public g(wy1.a aVar) {
        super(aVar);
        this.f401030i = new b();
        this.f401031m = new c();
        this.E = new MutableLiveData<>();
        this.G = new MutableLiveData<>();
        this.H = new cn<>();
        this.I = new cn<>();
        this.J = new cn<>();
        this.K = new cn<>();
        this.L = new cn<>();
        this.M = new MutableLiveData<>();
        this.N = new cn<>();
        this.P = new cn<>();
        this.Q = new dz1.a() { // from class: g02.c
        };
    }

    private void X1() {
        j2();
        ((IGPSService) ch.R0(IGPSService.class)).fetchGuildActiveValue(NumberUtil.stringToLong(this.D.getGuildID()), new df() { // from class: g02.f
            @Override // wh2.df
            public final void a(int i3, String str, IGProGuildActiveValue iGProGuildActiveValue) {
                g.this.g2(i3, str, iGProGuildActiveValue);
            }
        });
    }

    private String Z1(IGProGuildActiveValue iGProGuildActiveValue) {
        StringBuilder sb5 = new StringBuilder();
        if (iGProGuildActiveValue != null) {
            sb5.append("getTotalGuildActive: ");
            sb5.append(iGProGuildActiveValue.getTotalGuildActive());
            sb5.append(", getGuildTodayAddActive: ");
            sb5.append(iGProGuildActiveValue.getTotalGuildActive());
            sb5.append(", getMyTodayActive: ");
            sb5.append(iGProGuildActiveValue.getMyTodayActive());
        }
        return sb5.toString();
    }

    private int a2(int i3) {
        return Math.max(i3, 0);
    }

    private long b2(long j3) {
        return Math.max(j3, 0L);
    }

    private void d2() {
        if (this.D.getUserType() == 2) {
            uu1.e.e(this.f401031m);
            MissionModel f16 = uu1.e.f(this.D.getGuildID());
            if (f16 != null) {
                this.M.setValue(f16);
                QLog.i("GuildMainSettingViewModel", 1, "initMission");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e2() {
        QQToastUtil.showQQToast(2, HardCodeUtil.qqStr(R.string.f143140l_));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f2(int i3, String str, IGProSecurityResult iGProSecurityResult) {
        boolean z16 = true;
        QLog.i("GuildMainSettingViewModel", 1, "destroyGuild failed result: " + i3 + ", msg: " + str);
        if (i3 != 0) {
            z16 = false;
        }
        if (z16) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: g02.b
                @Override // java.lang.Runnable
                public final void run() {
                    g.e2();
                }
            }, 200L);
            this.H.setValue(Boolean.TRUE);
        } else {
            l lVar = new l();
            lVar.f(i3);
            lVar.h(str);
            this.L.setValue(lVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g2(int i3, String str, IGProGuildActiveValue iGProGuildActiveValue) {
        if (QLog.isColorLevel()) {
            QLog.i("GuildMainSettingViewModel", 2, "fetchGuildActiveValue result " + i3 + ",errMsg: " + str + ",value: " + Z1(iGProGuildActiveValue));
        }
        if (i3 == 0 && iGProGuildActiveValue != null) {
            int userType = this.D.getUserType();
            if (userType != 2 && userType != 1) {
                this.K.setValue(al.a(a2(iGProGuildActiveValue.getMyTodayActive())));
                return;
            } else {
                this.I.setValue(al.a(b2(iGProGuildActiveValue.getTotalGuildActive())));
                this.J.setValue(al.a(a2(iGProGuildActiveValue.getGuildTodayAddActive())));
                return;
            }
        }
        QLog.i("GuildMainSettingViewModel", 1, "fetchGuildActiveValue failed result " + i3 + ",errMsg: " + str + ",value: " + Z1(iGProGuildActiveValue));
        j2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h2(boolean z16) {
        this.P.setValue(Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i2(dz1.c cVar, boolean z16) {
        QLog.i("GuildMainSettingViewModel", 1, "shouldShowBindGameRedPoint " + z16);
        cVar.a(z16);
    }

    private void j2() {
        int userType = this.D.getUserType();
        if (userType != 2 && userType != 1) {
            this.K.setValue("0");
        } else {
            this.I.setValue("0");
            this.J.setValue("0");
        }
    }

    private void k2(final dz1.c cVar) {
        dz1.b.h(this.D.getGuildID(), new dz1.c() { // from class: g02.e
            @Override // dz1.c
            public final void a(boolean z16) {
                g.i2(dz1.c.this, z16);
            }
        });
    }

    private void removeObserver() {
        uu1.e.r(this.f401031m);
        ((IGPSService) ch.R0(IGPSService.class)).deleteObserver(this.f401030i);
        or1.c.d(this.F);
        dz1.b.g(this.Q);
    }

    public void U1() {
        ((IGPSService) ch.R0(IGPSService.class)).destroyGuild(this.D.getGuildID(), new dv() { // from class: g02.a
            @Override // wh2.dv
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                g.this.f2(i3, str, iGProSecurityResult);
            }
        });
    }

    public cn<Boolean> W1() {
        return this.H;
    }

    public void c2(IGProGuildInfo iGProGuildInfo) {
        if (iGProGuildInfo == null) {
            QLog.w("GuildMainSettingViewModel", 2, "guildInfo is null!");
            return;
        }
        this.D = iGProGuildInfo;
        this.E.setValue(iGProGuildInfo);
        IGPSService iGPSService = (IGPSService) ch.S0(IGPSService.class, "");
        this.C = iGPSService.getSelfTinyId();
        iGPSService.addObserver(this.f401030i);
        d2();
        d dVar = new d(this);
        this.F = dVar;
        or1.c.b(dVar);
        k2(new dz1.c() { // from class: g02.d
            @Override // dz1.c
            public final void a(boolean z16) {
                g.this.h2(z16);
            }
        });
        X1();
        dz1.b.e(this.Q);
    }

    public cn<l> l2() {
        return this.L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mvvm.c, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        removeObserver();
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(String str) {
    }
}
