package com.tencent.mobileqq.guild.profile.profilecard.main;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelStoreOwner;
import aw1.k;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import vh2.ak;
import vh2.bx;

/* compiled from: P */
/* loaded from: classes14.dex */
public class k extends com.tencent.mobileqq.mvvm.c<wy1.a> {
    private MutableLiveData<GuildHeaderData> C;
    private final MutableLiveData<l> D;
    private final MutableLiveData<List<k.b>> E;
    private final MutableLiveData<List<k.b>> F;
    private final MediatorLiveData<List<k.b>> G;
    private boolean H;

    /* renamed from: i, reason: collision with root package name */
    private GuildBaseProfileData f231533i;

    /* renamed from: m, reason: collision with root package name */
    private ev f231534m;

    public k(wy1.a aVar) {
        super(aVar);
        this.C = new MutableLiveData<>();
        this.D = new cn();
        this.E = new MutableLiveData<>();
        this.F = new MutableLiveData<>();
        this.G = new MediatorLiveData<>();
        this.H = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z1(int i3, String str, List list) {
        if (i3 == 0 && list != null && list.size() != 0) {
            if (QLog.isColorLevel()) {
                QLog.i("Guild.profile.GuildProfileHeaderViewModel", 2, "fetchMemberRoles, result: " + i3 + ",errMsg: " + str + ", list: " + list);
            }
            g2(list, this.E);
            return;
        }
        QLog.w("Guild.profile.GuildProfileHeaderViewModel", 1, "fetchMemberRoles, result: " + i3 + ",errMsg: " + str + ", list: " + list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ k a2() {
        return new k(new wy1.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b2(int i3, String str, List list) {
        if (i3 == 0 && list != null && list.size() != 0) {
            if (QLog.isColorLevel()) {
                QLog.i("Guild.profile.GuildProfileHeaderViewModel", 2, "preloadMemberRoles, result: " + i3 + ",errMsg: " + str + ", list: " + list);
            }
            g2(list, this.F);
            return;
        }
        QLog.w("Guild.profile.GuildProfileHeaderViewModel", 1, "preloadMemberRoles, result: " + i3 + ",errMsg: " + str + ", list: " + list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean c2(List list) {
        return Boolean.valueOf(!list.isEmpty());
    }

    public static k d2(ViewModelStoreOwner viewModelStoreOwner) {
        return (k) ef1.c.a(viewModelStoreOwner, k.class, new Function0() { // from class: com.tencent.mobileqq.guild.profile.profilecard.main.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                k a26;
                a26 = k.a2();
                return a26;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e2(Object obj) {
        MutableLiveData<List<k.b>> mutableLiveData = this.F;
        MutableLiveData<List<k.b>> mutableLiveData2 = this.E;
        if (mutableLiveData2.getValue() != null) {
            this.G.setValue(mutableLiveData2.getValue());
        } else if (mutableLiveData.getValue() != null) {
            this.G.setValue(mutableLiveData.getValue());
        }
    }

    private void f2() {
        String e16 = this.f231533i.e();
        String b16 = this.f231533i.b();
        QLog.i("Guild.profile.GuildProfileHeaderViewModel", 1, "preloadMemberRoles: guildID:" + e16 + ", dstTinyId: " + b16);
        ((IGPSService) ch.R0(IGPSService.class)).loadMemberRoleList(e16, b16, new bx() { // from class: com.tencent.mobileqq.guild.profile.profilecard.main.j
            @Override // vh2.bx
            public final void a(int i3, String str, List list) {
                k.this.b2(i3, str, list);
            }
        });
    }

    private void g2(List<IGProGuildRoleInfo> list, MutableLiveData<List<k.b>> mutableLiveData) {
        QLog.d("Guild.profile.GuildProfileHeaderViewModel", 1, "Fetched role group list size: " + list.size());
        ArrayList arrayList = new ArrayList();
        IGProGuildRoleInfo iGProGuildRoleInfo = null;
        for (IGProGuildRoleInfo iGProGuildRoleInfo2 : list) {
            if (iGProGuildRoleInfo2.getRoleType() != 1) {
                if (iGProGuildRoleInfo2.isLevelRole()) {
                    iGProGuildRoleInfo = iGProGuildRoleInfo2;
                } else {
                    arrayList.add(new k.b(iGProGuildRoleInfo2));
                }
            }
        }
        if (iGProGuildRoleInfo != null) {
            arrayList.add(0, new k.b(iGProGuildRoleInfo));
        }
        mutableLiveData.setValue(arrayList);
    }

    private int getDateDiffDays(long j3, long j16) {
        if (j3 > 0 && j16 > 0) {
            if (QLog.isColorLevel()) {
                QLog.i("Guild.profile.GuildProfileHeaderViewModel", 1, "date: " + com.tencent.mobileqq.remind.e.a(j3) + " - date2: " + com.tencent.mobileqq.remind.e.a(j16));
            }
            return (int) ((((Math.abs(j3 - j16) / 1000) / 60) / 60) / 24);
        }
        return -1;
    }

    private void h2() {
        ev evVar = this.f231534m;
        GuildHeaderData value = this.C.getValue();
        if (value == null) {
            value = new GuildHeaderData();
        }
        value.N(evVar.getUin());
        value.G(evVar.getTinyId());
        value.w(ch.e0(evVar));
        value.q(evVar.getAge());
        value.s(lv1.a.b(evVar));
        value.v(lv1.a.c(evVar));
        value.x(evVar.getGender());
        value.p(lv1.a.a(evVar).toString());
        value.y(evVar.getShutUpExpireTime());
        value.t(evVar.t());
        String f16 = evVar.f();
        if (!TextUtils.isEmpty(f16)) {
            value.F(f16.trim());
        }
        value.C(evVar.k());
        String fullGuildUserUserAvatarUrl = ((IGPSService) ch.R0(IGPSService.class)).getFullGuildUserUserAvatarUrl(this.f231533i.e(), evVar.getTinyId(), 0);
        if (!TextUtils.isEmpty(fullGuildUserUserAvatarUrl)) {
            value.z(fullGuildUserUserAvatarUrl);
        }
        if (evVar.getJoinTime() > 0) {
            value.A(getDateDiffDays(evVar.getJoinTime() * 1000, NetConnInfoCenter.getServerTimeMillis()));
        } else if (evVar.getJoinTime() == 0) {
            value.A(-1L);
        }
        QLog.d("Guild.profile.GuildProfileHeaderViewModel", 1, "topBannerUrl:" + evVar.h());
        if (!TextUtils.isEmpty(evVar.h())) {
            value.M(evVar.h());
        }
        QLog.d("Guild.profile.GuildProfileHeaderViewModel", 1, "medals:" + evVar.getMedals());
        if (!evVar.getMedals().isEmpty()) {
            value.B(evVar.getMedals());
        }
        value.r(evVar.d());
        value.D(evVar.getRoomState());
        value.u(this.f231533i.a());
        value.E(evVar.s());
        this.C.setValue(value);
    }

    public LaunchGuildChatPieParam Q1(com.tencent.mobileqq.qqguildsdk.data.k kVar) {
        Bundle bundle = new Bundle();
        bundle.putByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, (byte) 1);
        return new LaunchGuildChatPieParam().l(kVar.b()).b(kVar.a()).r(true).o(1).g(5).k(bundle).q("").a();
    }

    public void R1() {
        String b16 = this.f231533i.b();
        QLog.i("Guild.profile.GuildProfileHeaderViewModel", 1, "fetchMemberRoles: baseData:" + this.f231533i + ", dstTinyId: " + b16);
        ((IGPSService) ch.R0(IGPSService.class)).fetchMemberRoleList(this.f231533i.e(), this.f231533i.a(), b16, 102, new ak() { // from class: com.tencent.mobileqq.guild.profile.profilecard.main.f
            @Override // vh2.ak
            public final void a(int i3, String str, List list) {
                k.this.Z1(i3, str, list);
            }
        });
    }

    public LiveData<List<k.b>> S1() {
        return this.G;
    }

    public ev T1() {
        return this.f231534m;
    }

    public MutableLiveData<GuildHeaderData> U1() {
        return this.C;
    }

    public void W1(GuildProfileData guildProfileData) {
        this.f231533i = guildProfileData.getGuildBaseProfileData();
        this.f231534m = guildProfileData.getUserProfileInfo();
        boolean isDirectMessage = guildProfileData.isDirectMessage();
        k2(guildProfileData);
        if (!isDirectMessage) {
            f2();
        }
    }

    public boolean X1() {
        return TextUtils.equals(this.f231533i.j(), this.f231533i.b());
    }

    public GuildBaseProfileData getGuildBaseProfileData() {
        return this.f231533i;
    }

    public LiveData<Boolean> i2() {
        return Transformations.map(this.G, new Function() { // from class: com.tencent.mobileqq.guild.profile.profilecard.main.h
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean c26;
                c26 = k.c2((List) obj);
                return c26;
            }
        });
    }

    public MutableLiveData<l> j2() {
        return this.D;
    }

    public void k2(GuildProfileData guildProfileData) {
        this.f231533i = guildProfileData.getGuildBaseProfileData();
        this.f231534m = guildProfileData.getUserProfileInfo();
        this.H = guildProfileData.isDirectMessage();
        h2();
        if (!this.H) {
            this.G.removeSource(this.F);
            this.G.removeSource(this.E);
            this.G.addSource(this.E, new Observer() { // from class: com.tencent.mobileqq.guild.profile.profilecard.main.g
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    k.this.e2((List) obj);
                }
            });
            this.G.addSource(this.F, new Observer() { // from class: com.tencent.mobileqq.guild.profile.profilecard.main.g
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    k.this.e2((List) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mvvm.c, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
    }
}
