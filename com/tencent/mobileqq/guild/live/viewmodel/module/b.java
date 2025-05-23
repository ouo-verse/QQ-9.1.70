package com.tencent.mobileqq.guild.live.viewmodel.module;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.model.LiveChannelRoomInfo;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.eu;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleManagementTag;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import vh2.bq;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b extends com.tencent.mobileqq.guild.live.viewmodel.a {
    private String F;
    private boolean G;

    /* renamed from: i, reason: collision with root package name */
    private final e12.a<String> f226992i = new e12.a<>();

    /* renamed from: m, reason: collision with root package name */
    private final e12.a<String> f226993m = new e12.a<>();
    private final e12.a<eu> C = new e12.a<>();
    private final e12.a<IGProRoleManagementTag> D = new e12.a<>();
    private final GLiveChannelCore E = GLiveChannelCore.f226698a;
    private final GPServiceObserver H = new a();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends GPServiceObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onAddGuildNotInfo(String str) {
            if (QLog.isColorLevel()) {
                QLog.i("QGL.QQGuildAnchorInfoVM", 1, "onAddGuildNotInfo.");
            }
            b.this.i2();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAddGuildWithInfo(IGProGuildInfo iGProGuildInfo, int i3) {
            if (QLog.isColorLevel()) {
                QLog.i("QGL.QQGuildAnchorInfoVM", 1, "onAddGuildWithInfo.");
            }
            b.this.i2();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(String str, int i3) {
            if (QLog.isColorLevel()) {
                QLog.i("QGL.QQGuildAnchorInfoVM", 1, "onBeKickFromGuild.");
            }
            b.this.i2();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildUserAvatarUrlUpdate(String str, String str2) {
            if (TextUtils.equals(b.this.F, str2)) {
                b.this.j2(str2);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onMemberTopRoleChanged(String str, String str2) {
            if (QLog.isColorLevel()) {
                QLog.i("QGL.QQGuildAnchorInfoVM", 2, "onMemberTopRoleChanged, guildId: " + str + ", tinyId: " + str2);
            }
            super.onMemberTopRoleChanged(str, str2);
            if (TextUtils.equals(str2, b.this.F)) {
                b.this.i2();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(String str) {
            if (QLog.isColorLevel()) {
                QLog.i("QGL.QQGuildAnchorInfoVM", 1, "onRemoveGuild.");
            }
            b.this.i2();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserDisplayNameUpdate(String str) {
            if (b.this.G && TextUtils.equals(b.this.F, str)) {
                b.this.l2(ch.H(b.this.L1(), b.this.E.s().getGuildId(), str), "onUserDisplayNameUpdate");
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.live.viewmodel.module.b$b, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    class C7817b implements Observer<LiveChannelRoomInfo> {
        C7817b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(LiveChannelRoomInfo liveChannelRoomInfo) {
            if (b.this.G && liveChannelRoomInfo != null) {
                b.this.l2(liveChannelRoomInfo.getAnchorNick(), "LiveChannelRoomInfoUpdate");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class c implements Observer<IGProChannelInfo> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(IGProChannelInfo iGProChannelInfo) {
            b.this.n2(iGProChannelInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class d implements bq {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f226997a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f226998b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f226999c;

        d(String str, String str2, String str3) {
            this.f226997a = str;
            this.f226998b = str2;
            this.f226999c = str3;
        }

        @Override // vh2.bq
        public void a(int i3, String str, List<IGProUserInfo> list, List<String> list2) {
            if (QLog.isColorLevel()) {
                QLog.i("QGL.QQGuildAnchorInfoVM", 1, "fetchUserInfo result:" + i3 + " errMsg:" + str);
            }
            if (i3 == 0) {
                IGProUserInfo g26 = b.this.g2(list, this.f226997a);
                if (g26 != null) {
                    IGProGuildRoleInfo memberTopRole = ((IGPSService) b.this.L1().getRuntimeService(IGPSService.class, "")).getMemberTopRole(this.f226998b, this.f226999c, this.f226997a, "", 0);
                    b.this.l2(ch.d0(g26), "queryAnchorShowName");
                    b.this.m2(g26, memberTopRole);
                    b.this.k2(g26.getPersonalMedal());
                    return;
                }
                return;
            }
            if (i3 == 23000) {
                b.this.e2();
            }
        }
    }

    private void a2() {
        IGProGuildInfo guildInfo = GLiveChannelCore.f226698a.s().getGuildInfo();
        if (guildInfo == null) {
            this.G = true;
            return;
        }
        this.G = ((IGPSService) L1().getRuntimeService(IGPSService.class, "")).isGuest(guildInfo.getGuildID());
        if (QLog.isColorLevel()) {
            QLog.i("QGL.QQGuildAnchorInfoVM", 1, "mSelfIsGuest = " + this.G);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e2() {
        LiveChannelRoomInfo liveChannelRoomInfo = GLiveChannelCore.f226698a.s().getLiveChannelRoomInfo();
        if (liveChannelRoomInfo != null && !TextUtils.isEmpty(liveChannelRoomInfo.getAnchorNick())) {
            l2(liveChannelRoomInfo.getAnchorNick(), "getAnchorNameFromLiveRoomInfo");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IGProUserInfo g2(List<IGProUserInfo> list, String str) {
        if (list == null) {
            return null;
        }
        for (IGProUserInfo iGProUserInfo : list) {
            if (TextUtils.equals(iGProUserInfo.getTinyId(), str)) {
                return iGProUserInfo;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i2() {
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        if (gLiveChannelCore.s().getGuildInfo() == null) {
            return;
        }
        a2();
        IGProChannelInfo channelInfo = gLiveChannelCore.s().getChannelInfo();
        if (channelInfo == null) {
            return;
        }
        h2(channelInfo.getGuildId(), channelInfo.getChannelUin(), this.F);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j2(String str) {
        String guildId = this.E.s().getGuildId();
        IGPSService iGPSService = (IGPSService) L1().getRuntimeService(IGPSService.class, "");
        String fullGuildUserUserAvatarUrl = iGPSService.getFullGuildUserUserAvatarUrl(guildId, str, 0);
        if (QLog.isColorLevel()) {
            QLog.i("QGL.QQGuildAnchorInfoVM", 2, "getFullAvatarUrl avatarCircleUrl:" + fullGuildUserUserAvatarUrl);
        }
        this.f226992i.setValue(fullGuildUserUserAvatarUrl);
        o2();
        GLiveChannelCore.f226698a.g().E0(iGPSService.getFullGuildUserUserAvatarUrl(guildId, str, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k2(eu euVar) {
        this.C.setValue(euVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l2(String str, String str2) {
        QLog.i("QGL.QQGuildAnchorInfoVM", 1, "[updateAnchorName] anchorNick:" + str + ", from:" + str2);
        this.f226993m.setValue(str);
        o2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m2(IGProUserInfo iGProUserInfo, IGProGuildRoleInfo iGProGuildRoleInfo) {
        boolean z16;
        if (iGProGuildRoleInfo != null) {
            iGProUserInfo.setRoleManagementTag(Long.parseLong(iGProGuildRoleInfo.getRoleId()), iGProGuildRoleInfo.getDisplayTagName(), iGProGuildRoleInfo.getColor() | (-16777216));
            z16 = true;
        } else {
            z16 = false;
        }
        IGProRoleManagementTag roleManagementTag = iGProUserInfo.getRoleManagementTag();
        QLog.d("QGL.QQGuildAnchorInfoVM", 1, "[updateAnchorRoleTag] tagName: " + roleManagementTag.getTagName() + ", color: " + roleManagementTag.getColor() + ", fromRoleInfo: " + z16);
        this.D.setValue(roleManagementTag);
    }

    private void o2() {
        if (this.E.r().e()) {
            kf4.b bVar = new kf4.b(this.E.s().getAnchorTinyId(), this.f226993m.getValue(), this.f226992i.getValue(), 0);
            QLog.i("QGL.QQGuildAnchorInfoVM", 1, "updateAnchorInfo," + bVar.toString());
            this.E.h().f().d(bVar);
        }
    }

    public LiveData<String> b2() {
        return this.f226992i;
    }

    public LiveData<eu> c2() {
        return this.C;
    }

    public LiveData<String> d2() {
        return this.f226993m;
    }

    public LiveData<IGProRoleManagementTag> f2() {
        return this.D;
    }

    public void h2(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str3);
        ((IGPSService) L1().getRuntimeService(IGPSService.class, "")).fetchUserInfo(str, str2, (List<String>) arrayList, true, (bq) new d(str3, str, str2));
    }

    @Override // com.tencent.mobileqq.guild.live.viewmodel.a
    public void init() {
        e2();
        a2();
        e12.a<String> aVar = this.f226993m;
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        aVar.addSource(gLiveChannelCore.t().p(), new C7817b());
        this.f226993m.addSource(gLiveChannelCore.t().e(), new c());
        ((IGPSService) L1().getRuntimeService(IGPSService.class, "")).addObserver(this.H);
    }

    public void n2(IGProChannelInfo iGProChannelInfo) {
        if (iGProChannelInfo != null && iGProChannelInfo.getLiveAnchorTinyId() > 0) {
            String valueOf = String.valueOf(iGProChannelInfo.getLiveAnchorTinyId());
            if (TextUtils.equals(valueOf, this.F)) {
                if (QLog.isColorLevel()) {
                    QLog.i("QGL.QQGuildAnchorInfoVM", 1, "updateAllInfo == false, equals anchorId, ignore.");
                    return;
                }
                return;
            } else {
                this.F = valueOf;
                j2(valueOf);
                h2(iGProChannelInfo.getGuildId(), iGProChannelInfo.getChannelUin(), valueOf);
                return;
            }
        }
        this.f226992i.setValue("");
        this.f226993m.setValue(null);
        this.F = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        e12.a<String> aVar = this.f226993m;
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        aVar.removeSource(gLiveChannelCore.t().p());
        this.f226993m.removeSource(gLiveChannelCore.t().e());
        ((IGPSService) L1().getRuntimeService(IGPSService.class, "")).deleteObserver(this.H);
        this.F = null;
    }
}
