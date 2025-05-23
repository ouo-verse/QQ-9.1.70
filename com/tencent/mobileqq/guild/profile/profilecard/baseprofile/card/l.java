package com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.l;
import com.tencent.mobileqq.guild.rolegroup.model.data.GuildTarget;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.r;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import vh2.bz;

/* compiled from: P */
/* loaded from: classes14.dex */
public class l extends com.tencent.mobileqq.mvvm.c<wy1.a> {
    public static ViewModelProvider.Factory I = new a();
    private cn<GuildProfileData> C;
    private cn<com.tencent.mobileqq.qqguildsdk.data.k> D;
    private cn<Long> E;
    private BroadcastReceiver F;
    private GuildProfileData G;
    private GPServiceObserver H;

    /* renamed from: i, reason: collision with root package name */
    private cn<Boolean> f231371i;

    /* renamed from: m, reason: collision with root package name */
    private cn<com.tencent.mobileqq.guild.profile.profilecard.main.l> f231372m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements ViewModelProvider.Factory {
        a() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new l(new wy1.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action)) {
                return;
            }
            QLog.i("Guild.profile.GuildProfileCardViewModel", 1, "qqAccountReceiver onReceive= " + action);
            l.this.R1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c extends GPServiceObserver {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onUserProfileInfoUpdate(int i3, String str, String str2, String str3, ev evVar) {
            if (TextUtils.equals(l.this.G.getDstTinyId(), str3) && TextUtils.equals(l.this.G.getGuildId(), str2)) {
                QLog.i("Guild.profile.GuildProfileCardViewModel", 1, "loadByNet(: " + str2 + ", " + str3 + "): " + i3 + " - " + str);
                if (i3 == 0) {
                    l.this.l2(evVar);
                    return;
                }
                l.this.f231372m.setValue(new com.tencent.mobileqq.guild.profile.profilecard.main.l(i3, str, null));
                l.this.R1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface d {
        void a(int i3, String str, ev evVar);
    }

    public l(wy1.a aVar) {
        super(aVar);
        this.f231371i = new cn<>();
        this.f231372m = new cn<>();
        this.C = new cn<>();
        this.D = new cn<>();
        this.E = new cn<>();
    }

    private GPServiceObserver S1() {
        return new c();
    }

    private void T1(String str, String str2) {
        if (!NetworkUtil.isNetworkAvailable()) {
            R1();
        } else {
            ((IGPSService) ch.R0(IGPSService.class)).refreshGuildUserProfileInfo(str, str2);
        }
    }

    private boolean b2(ev evVar) {
        if (evVar.getIsMember() == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d2(GuildProfileData guildProfileData, int i3, String str, ev evVar) {
        QLog.i("Guild.profile.GuildProfileCardViewModel", 1, "loadByDB(: " + this.G.getGuildId() + ", " + this.G.getDstTinyId() + "): " + i3 + " - " + str);
        if (i3 == 0 && evVar != null && evVar.isValid()) {
            l2(evVar);
            T1(this.G.getGuildId(), this.G.getDstTinyId());
        } else {
            r.p().n(GuildTarget.e(guildProfileData.getGuildBaseProfileData().e()), guildProfileData.getGuildBaseProfileData().b(), new com.tencent.mobileqq.guild.base.repository.h() { // from class: com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.k
                @Override // com.tencent.mobileqq.guild.base.repository.h
                public final void a(ri1.a aVar, Object obj) {
                    l.c2(aVar, (List) obj);
                }
            });
            T1(this.G.getGuildId(), this.G.getDstTinyId());
        }
    }

    private void i2(GuildProfileData guildProfileData, AppRuntime appRuntime, final d dVar) {
        if (QLog.isColorLevel()) {
            QLog.i("Guild.profile.GuildProfileCardViewModel", 1, "GuildProfileData: " + guildProfileData.toString());
        }
        IGPSService iGPSService = (IGPSService) appRuntime.getRuntimeService(IGPSService.class, "");
        String e16 = guildProfileData.getGuildBaseProfileData().e();
        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(e16);
        if (guildInfo != null) {
            guildProfileData.getGuildBaseProfileData().D(guildInfo.getUserType());
        }
        guildProfileData.getGuildBaseProfileData().C(iGPSService.getSelfTinyId());
        iGPSService.loadGProUserProfileInfo(e16, guildProfileData.getGuildBaseProfileData().b(), new bz() { // from class: com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.j
            @Override // vh2.bz
            public final void a(int i3, String str, ev evVar) {
                l.d.this.a(i3, str, evVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l2(ev evVar) {
        this.G.setUserProfileInfo(evVar);
        GuildBaseProfileData guildBaseProfileData = this.G.getGuildBaseProfileData();
        guildBaseProfileData.t(evVar.getUserType());
        guildBaseProfileData.x(b2(evVar));
        guildBaseProfileData.w(evVar.n());
        this.C.setValue(this.G);
    }

    public void R1() {
        this.f231371i.setValue(Boolean.TRUE);
    }

    public cn<Boolean> U1() {
        return this.f231371i;
    }

    public cn<com.tencent.mobileqq.qqguildsdk.data.k> W1() {
        return this.D;
    }

    public cn<Long> X1() {
        return this.E;
    }

    public cn<com.tencent.mobileqq.guild.profile.profilecard.main.l> Z1() {
        return this.f231372m;
    }

    public cn<GuildProfileData> a2() {
        return this.C;
    }

    public void f2(final GuildProfileData guildProfileData) {
        this.G = guildProfileData;
        if (this.H == null) {
            this.H = S1();
            ((IGPSService) ch.R0(IGPSService.class)).addObserver(this.H);
        }
        i2(guildProfileData, MobileQQ.sMobileQQ.peekAppRuntime(), new d() { // from class: com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.i
            @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.l.d
            public final void a(int i3, String str, ev evVar) {
                l.this.d2(guildProfileData, i3, str, evVar);
            }
        });
    }

    public void g2(Context context) {
        if (this.F == null) {
            this.F = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
            intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
            intentFilter.addAction(NewIntent.ACTION_ACCOUNT_EXPIRED);
            intentFilter.addAction(NewIntent.ACTION_FORCE_LOGOUT);
            intentFilter.addAction(NewIntent.ACTION_LOGOUT);
            intentFilter.addAction("mqq.intent.action.EXIT_" + BaseApplication.getContext().getPackageName());
            intentFilter.addAction(AppConstants.QQ_KICKED_LOGIN_OTHER_DEVICE);
            context.registerReceiver(this.F, intentFilter);
        }
    }

    public void h2(Context context) {
        BroadcastReceiver broadcastReceiver = this.F;
        if (broadcastReceiver != null) {
            context.unregisterReceiver(broadcastReceiver);
            this.F = null;
        }
        if (this.H != null) {
            ((IGPSService) ch.R0(IGPSService.class)).deleteObserver(this.H);
            this.H = null;
        }
    }

    public void j2(com.tencent.mobileqq.qqguildsdk.data.k kVar) {
        this.D.setValue(kVar);
    }

    public void k2() {
        String tinyId = this.G.getUserProfileInfo().getTinyId();
        try {
            this.E.setValue(Long.valueOf(Long.parseLong(tinyId)));
            R1();
        } catch (NumberFormatException unused) {
            QLog.e("Guild.profile.GuildProfileCardViewModel", 1, "sendOpenGiftPanelEvent NumberFormatException," + tinyId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c2(ri1.a aVar, List list) {
    }
}
