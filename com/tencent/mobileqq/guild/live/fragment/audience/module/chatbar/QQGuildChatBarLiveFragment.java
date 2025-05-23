package com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.tencent.guildlive.api.IGuildLiveAioApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.api.impl.GuildDTReportApiImpl;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment;
import com.tencent.mobileqq.guild.live.fragment.base.module.chatbar.QQGuildLiveBaseChatBarFragment;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.livemanager.player.GamePlayTogetherMgr;
import com.tencent.mobileqq.guild.live.model.GLiveChannelStartParams;
import com.tencent.mobileqq.guild.live.model.LiveChannelRoomInfo;
import com.tencent.mobileqq.guild.live.widget.GuildLivePlayTogetherGuideView;
import com.tencent.mobileqq.guild.media.config.MediaGuidanceConfig;
import com.tencent.mobileqq.guild.media.core.notify.NotifyGiftRankChanged;
import com.tencent.mobileqq.guild.media.core.notify.NotifyReceivePayGiftChanged;
import com.tencent.mobileqq.guild.profile.me.aj;
import com.tencent.mobileqq.guild.profile.me.ak;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.api.live.playtogether.PlayTogetherClickType;
import com.tencent.timi.game.api.live.playtogether.PlayTogetherStatus;
import com.tencent.util.UiThreadUtil;
import fn0.GuildLiveAioMsgListWrap;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import rs0.LiveUserEnterTipsModel;
import vh2.bq;

