package com.tencent.av.ui.part.invite.multi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.GInviteTimeOutHelper;
import com.tencent.av.r;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.m;
import com.tencent.av.ui.s;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.ag;
import com.tencent.av.utils.bb;
import com.tencent.avcore.jni.audiodevice.TraeConstants;
import com.tencent.biz.richframework.part.Part;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.h;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.utils.GameActivityStatusWatcher;
import cooperation.qzone.remote.ServiceConst;
import java.io.File;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends Part {
    static boolean I = false;
    static bb J;
    private long[] C;
    private long D;
    private int E;
    private int F;
    private int G;
    private SessionInfo H;

    /* renamed from: d, reason: collision with root package name */
    private BroadcastReceiver f76517d = null;

    /* renamed from: e, reason: collision with root package name */
    private QavPanel f76518e = null;

    /* renamed from: f, reason: collision with root package name */
    private boolean f76519f = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f76520h = false;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f76521i = false;

    /* renamed from: m, reason: collision with root package name */
    private s f76522m = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f76524d;

        b(boolean z16) {
            this.f76524d = z16;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            DataReport.Y(false, false);
            if (dialogInterface != null) {
                dialogInterface.dismiss();
                if (!this.f76524d || a.this.f76518e == null || a.this.f76518e.L == null) {
                    return;
                }
                a.this.f76518e.L.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements s.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f76526a;

        c(long j3) {
            this.f76526a = j3;
        }

        @Override // com.tencent.av.ui.s.e
        public void a() {
            a.this.G9(this.f76526a);
            if (a.this.getActivity() != null) {
                a.this.getActivity().overridePendingTransition(0, R.anim.f154854e3);
            }
        }

        @Override // com.tencent.av.ui.s.e
        public void b() {
            if (a.this.f76518e != null) {
                a.this.f76518e.setViewEnable(m.l.f76066l, false);
                a.this.f76518e.setViewEnable(m.l.f76067m, false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class d implements s.e {
        d() {
        }

        @Override // com.tencent.av.ui.s.e
        public void a() {
            Activity activity = a.this.getActivity();
            if (activity != null) {
                activity.finish();
                activity.overridePendingTransition(0, R.anim.f154854e3);
            }
        }

        @Override // com.tencent.av.ui.s.e
        public void b() {
            if (a.this.f76518e != null) {
                a.this.f76518e.setViewEnable(m.l.f76067m, false);
                a.this.f76518e.setViewEnable(m.l.f76066l, false);
                a.this.f76518e.setViewEnable(m.l.f76064j, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        int f76529d;

        public e(int i3) {
            this.f76529d = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            int i16 = this.f76529d;
            if (i16 != 0) {
                if ((i16 == 1 || i16 == 2) && a.this.getActivity() != null) {
                    a.this.getActivity().finish();
                }
            } else {
                if (r.h0().W0()) {
                    r.h0().Z1();
                }
                a.this.N9();
            }
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class f extends BroadcastReceiver {
        f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                String stringExtra = intent.getStringExtra("reason");
                if (stringExtra == null || !stringExtra.equals(GameActivityStatusWatcher.InnerRecevier.SYSTEM_DIALOG_REASON_HOME_KEY)) {
                    return;
                }
                ReportController.o(null, "CliOper", "", "", "0X8004210", "0X8004210", 0, 0, "", "", "", "");
                a.this.F9(-1038L);
                return;
            }
            if (action.equals(IECScreenReceiver.ACTION_SCREEN_OFF)) {
                boolean g16 = r.g1(a.this.getContext());
                if (g16) {
                    ReportController.o(null, "CliOper", "", "", "0X800420C", "0X800420C", 0, 0, "", "", "", "");
                }
                if (QLog.isColorLevel()) {
                    QLog.w("GaInviteAcceptRefusePart", 1, "ACTION_SCREEN_OFF, isScreenLocked[" + g16 + "]");
                }
            }
        }
    }

    public a(long j3, int i3, int i16, int i17, long[] jArr, SessionInfo sessionInfo) {
        this.D = j3;
        this.C = jArr;
        this.E = i3;
        this.F = i16;
        this.H = sessionInfo;
        this.G = i17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E9(boolean z16) {
        VideoAppInterface b16 = nw.b.b();
        if (b16 == null || !b16.b0()) {
            return false;
        }
        DataReport.Y(false, true);
        if (getActivity() != null && getContext() != null) {
            DialogUtil.showSlideAcceptDialog(getActivity(), getContext().getString(R.string.d_o), getContext().getString(R.string.d_m), null, new b(z16), null);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F9(long j3) {
        s sVar;
        if (SmallScreenUtils.p(getContext()) && (sVar = this.f76522m) != null) {
            sVar.d(new c(j3));
        } else {
            G9(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N9() {
        int i3;
        Q9(com.tencent.av.utils.e.d());
        Intent intent = new Intent(getContext(), (Class<?>) AVActivity.class);
        intent.addFlags(262144);
        intent.addFlags(268435456);
        intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 3);
        intent.putExtra("GroupId", String.valueOf(this.D));
        intent.putExtra("Type", 1);
        intent.putExtra("DiscussUinList", this.C);
        intent.putExtra("needStartTRAE", true);
        int i16 = this.H.f73063p;
        if (i16 == 0 && (i3 = this.G) > 0) {
            intent.putExtra("MultiAVType", i3);
        } else {
            intent.putExtra("MultiAVType", i16);
        }
        intent.putExtra("uin", String.valueOf(this.D));
        intent.putExtra("uinType", this.F);
        intent.putExtra("isFromInviteDialog", true);
        intent.putExtra("needNotifyHangupEvent", this.H.I2);
        com.tencent.av.utils.e.m("GaInviteActivity.startGActivity", intent.getExtras());
        Activity activity = getActivity();
        QLog.w("GaInviteAcceptRefusePart", 1, "startGActivity hostActivity=" + activity + " mMultiAvType=" + this.G + " session.multiAVType=" + this.H.f73063p);
        if (activity != null) {
            activity.startActivity(intent);
            this.f76521i = true;
            activity.finish();
            activity.overridePendingTransition(R.anim.f154855e4, 0);
        }
    }

    public static void Q9(long j3) {
        if (QLog.isColorLevel()) {
            QLog.i("GaInviteAcceptRefusePart", 2, "stopRingAndShake seq[" + j3 + "], IsPlayingRing[" + I + "]");
        }
        if (I) {
            I = false;
            TraeHelper.I().k0(j3);
        }
        TraeHelper.n0(nw.b.b());
    }

    public void C9(View view) {
        String str;
        if (r.g1(getContext())) {
            str = "1";
        } else {
            str = "2";
        }
        String str2 = str;
        int id5 = view.getId();
        if (id5 != m.l.f76066l && id5 != m.l.f76067m) {
            if (id5 != m.l.f76064j || E9(false)) {
                return;
            }
            ReportController.o(null, "CliOper", "", "", "0X8009E94", "0X8009E94", 0, 0, str2, "", "", "");
            this.f76520h = true;
            if (getActivity() != null) {
                getActivity().sendBroadcast(new Intent("tencent.video.v2g.match_friend.exit_voice_chat"));
            }
            N9();
            return;
        }
        ReportController.o(null, "CliOper", "", "", "0X8009E93", "0X8009E93", 0, 0, str2, "", "", "");
        this.f76520h = false;
        F9(-1037L);
    }

    public void G9(long j3) {
        r.h0().P0(j3, this.E, this.D);
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    public void H9(long j3, int i3) {
        r.h0().Q0(j3, this.E, this.D, i3, false);
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    void I9(View view) {
        boolean g16 = r.g1(getContext());
        if (this.f76518e == null) {
            QavPanel qavPanel = (QavPanel) view.findViewById(R.id.f166587gb4);
            this.f76518e = qavPanel;
            qavPanel.g0(m.a.f75996g);
            this.f76518e.P0(new C0773a());
        }
        View findViewById = this.f76518e.findViewById(R.id.g8w);
        View findViewById2 = this.f76518e.findViewById(R.id.g8u);
        findViewById.setVisibility(g16 ? 8 : 0);
        findViewById2.setVisibility(g16 ? 0 : 8);
        view.findViewById(m.l.f76080z).setVisibility(g16 ? 8 : 0);
        View findViewById3 = view.findViewById(R.id.g8p);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById3.getLayoutParams();
        marginLayoutParams.setMargins(0, ViewUtils.dip2px(g16 ? 88.0f : 46.0f), 0, 0);
        findViewById3.setLayoutParams(marginLayoutParams);
        if (!ThemeUtil.isInNightMode(nw.b.b()) || g16) {
            return;
        }
        view.findViewById(R.id.m18).setVisibility(0);
    }

    public boolean J9() {
        return this.f76520h;
    }

    public boolean K9() {
        return this.f76521i;
    }

    public void L9() {
        s sVar;
        GInviteTimeOutHelper.b().a();
        boolean g16 = r.g1(getContext());
        if (SmallScreenUtils.p(getContext()) && !g16 && (sVar = this.f76522m) != null) {
            sVar.d(new d());
        } else if (getActivity() != null) {
            getActivity().finish();
        }
    }

    void M9() {
        QLog.w("GaInviteAcceptRefusePart", 1, "quitGAudioDialog");
        Context context = getContext();
        if (context == null) {
            QLog.e("GaInviteAcceptRefusePart", 1, "quitGAudioDialog error : context is null.");
            return;
        }
        DialogUtil.createCustomDialog(context, 230, (String) null, context.getString(R.string.dbj), R.string.icb, R.string.d_d, new e(0), new e(1)).show();
    }

    public void O9() {
        P9(this.f76519f);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        Activity activity = getActivity();
        if (activity != null) {
            AudioManager audioManager = (AudioManager) activity.getSystemService("audio");
            if (audioManager.getRingerMode() == 0 || audioManager.getRingerMode() == 1) {
                this.f76519f = true;
            }
        }
        I9(view);
        View findViewById = view.findViewById(R.id.f164334s9);
        s sVar = new s(getContext(), 1, this.f76518e, null, null, (ImageView) view.findViewById(R.id.g8p), (TextView) view.findViewById(R.id.g8c), findViewById, null);
        this.f76522m = sVar;
        sVar.b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
        f fVar = new f();
        this.f76517d = fVar;
        if (activity != null) {
            activity.registerReceiver(fVar, intentFilter);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QavPanel qavPanel = this.f76518e;
        if (qavPanel != null) {
            qavPanel.B0(-1044L);
            this.f76518e = null;
        }
        s sVar = this.f76522m;
        if (sVar != null) {
            sVar.a();
            this.f76522m = null;
        }
        if (this.f76517d != null) {
            if (getActivity() != null) {
                getActivity().unregisterReceiver(this.f76517d);
            }
            this.f76517d = null;
        }
        this.H = null;
        J = null;
        this.C = null;
    }

    public void onResume() {
        if (!this.H.H2) {
            O9();
        }
        I9(getPartRootView());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.av.ui.part.invite.multi.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class C0773a implements QavPanel.n {
        C0773a() {
        }

        @Override // com.tencent.av.ui.QavPanel.n
        public void a(boolean z16) {
            if (!z16 || a.this.E9(true)) {
                return;
            }
            if (!r.h0().W0()) {
                a.this.N9();
            } else {
                a.this.M9();
            }
            ReportController.o(null, "CliOper", "", "", "0X800420E", "0X800420E", 0, 0, "", "", "", "");
        }
    }

    public static void P9(boolean z16) {
        VideoAppInterface b16 = nw.b.b();
        if (b16 == null) {
            QLog.e("GaInviteAcceptRefusePart", 1, "startRingAndShake error");
            return;
        }
        long d16 = com.tencent.av.utils.e.d();
        boolean k3 = AVUtil.k(b16.getCurrentAccountUin());
        if (QLog.isColorLevel()) {
            QLog.i("GaInviteAcceptRefusePart", 2, "startRingAndShake avCallBtnState[" + k3 + "], Silent[" + z16 + "], seq[" + d16 + "]");
        }
        if (k3) {
            if (!z16 && TraeHelper.I() != null) {
                TraeHelper.I().i0(TraeConstants.VIDEO_CALL_CONFIG);
                if (!r.h0().W0()) {
                    I = true;
                    if (J == null) {
                        J = new bb(b16);
                    }
                    long resIdByUin = J.a(b16.getCurrentAccountUin()) != null ? VipFunCallUtil.getResIdByUin(b16, r0.uin, 3, true, null) : 0L;
                    if (resIdByUin == 0) {
                        TraeHelper.I().e0(d16, b16, R.raw.f169424w, -1, null);
                    } else {
                        String e16 = h.e(resIdByUin, 3);
                        if (new File(e16).exists()) {
                            TraeHelper.I().g0(d16, b16, 0, e16, -1, null);
                            ReportController.o(null, "CliOper", "", "", "0X8005004", "0X8005004", 0, 0, "", resIdByUin + "", "", "");
                        } else {
                            TraeHelper.I().e0(d16, b16, R.raw.f169424w, -1, null);
                            if (b16.getApp() != null) {
                                Intent intent = new Intent();
                                intent.setAction("tencent.video.v2q.commingRingDownload");
                                intent.setPackage(b16.getApp().getPackageName());
                                intent.putExtra("comming_ring_down_key", resIdByUin);
                                b16.getApp().sendBroadcast(intent);
                            }
                        }
                    }
                }
            }
            TraeHelper.j0(b16, false, d16);
        }
    }

    public void D9(Intent intent) {
        if (intent == null) {
            return;
        }
        if (ag.b(intent)) {
            ReportController.o(null, "dc00898", "", "", "0X800A2C5", "0X800A2C5", 0, 0, "", "", "", "");
        }
        long b16 = QQAudioHelper.b();
        String action = intent.getAction();
        if ("com.tencent.qav.notify.accept".equals(action)) {
            String stringExtra = intent.getStringExtra(ServiceConst.PARA_SESSION_ID);
            SessionInfo sessionInfo = this.H;
            String str = sessionInfo == null ? null : sessionInfo.f73030h;
            if (TextUtils.equals(stringExtra, str)) {
                if (!E9(false)) {
                    N9();
                    this.f76519f = true;
                } else if (QLog.isColorLevel()) {
                    QLog.i("GaInviteAcceptRefusePart", 2, "checkParamAndDoAction onPhoneCalling");
                }
            } else if (QLog.isColorLevel()) {
                QLog.i("GaInviteAcceptRefusePart", 2, "checkParamAndDoAction not same , coming[" + stringExtra + "], cur[" + str + "]");
            }
            ReportController.o(null, "dc00898", "", "", "0X800A2C6", "0X800A2C6", 0, 0, "", "", "", "");
        } else if ("com.tencent.qav.notify.refuse".equals(action)) {
            TraeHelper.n0(nw.b.b());
            G9(b16);
            this.f76519f = true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("GaInviteAcceptRefusePart", 2, "checkParamAndDoAction action[" + action + "], seq[" + b16 + "], silent[" + this.f76519f + "]");
        }
    }
}
