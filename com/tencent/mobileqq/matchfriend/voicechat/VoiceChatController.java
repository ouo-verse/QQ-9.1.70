package com.tencent.mobileqq.matchfriend.voicechat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.Constants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qav.QavDef$MultiUserInfo;
import com.tencent.qav.channel.g;
import com.tencent.qav.monitor.CallingStateMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.manager.PushManager;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes33.dex */
public class VoiceChatController {

    /* renamed from: a, reason: collision with root package name */
    private int f245603a;

    /* renamed from: b, reason: collision with root package name */
    private int f245604b;

    /* renamed from: c, reason: collision with root package name */
    private long f245605c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f245606d;

    /* renamed from: f, reason: collision with root package name */
    private boolean f245608f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f245609g;

    /* renamed from: h, reason: collision with root package name */
    List<com.tencent.mobileqq.matchfriend.bean.a> f245610h;

    /* renamed from: i, reason: collision with root package name */
    List<Pair<Long, Integer>> f245611i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f245615m;

    /* renamed from: s, reason: collision with root package name */
    private RoomInfo f245621s;

    /* renamed from: t, reason: collision with root package name */
    private Runnable f245622t;

    /* renamed from: u, reason: collision with root package name */
    private Runnable f245623u;

    /* renamed from: e, reason: collision with root package name */
    private final ArrayList<WeakReference<com.tencent.mobileqq.matchfriend.voicechat.api.a>> f245607e = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    private boolean f245612j = true;

    /* renamed from: k, reason: collision with root package name */
    private final BroadcastReceiver f245613k = new a();

    /* renamed from: l, reason: collision with root package name */
    private final INetEventHandler f245614l = new b();

