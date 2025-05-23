package com.tencent.mobileqq.guild.client.manage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.profile.profilecard.main.l;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.di;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import vh2.bi;
import vh2.cu;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildClientManageViewModel extends com.tencent.mobileqq.mvvm.c<wy1.a> {
    static ViewModelProvider.Factory G = new d();
    private final cn<l> C;
    private final cn<Boolean> D;
    private final MutableLiveData<Object[]> E;
    private final cn<Boolean> F;

    /* renamed from: i, reason: collision with root package name */
    private AppInterface f215398i;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<GuildClientParams> f215399m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements bi {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f215402a;

        a(String str) {
            this.f215402a = str;
        }

        @Override // vh2.bi
        public void onGetClientAccount(int i3, String str, byte[] bArr, boolean z16, ArrayList<di> arrayList) {
            if (i3 != 0) {
                QLog.e("Guild.client.GuildClientManageViewModel", 1, String.format("fetchClientInfo network error, errorCode: %d, errorMessage: %s", Integer.valueOf(i3), str));
                if (i3 == 871400) {
                    GuildClientManageViewModel.this.F.setValue(Boolean.TRUE);
                    return;
                }
                return;
            }
            QLog.d("Guild.client.GuildClientManageViewModel", 1, "fetchClientInfo success clientAccount: s%" + arrayList);
            Iterator<di> it = arrayList.iterator();
            while (it.hasNext()) {
                di next = it.next();
                if (next.getClientId().equals(this.f215402a)) {
                    GuildClientManageViewModel.this.f215399m.setValue(new GuildClientParams(next));
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements cu {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f215404a;

        b(boolean z16) {
            this.f215404a = z16;
        }

        @Override // vh2.cu
        public void a(int i3, String str, String str2, int i16, int i17) {
            if (i3 != 0) {
                QLog.e("Guild.client.GuildClientManageViewModel", 1, String.format("setClientConfigShowStatus network error, errorCode: %d, errorMessage: %s", Integer.valueOf(i3), str));
                GuildClientManageViewModel.this.E.setValue(new Object[]{Integer.valueOf(i16), Integer.valueOf(GuildClientManageViewModel.this.Z1(this.f215404a))});
            } else {
                QLog.d("Guild.client.GuildClientManageViewModel", 1, "setClientConfigShowStatus success");
                GuildClientManageViewModel.this.E.setValue(new Object[]{Integer.valueOf(i16), Integer.valueOf(i17)});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements vh2.d {
        c() {
        }

        @Override // vh2.d
        public void a(int i3, String str, String str2, String str3, int i16) {
            if (i3 != 0) {
                GuildClientManageViewModel.this.C.postValue(l.e(i3, "\u89e3\u9664\u5931\u8d25"));
                QLog.e("Guild.client.GuildClientManageViewModel", 1, String.format("unConnectClientAccount network error, errorCode: %d, errorMessage: %s", Integer.valueOf(i3), str));
                GuildClientManageViewModel.this.D.setValue(Boolean.FALSE);
            } else {
                QLog.i("Guild.client.GuildClientManageViewModel", 1, "unConnectClientAccount success");
                GuildClientManageViewModel.this.C.postValue(l.e(0, "\u89e3\u9664\u6210\u529f"));
                GuildClientManageViewModel.this.D.setValue(Boolean.TRUE);
                if (GuildClientManageViewModel.this.T1().equals("100001")) {
                    ch.f235508a = 0L;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class d implements ViewModelProvider.Factory {
        d() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new GuildClientManageViewModel(new wy1.a());
        }
    }

    public GuildClientManageViewModel(wy1.a aVar) {
        super(aVar);
        this.f215399m = new MutableLiveData<>();
        this.C = new cn<>();
        this.D = new cn<>();
        this.E = new MutableLiveData<>();
        this.F = new cn<>();
    }

    private void S1(final GuildClientParams guildClientParams) {
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.client.manage.GuildClientManageViewModel.1
            @Override // java.lang.Runnable
            public void run() {
                GuildClientManageViewModel.this.R1(guildClientParams.z());
            }
        }, 300L);
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.client.manage.GuildClientManageViewModel.2
            @Override // java.lang.Runnable
            public void run() {
                GuildClientManageViewModel.this.R1(guildClientParams.z());
            }
        }, 600L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Z1(boolean z16) {
        if (z16) {
            return 2;
        }
        return 1;
    }

    public void R1(String str) {
        ((IGPSService) this.f215398i.getRuntimeService(IGPSService.class, "")).getBindClientService(2, str, new byte[0], new a(str));
    }

    public String T1() {
        return this.f215399m.getValue().z();
    }

    public MutableLiveData<GuildClientParams> U1() {
        return this.f215399m;
    }

    public int W1() {
        return this.f215399m.getValue().B();
    }

    public MutableLiveData<Object[]> X1() {
        return this.E;
    }

    public cn<Boolean> a2() {
        return this.F;
    }

    public cn<l> b2() {
        return this.C;
    }

    public cn<Boolean> c2() {
        return this.D;
    }

    public String d2() {
        return this.f215399m.getValue().b0();
    }

    public void e2(AppInterface appInterface, GuildClientParams guildClientParams, int i3) {
        this.f215398i = appInterface;
        this.f215399m.setValue(guildClientParams);
        if (i3 == 2) {
            S1(guildClientParams);
        } else if (TextUtils.isEmpty(guildClientParams.o())) {
            R1(guildClientParams.z());
        }
    }

    public void f2(String str, int i3, boolean z16) {
        ((IGPSService) this.f215398i.getRuntimeService(IGPSService.class, "")).setClientShowConfig(str, i3, Z1(z16), new b(z16));
    }

    public void g2() {
        String o16 = this.f215399m.getValue().o();
        if (TextUtils.isEmpty(o16)) {
            return;
        }
        ((IGPSService) this.f215398i.getRuntimeService(IGPSService.class, "")).bindAppRole(T1(), o16, 2, new c());
    }

    public String getGuildId() {
        return this.f215399m.getValue().G();
    }
}
