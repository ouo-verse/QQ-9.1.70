package com.tencent.mobileqq.msgbackup.fragment;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.controller.e;
import com.tencent.mobileqq.msgbackup.controller.i;
import com.tencent.mobileqq.msgbackup.data.h;
import com.tencent.mobileqq.msgbackup.data.j;
import com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.d;
import com.tencent.mobileqq.msgbackup.util.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsgBackupCompleteFragment extends QIphoneTitleBarFragment implements e, View.OnClickListener, com.tencent.mobileqq.widget.navbar.a, Handler.Callback {
    static IPatchRedirector $redirector_;
    private View C;
    private View D;
    private ImageView E;
    private TextView F;
    private TextView G;
    private Button H;
    private Button I;
    private TextView J;
    private ProgressBar K;
    private int L;
    private int M;
    private int N;
    private boolean P;
    private MqqHandler Q;
    private boolean R;
    private boolean S;
    private boolean T;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupCompleteFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MsgBackupCompleteFragment.this.Ih();
                if (MsgBackupCompleteFragment.this.L == 1) {
                    d.f("0X800A253", 5);
                    return;
                } else {
                    if (MsgBackupCompleteFragment.this.L == 4 && MsgBackupCompleteFragment.this.T) {
                        d.f("0X800A267", 2);
                        return;
                    }
                    return;
                }
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupCompleteFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    public MsgBackupCompleteFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.M = 0;
        this.N = 0;
        this.P = false;
        this.S = false;
        this.T = false;
    }

    public static void Ah(Context context, int i3, int i16) {
        uh(context, i3, i16, 0, false);
    }

    public static void Bh(Context context, int i3, int i16) {
        vh(context, i3, i16, 0, false, true, false);
    }

    public static void Ch(Context context, int i3, int i16) {
        f.D("MsgBackupCompleteFragment", "tranfer not auto completed! so display whether import page!", new Object[0]);
        uh(context, i3, i16, 1, false);
    }

    public static void Dh(Context context, int i3, int i16) {
        uh(context, i3, i16, 2, false);
    }

    public static void Eh(Context context, int i3, int i16, boolean z16) {
        uh(context, i3, i16, 3, z16);
    }

    public static void Fh(Context context, int i3, int i16) {
        vh(context, i3, i16, 3, false, true, MsgBackupManager.N);
    }

    public static void Gh(Context context, int i3, int i16) {
        f.D("MsgBackupCompleteFragment", "restore not auto completed! so display whether import page!", new Object[0]);
        uh(context, i3, i16, 4, false);
    }

    public static void Hh(Context context, int i3, int i16) {
        uh(context, i3, i16, 5, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ih() {
        if (getActivity() != null) {
            MsgBackupManager.x().I();
            if (getActivity() != null) {
                getActivity().setResult(1001);
                getActivity().finish();
            }
        }
    }

    private void Jh() {
        Bundle arguments = getArguments();
        this.L = arguments.getInt(MiniAppPlugin.ATTR_PAGE_TYPE, 0);
        this.R = arguments.getBoolean("auto_import_key", false);
        this.M = arguments.getInt("import_total_count", this.M);
        this.N = arguments.getInt("import_finish_count", this.N);
        d.b();
        d.f251402a.f251378h = this.N;
        QLog.d("MsgBackupCompleteFragment", 1, "handlerArg, page type = " + this.L + " ;import total count = " + this.M + "; finish count = " + this.N + "; skip count = " + MsgBackupManager.I);
        if (this.L == 0) {
            d.e("0X800A240");
        }
    }

    private void Kh(int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackupCompleteFragment", 2, "auto import ------> initImportPage!!! finishedCount = " + i3 + ", total" + i16 + ", mPageType = " + this.L);
        }
        if (!isDetached()) {
            Message obtainMessage = this.Q.obtainMessage(1);
            obtainMessage.arg1 = i3;
            obtainMessage.arg2 = i16;
            this.Q.sendMessage(obtainMessage);
        }
    }

    private void Lh() {
        this.I.setOnClickListener(this);
        this.J.setOnClickListener(this);
        this.H.setOnClickListener(this);
    }

    private void Mh() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        DialogUtil.createCenterTextDialog(getActivity(), 0, activity.getString(R.string.iko), activity.getString(R.string.ikn), activity.getString(R.string.ikx), activity.getString(R.string.ikm), new a(), new b()).show();
    }

    private void Oh() {
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackupCompleteFragment", 2, "startImport is called!");
        }
        com.tencent.mobileqq.msgbackup.util.e.f251413k = 0L;
        com.tencent.mobileqq.msgbackup.util.e.j(null, "total_daoru_cost");
        this.P = true;
        this.f211174vg.setRightButton(R.string.f170675y5);
        ConcurrentHashMap<String, h> concurrentHashMap = MsgBackupManager.x().f251039c;
        if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
            HashSet<j> hashSet = new HashSet<>();
            for (h hVar : concurrentHashMap.values()) {
                if (hVar.f251148g) {
                    j jVar = new j();
                    jVar.k(hVar.f251142a);
                    jVar.m(hVar.f251143b);
                    hashSet.add(jVar);
                }
            }
            if (hashSet.size() == 0) {
                f.B("MsgBackupCompleteFragment", "no session is completed!--------so jump completed page!", new Object[0]);
                int i3 = this.L;
                if (i3 == 1) {
                    QLog.d("MsgBackupCompleteFragment", 1, "startImport totalSessionCount is " + MsgBackupManager.K + ", finishSessionCount is " + this.N);
                    Dh(getActivity(), MsgBackupManager.K, this.N);
                    return;
                }
                if (i3 == 4) {
                    Hh(getActivity(), MsgBackupManager.K, this.N);
                    return;
                }
                return;
            }
            MsgBackupManager.x().f251039c.clear();
            i iVar = new i();
            iVar.f251074b = 2;
            iVar.f251073a = hashSet;
            iVar.f251078f = hashSet.size();
            MsgBackupManager.x().X(this);
            MsgBackupManager.x().R(iVar);
            return;
        }
        QQToast.makeText(getActivity(), "no session to import", 0).show();
    }

    private void Ph(int i3, int i16) {
        int i17;
        ProgressBar progressBar;
        if (getActivity() == null) {
            return;
        }
        if (i3 != i16) {
            i17 = i3 + 1;
        } else {
            i17 = i3;
        }
        this.f211174vg.setOnItemSelectListener(this);
        this.E.setImageResource(R.drawable.msg_back_up_pc_to_phone);
        this.F.setText(getString(R.string.ikr, Integer.valueOf(i17), Integer.valueOf(i16)));
        this.G.setText(R.string.ijo);
        ViewUtils.setVisible(this.H, 8);
        if (i16 > 0 && (progressBar = this.K) != null) {
            ViewUtils.setVisible(progressBar, 0);
            this.K.setProgress((i3 * 100) / i16);
        }
    }

    private void Qh(int i3, int i16) {
        int i17;
        ProgressBar progressBar;
        if (getActivity() == null) {
            return;
        }
        if (i3 != i16) {
            i17 = i3 + 1;
        } else {
            i17 = i3;
        }
        this.f211174vg.setOnItemSelectListener(this);
        this.E.setImageResource(R.drawable.msg_back_up_migrate_receive);
        this.F.setText(getString(R.string.ikr, Integer.valueOf(i17), Integer.valueOf(i16)));
        this.G.setText(R.string.ijo);
        ViewUtils.setVisible(this.H, 8);
        if (i16 > 0 && (progressBar = this.K) != null) {
            ViewUtils.setVisible(progressBar, 0);
            this.K.setProgress((i3 * 100) / i16);
        }
    }

    private void init() {
        ViewUtils.setVisible(this.C, 8);
        ViewUtils.setVisible(this.D, 0);
        ViewUtils.setVisible(this.H, 8);
        ViewUtils.setVisible(this.I, 0);
        if (!this.R) {
            this.E.setImageResource(R.drawable.msg_back_up_complete);
        }
        this.f211174vg.setTitle(getString(R.string.ijj));
        this.f211174vg.setLeftBackVisible(8);
        int i3 = this.L;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                this.f211174vg.setTitle(getString(R.string.iir));
                                ViewUtils.setVisible(this.I, 0);
                                ViewUtils.setVisible(this.H, 8);
                                int i16 = this.N;
                                int i17 = i16 - MsgBackupManager.I;
                                f.D("MsgBackupCompleteFragment", "TYPE_PC_IMPORT_COMPLETED ----> mImportFinishCount = %d, sSkipSessionCount = %d", Integer.valueOf(i16), Integer.valueOf(MsgBackupManager.I));
                                this.F.setText(R.string.ikk);
                                this.G.setText(getString(R.string.ilf, Integer.valueOf(i17), Integer.valueOf(this.M)));
                                d.e("0X800A286");
                                return;
                            }
                            return;
                        }
                        this.f211174vg.setTitle(getString(R.string.iir));
                        ViewUtils.setVisible(this.I, 8);
                        if (this.R) {
                            this.f211174vg.setRightViewTextVisible(8);
                            Kh(0, this.M);
                            Oh();
                            return;
                        }
                        this.H.setText(R.string.iks);
                        if (AppSetting.f99565y) {
                            this.H.setContentDescription(getString(R.string.iks));
                        }
                        ViewUtils.setVisible(this.H, 0);
                        this.f211174vg.setRightButton(R.string.f170675y5);
                        this.F.setText(R.string.ikw);
                        this.G.setText(getString(R.string.ijq, Integer.valueOf(this.N - MsgBackupManager.I), Integer.valueOf(this.M)));
                        this.f211174vg.setOnItemSelectListener(this);
                        return;
                    }
                    this.f211174vg.setTitle(getString(R.string.iiu));
                    ViewUtils.setVisible(this.I, 0);
                    ViewUtils.setVisible(this.H, 8);
                    ViewUtils.setVisible(this.J, 0);
                    this.F.setText(R.string.ikj);
                    this.G.setText(getString(R.string.ile, Integer.valueOf(this.N), Integer.valueOf(this.M)));
                    this.f211174vg.setOnItemSelectListener(this);
                    d.e("0X800A262");
                    return;
                }
                this.f211174vg.setTitle(getString(R.string.ijj));
                ViewUtils.setVisible(this.I, 0);
                ViewUtils.setVisible(this.H, 8);
                int i18 = this.N - MsgBackupManager.I;
                QLog.d("MsgBackupCompleteFragment", 1, "TYPE_PHONE_IMPORT_COMPLETE ----> mImportFinishCount = " + this.N + ", sSkipSessionCount = " + MsgBackupManager.I);
                this.F.setText(R.string.ikt);
                this.G.setText(getString(R.string.ika, Integer.valueOf(i18), Integer.valueOf(this.M)));
                d.e("0X800A24F");
                return;
            }
            this.f211174vg.setTitle(getString(R.string.ijj));
            ViewUtils.setVisible(this.I, 8);
            if (this.R) {
                Kh(0, this.M);
                Oh();
            } else {
                ViewUtils.setVisible(this.H, 0);
                this.f211174vg.setRightButton(R.string.f170675y5);
                this.F.setText(R.string.ikw);
                this.G.setText(getString(R.string.ijq, Integer.valueOf(this.N - MsgBackupManager.I), Integer.valueOf(this.M)));
                this.H.setText(R.string.iks);
                if (AppSetting.f99565y) {
                    this.H.setContentDescription(getString(R.string.iks));
                }
                d.e("0X800A24B");
            }
            this.f211174vg.setOnItemSelectListener(this);
            return;
        }
        ViewUtils.setVisible(this.I, 0);
        ViewUtils.setVisible(this.H, 8);
        this.f211174vg.setTitle(getString(R.string.ijj));
        this.F.setText(R.string.ikp);
        this.G.setText(getString(R.string.ikq, Integer.valueOf(this.N), Integer.valueOf(this.M)));
    }

    private void sh() {
        if (this.P) {
            int i3 = this.L;
            if (i3 == 1) {
                d.f("0X800A252", 5);
            } else if (i3 == 4 && this.T) {
                d.f("0X800A266", 2);
            }
            Mh();
            return;
        }
        Ih();
    }

    private void th(View view) {
        this.C = view.findViewById(R.id.lsf);
        this.D = view.findViewById(R.id.lsd);
        this.E = (ImageView) view.findViewById(R.id.lsc);
        this.F = (TextView) view.findViewById(R.id.lsb);
        this.G = (TextView) view.findViewById(R.id.lsk);
        this.H = (Button) view.findViewById(R.id.ls9);
        this.I = (Button) view.findViewById(R.id.lsj);
        this.J = (TextView) view.findViewById(R.id.mdx);
        this.K = (ProgressBar) view.findViewById(R.id.lz6);
    }

    private static void uh(Context context, int i3, int i16, int i17, boolean z16) {
        vh(context, i3, i16, i17, false, false, z16);
    }

    private static void vh(Context context, int i3, int i16, int i17, boolean z16, boolean z17, boolean z18) {
        f.D("MsgBackupCompleteFragment", "go is called! isfromMsgTab = %b, auto = %b", Boolean.valueOf(z17), Boolean.valueOf(z16));
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            Intent intent = new Intent();
            intent.putExtra("import_total_count", i3);
            intent.putExtra("import_finish_count", i16);
            intent.putExtra(MiniAppPlugin.ATTR_PAGE_TYPE, i17);
            intent.putExtra("auto_import_key", z16);
            intent.putExtra("is_from_pc_handle", z18);
            if (z17) {
                QPublicFragmentActivity.start(activity, intent, MsgBackupCompleteFragment.class);
            } else {
                QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) MsgBackupCompleteFragment.class, 1000);
            }
        }
    }

    public static void wh(Context context, int i3, int i16) {
        f.D("MsgBackupCompleteFragment", "tranfer auto completed! so auto import data!", new Object[0]);
        vh(context, i3, i16, 1, true, false, false);
    }

    public static void xh(Context context, int i3, int i16) {
        vh(context, i3, i16, 1, true, true, false);
    }

    public static void yh(Context context, int i3, int i16) {
        f.D("MsgBackupCompleteFragment", "restore auto completed! so auto import data!", new Object[0]);
        vh(context, i3, i16, 4, true, false, false);
    }

    public static void zh(Context context, int i3, int i16) {
        vh(context, i3, i16, 4, true, true, false);
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.e
    public void C8(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.e
    public void K8(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, j3);
        }
    }

    protected void Nh() {
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        AppRuntime appRuntime = getQBaseActivity().getAppRuntime();
        if (appRuntime instanceof BaseQQAppInterface) {
            BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) appRuntime;
            f.D("MsgBackupCompleteFragment", "fight notification start ..app.isBackground_Stop =%b.app,.isBackground_Pause = %b,.", Boolean.valueOf(baseQQAppInterface.isBackgroundStop), Boolean.valueOf(baseQQAppInterface.isBackgroundPause));
            if (baseQQAppInterface.isBackgroundPause || baseQQAppInterface.isBackgroundStop) {
                f.D("MsgBackupCompleteFragment", "fight notification start ....", new Object[0]);
                try {
                    BaseApplication context = BaseApplication.getContext();
                    String str = SplashActivity.TAG;
                    intent = new Intent(context, (Class<?>) SplashActivity.class);
                } catch (ClassNotFoundException e16) {
                    e16.printStackTrace();
                    intent = null;
                }
                if (intent != null) {
                    intent.putExtra(QQNotificationManager.PARAM_NOTIFYID, 524);
                    PendingIntent activity = PendingIntent.getActivity(BaseApplication.getContext(), 0, intent, MsgBackupBaseFragment.ph(baseQQAppInterface, 134217728));
                    NotificationCompat.Builder when = NotificationFactory.createNotificationCompatBuilder(QQNotificationManager.CHANNEL_ID_OTHER).setSmallIcon(R.drawable.b8f).setAutoCancel(true).setOngoing(true).setWhen(System.currentTimeMillis());
                    when.setContentText("QQ\u6b63\u5728\u8fdb\u884c\u804a\u5929\u8bb0\u5f55\u8fc1\u79fb\uff0c\u8bf7\u4fdd\u6301QQ\u5728\u524d\u53f0\u663e\u793a\u3002").setContentIntent(activity);
                    QQNotificationManager.getInstance().notify("MsgBackup", 524, when.build());
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.e
    public void cb(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 == 4) {
            sh();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.cbs;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 1) {
            int i3 = message.arg1;
            int i16 = message.arg2;
            if (i3 == i16) {
                com.tencent.mobileqq.msgbackup.util.e.j("total_daoru_cost", null);
                int i17 = this.L;
                if (i17 == 1) {
                    QLog.d("MsgBackupCompleteFragment", 1, "handleMessage totalSessionCount is " + i3 + ", finishSessionCount is " + i3);
                    Dh(getActivity(), i3, i3);
                    return false;
                }
                if (i17 == 4) {
                    Hh(getActivity(), i3, i3);
                    return false;
                }
                return false;
            }
            int i18 = this.L;
            if (i18 == 1) {
                Qh(i3, i16);
                return false;
            }
            if (i18 == 4) {
                Ph(i3, i16);
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.e
    public void hd(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            return;
        }
        super.initWindowStyleAndAnimation(activity);
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
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
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ls9) {
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackupCompleteFragment", 2, "completed page, click migrate button!");
                }
                Oh();
            } else if (id5 == R.id.lsj) {
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackupCompleteFragment", 2, "completed page, click sure btn!");
                }
                Ih();
            } else if (id5 == R.id.mdx) {
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackupCompleteFragment", 2, "completed page, click space clean btn!");
                }
                d.e("0X800A263");
                MsgBackupManager.x().I();
                ((IMsgBackupTempApi) QRoute.api(IMsgBackupTempApi.class)).openStorageScanView(getActivity(), getQBaseActivity().getAppRuntime());
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
        } else {
            super.onCreate(bundle);
            this.Q = new MqqHandler(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        super.onDestroyView();
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackupCompleteFragment", 2, "onDestroyView");
        }
        MsgBackupManager.x().X(null);
        f.D("MsgBackupCompleteFragment", "onDestroyView is from page = %d", Integer.valueOf(this.L));
        MsgBackupManager.x().I();
        MsgBackupManager.x().G();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onFinish();
        if (getActivity() != null) {
            getActivity().overridePendingTransition(0, R.anim.f154725iw);
        }
    }

    @Override // com.tencent.mobileqq.widget.navbar.a
    public void onItemSelect(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) view, i3);
        } else if (i3 == 2) {
            sh();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onPause();
            MsgBackupManager.x().O(getActivity());
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onResume();
            MsgBackupManager.x().D(getActivity());
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            Nh();
            super.onStop();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, (Object) bundle);
            return;
        }
        super.onViewCreated(view, bundle);
        Jh();
        th(view);
        init();
        Lh();
        MsgBackupTransportProcessor.u().O();
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.e
    public void qc(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.e
    public void qd(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackupCompleteFragment", 2, "importProgress!!! finishedCount = " + i3 + ", total" + i16 + ", mPageType = " + this.L);
        }
        if (!isDetached()) {
            Message obtainMessage = this.Q.obtainMessage(1);
            obtainMessage.arg1 = i3;
            obtainMessage.arg2 = i16;
            this.Q.sendMessage(obtainMessage);
        }
        if (this.L == 1 && !this.S) {
            if (!this.R) {
                i17 = 1;
            }
            d.f("0X800A24E", i17);
            this.S = true;
        }
    }
}
