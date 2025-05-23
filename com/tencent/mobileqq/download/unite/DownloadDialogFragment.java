package com.tencent.mobileqq.download.unite;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.download.unite.config.DownloadConfigProcessor;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.onlinestatus.bv;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.QQDeviceInfo;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DownloadDialogFragment extends PublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DownloadDialogFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                DownloadDialogFragment.this.sh(0);
                bv.a("0X800B53D");
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DownloadDialogFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                DownloadDialogFragment.this.sh(1);
                DownloadDialogFragment.rh(DownloadDialogFragment.this.getBaseActivity());
                bv.a("0X800B53C");
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DownloadDialogFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                DownloadDialogFragment.this.sh(2);
                bv.a("0X800B53E");
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d implements DialogInterface.OnCancelListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DownloadDialogFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                DownloadDialogFragment.this.sh(2);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            }
        }
    }

    public DownloadDialogFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void rh(Activity activity) {
        String n3 = AppSetting.n();
        String n16 = AppSetting.n();
        String valueOf = String.valueOf(Build.VERSION.SDK_INT);
        String valueOf2 = String.valueOf(NetworkUtil.getNetworkType(activity));
        String imei = QQDeviceInfo.getIMEI("0");
        String stringExtra = activity.getIntent().getStringExtra("big_brother_source_key");
        String stringExtra2 = activity.getIntent().getStringExtra("key_url");
        String stringExtra3 = activity.getIntent().getStringExtra("key_appid");
        String str = "source=" + stringExtra + JefsClass.INDEX_URL + StringUtil.substring(stringExtra2, 0, 50) + ",appid=" + stringExtra3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("clientInfo=");
        sb5.append(n3);
        sb5.append("&clientVersion=");
        sb5.append(n16);
        sb5.append("&osVersion=");
        sb5.append(valueOf);
        sb5.append("&os=");
        sb5.append("android");
        sb5.append("&netType=");
        sb5.append(valueOf2);
        sb5.append("&imei=");
        sb5.append(imei);
        sb5.append("&customInfo=");
        sb5.append(str);
        if (QLog.isColorLevel()) {
            QLog.d("[UniteDownload] DownloadDialogFragment", 1, "url argument: ", sb5.toString());
        }
        activity.startActivity(new Intent(activity, (Class<?>) QQBrowserActivity.class).putExtra("url", "https://support.qq.com/product/275620?" + sb5.toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sh(int i3) {
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return;
        }
        Handler b16 = com.tencent.mobileqq.download.unite.util.b.b();
        if (b16 != null) {
            Message obtainMessage = b16.obtainMessage(1);
            obtainMessage.obj = Long.valueOf(baseActivity.getIntent().getLongExtra("listener_flag", -1L));
            obtainMessage.arg1 = i3;
            b16.sendMessage(obtainMessage);
        }
        baseActivity.finish();
        if (i3 != 1) {
            baseActivity.overridePendingTransition(R.anim.f154451a0, R.anim.f154452a1);
        } else {
            baseActivity.overridePendingTransition(0, R.anim.activity_out);
        }
    }

    public static void th(DownloadInfo downloadInfo, long j3) {
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("listener_flag", j3);
        intent.setFlags(268435456);
        intent.putExtra("big_brother_source_key", downloadInfo.M);
        intent.putExtra("key_url", downloadInfo.f341186f);
        intent.putExtra("key_appid", downloadInfo.f341184e);
        PublicFragmentActivity.b.a(BaseApplicationImpl.sApplication, intent, PublicTransFragmentActivity.class, DownloadDialogFragment.class);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
        } else {
            super.initWindowStyleAndAnimation(activity);
            activity.getWindow().setSoftInputMode(3);
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            inflate = (View) iPatchRedirector.redirect((short) 6, this, layoutInflater, viewGroup, bundle);
        } else {
            super.onCreateView(layoutInflater, viewGroup, bundle);
            inflate = layoutInflater.inflate(R.layout.ffp, (ViewGroup) null);
            inflate.setAlpha(0.5f);
            getBaseActivity().overridePendingTransition(R.anim.f154451a0, R.anim.f154452a1);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onResume();
            showDialog();
        }
    }

    public void showDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        com.tencent.mobileqq.download.unite.config.a a16 = DownloadConfigProcessor.a();
        QQCustomDialog createVerticalThreeBtnDialog = DialogUtil.createVerticalThreeBtnDialog(getBaseActivity(), 0, a16.f203575c, a16.f203576d, a16.f203578f, a16.f203577e, a16.f203579g, new a(), new b(), new c());
        createVerticalThreeBtnDialog.setOnCancelListener(new d());
        try {
            createVerticalThreeBtnDialog.show();
        } catch (Throwable th5) {
            QLog.e("[UniteDownload] DownloadDialogFragment", 1, "show dialog error: ", th5);
        }
        bv.a("0X800B53B");
    }
}
