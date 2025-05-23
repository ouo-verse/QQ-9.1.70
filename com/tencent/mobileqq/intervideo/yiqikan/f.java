package com.tencent.mobileqq.intervideo.yiqikan;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import javax.annotation.Nonnull;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static volatile String f238481a;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f238482d;

        a(Context context) {
            this.f238482d = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            com.tencent.mobileqq.qqfloatingwindow.b.b();
            ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).requestPermission(this.f238482d);
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Intent f238483d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f238484e;

        b(Intent intent, ActionSheet actionSheet) {
            this.f238483d = intent;
            this.f238484e = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent, (Object) actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 == 0 || i3 == 1) {
                ReportController.o(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_quit_opener", 0, 0, this.f238483d.getStringExtra("cur_uin"), i3 + "", "", "");
                g k3 = g.k();
                if (i3 != 0) {
                    i16 = 1;
                }
                k3.h(i16);
                this.f238484e.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c implements EIPCResultCallback {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCResult);
            } else if (QLog.isColorLevel()) {
                QLog.d("TogetherWatchFloatingUtil", 1, Integer.valueOf(eIPCResult.code));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class d implements EIPCResultCallback {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCResult);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TogetherWatchFloatingUtil", 2, "ACTION_QUIT_WATCH_FLOATING_WINDOWS result=", Integer.valueOf(eIPCResult.code));
            }
            int i3 = eIPCResult.code;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class e implements EIPCResultCallback {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCResult);
            } else if (QLog.isColorLevel()) {
                QLog.d("TogetherWatchFloatingUtil", 2, "ACTION_QUIT_WATCH_FLOATING_WINDOWS result=", Integer.valueOf(eIPCResult.code));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72608);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f238481a = null;
        }
    }

    public static void b(Context context, @Nonnull WatchTogetherFloatingData watchTogetherFloatingData) {
        if (BaseApplicationImpl.getApplication() != null && BaseApplicationImpl.getApplication().getQQProcessName() != null) {
            if (!BaseApplicationImpl.getApplication().getQQProcessName().endsWith(":tool")) {
                boolean h16 = h(2, watchTogetherFloatingData.getCurUin(), watchTogetherFloatingData.getCurType());
                boolean f16 = f();
                if (QLog.isColorLevel()) {
                    QLog.d("TogetherWatchFloatingUtil", 2, "closeFloatingWindow isSameFloatingInfo=", Boolean.valueOf(h16), "isFloatingInfoEmpty=", Boolean.valueOf(f16));
                }
                if (!h16 && !f16) {
                    return;
                }
                f238481a = "";
                Bundle bundle = new Bundle();
                bundle.putSerializable("BUNDLE_KEY_UI_DATA", watchTogetherFloatingData);
                QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "WatchTogetherClientIPCModule", "ACTION_QUIT_WATCH_FLOATING_WINDOWS", bundle, new d());
                return;
            }
            g.k().f(watchTogetherFloatingData.getCurUin(), watchTogetherFloatingData.getCurType(), true);
        }
    }

    public static void c() {
        f238481a = "";
        if (!BaseApplicationImpl.getApplication().getQQProcessName().endsWith(":tool")) {
            final Bundle bundle = new Bundle();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.intervideo.yiqikan.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.j(bundle);
                }
            }, 16, null, false);
        } else {
            g.k().g();
        }
    }

    public static Dialog d(Context context, Intent intent) {
        ActionSheet create = ActionSheet.create(context);
        create.addButton(R.string.g3l);
        create.addButton(R.string.vyz, 3);
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new b(intent, create));
        return create;
    }

    public static Dialog e(Context context) {
        if (context == null) {
            return null;
        }
        com.tencent.mobileqq.qqfloatingwindow.b.c();
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, (String) null, "\u4e00\u8d77\u770b\u5c06\u6536\u8d77\u4e3a\u5c0f\u7a97\u8fdb\u884c\u5c55\u793a\uff0c\u8bf7\u5f00\u542fQQ\u60ac\u6d6e\u7a97\u6743\u9650\u4ee5\u6b63\u5e38\u4f7f\u7528\u529f\u80fd\u3002", context.getString(R.string.cancel), context.getString(R.string.f171151ok), new a(context), (DialogInterface.OnClickListener) null);
        createCustomDialog.setCancelable(false);
        return createCustomDialog;
    }

    public static boolean f() {
        return TextUtils.isEmpty(f238481a);
    }

    public static boolean g() {
        if (f238481a == null) {
            return true;
        }
        return false;
    }

    public static boolean h(int i3, String str, int i16) {
        return TextUtils.equals(i3 + "_" + str + "_" + i16, f238481a);
    }

    public static boolean i(int i3, String str, int i16) {
        if (i3 != 2) {
            return false;
        }
        if (!QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool")) {
            f238481a = null;
            if (QLog.isColorLevel()) {
                QLog.d("TogetherWatchFloatingUtil", 2, "isWatchFloatingShow\uff0c tool process NOT EXIST");
            }
            return false;
        }
        int i17 = MobileQQ.sProcessId;
        if (1 != i17 && 7 != i17) {
            return false;
        }
        String str2 = i3 + "_" + str + "_" + i16;
        if (QLog.isColorLevel()) {
            QLog.d("TogetherWatchFloatingUtil", 2, "key=", str2, " info=", f238481a);
        }
        return TextUtils.equals(str2, f238481a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(Bundle bundle) {
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "WatchTogetherClientIPCModule", "ACTION_CLOSE_OR_QUIT_WATCH_FLOATING_WINDOWS", bundle, new e());
    }

    public static void k(boolean z16, String str, int i3, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d("TogetherWatchFloatingUtil", 2, "setIsWatchFloatingShow isShow=", Boolean.valueOf(z16), " uin=", str, " sessionType=", Integer.valueOf(i3));
        }
        if (!z16) {
            f238481a = "";
        } else {
            f238481a = "2_" + str + "_" + i3;
        }
        if (7 == MobileQQ.sProcessId) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("BUNDLE_SET_KEY_REFRESH_UI", z17);
            bundle.putBoolean("BUNDLE_SET_STATUS", z16);
            bundle.putString("BUNDLE_SET_KEY_UIN", str);
            bundle.putInt("BUNDLE_SET_KEY_SESSION_TYPE", i3);
            QIPCClientHelper.getInstance().callServer("TogetherBusinessIPCModule", "action_set_floating", bundle, new c());
        }
    }

    public static int l(Context context, @Nonnull WatchTogetherFloatingData watchTogetherFloatingData) {
        if (!BaseApplicationImpl.getApplication().getQQProcessName().endsWith(":tool")) {
            try {
                Intent intent = new Intent();
                intent.setAction("action_show_together_floating_windows");
                intent.setPackage(BaseApplication.getContext().getPackageName());
                intent.putExtra("com.tencent.mobileqq.webprocess.together.floating.data", watchTogetherFloatingData);
                intent.setComponent(new ComponentName(BaseApplication.getContext(), "com.tencent.mobileqq.webprocess.WebProcessReceiver"));
                BaseApplication.getContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
                if (QLog.isColorLevel()) {
                    QLog.d("TogetherWatchFloatingUtil", 2, "showFloatingWindow main..., data=", watchTogetherFloatingData.toString());
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("TogetherWatchFloatingUtil", 2, "showFloatingWindow fail...", e16);
                }
            }
            return 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TogetherWatchFloatingUtil", 2, "showFloatingWindow tool..., data=", watchTogetherFloatingData.toString());
        }
        if (g.k().r(context, watchTogetherFloatingData) == 0) {
            return 1;
        }
        return 2;
    }

    public static void m(Context context, int i3, String str) {
        Intent intent = new Intent(context, (Class<?>) TogetherTranslucentBrowserActivity.class);
        intent.putExtra(QQTranslucentBrowserActivity.FLAG_SHOW_LOADING_DIALOG, true);
        intent.putExtra("key_dialog_type", i3);
        intent.putExtra("cur_uin", str);
        intent.addFlags(805306368);
        context.startActivity(intent);
    }
}
