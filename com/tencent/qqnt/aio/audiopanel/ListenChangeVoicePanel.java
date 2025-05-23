package com.tencent.qqnt.aio.audiopanel;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.VoiceChangeHandler;
import com.tencent.mobileqq.pttlogic.api.IPttPreSendService;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.voicechange.IVoiceChangeHelper;
import com.tencent.mobileqq.voicechange.IVoiceChangeManager;
import com.tencent.mobileqq.voicechange.IVoiceTuneUtil;
import com.tencent.mobileqq.voicechange.c;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* loaded from: classes34.dex */
public class ListenChangeVoicePanel extends RelativeLayout implements VoiceChangeHandler.a, View.OnClickListener, com.tencent.mobileqq.activity.aio.audiopanel.c, DialogInterface.OnClickListener {

    /* renamed from: b0, reason: collision with root package name */
    public static String[] f349557b0 = {HardCodeUtil.qqStr(R.string.npv), HardCodeUtil.qqStr(R.string.f172139nq0), HardCodeUtil.qqStr(R.string.npd), HardCodeUtil.qqStr(R.string.npw), HardCodeUtil.qqStr(R.string.npu), HardCodeUtil.qqStr(R.string.np5), HardCodeUtil.qqStr(R.string.nos), HardCodeUtil.qqStr(R.string.npt), HardCodeUtil.qqStr(R.string.npc), HardCodeUtil.qqStr(R.string.npe), HardCodeUtil.qqStr(R.string.f172134np0), HardCodeUtil.qqStr(R.string.non), HardCodeUtil.qqStr(R.string.noy), HardCodeUtil.qqStr(R.string.npk), HardCodeUtil.qqStr(R.string.nop), HardCodeUtil.qqStr(R.string.nph), HardCodeUtil.qqStr(R.string.f172137np3)};

    /* renamed from: c0, reason: collision with root package name */
    public static String[] f349558c0 = {HardCodeUtil.qqStr(R.string.npi), HardCodeUtil.qqStr(R.string.nox), HardCodeUtil.qqStr(R.string.not), HardCodeUtil.qqStr(R.string.npx), HardCodeUtil.qqStr(R.string.noz), HardCodeUtil.qqStr(R.string.npb), HardCodeUtil.qqStr(R.string.nov), HardCodeUtil.qqStr(R.string.npy), HardCodeUtil.qqStr(R.string.f172135np1), HardCodeUtil.qqStr(R.string.nou), HardCodeUtil.qqStr(R.string.npl), HardCodeUtil.qqStr(R.string.npn), HardCodeUtil.qqStr(R.string.f172138np4), HardCodeUtil.qqStr(R.string.nor), HardCodeUtil.qqStr(R.string.noo), HardCodeUtil.qqStr(R.string.npq), HardCodeUtil.qqStr(R.string.npp)};

