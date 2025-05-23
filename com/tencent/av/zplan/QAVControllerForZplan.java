package com.tencent.av.zplan;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.n;
import com.tencent.av.q;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.ui.fragment.api.INTGaInviteFragmentPluginHelperApi;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.ba;
import com.tencent.avcore.jni.data.UinOpenIdResponse;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.utils.GameActivityStatusWatcher;
import com.tencent.zplan.e;
import cooperation.qzone.remote.ServiceConst;
import dx.GAudioZPlanStatus;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QAVControllerForZplan {

    /* renamed from: u, reason: collision with root package name */
    private static volatile QAVControllerForZplan f77245u;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<VideoAppInterface> f77246a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<AVActivity> f77247b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<VideoInviteActivity> f77248c;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<GaInviteLockActivity> f77249d;

    /* renamed from: e, reason: collision with root package name */
    private String f77250e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f77251f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f77252g;

    /* renamed from: h, reason: collision with root package name */
    private SessionInfo f77253h;

    /* renamed from: j, reason: collision with root package name */
    private long f77255j;

    /* renamed from: k, reason: collision with root package name */
    private int f77256k;

    /* renamed from: i, reason: collision with root package name */
    private long[] f77254i = null;

    /* renamed from: l, reason: collision with root package name */
    Runnable f77257l = null;

    /* renamed from: m, reason: collision with root package name */
    HashSet<Long> f77258m = new HashSet<>();

    /* renamed from: n, reason: collision with root package name */
    HashMap<Long, String> f77259n = new HashMap<>();

    /* renamed from: o, reason: collision with root package name */
    HashMap<String, Boolean> f77260o = new HashMap<>();

    /* renamed from: p, reason: collision with root package name */
    boolean f77261p = false;

    /* renamed from: q, reason: collision with root package name */
    boolean f77262q = false;

    /* renamed from: r, reason: collision with root package name */
    VideoObserver f77263r = null;

    /* renamed from: s, reason: collision with root package name */
    f f77264s = null;

    /* renamed from: t, reason: collision with root package name */
    GAudioUIObserver f77265t = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class GroupNetLevelRunnable implements Runnable {
        GroupNetLevelRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            if (r.h0() != null && !QAVControllerForZplan.this.f77262q) {
                boolean z17 = false;
                if (r.h0().a0() == 3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QAVControllerForZplan", 2, "getNetLevel " + r.h0().a0());
                }
                QAVControllerForZplan qAVControllerForZplan = QAVControllerForZplan.this;
                if (r.h0().m0() == 1) {
                    z17 = true;
                }
                qAVControllerForZplan.D(z17, z16);
                if (QAVControllerForZplan.this.f77257l != null && r.h0() != null && !QAVControllerForZplan.this.f77262q && r.h0().D() != null) {
                    r.h0().D().postDelayed(QAVControllerForZplan.this.f77257l, 2000L);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QAVControllerForZplan", 2, "VideoController.getInstance() == null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c extends e.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f77274d;

        c(d dVar) {
            this.f77274d = dVar;
        }

        @Override // com.tencent.zplan.e
        public void T0(boolean z16, String str) {
            boolean z17;
            if (z16) {
                QLog.d("QAVControllerForZplan", 1, "[handleInviteComing] in zplan home str " + str);
                try {
                    z17 = new JSONObject(str).getBoolean("isInSmallHomeMod");
                } catch (JSONException e16) {
                    e16.printStackTrace();
                    z17 = false;
                }
                this.f77274d.a(z17);
                return;
            }
            QLog.d("QAVControllerForZplan", 1, "[handleInviteComing] not in zplan home");
            this.f77274d.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface d {
        void a(boolean z16);

        void b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class e extends VideoObserver {
        e() {
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void e(long j3, int i3, String str) {
            String currentAccountUin = ((VideoAppInterface) QAVControllerForZplan.this.f77246a.get()).getCurrentAccountUin();
            if (!TextUtils.isEmpty(str) && r.h0() != null && !QAVControllerForZplan.this.f77262q && n.e().f() != null && !str.equals(n.e().f().f73091w)) {
                QAVControllerForZplan.this.G(11, str, currentAccountUin, true);
                QLog.d("QAVControllerForZplan", 1, "onClose not current uin");
                return;
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 5) {
                                if (i3 == 12) {
                                    if (n.e().f().G) {
                                        QAVControllerForZplan.this.G(5, str, currentAccountUin, true);
                                    } else {
                                        QAVControllerForZplan.this.G(5, currentAccountUin, str, false);
                                    }
                                    QAVControllerForZplan.this.k();
                                }
                            } else {
                                QAVControllerForZplan.this.I(1, str);
                            }
                            QAVControllerForZplan.this.f77250e = null;
                            QLog.d("QAVControllerForZplan", 1, "onClose " + i3 + " " + str);
                        }
                    }
                }
                if (r.h0() == null || QAVControllerForZplan.this.f77262q || n.e().f() == null || !n.e().f().G) {
                    QAVControllerForZplan.this.G(3, currentAccountUin, str, false);
                } else {
                    QAVControllerForZplan.this.G(3, str, currentAccountUin, true);
                }
                QAVControllerForZplan.this.k();
                QAVControllerForZplan.this.f77250e = null;
                QLog.d("QAVControllerForZplan", 1, "onClose " + i3 + " " + str);
            }
            if (r.h0() == null || QAVControllerForZplan.this.f77262q || n.e().f() == null || !n.e().f().G) {
                QAVControllerForZplan.this.G(4, currentAccountUin, str, false);
            } else {
                QAVControllerForZplan.this.G(4, str, currentAccountUin, true);
            }
            QAVControllerForZplan.this.k();
            QAVControllerForZplan.this.f77250e = null;
            QLog.d("QAVControllerForZplan", 1, "onClose " + i3 + " " + str);
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void g(long j3) {
            SessionInfo f16 = n.e().f();
            String str = f16.f73091w;
            String currentAccountUin = ((VideoAppInterface) QAVControllerForZplan.this.f77246a.get()).getCurrentAccountUin();
            if (n.e().f().G) {
                QAVControllerForZplan.this.F(2, str, currentAccountUin, f16.f73100y0, f16.f73104z0, true);
            } else {
                QAVControllerForZplan.this.F(2, currentAccountUin, str, f16.f73100y0, f16.f73104z0, false);
            }
            QLog.d("QAVControllerForZplan", 1, "onConnected " + str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void p(String str, String str2) {
            QAVControllerForZplan.this.I(0, str);
            QLog.d("QAVControllerForZplan", 1, "onInviteReached " + str + " " + str2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void u() {
            QLog.d("QAVControllerForZplan", 1, "onNetworkDisconnect");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class f extends BroadcastReceiver {
        f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            boolean z16 = false;
            if (action.equals(IECScreenReceiver.ACTION_SCREEN_ON)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("ACTION_SCREEN_ON, VideoController.getInstance()[");
                if (r.h0() != null) {
                    z16 = true;
                }
                sb5.append(z16);
                QLog.d("QAVControllerForZplan", 1, sb5.toString());
                return;
            }
            if (action.equals(IECScreenReceiver.ACTION_SCREEN_OFF)) {
                QLog.d("QAVControllerForZplan", 1, "ACTION_SCREEN_OFF, why[" + intent.getIntExtra("why", 0) + "]");
                if (r.h0() != null && !QAVControllerForZplan.this.f77262q) {
                    r.h0().L3("backgroundReason", "4");
                    q.a.f74207a = "4";
                    r.h0().J2(false);
                    QLog.d("QAVControllerForZplan", 1, "ACTION_SCREEN_OFF, switch to normal mode");
                }
                com.tencent.zplan.engine.a.f385563g.k("tencent.video.v2z.notify_need_restore_game_mode", null, null);
                return;
            }
            if (action.equals("android.intent.action.USER_PRESENT")) {
                QLog.d("QAVControllerForZplan", 1, "ACTION_USER_PRESENT");
                return;
            }
            if (action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                String stringExtra = intent.getStringExtra("reason");
                QLog.d("QAVControllerForZplan", 1, "ACTION_CLOSE_SYSTEM_DIALOGS, reason[" + stringExtra + "]");
                if (GameActivityStatusWatcher.InnerRecevier.SYSTEM_DIALOG_REASON_HOME_KEY.equalsIgnoreCase(stringExtra) && r.h0() != null && !QAVControllerForZplan.this.f77262q) {
                    r.h0().L3("backgroundReason", "1");
                    q.a.f74207a = "1";
                    r.h0().J2(false);
                    com.tencent.zplan.engine.a.f385563g.k("tencent.video.v2z.notify_need_restore_game_mode", null, null);
                    QLog.d("QAVControllerForZplan", 1, "SYSTEM_HOME_KEY, switch to normal mode");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class g extends GAudioUIObserver {
        g() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void F(long j3, long j16, boolean z16, boolean z17) {
            QLog.d("QAVControllerForZplan", 1, "onMemberJoin groupId:" + j3 + " friendUin " + j16);
            if (r.h0() != null && !QAVControllerForZplan.this.f77262q && n.e().f() != null) {
                if (QAVControllerForZplan.this.f77259n.containsKey(Long.valueOf(j16))) {
                    SessionInfo f16 = n.e().f();
                    QAVControllerForZplan qAVControllerForZplan = QAVControllerForZplan.this;
                    qAVControllerForZplan.H(8, "", qAVControllerForZplan.f77259n.get(Long.valueOf(j16)), f16.f73100y0, f16.f73104z0);
                } else {
                    SessionInfo f17 = n.e().f();
                    r.h0().W().getRoomUinOpenIdMap(((VideoAppInterface) QAVControllerForZplan.this.f77246a.get()).getLongAccountUin(), r.h0().W().getRoomId(), f17.S0, f17.f73063p);
                    QAVControllerForZplan.this.f77258m.add(Long.valueOf(j16));
                }
                if (j16 != ((VideoAppInterface) QAVControllerForZplan.this.f77246a.get()).getLongAccountUin()) {
                    QAVControllerForZplan.this.M(j16, true);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void G(long j3, long j16, boolean z16, boolean z17) {
            boolean z18;
            boolean z19 = true;
            QLog.d("QAVControllerForZplan", 1, "onMemberLeave groupId:" + j3 + " friendUin" + j16);
            if (r.h0() != null && !QAVControllerForZplan.this.f77262q) {
                ArrayList<com.tencent.av.e> Y = r.h0().Y();
                long longAccountUin = ((VideoAppInterface) QAVControllerForZplan.this.f77246a.get()).getLongAccountUin();
                if (Y.size() != 0 && (Y.size() != 1 || Y.get(0).f73701a != longAccountUin)) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                if (n.e().f().f73063p != 17) {
                    z19 = false;
                }
                if (z18 && z19) {
                    r.h0().a2(r.h0().b0(), r.h0().X(), 72);
                    QLog.d("QAVControllerForZplan", 2, "onMemberLeave: quitGAudioChat ");
                    QAVControllerForZplan.this.H(7, "", String.valueOf(longAccountUin), -1L, -1L);
                    QAVControllerForZplan.this.f77259n.clear();
                }
            }
            if (QAVControllerForZplan.this.f77259n.containsKey(Long.valueOf(j16))) {
                String str = QAVControllerForZplan.this.f77259n.get(Long.valueOf(j16));
                QLog.d("QAVControllerForZplan", 2, "onMemberLeave: find friend OpenID " + str);
                QAVControllerForZplan.this.H(9, "", str, -1L, -1L);
                QAVControllerForZplan.this.f77259n.remove(Long.valueOf(j16));
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void g(long j3, long j16) {
            QLog.d("QAVControllerForZplan", 1, "onCreateRoomSuc groupId:" + j16);
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void k(long j3, long j16) {
            QLog.d("QAVControllerForZplan", 1, "onEnterRoomSuc groupId:" + j16);
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void m(UinOpenIdResponse uinOpenIdResponse) {
            SessionInfo f16;
            if (uinOpenIdResponse == null) {
                QLog.e("QAVControllerForZplan", 1, "onGAudioGetOpenID response null");
                return;
            }
            HashSet<Long> hashSet = QAVControllerForZplan.this.f77258m;
            if ((hashSet == null || hashSet.isEmpty()) && !QAVControllerForZplan.this.f77261p) {
                QLog.e("QAVControllerForZplan", 1, "onGAudioGetOpenID no wait op");
                return;
            }
            for (Map.Entry<Long, String> entry : uinOpenIdResponse.pairs.entrySet()) {
                QLog.d("QAVControllerForZplan", 2, "onGetUinOpenIdRespond: Key = " + entry.getKey() + ", Value = " + entry.getValue());
                if (!QAVControllerForZplan.this.f77259n.containsKey(entry.getKey())) {
                    QAVControllerForZplan.this.f77259n.put(entry.getKey(), entry.getValue());
                }
                if (QAVControllerForZplan.this.f77258m.contains(entry.getKey())) {
                    QLog.d("QAVControllerForZplan", 2, "onGetUinOpenIdRespond: uin: " + entry.getKey() + " openId " + entry.getValue());
                    if (r.h0() != null && !QAVControllerForZplan.this.f77262q && (f16 = n.e().f()) != null) {
                        QLog.d("QAVControllerForZplan", 1, "onGAudioGetOpenID onMemberJoin connectedTime:" + f16.f73100y0 + " otherTerminalChattingTime " + f16.f73104z0);
                        QAVControllerForZplan.this.H(8, "", entry.getValue(), f16.f73100y0, f16.f73104z0);
                    }
                }
            }
            if (QAVControllerForZplan.this.f77261p) {
                QLog.d("QAVControllerForZplan", 2, "onGetUinOpenIdRespond for enter");
                ArrayList<String> arrayList = new ArrayList<>(QAVControllerForZplan.this.f77259n.values());
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("callList", arrayList);
                com.tencent.zplan.engine.a.f385563g.k("tencent.video.v2z.call_list_return", bundle, null);
                QAVControllerForZplan.this.f77261p = false;
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void z(long j3, int i3, int i16) {
            QLog.d("QAVControllerForZplan", 1, "onGroupVideoChatClosed relationId:" + j3 + " reason: " + i3 + " avtype" + i16);
            if (r.h0() != null && !QAVControllerForZplan.this.f77262q && r.h0().Y().size() <= 1) {
                r.h0().a2(r.h0().b0(), r.h0().X(), 72);
                QAVControllerForZplan qAVControllerForZplan = QAVControllerForZplan.this;
                qAVControllerForZplan.H(7, ((VideoAppInterface) qAVControllerForZplan.f77246a.get()).getCurrentAccountUin(), "", -1L, -1L);
            }
            QAVControllerForZplan.this.f77250e = null;
            QAVControllerForZplan.this.l(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(int i3, String str, String str2, long j3, long j16, boolean z16) {
        com.tencent.zplan.engine.a aVar = com.tencent.zplan.engine.a.f385563g;
        aVar.l(this.f77246a.get().getApp());
        Bundle bundle = new Bundle();
        bundle.putInt("status", i3);
        bundle.putString("caller", str);
        bundle.putString("callee", str2);
        bundle.putBoolean("isReceiver", z16);
        bundle.putLong("connectedTime", j3);
        bundle.putLong("otherTerChatTime", j16);
        aVar.k("tencent.video.v2z.on_audio_call_status", bundle, null);
        QLog.d("QAVControllerForZplan", 1, "onQQDoubleAudioCallEventToZplan status=" + i3 + " caller=" + str + " callee=" + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(int i3, String str, String str2, boolean z16) {
        F(i3, str, str2, -1L, -1L, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(int i3, String str, String str2, long j3, long j16) {
        com.tencent.zplan.engine.a aVar = com.tencent.zplan.engine.a.f385563g;
        aVar.l(this.f77246a.get().getApp());
        Bundle bundle = new Bundle();
        bundle.putInt("status", i3);
        bundle.putString("caller", str);
        bundle.putString("callee", str2);
        bundle.putLong("connectedTime", j3);
        bundle.putLong("otherTerChatTime", j16);
        aVar.k("tencent.video.v2z.on_audio_call_status", bundle, null);
        QLog.d("QAVControllerForZplan", 1, "onQQGAudioCallEventToZplan status=" + i3 + " caller=" + str + " callee=" + str2);
    }

    private boolean V() {
        WeakReference<VideoAppInterface> weakReference = this.f77246a;
        if (weakReference == null || weakReference.get() == null) {
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ == null) {
                QLog.d("QAVControllerForZplan", 1, "onReceive mobileQQ is null!");
                return false;
            }
            WeakReference<VideoAppInterface> weakReference2 = new WeakReference<>((VideoAppInterface) mobileQQ.peekAppRuntime());
            this.f77246a = weakReference2;
            if (weakReference2.get() == null) {
                QLog.d("QAVControllerForZplan", 1, "onReceive app is null!");
                return false;
            }
        }
        return true;
    }

    public static void W(VideoAppInterface videoAppInterface, boolean z16, boolean z17) {
        if (r.h0() == null) {
            QLog.e("lgx", 1, "zplanHomeGoBack error: videoController is null.");
            return;
        }
        n.e().f().H2 = false;
        r.h0().J2(false);
        if (z16) {
            if (n.e().f().f73035i == 1 && z17) {
                r.h0().s1(false);
                return;
            }
            if (n.e().f().f73035i == 3 && z17) {
                String b16 = new GAudioZPlanStatus(0, videoAppInterface.getCurrentAccountUin(), String.valueOf(System.currentTimeMillis())).b();
                r.h0().W().NotifyBusinessExtInfo(videoAppInterface.getCurrentAccountUin(), 1, b16, b16.length());
                QLog.i("QAVControllerForZplan", 2, "notify small home status " + b16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(boolean z16) {
        WeakReference<VideoAppInterface> weakReference;
        if (z16) {
            if (this.f77264s == null) {
                this.f77264s = new f();
                WeakReference<VideoAppInterface> weakReference2 = this.f77246a;
                if (weakReference2 != null && weakReference2.get() != null) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
                    intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
                    intentFilter.addAction("android.intent.action.USER_PRESENT");
                    intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
                    this.f77246a.get().getApp().registerReceiver(this.f77264s, intentFilter);
                    QLog.d("QAVControllerForZplan", 1, "register screen action receiver suc.");
                    return;
                }
                QLog.e("QAVControllerForZplan", 1, "startSensor error, mSreenActionReceive had exist");
                return;
            }
            return;
        }
        if (this.f77264s != null && (weakReference = this.f77246a) != null && weakReference.get() != null) {
            try {
                this.f77246a.get().getApp().unregisterReceiver(this.f77264s);
                this.f77264s = null;
            } catch (Exception e16) {
                QLog.d("QAVControllerForZplan", 1, "unregisterReceiver error : " + e16);
            }
            QLog.d("QAVControllerForZplan", 1, "unregister screen action receiver");
            return;
        }
        QLog.e("QAVControllerForZplan", 1, "unregister ScreenActionReceive error.");
    }

    public static QAVControllerForZplan p() {
        if (f77245u == null) {
            synchronized (QAVControllerForZplan.class) {
                if (f77245u == null) {
                    f77245u = new QAVControllerForZplan();
                }
            }
        }
        return f77245u;
    }

    public static boolean w() {
        if (f77245u != null) {
            return true;
        }
        return false;
    }

    public void A(String str, String str2, String str3, boolean z16, long j3) {
        this.f77250e = str;
        this.f77252g = z16;
        this.f77253h = n.e().f();
        Bundle bundle = new Bundle();
        bundle.putString("peerUin", str2);
        bundle.putString("peerNickName", str3);
        bundle.putLong("roomId", j3);
        com.tencent.zplan.engine.a.f385563g.k("tencent.video.v2z.on_receive_gaudio_call", bundle, null);
        QLog.d("QAVControllerForZplan", 1, "notifyInviteGAudio " + str);
    }

    public void B(long j3, long j16) {
        Bundle bundle = new Bundle();
        bundle.putLong("connectedTime", j3);
        bundle.putLong("otherTerChatTime", j16);
        com.tencent.zplan.engine.a.f385563g.k("tencent.video.v2z.notify_conneceted_time", bundle, null);
    }

    public void C() {
        H(10, this.f77259n.get(Long.valueOf(this.f77246a.get().getLongAccountUin())), this.f77246a.get().getCurrentAccountUin(), -1L, -1L);
    }

    public void D(boolean z16, boolean z17) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isWifi", z16);
        bundle.putBoolean("isBad", z17);
        com.tencent.zplan.engine.a.f385563g.k("tencent.video.v2z.notify_net_status", bundle, null);
    }

    public void E(long j3, boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putLong("uin", j3);
        bundle.putBoolean("isSpeaking", z16);
        com.tencent.zplan.engine.a.f385563g.k("tencent.video.v2z.notify_speaking_status", bundle, null);
    }

    public void I(int i3, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("retCode", i3);
        bundle.putString("peerUin", str);
        com.tencent.zplan.engine.a.f385563g.k("tencent.video.v2z.on_request_audio_ret", bundle, null);
    }

    public void J(String str, boolean z16) {
        this.f77260o.put(str, Boolean.valueOf(z16));
    }

    public void K() {
        WeakReference<GaInviteLockActivity> weakReference = this.f77249d;
        if (weakReference != null && weakReference.get() != null) {
            this.f77249d.get().finish();
            this.f77249d = null;
            WeakReference<VideoAppInterface> weakReference2 = this.f77246a;
            if (weakReference2 != null && weakReference2.get() != null) {
                com.tencent.zplan.engine.a.f385563g.n(this.f77246a.get().getApplicationContext());
                QLog.e("QAVControllerForZplan", 1, "[refuseGroupInviteAudio] unRegisterActionIpcHelper");
            }
        }
        if (!V()) {
            QLog.e("QAVControllerForZplan", 1, "[refuseGroupInviteAudio] app empty.");
            return;
        }
        WeakReference<VideoAppInterface> weakReference3 = this.f77246a;
        if (weakReference3 != null && weakReference3.get() != null) {
            SessionInfo i3 = n.e().i(this.f77250e);
            if (i3 != null && r.h0() != null && !this.f77262q) {
                r.h0().P0(QQAudioHelper.b(), i3.S0, i3.P0);
                this.f77250e = null;
                QLog.d("QAVControllerForZplan", 1, "refuseGroupInviteAudio suc.");
                return;
            }
            QLog.e("QAVControllerForZplan", 1, "[refuseGroupInviteAudio] invalid param.");
        }
    }

    public void L() {
        WeakReference<VideoAppInterface> weakReference;
        WeakReference<VideoInviteActivity> weakReference2 = this.f77248c;
        if (weakReference2 != null && weakReference2.get() != null) {
            this.f77248c.get().finish();
            this.f77248c = null;
            WeakReference<VideoAppInterface> weakReference3 = this.f77246a;
            if (weakReference3 != null && weakReference3.get() != null) {
                com.tencent.zplan.engine.a.f385563g.n(this.f77246a.get().getApplicationContext());
                QLog.e("QAVControllerForZplan", 1, "[refuseInviteAudio] unRegisterActionIpcHelper");
            }
        }
        if (!V()) {
            QLog.e("QAVControllerForZplan", 1, "[refuseInviteAudio] app empty.");
            return;
        }
        SessionInfo i3 = n.e().i(this.f77250e);
        if (i3 != null && (weakReference = this.f77246a) != null && weakReference.get() != null && r.h0() != null && !this.f77262q) {
            r.h0().g(QQAudioHelper.b(), i3.f73091w, 1, false);
            r.h0().r(i3.f73091w, 248);
            r.h0().j2(248);
            r.h0().q(i3.f73091w, 1);
            QLog.d("QAVControllerForZplan", 1, "refuseInviteAudio suc.");
            this.f77250e = null;
            return;
        }
        QLog.e("QAVControllerForZplan", 1, "[refuseInviteAudio] invalid param.");
    }

    public void M(final long j3, final boolean z16) {
        if (r.h0() != null && !this.f77262q) {
            final long g06 = r.h0().g0();
            final long P = r.h0().P();
            final int i3 = n.e().f().f73035i;
            r.h0().D().postDelayed(new Runnable() { // from class: com.tencent.av.zplan.QAVControllerForZplan.4
                @Override // java.lang.Runnable
                public void run() {
                    boolean z17;
                    long j16;
                    String valueOf = String.valueOf(j3);
                    boolean z18 = false;
                    if (QAVControllerForZplan.this.f77260o.containsKey(valueOf)) {
                        z17 = QAVControllerForZplan.this.f77260o.get(valueOf).booleanValue();
                        QAVControllerForZplan.this.f77260o.remove(valueOf);
                    } else {
                        z17 = false;
                    }
                    if (z16) {
                        if (z17) {
                            DataReport.T(null, "dc00898", "", "", "0X800C274", "0X800C274", 0, 0, String.valueOf(g06), "", "", "");
                            return;
                        } else {
                            DataReport.T(null, "dc00898", "", "", "0X800C272", "0X800C272", 0, 0, String.valueOf(g06), "", "", "");
                            return;
                        }
                    }
                    if (z17) {
                        int i16 = i3;
                        int i17 = 1;
                        if (i16 == 3 || i16 == 4) {
                            z18 = true;
                        }
                        if (z18) {
                            i17 = 2;
                        }
                        int i18 = i17;
                        if (z18) {
                            j16 = g06;
                        } else {
                            j16 = P;
                        }
                        DataReport.T(null, "dc00898", "", "", "0X800C273", "0X800C273", i18, 0, String.valueOf(j16), "", "", "");
                    }
                }
            }, 1000L);
        }
    }

    public void N(AVActivity aVActivity, VideoAppInterface videoAppInterface) {
        this.f77247b = new WeakReference<>(aVActivity);
        this.f77246a = new WeakReference<>(videoAppInterface);
        this.f77250e = null;
        this.f77262q = false;
    }

    public void O(AVActivity aVActivity, VideoAppInterface videoAppInterface) {
        int i3;
        N(aVActivity, videoAppInterface);
        if (this.f77263r == null && videoAppInterface != null) {
            e eVar = new e();
            this.f77263r = eVar;
            videoAppInterface.addObserver(eVar);
            QLog.d("QAVControllerForZplan", 1, "setAVActivityContext addObserver");
        }
        if (r.h0() != null && !this.f77262q && n.e().f() != null) {
            i3 = n.e().f().f73035i;
        } else {
            i3 = 0;
        }
        QLog.d("QAVControllerForZplan", 1, "setAVActivityContext addGAudioObserver " + i3);
        if (i3 == 3 && this.f77265t == null && videoAppInterface != null) {
            g gVar = new g();
            this.f77265t = gVar;
            videoAppInterface.addObserver(gVar);
            QLog.d("QAVControllerForZplan", 1, "setAVActivityContext addGAudioObserver");
        }
        QLog.d("QAVControllerForZplan", 1, "setAVActivityContext.");
        WeakReference<VideoAppInterface> weakReference = this.f77246a;
        if (weakReference != null && weakReference.get() != null) {
            com.tencent.zplan.engine.a.f385563g.l(this.f77246a.get().getApplicationContext());
            QLog.d("QAVControllerForZplan", 1, "[setAVActivityContext] registerActionIpcHelper.");
        }
        if (i3 == 3) {
            T();
        }
    }

    public void P(GaInviteLockActivity gaInviteLockActivity, VideoAppInterface videoAppInterface) {
        WeakReference<GaInviteLockActivity> weakReference = new WeakReference<>(gaInviteLockActivity);
        this.f77249d = weakReference;
        this.f77254i = weakReference.get().getIntent().getLongArrayExtra("memberList");
        this.f77255j = this.f77249d.get().getGroupId();
        this.f77256k = this.f77249d.get().getUinType();
        this.f77246a = new WeakReference<>(videoAppInterface);
        QLog.d("QAVControllerForZplan", 1, "setGroupInviteActivityContext. IsBindZplanProcess=");
        WeakReference<VideoAppInterface> weakReference2 = this.f77246a;
        if (weakReference2 != null && weakReference2.get() != null) {
            com.tencent.zplan.engine.a.f385563g.l(this.f77246a.get().getApplicationContext());
            QLog.d("QAVControllerForZplan", 1, "[setGroupInviteActivityContext] registerActionIpcHelper.");
        }
        if (this.f77265t == null && videoAppInterface != null) {
            g gVar = new g();
            this.f77265t = gVar;
            videoAppInterface.addObserver(gVar);
            QLog.d("QAVControllerForZplan", 1, "setGroupInviteActivityContext addObserver");
        }
    }

    public void Q(VideoInviteActivity videoInviteActivity, VideoAppInterface videoAppInterface) {
        this.f77248c = new WeakReference<>(videoInviteActivity);
        this.f77246a = new WeakReference<>(videoAppInterface);
        QLog.d("QAVControllerForZplan", 1, "setInviteActivityContext.");
        WeakReference<VideoAppInterface> weakReference = this.f77246a;
        if (weakReference != null && weakReference.get() != null) {
            com.tencent.zplan.engine.a.f385563g.l(this.f77246a.get().getApplicationContext());
            QLog.d("QAVControllerForZplan", 1, "[setInviteActivityContext] registerActionIpcHelper.");
        }
        if (this.f77263r == null && videoAppInterface != null) {
            e eVar = new e();
            this.f77263r = eVar;
            videoAppInterface.addObserver(eVar);
            QLog.d("QAVControllerForZplan", 1, "setInviteActivityContext addObserver");
        }
    }

    public void R(boolean z16) {
        this.f77251f = z16;
    }

    public boolean S(Context context, String str) {
        String str2;
        if (n() != 0) {
            QLog.e("QAVControllerForZplan", 1, "is already in audio");
            if (o() == 1) {
                QLog.i("QAVControllerForZplan", 1, "invite in double forbid");
                H(12, "", str, -1L, -1L);
                return false;
            }
            if (o() == 3 && n.e().f().f73063p != 17) {
                QLog.i("QAVControllerForZplan", 1, "invite in group forbid");
                H(12, "", str, -1L, -1L);
                return false;
            }
            if (n.e().f().f73063p != 17) {
                return false;
            }
            QLog.i("QAVControllerForZplan", 1, "invite user openId is " + str);
            if (this.f77259n.containsValue(str)) {
                QLog.i("QAVControllerForZplan", 1, "invite user openId is duplicate");
                H(12, "", str, -1L, -1L);
                return false;
            }
            r.h0().T0(null, false, new String[]{str});
            return true;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        if (V()) {
            str2 = this.f77246a.get().G(1, str, null);
        } else {
            str2 = str;
        }
        Intent intent = new Intent(context, (Class<?>) AVActivity.class);
        intent.addFlags(262144);
        intent.addFlags(131072);
        intent.putExtra("uinType", 1);
        intent.putExtra("uin", str);
        intent.putExtra("GroupId", this.f77246a.get().getCurrentAccountUin());
        intent.putExtra("name", str2);
        intent.putExtra("isAudioMode", true);
        intent.putExtra("isSender", true);
        intent.putExtra(IProfileProtocolConst.PARAM_IS_FRIEND, true);
        intent.putExtra("isInZplanHome", true);
        intent.putExtra("Type", 0);
        intent.putExtra("MultiAVType", 17);
        intent.putParcelableArrayListExtra("invitelist", q(arrayList));
        intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 3);
        context.startActivity(intent);
        l(true);
        QLog.d("QAVControllerForZplan", 1, "startAudioRequest uin=" + str + " nick=" + str2);
        return true;
    }

    void T() {
        if (this.f77257l == null) {
            this.f77257l = new GroupNetLevelRunnable();
        }
        if (r.h0() != null && !this.f77262q && r.h0().D() != null) {
            r.h0().D().removeCallbacks(this.f77257l);
            r.h0().D().postDelayed(this.f77257l, 2000L);
        }
        QLog.d("QAVControllerForZplan", 1, "startQueryNetLevelTimer");
    }

    void U() {
        if (this.f77257l != null && r.h0() != null && !this.f77262q && r.h0().D() != null) {
            r.h0().D().removeCallbacks(this.f77257l);
        }
        this.f77257l = null;
        QLog.d("QAVControllerForZplan", 1, "stopQueryNetLevelTimer");
    }

    public void g(Context context) {
        WeakReference<GaInviteLockActivity> weakReference = this.f77249d;
        if (weakReference != null && weakReference.get() != null) {
            this.f77249d.get().finish();
            this.f77249d = null;
        }
        SessionInfo i3 = n.e().i(this.f77250e);
        u();
        if (i3 == null) {
            QLog.d("QAVControllerForZplan", 1, "acceptGroupInviteAudio invalid SessionInfo. " + this.f77250e);
            return;
        }
        Intent intent = new Intent(context, (Class<?>) AVActivity.class);
        intent.addFlags(262144);
        intent.addFlags(131072);
        intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 3);
        intent.putExtra("GroupId", String.valueOf(this.f77255j));
        intent.putExtra("Type", 1);
        intent.putExtra("DiscussUinList", this.f77254i);
        intent.putExtra("needStartTRAE", true);
        intent.putExtra("MultiAVType", i3.f73063p);
        intent.putExtra("uin", String.valueOf(this.f77255j));
        intent.putExtra("uinType", this.f77256k);
        intent.putExtra("isFromInviteDialog", true);
        intent.putExtra("shutCamera", true);
        intent.putExtra("isSender", false);
        intent.putExtra("isInZplanHome", true);
        context.startActivity(intent);
        QLog.d("QAVControllerForZplan", 1, "acceptGroupInviteAudio suc.");
        this.f77250e = null;
        l(true);
    }

    public void h(Context context) {
        WeakReference<VideoInviteActivity> weakReference = this.f77248c;
        if (weakReference != null && weakReference.get() != null) {
            this.f77248c.get().finish();
            this.f77248c = null;
        }
        SessionInfo i3 = n.e().i(this.f77250e);
        if (i3 == null) {
            QLog.d("QAVControllerForZplan", 1, "acceptInviteAudio invalid SessionInfo. " + this.f77250e);
            return;
        }
        Intent intent = new Intent(context, (Class<?>) AVActivity.class);
        intent.addFlags(262144);
        intent.addFlags(131072);
        intent.putExtra("uinType", i3.f73067q);
        intent.putExtra("bindType", i3.B0);
        intent.putExtra("bindId", i3.D0);
        intent.putExtra("uin", i3.f73091w);
        intent.putExtra("name", i3.f73099y);
        intent.putExtra("extraUin", i3.f73103z);
        intent.putExtra(PreloadTRTCPlayerParams.KEY_SIG, i3.J0);
        intent.putExtra("subServiceType", i3.f73021f0);
        intent.putExtra("receive", true);
        intent.putExtra("isAudioMode", true);
        intent.putExtra(IProfileProtocolConst.PARAM_IS_FRIEND, true);
        intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 1);
        intent.putExtra("shutCamera", true);
        intent.putExtra("isSender", false);
        intent.putExtra("isInZplanHome", true);
        context.startActivity(intent);
        l(true);
        this.f77250e = null;
        QLog.d("QAVControllerForZplan", 1, "acceptInviteAudio suc.");
    }

    public void i(Context context, boolean z16, String str) {
        SessionInfo sessionInfo;
        boolean z17;
        Class cls;
        Intent intent;
        if (QLog.isColorLevel()) {
            QLog.i("QAVControllerForZplan", 2, "backToAVActivity needNotifyHangupEvent: " + z16 + " visitUin: " + str);
        }
        if (!TextUtils.isEmpty(this.f77250e)) {
            sessionInfo = n.e().i(this.f77250e);
        } else {
            WeakReference<VideoAppInterface> weakReference = this.f77246a;
            if (weakReference != null && weakReference.get() != null && r.h0() != null && !this.f77262q) {
                sessionInfo = n.e().f();
            } else {
                if (this.f77246a == null) {
                    QLog.e("QAVControllerForZplan", 1, "backToAVActivity sessionInfo is Null.");
                    com.tencent.zplan.engine.a aVar = com.tencent.zplan.engine.a.f385563g;
                    aVar.l(context);
                    aVar.k("tencent.video.v2z.notify_audio_call_abort", null, null);
                    return;
                }
                sessionInfo = null;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("QAVControllerForZplan", 2, "curSessionInfo " + sessionInfo);
        }
        if (n() != 2 && n() != 7) {
            WeakReference<VideoAppInterface> weakReference2 = this.f77246a;
            if (weakReference2 != null && weakReference2.get() != null) {
                W(this.f77246a.get(), false, false);
                QLog.d("QAVControllerForZplan", 1, "zplanHomeGoBack.");
            }
            intent = new Intent(context, (Class<?>) AVActivity.class);
            if (sessionInfo != null) {
                intent.putExtra("uinType", sessionInfo.f73067q);
                intent.putExtra("bindType", sessionInfo.B0);
                intent.putExtra("bindId", sessionInfo.D0);
                intent.putExtra("uin", sessionInfo.f73091w);
                intent.putExtra("name", sessionInfo.f73099y);
                intent.putExtra("extraUin", sessionInfo.f73103z);
                intent.putExtra(PreloadTRTCPlayerParams.KEY_SIG, sessionInfo.J0);
                intent.putExtra("subServiceType", sessionInfo.f73021f0);
                intent.putExtra("receive", true);
                intent.putExtra("isAudioMode", true);
                intent.putExtra(IProfileProtocolConst.PARAM_IS_FRIEND, true);
                intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, sessionInfo.f73035i);
                if (sessionInfo.f73035i == 3) {
                    intent.putExtra("uin", String.valueOf(sessionInfo.P0));
                    intent.putExtra("GroupId", String.valueOf(sessionInfo.P0));
                    intent.putExtra("Type", sessionInfo.R0);
                    intent.putExtra("MultiAVType", sessionInfo.f73063p);
                }
                intent.putExtra("shutCamera", true);
                intent.putExtra("isSender", false);
                intent.putExtra("isSpeakerOn", this.f77251f);
                intent.putExtra("needRestoreSpeaker", true);
            }
            QLog.d("QAVControllerForZplan", 1, "back to AVActivity. " + this.f77251f);
        } else {
            if (n() == 7) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                cls = GaInviteLockActivity.class;
            } else {
                cls = VideoInviteActivity.class;
            }
            Intent intent2 = new Intent(context, (Class<?>) cls);
            if (sessionInfo != null) {
                intent2.putExtra("uinType", sessionInfo.f73067q);
                int i3 = sessionInfo.S0;
                if (i3 != 0) {
                    intent2.putExtra("relationType", i3);
                } else {
                    intent2.putExtra("relationType", ba.uinType2AVRelationType(sessionInfo.f73067q));
                }
                intent2.putExtra(ServiceConst.PARA_SESSION_ID, this.f77250e);
                intent2.putExtra("peerUin", sessionInfo.f73091w);
                intent2.putExtra("extraUin", sessionInfo.f73103z);
                intent2.putExtra("isAudioMode", sessionInfo.M0);
                intent2.putExtra("curUserStatus", sessionInfo.f73025g);
                intent2.putExtra("isDoubleVideoMeeting", sessionInfo.f73060o0);
                intent2.putExtra("bindType", sessionInfo.B0);
                if (n() == 7) {
                    intent2.putExtra("bindType", sessionInfo.B0);
                    ((INTGaInviteFragmentPluginHelperApi) QRoute.api(INTGaInviteFragmentPluginHelperApi.class)).setIntentFrom(intent2, "backToAVActivity");
                    if (!TextUtils.isEmpty(sessionInfo.f73091w)) {
                        intent2.putExtra("friendUin", Long.parseLong(sessionInfo.f73091w));
                    }
                    intent2.putExtra("MultiAVType", sessionInfo.f73063p);
                    intent2.putExtra("discussId", sessionInfo.P0);
                    intent2.putExtra("memberList", sessionInfo.Q0);
                }
            }
            QLog.d("QAVControllerForZplan", 1, "back to invite Activity.");
            intent = intent2;
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.addFlags(262144);
        intent.addFlags(131072);
        intent.putExtra("isInZplanHome", false);
        intent.putExtra("needNotifyHangupEvent", z16);
        intent.putExtra("visitUin", str);
        context.startActivity(intent);
        U();
    }

    public void j() {
        this.f77247b = null;
    }

    public void k() {
        if (this.f77247b != null) {
            if (this.f77263r != null) {
                WeakReference<VideoAppInterface> weakReference = this.f77246a;
                if (weakReference != null && weakReference.get() != null) {
                    this.f77246a.get().deleteObserver(this.f77263r);
                    QLog.d("QAVControllerForZplan", 1, "closeAudio deleteObserver");
                }
                this.f77263r = null;
            }
            if (this.f77265t != null) {
                WeakReference<VideoAppInterface> weakReference2 = this.f77246a;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.f77246a.get().deleteObserver(this.f77265t);
                    QLog.d("QAVControllerForZplan", 1, "closeAudio deleteObserver");
                }
                this.f77265t = null;
            }
            WeakReference<VideoAppInterface> weakReference3 = this.f77246a;
            if (weakReference3 != null && weakReference3.get() != null) {
                com.tencent.zplan.engine.a.f385563g.n(this.f77246a.get().getApplicationContext());
                QLog.e("QAVControllerForZplan", 1, "[closeAudio] unRegisterActionIpcHelper");
            }
        }
        if (r.h0() != null && !this.f77262q) {
            SessionInfo f16 = n.e().f();
            r.h0().r(f16.f73091w, 0);
            r.h0().q(f16.f73091w, 0);
            U();
        }
        l(false);
        WeakReference<AVActivity> weakReference4 = this.f77247b;
        if (weakReference4 != null && weakReference4.get() != null) {
            this.f77247b.get().finish();
            this.f77247b = null;
            this.f77262q = true;
            this.f77246a = null;
        }
        this.f77260o.clear();
        QLog.d("QAVControllerForZplan", 1, "closeAudio.");
    }

    public void m() {
        QLog.d("QAVControllerForZplan", 1, "getCallList");
        if (r.h0() != null && !this.f77262q && n.e().f() != null) {
            SessionInfo f16 = n.e().f();
            r.h0().W().getRoomUinOpenIdMap(this.f77246a.get().getLongAccountUin(), r.h0().W().getRoomId(), f16.S0, f16.f73063p);
            this.f77261p = true;
        }
    }

    public int n() {
        if (!V()) {
            return 0;
        }
        return n.e().f().f73043k;
    }

    public int o() {
        if (!V()) {
            return 0;
        }
        return n.e().f().f73035i;
    }

    public ArrayList<ResultRecord> q(ArrayList<String> arrayList) {
        ArrayList<ResultRecord> arrayList2 = new ArrayList<>();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            ResultRecord resultRecord = new ResultRecord();
            resultRecord.uin = next;
            arrayList2.add(resultRecord);
        }
        return arrayList2;
    }

    public void r() {
        WeakReference<VideoAppInterface> weakReference;
        WeakReference<VideoAppInterface> weakReference2;
        WeakReference<VideoAppInterface> weakReference3 = this.f77246a;
        if (weakReference3 != null && weakReference3.get() != null) {
            if (r.h0() != null && !this.f77262q) {
                SessionInfo f16 = n.e().f();
                long d16 = com.tencent.av.utils.e.d();
                r.h0().P2(d16, f16.f73035i, false, true);
                if (f16.N || f16.f73062o2) {
                    r.h0().P2(d16, f16.f73035i, false, false);
                }
                r.h0().J2(true);
                f16.H2 = true;
                int i3 = f16.f73035i;
                if (i3 == 1) {
                    p().t(BaseApplication.getContext(), new a());
                } else if (i3 == 3) {
                    p().t(BaseApplication.getContext(), new b(f16));
                }
            }
            com.tencent.zplan.engine.a.f385563g.l(this.f77246a.get().getApp());
        }
        WeakReference<AVActivity> weakReference4 = this.f77247b;
        if (weakReference4 != null && weakReference4.get() != null && !this.f77247b.get().isFinishing()) {
            SessionInfo f17 = n.e().f();
            if (f17 != null) {
                B(f17.f73100y0, f17.f73104z0);
                R(f17.I0);
            }
            this.f77247b.get().y3();
            if (!this.f77247b.get().isFinishing()) {
                this.f77247b.get().finish();
                this.f77247b = null;
            }
            if (f17 != null && f17.f73035i == 3) {
                T();
            }
        }
        if (V()) {
            if (this.f77263r == null && (weakReference2 = this.f77246a) != null && weakReference2.get() != null) {
                this.f77263r = new e();
                this.f77246a.get().addObserver(this.f77263r);
                QLog.d("QAVControllerForZplan", 1, "handleEnterZplanGameHome addObserver");
            }
            if (this.f77265t == null && (weakReference = this.f77246a) != null && weakReference.get() != null) {
                this.f77265t = new g();
                this.f77246a.get().addObserver(this.f77265t);
                QLog.d("QAVControllerForZplan", 1, "handleEnterZplanGameHome addGAudioObserver");
            }
            l(true);
        }
    }

    public void s(boolean z16) {
        WeakReference<VideoAppInterface> weakReference = this.f77246a;
        if (weakReference != null && weakReference.get() != null) {
            W(this.f77246a.get(), true, z16);
        }
        if (r.h0() != null && !this.f77262q && n.e().f().H2) {
            k();
            QLog.d("QAVControllerForZplan", 1, "handleExitZplanGameHome from zplan");
        } else {
            WeakReference<VideoAppInterface> weakReference2 = this.f77246a;
            if (weakReference2 != null && weakReference2.get() != null) {
                i(this.f77246a.get().getApplicationContext(), false, null);
                if (this.f77263r != null) {
                    this.f77246a.get().deleteObserver(this.f77263r);
                    this.f77263r = null;
                    QLog.d("QAVControllerForZplan", 1, "handleExitZplanGameHome deleteObserver");
                }
                if (this.f77265t != null) {
                    this.f77246a.get().deleteObserver(this.f77265t);
                    this.f77265t = null;
                    QLog.d("QAVControllerForZplan", 1, "handleExitZplanGameHome deleteGAudioObserver");
                }
                this.f77246a = null;
                QLog.d("QAVControllerForZplan", 1, "handleExitZplanGameHome from video");
            }
        }
        U();
        l(false);
    }

    public void t(Context context, d dVar) {
        boolean z16;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
        if (runningAppProcesses != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (it.hasNext()) {
                if (it.next().processName.equals("com.tencent.mobileqq:zplan")) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (!z16) {
            QLog.d("QAVControllerForZplan", 1, "[handleInviteComing] zplan process no exist");
            dVar.b();
            return;
        }
        com.tencent.zplan.engine.a aVar = com.tencent.zplan.engine.a.f385563g;
        aVar.l(context);
        QLog.d("QAVControllerForZplan", 1, "[handleInviteComing] registerActionIpcHelper.");
        QLog.d("QAVControllerForZplan", 1, "[handleInviteComing] query is in zplan home.");
        aVar.k("tencent.video.v2z.is_in_zplan_home", null, new c(dVar));
    }

    void u() {
        SessionInfo sessionInfo;
        if (!this.f77252g) {
            return;
        }
        SessionInfo f16 = n.e().f();
        if (r.h0() != null && !this.f77262q && (sessionInfo = this.f77253h) != null && f16 == sessionInfo && n.e().c() >= 2) {
            r.h0().D2(true);
            if (!this.f77253h.u()) {
                r.h0().p(true, 205, f16.f73063p);
                r.h0().j2(205);
            }
            Intent intent = new Intent();
            intent.setPackage(this.f77246a.get().getApp().getPackageName());
            intent.setAction("tencent.av.v2q.StopVideoChat");
            intent.putExtra("stopReason3rd", 1);
            intent.putExtra("groupId", this.f77253h.P0);
            intent.putExtra("peerUin", this.f77253h.f73091w);
            this.f77246a.get().getApp().sendBroadcast(intent);
        }
    }

    public boolean v() {
        if (o() == 1) {
            return true;
        }
        return false;
    }

    public void x() {
        if (QLog.isColorLevel()) {
            QLog.i("QAVControllerForZplan", 2, "notifyGroupHangupEvent");
        }
        String currentAccountUin = this.f77246a.get().getCurrentAccountUin();
        if (r.h0() != null && !this.f77262q) {
            H(7, "", currentAccountUin, -1L, -1L);
        }
    }

    public void y(boolean z16, String str) {
        String currentAccountUin = this.f77246a.get().getCurrentAccountUin();
        if (z16) {
            G(4, str, currentAccountUin, true);
        } else {
            G(4, currentAccountUin, str, false);
        }
    }

    public void z(String str, String str2, String str3, long j3) {
        this.f77250e = str;
        Bundle bundle = new Bundle();
        bundle.putString("peerUin", str2);
        bundle.putString("peerNickName", str3);
        bundle.putLong("roomId", j3);
        com.tencent.zplan.engine.a.f385563g.k("tencent.video.v2z.on_receive_audio_call", bundle, null);
        QLog.d("QAVControllerForZplan", 1, "notifyInviteAudio " + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements d {
        a() {
        }

        @Override // com.tencent.av.zplan.QAVControllerForZplan.d
        public void a(boolean z16) {
            QLog.i("QAVControllerForZplan", 2, "handleEnterZplanGameHome onInZplanHome isInZPlanSmallHomeMod: " + z16);
            if (z16) {
                r.h0().s1(true);
            }
        }

        @Override // com.tencent.av.zplan.QAVControllerForZplan.d
        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SessionInfo f77272a;

        b(SessionInfo sessionInfo) {
            this.f77272a = sessionInfo;
        }

        @Override // com.tencent.av.zplan.QAVControllerForZplan.d
        public void a(boolean z16) {
            QLog.i("QAVControllerForZplan", 2, "zplanHomeGoBack handleEnterZplanGameHome isInZPlanSmallHomeMod: " + z16);
            if (z16) {
                SessionInfo sessionInfo = this.f77272a;
                String b16 = new GAudioZPlanStatus(1, sessionInfo.M2, sessionInfo.N2).b();
                r.h0().W().NotifyBusinessExtInfo(((VideoAppInterface) QAVControllerForZplan.this.f77246a.get()).getCurrentAccountUin(), 1, b16, b16.length());
                QLog.i("QAVControllerForZplan", 2, "notify small home status " + b16);
            }
        }

        @Override // com.tencent.av.zplan.QAVControllerForZplan.d
        public void b() {
        }
    }
}
