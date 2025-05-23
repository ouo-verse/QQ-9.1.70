package com.tencent.mobileqq.guild.live.viewmodel;

import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.livemanager.player.GuildLivePlayerTag;
import com.tencent.mobileqq.guild.live.livemanager.player.m;
import com.tencent.mobileqq.guild.live.model.GLiveChannelStartParams;
import com.tencent.mobileqq.guild.live.model.LiveChannelRoomInfo;
import com.tencent.mobileqq.guild.performance.report.l;
import com.tencent.mobileqq.guild.util.aa;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.guild.window.GuildFloatWindowUtils;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.UUID;
import vh2.de;

/* compiled from: P */
/* loaded from: classes14.dex */
public class h extends com.tencent.mobileqq.guild.live.viewmodel.a {
    public static String Q;
    private LiveData<Boolean> I;
    private LiveData<Boolean> J;
    private String K;
    private String L;
    private String M;

    /* renamed from: i, reason: collision with root package name */
    private final GLiveChannelCore f226958i = GLiveChannelCore.f226698a;

    /* renamed from: m, reason: collision with root package name */
    private final cn<Boolean> f226959m = new cn<>();
    private final Observer<Boolean> C = new a();
    private final Observer<LiveChannelRoomInfo> D = new b();
    private final Observer<Boolean> E = new c();
    private final e12.e<String> F = new e12.e<>();
    private final cn<Void> G = new cn<>();
    private boolean H = false;
    private final com.tencent.mobileqq.guild.live.viewmodel.e N = new d();
    private final Observer<Boolean> P = new e();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements Observer<Boolean> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool != null) {
                h.this.n2(bool.booleanValue());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b implements Observer<LiveChannelRoomInfo> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(LiveChannelRoomInfo liveChannelRoomInfo) {
            h.this.a2();
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class c implements Observer<Boolean> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            boolean z16;
            h hVar = h.this;
            if (bool == Boolean.TRUE) {
                z16 = true;
            } else {
                z16 = false;
            }
            hVar.i2(z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class d extends com.tencent.mobileqq.guild.live.viewmodel.e {
        d() {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            h.this.k2();
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class e implements Observer<Boolean> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            h.this.j2(bool);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class f implements m {
        f() {
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.player.m
        public boolean disableViewCallback() {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.player.m
        public boolean enableViewCallback() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class g implements de {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f226966a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f226967b;

        g(String str, String str2) {
            this.f226966a = str;
            this.f226967b = str2;
        }

        @Override // vh2.de
        public void a(int i3, String str) {
            QLog.i("QGL.QQGuildLiveRoomVM", 1, "terminateLiveStream, result:" + i3 + ",errMsg:" + str);
            if (i3 == 0) {
                h.this.v2(this.f226966a);
                h.this.f226958i.c(this.f226967b);
                if (h.this.p2()) {
                    h.this.f226958i.h().h(new kf4.a(h.this.L, h.this.K));
                    return;
                }
                return;
            }
            aa.e(str);
        }
    }

    private void A2() {
        String roomName;
        LiveChannelRoomInfo liveChannelRoomInfo = this.f226958i.s().getLiveChannelRoomInfo();
        if (liveChannelRoomInfo == null) {
            roomName = this.f226958i.s().getLiveRoomName();
            if (TextUtils.isEmpty(roomName)) {
                QLog.i("QGL.QQGuildLiveRoomVM", 1, "roomTitle is empty, get channel name.");
                roomName = this.f226958i.s().getChannelName();
            }
        } else {
            QLog.i("QGL.QQGuildLiveRoomVM", 1, "live channel room info not null, get room name.");
            roomName = liveChannelRoomInfo.getRoomName();
        }
        e12.e<String> eVar = this.F;
        if (roomName == null) {
            roomName = "";
        }
        eVar.setValue(roomName);
    }

    private boolean Z1() {
        if (this.f226958i.t().n().getValue() == Boolean.TRUE) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a2() {
        if (!this.f226958i.p().h()) {
            QLog.i("QGL.QQGuildLiveRoomVM", 1, "checkResumeOrEnterSdkRoom, sdk not init suc, ignore.");
            return;
        }
        if (this.f226958i.s().getLiveChannelRoomInfo() == null) {
            QLog.i("QGL.QQGuildLiveRoomVM", 1, "checkResumeOrEnterSdkRoom, live room info == null, ignore.");
            return;
        }
        if (!this.f226958i.s().isLiving()) {
            QLog.i("QGL.QQGuildLiveRoomVM", 1, "checkResumeOrEnterSdkRoom, not living, ignore.");
            return;
        }
        Boolean value = this.f226958i.t().n().getValue();
        Boolean bool = Boolean.TRUE;
        if (value == bool) {
            QLog.i("QGL.QQGuildLiveRoomVM", 1, "checkResumeOrEnterSdkRoom, getIsEnterRoomSuc == true, ignore.");
            return;
        }
        if (this.f226958i.t().D().getValue() == bool) {
            QLog.i("QGL.QQGuildLiveRoomVM", 1, "checkResumeOrEnterSdkRoom, getSelfIsAnchorLiving == true, ignore.");
            return;
        }
        if (this.f226958i.s().getAnchorIsSelf() && this.f226958i.r().d() && !this.f226958i.r().b()) {
            QLog.i("QGL.QQGuildLiveRoomVM", 1, "checkResumeOrEnterSdkRoom, I'm anchor, try resuming...");
            y2();
        } else if (this.f226958i.s().isValidRoomId()) {
            QLog.i("QGL.QQGuildLiveRoomVM", 1, "checkResumeOrEnterSdkRoom, enterRoomAndPlay.");
            d2();
        } else {
            if (!this.f226958i.s().isValidLiveUrl() || this.f226958i.x()) {
                return;
            }
            QLog.i("QGL.QQGuildLiveRoomVM", 1, "checkResumeOrEnterSdkRoom, playUrlByPlayer.");
            t2(this.f226958i.s().getLiveUrl());
        }
    }

    private void addObserver() {
        this.F.addSource(this.f226958i.t().p(), new Observer() { // from class: com.tencent.mobileqq.guild.live.viewmodel.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                h.this.q2((LiveChannelRoomInfo) obj);
            }
        });
        this.F.addSource(this.f226958i.t().e(), new Observer() { // from class: com.tencent.mobileqq.guild.live.viewmodel.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                h.this.r2((IGProChannelInfo) obj);
            }
        });
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.registerCallBack(this.N);
        }
        this.f226958i.t().p().observeForever(this.D);
        this.f226958i.t().n().observeForever(this.E);
    }

    private void d2() {
        GLiveChannelStartParams s16 = this.f226958i.s();
        this.f226958i.o().e(s16.getRoomId());
        if (!this.f226958i.x()) {
            this.f226958i.o().f(s16.getLiveUrl());
        }
    }

    private void e2() {
        if ((((Boolean) e12.d.b(this.f226958i.t().D(), Boolean.FALSE)).booleanValue() && this.f226958i.r().d()) || !Z1()) {
            return;
        }
        long roomId = this.f226958i.s().getRoomId();
        long currentRoomId = this.f226958i.o().getCurrentRoomId();
        if (roomId != currentRoomId) {
            QLog.i("QGL.QQGuildLiveRoomVM", 1, "exitLastLiveRoomIfNeed, willEnterRoomId=" + roomId + ", currentRoomId=" + currentRoomId);
            this.f226958i.o().d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i2(boolean z16) {
        QLog.i("QGL.QQGuildLiveRoomVM", 1, "handleEnterRoomSuc " + z16);
        if (!p2()) {
            return;
        }
        kf4.a aVar = new kf4.a(this.L, this.K);
        nf4.h f16 = this.f226958i.h().f();
        if (z16) {
            f16.a(this.f226958i.s().getAnchorIsSelf(), aVar, 1);
            String anchorTinyId = this.f226958i.s().getAnchorTinyId();
            LiveChannelRoomInfo liveChannelRoomInfo = this.f226958i.s().getLiveChannelRoomInfo();
            if (liveChannelRoomInfo != null) {
                kf4.b bVar = new kf4.b(anchorTinyId, liveChannelRoomInfo.getAnchorNick(), liveChannelRoomInfo.getAnchorIconUrl(), 0);
                QLog.i("QGL.QQGuildLiveRoomVM", 1, "updateAnchorInfo," + bVar.toString());
                f16.d(bVar);
                return;
            }
            return;
        }
        f16.c(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j2(Boolean bool) {
        QLog.i("QGL.QQGuildLiveRoomVM", 1, "handleInitSdkCallback(" + bool + ")");
        if (!bool.booleanValue()) {
            return;
        }
        this.I.removeObserver(this.P);
        if (!b2()) {
            return;
        }
        a2();
    }

    private void m2() {
        if (!this.f226958i.s().isLiving()) {
            QLog.i("QGL.QQGuildLiveRoomVM", 1, "handleRoomStatus, isLiving = false, ignore.");
            return;
        }
        if (Z1()) {
            QLog.i("QGL.QQGuildLiveRoomVM", 1, "handleRoomStatus, checkIsInLiveRoom = true, ignore.");
            return;
        }
        if (this.f226958i.s().isValidRoomId()) {
            QLog.i("QGL.QQGuildLiveRoomVM", 1, "handleRoomStatus, live sdk.");
            this.I.observeForever(this.P);
        } else if (this.f226958i.s().isValidLiveUrl()) {
            t2(this.f226958i.s().getLiveUrl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n2(boolean z16) {
        if (z16) {
            QLog.i("QGL.QQGuildLiveRoomVM", 1, "tryResumeAnchorRoom suc.");
        } else {
            QLog.i("QGL.QQGuildLiveRoomVM", 1, "tryResumeAnchorRoom fail.");
            this.f226959m.postValue(Boolean.TRUE);
        }
    }

    private void o2() {
        GLiveChannelStartParams s16 = this.f226958i.s();
        this.L = s16.getGuildId();
        this.K = s16.getChannelId();
        A2();
        if (s16.getGuildInfo() != null) {
            this.f226958i.t().a0(s16.getGuildInfo());
        }
        if (s16.getChannelInfo() != null) {
            this.f226958i.t().U(s16.getChannelInfo());
        }
        if (s16.getLiveChannelRoomInfo() != null) {
            this.f226958i.t().e0(s16.getLiveChannelRoomInfo());
        }
        if (this.f226958i.s().getViewerNumWhenInit() > ((Integer) e12.d.b(this.f226958i.t().f(), 1)).intValue()) {
            this.f226958i.t().o0(this.f226958i.s().getViewerNumWhenInit());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q2(LiveChannelRoomInfo liveChannelRoomInfo) {
        A2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r2(IGProChannelInfo iGProChannelInfo) {
        A2();
    }

    private void removeObserver() {
        this.F.removeSource(this.f226958i.t().p());
        this.F.removeSource(this.f226958i.t().e());
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.unregisterCallback(this.N);
        }
        this.f226958i.t().p().removeObserver(this.D);
        this.f226958i.t().n().removeObserver(this.E);
    }

    private void t2(String str) {
        boolean isEmpty = TextUtils.isEmpty(str);
        QLog.i("QGL.QQGuildLiveRoomVM", 1, "playUrlByPlayer, isEmptyStreamUrl = " + isEmpty);
        if (isEmpty) {
            return;
        }
        this.f226958i.t().l0(this.f226958i.m().c(str, GuildLivePlayerTag.LIVE, 0, false, false), new f());
        this.f226958i.t().c0(Boolean.TRUE);
        QLog.i("QGL.QQGuildLiveRoomVM", 1, "playUrlByPlayer, play stream url.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v2(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("exit_room_reason", str + ", after terminateLiveStream, audienceExitRoom");
        l.f("exit_room", hashMap);
    }

    private void w2(boolean z16) {
        if (z16) {
            this.f226958i.s().setNeedOpenSharePanel(false);
            this.G.d();
        }
    }

    private void x2() {
        GLiveChannelStartParams s16 = this.f226958i.s();
        if (s16.getBundle().getInt("openGuildAioFrom", 0) == 10 && !s16.isLiving()) {
            aa.d(R.string.f157481n1);
        }
    }

    private void y2() {
        String liveRoomProgramId = this.f226958i.s().getLiveRoomProgramId();
        if (TextUtils.isEmpty(liveRoomProgramId)) {
            QLog.i("QGL.QQGuildLiveRoomVM", 1, "tryResumeAnchorRoom, but programId is empty, ignore.");
            return;
        }
        if (this.J != null) {
            QLog.i("QGL.QQGuildLiveRoomVM", 1, "tryResumeAnchorRoom, but mResumeRoomLiveData != null, ignore.");
            return;
        }
        QLog.i("QGL.QQGuildLiveRoomVM", 1, "tryResumeAnchorRoom.");
        LiveData<Boolean> O = this.f226958i.n().O(this.f226958i.s().getRoomId(), liveRoomProgramId);
        this.J = O;
        O.observeForever(this.C);
    }

    private void z2() {
        LiveData<Boolean> liveData = this.I;
        if (liveData != null) {
            liveData.removeObserver(this.P);
        }
        LiveData<Boolean> liveData2 = this.J;
        if (liveData2 != null) {
            liveData2.removeObserver(this.C);
            this.J = null;
        }
        removeObserver();
        GLiveChannelCore.f226698a.j().c();
        this.H = false;
    }

    public void X1(FragmentActivity fragmentActivity) {
        if (fragmentActivity != null && !fragmentActivity.isDestroyed()) {
            for (Fragment fragment : fragmentActivity.getSupportFragmentManager().getFragments()) {
                if (fragment instanceof DialogFragment) {
                    QLog.i("QGL.QQGuildLiveRoomVM", 1, "cancelActivityAllDialogFragmentShow," + fragment.getClass().getName());
                    ((DialogFragment) fragment).dismissAllowingStateLoss();
                }
            }
        }
    }

    public boolean b2() {
        if (TextUtils.equals(Q, this.M) && GLiveChannelCore.f226698a.v()) {
            return true;
        }
        return false;
    }

    public void c2(String str) {
        int i3;
        int i16;
        String str2 = "endLive, reason:" + str + ",type:" + this.f226958i.s().getLiveType();
        QLog.i("QGL.QQGuildLiveRoomVM", 1, str2);
        if (!this.f226958i.r().a() && !this.f226958i.s().getAnchorIsSelf()) {
            QLog.e("QGL.QQGuildLiveRoomVM", 1, "endLive, anchor is not self, return.");
            return;
        }
        if (this.f226958i.r().c()) {
            if (this.f226958i.r().e()) {
                i16 = 1;
            } else {
                if (this.f226958i.r().a()) {
                    i3 = 5;
                } else if ((this.f226958i.r().d() && !this.f226958i.r().b()) || this.f226958i.r().b()) {
                    i16 = 2;
                } else {
                    i3 = 0;
                }
                i16 = i3;
            }
            QLog.i("QGL.QQGuildLiveRoomVM", 1, "terminateLiveStream serviceTyp " + i16);
            ((IGPSService) ch.R0(IGPSService.class)).terminateLiveStream(this.L, this.K, this.f226958i.s().getLiveType(), i16, new g(str, str2));
            return;
        }
        if (this.f226958i.r().d()) {
            v2(str);
            this.f226958i.c(str2);
        }
    }

    @Override // com.tencent.mobileqq.guild.live.viewmodel.a
    public void destroy() {
        z2();
    }

    public LiveData<Boolean> f2() {
        return this.f226959m;
    }

    public LiveData<Void> g2() {
        return this.G;
    }

    public LiveData<String> h2() {
        return this.F;
    }

    @Override // com.tencent.mobileqq.guild.live.viewmodel.a
    public void init() {
        if (this.H) {
            return;
        }
        this.H = true;
        String uuid = UUID.randomUUID().toString();
        this.M = uuid;
        Q = uuid;
        e2();
        o2();
        this.f226958i.g().m0(this.L, this.K);
        this.I = this.f226958i.p().g(L1());
        addObserver();
        m2();
        x2();
        w2(this.f226958i.s().getIsNeedOpenSharePanel());
    }

    public void k2() {
        QLog.i("QGL.QQGuildLiveRoomVM", 1, "handleOnApplicationBackground.");
        if (!GuildFloatWindowUtils.l() && Z1() && this.f226958i.r().e() && this.f226958i.s().getAnchorIsSelf()) {
            this.f226958i.o().pausePlay();
        }
    }

    public boolean l2() {
        GLiveChannelStartParams s16 = this.f226958i.s();
        if (TextUtils.equals(s16.getChannelId(), this.K)) {
            w2(s16.getIsNeedOpenSharePanel());
            QLog.i("QGL.QQGuildLiveRoomVM", 1, "handleOnNewIntent, equals channelId, ignore");
            return false;
        }
        this.f226958i.g().V();
        u2();
        return true;
    }

    public boolean p2() {
        return this.f226958i.r().e();
    }

    public void s2() {
        if (this.f226958i.r().e() && this.f226958i.s().getAnchorIsSelf()) {
            if (Z1()) {
                QLog.i("QGL.QQGuildLiveRoomVM", 1, "livePageOnResume, resumePlay.");
                this.f226958i.o().resumePlay();
            } else {
                QLog.i("QGL.QQGuildLiveRoomVM", 1, "livePageOnResume, notifyEnterAudienceRoomIfCan.");
                this.f226958i.g().x0();
            }
        }
    }

    public void u2() {
        QLog.i("QGL.QQGuildLiveRoomVM", 1, "reInit.");
        z2();
        init();
    }
}
