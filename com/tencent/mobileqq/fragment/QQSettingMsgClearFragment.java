package com.tencent.mobileqq.fragment;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.assistant.sdk.remote.SDKConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.lastclean.LastCleanMMKVHelper;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.DeepCleanConfigProcessor;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zootopia.api.IZootopiaSpaceApi;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.appstore.dl.DownloadProxy;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.util.BinderWarpper;
import com.tencent.util.VersionUtils;
import com.tencent.util.pm.PackageUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.text.DecimalFormat;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQSettingMsgClearFragment extends IphoneTitleBarFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    public static final String S;
    private static long T;
    private DownloadListener C;
    private QQAppInterface D;
    private BounceScrollView E;
    private FormSimpleItem F;
    private FormSimpleItem G;
    private View H;
    private TextView I;
    private ImageView J;
    private View K;
    private View L;
    private TextView M;
    private boolean N;
    private boolean P;
    private tb3.a Q;
    private long R;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements tb3.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMsgClearFragment.this);
            }
        }

        @Override // tb3.b
        public void a(@NonNull String str, @NonNull ZootopiaSource zootopiaSource) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) zootopiaSource);
                return;
            }
            QLog.d("QQSettingMsgClearFragment", 1, "onZootopiaTaskDelete id: " + str + ", source: " + zootopiaSource);
            QQAppInterface qQAppInterface = QQSettingMsgClearFragment.this.D;
            if (qQAppInterface == null) {
                return;
            }
            String currentAccountUin = qQAppInterface.getCurrentAccountUin();
            ZootopiaSource last = zootopiaSource.getLast();
            if (last != null && last.getMainSource() == Source.StorageScan) {
                LastCleanMMKVHelper.f183341a.f(currentAccountUin);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMsgClearFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                com.tencent.mobileqq.config.j.e(2);
                QQSettingMsgClearFragment.this.Mh();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMsgClearFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                com.tencent.mobileqq.config.j.e(1);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMsgClearFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            com.tencent.mobileqq.config.j.a(2);
            QQSettingMsgClearFragment.this.Rh();
            QQSettingMsgClearFragment.this.Bh();
            QQToast.makeText(QQSettingMsgClearFragment.this.getBaseActivity(), QQSettingMsgClearFragment.this.getString(R.string.ztd), 0).show(QQSettingMsgClearFragment.this.getBaseActivity().getTitleBarHeight());
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMsgClearFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                com.tencent.mobileqq.config.j.a(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class f implements DownloadListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMsgClearFragment.this);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void installSucceed(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                QQSettingMsgClearFragment.this.Ih(str, str2);
            } else {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadCancel(DownloadInfo downloadInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) downloadInfo);
            } else if (QLog.isColorLevel()) {
                QLog.w("QQSettingMsgClearFragment", 2, "qq onDownloadCancel info = " + downloadInfo);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadError(DownloadInfo downloadInfo, int i3, String str, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, downloadInfo, Integer.valueOf(i3), str, Integer.valueOf(i16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("QQSettingMsgClearFragment", 2, "qq onDownloadError errorCode = " + i3 + "errorMsg = " + str + ", state = " + i16 + ", info = " + downloadInfo);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadFinish(DownloadInfo downloadInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QQSettingMsgClearFragment.Hh(downloadInfo, "YYB");
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadInfo);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadPause(DownloadInfo downloadInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) downloadInfo);
            } else if (QLog.isColorLevel()) {
                QLog.e("QQSettingMsgClearFragment", 2, "qq onDownloadPause info = " + downloadInfo);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadUpdate(List<DownloadInfo> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
                return;
            }
            if (QLog.isColorLevel() && list != null && list.size() > 0) {
                for (DownloadInfo downloadInfo : list) {
                    QLog.w("QQSettingMsgClearFragment", 2, "qq onDownloadUpdate progress = " + downloadInfo.Q + ", url = " + downloadInfo.f341186f);
                }
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadWait(DownloadInfo downloadInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) downloadInfo);
            } else if (QLog.isColorLevel()) {
                QLog.e("QQSettingMsgClearFragment", 2, "qq onDownloadWait info = " + downloadInfo);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void packageReplaced(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) str2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("QQSettingMsgClearFragment", 2, "qq packageReplaced appid = " + str + ", packageName = " + str2);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void uninstallSucceed(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) str2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("QQSettingMsgClearFragment", 2, "qq uninstallSucceed appid = " + str + ", packageName = " + str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class g implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f211203d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQCustomDialog f211204e;

        g(DialogInterface.OnClickListener onClickListener, QQCustomDialog qQCustomDialog) {
            this.f211203d = onClickListener;
            this.f211204e = qQCustomDialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QQSettingMsgClearFragment.this, onClickListener, qQCustomDialog);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            DialogInterface.OnClickListener onClickListener = this.f211203d;
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i3);
            }
            QQCustomDialog qQCustomDialog = this.f211204e;
            if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
                this.f211204e.cancel();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72346);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            S = HardCodeUtil.qqStr(R.string.f172182pr);
        }
    }

    public QQSettingMsgClearFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.P = false;
        this.Q = null;
        this.R = 0L;
    }

    private void Ah() {
        if (this.C == null) {
            this.C = new f();
            DownloadManagerV2.V().t0(this.C);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bh() {
        Ah();
        Bundle bundle = new Bundle();
        bundle.putString(com.tencent.open.downloadnew.e.f341493b, "5848");
        bundle.putString(com.tencent.open.downloadnew.e.f341503l, S);
        bundle.putString(com.tencent.open.downloadnew.e.f341497f, SDKConst.SELF_PACKAGENAME);
        bundle.putString(com.tencent.open.downloadnew.e.f341501j, "https://a.app.qq.com/o/myapp-down?g_f=1118400");
        bundle.putInt(com.tencent.open.downloadnew.e.f341502k, 2);
        bundle.putBoolean(com.tencent.open.downloadnew.e.f341499h, true);
        DownloadProxy.k().g(getBaseActivity(), bundle, "biz_src_qq_setting_msg_clean", null, 0);
    }

    private void Dh() {
        if (this.L != null) {
            if (DeepCleanConfigProcessor.e()) {
                this.L.setVisibility(0);
                this.N = PackageUtil.isPackageInstalled(BaseApplication.getContext(), SDKConst.SELF_PACKAGENAME);
                this.M.setText(DeepCleanConfigProcessor.a(BaseApplication.getContext(), this.N));
                return;
            }
            this.L.setVisibility(8);
        }
    }

    public static boolean Eh() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - T <= 200) {
            if (QLog.isColorLevel()) {
                QLog.d("QQSettingMsgClearFragment", 2, "click too fast");
            }
            T = currentTimeMillis;
            return true;
        }
        T = currentTimeMillis;
        return false;
    }

    private boolean Fh() {
        return ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZplanAccessibleWithoutSetting(Constant.FROM_ID_START_ACTIVITY, this.D.getLongAccountUin());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Gh() {
        if (getBaseActivity() != null && !getBaseActivity().isDestroyed()) {
            Ph(false);
            QQToast.makeText(getBaseActivity(), 2, R.string.a3d, 0).show();
        } else {
            QLog.d("QQSettingMsgClearFragment", 1, "updateDelCacheSuccessUi but activity is destroyed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Hh(DownloadInfo downloadInfo, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("QQSettingMsgClearFragment", 2, str + " onDownloadFinish info = " + downloadInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ih(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.e("QQSettingMsgClearFragment", 2, "qq installSucceed appid = " + str + ", packageName = " + str2);
        }
        if (TextUtils.equals(str, "5848") && TextUtils.equals(str2, SDKConst.SELF_PACKAGENAME)) {
            if (QLog.isColorLevel()) {
                QLog.e("QQSettingMsgClearFragment", 2, "\u8fd9\u662f\u7edf\u4e00\u7684DownloadListener\uff0cinstallSucceed, appId:" + str + ",packName:" + str2);
            }
            DownloadManagerV2.V().D0(this.C);
            this.C = null;
        }
    }

    private void Jh() {
        if (this.Q != null) {
            return;
        }
        this.Q = new tb3.a() { // from class: com.tencent.mobileqq.fragment.QQSettingMsgClearFragment.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMsgClearFragment.this);
                }
            }

            @Override // tb3.a
            public void totalOccupiedSpaceUpdate(long j3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, j3);
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(j3) { // from class: com.tencent.mobileqq.fragment.QQSettingMsgClearFragment.1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ long f211192d;

                        {
                            this.f211192d = j3;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, AnonymousClass1.this, Long.valueOf(j3));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else if (this.f211192d <= 0) {
                                QQSettingMsgClearFragment.this.F.setRightText(QQSettingMsgClearFragment.this.getString(R.string.f1643025g));
                            } else {
                                QQSettingMsgClearFragment.this.F.setRightText(QQSettingMsgClearFragment.this.Ch(this.f211192d));
                            }
                        }
                    });
                }
            }
        };
        ((IZootopiaSpaceApi) QRoute.api(IZootopiaSpaceApi.class)).registerZootopiaSpaceOccupyListener(this.Q);
    }

    private void Kh() {
        ((IZootopiaSpaceApi) QRoute.api(IZootopiaSpaceApi.class)).setZootopiaTaskDeleteListener(new a());
    }

    private void Lh(String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog message = DialogUtil.createCustomDialog(getBaseActivity(), 230).setTitle((String) null).setMessage(str);
        message.setMessageTextSize(17.0f);
        message.setPositiveButton(str2, onClickListener);
        message.setNegativeButton(getString(R.string.cancel), new g(onClickListener2, message));
        try {
            message.show();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QQSettingMsgClearFragment", 2, "setTroopAdmins:", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mh() {
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse("tmast://spaceclean?via=ANDROIDQQ.YYB.AZQQAPK&targetTabType=1"));
        intent.setFlags(268435456);
        try {
            startActivity(intent);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void Nh() {
        if (this.Q == null) {
            return;
        }
        ((IZootopiaSpaceApi) QRoute.api(IZootopiaSpaceApi.class)).unRegisterZootopiaSpaceOccupyListener(this.Q);
        this.Q = null;
    }

    private void Oh() {
        ((IZootopiaSpaceApi) QRoute.api(IZootopiaSpaceApi.class)).setZootopiaTaskDeleteListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ph(boolean z16) {
        int i3;
        this.H.setEnabled(!z16);
        this.I.setEnabled(!z16);
        ImageView imageView = this.J;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        Object drawable = this.J.getDrawable();
        if (drawable instanceof Animatable) {
            if (z16) {
                ((Animatable) drawable).start();
            } else {
                ((Animatable) drawable).stop();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qh() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.fragment.l
            @Override // java.lang.Runnable
            public final void run() {
                QQSettingMsgClearFragment.this.Gh();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rh() {
        try {
            if (getBaseActivity() == null) {
                return;
            }
            ClipboardMonitor.setPrimaryClip((ClipboardManager) getBaseActivity().getApplicationContext().getSystemService("clipboard"), ClipData.newPlainText("Label", "tmast://spaceclean?via=ANDROIDQQ.NEWYYB.AZQQAPK&targetTabType=1&clipboard_start_time=" + System.currentTimeMillis()));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void initUI() {
        this.E = (BounceScrollView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.ii_);
        View findViewById = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.gsk);
        this.K = findViewById;
        findViewById.setOnClickListener(this);
        FormSimpleItem formSimpleItem = (FormSimpleItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f164961bf1);
        this.G = formSimpleItem;
        formSimpleItem.setOnClickListener(this);
        ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.meq).setOnClickListener(this);
        View findViewById2 = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f166012ye0);
        this.H = findViewById2;
        findViewById2.setOnClickListener(this);
        this.H.setContentDescription(getString(R.string.ajj));
        this.I = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f107286a0);
        this.J = (ImageView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.y1z);
        FormSimpleItem formSimpleItem2 = (FormSimpleItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f125897na);
        this.F = formSimpleItem2;
        formSimpleItem2.setRightText(getString(R.string.f1643125h));
        if (Fh()) {
            this.F.setOnClickListener(this);
        } else {
            this.G.setBgType(3);
            this.F.setVisibility(8);
        }
        Jh();
        Kh();
        View findViewById3 = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.ufv);
        this.L = findViewById3;
        findViewById3.setOnClickListener(this);
        this.M = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.ufw);
        Dh();
        if (VersionUtils.isGingerBread()) {
            this.E.setOverScrollMode(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void xh(QQSettingMsgClearFragment qQSettingMsgClearFragment) {
        qQSettingMsgClearFragment.Qh();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.lang.String] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00c1 -> B:12:0x00c2). Please report as a decompilation issue!!! */
    public String Ch(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, j3);
        }
        String str = "";
        try {
        } catch (Exception e16) {
            QLog.i("QQSettingMsgClearFragment", 2, "getFileSizeDesc " + j3, e16);
        }
        if (j3 < 1024) {
            j3 = j3 + "B";
        } else {
            DecimalFormat decimalFormat = new DecimalFormat("##0");
            double d16 = j3;
            if (d16 < 1048576.0d) {
                str = decimalFormat.format(d16 / 1024.0d) + "KB";
                if ("1024KB".equals(str)) {
                    j3 = "1MB";
                }
                j3 = str;
            } else if (d16 < 1.073741824E9d) {
                str = decimalFormat.format(d16 / 1048576.0d) + "MB";
                if ("1024MB".equals(str)) {
                    j3 = "1GB";
                }
                j3 = str;
            } else {
                j3 = decimalFormat.format(d16 / 1.073741824E9d) + "GB";
            }
        }
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        if (getBaseActivity().getAppRuntime() instanceof QQAppInterface) {
            QQAppInterface qQAppInterface = (QQAppInterface) getBaseActivity().getAppRuntime();
            this.D = qQAppInterface;
            if (qQAppInterface != null) {
                initUI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.cbx;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else if (view.getId() == R.id.f164961bf1) {
            ((IQQFileSelector) QRoute.api(IQQFileSelector.class)).openFileClear(getActivity(), 1);
            FileManagerReporter.addData("0x80087C4");
            ReportController.o(null, "dc00898", "", "", "0X800A0C2", "0X800A0C2", 0, 0, "", "", "", "");
            QQSettingMsgHistoryActivity.H2();
        } else if (view.getId() == R.id.meq) {
            Intent intent = new Intent(getBaseActivity(), (Class<?>) QQSettingMsgHistoryActivity.class);
            intent.putExtra("set_display_type", 1);
            getBaseActivity().startActivity(intent);
            ReportController.o(null, "CliOper", "", "", "0X800A2D1", "0X800A2D1", 0, 0, "", "", "", "");
        } else if (view.getId() == R.id.gsk) {
            if (!Eh()) {
                Intent intent2 = new Intent();
                AIOImageProviderService e36 = AIOImageProviderService.e3(this.D.getCurrentUin(), "", 0, null, false);
                Bundle bundle = new Bundle();
                bundle.putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(e36.asBinder()));
                bundle.putInt("jump", 1);
                intent2.putExtras(bundle);
                intent2.setFlags(805306368);
                ReportController.o(null, "dc00898", "", "", "0X800A0C1", "0X800A0C1", 0, 0, "", "", "", "");
                PublicFragmentActivity.b.f(this, intent2, PublicFragmentActivityForPeak.class, SessionClearFragment.class, 1);
                QQSettingMsgHistoryActivity.H2();
            }
        } else if (view.getId() == R.id.f166012ye0) {
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = currentTimeMillis - this.R;
            if (!getBaseActivity().isFinishing() && j3 >= 500) {
                this.R = currentTimeMillis;
                ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(getBaseActivity(), null);
                ActionSheet.OnButtonClickListener onButtonClickListener = new ActionSheet.OnButtonClickListener(actionSheet) { // from class: com.tencent.mobileqq.fragment.QQSettingMsgClearFragment.3
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ ActionSheet f211194d;

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.fragment.QQSettingMsgClearFragment$3$1, reason: invalid class name */
                    /* loaded from: classes12.dex */
                    class AnonymousClass1 implements Runnable {
                        static IPatchRedirector $redirector_;

                        AnonymousClass1() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                                QQAppInterface qQAppInterface = QQSettingMsgClearFragment.this.D;
                                final QQSettingMsgClearFragment qQSettingMsgClearFragment = QQSettingMsgClearFragment.this;
                                com.tencent.mobileqq.app.message.messageclean.q.a(qQAppInterface, qQSettingMsgClearFragment, new Runnable() { // from class: com.tencent.mobileqq.fragment.m
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        QQSettingMsgClearFragment.xh(QQSettingMsgClearFragment.this);
                                    }
                                });
                                return;
                            }
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                    }

                    {
                        this.f211194d = actionSheet;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMsgClearFragment.this, (Object) actionSheet);
                        }
                    }

                    @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                    public void onClick(View view2, int i3) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view2, i3);
                            return;
                        }
                        if (!QQSettingMsgClearFragment.this.getBaseActivity().isFinishing()) {
                            this.f211194d.cancel();
                            QQSettingMsgClearFragment.this.Ph(true);
                        }
                        ReportController.o(null, "dc00898", "", "", "0X800A0C5", "0X800A0C5", 0, 0, "", "", "", "");
                        com.tencent.mobileqq.app.message.messageclean.q.b(QQSettingMsgClearFragment.this.D, QQSettingMsgClearFragment.this);
                        ThreadManagerV2.excute(new AnonymousClass1(), 64, null, true);
                        LastCleanMMKVHelper.f183341a.f(QQSettingMsgClearFragment.this.D.getCurrentAccountUin());
                    }
                };
                actionSheet.addButton(R.string.aji, 3);
                actionSheet.addCancelButton(getString(R.string.cancel));
                actionSheet.setOnButtonClickListener(onButtonClickListener);
                actionSheet.setMainTitle(R.string.fs_);
                actionSheet.show();
            }
        } else if (view.getId() == R.id.ufv) {
            if (this.N) {
                com.tencent.mobileqq.config.j.f();
                Lh(getString(R.string.zrc), getString(R.string.zrd), new b(), new c());
            } else {
                com.tencent.mobileqq.config.j.b();
                Lh(getString(R.string.zr5), getString(R.string.zr6), new d(), new e());
            }
            com.tencent.mobileqq.config.j.c();
            this.P = true;
        } else if (view.getId() == R.id.f125897na) {
            ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).startDownloadManagerActivity(getActivity(), ZootopiaSource.INSTANCE.a(Source.StorageScan));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public View onCreateCenterView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        View onCreateCenterView = super.onCreateCenterView();
        setTitle(getBaseActivity().getString(R.string.f171522iz2));
        return onCreateCenterView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroy();
        QQSettingMsgHistoryActivity.H2();
        com.tencent.mobileqq.qrscan.utils.b.c(getBaseActivity());
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onDestroyView();
        if (this.C != null) {
            if (QLog.isColorLevel()) {
                QLog.e("QQSettingMsgClearFragment", 2, "\u624b\u52a8\u6ce8\u9500\u6ce8\u518c\u65f6\u4e8b\u4ef6mQQListener");
            }
            DownloadManagerV2.V().D0(this.C);
            this.C = null;
        }
        Nh();
        Oh();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onPause();
        if (this.P) {
            DeepCleanConfigProcessor.g();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onResume();
        this.N = PackageUtil.isPackageInstalled(BaseApplication.getContext(), SDKConst.SELF_PACKAGENAME);
        View view = this.L;
        if (view != null && view.getVisibility() == 0) {
            com.tencent.mobileqq.config.j.d();
        }
        ((IZootopiaSpaceApi) QRoute.api(IZootopiaSpaceApi.class)).calculateZootopiaSpaceOccupy();
    }
}
