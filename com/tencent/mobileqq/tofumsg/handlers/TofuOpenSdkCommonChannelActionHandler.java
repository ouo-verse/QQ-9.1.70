package com.tencent.mobileqq.tofumsg.handlers;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.tofumsg.NewTofuManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.model.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONObject;
import zp3.c;
import zp3.d;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes18.dex */
public class TofuOpenSdkCommonChannelActionHandler implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private boolean f293250a;

    /* renamed from: b, reason: collision with root package name */
    private final Runnable f293251b;

    /* renamed from: c, reason: collision with root package name */
    private QQCustomDialog f293252c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f293253d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f293254e;

        a(d dVar, Activity activity) {
            this.f293253d = dVar;
            this.f293254e = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TofuOpenSdkCommonChannelActionHandler.this, dVar, activity);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (i3 == 1) {
                Intent intent = new Intent();
                this.f293253d.d(intent);
                intent.addFlags(268435456);
                intent.addFlags(67108864);
                RouteUtils.startActivity(this.f293254e, intent, RouterConstants.UI_ROUTER_LOGIN);
                Activity activity = this.f293254e;
                if (activity instanceof JumpActivity) {
                    activity.finish();
                    return;
                }
                return;
            }
            if (i3 == 0) {
                TofuOpenSdkCommonChannelActionHandler.this.f(this.f293253d, 1, "user cancel");
            }
        }
    }

    public TofuOpenSdkCommonChannelActionHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f293251b = new Runnable() { // from class: com.tencent.mobileqq.tofumsg.handlers.TofuOpenSdkCommonChannelActionHandler.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TofuOpenSdkCommonChannelActionHandler.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        TofuOpenSdkCommonChannelActionHandler.this.f293250a = true;
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            };
        }
    }

    private void e(String str, final d dVar) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.f293251b, 20000L);
        dVar.a(new d.b() { // from class: com.tencent.mobileqq.tofumsg.handlers.a
            @Override // zp3.d.b
            public final void a(int i3, byte[] bArr, Bundle bundle, AppInfo appInfo) {
                TofuOpenSdkCommonChannelActionHandler.this.h(dVar, i3, bArr, bundle, appInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(d dVar, int i3, String str) {
        if (dVar.getContext() instanceof JumpActivity) {
            ((JumpActivity) dVar.getContext()).finish();
        }
        dVar.c(Foreground.getTopActivity(), 0, str);
        this.f293252c = null;
    }

    private void g(d dVar, String str, String str2, AppRuntime appRuntime) {
        QLog.i("TofuOpenSdkCommonChannelActionHandler", 1, "invokeToOpenAIO directly; uid=" + str);
        String friendName = ((IFriendNameService) appRuntime.getRuntimeService(IFriendNameService.class, "")).getFriendName(str2);
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_tofu_initiative", true);
            bundle.putString("key_from", "24");
            ((IAIOStarterApi) QRoute.api(IAIOStarterApi.class)).navigateToAIO(dVar.getContext(), 1, str, friendName, Long.parseLong(str2), bundle);
            if (dVar.getContext() instanceof JumpActivity) {
                ((JumpActivity) dVar.getContext()).finish();
            }
        } catch (Exception e16) {
            QLog.e("TofuOpenSdkCommonChannelActionHandler", 1, "Exception: " + e16);
            f(dVar, MessageRecord.MSG_TYPE_GAME_SHARE, "open aio failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(d dVar, int i3, byte[] bArr, Bundle bundle, AppInfo appInfo) {
        QLog.e("TofuOpenSdkCommonChannelActionHandler", 1, "auth errorCode=" + i3 + ", Timeout=" + this.f293250a);
        if (this.f293250a) {
            f(dVar, MessageRecord.MSG_TYPE_GAME_SHARE, "errorCode = -3005");
        } else {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f293251b);
            i(dVar, i3, bArr);
        }
    }

    private void i(d dVar, int i3, byte[] bArr) {
        if (i3 == 0) {
            j(dVar, bArr);
            return;
        }
        if (i3 == 25501) {
            QLog.i("TofuOpenSdkCommonChannelActionHandler", 1, "onAuthBack not same user");
            if (l(dVar)) {
                return;
            }
        }
        f(dVar, i3, "errorCode = " + i3);
    }

    private void j(d dVar, byte[] bArr) {
        String k3 = k(dVar, bArr);
        if (TextUtils.isEmpty(k3)) {
            QLog.e("TofuOpenSdkCommonChannelActionHandler", 1, "openAIO:: uin empty, return");
            f(dVar, MessageRecord.MSG_TYPE_GAME_SHARE, "invalid data empty uin");
            return;
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(k3);
        if (TextUtils.isEmpty(uidFromUin)) {
            QLog.e("TofuOpenSdkCommonChannelActionHandler", 1, "openAIO:: uid empty, return");
            f(dVar, MessageRecord.MSG_TYPE_GAME_SHARE, "invalid data empty id");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("TofuOpenSdkCommonChannelActionHandler", 1, "openAIO:: appRuntime is not QQAppInterface, return");
            f(dVar, MessageRecord.MSG_TYPE_GAME_SHARE, "invalid appRuntime");
            return;
        }
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity instanceof FragmentActivity) {
            AIOContact a16 = com.tencent.qqnt.aio.utils.a.f352276a.a((FragmentActivity) topActivity);
            if (a16 != null && TextUtils.equals(uidFromUin, a16.j())) {
                QLog.i("TofuOpenSdkCommonChannelActionHandler", 1, "the AIO is already opened, uid=" + uidFromUin);
                Manager manager = peekAppRuntime.getManager(QQManagerFactory.NEW_TOFU_MANAGER);
                if (!(manager instanceof NewTofuManager)) {
                    QLog.e("TofuOpenSdkCommonChannelActionHandler", 1, "openAIO:: manager illegal, return");
                    f(dVar, MessageRecord.MSG_TYPE_GAME_SHARE, "invalid manager");
                    return;
                } else {
                    ((NewTofuManager) manager).G(k3);
                    if (dVar.getContext() instanceof JumpActivity) {
                        ((JumpActivity) dVar.getContext()).finish();
                        return;
                    }
                    return;
                }
            }
            g(dVar, uidFromUin, k3, peekAppRuntime);
            return;
        }
        g(dVar, uidFromUin, k3, peekAppRuntime);
    }

    private String k(d dVar, byte[] bArr) {
        try {
            return new JSONObject(dVar.b(bArr)).optString("uin");
        } catch (Exception e16) {
            QLog.e("TofuOpenSdkCommonChannelActionHandler", 1, "Exception: " + e16);
            return null;
        }
    }

    @Override // zp3.c
    public void a(@NonNull String str, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) dVar);
        } else if (dVar.getContext() == null) {
            QLog.d("TofuOpenSdkCommonChannelActionHandler", 1, "helper.getContext() == null");
            f(dVar, MessageRecord.MSG_TYPE_GAME_SHARE, "context is null");
        } else {
            e(str, dVar);
        }
    }

    protected boolean l(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) dVar)).booleanValue();
        }
        Context context = dVar.getContext();
        if (!(context instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) context;
        if (activity.isFinishing()) {
            return false;
        }
        QQCustomDialog qQCustomDialog = this.f293252c;
        if (qQCustomDialog != null && !qQCustomDialog.isShowing() && !activity.isFinishing()) {
            try {
                this.f293252c.show();
                return true;
            } catch (Exception e16) {
                QLog.e("TofuOpenSdkCommonChannelActionHandler", 1, "showAccountConfirm ", e16);
                return false;
            }
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230);
        this.f293252c = createCustomDialog;
        createCustomDialog.setMessage(R.string.d65);
        this.f293252c.setTitle(R.string.b1v);
        a aVar = new a(dVar, activity);
        this.f293252c.setNegativeButton(R.string.cancel, aVar);
        this.f293252c.setPositiveButton(R.string.d5b, aVar);
        if (!activity.isFinishing()) {
            try {
                this.f293252c.show();
                return true;
            } catch (Exception e17) {
                QLog.e("TofuOpenSdkCommonChannelActionHandler", 1, "showAccountConfirm ", e17);
            }
        }
        return false;
    }
}
