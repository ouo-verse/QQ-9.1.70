package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ForwardAccountCheckFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;
    private QQCustomDialog C;
    private DialogInterface.OnClickListener D;
    private QQProgressDialog E;
    private String F;
    private Runnable G;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements QQProgressDialog.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardAccountCheckFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.QQProgressDialog.b
        public void onBackPressed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.d("ForwardCheckAccountFragment", 1, "onBackPressed");
            ForwardAccountCheckFragment.this.E.O(null);
            ForwardAccountCheckFragment.this.E.dismiss();
            if (ForwardAccountCheckFragment.this.getQBaseActivity() != null) {
                ForwardAccountCheckFragment.this.getQBaseActivity().doOnBackPressed();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f185401d;

        b(String str) {
            this.f185401d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardAccountCheckFragment.this, (Object) str);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ForwardAccountCheckFragment.this.uh(i3, bArr, this.f185401d);
            } else {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
            }
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardAccountCheckFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("param_original_source", ForwardAccountCheckFragment.this.F);
            intent.putExtra("is_change_account", true);
            intent.putExtra("param_from_forward_account", true);
            intent.addFlags(268435456);
            intent.addFlags(67108864);
            RouteUtils.startActivity(ForwardAccountCheckFragment.this.C.getContext(), intent, RouterConstants.UI_ROUTER_LOGIN);
            ForwardAccountCheckFragment.this.C.dismiss();
            if (ForwardAccountCheckFragment.this.getQBaseActivity() != null) {
                ForwardAccountCheckFragment.this.getQBaseActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardAccountCheckFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ForwardAccountCheckFragment.this.C.dismiss();
            if (ForwardAccountCheckFragment.this.getQBaseActivity() != null) {
                ForwardAccountCheckFragment.this.getQBaseActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardAccountCheckFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else if (ForwardAccountCheckFragment.this.getQBaseActivity() != null) {
                ForwardAccountCheckFragment.this.getQBaseActivity().finish();
            }
        }
    }

    public ForwardAccountCheckFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.G = new Runnable() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.ForwardAccountCheckFragment.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ForwardAccountCheckFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        ForwardAccountCheckFragment.this.xh();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uh(int i3, byte[] bArr, String str) {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            ThreadManager.getUIHandler().removeCallbacks(this.G);
            QQProgressDialog qQProgressDialog = this.E;
            if (qQProgressDialog != null) {
                qQProgressDialog.dismiss();
            }
            if (i3 == 0) {
                vh();
                return;
            } else {
                if (i3 == 25501) {
                    wh();
                    return;
                }
                QQToast.makeText(BaseApplication.getContext(), 1, "\u64cd\u4f5c\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
                qBaseActivity.finish();
                QLog.e("ForwardCheckAccountFragment", 1, "checkOpenIdAndScheme error:", Integer.valueOf(i3));
                return;
            }
        }
        QLog.e("ForwardCheckAccountFragment", 1, "activity is destroy");
    }

    private void vh() {
        if (QLog.isColorLevel()) {
            QLog.d("ForwardCheckAccountFragment", 2, "onCheckSuccess ");
        }
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            if (!TextUtils.isEmpty(this.F)) {
                bi.c((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), qBaseActivity, this.F.replaceFirst("mqqforward://forward", "mqqapi://forward")).b();
            }
            qBaseActivity.finish();
        }
    }

    private void wh() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            if (this.C == null) {
                this.C = DialogUtil.createCustomDialog(qBaseActivity, 230);
                this.D = new c();
                this.C.setMessage(getContext().getString(R.string.yjf));
                this.C.setPositiveButton(getContext().getString(R.string.cx9), this.D);
                this.C.setNegativeButton(getContext().getString(R.string.cancel), new d());
                this.C.setOnDismissListener(new e());
            }
            this.C.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xh() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            if (this.E == null) {
                QQProgressDialog qQProgressDialog = new QQProgressDialog(qBaseActivity, qBaseActivity.getTitleBarHeight());
                this.E = qQProgressDialog;
                qQProgressDialog.O(new a());
            }
            this.E.setMessage(HardCodeUtil.qqStr(R.string.f171618jt0));
            this.E.show();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        long longExtra = getActivity().getIntent().getLongExtra("appid", 0L);
        String stringExtra = getActivity().getIntent().getStringExtra("openid");
        this.F = getActivity().getIntent().getStringExtra("source");
        String stringExtra2 = getActivity().getIntent().getStringExtra("package_id");
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        ThreadManager.getUIHandler().postDelayed(this.G, 500L);
        qQAppInterface.getMsgHandler().N2(true, stringExtra, false, 0L, longExtra, 1, 3001, stringExtra2, true, com.tencent.mobileqq.forward.x.k(), this.F, new b(stringExtra2));
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onFinish();
        ThreadManager.getUIHandler().removeCallbacks(this.G);
        if (getQBaseActivity() != null) {
            getQBaseActivity().overridePendingTransition(0, 0);
        }
    }
}