/* compiled from: P */
/* loaded from: classes14.dex */
public class QQGuildChatBarLiveFragment extends QQGuildLiveBaseChatBarFragment implements ts0.a {
    private Fragment D;
    private com.tencent.mobileqq.guild.live.viewmodel.h E;
    private com.tencent.mobileqq.guild.live.viewmodel.module.a F;
    private View G;
    private GuildLivePlayTogetherGuideView H;
    private String L;
    private ScanningLightView Q;
    private final tq1.b C = GLiveChannelCore.f226698a.t();
    private boolean I = Uh();
    protected xr0.a J = null;
    protected EnterTipsMessageManagerStrategy K = null;
    private long M = -1;
    private final Runnable N = new Runnable() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar.g
        @Override // java.lang.Runnable
        public final void run() {
            QQGuildChatBarLiveFragment.this.pi();
        }
    };
    private final Runnable P = new Runnable() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar.h
        @Override // java.lang.Runnable
        public final void run() {
            QQGuildChatBarLiveFragment.this.mi();
        }
    };
    private final Observer<Integer> R = new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar.i
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            QQGuildChatBarLiveFragment.this.fi((Integer) obj);
        }
    };
    private final fn0.c S = new fn0.c() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar.QQGuildChatBarLiveFragment.1
        @Override // fn0.c
        public void L0(GuildLiveAioMsgListWrap guildLiveAioMsgListWrap) {
            ((com.tencent.mobileqq.guild.live.viewmodel.d) GLiveChannelCore.f226698a.q(com.tencent.mobileqq.guild.live.viewmodel.d.class)).L0(guildLiveAioMsgListWrap);
            if (QQGuildChatBarLiveFragment.this.Q != null && QQGuildChatBarLiveFragment.this.Q.getVisibility() == 0) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar.QQGuildChatBarLiveFragment.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QQGuildChatBarLiveFragment.this.ti();
                    }
                });
            }
        }

        @Override // fn0.c
        public void x(int i3, Bundle bundle) {
            ((com.tencent.mobileqq.guild.live.viewmodel.d) GLiveChannelCore.f226698a.q(com.tencent.mobileqq.guild.live.viewmodel.d.class)).x(i3, bundle);
        }
    };
    private final pf4.b T = new a();
    private final ak U = new b();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends pf4.b {
        a() {
        }

        @Override // pf4.b
        public void a(@PlayTogetherClickType int i3) {
            QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "onPlayTogetherJoinButtonClick : " + i3);
            if (i3 == 0) {
                String string = QQGuildChatBarLiveFragment.this.getResources().getString(R.string.f14862103);
                xr0.a aVar = QQGuildChatBarLiveFragment.this.J;
                if (aVar != null) {
                    aVar.j(string);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b implements ak {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.profile.me.ak
        public void a(ev evVar) {
            aj.q(this);
            if (QQGuildChatBarLiveFragment.this.J == null) {
                QLog.e("QGL.QQGuildChatBarLiveFragment", 1, "onProfileChange, guildLiveAioOperation is null!!!");
                return;
            }
            QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "add self enter tips, from onProfileChange.nick:" + evVar.getNickName());
            ArrayList arrayList = new ArrayList();
            arrayList.add(new LiveUserEnterTipsModel(ch.f(), evVar.getNickName(), QQGuildChatBarLiveFragment.this.ki()));
            QQGuildChatBarLiveFragmentKt.a(QQGuildChatBarLiveFragment.this, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QQGuildChatBarLiveFragment.this.zi(false);
            QQGuildChatBarLiveFragment.this.w3();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class d implements Observer<Boolean> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "onChanged enter room state:  " + bool);
            if (bool.booleanValue()) {
                QQGuildChatBarLiveFragment.this.xi();
            } else {
                QQGuildChatBarLiveFragment.this.yi(true, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class e implements Observer<Void> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Void r16) {
            QQGuildChatBarLiveFragment.this.xi();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class f implements Observer<Boolean> {
        f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            boolean z16;
            QQGuildChatBarLiveFragment qQGuildChatBarLiveFragment = QQGuildChatBarLiveFragment.this;
            if (bool == Boolean.TRUE) {
                z16 = true;
            } else {
                z16 = false;
            }
            qQGuildChatBarLiveFragment.zi(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class g implements Observer<Pair<String, String>> {
        g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Pair<String, String> pair) {
            if (pair != null) {
                QQGuildChatBarLiveFragment.this.wi(pair.getFirst(), pair.getSecond());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class h implements com.tencent.mobileqq.guild.live.livemanager.anchor.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f226597a;

        h(boolean z16) {
            this.f226597a = z16;
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.anchor.f
        public void a() {
            String string;
            QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "onClickPlayTogetherIcon: setPlayTogetherStatus onSuc :" + this.f226597a);
            if (this.f226597a) {
                string = QQGuildChatBarLiveFragment.this.getResources().getString(R.string.f148350zc);
            } else {
                string = QQGuildChatBarLiveFragment.this.getResources().getString(R.string.f148340zb);
            }
            QQToast.makeText(QQGuildChatBarLiveFragment.this.getContext(), string, 0).show();
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.anchor.f
        public void b(Integer num, String str) {
            QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "onClickPlayTogetherIcon: setCanPlayTogether failed ret: " + num + ", msg: " + str);
            String string = QQGuildChatBarLiveFragment.this.getResources().getString(R.string.f148330za);
            QQGuildChatBarLiveFragment.this.vi(1 ^ (this.f226597a ? 1 : 0));
            QQToast.makeText(QQGuildChatBarLiveFragment.this.getContext(), string, 0).show();
        }
    }

    private void Mh(int i3) {
        QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "[configLiveChannelGiftVisibility] visibility = " + i3);
        xr0.a aVar = this.J;
        if (aVar != null) {
            aVar.f(i3);
        }
    }

    private void Nh(int i3, boolean z16, boolean z17) {
        QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "[configLivePlayTogetherIconUI] visibility = " + i3 + ", isStatusOn = " + z16 + ", showAnimation = " + z17);
        xr0.a aVar = this.J;
        if (aVar != null) {
            aVar.l(i3, z16, z17);
        }
    }

    private void Oh(long j3) {
        Bundle bundle;
        if (QLog.isColorLevel()) {
            QLog.d("QGL.QQGuildChatBarLiveFragment", 2, "[initAIO]");
        }
        if (getActivity() != null && getActivity().getIntent() != null) {
            bundle = getActivity().getIntent().getBundleExtra(AppConstants.Key.GUILD_EXTRA);
        } else {
            bundle = null;
        }
        if (bundle == null && getArguments() != null) {
            bundle = getArguments().getBundle(AppConstants.Key.GUILD_EXTRA);
        }
        if (bundle != null) {
            bundle.putLong("extra_key_show_max_msg_seq", j3);
        } else {
            QLog.e("QGL.QQGuildChatBarLiveFragment", 1, "sourceBundle is null!");
        }
        GLiveChannelStartParams s16 = GLiveChannelCore.f226698a.s();
        Ph(s16.getGuildId(), s16.getChannelId(), bundle);
    }

    private void Ph(String str, String str2, Bundle bundle) {
        this.J = ((IGuildLiveAioApi) QRoute.api(IGuildLiveAioApi.class)).initAIOFragment(R.id.f165552wm2, getChildFragmentManager(), str, str2, bundle, this, oe1.a.f422573a.a(), this.S);
        com.tencent.mobileqq.guild.live.livemanager.e showHideAnimHelper = getShowHideAnimHelper();
        if (showHideAnimHelper != null) {
            showHideAnimHelper.Q(this.J);
        }
        this.D = this.J.a();
        this.K = new EnterTipsMessageManagerStrategy(this.J, this);
        QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "[initAIO] finish");
    }

    private void Qh(long j3) {
        boolean z16;
        if (this.D == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "initAIOIfNeed, msgSeq:" + j3 + " mChatFragmentProviderIsNull:" + z16);
        Oh(j3);
        if (z16) {
            Th();
            Rh();
        } else {
            this.E.X1(getActivity());
            this.G.postDelayed(this.N, 500L);
        }
    }

    private void Sh(@NonNull View view) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        ScanningLightView scanningLightView = (ScanningLightView) view.findViewById(R.id.f164565t34);
        this.Q = scanningLightView;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) scanningLightView.getLayoutParams();
        layoutParams.topMargin = gq1.b.b(activity) + ViewUtils.dpToPx(59.0f);
        this.Q.setLayoutParams(layoutParams);
        this.Q.v(true);
        int color = activity.getResources().getColor(R.color.f157145bq1);
        this.Q.setSkeletonColor(color, color);
    }

    private void Th() {
        this.C.n().observe(this.D, new d());
        this.F.Q1().observe(this.D, new e());
        this.F.P1().observe(this.D, new f());
        this.F.O1().observe(this.D, new g());
    }

    private boolean Uh() {
        int e16 = GamePlayTogetherMgr.INSTANCE.a().f().e();
        QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "isPlayTogetherStatusOn :" + e16);
        if (1 == e16) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Vh(NotifyReceivePayGiftChanged notifyReceivePayGiftChanged) {
        if (notifyReceivePayGiftChanged != null) {
            QQGuildChatBarLiveFragmentKt.d(this, notifyReceivePayGiftChanged);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Wh(Boolean bool) {
        ti();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Xh(android.util.Pair pair) {
        boolean z16;
        Object obj = pair.first;
        Boolean bool = Boolean.TRUE;
        boolean z17 = true;
        if (obj == bool) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (pair.second != bool) {
            z17 = false;
        }
        ui(z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Yh(String str) {
        xr0.a aVar;
        QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "[initLiveDataObservers] title = " + str);
        if (!TextUtils.isEmpty(str) && (aVar = this.J) != null) {
            aVar.n(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Zh(LiveChannelRoomInfo liveChannelRoomInfo) {
        xr0.a aVar;
        if (liveChannelRoomInfo != null && (aVar = this.J) != null) {
            aVar.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ai(Integer num) {
        boolean z16;
        boolean z17 = true;
        QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "[initLiveDataObservers] videoScreenState = " + num);
        ji();
        xr0.a aVar = this.J;
        if (aVar != null) {
            aVar.g(num.intValue());
        }
        if (num.intValue() == 2) {
            GLiveChannelCore.f226698a.i().hidePanel();
        }
        GuildLivePlayTogetherGuideView guildLivePlayTogetherGuideView = this.H;
        if (num.intValue() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        guildLivePlayTogetherGuideView.setIsFullScreen(z16);
        if (this.J != null) {
            if (num.intValue() == 2) {
                z17 = false;
            }
            this.J.d(z17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void bi(tq1.b bVar, Integer num) {
        int m3 = bVar.m();
        QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "[initLiveDataObservers] videoStateValue = value");
        xr0.a aVar = this.J;
        if (aVar != null) {
            aVar.g(m3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ci(List list) {
        if (this.J != null && list != null) {
            QQGuildChatBarLiveFragmentKt.a(this, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void di(NotifyGiftRankChanged notifyGiftRankChanged) {
        if (notifyGiftRankChanged != null) {
            QQGuildChatBarLiveFragmentKt.e(this, notifyGiftRankChanged);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ei(Long l3) {
        if (l3 == null) {
            return;
        }
        if (l3.longValue() > -1 && l3.longValue() != this.M) {
            Qh(l3.longValue());
        } else {
            QLog.w("QGL.QQGuildChatBarLiveFragment", 1, "msgSeq:" + l3 + ",curAioMsgSeq:" + this.M + ", ignore.");
        }
        this.M = l3.longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void fi(Integer num) {
        boolean z16;
        if (num.intValue() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "[guildLiveSpeakSwitchObserver] closeSpeak = " + z16);
        xr0.a aVar = this.J;
        if (aVar != null) {
            aVar.i(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gi(int i3, String str, List list, List list2) {
        LiveUserEnterTipsModel liveUserEnterTipsModel;
        if (isDetached()) {
            QLog.e("QGL.QQGuildChatBarLiveFragment", 1, "isDetached.");
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            ev l3 = aj.l();
            if (l3 == null) {
                aj.g(this.U);
                QLog.e("QGL.QQGuildChatBarLiveFragment", 1, "selfUserInfo is null!");
                return;
            } else {
                liveUserEnterTipsModel = new LiveUserEnterTipsModel(ch.f(), l3.getNickName(), ki());
                QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "add self enter tips, from getSelfUserProfileInfo.");
            }
        } else {
            liveUserEnterTipsModel = new LiveUserEnterTipsModel(ch.f(), ch.d0((IGProUserInfo) list.get(0)), ki());
            QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "add self enter tips, from fetchUserInfo.");
        }
        arrayList.add(liveUserEnterTipsModel);
        QQGuildChatBarLiveFragmentKt.a(this, arrayList);
    }

    public static QQGuildLiveModuleBaseFragment hi(Bundle bundle) {
        QQGuildChatBarLiveFragment qQGuildChatBarLiveFragment = new QQGuildChatBarLiveFragment();
        qQGuildChatBarLiveFragment.setArguments(bundle);
        return qQGuildChatBarLiveFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ii(IGProGuildInfo iGProGuildInfo) {
        QLog.e("QGL.QQGuildChatBarLiveFragment", 1, "notifyAIOGuildDataUpdate guildLiveAioOperation = " + this.J);
        xr0.a aVar = this.J;
        if (aVar != null) {
            aVar.k(iGProGuildInfo);
        }
    }

    private void ji() {
        QLog.e("QGL.QQGuildChatBarLiveFragment", 1, "notifyAIOListData guildLiveAioOperation = " + this.J);
        xr0.a aVar = this.J;
        if (aVar != null) {
            aVar.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ki() {
        if (GLiveChannelCore.f226698a.s().getGuildInfo() == null) {
            return true;
        }
        return !r0.isMember();
    }

    private void li() {
        GLiveChannelStartParams s16 = GLiveChannelCore.f226698a.s();
        IGProChannelInfo channelInfo = s16.getChannelInfo();
        if (channelInfo != null && channelInfo.getTopMsgList().isEmpty()) {
            if (!((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).isGuildOrChannelManager(s16.getGuildId(), s16.getChannelId())) {
                QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "sendAnnounceGuideTipsMsg, is not manager.");
                return;
            }
            MediaGuidanceConfig.NavConfigData navConfigData = MediaGuidanceConfig.INSTANCE.a().getNavConfigData();
            if (navConfigData.getTimesLimit() == null) {
                QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "sendAnnounceGuideTipsMsg, getTimesLimit is null.");
                return;
            }
            if (bw.f235485a.K() < navConfigData.getTimesLimit().optInt(0)) {
                int i3 = 2;
                if (navConfigData.getUserEnterTime() != null) {
                    i3 = navConfigData.getUserEnterTime().optInt(0, 2);
                }
                this.G.postDelayed(this.P, i3 * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mi() {
        if (getContext() == null) {
            QLog.w("QGL.QQGuildChatBarLiveFragment", 1, "sendAnnounceGuideTipsRun, check context is null.");
        } else if (this.J != null) {
            bw bwVar = bw.f235485a;
            bwVar.s1(bwVar.K() + 1);
            QQGuildChatBarLiveFragmentKt.b(this, Integer.valueOf(R.drawable.guild_media_announce_msg_tips_icon), HardCodeUtil.qqStr(R.string.f1492311q), "", Integer.valueOf(R.drawable.guild_media_announce_guide_msg_item_bg), getResources().getColor(R.color.f157130bn1));
        }
    }

    private void ni() {
        xr0.a aVar = this.J;
        if (aVar != null) {
            aVar.b();
        }
    }

    private void oi() {
        String guildId = GLiveChannelCore.f226698a.s().getGuildId();
        if (TextUtils.isEmpty(guildId)) {
            QLog.e("QGL.QQGuildChatBarLiveFragment", 1, "sendSelfEnterTipsMsg guildId is empty.");
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(ch.f());
        ((IGPSService) ch.R0(IGPSService.class)).fetchUserInfo(guildId, arrayList, false, new bq() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar.j
            @Override // vh2.bq
            public final void a(int i3, String str, List list, List list2) {
                QQGuildChatBarLiveFragment.this.gi(i3, str, list, list2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pi() {
        boolean S = this.C.S();
        QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "sendSelfEnterTipsMsgIfNeed. shouldShowSelfEnterTips:" + S);
        if (S) {
            this.C.s0(false);
            ni();
            oi();
            li();
        }
    }

    private void qi() {
        ch.f235509b.setElementExposureAndClickParams(this.G.findViewById(R.id.shw), "em_sgrp_aio_gifts", null);
    }

    private void ri() {
        GuildDTReportApiImpl guildDTReportApiImpl = ch.f235509b;
        guildDTReportApiImpl.setElementExposureAndClickParams(this.H, "em_sgrp_stream_bubble", null);
        guildDTReportApiImpl.setElementExposureAndClickParams(this.H.findViewById(R.id.y3u), "em_sgrp_stream_close", null);
    }

    private void si(boolean z16) {
        vi(z16 ? 1 : 0);
        GamePlayTogetherMgr.INSTANCE.a().g(z16, new h(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ti() {
        QLog.d("QGL.QQGuildChatBarLiveFragment", 1, "[stopLoadingShimmer]  ");
        this.Q.setVisibility(8);
    }

    private void ui(boolean z16, boolean z17) {
        if (GLiveChannelCore.f226698a.r().a()) {
            QLog.d("QGL.QQGuildChatBarLiveFragment", 1, "isProgramListType, hideGiftIcon.");
            Mh(8);
        } else if (!z17) {
            QLog.d("QGL.QQGuildChatBarLiveFragment", 1, "hideGiftIcon ");
            Mh(8);
        } else {
            QLog.d("QGL.QQGuildChatBarLiveFragment", 1, "showGiftIcon.");
            qi();
            Mh(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vi(@PlayTogetherStatus int i3) {
        yi(false, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wi(String str, String str2) {
        QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "updatePlayTogetherContent " + str + ", " + str2);
        this.H.i(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xi() {
        yi(false, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yi(boolean z16, @PlayTogetherStatus int i3) {
        boolean z17;
        boolean z18;
        if (!this.E.p2()) {
            if (QLog.isColorLevel()) {
                QLog.i("QGL.QQGuildChatBarLiveFragment", 2, "updatePlayTogetherIconStatus is not game live, set game icon invisible");
            }
            Nh(8, false, false);
            return;
        }
        if (z16) {
            QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "updatePlayTogetherIconStatus force hidden");
            Nh(8, false, false);
            return;
        }
        GamePlayTogetherMgr.Companion companion = GamePlayTogetherMgr.INSTANCE;
        int status = companion.a().f().c().getStatus();
        int e16 = companion.a().f().e();
        if (i3 == -1) {
            i3 = e16;
        }
        boolean booleanValue = ((Boolean) e12.d.b(GLiveChannelCore.f226698a.t().D(), Boolean.FALSE)).booleanValue();
        if (i3 == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "updatePlayTogetherIconStatus isAnchor: " + booleanValue + ", switch: " + i3 + ", teamStatus: " + status);
        this.I = z17;
        if (booleanValue) {
            Nh(0, z17, false);
            return;
        }
        if (!z17) {
            Nh(0, true, false);
            return;
        }
        if (status == 1) {
            z18 = true;
        } else {
            z18 = false;
        }
        Nh(0, true, z18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zi(boolean z16) {
        if (z16) {
            this.H.bringToFront();
            this.H.h(this.G.findViewById(R.id.vxz));
        } else {
            this.H.g();
        }
    }

    protected void Rh() {
        final tq1.b t16 = GLiveChannelCore.f226698a.t();
        e12.b.a(t16.D(), t16.n()).observe(this.D, new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildChatBarLiveFragment.this.Xh((android.util.Pair) obj);
            }
        });
        this.E.h2().observe(this.D, new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildChatBarLiveFragment.this.Yh((String) obj);
            }
        });
        t16.p().observe(this.D, new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildChatBarLiveFragment.this.Zh((LiveChannelRoomInfo) obj);
            }
        });
        t16.k().observe(this.D, new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildChatBarLiveFragment.this.ii((IGProGuildInfo) obj);
            }
        });
        t16.l().observe(this.D, new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildChatBarLiveFragment.this.ai((Integer) obj);
            }
        });
        t16.t().observe(this.D, new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildChatBarLiveFragment.this.bi(t16, (Integer) obj);
            }
        });
        t16.H().observe(this.D, new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildChatBarLiveFragment.this.ci((List) obj);
            }
        });
        com.tencent.mobileqq.guild.util.security.h.f235636d.b(this.L, this.R);
        t16.j().observe(this.D, new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildChatBarLiveFragment.this.di((NotifyGiftRankChanged) obj);
            }
        });
        t16.B().observe(this.D, new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildChatBarLiveFragment.this.Vh((NotifyReceivePayGiftChanged) obj);
            }
        });
        t16.y().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildChatBarLiveFragment.this.Wh((Boolean) obj);
            }
        });
    }

    @Override // ts0.a
    public int S() {
        int dip2px;
        int m3 = GLiveChannelCore.f226698a.t().m();
        if (m3 == 2) {
            return 0;
        }
        if (m3 == 1 && getActivity() != null) {
            return getActivity().findViewById(R.id.wm8).getMeasuredHeight() - getActivity().getResources().getDimensionPixelSize(R.dimen.cgc);
        }
        if (getActivity() != null) {
            dip2px = this.C.u(getActivity());
        } else {
            dip2px = ViewUtils.dip2px(241.0f);
        }
        return 0 + dip2px;
    }

    @Override // ts0.a
    public void V5(boolean z16, boolean z17) {
        boolean z18;
        nq1.g gVar = this.mLiveModuleControl;
        if (gVar != null && gVar.a() != null) {
            this.mLiveModuleControl.a().onAIOPanelChanged(z16);
        }
        GuildLivePlayTogetherGuideView guildLivePlayTogetherGuideView = this.H;
        boolean z19 = true;
        if (z16 && !z17) {
            z18 = true;
        } else {
            z18 = false;
        }
        guildLivePlayTogetherGuideView.setPanelChanged(z18);
        tq1.b bVar = this.C;
        if (z16 && !z17) {
            z19 = false;
        }
        bVar.i0(z19);
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    protected int getLayoutId() {
        return R.layout.ewn;
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    protected void initLiveDataObserver() {
        this.C.G().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildChatBarLiveFragment.this.ei((Long) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    public void initViewModel() {
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        this.E = (com.tencent.mobileqq.guild.live.viewmodel.h) gLiveChannelCore.q(com.tencent.mobileqq.guild.live.viewmodel.h.class);
        com.tencent.mobileqq.guild.live.viewmodel.module.a aVar = (com.tencent.mobileqq.guild.live.viewmodel.module.a) com.tencent.mobileqq.guild.live.viewmodel.i.a(this).get(com.tencent.mobileqq.guild.live.viewmodel.module.a.class);
        this.F = aVar;
        aVar.init();
        String guildId = gLiveChannelCore.s().getGuildId();
        this.L = guildId;
        com.tencent.mobileqq.guild.util.security.h.f235636d.d(guildId);
    }

    protected void initViews(@NonNull View view) {
        if (QLog.isColorLevel()) {
            QLog.d("QGL.QQGuildChatBarLiveFragment", 2, "[initView]");
        }
        this.G = view;
        GuildLivePlayTogetherGuideView guildLivePlayTogetherGuideView = (GuildLivePlayTogetherGuideView) view.findViewById(R.id.wtu);
        this.H = guildLivePlayTogetherGuideView;
        guildLivePlayTogetherGuideView.setClickPlayListener(new c());
        if (getShowHideAnimHelper() != null) {
            getShowHideAnimHelper().k(this.G, "chatBarRootView");
            if (GLiveChannelStartParams.fromLittleWorld()) {
                this.G.setAlpha(0.0f);
                this.G.setTranslationY(200.0f);
            } else {
                getShowHideAnimHelper().j(this.G, "chatBarRootView");
            }
        }
        Sh(view);
    }

    @Override // ts0.a
    public void l0() {
        QLog.d("QGL.QQGuildChatBarLiveFragment", 1, "[onFirstListRender]  ");
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            if (GLiveChannelStartParams.fromLittleWorld()) {
                this.G.animate().setDuration(200L).alpha(1.0f).translationY(0.0f).start();
            }
            pi();
            ti();
            return;
        }
        QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "[onFirstListRender] activity is isFinishing");
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i16 == 539100465 && intent != null && intent.hasExtra("guild_live_msg_seq")) {
            long longExtra = intent.getLongExtra("guild_live_msg_seq", 0L);
            QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "[onActivityResult] msgSeq = " + longExtra);
            xr0.a aVar = this.J;
            if (aVar != null) {
                aVar.m(longExtra);
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "[onBackEvent] ");
        xr0.a aVar = this.J;
        if (aVar != null) {
            return aVar.onBackPressed();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "[onDestroy]:" + hashCode());
        EnterTipsMessageManagerStrategy enterTipsMessageManagerStrategy = this.K;
        if (enterTipsMessageManagerStrategy != null) {
            enterTipsMessageManagerStrategy.f();
        }
        aj.q(this.U);
        com.tencent.mobileqq.guild.util.security.h.f235636d.f(this.L, this.R);
        this.F.destroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.G.removeCallbacks(this.N);
        this.G.removeCallbacks(this.P);
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        GLiveChannelStartParams s16 = GLiveChannelCore.f226698a.s();
        Bundle bundle = (Bundle) extras.get(AppConstants.Key.GUILD_EXTRA);
        if (bundle == null && getArguments() != null) {
            bundle = (Bundle) getArguments().get(AppConstants.Key.GUILD_EXTRA);
        }
        if (bundle != null) {
            bundle.putLong("extra_key_show_max_msg_seq", Long.MAX_VALUE);
        } else {
            QLog.e("QGL.QQGuildChatBarLiveFragment", 1, "extra is null!");
        }
        Ph(s16.getGuildId(), s16.getChannelId(), bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        QLog.d("QGL.QQGuildChatBarLiveFragment", 1, "[onViewCreated]:" + hashCode());
        initViews(view);
        ri();
    }

    @Override // ts0.a
    public void w3() {
        if (com.tencent.mobileqq.guild.util.o.c("QGL.QQGuildChatBarLiveFragment.playTogetherIconClick")) {
            QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "onClickPlayTogetherIcon is fast click");
            return;
        }
        boolean booleanValue = ((Boolean) e12.d.b(GLiveChannelCore.f226698a.t().D(), Boolean.FALSE)).booleanValue();
        QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "onClickPlayTogetherIcon isAnchor: " + booleanValue);
        if (booleanValue) {
            si(!this.I);
        } else if (getActivity() != null) {
            GamePlayTogetherMgr.INSTANCE.a().f().d(getActivity(), this.T);
        }
    }

    @Override // ts0.a
    public void wf() {
        if (!com.tencent.mobileqq.guild.util.o.c("QGL.QQGuildChatBarLiveFragment.leftIconClick") && getActivity() != null) {
            GLiveChannelCore.f226698a.i().i(getActivity());
        }
    }

    @Override // ts0.a
    public void ch(int i3) {
    }
}
