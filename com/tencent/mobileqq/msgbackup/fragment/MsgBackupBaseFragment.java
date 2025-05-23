package com.tencent.mobileqq.msgbackup.fragment;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.controller.e;
import com.tencent.mobileqq.msgbackup.data.d;
import com.tencent.mobileqq.msgbackup.data.g;
import com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QFormSimpleItem;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsgBackupBaseFragment extends QIphoneTitleBarFragment implements View.OnClickListener, e, Handler.Callback {
    static IPatchRedirector $redirector_;
    protected int C;
    protected LinearLayout D;
    protected LinearLayout E;
    protected LinearLayout F;
    protected LinearLayout G;
    protected QFormSimpleItem H;
    protected QFormSimpleItem I;
    protected Button J;
    protected ImageView K;
    protected TextView L;
    protected TextView M;
    protected ImageView N;
    protected ProgressBar P;
    protected LinearLayout Q;
    protected TextView R;
    protected ImageView S;
    protected TextView T;
    protected TextView U;
    protected Button V;
    protected MqqHandler W;
    protected MqqHandler X;
    protected int Y;
    protected ProgressBar Z;

    /* renamed from: a0, reason: collision with root package name */
    protected ProgressBar f251169a0;

    /* renamed from: b0, reason: collision with root package name */
    protected Runnable f251170b0;

    /* renamed from: c0, reason: collision with root package name */
    protected com.tencent.mobileqq.msgbackup.authentication.b f251171c0;

    /* renamed from: d0, reason: collision with root package name */
    protected Runnable f251172d0;

    /* renamed from: e0, reason: collision with root package name */
    protected long f251173e0;

    /* renamed from: f0, reason: collision with root package name */
    protected int f251174f0;

    /* renamed from: g0, reason: collision with root package name */
    protected int f251175g0;

    /* renamed from: h0, reason: collision with root package name */
    protected boolean f251176h0;

    /* renamed from: i0, reason: collision with root package name */
    protected boolean f251177i0;

    /* renamed from: j0, reason: collision with root package name */
    protected long f251178j0;

    /* renamed from: k0, reason: collision with root package name */
    protected boolean f251179k0;

    /* renamed from: l0, reason: collision with root package name */
    protected boolean f251180l0;

    /* renamed from: m0, reason: collision with root package name */
    protected Runnable f251181m0;

    /* renamed from: n0, reason: collision with root package name */
    public int f251182n0;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends com.tencent.mobileqq.msgbackup.authentication.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupBaseFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.msgbackup.authentication.b
        public void a(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "onConfirmQrResponse: " + obj + ", isSuccess: " + z16);
            }
            MsgBackupBaseFragment.this.yh(z16, obj);
            super.a(z16, obj);
        }

        @Override // com.tencent.mobileqq.msgbackup.authentication.b
        public void b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, z16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "onConfirmTokenResponse:  isSuccess: " + z16);
            }
            super.b(z16);
        }

        @Override // com.tencent.mobileqq.msgbackup.authentication.b
        public void c(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "onGetQrResponse: " + obj + ", isSuccess: " + z16);
            }
            if (z16 && (obj instanceof d)) {
                MsgBackupBaseFragment.this.Ah((d) obj);
            } else if (obj instanceof Integer) {
                MsgBackupBaseFragment.this.zh((Integer) obj);
            }
            super.c(z16, obj);
        }

        @Override // com.tencent.mobileqq.msgbackup.authentication.b
        public void d(boolean z16, g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), gVar);
                return;
            }
            if (z16) {
                MsgBackupBaseFragment.this.Bh(gVar);
            }
            super.d(z16, gVar);
        }

        @Override // com.tencent.mobileqq.msgbackup.authentication.b
        public void e(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, z16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "onRejectQRResponse:  isSuccess: " + z16);
            }
            super.e(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupBaseFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            MsgBackupBaseFragment msgBackupBaseFragment = MsgBackupBaseFragment.this;
            int i16 = msgBackupBaseFragment.Y;
            if (i16 == 2) {
                FragmentActivity activity = msgBackupBaseFragment.getActivity();
                MsgBackupBaseFragment msgBackupBaseFragment2 = MsgBackupBaseFragment.this;
                MsgBackupCompleteFragment.wh(activity, msgBackupBaseFragment2.f251174f0, msgBackupBaseFragment2.f251175g0);
            } else if (i16 == 3) {
                FragmentActivity activity2 = msgBackupBaseFragment.getActivity();
                MsgBackupBaseFragment msgBackupBaseFragment3 = MsgBackupBaseFragment.this;
                MsgBackupCompleteFragment.yh(activity2, msgBackupBaseFragment3.f251174f0, msgBackupBaseFragment3.f251175g0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupBaseFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (MsgBackupBaseFragment.this.getActivity() != null) {
                MsgBackupBaseFragment.this.getActivity().setResult(1001);
                MsgBackupBaseFragment.this.getActivity().finish();
            }
        }
    }

    public MsgBackupBaseFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.C = -1;
        this.f251170b0 = new Runnable() { // from class: com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgBackupBaseFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                int i3 = 1;
                if (NetworkUtil.getSystemNetwork(MsgBackupBaseFragment.this.getContext()) != 1) {
                    i3 = 0;
                }
                Message obtainMessage = MsgBackupBaseFragment.this.W.obtainMessage(10012);
                obtainMessage.arg1 = i3;
                MsgBackupBaseFragment.this.W.sendMessage(obtainMessage);
                MsgBackupBaseFragment.this.X.postDelayed(this, 800L);
            }
        };
        this.f251171c0 = new a();
        this.f251172d0 = new Runnable() { // from class: com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgBackupBaseFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    if (MsgBackupBaseFragment.this.th() < FaceConstant.HeadDownload.QQHEAD_SYSTEM_MIN_STORAGE_SIZE) {
                        MsgBackupBaseFragment.this.X.removeCallbacks(this);
                        MsgBackupBaseFragment.this.W.sendMessage(MsgBackupBaseFragment.this.W.obtainMessage(10010));
                        return;
                    }
                    MsgBackupBaseFragment.this.X.postDelayed(this, 15000L);
                }
            }
        };
        this.f251173e0 = 0L;
        this.f251174f0 = 0;
        this.f251175g0 = 0;
        this.f251176h0 = false;
        this.f251177i0 = false;
        this.f251178j0 = 0L;
        this.f251179k0 = false;
        this.f251180l0 = false;
        this.f251181m0 = new Runnable() { // from class: com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgBackupBaseFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (!MsgBackupTransportProcessor.u().J()) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    MsgBackupBaseFragment msgBackupBaseFragment = MsgBackupBaseFragment.this;
                    if (elapsedRealtime - msgBackupBaseFragment.f251178j0 > 30000) {
                        MsgBackupBaseFragment.this.W.sendMessage(msgBackupBaseFragment.W.obtainMessage(10009));
                        MsgBackupBaseFragment.this.X.removeCallbacks(this);
                        return;
                    }
                    msgBackupBaseFragment.X.postDelayed(this, 1000L);
                    return;
                }
                MsgBackupBaseFragment.this.X.removeCallbacks(this);
            }
        };
        this.f251182n0 = 2;
    }

    private void initUI() {
        this.H = (QFormSimpleItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.m5e);
        this.I = (QFormSimpleItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.m5d);
        this.D = (LinearLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.lsf);
        this.E = (LinearLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.m38);
        this.F = (LinearLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.lsd);
        this.G = (LinearLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.ls8);
        this.J = (Button) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.ls9);
        this.K = (ImageView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.lsc);
        this.L = (TextView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.lsb);
        this.M = (TextView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.lsk);
        this.N = (ImageView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.m39);
        this.P = (ProgressBar) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.efa);
        this.Q = (LinearLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.lx5);
        this.R = (TextView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f166396lx4);
        this.S = (ImageView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.lsh);
        this.T = (TextView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.lsg);
        this.U = (TextView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.lsi);
        this.V = (Button) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.lsj);
        this.Z = (ProgressBar) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.mbg);
        this.f251169a0 = (ProgressBar) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.m9n);
    }

    public static int ph(AppRuntime appRuntime, int i3) {
        try {
            if (((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("MOBILE_SERVICE_EXTEND_SET_MUTABLE_FLAG")) {
                return 67108864 | i3;
            }
        } catch (Exception e16) {
            QLog.e("MsgBackup.MsgBackupBaseFragment", 1, "addInMutableFlag", e16);
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ah(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bh(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) gVar);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.e
    public void C8(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, z16);
        } else if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "\u5bf9\u7aef\u9000\u51fa\u4e86\uff01------------->isExit!!!");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ch(TextView textView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) textView, (Object) str);
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (textView != null) {
                textView.setText(str);
                textView.setVisibility(0);
                return;
            }
            return;
        }
        this.W.post(new Runnable(textView, str) { // from class: com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment.7
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ TextView f251183d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f251184e;

            {
                this.f251183d = textView;
                this.f251184e = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, MsgBackupBaseFragment.this, textView, str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                TextView textView2 = this.f251183d;
                if (textView2 != null) {
                    textView2.setText(this.f251184e);
                    this.f251183d.setVisibility(0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dh() {
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
            return;
        }
        AppRuntime appRuntime = getQBaseActivity().getAppRuntime();
        if (appRuntime instanceof BaseQQAppInterface) {
            BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) appRuntime;
            f.D("MsgBackup.MsgBackupBaseFragment", "fight notification start ..app.isBackground_Stop =%b.app,.isBackground_Pause = %b,.", Boolean.valueOf(baseQQAppInterface.isBackgroundStop), Boolean.valueOf(baseQQAppInterface.isBackgroundPause));
            if (baseQQAppInterface.isBackgroundPause || baseQQAppInterface.isBackgroundStop) {
                f.D("MsgBackup.MsgBackupBaseFragment", "fight notification start ....", new Object[0]);
                try {
                    BaseApplication context = BaseApplication.getContext();
                    String str = SplashActivity.TAG;
                    intent = new Intent(context, (Class<?>) SplashActivity.class);
                } catch (ClassNotFoundException e16) {
                    e16.printStackTrace();
                    intent = null;
                }
                if (intent == null) {
                    return;
                }
                intent.putExtra(QQNotificationManager.PARAM_NOTIFYID, 524);
                PendingIntent activity = PendingIntent.getActivity(BaseApplication.getContext(), 0, intent, ph(baseQQAppInterface, 134217728));
                NotificationCompat.Builder when = NotificationFactory.createNotificationCompatBuilder(QQNotificationManager.CHANNEL_ID_OTHER).setSmallIcon(R.drawable.b8f).setAutoCancel(true).setOngoing(true).setWhen(System.currentTimeMillis());
                when.setContentText("QQ\u6b63\u5728\u8fdb\u884c\u804a\u5929\u8bb0\u5f55\u8fc1\u79fb\uff0c\u8bf7\u4fdd\u6301QQ\u5728\u524d\u53f0\u663e\u793a\u3002").setContentIntent(activity);
                QQNotificationManager.getInstance().notify("MsgBackup", 524, when.build());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Eh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            MsgBackupManager.x().z().n();
            MsgBackupTransportProcessor.u().O();
            DialogUtil.createCenterTextDialog(activity, 0, activity.getString(R.string.f170556ik1), activity.getString(R.string.f170555ik0), activity.getString(R.string.f170562il3), activity.getString(R.string.f170561il2), new b(), new c()).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Fh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.e
    public void K8(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, j3);
            return;
        }
        f.B("MsgBackup.MsgBackupBaseFragment", "speedState------> increment = " + j3, new Object[0]);
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.e
    public void cb(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "transportStart\uff01------------->isStart = " + z16);
        }
        this.W.sendMessage(this.W.obtainMessage(10011));
        com.tencent.mobileqq.msgbackup.util.e.f();
        com.tencent.mobileqq.msgbackup.util.e.j(null, "total_transport_cost");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        xh();
        initUI();
        rh();
        initListener();
        qh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.cbs;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, (Object) message)).booleanValue();
        }
        if (getActivity() == null) {
            f.D("MsgBackup.MsgBackupBaseFragment", "activity is null------------->", new Object[0]);
            return false;
        }
        switch (message.what) {
            case 10009:
                this.f251180l0 = true;
                Fh();
                break;
            case 10010:
                Eh();
                break;
            case 10011:
                ProgressBar progressBar = this.f251169a0;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                    break;
                }
                break;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.e
    public void hd(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        f.B("MsgBackup.MsgBackupBaseFragment", "isCompleted = %b, finishedSessions = %d, totalSession = %d", Boolean.valueOf(this.f251177i0), Integer.valueOf(i3), Integer.valueOf(i16));
        if (i3 == i16) {
            com.tencent.mobileqq.msgbackup.util.e.j("total_transport_cost", null);
            com.tencent.mobileqq.msgbackup.util.e.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (1000 == i3 && i16 == 1001) {
            if (getActivity() != null) {
                getActivity().setResult(1001);
            }
            onBackEvent();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        this.W = new MqqHandler(this);
        this.X = new MqqHandler(ThreadManagerV2.getSubThreadLooper());
        this.Y = com.tencent.mobileqq.msgbackup.authentication.a.d().b();
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "toPage = " + this.C + "; mBizType = " + this.Y);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        super.onDestroyView();
        this.W.removeCallbacksAndMessages(null);
        this.X.removeCallbacks(this.f251172d0);
        this.X.removeCallbacks(this.f251181m0);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
        } else {
            super.onStop();
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.e
    public void qc(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "netConnectionState!!! isConnected = " + z16);
        }
        this.f251179k0 = z16;
        if (!z16) {
            this.f251178j0 = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.e
    public void qd(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        wh();
        if (this.C != 4) {
            MsgBackupManager.O = false;
        }
        MsgBackupManager.C = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            MsgBackupManager.x().I();
            vh();
        }
    }

    protected long th() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, (Object) this)).longValue();
        }
        ActivityManager activityManager = (ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
        }
        return memoryInfo.availMem / 1024;
    }

    public void uh(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) activity);
            return;
        }
        Intent intent = new Intent();
        AppRuntime appRuntime = getQBaseActivity().getAppRuntime();
        if (appRuntime instanceof AppInterface) {
            ((IMsgBackupTempApi) QRoute.api(IMsgBackupTempApi.class)).gotoChatHistoryFragment(activity, intent);
            activity.setResult(1001);
            activity.finish();
            MsgBackupManager.x().I();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else if (MsgBackupTransportProcessor.u().x() == 2) {
            MsgBackupCompleteFragment.Ah(getActivity(), this.f251174f0, this.f251175g0);
        } else {
            MsgBackupCompleteFragment.Ch(getActivity(), this.f251174f0, this.f251175g0);
        }
    }

    protected void wh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        ProgressBar progressBar = this.Z;
        if (progressBar != null) {
            progressBar.setMax(100);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yh(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zh(Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) num);
        }
    }
}
