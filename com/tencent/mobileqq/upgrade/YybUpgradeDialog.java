package com.tencent.mobileqq.upgrade;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.assistant.sdk.remote.SDKConst;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dx;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.tmassistantbase.util.OuterCallLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes20.dex */
public class YybUpgradeDialog extends QQCustomDialog {
    static IPatchRedirector $redirector_;
    private static boolean T;
    private static int U;
    private static long V;
    protected final WeakReference<Activity> C;
    TextView D;
    TextView E;
    TextView F;
    TextView G;
    TextView H;
    TextView I;
    ProgressBar J;
    ImageView K;
    private boolean L;
    private DownloadListener M;
    private int N;
    private boolean P;
    protected View.OnClickListener Q;
    private boolean R;
    private volatile boolean S;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    protected class YYBDownloadListener implements DownloadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private long f306205a;

        /* renamed from: b, reason: collision with root package name */
        private long f306206b;

        protected YYBDownloadListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) YybUpgradeDialog.this);
            } else {
                this.f306205a = 0L;
                this.f306206b = 0L;
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void installSucceed(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
                return;
            }
            if (str.equals("1101070898") && str2.equals(SDKConst.SELF_PACKAGENAME)) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f306206b < 1000) {
                    return;
                }
                this.f306206b = currentTimeMillis;
                com.tencent.open.base.f.e("YybUpgradeDialog", np3.b.a(10010, YybUpgradeDialog.U, 3, 400));
                np3.a.g().j(22, np3.b.a(10010, YybUpgradeDialog.U, 3, 400));
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadCancel(DownloadInfo downloadInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) downloadInfo);
            } else {
                com.tencent.open.base.f.a("YybUpgradeDialog", "onDownloadCancel");
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadError(DownloadInfo downloadInfo, int i3, String str, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, downloadInfo, Integer.valueOf(i3), str, Integer.valueOf(i16));
                return;
            }
            if (downloadInfo != null && downloadInfo.f341184e.equals("1101070898")) {
                com.tencent.open.base.f.a("YybUpgradeDialog", "onDownloadError state = " + i16);
                if (downloadInfo.Q != 100 && downloadInfo.f() != 4) {
                    ThreadManager.getUIHandler().post(new Runnable(downloadInfo) { // from class: com.tencent.mobileqq.upgrade.YybUpgradeDialog.YYBDownloadListener.4
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ DownloadInfo f306214d;

                        {
                            this.f306214d = downloadInfo;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) YYBDownloadListener.this, (Object) downloadInfo);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                YybUpgradeDialog.this.x0(this.f306214d.f());
                            } else {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                } else {
                    onDownloadFinish(downloadInfo);
                }
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadFinish(DownloadInfo downloadInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) downloadInfo);
                return;
            }
            com.tencent.open.base.f.a("YybUpgradeDialog", "onDownloadFinish");
            if (downloadInfo != null && downloadInfo.f341184e.equals("1101070898")) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f306205a < 1000) {
                    return;
                }
                this.f306205a = currentTimeMillis;
                com.tencent.open.base.f.e("YybUpgradeDialog", np3.b.a(10010, YybUpgradeDialog.U, 3, 700));
                np3.a.g().j(20, np3.b.a(10010, YybUpgradeDialog.U, 3, 700));
                ThreadManager.getUIHandler().post(new Runnable(downloadInfo) { // from class: com.tencent.mobileqq.upgrade.YybUpgradeDialog.YYBDownloadListener.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ DownloadInfo f306210d;

                    {
                        this.f306210d = downloadInfo;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) YYBDownloadListener.this, (Object) downloadInfo);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            YybUpgradeDialog.this.y0(100, this.f306210d.f());
                        }
                    }
                });
                if (YybUpgradeDialog.this.R) {
                    YybUpgradeDialog.this.d0();
                    com.tencent.open.base.f.a("YybUpgradeDialog", HardCodeUtil.qqStr(R.string.or7));
                } else {
                    com.tencent.open.base.f.a("YybUpgradeDialog", HardCodeUtil.qqStr(R.string.ore));
                }
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadPause(DownloadInfo downloadInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadInfo);
                return;
            }
            if (downloadInfo != null && downloadInfo.f341184e.equals("1101070898")) {
                com.tencent.open.base.f.a("YybUpgradeDialog", "onDownloadPause");
                com.tencent.open.base.f.e("YybUpgradeDialog", np3.b.a(10010, YybUpgradeDialog.U, 3, 600));
                np3.a.g().j(19, np3.b.a(10010, YybUpgradeDialog.U, 3, 600));
                ThreadManager.getUIHandler().post(new Runnable(downloadInfo) { // from class: com.tencent.mobileqq.upgrade.YybUpgradeDialog.YYBDownloadListener.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ DownloadInfo f306208d;

                    {
                        this.f306208d = downloadInfo;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) YYBDownloadListener.this, (Object) downloadInfo);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            YybUpgradeDialog.this.y0(this.f306208d.Q, this.f306208d.f());
                        }
                    }
                });
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadUpdate(List<DownloadInfo> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
                return;
            }
            com.tencent.open.base.f.a("YybUpgradeDialog", "onDownloadUpdate");
            if (list != null) {
                for (DownloadInfo downloadInfo : list) {
                    if (downloadInfo.f341184e.equals("1101070898")) {
                        com.tencent.open.base.f.a("YybUpgradeDialog", "onDownloadUpdate STATE = " + downloadInfo.f());
                        ThreadManager.getUIHandler().post(new Runnable(downloadInfo) { // from class: com.tencent.mobileqq.upgrade.YybUpgradeDialog.YYBDownloadListener.3
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ DownloadInfo f306212d;

                            {
                                this.f306212d = downloadInfo;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) YYBDownloadListener.this, (Object) downloadInfo);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else {
                                    YybUpgradeDialog.this.y0(this.f306212d.Q, this.f306212d.f());
                                }
                            }
                        });
                    }
                }
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadWait(DownloadInfo downloadInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) downloadInfo);
            } else if (downloadInfo != null && downloadInfo.f341184e.equals("1101070898")) {
                com.tencent.open.base.f.a("YybUpgradeDialog", "onDownloadWait");
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void packageReplaced(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) str2);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void uninstallSucceed(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) str2);
            } else if (str.equals("1101070898") && str2.equals(SDKConst.SELF_PACKAGENAME)) {
                YybUpgradeDialog yybUpgradeDialog = YybUpgradeDialog.this;
                yybUpgradeDialog.M = new YYBDownloadListener();
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.upgrade.YybUpgradeDialog.YYBDownloadListener.5
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) YYBDownloadListener.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            YybUpgradeDialog.this.p0();
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements DialogInterface.OnKeyListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) YybUpgradeDialog.this);
            }
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, dialogInterface, Integer.valueOf(i3), keyEvent)).booleanValue();
            }
            if (i3 != 4) {
                return false;
            }
            YybUpgradeDialog.this.dismiss();
            YybUpgradeDialog.this.C.get().finish();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) YybUpgradeDialog.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                com.tencent.open.base.f.e("YybUpgradeDialog", np3.b.a(10010, YybUpgradeDialog.U, 2, 200));
                np3.a.g().j(17, np3.b.a(10010, YybUpgradeDialog.U, 4, 200));
                YybUpgradeDialog.this.dismiss();
                YybUpgradeDialog.this.C.get().finish();
                if (YybUpgradeDialog.U == 2) {
                    i3 = 1;
                }
                ReportController.o(null, "dc00898", "", "", "0X8008FFC", "0X8008FFC", i3, 0, "", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f306219d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f306220e;

        c(DialogInterface.OnClickListener onClickListener, boolean z16) {
            this.f306219d = onClickListener;
            this.f306220e = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, YybUpgradeDialog.this, onClickListener, Boolean.valueOf(z16));
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                com.tencent.open.base.f.e("YybUpgradeDialog", np3.b.a(10010, YybUpgradeDialog.U, 2, 200));
                np3.a.g().j(17, np3.b.a(10010, YybUpgradeDialog.U, 2, 200));
                if (YybUpgradeDialog.U == 2) {
                    ReportController.o(null, "dc00898", "", "", "0X8008F80", "0X8008F80", 0, 0, "", "", "", "");
                } else {
                    ReportController.o(null, "dc00898", "", "", "0X8008F83", "0X8008F83", 0, 0, "", "", "", "");
                }
                DialogInterface.OnClickListener onClickListener = this.f306219d;
                if (onClickListener != null) {
                    onClickListener.onClick(YybUpgradeDialog.this, 0);
                }
                if (this.f306220e) {
                    DownloadManager.C().j0(YybUpgradeDialog.this.M);
                    YybUpgradeDialog.this.dismiss();
                }
                YybUpgradeDialog.this.S = true;
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) YybUpgradeDialog.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                int i3 = YybUpgradeDialog.this.N;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            YybUpgradeDialog.this.f0();
                            com.tencent.open.base.f.a("YybUpgradeDialog", "onclick right btn  state = STATE_PAUSE");
                        } else if (i3 == 4) {
                            YybUpgradeDialog.this.d0();
                            com.tencent.open.base.f.a("YybUpgradeDialog", "onclick right btn  state = STATE_COMPLETE");
                        } else if (i3 != 10) {
                            if (i3 == 20) {
                                com.tencent.open.base.f.a("YybUpgradeDialog", "onclick right btn  state = STATE_WAIT");
                            }
                        } else {
                            com.tencent.open.base.f.a("YybUpgradeDialog", "onclick right btn  state = STATE_CANCEL");
                        }
                    } else {
                        YybUpgradeDialog.this.e0();
                        com.tencent.open.base.f.a("YybUpgradeDialog", "onclick right btn  state = STATE_DOWNLOADING");
                    }
                } else {
                    com.tencent.open.base.f.a("YybUpgradeDialog", "onclick right btn  state = STATE_INIT");
                    YybUpgradeDialog.this.k0();
                }
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77163);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            T = false;
            U = 3;
        }
    }

    public YybUpgradeDialog(Activity activity) {
        super(activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
            return;
        }
        this.L = false;
        this.N = 1;
        this.P = true;
        this.Q = new d();
        this.R = false;
        this.S = false;
        this.C = new WeakReference<>(activity);
        requestWindowFeature(1);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setAlpha(0);
        getWindow().setBackgroundDrawable(colorDrawable);
        setContentView(R.layout.f168338td);
        this.M = new YYBDownloadListener();
        this.P = com.tencent.open.downloadnew.d.y();
        DownloadManager.C();
        setOnKeyListener(new a());
        c0();
        com.tencent.open.base.f.e("YybUpgradeDialog", np3.b.a(10010, U, 1, 100));
        com.tencent.open.base.f.e("YybUpgradeDialog", np3.b.a(10010, U, 2, 100));
        com.tencent.open.base.f.e("YybUpgradeDialog", np3.b.a(10010, U, 3, 100));
        com.tencent.open.base.f.e("YybUpgradeDialog", np3.b.a(10010, U, 4, 100));
        np3.a.g().j(16, np3.b.a(10010, U, 1, 100));
        np3.a.g().j(16, np3.b.a(10010, U, 2, 100));
        np3.a.g().j(16, np3.b.a(10010, U, 3, 100));
        np3.a.g().j(16, np3.b.a(10010, U, 4, 100));
        if (U == 2) {
            ReportController.o(null, "dc00898", "", "", "0X8008F7F", "0X8008F7F", 0, 0, "", "", "", "");
        } else {
            ReportController.o(null, "dc00898", "", "", "0X8008F82", "0X8008F82", 0, 0, "", "", "", "");
        }
    }

    public static void c0() {
        boolean b16 = dx.b();
        T = b16;
        if (b16) {
            U = 2;
        } else {
            U = 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.upgrade.YybUpgradeDialog.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) YybUpgradeDialog.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    YybUpgradeDialog.this.p0();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
        z0();
        m0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0() {
        boolean y16 = com.tencent.open.downloadnew.d.y();
        this.P = y16;
        if (y16) {
            if (!com.tencent.open.base.a.j(this.C.get())) {
                ToastUtil.a().e(HardCodeUtil.qqStr(R.string.or9));
            } else {
                x0(2);
                DownloadManager.C().d0(DownloadManager.C().w("1101070898"));
            }
        }
    }

    public static String g0(float f16, boolean z16, int i3) {
        StringBuilder sb5 = new StringBuilder(i0((f16 / 1024.0f) / 1024.0f, i3));
        if (z16) {
            sb5.append("MB");
            return sb5.toString();
        }
        return sb5.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003a A[LOOP:0: B:12:0x0036->B:14:0x003a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004e A[LOOP:1: B:17:0x004c->B:18:0x004e, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String i0(double d16, int i3) {
        int i16;
        int i17;
        StringBuilder sb5 = new StringBuilder();
        if (i3 <= 0) {
            sb5.append((int) Math.round(d16));
            return sb5.toString();
        }
        if (i3 == 1) {
            int i18 = (int) d16;
            if (d16 >= i18 + 0.95d) {
                sb5.append(i18 + 1);
                sb5.append(".");
                double d17 = 1.0d;
                for (i17 = 0; i17 < i3; i17++) {
                    d17 *= 10.0d;
                }
                double abs = Math.abs(Math.round((d16 - ((int) d16)) * d17) / d17);
                for (i16 = 0; i16 < i3; i16++) {
                    abs *= 10.0d;
                    sb5.append(((int) abs) % 10);
                }
                return sb5.toString();
            }
        }
        sb5.append((int) d16);
        sb5.append(".");
        double d172 = 1.0d;
        while (i17 < i3) {
        }
        double abs2 = Math.abs(Math.round((d16 - ((int) d16)) * d172) / d172);
        while (i16 < i3) {
        }
        return sb5.toString();
    }

    public static boolean j0(Activity activity) {
        String str;
        if (System.currentTimeMillis() - V <= 1000) {
            return false;
        }
        V = System.currentTimeMillis();
        UpgradeDetailWrapper j3 = k.i().j();
        if (j3 != null && j3.f306170d != null && j3.f306173h != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("sdkShowNotification", 0);
            bundle.putBoolean("showNetworkDialog", false);
            bundle.putString("appName", j3.f306173h.f306176a);
            bundle.putString("url", j3.f306170d.strNewSoftwareURL);
            bundle.putString("via", "ANDROIDQQ.YYB.QQUPDATE");
            String valueOf = String.valueOf(j3.f306170d.iAppid);
            bundle.putString("appId", valueOf);
            bundle.putLong(OuterCallLog.OuterCall_DownloadApi_DoDownloadActionByMyApp, System.currentTimeMillis());
            bundle.putBoolean("autoInstall", true);
            int i3 = j3.f306173h.f306179d;
            if (i3 == 999) {
                i3 = 718;
            }
            bundle.putInt("versionCode", i3);
            bundle.putString("packageName", BaseApplicationImpl.getApplication().getPackageName());
            bundle.putInt("downloadType", 1);
            bundle.putBoolean(VirtualAppProxy.KEY_AUTO_DOWNLOAD, true);
            DownloadInfo w3 = DownloadManager.C().w(valueOf);
            if (w3 != null) {
                str = w3.L;
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                bundle.putInt(com.tencent.open.downloadnew.e.f341502k, 5);
                DownloadApi.f(bundle, "biz_src_jc_update", k.i().j().f306172f);
                return true;
            }
            if (!com.tencent.open.downloadnew.d.i() && !MyAppApi.z().S()) {
                UpgradeDetailActivity.Y2(activity, k.i().j(), false, true, true);
            } else {
                ThreadManagerV2.excute(new Runnable(activity, bundle) { // from class: com.tencent.mobileqq.upgrade.YybUpgradeDialog.7
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Activity f306202d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ Bundle f306203e;

                    {
                        this.f306202d = activity;
                        this.f306203e = bundle;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) bundle);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            MyAppApi.z().n0(this.f306202d, this.f306203e, true, true);
                        }
                    }
                }, 16, null, false);
            }
            return true;
        }
        ToastUtil.a().e(HardCodeUtil.qqStr(R.string.ord));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0() {
        com.tencent.open.base.f.e("YybUpgradeDialog", np3.b.a(10010, U, 3, 200));
        np3.a.g().j(17, np3.b.a(10010, U, 3, 200));
        if (U == 2) {
            ReportController.o(null, "dc00898", "", "", "0X8008F81", "0X8008F81", 0, 0, "", "", "", "");
        } else {
            ReportController.o(null, "dc00898", "", "", "0X8008F84", "0X8008F84", 0, 0, "", "", "", "");
        }
        MyAppApi.z();
        if (MyAppApi.G()) {
            j0(this.C.get());
            dismiss();
            this.C.get().finish();
            return;
        }
        this.L = true;
        this.R = true;
        DownloadInfo w3 = DownloadManager.C().w("1101070898");
        boolean y16 = com.tencent.open.downloadnew.d.y();
        this.P = y16;
        if (y16) {
            if (!com.tencent.open.base.a.j(this.C.get())) {
                ToastUtil.a().e(HardCodeUtil.qqStr(R.string.ora));
                this.L = false;
                this.R = false;
                return;
            }
            if (w3 != null && w3.f() != 4) {
                y0(w3.Q, w3.f());
            }
            if (w3 == null || w3.f() == 1 || w3.f() == 10 || w3.f() == 3 || w3.f() == 4) {
                com.tencent.open.base.f.e("YybUpgradeDialog", np3.b.a(10010, U, 3, 500));
                np3.a.g().j(18, np3.b.a(10010, U, 3, 500));
                MyAppApi.z().W(this.C.get(), "ANDROIDQQ.NEWYYB.QQUPDATE", true);
            }
        } else {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.upgrade.YybUpgradeDialog.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) YybUpgradeDialog.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    long j3 = 1500 / 10;
                    int i3 = 10;
                    while (i3 > 0) {
                        ThreadManager.getUIHandler().post(new Runnable((10 - i3) * 10) { // from class: com.tencent.mobileqq.upgrade.YybUpgradeDialog.6.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ int f306200d;

                            {
                                this.f306200d = r5;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this, r5);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                    YybUpgradeDialog.this.N = 2;
                                    YybUpgradeDialog.this.y0(this.f306200d, 2);
                                } else {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                }
                            }
                        });
                        i3--;
                        try {
                            TimeUnit.MILLISECONDS.sleep(j3);
                        } catch (InterruptedException e16) {
                            e16.printStackTrace();
                        }
                    }
                    if (!YybUpgradeDialog.this.S) {
                        YybUpgradeDialog.this.d0();
                    }
                }
            }, 5, null, false);
        }
        DownloadManager.C().Y(this.M);
    }

    private void l0() {
        UpgradeDetailWrapper j3 = k.i().j();
        if (j3 != null && j3.f306170d != null && j3.f306173h != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("sdkShowNotification", 0);
            bundle.putBoolean("showNetworkDialog", false);
            bundle.putString("appName", j3.f306173h.f306176a);
            bundle.putString("url", j3.f306170d.strNewSoftwareURL);
            bundle.putString("via", "ANDROIDQQ.YYB.QQUPDATE");
            bundle.putString("appId", String.valueOf(j3.f306170d.iAppid));
            bundle.putLong(OuterCallLog.OuterCall_DownloadApi_DoDownloadActionByMyApp, System.currentTimeMillis());
            bundle.putBoolean("autoInstall", true);
            int i3 = j3.f306173h.f306179d;
            if (i3 == 999) {
                i3 = 718;
            }
            bundle.putInt("versionCode", i3);
            bundle.putString("packageName", "com.tencent.mobileqq");
            bundle.putInt("downloadType", 1);
            bundle.putBoolean(VirtualAppProxy.KEY_AUTO_DOWNLOAD, true);
            ThreadManagerV2.excute(new Runnable(bundle) { // from class: com.tencent.mobileqq.upgrade.YybUpgradeDialog.8
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Bundle f306204d;

                {
                    this.f306204d = bundle;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) YybUpgradeDialog.this, (Object) bundle);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        MyAppApi.z().n0(YybUpgradeDialog.this.C.get(), this.f306204d, false, false);
                    }
                }
            }, 16, null, false);
            return;
        }
        ToastUtil.a().e(HardCodeUtil.qqStr(R.string.orb));
    }

    private void m0() {
        com.tencent.open.base.f.e("YybUpgradeDialog", np3.b.a(10010, U, 3, 300));
        np3.a.g().j(21, np3.b.a(10010, U, 3, 300));
        DownloadManager.C().I(DownloadManager.C().w("1101070898"));
    }

    public static void o0() {
        T = true;
        U = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0() {
        this.I.getPaint().setFakeBoldText(true);
        this.I.setText(HardCodeUtil.qqStr(R.string.orc));
        this.J.setProgress(0);
        this.L = true;
        this.N = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(int i3) {
        this.N = i3;
        this.I.getPaint().setFakeBoldText(false);
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 10) {
                            if (i3 != 20) {
                                return;
                            }
                        } else {
                            this.I.setText(HardCodeUtil.qqStr(R.string.orh));
                            return;
                        }
                    } else {
                        this.I.setText(HardCodeUtil.qqStr(R.string.oro));
                        return;
                    }
                } else {
                    this.I.setText(HardCodeUtil.qqStr(R.string.ork));
                    return;
                }
            } else {
                this.I.setText(HardCodeUtil.qqStr(R.string.or_));
                return;
            }
        }
        this.I.setText(HardCodeUtil.qqStr(R.string.orm));
    }

    private void z0() {
        UpgradeDetailWrapper.b bVar;
        UpgradeDetailWrapper j3 = k.i().j();
        if (j3 != null && j3.f306170d != null && (bVar = j3.f306173h) != null) {
            int i3 = bVar.f306179d;
            if (i3 == 999) {
                i3 = 718;
            }
            int i16 = 0;
            try {
                i16 = InstalledAppListMonitor.getPackageInfo(BaseActivity.sTopActivity.getPackageManager(), BaseActivity.sTopActivity.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException e16) {
                e16.printStackTrace();
            }
            String str = "tmast://appdetails?r=0.9138136501079244&pname=com.tencent.mobileqq&oplist=1%3B2&via=ANDROIDQQ.NEWYYB.QQUPDATE&appid=" + j3.f306170d.iAppid + "&versioncode=" + i3 + "&hostpname=" + BaseApplicationImpl.getApplication().getPackageName() + "&hostversioncode=" + i16 + "\"\n";
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            DownloadApi.p(bundle);
            DownloadApi.q(bundle);
            MyAppApi.z().K();
            l0();
            return;
        }
        ToastUtil.a().e(HardCodeUtil.qqStr(R.string.orj));
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        try {
            if (this.N != 2) {
                this.R = false;
                DownloadManager.C().j0(this.M);
                this.M = null;
            }
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    public void e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        boolean y16 = com.tencent.open.downloadnew.d.y();
        this.P = y16;
        if (y16) {
            if (!com.tencent.open.base.a.j(this.C.get())) {
                ToastUtil.a().e(HardCodeUtil.qqStr(R.string.orl));
            } else {
                x0(3);
                DownloadManager.C().Q("1101070898");
            }
        }
    }

    public void n0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        DownloadInfo w3 = DownloadManager.C().w("1101070898");
        if (w3 != null && w3.f() == 2) {
            DownloadManager.C().Q("1101070898");
        }
    }

    public YybUpgradeDialog q0(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (YybUpgradeDialog) iPatchRedirector.redirect((short) 7, (Object) this, (Object) charSequence);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.G.setText(charSequence);
        }
        return this;
    }

    public YybUpgradeDialog r0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (YybUpgradeDialog) iPatchRedirector.redirect((short) 6, (Object) this, j3);
        }
        String g06 = g0((float) j3, true, 2);
        if (!TextUtils.isEmpty(g06)) {
            this.E.setText(HardCodeUtil.qqStr(R.string.orf) + g06);
        }
        return this;
    }

    public YybUpgradeDialog s0(DialogInterface.OnClickListener onClickListener, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (YybUpgradeDialog) iPatchRedirector.redirect((short) 9, this, onClickListener, Boolean.valueOf(z16));
        }
        this.H.setVisibility(0);
        this.H.setOnClickListener(new c(onClickListener, z16));
        return this;
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog, android.app.Dialog
    public void setContentView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        super.setContentView(i3);
        this.D = (TextView) findViewById(R.id.dialogTitle);
        this.E = (TextView) findViewById(R.id.kfj);
        this.G = (TextView) findViewById(R.id.dialogText);
        this.F = (TextView) findViewById(R.id.kff);
        this.H = (TextView) findViewById(R.id.dialogLeftBtn);
        TextView textView = (TextView) findViewById(R.id.dialogRightBtn);
        this.I = textView;
        textView.setVisibility(0);
        this.I.getPaint().setFakeBoldText(true);
        this.I.setOnClickListener(this.Q);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.g1f);
        this.J = progressBar;
        progressBar.setProgress(0);
        ImageView imageView = (ImageView) findViewById(R.id.dgc);
        this.K = imageView;
        imageView.setOnClickListener(new b());
    }

    public YybUpgradeDialog u0(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (YybUpgradeDialog) iPatchRedirector.redirect((short) 8, (Object) this, (Object) charSequence);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.F.setText(charSequence);
        }
        SpannableString spannableString = new SpannableString("\u63a8\u8350\u4f7f\u7528\"\u7701\u6d41\u5347\u7ea7\",\u901a\u8fc7QQ\u5b98\u65b9\u4e0b\u8f7d\u5668\"\u5e94\u7528\u5b9d\"\u5347\u7ea7,\u8282\u7701\u6d41\u91cf\u901f\u5ea6\u66f4\u5feb");
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#0099EE")), 21, 24, 17);
        this.F.setText(spannableString);
        this.F.setVisibility(0);
        return this;
    }

    public YybUpgradeDialog w0(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (YybUpgradeDialog) iPatchRedirector.redirect((short) 5, (Object) this, (Object) charSequence);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.D.setText(charSequence);
            this.D.setVisibility(0);
        }
        return this;
    }

    public void y0(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        com.tencent.open.base.f.a("YybUpgradeDialog", "updateView--progress--" + i3 + " state = " + i16);
        this.N = i16;
        x0(i16);
        int i17 = 100;
        if (i16 == 4) {
            i3 = 100;
        }
        if (i3 < 0) {
            this.L = this.R;
            i17 = 0;
        } else if (i3 >= 100) {
            this.L = false;
        } else {
            i17 = i3;
        }
        this.J.setProgress(i17);
        if (this.L) {
            this.J.setVisibility(0);
        } else {
            this.J.setVisibility(4);
        }
    }
}
