package com.tencent.mobileqq.guild.setting.guildmanage.foundjoin;

import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchJoinGuildOptionRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSetSearchSwitchRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.au;
import com.tencent.mobileqq.qqguildsdk.data.genc.em;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import vh2.cc;
import vh2.v;
import wh2.ar;
import wh2.dv;
import wh2.ek;

/* compiled from: P */
/* loaded from: classes14.dex */
public class l extends com.tencent.mobileqq.mvvm.c<wy1.a> {
    public static ViewModelProvider.Factory K = new d();
    private MutableLiveData<Integer> C;
    private MutableLiveData<cf1.b> D;
    private MutableLiveData<Boolean> E;
    private MutableLiveData<Boolean> F;
    private MutableLiveData<Boolean> G;
    private String H;
    private boolean I;
    private final GPServiceObserver J;

    /* renamed from: i, reason: collision with root package name */
    private MutableLiveData<Boolean> f233927i;

    /* renamed from: m, reason: collision with root package name */
    private MutableLiveData<Boolean> f233928m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends GPServiceObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(String str) {
            if (TextUtils.equals(str, l.this.H)) {
                l.this.g2(((IGPSService) ch.R0(IGPSService.class)).getGuildInfo(l.this.H), true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements ar {
        b() {
        }

        @Override // wh2.ar
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProFetchJoinGuildOptionRsp iGProFetchJoinGuildOptionRsp) {
            if (i3 == 0 && iGProFetchJoinGuildOptionRsp != null) {
                if (iGProFetchJoinGuildOptionRsp.getSettingInfo() != null && iGProFetchJoinGuildOptionRsp.getSettingInfo().getOptionType() != 0) {
                    QLog.i("Guild.mnr.GuildFoundAndJoinSettingViewModel", 1, "onFetchJoinGuildOption\uff1a " + iGProFetchJoinGuildOptionRsp.getSettingInfo().getOptionType());
                    l.this.C.setValue(Integer.valueOf(iGProFetchJoinGuildOptionRsp.getSettingInfo().getOptionType()));
                    return;
                }
                l.this.C.setValue(0);
                return;
            }
            QLog.w("Guild.mnr.GuildFoundAndJoinSettingViewModel", 1, "getAddGuildOption failed " + i3 + "errMsg" + str);
            l.this.C.setValue(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class c implements ek {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f233931a;

        c(boolean z16) {
            this.f233931a = z16;
        }

        @Override // wh2.ek
        public void a(int i3, String str, IGProSetSearchSwitchRsp iGProSetSearchSwitchRsp) {
            if (i3 != 0) {
                l.this.E.setValue(Boolean.valueOf(!this.f233931a));
                l.this.D.setValue(new cf1.b(i3, str));
                QLog.e("Guild.mnr.GuildFoundAndJoinSettingViewModel", 1, "setSearchedGuildNameAuth error: " + str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class d implements ViewModelProvider.Factory {
        d() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new l(new wy1.a());
        }
    }

    public l(wy1.a aVar) {
        super(aVar);
        Boolean bool = Boolean.FALSE;
        this.f233927i = new MutableLiveData<>(bool);
        this.f233928m = new MutableLiveData<>(bool);
        this.C = new MutableLiveData<>(0);
        this.D = new MutableLiveData<>();
        this.E = new MutableLiveData<>(bool);
        this.F = new MutableLiveData<>(bool);
        this.G = new MutableLiveData<>(bool);
        this.H = "";
        this.I = false;
        this.J = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0080, code lost:
    
        if (r2 != r4) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b1, code lost:
    
        if (r2 != r4) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g2(IGProGuildInfo iGProGuildInfo, boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        if (iGProGuildInfo == null) {
            QLog.w("Guild.mnr.GuildFoundAndJoinSettingViewModel", 1, "handleGuildInfo\uff1aguildInfo is null");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.mnr.GuildFoundAndJoinSettingViewModel", 4, "handleGuildInfo\uff1aAllowSearch=" + iGProGuildInfo.getAllowSearch() + "\uff0cisVisibleForVisitor=" + iGProGuildInfo.isVisibleForVisitor());
        }
        boolean z28 = false;
        if (iGProGuildInfo.getGuildNumSearch() == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (this.f233927i.getValue() == null || this.f233927i.getValue().booleanValue() != z17) {
            this.f233927i.setValue(Boolean.valueOf(z17));
        }
        if (this.f233928m.getValue() != null) {
            boolean booleanValue = this.f233928m.getValue().booleanValue();
            if (iGProGuildInfo.getQRCodeSwitch() == 0) {
                z27 = true;
            } else {
                z27 = false;
            }
        }
        MutableLiveData<Boolean> mutableLiveData = this.f233928m;
        if (iGProGuildInfo.getQRCodeSwitch() == 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        mutableLiveData.setValue(Boolean.valueOf(z18));
        if (this.F.getValue() != null) {
            boolean booleanValue2 = this.F.getValue().booleanValue();
            if (iGProGuildInfo.getSupportRecommendSwitch() == 0) {
                z26 = true;
            } else {
                z26 = false;
            }
        }
        MutableLiveData<Boolean> mutableLiveData2 = this.F;
        if (iGProGuildInfo.getSupportRecommendSwitch() == 0) {
            z19 = true;
        } else {
            z19 = false;
        }
        mutableLiveData2.setValue(Boolean.valueOf(z19));
        if (iGProGuildInfo.getKeywordSearchSwitch() == 1) {
            z28 = true;
        }
        if (this.E.getValue() == null || this.E.getValue().booleanValue() != z28) {
            this.E.setValue(Boolean.valueOf(z28));
        }
        QLog.d("Guild.mnr.GuildFoundAndJoinSettingViewModel", 1, "handleGuildInfo\uff1aKeywordSearchSwitch=" + iGProGuildInfo.getKeywordSearchSwitch() + "  isObserver=" + z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i2(int i3, String str, IGProGuildInfo iGProGuildInfo) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.mnr.GuildFoundAndJoinSettingViewModel", 4, "fetchGuildInfo\uff1aguildId=" + this.H);
        }
        if (i3 == 0) {
            g2(iGProGuildInfo, false);
        } else {
            QLog.w("Guild.mnr.GuildFoundAndJoinSettingViewModel", 1, "fetchGuildInfo\uff1a result=" + i3 + "\uff0c errMsg=" + str + "\uff0c guildInfo=" + iGProGuildInfo);
        }
        this.G.setValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j2(boolean z16, int i3, String str) {
        if (i3 != 0) {
            this.F.setValue(Boolean.valueOf(!z16));
            ch.e1(1, str);
            QLog.e("Guild.mnr.GuildFoundAndJoinSettingViewModel", 1, "changeGuildAllowTobeRecommended error: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k2(boolean z16, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        if (i3 != 0 || !ch.p(iGProSecurityResult)) {
            this.D.setValue(new cf1.b(i3, str, iGProSecurityResult));
            this.f233928m.setValue(Boolean.valueOf(!z16));
            QLog.e("Guild.mnr.GuildFoundAndJoinSettingViewModel", 1, "setQrcodeSwitchByNetwork, result=" + i3 + ", errMsg=" + str + "secResult=" + iGProSecurityResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l2(boolean z16, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        this.I = false;
        if (i3 != 0 || !ch.p(iGProSecurityResult)) {
            this.f233927i.setValue(Boolean.valueOf(!z16));
            this.D.setValue(new cf1.b(i3, str, iGProSecurityResult));
            QLog.e("Guild.mnr.GuildFoundAndJoinSettingViewModel", 1, "changeGuildAllowSearch error: " + str + "security: " + iGProSecurityResult);
        }
    }

    public void U1() {
        long j3;
        try {
            j3 = Long.valueOf(this.H).longValue();
        } catch (NumberFormatException unused) {
            QLog.w("Guild.mnr.GuildFoundAndJoinSettingViewModel", 1, "fetchAddGuildOption failed\uff1a " + this.H);
            j3 = 0L;
        }
        if (j3 == 0) {
            return;
        }
        au auVar = new au();
        auVar.e(j3);
        ((IGPSService) ch.R0(IGPSService.class)).fetchJoinGuildOption(auVar, new b());
    }

    public void W1() {
        ((IGPSService) ch.R0(IGPSService.class)).fetchGuildInfoWithSource(this.H, 103, new v() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.h
            @Override // vh2.v
            public final void a(int i3, String str, IGProGuildInfo iGProGuildInfo) {
                l.this.i2(i3, str, iGProGuildInfo);
            }
        });
    }

    public LiveData<Integer> X1() {
        return this.C;
    }

    public LiveData<Boolean> Z1() {
        return this.G;
    }

    public MutableLiveData<Boolean> a2() {
        return this.F;
    }

    public void addObserver() {
        ((IGPSService) ch.R0(IGPSService.class)).addObserver(this.J);
    }

    public MutableLiveData<Boolean> b2() {
        return this.E;
    }

    public MutableLiveData<Boolean> c2() {
        return this.f233927i;
    }

    public String d2(int i3) {
        if (i3 == 1) {
            return HardCodeUtil.qqStr(R.string.f138760_f);
        }
        if (i3 != 2 && i3 != 4 && i3 != 6 && i3 != 7 && i3 != 5) {
            if (i3 == 3) {
                return HardCodeUtil.qqStr(R.string.f138780_h);
            }
            return "";
        }
        return HardCodeUtil.qqStr(R.string.f138790_i);
    }

    public LiveData<cf1.b> e2() {
        return this.D;
    }

    public MutableLiveData<Boolean> f2() {
        return this.f233928m;
    }

    @MainThread
    public void h2(String str) {
        this.H = str;
        W1();
    }

    public void m2(final boolean z16) {
        if (this.F.getValue() != null && z16 == this.F.getValue().booleanValue()) {
            return;
        }
        this.F.setValue(Boolean.valueOf(z16));
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(51, Integer.valueOf(!z16 ? 1 : 0));
        ((IGPSService) ch.R0(IGPSService.class)).batchSetIntField(this.H, hashMap, new cc() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.j
            @Override // vh2.cc
            public final void onResult(int i3, String str) {
                l.this.j2(z16, i3, str);
            }
        });
    }

    public void n2(final boolean z16) {
        this.f233928m.setValue(Boolean.valueOf(z16));
        ((IGPSService) ch.R0(IGPSService.class)).setGuildQRCodeSwitch(Long.parseLong(this.H), !z16 ? 1 : 0, new dv() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.i
            @Override // wh2.dv
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                l.this.k2(z16, i3, str, iGProSecurityResult);
            }
        });
    }

    public void o2(final boolean z16) {
        Boolean value = this.f233927i.getValue();
        if ((value != null && z16 == value.booleanValue()) || this.I) {
            return;
        }
        this.I = true;
        this.f233927i.setValue(Boolean.valueOf(z16));
        ((IGPSService) ch.R0(IGPSService.class)).setGuildNumSearchSwitch(Long.parseLong(this.H), z16 ? 1 : 0, new dv() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.k
            @Override // wh2.dv
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                l.this.l2(z16, i3, str, iGProSecurityResult);
            }
        });
    }

    public void p2(boolean z16) {
        int i3;
        em emVar = new em();
        emVar.d(this.H);
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        emVar.c(i3);
        this.E.setValue(Boolean.valueOf(z16));
        ((IGPSService) ch.R0(IGPSService.class)).setSearchSwitch(emVar, new c(z16));
    }

    public void removeObserver() {
        ((IGPSService) ch.R0(IGPSService.class)).deleteObserver(this.J);
    }
}
