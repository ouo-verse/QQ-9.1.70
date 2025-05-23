package com.tencent.adelie.av.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.adelie.av.qav.AdelieAVController;
import com.tencent.adelie.av.ui.AdelieAVChatStatusManager;
import com.tencent.adelie.av.ui.b;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.m;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.av.utils.ba;
import com.tencent.av.utils.l;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qav.QavDef$MultiUserInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.RealtimeBgSource;
import com.tencent.robot.api.IRobotProfileInfoApi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AdelieAVControlUI implements AdelieAVChatStatusManager.b {
    public static long D;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Context> f61407a;

    /* renamed from: b, reason: collision with root package name */
    private RelativeLayout f61408b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f61409c;

    /* renamed from: d, reason: collision with root package name */
    private AdelieAVTimerController f61410d;

    /* renamed from: e, reason: collision with root package name */
    private String f61411e;

    /* renamed from: f, reason: collision with root package name */
    private String f61412f;

    /* renamed from: g, reason: collision with root package name */
    private AdelieAVPanel f61413g;

    /* renamed from: h, reason: collision with root package name */
    private View f61414h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f61415i;

    /* renamed from: k, reason: collision with root package name */
    private AdelieAVChatStatusManager f61417k;

    /* renamed from: l, reason: collision with root package name */
    private com.tencent.adelie.av.ui.a f61418l;

    /* renamed from: n, reason: collision with root package name */
    private long f61420n;

    /* renamed from: p, reason: collision with root package name */
    private boolean f61422p;

    /* renamed from: q, reason: collision with root package name */
    private TextView f61423q;

    /* renamed from: r, reason: collision with root package name */
    private TextView f61424r;

    /* renamed from: s, reason: collision with root package name */
    private ImageView f61425s;

    /* renamed from: t, reason: collision with root package name */
    private ImageView f61426t;

    /* renamed from: u, reason: collision with root package name */
    private com.tencent.adelie.av.ui.c f61427u;

    /* renamed from: v, reason: collision with root package name */
    private ImageView f61428v;

    /* renamed from: w, reason: collision with root package name */
    private ImageView f61429w;

    /* renamed from: j, reason: collision with root package name */
    private boolean f61416j = true;

    /* renamed from: m, reason: collision with root package name */
    private int f61419m = -1;

    /* renamed from: o, reason: collision with root package name */
    private boolean f61421o = false;

    /* renamed from: x, reason: collision with root package name */
    private up.a f61430x = null;

    /* renamed from: y, reason: collision with root package name */
    private String f61431y = null;

    /* renamed from: z, reason: collision with root package name */
    private BroadcastReceiver f61432z = new c();
    private qp.a A = new qp.a() { // from class: com.tencent.adelie.av.ui.AdelieAVControlUI.2
        @Override // qp.a
        public void a(long j3, int i3) {
            super.a(j3, i3);
            if (AdelieAVController.J()) {
                int l3 = AdelieAVChatStatusManager.l(i3);
                up.a E = AdelieAVController.D().E();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onAdelieRobotStatusChange status=");
                sb5.append(i3);
                sb5.append(" str=");
                sb5.append(l3);
                sb5.append(" groupId=");
                sb5.append(j3);
                sb5.append(" str=");
                sb5.append(AdelieAVChatStatusManager.n(i3));
                sb5.append(" mChatStatus");
                sb5.append(E != null ? E.f439402u : -1);
                QLog.d("AdelieAVControlUI", 1, sb5.toString());
                if (E != null && E.f439402u == -1) {
                    if (i3 == 11 || i3 == 33) {
                        if (!E.f439393l) {
                            AdelieAVController.D().y(true);
                        }
                        if (i3 != 11 || AdelieAVControlUI.this.f61417k == null) {
                            return;
                        }
                        AdelieAVControlUI.this.f61417k.t(0);
                        return;
                    }
                    return;
                }
                if (l3 == 1 && E != null && E.f439402u == 3) {
                    QLog.d("AdelieAVControlUI", 1, "onAdelieRobotStatusChange illegal");
                } else if (l3 == 4) {
                    AdelieAVControlUI.this.N(false);
                } else if (AdelieAVControlUI.this.f61417k != null) {
                    AdelieAVControlUI.this.f61417k.t(l3);
                }
            }
        }

        @Override // qp.a
        public void b(int i3) {
            QLog.d("AdelieAVControlUI", 1, "onApnChanged netType=" + i3 + " curChatStatus=" + AdelieAVControlUI.this.L());
            super.b(i3);
            if (AdelieAVControlUI.this.f61417k == null) {
                return;
            }
            if (i3 != 0) {
                if (AdelieAVControlUI.this.L() == 4) {
                    AdelieAVControlUI.this.f61417k.t(0);
                    return;
                }
                return;
            }
            AdelieAVControlUI.this.f61417k.t(4);
        }

        @Override // qp.a
        public void c(int i3, int i16) {
            QLog.d("AdelieAVControlUI", 1, "onAudioOutputDeviceChange audioOutPut=" + i3 + " subtype=" + i16 + " oldAudioRoute=" + AdelieAVControlUI.this.f61419m);
            if (AdelieAVControlUI.this.f61419m == i3) {
                return;
            }
            AdelieAVControlUI.this.f61419m = i3;
            AdelieAVControlUI.this.V(i3);
            super.c(i3, i16);
        }

        @Override // qp.a
        public void d(int i3) {
            QLog.d("AdelieAVControlUI", 1, "onEnterRoomError " + i3);
            super.d(i3);
            QQToast.makeText((Context) AdelieAVControlUI.this.f61407a.get(), "\u8fdb\u623f\u5931\u8d25\uff1a" + i3, 1).show();
            VideoMsgTools.l((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), 1043, i3 == 3 ? 9 : 45, true, AdelieAVControlUI.this.f61411e, String.valueOf(AdelieAVControlUI.this.f61420n), true, null, true, new Object[0]);
            AdelieAVControlUI.this.N(false);
        }

        @Override // qp.a
        public void e() {
            super.e();
            if (AdelieAVController.J()) {
                up.a E = AdelieAVController.D().E();
                QLog.d("AdelieAVControlUI", 1, "ADELIE_COST enter_room cost : " + (System.currentTimeMillis() - AdelieAVControlUI.D) + " ms");
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onEnterRoomSuccess session=");
                sb5.append(E);
                QLog.d("AdelieAVControlUI", 1, sb5.toString());
                if (E != null) {
                    AdelieAVControlUI.this.f61430x = E;
                    E.f439404w = SystemClock.elapsedRealtime();
                }
                if (AdelieAVControlUI.this.f61410d == null) {
                    AdelieAVControlUI adelieAVControlUI = AdelieAVControlUI.this;
                    adelieAVControlUI.f61410d = new AdelieAVTimerController(adelieAVControlUI.f61409c);
                }
                AdelieAVControlUI.this.f61410d.e();
                if (AdelieAVControlUI.this.f61417k != null) {
                    AdelieAVControlUI.this.f61417k.q();
                }
                ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAVControlUI.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AdelieAVControlUI.this.Z(true);
                        AdelieAVControlUI.this.g0(true);
                    }
                });
            }
        }

        @Override // qp.a
        public void g(int i3) {
            QLog.d("AdelieAVControlUI", 1, "onSelfVolumeUpdate volumeValue=" + i3);
            super.g(i3);
        }

        @Override // qp.a
        public void i(final boolean z16) {
            QLog.d("AdelieAVControlUI", 1, "onSystemCallStateChanged isCalling=" + z16);
            super.i(z16);
            ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAVControlUI.2.4
                @Override // java.lang.Runnable
                public void run() {
                    if (z16) {
                        if (AdelieAVControlUI.this.f61413g != null) {
                            AdelieAVControlUI.this.f61413g.p(m.l.O, true);
                            AdelieAVControlUI.this.f61413g.s(false, true);
                            return;
                        }
                        return;
                    }
                    AdelieAVControlUI.this.d0();
                }
            });
        }

        @Override // qp.a
        public void j(QavDef$MultiUserInfo qavDef$MultiUserInfo, boolean z16) {
            QLog.d("AdelieAVControlUI", 1, "onUserAudioAvailable " + qavDef$MultiUserInfo + " available=" + z16);
            super.j(qavDef$MultiUserInfo, z16);
        }

        @Override // qp.a
        public void k(QavDef$MultiUserInfo qavDef$MultiUserInfo) {
            QLog.d("AdelieAVControlUI", 1, "onUserEnter " + qavDef$MultiUserInfo);
            super.k(qavDef$MultiUserInfo);
        }

        @Override // qp.a
        public void l(QavDef$MultiUserInfo qavDef$MultiUserInfo) {
            QLog.d("AdelieAVControlUI", 1, "onUserExit " + qavDef$MultiUserInfo);
            super.l(qavDef$MultiUserInfo);
            ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAVControlUI.2.2
                @Override // java.lang.Runnable
                public void run() {
                    if (AdelieAVControlUI.this.f61418l != null) {
                        AdelieAVControlUI.this.f61418l.e();
                    }
                }
            });
            AdelieAVControlUI.this.N(false);
        }

        @Override // qp.a
        public void m(QavDef$MultiUserInfo qavDef$MultiUserInfo, boolean z16, final int i3) {
            QLog.d("AdelieAVControlUI", 1, "onUserSpeaking uin=" + qavDef$MultiUserInfo.mUin + " isSpeaking=" + z16 + " chatStatus=" + AdelieAVControlUI.this.L() + " audioEnergy=" + i3 + " interrupting=" + AdelieAVControlUI.this.f61421o);
            if (qavDef$MultiUserInfo.mUin == AdelieAVControlUI.this.f61420n) {
                ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAVControlUI.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AdelieAVControlUI.this.f61413g != null) {
                            AdelieAVControlUI.this.f61413g.setAudioVolumeValue(i3);
                        }
                    }
                });
            }
            if ((!AdelieAVControlUI.this.f61421o || qavDef$MultiUserInfo.mUin == AdelieAVControlUI.this.f61420n) && AdelieAVControlUI.this.f61417k != null) {
                AdelieAVControlUI.this.f61417k.r(qavDef$MultiUserInfo, z16, i3);
            }
            super.m(qavDef$MultiUserInfo, z16, i3);
        }

        @Override // qp.a
        public void n(List<QavDef$MultiUserInfo> list) {
            QLog.d("AdelieAVControlUI", 1, "onUserUpdate userInfoList=" + list);
            super.n(list);
        }
    };
    private View.OnClickListener B = new d();
    private long C = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements URLDrawable.URLDrawableListener {
        a() {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            QLog.d("AdelieAVControlUI", 1, "updateRobotBackground onLoadProgressed progress=" + i3);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            QLog.d("AdelieAVControlUI", 1, "updateRobotBackground onLoadCanceled");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            QLog.d("AdelieAVControlUI", 1, "updateRobotBackground onLoadFialed drawable... ");
            AdelieAVControlUI.this.f61428v.setVisibility(8);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            QLog.d("AdelieAVControlUI", 1, "updateRobotBackground onLoadSuccessed drawable");
            AdelieAVControlUI.this.c0(uRLDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements IGetGroupRobotProfileCallback {
        b() {
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback
        public void onResult(int i3, String str, GroupRobotProfile groupRobotProfile) {
            ArrayList<RealtimeBgSource> realtimeSpeechCfg = groupRobotProfile.getRealtimeSpeechCfg();
            if (realtimeSpeechCfg.size() == 0) {
                QLog.e("AdelieAVControlUI", 1, "updateRobotBackground bg size is 0. peerUin=" + AdelieAVControlUI.this.f61411e);
                return;
            }
            Iterator<RealtimeBgSource> it = realtimeSpeechCfg.iterator();
            while (it.hasNext()) {
                RealtimeBgSource next = it.next();
                QLog.e("AdelieAVControlUI", 1, "updateRobotBackground sourceType=" + next.getSourceType() + " SceneType=" + next.getSceneType() + " url=" + next.getUrl());
                if (next.getSceneType() == 0 && "pic".equals(next.getSourceType())) {
                    String url = next.getUrl();
                    if (!TextUtils.isEmpty(url)) {
                        AdelieAVControlUI.this.f61431y = url;
                        AdelieAVControlUI adelieAVControlUI = AdelieAVControlUI.this;
                        adelieAVControlUI.f61416j = TextUtils.isEmpty(adelieAVControlUI.f61431y);
                        if (!AdelieAVControlUI.this.f61416j) {
                            AdelieAVControlUI adelieAVControlUI2 = AdelieAVControlUI.this;
                            adelieAVControlUI2.W(adelieAVControlUI2.f61431y);
                        }
                        AdelieAVControlUI.this.f61427u.j(AdelieAVControlUI.this.f61416j);
                        AdelieAVControlUI.this.f0();
                        return;
                    }
                } else {
                    QLog.e("AdelieAVControlUI", 1, "updateRobotBackground not find.");
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.tencent.adelie.av.exit")) {
                AdelieAVControlUI.this.N(true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            QLog.d("AdelieAVControlUI", 1, "interrupt click.");
            AdelieAVController.D().V((int) com.tencent.av.utils.e.d(), 40);
            if (AdelieAVControlUI.this.f61417k != null) {
                AdelieAVControlUI.this.f61417k.t(1);
            }
            AdelieAVControlUI.this.f61421o = true;
            AdelieAVController.D().R();
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class e implements h {
        e() {
        }

        @Override // com.tencent.adelie.av.ui.AdelieAVControlUI.h
        public void a() {
            if (AdelieAVControlUI.this.f61416j) {
                return;
            }
            AdelieAVControlUI.this.h0();
        }

        @Override // com.tencent.adelie.av.ui.AdelieAVControlUI.h
        public void b() {
            AdelieAVControlUI.this.U();
            if (AdelieAVControlUI.this.f61417k != null) {
                AdelieAVControlUI.this.f61417k.k(true);
            }
            AdelieAVControlUI adelieAVControlUI = AdelieAVControlUI.this;
            adelieAVControlUI.V(adelieAVControlUI.f61419m);
            AdelieAVControlUI.this.g0(true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class f implements b.d {
        f() {
        }

        @Override // com.tencent.adelie.av.ui.b.d
        public void a() {
            QLog.d("AdelieAVControlUI", 1, "[InviteAnimation] inOutCtrl onInAnimationEnd");
            if (AdelieAVControlUI.this.f61427u != null) {
                AdelieAVControlUI.this.f61427u.p();
            }
        }

        @Override // com.tencent.adelie.av.ui.b.d
        public void b() {
            QLog.d("AdelieAVControlUI", 1, "[InviteAnimation] inOutCtrl onInAnimationStart");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class g implements ew.b {
        g() {
        }

        @Override // ew.b
        public void D1(ew.a aVar, Drawable drawable) {
            if (AdelieAVControlUI.this.f61429w != null) {
                AdelieAVControlUI.this.f61429w.setImageDrawable(drawable);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface h {
        void a();

        void b();
    }

    public static void H(String str, boolean z16) {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (AdelieAVController.J()) {
            if (AdelieAVController.D().F()) {
                VideoMsgTools.l(qQAppInterface, 1043, z16 ? 0 : 2, false, str, qQAppInterface.getCurrentAccountUin(), true, ba.formatTime(AdelieAVTimerController.c()), true, new Object[0]);
            } else {
                VideoMsgTools.l(qQAppInterface, 1043, z16 ? 1 : 3, false, str, qQAppInterface.getCurrentAccountUin(), true, qQAppInterface.getApplicationContext().getString(R.string.f173247id1), true, new Object[0]);
            }
        }
    }

    private boolean J() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.C <= 500) {
            return false;
        }
        this.C = currentTimeMillis;
        return true;
    }

    private void K() {
        ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).fetchRobotProfileInfo(this.f61411e, "", new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int L() {
        up.a M = M();
        if (M != null) {
            return M.f439402u;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(boolean z16) {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        up.a E = AdelieAVController.D().E();
        qQAppInterface.getAVNotifyCenter().V0(com.tencent.av.utils.e.d(), 0);
        if (E != null && E.f439387f > 0) {
            qQAppInterface.getAVNotifyCenter().q0(String.valueOf(E.f439387f));
        }
        AdelieAVTimerController adelieAVTimerController = this.f61410d;
        if (adelieAVTimerController != null) {
            adelieAVTimerController.f();
            this.f61410d.d();
            this.f61410d = null;
        }
        H(this.f61411e, z16);
        if (this.A != null) {
            AdelieAVController.D().N(this.A);
            this.A = null;
        }
        AdelieAVController.D().B();
        AdelieAVController.x();
        WeakReference<Context> weakReference = this.f61407a;
        if (weakReference != null && weakReference.get() != null) {
            ((Activity) this.f61407a.get()).finish();
        }
        ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAVControlUI.6
            @Override // java.lang.Runnable
            public void run() {
                AdelieAvatarHelper.p().g(AdelieAVControlUI.this.f61411e);
            }
        });
    }

    private void O() {
        Activity activity = (Activity) this.f61407a.get();
        activity.finish();
        activity.overridePendingTransition(0, SmallScreenUtils.j(7));
        AdelieAVFloatWindowManager.z().C(this.f61407a.get());
        AdelieAVFloatWindowManager.z().E(this.f61412f, this.f61411e);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAVControlUI.7
            @Override // java.lang.Runnable
            public void run() {
                AdelieAVFloatWindowManager.z().F();
            }
        }, 300L);
    }

    private void Q() {
        up.a E = AdelieAVController.D().E();
        if (E != null) {
            if (E.f439393l) {
                QQToast.makeText(this.f61407a.get(), -1, R.string.f170485z74, 0).show();
            } else {
                QQToast.makeText(this.f61407a.get(), -1, R.string.z6r, 0).show();
            }
            E.f439393l = !E.f439393l;
            QLog.d("AdelieAVControlUI", 1, "onClickMute mLocalClickMute=" + E.f439393l);
            boolean z16 = E.f439393l;
            boolean z17 = E.f439392k;
            if (z16 != z17) {
                AdelieAVController.D().y(z17);
            }
            d0();
        }
    }

    private void R() {
        if (!J()) {
            if (QLog.isColorLevel()) {
                QLog.d("AdelieAVControlUI", 2, "onClick_Speak fast-click");
                return;
            }
            return;
        }
        AdelieAVController D2 = AdelieAVController.D();
        if (D2 != null) {
            int C = D2.C();
            QLog.d("AdelieAVControlUI", 2, "onClickSpeaker curAudioRoute=" + C);
            if (C == 2) {
                if (QLog.isColorLevel()) {
                    QLog.d("AdelieAVControlUI", 2, "onClick_Speak in AUDIO_ROUTE_BLUETOOTH status, not support close bluetooth");
                    return;
                }
                return;
            }
            int i3 = 1;
            if (C == 0) {
                QQToast.makeText(this.f61407a.get(), -1, R.string.z75, 0).show();
            } else {
                if (C == 1) {
                    QQToast.makeText(this.f61407a.get(), -1, R.string.z6s, 0).show();
                }
                i3 = 0;
            }
            D2.P(i3);
            i0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (this.f61415i == null) {
            return;
        }
        this.f61415i.setText(com.tencent.mobileqq.text.TextUtils.adjustEllipsizeEndText(this.f61415i, "\u4e0e" + this.f61412f, BaseAIOUtils.f(124.0f, this.f61407a.get().getResources())) + "\u901a\u8bdd\u4e2d");
        if (this.f61416j) {
            a0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(final int i3) {
        boolean z16 = com.tencent.adelie.av.ui.c.N;
        QLog.d("AdelieAVControlUI", 1, "onUpdateSpeakerUI audioOutPut=" + i3 + " showingAnim=" + z16);
        if (z16) {
            return;
        }
        ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAVControlUI.8
            @Override // java.lang.Runnable
            public void run() {
                if (AdelieAVControlUI.this.f61407a == null) {
                    return;
                }
                Button button = (Button) ((Activity) AdelieAVControlUI.this.f61407a.get()).findViewById(R.id.f29990n5);
                if (i3 == 2) {
                    button.setCompoundDrawables(null, l.b(((Context) AdelieAVControlUI.this.f61407a.get()).getResources(), R.drawable.d_u, false, false), null, null);
                    button.setSelected(true);
                } else {
                    QavPanel.setBtnTopDrawable(button, R.drawable.k9i);
                    AdelieAVControlUI.this.i0();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(String str) {
        URLDrawable.getDrawable(str, URLDrawable.URLDrawableOptions.obtain()).startDownload(false);
    }

    private void X() {
        Object obj;
        up.a aVar;
        HashMap hashMap = new HashMap();
        up.a E = AdelieAVController.D().E();
        if (E == null && (aVar = this.f61430x) != null) {
            E = aVar;
        }
        if (E == null) {
            return;
        }
        tp.b bVar = tp.b.f437029a;
        bVar.d("em_bas_hang_up");
        String str = "2";
        if (E.f439392k) {
            obj = "2";
        } else {
            obj = "1";
        }
        hashMap.put("status", obj);
        bVar.e("em_bas_microphone", hashMap);
        if (E.f439391j) {
            str = "1";
        }
        hashMap.put("status", str);
        bVar.e("em_bas_loudspeaker", hashMap);
        bVar.d("em_bas_minification_window");
    }

    private void Y() {
        Object obj;
        up.a aVar;
        HashMap hashMap = new HashMap();
        up.a E = AdelieAVController.D().E();
        if (E == null && (aVar = this.f61430x) != null) {
            E = aVar;
        }
        if (E == null) {
            return;
        }
        tp.b bVar = tp.b.f437029a;
        bVar.f("em_bas_hang_up");
        String str = "2";
        if (E.f439392k) {
            obj = "2";
        } else {
            obj = "1";
        }
        hashMap.put("status", obj);
        bVar.g("em_bas_microphone", hashMap);
        if (E.f439391j) {
            str = "1";
        }
        hashMap.put("status", str);
        bVar.g("em_bas_loudspeaker", hashMap);
        bVar.f("em_bas_minification_window");
    }

    private void a0() {
        e0();
        if (this.f61425s.getVisibility() == 0) {
            QLog.d("AdelieAVControlUI", 1, "showHeadAndGaussian is already showed.");
            return;
        }
        ew.a aVar = new ew.a(0, this.f61411e, null, true);
        AdelieAvatarHelper.p().s((ImageView) this.f61408b.findViewById(R.id.rbf), aVar, null);
        this.f61425s.getBackground().setAlpha(127);
        this.f61425s.setVisibility(0);
        this.f61429w.setVisibility(0);
        ew.a aVar2 = new ew.a(aVar.f397247a, this.f61411e, aVar.f397249c, false);
        AdelieAvatarHelper.p().u(aVar2, ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getFaceBitmap(aVar2.f397248b, (byte) 5, true), new g());
    }

    private void b0() {
        this.f61423q.setVisibility(0);
        this.f61423q.setText(this.f61412f);
        this.f61424r.setVisibility(0);
        this.f61424r.setText(R.string.djr);
        this.f61409c.setVisibility(8);
        this.f61415i.setVisibility(8);
        a0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(URLDrawable uRLDrawable) {
        this.f61428v.setVisibility(0);
        this.f61428v.setImageDrawable(uRLDrawable);
        this.f61429w.setVisibility(8);
        this.f61425s.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        if (this.f61413g == null || !AdelieAVController.J()) {
            return;
        }
        up.a E = AdelieAVController.D().E();
        if (E != null) {
            boolean p16 = this.f61413g.p(m.l.O, E.f439393l);
            AdelieAVPanel adelieAVPanel = this.f61413g;
            boolean z16 = E.f439393l;
            adelieAVPanel.s(!z16, z16);
            QLog.d("AdelieAVControlUI", 1, "updateAudioBtnStatus mLocalClickMute=" + E.f439393l + " isValid=" + p16);
            return;
        }
        this.f61413g.s(true, false);
        QLog.d("AdelieAVControlUI", 1, "updateAudioBtnStatus session is null");
    }

    private void e0() {
        if (this.f61414h.getVisibility() == 0) {
            QLog.d("AdelieAVControlUI", 1, "showHeadFrame is already showed.");
            return;
        }
        QLog.d("AdelieAVControlUI", 1, "updateHeadFrameParam");
        this.f61414h.setVisibility(0);
        this.f61428v.setVisibility(8);
        Resources resources = this.f61408b.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f61414h.getLayoutParams();
        int i3 = resources.getDisplayMetrics().heightPixels;
        if (resources.getConfiguration().orientation == 2) {
            i3 = resources.getDisplayMetrics().widthPixels;
        }
        int f16 = ((int) (i3 * 0.18f)) + BaseAIOUtils.f(15.0f, resources);
        layoutParams.topMargin = f16;
        this.f61414h.requestLayout();
        ((RelativeLayout.LayoutParams) this.f61426t.getLayoutParams()).topMargin = f16 - ((resources.getDimensionPixelSize(R.dimen.f12838j) - resources.getDimensionPixelSize(R.dimen.a4s)) / 2);
        this.f61426t.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0() {
        ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAVControlUI.12
            @Override // java.lang.Runnable
            public void run() {
                up.a E;
                if (AdelieAVController.J() && (E = AdelieAVController.D().E()) != null && E.e() == 2) {
                    AdelieAVControlUI.this.Z(false);
                    AdelieAVControlUI.this.h0();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(boolean z16) {
        AdelieAVPanel adelieAVPanel;
        boolean z17 = com.tencent.adelie.av.ui.c.N;
        QLog.d("AdelieAVControlUI", 1, "updateMuteSpeakerClickable clickable=" + z16 + " showingAnim=" + z17);
        if (z17 || (adelieAVPanel = this.f61413g) == null) {
            return;
        }
        adelieAVPanel.setViewEnable(m.l.O, z16);
        this.f61413g.setViewEnable(m.l.P, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        QLog.d("AdelieAVControlUI", 1, "updateRobotBackground.");
        if (TextUtils.isEmpty(this.f61431y)) {
            QLog.e("AdelieAVControlUI", 1, "updateRobotBackground url is empty.");
            return;
        }
        URLDrawable drawable = URLDrawable.getDrawable(this.f61431y, URLDrawable.URLDrawableOptions.obtain());
        if (drawable == null) {
            QLog.d("AdelieAVControlUI", 1, "updateRobotBackground drawable is null.");
            this.f61428v.setVisibility(8);
        } else {
            if (drawable.getStatus() != 1) {
                QLog.d("AdelieAVControlUI", 1, "updateRobotBackground setDrawable.");
                drawable.setURLDrawableListener(new a());
                this.f61428v.setVisibility(0);
                this.f61428v.setImageDrawable(drawable);
                return;
            }
            c0(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        up.a E;
        if (AdelieAVController.J() && (E = AdelieAVController.D().E()) != null) {
            this.f61413g.p(m.l.P, E.f439391j);
        }
    }

    private void j0() {
        up.a E = AdelieAVController.D().E();
        if (E != null && E.e() == 2) {
            if (this.f61410d == null) {
                this.f61410d = new AdelieAVTimerController(this.f61409c);
            }
            this.f61410d.e();
            Z(false);
            return;
        }
        if (this.f61410d == null) {
            b0();
        }
    }

    public void I(View view) {
        int id5 = view.getId();
        HashMap hashMap = new HashMap();
        up.a E = AdelieAVController.D().E();
        String str = "1";
        if (id5 == m.l.O) {
            Q();
            if (E != null) {
                if (!E.f439392k) {
                    str = "2";
                }
                hashMap.put("status", str);
            }
            tp.b.f437029a.c("em_bas_microphone", hashMap);
            return;
        }
        if (id5 == m.l.P) {
            R();
            if (E != null) {
                if (E.f439391j) {
                    str = "2";
                }
                hashMap.put("status", str);
            }
            tp.b.f437029a.c("em_bas_loudspeaker", hashMap);
            return;
        }
        if (id5 == m.l.f76074t) {
            this.f61418l.k();
            N(true);
            tp.b.f437029a.b("em_bas_hang_up");
        } else if (id5 == R.id.rba) {
            O();
            tp.b.f437029a.c("em_bas_minification_window", hashMap);
        }
    }

    public up.a M() {
        if (AdelieAVController.J()) {
            return AdelieAVController.D().E();
        }
        return null;
    }

    public void P() {
        O();
    }

    public void S() {
        this.f61413g.l(com.tencent.av.utils.e.d());
        this.f61413g = null;
        com.tencent.adelie.av.ui.a aVar = this.f61418l;
        if (aVar != null) {
            aVar.d();
            this.f61418l = null;
        }
        com.tencent.adelie.av.ui.c cVar = this.f61427u;
        if (cVar != null) {
            cVar.i();
            this.f61427u = null;
        }
        this.f61409c.setCompoundDrawables(null, null, null, null);
        AdelieAVChatStatusManager adelieAVChatStatusManager = this.f61417k;
        if (adelieAVChatStatusManager != null) {
            adelieAVChatStatusManager.s();
            this.f61417k = null;
        }
        ImageView imageView = this.f61429w;
        if (imageView != null) {
            imageView.setImageDrawable(null);
            this.f61429w = null;
        }
        ImageView imageView2 = this.f61428v;
        if (imageView2 != null) {
            imageView2.setImageDrawable(null);
            this.f61428v = null;
        }
        this.B = null;
        this.f61414h = null;
        this.f61415i = null;
        this.f61421o = false;
        try {
            if (this.f61422p) {
                this.f61407a.get().unregisterReceiver(this.f61432z);
                this.f61422p = false;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        this.f61407a = null;
        boolean z16 = !AdelieAVController.J();
        Y();
        if (z16) {
            AdelieAVController.x();
        }
    }

    public void T() {
        X();
    }

    @Override // com.tencent.adelie.av.ui.AdelieAVChatStatusManager.b
    public void onChange(int i3) {
        tp.c.g().h(i3);
        QLog.d("AdelieAVControlUI", 1, "onChange status=" + i3 + " mInterrupting=" + this.f61421o);
        if (i3 != 2 && i3 != 3) {
            d0();
        } else {
            this.f61413g.setAudioVolumeValue(0);
        }
        if (!this.f61421o || i3 == 1) {
            return;
        }
        if (AdelieAVController.J()) {
            AdelieAVController.D().Q();
        }
        this.f61421o = false;
        QLog.d("AdelieAVControlUI", 1, "resume interrupt startAudioRecv");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(boolean z16) {
        if (z16) {
            com.tencent.adelie.av.ui.c cVar = this.f61427u;
            if (cVar != null) {
                cVar.l();
                return;
            }
            return;
        }
        U();
        com.tencent.adelie.av.ui.c cVar2 = this.f61427u;
        if (cVar2 != null) {
            cVar2.o(false);
        }
    }

    public AdelieAVControlUI(Activity activity, String str, String str2) {
        this.f61422p = false;
        this.f61407a = new WeakReference<>(activity);
        this.f61411e = str;
        this.f61412f = str2;
        RelativeLayout relativeLayout = (RelativeLayout) activity.findViewById(R.id.rbb);
        this.f61408b = relativeLayout;
        View findViewById = relativeLayout.findViewById(R.id.rbe);
        this.f61414h = findViewById;
        findViewById.setVisibility(8);
        this.f61415i = (TextView) this.f61408b.findViewById(R.id.f163657ra4);
        this.f61423q = (TextView) this.f61408b.findViewById(R.id.ra6);
        this.f61424r = (TextView) this.f61408b.findViewById(R.id.ra7);
        this.f61409c = (TextView) this.f61408b.findViewById(R.id.f163656ra3);
        this.f61428v = (ImageView) activity.findViewById(R.id.rb_);
        this.f61429w = (ImageView) activity.findViewById(R.id.ra5);
        ImageView imageView = (ImageView) this.f61408b.findViewById(R.id.rbh);
        this.f61425s = imageView;
        imageView.setVisibility(8);
        this.f61426t = (ImageView) this.f61408b.findViewById(R.id.ra9);
        this.f61420n = ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getLongAccountUin();
        K();
        com.tencent.adelie.av.ui.c cVar = new com.tencent.adelie.av.ui.c(activity, this.f61416j, this.f61408b.findViewById(R.id.rbf), this.f61426t, this.f61423q, this.f61424r, this.f61425s, this.f61408b.findViewById(R.id.ra8), this.f61408b.findViewById(R.id.f163655ra2), this.f61409c, this.f61415i);
        this.f61427u = cVar;
        cVar.k(new e());
        RelativeLayout relativeLayout2 = (RelativeLayout) this.f61408b.findViewById(R.id.rbw);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout2.getLayoutParams();
        layoutParams.topMargin = BaseAIOUtils.f(15.0f, this.f61407a.get().getResources());
        relativeLayout2.setLayoutParams(layoutParams);
        AdelieAVPanel adelieAVPanel = (AdelieAVPanel) this.f61408b.findViewById(R.id.rbk);
        this.f61413g = adelieAVPanel;
        adelieAVPanel.g(m.a.f75990a);
        AdelieAVController.D().v(this.A);
        j0();
        this.f61417k = new AdelieAVChatStatusManager(activity, true, this.B, this);
        this.f61418l = new com.tencent.adelie.av.ui.a(this.f61408b);
        up.a M = M();
        if (M != null && M.e() != 0 && M.e() != 1) {
            g0(true);
        } else {
            this.f61418l.j(new f());
            g0(false);
        }
        d0();
        int C = AdelieAVController.D().C();
        V(C);
        if (M != null) {
            QLog.d("AdelieAVControlUI", 1, "init audioRoute=" + C + " mLocalClickMute=" + M.f439393l + " localMute=" + M.f439392k + " mPeerUin=" + this.f61411e + " mIsHeadMode=" + this.f61416j);
        } else {
            QLog.d("AdelieAVControlUI", 1, "init audioRoute=" + C);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.adelie.av.exit");
        try {
            this.f61422p = true;
            activity.registerReceiver(this.f61432z, intentFilter);
        } catch (Throwable th5) {
            th5.printStackTrace();
            this.f61422p = false;
        }
    }
}
