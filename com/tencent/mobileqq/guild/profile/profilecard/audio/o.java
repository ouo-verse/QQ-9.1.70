package com.tencent.mobileqq.guild.profile.profilecard.audio;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.data.GuildAudioChannelData;
import com.tencent.mobileqq.guild.data.GuildSpeakParamsInfo;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.event.GuildSpeakManageGuideShowEvent;
import com.tencent.mobileqq.guild.guide.GuildSpeakManageGuide;
import com.tencent.mobileqq.guild.media.core.notify.y;
import com.tencent.mobileqq.guild.profile.profilecard.audio.o;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.dj;
import com.tencent.mobileqq.qqguildsdk.data.ei;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qqguildsdk.data.genc.fk;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import mqq.app.MobileQQ;
import vh2.ar;
import vh2.bw;
import wh2.ex;

/* compiled from: P */
/* loaded from: classes14.dex */
public class o extends com.tencent.mobileqq.mvvm.c<wy1.a> {
    public static ViewModelProvider.Factory M = new a();
    private MutableLiveData<GuildAudioChannelData> C;
    private MutableLiveData<Integer> D;
    private MediatorLiveData<com.tencent.mobileqq.guild.profile.profilecard.audio.a> E;
    private MutableLiveData<Integer> F;
    private cn<Boolean> G;
    private cn<com.tencent.mobileqq.guild.profile.profilecard.main.l> H;
    private cn<Boolean> I;
    private final MutableLiveData<List<String>> J;
    private GPServiceObserver K;
    private final y L;

    /* renamed from: i, reason: collision with root package name */
    private i f231340i;