    /* renamed from: n, reason: collision with root package name */
    private final Runnable f245616n = new Runnable() { // from class: com.tencent.mobileqq.matchfriend.voicechat.VoiceChatController.3
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            String[] split;
            QLog.i("VoiceChatController", 1, "ensure process instance: " + VoiceChatController.I().hashCode());
            try {
                if (VoiceChatController.this.f245617o != null && VoiceChatController.this.f245617o.get() && VoiceChatController.this.L()) {
                    com.tencent.qav.controller.multi.a c16 = com.tencent.qav.b.b().c();
                    if (c16 == null) {
                        return;
                    }
                    String netWorkQualityRTT = c16.getNetWorkQualityRTT();
                    if (QLog.isDevelopLevel()) {
                        QLog.d("VoiceChatController", 4, "getNetWorkQualityRTT result=" + netWorkQualityRTT);
                    }
                    if (netWorkQualityRTT == null || (split = netWorkQualityRTT.split("\\|")) == null || split.length < 2) {
                        return;
                    }
                    try {
                        boolean z16 = Integer.parseInt(split[0]) < 300;
                        if (z16 != VoiceChatController.this.f245615m) {
                            VoiceChatController.this.f245615m = z16;
                            synchronized (VoiceChatController.this.f245607e) {
                                Iterator it = VoiceChatController.this.f245607e.iterator();
                                while (it.hasNext()) {
                                    WeakReference weakReference = (WeakReference) it.next();
                                    if (weakReference != null && weakReference.get() != 0) {
                                        ((com.tencent.mobileqq.matchfriend.voicechat.api.a) weakReference.get()).e(z16);
                                    }
                                }
                            }
                        }
                    } catch (Exception e16) {
                        QLog.e("VoiceChatController", 1, "parse network quality error. result=" + netWorkQualityRTT, e16);
                    }
                    ThreadManagerV2.executeDelay(this, 16, null, true, 2000L);
                    return;
                }
                QLog.e("VoiceChatController", 1, "mCheckNetWorkQualityRunnable is return!");
            } catch (NullPointerException unused) {
                QLog.e("VoiceChatController", 1, "mCheckNetWorkQualityRunnable is error!");
            }
        }
    };

    /* renamed from: o, reason: collision with root package name */
    private final AtomicBoolean f245617o = new AtomicBoolean(false);

    /* renamed from: p, reason: collision with root package name */
    private final AtomicBoolean f245618p = new AtomicBoolean(false);

    /* renamed from: q, reason: collision with root package name */
    private final AtomicBoolean f245619q = new AtomicBoolean(false);

    /* renamed from: r, reason: collision with root package name */
    private final AtomicBoolean f245620r = new AtomicBoolean(false);

    /* renamed from: v, reason: collision with root package name */
    private final com.tencent.qav.controller.multi.c f245624v = new com.tencent.qav.controller.multi.c() { // from class: com.tencent.mobileqq.matchfriend.voicechat.VoiceChatController.7
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void f() {
            super.f();
            QLog.i("VoiceChatController", 1, "onEnterRoom");
            VoiceChatController.this.f245619q.set(true);
            com.tencent.qav.controller.multi.a c16 = com.tencent.qav.b.b().c();
            if (c16 != null) {
                VoiceChatController.this.W(true);
                c16.enableRemoteAudio(true);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.voicechat.VoiceChatController.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VoiceChatController.this.b0();
                    }
                }, 16, null, true);
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("tencent.video.v2g.match_friend.exit_voice_chat");
            BaseApplication.getContext().registerReceiver(VoiceChatController.this.f245613k, intentFilter);
            synchronized (VoiceChatController.this.f245607e) {
                Iterator it = VoiceChatController.this.f245607e.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference != null && weakReference.get() != 0) {
                        ((com.tencent.mobileqq.matchfriend.voicechat.api.a) weakReference.get()).c();
                    }
                }
            }
            if (VoiceChatController.this.f245620r == null || !VoiceChatController.this.f245620r.get()) {
                VoiceChatController.this.f245622t = ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.voicechat.VoiceChatController.7.2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceChatController.this.f245620r == null || !VoiceChatController.this.f245620r.get()) {
                            QLog.e("VoiceChatController", 1, "wait for peer enter room time out!");
                            VoiceChatController.this.U(1);
                            Iterator it5 = VoiceChatController.this.f245607e.iterator();
                            while (it5.hasNext()) {
                                WeakReference weakReference2 = (WeakReference) it5.next();
                                if (weakReference2 != null && weakReference2.get() != 0) {
                                    ((com.tencent.mobileqq.matchfriend.voicechat.api.a) weakReference2.get()).o();
                                }
                            }
                        }
                    }
                }, 16, null, true, VoiceChatController.this.f245621s == null ? 0L : VoiceChatController.this.f245621s.D);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void g(int i3) {
            super.g(i3);
            QLog.e("VoiceChatController", 1, "onError errorType=" + i3);
            if (4 == i3) {
                QLog.i("VoiceChatController", 1, "interrupted by call");
                VoiceChatController.this.D();
            }
            VoiceChatController.this.U(5);
            synchronized (VoiceChatController.this.f245607e) {
                Iterator it = VoiceChatController.this.f245607e.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference != null && weakReference.get() != 0) {
                        ((com.tencent.mobileqq.matchfriend.voicechat.api.a) weakReference.get()).d(i3);
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void n(int i3) {
            super.n(i3);
            QLog.i("VoiceChatController", 1, "onSelfVolumeUpdate volume=" + i3);
            synchronized (VoiceChatController.this.f245607e) {
                Iterator it = VoiceChatController.this.f245607e.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference != null && weakReference.get() != 0) {
                        ((com.tencent.mobileqq.matchfriend.voicechat.api.a) weakReference.get()).f(i3);
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void p(boolean z16) {
            super.p(z16);
            QLog.i("VoiceChatController", 1, "onSystemCallStateChanged isCalling=" + z16);
            com.tencent.qav.controller.multi.a c16 = com.tencent.qav.b.b().c();
            if (c16 instanceof com.tencent.mobileqq.matchfriend.voicechat.a) {
                if (z16) {
                    if (VoiceChatController.this.f245608f) {
                        c16.enableLocalAudio(false);
                    }
                    ((com.tencent.mobileqq.matchfriend.voicechat.a) c16).P();
                    CallingStateMonitor.k().h();
                } else {
                    if (VoiceChatController.this.f245608f) {
                        c16.enableLocalAudio(true);
                    }
                    ((com.tencent.mobileqq.matchfriend.voicechat.a) c16).O();
                }
            }
            synchronized (VoiceChatController.this.f245607e) {
                Iterator it = VoiceChatController.this.f245607e.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference != null && weakReference.get() != 0) {
                        ((com.tencent.mobileqq.matchfriend.voicechat.api.a) weakReference.get()).g(z16);
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void q(QavDef$MultiUserInfo qavDef$MultiUserInfo, boolean z16) {
            super.q(qavDef$MultiUserInfo, z16);
            QLog.i("VoiceChatController", 1, "onUserAudioAvailable userInfo=" + qavDef$MultiUserInfo + " available=" + z16);
            synchronized (VoiceChatController.this.f245607e) {
                Iterator it = VoiceChatController.this.f245607e.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference != null && weakReference.get() != 0) {
                        ((com.tencent.mobileqq.matchfriend.voicechat.api.a) weakReference.get()).h(qavDef$MultiUserInfo, z16);
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void r(QavDef$MultiUserInfo qavDef$MultiUserInfo) {
            super.r(qavDef$MultiUserInfo);
            if (z(qavDef$MultiUserInfo)) {
                boolean z16 = qavDef$MultiUserInfo.mUin == VoiceChatController.this.f245605c;
                QLog.i("VoiceChatController", 1, "onUserEnter userInfo=" + qavDef$MultiUserInfo + " isSelf=" + z16);
                if (!z16) {
                    VoiceChatController.this.f245620r.set(true);
                    if (VoiceChatController.this.f245622t != null) {
                        ThreadManagerV2.removeJob(VoiceChatController.this.f245622t, 16);
                    }
                    if (VoiceChatController.this.f245621s != null) {
                        VoiceChatController.this.f245621s.E = System.currentTimeMillis();
                    }
                    VoiceChatController.this.U(2);
                }
                if (VoiceChatController.this.L()) {
                    VoiceChatService.s(BaseApplication.getContext());
                    VoiceChatController.this.f245606d = true;
                    VoiceChatController.this.f245623u = ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.voicechat.VoiceChatController.7.3
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public void run() {
                            QLog.i("VoiceChatController", 1, "keep silence from the begin of chat");
                            Iterator it = VoiceChatController.this.f245607e.iterator();
                            while (it.hasNext()) {
                                WeakReference weakReference = (WeakReference) it.next();
                                if (weakReference != null && weakReference.get() != 0) {
                                    ((com.tencent.mobileqq.matchfriend.voicechat.api.a) weakReference.get()).k();
                                }
                            }
                        }
                    }, 16, null, true, 2000L);
                    ThreadManagerV2.executeDelay(VoiceChatController.this.f245616n, 16, null, true, 2000L);
                }
                synchronized (VoiceChatController.this.f245607e) {
                    Iterator it = VoiceChatController.this.f245607e.iterator();
                    while (it.hasNext()) {
                        WeakReference weakReference = (WeakReference) it.next();
                        if (weakReference != null && weakReference.get() != 0) {
                            ((com.tencent.mobileqq.matchfriend.voicechat.api.a) weakReference.get()).i(qavDef$MultiUserInfo);
                            if (VoiceChatController.this.L()) {
                                ((com.tencent.mobileqq.matchfriend.voicechat.api.a) weakReference.get()).b();
                            }
                        }
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void s(QavDef$MultiUserInfo qavDef$MultiUserInfo) {
            super.s(qavDef$MultiUserInfo);
            if (qavDef$MultiUserInfo == null) {
                return;
            }
            boolean z16 = qavDef$MultiUserInfo.mUin == VoiceChatController.this.f245605c;
            QLog.i("VoiceChatController", 1, "onUserExit userInfo=" + qavDef$MultiUserInfo + " isSelf=" + z16);
            if (!z16) {
                VoiceChatController.this.U(4);
            }
            synchronized (VoiceChatController.this.f245607e) {
                Iterator it = VoiceChatController.this.f245607e.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference != null && weakReference.get() != 0) {
                        ((com.tencent.mobileqq.matchfriend.voicechat.api.a) weakReference.get()).j(qavDef$MultiUserInfo);
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void v(QavDef$MultiUserInfo qavDef$MultiUserInfo, boolean z16, int i3) {
            super.v(qavDef$MultiUserInfo, z16, i3);
            if (qavDef$MultiUserInfo == null) {
                return;
            }
            if (VoiceChatController.this.f245606d && qavDef$MultiUserInfo.mUin == VoiceChatController.this.f245605c && i3 > 0) {
                VoiceChatController.this.f245606d = false;
                if (VoiceChatController.this.f245623u != null) {
                    ThreadManagerV2.removeJob(VoiceChatController.this.f245623u, 16);
                }
            }
            synchronized (VoiceChatController.this.f245607e) {
                Iterator it = VoiceChatController.this.f245607e.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference != null && weakReference.get() != 0) {
                        ((com.tencent.mobileqq.matchfriend.voicechat.api.a) weakReference.get()).l(qavDef$MultiUserInfo, z16, i3);
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void w(List<QavDef$MultiUserInfo> list) {
            super.w(list);
            if (list == null) {
                return;
            }
            QLog.i("VoiceChatController", 1, "onUserUpdate userInfoList.size=" + list.size());
            if (QLog.isColorLevel()) {
                Iterator<QavDef$MultiUserInfo> it = list.iterator();
                while (it.hasNext()) {
                    QLog.i("VoiceChatController", 2, "onUserUpdate userInfo=" + it.next());
                }
            }
            synchronized (VoiceChatController.this.f245607e) {
                Iterator it5 = VoiceChatController.this.f245607e.iterator();
                while (it5.hasNext()) {
                    WeakReference weakReference = (WeakReference) it5.next();
                    if (weakReference != null && weakReference.get() != 0) {
                        ((com.tencent.mobileqq.matchfriend.voicechat.api.a) weakReference.get()).m(list);
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void y(boolean z16) {
            super.y(z16);
            QLog.i("VoiceChatController", 1, "onVideoChatCallStateChanged isCalling=" + z16);
            synchronized (VoiceChatController.this.f245607e) {
                Iterator it = VoiceChatController.this.f245607e.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference != null && weakReference.get() != 0) {
                        ((com.tencent.mobileqq.matchfriend.voicechat.api.a) weakReference.get()).n(z16);
                    }
                }
            }
        }

        private boolean z(QavDef$MultiUserInfo qavDef$MultiUserInfo) {
            if (qavDef$MultiUserInfo != null && (qavDef$MultiUserInfo.mUin > 0 || !TextUtils.isEmpty(qavDef$MultiUserInfo.mOpenId))) {
                return true;
            }
            QLog.e("VoiceChatController", 1, "invalid MultiUserInfo:" + qavDef$MultiUserInfo);
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private static final VoiceChatController f245637a = new VoiceChatController();
    }

    VoiceChatController() {
    }

    public static VoiceChatController I() {
        return d.f245637a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(String str) {
        RoomInfo roomInfo = this.f245621s;
        if (roomInfo == null || roomInfo.f245599f <= 0) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("friend_tiny_id", this.f245621s.f245599f);
        bundle.putString("time_text", str);
        QIPCClientHelper.getInstance().getClient().callServer("MatchFriendVoiceChatIpcServer", "InsertVoiceChatRecord", bundle, null);
    }

    private void P(int i3, int i16) {
        Iterator<WeakReference<com.tencent.mobileqq.matchfriend.voicechat.api.a>> it = this.f245607e.iterator();
        while (it.hasNext()) {
            WeakReference<com.tencent.mobileqq.matchfriend.voicechat.api.a> next = it.next();
            if (next != null && next.get() != null) {
                next.get().a(i3, i16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(final Intent intent) {
        final String action = intent.getAction();
        if (action == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.voicechat.VoiceChatController.6
            @Override // java.lang.Runnable
            public void run() {
                if ("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED".equals(intent.getAction())) {
                    int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 10);
                    QLog.d("VoiceChatController", 1, String.format("onReceive ACTION_AUDIO_STATE_CHANGED state=%s", Integer.valueOf(intExtra)));
                    if (intExtra == 12) {
                        int i3 = VoiceChatController.this.f245612j ? -1 : 0;
                        VoiceChatController.this.f245612j = false;
                        VoiceChatController.this.c0(2, i3);
                        return;
                    } else {
                        if (intExtra == 10) {
                            VoiceChatController.this.d0(2);
                            return;
                        }
                        return;
                    }
                }
                if ("android.intent.action.HEADSET_PLUG".equals(action)) {
                    int intExtra2 = intent.getIntExtra("state", -1);
                    QLog.d("VoiceChatController", 1, String.format("onReceive ACTION_HEADSET_PLUG state=%s", Integer.valueOf(intExtra2)));
                    if (intExtra2 == 0) {
                        VoiceChatController.this.d0(0);
                        return;
                    } else {
                        if (intExtra2 == 1) {
                            VoiceChatController.this.c0(0, 3);
                            return;
                        }
                        return;
                    }
                }
                if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(action)) {
                    int intExtra3 = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
                    QLog.d("VoiceChatController", 1, String.format("onReceive ACTION_CONNECTION_STATE_CHANGED state=%s", Integer.valueOf(intExtra3)));
                    if (intExtra3 == 2) {
                        VoiceChatController.this.c0(2, 0);
                        return;
                    } else {
                        if (intExtra3 == 0) {
                            VoiceChatController.this.d0(2);
                            return;
                        }
                        return;
                    }
                }
                if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                    int intExtra4 = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                    QLog.d("VoiceChatController", 1, String.format("onReceive ACTION_STATE_CHANGED state=%s", Integer.valueOf(intExtra4)));
                    if (intExtra4 == 10 || intExtra4 == 13) {
                        VoiceChatController.this.d0(2);
                    }
                }
            }
        }, 16, null, true);
    }

    private void T(long j3) {
        HashMap hashMap = new HashMap();
        if (this.f245621s != null) {
            hashMap.put("kl_new_from_openid", com.tencent.mobileqq.matchfriend.utils.b.d().j());
            hashMap.put("kl_new_to_openid", this.f245621s.f245600h);
        }
        hashMap.put("kl_new_calling_time", Long.valueOf(j3));
        VideoReport.reportEvent("ev_kl_new_calling_time", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i3) {
        HashMap hashMap = new HashMap();
        if (this.f245621s != null) {
            hashMap.put("kl_new_from_openid", com.tencent.mobileqq.matchfriend.utils.b.d().j());
            hashMap.put("kl_new_to_openid", this.f245621s.f245600h);
        }
        hashMap.put("kl_new_calling_status_type", Integer.valueOf(i3));
        VideoReport.reportEvent("ev_kl_new_voice_match_calling_status", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        BaseApplication.getContext().stopService(new Intent(BaseApplication.getContext(), (Class<?>) VoiceChatService.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        boolean c16 = com.tencent.relation.common.utils.d.c(BaseApplication.getContext());
        boolean b16 = com.tencent.relation.common.utils.d.b(BaseApplication.getContext());
        boolean a16 = com.tencent.relation.common.utils.d.a(BaseApplication.getContext());
        int i3 = 3;
        int i16 = 0;
        QLog.d("VoiceChatController", 1, String.format("switchAudioRoute isHeadsetPlugged=%s isBluetoothOn=%s hasBlueToothPermisssion=%s", Boolean.valueOf(c16), Boolean.valueOf(b16), Boolean.valueOf(a16)));
        com.tencent.qav.controller.multi.a c17 = com.tencent.qav.b.b().c();
        if (c17 != null) {
            if (c16) {
                c17.setAudioRoute(0);
            } else {
                i3 = -1;
                if (b16 && a16) {
                    c17.setAudioRoute(2);
                    i16 = 2;
                } else {
                    c17.setAudioRoute(0);
                }
            }
            this.f245603a = i16;
            this.f245604b = i3;
            P(i16, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(int i3) {
        boolean c16 = com.tencent.relation.common.utils.d.c(BaseApplication.getContext());
        boolean b16 = com.tencent.relation.common.utils.d.b(BaseApplication.getContext());
        boolean a16 = com.tencent.relation.common.utils.d.a(BaseApplication.getContext());
        int i16 = 0;
        int i17 = 3;
        QLog.d("VoiceChatController", 1, String.format("switchAudioRoute isHeadsetPlugged=%s isBluetoothOn=%s ihasBlueToothPermisssion=%s current = %d", Boolean.valueOf(c16), Boolean.valueOf(b16), Boolean.valueOf(a16), Integer.valueOf(i3)));
        com.tencent.qav.controller.multi.a c17 = com.tencent.qav.b.b().c();
        if (c17 != null) {
            if (i3 != 0 && c16) {
                c17.setAudioRoute(0);
            } else if (i3 != 2 && b16 && a16) {
                c17.setAudioRoute(2);
                i17 = 0;
                i16 = 2;
            } else {
                c17.setAudioRoute(0);
                i17 = 0;
            }
            this.f245603a = i16;
            this.f245604b = i17;
            P(i16, i17);
        }
    }

    public int B(RoomInfo roomInfo) {
        if (this.f245618p.get()) {
            QLog.i("VoiceChatController", 1, "enterRoom duplicate call.");
            return 0;
        }
        if (!this.f245617o.get()) {
            QLog.e("VoiceChatController", 1, "enterRoom failed: has not initialized");
            return -6;
        }
        if (roomInfo != null && roomInfo.a()) {
            QLog.i("VoiceChatController", 1, "enterRoom roomId=" + roomInfo.f245597d);
            com.tencent.qav.controller.multi.a c16 = com.tencent.qav.b.b().c();
            if (c16 == null) {
                QLog.e("VoiceChatController", 1, "enterRoom failed. multiOperator == null");
                return -5;
            }
            if (!"true".equals(AVBizModuleFactory.getModuleByName(Constants.Business.MATCH_FRIEND).requestAVFocus())) {
                QLog.e("VoiceChatController", 1, "request focus failed");
                return -8;
            }
            com.tencent.qav.a aVar = new com.tencent.qav.a();
            aVar.f342343a = 11;
            aVar.f342344b = 14;
            aVar.f342345c = 1;
            aVar.f342346d = roomInfo.f245597d;
            long j3 = this.f245605c;
            aVar.f342347e = j3;
            aVar.f342348f = String.valueOf(j3);
            aVar.f342349g = 5;
            aVar.f342350h = roomInfo.C;
            this.f245621s = roomInfo;
            int e16 = c16.e(aVar);
            if (e16 != 0) {
                QLog.e("VoiceChatController", 1, "enterRoom failed. result=" + e16);
            } else {
                this.f245618p.set(true);
            }
            return e16;
        }
        QLog.e("VoiceChatController", 1, "invalid roomInfo");
        return -7;
    }

    public void C(long j3) {
        QLog.i("VoiceChatController", 1, "exitRoom delay=" + j3);
        final boolean z16 = false;
        final long j16 = 0;
        if (L()) {
            RoomInfo roomInfo = this.f245621s;
            long currentTimeMillis = (roomInfo == null || roomInfo.E <= 0) ? 0L : System.currentTimeMillis() - this.f245621s.E;
            boolean z17 = currentTimeMillis > 0;
            T(currentTimeMillis / 1000);
            z16 = z17;
            j16 = currentTimeMillis;
        }
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.voicechat.VoiceChatController.5
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (VoiceChatController.this.f245617o.get() && VoiceChatController.this.f245618p.get()) {
                    if (z16) {
                        VoiceChatController.this.K(com.tencent.mobileqq.matchfriend.voicechat.b.a(j16));
                    }
                    QavDef$MultiUserInfo qavDef$MultiUserInfo = new QavDef$MultiUserInfo();
                    qavDef$MultiUserInfo.mUin = VoiceChatController.this.f245605c;
                    synchronized (VoiceChatController.this.f245607e) {
                        Iterator it = VoiceChatController.this.f245607e.iterator();
                        while (it.hasNext()) {
                            WeakReference weakReference = (WeakReference) it.next();
                            if (weakReference != null && weakReference.get() != 0) {
                                ((com.tencent.mobileqq.matchfriend.voicechat.api.a) weakReference.get()).j(qavDef$MultiUserInfo);
                            }
                        }
                    }
                    AVBizModuleFactory.getModuleByName(Constants.Business.MATCH_FRIEND).abandonAVFocus();
                    AVBizModuleFactory.removeModuleByName(Constants.Business.MATCH_FRIEND);
                    VoiceChatController.this.a0();
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.voicechat.VoiceChatController.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.qav.controller.multi.a c16;
                            if (VoiceChatController.this.f245619q.get() && (c16 = com.tencent.qav.b.b().c()) != null) {
                                c16.exitRoom();
                            }
                            VoiceChatController.this.R();
                        }
                    }, 16, null, true);
                }
            }
        }, 16, null, true, j3);
    }

    public RoomInfo E() {
        return this.f245621s;
    }

    public boolean F() {
        return this.f245609g;
    }

    public List<Pair<Long, Integer>> G() {
        return this.f245611i;
    }

    public List<com.tencent.mobileqq.matchfriend.bean.a> H() {
        return this.f245610h;
    }

    public synchronized void J(long j3) {
        QLog.i("VoiceChatController", 1, "init");
        if (this.f245617o.get()) {
            QLog.i("VoiceChatController", 1, "init duplicate call.");
            return;
        }
        this.f245605c = j3;
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        ((PushManager) runtime.getManager(4)).registProxyMessagePush(AppSetting.f(), BaseApplicationImpl.getApplication().getQQProcessName(), "", "MultiVideo.c2sack", "MultiVideo.s2c", "VideoCCSvc.Adaptation");
        AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), this.f245614l);
        com.tencent.qav.log.a.f(new com.tencent.qav.log.c());
        com.tencent.qav.channel.c z16 = com.tencent.qav.channel.c.z();
        z16.A(runtime);
        z16.y(new c());
        com.tencent.qav.controller.a aVar = new com.tencent.qav.controller.a(BaseApplication.getContext(), new com.tencent.mobileqq.matchfriend.voicechat.a(BaseApplication.getContext(), j3, z16));
        com.tencent.qav.b b16 = com.tencent.qav.b.b();
        b16.f(aVar);
        b16.d(BaseApplicationImpl.getApplication().getApplicationContext(), j3, z16);
        b16.a(this.f245624v);
        this.f245617o.set(true);
    }

    public boolean L() {
        return this.f245619q.get() && this.f245620r.get();
    }

    public boolean M() {
        com.tencent.qav.controller.multi.a c16 = com.tencent.qav.b.b().c();
        return c16 != null && c16.isLocalAudioEnable();
    }

    public boolean N() {
        return this.f245617o.get();
    }

    public boolean O() {
        return this.f245603a == 1;
    }

    public synchronized void R() {
        QLog.i("VoiceChatController", 1, "release");
        PushManager pushManager = (PushManager) BaseApplicationImpl.getApplication().getRuntime().getManager(4);
        if (pushManager != null) {
            pushManager.unregistProxyMessagePush(AppSetting.f(), BaseApplicationImpl.getApplication().getQQProcessName());
        }
        AppNetConnInfo.unregisterNetEventHandler(this.f245614l);
        com.tencent.qav.b b16 = com.tencent.qav.b.b();
        b16.e(this.f245624v);
        b16.g();
        synchronized (this.f245607e) {
            this.f245607e.clear();
        }
        this.f245617o.set(false);
        this.f245620r.set(false);
        this.f245619q.set(false);
        this.f245618p.set(false);
        Runnable runnable = this.f245622t;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
        }
        Runnable runnable2 = this.f245623u;
        if (runnable2 != null) {
            ThreadManagerV2.removeJob(runnable2, 16);
        }
    }

    public void V() {
        P(this.f245603a, this.f245604b);
    }

    public void W(boolean z16) {
        com.tencent.qav.controller.multi.a c16 = com.tencent.qav.b.b().c();
        if (c16 != null) {
            c16.enableLocalAudio(z16);
        }
        this.f245608f = z16;
    }

    public void X(boolean z16) {
        this.f245609g = z16;
    }

    public void Y(List<Pair<Long, Integer>> list) {
        this.f245611i = list;
    }

    public void Z(List<com.tencent.mobileqq.matchfriend.bean.a> list) {
        this.f245610h = list;
    }

    public void c0(int i3, int i16) {
        QLog.d("VoiceChatController", 1, String.format("switchAudioRoute route=%s isHeadsetPlugged=%s isBluetoothOn=%s subType = %s", Integer.valueOf(i3), Boolean.valueOf(com.tencent.relation.common.utils.d.c(BaseApplication.getContext())), Boolean.valueOf(com.tencent.relation.common.utils.d.b(BaseApplication.getContext())), Integer.valueOf(i16)));
        com.tencent.qav.controller.multi.a c16 = com.tencent.qav.b.b().c();
        if (c16 != null) {
            c16.setAudioRoute(i3);
            this.f245603a = i3;
            this.f245604b = i16;
            P(i3, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b implements INetEventHandler {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
        public void onNetChangeEvent(boolean z16) {
            if (z16) {
                return;
            }
            QLog.e("VoiceChatController", 1, "onNetChangeEvent network is not available");
            VoiceChatController.this.U(3);
            synchronized (VoiceChatController.this.f245607e) {
                Iterator it = VoiceChatController.this.f245607e.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference != null && weakReference.get() != 0) {
                        ((com.tencent.mobileqq.matchfriend.voicechat.api.a) weakReference.get()).d(3);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if ("tencent.video.v2g.match_friend.exit_voice_chat".equals(action)) {
                VoiceChatController.this.D();
            } else if ("android.intent.action.HEADSET_PLUG".equals(action) || "android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(action) || "android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED".equals(action) || "android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                VoiceChatController.this.Q(intent);
            }
        }
    }

    public void D() {
        C(0L);
    }

    public void A(com.tencent.mobileqq.matchfriend.voicechat.api.a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (this.f245607e) {
            Iterator<WeakReference<com.tencent.mobileqq.matchfriend.voicechat.api.a>> it = this.f245607e.iterator();
            while (it.hasNext()) {
                WeakReference<com.tencent.mobileqq.matchfriend.voicechat.api.a> next = it.next();
                if (next != null && next.get() != null && next.get() == aVar) {
                    return;
                }
            }
            this.f245607e.add(new WeakReference<>(aVar));
        }
    }

    public void S(com.tencent.mobileqq.matchfriend.voicechat.api.a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (this.f245607e) {
            Iterator<WeakReference<com.tencent.mobileqq.matchfriend.voicechat.api.a>> it = this.f245607e.iterator();
            while (it.hasNext()) {
                WeakReference<com.tencent.mobileqq.matchfriend.voicechat.api.a> next = it.next();
                if (next != null && next.get() == aVar) {
                    this.f245607e.remove(next);
                    return;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class c implements g {
        c() {
        }

        @Override // com.tencent.qav.channel.g
        public boolean b(int i3) {
            return false;
        }

        @Override // com.tencent.qav.channel.g
        public boolean a(int i3) {
            boolean z16 = i3 + (-32) == 5;
            com.tencent.qav.log.a.a("VoiceChatController", String.format("isMultiVideoMsgSupport type=0x%X support=%s", Integer.valueOf(i3), Boolean.valueOf(z16)));
            return z16;
        }
    }
}
