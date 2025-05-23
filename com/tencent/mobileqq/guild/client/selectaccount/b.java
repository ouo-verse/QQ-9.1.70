package com.tencent.mobileqq.guild.client.selectaccount;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.client.selectaccount.GuildClientSelectAccountDialogParams;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b extends com.tencent.mobileqq.mvvm.c<wy1.a> {
    public static ViewModelProvider.Factory D = new C7696b();
    private GuildClientSelectAccountDialogParams C;

    /* renamed from: i, reason: collision with root package name */
    private final cn<com.tencent.mobileqq.guild.profile.profilecard.main.l> f215422i;

    /* renamed from: m, reason: collision with root package name */
    private AppInterface f215423m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements vh2.d {
        a() {
        }

        @Override // vh2.d
        public void a(int i3, String str, String str2, String str3, int i16) {
            if (i3 != 0) {
                b.this.f215422i.postValue(com.tencent.mobileqq.guild.profile.profilecard.main.l.e(i3, str));
                QLog.e("Guild.client.GuildClientSelectAccountViewModel", 1, String.format("bindAppRole network error, errorCode: %d, errorMessage: %s", Integer.valueOf(i3), str));
            } else {
                QLog.i("Guild.client.GuildClientSelectAccountViewModel", 1, "requestBindClientRole success");
                b.this.f215422i.postValue(com.tencent.mobileqq.guild.profile.profilecard.main.l.e(0, ""));
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.client.selectaccount.b$b, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    class C7696b implements ViewModelProvider.Factory {
        C7696b() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new b(new wy1.a());
        }
    }

    public b(wy1.a aVar) {
        super(aVar);
        this.f215422i = new cn<>();
    }

    public int M1() {
        return this.C.e().Z();
    }

    public String N1() {
        return this.C.e().z();
    }

    public void O1(AppInterface appInterface, GuildClientSelectAccountDialogParams guildClientSelectAccountDialogParams) {
        this.f215423m = appInterface;
        this.C = guildClientSelectAccountDialogParams;
    }

    public void P1(GuildClientSelectAccountDialogParams.AccountInfo accountInfo) {
        ((IGPSService) this.f215423m.getRuntimeService(IGPSService.class, "")).bindAppRole(this.C.e().z(), accountInfo.b(), 1, new a());
    }

    public String getGuildId() {
        return this.C.e().G();
    }

    public LiveData<com.tencent.mobileqq.guild.profile.profilecard.main.l> getToastEvent() {
        return this.f215422i;
    }
}