    /* renamed from: d0, reason: collision with root package name */
    public static int[] f349559d0 = {R.drawable.aio_voicechange_img_normal, R.drawable.c4k, R.drawable.c4n, R.drawable.c4m, R.drawable.c4j, R.drawable.c4i, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: e0, reason: collision with root package name */
    public static volatile com.tencent.mobileqq.ptt.b f349560e0 = null;

    /* renamed from: f0, reason: collision with root package name */
    public static boolean f349561f0;
    private double C;
    private RecordParams.RecorderParam D;
    ArrayList<com.tencent.mobileqq.voicechange.c> E;
    ArrayList<com.tencent.mobileqq.voicechange.c> F;
    ChangeVoiceView G;
    j H;
    ListView I;
    private int J;
    private int[] K;
    final AtomicInteger L;
    private m M;
    private ArrayList<Byte> N;
    Handler P;
    com.tencent.mobileqq.voicechange.b Q;
    boolean R;
    private p S;
    CallBacker T;
    boolean U;
    Bundle V;
    protected String W;

    /* renamed from: a0, reason: collision with root package name */
    QQProgressDialog f349562a0;

    /* renamed from: d, reason: collision with root package name */
    private volatile int f349563d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<QQAppInterface> f349564e;

    /* renamed from: f, reason: collision with root package name */
    private ViewGroup f349565f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f349566h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f349567i;

    /* renamed from: m, reason: collision with root package name */
    private String f349568m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class a extends Handler {

        /* renamed from: com.tencent.qqnt.aio.audiopanel.ListenChangeVoicePanel$a$a, reason: collision with other inner class name */
        /* loaded from: classes34.dex */
        class C9467a implements IVoiceChangeHelper.a {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f349570d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ArrayList f349571e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f349572f;

            C9467a(int i3, ArrayList arrayList, int i16) {
                this.f349570d = i3;
                this.f349571e = arrayList;
                this.f349572f = i16;
            }

            @Override // com.tencent.mobileqq.voicechange.IVoiceChangeHelper.a
            public void onCompressFinished(String str, int i3, int i16) {
                m mVar = ListenChangeVoicePanel.this.M;
                float f16 = this.f349570d;
                ArrayList<Byte> arrayList = this.f349571e;
                RecordParams.RecorderParam recorderParam = ListenChangeVoicePanel.this.D;
                int i17 = this.f349572f;
                mVar.Z(str, f16, arrayList, recorderParam, i17 > 0, false, i17);
            }
        }

        a(Looper looper) {
            super(looper);
        }

        private boolean b() {
            String str;
            ListenChangeVoicePanel listenChangeVoicePanel = ListenChangeVoicePanel.this;
            String str2 = listenChangeVoicePanel.E.get(listenChangeVoicePanel.H.f349698f).f313146b;
            if (ListenChangeVoicePanel.this.G.d().getText() != null) {
                str = ListenChangeVoicePanel.this.G.d().getText().toString();
            } else {
                str = "";
            }
            return str2.equals(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            ListenChangeVoicePanel.this.M.Z(ListenChangeVoicePanel.this.f349568m, (int) ListenChangeVoicePanel.this.C, ListenChangeVoicePanel.this.N, ListenChangeVoicePanel.this.D, ListenChangeVoicePanel.this.f349563d > 0, false, ListenChangeVoicePanel.this.f349563d);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ChangeVoiceView changeVoiceView;
            Bundle bundle;
            switch (message.what) {
                case 101:
                    ListenChangeVoicePanel.this.f349563d = -1;
                    ListenChangeVoicePanel listenChangeVoicePanel = ListenChangeVoicePanel.this;
                    listenChangeVoicePanel.H.f349698f = 0;
                    listenChangeVoicePanel.G = null;
                    synchronized (listenChangeVoicePanel.F) {
                        ListenChangeVoicePanel listenChangeVoicePanel2 = ListenChangeVoicePanel.this;
                        j jVar = listenChangeVoicePanel2.H;
                        jVar.f349700i = listenChangeVoicePanel2.F;
                        jVar.notifyDataSetChanged();
                    }
                    return;
                case 102:
                default:
                    return;
                case 103:
                    Object obj = message.obj;
                    if (obj == null || !(obj instanceof Bundle) || (changeVoiceView = ListenChangeVoicePanel.this.G) == null || (bundle = (Bundle) obj) == null) {
                        return;
                    }
                    changeVoiceView.b(bundle.getInt("progress"), bundle.getInt(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_TIME), bundle.getInt("level"));
                    return;
                case 104:
                    if (ListenChangeVoicePanel.this.G == null || !b()) {
                        return;
                    }
                    ListenChangeVoicePanel.this.G.a(1);
                    return;
                case 105:
                    if (ListenChangeVoicePanel.this.f349564e.get() != null) {
                        QQToast.makeText(((QQAppInterface) ListenChangeVoicePanel.this.f349564e.get()).getApp(), "\u64ad\u653e\u53d8\u97f3error", 0);
                    }
                    ChangeVoiceView changeVoiceView2 = ListenChangeVoicePanel.this.G;
                    if (changeVoiceView2 != null) {
                        changeVoiceView2.a(1);
                        return;
                    }
                    return;
                case 106:
                    if (ListenChangeVoicePanel.this.f349564e.get() == null) {
                        return;
                    }
                    if (((IVoiceChangeManager) QRoute.api(IVoiceChangeManager.class)).isVoiceChangeFinished(ListenChangeVoicePanel.this.f349568m)) {
                        QLog.i("ListenChangeVoicePanel", 1, "send msg voice change finished, mCurType:" + ListenChangeVoicePanel.this.f349563d);
                        if (com.tencent.qqnt.audio.l.a()) {
                            ((IVoiceTuneUtil) QRoute.api(IVoiceTuneUtil.class)).asyncDeleteOtherTmpFile(ListenChangeVoicePanel.this.f349568m, ListenChangeVoicePanel.this.f349568m, ListenChangeVoicePanel.this.f349563d, new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.n
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ListenChangeVoicePanel.a.this.c();
                                }
                            });
                        } else {
                            ((IVoiceTuneUtil) QRoute.api(IVoiceTuneUtil.class)).deleteOtherTmpFiles(ListenChangeVoicePanel.this.f349568m, ListenChangeVoicePanel.this.f349568m, ListenChangeVoicePanel.this.f349563d);
                            ListenChangeVoicePanel.this.M.Z(ListenChangeVoicePanel.this.f349568m, (int) ListenChangeVoicePanel.this.C, ListenChangeVoicePanel.this.N, ListenChangeVoicePanel.this.D, ListenChangeVoicePanel.this.f349563d > 0, false, ListenChangeVoicePanel.this.f349563d);
                        }
                    } else {
                        QLog.i("ListenChangeVoicePanel", 1, "send msg voice change not finished, mCurType:" + ListenChangeVoicePanel.this.f349563d);
                        C9467a c9467a = new C9467a((int) ListenChangeVoicePanel.this.C, ListenChangeVoicePanel.this.N, ListenChangeVoicePanel.this.f349563d);
                        ListenChangeVoicePanel.this.M.C0(ListenChangeVoicePanel.this.f349568m, (int) ListenChangeVoicePanel.this.C, ListenChangeVoicePanel.this.N, ListenChangeVoicePanel.this.D, ListenChangeVoicePanel.this.f349563d > 0, false, ListenChangeVoicePanel.this.f349563d);
                        boolean queryStateByPath = ((IVoiceChangeManager) QRoute.api(IVoiceChangeManager.class)).queryStateByPath(ListenChangeVoicePanel.this.f349568m, c9467a);
                        IVoiceChangeManager iVoiceChangeManager = (IVoiceChangeManager) QRoute.api(IVoiceChangeManager.class);
                        BaseApplication app = ((QQAppInterface) ListenChangeVoicePanel.this.f349564e.get()).getApp();
                        ListenChangeVoicePanel listenChangeVoicePanel3 = ListenChangeVoicePanel.this;
                        iVoiceChangeManager.requestToSend(app, listenChangeVoicePanel3.Q, PressToChangeVoicePanel.U, listenChangeVoicePanel3.S, queryStateByPath ? null : c9467a);
                    }
                    if (ListenChangeVoicePanel.f349560e0 != null) {
                        ListenChangeVoicePanel.f349560e0.a((AppRuntime) ListenChangeVoicePanel.this.f349564e.get(), ListenChangeVoicePanel.this.f349563d);
                        if (ListenChangeVoicePanel.this.f349563d > 0) {
                            ReportController.o((AppRuntime) ListenChangeVoicePanel.this.f349564e.get(), "CliOper", "", "", "changevoice", "0X8006F7C", 0, 0, "", "" + ListenChangeVoicePanel.this.f349563d, "", "");
                        }
                    }
                    ListenChangeVoicePanel.this.s();
                    ListenChangeVoicePanel.this.m();
                    ListenChangeVoicePanel listenChangeVoicePanel4 = ListenChangeVoicePanel.this;
                    boolean z16 = listenChangeVoicePanel4.R;
                    int unused = listenChangeVoicePanel4.f349563d;
                    int unused2 = ListenChangeVoicePanel.this.J;
                    return;
                case 107:
                    ListenChangeVoicePanel.this.a(message.arg1, message.arg2, message.obj, true);
                    return;
            }
        }
    }

