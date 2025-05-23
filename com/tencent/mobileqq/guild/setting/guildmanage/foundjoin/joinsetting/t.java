package com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.GWGProJoinGuildChoiceQuestion;
import com.tencent.mobileqq.qqguildsdk.data.genc.GWGProJoinGuildWordQuestion;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchJoinGuildOptionRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildSetting;
import com.tencent.mobileqq.qqguildsdk.data.genc.au;
import com.tencent.mobileqq.qqguildsdk.data.genc.el;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import wh2.ar;
import wh2.dv;

/* compiled from: P */
/* loaded from: classes14.dex */
public class t extends com.tencent.mobileqq.mvvm.c<wy1.a> {
    public static ViewModelProvider.Factory H = new a();
    private cn<cf1.a> C;
    private cn<Boolean> D;
    private IGProJoinGuildSetting E;
    private GuildJoinEditData F;
    private String G;

    /* renamed from: i, reason: collision with root package name */
    private MutableLiveData<GuildJoinEditData> f233918i;

    /* renamed from: m, reason: collision with root package name */
    private MutableLiveData<Boolean> f233919m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements ViewModelProvider.Factory {
        a() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new t(new wy1.a());
        }
    }

    public t(wy1.a aVar) {
        super(aVar);
        this.f233918i = new MutableLiveData<>();
        this.f233919m = new MutableLiveData<>();
        this.C = new cn<>();
        this.D = new cn<>();
        this.G = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U1(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProFetchJoinGuildOptionRsp iGProFetchJoinGuildOptionRsp) {
        if (i3 == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("Guild.mnr.JoinGuildSettingViewModel", 4, "onFetchJoinGuildOption " + iGProFetchJoinGuildOptionRsp.toString());
            }
            IGProJoinGuildSetting settingInfo = iGProFetchJoinGuildOptionRsp.getSettingInfo();
            this.E = settingInfo;
            GuildJoinEditData b16 = GuildJoinEditData.b(settingInfo);
            this.F = b16;
            this.f233918i.setValue(b16);
            this.f233919m.setValue(Boolean.valueOf(this.F.a()));
            this.D.setValue(Boolean.FALSE);
            return;
        }
        QLog.w("Guild.mnr.JoinGuildSettingViewModel", 1, "onFetchJoinGuildOption failed " + i3);
        this.C.setValue(new cf1.a(i3, str));
        this.f233918i.setValue(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W1(int i3, String str, IGProSecurityResult iGProSecurityResult) {
        if (i3 == 0 && ch.p(iGProSecurityResult)) {
            this.C.setValue(new cf1.a(i3, MobileQQ.sMobileQQ.getApplicationContext().getResources().getString(R.string.f156431k7), iGProSecurityResult));
            this.D.setValue(Boolean.TRUE);
        } else {
            this.C.setValue(new cf1.a(i3, str, iGProSecurityResult));
        }
        QLog.d("Guild.mnr.JoinGuildSettingViewModel", QLog._DEFAULT_REPORTLOG_LEVEL, "setJoinGuildOption_rsp", Integer.valueOf(i3), " ", str, " ", this.F);
    }

    public LiveData<Boolean> N1() {
        return this.D;
    }

    public LiveData<GuildJoinEditData> O1() {
        return this.f233918i;
    }

    public LiveData<Boolean> P1() {
        return this.f233919m;
    }

    public LiveData<cf1.a> Q1() {
        return this.C;
    }

    public void R1(int i3, String str) {
        if (this.F == null) {
            this.F = new GuildJoinEditData(i3);
        }
        this.F.k(i3);
        this.F.l(str);
        this.f233918i.setValue(this.F);
        this.f233919m.setValue(Boolean.valueOf(this.F.a()));
    }

    public boolean S1() {
        GuildJoinEditData guildJoinEditData;
        IGProJoinGuildSetting iGProJoinGuildSetting = this.E;
        if (iGProJoinGuildSetting != null && (guildJoinEditData = this.F) != null) {
            return guildJoinEditData.h(iGProJoinGuildSetting);
        }
        return false;
    }

    @MainThread
    public void T1(AppInterface appInterface, String str) {
        this.G = str;
        ((wy1.a) this.mRepository).m(appInterface);
        IGPSService iGPSService = (IGPSService) appInterface.getRuntimeService(IGPSService.class, "");
        au auVar = new au();
        auVar.e(Long.parseLong(str));
        iGPSService.fetchJoinGuildOption(auVar, new ar() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.s
            @Override // wh2.ar
            public final void a(int i3, String str2, IGProSecurityResult iGProSecurityResult, IGProFetchJoinGuildOptionRsp iGProFetchJoinGuildOptionRsp) {
                t.this.U1(i3, str2, iGProSecurityResult, iGProFetchJoinGuildOptionRsp);
            }
        });
    }

    public void X1(String str) {
        GuildJoinEditData guildJoinEditData = this.F;
        if (guildJoinEditData == null || guildJoinEditData.getMOptionType() != 5) {
            return;
        }
        this.F.l(str);
        this.f233919m.setValue(Boolean.valueOf(this.F.a()));
    }

    public void Z1() {
        GuildJoinEditData guildJoinEditData = this.F;
        if (guildJoinEditData == null) {
            GuildJoinEditData guildJoinEditData2 = new GuildJoinEditData(2);
            this.F = guildJoinEditData2;
            this.f233918i.setValue(guildJoinEditData2);
            this.f233919m.setValue(Boolean.valueOf(this.F.a()));
            return;
        }
        if (!guildJoinEditData.i()) {
            this.F.k(2);
            this.f233918i.setValue(this.F);
            this.f233919m.setValue(Boolean.valueOf(this.F.a()));
        }
    }

    public void a2() {
        if (this.F == null) {
            QLog.w("Guild.mnr.JoinGuildSettingViewModel", 1, "saveSetting data is null");
            return;
        }
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        el elVar = new el();
        elVar.c(Long.parseLong(this.G));
        elVar.d(this.F.g());
        QLog.d("Guild.mnr.JoinGuildSettingViewModel", 4, "setJoinGuildOption_req", elVar);
        iGPSService.setJoinGuildOption(elVar, new dv() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.r
            @Override // wh2.dv
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                t.this.W1(i3, str, iGProSecurityResult);
            }
        });
    }

    public void b2(GWGProJoinGuildChoiceQuestion gWGProJoinGuildChoiceQuestion) {
        if (this.F == null) {
            this.F = new GuildJoinEditData(7);
        }
        this.F.j(gWGProJoinGuildChoiceQuestion);
        this.f233918i.setValue(this.F);
        this.f233919m.setValue(Boolean.valueOf(this.F.a()));
    }

    public void c2(GWGProJoinGuildWordQuestion gWGProJoinGuildWordQuestion) {
        if (this.F == null) {
            this.F = new GuildJoinEditData(6);
        }
        this.F.m(gWGProJoinGuildWordQuestion);
        this.f233918i.setValue(this.F);
        this.f233919m.setValue(Boolean.valueOf(this.F.a()));
    }
}
