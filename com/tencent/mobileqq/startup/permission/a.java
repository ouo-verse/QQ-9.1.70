package com.tencent.mobileqq.startup.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmethodmonitor.monitor.PrivacyProtectionManager;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.PermissionUtil;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements QQPermissionCallback, DialogInterface.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f289722f;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f289723h;

    /* renamed from: i, reason: collision with root package name */
    private static final String[] f289724i;

    /* renamed from: d, reason: collision with root package name */
    private AppActivity f289725d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.startup.permission.b f289726e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.startup.permission.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public class DialogInterfaceOnClickListenerC8613a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        DialogInterfaceOnClickListenerC8613a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            QLog.d("CheckPermission", 1, "PrivacyPolicyHelper User Allow is show & onClick which is" + i3);
            if (i3 == 1) {
                a.this.g();
                a.f289722f = false;
                a aVar = a.this;
                if (aVar.e(aVar.f289725d)) {
                    a.this.f289725d = null;
                    if (a.this.f289726e != null) {
                        a.this.f289726e.a();
                        return;
                    }
                    return;
                }
                return;
            }
            a.this.f289725d.superFinish();
            SystemMethodProxy.killProcess(Process.myPid());
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface b extends PermissionUtil.SDCardPermissionCallback {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46403);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f289722f = false;
        f289723h = false;
        f289724i = new String[]{HardCodeUtil.qqStr(R.string.f214875u3), "QQ\u4f7f\u7528\u7535\u8bdd\u6743\u9650\u786e\u5b9a\u672c\u673a\u53f7\u7801\u548c\u8bbe\u5907ID\uff0c\u4ee5\u4fdd\u8bc1\u8d26\u53f7\u767b\u5f55\u7684\u5b89\u5168\u6027\u3002QQ\u4e0d\u4f1a\u62e8\u6253\u5176\u4ed6\u53f7\u7801\u6216\u7ec8\u6b62\u901a\u8bdd\u3002\n\u8bf7\u5728\u8bbe\u7f6e\u4e2d\u5f00\u542f\u7535\u8bdd\u6743\u9650\uff0c\u4ee5\u6b63\u5e38\u4f7f\u7528QQ\u529f\u80fd\u3002"};
    }

    public a(com.tencent.mobileqq.startup.permission.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
        } else {
            this.f289726e = bVar;
        }
    }

    public static boolean f(Context context) {
        return PermissionUtil.isHasStoragePermission(context);
    }

    public static void h(Activity activity, b bVar) {
        PermissionUtil.requestStorePermission(activity, bVar);
    }

    @Override // mqq.app.QQPermissionCallback
    public void deny(int i3, String[] strArr, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), strArr, iArr);
            return;
        }
        QLog.d("CheckPermission", 1, "deny" + i3);
        String str = f289724i[i3 - 1];
        String qqStr = HardCodeUtil.qqStr(R.string.f214855u1);
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.f289725d, 230);
        createCustomDialog.setTitle(qqStr);
        createCustomDialog.setMessage(str);
        createCustomDialog.setNegativeButton(HardCodeUtil.qqStr(R.string.j6l), this);
        createCustomDialog.setPositiveButton(HardCodeUtil.qqStr(R.string.f214865u2), this);
        createCustomDialog.setOnDismissListener(null);
        createCustomDialog.show();
    }

    @TargetApi(23)
    public boolean e(AppActivity appActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appActivity)).booleanValue();
        }
        QLog.d("CheckPermission", 1, "enter CheckPermission");
        if (appActivity != null && this.f289725d != appActivity) {
            this.f289725d = appActivity;
        }
        AppActivity appActivity2 = this.f289725d;
        if (appActivity2 != null && !appActivity2.isFinishing()) {
            if (!PrivacyPolicyHelper.isUserAllow()) {
                DialogInterfaceOnClickListenerC8613a dialogInterfaceOnClickListenerC8613a = new DialogInterfaceOnClickListenerC8613a();
                PrivacyPolicyHelper.showPrivacyPolicyDlgForCP(this.f289725d, "", dialogInterfaceOnClickListenerC8613a, dialogInterfaceOnClickListenerC8613a).show();
                f289722f = true;
                QLog.d("CheckPermission", 1, "PrivacyPolicyHelper User Allow is show");
                return false;
            }
            if (!f289723h) {
                return true;
            }
            int length = PermissionUtil.PERMS.length;
            if (Build.VERSION.SDK_INT > 28) {
                length = 1;
            }
            for (int i3 = 0; i3 < length; i3++) {
                AppActivity appActivity3 = this.f289725d;
                String[] strArr = PermissionUtil.PERMS;
                if (appActivity3.checkSelfPermission(strArr[i3]) != 0) {
                    this.f289725d.requestPermissions(this, i3 + 1, strArr[i3]);
                    return false;
                }
            }
            return true;
        }
        QLog.d("CheckPermission", 1, "mAct is destoryed");
        return true;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            PrivacyProtectionManager.f(true);
            o.e(true);
        }
    }

    @Override // mqq.app.QQPermissionCallback
    public void grant(int i3, String[] strArr, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), strArr, iArr);
            return;
        }
        QLog.d("CheckPermission", 1, "grant" + i3);
        this.f289725d = null;
        com.tencent.mobileqq.startup.permission.b bVar = this.f289726e;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) dialogInterface, i3);
            return;
        }
        if (i3 == 1) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", this.f289725d.getPackageName(), null));
            this.f289725d.startActivity(intent);
        }
        this.f289725d.superFinish();
        SystemMethodProxy.killProcess(Process.myPid());
    }
}