    /* renamed from: m, reason: collision with root package name */
    private GuildBaseProfileData f231341m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements ViewModelProvider.Factory {
        a() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new o(new wy1.a());
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAdminChanged(String str, String str2, boolean z16) {
            super.onAdminChanged(str, str2, z16);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(String str) {
            super.onChannelInfoUpdated(str);
            o.this.d2();
            o.this.e2();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onPushKickOutAudioChannel(String str, String str2, String str3, String str4, int i3, String str5, int i16) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (o.this.f231341m == null) {
                QLog.e("Guild.profile.GuildProfileAudioViewModel", 1, "[onPushKickOutAudioChannel] profile data is null");
                return;
            }
            String b16 = o.this.f231341m.b();
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(b16) && str4.equals(b16)) {
                if (QLog.isColorLevel()) {
                    QLog.i("Guild.profile.GuildProfileAudioViewModel", 1, String.format("guildId: %s, chnnUin: %s, operatorTinyId: %s, tinyId: %s", str, str2, str3, str4));
                }
                if (str.equals(o.this.f231341m.e())) {
                    o.this.G.setValue(Boolean.TRUE);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onUserProfileInfoUpdate(int i3, String str, String str2, String str3, ev evVar) {
            if (QLog.isColorLevel()) {
                QLog.i("Guild.profile.GuildProfileAudioViewModel", 1, "onUserProfileInfoUpdate info: " + evVar);
            }
            if (i3 == 0) {
                o.this.D.setValue(Integer.valueOf(evVar.getGender()));
                if (o.this.C.getValue() != 0) {
                    ((GuildAudioChannelData) o.this.C.getValue()).n(evVar.getGender());
                }
                o.this.z2(evVar);
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserSpeakingNotifyForAll(String str, String str2, ArrayList<IGProUserInfo> arrayList, IGProChannelUserNum iGProChannelUserNum) {
            if (str.equals(o.this.f231341m.e()) && str2.equals(o.this.f231341m.a())) {
                o.this.l2(str, str2, arrayList);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class c extends y {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void t(String str, String str2, String str3) {
            o.this.G.setValue(Boolean.TRUE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void x(String str, String str2, String str3, com.tencent.mobileqq.guild.media.core.data.f fVar) {
            int intValue;
            if (str.equals("pushOnTRTCUserVoiceVolume")) {
                QLog.w("Guild.profile.GuildProfileAudioViewModel", 4, "volume refresh return");
                return;
            }
            if (o.this.C.getValue() == 0) {
                if (QLog.isColorLevel()) {
                    QLog.w("Guild.profile.GuildProfileAudioViewModel", 2, "mChannelData.getValue() is null!");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("Guild.profile.GuildProfileAudioViewModel", 2, "onUserDataUpdate from[" + str + "], " + fVar);
                if (((GuildAudioChannelData) o.this.C.getValue()).k() != fVar.f228097e) {
                    QLog.i("Guild.profile.GuildProfileAudioViewModel", 2, "my user type change[" + ((GuildAudioChannelData) o.this.C.getValue()).k() + " -> " + fVar.f228097e + "]");
                }
            }
            GuildAudioChannelData guildAudioChannelData = (GuildAudioChannelData) o.this.C.getValue();
            com.tencent.mobileqq.guild.media.core.data.p g16 = com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList().g(guildAudioChannelData.b());
            if (g16 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("Guild.profile.GuildProfileAudioViewModel", 2, guildAudioChannelData.b() + " already exit!");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("Guild.profile.GuildProfileAudioViewModel", 2, "onUserDataUpdate from[" + str + "], " + g16);
                if (guildAudioChannelData.c() != g16.f228097e || guildAudioChannelData.g() != g16.f228112t || guildAudioChannelData.f() != g16.f228113u) {
                    QLog.i("Guild.profile.GuildProfileAudioViewModel", 2, "dst user profile change, userType[" + guildAudioChannelData.c() + " -> " + g16.f228097e + "], muteToMe[" + guildAudioChannelData.g() + " -> " + g16.f228112t + "], globalMute[" + guildAudioChannelData.f() + " -> " + g16.f228113u + "]");
                }
            }
            guildAudioChannelData.q(fVar.f228093a);
            guildAudioChannelData.r(fVar.f228097e);
            guildAudioChannelData.l(g16.f228093a);
            guildAudioChannelData.m(g16.f228097e);
            guildAudioChannelData.p(g16.f228112t);
            guildAudioChannelData.o(g16.f228113u);
            if (o.this.D.getValue() == 0) {
                intValue = 0;
            } else {
                intValue = ((Integer) o.this.D.getValue()).intValue();
            }
            guildAudioChannelData.n(intValue);
            o.this.C.setValue(guildAudioChannelData);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void y(String str, String str2, boolean z16) {
            int intValue;
            if (str.equals("setUserVoicelessToMe")) {
                GuildAudioChannelData guildAudioChannelData = (GuildAudioChannelData) o.this.C.getValue();
                com.tencent.mobileqq.guild.media.core.data.p g16 = com.tencent.mobileqq.guild.media.core.j.c().getTotalUserInfoList().g(str2);
                QLog.d("Guild.profile.GuildProfileAudioViewModel", 1, "onUserStatusChange from: " + str + ", dstId: " + str2 + ", status: " + z16);
                if (g16 != null && guildAudioChannelData != null) {
                    guildAudioChannelData.q(com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228093a);
                    guildAudioChannelData.r(com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228097e);
                    guildAudioChannelData.l(g16.f228093a);
                    guildAudioChannelData.m(g16.f228097e);
                    guildAudioChannelData.p(z16);
                    guildAudioChannelData.o(g16.f228113u);
                    if (o.this.D.getValue() == 0) {
                        intValue = 0;
                    } else {
                        intValue = ((Integer) o.this.D.getValue()).intValue();
                    }
                    guildAudioChannelData.n(intValue);
                    o.this.C.setValue(guildAudioChannelData);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class d implements Observer<Integer> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            if (num.intValue() == 2) {
                com.tencent.mobileqq.guild.profile.profilecard.audio.a aVar = new com.tencent.mobileqq.guild.profile.profilecard.audio.a();
                aVar.d(R.string.f139860ce);
                aVar.c(R.string.f139920ck);
                o.this.E.setValue(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class e implements bw {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit c(com.tencent.mobileqq.guild.profile.profilecard.main.l lVar, Boolean bool) {
            if (bool.booleanValue()) {
                o.this.G.postValue(Boolean.TRUE);
                SimpleEventBus.getInstance().dispatchEvent(new GuildSpeakManageGuideShowEvent(BaseApplication.getContext().getString(R.string.f152901an), new GuildSpeakParamsInfo(o.this.f231341m.e(), o.this.f231341m.a(), Integer.valueOf(o.this.f231341m.g()), 5)));
                return null;
            }
            o.this.H.postValue(lVar);
            o.this.G.postValue(Boolean.TRUE);
            return null;
        }

        @Override // vh2.bw
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult, List<ei> list) {
            boolean z16;
            final com.tencent.mobileqq.guild.profile.profilecard.main.l lVar = new com.tencent.mobileqq.guild.profile.profilecard.main.l();
            lVar.f(i3);
            if (i3 == 0 && ch.p(iGProSecurityResult)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                lVar.h(BaseApplication.getContext().getString(R.string.f1500413x));
            } else {
                if (TextUtils.isEmpty(str)) {
                    str = BaseApplication.getContext().getString(R.string.f1500313w);
                }
                lVar.h(str);
                lVar.g(iGProSecurityResult);
                o.this.H.setValue(lVar);
            }
            if (z16) {
                GuildSpeakManageGuide.f224623a.f(o.this.f231341m.e(), new Function1() { // from class: com.tencent.mobileqq.guild.profile.profilecard.audio.p
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit c16;
                        c16 = o.e.this.c(lVar, (Boolean) obj);
                        return c16;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class f implements ex {
        f() {
        }

        @Override // wh2.ex
        public void onVoiceSmobaKickOutRoom(int i3, String str) {
            QLog.i("Guild.profile.GuildProfileAudioViewModel", 1, "voiceSmobaGameKickOutRoom: result " + i3 + " errMsg " + str);
            com.tencent.mobileqq.guild.profile.profilecard.main.l lVar = new com.tencent.mobileqq.guild.profile.profilecard.main.l();
            if (i3 == 0) {
                str = "\u79fb\u51fa\u6210\u529f";
            }
            lVar.h(str);
            o.this.H.setValue(lVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class g implements ar {
        g() {
        }

        @Override // vh2.ar
        public void a(int i3, String str, int i16, boolean z16, List<IGProUserInfo> list) {
            o.this.k2(i3, str, list, "fetchChannelAdmin");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class h implements ar {
        h() {
        }

        @Override // vh2.ar
        public void a(int i3, String str, int i16, boolean z16, List<IGProUserInfo> list) {
            o.this.k2(i3, str, list, "fetchCategoryAdmin");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface i {
        void onRaiseHandStateUpdate();
    }

    public o(wy1.a aVar) {
        super(aVar);
        this.C = new MutableLiveData<>();
        this.D = new cn();
        this.E = new MediatorLiveData<>();
        this.F = new MediatorLiveData();
        this.G = new cn<>();
        this.H = new cn<>();
        this.I = new cn<>();
        this.J = new MutableLiveData<>(new ArrayList());
        this.K = new b();
        this.L = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d2() {
        IGPSService iGPSService = (IGPSService) ch.S0(IGPSService.class, "");
        iGPSService.fetchChannelAdminMemberList(this.f231341m.e(), this.f231341m.a(), "5", 200, true, new g());
        IGProChannelInfo channelInfo = iGPSService.getChannelInfo(this.f231341m.a());
        if (channelInfo == null) {
            QLog.w("Guild.profile.GuildProfileAudioViewModel", 1, "fetchChannelAdminList channelInfo == null " + this.f231341m.a());
            return;
        }
        iGPSService.fetchCategoryAdminMemberList(this.f231341m.e(), String.valueOf(channelInfo.getCategoryId()), "7", 200, true, new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k2(int i3, String str, List<IGProUserInfo> list, String str2) {
        List<String> value;
        if (i3 != 0) {
            QLog.e("Guild.profile.GuildProfileAudioViewModel", 1, str2 + " fail code:" + i3 + " msg:" + str + " gId:" + this.f231341m + " cId:" + this.f231341m.a());
            return;
        }
        if (this.J.getValue() == null) {
            value = new ArrayList();
        } else {
            value = this.J.getValue();
        }
        ArrayList arrayList = new ArrayList(value);
        Iterator<IGProUserInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getTinyId());
        }
        QLog.d("Guild.profile.GuildProfileAudioViewModel", 4, str2 + " Result size" + arrayList.size());
        this.J.setValue(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l2(String str, String str2, ArrayList<IGProUserInfo> arrayList) {
        IGProUserInfo iGProUserInfo;
        String b16 = this.f231341m.b();
        Iterator<IGProUserInfo> it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                iGProUserInfo = it.next();
                if (TextUtils.equals(iGProUserInfo.getTinyId(), b16)) {
                    break;
                }
            } else {
                iGProUserInfo = null;
                break;
            }
        }
        if (iGProUserInfo != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.profile.profilecard.audio.m
                @Override // java.lang.Runnable
                public final void run() {
                    o.this.p2();
                }
            });
        }
    }

    private void m2() {
        ((IGPSService) ch.R0(IGPSService.class)).refreshGuildUserProfileInfo(this.f231341m.e(), this.f231341m.b());
        ((IGPSService) ch.R0(IGPSService.class)).addObserver(this.K);
        com.tencent.mobileqq.guild.media.core.j.a().l0().b(this.L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o2(int i3, String str, int i16) {
        QLog.i("Guild.profile.GuildProfileAudioViewModel", 1, "fetchUserTalkPermission: result[" + i3 + "] errMsg[" + str + "] permission[" + i16 + "]");
        if (i3 == 0) {
            this.F.setValue(Integer.valueOf(i16 & 4));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p2() {
        i iVar = this.f231340i;
        if (iVar != null) {
            iVar.onRaiseHandStateUpdate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q2(int i3, String str) {
        com.tencent.mobileqq.guild.profile.profilecard.main.l lVar = new com.tencent.mobileqq.guild.profile.profilecard.main.l();
        lVar.f(i3);
        if (i3 != 0) {
            QLog.e("Guild.profile.GuildProfileAudioViewModel", 1, "setUserVoicelessToMe code:" + i3 + " msg:" + str);
            lVar.h(BaseApplication.getContext().getString(R.string.f140210dc));
            this.H.setValue(lVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit r2(Integer num, String str) {
        QLog.i("Guild.profile.GuildProfileAudioViewModel", 1, "doAdminInviteUserRaiseHand: retCode[" + num + "] msg[" + str + "]");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit s2(Integer num, String str) {
        QLog.i("Guild.profile.GuildProfileAudioViewModel", 1, "doAdminInviteUserRaiseHand: retCode[" + num + "] msg[" + str + "]");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t2(boolean z16, int i3, String str) {
        com.tencent.mobileqq.guild.profile.profilecard.main.l lVar = new com.tencent.mobileqq.guild.profile.profilecard.main.l();
        lVar.f(i3);
        if (i3 != 0) {
            g2().getValue().o(z16);
            if (TextUtils.isEmpty(str)) {
                str = BaseApplication.getContext().getString(R.string.f139910cj);
            }
            lVar.h(str);
            this.H.setValue(lVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z2(ev evVar) {
        boolean z16 = true;
        if (evVar != null) {
            if (evVar.getClientPresence() != null && evVar.getClientPresence().getClientId() > 0) {
                z16 = false;
            }
            ArrayList<dj> m3 = evVar.m();
            if (m3 != null && m3.size() > 0) {
                int size = m3.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (m3.get(i3).a() != null && m3.get(i3).a().getGradeLevel() > 0) {
                        z16 = false;
                    }
                }
            }
        }
        this.I.setValue(Boolean.valueOf(z16));
    }

    public void A2() {
        IGPSService iGPSService = (IGPSService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "");
        fk fkVar = new fk();
        fkVar.l(Long.parseLong(this.f231341m.b()));
        fkVar.g(Long.parseLong(this.f231341m.a()));
        fkVar.i(Long.parseLong(this.f231341m.e()));
        fkVar.h(1);
        fkVar.j(com.tencent.mobileqq.guild.media.core.j.c().n().getRoomInfo().getRoomId());
        fkVar.k(0L);
        iGPSService.voiceSmobaGameKickOutRoom(fkVar, new f());
    }

    public void B2(GuildBaseProfileData guildBaseProfileData) {
        this.f231341m = guildBaseProfileData;
    }

    public void C2(GuildAudioChannelData guildAudioChannelData) {
        if (guildAudioChannelData == null) {
            if (QLog.isColorLevel()) {
                QLog.w("Guild.profile.GuildProfileAudioViewModel", 1, "setChannelData channelData is null!");
                return;
            }
            return;
        }
        this.C.setValue(guildAudioChannelData);
    }

    public void D2(i iVar) {
        this.f231340i = iVar;
    }

    public cn<com.tencent.mobileqq.guild.profile.profilecard.main.l> E2() {
        return this.H;
    }

    public void e2() {
        AppInterface l3 = ch.l();
        if (l3 == null) {
            QLog.e("Guild.profile.GuildProfileAudioViewModel", 1, "fetchUserTalkPermission: app is null!");
            return;
        }
        try {
            long parseLong = Long.parseLong(this.f231341m.e());
            long parseLong2 = Long.parseLong(this.f231341m.a());
            long parseLong3 = Long.parseLong(this.f231341m.b());
            QLog.i("Guild.profile.GuildProfileAudioViewModel", 1, "fetchUserTalkPermission: channelId[" + parseLong2 + "] tinyId[" + parseLong3 + "]");
            ((IGPSService) l3.getRuntimeService(IGPSService.class, "")).fetchOtherChannelUserPermission(parseLong, parseLong2, parseLong3, 4, 104, new wh2.g() { // from class: com.tencent.mobileqq.guild.profile.profilecard.audio.l
                @Override // wh2.g
                public final void onFetchChannelUserPermission(int i3, String str, int i16) {
                    o.this.o2(i3, str, i16);
                }
            });
        } catch (NumberFormatException e16) {
            QLog.i("Guild.profile.GuildProfileAudioViewModel", 1, "fetchUserTalkPermission: " + e16.getMessage());
        }
    }

    public LiveData<List<String>> f2() {
        return this.J;
    }

    public MutableLiveData<GuildAudioChannelData> g2() {
        return this.C;
    }

    public MediatorLiveData<com.tencent.mobileqq.guild.profile.profilecard.audio.a> h2() {
        return this.E;
    }

    public cn<Boolean> i2() {
        return this.G;
    }

    public void init(AppInterface appInterface) {
        ((wy1.a) this.mRepository).m(appInterface);
        m2();
        this.E.removeSource(this.D);
        this.E.addSource(this.D, new d());
        d2();
        e2();
        this.F.setValue(-1);
    }

    public MutableLiveData<Integer> j2() {
        return this.F;
    }

    public cn<Boolean> n2() {
        return this.I;
    }

    public void onDestroy() {
        ((wy1.a) this.mRepository).k(this.K);
        com.tencent.mobileqq.guild.media.core.j.a().l0().B(this.L);
        this.E.removeSource(this.D);
        this.f231340i = null;
    }

    public void u2(boolean z16) {
        com.tencent.mobileqq.guild.media.core.j.a().J().e(this.f231341m.b(), z16, new com.tencent.mobileqq.guild.media.core.i() { // from class: com.tencent.mobileqq.guild.profile.profilecard.audio.j
            @Override // com.tencent.mobileqq.guild.media.core.i
            public final void onResult(int i3, String str) {
                o.this.q2(i3, str);
            }
        });
    }

    public void v2() {
        if (QLog.isColorLevel()) {
            QLog.i("Guild.profile.GuildProfileAudioViewModel", 2, "onClickInviteTalk guildId[" + this.f231341m.e() + "], channelId[" + this.C.getValue().a() + "], tinyId[" + this.C.getValue().b() + "]");
        }
        IGProChannelInfo channelInfo = ((IGPSService) ch.S0(IGPSService.class, "")).getChannelInfo(this.f231341m.a());
        if (channelInfo != null && channelInfo.getVoiceSpeakModeCfg().getSpeakMode() == 2) {
            com.tencent.mobileqq.guild.media.core.j.a().N().u1(this.f231341m.b());
        } else {
            com.tencent.mobileqq.guild.media.core.j.a().T().n1(this.f231341m.b(), new Function2() { // from class: com.tencent.mobileqq.guild.profile.profilecard.audio.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit r26;
                    r26 = o.r2((Integer) obj, (String) obj2);
                    return r26;
                }
            });
        }
    }

    public void w2() {
        if (QLog.isColorLevel()) {
            QLog.i("Guild.profile.GuildProfileAudioViewModel", 2, "onClickKickOutChannel guildId[" + this.f231341m.e() + "], channelId[" + this.C.getValue().a() + "], tinyId[" + this.C.getValue().b() + "]");
        }
        ((IGPSService) ((wy1.a) this.mRepository).l().getRuntimeService(IGPSService.class, "")).kickAudioChannelUsers(this.f231341m.e(), this.C.getValue().a(), new ArrayList<>(Collections.singletonList(this.C.getValue().b())), new e());
    }

    public void x2() {
        if (QLog.isColorLevel()) {
            QLog.i("Guild.profile.GuildProfileAudioViewModel", 2, "onClickRevokeTalkRight guildId[" + this.f231341m.e() + "], channelId[" + this.C.getValue().a() + "], tinyId[" + this.C.getValue().b() + "]");
        }
        com.tencent.mobileqq.guild.media.core.j.a().T().j1(this.f231341m.b(), new Function2() { // from class: com.tencent.mobileqq.guild.profile.profilecard.audio.k
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit s26;
                s26 = o.s2((Integer) obj, (String) obj2);
                return s26;
            }
        });
    }

    public void y2(final boolean z16) {
        long j3;
        long j16;
        long j17;
        QLog.i("Guild.profile.GuildProfileAudioViewModel", 1, "onSwitchBanInChannel allow: isBan[" + z16 + "]");
        try {
            j3 = Long.parseLong(this.f231341m.e());
            try {
                j16 = Long.parseLong(this.f231341m.a());
            } catch (NumberFormatException e16) {
                e = e16;
                j16 = 0;
            }
            try {
                j17 = Long.parseLong(this.f231341m.b());
            } catch (NumberFormatException e17) {
                e = e17;
                QLog.i("Guild.profile.GuildProfileAudioViewModel", 1, "onSwitchBanInChannel: " + e.getMessage());
                j17 = 0L;
                if (j3 == 0) {
                    return;
                } else {
                    return;
                }
            }
        } catch (NumberFormatException e18) {
            e = e18;
            j3 = 0;
            j16 = 0;
        }
        if (j3 == 0 && j16 != 0 && j17 != 0) {
            g2().getValue().o(!z16);
            com.tencent.mobileqq.guild.media.core.j.a().J().f(j3, j16, j17, z16, new com.tencent.mobileqq.guild.media.core.i() { // from class: com.tencent.mobileqq.guild.profile.profilecard.audio.i
                @Override // com.tencent.mobileqq.guild.media.core.i
                public final void onResult(int i3, String str) {
                    o.this.t2(z16, i3, str);
                }
            });
        }
    }
}