    public ListenChangeVoicePanel(Context context) {
        super(context);
        this.f349563d = -1;
        this.E = new ArrayList<>();
        this.F = new ArrayList<>();
        this.J = -1;
        this.K = new int[IVoiceTuneUtil.VOICE_TYPES.length];
        this.L = new AtomicInteger(0);
        this.P = new a(Looper.getMainLooper());
        this.S = new p(this);
        this.T = new b();
        this.W = "mvip.gxh.android.changevoice_";
    }

    public void n(QQAppInterface qQAppInterface, m mVar, ViewGroup viewGroup) {
        this.f349564e = new WeakReference<>(qQAppInterface);
        this.M = mVar;
        this.f349565f = viewGroup;
        this.f349566h = (TextView) super.findViewById(R.id.ebw);
        this.f349567i = (TextView) super.findViewById(R.id.listen_panel_send_tv);
        this.f349566h.setOnClickListener(this);
        this.f349567i.setOnClickListener(this);
        this.I = (ListView) super.findViewById(R.id.d_r);
        j jVar = new j(super.getContext());
        this.H = jVar;
        jVar.f349699h = this;
        this.I.setAdapter((ListAdapter) jVar);
        synchronized (this.E) {
            if (this.E.size() < IVoiceTuneUtil.VOICE_TYPES.length) {
                int i3 = 0;
                while (true) {
                    int[] iArr = IVoiceTuneUtil.VOICE_TYPES;
                    if (i3 >= iArr.length) {
                        break;
                    }
                    this.E.add(new com.tencent.mobileqq.voicechange.c(iArr[i3], f349557b0[i3], f349558c0[i3], 0, i3 >= 6 ? 0 : 2, 1, new c.a(f349559d0[i3], null, null, null)));
                    i3++;
                }
            }
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.ListenChangeVoicePanel.2
            @Override // java.lang.Runnable
            public void run() {
                ListenChangeVoicePanel.this.p(false);
            }
        }, 8, null, true);
    }

    public void o() {
        this.J = this.f349563d;
        if (this.f349563d == -1) {
            this.f349563d = 0;
        }
        ChangeVoiceView changeVoiceView = this.G;
        if (changeVoiceView != null) {
            changeVoiceView.a(1);
        }
        this.R = false;
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.c
    public boolean onBackEvent() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "ListenPanel.onBackEvent() is called,audioPath is:" + this.f349568m);
        }
        setVisibility(8);
        PressToChangeVoicePanel pressToChangeVoicePanel = (PressToChangeVoicePanel) this.f349565f.findViewById(R.id.fy7);
        pressToChangeVoicePanel.s();
        pressToChangeVoicePanel.setVisibility(0);
        this.M.O(this.f349568m);
        ((IVoiceChangeManager) QRoute.api(IVoiceChangeManager.class)).requestToCancel(this.Q);
        WeakReference<QQAppInterface> weakReference = this.f349564e;
        if (weakReference != null && weakReference.get() != null) {
            if (f349560e0 != null) {
                f349560e0.a(this.f349564e.get(), -1);
            }
            ((IPttPreSendService) this.f349564e.get().getRuntimeService(IPttPreSendService.class)).doOnCancelSend();
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        int id5 = view.getId();
        int i3 = 1;
        if (id5 == R.id.ebw) {
            QLog.i("ListenChangeVoicePanel", 1, "click to cancel, mCurType:" + this.f349563d);
            ChangeVoiceView changeVoiceView = this.G;
            if (changeVoiceView != null) {
                changeVoiceView.a(1);
            }
            this.M.O(this.f349568m);
            s();
            ((IVoiceChangeManager) QRoute.api(IVoiceChangeManager.class)).requestToCancel(this.Q);
            if (this.f349564e.get() != null) {
                ((IPttPreSendService) this.f349564e.get().getRuntimeService(IPttPreSendService.class)).doOnCancelSend();
                if (f349560e0 != null) {
                    f349560e0.a(this.f349564e.get(), -1);
                }
            }
        } else {
            ChangeVoiceView changeVoiceView2 = null;
            if (id5 == R.id.listen_panel_send_tv) {
                QLog.i("ListenChangeVoicePanel", 1, "click to send, mCurType:" + this.f349563d);
                if (this.f349563d >= 6) {
                    t(true, R.string.f6i);
                    if (this.f349564e.get() != null) {
                        ((VoiceChangeHandler) this.f349564e.get().getBusinessHandler(BusinessHandlerFactory.CHANGE_VOICE_HANDLER)).D2(1, this.f349563d, this);
                    }
                } else {
                    Handler handler = this.P;
                    handler.sendMessage(Message.obtain(handler, 106, null));
                }
                i3 = 2;
            } else {
                this.R = true;
                if (view instanceof ChangeVoiceView) {
                    ChangeVoiceView changeVoiceView3 = (ChangeVoiceView) view;
                    com.tencent.mobileqq.voicechange.c cVar = changeVoiceView3.J;
                    if (cVar == null) {
                        return;
                    }
                    if (2 == cVar.f313148d) {
                        int i16 = changeVoiceView3.D;
                        this.H.f349698f = i16;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("click to play changed voice, mCurType:");
                        sb5.append(this.f349563d);
                        sb5.append(", isPlay:");
                        sb5.append(i16 != this.f349563d);
                        QLog.i("ListenChangeVoicePanel", 1, sb5.toString());
                        if (i16 != this.f349563d) {
                            if (this.G == null) {
                                ListView listView = this.I;
                                ViewGroup viewGroup = (listView == null || listView.getChildCount() <= 0 || !(this.I.getChildAt(0) instanceof ViewGroup)) ? null : (ViewGroup) this.I.getChildAt(0);
                                if (viewGroup != null && viewGroup.getChildCount() > 0 && (viewGroup.getChildAt(0) instanceof ChangeVoiceView)) {
                                    changeVoiceView2 = (ChangeVoiceView) viewGroup.getChildAt(0);
                                }
                                this.G = changeVoiceView2;
                            }
                            ChangeVoiceView changeVoiceView4 = this.G;
                            if (changeVoiceView4 != null && changeVoiceView3 != changeVoiceView4) {
                                changeVoiceView4.a(0);
                            }
                            this.G = changeVoiceView3;
                            changeVoiceView3.a(2);
                            this.f349563d = i16;
                            q();
                            this.K[this.f349563d] = 1;
                        } else {
                            this.G = changeVoiceView3;
                            if (changeVoiceView3.c() == 2) {
                                changeVoiceView3.a(1);
                                ((IVoiceChangeManager) QRoute.api(IVoiceChangeManager.class)).requestToPause(this.Q);
                            } else if (changeVoiceView3.c() == 1) {
                                q();
                                changeVoiceView3.a(2);
                            } else if (QLog.isColorLevel()) {
                                QLog.e("changevoice", 2, "CLICK EXCEPTION\uff0c curtype = " + this.f349563d + " newtype is " + i16 + " state is " + changeVoiceView3.c());
                            }
                        }
                    } else {
                        u(4, changeVoiceView3.D, null, HardCodeUtil.qqStr(R.string.npf), null, null, null);
                    }
                    i3 = 0;
                } else {
                    i3 = -1;
                }
            }
        }
        if (i3 < 0 || this.f349564e.get() == null) {
            return;
        }
        QQAppInterface qQAppInterface = this.f349564e.get();
        String str2 = "" + i3;
        if (i3 == 0) {
            str = "" + this.f349563d;
        } else {
            str = "";
        }
        ReportController.o(qQAppInterface, "CliOper", "", "", "changevoice", "0X8006F50", 0, 0, str2, str, "", "");
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.c
    public void onDestroy() {
        WeakReference<QQAppInterface> weakReference = this.f349564e;
        if (weakReference != null && weakReference.get() != null) {
            ((IVasQuickUpdateService) this.f349564e.get().getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(this.T);
        }
        if (this.f349568m == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "ListenPanel.onBackEvent() is called,audioPath is:" + this.f349568m);
        }
        s();
        ((IVoiceChangeManager) QRoute.api(IVoiceChangeManager.class)).requestToCancel(this.Q);
        this.M.O(this.f349568m);
        f349561f0 = false;
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.c
    public void onPause() {
        ((IVoiceChangeManager) QRoute.api(IVoiceChangeManager.class)).requestToPause(this.Q);
        ChangeVoiceView changeVoiceView = this.G;
        if (changeVoiceView != null) {
            changeVoiceView.a(1);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void p(boolean z16) {
        if (this.f349564e.get() == null) {
            return;
        }
        JSONObject jSONFromLocal = VasUpdateUtil.getJSONFromLocal(this.f349564e.get(), VasUpdateConstants.SCID_CHANGEVOICE, !z16, this.T);
        if (jSONFromLocal != null) {
            boolean preCheckData = ((IVoiceChangeManager) QRoute.api(IVoiceChangeManager.class)).preCheckData(this.E, jSONFromLocal, this.f349564e.get());
            if (QLog.isColorLevel()) {
                QLog.d("ListenChangeVoicePanel", 2, "initVoiceDatas startDownload json.isLoaded=" + z16 + ", isChecked=" + preCheckData);
            }
        } else if (QLog.isColorLevel() || z16) {
            QLog.d("ListenChangeVoicePanel", 2, "initVoiceDatas null=xydata startDownload json. isLoaded=" + z16);
        }
        synchronized (this.F) {
            this.F.clear();
            for (int size = this.E.size() - 1; size >= 0; size--) {
                com.tencent.mobileqq.voicechange.c cVar = this.E.get(size);
                if (cVar.f313148d != 0) {
                    if (6 > size) {
                        this.F.add(0, cVar);
                    } else {
                        this.F.add(cVar);
                    }
                }
            }
            Handler handler = this.P;
            handler.sendMessage(Message.obtain(handler, 101, null));
        }
    }

    public void q() {
        this.Q.f313144g = this.f349563d;
        if (this.f349564e.get() != null) {
            if (this.L.getAndIncrement() == 0) {
                QQAudioUtils.i(BaseApplication.getContext(), true);
            }
            ((IVoiceChangeManager) QRoute.api(IVoiceChangeManager.class)).requestToStart(this.f349564e.get().getApp(), this.Q, PressToChangeVoicePanel.U, this.S);
        }
    }

    public void r() {
        if (this.f349563d == -1) {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.ListenChangeVoicePanel.4
                @Override // java.lang.Runnable
                public void run() {
                    if (ListenChangeVoicePanel.this.f349564e.get() != null && ListenChangeVoicePanel.f349560e0 == null) {
                        ListenChangeVoicePanel.f349560e0 = ((IPttUtils) QRoute.api(IPttUtils.class)).createPttVoiceChangePreSender((AppRuntime) ListenChangeVoicePanel.this.f349564e.get());
                    }
                }
            });
        }
    }

    public void setAudioData(ArrayList<Byte> arrayList) {
        this.N = arrayList;
    }

    public void setAudioPath(String str, double d16, RecordParams.RecorderParam recorderParam) {
        this.f349568m = str;
        this.C = d16;
        this.D = recorderParam;
        this.Q = new com.tencent.mobileqq.voicechange.b(str, recorderParam.f307255d, recorderParam.f307256e, recorderParam.f307257f, this.f349563d);
        if (AppSetting.f99565y) {
            AccessibilityUtil.m(this.G);
        }
    }

    boolean u(int i3, int i16, String str, String str2, String str3, String str4, String str5) {
        Bundle bundle = new Bundle();
        this.V = bundle;
        bundle.putInt("funcType", i3);
        this.V.putString("url", str5);
        this.V.putInt("fcID", i16);
        if (TextUtils.isEmpty(str)) {
            str = HardCodeUtil.qqStr(R.string.npz);
        }
        String str6 = str;
        if (TextUtils.isEmpty(str2)) {
            str2 = HardCodeUtil.qqStr(R.string.npo);
        }
        String str7 = str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = HardCodeUtil.qqStr(R.string.j6l);
        }
        String str8 = str3;
        if (TextUtils.isEmpty(str4)) {
            str4 = HardCodeUtil.qqStr(R.string.ket);
        }
        String str9 = str4;
        if (QLog.isColorLevel()) {
            QLog.d("ListenChangeVoicePanel", 1, "showTips content=" + str7 + ", title=" + str6);
        }
        DialogUtil.createCustomDialog(getContext(), 0, str6, str7, str8, str9, this, this).show();
        return true;
    }

    public void s() {
        setVisibility(8);
        ViewGroup viewGroup = this.f349565f;
        if (viewGroup != null) {
            PressToChangeVoicePanel pressToChangeVoicePanel = (PressToChangeVoicePanel) viewGroup.findViewById(R.id.fy7);
            pressToChangeVoicePanel.s();
            pressToChangeVoicePanel.setVisibility(0);
        }
        int i3 = 0;
        while (true) {
            int[] iArr = this.K;
            if (i3 >= iArr.length) {
                return;
            }
            iArr[i3] = 0;
            i3++;
        }
    }

    void t(boolean z16, int i3) {
        if (z16) {
            if (this.f349562a0 == null) {
                QQProgressDialog qQProgressDialog = new QQProgressDialog(getContext(), BaseAIOUtils.f(50.0f, super.getResources()));
                this.f349562a0 = qQProgressDialog;
                qQProgressDialog.setCancelable(true);
            }
            QQProgressDialog qQProgressDialog2 = this.f349562a0;
            if (qQProgressDialog2 != null) {
                qQProgressDialog2.setMessage(i3);
                this.f349562a0.show();
                return;
            }
            return;
        }
        QQProgressDialog qQProgressDialog3 = this.f349562a0;
        if (qQProgressDialog3 == null || !qQProgressDialog3.isShowing()) {
            return;
        }
        this.f349562a0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int m() {
        int i3 = 0;
        int i16 = 0;
        while (true) {
            int[] iArr = this.K;
            if (i3 >= iArr.length) {
                return i16;
            }
            if (iArr[i3] == 1) {
                i16++;
                iArr[i3] = 0;
            }
            i3++;
        }
    }

    /* loaded from: classes34.dex */
    class b extends CallBacker {
        b() {
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.CallBacker
        public void callback(long j3, String str, String str2, String str3, int i3, int i16) {
            if (1000 == j3 && VasUpdateConstants.SCID_CHANGEVOICE.equals(str)) {
                if (QLog.isColorLevel() || i3 != 0) {
                    QLog.d("ListenChangeVoicePanel", 2, "changeVoice jsonLoaded callBacker, errorCode=" + i3);
                }
                if (i3 == 0) {
                    ListenChangeVoicePanel.this.p(true);
                }
                IVasQuickUpdateService iVasQuickUpdateService = (IVasQuickUpdateService) ((QQAppInterface) ListenChangeVoicePanel.this.f349564e.get()).getRuntimeService(IVasQuickUpdateService.class, "");
                if (iVasQuickUpdateService != null) {
                    iVasQuickUpdateService.removeCallBacker(ListenChangeVoicePanel.this.T);
                }
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        f349561f0 = i3 == 0;
        super.setVisibility(i3);
        if (!f349561f0 || this.f349564e.get() == null) {
            return;
        }
        ReportController.o(this.f349564e.get(), "CliOper", "", "", "changevoice", "0X8006F4F", 0, 0, "", "", "", "");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.app.VoiceChangeHandler.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i3, int i16, Object obj, boolean z16) {
        String qqStr;
        if (!z16) {
            if (QLog.isColorLevel()) {
                QLog.d("ListenChangeVoicePanel", 2, "VoiceChangeObserver type=" + i3 + ", ret=" + i16 + ", fromUiThread-f:" + z16);
            }
            Handler handler = this.P;
            handler.sendMessage(Message.obtain(handler, 107, i3, i16, obj));
            return;
        }
        t(false, 0);
        Bundle bundle = (Bundle) obj;
        this.U = false;
        int i17 = bundle.getInt("callId", 0);
        String string = bundle.getString("message");
        String string2 = bundle.getString(VipFunCallConstants.KEY_SV_URL);
        String string3 = bundle.getString(VipFunCallConstants.KEY_SV_ACTSTR);
        if (QLog.isColorLevel()) {
            QLog.d("ListenChangeVoicePanel", 2, "VoiceChangeObserver type=" + i3 + ", ret=" + i16 + ", fromUiThread:" + z16);
        }
        if (i16 == 0) {
            Handler handler2 = this.P;
            handler2.sendMessage(Message.obtain(handler2, 106, null));
            return;
        }
        int i18 = 4;
        if (i16 == 2002) {
            if (TextUtils.isEmpty(string)) {
                qqStr = HardCodeUtil.qqStr(R.string.noq);
                string = qqStr;
            }
            if (i16 != 0) {
            }
        } else {
            if (i16 != 3002) {
                if (i16 == 4002) {
                    if (TextUtils.isEmpty(string)) {
                        string = HardCodeUtil.qqStr(R.string.nps);
                    }
                    if (TextUtils.isEmpty(string3)) {
                        string3 = HardCodeUtil.qqStr(R.string.np_);
                    }
                    this.U = true;
                    i18 = 1;
                } else if (i16 == 5002) {
                    if (TextUtils.isEmpty(string)) {
                        string = HardCodeUtil.qqStr(R.string.npg);
                    }
                    if (TextUtils.isEmpty(string3)) {
                        string3 = HardCodeUtil.qqStr(R.string.f172136np2);
                    }
                    this.U = true;
                    i18 = 2;
                } else if (i16 == 6002) {
                    if (TextUtils.isEmpty(string)) {
                        string = HardCodeUtil.qqStr(R.string.npa);
                    }
                    this.U = true;
                } else if (i16 == 7002) {
                    if (TextUtils.isEmpty(string)) {
                        string = HardCodeUtil.qqStr(R.string.npr);
                    }
                    this.U = true;
                } else if (i16 == 8002) {
                    if (TextUtils.isEmpty(string)) {
                        string = HardCodeUtil.qqStr(R.string.np9);
                    }
                    this.U = true;
                } else if (i16 != 21001) {
                    if (i16 == 22001 && TextUtils.isEmpty(string)) {
                        qqStr = HardCodeUtil.qqStr(R.string.now);
                        string = qqStr;
                    }
                } else if (TextUtils.isEmpty(string)) {
                    qqStr = HardCodeUtil.qqStr(R.string.npm);
                    string = qqStr;
                }
                if (i16 != 0) {
                    QLog.d("ListenChangeVoicePanel", 1, "VoiceChangeObserver fail, ret=" + i16 + ", msg=" + string);
                    u(i18, i17, null, string, null, (TextUtils.isEmpty(string2) || !TextUtils.isEmpty(string3)) ? string3 : HardCodeUtil.qqStr(R.string.np7), string2);
                    if (!this.U || this.f349564e.get() == null) {
                        return;
                    }
                    ReportController.o(this.f349564e.get(), "CliOper", "", "", "changevoice", "0X8006F45", 0, 0, "" + this.f349563d, "", "", "");
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(string)) {
                qqStr = HardCodeUtil.qqStr(R.string.np6);
                string = qqStr;
            }
            if (i16 != 0) {
            }
        }
    }

    public ListenChangeVoicePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f349563d = -1;
        this.E = new ArrayList<>();
        this.F = new ArrayList<>();
        this.J = -1;
        this.K = new int[IVoiceTuneUtil.VOICE_TYPES.length];
        this.L = new AtomicInteger(0);
        this.P = new a(Looper.getMainLooper());
        this.S = new p(this);
        this.T = new b();
        this.W = "mvip.gxh.android.changevoice_";
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i3) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        Bundle bundle = this.V;
        if (bundle == null) {
            return;
        }
        int i16 = bundle.getInt("funcType", 4);
        String string = this.V.getString("url");
        int i17 = 0;
        int i18 = this.V.getInt("fcID", 0);
        if (QLog.isColorLevel()) {
            QLog.d("ListenChangeVoicePanel", 1, "DialogInterface funcType=" + i16 + ", url:" + string);
        }
        if (1 != i16 && 2 != i16) {
            if (i3 == 1 && !TextUtils.isEmpty(string)) {
                Intent intent = new Intent(getContext(), (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", string);
                intent.putExtra("isShowAd", false);
                getContext().startActivity(intent);
                i17 = 1;
            }
        } else if (i3 == 1 && this.f349564e.get() != null) {
            if (1 == i16) {
                VasH5PayUtil.openClubPay(getContext(), this.W + i18, 3, "1450000515", "LTMCLUB", super.getResources().getString(R.string.d2p), "voiceVip");
            } else {
                VasH5PayUtil.openClubPay(getContext(), this.W + i18, 3, "1450000516", "CJCLUBT", super.getResources().getString(R.string.f173184hu3), "voiceSvip");
            }
        }
        if (!this.U || this.f349564e.get() == null) {
            return;
        }
        ReportController.o(this.f349564e.get(), "CliOper", "", "", "changevoice", "0X8006F46", 0, 0, "" + i3, "", "", "");
        if (i3 == 1) {
            ReportController.o(this.f349564e.get(), "CliOper", "", "", "changevoice", "0X8006F46", 0, 0, "" + i17, "", "", "");
        }
    }
}
